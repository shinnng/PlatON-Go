package network.platon.contracts.evm.v0_7_1;

import com.platon.abi.solidity.TypeReference;
import com.platon.abi.solidity.datatypes.DynamicBytes;
import com.platon.abi.solidity.datatypes.Function;
import com.platon.abi.solidity.datatypes.Type;
import com.platon.abi.solidity.datatypes.generated.Uint256;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.protocol.core.methods.response.TransactionReceipt;
import com.platon.tx.Contract;
import com.platon.tx.TransactionManager;
import com.platon.tx.gas.GasProvider;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the com.platon.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.15.1.7.
 */
public class PlatonInner extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506103d0806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80636f10e28514610046578063eb51cc9114610064578063f40ae8d9146100e7575b600080fd5b61004e6101c2565b6040518082815260200191505060405180910390f35b61006c6101c8565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100ac578082015181840152602081019050610091565b50505050905090810190601f1680156100d95780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101c0600480360360408110156100fd57600080fd5b810190808035906020019064010000000081111561011a57600080fd5b82018360208201111561012c57600080fd5b8035906020019184600183028401116401000000008311171561014e57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061026a565b005b60015481565b606060008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156102605780601f1061023557610100808354040283529160200191610260565b820191906000526020600020905b81548152906001019060200180831161024357829003601f168201915b5050505050905090565b600082519050600060606000808460208801875af48061028657fe5b3d9250508167ffffffffffffffff811180156102a157600080fd5b506040519080825280601f01601f1916602001820160405280156102d45781602001600182028036833780820191505090505b5090503d6000602083013e80600090805190602001906102f59291906102fd565b505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061033e57805160ff191683800117855561036c565b8280016001018555821561036c579182015b8281111561036b578251825591602001919060010190610350565b5b509050610379919061037d565b5090565b5b8082111561039657600081600090555060010161037e565b509056fea2646970667358221220efae91c82edd4c1618dc611006f6446c1ba81b29c78ec1dc1bc1551b87e3c50664736f6c63430007010033";

    public static final String FUNC_ASSEMBLYCALLPPOS = "assemblyCallppos";

    public static final String FUNC_GETRETURNVALUE = "getReturnValue";

    public static final String FUNC_RES = "res";

    protected PlatonInner(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected PlatonInner(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> assemblyCallppos(byte[] data, String addr) {
        final Function function = new Function(
                FUNC_ASSEMBLYCALLPPOS, 
                Arrays.<Type>asList(new com.platon.abi.solidity.datatypes.DynamicBytes(data), 
                new com.platon.abi.solidity.datatypes.Address(addr)), 
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

    public static RemoteCall<PlatonInner> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(PlatonInner.class, web3j, credentials, contractGasProvider, BINARY,  "");
    }

    public static RemoteCall<PlatonInner> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(PlatonInner.class, web3j, transactionManager, contractGasProvider, BINARY,  "");
    }

    public static PlatonInner load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new PlatonInner(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PlatonInner load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new PlatonInner(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
