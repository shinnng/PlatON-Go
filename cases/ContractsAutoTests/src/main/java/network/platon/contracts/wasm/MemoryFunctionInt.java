package network.platon.contracts.wasm;

import com.platon.abi.wasm.WasmFunctionEncoder;
import com.platon.abi.wasm.datatypes.WasmFunction;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.rlp.wasm.datatypes.Int32;
import com.platon.tx.TransactionManager;
import com.platon.tx.WasmContract;
import com.platon.tx.gas.GasProvider;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/PlatONnetwork/client-sdk-java/releases">platon-web3j command line tools</a>,
 * or the com.platon.codegen.WasmFunctionWrapperGenerator in the
 * <a href="https://github.com/PlatONnetwork/client-sdk-java/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with platon-web3j version 0.13.2.0.
 */
public class MemoryFunctionInt extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001420c60000060017f017f60017f0060027f7f006000017f60037f7f7f0060037e7e7f0060027f7f017f60037f7f7f017f60047f7f7f7f017f60027e7e017f60017f017e02b1010803656e760c706c61746f6e5f70616e6963000003656e760d726c705f6c6973745f73697a65000103656e760f706c61746f6e5f726c705f6c697374000503656e760d726c705f753132385f73697a65000a03656e760f706c61746f6e5f726c705f75313238000603656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000403656e7610706c61746f6e5f6765745f696e707574000203656e760d706c61746f6e5f72657475726e0003031312000401080009030702010b020303000001010405017001010105030100020608017f0141b088040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300080f5f5f66756e63735f6f6e5f65786974001606696e766f6b65000c0ad71d12040010170b3401027f230041106b220024002000417f36020c4104100a22012000410c6a4104100b1a20012802002101200041106a240020010b9b0101047f230041106b220124002001200036020c2000047f41a808200041086a2202411076220041a8082802006a220336020041a40841a408280200220420026a41076a417871220236020002400240200341107420024d044041a808200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104100b41086a0541000b2100200141106a240020000bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000bb40802087f047e230041406a22022400101710052200100a220110060240200241086a20012000411c100d2203280208450440200341146a2802002100200328021021010c010b200241386a2003100e20032002280238200228023c100f36020c200241206a2003100e410021002003027f410020022802202204450d001a410020022802242206200328020c2205490d001a200620052005417f461b210020040b2201360210200341146a2000360200200341003602080b200241206a200120004114100d22001010024002402000280204450d00200010100240200028020022042c0000220141004e044020010d010c020b200141807f460d00200141ff0171220541b7014d0440200028020441014d04401000200028020021040b20042d00010d010c020b200541bf014b0d012000280204200141ff017141ca7e6a22014d04401000200028020021040b200120046a2d0000450d010b2000280204450d0020042d000041c001490d010b10000b200010112206200028020422044b04401000200028020421040b20002802002107024002400240200404404100210520072c00002200417f4a0d01027f200041ff0171220541bf014d04404100200041ff017141b801490d011a200541c97e6a0c010b4100200041ff017141f801490d001a200541897e6a0b41016a21050c010b4101210520070d00410021000c010b41002100200520066a20044b0d0020042006490d004100210120042005490d01200520076a2101200420056b20062006417f461b22004109490d0110000c010b410021010b0340200004402000417f6a210020013100002008420886842108200141016a21010c010b0b024002402008500d0041800810122008510440200310130c020b41850810122008520d002003101310092103410021002002410036022820024200370320200241206a41001014200241346a41003602002002420037022c410121012003ac22084201862008423f87220985220a42800154410020094201862008423f8884200985220b501b450440200a2109200b2108034020082009845045044020084238862009420888842109200041016a2100200842088821080c010b0b024020004138490d002000210103402001450d01200041016a2100200141087621010c000b000b200041016a21010b20022802282001490440200241206a200110140b200241206a200b200a1003200228022422006a1015200b200a2000200228022022066a10040340024020022802302201200228022c22044622050d00200141786a220028020022034504401000200028020021030b20002003417f6a220336020020030d0020022000360230200241206a2001417c6a2802002200200228022420006b220110016a10152000200228022022066a22002001200010020c010b0b200545044010000b2006200228022410072004450d01200220043602300c010b10000b1016200241406b24000b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000101820024f0d002003410471044010000c010b200042003702000b02402003411071450d002000101820024d0d0020034104710440100020000f0b200042003702000b20000b7201047f20011011220220012802044b044010000b2001101921032000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012003490d00410020012002490d011a200320056a2104200120036b20022002417f461b0c010b41000b360204200020043602000b2701017f230041206b22022400200241086a200020014114100d10182100200241206a240020000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bff0201037f200028020445044041000f0b2000101041012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b8b0101047f230041106b22012400024002402000280204450d0020002802002d000041c001490d00200141086a2000100e41012103200128020c2100034020000440200141002001280208220220022000100f22046a20024520002004497222021b3602084100200020046b20021b21002003417f6a21030c010b0b2003450d010b10000b200141106a24000b2f01017f200028020820014904402001100a20002802002000280204100b210220002001360208200020023602000b0b3601017f200028020820014904402001100a20002802002000280204100b210220002001360208200020023602000b200020013602040b880101037f419408410136020041980828020021000340200004400340419c08419c082802002201417f6a220236020020014101484504404194084100360200200020024102746a22004184016a280200200041046a280200110200419408410136020041980828020021000c010b0b419c084120360200419808200028020022003602000c010b0b0b3501017f230041106b220041b0880436020c41a008200028020c41076a417871220036020041a408200036020041a8083f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001019200010116a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b0b1801004180080b11696e6974006765746d616c6c6f63696e74";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GETMALLOCINT = "getmallocint";

    protected MemoryFunctionInt(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected MemoryFunctionInt(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<MemoryFunctionInt> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MemoryFunctionInt.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<MemoryFunctionInt> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MemoryFunctionInt.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<MemoryFunctionInt> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MemoryFunctionInt.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<MemoryFunctionInt> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MemoryFunctionInt.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<Int32> getmallocint() {
        final WasmFunction function = new WasmFunction(FUNC_GETMALLOCINT, Arrays.asList(), Int32.class);
        return executeRemoteCall(function, Int32.class);
    }

    public static MemoryFunctionInt load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new MemoryFunctionInt(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static MemoryFunctionInt load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new MemoryFunctionInt(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
