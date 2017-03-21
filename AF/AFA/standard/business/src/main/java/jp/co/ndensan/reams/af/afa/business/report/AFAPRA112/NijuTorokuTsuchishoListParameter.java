/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA112;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 二重登録通知一覧表のパラメータクラスです。
 *
 * @reamsid_L AF-0010-045 xiaoj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NijuTorokuTsuchishoListParameter {

    private SenkyoMeiboShohonEntity 選挙人資格の情報;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    private RString 出力区分;
    private RString 集計;
    private RString 帳票区分;

    /**
     * 宛名PSMを取得します。
     *
     * @return IShikibetsuTaisho 宛名PSM
     *
     */
    public IShikibetsuTaisho toShikibetsuTaisho() {
        return ShikibetsuTaishoFactory.createShikibetsuTaisho(this.get選挙人資格の情報().getAtenaPSMEntity());
    }
}
