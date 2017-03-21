package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 */
public interface IZaigaiMeiboJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     */
    void initialize(RString 申請番号, ShikibetsuCode 識別コード);

    /**
     * 共有子Divの表示状態（表示／非表示）モードを設定します。
     *
     * @param displayNoneSetMode 表示状態（表示／非表示）
     */
    void setDisplayNoneMode(Boolean displayNoneSetMode);

    /**
     * 共有子Divの書込み状態モードを設定します。
     *
     * @param readOnlySetMode
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * 共有子Divのクローズ状態モードを設定します。
     *
     * @param isOpenSetMode
     */
    void setIsOpenMode(Boolean isOpenSetMode);

    /**
     * 共有子Divのクローズ状態モードを設定します。
     *
     * @return ZaigaiMeiboJohoDiv
     */
    ZaigaiMeiboJohoDiv get在外名簿情報();
}
