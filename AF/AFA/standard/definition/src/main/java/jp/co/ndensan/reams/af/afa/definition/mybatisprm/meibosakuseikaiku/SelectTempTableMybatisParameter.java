/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
public class SelectTempTableMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 出力順;
    private RString table;
    private ShohonNo 抄本番号;
    private List<ShohonNo> 抄本番号List;
    private RString 処理種別;
    private Code 選挙種類;
    private RYear 年度;

    /**
     *
     * @param 出力順 RString
     * @param table RString
     * @param 抄本番号 ShohonNo
     * @param 抄本番号List List<ShohonNo>
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 処理種別 RString
     * @param 選挙種類 Code
     * @param 年度 RYear
     */
    public SelectTempTableMybatisParameter(RString 出力順, RString table, ShohonNo 抄本番号, List<ShohonNo> 抄本番号List,
            IShikibetsuTaishoPSMSearchKey searchKey, RString 処理種別, Code 選挙種類, RYear 年度) {
        super(searchKey);
        this.出力順 = 出力順;
        this.table = table;
        this.抄本番号 = 抄本番号;
        this.抄本番号List = 抄本番号List;
        this.処理種別 = 処理種別;
        this.選挙種類 = 選挙種類;
        this.年度 = 年度;
    }

}
