package network.platon.contracts.wasm;

import com.platon.abi.wasm.WasmFunctionEncoder;
import com.platon.abi.wasm.datatypes.WasmFunction;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.protocol.core.methods.response.TransactionReceipt;
import com.platon.rlp.wasm.datatypes.Uint32;
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
public class ReferenceDataTypeArrayFuncContract extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001540f60027f7f0060017f017f60017f0060037f7f7f0060000060037f7f7f017f60027f7f017f60047f7f7f7f017f60047f7f7f7f0060027f7e0060037e7e7f006000017f60027f7e017f60027e7e017f60017f017e02a9020d03656e760c706c61746f6e5f70616e6963000403656e760d726c705f6c6973745f73697a65000103656e760f706c61746f6e5f726c705f6c697374000303656e760e726c705f62797465735f73697a65000603656e7610706c61746f6e5f726c705f6279746573000303656e760d726c705f753132385f73697a65000d03656e760f706c61746f6e5f726c705f75313238000a03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000b03656e7610706c61746f6e5f6765745f696e707574000203656e7617706c61746f6e5f6765745f73746174655f6c656e677468000603656e7610706c61746f6e5f6765745f7374617465000703656e7610706c61746f6e5f7365745f7374617465000803656e760d706c61746f6e5f72657475726e000003414004020200060000040105030201000e000201010902000c02010201000407010102090101000001050000000005000200020100050702050304030301010806000405017001030305030100020608017f01418089040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000d0f5f5f66756e63735f6f6e5f65786974002906696e766f6b6500140908010041010b020e0f0aeb5240040010450b0300010b390020004180016a41800810102000418c016a418208101020004198016a4184081010200041a4016a4186081010200041b0016a41880810100b7e01027f20012102024003402002410371044020022d0000450d02200241016a21020c010b0b2002417c6a21020340200241046a22022802002203417f73200341fffdfb776a7141808182847871450d000b0340200341ff0171450d01200241016a2d00002103200241016a21020c000b000b20002001200220016b10470ba10101037f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b20012802082103024020012802042201410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712204102f21022000200136020420002004410172360200200020023602080b2002200320011046200120026a41003a000020000b2f01017f20004180016a2102410021000340200041f80046450440200020026a200110132000410c6a21000c010b0b0b3401017f2000200147044020002001280208200141016a20012d0000220041017122021b2001280204200041017620021b10470b0bf20502047f017e230041e0026b22002400104510072201101522031008200041d8006a200041086a200320011016220241001017200041d8006a101802400240200041d8006a1019450d00200028025c450d0020002802582d000041c001490d010b10000b200041386a200041d8006a101a200028023c220141094f044010000b200028023821030340200104402001417f6a210120033100002004420886842104200341016a21030c010b0b024002402004500d00418a08101b200451044020024101101c0c020b418f08101b200451044020024102101c0c020b41a008101b20045104402002101d200041d8006a101e2103200041206a101f2101200041d0006a4100360200200041c8006a4200370300200041406b420037030020004200370338200041386a4200102020002802382102200041386a4104721021200120021022200142001023220128020c200141106a28020047044010000b20012802002001280204100c200128020c22020440200120023602100b200310240c020b41b008101b200451044020021025410247044010000b200041d8006a200241011017200041d8006a101802400240200041d8006a1019450d00200028025c450d0020002802582d000041c001490d010b10000b200041386a200041d8006a101a200028023c220141054f044010000b41002102200028023821030340200104402001417f6a210120032d00002002410874722102200341016a21030c010b0b200041d8006a101e210120002002360220200041386a2000200041206a280200410c6c6a41d8016a10111a200041386a1026200110240c020b41c308101b20045104402002101d200041d8006a101e2101200041386a200041d8016a10111026200110240c020b41d608101b2004520d00200041d0026a1027210120021025410247044010000b200041d8006a200241011017200041d8006a20011028200041d8006a101e2103200041d8006a200041386a200041206a2001101110111012200310240c010b10000b1029200041e0026a24000b9b0101047f230041106b220124002001200036020c2000047f41f808200041086a2202411076220041f8082802006a220336020041f40841f408280200220420026a41076a417871220236020002400240200341107420024d044041f808200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104103941086a0541000b2100200141106a240020000b0c00200020012002411c102a0bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001104c20012003280208200328020c104b36020c20032001104c410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b2000200628020020044114102a1a200341106a24000f0b20032001104c41002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b2105200120043602142001200536021020032006410020052004104b104a2001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b980101037f200028020445044041000f0b20001018200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0bd50101047f2001102b2204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b41002103200120046a20024b0d0020022001490d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b3101017f23004180026b220224002000101d200241086a101e2100200241086a20011102002000102420024180026a24000b0e0020001025410147044010000b0bf50201077f230041e0006b220224002000102c2203102d2003428aa4bedd86c3aeee5837037820034180016a102d200241206a101f22042003290378102e200428020c200441106a28020047044010000b0240200428020022062004280204220510092207450d002007102f21000340200020016a41003a00002007200141016a2201470d000b2006200520002001100a417f460440410021010c010b0240200241086a200041016a200020016a2000417f736a10162205280204044020052802002d000041bf014b0d010b10000b20051030410a47044010000b20034180016a21004100210103402001410a46450440200241d0006a10272106200241386a200520011017200241386a200610282000200610312000410c6a2100200141016a21010c010b0b200721010b200428020c22000440200420003602100b024020010d00410021010340200141f800460d01200120036a22004180016a200010132001410c6a21010c000b000b200241e0006a240020030b29002000410036020820004200370200200041001032200041146a41003602002000420037020c20000b840102027f017e4101210320014280015a0440034020012004845045044020044238862001420888842101200241016a2102200442088821040c010b0b200241384f047f2002103320026a0520020b41016a21030b200041186a28020022020440200041086a280200200041146a2802002002103421000b2000200028020020036a3602000bea0101047f230041106b22042400200028020422012000280210220241087641fcffff07716a2103027f410020012000280208460d001a2003280200200241ff07714102746a0b2101200441086a20001035200428020c210203400240200120024604402000410036021420002802082103200028020421010340200320016b41027522024103490d022000200141046a22013602040c000b000b200141046a220120032802006b418020470d0120032802042101200341046a21030c010b0b2002417f6a220241014d04402000418004418008200241016b1b3602100b200020011036200441106a24000b1300200028020820014904402000200110320b0b2a01017f2000420020011005200028020422026a103c42002001200220002802006a10062000103d20000bef05010b7f230041e0006b22032400200341186a101f2106200341c8006a22024100360200200341406b22044200370300200341386a2205420037030020034200370330200341306a2000290378102020032802302101200341306a410472102120062001102220062000290378102e200628020c200641106a28020047044010000b200628020421092006280200210a2003101f210120024100360200200442003703002005420037030020034200370330200341306a4100103741800121020340200241f801470440200341306a200341d0006a200020026a101110382002410c6a21020c010b0b200341306a4101103720032802302105200341306a41047210214101102f220241fe013a0000200128020c200141106a28020047044010000b200241016a21072001280204220441016a220820012802084b047f20012008103220012802040520040b20012802006a2002410110391a2001200128020441016a3602042001200520026b20076a102220012802042102024020012802102204200141146a280200220549044020042002ad422086420a843702002001200128021041086a3602100c010b027f41002004200128020c22076b410375220841016a2204200520076b2205410275220720072004491b41ffffffff01200541037541ffffffff00491b2207450d001a2007410374102f0b2104200420084103746a22052002ad422086420a8437020020052001280210200128020c220b6b22026b2108200420074103746a2104200541086a2105200241014e04402008200b200210391a0b20012004360214200120053602102001200836020c0b41800121020340200241f8014704402001200341306a200020026a1011103a2002410c6a21020c010b0b0240200128020c2001280210460440200128020021020c010b100020012802002102200128020c2001280210460d0010000b200a200920022001280204100b200128020c22020440200120023602100b200628020c22020440200620023602100b200341e0006a24000b2501017f02402000280204450d0020002802002d000041c001490d002000103021010b20010bab0101037f230041e0006b22012400200141186a101f2102200141d8006a4100360200200141d0006a4200370300200141c8006a420037030020014200370340200141406b200141306a20001011103820012802402103200141406b41047210212002200310222002200141086a20001011103a200228020c200241106a28020047044010000b20022802002002280204100c200228020c22000440200220003602100b200141e0006a24000b190020004200370200200041086a41003602002000103b20000ba10201057f230041206b22022400024002402000280204044020002802002d000041c001490d010b200241086a10271a0c010b200241186a2000101a2000102b21030240024002400240200228021822000440200228021c220520034f0d010b41002100200241106a410036020020024200370308410021050c010b200241106a4100360200200242003703082000200520032003417f461b22046a21052004410a4b0d010b200220044101743a0008200241086a41017221030c010b200441106a4170712206102f21032002200436020c20022006410172360208200220033602100b03402000200546450440200320002d00003a0000200341016a2103200041016a21000c010b0b200341003a00000b2001200241086a1031200241206a24000b880101037f41e408410136020041e8082802002100034020000440034041ec0841ec082802002201417f6a2202360200200141014845044041e4084100360200200020024102746a22004184016a280200200041046a28020011020041e408410136020041e80828020021000c010b0b41ec08412036020041e808200028020022003602000c010b0b0b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104820024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104820024d0d0020034104710440100020000f0b200042003702000b20000bff0201037f200028020445044041000f0b2000101841012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020bc90201037f200041003a0000200041f8006a2202417f6a41003a0000200041003a0002200041003a00012002417d6a41003a00002002417e6a41003a0000200041003a00032002417c6a41003a00002000410020006b41037122016a22024100360200200241f80020016b417c7122016a2203417c6a4100360200024020014109490d002002410036020820024100360204200341786a4100360200200341746a410036020020014119490d002002410036021820024100360214200241003602102002410036020c200341706a41003602002003416c6a4100360200200341686a4100360200200341646a41003602002001200241047141187222016b2103200120026a2101034020034120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200341606a21030c000b000b20000b2601027f200041f8006a210103402000102721022000410c6a21002002410c6a2001470d000b0b09002000200110231a0b0b002000410120001b10150b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a2000104c200128020c210003402000450d01200141002001280208220320032000104b22046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020b5b00024020002d0000410171450440200041003b01000c010b200028020841003a00002000410036020420002d0000410171450d00200041003602000b20002001290200370200200041086a200141086a2802003602002001103b0b2f01017f2000280208200149044020011015200028020020002802041039210220002001360208200020023602000b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b25002000200120026a417f6a220241087641fcffff07716a280200200241ff07714102746a0b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0bc10c02077f027e230041306b22042400200041046a2107024020014101460440200041086a280200200041146a280200200041186a220228020022031034280200210120022003417f6a3602002007103e4180104f044020072000410c6a280200417c6a10360b200141384f047f2001103320016a0520010b41016a2101200041186a2802002202450d01200041086a280200200041146a2802002002103421000c010b02402007103e0d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021032001200241046a360200200420033602182007200441186a103f0c010b2000410c6a2802002202200041086a2802006b4102752203200041106a2205280200220620002802046b2201410275490440418020102f2105200220064704400240200028020c220120002802102202470d0020002802082203200028020422064b04402000200320012003200320066b41027541016a417e6d41027422026a1040220136020c2000200028020820026a3602080c010b200441186a200220066b2201410175410120011b22012001410276200041106a10412102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021042200028020c21010b200120053602002000200028020c41046a36020c0c020b02402000280208220120002802042202470d00200028020c2203200028021022064904402000200120032003200620036b41027541016a41026d41027422026a104322013602082000200028020c20026a36020c0c010b200441186a200620026b2201410175410120011b2201200141036a410276200041106a10412102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c2002200937020820021042200028020821010b2001417c6a2005360200200020002802082201417c6a22023602082002280200210220002001360208200420023602182007200441186a103f0c010b20042001410175410120011b2003200510412102418020102f2106024020022802082201200228020c2203470d0020022802042205200228020022084b04402002200520012005200520086b41027541016a417e6d41027422036a104022013602082002200228020420036a3602040c010b200441186a200320086b2201410175410120011b22012001410276200241106a280200104121032002280208210520022802042101034020012005470440200328020820012802003602002003200328020841046a360208200141046a21010c010b0b20022902002109200220032902003702002003200937020020022902082109200220032902083702082003200937020820031042200228020821010b200120063602002002200228020841046a360208200028020c2105034020002802082005460440200028020421012000200228020036020420022001360200200228020421012002200536020420002001360208200029020c21092000200229020837020c2002200937020820021042052005417c6a210502402002280204220120022802002203470d0020022802082206200228020c22084904402002200120062006200820066b41027541016a41026d41027422036a104322013602042002200228020820036a3602080c010b200441186a200820036b2201410175410120011b2201200141036a4102762002280210104121062002280208210320022802042101034020012003470440200428022020012802003602002004200428022041046a360220200141046a21010c010b0b20022902002109200220042903183702002002290208210a20022004290320370208200420093703182004200a37032020061042200228020421010b2001417c6a200528020036020020022002280204417c6a3602040c010b0b0b200441186a20071035200428021c4100360200200041186a2100410121010b2000200028020020016a360200200441306a24000b9a0101037f41012103024002400240200128020420012d00002202410176200241017122041b220241014d0440200241016b0d032001280208200141016a20041b2c0000417f4c0d010c030b200241374b0d010b200241016a21030c010b2002103320026a41016a21030b200041186a28020022010440200041086a280200200041146a2802002001103421000b2000200028020020036a3602000bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b4c01037f20002001280208200141016a20012d0000220241017122031b22042001280204200241017620031b22011003200028020422026a103c20042001200220002802006a10042000103d0b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b3601017f2000280208200149044020011015200028020020002802041039210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210016a103c200120002802006a22012002200110020c010b0b0b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0ba10202057f017e230041206b22052400024020002802082202200028020c2203470d0020002802042204200028020022064b04402000200420022004200420066b41027541016a417e6d41027422036a104022023602082000200028020420036a3602040c010b200541086a200320066b2202410175410120021b220220024102762000410c6a10412103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b20002902002107200020032902003702002003200737020020002902082107200020032902083702082003200737020820031042200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110440b200220034102746a0b4f01017f2000410036020c200041106a2003360200200104402001410274102f21040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000b2b01027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b0b1b00200120006b22010440200220016b22022000200110440b20020b8d0301037f024020002001460d00200120006b20026b410020024101746b4d044020002001200210391a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2105200020036a2204410371450440200220036b210241002103034020024104490d04200320046a200320056a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200420052d00003a0000200341016a21030c000b000b024020030d002001417f6a21040340200020026a22034103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042003417f6a200220046a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320056a2101200320046a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b3501017f230041106b22004180890436020c41f008200028020c41076a417871220036020041f408200036020041f8083f003602000b10002002044020002001200210391a0b0bd40101027f410a210320002d0000410171220404402000280200417e71417f6a21030b200320024f0440027f2004044020002802080c010b200041016a0b21032002044020032001200210440b200220036a41003a000020002d00004101710440200020023602040f0b200020024101743a00000f0b416f2104200341e6ffffff074d0440410b200341017422032002200320024b1b220341106a4170712003410b491b21040b2004102f2203200120021046200020023602042000200441017236020020002003360208200220036a41003a00000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f200010492000102b6a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000b2701017f230041206b22022400200241086a200020014114102a10482100200241206a240020000b2101017f2001102b220220012802044b044010000b20002001200110492002104a0b0b6901004180080b6261006200630064006500696e697400736574496e69744172726179446174650067657441727261794973456d70747900676574417272617956616c7565496e646578006765744172726179466972737456616c756500736574417272617946696c6c";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GETARRAYFIRSTVALUE = "getArrayFirstValue";

    public static final String FUNC_SETINITARRAYDATE = "setInitArrayDate";

    public static final String FUNC_GETARRAYISEMPTY = "getArrayIsEmpty";

    public static final String FUNC_GETARRAYVALUEINDEX = "getArrayValueIndex";

    public static final String FUNC_SETARRAYFILL = "setArrayFill";

    protected ReferenceDataTypeArrayFuncContract(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected ReferenceDataTypeArrayFuncContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public RemoteCall<String> getArrayFirstValue() {
        final WasmFunction function = new WasmFunction(FUNC_GETARRAYFIRSTVALUE, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static RemoteCall<ReferenceDataTypeArrayFuncContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeArrayFuncContract.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<ReferenceDataTypeArrayFuncContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeArrayFuncContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<ReferenceDataTypeArrayFuncContract> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeArrayFuncContract.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<ReferenceDataTypeArrayFuncContract> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(ReferenceDataTypeArrayFuncContract.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<TransactionReceipt> setInitArrayDate() {
        final WasmFunction function = new WasmFunction(FUNC_SETINITARRAYDATE, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setInitArrayDate(BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_SETINITARRAYDATE, Arrays.asList(), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public RemoteCall<Boolean> getArrayIsEmpty() {
        final WasmFunction function = new WasmFunction(FUNC_GETARRAYISEMPTY, Arrays.asList(), Boolean.class);
        return executeRemoteCall(function, Boolean.class);
    }

    public RemoteCall<String> getArrayValueIndex(Uint32 index) {
        final WasmFunction function = new WasmFunction(FUNC_GETARRAYVALUEINDEX, Arrays.asList(index), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setArrayFill(String str) {
        final WasmFunction function = new WasmFunction(FUNC_SETARRAYFILL, Arrays.asList(str), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setArrayFill(String str, BigInteger vonValue) {
        final WasmFunction function = new WasmFunction(FUNC_SETARRAYFILL, Arrays.asList(str), Void.class);
        return executeRemoteCallTransaction(function, vonValue);
    }

    public static ReferenceDataTypeArrayFuncContract load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new ReferenceDataTypeArrayFuncContract(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static ReferenceDataTypeArrayFuncContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new ReferenceDataTypeArrayFuncContract(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
