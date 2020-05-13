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
public class InitWithObjectParams extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001420c60027f7f0060017f0060017f017f60027f7f017f60037f7f7f017f60000060037f7f7f0060047f7f7f7f0060047f7f7f7f017f60027f7e006000017f60017f017e02a9010703656e760c706c61746f6e5f70616e6963000503656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000a03656e7610706c61746f6e5f6765745f696e707574000103656e7617706c61746f6e5f6765745f73746174655f6c656e677468000303656e7610706c61746f6e5f6765745f7374617465000803656e7610706c61746f6e5f7365745f7374617465000703656e760d706c61746f6e5f72657475726e0000035d5c05020101000303080001030006040b05000200020101010100010200010109000202010000020000040001020003000303020004080104040206050202030601000501050104020202010103070400060202070000000000000003090405017001030305030100020608017f0141e08a040b073904066d656d6f72790200115f5f7761736d5f63616c6c5f63746f727300070f5f5f66756e63735f6f6e5f65786974004806696e766f6b6500160908010041010b020a4b0ad4695c100041a00810081a410110491041104a0b190020004200370200200041086a41003602002000100920000b2201017f03402001410c470440200020016a4100360200200141046a21010c010b0b0b070041a00810460b8a0101027f230041206b22032400024020002802042202200028020847044020022001100c1a2000200028020441246a3602040c010b200341086a2000200220002802006b41246d41016a100d200028020420002802006b41246d200041086a100e22022802082001100c1a2002200228020841246a36020820002002100f200210100b200341206a24000b25002000200110441a2000410c6a2001410c6a10441a200041186a200141186a10441a20000b3b01017f200141c8e3f1384f0440000b2001200028020820002802006b41246d2200410174220220022001491b41c7e3f138200041e3f1b81c491b0b4c01017f2000410036020c200041106a2003360200200104402001102c21040b2000200436020020002004200241246c6a220236020820002004200141246c6a36020c2000200236020420000b900101027f2000280204210220002802002103034020022003464504402001280204415c6a2002415c6a2202102d20012001280204415c6a3602040c010b0b200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b3301027f20002802042102034020022000280208220147044020002001415c6a22013602082001101b0c010b0b20002802001a0b3e01017f2000420037020020004100360208200128020420012802006b220204402000200241246d101220012802002001280204200041046a10130b20000b2f01017f200141c8e3f1384f0440000b20002001102c22023602002000200236020420002002200141246c6a3602080b2e000340200020014645044020022802002000100c1a2002200228020041246a360200200041246a21000c010b0b0b3401017f230041106b220324002003200236020c200320013602082003200329030837030020002003411c104c200341106a24000b3901027e42a5c688a1c89ca7f94b210103402000300000220250450440200041016a2100200142b383808080207e20028521010c010b0b20010bbf0302057f017e230041a0016b22002400100710012202104222011002200041e8006a2000200120021014220241001056200041e8006a105002400240200041e8006a1057450d00200028026c450d0020002802682d000041c001490d010b10000b200041406b200041e8006a10172000280244220141094f044010000b200028024021030340200104402001417f6a210120033100002005420886842105200341016a21030c010b0b024002402005500d0041800810152005510440200041186a101821012002200041186a1019200041e8006a101a20004180016a200041406b2001100c2203100b2003101b101c2001101b0c020b41850810152005510440200041186a101821012002200041186a1019200041e8006a101a20004180016a2203200041406b2001100c2204100b20004190016a200310111a20004190016a101d20004190016a101e2004101b101c2001101b0c020b41910810152005520d0020004190016a10082101200041e8006a200241011056200041e8006a2001101f200041e8006a101a200041186a20011044200041406b20004180016a10112204101d2004101e1046101c200110460c010b10000b1048200041a0016a24000bd60101047f2001104f2204200128020422024b04401000200128020421020b20012802002105027f027f41002002450d001a410020052c00002203417f4a0d011a200341ff0171220141bf014d04404100200341ff017141b801490d011a200141c97e6a0c010b4100200341ff017141f801490d001a200141897e6a0b41016a0b21012000027f02402005450440410021030c010b410021032002200149200120046a20024b720d00410020022004490d011a200120056a2103200220016b20042004417f461b0c010b41000b360204200020033602000b1900200010081a2000410c6a10081a200041186a10081a20000b2801017f230041206b22022400200241086a200041011056200241086a2001102e200241206a24000bcf06020c7f017e230041c0016b2202240020004200370218200042b8e09485bbf68abc133703102000410036020820004200370200200041206a4100360200200241306a1021220620002903101025200628020c200641106a28020047044010000b200041186a21072000411c6a210902402006280200220b2006280204220c10032204044020024100360228200242003703202004417f4c0d012004104321030340200120036a41003a00002004200141016a2201470d000b200120036a210820032002280224200228022022056b220a6b2101200a41014e044020012005200a103e1a200228022021050b2002200320046a36022820022008360224200220013602200240200b200c2005044020022802242108200228022021010b2001200820016b1004417f460440410021040c010b0240200241086a2002280220220141016a20022802242001417f736a10142201280204450d0020012802002d000041c001490d002001105821032000280220200028021822086b41246d20034904402007200241c8006a2003200028021c20086b41246d200041206a100e2203100f200310100b20024198016a2001410110542103200041206a210a20024188016a200141001054210803402003280204200828020446044020032802082008280208460d030b20022003290204220d3703482002200d370300200241f0006a2002411c104c200241c8006a10182201102e0240200028021c2205200028022049044020052001102d2009200928020041246a3602000c010b200241a8016a2007200520072802006b41246d41016a100d200928020020072802006b41246d200a100e210520022802b0012001102d200220022802b00141246a3602b00120072005100f200510100b2001101b200310510c000b000b10000b200241206a1020200421010b20061023024020010d0020002802042206200028020022016b41246d22032000280220200028021822046b41246d4d04402003200928020020046b41246d22034b044020012001200341246c6a22012004102f1a20012006200910130c020b2007200120062004102f10300c010b200404402007103120002802181a20004100360220200042003702180b200720072003100d101220012006200910130b200241c0016a240020000f0b000b1400200041186a10462000410c6a1046200010460bee03020c7f027e230041d0006b22022400200241186a10212105200241c8006a4100360200200241406b4200370300200241386a420037030020024200370330410121032000290310220d4280015a04400340200d200e8450450440200e423886200d42088884210d200441016a2104200e420888210e0c010b0b200441384f047f2004102720046a0520040b41016a21030b20022003360230200241306a4104721029200520031026200520002903101025200528020c200541106a28020047044010000b200528020421082005280200200241306a10212101200041186a220a1032210b41011043220341fe013a0000200220033602082002200341016a22063602102002200636020c200128020c200141106a2802004704401000200228020c2106200228020821030b2003210420012802042207200620036b22066a220c20012802084b04402001200c102220012802042107200228020821040b200128020020076a20032006103e1a2001200128020420066a3602042001200228020c200b20046b6a10262001200a10330240200128020c2001280210460440200128020021030c010b100020012802002103200128020c2001280210460d0010000b2008200320012802041005200241086a10202001102320051023200041186a101e2000101e200241d0006a24000b4c01027f230041206b22022400200241086a10212201200010321026200120001033200128020c200141106a28020047044010000b20012802002001280204100620011023200241206a24000b1400200028020004402000103120002802001a0b0b8c0301057f230041206b220224000240024002402000280204044020002802002d000041c001490d010b200241086a10081a0c010b200241186a200010172000104f21030240024002400240200228021822000440200228021c220420034f0d010b41002100200241106a410036020020024200370308410021030c010b200241106a410036020020024200370308200420032003417f461b220341704f0d04200020036a21052003410a4b0d010b200220034101743a0008200241086a41017221040c010b200341106a4170712206104321042002200336020c20022006410172360208200220043602100b034020002005470440200420002d00003a0000200441016a2104200041016a21000c010b0b200441003a00000b024020012d0000410171450440200141003b01000c010b200128020841003a00002001410036020420012d0000410171450d0020012802081a200141003602000b20012002290308370200200141086a200241106a280200360200200241086a1009200241086a1046200241206a24000f0b000b1501017f200028020022010440200020013602040b0b29002000410036020820004200370200200041001022200041146a41003602002000420037020c20000b3401017f2000280208200149044020011042220220002802002000280204103e1a2000102420002001360208200020023602000b0b1c01017f200028020c22010440200041106a20013602000b200010240b080020002802001a0b08002000200110620b1300200028020820014904402000200110220b0b1e01017f03402000044020004108762100200141016a21010c010b0b20010b2e002000280204200028021420002802106a417f6a220041087641fcffff07716a280200200041ff07714102746a0b940201047f230041106b22042400200028020422012000280210220241087641fcffff07716a2103027f410020012000280208460d001a2003280200200241ff07714102746a0b2101200441086a2000102a200428020c21020340024020012002460440200041003602142000280204210103402000280208220320016b41027522024103490d0220012802001a2000200028020441046a22013602040c000b000b200141046a220120032802006b418020470d0120032802042101200341046a21030c010b0b2002417f6a220241014d04402000418004418008200241016b1b3602100b03402001200347044020012802001a200141046a21010c010b0b20002000280204102b20002802001a200441106a24000b4f01037f20012802042203200128021020012802146a220441087641fcffff07716a21022000027f410020032001280208460d001a2002280200200441ff07714102746a0b360204200020023602000b2501017f200028020821020340200120024645044020002002417c6a22023602080c010b0b0b1500200041c8e3f1384f0440000b200041246c10430b620020002001290200370200200041086a200141086a28020036020020011009200041146a200141146a2802003602002000200129020c37020c2001410c6a1009200041206a200141206a28020036020020002001290218370218200141186a10090b5e01017f230041306b220224002002200041001056200241186a200241001056200241186a2001101f200241186a200041011056200241186a2001410c6a101f200241186a200041021056200241186a200141186a101f200241306a24000b4800200120006b21010340200104402002200010472002410c6a2000410c6a1047200241186a200041186a1047200241246a21022001415c6a2101200041246a21000c010b0b20020b2901017f20002802042102034020012002464504402002415c6a2202101b0c010b0b200020013602040b0b002000200028020010300bd30101067f230041406a22012400200141186a4100360200200141106a4200370300200141086a420037030020014200370300027f200028020020002802044604402001410136020041010c010b20014100103421042000280204200028020022006b2102037f2002047f2004410010342203200010352003200141306a2000410c6a104422031036200141206a200041186a1044220510362005104620031046410110341a2002415c6a2102200041246a21000c01052004410110341a20012802000b0b0b20014104721029200141406b24000bcf0201087f23004180016b220224002000200128020420012802006b41246d105e2001280204200128020022016b2104200241206a4104722106200241e0006a410472210703402004044020004103105e20024100360238200242003703302002420037032820024200370320200241206a20011035200241206a200241106a2001410c6a22051044220310362002200141186a22081044220910361a200910462003104620002002280220102620004101105e20024100360278200242003703702002420037036820024200370360200241e0006a200241d0006a20011044220310361a200310462000200228026010262000200241406b20011044220310371a20031046200710292000200241e0006a2005104422051037200241d0006a20081044220310371a2003104620051046200610292004415c6a2104200141246a21010c010520024180016a24000b0b0ba60c02077f027e230041306b22052400200041046a2107027f20014101460440200710282802002101200041186a22022002280200417f6a360200200710384180104f04402000410c6a2202280200417c6a2802001a20072002280200417c6a102b0b200141384f047f2001102720016a0520010b41016a210120002802180440200710280c020b20000c010b0240200710380d00200041146a28020022014180084f0440200020014180786a360214200041086a2201280200220228020021042001200241046a360200200520043602182007200541186a10390c010b2000410c6a2802002202200041086a2802006b4102752204200041106a2203280200220620002802046b220141027549044041802010432104200220064704400240200028020c220120002802102206470d0020002802082202200028020422034b04402000200220012002200220036b41027541016a417e6d41027422036a103a220136020c2000200028020820036a3602080c010b200541186a200620036b2201410175410120011b22012001410276200041106a103b2102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002103c200028020c21010b200120043602002000200028020c41046a36020c0c020b02402000280208220120002802042206470d00200028020c2202200028021022034904402000200120022002200320026b41027541016a41026d41027422036a103d22013602082000200028020c20036a36020c0c010b200541186a200320066b2201410175410120011b2201200141036a410276200041106a103b2102200028020c210320002802082101034020012003470440200228020820012802003602002002200228020841046a360208200141046a21010c010b0b200029020421092000200229020037020420022009370200200029020c21092000200229020837020c200220093702082002103c200028020821010b2001417c6a2004360200200020002802082201417c6a22023602082002280200210220002001360208200520023602182007200541186a10390c010b20052001410175410120011b20042003103b210241802010432106024020022802082201200228020c2208470d0020022802042204200228020022034b04402002200420012004200420036b41027541016a417e6d41027422036a103a22013602082002200228020420036a3602040c010b200541186a200820036b2201410175410120011b22012001410276200241106a280200103b21042002280208210320022802042101034020012003470440200428020820012802003602002004200428020841046a360208200141046a21010c010b0b2002290200210920022004290200370200200420093702002002290208210920022004290208370208200420093702082004103c200228020821010b200120063602002002200228020841046a360208200028020c2104034020002802082004460440200028020421012000200228020036020420022001360200200228020421012002200436020420002001360208200029020c21092000200229020837020c200220093702082002103c052004417c6a210402402002280204220120022802002208470d0020022802082203200228020c22064904402002200120032003200620036b41027541016a41026d41027422066a103d22013602042002200228020820066a3602080c010b200541186a200620086b2201410175410120011b2201200141036a4102762002280210103b2002280208210620022802042101034020012006470440200528022020012802003602002005200528022041046a360220200141046a21010c010b0b20022902002109200220052903183702002002290208210a20022005290320370208200520093703182005200a370320103c200228020421010b2001417c6a200428020036020020022002280204417c6a3602040c010b0b0b200541186a2007102a200528021c410036020041012101200041186a0b2202200228020020016a360200200541306a240020000b2d01017f230041106b220224002000410010342002200110442200103620001046410110341a200241106a24000b900101037f410121030240200128020420012d00002202410176200241017122041b2202450d0002400240200241014604402001280208200141016a20041b2c0000417f4c0d010c030b200241374b0d010b200241016a21030c010b2002102720026a41016a21030b027f200041186a2802000440200041046a10280c010b20000b2201200128020020036a36020020000b5201037f230041106b2202240020022001280208200141016a20012d0000220341017122041b36020820022001280204200341017620041b36020c20022002290308370300200020021061200241106a24000b2801017f200028020820002802046b2201410874417f6a410020011b200028021420002802106a6b0ba10202057f017e230041206b22052400024020002802082202200028020c2206470d0020002802042203200028020022044b04402000200320022003200320046b41027541016a417e6d41027422046a103a22023602082000200028020420046a3602040c010b200541086a200620046b2202410175410120021b220220024102762000410c6a103b2103200028020821042000280204210203402002200446450440200328020820022802003602002003200328020841046a360208200241046a21020c010b0b2000290200210720002003290200370200200320073702002000290208210720002003290208370208200320073702082003103c200028020821020b200220012802003602002000200028020841046a360208200541206a24000b2501017f200120006b220141027521032001044020022000200110400b200220034102746a0b5f01017f2000410036020c200041106a200336020002402001044020014180808080044f0d012001410274104321040b200020043602002000200420024102746a22023602082000200420014102746a36020c2000200236020420000f0b000b3101027f200028020821012000280204210203402001200247044020002001417c6a22013602080c010b0b20002802001a0b1b00200120006b22010440200220016b22022000200110400b20020bf80801067f0340200020046a2105200120046a220341037145200220044672450440200520032d00003a0000200441016a21040c010b0b200220046b210602402005410371220845044003402006411049450440200020046a2202200120046a2203290200370200200241086a200341086a290200370200200441106a2104200641706a21060c010b0b027f2006410871450440200120046a2103200020046a0c010b200020046a2202200120046a2201290200370200200141086a2103200241086a0b21042006410471044020042003280200360200200341046a2103200441046a21040b20064102710440200420032f00003b0000200341026a2103200441026a21040b2006410171450d01200420032d00003a000020000f0b024020064120490d002008417f6a220841024b0d00024002400240024002400240200841016b0e020102000b2005200120046a220628020022033a0000200541016a200641016a2f00003b0000200041036a2108200220046b417d6a2106034020064111490d03200420086a2202200120046a220541046a2802002207410874200341187672360200200241046a200541086a2802002203410874200741187672360200200241086a2005410c6a28020022074108742003411876723602002002410c6a200541106a2802002203410874200741187672360200200441106a2104200641706a21060c000b000b2005200120046a220628020022033a0000200541016a200641016a2d00003a0000200041026a2108200220046b417e6a2106034020064112490d03200420086a2202200120046a220541046a2802002207411074200341107672360200200241046a200541086a2802002203411074200741107672360200200241086a2005410c6a28020022074110742003411076723602002002410c6a200541106a2802002203411074200741107672360200200441106a2104200641706a21060c000b000b2005200120046a28020022033a0000200041016a21082004417f7320026a2106034020064113490d03200420086a2202200120046a220541046a2802002207411874200341087672360200200241046a200541086a2802002203411874200741087672360200200241086a2005410c6a28020022074118742003410876723602002002410c6a200541106a2802002203411874200741087672360200200441106a2104200641706a21060c000b000b200120046a41036a2103200020046a41036a21050c020b200120046a41026a2103200020046a41026a21050c010b200120046a41016a2103200020046a41016a21050b20064110710440200520032d00003a00002005200328000136000120052003290005370005200520032f000d3b000d200520032d000f3a000f200541106a2105200341106a21030b2006410871044020052003290000370000200541086a2105200341086a21030b2006410471044020052003280000360000200541046a2105200341046a21030b20064102710440200520032f00003b0000200541026a2105200341026a21030b2006410171450d00200520032d00003a00000b20000bc90201037f200041003a000020004184026a2201417f6a41003a0000200041003a0002200041003a00012001417d6a41003a00002001417e6a41003a0000200041003a00032001417c6a41003a00002000410020006b41037122026a22014100360200200141840220026b417c7122036a2202417c6a4100360200024020034109490d002001410036020820014100360204200241786a4100360200200241746a410036020020034119490d002001410036021820014100360214200141003602102001410036020c200241706a41003602002002416c6a4100360200200241686a4100360200200241646a41003602002003200141047141187222036b2102200120036a2101034020024120490d0120014200370300200141186a4200370300200141106a4200370300200141086a4200370300200141206a2101200241606a21020c000b000b20000b8d0301037f024020002001460d00200120006b20026b410020024101746b4d0440200020012002103e1a0c010b20002001734103712103027f024020002001490440200020030d021a410021030340200120036a2104200020036a2205410371450440200220036b210241002103034020024104490d04200320056a200320046a280200360200200341046a21032002417c6a21020c000b000b20022003460d04200520042d00003a0000200341016a21030c000b000b024020030d002001417f6a21030340200020026a22044103714504402001417c6a21032000417c6a2104034020024104490d03200220046a200220036a2802003602002002417c6a21020c000b000b2002450d042004417f6a200220036a2d00003a00002002417f6a21020c000b000b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b000b200320046a2101200320056a0b210303402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b000b0b3501017f230041106b220041e08a0436020c41c80a200028020c41076a417871220036020041cc0a200036020041d00a3f003602000b970101047f230041106b220124002001200036020c2000047f41d00a200041086a2202411076220041d00a2802006a220336020041cc0a200241cc0a28020022026a41076a417871220436020002400240200341107420044d044041d00a200341016a360200200041016a21000c010b2000450d010b200040000d0010000b20022001410c6a4104103e41086a0541000b200141106a24000b0b002000410120001b10420ba10101037f20004200370200200041086a2202410036020020012d0000410171450440200020012902003702002002200141086a28020036020020000f0b20012802082103024020012802042201410a4d0440200020014101743a0000200041016a21020c010b200141106a4170712204104321022000200136020420002004410172360200200020023602080b2002200320011045200120026a41003a000020000b100020020440200020012002103e1a0b0b130020002d0000410171044020002802081a0b0ba10201047f20002001470440200128020420012d00002202410176200241017122031b2102200141016a21052001280208410a2101200520031b210520002d000022034101712204044020002802002203417e71417f6a21010b200220014d0440027f2004044020002802080c010b200041016a0b21012002044020012005200210400b200120026a41003a000020002d00004101710440200020023602040f0b200020024101743a00000f0b027f2003410171044020002802080c010b41000b1a416f2103200141e6ffffff074d0440410b20014101742203200220022003491b220341106a4170712003410b491b21030b200310432204200520021045200020023602042000200436020820002003410172360200200220046a41003a00000b0b880101037f41ac08410136020041b0082802002100034020000440034041b40841b4082802002201417f6a2202360200200141014845044041ac084100360200200020024102746a22004184016a280200200041046a28020011010041ac08410136020041b00828020021000c010b0b41b408412036020041b008200028020022003602000c010b0b0b940101027f41ac08410136020041b008280200220145044041b00841b80836020041b80821010b024041b4082802002202412046044041840210422201450d012001103f220141b00828020036020041b008200136020041b4084100360200410021020b41b408200241016a360200200120024102746a22014184016a4100360200200141046a20003602000b41ac0841003602000b3801017f41bc0a420037020041c40a410036020041742100034020000440200041c80a6a4100360200200041046a21000c010b0b410210490b070041bc0a10460b750020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d002000104d20012802044f0d002002410471044010000c010b200042003702000b02402002411071450d002000104d20012802044d0d0020024104710440100020000f0b200042003702000b20000b2e01017f200028020445044041000f0b4101210120002802002c0000417f4c047f2000104e2000104f6a0541010b0b5b00027f027f41002000280204450d001a410020002802002c0000417f4a0d011a20002802002d0000220041bf014d04404100200041b801490d011a200041c97e6a0c010b4100200041f801490d001a200041897e6a0b41016a0b0bff0201037f200028020445044041000f0b2000105041012102024020002802002c00002201417f4a0d00200141ff0171220341b7014d0440200341807f6a0f0b02400240200141ff0171220141bf014d0440024020002802042201200341c97e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241b7012101034020012003460440200241384f0d030c0405200028020020016a41ca7e6a2d00002002410874722102200141016a21010c010b000b000b200141f7014d0440200341c07e6a0f0b024020002802042201200341897e6a22024d047f100020002802040520010b4102490d0020002802002d00010d0010000b200241054f044010000b20002802002d000145044010000b4100210241f701210103402001200346044020024138490d0305200028020020016a418a7e6a2d00002002410874722102200141016a21010c010b0b0b200241ff7d490d010b10000b20020b4101017f200028020445044010000b0240200028020022012d0000418101470d00200028020441014d047f100020002802000520010b2c00014100480d0010000b0bb50102057f017e230041106b22022400200041046a210102402000280200220304402001280200220504402005200041086a2802006a21040b20002004360204200041086a2003360200200241086a20014100200420031052105320002002290308220637020420004100200028020022002006422088a76b2201200120004b1b3602000c010b200020012802002201047f2001200041086a2802006a0541000b360204200041086a41003602000b200241106a24000b3c01017f230041306b22022400200220013602142002200036021020022002290310370308200241186a200241086a4114104c104d200241306a24000b5a01027f2000027f0240200128020022054504400c010b200220036a200128020422014b2001200249720d00410020012003490d011a200220056a2104200120026b20032003417f461b0c010b41000b360204200020043602000be70101037f230041106b2204240020004200370200200041086a410036020020012802042103024002402002450440200321020c010b410021022003450d002003210220012802002d000041c001490d00200441086a2001105520004100200428020c2201200428020822022001105222032003417f461b20024520012003497222031b220536020820004100200220031b3602042000200120056b3602000c010b20012802002103200128020421012000410036020020004100200220016b20034520022001497222021b36020820004100200120036a20021b3602040b200441106a240020000b2101017f2001104f220220012802044b044010000b200020012001104e200210530bd60202077f017e230041206b220324002001280208220420024b0440200341186a2001105520012003280218200328021c105236020c200341106a20011055410021042001027f410020032802102206450d001a410020032802142208200128020c2207490d001a200820072007417f461b210520060b360210200141146a2005360200200141003602080b200141106a210903400240200420024f0d002001280214450d00200341106a2001105541002104027f410020032802102207450d001a410020032802142208200128020c2206490d001a200820066b2104200620076a0b21052001200436021420012005360210200341106a20094100200520041052105320012003290310220a3702102001200128020c200a422088a76a36020c2001200128020841016a22043602080c010b0b20032009290200220a3703082003200a370300200020034114104c1a200341206a24000b980101037f200028020445044041000f0b20001050200028020022022c0000220141004e044020014100470f0b027f4101200141807f460d001a200141ff0171220341b7014d0440200028020441014d047f100020002802000520020b2d00014100470f0b4100200341bf014b0d001a2000280204200141ff017141ca7e6a22014d047f100020002802000520020b20016a2d00004100470b0b800101047f230041106b2201240002402000280204450d0020002802002d000041c001490d00200141086a20001055200128020c210003402000450d01200141002001280208220320032000105222046a20034520002004497222031b3602084100200020046b20031b2100200241016a21020c000b000b200141106a240020020b2d0020002002105a200028020020002802046a20012002103e1a2000200028020420026a36020420002003105b0b1b00200028020420016a220120002802084b044020002001105d0b0b820201047f02402001450d00034020002802102202200028020c460d01200241786a28020020014904401000200028021021020b200241786a2203200328020020016b220136020020010d012000200336021020004101200028020422042002417c6a28020022016b22021027220341016a20024138491b220520046a105c200120002802006a220420056a2004200210400240200241374d0440200028020020016a200241406a3a00000c010b200341f7016a220441ff014d0440200028020020016a20043a00002000280200200120036a6a210103402002450d02200120023a0000200241087621022001417f6a21010c000b000b10000b410121010c000b000b0b0f0020002001105d200020013602040b2f01017f200028020820014904402001104220002802002000280204103e210220002001360208200020023602000b0b8d0201057f02402001044020002802042104200041106a2802002202200041146a280200220349044020022001ad2004ad422086843702002000200028021041086a3602100f0b027f41002002200028020c22026b410375220541016a2206200320026b2202410275220320032006491b41ffffffff01200241037541ffffffff00491b2202450d001a200241037410430b2103200320054103746a22052001ad2004ad4220868437020020052000280210200028020c22016b22046b2106200441014e0440200620012004103e1a200028020c21010b2000200320024103746a3602142000200541086a3602102000200636020c2001450d010f0b200041c001105f200041004100410110590b0b250020004101105a200028020020002802046a20013a00002000200028020441016a3602040b5e01027f20011027220241b7016a22034180024e044010000b2000200341ff0171105f2000200028020420026a105c200028020420002802006a417f6a2100034020010440200020013a0000200141087621012000417f6a21000c010b0b0b7701027f2001280200210341012102024002400240024020012802042201410146044020032c000022014100480d012000200141ff0171105f0c040b200141374b0d01200121020b200020024180017341ff0171105f0c010b200020011060200121020b200020032002410010590b20004101105b20000bba0202037f037e024020015004402000418001105f0c010b20014280015a044020012105034020052006845045044020064238862005420888842105200241016a2102200642088821060c010b0b0240200241384f04402002210303402003044020034108762103200441016a21040c010b0b200441c9004f044010000b2000200441b77f6a41ff0171105f2000200028020420046a105c200028020420002802006a417f6a21042002210303402003450d02200420033a0000200341087621032004417f6a21040c000b000b200020024180017341ff0171105f0b2000200028020420026a105c200028020420002802006a417f6a210203402001200784500d02200220013c0000200742388620014208888421012002417f6a2102200742088821070c000b000b20002001a741ff0171105f0b20004101105b0b0b2301004180080b1c696e6974006164645f6d657373616765006765745f6d657373616765";

    private static String BINARY = BINARY_0;

    public static final String FUNC_ADD_MESSAGE = "add_message";

    public static final String FUNC_GET_MESSAGE = "get_message";

    protected InitWithObjectParams(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected InitWithObjectParams(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<InitWithObjectParams> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider, My_message one_message) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(one_message));
        return deployRemoteCall(InitWithObjectParams.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<InitWithObjectParams> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider, My_message one_message) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList(one_message));
        return deployRemoteCall(InitWithObjectParams.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public RemoteCall<TransactionReceipt> add_message(My_message one_message) {
        final WasmFunction function = new WasmFunction(FUNC_ADD_MESSAGE, Arrays.asList(one_message), Void.class);
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<My_message[]> get_message(String name) {
        final WasmFunction function = new WasmFunction(FUNC_GET_MESSAGE, Arrays.asList(name), My_message[].class);
        return executeRemoteCall(function, My_message[].class);
    }

    public static InitWithObjectParams load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new InitWithObjectParams(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static InitWithObjectParams load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new InitWithObjectParams(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class Message {
        public String head;
    }

    public static class My_message {
        public Message baseClass;

        public String body;

        public String end;
    }
}
