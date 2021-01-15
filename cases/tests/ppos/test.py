import os
import time
from random import randint, shuffle, uniform

from alaya import HTTPProvider, Web3, WebsocketProvider, Account
from alaya.admin import Admin
from alaya.eth import Eth
from alaya.middleware import geth_poa_middleware
from alaya.packages.platon_keys.utils.address import MIANNETHRP
from alaya.ppos import Ppos
from alaya.pip import Pip
from hexbytes import HexBytes
from alaya.packages.platon_account.account import Account
# from alaya.packages.platon_keys
# from conf.settings import TMP_ADDRES, ACCOUNT_FILE, BASE_DIR
from numpy.ma import arange

from common.load_file import LoadFile
from conf.settings import BASE_DIR

accounts = {}


def connect_web3(url, chain_id=201018):
    if "ws" in url:
        w3 = Web3(WebsocketProvider(url), chain_id=chain_id)
    else:
        w3 = Web3(HTTPProvider(url), chain_id=chain_id)
    w3.middleware_stack.inject(geth_poa_middleware, layer=0)
    return w3


def createRestrictingPlan(url, account, plan, pri_key):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.createRestrictingPlan(account, plan, pri_key)
    print(result)


def createstaking(url, typ, pri_key, amount, benifit_address=None, reward_per=1000):
    web3 = connect_web3(url)
    admin = Admin(web3)
    ppos = Ppos(web3)
    print("==== create staking =====")
    # w3 = Web3(HTTPProvider(node_url), chain_id=chain_id)
    program_version = admin.getProgramVersion()['Version']
    version_sign = admin.getProgramVersion()['Sign']
    bls_proof = admin.getSchnorrNIZKProve()
    bls_pubkey = admin.nodeInfo['blsPubKey']
    node_id = admin.nodeInfo['id']
    if benifit_address is None:
        benifit_address = Account.privateKeyToAccount(pri_key, MIANNETHRP).address
    result = ppos.createStaking(typ, benifit_address, node_id, 'external_id', 'node_name', 'website', 'details',
                                amount, program_version, version_sign, bls_pubkey, bls_proof, pri_key, reward_per)
    print(f"create staking result = {result}")


def increase_staking(url, type, node_id, amount, pri_key):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.increaseStaking(type, node_id, amount, pri_key)
    print(result)


def withdrewStaking(url, node_id, pri_key):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.withdrewStaking(node_id, pri_key)
    print(result)


def delegate(url, typ, node_id, amount, pri_key):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.delegate(typ, node_id, amount, pri_key)
    print("委托结果：", result)
    # return result


def withdraw_delegate(url, staking_blocknum, node_id, amount, pri_key):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    # ppos.need_analyze == False
    result = ppos.withdrewDelegate(staking_blocknum, node_id, amount, pri_key)
    print("赎回委托状态", result)


def withdraw_delegate_reward(url, pri_key):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.withdrawDelegateReward(pri_key)
    print(result)


def editCandidate(url, benifit_address, node_id, reward_per, pri_key):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    external_id = ''
    node_name = ''
    website = ''
    details = ''
    result = ppos.editCandidate(benifit_address, node_id, external_id, node_name, website, details, pri_key, reward_per,
                                transaction_cfg=None)
    print(result)


def sendTransaction(url, from_address, prikey, to_address, value, chain_id):
    web3 = connect_web3(url)
    platon = Eth(web3)
    nonce = platon.getTransactionCount(from_address)
    gasPrice = platon.gasPrice
    # gasPrice = 100000000
    transaction_dict = {
        "to": to_address,
        "gasPrice": gasPrice,
        "gas": 21000,
        "nonce": nonce,
        "data": '',
        "chainId": chain_id,
        "value": value,
    }

    signedTransactionDict = platon.account.signTransaction(
        transaction_dict, prikey
    )

    data = signedTransactionDict.rawTransaction
    result = HexBytes(platon.sendRawTransaction(data)).hex()
    # print(result)
    # log.debug("result:::::::{}".format(result))
    res = platon.waitForTransactionReceipt(result)
    print(res)


