from functools import wraps

from alaya import Web3
from alaya.packages.platon_account.account import Account
from alaya.packages.platon_account.signers.local import LocalAccount
from alaya.packages.platon_keys.utils.address import TESTNETHRP
from alaya.utils.contracts import find_matching_fn_abi

from environment.node import Node
from tests.lib import Client


def deploy(web3: Web3, bytecode: str, abi: str, account: LocalAccount, **constructor_args):
    # account = Account.privateKeyToAccount(deployer)
    nonce = web3.eth.getTransactionCount(account.address)
    contract = web3.eth.contract(abi=abi, bytecode=bytecode)
    transaction = {
        'gas': 4012388,
        'gasPrice': 100000000,
        "chainId": 201018,
        "nonce": nonce,
    }
    print(f'#### constructor args: {constructor_args}')
    data = contract._encode_constructor_data(kwargs=constructor_args)
    transaction["data"] = data
    print(f'#### transaction: {transaction}')
    print(f'#### deployer: {account.address}')
    signed_tx = web3.eth.account.signTransaction(transaction, account.privateKey).rawTransaction
    tx_hex = web3.eth.sendRawTransaction(signed_tx)
    print('trans_hex is :{}'.format(tx_hex.hex()))
    receipt = web3.eth.waitForTransactionReceipt(tx_hex)
    print('contractAddress is :{}'.format(receipt['contractAddress']))
    address = receipt['contractAddress']
    return Contract(web3, bytecode, abi, address, account)


class Contract:

    def __init__(self, web3: Web3, bytecode: str, abi: str, address: str, account: LocalAccount = None, **init_args):
        self.web3 = web3
        self.bytecode = bytecode
        self.abi = abi
        self.address = address
        self.account = account
        # self.address = deploy(abi, bytecode, web3, private_key, **init_args)
        self.contract = web3.eth.contract(abi=abi, bytecode=bytecode)
        self.functions = self.contract.functions
        self.events = self.contract.events
        self.fallback = self.contract.fallback
        for func in self.contract.functions:
            # 通过方法名获取方法
            print(f'### func: {func}')
            warp_function = self.call_selector(getattr(self.contract.functions, func))
            setattr(self, func, warp_function)

        # self._set_functions(contract.functions)
        # self._setattr(contract.variables)
        # self._setattr(contract.events)

    def call_selector(self, func):
        @wraps(func)
        def call_selector(*args, **kwargs):
            print(f'### find func: {func.name}')
            function_abi = find_matching_fn_abi(self.abi, func.name)
            if function_abi['stateMutability'] == 'view':
                tx = {
                    'chainId': 201018,
                    'nonce': self.web3.eth.getTransactionCount('atp1zkrxx6rf358jcvr7nruhyvr9hxpwv9uncjmns0'),
                    'gas': 2000000,
                    'value': 0,
                    'gasPrice': 1000000000,
                    'to': self.address
                }
                txn = func(*args, **kwargs).buildTransaction(tx)
                self.web3.eth.call(txn)
            else:
                tx = {
                    'chainId': 201018,
                    'nonce': self.web3.eth.getTransactionCount('atp1zkrxx6rf358jcvr7nruhyvr9hxpwv9uncjmns0'),
                    'gas': 2000000,
                    'value': 0,
                    'gasPrice': 1000000000,
                    'to': self.address
                }
                txn = func(*args, **kwargs).buildTransaction(tx)
                signed_txn = self.web3.eth.account.signTransaction(txn, private_key=self.owner.privateKey.hex())
                print(f'### signed_txn: {signed_txn}')
                res = self.web3.eth.sendRawTransaction(signed_txn.rawTransaction).hex()
                print(f'### res: {res}')

        return call_selector()

    # def _set_attrs(self, attrs):
    #     for attr in attrs:
    #         setattr(self, attr.__name__, attr)
    #
    # def _set_functions(self, functions):
    #     pass

