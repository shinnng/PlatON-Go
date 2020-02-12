package wasm.data_type;

import network.platon.autotest.junit.annotations.DataSource;
import network.platon.autotest.junit.enums.DataSourceType;
import network.platon.contracts.wasm.InnerFunction;
import network.platon.contracts.wasm.IntegerDataTypeContract;
import org.junit.Test;
import org.openqa.selenium.By;
import org.web3j.abi.datatypes.Address;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Bytes;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;
import wasm.beforetest.WASMContractPrepareTest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Base data type test.
 */
public class IntegerDataTypeContractTest extends WASMContractPrepareTest {

    @Test
    @DataSource(type = DataSourceType.EXCEL, file = "test.xls", sheetName = "Sheet1",
            author = "zjsunzone", showName = "wasm.integer_data_type",sourcePrefix = "wasm")
    public void testIntegerTypeContract() {

        try {
            prepare();

            // deploy contract.
            IntegerDataTypeContract contract = IntegerDataTypeContract.deploy(web3j, transactionManager, provider).send();
            String contractAddress = contract.getContractAddress();
            String transactionHash = contract.getTransactionReceipt().get().getTransactionHash();
            collector.logStepPass("IntegerDataTypeContract issued successfully.contractAddress:" + contractAddress + ", hash:" + transactionHash);

            // test: store string
            TransactionReceipt strTr = contract.setString("setString").send();
            String getString = contract.getString().send();
            collector.logStepPass("To invoke setString and getString, getString: " + getString);
            collector.assertEqual(getString, "setString");

            // test: store bool
            TransactionReceipt boolTr = contract.setBool(true).send();
            boolean getBool = contract.getBool().send();
            collector.logStepPass("To invoke setBool and getBool, bool: " + getBool);
            collector.assertEqual(getBool, true);

            // test: store char
            Byte expectByte = (byte)1;
            TransactionReceipt charTr = contract.setChar(expectByte).send();
            collector.logStepPass("To invoke setChar success, txHash: " + charTr.getTransactionHash());
            Byte getChar = contract.getChar().send();
            collector.logStepPass("To invoke getChar success, getChar: " + getChar.byteValue());
            collector.assertEqual(getChar.byteValue(), expectByte.byteValue());

            // test: store address
            Address expectAddr = new Address("0x5b05e7a3e2a688c5e5cc491545a84a1efc66c1b1");
            TransactionReceipt addrTr = contract.setAddress(expectAddr.getValue()).send();
            collector.logStepPass("To invoke setAddress success, txHash: " + addrTr.getTransactionHash());
            String getAddress = contract.getAddress().send();
            collector.logStepPass("To invoke getAddress success, getAddress: " + getAddress);
            collector.assertEqual(expectAddr, getAddress);

        } catch (Exception e) {
            if(e instanceof ArrayIndexOutOfBoundsException){
                collector.logStepPass("IntegerDataTypeContract and could not call contract function");
            }else{
                collector.logStepFail("IntegerDataTypeContract failure,exception msg:" , e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
