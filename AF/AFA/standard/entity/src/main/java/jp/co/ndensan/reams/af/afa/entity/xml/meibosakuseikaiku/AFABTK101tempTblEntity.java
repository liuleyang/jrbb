/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChugakkokuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.MailAddress;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShogakkokuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名識別対象の一時テーブル作成用entityクラスです。
 *
 * @reamsid_L AF-0460-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTK101tempTblEntity extends DbTableEntityBase<AFABTK101tempTblEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString groupCode;
    @TempTableColumnOrder(2)
    private RString tohyokuCodeAdd;
    @TempTableColumnOrder(3)
    private RString satsu;
    @TempTableColumnOrder(4)
    private int page;
    @TempTableColumnOrder(5)
    private int gyo;
    @TempTableColumnOrder(6)
    private int renban;
    @TempTableColumnOrder(7)
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(8)
    private LasdecCode genLasdecCode;
    @TempTableColumnOrder(9)
    private LasdecCode kyuLasdecCode;
    @TempTableColumnOrder(10)
    private int kyuLasdecCodeRenban;
    @TempTableColumnOrder(11)
    private GyomuCode gyomuCode;
    @TempTableColumnOrder(12)
    private int rirekiNo;
    @TempTableColumnOrder(13)
    private boolean currentFlag;
    @TempTableColumnOrder(14)
    private RString juminShubetsuCode;
    @TempTableColumnOrder(15)
    private KojinNo kojinNo;
    @TempTableColumnOrder(16)
    private HojinNo hojinNo;
    @TempTableColumnOrder(17)
    private FlexibleDate shoriYMD;
    @TempTableColumnOrder(18)
    private RString idoJiyuCode;
    @TempTableColumnOrder(19)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(20)
    private RString todokedeJiyuCode;
    @TempTableColumnOrder(21)
    private FlexibleDate todokedeYMD;
    @TempTableColumnOrder(22)
    private Code idoRiyuCode;
    @TempTableColumnOrder(23)
    private AtenaMeisho meisho;
    @TempTableColumnOrder(24)
    private AtenaKanaMeisho kanaMeisho;
    @TempTableColumnOrder(25)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(26)
    private YubinNo yubinNo;
    @TempTableColumnOrder(27)
    private ChoikiCode choikiCode;
    @TempTableColumnOrder(28)
    private ZenkokuJushoCode zenkokuJushoCode;
    @TempTableColumnOrder(29)
    private AtenaJusho jusho;
    @TempTableColumnOrder(30)
    private BanchiCode banchiCode1;
    @TempTableColumnOrder(31)
    private BanchiCode banchiCode2;
    @TempTableColumnOrder(32)
    private BanchiCode banchiCode3;
    @TempTableColumnOrder(33)
    private BanchiCode banchiCode4;
    @TempTableColumnOrder(34)
    private AtenaBanchi banchi;
    @TempTableColumnOrder(35)
    private Katagaki katagaki;
    @TempTableColumnOrder(36)
    private boolean katagakiInjiFlag;
    @TempTableColumnOrder(37)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(38)
    private RString gyoseikuName;
    @TempTableColumnOrder(39)
    private ChikuCode chikuCode1;
    @TempTableColumnOrder(40)
    private RString chikuName1;
    @TempTableColumnOrder(41)
    private ChikuCode chikuCode2;
    @TempTableColumnOrder(42)
    private RString chikuName2;
    @TempTableColumnOrder(43)
    private ChikuCode chikuCode3;
    @TempTableColumnOrder(44)
    private RString chikuName3;
    @TempTableColumnOrder(45)
    private ShogakkokuCode shogakkokuCode;
    @TempTableColumnOrder(46)
    private RString shogakkokuName;
    @TempTableColumnOrder(47)
    private ChugakkokuCode chugakkokuCode;
    @TempTableColumnOrder(48)
    private RString chugakkokuName;
    @TempTableColumnOrder(49)
    private TohyokuCode tohyokuCode;
    @TempTableColumnOrder(50)
    private RString tohyokuName;
    @TempTableColumnOrder(51)
    private RString juminJotaiCode;
    @TempTableColumnOrder(52)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(53)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(54)
    private RString seinengappiFushoKubun;
    @TempTableColumnOrder(55)
    private RString seibetsuCode;
    @TempTableColumnOrder(56)
    private TsuzukigaraCode tsuzukigaraCode;
    @TempTableColumnOrder(57)
    private RString tsuzukigara;
    @TempTableColumnOrder(58)
    private int kazokuNo;
    @TempTableColumnOrder(59)
    private int juminhyoHyojijun;
    @TempTableColumnOrder(60)
    private FlexibleDate kikaYMD;
    @TempTableColumnOrder(61)
    private AtenaMeisho kanjiShimei;
    @TempTableColumnOrder(62)
    private AtenaKanaMeisho kanaShimei;
    @TempTableColumnOrder(63)
    private ZenkokuJushoCode honsekiZenkokuJushoCode;
    @TempTableColumnOrder(64)
    private ChoikiCode honsekiChoikiCode;
    @TempTableColumnOrder(65)
    private AtenaJusho honsekiJusho;
    @TempTableColumnOrder(66)
    private AtenaBanchi honsekiBanchi;
    @TempTableColumnOrder(67)
    private AtenaMeisho hittosha;
    @TempTableColumnOrder(68)
    private AtenaMeisho gaikokujinShimei;
    @TempTableColumnOrder(69)
    private AtenaMeisho gaikokujinHeikimei;
    @TempTableColumnOrder(70)
    private AtenaKanaMeisho gaikokujinKanaShimei;
    @TempTableColumnOrder(71)
    private AtenaMeisho tsushomei;
    @TempTableColumnOrder(72)
    private RString shimeiRiyoKubun;
    @TempTableColumnOrder(73)
    private AtenaKanaMeisho kanaTsushomei;
    @TempTableColumnOrder(74)
    private AtenaKanaMeisho katakanaHyoki;
    @TempTableColumnOrder(75)
    private Code kokusekiChiikiCode;
    @TempTableColumnOrder(76)
    private Code zairyuShikakuCode;
    @TempTableColumnOrder(77)
    private RString zairyuKikanCode;
    @TempTableColumnOrder(78)
    private FlexibleDate zairyuKikantoManryoYMD;
    @TempTableColumnOrder(79)
    private RString zairyuCardtoNo;
    @TempTableColumnOrder(80)
    private FlexibleDate zairyuCardtoYukoYMD;
    @TempTableColumnOrder(81)
    private RString dai30Jono45niKiteisuruKubun;
    @TempTableColumnOrder(82)
    private ShikibetsuCode setainushiShikibetsuCode;
    @TempTableColumnOrder(83)
    private AtenaMeisho setainushiMei;
    @TempTableColumnOrder(84)
    private Code hojinKeitaiCode;
    @TempTableColumnOrder(85)
    private RString hojinKeitaiMeisho;
    @TempTableColumnOrder(86)
    private RString hojinKeitaiRyakusho;
    @TempTableColumnOrder(87)
    private RString hojinMeishoHenshuKubun;
    @TempTableColumnOrder(88)
    private RString hojinKeitaiRyakushoKubun;
    @TempTableColumnOrder(89)
    private AtenaMeisho hojinMeisho;
    @TempTableColumnOrder(90)
    private AtenaKanaMeisho hojinKanaMeisho;
    @TempTableColumnOrder(91)
    private AtenaMeisho hojinShitenMeisho;
    @TempTableColumnOrder(92)
    private AtenaKanaMeisho hojinShitenKanaMeisho;
    @TempTableColumnOrder(93)
    private ShikibetsuCode daihyoshaShikibetsuCode;
    @TempTableColumnOrder(94)
    private RString daihyoshaJuminShubetsu;
    @TempTableColumnOrder(95)
    private AtenaMeisho daihyoshaShimei;
    @TempTableColumnOrder(96)
    private AtenaKanaMeisho daihyoshaKanaShimei;
    @TempTableColumnOrder(97)
    private AtenaMeisho daihyoshaNihonjinShimei;
    @TempTableColumnOrder(98)
    private AtenaKanaMeisho daihyoshaNihonjinKanaShimei;
    @TempTableColumnOrder(99)
    private AtenaMeisho daihyoshaGaikokujinShimei;
    @TempTableColumnOrder(100)
    private AtenaMeisho daihyoshaGaikokujinHeikimei;
    @TempTableColumnOrder(101)
    private AtenaKanaMeisho daihyoshaGaikokujinKanaShimei;
    @TempTableColumnOrder(102)
    private AtenaMeisho daihyoshaTsushomei;
    @TempTableColumnOrder(103)
    private RString daihyoshaShimeiRiyoKubun;
    @TempTableColumnOrder(104)
    private AtenaKanaMeisho daihyoshaKanaTsushomei;
    @TempTableColumnOrder(105)
    private RString daihyoshaKannaiKangaiKubun;
    @TempTableColumnOrder(106)
    private YubinNo daihyoshaYubinNo;
    @TempTableColumnOrder(107)
    private ChoikiCode daihyoshaChoikiCode;
    @TempTableColumnOrder(108)
    private ZenkokuJushoCode daihyoshaZenkokuJushoCode;
    @TempTableColumnOrder(109)
    private AtenaJusho daihyoshaJusho;
    @TempTableColumnOrder(110)
    private BanchiCode daihyoshaBanchiCode1;
    @TempTableColumnOrder(111)
    private BanchiCode daihyoshaBanchiCode2;
    @TempTableColumnOrder(112)
    private BanchiCode daihyoshaBanchiCode3;
    @TempTableColumnOrder(113)
    private BanchiCode daihyoshaBanchiCode4;
    @TempTableColumnOrder(114)
    private AtenaBanchi daihyoshaBanchi;
    @TempTableColumnOrder(115)
    private Katagaki daihyoshaKatagaki;
    @TempTableColumnOrder(116)
    private Code ninkachiendantaiTorokuShikakuKubun;
    @TempTableColumnOrder(117)
    private FlexibleDate ninkachiendantaiNinkaYMD;
    @TempTableColumnOrder(118)
    private RString kojinHojinKBN;
    @TempTableColumnOrder(119)
    private AtenaMeisho kyoyushaMeisho;
    @TempTableColumnOrder(120)
    private AtenaKanaMeisho kyoyushaKanaMeisho;
    @TempTableColumnOrder(121)
    private RString torokuJiyuCode;
    @TempTableColumnOrder(122)
    private FlexibleDate torokuIdoYMD;
    @TempTableColumnOrder(123)
    private FlexibleDate torokuTodokedeYMD;
    @TempTableColumnOrder(124)
    private RString juteiJiyuCode;
    @TempTableColumnOrder(125)
    private FlexibleDate juteiIdoYMD;
    @TempTableColumnOrder(126)
    private FlexibleDate juteiTodokedeYMD;
    @TempTableColumnOrder(127)
    private RString shojoJiyuCode;
    @TempTableColumnOrder(128)
    private FlexibleDate shojoIdoYMD;
    @TempTableColumnOrder(129)
    private FlexibleDate shojoTodokedeYMD;
    @TempTableColumnOrder(130)
    private RString aimaiShojobiMongon;
    @TempTableColumnOrder(131)
    private YubinNo jutonaiYubinNo;
    @TempTableColumnOrder(132)
    private ChoikiCode jutonaiChoikiCode;
    @TempTableColumnOrder(133)
    private RString jutonaiJusho;
    @TempTableColumnOrder(134)
    private BanchiCode jutonaiBanchiCode1;
    @TempTableColumnOrder(135)
    private BanchiCode jutonaiBanchiCode2;
    @TempTableColumnOrder(136)
    private BanchiCode jutonaiBanchiCode3;
    @TempTableColumnOrder(137)
    private BanchiCode jutonaiBanchiCode4;
    @TempTableColumnOrder(138)
    private AtenaBanchi jutonaiBanchi;
    @TempTableColumnOrder(139)
    private Katagaki jutonaiKatagaki;
    @TempTableColumnOrder(140)
    private boolean jutonaiKatagakiInjiFlag;
    @TempTableColumnOrder(141)
    private YubinNo tennyumaeYubinNo;
    @TempTableColumnOrder(142)
    private ZenkokuJushoCode tennyumaeZenkokuJushoCode;
    @TempTableColumnOrder(143)
    private AtenaJusho tennyumaeJusho;
    @TempTableColumnOrder(144)
    private AtenaBanchi tennyumaeBanchi;
    @TempTableColumnOrder(145)
    private Katagaki tennyumaeKatagaki;
    @TempTableColumnOrder(146)
    private RString tennyumaeSetainushimei;
    @TempTableColumnOrder(147)
    private AtenaMeisho tennyumaeKyusei;
    @TempTableColumnOrder(148)
    private YubinNo saishuJutochiYubinNo;
    @TempTableColumnOrder(149)
    private ZenkokuJushoCode saishuJutochiZenkokuJushoCode;
    @TempTableColumnOrder(150)
    private AtenaJusho saishuJutochiJusho;
    @TempTableColumnOrder(151)
    private AtenaBanchi saishuJutochiBanchi;
    @TempTableColumnOrder(152)
    private Katagaki saishuJutochiKatagaki;
    @TempTableColumnOrder(153)
    private RString saishuJutochiSetainushimei;
    @TempTableColumnOrder(154)
    private FlexibleDate tenshutsuYoteiIdoYMD;
    @TempTableColumnOrder(155)
    private YubinNo tenshutsuYoteiYubinNo;
    @TempTableColumnOrder(156)
    private ZenkokuJushoCode tenshutsuYoteiZenkokuJushoCode;
    @TempTableColumnOrder(157)
    private AtenaJusho tenshutsuYoteiJusho;
    @TempTableColumnOrder(158)
    private AtenaBanchi tenshutsuYoteiBanchi;
    @TempTableColumnOrder(159)
    private Katagaki tenshutsuYoteiKatagaki;
    @TempTableColumnOrder(160)
    private RString tenshutsuYoteiSetainushimei;
    @TempTableColumnOrder(161)
    private FlexibleDate tenshutsuKakuteiIdoYMD;
    @TempTableColumnOrder(162)
    private FlexibleDate tenshutsuKakuteiTsuchiYMD;
    @TempTableColumnOrder(163)
    private YubinNo tenshutsuKakuteiYubinNo;
    @TempTableColumnOrder(164)
    private ZenkokuJushoCode tenshutsuKakuteiZenkokuJushoCode;
    @TempTableColumnOrder(165)
    private AtenaJusho tenshutsuKakuteiJusho;
    @TempTableColumnOrder(166)
    private AtenaBanchi tenshutsuKakuteiBanchi;
    @TempTableColumnOrder(167)
    private Katagaki tenshutsuKakuteiKatagaki;
    @TempTableColumnOrder(168)
    private RString tenshutsuKakuteiSetainushimei;
    @TempTableColumnOrder(169)
    private RString juminhyoUtsushiHakkoSeigyoKubun;
    @TempTableColumnOrder(170)
    private TelNo renrakusaki1;
    @TempTableColumnOrder(171)
    private Code renrakusakiKubun1;
    @TempTableColumnOrder(172)
    private TelNo renrakusaki2;
    @TempTableColumnOrder(173)
    private Code renrakusakiKubun2;
    @TempTableColumnOrder(174)
    private TelNo renrakusaki3;
    @TempTableColumnOrder(175)
    private TelNo kensakuRenrakusaki3;
    @TempTableColumnOrder(176)
    private Code renrakusakiKubun3;
    @TempTableColumnOrder(177)
    private MailAddress mailAddress;
    @TempTableColumnOrder(178)
    private RString biko;
    @TempTableColumnOrder(179)
    private RDateTime lastUpdateTimestamp;
    @TempTableColumnOrder(180)
    private RString lastUpdateReamsLoginId;
    @TempTableColumnOrder(181)
    private int jutogaiKanriUpdateCount;
    @TempTableColumnOrder(182)
    private jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo jutogaiKanriTorokuNo;
    @TempTableColumnOrder(183)
    private int jutogaiKojinKihonUpdateCount;
    @TempTableColumnOrder(184)
    private jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo jutogaiKojinKihonTorokuNo;
    @TempTableColumnOrder(185)
    private int jutogaiNihonjinUpdateCount;
    @TempTableColumnOrder(186)
    private jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo jutogaiNihonjinTorokuNo;
    @TempTableColumnOrder(187)
    private int jutogaiGaikokujinUpdateCount;
    @TempTableColumnOrder(188)
    private jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo jutogaiGaikokujinTorokuNo;
    @TempTableColumnOrder(189)
    private int hojinUpdateCount;
    @TempTableColumnOrder(192)
    private jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo hojinTorokuNo;
    @TempTableColumnOrder(190)
    private int kyoyushaUpdateCount;
    @TempTableColumnOrder(191)
    private jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo kyoyushaTorokuNo;
    @TempTableColumnOrder(192)
    private jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.TorokuNo shimeiSearchTorokuNo;
    @TempTableColumnOrder(193)
    private int yusenShimeiUpdateCount;
    @TempTableColumnOrder(194)
    private RDateTime yusenShimeiTimestamp;
    @TempTableColumnOrder(195)
    private RString kanaName;
    @TempTableColumnOrder(196)
    private RString kanaTsushoName;

    @TempTableColumnOrder(197)
    private RString shohonName;
    @TempTableColumnOrder(198)
    private SenkyoNo senkyoNo;

    @TempTableColumnOrder(199)
    private ShikibetsuCode shikibetsuCodehaiku;
    @TempTableColumnOrder(200)
    private RString gyogyoshaNo;
    @TempTableColumnOrder(201)
    private RString kumiaiCode;
    @TempTableColumnOrder(202)
    private int nissuGyogyosha;
    @TempTableColumnOrder(203)
    private int nissuJujisha;
    @TempTableColumnOrder(204)
    private Code gyogyoShurui;
    @TempTableColumnOrder(205)
    private Code gyosenShubetsu;
    @TempTableColumnOrder(206)
    private RString senmei;
    @TempTableColumnOrder(207)
    private RString torokuNo;

    @TempTableColumnOrder(208)
    private BigSerial kakuSeq;
    @TempTableColumnOrder(209)
    private Code shikakuKubun;

    @TempTableColumnOrder(210)
    private FlexibleDate subTorokuTeishiYMD;
    @TempTableColumnOrder(211)
    private Code subTorokuTeishiJiyuCode;
    @TempTableColumnOrder(212)
    private FlexibleDate subHyojiYMD;
    @TempTableColumnOrder(213)
    private Code subHyojiJiyuCode;
    @TempTableColumnOrder(214)
    private FlexibleDate subKeikiShuryoYMD;
    @TempTableColumnOrder(215)
    private boolean subNikeimochiFlag;

    @TempTableColumnOrder(216)
    private BigSerial seq;
    @TempTableColumnOrder(217)
    private RString senkyoTohyokuCode;
    @TempTableColumnOrder(218)
    private Code senkyoShikakuKubun;
    @TempTableColumnOrder(219)
    private Code senkyoTorokuJiyuCode;

    @TempTableColumnOrder(220)
    private FlexibleDate kiteiNenreiTotatsuYMD;

}
