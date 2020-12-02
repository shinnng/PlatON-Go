package network.platon.contracts.evm.v0_5_17;

import com.alaya.abi.solidity.TypeReference;
import com.alaya.abi.solidity.datatypes.DynamicBytes;
import com.alaya.abi.solidity.datatypes.Function;
import com.alaya.abi.solidity.datatypes.Type;
import com.alaya.abi.solidity.datatypes.generated.Uint256;
import com.alaya.crypto.Credentials;
import com.alaya.protocol.Web3j;
import com.alaya.protocol.core.RemoteCall;
import com.alaya.protocol.core.methods.response.TransactionReceipt;
import com.alaya.tx.Contract;
import com.alaya.tx.TransactionManager;
import com.alaya.tx.gas.GasProvider;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the com.alaya.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.13.2.1.
 */
public class PlatonInner extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610370806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80636f10e28514610046578063eb51cc9114610060578063f40ae8d9146100dd575b600080fd5b61004e610190565b60408051918252519081900360200190f35b610068610196565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100a257818101518382015260200161008a565b50505050905090810190601f1680156100cf5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61018e600480360360408110156100f357600080fd5b81019060208101813564010000000081111561010e57600080fd5b82018360208201111561012057600080fd5b8035906020019184600183028401116401000000008311171561014257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550505090356001600160a01b0316915061022d9050565b005b60015481565b60008054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156102225780601f106101f757610100808354040283529160200191610222565b820191906000526020600020905b81548152906001019060200180831161020557829003601f168201915b505050505090505b90565b8151600080606081808560208901885af480610247578092505b506001829055604080513d808252601f19601f820116820160200190925290935083801561027c576020820181803883390190505b5090503d6000602083013e805161029a9060009060208401906102a3565b50505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106102e457805160ff1916838001178555610311565b82800160010185558215610311579182015b828111156103115782518255916020019190600101906102f6565b5061031d929150610321565b5090565b61022a91905b8082111561031d576000815560010161032756fea265627a7a72315820145b018e89f7d8491cfbfd9eaa5d40b36ae0f4e3bf412bffe419f5eee54cdb0164736f6c63430005110032";

    public static final String FUNC_ASSEMBLYCALLPPOS = "assemblyCallppos";

    public static final String FUNC_GETRETURNVALUE = "getReturnValue";

    public static final String FUNC_RES = "res";

    protected PlatonInner(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected PlatonInner(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public RemoteCall<TransactionReceipt> assemblyCallppos(byte[] data, String addr) {
        final Function function = new Function(
                FUNC_ASSEMBLYCALLPPOS,
                Arrays.<Type>asList(new DynamicBytes(data),
                        new com.alaya.abi.solidity.datatypes.Address(addr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> getReturnValue() {
        final Function function = new Function(FUNC_GETRETURNVALUE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> res() {
        final Function function = new Function(FUNC_RES,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<PlatonInner> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return deployRemoteCall(PlatonInner.class, web3j, credentials, contractGasProvider, BINARY,  "", chainId);
    }

    public static RemoteCall<PlatonInner> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return deployRemoteCall(PlatonInner.class, web3j, transactionManager, contractGasProvider, BINARY,  "", chainId);
    }

    public static PlatonInner load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new PlatonInner(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static PlatonInner load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new PlatonInner(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
