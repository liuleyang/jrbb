package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * このコードはツールによって生成されました。
 */
public interface IMeiboSakuseiKijunDiv extends ICommonChildDivBaseProperties {

    RadioButton getRadShori();

    void setRadShori(RadioButton radShori);

    IShohonNameListDiv getCcdShohonNameList();

    TextBox getTxtShohonName();

    void setTxtShohonName(TextBox txtShohonName);

    TextBoxDate getTxtTohyoYMD();

    void setTxtTohyoYMD(TextBoxDate txtTohyoYMD);

    TextBoxDate getTxtKijunYMD();

    void setTxtKijunYMD(TextBoxDate txtKijunYMD);

    Button getBtnSetYmd();

    void setBtnSetYmd(Button btnSetYmd);

    TextBoxDate getTxtMeiboTorokuYMD();

    void setTxtMeiboTorokuYMD(TextBoxDate txtMeiboTorokuYMD);

    TextBoxDate getTxtTenshutsuYMD();

    void setTxtTenshutsuYMD(TextBoxDate txtTenshutsuYMD);

    TextBoxDate getTxtTennyuYMD();

    void setTxtTennyuYMD(TextBoxDate txtTennyuYMD);

    TextBoxDate getTxtNenreiTotatsuYMD();

    void setTxtNenreiTotatsuYMD(TextBoxDate txtNenreiTotatsuYMD);

    SenkyoNyuryokuDiv getSenkyoNyuryoku();

    void setSenkyoNyuryoku(SenkyoNyuryokuDiv SenkyoNyuryoku);

    Button getBtnSetChohyoYmd();

    void setBtnSetChohyoYmd(Button btnSetChohyoYmd);

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
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 新規処理と再処理のラジオボタン切り替え時の処理をするメソッドです。
     *
     */
    void clickRadShori();

    /**
     * 画面上の選挙情報を取得します。
     *
     * @return 選挙情報リスト
     */
    List<dgSenkyojiSenkyoNyuryoku_Row> get選挙情報();

    /**
     * この共有子Divに初期値を設定します。
     *
     * @param senkyoShurui
     */
    void setTxtHdnSenkyoShurui(RString senkyoShurui);

    /**
     * 定時登録抄本項目値を設定します。
     */
    void setSelected抄本項目By定時登録();

    /**
     * 選挙時登録抄本項目値を設定します。
     */
    void setSelected抄本項目By選挙時登録();

    /**
     * 処理種類を設定します。
     *
     * @param key key
     */
    void set処理種類(RString key);
}
