/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA111;

import static jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler.getNullToRString;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 二重登録者通知のパラメータクラスです。
 *
 * @reamsid_L AF-0010-044 xiaoj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NijuTorokuTsuchishoParameter {

    private static final int 転入前全国住所コード上5桁 = 5;

    private SenkyoMeiboShohonEntity 選挙人資格の情報;
    private RString 発行番号_第;
    private RString 発行番号_番号;
    private RString 発行番号_号;
    private FlexibleDate 転入期間_開始日;
    private FlexibleDate 転入期間_終了日;
    private RString page;
    private RString layoutIndex;
    private ShichosonAtesaki 他市町村送付先;
    private RString 選挙名称;

    /**
     * コンストラクタ
     *
     * @param 選挙人資格の情報 SenkyoMeiboShohonEntity
     * @param 発行番号_第 RString
     * @param 発行番号_番号 RString
     * @param 発行番号_号 RString
     * @param 転入期間_開始日 FlexibleDate
     * @param 転入期間_終了日 FlexibleDate
     * @param page RString
     * @param layoutIndex RString
     * @param 他市町村送付先 ShichosonAtesaki
     * @param 選挙名称 RString
     */
    public NijuTorokuTsuchishoParameter(SenkyoMeiboShohonEntity 選挙人資格の情報, RString 発行番号_第, RString 発行番号_番号,
            RString 発行番号_号, FlexibleDate 転入期間_開始日, FlexibleDate 転入期間_終了日, RString page, RString layoutIndex,
            ShichosonAtesaki 他市町村送付先, RString 選挙名称) {
        this.選挙人資格の情報 = 選挙人資格の情報;
        this.発行番号_第 = 発行番号_第;
        this.発行番号_番号 = 発行番号_番号;
        this.発行番号_号 = 発行番号_号;
        this.転入期間_開始日 = 転入期間_開始日;
        this.転入期間_終了日 = 転入期間_終了日;
        this.page = page;
        this.layoutIndex = layoutIndex;
        this.他市町村送付先 = 他市町村送付先;
        this.選挙名称 = 選挙名称;
    }

    /**
     * 転入前全国住所コード上5桁を取得します。。
     *
     * @param entity SenkyoMeiboShohonEntity
     * @return 転入前全国住所コード上5桁
     */
    public RString get転入前全国住所コード上5桁(SenkyoMeiboShohonEntity entity) {
        RString 転入前全国住所コード = getNullToRString(entity.getAtenaPSMEntity().getTennyumaeZenkokuJushoCode());
        if (転入前全国住所コード.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 転入前全国住所コード.substring(0, 転入前全国住所コード上5桁);
        }
    }
}
