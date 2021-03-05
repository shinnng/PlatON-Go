package network.platon.contracts.evm.v0_7_1;

import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.tx.Contract;
import com.platon.tx.TransactionManager;
import com.platon.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the com.platon.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.15.1.7.
 */
public class CalledContract extends Contract {
    private static final String BINARY = "6080604052348015600f57600080fd5b50607080601d6000396000f3fe6080604052348015600f57600080fd5b506004361060285760003560e01c806335b09a6e14602d575b600080fd5b60336035565b005b600080fdfea26469706673582212209bfb70d28f589a77e0ce3e7b18ee2655b1be9bae726c7e5c516b59c12903552764736f6c63430007010033";

    public static final String FUNC_SOMEFUNCTION = "someFunction";

    protected CalledContract(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected CalledContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public void someFunction() {
        throw new RuntimeException("cannot call constant function with void return type");
    }

    public static RemoteCall<CalledContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(CalledContract.class, web3j, credentials, contractGasProvider, BINARY,  "");
    }

    public static RemoteCall<CalledContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(CalledContract.class, web3j, transactionManager, contractGasProvider, BINARY,  "");
    }

    public static CalledContract load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new CalledContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CalledContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new CalledContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