def get_candidatelist(url):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.getCandidateList()
    print(result)


def get_VerifierList(url):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.getVerifierList()
    print(result)


def getValidatorList(url):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.getValidatorList()
    print(result)


def get_candinfo(url, node_id):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.getCandidateInfo(node_id)
    print(result)


def get_RestrictingPlan(url, address):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.getRestrictingInfo(address)
    print(result)


def getDelegateReward(url, address):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.getDelegateReward(address)
    print(result)


def getDelegateInfo(url, staking_blocknum, del_address, node_id):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.getDelegateInfo(staking_blocknum, del_address, node_id)
    print(result)
    return result


def getRelatedListByDelAddr(url, del_address):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    result = ppos.getRelatedListByDelAddr(del_address)
    return result
    # print(result)


def getlistProposal(url):
    web3 = connect_web3(url)
    pip = Pip(web3)
    result = pip.listProposal()
    print(result)


def create_account(url, chain_id=201030):
    web3 = connect_web3(url)
    platon = Eth(web3)
    if chain_id == 201030:
        HRP = 'atx'
    else:
        HRP = 'atp'
    account = platon.account.create(net_type=HRP)
    address = account.address
    prikey = account.privateKey.hex()[2:]
    print(f"create account = {address}, {prikey}")
    return address, prikey


def get_nodeId_list(url):
    web3 = connect_web3(url)
    ppos = Ppos(web3)
    candidate_list = ppos.getCandidateList()['Ret']
    nodeid_list = []
    for candidate in candidate_list:
        nodeid = candidate['NodeId']
        if candidate['StakingAddress'] != 'atx1ur2hg0u9wt5qenmkcxlp7ysvaw6yupt4xerq62':
            nodeid_list.append(nodeid)
    return nodeid_list


