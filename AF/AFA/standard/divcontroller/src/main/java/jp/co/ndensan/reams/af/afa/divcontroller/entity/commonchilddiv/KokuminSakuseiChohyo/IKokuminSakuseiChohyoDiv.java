package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * このコードはツールによって生成されました。
 */
public interface IKokuminSakuseiChohyoDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     */
    void initialize();

    /**
     * 引数の抄本番号から、帳票条件の初期表示を行います。
     *
     * @param shohonNo RString 抄本番号
     */
    void initialize(RString shohonNo);

    /**
     * 引数の各種日付で、帳票条件の初期表示を行います。
     *
     * @param tokuteiKigenYmd RDate 特定期限日
     * @param kijunKigenYmd RDate 基準日
     * @param shoriYmd RDate 抄本を作成した日付
     */
    void initialize(RDate tokuteiKigenYmd, RDate kijunKigenYmd, RDate shoriYmd);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * BarCodeNyuryokuValidationHandlerを返す。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs validate時点日();

    /**
     * 時点日を取得する
     *
     * @return 時点日
     */
    TextBoxDate get時点日();

    /**
     * 投票人名簿抄本取得
     *
     * @return 投票人名簿抄本
     */
    KokuminSakuseiChohyoMeiboShohonDiv get投票人名簿抄本();

    /**
     * 投票人名簿登録者数リスト取得
     *
     * @return 投票人名簿登録者数リスト
     */
    KokuminSakuseiChohyoTorokushasuListDiv get投票人名簿登録者数リスト();

    /**
     * 1号資格登録通知取得
     *
     * @return 1号資格登録通知
     */
    KokuminSakuseiChohyo1goShikakuTsuchiDiv get1号資格登録通知();

    /**
     * 2号資格調査票取得
     *
     * @return 2号資格調査票
     */
    KokuminSakuseiChohyo2goShikakuChosahyoDiv get2号資格調査票();

    /**
     * 2号資格候補者一覧表取得
     *
     * @return 2号資格候補者一覧表
     */
    KokuminSakuseiChohyo2goKohoListDiv get2号資格候補者一覧表();

    /**
     * 補正登録者名簿取得
     *
     * @return 補正登録者名簿
     */
    KokuminSakuseiChohyoIdoTorokushaMeiboDiv get補正登録者名簿();

    /**
     * 抹消者名簿取得
     *
     * @return 抹消者名簿
     */
    KokuminSakuseiChohyoIdoMasshoshaMeiboDiv get抹消者名簿();

    /**
     * 訂正者名簿取得
     *
     * @return 訂正者名簿
     */
    KokuminSakuseiChohyoIdoTeiseishaMeiboDiv get訂正者名簿();

    /**
     * 未登録者抹消通知取得
     *
     * @return 未登録者抹消通知
     */
    KokuminSakuseiChohyoMasshoTsuchiDiv get未登録者抹消通知();

    /**
     * 国内転入者調査票取得
     *
     * @return 国内転入者調査票
     */
    KokuminSakuseiChohyoKokunaiChosahyoDiv get国内転入者調査票();

    /**
     * 国外転入者調査票取得
     *
     * @return 国外転入者調査票
     */
    KokuminSakuseiChohyoKokugaiChosahyoDiv get国外転入者調査票();

    /**
     * 在外投票関連取得
     *
     * @return 在外投票関連
     */
    KokuminSakuseiChohyoZaigaiDiv get在外投票関連();
}
