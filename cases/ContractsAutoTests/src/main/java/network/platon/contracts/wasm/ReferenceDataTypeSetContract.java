package network.platon.contracts.wasm;

import com.platon.abi.wasm.WasmFunctionEncoder;
import com.platon.abi.wasm.datatypes.WasmFunction;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.protocol.core.methods.response.TransactionReceipt;
import com.platon.rlp.wasm.datatypes.Uint64;
import com.platon.rlp.wasm.datatypes.Uint8;
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
public class ReferenceDataTypeSetContract extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001591060017f017f60027f7f0060017f0060037f7f7f017f60000060037f7f7f0060047f7f7f7f0060027f7f017f60047f7f7f7f017f60027f7e0060037e7e7f006000017f60027f7e017f60017e017f60027e7e017f60017f017e02fd010b03656e760c706c61746f6e5f70616e6963000403656e760d726c705f6c6973745f73697a65000003656e760f706c61746f6e5f726c705f6c697374000503656e760d726c705f753132385f73697a65000e03656e760f706c61746f6e5f726c705f75313238000a03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000b03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000703656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000603656e760d706c61746f6e5f72657475726e00010348470402020000030605010200000701000202020000040003050200010f01010200000d010902010201090c04080000000307030101030102010100030001030802030501040000060405017001070705030100020608017f01418089040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000b0f5f5f66756e63735f6f6e5f65786974003506696e766f6b65001f090c010041010b060c0d1314181c0ab45d470400104e0b0300010be00101057f230041106b22022400200241850c3b000620024181848c20360002200041186a21030240200041206a280200450440200241026a21000c010b2003100e210103400240200241026a20046a21002001450d0020044106460d00200120002d00003a000d2001100f21002003200241086a2001410d6a10102205280200450440200320022802082005200110110b200441016a2104200021010c010b0b2001450d000340200128020822010d000b0b200241086a210103402000200146450440200241086a200320001012200041016a21000c010b0b200241106a24000b3d01027f200028020021012000200041046a3602002000410036020820002802042102200041003602042002410036020820012802042200200120001b0b4c01027f2000280208220145044041000f0b02402000200128020022024604402001410036020020012802042200450d012000101e0f0b200141003602042002450d002002101e21010b20010b8d0101027f200041046a2103024020002802042200044020022d000021040240034002400240200420002d000d2202490440200028020022020d012001200036020020000f0b200220044f0d03200041046a210320002802042202450d01200321000b20002103200221000c010b0b2001200036020020030f0b200120003602000c010b200120033602000b20030baf0201027f20032001360208200342003702002002200336020020002802002802002201044020002001360200200228020021030b2003200320002802042205463a000c03400240024020032005460d00200328020822012d000c0d002001200128020822022802002204460440024020022802042204450d0020042d000c0d002004410c6a21030c030b200320012802004704402001101a2001280208220128020821020b200141013a000c200241003a000c2002101b0c010b02402004450d0020042d000c0d002004410c6a21030c020b200320012802004604402001101b2001280208220128020821020b200141013a000c200241003a000c2002101a0b2000200028020841016a3602080f0b200141013a000c200220022005463a000c200341013a0000200221030c000b000b5501037f230041106b22032400200020012003410c6a2002101022052802002204047f4100054110101d220420022d00003a000d2001200328020c20052004101141010b3a000420002004360200200341106a24000b2201017f230041106b22022400200241086a200041186a20011012200241106a24000b2501017f2000411c6a2101200028021821000340200020014704402000101521000c010b0b0b3401017f02402000280204220104402001101921010c010b0340200028020822012802002000460d01200121000c000b000b20010b2601017f027f4100200041186a4103101722012000411c6a460d001a20012d000d0b41ff01710b6401057f200141ff01712105200041046a22032104200321020340200428020022000440200041046a200020002d000d20054922061b21042002200020061b21020c010b0b02402002200347044020022d000d200141ff01714d0d010b200321020b20020bd30601067f0240200041186a220320012d0000101722022000411c6a460d00200220032802004604402003200210153602000b200041206a22012001280200417f6a3602002000411c6a2802002103027f0240024020022802002204450440200221010c010b20022802042200450440200221010c020b20001019220128020022040d010b200128020422040d004100210441000c010b2004200128020836020841010b210702402001200128020822062802002200460440200620043602002001200346044041002100200421030c020b200628020421000c010b200620043602040b20012d000c210620012002470440200120022802082205360208200520022802082802002002474102746a20013602002002280200220520013602082001200536020020012002280204220536020420050440200520013602080b200120022d000c3a000c2001200320022003461b21030b200641ff0171450d002003450d002007450440034020002d000c2101024020002000280208220228020047044002400240200141ff0171450440200041013a000c200241003a000c2002101a20002003200320002802002201461b2103200128020421000b20002802002202044020022d000c450d010b20002802042201044020012d000c450d020b200041003a000c0240200320002802082200460440200321000c010b20002d000c0d040b200041013a000c0f0b20002802042201044020012d000c450d010b200241013a000c200041003a000c2000101b2000280208220028020421010b2000200028020822022d000c3a000c200241013a000c200141013a000c2002101a0f0b0240200141ff0171450440200041013a000c200241003a000c2002101b20002003200320002802042201461b2103200128020021000b20002802002201044020012d000c450d010b024020002802042202044020022d000c450d010b200041003a000c20032000280208220047044020002d000c0d030b200041013a000c0f0b2001044020012d000c450d010b200241013a000c200041003a000c2000101a2000280208220028020021010b2000200028020822022d000c3a000c200241013a000c200141013a000c2002101b0f0b2000280208220120012802002000464102746a28020021000c000b000b200441013a000c0b0b1401017f03402000220128020022000d000b20010b5101027f200020002802042201280200220236020420020440200220003602080b200120002802083602082000280208220220022802002000474102746a200136020020002001360208200120003602000b5101027f200020002802002201280204220236020020020440200220003602080b200120002802083602082000280208220220022802002000474102746a200136020020002001360208200120003602040b150020002000411c6a2200360218200042003702000b0b002000410120001b10200b1d01017f03402000220128020022000d00200128020422000d000b20010b860602057f017e23004180016b22002400104e10052201102022031006200041d8006a200041086a200320011021220241001022200041d8006a102302400240200041d8006a1024450d00200028025c450d0020002802582d000041c001490d010b10000b200041386a200041d8006a1025200028023c220141094f044010000b200028023821030340200104402001417f6a210120033100002005420886842105200341016a21030c010b0b024002402005500d00418008102620055104402002410110270c020b418508102620055104402002410210270c020b418e08102620055104402002410310280c020b4199081026200551044020021029200041d8006a102a2103200041f8006a3502002105200041386a102b22012005102c102d20012005102e200128020c200141106a28020047044010000b20012802002001280204100a200128020c22020440200120023602100b2003102f0c020b41a608102620055104402002410410270c020b41b3081026200551044020021029200041d8006a102a2102200041d8006a10162103200041206a102b2101200041d0006a4100360200200041c8006a4200370300200041406b420037030020004200370338200041386a2003103020002802382104200041386a410472103120012004102d200120031032200128020c200141106a28020047044010000b20012802002001280204100a200128020c22030440200120033602100b2002102f0c020b41bc08102620055104402002410510280c020b41c6081026200551044020021029200041d8006a102a2103200041f8006a2802002102200041206a102b2101200041d0006a4100360200200041c8006a4200370300200041406b420037030020004200370338200041386a200245ad2205103320002802382102200041386a410472103120012002102d200120051034220128020c200141106a28020047044010000b20012802002001280204100a200128020c22020440200120023602100b2003102f0c020b41d40810262005520d002002410610270c010b10000b103520004180016a24000b9b0101047f230041106b220124002001200036020c2000047f41f408200041086a2202411076220041f4082802006a220336020041f00841f008280200220420026a41076a417871220236020002400240200341107420024d044041f408200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104103f41086a0541000b2100200141106a240020000b0c00200020012002411c10360bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001104d20012003280208200328020c103b36020c20032001104d410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b200020062802002004411410361a200341106a24000f0b20032001104d41002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b2105200120043602142001200536021020032006410020052004103b10512001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b980101037f200028020445044041000f0b20001023200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bd50101047f200110372204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b41002103200120046a20024b0d0020022001490d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b2f01017f230041306b2202240020001029200241086a102a2100200241086a20011102002000102f200241306a24000b4b01027f230041306b2202240020001038410247044010000b20022000410110222002103921002002102a2103200220003a002f20022002412f6a20011101002003102f200241306a24000b0e0020001038410147044010000b0be605010b7f230041f0006b2205240020004200370204200042c2c285f3c4ee90c6e4003703102000411c6a220142003702002000200041046a220a36020020002001360218200541186a102b22082000290310102e200828020c200841106a28020047044010000b200041186a210602400240200828020022032008280204220910072204450d002004101d2102410021010340200120026a41003a00002004200141016a2201470d000b20032009200220011008417f460d0002402005200241016a200120026a2002417f736a10212202280204450d0020022802002d000041c001490d00200541e0006a20024101103a2101200541d0006a20024100103a210920012802042102034020092802042002464100200128020822032009280208461b0d032005200541386a20022003411c1036103922023a00372006200541ec006a200541376a101022032802004504404110101d220720023a000d2006200528026c2003200710110b20012001280204220220012802086a410020021b22023602042001280200220304402001200336020820022003103b21072001027f200128020422024504404100210341000c010b4100210341002001280208220b2007490d001a200b20072007417f461b210320020b2202ad2003ad42208684370204200141002001280200220720036b2203200320074b1b3602000c0105200141003602080c010b000b000b10000c010b410021040b200828020c22010440200820013602100b024020040d002000280200210102402000280220450d002006100e210403402004450d012001200a470440200420012d000d3a000d2004100f21022006200541386a2004410d6a103c210320062005280238200320041011200110152101200221040c010b0b0340200428020822040d000b200a21010b03402001200a460d014110101d220420012d000d3a000d2006200541386a2004410d6a103c2102200620052802382002200410112001101521010c000b000b200541f0006a240020000b2900200041003602082000420037020020004100103d200041146a41003602002000420037020c20000b4f01027f230041206b22012400200141186a4100360200200141106a4200370300200141086a4200370300200142003703002001200010332001280200210220014104721031200141206a240020020b13002000280208200149044020002001103d0b0b09002000200110341a0bfd05010b7f230041d0006b22032400200341186a102b22082000290310102c102d20082000290310102e200828020c200841106a28020047044010000b2008280204210a2008280200210b2003102b2101200341c8006a4100360200200341406b4200370300200341386a420037030020034200370330027f200041206a2802004504402003410136023041010c010b200341306a4100103e2000411c6a210420002802182102037f2002200446047f200341306a4101103e200328023005200341306a20022d000d10302002101521020c010b0b0b2106200341306a41047210314101101d220241fe013a0000200128020c200141106a28020047044010000b200241016a21052001280204220441016a220720012802084b047f20012007103d20012802040520040b20012802006a20024101103f1a2001200128020441016a3602042001200620026b20056a102d02402000280220220204402001280204210420012802102205200141146a280200220649044020052002ad2004ad422086843702002001200128021041086a3602100c020b027f41002005200128020c22076b410375220941016a2205200620076b2206410275220720072005491b41ffffffff01200641037541ffffffff00491b2207450d001a2007410374101d0b2105200520094103746a22062002ad2004ad4220868437020020062001280210200128020c22096b22026b2104200520074103746a2105200641086a2106200241014e0440200420092002103f1a0b20012005360214200120063602102001200436020c0c010b200141001001200128020422026a104041004100200220012802006a1002200110410b2000411c6a210420002802182102034020022004470440200120022d000d10322002101521020c010b0b0240200128020c2001280210460440200128020021020c010b100020012802002102200128020c2001280210460d0010000b200b200a200220012802041009200128020c22020440200120023602100b200828020c22020440200820023602100b200341d0006a24000b090020002001ad10330bea0101047f230041106b22042400200028020422012000280210220241087641fcffff07716a2103027f410020012000280208460d001a2003280200200241ff07714102746a0b2101200441086a20001042200428020c210203400240200120024604402000410036021420002802082103200028020421010340200320016b41027522024103490d022000200141046a22013602040c000b000b200141046a220120032802006b418020470d0120032802042101200341046a21030c010b0b2002417f6a220241014d04402000418004418008200241016b1b3602100b200020011043200441106a24000b0a0020002001ad10341a0b840102027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002104420026a0520020b41016a21030b200041186a28020022020440200041086a280200200041146a2802002002104521000b2000200028020020036a3602000b2a01017f2000420020011003200028020422026a104042002001200220002802006a10042000104120000b880101037f41e008410136020041e4082802002100034020000440034041e80841e8082802002201417f6a2202360200200141014845044041e0084100360200200020024102746a22004184016a280200200041046a28020011020041e008410136020041e40828020021000c010b0b41e808412036020041e408200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104f20024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104f20024d0d0020034104710440100020000f0b200042003702000b20000bff0201037f200028020445044041000f0b2000102341012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a2000104d200128020c210003402000450d01200141002001280208220320032000103b22046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020b7d01037f230041106b22012400200010230240024020001024450d002000280204450d0020002802002d000041c001490d010b10000b200141086a20001025200128020c220041024f044010000b200128020821020340200004402000417f6a210020022d00002103200241016a21020c010b0b200141106a240020030be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001104d20004100200428020c2201200428020822022001103b22032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b2701017f230041206b22022400200241086a2000200141141036104f2100200241206a240020000b6201017f024020002802042203044020022d0000210203400240200220032d000d49044020032802002200450d040c010b200328020422000d0020012003360200200341046a0f0b200021030c000b000b200041046a21030b2001200336020020030b2f01017f200028020820014904402001102020002802002000280204103f210220002001360208200020023602000b0bc10c02077f027e230041306b22042400200041046a2107024020014101460440200041086a280200200041146a280200200041186a220228020022031045280200210120022003417f6a360200200710464180104f044020072000410c6a280200417c6a10430b200141384f047f2001104420016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002104521000c010b0240200710460d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021032001200241046a360200200420033602182007200441186a10470c010b2000410c6a2802002202200041086a2802006b4102752203200041106a2205280200220620002802046b2201410275490440418020101d2105200220064704400240200028020c220120002802102202470d0020002802082203200028020422064b04402000200320012003200320066b41027541016a417e6d41027422026a1048220136020c2000200028020820026a3602080c010b200441186a200220066b2201410175410120011b22012001410276200041106a10492102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002104a200028020c21010b200120053602002000200028020c41046a36020c0c020b02402000280208220120002802042202470d00200028020c2203200028021022064904402000200120032003200620036b41027541016a41026d41027422026a104b22013602082000200028020c20026a36020c0c010b200441186a200620026b2201410175410120011b2201200141036a410276200041106a10492102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002104a200028020821010b2001417c6a2005360200200020002802082201417c6a22023602082002280200210220002001360208200420023602182007200441186a10470c010b20042001410175410120011b2003200510492102418020101d2106024020022802082201200228020c2203470d0020022802042205200228020022084b04402002200520012005200520086b41027541016a417e6d41027422036a104822013602082002200228020420036a3602040c010b200441186a200320086b2201410175410120011b22012001410276200241106a280200104921032002280208210520022802042101034020012005470440200328020820012802003602002003200328020841046a360208200141046a21010c010b0b2002290200210920022003290200370200200320093702002002290208210920022003290208370208200320093702082003104a200228020821010b200120063602002002200228020841046a360208200028020c2105034020002802082005460440200028020421012000200228020036020420022001360200200228020421012002200536020420002001360208200029020c21092000200229020837020c200220093702082002104a052005417c6a210502402002280204220120022802002203470d0020022802082206200228020c22084904402002200120062006200820066b41027541016a41026d41027422036a104b22013602042002200228020820036a3602080c010b200441186a200820036b2201410175410120011b2201200141036a4102762002280210104921062002280208210320022802042101034020012003470440200428022020012802003602002004200428022041046a360220200141046a21010c010b0b20022902002109200220042903183702002002290208210a20022004290320370208200420093703182004200a3703202006104a200228020421010b2001417c6a200528020036020020022002280204417c6a3602040c010b0b0b200441186a20071042200428021c4100360200200041186a2100410121010b2000200028020020016a360200200441306a24000bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b3601017f200028020820014904402001102020002802002000280204103f210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210016a1040200120002802006a22012002200110020c010b0b0b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b25002000200120026a417f6a220241087641fcffff07716a280200200241ff07714102746a0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0ba10202057f017e230041206b22052400024020002802082202200028020c2203470d0020002802042204200028020022064b04402000200420022004200420066b41027541016a417e6d41027422036a104822023602082000200028020420036a3602040c010b200541086a200320066b2202410175410120021b220220024102762000410c6a10492103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b2000290200210720002003290200370200200320073702002000290208210720002003290208370208200320073702082003104a200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b2201410275210320010440200220002001104c0b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274101d21040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b220220002001104c0b20020b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002103f1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2105200020036a2204410371450440200220036b210241002103034020024104490d04200320046a200320056a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200420052d00003a0000200341016a21030c000b000b024020030d002001417f6a21040340200020026a22034103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042003417f6a200220046a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320056a2101200320046a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b2101017f20011037220220012802044b044010000b2000200120011050200210510b3501017f230041106b22004180890436020c41ec08200028020c41076a417871220036020041f008200036020041f4083f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001050200010376a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b0b6401004180080b5d696e697400696e69745f73657400696e736572745f736574006765745f7365745f73697a65006974657261746f725f7365740066696e645f7365740065726173655f736574006765745f7365745f656d70747900636c6561725f736574";

    public static String BINARY = BINARY_0;

    public static final String FUNC_ITERATOR_SET = "iterator_set";

    public static final String FUNC_INIT_SET = "init_set";

    public static final String FUNC_INSERT_SET = "insert_set";

    public static final String FUNC_FIND_SET = "find_set";

    public static final String FUNC_ERASE_SET = "erase_set";

    public static final String FUNC_GET_SET_EMPTY = "get_set_empty";

    public static final String FUNC_CLEAR_SET = "clear_set";

    public static final String FUNC_GET_SET_SIZE = "get_set_size";

    protected ReferenceDataTypeSetContract(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected ReferenceDataTypeSetContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public RemoteCall<TransactionReceipt> iterator_set() {
        final WasmFunction function = new WasmFunction(FUNC_ITERATOR_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> iterator_set(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_ITERATOR_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public static RemoteCall<ReferenceDataTypeSetContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeSetContract.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<ReferenceDataTypeSetContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeSetContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<ReferenceDataTypeSetContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeSetContract.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<ReferenceDataTypeSetContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeSetContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> init_set() {
        final WasmFunction function = new WasmFunction(FUNC_INIT_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> init_set(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_INIT_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<TransactionReceipt> insert_set(Uint8 value) {
        final WasmFunction function = new WasmFunction(FUNC_INSERT_SET, Arrays.asList(value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> insert_set(Uint8 value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_INSERT_SET, Arrays.asList(value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Uint8> find_set() {
        final WasmFunction function = new WasmFunction(FUNC_FIND_SET, Arrays.asList(), Uint8.class);
        return executeRemoteCall(function, Uint8.class);
    }

    public RemoteCall<TransactionReceipt> erase_set(Uint8 value) {
        final WasmFunction function = new WasmFunction(FUNC_ERASE_SET, Arrays.asList(value), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> erase_set(Uint8 value, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_ERASE_SET, Arrays.asList(value), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Boolean> get_set_empty() {
        final WasmFunction function = new WasmFunction(FUNC_GET_SET_EMPTY, Arrays.asList(), Boolean.class);
        return executeRemoteCall(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> clear_set() {
        final WasmFunction function = new WasmFunction(FUNC_CLEAR_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> clear_set(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_CLEAR_SET, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Uint64> get_set_size() {
        final WasmFunction function = new WasmFunction(FUNC_GET_SET_SIZE, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public static ReferenceDataTypeSetContract load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new ReferenceDataTypeSetContract(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static ReferenceDataTypeSetContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new ReferenceDataTypeSetContract(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
