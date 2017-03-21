/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JuminTohyojiSelectMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private List<ShohonNo> 抄本番号List;
    private RString 出力順;
    private RString コンフィグ住基連動;

    private RString 利用区分;
    private RString 抽出区分;
    private RDateTime 前回日時;
    private RDateTime 今回日時;
    private RString 注意種類コード;
    private RString 有効期限;

    /**
     * コンストラクタ作成します。
     *
     * @param 抄本番号List List<ShohonNo>
     * @param 出力順 RString
     * @param コンフィグ住基連動 RString
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 利用区分 RString
     * @param 抽出区分 RString
     * @param 前回日時 RDateTime
     * @param 今回日時 RDateTime
     * @param 注意種類コード RString
     * @param 有効期限 RString
     */
    public JuminTohyojiSelectMybatisParameter(List<ShohonNo> 抄本番号List, RString 出力順, RString コンフィグ住基連動,
            IShikibetsuTaishoPSMSearchKey searchKey, RString 利用区分, RString 抽出区分, RDateTime 前回日時, RDateTime 今回日時,
            RString 注意種類コード, RString 有効期限) {
        super(searchKey);
        this.抄本番号List = 抄本番号List;
        this.出力順 = 出力順;
        this.コンフィグ住基連動 = コンフィグ住基連動;
        this.利用区分 = 利用区分;
        this.抽出区分 = 抽出区分;
        this.前回日時 = 前回日時;
        this.今回日時 = 今回日時;
        this.注意種類コード = 注意種類コード;
        this.有効期限 = 有効期限;
    }

}
