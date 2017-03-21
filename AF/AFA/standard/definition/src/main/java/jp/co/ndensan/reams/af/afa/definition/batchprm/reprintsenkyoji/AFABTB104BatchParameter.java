/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.reprintsenkyoji;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙時登録バッチパラメータクラスです。
 *
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTB104BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHON = "抄本番号";

    private static final String KEY_TOUHYOBI = "投票日";
    private static final String KEY_NENREIKIGENBI = "年齢期限日";
    private static final String KEY_SENKYONINMEIBOSHOHONFLG = "選挙人名簿抄本出力有無";
    private static final String KEY_EIKYUSENKYONINMEIBOFLG = "永久選挙人名簿出力有無";
    private static final String KEY_SHUTURYOKUJYOKEN = "出力条件";
    private static final String KEY_SHIKIBETUCODE = "識別コード";
    private static final String KEY_SHITEIBI = "指定日";
    private static final String KEY_IDOUJIYU = "異動事由";
    private static final String KEY_KEY_SAKUINMEIBOFLG = "選挙人名簿索引簿出力有無";
    private static final String KEY_TOUROKUSHASULIST = "登録者数リスト出力有無";
    private static final String KEY_JITEN = "時点";
    private static final String KEY_FUZAISHATOHYOSHIKAKUSHAFLG = "不在者投票資格者分作成有無";
    private static final String KEY_FUZAISHIKAKUMEIBOFLG = "不在資格対象者名簿作成有無";
    private static final String KEY_YUKENSHAFLG = "有榷者数調べ出力有無";
    private static final String KEY_NIJYUTOUROKUTUUCHIFLG = "二重登録通知出力有無";
    private static final String KEY_HAKOUBI = "発行日";
    private static final String KEY_KAKOUNUM_DAI = "発行番号の第";
    private static final String KEY_KAKOUNUM_NO = "発行番号の番号";
    private static final String KEY_KAKOUNUM_GO = "発行番号の号";
    private static final String KEY_TENNYUKIKAN = "転入期間";
    private static final String KEY_SOUFUSAKIATENAFLG = "送付先宛名シール作成有無";
    private static final String KEY_NIJYUTOUROKUHYOFLG = "二重登録通知一覧表作成有無";
    private static final String KEY_NIJYUTOUROKUTYOUSAFLG = "二重登録調査票有無";
    private static final String KEY_HAKOUBI_TYOUSA = "発行日_調査票";
    private static final String KEY_KAKOUNUM_DAI_TYOUSA = "発行番号の第_調査票";
    private static final String KEY_KAKOUNUM_NO_TYOUSA = "発行番号の番号_調査票";
    private static final String KEY_KAKOUNUM_GO_TYOUSA = "発行番号の号_調査票";
    private static final String KEY_TENNYUKIKAN_TYOUSA = "転出期間_調査票";
    private static final String KEY_SOFUSAKIATENA_TYOUSA = "送付先宛名シール作成有無_調査票";
    private static final String KEY_NIJYUTOUROKUHYOSAFLG = "二重調査票一覧表作成有無_調査票";
    private static final String KEY_TOUROKUSHAMEIBOFLG = "登録者名簿出力有無";
    private static final String KEY_JYURANYOUTOROKUSHA = "縦覧用作成有無_登録者";
    private static final String KEY_SHINKITOROKUSHAATENA = "新規登録者宛名シール作成有無";
    private static final String KEY_KIKATAISHOMEIBOFLG = "帰化対象者名簿出力有無";
    private static final String KEY_KIKAKIKAN = "帰化期間";
    private static final String KEY_MASHOSHAMEIBOFLG = "抹消者名簿出力有無";
    private static final String KEY_JYURANYOUMASHO = "縦覧用作成有無_抹消者";
    private static final String KEY_KYOJUYOKENMASHOSHA = "居住要件抹消者名簿出力有無";
    private static final String KEY_MASHOYOTEISHAMEIBO = "抹消予定者名簿出力有無";
    private static final String KEY_SHIKKENSHAMEIBOFLG = "失権者名簿出力有無";
    private static final String KEY_HYOJISHAMEIBOFLG = "表示者名簿出力有無";
    private static final String KEY_HYOJISHOJOSHAMEIBO = "表示消除者名簿出力有無";
    private static final String KEY_HYOJISHOJOYOTEISHA = "表示消除予定者名簿出力有無";
    private static final String KEY_KITEINENREIMAEMEIBOFLG = "規定年齢未到達者名簿出力有無";
    private static final String KEY_SAITENNYUSHAMEIBOFLG = "再転入者名簿出力有無";
    private static final String KEY_TEISEISHAMEIBOFLG = "訂正者名簿出力有無";
    private static final String KEY_TENSHUTUSHAMEIBOFLG = "転出者名簿出力有無";
    private static final String KEY_TOUROKUTEISHISHAMEIBOFLG = "登録停止者名簿出力有無";
    private static final String KEY_ZAIGAISENKYONINMEIBOFLG = "在外選挙人名簿抄本出力有無";
    private static final String KEY_ZAIGAITOHYOSHIKAKUSHA = "在外投票資格者名簿出力有無";
    private static final String KEY_ZAIGAITOUHYOKANRIHYOFLG = "在外投票管理票出力有無";
    private static final String KEY_SENKYONO = "選挙Noリスト";
    private static final String KEY_SENKYONAME = "選挙名リスト";
    private static final String KEY_KIJUNYMD = "基準日リスト";
    private static final String KEY_MEIBOTOROKUYMD = "登録日リスト";
    private static final String KEY_KOKUJIYMD = "告示日リスト";
    private static final String KEY_TENSHUTSUKIGENYMD = "転出期限日リスト";
    private static final String KEY_TENNYUKIGENYMD = "転入期限日リスト";
    private static final String KEY_TOHYOUKETSUKEYMD = "受付開始日リスト";
    private static final String KEY_MUTOHYOSENKYOFLAG = "無投票選挙フラグ";
    private static final String KEY_TOKYOKUFROM = "投票区From";
    private static final String KEY_TOKYOKUTO = "投票区To";

    @BatchParameter(key = KEY_SHOHON, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_TOUHYOBI, name = "投票日", order = 3)
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_NENREIKIGENBI, name = "年齢期限日", order = 5)
    private FlexibleDate 年齢期限日;
    @BatchParameter(key = KEY_SENKYONO, name = "選挙NOリスト", order = 7)
    private ArrayList<RString> 選挙Noリスト;
    @BatchParameter(key = KEY_SENKYONAME, name = "選挙名リスト", order = 9)
    private ArrayList<RString> 選挙名リスト;
    @BatchParameter(key = KEY_KIJUNYMD, name = "基準日リスト", order = 11)
    private ArrayList<FlexibleDate> 基準日リスト;
    @BatchParameter(key = KEY_TOHYOUKETSUKEYMD, name = "受付開始日リスト", order = 13)
    private ArrayList<FlexibleDate> 受付開始日リスト;
    @BatchParameter(key = KEY_KOKUJIYMD, name = "告示日リスト", order = 15)
    private ArrayList<FlexibleDate> 告示日リスト;
    @BatchParameter(key = KEY_MEIBOTOROKUYMD, name = "登録日リスト", order = 17)
    private ArrayList<FlexibleDate> 登録日リスト;
    @BatchParameter(key = KEY_TENSHUTSUKIGENYMD, name = "転出期限日リスト", order = 19)
    private ArrayList<FlexibleDate> 転出期限日リスト;
    @BatchParameter(key = KEY_TENNYUKIGENYMD, name = "転入期限日リスト", order = 21)
    private ArrayList<FlexibleDate> 転入期限日リスト;
    @BatchParameter(key = KEY_MUTOHYOSENKYOFLAG, name = "無投票選挙フラグ", order = 23)
    private ArrayList<Boolean> 無投票選挙フラグリスト;
    @BatchParameter(key = KEY_SENKYONINMEIBOSHOHONFLG, name = "選挙人名簿抄本出力有無", order = 25)
    private Boolean 選挙人名簿抄本出力有無;
    @BatchParameter(key = KEY_TOKYOKUFROM, name = "投票区From", order = 27)
    private RString 投票区From;
    @BatchParameter(key = KEY_TOKYOKUTO, name = "投票区To", order = 29)
    private RString 投票区To;
    @BatchParameter(key = KEY_EIKYUSENKYONINMEIBOFLG, name = "永久選挙人名簿出力有無", order = 31)
    private Boolean 永久選挙人名簿出力有無;
    @BatchParameter(key = KEY_SHUTURYOKUJYOKEN, name = "出力条件", order = 33)
    private RString 出力条件;
    @BatchParameter(key = KEY_SHIKIBETUCODE, name = "識別コード", order = 35)
    private RString 識別コード;
    @BatchParameter(key = KEY_SHITEIBI, name = "指定日", order = 37)
    private ArrayList<FlexibleDate> 指定日;
    @BatchParameter(key = KEY_IDOUJIYU, name = "異動事由", order = 39)
    private RString 異動事由;
    @BatchParameter(key = KEY_KEY_SAKUINMEIBOFLG, name = "選挙人名簿索引簿出力有無", order = 41)
    private Boolean 選挙人名簿索引簿出力有無;
    @BatchParameter(key = KEY_TOUROKUSHASULIST, name = "登録者数リスト出力有無", order = 43)
    private Boolean 登録者数リスト出力有無;
    @BatchParameter(key = KEY_JITEN, name = "時点", order = 45)
    private FlexibleDate 時点;
    @BatchParameter(key = KEY_FUZAISHATOHYOSHIKAKUSHAFLG, name = "不在者投票資格者分作成有無", order = 47)
    private Boolean 不在者投票資格者分作成有無;
    @BatchParameter(key = KEY_FUZAISHIKAKUMEIBOFLG, name = "不在資格対象者名簿作成有無", order = 49)
    private Boolean 不在資格対象者名簿作成有無;
    @BatchParameter(key = KEY_YUKENSHAFLG, name = "有榷者数調べ出力有無", order = 51)
    private Boolean 有榷者数調べ出力有無;
    @BatchParameter(key = KEY_NIJYUTOUROKUTUUCHIFLG, name = "二重登録通知出力有無", order = 53)
    private Boolean 二重登録通知出力有無;
    @BatchParameter(key = KEY_HAKOUBI, name = "発行日", order = 55)
    private FlexibleDate 発行日;
    @BatchParameter(key = KEY_KAKOUNUM_DAI, name = "発行番号の第", order = 57)
    private RString 発行番号の第;
    @BatchParameter(key = KEY_KAKOUNUM_NO, name = "発行番号の番号", order = 59)
    private RString 発行番号の番号;
    @BatchParameter(key = KEY_KAKOUNUM_GO, name = "発行番号の号", order = 61)
    private RString 発行番号の号;
    @BatchParameter(key = KEY_TENNYUKIKAN, name = "転入期間", order = 63)
    private ArrayList<FlexibleDate> 転入期間;
    @BatchParameter(key = KEY_SOUFUSAKIATENAFLG, name = "送付先宛名シール作成有無", order = 65)
    private Boolean 送付先宛名シール作成有無;
    @BatchParameter(key = KEY_NIJYUTOUROKUHYOFLG, name = "二重登録通知一覧表作成有無", order = 67)
    private Boolean 二重登録通知一覧表作成有無;
    @BatchParameter(key = KEY_NIJYUTOUROKUTYOUSAFLG, name = "二重登録調査票有無", order = 69)
    private Boolean 二重登録調査票有無;
    @BatchParameter(key = KEY_HAKOUBI_TYOUSA, name = "発行日_調査票", order = 71)
    private FlexibleDate 発行日_調査票;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_TYOUSA, name = "発行番号の第_調査票", order = 73)
    private RString 発行番号の第_調査票;
    @BatchParameter(key = KEY_KAKOUNUM_NO_TYOUSA, name = "発行番号の番号_調査票", order = 75)
    private RString 発行番号の番号_調査票;
    @BatchParameter(key = KEY_KAKOUNUM_GO_TYOUSA, name = "発行番号の号_調査票", order = 77)
    private RString 発行番号の号_調査票;
    @BatchParameter(key = KEY_TENNYUKIKAN_TYOUSA, name = "転出期間_調査票", order = 79)
    private ArrayList<FlexibleDate> 転出期間_調査票;
    @BatchParameter(key = KEY_SOFUSAKIATENA_TYOUSA, name = "送付先宛名シール作成有無_調査票", order = 81)
    private Boolean 送付先宛名シール作成有無_調査票;
    @BatchParameter(key = KEY_NIJYUTOUROKUHYOSAFLG, name = "二重調査票一覧表作成有無_調査票", order = 83)
    private Boolean 二重調査票一覧表作成有無_調査票;
    @BatchParameter(key = KEY_TOUROKUSHAMEIBOFLG, name = "登録者名簿出力有無", order = 85)
    private Boolean 登録者名簿出力有無;
    @BatchParameter(key = KEY_JYURANYOUTOROKUSHA, name = "縦覧用作成有無_登録者", order = 87)
    private Boolean 縦覧用作成有無_登録者;
    @BatchParameter(key = KEY_SHINKITOROKUSHAATENA, name = "新規登録者宛名シール作成有無", order = 89)
    private Boolean 新規登録者宛名シール作成有無;
    @BatchParameter(key = KEY_KIKATAISHOMEIBOFLG, name = "帰化対象者名簿出力有無", order = 91)
    private Boolean 帰化対象者名簿出力有無;
    @BatchParameter(key = KEY_KIKAKIKAN, name = "帰化期間", order = 93)
    private ArrayList<FlexibleDate> 帰化期間;
    @BatchParameter(key = KEY_MASHOSHAMEIBOFLG, name = "抹消者名簿出力有無", order = 95)
    private Boolean 抹消者名簿出力有無;
    @BatchParameter(key = KEY_JYURANYOUMASHO, name = "縦覧用作成有無_抹消者", order = 97)
    private Boolean 縦覧用作成有無_抹消者;
    @BatchParameter(key = KEY_KYOJUYOKENMASHOSHA, name = "居住要件抹消者名簿出力有無", order = 99)
    private Boolean 居住要件抹消者名簿出力有無;
    @BatchParameter(key = KEY_MASHOYOTEISHAMEIBO, name = "抹消予定者名簿出力有無", order = 101)
    private Boolean 抹消予定者名簿出力有無;
    @BatchParameter(key = KEY_SHIKKENSHAMEIBOFLG, name = "失権者名簿出力有無", order = 103)
    private Boolean 失権者名簿出力有無;
    @BatchParameter(key = KEY_HYOJISHAMEIBOFLG, name = "表示者名簿出力有無", order = 105)
    private Boolean 表示者名簿出力有無;
    @BatchParameter(key = KEY_HYOJISHOJOSHAMEIBO, name = "表示消除者名簿出力有無", order = 107)
    private Boolean 表示消除者名簿出力有無;
    @BatchParameter(key = KEY_HYOJISHOJOYOTEISHA, name = "表示消除予定者名簿出力有無", order = 109)
    private Boolean 表示消除予定者名簿出力有無;
    @BatchParameter(key = KEY_KITEINENREIMAEMEIBOFLG, name = "規定年齢未到達者名簿出力有無", order = 111)
    private Boolean 規定年齢未到達者名簿出力有無;
    @BatchParameter(key = KEY_SAITENNYUSHAMEIBOFLG, name = "再転入者名簿出力有無", order = 113)
    private Boolean 再転入者名簿出力有無;
    @BatchParameter(key = KEY_TEISEISHAMEIBOFLG, name = "訂正者名簿出力有無", order = 115)
    private Boolean 訂正者名簿出力有無;
    @BatchParameter(key = KEY_TENSHUTUSHAMEIBOFLG, name = "転出者名簿出力有無", order = 117)
    private Boolean 転出者名簿出力有無;
    @BatchParameter(key = KEY_TOUROKUTEISHISHAMEIBOFLG, name = "登録停止者名簿出力有無", order = 119)
    private Boolean 登録停止者名簿出力有無;
    @BatchParameter(key = KEY_ZAIGAISENKYONINMEIBOFLG, name = "在外選挙人名簿抄本出力有無", order = 121)
    private Boolean 在外選挙人名簿抄本出力有無;
    @BatchParameter(key = KEY_ZAIGAITOHYOSHIKAKUSHA, name = "在外投票資格者名簿出力有無", order = 123)
    private Boolean 在外投票資格者名簿出力有無;
    @BatchParameter(key = KEY_ZAIGAITOUHYOKANRIHYOFLG, name = "在外投票管理票出力有無", order = 125)
    private Boolean 在外投票管理票出力有無;

    /**
     * AFABTB101SelectProcessParameterの変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @return AFABTB101SelectProcessParameter
     */
    public AFABTB101SelectProcessParameter toAFABTB101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll) {
        FlexibleDate 最大基準日 = FlexibleDate.MIN;
        FlexibleDate 最大登録日 = FlexibleDate.MIN;
        FlexibleDate 最大転出期限日 = FlexibleDate.MIN;
        FlexibleDate 最小転入期限日 = FlexibleDate.MAX;
        for (FlexibleDate 基準日 : 基準日リスト) {
            if (最大基準日.isBefore(基準日)) {
                最大基準日 = 基準日;
            }
        }
        for (FlexibleDate 登録日 : 登録日リスト) {
            if (最大登録日.isBefore(登録日)) {
                最大登録日 = 登録日;
            }
        }
        for (FlexibleDate 転出期限日 : 転出期限日リスト) {
            if (最大転出期限日.isBefore(転出期限日)) {
                最大転出期限日 = 転出期限日;
            }
        }
        for (FlexibleDate 転入期限日 : 転入期限日リスト) {
            if (!最小転入期限日.isBefore(転入期限日)) {
                最小転入期限日 = 転入期限日;
            }
        }
        return new AFABTB101SelectProcessParameter(RString.EMPTY, get選択一覧リスト(選挙Noリスト, 選挙名リスト,
                基準日リスト, 登録日リスト, 告示日リスト, 転出期限日リスト, 転入期限日リスト,
                受付開始日リスト, 無投票選挙フラグリスト), new ShohonNo(抄本番号), RString.EMPTY, 最大基準日, 最大登録日, 投票日, 最大転出期限日,
                最小転入期限日, 年齢期限日, 帰化期間, key, keyForAll, 出力条件, 識別コード, 指定日.get(0), 指定日.get(1), 異動事由, RString.EMPTY, false,
                RString.EMPTY, 投票区From, 投票区To);
    }

    /**
     * AFABTB101BatchPrintProcessParameterの変換のメソッドです。
     *
     * @return AFABTB101SelectProcessParameter
     */
    public AFABTB101BatchPrintProcessParameter toAFABTB101BatchPrintProcessParameter() {
        return new AFABTB101BatchPrintProcessParameter(
                new ShohonNo(抄本番号),
                RString.EMPTY,
                投票日,
                年齢期限日,
                Boolean.FALSE,
                get選択一覧リスト(選挙Noリスト, 選挙名リスト, 基準日リスト,
                        登録日リスト, 告示日リスト, 転出期限日リスト, 転入期限日リスト, 受付開始日リスト, 無投票選挙フラグリスト),
                選挙人名簿抄本出力有無,
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
                二重登録調査票有無,
                発行日_調査票,
                発行番号の第_調査票,
                発行番号の番号_調査票,
                発行番号の号_調査票,
                転出期間_調査票,
                送付先宛名シール作成有無_調査票,
                二重調査票一覧表作成有無_調査票,
                登録者名簿出力有無,
                縦覧用作成有無_登録者,
                新規登録者宛名シール作成有無,
                帰化対象者名簿出力有無,
                帰化期間,
                抹消者名簿出力有無,
                縦覧用作成有無_抹消者,
                居住要件抹消者名簿出力有無,
                抹消予定者名簿出力有無,
                失権者名簿出力有無,
                表示者名簿出力有無,
                表示消除者名簿出力有無,
                表示消除予定者名簿出力有無,
                規定年齢未到達者名簿出力有無,
                再転入者名簿出力有無,
                訂正者名簿出力有無,
                転出者名簿出力有無,
                登録停止者名簿出力有無,
                在外選挙人名簿抄本出力有無,
                在外投票資格者名簿出力有無,
                在外投票管理票出力有無,
                投票区From,
                投票区To
        );
    }

    private List<AFABTB101Senkyoichiran> get選択一覧リスト(ArrayList<RString> 選挙Noリスト, ArrayList<RString> 選挙名リスト,
            ArrayList<FlexibleDate> 基準日リスト, ArrayList<FlexibleDate> 登録日リスト, ArrayList<FlexibleDate> 告示日リスト, ArrayList<FlexibleDate> 転出期限日リスト,
            ArrayList<FlexibleDate> 転入期限日リスト, ArrayList<FlexibleDate> 受付開始日リスト, ArrayList<Boolean> 無投票選挙フラグリスト) {
        List<AFABTB101Senkyoichiran> 選択一覧リスト = new ArrayList<>();
        for (int i = 0; i < 選挙Noリスト.size(); i++) {
            AFABTB101Senkyoichiran 選択一覧 = new AFABTB101Senkyoichiran();
            選択一覧.setKijunYMD(基準日リスト.get(i));
            選択一覧.setKokujiYMD(告示日リスト.get(i));
            選択一覧.setMeiboTorokuYMD(登録日リスト.get(i));
            選択一覧.setSenkyoName(選挙名リスト.get(i));
            選択一覧.setSenkyoNo(new SenkyoNo(選挙Noリスト.get(i)));
            選択一覧.setTennyuKigenYMD(転入期限日リスト.get(i));
            選択一覧.setTenshutsuKigenYMD(転出期限日リスト.get(i));
            選択一覧.setTohyoUketsukeYMD(受付開始日リスト.get(i));
            選択一覧.setMutohyoSenkyoFlag(無投票選挙フラグリスト.get(i));
            選択一覧リスト.add(選択一覧);
        }
        return 選択一覧リスト;
    }
}