if __name__ == '__main__':
    url = 'http://192.168.10.224:6790'
    # url = 'http://192.168.120.121:6790'
    # url = 'http://10.1.1.60:6789'
    # url = 'http://10.1.1.51:6789'
    # url = 'http://192.168.120.121:6789'
    # url = 'http:// 47.241.4.217:6789'
    # url = 'http://154.85.35.163:80'
    # url = 'http://154.85.34.8:6789'
    # url = 'http://192.168.21.186:6771'
    # url = 'https://openapi.alaya.network/rpc'
    account = 'atp1k0aumpg2r6cawq4uqejpfw6m3n5v877pl4vgkj'
    pri_key = '4fe61a44da26bf1a09771f6b26d22a40e03250dc1ef2141208611485f0ea79d1'
    account1 = 'atx1999r47ahhuc4xhjdhppvgkyw3z03gu765vtx2u'
    pri_key1 = 'f51ca759562e1daf9e5302d121f933a8152915d34fcbc27e542baf256b5e4b74'
    # from_address = 'atx1zkrxx6rf358jcvr7nruhyvr9hxpwv9unj58er9'
    # epoch1 = 10
    # epoch2 = 20
    # create_account(url)
    amount1 = Web3.toWei(833, 'ether')
    amount2 = Web3.toWei(837, 'ether')
    # list = ['atx1r8pvmt7hk6lk8uk7dtnfyrpcy9l8rfjry34uq9',
    #         'atx1nccsq48wery09qlma3rapree588cafwlpll8cr',
    #         'atx14w3m34dmx5xjr7wc5yhg6xtp59j3qy4m77t4vl',
    #         'atx10u83ynv0sdjrjg4na66pg3fqyx8uc89g7zvnyu',
    #         'atx13e2hlak7jytcdlv47vmqa2hkaeyv62ggv3hymk',
    #         'atx1z4e77tam2lv8vsrzkazz659avlvx3v8jyh0ywt',
    #         'atx1pvd37yxnmdtdujaf3dwc4xpcukdzsf5q2hyc9a',
    #         'atx17rf2ylcauvse5sxsvnn05c30zscey0zwzhs5wp',
    #         'atx1cux96yve5d335hqt3a7pdjygpj77pny3xqq7qu',
    #         'atx1s9qht6yzg6f53u26fe69vl4qrt6fs0sphth3ez',
    #         'atx1ckxg24sa4clv239y93talm79h7ac8r20t4dl8e',
    #         'atx19qtc92y2s9a6dyvuqxrqwpsaztz95mel4xuhkv']
    # ac = 'atx1r8pvmt7hk6lk8uk7dtnfyrpcy9l8rfjry34uq9'
    # privateKey = ['b1b59658038c80d8f6f2b1f3d968417e938af6f5ea3c29d01aee4a4fb7f1a26f',
    #               '798c9a1a06564f4d9533c3a1d6fb96348b62a92c049d16669b871896c3bcd873',
    #               'ae5acd5e594a459bbe3faadc00ac64be79aa93251f0bd0243f05628a14657a2e',
    #               '127e0451e60c9c1df551dc9050362ab9ab7deeafa160672857aaf00f2b8c0139',
    #               '5d6514d3878eb2b98ae77d7d4cb687e17411f338fac61a5c24fb0e25d3499b45',
    #               '7b4a75bd91933c30d15f5aab5ce79cd4f886373d307fa91619f1e145a5f5c622',
    #               '4298456cd70c306cb4827f57bb59ec311b22d4694e8b4793344fcd2a96bafa7a',
    #               '969502cd2da5aac9eab511c0f85fd544db48e4311f34a2037e8479b9b412f9c0',
    #               'd01ccb8952c0107a5c49396bb7915ca6dbc1ad913b5e36370f540b5938f238c3',
    #               '3832e25a1f6feb6eb5e8c26c66494c7c9467181a635b8fa38cc51dd040f40bae',
    #               '2f98ef83dffae0ee71b9b5d9ad70901a671b6d718e36e8cbab9b9de6d6d76ecd',
    #               '80d9a69bff3eb0131c6237365399666a09a6b2c77ac861b858cc7dbf16efbb54',
    #               'e4633d9261cf53f5320e5af29273ba3a3e990d042b0f9dae89169db9e66b5a56',
    #               '504523e07a4d5c6a2e44fa18df316bfedfe58dedfa5a29c20d7153e70fd99850',
    #               'fbef6de59dd738e192dee8efbd96dc8a8432447173bbb835ecca43b39efd4b28',
    #               '687e466709fff60a681d58a892532a4673baebcb10f59dc559328611cbb1e41f',
    #               'b452ac93e4a65114eae569607460ae7b53a9f64c45c9e675ce79d7022fb2197c',
    #               'a0e6c7d073c13df70f8b85a5b9f9bc137a3c75c489f03f1497cc34ae2947d97b',
    #               '9085ec2a136adb886990419794528945f1b750fb770bf07e5778a124c6058c83',
    #               '3c1d0950c6329ba7376a5e7d06713edd34012947aa95dd78c1954d56e5d5632e',
    #               '71108275ade39f514162869f52183b19ce7ba70c9ac8ddccc86113e871fd1c03',
    #               '3f2ed71cba9c15decf008819a3c4d93dd0dffbb7888acb22ea4a0ad4c7bf35e8',
    #               '3a3fbabfddf9934c6ca1395b486db656be9e3a7fc66f7340a6332209432c3575',
    #               '4fe61a44da26bf1a09771f6b26d22a40e03250dc1ef2141208611485f0ea79d1',
    #               '7cb35bcebe5900bcdc7ea7fd47486128f4b22b8ecd1595bb47e8f8866b190d17',
    #               'a4a026cb5c7d10c7ebef0069528e43358b63de2dd707715b566fd177429d66b2',
    #               'c8cfb8fbc397a11dc5b9c3ce61b9498166edd1051abb4c30f61fa948d1cbba0c']
    # list = ['atp1n2yckcf0lp8fd4x3u4gqndyf7at4j9auanjd9r', 'atp1sga8gepxjlznwy6z9emerja95cqh57zrrsxa4z']
    # plan = [{'Epoch': 32, 'Amount': Web3.toWei(1000, 'ether')}]
    # createRestrictingPlan(url, account, plan, pri_key)
    # delegate(url, 0, nodeid, amount, pri_key)
    # plan = [{'Epoch': 1, 'Amount': amount1},
    #         {'Epoch': 8, 'Amount': amount1},
    #         {'Epoch': 16, 'Amount': amount1},
    #         {'Epoch': 32, 'Amount': amount1},
    #         {'Epoch': 64, 'Amount': amount1},
    #         {'Epoch': 128, 'Amount': amount1},
    #         {'Epoch': 300, 'Amount': amount1},
    #         {'Epoch': 400, 'Amount': amount1},
    #         {'Epoch': 500, 'Amount': amount1},
    #         {'Epoch': 600, 'Amount': amount1},
    #         {'Epoch': 700, 'Amount': amount1},
    #         {'Epoch': 800, 'Amount': amount2}]
    plan = [{'Epoch': 32, 'Amount': Web3.toWei(1000, 'ether')}]
    # address = 'atp1xsp5qwy9hgj26yujead2jmjlknhp2s7cqyh37u'
    # address = 'atx1lmcpsdp8cw899lu3wzmr5hxxplze82s2y3k4h9'
    node_id = 'd3f54cf2fbcb06e372573079f432513f328dde846ceebcc8915ea1ea9abf91e4ffefe42dc42f411850c23e177e81271703bbc16add6754c7df1a9c6ac6cbe63f'
    # print(Web3.fromWei(1000000000000000000000, 'ether'))
    node_id1 = '09ac1c54b6d4e87465eba8c17b149fc2b0add867f69253230c7ce843970ddbed57d79dac993cf89ca597dfe6bc63935e7429947b71f575a0ad63551c10e4a2ac'
    # pri_key1 = 'd357920de1df4ecb00cbce60ded2d73f3f51fd1e9fb79b08f366e301e849bd9d'
    # for i in list:
    #     print(i)
    #     createRestrictingPlan(url, i, plan, pri_key)
    # time.sleep(2)
    # get_RestrictingPlan(url, account)
    # fff(url)
    # sendTransaction(url, account1, pri_key1, account, Web3.toWei(1, 'ether'), 201030)
    web3 = connect_web3(url)
    platon = Eth(web3)
    print(platon.blockNumber)
    # # # print(platon.gasPrice)
    # tmp_amount = 0
    # tmp_amount1 = 0
    # for i in range(13):
    #     number = 160 * (i + 1)
    #     amount = platon.getBalance(account, number)
    #     print(account, amount)
    #     if amount is not None:
    #         y = amount - tmp_amount1
    #         tmp_amount1 = amount
    #         print("账户余额差：", y)
    #     amount = platon.getBalance(web3.restrictingAddress, number)
    #     print(web3.restrictingAddress, amount)
    #     if amount is not None:
    #         x = amount - tmp_amount
    #         tmp_amount = amount
    #         print("锁仓合约余额差：", x)
    amount = platon.getBalance(account)
    print(account, amount)
    amount = platon.getBalance(web3.restrictingAddress)
    print(web3.restrictingAddress, amount)
    # amount = platon.getBalance(web3.stakingAddress)
    # print(amount)
    # print(Web3.fromWei(1000, 'ether'))
    # platon.gasPrice
    # withdrewStaking(url, node_id, pri_key)
    # stakingnum = 335
    # node_id = '8ec906e2fdb09c8a45dbc193afe36ae7542e6c8efc96f06c566bf504c7b509691ef119accb0f95d6c9e51e053bd15c6ac5a568bd6f708508100e58d4d7a9036b'
    # get_VerifierList(url)
    # get_candidatelist(url)
    # StakingBlockNum = 515
    # get_candidatelist(url)
    # addresss = 'lat13l39glde394a6kkrm5aenj4ty7m7565x8sgtrf'
    # print(Web3.fromWei(999999999999999936000, 'ether'))
    # fff()
    # get_listGovernParam(url)
    # getDelegateReward(url, account)
    # getValidatorList(url)
    # withdraw_delegate_reward(url, pri_key)
    # node_config = LoadFile(os.path.abspath(os.path.join(BASE_DIR, "deploy/node/node-32.yml"))).get_data()
    # noconsensus_node_config_list = node_config.get("noconsensus", [])
    # node_id_list = [i['id'] for i in noconsensus_node_config_list]
    # for i in node_id_list:
    #     print(i)
    # delegate(url, 0, i, amount, pri_key)
    #     time.sleep(1)
    # getValidatorList(url)
    # amount = Web3.toWei(8.773190798799, 'ether')
    # print(amount)
    # amount = 9167000000000000000000
    # delegate(url, 1, node_id, amount, pri_key)
    # for pri_key in privateKey:
    # withdraw_delegate(url, 71, node_id, amount, pri_key)
    # time.sleep(2)
    # increase_staking(url, 1, node_id1, amount, pri_key)
    # createRestrictingPlan(url, account, plan, pri_key1)
    # createstaking(url, 0, pri_key, Web3.toWei(10000, 'ether'), benifit_address='atx1l6tmfpjqfey373yrulxkr8egvgplgnx5g66s4u')
    # get_candinfo(url, node_id)
    # getDelegateInfo(url, 9, account, node_id)
    # getDelegateInfo(url, 64, account, '7038eb30c06683c97282d0d7acbf939c15bcfc390eb461983445c2d58328d88b85a3d4c79867c18a5ed9442a13062c4b5a9f9e03ea7026e000c9b13c2a1d3255')
    # getDelegateInfo(url, 562, account, '7c31d0e2f716324c9051c322be59dd86194f28ad7b71e3bc3837062708b7207e82bed0d6e24691b9107549787b541e3c917ec7503e0ba3addd1340075188bad6')
    # getDelegateInfo(url, 555, account, 'bc9dabae54a13202ec765c1537c57b9f6659161596eae7c0344a606e9396c63c96a2a76aadc320100e9a56c5acdb8faddfb61733bddeff7b9f261ac54a46d775')
    # getDelegateInfo(url, 548, account, 'd80caefe38ec4bfcb8bf99793f63da63662d0acf34c8adeb96ab89a3c6b96b4cf862d405febfa708d28f64895e755e1f60c2821124915f369746a78834a8b906')
    addresslist = ['atp1k0aumpg2r6cawq4uqejpfw6m3n5v877pl4vgkj',
                   'atp1des5cqfsrsd6nyyp6h6ekghv5xdw0crqrppl8u',
                   'atp1kqyfg9ju4fppl090xwf5nxjkg7zj7yc3r43r4x',
                   'atp1e7q4z8dkns6vpk8v27f2hghgz8mr242zcl5aze',
                   'atp1540hmathq6fm5ynm5f4fp4ny96nkrk6x75r9kl',
                   'atp1nufdg2rvche4upfan94kfwvn62mcr22h5sxef6',
                   'atp1zpunl3yfp42yazqmqvkna54nrjuu6khfnhhwg2']
    for i in addresslist:
        getDelegateReward(url, account)
        # 查询地址所有委托信息
        result = getRelatedListByDelAddr(url, account)
        # print(result)
        amount_add = 0
        for i in result['Ret']:
            resutl = getDelegateInfo(url, i['StakingBlockNum'], account, i['NodeId'])
            amount_add = amount_add + int(resutl['Ret']['RestrictingPlan'])
        print(amount_add)
        get_RestrictingPlan(url, account)
    # getlistProposal(url)
    # get_RestrictingPlan(url, 'atp1s668hqh6hsanndfjq4wrqn5c7cdtexdtap2gz4')
    # 循环委托节点
    # nodeid_list = get_nodeId_list(url)
    # for nodeid in nodeid_list:
    #     print(nodeid)
    #     amount_tmp = uniform(100, 1000)
    #     # amount_tmp = 500
    #     print(amount_tmp)
    #     delegate(url, 1, nodeid, Web3.toWei(amount_tmp, 'ether'), pri_key)
        # time.sleep(1)
    # delegate(url, 1, nodeid_list[4], Web3.toWei(1000, 'ether'), pri_key)
