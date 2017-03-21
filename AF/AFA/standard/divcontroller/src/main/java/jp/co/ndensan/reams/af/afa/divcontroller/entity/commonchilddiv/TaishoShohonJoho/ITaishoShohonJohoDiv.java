package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TaishoShohonJoho;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L AF-0050-010 qiuxy
 */
public interface ITaishoShohonJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 選択された抄本番号を取得します。
     *
     * @return 抄本番号
     */
    RString getTxtHdnShohonNo();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * この共有子Divの初期表示を行います。
     *
     */
    void initialSetting();

    /**
     * 引数の抄本番号で、この共有子Divの初期表示を行います。
     *
     * @param shohonNo RString
     */
    void initialize(RString shohonNo);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 選択された抄本番号の投票日を取得します。
     *
     * @return 投票日
     */
    TextBoxDate getTxtTohyoYMD();

    /**
     * 選択された抄本番号の抄本名を取得します。
     *
     * @return 抄本名
     */
    TextBox getTxtShohonName();

    /**
     * 対象情報のハンドラを取得します。
     *
     * @return ハンドラ
     */
    TaishoShohonJohoHandler getHandler();

    /**
     * 抄本名を取得します。
     *
     * @return 抄本名
     */
    RString get抄本名();

    /**
     * 基準日を取得します。
     *
     * @return 基準日
     */
    RDate get基準日();

    /**
     * 投票日を取得します。
     *
     * @return 投票日
     */
    RDate get投票日();

    /**
     * 名簿登録日を取得します。
     *
     * @return 名簿登録日
     */
    RDate get名簿登録日();

    /**
     * 年齢到達日を取得します。
     *
     * @return 年齢到達日
     */
    RDate get年齢到達日();

    /**
     * 転出期限日を取得します。
     *
     * @return 転出期限日
     */
    RDate get転出期限日();

    /**
     * 転入期限日を取得します。
     *
     * @return 転入期限日
     */
    RDate get転入期限日();
}
