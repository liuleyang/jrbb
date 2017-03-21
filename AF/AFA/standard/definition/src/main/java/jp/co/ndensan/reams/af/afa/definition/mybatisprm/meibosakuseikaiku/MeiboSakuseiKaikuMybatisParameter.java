/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 海区漁業調整委員会委員選挙人名簿作成バッチパラメータクラスです。
 *
 * @reamsid_L AF-0460-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class MeiboSakuseiKaikuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private FlexibleDate 出年月日;
    private FlexibleDate 基準日;
    private Code 選挙種類;
    private RYear 年度;
    private FlexibleDate 名簿基準日;
    private ShohonNo 抄本番号;
    private RString 出力順;
    private RString 処理種別;

    /**
     *
     * @param 出年月日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     * @param 年度 RYear
     * @param 名簿基準日 FlexibleDate
     * @param 抄本番号 ShohonNo
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 処理種別 RString
     */
    public MeiboSakuseiKaikuMybatisParameter(FlexibleDate 出年月日, FlexibleDate 基準日, Code 選挙種類, RYear 年度,
            FlexibleDate 名簿基準日, ShohonNo 抄本番号, IShikibetsuTaishoPSMSearchKey searchKey, RString 処理種別) {
        super(searchKey);
        this.出年月日 = 出年月日;
        this.基準日 = 基準日;
        this.選挙種類 = 選挙種類;
        this.年度 = 年度;
        this.名簿基準日 = 名簿基準日;
        this.抄本番号 = 抄本番号;
        this.処理種別 = 処理種別;
    }

}
