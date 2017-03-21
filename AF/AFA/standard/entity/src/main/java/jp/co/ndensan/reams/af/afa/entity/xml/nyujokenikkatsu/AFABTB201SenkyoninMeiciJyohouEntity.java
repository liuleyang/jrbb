/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu;

import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 入場券発行明細情報の一時テーブル作成用entityクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTB201SenkyoninMeiciJyohouEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString jutonaiJusho;
    @TempTableColumnOrder(2)
    private RString meisho;
    @TempTableColumnOrder(3)
    private RString kanaMeisho;
    @TempTableColumnOrder(4)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(5)
    private RString seibetsuCode;
    @TempTableColumnOrder(6)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(7)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(8)
    private RString gyoseikuName;
    @TempTableColumnOrder(9)
    private ChikuCode chikuCode1;
    @TempTableColumnOrder(10)
    private ChikuCode chikuCode2;
    @TempTableColumnOrder(11)
    private ChikuCode chikuCode3;
    @TempTableColumnOrder(12)
    private RString chikuName1;
    @TempTableColumnOrder(13)
    private RString chikuName2;
    @TempTableColumnOrder(14)
    private RString chikuName3;
    @TempTableColumnOrder(15)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(16)
    private TsuzukigaraCode tsuzukigaraCode;
    @TempTableColumnOrder(17)
    private ZenkokuJushoCode zenkokuJushoCode;
    @TempTableColumnOrder(18)
    private ChoikiCode jutonaiChoikiCode;
    @TempTableColumnOrder(19)
    private AtenaBanchi jutonaiBanchi;
    @TempTableColumnOrder(20)
    private Katagaki jutonaiKatagaki;
    @TempTableColumnOrder(21)
    private RString juminShubetsuCode;
    @TempTableColumnOrder(22)
    private int juminhyoHyojijun;
    @TempTableColumnOrder(23)
    private AtenaBanchi banchi;
    @TempTableColumnOrder(24)
    private Katagaki katagaki;
    @TempTableColumnOrder(25)
    private YubinNo teshuYubinNo;
    @TempTableColumnOrder(26)
    private FlexibleDate torokuTodokedeYMD;
    @TempTableColumnOrder(27)
    private AtenaMeisho setainushiMei;
    @TempTableColumnOrder(28)
    private YubinNo yubinNo;
    @TempTableColumnOrder(29)
    private RString tohyokuCode;
    @TempTableColumnOrder(30)
    private RString tohyokuName;
    @TempTableColumnOrder(31)
    private RString tohyojoCode;
    @TempTableColumnOrder(32)
    private RString tohyojoName;
    @TempTableColumnOrder(33)
    private RTime tohyoStartTime;
    @TempTableColumnOrder(34)
    private RTime tohyoStopTime;
    @TempTableColumnOrder(35)
    private int page;
    @TempTableColumnOrder(36)
    private int gyo;
    @TempTableColumnOrder(37)
    private RString groupKubun;
    @TempTableColumnOrder(38)
    private AtenaJusho psmJusho;
    @TempTableColumnOrder(39)
    private AtenaJusho jusho;
    @TempTableColumnOrder(40)
    private RString satsu;
    @TempTableColumnOrder(41)
    private AtenaMeisho setaiName;

}
