/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.kokuminTohyoji;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 国民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0360-020 xiaoj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTG101BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHORIMODE = "処理種別";
    private static final String KEY_SHOHONNO = "抄本番号";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_TOUHYOBI = "投票日";
    private static final String KEY_KIJUNBI = "基準日";
    private static final String KEY_MEIBOTOROKUBI = "名簿登録日";
    private static final String KEY_NENREITOTATSUBI = "年齢到達日";
    private static final String KEY_TOKUTEIKIKANKAISHIBI = "特定期間開始日";
    private static final String KEY_TOKUTEIKIGENBI = "特定期限日";
    private static final String KEY_TOHYOUKETSUKEBI = "受付開始日";
    private static final String KEY_ = "研修用データ作成有無";

    private static final String KEY_SENKYO_NO = "選挙番号リスト";
    private static final String KEY_SENKYO_NAME = "選挙名称リスト";
    private static final String KEY_SENKYO_RYAKUSHO = "選挙略称リスト";
    private static final String KEY_MEIBOSHOHON = "投票人名簿抄本出力有無";
    private static final String KEY_TOROKUSHASULISTFLG = "投票人名簿登録者数リスト出力有無";
    private static final String KEY_KUJUNBI_TOROKUSHASU = "時点日";
    private static final String KEY_FUZAISHABUNFLG = "不在者投票資格者分出力有無";
    private static final String KEY_FUZAITOHYOMEIBOFLG = "不在資格対象者名簿出力有無";
    private static final String KEY_1GOSHIKAKUTSUCHIFLG = "1号資格登録通知出力有無";
    private static final String KEY_HAKOUBI_1GOSHIKAKU = "発行日_1号資格登録";
    private static final String KEY_KAKOUNUM_DAI_1GOSHIKAKU = "発行番号の第_1号資格";
    private static final String KEY_KAKOUNUM_NO_1GOSHIKAKU = "発行番号の番号_1号資格";
    private static final String KEY_KAKOUNUM_GO_1GOSHIKAKU = "発行番号の号_1号資格";
    private static final String KEY_CHKSEAL1GOTSUCHIFLG = "送付先宛名シール出力有無_1号資格";
    private static final String KEY_CHKSEAL1GOTSUCHIICHIRANFLG = "1号資格登録通知一覧表出力有無";
    private static final String KEY_2GOSHIKAKUCHOSAHYOFLG = "2号資格調査票出力有無";
    private static final String KEY_HAKOUBI_2GOSHIKAKU = "発行日_2号資格";
    private static final String KEY_KAKOUNUM_DAI_2GOSHIKAKU = "発行番号の第_2号資格";
    private static final String KEY_KAKOUNUM_NO_2GOSHIKAKU = "発行番号の番号_2号資格";
    private static final String KEY_KAKOUNUM_GO_2GOSHIKAKU = "発行番号の号_2号資格";
    private static final String KEY_CHKSEAL2GOCHOSAHYOFLG = "送付先宛名シール出力有無_2号資格";
    private static final String KEY_CHK2GOCHOSAICHIRANFLG = "_2号資格調査一覧表出力有無";
    private static final String KEY_2GOKOHOLISTFLG = "_2号資格候補者一覧表出力有無";
    private static final String KEY_IDOTOROKUSHAMEIBOFLG = "補正登録者名簿出力有無";
    private static final String KEY_CHKTOROKUSHAMEIBOJURANFLG = "縦覧用も作成する出力有無_補正登録者";
    private static final String KEY_CHKSEALTOROKUSHAMEIBO = "補正登録者宛名シール出力有無";
    private static final String KEY_IDOMASSHOSHAMEIBOFLG = "抹消者名簿出力有無";
    private static final String KEY_MASSHOBI = "抹消日";

    private static final String KEY_CHKMASSHOSHAMEIBOJURANFLG = "縦覧用も作成する出力有無_抹消者";
    private static final String KEY_IDOTEISEISHAMEIBOFLG = "訂正者名簿出力有無";
    private static final String KEY_MASSHOTSUCHIFLG = "未登録者抹消通知出力有無";
    private static final String KEY_HAKOUBI_MASSHOTSUCHI = "発行日_未登録者抹消";
    private static final String KEY_KAKOUNUM_DAI_MASSHOTSUCHI = "発行番号の第_未登録者抹消";
    private static final String KEY_KAKOUNUM_NO_MASSHOTSUCHI = "発行番号の番号_未登録者抹消";
    private static final String KEY_KAKOUNUM_GO_MASSHOTSUCHI = "発行番号の号_未登録者抹消";
    private static final String KEY_CHKSEALMASSHOTSUCHI = "送付先宛名シール出力有無_未登録者抹消";
    private static final String KEY_CHKMASSHOTSUCHIICHIRANFLG = "未登録者抹消通知一覧出力有無";
    private static final String KEY_KOKUNAICHOSAHYOFLG = "国内転入者調査票出力有無";
    private static final String KEY_HAKOUBI_KOKUNAICHOSA = "発行日_国内転入者調査票";
    private static final String KEY_KAKOUNUM_DAI_KOKUNAICHOSA = "発行番号の第_国内転入者調査票";
    private static final String KEY_KAKOUNUM_NO_KOKUNAICHOSA = "発行番号の番号_国内転入者調査票";
    private static final String KEY_KAKOUNUM_GO_KOKUNAICHOSA = "発行番号の号_国内転入者調査票";
    private static final String KEY_CHKSEALKOKUNAICHOSAFLG = "送付先宛名シール出力有無_国内転入者調査票";
    private static final String KEY_CHKKOKUNAICHOSAICHIRANFLG = "国内転入者調査一覧表出力有無";
    private static final String KEY_KOKUGAICHOSAHYOFLG = "国外転入者調査票出力有無";
    private static final String KEY_HAKOUBI_KOKUGAICHOSA = "発行日_国外転入者調査票";
    private static final String KEY_KAKOUNUM_DAI_KOKUGAICHOSA = "発行番号の第_国外転入者調査票";
    private static final String KEY_KAKOUNUM_NO_KOKUGAICHOSA = "発行番号の番号_国外転入者調査票";
    private static final String KEY_KAKOUNUM_GO_KOKUGAICHOSA = "発行番号の号_国外転入者調査票";
    private static final String KEY_CHKSEALKOKUGAICHOSAFLG = "送付先宛名シール出力有無_国外転入者調査票";
    private static final String KEY_CHKKOKUGAICHOSAICHIRANFLG = "国外転入者調査一覧表出力有無";
    private static final String KEY_ZAIGAISENKYONINMEIBOSHOHON = "在外投票人名簿抄本出力有無";
    private static final String KEY_ZAIGAISHIKAKUSHAMEIBOFLG = "在外投票資格者名簿出力有無";
    private static final String KEY_ZAIGAITOHYOKANRIHYOFLG = "在外投票管理表出力有無";

    @BatchParameter(key = KEY_SHORIMODE, name = "処理種別", order = 1)
    private RString 処理種別;
    @BatchParameter(key = KEY_SHOHONNO, name = "抄本番号", order = 2)
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名", order = 3)
    private RString 抄本名;
    @BatchParameter(key = KEY_TOUHYOBI, name = "投票日", order = 4)
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_KIJUNBI, name = "基準日", order = 5)
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_MEIBOTOROKUBI, name = "名簿登録日", order = 6)
    private FlexibleDate 名簿登録日;
    @BatchParameter(key = KEY_NENREITOTATSUBI, name = "年齢到達日", order = 7)
    private FlexibleDate 年齢到達日;
    @BatchParameter(key = KEY_TOKUTEIKIKANKAISHIBI, name = "特定期間開始日", order = 8)
    private FlexibleDate 特定期間開始日;
    @BatchParameter(key = KEY_TOKUTEIKIGENBI, name = "特定期限日", order = 9)
    private FlexibleDate 特定期限日;
    @BatchParameter(key = KEY_TOHYOUKETSUKEBI, name = "受付開始日", order = 10)
    private FlexibleDate 受付開始日;
    @BatchParameter(key = KEY_, name = "研修用データ作成有無", order = 11)
    private boolean 研修用データ作成有無;
    @BatchParameter(key = KEY_SENKYO_NO, name = "選挙番号リスト", order = 12)
    private ArrayList<RString> 選挙番号リスト;
    @BatchParameter(key = KEY_SENKYO_NAME, name = "選挙名称リスト", order = 13)
    private ArrayList<RString> 選挙名称リスト;
    @BatchParameter(key = KEY_SENKYO_RYAKUSHO, name = "選挙略称リスト", order = 14)
    private ArrayList<RString> 選挙略称リスト;
    @BatchParameter(key = KEY_MEIBOSHOHON, name = "投票人名簿抄本出力有無", order = 15)
    private boolean 投票人名簿抄本出力有無;
    @BatchParameter(key = KEY_TOROKUSHASULISTFLG, name = "投票人名簿登録者数リスト出力有無", order = 16)
    private boolean 投票人名簿登録者数リスト出力有無;
    @BatchParameter(key = KEY_KUJUNBI_TOROKUSHASU, name = "時点日", order = 17)
    private FlexibleDate 時点日;
    @BatchParameter(key = KEY_FUZAISHABUNFLG, name = "不在者投票資格者分出力有無", order = 18)
    private boolean 不在者投票資格者分出力有無;
    @BatchParameter(key = KEY_FUZAITOHYOMEIBOFLG, name = "不在資格対象者名簿出力有無", order = 19)
    private boolean 不在資格対象者名簿出力有無;
    @BatchParameter(key = KEY_1GOSHIKAKUTSUCHIFLG, name = "一号資格登録通知出力有無", order = 20)
    private boolean 一号資格登録通知出力有無;
    @BatchParameter(key = KEY_HAKOUBI_1GOSHIKAKU, name = "発行日_1号資格登録", order = 21)
    private FlexibleDate 発行日_1号資格登録;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_1GOSHIKAKU, name = "発行番号の第_1号資格", order = 22)
    private RString 発行番号の第_1号資格;
    @BatchParameter(key = KEY_KAKOUNUM_NO_1GOSHIKAKU, name = "発行番号の番号_1号資格", order = 23)
    private RString 発行番号の番号_1号資格;
    @BatchParameter(key = KEY_KAKOUNUM_GO_1GOSHIKAKU, name = "発行番号の号_1号資格", order = 24)
    private RString 発行番号の号_1号資格;
    @BatchParameter(key = KEY_CHKSEAL1GOTSUCHIFLG, name = "送付先宛名シール出力有無_1号資格", order = 25)
    private boolean 送付先宛名シール出力有無_1号資格;
    @BatchParameter(key = KEY_CHKSEAL1GOTSUCHIICHIRANFLG, name = "一号資格登録通知一覧表出力有無", order = 26)
    private boolean 一号資格登録通知一覧表出力有無;
    @BatchParameter(key = KEY_2GOSHIKAKUCHOSAHYOFLG, name = "二号資格調査票出力有無", order = 27)
    private boolean 二号資格調査票出力有無;
    @BatchParameter(key = KEY_HAKOUBI_2GOSHIKAKU, name = "発行日_2号資格", order = 28)
    private FlexibleDate 発行日_2号資格;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_2GOSHIKAKU, name = "発行番号の第_2号資格", order = 29)
    private RString 発行番号の第_2号資格;
    @BatchParameter(key = KEY_KAKOUNUM_NO_2GOSHIKAKU, name = "発行番号の番号_2号資格", order = 30)
    private RString 発行番号の番号_2号資格;
    @BatchParameter(key = KEY_KAKOUNUM_GO_2GOSHIKAKU, name = "発行番号の号_2号資格", order = 31)
    private RString 発行番号の号_2号資格;
    @BatchParameter(key = KEY_CHKSEAL2GOCHOSAHYOFLG, name = "送付先宛名シール出力有無_2号資格", order = 32)
    private boolean 送付先宛名シール出力有無_2号資格;
    @BatchParameter(key = KEY_CHK2GOCHOSAICHIRANFLG, name = "二号資格調査一覧表出力有無", order = 33)
    private boolean 二号資格調査一覧表出力有無;
    @BatchParameter(key = KEY_2GOKOHOLISTFLG, name = "二号資格候補者一覧表出力有無", order = 34)
    private boolean 二号資格候補者一覧表出力有無;
    @BatchParameter(key = KEY_IDOTOROKUSHAMEIBOFLG, name = "補正登録者名簿出力有無", order = 35)
    private boolean 補正登録者名簿出力有無;
    @BatchParameter(key = KEY_CHKTOROKUSHAMEIBOJURANFLG, name = "縦覧用も作成する出力有無_補正登録者", order = 36)
    private boolean 縦覧用も作成する出力有無;
    @BatchParameter(key = KEY_CHKSEALTOROKUSHAMEIBO, name = "補正登録者宛名シール出力有無", order = 37)
    private boolean 補正登録者宛名シール出力有無;
    @BatchParameter(key = KEY_IDOMASSHOSHAMEIBOFLG, name = "抹消者名簿出力有無", order = 38)
    private boolean 抹消者名簿出力有無;
    @BatchParameter(key = KEY_MASSHOBI, name = "抹消日", order = 39)
    private FlexibleDate 抹消日;
    @BatchParameter(key = KEY_CHKMASSHOSHAMEIBOJURANFLG, name = "縦覧用も作成する出力有無_抹消者", order = 40)
    private boolean 縦覧用も作成する出力有無_抹消者;
    @BatchParameter(key = KEY_IDOTEISEISHAMEIBOFLG, name = "訂正者名簿出力有無", order = 41)
    private boolean 訂正者名簿出力有無;
    @BatchParameter(key = KEY_MASSHOTSUCHIFLG, name = "未登録者抹消通知出力有無", order = 42)
    private boolean 未登録者抹消通知出力有無;
    @BatchParameter(key = KEY_HAKOUBI_MASSHOTSUCHI, name = "発行日_未登録者抹消", order = 43)
    private FlexibleDate 発行日_未登録者抹消;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_MASSHOTSUCHI, name = "発行番号の第_未登録者抹消", order = 44)
    private RString 発行番号の第_未登録者抹消;
    @BatchParameter(key = KEY_KAKOUNUM_NO_MASSHOTSUCHI, name = "発行番号の番号_未登録者抹消", order = 45)
    private RString 発行番号の番号_未登録者抹消;
    @BatchParameter(key = KEY_KAKOUNUM_GO_MASSHOTSUCHI, name = "発行番号の号_未登録者抹消", order = 46)
    private RString 発行番号の号_未登録者抹消;
    @BatchParameter(key = KEY_CHKSEALMASSHOTSUCHI, name = "送付先宛名シール出力有無_未登録者抹消", order = 47)
    private boolean 送付先宛名シール出力有無_未登録者抹消;
    @BatchParameter(key = KEY_CHKMASSHOTSUCHIICHIRANFLG, name = "未登録者抹消通知一覧出力有無", order = 48)
    private boolean 未登録者抹消通知一覧出力有無;
    @BatchParameter(key = KEY_KOKUNAICHOSAHYOFLG, name = "国内転入者調査票出力有無", order = 49)
    private boolean 国内転入者調査票出力有無;
    @BatchParameter(key = KEY_HAKOUBI_KOKUNAICHOSA, name = "発行日_国内転入者調査票", order = 50)
    private FlexibleDate 発行日_国内転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_KOKUNAICHOSA, name = "発行番号の第_国内転入者調査票", order = 51)
    private RString 発行番号の第_国内転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_NO_KOKUNAICHOSA, name = "発行番号の番号_国内転入者調査票", order = 52)
    private RString 発行番号の番号_国内転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_GO_KOKUNAICHOSA, name = "発行番号の号_国内転入者調査票", order = 53)
    private RString 発行番号の号_国内転入者調査票;
    @BatchParameter(key = KEY_CHKSEALKOKUNAICHOSAFLG, name = "送付先宛名シール出力有無_国内転入者調査票", order = 54)
    private boolean 送付先宛名シール出力有無_国内転入者調査票;
    @BatchParameter(key = KEY_CHKKOKUNAICHOSAICHIRANFLG, name = "国内転入者調査一覧表出力有無", order = 55)
    private boolean 国内転入者調査一覧表出力有無;
    @BatchParameter(key = KEY_KOKUGAICHOSAHYOFLG, name = "国外転入者調査票出力有無", order = 56)
    private boolean 国外転入者調査票出力有無;
    @BatchParameter(key = KEY_HAKOUBI_KOKUGAICHOSA, name = "発行日_国外転入者調査票", order = 57)
    private FlexibleDate 発行日_国外転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_KOKUGAICHOSA, name = "発行番号の第_国外転入者調査票", order = 58)
    private RString 発行番号の第_国外転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_NO_KOKUGAICHOSA, name = "発行番号の番号_国外転入者調査票", order = 59)
    private RString 発行番号の番号_国外転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_GO_KOKUGAICHOSA, name = "発行番号の号_国外転入者調査票", order = 60)
    private RString 発行番号の号_国外転入者調査票;
    @BatchParameter(key = KEY_CHKSEALKOKUGAICHOSAFLG, name = "送付先宛名シール出力有無_国外転入者調査票", order = 61)
    private boolean 送付先宛名シール出力有無_国外転入者調査票;
    @BatchParameter(key = KEY_CHKKOKUGAICHOSAICHIRANFLG, name = "国外転入者調査一覧表出力有無", order = 62)
    private boolean 国外転入者調査一覧表出力有無;
    @BatchParameter(key = KEY_ZAIGAISENKYONINMEIBOSHOHON, name = "在外投票人名簿抄本出力有無", order = 63)
    private boolean 在外投票人名簿抄本出力有無;
    @BatchParameter(key = KEY_ZAIGAISHIKAKUSHAMEIBOFLG, name = "在外投票資格者名簿出力有無", order = 64)
    private boolean 在外投票資格者名簿出力有無;
    @BatchParameter(key = KEY_ZAIGAITOHYOKANRIHYOFLG, name = "在外投票管理表出力有無", order = 65)
    private boolean 在外投票管理表出力有無;

    /**
     * AFABTG101SelectProcessParameterrの変換のメソッドです。
     *
     * @return AFABTG101SelectProcessParameter
     */
    public AFABTG101SelectProcessParameter toAFABTG101SelectProcessParameter() {
        return toAFABTG101SelectProcessParameter(RString.EMPTY);

    }

    /**
     * AFABTG101SelectProcessParameterの変換のメソッドです。
     *
     * @param order順 RString
     * @return AFABTG101SelectProcessParameter
     */
    public AFABTG101SelectProcessParameter toAFABTG101SelectProcessParameter(RString order順) {
        return new AFABTG101SelectProcessParameter(処理種別, RString.isNullOrEmpty(抄本番号) ? null : new ShohonNo(抄本番号), 抄本名, 投票日,
                基準日, 名簿登録日, 年齢到達日, 特定期間開始日, 特定期限日, 受付開始日, 時点日, 発行日_1号資格登録, 発行番号の第_1号資格,
                発行番号の番号_1号資格, 発行番号の号_1号資格, 発行日_2号資格, 発行番号の第_2号資格, 発行番号の番号_2号資格,
                発行番号の号_2号資格, 抹消日, 発行日_未登録者抹消, 発行番号の第_未登録者抹消, 発行番号の番号_未登録者抹消,
                発行番号の号_未登録者抹消, 発行日_国内転入者調査票, 発行番号の第_国内転入者調査票,
                発行番号の番号_国内転入者調査票, 発行番号の号_国内転入者調査票, 発行日_国外転入者調査票,
                発行番号の第_国外転入者調査票, 発行番号の番号_国外転入者調査票, 発行番号の号_国外転入者調査票,
                get選挙一覧リスト(選挙番号リスト, 選挙名称リスト, 選挙略称リスト), RString.EMPTY);
    }

    private List<AFABTB101Senkyoichiran> get選挙一覧リスト(List<RString> 選挙Noリスト, List<RString> 選挙名リスト,
            List<RString> 選挙略称リスト) {
        List<AFABTB101Senkyoichiran> 選択一覧リスト = new ArrayList<>();
        for (int i = 0; i < 選挙Noリスト.size(); i++) {
            AFABTB101Senkyoichiran 選択一覧 = new AFABTB101Senkyoichiran();
            選択一覧.setSenkyoName(選挙名リスト.get(i));
            選択一覧.setSenkyoNo(new SenkyoNo(RString.isNullOrEmpty(選挙Noリスト.get(i)) ? new RString(String.valueOf(i + 1)) : 選挙Noリスト.get(i)));
            選択一覧.setSenkyoRyakusho(選挙略称リスト.get(i));
            選択一覧リスト.add(選択一覧);
        }
        return 選択一覧リスト;
    }

    /**
     * AFABTG101BatchPrintProcessParameterの変換のメソッドです。
     *
     * @return AFABTG101BatchPrintProcessParameter
     */
    public AFABTG101BatchPrintProcessParameter toAFABTG101BatchPrintProcessParameter() {
        return new AFABTG101BatchPrintProcessParameter(
                RString.isNullOrEmpty(抄本番号) ? null : new ShohonNo(抄本番号),
                抄本名,
                投票日,
                基準日,
                名簿登録日,
                年齢到達日,
                特定期間開始日,
                特定期限日,
                受付開始日,
                get選挙一覧リスト(選挙番号リスト, 選挙名称リスト, 選挙略称リスト),
                投票人名簿抄本出力有無,
                投票人名簿登録者数リスト出力有無,
                時点日,
                不在者投票資格者分出力有無,
                不在資格対象者名簿出力有無,
                一号資格登録通知出力有無,
                発行日_1号資格登録,
                発行番号の第_1号資格,
                発行番号の番号_1号資格,
                発行番号の号_1号資格,
                送付先宛名シール出力有無_1号資格,
                一号資格登録通知一覧表出力有無,
                二号資格調査票出力有無,
                発行日_2号資格,
                発行番号の第_2号資格,
                発行番号の番号_2号資格,
                発行番号の号_2号資格,
                送付先宛名シール出力有無_2号資格,
                二号資格調査一覧表出力有無,
                二号資格候補者一覧表出力有無,
                補正登録者名簿出力有無,
                縦覧用も作成する出力有無,
                補正登録者宛名シール出力有無,
                抹消者名簿出力有無,
                抹消日,
                縦覧用も作成する出力有無_抹消者,
                訂正者名簿出力有無,
                未登録者抹消通知出力有無,
                発行日_未登録者抹消,
                発行番号の第_未登録者抹消,
                発行番号の番号_未登録者抹消,
                発行番号の号_未登録者抹消,
                送付先宛名シール出力有無_未登録者抹消,
                未登録者抹消通知一覧出力有無,
                国内転入者調査票出力有無,
                発行日_国内転入者調査票,
                発行番号の第_国内転入者調査票,
                発行番号の番号_国内転入者調査票,
                発行番号の号_国内転入者調査票,
                送付先宛名シール出力有無_国内転入者調査票,
                国内転入者調査一覧表出力有無,
                国外転入者調査票出力有無,
                発行日_国外転入者調査票,
                発行番号の第_国外転入者調査票,
                発行番号の番号_国外転入者調査票,
                発行番号の号_国外転入者調査票,
                送付先宛名シール出力有無_国外転入者調査票,
                国外転入者調査一覧表出力有無,
                在外投票人名簿抄本出力有無,
                在外投票資格者名簿出力有無,
                在外投票管理表出力有無
        );
    }
}
