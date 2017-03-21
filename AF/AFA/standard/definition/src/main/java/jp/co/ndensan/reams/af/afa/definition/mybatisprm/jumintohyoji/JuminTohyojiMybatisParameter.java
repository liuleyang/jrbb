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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
public class JuminTohyojiMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private boolean 日本人フラグ;

    private boolean 外国人フラグ;

    private FlexibleDate 年齢計算基準日;

    private RString 何歳以上;

    private boolean 基準日翌日の誕生日の人を含むフラグ;

    private boolean 住民フラグ;

    private boolean 転出者フラグ;

    private boolean 転入者フラグ;

    private FlexibleDate 転出日;

    private FlexibleDate 転入日;

    private FlexibleDate 住定期間From;

    private FlexibleDate 住定期間To;

    private RString 住所条件;

    private List<RString> 住所条件選択コードリスト;

    private ShohonNo 抄本番号;

    private List<RString> 住民種別条件リスト;

    private FlexibleDate 年齢条件の生年月日;

    private RString 消除事由コード;

    private RString 登録事由コード;

    /**
     * コンストラクタ作成します。
     *
     * @param 日本人フラグ boolean
     * @param 外国人フラグ boolean
     * @param 年齢計算基準日 FlexibleDate
     * @param 何歳以上 RString
     * @param 基準日翌日の誕生日の人を含むフラグ boolean
     * @param 住民フラグ boolean
     * @param 転出者フラグ boolean
     * @param 転入者フラグ boolean
     * @param 転出日 FlexibleDate
     * @param 転入日 FlexibleDate
     * @param 住定期間From FlexibleDate
     * @param 住定期間To FlexibleDate
     * @param 住所条件 RString
     * @param 住所条件選択コードリスト List<RString>
     * @param 抄本番号 ShohonNo
     * @param 住民種別条件リスト List<RString>
     * @param 年齢条件の生年月日 FlexibleDate
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 消除事由コード RString
     * @param 登録事由コード RString
     */
    public JuminTohyojiMybatisParameter(boolean 日本人フラグ, boolean 外国人フラグ,
            FlexibleDate 年齢計算基準日, RString 何歳以上, boolean 基準日翌日の誕生日の人を含むフラグ, boolean 住民フラグ,
            boolean 転出者フラグ, boolean 転入者フラグ, FlexibleDate 転出日, FlexibleDate 転入日, FlexibleDate 住定期間From,
            FlexibleDate 住定期間To, RString 住所条件, List<RString> 住所条件選択コードリスト, ShohonNo 抄本番号,
            List<RString> 住民種別条件リスト, FlexibleDate 年齢条件の生年月日, IShikibetsuTaishoPSMSearchKey searchKey, RString 消除事由コード, RString 登録事由コード
    ) {
        super(searchKey);
        this.日本人フラグ = 日本人フラグ;
        this.外国人フラグ = 外国人フラグ;
        this.年齢計算基準日 = 年齢計算基準日;
        this.何歳以上 = 何歳以上;
        this.基準日翌日の誕生日の人を含むフラグ = 基準日翌日の誕生日の人を含むフラグ;
        this.住民フラグ = 住民フラグ;
        this.転出者フラグ = 転出者フラグ;
        this.転入者フラグ = 転入者フラグ;
        this.転出日 = 転出日;
        this.転入日 = 転入日;
        this.住定期間From = 住定期間From;
        this.住定期間To = 住定期間To;
        this.住所条件 = 住所条件;
        this.住所条件選択コードリスト = 住所条件選択コードリスト;
        this.抄本番号 = 抄本番号;
        this.住民種別条件リスト = 住民種別条件リスト;
        this.年齢条件の生年月日 = 年齢条件の生年月日;
        this.消除事由コード = 消除事由コード;
        this.登録事由コード = 登録事由コード;
    }

}
