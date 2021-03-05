package network.platon.contracts.evm.v0_7_1;

import com.platon.abi.solidity.TypeReference;
import com.platon.abi.solidity.datatypes.Bool;
import com.platon.abi.solidity.datatypes.Function;
import com.platon.abi.solidity.datatypes.Type;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.tx.Contract;
import com.platon.tx.TransactionManager;
import com.platon.tx.gas.GasProvider;
import java.util.Arrays;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the com.platon.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.15.1.7.
 */
public class DoWhileError extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060c38061001f6000396000f3fe6080604052348015600f57600080fd5b506004361060285760003560e01c8063a8a5cadc14602d575b600080fd5b6033604b565b60405180821515815260200191505060405180910390f35b6000806054606e565b90508060000160009054906101000a900460ff1691505090565b60005b600090508060000160009054906101000a900460ff166071579056fea26469706673582212201f6c7d3daf2093351454365434be1a44d9d202983f477497dfbe82f1ca8ef62a64736f6c63430007010033";

    public static final String FUNC_GETDOWHILECONTROLRES = "getDoWhileControlRes";

    protected DoWhileError(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected DoWhileError(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Boolean> getDoWhileControlRes() {
        final Function function = new Function(FUNC_GETDOWHILECONTROLRES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<DoWhileError> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(DoWhileError.class, web3j, credentials, contractGasProvider, BINARY,  "");
    }

    public static RemoteCall<DoWhileError> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(DoWhileError.class, web3j, transactionManager, contractGasProvider, BINARY,  "");
    }

    public static DoWhileError load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new DoWhileError(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DoWhileError load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new DoWhileError(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
