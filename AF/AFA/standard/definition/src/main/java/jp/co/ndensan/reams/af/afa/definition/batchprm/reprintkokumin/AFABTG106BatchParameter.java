/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.reprintkokumin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
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
 * 投票人名簿最新化バッチパラメータクラスです。
 *
 * @reamsid_L AF-0390-030 jihb
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTG106BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHONNO = "抄本番号";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_TOUHYOBI = "投票日";
    private static final String KEY_KIJUNBI = "基準日";
    private static final String KEY_MEIBOTOROKUBI = "名簿登録日";
    private static final String KEY_NENREITOTATSUBI = "年齢到達日";
    private static final String KEY_TOKUTEIKIKANKAISHIBI = "特定期間開始日";
    private static final String KEY_TOKUTEIKIGENBI = "特定期限日";
    private static final String KEY_TOHYOUKETSUKEBI = "受付開始日";
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

    @BatchParameter(key = KEY_SHOHONNO, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名", order = 2)
    private RString 抄本名;
    @BatchParameter(key = KEY_TOUHYOBI, name = "投票日", order = 3)
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_KIJUNBI, name = "基準日", order = 4)
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_MEIBOTOROKUBI, name = "名簿登録日", order = 5)
    private FlexibleDate 名簿登録日;
    @BatchParameter(key = KEY_NENREITOTATSUBI, name = "年齢到達日", order = 6)
    private FlexibleDate 年齢到達日;
    @BatchParameter(key = KEY_TOKUTEIKIKANKAISHIBI, name = "特定期間開始日", order = 7)
    private FlexibleDate 特定期間開始日;
    @BatchParameter(key = KEY_TOKUTEIKIGENBI, name = "特定期限日", order = 8)
    private FlexibleDate 特定期限日;
    @BatchParameter(key = KEY_TOHYOUKETSUKEBI, name = "受付開始日", order = 9)
    private FlexibleDate 受付開始日;
    @BatchParameter(key = KEY_MEIBOSHOHON, name = "投票人名簿抄本出力有無", order = 10)
    private Boolean 投票人名簿抄本出力有無;
    @BatchParameter(key = KEY_TOROKUSHASULISTFLG, name = "投票人名簿登録者数リスト出力有無", order = 11)
    private Boolean 投票人名簿登録者数リスト出力有無;
    @BatchParameter(key = KEY_KUJUNBI_TOROKUSHASU, name = "時点日", order = 12)
    private FlexibleDate 時点日;
    @BatchParameter(key = KEY_FUZAISHABUNFLG, name = "不在者投票資格者分出力有無", order = 13)
    private Boolean 不在者投票資格者分出力有無;
    @BatchParameter(key = KEY_FUZAITOHYOMEIBOFLG, name = "不在資格対象者名簿出力有無", order = 14)
    private Boolean 不在資格対象者名簿出力有無;
    @BatchParameter(key = KEY_1GOSHIKAKUTSUCHIFLG, name = "一号資格登録通知出力有無", order = 15)
    private Boolean 一号資格登録通知出力有無;
    @BatchParameter(key = KEY_HAKOUBI_1GOSHIKAKU, name = "発行日_1号資格登録", order = 16)
    private FlexibleDate 発行日_1号資格登録;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_1GOSHIKAKU, name = "発行番号の第_1号資格", order = 17)
    private RString 発行番号の第_1号資格;
    @BatchParameter(key = KEY_KAKOUNUM_NO_1GOSHIKAKU, name = "発行番号の番号_1号資格", order = 18)
    private RString 発行番号の番号_1号資格;
    @BatchParameter(key = KEY_KAKOUNUM_GO_1GOSHIKAKU, name = "発行番号の号_1号資格", order = 19)
    private RString 発行番号の号_1号資格;
    @BatchParameter(key = KEY_CHKSEAL1GOTSUCHIFLG, name = "送付先宛名シール出力有無_1号資格", order = 20)
    private Boolean 送付先宛名シール出力有無_1号資格;
    @BatchParameter(key = KEY_CHKSEAL1GOTSUCHIICHIRANFLG, name = "一号資格登録通知一覧表出力有無", order = 21)
    private Boolean 一号資格登録通知一覧表出力有無;
    @BatchParameter(key = KEY_2GOSHIKAKUCHOSAHYOFLG, name = "二号資格調査票出力有無", order = 22)
    private Boolean 二号資格調査票出力有無;
    @BatchParameter(key = KEY_HAKOUBI_2GOSHIKAKU, name = "発行日_2号資格", order = 23)
    private FlexibleDate 発行日_2号資格;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_2GOSHIKAKU, name = "発行番号の第_2号資格", order = 24)
    private RString 発行番号の第_2号資格;
    @BatchParameter(key = KEY_KAKOUNUM_NO_2GOSHIKAKU, name = "発行番号の番号_2号資格", order = 25)
    private RString 発行番号の番号_2号資格;
    @BatchParameter(key = KEY_KAKOUNUM_GO_2GOSHIKAKU, name = "発行番号の号_2号資格", order = 26)
    private RString 発行番号の号_2号資格;
    @BatchParameter(key = KEY_CHKSEAL2GOCHOSAHYOFLG, name = "送付先宛名シール出力有無_2号資格", order = 27)
    private Boolean 送付先宛名シール出力有無_2号資格;
    @BatchParameter(key = KEY_CHK2GOCHOSAICHIRANFLG, name = "二号資格調査一覧表出力有無", order = 28)
    private Boolean 二号資格調査一覧表出力有無;
    @BatchParameter(key = KEY_2GOKOHOLISTFLG, name = "二号資格候補者一覧表出力有無", order = 29)
    private Boolean 二号資格候補者一覧表出力有無;
    @BatchParameter(key = KEY_IDOTOROKUSHAMEIBOFLG, name = "補正登録者名簿出力有無", order = 30)
    private Boolean 補正登録者名簿出力有無;
    @BatchParameter(key = KEY_CHKTOROKUSHAMEIBOJURANFLG, name = "縦覧用も作成する出力有無_補正登録者", order = 31)
    private Boolean 縦覧用も作成する出力有無;
    @BatchParameter(key = KEY_CHKSEALTOROKUSHAMEIBO, name = "補正登録者宛名シール出力有無", order = 32)
    private Boolean 補正登録者宛名シール出力有無;
    @BatchParameter(key = KEY_IDOMASSHOSHAMEIBOFLG, name = "抹消者名簿出力有無", order = 33)
    private Boolean 抹消者名簿出力有無;
    @BatchParameter(key = KEY_MASSHOBI, name = "抹消日", order = 34)
    private FlexibleDate 抹消日;
    @BatchParameter(key = KEY_CHKMASSHOSHAMEIBOJURANFLG, name = "縦覧用も作成する出力有無_抹消者", order = 35)
    private Boolean 縦覧用も作成する出力有無_抹消者;
    @BatchParameter(key = KEY_IDOTEISEISHAMEIBOFLG, name = "訂正者名簿出力有無", order = 36)
    private Boolean 訂正者名簿出力有無;
    @BatchParameter(key = KEY_MASSHOTSUCHIFLG, name = "未登録者抹消通知出力有無", order = 37)
    private Boolean 未登録者抹消通知出力有無;
    @BatchParameter(key = KEY_HAKOUBI_MASSHOTSUCHI, name = "発行日_未登録者抹消", order = 38)
    private FlexibleDate 発行日_未登録者抹消;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_MASSHOTSUCHI, name = "発行番号の第_未登録者抹消", order = 39)
    private RString 発行番号の第_未登録者抹消;
    @BatchParameter(key = KEY_KAKOUNUM_NO_MASSHOTSUCHI, name = "発行番号の番号_未登録者抹消", order = 40)
    private RString 発行番号の番号_未登録者抹消;
    @BatchParameter(key = KEY_KAKOUNUM_GO_MASSHOTSUCHI, name = "発行番号の号_未登録者抹消", order = 41)
    private RString 発行番号の号_未登録者抹消;
    @BatchParameter(key = KEY_CHKSEALMASSHOTSUCHI, name = "送付先宛名シール出力有無_未登録者抹消", order = 42)
    private Boolean 送付先宛名シール出力有無_未登録者抹消;
    @BatchParameter(key = KEY_CHKMASSHOTSUCHIICHIRANFLG, name = "未登録者抹消通知一覧出力有無", order = 43)
    private Boolean 未登録者抹消通知一覧出力有無;
    @BatchParameter(key = KEY_KOKUNAICHOSAHYOFLG, name = "国内転入者調査票出力有無", order = 44)
    private Boolean 国内転入者調査票出力有無;
    @BatchParameter(key = KEY_HAKOUBI_KOKUNAICHOSA, name = "発行日_国内転入者調査票", order = 45)
    private FlexibleDate 発行日_国内転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_KOKUNAICHOSA, name = "発行番号の第_国内転入者調査票", order = 46)
    private RString 発行番号の第_国内転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_NO_KOKUNAICHOSA, name = "発行番号の番号_国内転入者調査票", order = 47)
    private RString 発行番号の番号_国内転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_GO_KOKUNAICHOSA, name = "発行番号の号_国内転入者調査票", order = 48)
    private RString 発行番号の号_国内転入者調査票;
    @BatchParameter(key = KEY_CHKSEALKOKUNAICHOSAFLG, name = "送付先宛名シール出力有無_国内転入者調査票", order = 49)
    private Boolean 送付先宛名シール出力有無_国内転入者調査票;
    @BatchParameter(key = KEY_CHKKOKUNAICHOSAICHIRANFLG, name = "国内転入者調査一覧表出力有無", order = 50)
    private Boolean 国内転入者調査一覧表出力有無;
    @BatchParameter(key = KEY_KOKUGAICHOSAHYOFLG, name = "国外転入者調査票出力有無", order = 51)
    private Boolean 国外転入者調査票出力有無;
    @BatchParameter(key = KEY_HAKOUBI_KOKUGAICHOSA, name = "発行日_国外転入者調査票", order = 52)
    private FlexibleDate 発行日_国外転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_DAI_KOKUGAICHOSA, name = "発行番号の第_国外転入者調査票", order = 53)
    private RString 発行番号の第_国外転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_NO_KOKUGAICHOSA, name = "発行番号の番号_国外転入者調査票", order = 54)
    private RString 発行番号の番号_国外転入者調査票;
    @BatchParameter(key = KEY_KAKOUNUM_GO_KOKUGAICHOSA, name = "発行番号の号_国外転入者調査票", order = 55)
    private RString 発行番号の号_国外転入者調査票;
    @BatchParameter(key = KEY_CHKSEALKOKUGAICHOSAFLG, name = "送付先宛名シール出力有無_国外転入者調査票", order = 56)
    private Boolean 送付先宛名シール出力有無_国外転入者調査票;
    @BatchParameter(key = KEY_CHKKOKUGAICHOSAICHIRANFLG, name = "国外転入者調査一覧表出力有無", order = 57)
    private Boolean 国外転入者調査一覧表出力有無;
    @BatchParameter(key = KEY_ZAIGAISENKYONINMEIBOSHOHON, name = "在外投票人名簿抄本出力有無", order = 58)
    private Boolean 在外投票人名簿抄本出力有無;
    @BatchParameter(key = KEY_ZAIGAISHIKAKUSHAMEIBOFLG, name = "在外投票資格者名簿出力有無", order = 59)
    private Boolean 在外投票資格者名簿出力有無;
    @BatchParameter(key = KEY_ZAIGAITOHYOKANRIHYOFLG, name = "在外投票管理表出力有無", order = 60)
    private Boolean 在外投票管理表出力有無;

    /**
     * AFABTG101SelectProcessParameterrの変換のメソッドです。
     *
     * @return AFABTG101SelectProcessParameter
     */
    public AFABTG101SelectProcessParameter toAFABTG101SelectProcessParameter() {
        return new AFABTG101SelectProcessParameter(null, RString.isNullOrEmpty(抄本番号) ? new ShohonNo(0) : new ShohonNo(抄本番号),
                抄本名, 投票日,
                基準日, 名簿登録日, 年齢到達日, 特定期間開始日, 特定期限日, 受付開始日, 時点日, 発行日_1号資格登録, 発行番号の第_1号資格,
                発行番号の番号_1号資格, 発行番号の号_1号資格, 発行日_2号資格, 発行番号の第_2号資格, 発行番号の番号_2号資格,
                発行番号の号_2号資格, 抹消日, 発行日_未登録者抹消, 発行番号の第_未登録者抹消, 発行番号の番号_未登録者抹消,
                発行番号の号_未登録者抹消, 発行日_国内転入者調査票, 発行番号の第_国内転入者調査票,
                発行番号の番号_国内転入者調査票, 発行番号の号_国内転入者調査票, 発行日_国外転入者調査票,
                発行番号の第_国外転入者調査票, 発行番号の番号_国外転入者調査票, 発行番号の号_国外転入者調査票,
                null, RString.EMPTY);

    }

    /**
     * AFABTA101SelectProcessParameterへ変換のメソッドです。
     *
     * @return AFABTA101SelectProcessParameter
     */
    public AFABTA101SelectProcessParameter toAFABTA101SelectProcessParameter() {
        return new AFABTA101SelectProcessParameter(
                null,
                RString.isNullOrEmpty(抄本番号) ? new ShohonNo(0) : new ShohonNo(抄本番号),
                抄本名,
                基準日,
                名簿登録日,
                投票日,
                特定期間開始日,
                特定期限日,
                年齢到達日,
                Arrays.asList(FlexibleDate.EMPTY, FlexibleDate.EMPTY),
                null,
                null,
                RString.EMPTY,
                RString.EMPTY,
                FlexibleDate.EMPTY,
                FlexibleDate.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * AFABTA101SelectProcessParameterへ変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @return AFABTA101SelectProcessParameter
     */
    public AFABTA101SelectProcessParameter toAFABTA101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll) {
        return new AFABTA101SelectProcessParameter(
                RString.EMPTY,
                RString.isNullOrEmpty(抄本番号) ? new ShohonNo(0) : new ShohonNo(抄本番号),
                抄本名,
                基準日,
                名簿登録日,
                投票日,
                特定期間開始日,
                特定期限日,
                年齢到達日,
                Arrays.asList(FlexibleDate.EMPTY, FlexibleDate.EMPTY),
                key,
                keyForAll,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    /**
     * AFABTB101SelectProcessParameterへ変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @return AFABTB101SelectProcessParameter
     */
    public AFABTB101SelectProcessParameter toAFABTB101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll) {
        List<FlexibleDate> 帰化期間 = new ArrayList<>();
        帰化期間.add(FlexibleDate.EMPTY);
        帰化期間.add(FlexibleDate.EMPTY);
        return new AFABTB101SelectProcessParameter(null,
                null,
                RString.isNullOrEmpty(抄本番号) ? new ShohonNo(0) : new ShohonNo(抄本番号),
                抄本名,
                基準日,
                名簿登録日,
                投票日,
                特定期間開始日,
                特定期限日,
                年齢到達日,
                帰化期間,
                key,
                keyForAll,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

    }
}
