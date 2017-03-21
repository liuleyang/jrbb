package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuFuzuiJoho;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaikuFuzuiJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 引数の抄本番号、識別コードから、この共有子Divの初期表示を行います。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     */
    void initialize(RString shohonNo, ShikibetsuCode shikibetsuCode);

    /**
     * 識別コードから、この共有子Divの初期表示を行います。
     *
     * @param shikibetsuCode ShikibetsuCode
     */
    void initialize(ShikibetsuCode shikibetsuCode);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 共有子Div自身のsetDisplayNoneをセットします。
     *
     * @param displayNoneSetMode True：表示しない　False：表示する
     */
    void setDisplayNoneMode(Boolean displayNoneSetMode);

    /**
     * 共有子Div自身のisDisplayNoneを取得します
     *
     * @return 表示状態
     */
    boolean isDisplayNoneMode();

    /**
     * この共有子Div情報を取得する。
     *
     * @return KaikuFuzuiJohoDiv
     */
    KaikuFuzuiJohoDiv get海区付随資格情報();

    /**
     * この共有子Div情報を更新する。
     *
     */
    void changeDdlShohon(RString shohonNo, ShikibetsuCode shikibetsuCode);
}
