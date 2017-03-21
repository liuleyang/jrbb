/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB101;

import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.NijuTorokuChosaKaitoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 二重登録調査票（回答）のパラメタです。
 *
 * @reamsid_L AF-0030-034 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NijuTorokuChosaKaitoParameter {

    private final NijuTorokuChosaKaitoEntity entity;
    private final RString 転出先市町村名;
    private final RString 転出先郵便番号;
    private final RString page;
    private final RString allPage;
    private final RString layoutIndex;
    private final Association 導入団体;
    private final FlexibleDate 転出期間_開始日;
    private final FlexibleDate 転出期間_終了日;

    /**
     * コンストラクタです。
     *
     * @param entity NijuTorokuChosaKaitoEntity
     * @param 転出先市町村名 RString
     * @param 転出先郵便番号 RString
     * @param allPage RString
     * @param 導入団体 Association
     * @param 転出期間_開始日 FlexibleDate
     * @param 転出期間_終了日 FlexibleDate
     * @param page RString
     * @param layoutIndex RString
     *
     */
    public NijuTorokuChosaKaitoParameter(NijuTorokuChosaKaitoEntity entity, RString 転出先市町村名, RString 転出先郵便番号, RString allPage,
            Association 導入団体, FlexibleDate 転出期間_開始日, FlexibleDate 転出期間_終了日, RString page, RString layoutIndex) {
        this.entity = entity;
        this.転出先市町村名 = 転出先市町村名;
        this.転出先郵便番号 = 転出先郵便番号;
        this.導入団体 = 導入団体;
        this.転出期間_開始日 = 転出期間_開始日;
        this.転出期間_終了日 = 転出期間_終了日;
        this.page = page;
        this.allPage = allPage;
        this.layoutIndex = layoutIndex;
    }
}