# if __name__ == "main":
#     bytecode = '60806040523480156200001157600080fd5b506040516200150c3803806200150c833981810160405260808110156200003757600080fd5b81019080805160405193929190846401000000008211156200005857600080fd5b9083019060208201858111156200006e57600080fd5b82516401000000008111828201881017156200008957600080fd5b82525081516020918201929091019080838360005b83811015620000b85781810151838201526020016200009e565b50505050905090810190601f168015620000e65780820380516001836020036101000a031916815260200191505b50604052602001805160405193929190846401000000008211156200010a57600080fd5b9083019060208201858111156200012057600080fd5b82516401000000008111828201881017156200013b57600080fd5b82525081516020918201929091019080838360005b838110156200016a57818101518382015260200162000150565b50505050905090810190601f168015620001985780820380516001836020036101000a031916815260200191505b50604090815260208281015192909101518651929450925085918591620001c591600391850190620002c9565b508051620001db906004906020840190620002c9565b50506005805460ff19166012179055506000620001f7620002af565b60058054610100600160a81b0319166101006001600160a01b03841690810291909117909155604051919250906000907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908290a3506200025882620002b3565b60008111620002a2576040805162461bcd60e51b815260206004820152601160248201527004343546f6b656e3a20636170206973203607c1b604482015290519081900360640190fd5b6006555062000365915050565b3390565b6005805460ff191660ff92909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200030c57805160ff19168380011785556200033c565b828001600101855582156200033c579182015b828111156200033c5782518255916020019190600101906200031f565b506200034a9291506200034e565b5090565b5b808211156200034a57600081556001016200034f565b61119780620003756000396000f3fe608060405234801561001057600080fd5b50600436106101165760003560e01c806370a08231116100a257806395d89b411161007157806395d89b4114610343578063a457c2d71461034b578063a9059cbb14610377578063dd62ed3e146103a3578063f2fde38b146103d157610116565b806370a08231146102c5578063715018a6146102eb57806379cc6790146102f35780638da5cb5b1461031f57610116565b8063313ce567116100e9578063313ce567146102285780633950935114610246578063449a52f81461027257806347786d371461029e578063554d578d146102bd57610116565b806306fdde031461011b578063095ea7b31461019857806318160ddd146101d857806323b872dd146101f2575b600080fd5b6101236103f7565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561015d578181015183820152602001610145565b50505050905090810190601f16801561018a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101c4600480360360408110156101ae57600080fd5b506001600160a01b03813516906020013561048d565b604080519115158252519081900360200190f35b6101e06104aa565b60408051918252519081900360200190f35b6101c46004803603606081101561020857600080fd5b506001600160a01b038135811691602081013590911690604001356104b0565b610230610537565b6040805160ff9092168252519081900360200190f35b6101c46004803603604081101561025c57600080fd5b506001600160a01b038135169060200135610540565b6101c46004803603604081101561028857600080fd5b506001600160a01b03813516906020013561058e565b6102bb600480360360208110156102b457600080fd5b5035610658565b005b6101e0610703565b6101e0600480360360208110156102db57600080fd5b50356001600160a01b0316610709565b6102bb610724565b6102bb6004803603604081101561030957600080fd5b506001600160a01b0381351690602001356107d1565b61032761083c565b604080516001600160a01b039092168252519081900360200190f35b610123610850565b6101c46004803603604081101561036157600080fd5b506001600160a01b0381351690602001356108b1565b6101c46004803603604081101561038d57600080fd5b506001600160a01b038135169060200135610919565b6101e0600480360360408110156103b957600080fd5b506001600160a01b038135811691602001351661092d565b6102bb600480360360208110156103e757600080fd5b50356001600160a01b0316610958565b60038054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156104835780601f1061045857610100808354040283529160200191610483565b820191906000526020600020905b81548152906001019060200180831161046657829003601f168201915b5050505050905090565b60006104a161049a610a61565b8484610a65565b50600192915050565b60025490565b60006104bd848484610b51565b61052d846104c9610a61565b6105288560405180606001604052806028815260200161108b602891396001600160a01b038a16600090815260016020526040812090610507610a61565b6001600160a01b031681526020810191909152604001600020549190610cac565b610a65565b5060019392505050565b60055460ff1690565b60006104a161054d610a61565b84610528856001600061055e610a61565b6001600160a01b03908116825260208083019390935260409182016000908120918c168152925290205490610d43565b6000610598610a61565b60055461010090046001600160a01b039081169116146105ed576040805162461bcd60e51b815260206004820181905260248201526000805160206110b3833981519152604482015290519081900360640190fd5b600654610602836105fc6104aa565b90610d43565b111561064e576040805162461bcd60e51b81526020600482015260166024820152754343546f6b656e3a206361702065786365656465642160501b604482015290519081900360640190fd5b6104a18383610da4565b610660610a61565b60055461010090046001600160a01b039081169116146106b5576040805162461bcd60e51b815260206004820181905260248201526000805160206110b3833981519152604482015290519081900360640190fd5b600081116106fe576040805162461bcd60e51b815260206004820152601160248201527004343546f6b656e3a20636170206973203607c1b604482015290519081900360640190fd5b600655565b60065490565b6001600160a01b031660009081526020819052604090205490565b61072c610a61565b60055461010090046001600160a01b03908116911614610781576040805162461bcd60e51b815260206004820181905260248201526000805160206110b3833981519152604482015290519081900360640190fd5b60055460405160009161010090046001600160a01b0316907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e0908390a360058054610100600160a81b0319169055565b6107d9610a61565b60055461010090046001600160a01b0390811691161461082e576040805162461bcd60e51b815260206004820181905260248201526000805160206110b3833981519152604482015290519081900360640190fd5b6108388282610e94565b5050565b60055461010090046001600160a01b031690565b60048054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156104835780601f1061045857610100808354040283529160200191610483565b60006104a16108be610a61565b846105288560405180606001604052806025815260200161113d60259139600160006108e8610a61565b6001600160a01b03908116825260208083019390935260409182016000908120918d16815292529020549190610cac565b60006104a1610926610a61565b8484610b51565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205490565b610960610a61565b60055461010090046001600160a01b039081169116146109b5576040805162461bcd60e51b815260206004820181905260248201526000805160206110b3833981519152604482015290519081900360640190fd5b6001600160a01b0381166109fa5760405162461bcd60e51b815260040180806020018281038252602681526020018061101d6026913960400191505060405180910390fd5b6005546040516001600160a01b0380841692610100900416907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a3600580546001600160a01b0390921661010002610100600160a81b0319909216919091179055565b3390565b6001600160a01b038316610aaa5760405162461bcd60e51b81526004018080602001828103825260248152602001806111196024913960400191505060405180910390fd5b6001600160a01b038216610aef5760405162461bcd60e51b81526004018080602001828103825260228152602001806110436022913960400191505060405180910390fd5b6001600160a01b03808416600081815260016020908152604080832094871680845294825291829020859055815185815291517f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b9259281900390910190a3505050565b6001600160a01b038316610b965760405162461bcd60e51b81526004018080602001828103825260258152602001806110f46025913960400191505060405180910390fd5b6001600160a01b038216610bdb5760405162461bcd60e51b8152600401808060200182810382526023815260200180610fd86023913960400191505060405180910390fd5b610be6838383610f90565b610c2381604051806060016040528060268152602001611065602691396001600160a01b0386166000908152602081905260409020549190610cac565b6001600160a01b038085166000908152602081905260408082209390935590841681522054610c529082610d43565b6001600160a01b038084166000818152602081815260409182902094909455805185815290519193928716927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef92918290030190a3505050565b60008184841115610d3b5760405162461bcd60e51b81526004018080602001828103825283818151815260200191508051906020019080838360005b83811015610d00578181015183820152602001610ce8565b50505050905090810190601f168015610d2d5780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b505050900390565b600082820183811015610d9d576040805162461bcd60e51b815260206004820152601b60248201527f536166654d6174683a206164646974696f6e206f766572666c6f770000000000604482015290519081900360640190fd5b9392505050565b6001600160a01b038216610dff576040805162461bcd60e51b815260206004820152601f60248201527f45524332303a206d696e7420746f20746865207a65726f206164647265737300604482015290519081900360640190fd5b610e0b60008383610f90565b600254610e189082610d43565b6002556001600160a01b038216600090815260208190526040902054610e3e9082610d43565b6001600160a01b0383166000818152602081815260408083209490945583518581529351929391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a35050565b6001600160a01b038216610ed95760405162461bcd60e51b81526004018080602001828103825260218152602001806110d36021913960400191505060405180910390fd5b610ee582600083610f90565b610f2281604051806060016040528060228152602001610ffb602291396001600160a01b0385166000908152602081905260409020549190610cac565b6001600160a01b038316600090815260208190526040902055600254610f489082610f95565b6002556040805182815290516000916001600160a01b038516917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9181900360200190a35050565b505050565b6000610d9d83836040518060400160405280601e81526020017f536166654d6174683a207375627472616374696f6e206f766572666c6f770000815250610cac56fe45524332303a207472616e7366657220746f20746865207a65726f206164647265737345524332303a206275726e20616d6f756e7420657863656564732062616c616e63654f776e61626c653a206e6577206f776e657220697320746865207a65726f206164647265737345524332303a20617070726f766520746f20746865207a65726f206164647265737345524332303a207472616e7366657220616d6f756e7420657863656564732062616c616e636545524332303a207472616e7366657220616d6f756e74206578636565647320616c6c6f77616e63654f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e657245524332303a206275726e2066726f6d20746865207a65726f206164647265737345524332303a207472616e736665722066726f6d20746865207a65726f206164647265737345524332303a20617070726f76652066726f6d20746865207a65726f206164647265737345524332303a2064656372656173656420616c6c6f77616e63652062656c6f77207a65726fa2646970667358221220df2ca9bd2a6ed5414cd93beefac87d4bc9bdeeb1fd44473018b741e169973ebc64736f6c634300060c0033'
#     abi = [{"inputs":[{"internalType":"string","name":"name","type":"string"},{"internalType":"string","name":"symbol","type":"string"},{"internalType":"uint8","name":"decimals","type":"uint8"},{"internalType":"uint256","name":"cap","type":"uint256"}],"stateMutability":"nonpayable","type":"constructor"},{"anonymous":false,"inputs":[{"indexed":true,"internalType":"address","name":"owner","type":"address"},{"indexed":true,"internalType":"address","name":"spender","type":"address"},{"indexed":false,"internalType":"uint256","name":"value","type":"uint256"}],"name":"Approval","type":"event"},{"anonymous":false,"inputs":[{"indexed":true,"internalType":"address","name":"previousOwner","type":"address"},{"indexed":true,"internalType":"address","name":"newOwner","type":"address"}],"name":"OwnershipTransferred","type":"event"},{"anonymous":false,"inputs":[{"indexed":true,"internalType":"address","name":"from","type":"address"},{"indexed":true,"internalType":"address","name":"to","type":"address"},{"indexed":false,"internalType":"uint256","name":"value","type":"uint256"}],"name":"Transfer","type":"event"},{"inputs":[{"internalType":"address","name":"owner","type":"address"},{"internalType":"address","name":"spender","type":"address"}],"name":"allowance","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"approve","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"address","name":"account","type":"address"}],"name":"balanceOf","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"account","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"burnFrom","outputs":[],"stateMutability":"nonpayable","type":"function"},{"inputs":[],"name":"decimals","outputs":[{"internalType":"uint8","name":"","type":"uint8"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"subtractedValue","type":"uint256"}],"name":"decreaseAllowance","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[],"name":"getCap","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"spender","type":"address"},{"internalType":"uint256","name":"addedValue","type":"uint256"}],"name":"increaseAllowance","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"address","name":"account","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"mintTo","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[],"name":"name","outputs":[{"internalType":"string","name":"","type":"string"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"owner","outputs":[{"internalType":"address","name":"","type":"address"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"renounceOwnership","outputs":[],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"uint256","name":"cap","type":"uint256"}],"name":"setCap","outputs":[],"stateMutability":"nonpayable","type":"function"},{"inputs":[],"name":"symbol","outputs":[{"internalType":"string","name":"","type":"string"}],"stateMutability":"view","type":"function"},{"inputs":[],"name":"totalSupply","outputs":[{"internalType":"uint256","name":"","type":"uint256"}],"stateMutability":"view","type":"function"},{"inputs":[{"internalType":"address","name":"recipient","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"transfer","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"address","name":"sender","type":"address"},{"internalType":"address","name":"recipient","type":"address"},{"internalType":"uint256","name":"amount","type":"uint256"}],"name":"transferFrom","outputs":[{"internalType":"bool","name":"","type":"bool"}],"stateMutability":"nonpayable","type":"function"},{"inputs":[{"internalType":"address","name":"newOwner","type":"address"}],"name":"transferOwnership","outputs":[],"stateMutability":"nonpayable","type":"function"}]
#     Defi = Contract(abi, bytecode, )
#     from_address = ''
#     to_address = ''
#     Defi.lockAsset(from_address, to_address, 10 * 10 ** 18)
#     assert Defi.amoute[''] = 10
