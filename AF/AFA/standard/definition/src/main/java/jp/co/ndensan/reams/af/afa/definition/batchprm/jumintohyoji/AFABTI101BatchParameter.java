/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.jumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101DbProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTI101BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOLISYUBETU = "処理種別";
    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_TOUHYOBI = "投票日";
    private static final String KEY_TOHYOKAISHIYMD = "投票開始日";
    private static final String KEY_JAPANESE = "日本人フラグ";
    private static final String KEY_FOREIGNER = "外国人フラグ";
    private static final String KEY_JUMIN = "住民フラグ";
    private static final String KEY_TENSHUTSUSHA = "転出者フラグ";
    private static final String KEY_TENNYUSHA = "転入者フラグ";
    private static final String KEY_TENSHUTSUYMD = "転出日";
    private static final String KEY_TENNYUYMD = "転入日";
    private static final String KEY_TEISHISHAFUKUMU = "抽出対象者に公民権停止者の人を含めるフラグ";
    private static final String KEY_NENREIKIJUNYMD = "年齢計算基準日";
    private static final String KEY_NENREI = "何歳以上";
    private static final String KEY_NENREIKIJUN = "基準日翌日の誕生日の人を含むフラグ";
    private static final String KEY_JUTEIKIKANFROM = "住定期間From";
    private static final String KEY_JUTEIKIKANTO = "住定期間To";
    private static final String KEY_RENZOKUKIKAN = "期間中_年以上連続で居住フラグ";
    private static final String KEY_KYOJUNENSU = "期間中_年以上連続で居住";
    private static final String KEY_JUSHOJOKEN = "住所条件";
    private static final String KEY_JUSHOJOKENLIST = "住所条件選択コードリスト";
    private static final String KEY_JUMINTOISAK = "住民投票資格者名簿抄本フラグ";

    @BatchParameter(key = KEY_SHOLISYUBETU, name = "処理種別")
    private RString 処理種別;

    @BatchParameter(key = KEY_SHOHON, name = "抄本番号")
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名")
    private RString 抄本名;
    @BatchParameter(key = KEY_TOUHYOBI, name = "投票日")
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_TOHYOKAISHIYMD, name = "投票開始日")
    private FlexibleDate 投票開始日;
    @BatchParameter(key = KEY_JAPANESE, name = "日本人フラグ")
    private boolean 日本人フラグ;
    @BatchParameter(key = KEY_FOREIGNER, name = "外国人フラグ")
    private boolean 外国人フラグ;
    @BatchParameter(key = KEY_JUMIN, name = "住民フラグ")
    private boolean 住民フラグ;
    @BatchParameter(key = KEY_TENSHUTSUSHA, name = "転出者フラグ")
    private boolean 転出者フラグ;
    @BatchParameter(key = KEY_TENNYUSHA, name = "転入者フラグ")
    private boolean 転入者フラグ;
    @BatchParameter(key = KEY_TENSHUTSUYMD, name = "転出日フラグ")
    private FlexibleDate 転出日;
    @BatchParameter(key = KEY_TENNYUYMD, name = "転入日フラグ")
    private FlexibleDate 転入日;
    @BatchParameter(key = KEY_TEISHISHAFUKUMU, name = "抽出対象者に公民権停止者の人を含めるフラグ")
    private boolean 抽出対象者に公民権停止者の人を含めるフラグ;
    @BatchParameter(key = KEY_NENREIKIJUNYMD, name = "年齢計算基準日")
    private FlexibleDate 年齢計算基準日;
    @BatchParameter(key = KEY_NENREI, name = "何歳以上")
    private RString 何歳以上;
    @BatchParameter(key = KEY_NENREIKIJUN, name = "基準日翌日の誕生日の人を含むフラグ")
    private boolean 基準日翌日の誕生日の人を含むフラグ;
    @BatchParameter(key = KEY_JUTEIKIKANFROM, name = "住定期間From")
    private FlexibleDate 住定期間From;
    @BatchParameter(key = KEY_JUTEIKIKANTO, name = "住定期間To")
    private FlexibleDate 住定期間To;
    @BatchParameter(key = KEY_RENZOKUKIKAN, name = "期間中_年以上連続で居住フラグ")
    private boolean 期間中_年以上連続で居住フラグ;
    @BatchParameter(key = KEY_KYOJUNENSU, name = "期間中_年以上連続で居住")
    private RString 期間中_年以上連続で居住;
    @BatchParameter(key = KEY_JUSHOJOKEN, name = "住所条件")
    private RString 住所条件;
    @BatchParameter(key = KEY_JUSHOJOKENLIST, name = "住所条件選択コードリスト")
    private List<RString> 住所条件選択コードリスト;
    @BatchParameter(key = KEY_JUMINTOISAK, name = "住民投票資格者名簿抄本フラグ")
    private boolean 住民投票資格者名簿抄本フラグ;

    /**
     * AFABTI101SelectProcessParameterの変換のメソッドです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     *
     * @return AFABTI101SelectProcessParameter
     */
    public AFABTI101SelectProcessParameter toAFABTI101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey) {

        ShohonNo 抄本番号Class = null;
        if (抄本番号 != null) {
            抄本番号Class = new ShohonNo(抄本番号);
        }
        return new AFABTI101SelectProcessParameter(null, null, null, null,
                処理種別, 抄本番号Class, 抄本名, 投票日, 投票開始日,
                日本人フラグ, 外国人フラグ, 住民フラグ, 転出者フラグ, 転入者フラグ, 転出日,
                転入日, 抽出対象者に公民権停止者の人を含めるフラグ, 年齢計算基準日, 何歳以上,
                基準日翌日の誕生日の人を含むフラグ, 住定期間From, 住定期間To, 期間中_年以上連続で居住フラグ,
                期間中_年以上連続で居住, 住所条件, 住所条件選択コードリスト, 住民投票資格者名簿抄本フラグ, null, null, null, searchKey);
    }

    /**
     * AFABTI101DbProcessParameterの変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 住民種別条件リスト List<RString>
     * @param 年齢条件の生年月日 FlexibleDate
     *
     * @return AFABTI101DbProcessParameter
     */
    public AFABTI101DbProcessParameter toAFABTI101DbProcessParameter(IShikibetsuTaishoPSMSearchKey key, List<RString> 住民種別条件リスト,
            FlexibleDate 年齢条件の生年月日) {
        ShohonNo 抄本番号Class = null;
        if (抄本番号 != null) {
            抄本番号Class = new ShohonNo(抄本番号);
        }
        return new AFABTI101DbProcessParameter(日本人フラグ, 外国人フラグ, 年齢計算基準日, 何歳以上,
                基準日翌日の誕生日の人を含むフラグ, 住民フラグ, 転出者フラグ, 転入者フラグ, 転出日,
                転入日, 住定期間From, 住定期間To, 住所条件, 住所条件選択コードリスト,
                抄本番号Class, 住民種別条件リスト, 年齢条件の生年月日, 抽出対象者に公民権停止者の人を含めるフラグ,
                期間中_年以上連続で居住フラグ, 期間中_年以上連続で居住, 処理種別, key, 抄本名,
                投票日, 投票開始日, 住民投票資格者名簿抄本フラグ, null);
    }

}
