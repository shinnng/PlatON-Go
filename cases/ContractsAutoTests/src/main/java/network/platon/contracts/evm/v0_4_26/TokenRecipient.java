package network.platon.contracts.evm.v0_4_26;

import com.platon.abi.solidity.TypeReference;
import com.platon.abi.solidity.datatypes.Function;
import com.platon.abi.solidity.datatypes.Type;
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
public class TokenRecipient extends Contract {
    private static final String BINARY = "";

    public static final String FUNC_RECEIVEAPPROVAL = "receiveApproval";

    protected TokenRecipient(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected TokenRecipient(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> receiveApproval(String _from, BigInteger _value, String _token, byte[] _extraData) {
        final Function function = new Function(
                FUNC_RECEIVEAPPROVAL, 
                Arrays.<Type>asList(new com.platon.abi.solidity.datatypes.Address(_from), 
                new com.platon.abi.solidity.datatypes.generated.Uint256(_value), 
                new com.platon.abi.solidity.datatypes.Address(_token), 
                new com.platon.abi.solidity.datatypes.DynamicBytes(_extraData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<TokenRecipient> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(TokenRecipient.class, web3j, credentials, contractGasProvider, BINARY,  "");
    }

    public static RemoteCall<TokenRecipient> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(TokenRecipient.class, web3j, transactionManager, contractGasProvider, BINARY,  "");
    }

    public static TokenRecipient load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new TokenRecipient(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TokenRecipient load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new TokenRecipient(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
