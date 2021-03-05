package network.platon.contracts.wasm;

import com.platon.abi.wasm.WasmFunctionEncoder;
import com.platon.abi.wasm.datatypes.WasmFunction;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.protocol.core.methods.response.TransactionReceipt;
import com.platon.rlp.wasm.datatypes.Uint64;
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
public class Contract_timeout_termination extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001540f60017f017f60027f7f0060017f0060000060037f7f7f0060027f7f017f60047f7f7f7f0060037f7f7f017f60047f7f7f7f017f60017f017e60037f7f7e0060027f7e0060037e7e7f006000017f60027e7e017f02a9020d03656e760c706c61746f6e5f70616e6963000303656e760d726c705f6c6973745f73697a65000003656e760f706c61746f6e5f726c705f6c697374000403656e760e726c705f62797465735f73697a65000503656e7610706c61746f6e5f726c705f6279746573000403656e760d726c705f753132385f73697a65000e03656e760f706c61746f6e5f726c705f75313238000c03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000d03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000503656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000603656e760d706c61746f6e5f72657475726e0001032b2a030a010503000704090902000200000100000101030802010b00000201070201050001020403040000060405017001010105030100020608017f0141c088040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000d0f5f5f66756e63735f6f6e5f65786974002106696e766f6b6500110a8c342a040010320b22002002427f7c21020340200242017c220242e400560d000b200041186a2001100f0b8c0201047f20002001470440200128020420012d00002202410176200241017122041b2102200141016a210320012802082105410a21012005200320041b210420002d0000410171220304402000280200417e71417f6a21010b200220014d0440027f2003044020002802080c010b200041016a0b21012002044020012004200210310b200120026a41003a000020002d00004101710440200020023602040f0b200020024101743a00000f0b416f2103200141e6ffffff074d0440410b20014101742201200220022001491b220141106a4170712001410b491b21030b200310262201200420021033200020023602042000200341017236020020002001360208200120026a41003a00000b0ba10101037f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b20012802082103024020012802042201410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712204102621022000200136020420002004410172360200200020023602080b2002200320011033200120026a41003a000020000bec0202047f017e23004180016b22002400103210072201101222021008200041206a200041086a20022001101322014100101402400240200041206a10152204500d004180081016200451044020011017200041206a101810190c020b41850810162004510440200041e8006a101a2102200042003703782001101b410347044010000b200041206a200141011014200041206a2002101c200041206a2001410210142000200041206a1015370378200041206a10182101200041c8006a20021010210220002903782104200041206a200041d8006a200210102004100e200110190c020b41910810162004520d0020011017200041206a10182103200041c8006a200041386a10102102200041e8006a101d22012002101e101f2001200041d8006a200210101020200128020c200141106a28020047044010000b20012802002001280204100c200128020c22020440200120023602100b200310190c010b10000b102120004180016a24000b9b0101047f230041106b220124002001200036020c2000047f41b808200041086a2202411076220041b8082802006a220336020041b40841b408280200220420026a41076a417871220236020002400240200341107420024d044041b808200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104102a41086a0541000b2100200141106a240020000b0c00200020012002411c10220bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001102c20012003280208200328020c102d36020c20032001102c410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b200020062802002004411410221a200341106a24000f0b20032001102c41002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b2105200120043602142001200536021020032006410020052004102d10362001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000b870202047f017e230041106b2203240020001023024002402000280204450d00200010230240200028020022022c0000220141004e044020010d010c020b200141807f460d00200141ff0171220441b7014d0440200028020441014d04401000200028020021020b20022d00010d010c020b200441bf014b0d012000280204200141ff017141ca7e6a22014d04401000200028020021020b200120026a2d0000450d010b2000280204450d0020022d000041c001490d010b10000b200341086a20001024200328020c220041094f044010000b200328020821010340200004402000417f6a210020013100002005420886842105200141016a21010c010b0b200341106a240020050b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b0e002000101b410147044010000b0bdc0101097f230041306b220524002000101a2107200042afb59bdd9e8485b9f800370310200041186a101a2106200541186a101d220220002903101025200228020c200241106a28020047044010000b02400240200228020022082002280204220910092204450d002004102621030340200120036a41003a00002004200141016a2201470d000b2008200920032001100a417f460d002005200341016a200120036a2003417f736a10132006101c0c010b410021040b200228020c22010440200220013602100b200445044020062007100f0b200541306a240020000bc80302097f027e230041d0006b22032400200341186a101d2104200341c8006a4100360200200341406b4200370300200341386a420037030020034200370330410121022000290310220a4280015a04400340200a200b8450450440200b423886200a42088884210a200141016a2101200b420888210b0c010b0b200141384f047f2001102720016a0520010b41016a21020b20032002360230200341306a410472102820042002101f200420002903101025200428020c200441106a28020047044010000b2004280204210520042802002106200341306a101d2101200041186a2200101e210741011026220241fe013a0000200128020c200141106a28020047044010000b2001280204220841016a220920012802084b047f20012009102920012802040520080b20012802006a20024101102a1a2001200128020441016a3602042001200241016a200720026b6a101f2001200341086a2000101010200240200128020c2001280210460440200128020021020c010b100020012802002102200128020c2001280210460d0010000b2006200520022001280204100b200128020c22020440200120023602100b200428020c22010440200420013602100b200341d0006a24000b190020004200370200200041086a41003602002000102b20000b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a2000102c200128020c210003402000450d01200141002001280208220320032000102d22046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020bf40201057f230041206b22022400024002402000280204044020002802002d000041c001490d010b200241086a101a1a0c010b200241186a200010242000102e21030240024002400240200228021822000440200228021c220520034f0d010b41002100200241106a410036020020024200370308410021050c010b200241106a4100360200200242003703082000200520032003417f461b22046a21052004410a4b0d010b200220044101743a0008200241086a41017221030c010b200441106a4170712206102621032002200436020c20022006410172360208200220033602100b03402000200546450440200320002d00003a0000200341016a2103200041016a21000c010b0b200341003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d00200141003602000b20012002290308370200200141086a200241106a280200360200200241086a102b200241206a24000b29002000410036020820004200370200200041001029200041146a41003602002000420037020c20000bb80101047f230041306b22012400200141286a4100360200200141206a4200370300200141186a42003703002001420037031041012103024002400240200120001010220028020420002d00002202410176200241017122041b220241014d0440200241016b0d032000280208200041016a20041b2c0000417f4c0d010c030b200241374b0d010b200241016a21030c010b2002102720026a41016a21030b20012003360210200141106a4104721028200141306a240020030b1300200028020820014904402000200110290b0b4c01037f20002001280208200141016a20012d0000220241017122031b22042001280204200241017620031b22011003200028020422026a102f20042001200220002802006a1004200010300b880101037f41a408410136020041a8082802002100034020000440034041ac0841ac082802002201417f6a2202360200200141014845044041a4084100360200200020024102746a22004184016a280200200041046a28020011020041a408410136020041a80828020021000c010b0b41ac08412036020041a808200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000103420024f0d002003410471044010000c010b200042003702000b02402003411071450d002000103420024d0d0020034104710440100020000f0b200042003702000b20000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bd50101047f2001102e2204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b41002103200120046a20024b0d0020022001490d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b2801017f2000420020011005200028020422026a102f42002001200220002802006a1006200010300b0b002000410120001b10120b1e01017f03402000044020004108762100200141016a21010c010b0b20010b860201067f200028020422032000280210220141087641fcffff07716a2102027f200320002802082204460440200041146a210641000c010b2003200028021420016a220541087641fcffff07716a280200200541ff07714102746a2105200041146a21062002280200200141ff07714102746a0b21010340024020012005460440200641003602000340200420036b41027522014103490d022000200341046a22033602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2001417f6a220241014d04402000418004418008200241016b1b3602100b03402003200447044020002004417c6a22043602080c010b0b0b2f01017f200028020820014904402001101220002802002000280204102a210220002001360208200020023602000b0bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b2101017f2001102e220220012802044b044010000b2000200120011035200210360b2701017f230041206b22022400200241086a200020014114102210342100200241206a240020000bff0201037f200028020445044041000f0b2000102341012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b3601017f200028020820014904402001101220002802002000280204102a210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210016a102f200120002802006a22012002200110020c010b0b0b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002102a1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2105200020036a2204410371450440200220036b210241002103034020024104490d04200320046a200320056a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200420052d00003a0000200341016a21030c000b000b024020030d002001417f6a21040340200020026a22034103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042003417f6a200220046a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320056a2101200320046a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b3501017f230041106b220041c0880436020c41b008200028020c41076a417871220036020041b408200036020041b8083f003602000b100020020440200020012002102a1a0b0b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f200010352000102e6a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b0b2a01004180080b23696e697400666f7266756e6374696f6e006765745f737472696e675f73746f72616765";

    public static String BINARY = BINARY_0;

    public static final String FUNC_FORFUNCTION = "forfunction";

    public static final String FUNC_GET_STRING_STORAGE = "get_string_storage";

    protected Contract_timeout_termination(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected Contract_timeout_termination(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<Contract_timeout_termination> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_timeout_termination.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<Contract_timeout_termination> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_timeout_termination.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<Contract_timeout_termination> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_timeout_termination.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<Contract_timeout_termination> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(Contract_timeout_termination.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> forfunction(String name, Uint64 value) {
        final WasmFunction function = new WasmFunction(FUNC_FORFUNCTION, Arrays.asList(name,value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> forfunction(String name, Uint64 value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_FORFUNCTION, Arrays.asList(name,value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<String> get_string_storage() {
        final WasmFunction function = new WasmFunction(FUNC_GET_STRING_STORAGE, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static Contract_timeout_termination load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new Contract_timeout_termination(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static Contract_timeout_termination load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new Contract_timeout_termination(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
