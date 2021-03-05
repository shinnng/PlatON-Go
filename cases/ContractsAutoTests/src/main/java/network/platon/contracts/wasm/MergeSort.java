package network.platon.contracts.wasm;

import com.platon.abi.wasm.WasmFunctionEncoder;
import com.platon.abi.wasm.datatypes.WasmFunction;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.protocol.core.methods.response.TransactionReceipt;
import com.platon.rlp.wasm.datatypes.Int32;
import com.platon.rlp.wasm.datatypes.Int64;
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
public class MergeSort extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001540f60027f7f0060017f017f60017f0060037f7f7f017f60000060037f7f7f0060027f7f017f60047f7f7f7f017f60047f7f7f7f0060037f7e7e0060027f7e0060037e7e7f006000017f60027e7e017f60017f017e02fd010b03656e760c706c61746f6e5f70616e6963000403656e760d726c705f6c6973745f73697a65000103656e760f706c61746f6e5f726c705f6c697374000503656e760d726c705f753132385f73697a65000d03656e760f706c61746f6e5f726c705f75313238000b03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000c03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000603656e7610706c61746f6e5f6765745f7374617465000703656e7610706c61746f6e5f7365745f7374617465000803656e760d706c61746f6e5f72657475726e0000033f3e040803060005010301040103050201000e020102010000010100000407010a030609020000060700020300000002090301000100030702030005040101080405017001010105030100020608017f0141b088040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000b0f5f5f66756e63735f6f6e5f65786974002606696e766f6b6500140af6523e040010450b4a00200120022003100d21012000280218044020004200370218200041206a41003602000b20002001290200370218200041206a200128020836020020014100360208200142003702000b800302097f027e0240200120024e0d0020002001200120026a41026d220b100d200b41016a22062002100d2103417f200220016b41016a2204410274200441ffffffff03712004471b1013210820032802002109200821042001210303402003200b4c4100200620024c1b04402008200a4102746a200920064103746a290300220c200920034103746a290300220d200d200c5522071b3e0200200620076a21062003200d200c576a2103200441046a2104200a41016a210a0c0105200920034103746a2105410021070340200320076a200b4a0440200920064103746a2105410021030340200320066a20024a04402007200a6a20036a2104200920014103746a210303402004450d07200320083402003703002004417f6a2104200341086a2103200841046a21080c000b0005200420052903003e0200200441046a2104200341016a2103200541086a21050c010b000b0005200420052903003e0200200741016a2107200541086a2105200441046a21040c010b000b000b000b000b20000b3e01017f2000420037020020004100360208200128020420012802006b2202044020002002410375100f20012802002001280204200041046a10100b20000b2301017f2000200110112202360200200020023602042000200220014103746a3602080b2800200120006b220141014e044020022802002000200110121a2002200228020020016a3602000b0b0900200041037410130bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b0b002000410120001b10150bb90402057f017e230041f0006b22002400104510052201101522021006200041206a2000200220011016220341001017200041206a101802400240200041206a1019450d002000280224450d0020002802202d000041c001490d010b10000b200041d8006a200041206a101a200028025c220141094f044010000b200028025821020340200104402001417f6a210120023100002005420886842105200241016a21020c010b0b024002402005500d00418008101b20055104402003101c200041206a101d101e0c020b418508101b2005510440200041003602682000420037036020004200370358200041e8006a2101200041e4006a21022003101f410447044010000b2000410136021c2000200336024820002000411c6a36024c200041206a200341011017200041206a200041d8006a10202000200028021c41016a36021c200041c8006a20021021200041c8006a20011021200041206a101d2102200041206a200041c8006a200041d8006a100e220120002802642000280268100c200128020022030440200120033602040b2002101e20002802582201450d022000200136025c0c020b418a08101b2005520d002003101c200041206a101d2103200041c8006a200041386a100e2102200041d8006a10222201200210231024200120021025200128020c200141106a28020047044010000b20012802002001280204100a200128020c22040440200120043602100b200228020022010440200220013602040b2003101e0c010b10000b1026200041f0006a24000b9b0101047f230041106b220124002001200036020c2000047f41a808200041086a2202411076220041a8082802006a220336020041a40841a408280200220420026a41076a417871220236020002400240200341107420024d044041a808200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104101241086a0541000b2100200141106a240020000b0c00200020012002411c10270bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001102f20012003280208200328020c103036020c20032001102f410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b200020062802002004411410271a200341106a24000f0b20032001102f41002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b2105200120043602142001200536021020032006410020052004103010482001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b980101037f200028020445044041000f0b20001018200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bd50101047f200110282204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b41002103200120046a20024b0d0020022001490d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b0e002000101f410147044010000b0b800301087f230041306b2207240020004200370218200042a3e186fee9ae96ea083703102000410036020820004200370200200041206a4100360200200741186a1022220320002903101029200328020c200341106a28020047044010000b200041186a21050240200328020022062003280204220810072204450d002004101321020340200120026a41003a00002004200141016a2201470d000b20062008200220011008417f460440410021010c010b2007200241016a200120026a2002417f736a101620051020200421010b200328020c22020440200320023602100b024020010d002000411c6a210120002802042203200028020022046b41037522062000280220200028021822026b4103754d04402006200128020020026b41037522054b04402004200420054103746a22052002102a1a20052003200110100c020b2001200420032002102a3602000c010b2002044020004100360220200042003702180b200520052006102b100f20042003200110100b200741306a240020000b9c03010a7f230041406a22022400200241086a10222103200241386a4100360200200241306a4200370300200241286a420037030020024200370320200241206a20002903104200102c20022802202101200241206a410472102d200320011024200320002903101029200328020c200341106a28020047044010000b2003280204210520032802002106200241206a10222101200041186a22071023210841011013220441fe013a0000200128020c200141106a28020047044010000b2001280204220941016a220a20012802084b047f2001200a102e20012802040520090b20012802006a2004410110121a2001200128020441016a3602042001200441016a200820046b6a10242001200710250240200128020c2001280210460440200128020021040c010b100020012802002104200128020c2001280210460d0010000b20062005200420012802041009200128020c22040440200120043602100b200328020c22010440200320013602100b2000280218220104402000411c6a20013602000b200028020022010440200020013602040b200241406b24000b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a2000102f200128020c210003402000450d01200141002001280208220320032000103022046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020bf30302077f017e230041e0006b22042400024002402000280204450d0020002802002d000041c001490d002000101f21022001280208200128020022036b41037520024904402001200441106a2002200128020420036b410375200141086a103122021032200210330b200441386a2000410110342102200441286a2000410010342106200141086a210720022802042100034020062802042000464100200228020822032006280208461b0d022004200441106a20002003411c10271035200441086a290300423f862004290300220942018884420020094201837d8521090240200128020422002001280208490440200020093703002001200041086a3602040c010b200441c8006a2001200020012802006b410375220041016a102b20002007103121002004280250220320093703002004200341086a360250200120001032200010330b20022002280204220020022802086a410020001b22003602042002280200220304402002200336020820002003103021052002027f200228020422004504404100210341000c010b410021034100200228020822082005490d001a200820052005417f461b210320000b2200ad2003ad42208684370204200241002002280200220520036b2203200320054b1b3602000c0105200241003602080c010b000b000b10000b200441e0006a24000b6002017f017e230041306b22022400200241186a200028020020002802042802001017200241086a200241186a1035200120022903082203420188420020034201837d853e020020002802042200200028020041016a360200200241306a24000b2900200041003602082000420037020020004100102e200041146a41003602002000420037020c20000bba0102027f027e230041206b22012400200141186a4100360200200141106a4200370300200141086a420037030020014200370300027f200028020020002802044604402001410136020041010c010b2001410010362000280204210220002802002100037f2000200246047f2001410110362001280200052001200029030022034201862003423f8722048520044201862003423f8884200485102c200041086a21000c010b0b0b21002001410472102d200141206a240020000b13002000280208200149044020002001102e0b0bf60202067f027e0240200128020420012802006b220204402002410375210220002802042106200041106a2802002203200041146a280200220449044020032002ad2006ad422086843702002000200028021041086a3602100c020b027f41002003200028020c22056b410375220741016a2203200420056b2204410275220520052003491b41ffffffff01200441037541ffffffff00491b2205450d001a200541037410130b2103200320074103746a22042002ad2006ad4220868437020020042000280210200028020c22076b22026b2106200320054103746a2103200441086a2104200241014e044020062007200210121a0b20002003360214200020043602102000200636020c0c010b200041001001200028020422026a103741004100200220002802006a1002200010380b20012802042102200128020021010340200120024704402000200129030022084201862008423f8722098520094201862008423f88842009851039200141086a21010c010b0b0b880101037f419408410136020041980828020021000340200004400340419c08419c082802002201417f6a220236020020014101484504404194084100360200200020024102746a22004184016a280200200041046a280200110200419408410136020041980828020021000c010b0b419c084120360200419808200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104620024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104620024d0d0020034104710440100020000f0b200042003702000b20000bff0201037f200028020445044041000f0b2000101841012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b0a0020002001420010390b2501017f200120006b220141037521032001044020022000200110440b200220034103746a0b3101017f2001200028020820002802006b2200410275220220022001491b41ffffffff01200041037541ffffffff00491b0b890101027f4101210420014280015441002002501b450440034020012002845045044020024238862001420888842101200341016a2103200242088821020c010b0b200341384f047f2003103d20036a0520030b41016a21040b200041186a28020022030440200041086a280200200041146a2802002003103a21000b2000200028020020046a3602000bea0101047f230041106b22042400200028020422012000280210220241087641fcffff07716a2103027f410020012000280208460d001a2003280200200241ff07714102746a0b2101200441086a20001043200428020c210203400240200120024604402000410036021420002802082103200028020421010340200320016b41027522024103490d022000200141046a22013602040c000b000b200141046a220120032802006b418020470d0120032802042101200341046a21030c010b0b2002417f6a220241014d04402000418004418008200241016b1b3602100b20002001103c200441106a24000b2f01017f2000280208200149044020011015200028020020002802041012210220002001360208200020023602000b0b2101017f20011028220220012802044b044010000b2000200120011047200210480b2701017f230041206b22022400200241086a200020014114102710462100200241206a240020000b4c01017f2000410036020c200041106a2003360200200104402001101121040b200020043602002000200420024103746a22023602082000200420014103746a36020c2000200236020420000b870101037f200120012802042000280204200028020022046b22036b2202360204200341004a044020022004200310121a200128020421020b200028020021032000200236020020012003360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2b01027f20002802082101200028020421020340200120024704402000200141786a22013602080c010b0b0be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001102f20004100200428020c2201200428020822022001103022032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b9e0102027f027e230041106b22022400200110180240024020011019450d002001280204450d0020012802002d000041c001490d010b10000b200241086a2001101a200228020c220141114f044010000b20022802082103034020010440200542088620044238888421052001417f6a210120033100002004420886842104200341016a21030c010b0b2000200437030020002005370308200241106a24000bc10c02077f027e230041306b22042400200041046a2107024020014101460440200041086a280200200041146a280200200041186a22022802002203103a280200210120022003417f6a3602002007103b4180104f044020072000410c6a280200417c6a103c0b200141384f047f2001103d20016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002103a21000c010b02402007103b0d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021032001200241046a360200200420033602182007200441186a103e0c010b2000410c6a2802002202200041086a2802006b4102752203200041106a2205280200220620002802046b220141027549044041802010132105200220064704400240200028020c220120002802102202470d0020002802082203200028020422064b04402000200320012003200320066b41027541016a417e6d41027422026a103f220136020c2000200028020820026a3602080c010b200441186a200220066b2201410175410120011b22012001410276200041106a10402102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021041200028020c21010b200120053602002000200028020c41046a36020c0c020b02402000280208220120002802042202470d00200028020c2203200028021022064904402000200120032003200620036b41027541016a41026d41027422026a104222013602082000200028020c20026a36020c0c010b200441186a200620026b2201410175410120011b2201200141036a410276200041106a10402102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021041200028020821010b2001417c6a2005360200200020002802082201417c6a22023602082002280200210220002001360208200420023602182007200441186a103e0c010b20042001410175410120011b200320051040210241802010132106024020022802082201200228020c2203470d0020022802042205200228020022084b04402002200520012005200520086b41027541016a417e6d41027422036a103f22013602082002200228020420036a3602040c010b200441186a200320086b2201410175410120011b22012001410276200241106a280200104021032002280208210520022802042101034020012005470440200328020820012802003602002003200328020841046a360208200141046a21010c010b0b20022902002109200220032902003702002003200937020020022902082109200220032902083702082003200937020820031041200228020821010b200120063602002002200228020841046a360208200028020c2105034020002802082005460440200028020421012000200228020036020420022001360200200228020421012002200536020420002001360208200029020c21092000200229020837020c2002200937020820021041052005417c6a210502402002280204220120022802002203470d0020022802082206200228020c22084904402002200120062006200820066b41027541016a41026d41027422036a104222013602042002200228020820036a3602080c010b200441186a200820036b2201410175410120011b2201200141036a4102762002280210104021062002280208210320022802042101034020012003470440200428022020012802003602002004200428022041046a360220200141046a21010c010b0b20022902002109200220042903183702002002290208210a20022004290320370208200420093703182004200a37032020061041200228020421010b2001417c6a200528020036020020022002280204417c6a3602040c010b0b0b200441186a20071043200428021c4100360200200041186a2100410121010b2000200028020020016a360200200441306a24000b3601017f2000280208200149044020011015200028020020002802041012210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210016a1037200120002802006a22012002200110020c010b0b0b2801017f2000200220011003200028020422036a103720022001200320002802006a1004200010380b25002000200120026a417f6a220241087641fcffff07716a280200200241ff07714102746a0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010ba10202057f017e230041206b22052400024020002802082202200028020c2203470d0020002802042204200028020022064b04402000200420022004200420066b41027541016a417e6d41027422036a103f22023602082000200028020420036a3602040c010b200541086a200320066b2202410175410120021b220220024102762000410c6a10402103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b20002902002107200020032902003702002003200737020020002902082107200020032902083702082003200737020820031041200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110440b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274101321040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b22022000200110440b20020b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b8d0301037f024020002001460d00200120006b20026b410020024101746b4d044020002001200210121a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2105200020036a2204410371450440200220036b210241002103034020024104490d04200320046a200320056a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200420052d00003a0000200341016a21030c000b000b024020030d002001417f6a21040340200020026a22034103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042003417f6a200220046a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320056a2101200320046a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b3501017f230041106b220041b0880436020c41a008200028020c41076a417871220036020041a408200036020041a8083f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001047200010286a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b0b1a01004180080b13696e697400736f7274006765745f6172726179";

    public static String BINARY = BINARY_0;

    public static final String FUNC_SORT = "sort";

    public static final String FUNC_GET_ARRAY = "get_array";

    protected MergeSort(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected MergeSort(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<MergeSort> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MergeSort.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<MergeSort> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MergeSort.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<MergeSort> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MergeSort.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<MergeSort> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MergeSort.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> sort(Int64[] arr, Int32 start, Int32 end) {
        final WasmFunction function = new WasmFunction(FUNC_SORT, Arrays.asList(arr,start,end), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> sort(Int64[] arr, Int32 start, Int32 end, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_SORT, Arrays.asList(arr,start,end), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Int64[]> get_array() {
        final WasmFunction function = new WasmFunction(FUNC_GET_ARRAY, Arrays.asList(), Int64[].class);
        return executeRemoteCall(function, Int64[].class);
    }

    public static MergeSort load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new MergeSort(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static MergeSort load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new MergeSort(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
