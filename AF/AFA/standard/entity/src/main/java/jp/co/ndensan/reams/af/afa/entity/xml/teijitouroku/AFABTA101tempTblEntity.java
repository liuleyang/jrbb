/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku;

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
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名識別対象の一時テーブル作成用entityクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTA101tempTblEntity extends DbTableEntityBase<AFABTA101tempTblEntity> implements IDbAccessable {

    /**
     * 定時登録_temp取得
     */
    @TableName
    public static final RString TEMP_TABLE_NAME;

    static {
        TEMP_TABLE_NAME = new RString("TempUaFt200FindShikibetsuTaisho");
    }

    @CsvField(order = 1, name = "groupCode")
    @TempTableColumnOrder(1)
    private RString groupCode;
    @CsvField(order = 2, name = "tohyokuCodeAdd")
    @TempTableColumnOrder(2)
    private RString tohyokuCodeAdd;
    @CsvField(order = 3, name = "satsu")
    @TempTableColumnOrder(3)
    private RString satsu;
    @CsvField(order = 4, name = "page")
    @TempTableColumnOrder(4)
    private int page;
    @CsvField(order = 5, name = "gyo")
    @TempTableColumnOrder(5)
    private int gyo;
    @CsvField(order = 6, name = "renban")
    @TempTableColumnOrder(6)
    private int renban;
    @CsvField(order = 7, name = "shikibetsuCode")
    @TempTableColumnOrder(7)
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @CsvField(order = 8, name = "genLasdecCode")
    @TempTableColumnOrder(8)
    private LasdecCode genLasdecCode;
    @CsvField(order = 9, name = "kyuLasdecCode")
    @TempTableColumnOrder(9)
    private LasdecCode kyuLasdecCode;
    @CsvField(order = 10, name = "kyuLasdecCodeRenban")
    @TempTableColumnOrder(10)
    private int kyuLasdecCodeRenban;
    @CsvField(order = 11, name = "gyomuCode")
    @TempTableColumnOrder(11)
    private GyomuCode gyomuCode;
    @CsvField(order = 12, name = "rirekiNo")
    @TempTableColumnOrder(12)
    private int rirekiNo;
    @CsvField(order = 13, name = "currentFlag")
    @TempTableColumnOrder(13)
    private boolean currentFlag;
    @CsvField(order = 14, name = "juminShubetsuCode")
    @TempTableColumnOrder(14)
    private RString juminShubetsuCode;
    @CsvField(order = 15, name = "kojinNo")
    @TempTableColumnOrder(15)
    private KojinNo kojinNo;
    @CsvField(order = 16, name = "hojinNo")
    @TempTableColumnOrder(16)
    private HojinNo hojinNo;
    @CsvField(order = 17, name = "shoriYMD")
    @TempTableColumnOrder(17)
    private FlexibleDate shoriYMD;
    @CsvField(order = 18, name = "idoJiyuCode")
    @TempTableColumnOrder(18)
    private RString idoJiyuCode;
    @CsvField(order = 19, name = "idoYMD")
    @TempTableColumnOrder(19)
    private FlexibleDate idoYMD;
    @CsvField(order = 20, name = "todokedeJiyuCode")
    @TempTableColumnOrder(20)
    private RString todokedeJiyuCode;
    @CsvField(order = 21, name = "todokedeYMD")
    @TempTableColumnOrder(21)
    private FlexibleDate todokedeYMD;
    @CsvField(order = 22, name = "idoRiyuCode")
    @TempTableColumnOrder(22)
    private Code idoRiyuCode;
    @CsvField(order = 23, name = "meisho")
    @TempTableColumnOrder(23)
    private AtenaMeisho meisho;
    @CsvField(order = 24, name = "kanaMeisho")
    @TempTableColumnOrder(24)
    private AtenaKanaMeisho kanaMeisho;
    @CsvField(order = 25, name = "kannaiKangaiKubun")
    @TempTableColumnOrder(25)
    private RString kannaiKangaiKubun;
    @CsvField(order = 26, name = "yubinNo")
    @TempTableColumnOrder(26)
    private YubinNo yubinNo;
    @CsvField(order = 27, name = "choikiCode")
    @TempTableColumnOrder(27)
    private ChoikiCode choikiCode;
    @CsvField(order = 28, name = "zenkokuJushoCode")
    @TempTableColumnOrder(28)
    private ZenkokuJushoCode zenkokuJushoCode;
    @CsvField(order = 29, name = "jusho")
    @TempTableColumnOrder(29)
    private AtenaJusho jusho;
    @CsvField(order = 30, name = "banchiCode1")
    @TempTableColumnOrder(30)
    private BanchiCode banchiCode1;
    @CsvField(order = 31, name = "banchiCode2")
    @TempTableColumnOrder(31)
    private BanchiCode banchiCode2;
    @CsvField(order = 32, name = "banchiCode3")
    @TempTableColumnOrder(32)
    private BanchiCode banchiCode3;
    @CsvField(order = 33, name = "banchiCode4")
    @TempTableColumnOrder(33)
    private BanchiCode banchiCode4;
    @CsvField(order = 34, name = "banchi")
    @TempTableColumnOrder(34)
    private AtenaBanchi banchi;
    @CsvField(order = 35, name = "katagaki")
    @TempTableColumnOrder(35)
    private Katagaki katagaki;
    @CsvField(order = 36, name = "katagakiInjiFlag")
    @TempTableColumnOrder(36)
    private boolean katagakiInjiFlag;
    @CsvField(order = 37, name = "gyoseikuCode")
    @TempTableColumnOrder(37)
    private GyoseikuCode gyoseikuCode;
    @CsvField(order = 38, name = "gyoseikuName")
    @TempTableColumnOrder(38)
    private RString gyoseikuName;
    @CsvField(order = 39, name = "chikuCode1")
    @TempTableColumnOrder(39)
    private ChikuCode chikuCode1;
    @CsvField(order = 40, name = "chikuName1")
    @TempTableColumnOrder(40)
    private RString chikuName1;
    @CsvField(order = 41, name = "chikuCode2")
    @TempTableColumnOrder(41)
    private ChikuCode chikuCode2;
    @CsvField(order = 42, name = "chikuName2")
    @TempTableColumnOrder(42)
    private RString chikuName2;
    @CsvField(order = 43, name = "chikuCode3")
    @TempTableColumnOrder(43)
    private ChikuCode chikuCode3;
    @CsvField(order = 44, name = "chikuName3")
    @TempTableColumnOrder(44)
    private RString chikuName3;
    @CsvField(order = 45, name = "shogakkokuCode")
    @TempTableColumnOrder(45)
    private ShogakkokuCode shogakkokuCode;
    @CsvField(order = 46, name = "shogakkokuName")
    @TempTableColumnOrder(46)
    private RString shogakkokuName;
    @CsvField(order = 47, name = "chugakkokuCode")
    @TempTableColumnOrder(47)
    private ChugakkokuCode chugakkokuCode;
    @CsvField(order = 48, name = "chugakkokuName")
    @TempTableColumnOrder(48)
    private RString chugakkokuName;
    @CsvField(order = 49, name = "tohyokuCode")
    @TempTableColumnOrder(49)
    private TohyokuCode tohyokuCode;
    @CsvField(order = 50, name = "tohyokuName")
    @TempTableColumnOrder(50)
    private RString tohyokuName;
    @CsvField(order = 51, name = "juminJotaiCode")
    @TempTableColumnOrder(51)
    private RString juminJotaiCode;
    @CsvField(order = 52, name = "setaiCode")
    @TempTableColumnOrder(52)
    private SetaiCode setaiCode;
    @CsvField(order = 53, name = "seinengappiYMD")
    @TempTableColumnOrder(53)
    private FlexibleDate seinengappiYMD;
    @CsvField(order = 54, name = "seinengappiFushoKubun")
    @TempTableColumnOrder(54)
    private RString seinengappiFushoKubun;
    @CsvField(order = 55, name = "seibetsuCode")
    @TempTableColumnOrder(55)
    private RString seibetsuCode;
    @CsvField(order = 56, name = "tsuzukigaraCode")
    @TempTableColumnOrder(56)
    private TsuzukigaraCode tsuzukigaraCode;
    @CsvField(order = 57, name = "tsuzukigara")
    @TempTableColumnOrder(57)
    private RString tsuzukigara;
    @CsvField(order = 58, name = "kazokuNo")
    @TempTableColumnOrder(58)
    private int kazokuNo;
    @CsvField(order = 59, name = "juminhyoHyojijun")
    @TempTableColumnOrder(59)
    private int juminhyoHyojijun;
    @CsvField(order = 60, name = "kikaYMD")
    @TempTableColumnOrder(60)
    private FlexibleDate kikaYMD;
    @CsvField(order = 61, name = "kanjiShimei")
    @TempTableColumnOrder(61)
    private AtenaMeisho kanjiShimei;
    @CsvField(order = 62, name = "kanaShimei")
    @TempTableColumnOrder(62)
    private AtenaKanaMeisho kanaShimei;
    @CsvField(order = 63, name = "honsekiZenkokuJushoCode")
    @TempTableColumnOrder(63)
    private ZenkokuJushoCode honsekiZenkokuJushoCode;
    @CsvField(order = 64, name = "honsekiChoikiCode")
    @TempTableColumnOrder(64)
    private ChoikiCode honsekiChoikiCode;
    @CsvField(order = 65, name = "honsekiJusho")
    @TempTableColumnOrder(65)
    private AtenaJusho honsekiJusho;
    @CsvField(order = 66, name = "honsekiBanchi")
    @TempTableColumnOrder(66)
    private AtenaBanchi honsekiBanchi;
    @CsvField(order = 67, name = "hittosha")
    @TempTableColumnOrder(67)
    private AtenaMeisho hittosha;
    @CsvField(order = 68, name = "gaikokujinShimei")
    @TempTableColumnOrder(68)
    private AtenaMeisho gaikokujinShimei;
    @CsvField(order = 69, name = "gaikokujinHeikimei")
    @TempTableColumnOrder(69)
    private AtenaMeisho gaikokujinHeikimei;
    @CsvField(order = 70, name = "gaikokujinKanaShimei")
    @TempTableColumnOrder(70)
    private AtenaKanaMeisho gaikokujinKanaShimei;
    @CsvField(order = 71, name = "tsushomei")
    @TempTableColumnOrder(71)
    private AtenaMeisho tsushomei;
    @CsvField(order = 72, name = "shimeiRiyoKubun")
    @TempTableColumnOrder(72)
    private RString shimeiRiyoKubun;
    @CsvField(order = 73, name = "kanaTsushomei")
    @TempTableColumnOrder(73)
    private AtenaKanaMeisho kanaTsushomei;
    @CsvField(order = 74, name = "katakanaHyoki")
    @TempTableColumnOrder(74)
    private AtenaKanaMeisho katakanaHyoki;
    @CsvField(order = 75, name = "kokusekiChiikiCode")
    @TempTableColumnOrder(75)
    private Code kokusekiChiikiCode;
    @CsvField(order = 76, name = "zairyuShikakuCode")
    @TempTableColumnOrder(76)
    private Code zairyuShikakuCode;
    @CsvField(order = 77, name = "zairyuKikanCode")
    @TempTableColumnOrder(77)
    private RString zairyuKikanCode;
    @CsvField(order = 78, name = "zairyuKikantoManryoYMD")
    @TempTableColumnOrder(78)
    private FlexibleDate zairyuKikantoManryoYMD;
    @CsvField(order = 79, name = "zairyuCardtoNo")
    @TempTableColumnOrder(79)
    private RString zairyuCardtoNo;
    @CsvField(order = 80, name = "zairyuCardtoYukoYMD")
    @TempTableColumnOrder(80)
    private FlexibleDate zairyuCardtoYukoYMD;
    @CsvField(order = 81, name = "dai30Jono45niKiteisuruKubun")
    @TempTableColumnOrder(81)
    private RString dai30Jono45niKiteisuruKubun;
    @CsvField(order = 82, name = "setainushiShikibetsuCode")
    @TempTableColumnOrder(82)
    private ShikibetsuCode setainushiShikibetsuCode;
    @CsvField(order = 83, name = "setainushiMei")
    @TempTableColumnOrder(83)
    private AtenaMeisho setainushiMei;
    @CsvField(order = 84, name = "hojinKeitaiCode")
    @TempTableColumnOrder(84)
    private Code hojinKeitaiCode;
    @CsvField(order = 85, name = "hojinKeitaiMeisho")
    @TempTableColumnOrder(85)
    private RString hojinKeitaiMeisho;
    @CsvField(order = 86, name = "hojinKeitaiRyakusho")
    @TempTableColumnOrder(86)
    private RString hojinKeitaiRyakusho;
    @CsvField(order = 87, name = "hojinMeishoHenshuKubun")
    @TempTableColumnOrder(87)
    private RString hojinMeishoHenshuKubun;
    @CsvField(order = 88, name = "hojinKeitaiRyakushoKubun")
    @TempTableColumnOrder(88)
    private RString hojinKeitaiRyakushoKubun;
    @CsvField(order = 89, name = "hojinMeisho")
    @TempTableColumnOrder(89)
    private AtenaMeisho hojinMeisho;
    @CsvField(order = 90, name = "hojinKanaMeisho")
    @TempTableColumnOrder(90)
    private AtenaKanaMeisho hojinKanaMeisho;
    @CsvField(order = 91, name = "hojinShitenMeisho")
    @TempTableColumnOrder(91)
    private AtenaMeisho hojinShitenMeisho;
    @CsvField(order = 92, name = "hojinShitenKanaMeisho")
    @TempTableColumnOrder(92)
    private AtenaKanaMeisho hojinShitenKanaMeisho;
    @CsvField(order = 93, name = "daihyoshaShikibetsuCode")
    @TempTableColumnOrder(93)
    private ShikibetsuCode daihyoshaShikibetsuCode;
    @CsvField(order = 94, name = "daihyoshaJuminShubetsu")
    @TempTableColumnOrder(94)
    private RString daihyoshaJuminShubetsu;
    @CsvField(order = 95, name = "daihyoshaShimei")
    @TempTableColumnOrder(95)
    private AtenaMeisho daihyoshaShimei;
    @CsvField(order = 96, name = "daihyoshaKanaShimei")
    @TempTableColumnOrder(96)
    private AtenaKanaMeisho daihyoshaKanaShimei;
    @CsvField(order = 97, name = "daihyoshaNihonjinShimei")
    @TempTableColumnOrder(97)
    private AtenaMeisho daihyoshaNihonjinShimei;
    @CsvField(order = 98, name = "daihyoshaNihonjinKanaShimei")
    @TempTableColumnOrder(98)
    private AtenaKanaMeisho daihyoshaNihonjinKanaShimei;
    @CsvField(order = 99, name = "daihyoshaGaikokujinShimei")
    @TempTableColumnOrder(99)
    private AtenaMeisho daihyoshaGaikokujinShimei;
    @CsvField(order = 100, name = "daihyoshaGaikokujinHeikimei")
    @TempTableColumnOrder(100)
    private AtenaMeisho daihyoshaGaikokujinHeikimei;
    @CsvField(order = 101, name = "daihyoshaGaikokujinKanaShimei")
    @TempTableColumnOrder(101)
    private AtenaKanaMeisho daihyoshaGaikokujinKanaShimei;
    @CsvField(order = 102, name = "daihyoshaTsushomei")
    @TempTableColumnOrder(102)
    private AtenaMeisho daihyoshaTsushomei;
    @CsvField(order = 103, name = "daihyoshaShimeiRiyoKubun")
    @TempTableColumnOrder(103)
    private RString daihyoshaShimeiRiyoKubun;
    @CsvField(order = 104, name = "daihyoshaKanaTsushomei")
    @TempTableColumnOrder(104)
    private AtenaKanaMeisho daihyoshaKanaTsushomei;
    @CsvField(order = 105, name = "daihyoshaKannaiKangaiKubun")
    @TempTableColumnOrder(105)
    private RString daihyoshaKannaiKangaiKubun;
    @CsvField(order = 106, name = "daihyoshaYubinNo")
    @TempTableColumnOrder(106)
    private YubinNo daihyoshaYubinNo;
    @CsvField(order = 107, name = "daihyoshaChoikiCode")
    @TempTableColumnOrder(107)
    private ChoikiCode daihyoshaChoikiCode;
    @CsvField(order = 108, name = "daihyoshaZenkokuJushoCode")
    @TempTableColumnOrder(108)
    private ZenkokuJushoCode daihyoshaZenkokuJushoCode;
    @CsvField(order = 109, name = "daihyoshaJusho")
    @TempTableColumnOrder(109)
    private AtenaJusho daihyoshaJusho;
    @CsvField(order = 110, name = "daihyoshaBanchiCode1")
    @TempTableColumnOrder(110)
    private BanchiCode daihyoshaBanchiCode1;
    @CsvField(order = 111, name = "daihyoshaBanchiCode2")
    @TempTableColumnOrder(111)
    private BanchiCode daihyoshaBanchiCode2;
    @CsvField(order = 112, name = "daihyoshaBanchiCode3")
    @TempTableColumnOrder(112)
    private BanchiCode daihyoshaBanchiCode3;
    @CsvField(order = 113, name = "daihyoshaBanchiCode4")
    @TempTableColumnOrder(113)
    private BanchiCode daihyoshaBanchiCode4;
    @CsvField(order = 114, name = "daihyoshaBanchi")
    @TempTableColumnOrder(114)
    private AtenaBanchi daihyoshaBanchi;
    @CsvField(order = 115, name = "daihyoshaKatagaki")
    @TempTableColumnOrder(115)
    private Katagaki daihyoshaKatagaki;
    @CsvField(order = 116, name = "ninkachiendantaiTorokuShikakuKubun")
    @TempTableColumnOrder(116)
    private Code ninkachiendantaiTorokuShikakuKubun;
    @CsvField(order = 117, name = "ninkachiendantaiNinkaYMD")
    @TempTableColumnOrder(117)
    private FlexibleDate ninkachiendantaiNinkaYMD;
    @CsvField(order = 118, name = "kojinHojinKBN")
    @TempTableColumnOrder(118)
    private RString kojinHojinKBN;
    @CsvField(order = 119, name = "kyoyushaMeisho")
    @TempTableColumnOrder(119)
    private AtenaMeisho kyoyushaMeisho;
    @CsvField(order = 120, name = "kyoyushaKanaMeisho")
    @TempTableColumnOrder(120)
    private AtenaKanaMeisho kyoyushaKanaMeisho;
    @CsvField(order = 121, name = "torokuJiyuCode")
    @TempTableColumnOrder(121)
    private RString torokuJiyuCode;
    @CsvField(order = 122, name = "torokuIdoYMD")
    @TempTableColumnOrder(122)
    private FlexibleDate torokuIdoYMD;
    @CsvField(order = 123, name = "torokuTodokedeYMD")
    @TempTableColumnOrder(123)
    private FlexibleDate torokuTodokedeYMD;
    @CsvField(order = 124, name = "juteiJiyuCode")
    @TempTableColumnOrder(124)
    private RString juteiJiyuCode;
    @CsvField(order = 125, name = "juteiIdoYMD")
    @TempTableColumnOrder(125)
    private FlexibleDate juteiIdoYMD;
    @CsvField(order = 126, name = "juteiTodokedeYMD")
    @TempTableColumnOrder(126)
    private FlexibleDate juteiTodokedeYMD;
    @CsvField(order = 127, name = "shojoJiyuCode")
    @TempTableColumnOrder(127)
    private RString shojoJiyuCode;
    @CsvField(order = 128, name = "shojoIdoYMD")
    @TempTableColumnOrder(128)
    private FlexibleDate shojoIdoYMD;
    @CsvField(order = 129, name = "shojoTodokedeYMD")
    @TempTableColumnOrder(129)
    private FlexibleDate shojoTodokedeYMD;
    @CsvField(order = 130, name = "aimaiShojobiMongon")
    @TempTableColumnOrder(130)
    private RString aimaiShojobiMongon;
    @CsvField(order = 131, name = "jutonaiYubinNo")
    @TempTableColumnOrder(131)
    private YubinNo jutonaiYubinNo;
    @CsvField(order = 132, name = "jutonaiChoikiCode")
    @TempTableColumnOrder(132)
    private ChoikiCode jutonaiChoikiCode;
    @CsvField(order = 133, name = "jutonaiJusho")
    @TempTableColumnOrder(133)
    private RString jutonaiJusho;
    @CsvField(order = 134, name = "jutonaiBanchiCode1")
    @TempTableColumnOrder(134)
    private BanchiCode jutonaiBanchiCode1;
    @CsvField(order = 135, name = "jutonaiBanchiCode2")
    @TempTableColumnOrder(135)
    private BanchiCode jutonaiBanchiCode2;
    @CsvField(order = 136, name = "jutonaiBanchiCode3")
    @TempTableColumnOrder(136)
    private BanchiCode jutonaiBanchiCode3;
    @CsvField(order = 137, name = "jutonaiBanchiCode4")
    @TempTableColumnOrder(137)
    private BanchiCode jutonaiBanchiCode4;
    @CsvField(order = 138, name = "jutonaiBanchi")
    @TempTableColumnOrder(138)
    private AtenaBanchi jutonaiBanchi;
    @CsvField(order = 139, name = "jutonaiKatagaki")
    @TempTableColumnOrder(139)
    private Katagaki jutonaiKatagaki;
    @CsvField(order = 140, name = "jutonaiKatagakiInjiFlag")
    @TempTableColumnOrder(140)
    private boolean jutonaiKatagakiInjiFlag;
    @CsvField(order = 141, name = "tennyumaeYubinNo")
    @TempTableColumnOrder(141)
    private YubinNo tennyumaeYubinNo;
    @CsvField(order = 142, name = "tennyumaeZenkokuJushoCode")
    @TempTableColumnOrder(142)
    private ZenkokuJushoCode tennyumaeZenkokuJushoCode;
    @CsvField(order = 143, name = "tennyumaeJusho")
    @TempTableColumnOrder(143)
    private AtenaJusho tennyumaeJusho;
    @CsvField(order = 144, name = "tennyumaeBanchi")
    @TempTableColumnOrder(144)
    private AtenaBanchi tennyumaeBanchi;
    @CsvField(order = 145, name = "tennyumaeKatagaki")
    @TempTableColumnOrder(145)
    private Katagaki tennyumaeKatagaki;
    @CsvField(order = 146, name = "tennyumaeSetainushimei")
    @TempTableColumnOrder(146)
    private RString tennyumaeSetainushimei;
    @CsvField(order = 147, name = "tennyumaeKyusei")
    @TempTableColumnOrder(147)
    private AtenaMeisho tennyumaeKyusei;
    @CsvField(order = 148, name = "saishuJutochiYubinNo")
    @TempTableColumnOrder(148)
    private YubinNo saishuJutochiYubinNo;
    @CsvField(order = 149, name = "saishuJutochiZenkokuJushoCode")
    @TempTableColumnOrder(149)
    private ZenkokuJushoCode saishuJutochiZenkokuJushoCode;
    @CsvField(order = 150, name = "saishuJutochiJusho")
    @TempTableColumnOrder(150)
    private AtenaJusho saishuJutochiJusho;
    @CsvField(order = 151, name = "saishuJutochiBanchi")
    @TempTableColumnOrder(151)
    private AtenaBanchi saishuJutochiBanchi;
    @CsvField(order = 152, name = "saishuJutochiKatagaki")
    @TempTableColumnOrder(152)
    private Katagaki saishuJutochiKatagaki;
    @CsvField(order = 153, name = "saishuJutochiSetainushimei")
    @TempTableColumnOrder(153)
    private RString saishuJutochiSetainushimei;
    @CsvField(order = 154, name = "tenshutsuYoteiIdoYMD")
    @TempTableColumnOrder(154)
    private FlexibleDate tenshutsuYoteiIdoYMD;
    @CsvField(order = 155, name = "tenshutsuYoteiYubinNo")
    @TempTableColumnOrder(155)
    private YubinNo tenshutsuYoteiYubinNo;
    @CsvField(order = 156, name = "tenshutsuYoteiZenkokuJushoCode")
    @TempTableColumnOrder(156)
    private ZenkokuJushoCode tenshutsuYoteiZenkokuJushoCode;
    @CsvField(order = 157, name = "tenshutsuYoteiJusho")
    @TempTableColumnOrder(157)
    private AtenaJusho tenshutsuYoteiJusho;
    @CsvField(order = 158, name = "tenshutsuYoteiBanchi")
    @TempTableColumnOrder(158)
    private AtenaBanchi tenshutsuYoteiBanchi;
    @CsvField(order = 159, name = "tenshutsuYoteiKatagaki")
    @TempTableColumnOrder(159)
    private Katagaki tenshutsuYoteiKatagaki;
    @CsvField(order = 160, name = "tenshutsuYoteiSetainushimei")
    @TempTableColumnOrder(160)
    private RString tenshutsuYoteiSetainushimei;
    @CsvField(order = 161, name = "tenshutsuKakuteiIdoYMD")
    @TempTableColumnOrder(161)
    private FlexibleDate tenshutsuKakuteiIdoYMD;
    @CsvField(order = 162, name = "tenshutsuKakuteiTsuchiYMD")
    @TempTableColumnOrder(162)
    private FlexibleDate tenshutsuKakuteiTsuchiYMD;
    @CsvField(order = 163, name = "tenshutsuKakuteiYubinNo")
    @TempTableColumnOrder(163)
    private YubinNo tenshutsuKakuteiYubinNo;
    @CsvField(order = 164, name = "tenshutsuKakuteiZenkokuJushoCode")
    @TempTableColumnOrder(164)
    private ZenkokuJushoCode tenshutsuKakuteiZenkokuJushoCode;
    @CsvField(order = 165, name = "tenshutsuKakuteiJusho")
    @TempTableColumnOrder(165)
    private AtenaJusho tenshutsuKakuteiJusho;
    @CsvField(order = 166, name = "tenshutsuKakuteiBanchi")
    @TempTableColumnOrder(166)
    private AtenaBanchi tenshutsuKakuteiBanchi;
    @CsvField(order = 167, name = "tenshutsuKakuteiKatagaki")
    @TempTableColumnOrder(167)
    private Katagaki tenshutsuKakuteiKatagaki;
    @CsvField(order = 168, name = "tenshutsuKakuteiSetainushimei")
    @TempTableColumnOrder(168)
    private RString tenshutsuKakuteiSetainushimei;
    @CsvField(order = 169, name = "juminhyoUtsushiHakkoSeigyoKubun")
    @TempTableColumnOrder(169)
    private RString juminhyoUtsushiHakkoSeigyoKubun;
    @CsvField(order = 170, name = "renrakusaki1")
    @TempTableColumnOrder(170)
    private TelNo renrakusaki1;
    @CsvField(order = 171, name = "kensakuRenrakusaki1")
    @TempTableColumnOrder(171)
    private TelNo kensakuRenrakusaki1;
    @CsvField(order = 172, name = "renrakusakiKubun1")
    @TempTableColumnOrder(172)
    private Code renrakusakiKubun1;
    @CsvField(order = 173, name = "renrakusaki2")
    @TempTableColumnOrder(173)
    private TelNo renrakusaki2;
    @CsvField(order = 174, name = "kensakuRenrakusaki2")
    @TempTableColumnOrder(174)
    private TelNo kensakuRenrakusaki2;
    @CsvField(order = 175, name = "renrakusakiKubun2")
    @TempTableColumnOrder(175)
    private Code renrakusakiKubun2;
    @CsvField(order = 176, name = "renrakusaki3")
    @TempTableColumnOrder(176)
    private TelNo renrakusaki3;
    @CsvField(order = 177, name = "kensakuRenrakusaki3")
    @TempTableColumnOrder(177)
    private TelNo kensakuRenrakusaki3;
    @CsvField(order = 178, name = "renrakusakiKubun3")
    @TempTableColumnOrder(178)
    private Code renrakusakiKubun3;
    @CsvField(order = 179, name = "mailAddress")
    @TempTableColumnOrder(179)
    private MailAddress mailAddress;
    @CsvField(order = 180, name = "biko")
    @TempTableColumnOrder(180)
    private RString biko;
    @CsvField(order = 181, name = "lastUpdateTimestamp")
    @TempTableColumnOrder(181)
    private RDateTime lastUpdateTimestamp;
    @CsvField(order = 182, name = "lastUpdateReamsLoginId")
    @TempTableColumnOrder(182)
    private RString lastUpdateReamsLoginId;
    @CsvField(order = 183, name = "jutogaiKanriUpdateCount")
    @TempTableColumnOrder(183)
    private int jutogaiKanriUpdateCount;
    @CsvField(order = 184, name = "jutogaiKanriTorokuNo")
    @TempTableColumnOrder(184)
    private Integer jutogaiKanriTorokuNo;
    @CsvField(order = 185, name = "jutogaiKojinKihonUpdateCount")
    @TempTableColumnOrder(185)
    private int jutogaiKojinKihonUpdateCount;
    @CsvField(order = 186, name = "jutogaiKojinKihonTorokuNo")
    @TempTableColumnOrder(186)
    private Integer jutogaiKojinKihonTorokuNo;
    @CsvField(order = 187, name = "jutogaiNihonjinUpdateCount")
    @TempTableColumnOrder(187)
    private int jutogaiNihonjinUpdateCount;
    @CsvField(order = 188, name = "jutogaiNihonjinTorokuNo")
    @TempTableColumnOrder(188)
    private Integer jutogaiNihonjinTorokuNo;
    @CsvField(order = 189, name = "jutogaiGaikokujinUpdateCount")
    @TempTableColumnOrder(189)
    private int jutogaiGaikokujinUpdateCount;
    @CsvField(order = 190, name = "jutogaiGaikokujinTorokuNo")
    @TempTableColumnOrder(190)
    private Integer jutogaiGaikokujinTorokuNo;
    @CsvField(order = 191, name = "hojinUpdateCount")
    @TempTableColumnOrder(191)
    private int hojinUpdateCount;
    @CsvField(order = 192, name = "hojinTorokuNo")
    @TempTableColumnOrder(192)
    private Integer hojinTorokuNo;
    @CsvField(order = 193, name = "kyoyushaUpdateCount")
    @TempTableColumnOrder(193)
    private int kyoyushaUpdateCount;
    @CsvField(order = 194, name = "kyoyushaTorokuNo")
    @TempTableColumnOrder(194)
    private Integer kyoyushaTorokuNo;
    @CsvField(order = 195, name = "shimeiSearchTorokuNo")
    @TempTableColumnOrder(195)
    private Integer shimeiSearchTorokuNo;
    @CsvField(order = 196, name = "yusenShimeiUpdateCount")
    @TempTableColumnOrder(196)
    private int yusenShimeiUpdateCount;
    @CsvField(order = 197, name = "yusenShimeiTimestamp")
    @TempTableColumnOrder(197)
    private RDateTime yusenShimeiTimestamp;
}
