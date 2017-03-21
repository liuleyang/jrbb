/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 海区漁業調整委員会委員選挙時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0470-030 jihb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SenkyojiKaikuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private FlexibleDate 出年月日;
    private FlexibleDate 基準日;
    private Code 選挙種類;
    private FlexibleDate 名簿基準日;
    private ShohonNo 抄本番号;
    private RString 出力順;
    private RString 処理種別;
    private RString table;
    private List<ShohonNo> 抄本番号List;
    private List<RString> idoJiyuCodeList;
    private RYear 年度;
    private RString 利用区分;
    private RString 抽出区分;
    private RDateTime 前回日時;
    private RDateTime 今回日時;
    private RString 注意種類コード;
    private RString 有効期限;
    private UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    private FlexibleDate 名簿確定日;
    private FlexibleDate 年齢到達日;
    private FlexibleDate 最新化時点日;
    private boolean 最新化有無;
    private boolean 名簿並び替え有無;
    private ShikibetsuCode 識別コード;
    private List<ShikibetsuCode> 識別コードList;

    /**
     *
     * @param 出年月日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @param 選挙種類 Code
     * @param 名簿基準日 FlexibleDate
     * @param 抄本番号 ShohonNo
     * @param 出力順 RString
     * @param 処理種別 RString
     * @param table RString
     * @param 抄本番号List List<ShohonNo>
     * @param idoJiyuCodeList List<RString>
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 年度 RYear
     * @param 利用区分 RString
     * @param 抽出区分 RString
     * @param 前回日時 RDateTime
     * @param 今回日時 RDateTime
     * @param 注意種類コード RString
     * @param 有効期限 RString
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @param 名簿確定日 FlexibleDate
     * @param 年齢到達日 FlexibleDate
     * @param 最新化時点日 FlexibleDate
     * @param 最新化有無 boolean
     * @param 名簿並び替え有無 boolean
     * @param 識別コード ShikibetsuCode
     * @param 識別コードList List<ShikibetsuCode>
     */
    public SenkyojiKaikuMybatisParameter(FlexibleDate 出年月日, FlexibleDate 基準日, Code 選挙種類, FlexibleDate 名簿基準日,
            ShohonNo 抄本番号, RString 出力順, RString 処理種別, RString table, List<ShohonNo> 抄本番号List,
            IShikibetsuTaishoPSMSearchKey searchKey, IShikibetsuTaishoPSMSearchKey keyForAll,
            List<RString> idoJiyuCodeList, RYear 年度, RString 利用区分, RString 抽出区分,
            RDateTime 前回日時, RDateTime 今回日時, RString 注意種類コード, RString 有効期限,
            FlexibleDate 名簿確定日, FlexibleDate 年齢到達日,
            FlexibleDate 最新化時点日, boolean 最新化有無, boolean 名簿並び替え有無,
            ShikibetsuCode 識別コード, List<ShikibetsuCode> 識別コードList) {
        super(searchKey);
        shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(keyForAll);
        this.出年月日 = 出年月日;
        this.基準日 = 基準日;
        this.選挙種類 = 選挙種類;
        this.名簿基準日 = 名簿基準日;
        this.抄本番号 = 抄本番号;
        this.出力順 = 出力順;
        this.処理種別 = 処理種別;
        this.table = table;
        this.抄本番号List = 抄本番号List;
        this.idoJiyuCodeList = idoJiyuCodeList;
        this.年度 = 年度;
        this.利用区分 = 利用区分;
        this.抽出区分 = 抽出区分;
        this.前回日時 = 前回日時;
        this.今回日時 = 今回日時;
        this.注意種類コード = 注意種類コード;
        this.有効期限 = 有効期限;
        this.名簿確定日 = 名簿確定日;
        this.年齢到達日 = 年齢到達日;
        this.最新化時点日 = 最新化時点日;
        this.最新化有無 = 最新化有無;
        this.名簿並び替え有無 = 名簿並び替え有無;
        this.識別コード = 識別コード;
        this.識別コードList = 識別コードList;
    }

}
