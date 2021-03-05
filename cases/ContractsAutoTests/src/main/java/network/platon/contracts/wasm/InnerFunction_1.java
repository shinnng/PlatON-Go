package network.platon.contracts.wasm;

import com.platon.abi.wasm.WasmFunctionEncoder;
import com.platon.abi.wasm.datatypes.WasmFunction;
import com.platon.crypto.Credentials;
import com.platon.protocol.Web3j;
import com.platon.protocol.core.RemoteCall;
import com.platon.rlp.wasm.datatypes.Uint64;
import com.platon.rlp.wasm.datatypes.WasmAddress;
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
public class InnerFunction_1 extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001671260027f7f0060017f0060017f017f60037f7f7f0060027f7f017f60000060017f017e60037f7e7e0060037f7f7f017f6000017e60047f7f7f7f0060077f7f7f7f7f7f7f0060027f7e0060027e7f0060037e7e7f006000017f60047f7f7f7f017f60027e7e017f02cb020f03656e760c706c61746f6e5f70616e6963000503656e7611706c61746f6e5f626c6f636b5f68617368000d03656e760f706c61746f6e5f636f696e62617365000103656e760e706c61746f6e5f62616c616e6365000403656e760a706c61746f6e5f676173000903656e7613706c61746f6e5f63616c6c65725f6e6f6e6365000903656e760d726c705f6c6973745f73697a65000203656e760f706c61746f6e5f726c705f6c697374000303656e760e726c705f62797465735f73697a65000403656e7610706c61746f6e5f726c705f6279746573000303656e760d726c705f753132385f73697a65001103656e760f706c61746f6e5f726c705f75313238000e03656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000f03656e7610706c61746f6e5f6765745f696e707574000103656e760d706c61746f6e5f72657475726e0000033a390506060c08040204030b0201010000000200030100030707030405021003060601000201020100080002040501020001000400030502020a070405017001030305030100020608017f0141808a040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f7273000f0f5f5f66756e63735f6f6e5f65786974003a06696e766f6b6500290908010041010b0210110aac6039040010430b040010040b040010050bb608010a7f230041d0006b220224002001200241206a1001200241186a4200370300200241106a4200370300200241086a420037030020024200370300034020064120470440200220066a41003a0000200641016a21060c010b0b2002200241206a412010131a200241206a419b0910142103200241c8006a41003602002002420037034002400240200328020420022d0020220441017620044101711b220641406b2205410b4f0440200641d0006a4170712204101521072002200536024420022004410172360240200220073602480c010b200220054101743a0040200241406b41017221072005450d010b200720051016210720022d002021040b200520076a41003a0000200341016a21082003280208210a2003280204200441fe0171410176200441017122091b2103027f20022d00402204410171220b450440410a2107200441017622042006200620044b1b0c010b2002280240417e71417f6a210720022802442204200620042006491b0b2105200a200820091b2108024002400240027f02400240200520046b20076a20034f04402002280248200241406b410172200b1b21074100210a20032005460440200321090c050b200420056b220b450440200521090c050b20032005490d01200720084f0d02200420076a20084d0d02200520076a20084d04402008200320056b6a21080c030b2007200820051017200320086a2108200320056b21032005210a41000c030b200241406b2007200320046a20056b20076b200420052003200810180c050b2007200820031017200320076a200520076a200b1017200521090c030b20050b21092007200a6a220520036a200520096a200b10170b2007200a6a2008200310170b200320096b20046a2103024020022d00404101710440200220033602440c010b200220034101743a00400b200320076a41003a00000b200241406b4101722104410021030340200341204704402002280248200420022d00404101711b20066a200220036a22052d0000410476419c096a2d00003a00002002280248200420022d00404101711b20066a41016a20052d0000410f71419c096a2d00003a0000200341016a2103200641026a21060c010b0b41ad09101921060240027f20022d00402203410171220745044020034101762103410a0c010b200228024421032002280240417e71417f6a0b220520036b20064f04402006450d012002280248200420071b2204027f20034504404100210341ad090c010b200420066a200420031017200641ad096a41ad09200320046a41ad094b1b41ad09200441ad094d1b0b20061017200320066a2106024020022d00404101710440200220063602440c010b200220064101743a00400b200420066a41003a00000c010b200241406b2005200320066a20056b20034100200641ad0910180b20002002290340370200200041086a200241c8006a280200360200200241406b101a200241d0006a24000bfc0801067f03400240200020046a2105200120046a210320022004460d002003410371450d00200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220745044003402006411049450440200020046a2203200120046a2205290200370200200341086a200541086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2205200120046a2204290200370200200441086a2103200541086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002007417f6a220741024b0d00024002400240024002400240200741016b0e020102000b2005200120046a220328020022073a0000200541016a200341016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2203200120046a220541046a2802002202410874200741187672360200200341046a200541086a2802002207410874200241187672360200200341086a2005410c6a28020022024108742007411876723602002003410c6a200541106a2802002207410874200241187672360200200441106a2104200641706a21060c000b000b2005200120046a220328020022073a0000200541016a200341016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2203200120046a220541046a2802002202411074200741107672360200200341046a200541086a2802002207411074200241107672360200200341086a2005410c6a28020022024110742007411076723602002003410c6a200541106a2802002207411074200241107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022073a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2203200120046a220541046a2802002202411874200741087672360200200341046a200541086a2802002207411874200241087672360200200341086a2005410c6a28020022024118742007410876723602002003410c6a200541106a2802002207411874200241087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000b1f0020004200370200200041086a41003602002000200120011019102720000b0b002000410120001b102a0bb90301027f02402001450d00200041303a0000200020016a2203417f6a41303a000020014103490d00200041303a0002200041303a00012003417d6a41303a00002003417e6a41303a000020014107490d00200041303a00032003417c6a41303a000020014109490d002000410020006b41037122026a220341b0e0c081033602002003200120026b417c7122026a2201417c6a41b0e0c0810336020020024109490d00200341b0e0c08103360208200341b0e0c08103360204200141786a41b0e0c08103360200200141746a41b0e0c0810336020020024119490d00200341b0e0c08103360218200341b0e0c08103360214200341b0e0c08103360210200341b0e0c0810336020c200141706a41b0e0c081033602002001416c6a41b0e0c08103360200200141686a41b0e0c08103360200200141646a41b0e0c081033602002002200341047141187222026b2101200220036a2102034020014120490d01200242b0e0c08183868c9830370300200241186a42b0e0c08183868c9830370300200241106a42b0e0c08183868c9830370300200241086a42b0e0c08183868c9830370300200241206a2102200141606a21010c000b000b20000b0f002002044020002001200210420b0ba80101027f027f20002d0000410171044020002802080c010b200041016a0b2108416f2107200141e6ffffff074d0440410b20014101742207200120026a220120012007491b220141106a4170712001410b491b21070b2007101521012005044020012006200510240b200320046b22030440200120056a200420086a200310240b200020013602082000200320056a220536020420002007410172360200200120056a41003a00000b7801027f20002101024003402001410371044020012d0000450d02200141016a21010c010b0b2001417c6a21010340200141046a22012802002202417f73200241fffdfb776a7141808182847871450d000b0340200241ff0171450d01200141016a2d00002102200141016a21010c000b000b200120006b0b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b4c01017f230041206b2201240020011002200041106a4100360000200041086a420037000020004200370000200141003a001f20002001411f6a101c20002001411410131a200141206a24000b2601017f03402002411446450440200020026a20012d00003a0000200241016a21020c010b0b0ba815020c7f047e230041c0016b22022400200241386a4180081014210a2001280208200141016a220c20012d0000220341017122041b21082001280204200341017620041b21094100210341012105024003402005410171410020032009491b0440200320086a2d00002204415f6a41ff017141de004921052006200441bf7f6a41ff0171411a4972210620072004419f7f6a41ff0171411a49722107200341016a21030c01050240200520062007714101737121062009450d002009210303402003450d01200320086a21052003417f6a220421032005417f6a2d00004131470d000b0c030b0b0b417f21040b0240024002402006410171450d00200441076a20094b0d00200441016a4102490d00200941da004b0d0041002103200241003602b801200242003703b001200241b0016a20092004417f7322076a101e4101210602400240024003402003200128020420012d00002205410176200541017122051b20076a4f044002402006410171450d0541002103200241a0016a101f21060340200320044604402006280204220720022d00a00122034101762208200341017122051b2204200a28020420022d00382203410176200341017122031b470d05200a280208200a41016a20031b210320050d02200641016a21052008210403402004450440200821070c080b20052d000020032d0000470d06200341016a2103200541016a21052004417f6a21040c000b000520062001280208200c20012d00004101711b20036a2c000022054120722005200541bf7f6a411a491b4118744118751020200341016a21030c010b000b000b0520022802b00120036a2001280208200c20051b20046a20036a41016a2d00004190086a2d000022053a00002006200541ff0147712106200341016a21030c010b0b2004450d012006280208210503402004450d0220052d000020032d0000470d01200341016a2103200541016a21052004417f6a21040c000b000b200241286a4200370300200241306a410036020020024200370320200241003a003420022802b0012203450d03200220033602b4010c030b410021032002410036026820024200370360200241e0006a2007410174410172101e200641016a210703402003200628020420022d00a0012204410176200441017122041b2205490440200228026020036a2006280208200720041b20036a2d000022044105763a00002002280260200628020420022d00a001220541017620054101711b6a20036a41016a2004411f713a0000200341016a21030c010b0b200228026020056a41003a000020022802642105024020022802b401220420022802b00122036b22064101480d0020062002280268220820056b4c0440034020032004460d02200520032d00003a00002002200228026441016a2205360264200341016a21030c000b000b200241306a200241e8006a360200410021072002410036022c2005200228026022016b2109200520066a20016b2206200820016b2208410174220120012006491b41ffffffff07200841ffffffff03491b220804402008101521070b200220073602202002200720096a22063602282002200720086a36022c20022006360224200241206a4104722107034020032004470440200620032d00003a00002002200228022841016a2206360228200341016a21030c010b0b200228026020052007102102402002280264220420056b220341004c0440200228022821050c010b2002200228022820052003101320036a2205360228200228026421040b2002280260210320022002280224360260200220033602242002200536026420022004360228200228026821042002200228022c3602682002200436022c20022003360220200241206a1022200228026421050b200242003702642002280260210420024100360260200520046b21054101210303402005044020042d000041002003411d764101716b41b3c5d1d0027141002003411c764101716b41dde788ea037141002003411b764101716b41fab384f5017141002003411a764101716b41ed9cc2b20271410020034119764101716b41b2afa9db0371200341057441e0ffffff037173737373737321032005417f6a2105200441016a21040c010b0b20034101470d00410021032002410036028001200242003703784100210520022802b401417a6a220620022802b00122046b2207044020071015220d210b034020042006470440200b20042d00003a0000200b41016a210b200441016a21040c010b0b200b21050b20024180016a210c410021084100210a02400340200a2005200d6b4f04400240200341044c044041ff01410820036b76200871450d010b200228027821030c030b05200a200d6a2d0000200841057441e01f71722108200341056a21030340200341084e04402008200341786a2203762105200228027c22062002280280012207490440200620053a00002002200228027c41016a36027c0c02052002200c360230410021042002410036022c2006200228027822016b220641016a2209200720016b2207410174220120012009491b41ffffffff07200741ffffffff03491b220704402007101521040b20022004360220200420066a220620053a00002002200420076a36022c200220063602242002200641016a360228200241f8006a200241206a1023200241206a10220c020b000b0b200a41016a210a200b21050c010b0b200228027c200228027822036b4114470d0041002103200241f0006a4100360200200241e8006a420037030020024200370360200241003a0020200241e0006a200241206a101c200228027c200228027822046b21050340024020032005460d00200341134b0d00200241e0006a20036a200320046a2d00003a0000200341016a21030c010b0b200241306a200241f0006a280200360200200241286a200241e8006a29030037030020022002290360370320200241013a0034200404402002200436027c0b20022802b00122030440200220033602b4010b200241e0006a2104200241206a200241e0006a10032103034020030440200f420886200e42388884210f2003417f6a21032004310000200e42088684210e200441016a21040c010b0b0240027f2000101f22062d00002203410171450440200341017622044128200441284b1b41106a41f001712103410a0c010b200628020422044128200441284b1b41106a41707122032006280200417e712205460d012005417f6a0b210741002003417f6a20074d2003101522051b0d0020052006280208200641016a20062d0000220741017122081b2006280204200741017620081b41016a10242006200536020820062004360204200620034101723602000b200241186a21070340200241106a200e200f102520022002290310221020072903002211102620062002290300200e7ca74190096a2c00001020200e4209562103200f4200522104200f5021052010210e2011210f2003200420051b0d000b200628020420062d00002203410176200341017122031b2204450d0420042006280208200641016a20031b22036a417f6a21040340200320044f0d0520032d00002105200320042d00003a0000200420053a00002004417f6a2104200341016a21030c000b000b2003450d002002200336027c0b20022802b0012203450d00200220033602b4010b200241286a4200370300200241306a410036020020024200370320200241003a00340b2000419b0910141a0b200241c0016a24000bfa0101057f230041206b22022400024020002802042203200028020022046b22052001490440200028020820036b200120056b22044f04400340200341003a00002000200028020441016a22033602042004417f6a22040d000c030b000b2000200110282106200241186a200041086a3602002002410036021441002101200604402006101521010b200220013602082002200120056a22033602102002200120066a3602142002200336020c0340200341003a00002002200228021041016a22033602102004417f6a22040d000b2000200241086a1023200241086a10220c010b200520014d0d002000200120046a3602040b200241206a24000b190020004200370200200041086a41003602002000101a20000bf60101057f027f20002d00002202410171220345044020024101762104410a0c010b2000280204210420002802002202417e71417f6a0b210502400240024020042005460440027f2002410171044020002802080c010b200041016a0b2106416f2103200541e6ffffff074d0440410b20054101742202200541016a220320032002491b220241106a4170712002410b491b21030b20031015220220062005102420002003410172360200200020023602080c010b2003450d01200028020821020b2000200441016a3602040c010b2000200441017441026a3a0000200041016a21020b200220046a220041003a0001200020013a00000b270020022002280200200120006b22016b2202360200200141014e044020022000200110131a0b0b2b01027f200028020821012000280204210203402001200247044020002001417f6a22013602080c010b0b0b6701017f20002802002000280204200141046a1021200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b10002002044020002001200210131a0b0b3701017f230041106b220324002003200120021047200329030021012000200341086a29030037030820002001370300200341106a24000b7701017e20002001427f7e200242767e7c2001422088220242ffffffff0f7e7c200242f6ffffff0f7e200142ffffffff0f83220142f6ffffff0f7e22034220887c22024220887c200142ffffffff0f7e200242ffffffff0f837c22024220887c3703082000200342ffffffff0f832002422086843703000b5a01027f02402002410a4d0440200020024101743a0000200041016a21030c010b200241106a4170712204101521032000200236020420002004410172360200200020033602080b2003200120021024200220036a41003a00000b2e01017f2001200028020820002802006b2200410174220220022001491b41ffffffff07200041ffffffff03491b0be60802077f027e230041d0016b220024001043100c2201102a2202100d200041e8006a200020022001411c102b22014100102c02400240200041e8006a102d2207500d0041b009102e20075104402001102f0c020b41b509102e20075104402001410110300c020b41b909102e20075104402001410210300c020b41bf09102e200751044020011031410247044010000b200041e8006a20014101102c200041e8006a200041e8006a102d1012200041e8006a10320c020b41ca09102e20075104402001102f200041206a101b200041386a10332104200041e0006a200041306a2802002202360200200041d8006a200041286a29030022073703004100210120004180016a4100360200200041f8006a4200370300200041f0006a42003703002000200029032022083703502000420037036820004190016a200737030020004198016a2002360200200041a8016a2007370300200041b0016a20023602002000200837038801200020083703a001200041c8016a2002360200200041c0016a2007370300200020083703b801410121030240034020014114460d01200041b8016a20016a2102200141016a210120022d0000450d000b411521030b20002003360268200041e8006a410472103420042003103520004198016a200041306a280200220136020020004190016a200041286a290300220737030020002000290320220837038801200041a8016a2007370300200041b0016a2001360200200041c0016a2007370300200041c8016a2001360200200020083703a001200020083703b801200041f8006a2001360200200041f0006a2007370300200020083703682004200041e8006a41141036220128020c200141106a28020047044010000b20012802002001280204100e200128020c2202450d02200120023602100c020b41d309102e2007520d00200041b8016a101f210420011031410247044010000b200041e8006a20014101102c02400240200028026c044020002802682d000041c001490d010b200041386a101f1a0c010b200041a0016a200041e8006a1037200041e8006a10382102024002400240024020002802a0012201044020002802a401220320024f0d010b41002101200041406b410036020020004200370338410021030c010b200041406b4100360200200042003703382001200320022002417f461b22056a21032005410a4b0d010b200020054101743a0038200041386a41017221020c010b200541106a4170712206101521022000200536023c20002006410172360238200020023602400b034020012003470440200220012d00003a0000200241016a2102200141016a21010c010b0b200241003a00000b024020002d00b801410171450440200041003b01b8010c010b20002802c00141003a0000200041003602bc0120002d00b801410171450d00200041003602b8010b200041c0016a200041406b280200360200200020002903383703b801200041386a101a200041e8006a200041386a20041039101d200041e8006a10320c010b10000b103a200041d0016a24000b9b0101047f230041106b220124002001200036020c2000047f41f409200041086a2202411076220041f4092802006a220336020041f00941f009280200220420026a41076a417871220236020002400240200341107420024d044041f409200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20042001410c6a4104101341086a0541000b2100200141106a240020000b730020004200370210200042ffffffff0f370208200020023602042000200136020002402003410871450d002000104420024f0d002003410471044010000c010b200042003702000b02402003411071450d002000104420024d0d0020034104710440100020000f0b200042003702000b20000bc90202067f017e230041106b220324002001280208220520024b0440200341086a2001103f20012003280208200328020c104036020c20032001103f410021052001027f410020032802002207450d001a410020032802042208200128020c2206490d001a200820062006417f461b210420070b360210200141146a2004360200200141003602080b200141106a210603402001280214210402402005200249044020040d01410021040b2000200628020020044114102b1a200341106a24000f0b20032001103f41002104027f410020032802002205450d001a410020032802042208200128020c2207490d001a200820076b2104200520076a0b2105200120043602142001200536021020032006410020052004104010462001200329030022093702102001200128020c2009422088a76a36020c2001200128020841016a22053602080c000b000b870202047f017e230041106b220324002000103b024002402000280204450d002000103b0240200028020022022c0000220141004e044020010d010c020b200141807f460d00200141ff0171220441b7014d0440200028020441014d04401000200028020021020b20022d00010d010c020b200441bf014b0d012000280204200141ff017141ca7e6a22014d04401000200028020021020b200120026a2d0000450d010b2000280204450d0020022d000041c001490d010b10000b200341086a20001037200328020c220041094f044010000b200328020821010340200004402000417f6a210020013100002005420886842105200141016a21010c010b0b200341106a240020050b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010b0e0020001031410147044010000b0b920202027f037e230041406a220324002000102f41012100200320011106002104200341086a1033210241002101200341386a4100360200200341306a4200370300200341286a42003703002003420037032020044280015a044020042105034020052006845045044020064238862005420888842105200141016a2101200642088821060c010b0b200141384f047f2001103c20016a0520010b41016a21000b20032000360220200341206a4104721034200220001035200242002004100a200228020422016a103d42002004200120022802006a100b2002103e200228020c200241106a28020047044010000b20022802002002280204100e200228020c22010440200220013602100b200341406b24000b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a2000103f200128020c210003402000450d01200141002001280208220320032000104022046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020bae0201067f230041e0006b22022400200241186a10332104200241d8006a4100360200200241d0006a4200370300200241c8006a42003703002002420037034041012101024002400240200241306a20001039220528020420022d00302203410176200341017122061b220341014d0440200341016b0d032005280208200541016a20061b2c0000417f4c0d010c030b200341374b0d010b200341016a21010c010b2003103c20036a41016a21010b20022001360240200241406b41047210342004200110352004200241086a200010392201280208200141016a20012d0000220041017122031b2001280204200041017620031b1036220128020c200141106a28020047044010000b20012802002001280204100e200128020c22000440200120003602100b200241e0006a24000b29002000410036020820004200370200200041001041200041146a41003602002000420037020c20000b860201067f200028020422032000280210220141087641fcffff07716a2102027f200320002802082204460440200041146a210641000c010b2003200028021420016a220541087641fcffff07716a280200200541ff07714102746a2105200041146a21062002280200200141ff07714102746a0b21010340024020012005460440200641003602000340200420036b41027522014103490d022000200341046a22033602040c000b000b200141046a220120022802006b418020470d0120022802042101200241046a21020c010b0b2001417f6a220241014d04402000418004418008200241016b1b3602100b03402003200447044020002004417c6a22043602080c010b0b0b1300200028020820014904402000200110410b0b2a01017f2000200120021008200028020422036a103d20012002200320002802006a10092000103e20000bd50101047f200110382204200128020422024b04401000200128020421020b200128020021052000027f02400240200204404100210120052c00002203417f4a0d01027f200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a21010c010b4101210120050d000c010b41002103200120046a20024b0d0020022001490d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000bff0201037f200028020445044041000f0b2000103b41012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b4d01017f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b200020012802082001280204102720000b880101037f41e009410136020041e4092802002100034020000440034041e80941e8092802002201417f6a2202360200200141014845044041e0094100360200200020024102746a22004184016a280200200041046a28020011010041e009410136020041e40928020021000c010b0b41e809412036020041e409200028020022003602000c010b0b0b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b3601017f200028020820014904402001102a200028020020002802041013210220002001360208200020023602000b200020013602040b7a01037f0340024020002802102201200028020c460d00200141786a2802004504401000200028021021010b200141786a22022002280200417f6a220336020020030d002000200236021020002001417c6a2802002201200028020420016b220210066a103d200120002802006a22012002200110070c010b0b0b2101017f20011038220220012802044b044010000b2000200120011045200210460b2701017f230041206b22022400200241086a200020014114102b10442100200241206a240020000b2f01017f200028020820014904402001102a200028020020002802041013210220002001360208200020023602000b0b8d0301037f024020002001460d00200120006b20026b410020024101746b4d044020002001200210131a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2105200020036a2204410371450440200220036b210241002103034020024104490d04200320046a200320056a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200420052d00003a0000200341016a21030c000b000b024020030d002001417f6a21040340200020026a22034103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042003417f6a200220046a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320056a2101200320046a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b3501017f230041106b220041808a0436020c41ec09200028020c41076a417871220036020041f009200036020041f4093f003602000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f20001045200010386a0520010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0b5b01027f2000027f0240200128020022054504400c010b200220036a200128020422014b0d0020012002490d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000bbe0202027f047e2000027e2002500440420021022001420a800c010b0240027e200141fd00200279a76b220341c000460d001a2003413f4d0440200241c00020036bad22058620012003ad2207888421062002200788210820012005862107420021050c020b200241800120036bad2205862001200341406aad22068884210720022006882106200120058621050c010b21072002210641c00021030b03402003044020084201862006423f888422022002427f8542007c20064201862007423f88842206427f852202420a7c200254ad7c423f8722024200837d20062002420a83220154ad7d2108200620017d210620074201862005423f888421072003417f6a21032004ad20054201868421052002a741017121040c010b0b20074201862005423f888421022004ad2005420186427e83840b370300200020023703080b0bdd0102004180080b03617478004190080bcc01ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff0fff0a1115141a1e0705ffffffffffffff1dff180d19090817ff12161f1b13ff010003100b1c0c0e060402ffffffffffff1dff180d19090817ff12161f1b13ff010003100b1c0c0e060402ffffffffff3031323334353637383900003031323334353637383961626364656600307800696e697400676173006e6f6e636500626c6f636b5f6861736800636f696e626173650062616c616e63654f66";

    public static String BINARY = BINARY_0;

    public static final String FUNC_NONCE = "nonce";

    public static final String FUNC_GAS = "gas";

    public static final String FUNC_BLOCK_HASH = "block_hash";

    public static final String FUNC_COINBASE = "coinbase";

    public static final String FUNC_BALANCEOF = "balanceOf";

    protected InnerFunction_1(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    protected InnerFunction_1(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }

    public static RemoteCall<InnerFunction_1> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction_1.class, web3j, credentials, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<InnerFunction_1> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction_1.class, web3j, transactionManager, contractGasProvider, encodedConstructor, chainId);
    }

    public static RemoteCall<InnerFunction_1> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction_1.class, web3j, credentials, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public static RemoteCall<InnerFunction_1> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, BigInteger initialVonValue, Long chainId) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(InnerFunction_1.class, web3j, transactionManager, contractGasProvider, encodedConstructor, initialVonValue, chainId);
    }

    public RemoteCall<Uint64> nonce() {
        final WasmFunction function = new WasmFunction(FUNC_NONCE, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<Uint64> gas() {
        final WasmFunction function = new WasmFunction(FUNC_GAS, Arrays.asList(), Uint64.class);
        return executeRemoteCall(function, Uint64.class);
    }

    public RemoteCall<String> block_hash(Uint64 bn) {
        final WasmFunction function = new WasmFunction(FUNC_BLOCK_HASH, Arrays.asList(bn), String.class);
        return executeRemoteCall(function, String.class);
    }

    public RemoteCall<WasmAddress> coinbase() {
        final WasmFunction function = new WasmFunction(FUNC_COINBASE, Arrays.asList(), WasmAddress.class);
        return executeRemoteCall(function, WasmAddress.class);
    }

    public RemoteCall<String> balanceOf(String addr) {
        final WasmFunction function = new WasmFunction(FUNC_BALANCEOF, Arrays.asList(addr), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static InnerFunction_1 load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider, Long chainId) {
        return new InnerFunction_1(contractAddress, web3j, credentials, contractGasProvider, chainId);
    }

    public static InnerFunction_1 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, Long chainId) {
        return new InnerFunction_1(contractAddress, web3j, transactionManager, contractGasProvider, chainId);
    }
}
