package network.platon.contracts.evm.v0_6_12;

import com.platon.abi.solidity.TypeReference;
import com.platon.abi.solidity.datatypes.Function;
import com.platon.abi.solidity.datatypes.Type;
import com.platon.abi.solidity.datatypes.generated.Uint256;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.tx.Contract;
import com.platon.tx.TransactionManager;
import com.platon.tx.gas.GasProvider;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the com.platon.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.15.1.7.
 */
public class Sum extends Contract {
    private static final String BINARY = "61016c610026600b82828239805160001a60731461001957fe5b30600052607381538281f3fe73000000000000000000000000000000000000000030146080604052600436106100355760003560e01c806387fbcc771461003a575b600080fd5b6100f06004803603602081101561005057600080fd5b810190808035906020019064010000000081111561006d57600080fd5b82018360208201111561007f57600080fd5b803590602001918460208302840111640100000000831117156100a157600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600081840152601f19601f820116905080830192505050505050509192919290505050610106565b6040518082815260200191505060405180910390f35b600080600090505b825181101561013057602081026020840101518201915080600101905061010e565b5091905056fea26469706673582212205348bed70e29de2214caae24a6872babdeea9203111542652c7a7b3417391faf64736f6c634300060c0033";

    public static final String FUNC_SUMUSINGINLINEASSEMBLY = "sumUsingInlineAssembly";

    protected Sum(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected Sum(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> sumUsingInlineAssembly(List<BigInteger> _data) {
        final Function function = new Function(FUNC_SUMUSINGINLINEASSEMBLY, 
                Arrays.<Type>asList(new com.platon.abi.solidity.datatypes.DynamicArray<com.platon.abi.solidity.datatypes.generated.Uint256>(
                com.platon.abi.solidity.datatypes.generated.Uint256.class,
                        com.platon.abi.solidity.Utils.typeMap(_data, com.platon.abi.solidity.datatypes.generated.Uint256.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<Sum> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(Sum.class, web3j, credentials, contractGasProvider, BINARY,  "");
    }

    public static RemoteCall<Sum> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(Sum.class, web3j, transactionManager, contractGasProvider, BINARY,  "");
    }

    public static Sum load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new Sum(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Sum load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new Sum(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
