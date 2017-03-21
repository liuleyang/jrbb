/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu;

import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
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
public class AFABTB201NninIjoSetaiListEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(2)
    private RString groupKubun;
    @TempTableColumnOrder(3)
    private Decimal setaiSuji;

}
