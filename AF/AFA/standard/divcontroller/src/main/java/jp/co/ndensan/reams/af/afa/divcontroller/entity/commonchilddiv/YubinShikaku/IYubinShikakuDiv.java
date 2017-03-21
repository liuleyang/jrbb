package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public interface IYubinShikakuDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoShurui RString
     */
    void initialize(ShikibetsuCode shikibetsuCode, RString senkyoShurui);

    /**
     * この共有子Divをダイアログ画面を表示する時の画面項目制御です。
     *
     */
    void set画面項目制御_資格登録画面以外();

    void set画面項目制御_代理記載者情報非活性();

    void clear代理記載者情報();

    /**
     * この共有子Div情報を取得する。
     *
     * @return YubinShikakuDiv
     */
    YubinShikakuDiv get郵便等投票資格情報();
}
