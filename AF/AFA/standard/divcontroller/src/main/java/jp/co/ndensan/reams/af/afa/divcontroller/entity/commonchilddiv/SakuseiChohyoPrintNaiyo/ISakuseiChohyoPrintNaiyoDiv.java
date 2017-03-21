package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyoPrintNaiyo;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HakkoBango.IHakkoBangoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * このコードはツールによって生成されました。
 */
public interface ISakuseiChohyoPrintNaiyoDiv extends ICommonChildDivBaseProperties {

    TextBoxDate getTxtHakkoYMD();

    void setTxtHakkoYMD(TextBoxDate txtHakkoYMD);

    IHakkoBangoDiv getCcdHakkoBango();

    TextBox getTxtIinchoName();

    void setTxtIinchoName(TextBox txtIinchoName);

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param chohyoID RString 帳票ID
     */
    void initialize(RString chohyoID);

    /**
     * 引数の帳票ID、発行日から、帳票印字内容の初期表示を行います。
     *
     * @param chohyoID RString 帳票ID
     * @param hakkoYMD RDate 発行日
     */
    void initialize(RString chohyoID, RDate hakkoYMD);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

}
