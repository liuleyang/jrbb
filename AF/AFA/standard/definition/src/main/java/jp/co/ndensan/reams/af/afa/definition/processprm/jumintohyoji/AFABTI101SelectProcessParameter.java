/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.jumintohyoji.JuminTohyojiSelectMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
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
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTI101SelectProcessParameter implements IBatchProcessParameter {

    private RString 帳票ID;
    private RString sort;

    private RString order順;

    private List<RString> 改頁項目IDリスト;

    private RString 処理種別;

    private ShohonNo 抄本番号;

    private RString 抄本名;

    private FlexibleDate 投票日;

    private FlexibleDate 投票開始日;

    private boolean 日本人フラグ;

    private boolean 外国人フラグ;

    private boolean 住民フラグ;

    private boolean 転出者フラグ;

    private boolean 転入者フラグ;

    private FlexibleDate 転出日;

    private FlexibleDate 転入日;

    private boolean 抽出対象者に公民権停止者の人を含めるフラグ;

    private FlexibleDate 年齢計算基準日;

    private RString 何歳以上;

    private boolean 基準日翌日の誕生日の人を含むフラグ;

    private FlexibleDate 住定期間From;
    private FlexibleDate 住定期間To;

    private boolean 期間中_年以上連続で居住フラグ;

    private RString 期間中_年以上連続で居住;

    private RString 住所条件;

    private List<RString> 住所条件選択コードリスト;

    private boolean 住民投票資格者名簿抄本フラグ;

    private List<ShohonNo> 抄本番号List;
    private List<RString> 集計項目IDリスト;
    private RString 出力順;
    private IShikibetsuTaishoPSMSearchKey key;

    /**
     *
     * @param 帳票ID RString
     * @param sort RString
     * @param order順 RString
     * @param 改頁項目IDリスト List<RString>
     * @param 処理種別 処理種別
     * @param 抄本番号 RString
     * @param 抄本名 RString
     * @param 投票日 FlexibleDate
     * @param 投票開始日 FlexibleDate
     * @param 日本人 boolean
     * @param 外国人 boolean
     * @param 住民 boolean
     * @param 転出者 boolean
     * @param 転入者 boolean
     * @param 転出日 FlexibleDate
     * @param 転入日 FlexibleDate
     * @param 抽出対象者に公民権停止者の人を含める boolean
     * @param 年齢計算基準日 FlexibleDate
     * @param 何歳以上 RString
     * @param 基準日翌日の誕生日の人を含む boolean
     * @param 住定期間From FlexibleDate
     * @param 住定期間To FlexibleDate
     * @param 期間中_年以上連続で居住チェック boolean
     * @param 期間中_年以上連続で居住 boolean
     * @param 住所条件 RString
     * @param 住所条件選択コードリスト List<JushoJoken>
     * @param 住民投票資格者名簿抄本 boolean
     * @param 抄本番号List List<ShohonNo>
     * @param 集計項目IDリスト List<RString>
     * @param 出力順 RString
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public AFABTI101SelectProcessParameter(RString 帳票ID, RString sort, RString order順, List<RString> 改頁項目IDリスト,
            RString 処理種別, ShohonNo 抄本番号, RString 抄本名, FlexibleDate 投票日, FlexibleDate 投票開始日,
            boolean 日本人, boolean 外国人, boolean 住民, boolean 転出者, boolean 転入者, FlexibleDate 転出日,
            FlexibleDate 転入日, boolean 抽出対象者に公民権停止者の人を含める, FlexibleDate 年齢計算基準日, RString 何歳以上,
            boolean 基準日翌日の誕生日の人を含む, FlexibleDate 住定期間From, FlexibleDate 住定期間To, boolean 期間中_年以上連続で居住チェック,
            RString 期間中_年以上連続で居住, RString 住所条件, List<RString> 住所条件選択コードリスト, boolean 住民投票資格者名簿抄本, List<ShohonNo> 抄本番号List,
            List<RString> 集計項目IDリスト, RString 出力順, IShikibetsuTaishoPSMSearchKey key) {
        this.帳票ID = 帳票ID;
        this.sort = sort;
        this.order順 = order順;
        this.改頁項目IDリスト = 改頁項目IDリスト;
        this.処理種別 = 処理種別;
        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.投票日 = 投票日;
        this.投票開始日 = 投票開始日;
        this.日本人フラグ = 日本人;
        this.外国人フラグ = 外国人;
        this.住民フラグ = 住民;
        this.転出者フラグ = 転出者;
        this.転入者フラグ = 転入者;
        this.転出日 = 転出日;
        this.転入日 = 転入日;
        this.抽出対象者に公民権停止者の人を含めるフラグ = 抽出対象者に公民権停止者の人を含める;
        this.年齢計算基準日 = 年齢計算基準日;
        this.何歳以上 = 何歳以上;
        this.基準日翌日の誕生日の人を含むフラグ = 基準日翌日の誕生日の人を含む;
        this.住定期間From = 住定期間From;
        this.住定期間To = 住定期間To;
        this.期間中_年以上連続で居住フラグ = 期間中_年以上連続で居住チェック;
        this.期間中_年以上連続で居住 = 期間中_年以上連続で居住;
        this.住所条件 = 住所条件;
        this.住所条件選択コードリスト = 住所条件選択コードリスト;
        this.住民投票資格者名簿抄本フラグ = 住民投票資格者名簿抄本;
        this.抄本番号List = 抄本番号List;
        this.集計項目IDリスト = 集計項目IDリスト;
        this.出力順 = 出力順;
        this.key = key;
    }

    /**
     * 住民投票時登録バッチのパラメータクラス。
     *
     * @return JuminTohyojiMybatisParameter
     */
    public JuminTohyojiSelectMybatisParameter toJuminTohyojiSelectMybatisParameter() {
        return new JuminTohyojiSelectMybatisParameter(抄本番号List, 出力順, null, key, null, null, null, null, null, null);
    }
}
