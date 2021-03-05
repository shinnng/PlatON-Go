package network.platon.contracts.evm.v0_6_12;

import com.platon.abi.solidity.TypeReference;
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
public class FunctionDeclaraction extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506101d5806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806312065fe014610046578063ab95edb114610064578063cb533b38146100c3575b600080fd5b61004e610122565b6040518082815260200191505060405180910390f35b6100906004803603602081101561007a57600080fd5b810190808035906020019092919050505061012b565b604051808373ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390f35b6100ef600480360360208110156100d957600080fd5b8101908080359060200190929190505050610146565b604051808373ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390f35b60008054905090565b60008061013783610161565b50503360005491509150915091565b60008061015283610180565b50503360005491509150915091565b6000808260008082825401925050819055503360005491509150915091565b600080826000808282540192505081905550336000549150915091509156fea26469706673582212208b7fd28df413565e1997d8949ae4e1062b87311419c5ba29465267cfcbc5115564736f6c634300060c0033";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_UPDATE_EXTERNAL = "update_external";

    public static final String FUNC_UPDATE_PUBLIC = "update_public";

    protected FunctionDeclaraction(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected FunctionDeclaraction(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> update_external(BigInteger amount_ex) {
        final Function function = new Function(
                FUNC_UPDATE_EXTERNAL, 
                Arrays.<Type>asList(new com.platon.abi.solidity.datatypes.generated.Uint256(amount_ex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> update_public(BigInteger amount_pu) {
        final Function function = new Function(
                FUNC_UPDATE_PUBLIC, 
                Arrays.<Type>asList(new com.platon.abi.solidity.datatypes.generated.Uint256(amount_pu)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<FunctionDeclaraction> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(FunctionDeclaraction.class, web3j, credentials, contractGasProvider, BINARY,  "");
    }

    public static RemoteCall<FunctionDeclaraction> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(FunctionDeclaraction.class, web3j, transactionManager, contractGasProvider, BINARY,  "");
    }

    public static FunctionDeclaraction load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new FunctionDeclaraction(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static FunctionDeclaraction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new FunctionDeclaraction(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
