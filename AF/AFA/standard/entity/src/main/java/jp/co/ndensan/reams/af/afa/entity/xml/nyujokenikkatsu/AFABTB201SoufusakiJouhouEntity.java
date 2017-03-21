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
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 送付先情報の一時テーブル作成用entityクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTB201SoufusakiJouhouEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private YubinNo yubinNo;
    @TempTableColumnOrder(2)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(3)
    private ZenkokuJushoCode zenkokuJushoCode;
    @TempTableColumnOrder(4)
    private ChikuCode chikuCode1;
    @TempTableColumnOrder(5)
    private RString chikuName1;
    @TempTableColumnOrder(6)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(7)
    private AtenaMeisho setaiName;
    @TempTableColumnOrder(8)
    private AtenaJusho jusho;
    @TempTableColumnOrder(9)
    private AtenaBanchi banchi;
    @TempTableColumnOrder(10)
    private Katagaki katagaki;
    @TempTableColumnOrder(11)
    private RString gyoseikuName;
    @TempTableColumnOrder(12)
    private RString meisho;
    @TempTableColumnOrder(13)
    private RString tohyokuCode;
    @TempTableColumnOrder(14)
    private int page;
    @TempTableColumnOrder(15)
    private int gyo;
    @TempTableColumnOrder(16)
    private RString groupKubun;
    @TempTableColumnOrder(17)
    private Decimal setaiSuji;
    @TempTableColumnOrder(18)
    private RString satsu;
    @TempTableColumnOrder(19)
    private ShikibetsuCode shikibetsuCode;
}
