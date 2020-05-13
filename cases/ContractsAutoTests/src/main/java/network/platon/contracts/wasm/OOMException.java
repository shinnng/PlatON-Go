package network.platon.contracts.wasm;

import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.7.5.3-SNAPSHOT.
 */
public class OOMException extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001540c60000060017f017f60017f0060027f7f0060047f7f7f7f0060027f7f017f6000017f60037f7f7f017f60087f7f7f7f7f7f7f7f017f60097f7f7f7f7f7f7f7f7f017f60087f7f7e7f7e7f7f7f017f60017f017e025c0403656e760c706c61746f6e5f6465627567000303656e760c706c61746f6e5f70616e6963000003656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000603656e7610706c61746f6e5f6765745f696e7075740002031e1d0002000b0000020104080a0905010001000200070101010204050303010405017001040405030100020608017f0141b08b040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300040f5f5f66756e63735f6f6e5f65786974001406696e766f6b6500080909010041010b03050c050ac3401d08001009101210160b0300010b5401037f230041206b2200240003402001418030460440200020022802003602002000100a200041206a240005418080c00010132202200136020020002001360210200041106a100a200141016a21010c010b0b0b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b950302077f017e230041406a22002400100410022202101322011003200020023602142000200136021020002000290310370308200041106a200041286a200041086a411c1017101f200041106a101b02400240200041106a1020450d002000280214450d0020002802102d000041c001490d010b10010b200041106a101a2204200028021422024b04401001200028021421020b200028021021060240024002402002044020062c00002201417f4a0d01027f200141ff0171220341bf014d04404100200141ff017141b801490d011a200341c97e6a0c010b4100200141ff017141f801490d001a200341897e6a0b41016a21030c010b4101210320060d000c010b2002200449200320046a20024b720d004100210120022003490d01200320066a2101200220036b20042004417f461b22054109490d0110010c010b410021010b0340200504402005417f6a210520013100002007420886842107200141016a21010c010b0b024002402007500d0041890810072007510d01418e0810072007520d0010060c010b10010b1014200041406b24000b3801017f41f008420037020041f808410036020041742100034020000440200041fc086a4100360200200041046a21000c010b0b410110150bf518030f7f027e037c4180082104230041c0086b220524002005200036020c200541800836029c082005419f086a210e0340410020066b21070240034020042d00002202450d0120024125470440200641ff074d0440200541106a20066a20023a00000b200641016a21062005200441016a220436029c082007417f6a21070c010b0b2005200441016a220436029c08410021010340024002400240024020042c0000220241556a220341054b0440200241606a220341034b0d0102400240200341016b0e03030301000b2005200441016a220436029c08200141087221010c060b2005200441016a220436029c08200141107221010c050b200341016b0e050002000003010b0240200241506a41ff017141094d04402005419c086a100b2109200528029c0821040c010b410021092002412a470d00200028020021022005200441016a220436029c082001410272200120024100481b210120022002411f7522036a2003732109200041046a21000b41002108024020042d0000412e470d002005200441016a220236029c08200141800872210120042d0001220341506a41ff017141094d04402005419c086a100b2108200528029c0821040c010b2003412a470440200221040c010b200028020021022005200441026a220436029c0820024100200241004a1b2108200041046a21000b0240024020042c000041987f6a411f77220241094b0d000240024002400240200241016b0e09020004040403040403010b2005200441016a220236029c0820042d0001220341ec004704402001418002722101200221040c050b2005200441026a220436029c0820014180067221010c030b2005200441016a220236029c0820042d0001220341e8004704402001418001722101200221040c040b2005200441026a220436029c08200141c0017221010c020b2005200441016a220436029c0820014180047221010c010b2005200441016a220436029c0820014180027221010b20042d000021030b0240027f024002400240024002400240024020034118744118752202419e7f6a220a41164b044020024125470440200241c600460d07200241d800470d020c080b200641ff074b0d02200541106a20066a41253a00000c020b200a41016b0e15040600050000060000000000060200000300060000060b200641ff074b0d00200541106a20066a20033a00000b200641016a21060c060b200541106a2006200028020041004110200841082001412172100d21062005200441016a220436029c08200041046a21000c0b0b20002802002203417f6a21070340200741016a22072d00000d000b200720036b2202200820022008491b2002200141800871220a410a761b210202402001410271220c0440200621070c010b200541106a20066a210b4100210103400240200120066a2107200120026a220d20094f0d00200741ff074d04402001200b6a41203a00000b200141016a21010c010b0b200d41016a21020b200041046a2100034002402007210120032d00002206450d00200a04402008450d012008417f6a21080b200141016a2107200341016a2103200141ff074b0d01200541106a20016a20063a00000c010b0b200c450440200121060c050b200541106a20016a2103410021070340200120076a2106200220076a20094f0d05200641ff074d0440200320076a41203a00000b200741016a21070c000b000b410121070240200141027122080440200621030c010b200541106a20066a21074100210103400240200120066a2103200141016a220220094f0d00200341ff074d0440200120076a41203a00000b200221010c010b0b200141026a21070b200341ff074d0440200541106a20036a20002802003a00000b200341016a22062008450d021a034020062202200720094f0d031a200241016a2106200741016a2107200241ff074b0d00200541106a20026a41203a00000c000b000b200841062001418008711b220841037441a0086a2102200041076a417871220d2b030021124100210303402008410a492003411f4b72450440200541a0086a20036a41303a0000200241786a21022008417f6a2108200341016a21030c010b0b027f4400000000000000002012a12012201244000000000000000063220b1b22129944000000000000e0416304402012aa0c010b4180808080780b2100027f20122000b7a120022b03002214a2221344000000000000f041632013440000000000000000667104402013ab0c010b41000b210a02402013200ab8a1221344000000000000e03f644101734504402014200a41016a220ab8654101730d01200041016a21004100210a0c010b201344000000000000e03f620d00200a45200a41017172200a6a210a0b4100210202402012440000c0ffffffdf41640d00024020080440200320086a41606a2102034002402003412046044041202103200221080c010b200541a0086a20036a200a200a410a6e220c41766c6a4130723a0000200341016a21032008417f6a2108200a41094b200c210a0d010b0b03402003411f4b220220084572450440200541a0086a20036a41303a0000200341016a21032008417f6a21080c010b0b20020d01200541a0086a20036a412e3a0000200341016a21030c010b20122000b7a1221244000000000000e03f64410173450440200041016a21000c010b20002000201244000000000000e03f61716a21000b03402003411f4d0440200541a0086a20036a20002000410a6d220241766c6a41306a3a0000200341016a2103200041096a2002210041124b0d010b0b20014103712100034020004101472003411f4b72200320094f72450440200541a0086a20036a41303a0000200341016a21030c010b0b2001410171210220014102712100024020092001410c71410047200b726b200320032009461b2203411f4b0d000240200b410173450440200541a0086a20036a412d3a00000c010b20014104710440200541a0086a20036a412b3a00000c010b2001410871450d01200541a0086a20036a41203a00000b200341016a21030b024020002002720440200621020c010b200541106a20066a2108410021010340200120066a2102200120036a20094f0d01200241ff074d0440200120086a41203a00000b200141016a21010c000b000b200220076a2106034020034504402000450d020340200620094f0d03200241ff074d0440200541106a20026a41203a00000b200241016a2102200641016a21060c000b000b200241ff074d0440200541106a20026a2003200e6a2d00003a00000b200241016a2102200641016a21062003417f6a21030c000b000b200d41086a21002005200441016a220436029c08200221060c080b41102102027f0240200341ff0171220341d800462207200341f8004672450440200341ef00460440410821020c020b200341e200460440410221020c020b2001416f712101410a21020b2001412072200120071b2201200341e40046200341e90046720d011a0b20014173710b2207417e7120072007418008711b2107200341e900474100200341e400471b4504402007418004710440200541106a2006200041076a417871220029030022102010423f8722117c2011852010423f88a72002ad200820092007100e2106200041086a21000c030b2007418002710440200541106a2006200028020022062006411f7522016a2001732006411f762002200820092007100d0c020b200541106a2006027f200741c00071044020002c00000c010b2000280200220641107441107520062007418001711b0b2206411f75220120066a2001732006411f762002200820092007100d0c010b2007418004710440200541106a2006200041076a417871220029030041002002ad200820092007100e2106200041086a21000c020b2007418002710440200541106a2006200028020041002002200820092007100d0c010b200541106a2006027f200741c00071044020002d00000c010b2000280200220641ffff037120062007418001711b0b41002002200820092007100d0b2106200041046a21000b2005200441016a220436029c080c050b2005200441016a220436029c08200141047221010c020b2005200441016a220436029c08200141027221010c010b2005200441016a220436029c08200141017221010c000b000b0b200541106a200641ff07200641ff07491b6a41003a0000200541106a2104024003402004410371044020042d0000450d02200441016a21040c010b0b2004417c6a21040340200441046a22042802002201417f73200141fffdfb776a7141808182847871450d000b0340200141ff0171450d01200441016a2d00002101200441016a21040c000b000b200541106a2004200541106a6b1000200541c0086a24000b4501037f20002802002101034020012d000041506a41ff017141094b4504402000200141016a220336020020012c00002002410a6c6a41506a2102200321010c010b0b20020b140020022003490440200120026a20003a00000b0b9f0101067f230041206b220924000240200245410020072007416f7120021b220a418008711b0d00200a41207141e1007341f6016a210b410021070340200720096a2002200220046e220c20046c6b22084130200b200841187441808080d000481b6a3a0000200741016a21082007411e4b0d01200220044f20082107200c21020d000b0b20002001200920082003200420052006200a100f200941206a24000baa0102057f017e230041206b2209240020072007416f71200242005222071b210a02402007454100200a418008711b0d00200a41207141e1007341f6016a210b410021070340200720096a4130200b20022002200480220d20047e7da7220841187441808080d000481b20086a3a0000200741016a21082007411e4b0d01200220045a20082107200d21020d000b0b200020012009200820032004a720052006200a100f200941206a24000be10401037f2008410271210a2003210902400340200a0d012009411f4b200920064f72450440200220096a41303a0000200941016a21090c010b0b200921030b2008410371410147210b2003210902400340200b0d012009411f4b200920074f72450440200220096a41303a0000200941016a21090c010b0b200921030b2008410171210b02400240024020084110710440200345200841800871722003200647410020032007471b724504402003417e6a2003417f6a220320031b200320054110461b21030b024020054110460440200841207122052003411f4b72450440200220036a41f8003a0000200341016a21030c020b2005452003411f4b720d01200220036a41d8003a0000200341016a21030c010b20054102472003411f4b720d00200220036a41e2003a0000200341016a21030b2003411f4b0d01200220036a41303a0000200341016a21030c010b20030d00410021030c010b20072008410c714100472004726b200320032007461b2203411f4b0d010b20040440200220036a412d3a0000200341016a21030c010b20084104710440200220036a412b3a0000200341016a21030c010b2008410871450d00200220036a41203a0000200341016a21030b200121090240200a200b720d00200321040340200420074f0d01412020002009418008100c200441016a2104200941016a21090c000b000b2002417f6a2102037f2003047f200220036a2c000020002009418008100c2003417f6a2103200941016a21090c01050240200a450d00410020016b21010340200120096a20074f0d01412020002009418008100c200941016a21090c000b000b20090b0b0bf10801077f0340200020036a2104200120036a220241037145200341044672450440200420022d00003a0000200341016a21030c010b0b410420036b21050240200441037122064504400340200541104f0440200020036a2202200120036a2204290200370200200241086a200441086a290200370200200341106a2103200541706a21050c010b0b027f2005410871450440200120036a2102200020036a0c010b200020036a2204200120036a2201290200370200200141086a2102200441086a0b21032005410471044020032002280200360200200241046a2102200341046a21030b20054102710440200320022f00003b0000200241026a2102200341026a21030b2005410171450d01200320022d00003a000020000f0b024020054120490d002006417f6a220641024b0d00024002400240024002400240200641016b0e020102000b2004200120036a220528020022023a0000200441016a200541016a2f00003b0000200041036a2108410120036b2105034020054111490d03200320086a2204200120036a220641046a2802002207410874200241187672360200200441046a200641086a2802002202410874200741187672360200200441086a2006410c6a28020022074108742002411876723602002004410c6a200641106a2802002202410874200741187672360200200341106a2103200541706a21050c000b000b2004200120036a220528020022023a0000200441016a200541016a2d00003a0000200041026a2108410220036b2105034020054112490d03200320086a2204200120036a220641046a2802002207411074200241107672360200200441046a200641086a2802002202411074200741107672360200200441086a2006410c6a28020022074110742002411076723602002004410c6a200641106a2802002202411074200741107672360200200341106a2103200541706a21050c000b000b2004200120036a28020022023a0000200041016a21082003417f7341046a2105034020054113490d03200320086a2204200120036a220641046a2802002207411874200241087672360200200441046a200641086a2802002202411874200741087672360200200441086a2006410c6a28020022074118742002410876723602002004410c6a200641106a2802002202411874200741087672360200200341106a2103200541706a21050c000b000b200120036a41036a2102200020036a41036a21040c020b200120036a41026a2102200020036a41026a21040c010b200120036a41016a2102200020036a41016a21040b20054110710440200420022d00003a00002004200228000136000120042002290005370005200420022f000d3b000d200420022d000f3a000f200441106a2104200241106a21020b2005410871044020042002290000370000200441086a2104200241086a21020b2005410471044020042002280000360000200441046a2104200241046a21020b20054102710440200420022f00003b0000200441026a2104200241026a21020b2005410171450d00200420022d00003a00000b20000bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b3501017f230041106b220041b08b0436020c41980b200028020c41076a4178712200360200419c0b200036020041a00b3f003602000b950101047f230041106b220124002001200036020c2000047f41a00b200041086a2202411076220041a00b2802006a2203360200419c0b2002419c0b28020022026a41076a417871220436020002400240200341107420044d044041a00b200341016a360200200041016a21000c010b2000450d010b200040000d0010010b20022001410c6a101041086a0541000b200141106a24000b880101037f41fc084101360200418009280200210003402000044003404184094184092802002201417f6a2202360200200141014845044041fc084100360200200020024102746a22004184016a280200200041046a28020011020041fc08410136020041800928020021000c010b0b4184094120360200418009200028020022003602000c010b0b0b940101027f41fc084101360200418009280200220145044041800941880936020041880921010b02404184092802002202412046044041840210132201450d0120011011220141800928020036020041800920013602004184094100360200410021020b418409200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41fc0841003602000b3801017f418c0b420037020041940b410036020041742100034020000440200041980b6a4100360200200041046a21000c010b0b410310150b750020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d002000101820012802044f0d002002410471044010010c010b200042003702000b02402002411071450d002000101820012802044d0d0020024104710440100120000f0b200042003702000b20000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f200010192000101a6a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0bff0201037f200028020445044041000f0b2000101b41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100120002802040520010b4102490d0020002802002d00010d0010010b200241054f044010010b20002802002d000145044010010b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100120002802040520010b4102490d0020002802002d00010d0010010b200241054f044010010b20002802002d000145044010010b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10010b20020b4101017f200028020445044010010b0240200028020022012d0000418101470d00200028020441014d047f100120002802000520010b2c00014100480d0010010b0b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b3c01017f230041306b22022400200220013602142002200036021020022002290310370308200241186a200241086a411410171018200241306a24000b2101017f2001101a220220012802044b044010010b20002001200110192002101c0bd60202067f017e230041206b220224002001280208220341004b0440200241186a2001101e20012002280218200228021c101d36020c200241106a2001101e410021032001027f410020022802102204450d001a410020022802142206200128020c2205490d001a200620052005417f461b210720040b360210200141146a2007360200200141003602080b200141106a210503400240200341004f0d002001280214450d00200241106a2001101e41002103027f410020022802102206450d001a410020022802142207200128020c2204490d001a200720046b2103200420066a0b21042001200336021420012004360210200241106a2005410020042003101d101c2001200229031022083702102001200128020c2008422088a76a36020c2001200128020841016a22033602080c010b0b2002200529020022083703082002200837030020002002411410171a200241206a24000b980101037f200028020445044041000f0b2000101b200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100120002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100120002802000520020b20016a2d00004100470b0b0b7102004180080b1a69203d202564090a00696e6974006d656d6f72795f6c696d69740041a6080b4af03f000000000000244000000000000059400000000000408f40000000000088c34000000000006af8400000000080842e4100000000d01263410000000084d797410000000065cdcd41";

    private static String BINARY = BINARY_0;

    public static final String FUNC_MEMORY_LIMIT = "memory_limit";

    protected OOMException(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected OOMException(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> memory_limit() {
        final WasmFunction function = new WasmFunction(FUNC_MEMORY_LIMIT, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<OOMException> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(OOMException.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<OOMException> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(OOMException.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public static OOMException load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new OOMException(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static OOMException load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new OOMException(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
