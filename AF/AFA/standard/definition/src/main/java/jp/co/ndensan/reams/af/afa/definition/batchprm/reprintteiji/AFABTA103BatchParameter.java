/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.reprintteiji;

import java.util.ArrayList;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShoriModel;
import jp.co.ndensan.reams.af.afa.definition.processprm.reprintteiji.AFABTA103BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 定時登録再発行のバッチパラメータクラスです。
 *
 * @reamsid_L AF-0020-020 gaoya
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTA103BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHURISHUBETU = "処理種別";
    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SHOHONMEI = "抄本名";
    private static final String KEY_TOUHYOBI = "投票日";
    private static final String KEY_KIJUNBI = "基準日";
    private static final String KEY_TOUROKUBI = "登録日";
    private static final String KEY_TENSHUTUKIGENBI = "転出期限日";
    private static final String KEY_TENNYUKIGENBI = "転入期限日";
    private static final String KEY_NENREIKIGENBI = "年齢期限日";
    private static final String KEY_SHORIBI = "処理日";
    private static final String KEY_SENKYONINMEIBOSHOHONFLG = "選挙人名簿抄本出力有無";
    private static final String KEY_TOKYOKUFROM = "投票区From";
    private static final String KEY_TOKYOKUTO = "投票区To";
    private static final String KEY_EIKYUSENKYONINMEIBOFLG = "永久選挙人名簿出力有無";
    private static final String KEY_SHUTURYOKUJYOKEN = "出力条件";
    private static final String KEY_SHIKIBETUCODE = "識別コード";
    private static final String KEY_SHITEIBI = "指定日";
    private static final String KEY_IDOUJIYU = "異動事由";
    private static final String KEY_SENKYONINMEIBOFLG = "選挙人名簿索引簿出力有無";
    private static final String KEY_TOUROKUSHASULIST = "登録者数リスト出力有無";
    private static final String KEY_JITEN = "時点";
    private static final String KEY_FUZAISHATOHYOSHIKAKUSHAFLG = "不在者投票資格者分作成有無";
    private static final String KEY_FUZAISHIKAKUSAKUSEIFLG = "不在資格対象者名簿作成有無";
    private static final String KEY_YUKENSHAFLG = "有榷者数調べ出力有無";
    private static final String KEY_NIJYUTOUROKUTUUCHIFLG = "二重登録通知出力有無";
    private static final String KEY_HAKOUBI = "発行日";
    private static final String KEY_KAKOUNUM_DAI = "発行番号の第";
    private static final String KEY_KAKOUNUM_NO = "発行番号の番号";
    private static final String KEY_KAKOUNUM_GO = "発行番号の号";
    private static final String KEY_TENNYUKIKAN = "転入期間";
    private static final String KEY_SOUFUSAKIATENASHIRUIFLG = "送付先宛名シール作成有無";
    private static final String KEY_NIJYUTOUROKUTUUCHIIFLG = "二重登録通知一覧表作成有無";
    private static final String KEY_TOUROKUSHAMEIBOFLG = "登録者名簿出力有無";
    private static final String KEY_JYURANYOUSAKUSEIFLG = "縦覧用作成有無_登録者";
    private static final String KEY_SHINKITOUROKUSHAAFLG = "新規登録者宛名シール作成有無";
    private static final String KEY_KIKATAISHOMEIBOFLG = "帰化対象者名簿出力有無";
    private static final String KEY_KIKAKIKAN = "帰化期間";
    private static final String KEY_MASHOSHAMEIBOFLG = "抹消者名簿出力有無";
    private static final String KEY_JYURANYOUFLGMASHOSHA = "縦覧用作成有無_抹消者";
    private static final String KEY_KYOJYUYOKENMEIBOFLG = "居住要件抹消者名簿出力有無";
    private static final String KEY_HYOJISHAMEIBOFLG = "表示者名簿出力有無";
    private static final String KEY_HYOJISHOJYOSHAMEIBOFLG = "表示消除者名簿出力有無";
    private static final String KEY_KITEINENREIMAEMEIBOFLG = "規定年齢前名簿出力有無";
    private static final String KEY_KITEINENREIMAEKUSEIFLG = "規定年齢前シール作成有無";
    private static final String KEY_KITEINENREIMITOUFLG = "規定年齢未到達者名簿出力有無";
    private static final String KEY_SAITENNYUSHAMEIBOFLG = "再転入者名簿出力有無";
    private static final String KEY_TEISEISHAMEIBOFLG = "訂正者名簿出力有無";
    private static final String KEY_TENSHUTUSHAMEIBOFLG = "転出者名簿出力有無";
    private static final String KEY_TOUROKUTEISHISHAMEIBOFLG = "登録停止者名簿出力有無";
    private static final String KEY_ZAIGAISENKYONINMEIBOFLG = "在外選挙人名簿抄本出力有無";
    private static final String KEY_ZAIGAITOUHYOFLG = "在外投票資格者名簿出力有無";

    @BatchParameter(key = KEY_SHOHON, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONMEI, name = "抄本名", order = 5)
    private RString 抄本名;
    @BatchParameter(key = KEY_KIJUNBI, name = "基準日", order = 10)
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_TOUROKUBI, name = "登録日", order = 15)
    private FlexibleDate 登録日;
    @BatchParameter(key = KEY_TENSHUTUKIGENBI, name = "転出期限日", order = 20)
    private FlexibleDate 転出期限日;
    @BatchParameter(key = KEY_TENNYUKIGENBI, name = "転入期限日", order = 25)
    private FlexibleDate 転入期限日;
    @BatchParameter(key = KEY_NENREIKIGENBI, name = "年齢期限日", order = 30)
    private FlexibleDate 年齢期限日;
    @BatchParameter(key = KEY_SHORIBI, name = "処理日", order = 35)
    private FlexibleDate 処理日;
    @BatchParameter(key = KEY_SENKYONINMEIBOSHOHONFLG, name = "選挙人名簿抄本出力有無", order = 40)
    private Boolean 選挙人名簿抄本出力有無;
    @BatchParameter(key = KEY_TOKYOKUFROM, name = "投票区From", order = 45)
    private RString 投票区From;
    @BatchParameter(key = KEY_TOKYOKUTO, name = "投票区To", order = 50)
    private RString 投票区To;
    @BatchParameter(key = KEY_EIKYUSENKYONINMEIBOFLG, name = "永久選挙人名簿出力有無", order = 55)
    private Boolean 永久選挙人名簿出力有無;
    @BatchParameter(key = KEY_SHUTURYOKUJYOKEN, name = "出力条件", order = 60)
    private RString 出力条件;
    @BatchParameter(key = KEY_SHIKIBETUCODE, name = "識別コード", order = 65)
    private RString 識別コード;
    @BatchParameter(key = KEY_SHITEIBI, name = "指定日", order = 70)
    private ArrayList<FlexibleDate> 指定日;
    @BatchParameter(key = KEY_IDOUJIYU, name = "異動事由", order = 75)
    private RString 異動事由;
    @BatchParameter(key = KEY_SENKYONINMEIBOFLG, name = "選挙人名簿索引簿出力有無", order = 80)
    private Boolean 選挙人名簿索引簿出力有無;
    @BatchParameter(key = KEY_TOUROKUSHASULIST, name = "登録者数リスト出力有無", order = 85)
    private Boolean 登録者数リスト出力有無;
    @BatchParameter(key = KEY_JITEN, name = "時点", order = 90)
    private FlexibleDate 時点;
    @BatchParameter(key = KEY_FUZAISHATOHYOSHIKAKUSHAFLG, name = "不在者投票資格者分作成有無", order = 95)
    private Boolean 不在者投票資格者分作成有無;
    @BatchParameter(key = KEY_FUZAISHIKAKUSAKUSEIFLG, name = "不在資格対象者名簿作成有無", order = 100)
    private Boolean 不在資格対象者名簿作成有無;
    @BatchParameter(key = KEY_YUKENSHAFLG, name = "有榷者数調べ出力有無", order = 105)
    private Boolean 有榷者数調べ出力有無;
    @BatchParameter(key = KEY_NIJYUTOUROKUTUUCHIFLG, name = "二重登録通知出力有無", order = 110)
    private Boolean 二重登録通知出力有無;
    @BatchParameter(key = KEY_HAKOUBI, name = "発行日", order = 115)
    private FlexibleDate 発行日;
    @BatchParameter(key = KEY_KAKOUNUM_DAI, name = "発行番号の第", order = 120)
    private RString 発行番号の第;
    @BatchParameter(key = KEY_KAKOUNUM_NO, name = "発行番号の番号", order = 125)
    private RString 発行番号の番号;
    @BatchParameter(key = KEY_KAKOUNUM_GO, name = "発行番号の号", order = 130)
    private RString 発行番号の号;
    @BatchParameter(key = KEY_TENNYUKIKAN, name = "転入期間", order = 135)
    private ArrayList<FlexibleDate> 転入期間;
    @BatchParameter(key = KEY_SOUFUSAKIATENASHIRUIFLG, name = "送付先宛名シール作成有無", order = 140)
    private Boolean 送付先宛名シール作成有無;
    @BatchParameter(key = KEY_NIJYUTOUROKUTUUCHIIFLG, name = "二重登録通知一覧表作成有無", order = 145)
    private Boolean 二重登録通知一覧表作成有無;
    @BatchParameter(key = KEY_TOUROKUSHAMEIBOFLG, name = "登録者名簿出力有無", order = 150)
    private Boolean 登録者名簿出力有無;
    @BatchParameter(key = KEY_JYURANYOUSAKUSEIFLG, name = "縦覧用作成有無_登録者", order = 155)
    private Boolean 縦覧用作成有無_登録者;
    @BatchParameter(key = KEY_SHINKITOUROKUSHAAFLG, name = "新規登録者宛名シール作成有無", order = 160)
    private Boolean 新規登録者宛名シール作成有無;
    @BatchParameter(key = KEY_KIKATAISHOMEIBOFLG, name = "帰化対象者名簿出力有無", order = 165)
    private Boolean 帰化対象者名簿出力有無;
    @BatchParameter(key = KEY_KIKAKIKAN, name = "帰化期間", order = 170)
    private ArrayList<FlexibleDate> 帰化期間;
    @BatchParameter(key = KEY_MASHOSHAMEIBOFLG, name = "抹消者名簿出力有無", order = 175)
    private Boolean 抹消者名簿出力有無;
    @BatchParameter(key = KEY_JYURANYOUFLGMASHOSHA, name = "縦覧用作成有無_抹消者", order = 180)
    private Boolean 縦覧用作成有無_抹消者;
    @BatchParameter(key = KEY_KYOJYUYOKENMEIBOFLG, name = "居住要件抹消者名簿出力有無", order = 185)
    private Boolean 居住要件抹消者名簿出力有無;
    @BatchParameter(key = KEY_HYOJISHAMEIBOFLG, name = "表示者名簿出力有無", order = 190)
    private Boolean 表示者名簿出力有無;
    @BatchParameter(key = KEY_HYOJISHOJYOSHAMEIBOFLG, name = "表示消除者名簿出力有無", order = 195)
    private Boolean 表示消除者名簿出力有無;
    @BatchParameter(key = KEY_KITEINENREIMAEMEIBOFLG, name = "規定年齢前名簿出力有無", order = 200)
    private Boolean 規定年齢前名簿出力有無;
    @BatchParameter(key = KEY_KITEINENREIMAEKUSEIFLG, name = "規定年齢前シール作成有無", order = 205)
    private Boolean 規定年齢前シール作成有無;
    @BatchParameter(key = KEY_KITEINENREIMITOUFLG, name = "規定年齢未到達者名簿出力有無", order = 210)
    private Boolean 規定年齢未到達者名簿出力有無;
    @BatchParameter(key = KEY_SAITENNYUSHAMEIBOFLG, name = "再転入者名簿出力有無", order = 215)
    private Boolean 再転入者名簿出力有無;
    @BatchParameter(key = KEY_TEISEISHAMEIBOFLG, name = "訂正者名簿出力有無", order = 220)
    private Boolean 訂正者名簿出力有無;
    @BatchParameter(key = KEY_TENSHUTUSHAMEIBOFLG, name = "転出者名簿出力有無", order = 225)
    private Boolean 転出者名簿出力有無;
    @BatchParameter(key = KEY_TOUROKUTEISHISHAMEIBOFLG, name = "登録停止者名簿出力有無", order = 230)
    private Boolean 登録停止者名簿出力有無;
    @BatchParameter(key = KEY_ZAIGAISENKYONINMEIBOFLG, name = "在外選挙人名簿抄本出力有無", order = 235)
    private Boolean 在外選挙人名簿抄本出力有無;
    @BatchParameter(key = KEY_ZAIGAITOUHYOFLG, name = "在外投票資格者名簿出力有無", order = 240)
    private Boolean 在外投票資格者名簿出力有無;
    @BatchParameter(key = KEY_SHURISHUBETU, name = "処理種別", order = 245)
    private RString 処理種別;
    @BatchParameter(key = KEY_TOUHYOBI, name = "投票日", order = 250)
    private FlexibleDate 投票日;

    /**
     * 定時登録再発行バッチの検索プロセス入力パラメータに変換して返します。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyFoAll IShikibetsuTaishoPSMSearchKey
     * @return バッチの検索プロセスの入力パラメータ
     */
    public AFABTA101SelectProcessParameter toAFABTA101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyFoAll) {
        ShohonNo shohonNo = (抄本番号 == null || 抄本番号.isEmpty()) ? null : new ShohonNo(抄本番号);
        return new AFABTA101SelectProcessParameter(処理種別, shohonNo, 抄本名, 基準日, 登録日, 投票日, 転出期限日, 転入期限日, 年齢期限日,
                帰化期間, key, keyFoAll, 出力条件, 識別コード, 指定日.get(0), 指定日.get(1), 異動事由, 投票区From, 投票区To, ShoriModel.通常処理.code());
    }

    /**
     * 定時登録再発行バッチ出力条件リスト入力パラメータに変換して返します。
     *
     * @return バッチ出力条件リスト入力パラメータ
     */
    public AFABTA103BatchPrintProcessParameter toAFABTA103BatchPrintProcessParameter() {
        ShohonNo shohonNo = (抄本番号 == null || 抄本番号.isEmpty()) ? null : new ShohonNo(抄本番号);
        return new AFABTA103BatchPrintProcessParameter(shohonNo, 抄本名, 基準日, 登録日, 転出期限日, 転入期限日, 年齢期限日, 処理日,
                選挙人名簿抄本出力有無, 永久選挙人名簿出力有無, 出力条件, 識別コード, 指定日, 異動事由, 選挙人名簿索引簿出力有無, 登録者数リスト出力有無,
                時点, 不在者投票資格者分作成有無, 不在資格対象者名簿作成有無, 有榷者数調べ出力有無, 二重登録通知出力有無, 発行日, 発行番号の第,
                発行番号の番号, 発行番号の号, 転入期間, 送付先宛名シール作成有無, 二重登録通知一覧表作成有無, 登録者名簿出力有無, 縦覧用作成有無_登録者,
                新規登録者宛名シール作成有無, 帰化対象者名簿出力有無, 帰化期間, 抹消者名簿出力有無, 縦覧用作成有無_抹消者, 居住要件抹消者名簿出力有無,
                表示者名簿出力有無, 表示消除者名簿出力有無, 規定年齢前名簿出力有無, 規定年齢前シール作成有無, 規定年齢未到達者名簿出力有無,
                再転入者名簿出力有無, 訂正者名簿出力有無, 転出者名簿出力有無, 登録停止者名簿出力有無, 在外選挙人名簿抄本出力有無, 在外投票資格者名簿出力有無);
    }

    /**
     * 定時登録再発行バッチ出力条件リスト入力パラメータに変換して返します。
     *
     * @return バッチ出力条件リスト入力パラメータ
     */
    public AFABTA101BatchPrintProcessParameter toAFABTA101BatchPrintProcessParameter() {
        ShohonNo shohonNo = (抄本番号 == null || 抄本番号.isEmpty()) ? null : new ShohonNo(抄本番号);
        return new AFABTA101BatchPrintProcessParameter(処理種別,
                shohonNo,
                抄本名,
                投票日,
                基準日,
                登録日,
                転出期限日,
                転入期限日,
                年齢期限日,
                選挙人名簿抄本出力有無,
                投票区From,
                投票区To,
                永久選挙人名簿出力有無,
                出力条件,
                識別コード,
                指定日,
                異動事由,
                選挙人名簿索引簿出力有無,
                登録者数リスト出力有無,
                時点,
                不在者投票資格者分作成有無,
                不在資格対象者名簿作成有無,
                有榷者数調べ出力有無,
                二重登録通知出力有無,
                発行日,
                発行番号の第,
                発行番号の番号,
                発行番号の号,
                転入期間,
                送付先宛名シール作成有無,
                二重登録通知一覧表作成有無,
                登録者名簿出力有無,
                縦覧用作成有無_登録者,
                新規登録者宛名シール作成有無,
                帰化対象者名簿出力有無,
                帰化期間,
                抹消者名簿出力有無,
                縦覧用作成有無_抹消者,
                居住要件抹消者名簿出力有無,
                表示者名簿出力有無,
                表示消除者名簿出力有無,
                規定年齢前名簿出力有無,
                規定年齢前シール作成有無,
                規定年齢未到達者名簿出力有無,
                再転入者名簿出力有無,
                訂正者名簿出力有無,
                転出者名簿出力有無,
                登録停止者名簿出力有無,
                在外選挙人名簿抄本出力有無,
                在外投票資格者名簿出力有無);
    }
}
