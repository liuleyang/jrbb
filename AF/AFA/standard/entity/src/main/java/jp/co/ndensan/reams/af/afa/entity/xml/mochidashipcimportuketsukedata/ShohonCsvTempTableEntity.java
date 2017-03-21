/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.mochidashipcimportuketsukedata;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 抄本ファイルの一時テーブル作成用entityクラスです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShohonCsvTempTableEntity extends DbTableEntityBase<ShohonCsvTempTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private ShohonNo shohonNo;

    @TempTableColumnOrder(2)
    private RString groupCode;

    @TempTableColumnOrder(3)
    private RString senkyokuCode;

    @TempTableColumnOrder(4)
    private RString tohyokuCode;

    @TempTableColumnOrder(5)
    private RString satsu;

    @TempTableColumnOrder(6)
    private RString page;

    @TempTableColumnOrder(7)
    private RString gyo;

    @TempTableColumnOrder(8)
    private RString shichosonCode;

    @TempTableColumnOrder(9)
    private RString yubinNo;

    @TempTableColumnOrder(10)
    private RString jushoCode;

    @TempTableColumnOrder(11)
    private RString jusho;

    @TempTableColumnOrder(12)
    private RString gyoseikuCode;

    @TempTableColumnOrder(13)
    private RString gyoseikuMei;

    @TempTableColumnOrder(14)
    private RString chikuCode1;

    @TempTableColumnOrder(15)
    private RString chikuName1;

    @TempTableColumnOrder(16)
    private RString chikuCode2;

    @TempTableColumnOrder(17)
    private RString chikuName2;

    @TempTableColumnOrder(18)
    private RString chikuCode3;

    @TempTableColumnOrder(19)
    private RString chikuName3;

    @TempTableColumnOrder(20)
    private RString banchiCode1;

    @TempTableColumnOrder(21)
    private RString banchiCode2;

    @TempTableColumnOrder(22)
    private RString banchiCode3;

    @TempTableColumnOrder(23)
    private RString banchi;

    @TempTableColumnOrder(24)
    private RString gatagakiCode;

    @TempTableColumnOrder(25)
    private RString gatagaki;

    @TempTableColumnOrder(26)
    private RString tennyumaeYubinNo;

    @TempTableColumnOrder(27)
    private RString tennyumaeZenkokuJushoCode;

    @TempTableColumnOrder(28)
    private RString tennyumaeJusho;

    @TempTableColumnOrder(29)
    private RString tennyumaeBanchi;

    @TempTableColumnOrder(30)
    private RString tennyumaeKatagaki;

    @TempTableColumnOrder(31)
    private RString tenshutsuSakiYubinNo;

    @TempTableColumnOrder(32)
    private RString tenshutsuSakiZenkokuJushoCode;

    @TempTableColumnOrder(33)
    private RString tenshutsuSakiJusho;

    @TempTableColumnOrder(34)
    private RString tenshutsuSakiBanchi;

    @TempTableColumnOrder(35)
    private RString tenshutsuSakiKatagaki;

    @TempTableColumnOrder(36)
    private RString tenshutsuSakiSetainushimei;

    @TempTableColumnOrder(37)
    private RString juminCode;

    @TempTableColumnOrder(38)
    private RString meisho;

    @TempTableColumnOrder(39)
    private RString kanaMeisho;

    @TempTableColumnOrder(40)
    private RString kensakukanaSeimei;

    @TempTableColumnOrder(41)
    private RString kensakukanaSei;

    @TempTableColumnOrder(42)
    private RString kensakukanamei;

    @TempTableColumnOrder(43)
    private RString meishoTsushomei;

    @TempTableColumnOrder(44)
    private RString kanaTsushomei;

    @TempTableColumnOrder(45)
    private RString setaiCode;

    @TempTableColumnOrder(46)
    private RString setainuShimei;

    @TempTableColumnOrder(47)
    private RString kanaSetainuShimei;

    @TempTableColumnOrder(48)
    private RString juminShubetsuCode;

    @TempTableColumnOrder(49)
    private FlexibleDate seinengappiYMD;

    @TempTableColumnOrder(50)
    private RString seibetsu;

    @TempTableColumnOrder(51)
    private RString tsuzukigaraCode;

    @TempTableColumnOrder(52)
    private RString tsuzukigara;

    @TempTableColumnOrder(53)
    private RString jukiHyojijun;

    @TempTableColumnOrder(54)
    private FlexibleDate jukiTorokuYMD;

    @TempTableColumnOrder(55)
    private FlexibleDate jukiShojoYMD;

    @TempTableColumnOrder(56)
    private FlexibleDate tennyuTodokedeYMD;

    @TempTableColumnOrder(57)
    private FlexibleDate tennyuIdoYMD;

    @TempTableColumnOrder(58)
    private RString tennyuKubun;

    @TempTableColumnOrder(59)
    private FlexibleDate tenshutsuTodokedeYMD;

    @TempTableColumnOrder(60)
    private FlexibleDate tenshutsuIdoYMD;

    @TempTableColumnOrder(61)
    private RString tenshutsuKubun;

    @TempTableColumnOrder(62)
    private RString senkyoShikakuKubun;

    @TempTableColumnOrder(63)
    private FlexibleDate senkyoTorokuYMD;

    @TempTableColumnOrder(64)
    private RString senkyoTorokuJiyuCode;

    @TempTableColumnOrder(65)
    private FlexibleDate hyojiYMD;

    @TempTableColumnOrder(66)
    private RString hyojiJiyuCode;

    @TempTableColumnOrder(67)
    private FlexibleDate masshoYMD;

    @TempTableColumnOrder(68)
    private RString masshoJiyuCode;

    @TempTableColumnOrder(69)
    private RString tenshutsuHyojiKubun;

    @TempTableColumnOrder(70)
    private RString cikkenKubun;

    @TempTableColumnOrder(71)
    private RString kyojyuKubun;

    @TempTableColumnOrder(72)
    private RString fuzaishaKijitsuzen1;

    @TempTableColumnOrder(73)
    private RString fuzaishaKijitsuzen2;

    @TempTableColumnOrder(74)
    private RString fuzaishaKijitsuzen3;

    @TempTableColumnOrder(75)
    private RString fuzaishaKijitsuzen4;

    @TempTableColumnOrder(76)
    private RString fuzaishaKijitsuzen5;

    @TempTableColumnOrder(77)
    private RString fuzaishaKijitsuzen6;

    @TempTableColumnOrder(78)
    private RString fuzaishaKijitsuzen7;

    @TempTableColumnOrder(79)
    private RString fuzaishaKijitsuzen8;

    @TempTableColumnOrder(80)
    private RString fuzaishaKijitsuzen9;

    @TempTableColumnOrder(81)
    private RString tohyoJyokyo1;

    @TempTableColumnOrder(82)
    private RString tohyoJyokyo2;

    @TempTableColumnOrder(83)
    private RString tohyoJyokyo3;

    @TempTableColumnOrder(84)
    private RString tohyoJyokyo4;

    @TempTableColumnOrder(85)
    private RString tohyoJyokyo5;

    @TempTableColumnOrder(86)
    private RString tohyoJyokyo6;

    @TempTableColumnOrder(87)
    private RString tohyoJyokyo7;

    @TempTableColumnOrder(88)
    private RString tohyoJyokyo8;

    @TempTableColumnOrder(89)
    private RString tohyoJyokyo9;

    @TempTableColumnOrder(90)
    private RString koufuShisetsuCode1;

    @TempTableColumnOrder(91)
    private RString koufuShisetsuCode2;

    @TempTableColumnOrder(92)
    private RString koufuShisetsuCode3;

    @TempTableColumnOrder(93)
    private RString koufuShisetsuCode4;

    @TempTableColumnOrder(94)
    private RString koufuShisetsuCode5;

    @TempTableColumnOrder(95)
    private RString koufuShisetsuCode6;

    @TempTableColumnOrder(96)
    private RString koufuShisetsuCode7;

    @TempTableColumnOrder(97)
    private RString koufuShisetsuCode8;

    @TempTableColumnOrder(98)
    private RString koufuShisetsuCode9;

    @TempTableColumnOrder(99)
    private RString youjyoTohyoshaKubun;

    @TempTableColumnOrder(100)
    private RString kosakuMensaki;

    @TempTableColumnOrder(101)
    private RString houjinmei;

    @TempTableColumnOrder(102)
    private RString kumiaiCode;

    @TempTableColumnOrder(103)
    private RString kumiaimei;

    @TempTableColumnOrder(104)
    private RString taihyoshaKubun;

    @TempTableColumnOrder(105)
    private RString juujiNissu;

    @TempTableColumnOrder(106)
    private RString tanmatsuId;

    @TempTableColumnOrder(107)
    private RString isDeleted;

    @TempTableColumnOrder(108)
    private RString updateCount;

    @TempTableColumnOrder(109)
    private RString insertDataTimestamp;

    @TempTableColumnOrder(110)
    private RString insertDataLoginId;

    @TempTableColumnOrder(111)
    private RString lastUpdateDataTimestamp;

    @TempTableColumnOrder(112)
    private RString lastUpdateDataLoginId;

}
