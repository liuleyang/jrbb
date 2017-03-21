package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchShikakuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchShikakuShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchTorokuYmd")
    private TextBoxDateRange txtSearchTorokuYmd;
    @JsonProperty("ccdSearchTorokuJiyu")
    private JiyuNameListDiv ccdSearchTorokuJiyu;
    @JsonProperty("txtSearchTeishiYMD")
    private TextBoxDateRange txtSearchTeishiYMD;
    @JsonProperty("ccdSearchTeishiJiyu")
    private JiyuNameListDiv ccdSearchTeishiJiyu;
    @JsonProperty("txtSearchMasshoYMD")
    private TextBoxDateRange txtSearchMasshoYMD;
    @JsonProperty("ccdSearchMasshoJiyu")
    private JiyuNameListDiv ccdSearchMasshoJiyu;
    @JsonProperty("txtSearchHyojiYMD")
    private TextBoxDateRange txtSearchHyojiYMD;
    @JsonProperty("ccdSearchHyojiJiyu")
    private JiyuNameListDiv ccdSearchHyojiJiyu;
    @JsonProperty("txtSearchShojoYoteiYMD")
    private TextBoxDateRange txtSearchShojoYoteiYMD;
    @JsonProperty("txtSearchShojoYMD")
    private TextBoxDateRange txtSearchShojoYMD;
    @JsonProperty("txtSearchKeikiShuryoYMD")
    private TextBoxDateRange txtSearchKeikiShuryoYMD;
    @JsonProperty("chk2keiMochi")
    private CheckBoxList chk2keiMochi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSearchTorokuYmd
     * @return txtSearchTorokuYmd
     */
    @JsonProperty("txtSearchTorokuYmd")
    public TextBoxDateRange getTxtSearchTorokuYmd() {
        return txtSearchTorokuYmd;
    }

    /*
     * settxtSearchTorokuYmd
     * @param txtSearchTorokuYmd txtSearchTorokuYmd
     */
    @JsonProperty("txtSearchTorokuYmd")
    public void setTxtSearchTorokuYmd(TextBoxDateRange txtSearchTorokuYmd) {
        this.txtSearchTorokuYmd = txtSearchTorokuYmd;
    }

    /*
     * getccdSearchTorokuJiyu
     * @return ccdSearchTorokuJiyu
     */
    @JsonProperty("ccdSearchTorokuJiyu")
    public IJiyuNameListDiv getCcdSearchTorokuJiyu() {
        return ccdSearchTorokuJiyu;
    }

    /*
     * gettxtSearchTeishiYMD
     * @return txtSearchTeishiYMD
     */
    @JsonProperty("txtSearchTeishiYMD")
    public TextBoxDateRange getTxtSearchTeishiYMD() {
        return txtSearchTeishiYMD;
    }

    /*
     * settxtSearchTeishiYMD
     * @param txtSearchTeishiYMD txtSearchTeishiYMD
     */
    @JsonProperty("txtSearchTeishiYMD")
    public void setTxtSearchTeishiYMD(TextBoxDateRange txtSearchTeishiYMD) {
        this.txtSearchTeishiYMD = txtSearchTeishiYMD;
    }

    /*
     * getccdSearchTeishiJiyu
     * @return ccdSearchTeishiJiyu
     */
    @JsonProperty("ccdSearchTeishiJiyu")
    public IJiyuNameListDiv getCcdSearchTeishiJiyu() {
        return ccdSearchTeishiJiyu;
    }

    /*
     * gettxtSearchMasshoYMD
     * @return txtSearchMasshoYMD
     */
    @JsonProperty("txtSearchMasshoYMD")
    public TextBoxDateRange getTxtSearchMasshoYMD() {
        return txtSearchMasshoYMD;
    }

    /*
     * settxtSearchMasshoYMD
     * @param txtSearchMasshoYMD txtSearchMasshoYMD
     */
    @JsonProperty("txtSearchMasshoYMD")
    public void setTxtSearchMasshoYMD(TextBoxDateRange txtSearchMasshoYMD) {
        this.txtSearchMasshoYMD = txtSearchMasshoYMD;
    }

    /*
     * getccdSearchMasshoJiyu
     * @return ccdSearchMasshoJiyu
     */
    @JsonProperty("ccdSearchMasshoJiyu")
    public IJiyuNameListDiv getCcdSearchMasshoJiyu() {
        return ccdSearchMasshoJiyu;
    }

    /*
     * gettxtSearchHyojiYMD
     * @return txtSearchHyojiYMD
     */
    @JsonProperty("txtSearchHyojiYMD")
    public TextBoxDateRange getTxtSearchHyojiYMD() {
        return txtSearchHyojiYMD;
    }

    /*
     * settxtSearchHyojiYMD
     * @param txtSearchHyojiYMD txtSearchHyojiYMD
     */
    @JsonProperty("txtSearchHyojiYMD")
    public void setTxtSearchHyojiYMD(TextBoxDateRange txtSearchHyojiYMD) {
        this.txtSearchHyojiYMD = txtSearchHyojiYMD;
    }

    /*
     * getccdSearchHyojiJiyu
     * @return ccdSearchHyojiJiyu
     */
    @JsonProperty("ccdSearchHyojiJiyu")
    public IJiyuNameListDiv getCcdSearchHyojiJiyu() {
        return ccdSearchHyojiJiyu;
    }

    /*
     * gettxtSearchShojoYoteiYMD
     * @return txtSearchShojoYoteiYMD
     */
    @JsonProperty("txtSearchShojoYoteiYMD")
    public TextBoxDateRange getTxtSearchShojoYoteiYMD() {
        return txtSearchShojoYoteiYMD;
    }

    /*
     * settxtSearchShojoYoteiYMD
     * @param txtSearchShojoYoteiYMD txtSearchShojoYoteiYMD
     */
    @JsonProperty("txtSearchShojoYoteiYMD")
    public void setTxtSearchShojoYoteiYMD(TextBoxDateRange txtSearchShojoYoteiYMD) {
        this.txtSearchShojoYoteiYMD = txtSearchShojoYoteiYMD;
    }

    /*
     * gettxtSearchShojoYMD
     * @return txtSearchShojoYMD
     */
    @JsonProperty("txtSearchShojoYMD")
    public TextBoxDateRange getTxtSearchShojoYMD() {
        return txtSearchShojoYMD;
    }

    /*
     * settxtSearchShojoYMD
     * @param txtSearchShojoYMD txtSearchShojoYMD
     */
    @JsonProperty("txtSearchShojoYMD")
    public void setTxtSearchShojoYMD(TextBoxDateRange txtSearchShojoYMD) {
        this.txtSearchShojoYMD = txtSearchShojoYMD;
    }

    /*
     * gettxtSearchKeikiShuryoYMD
     * @return txtSearchKeikiShuryoYMD
     */
    @JsonProperty("txtSearchKeikiShuryoYMD")
    public TextBoxDateRange getTxtSearchKeikiShuryoYMD() {
        return txtSearchKeikiShuryoYMD;
    }

    /*
     * settxtSearchKeikiShuryoYMD
     * @param txtSearchKeikiShuryoYMD txtSearchKeikiShuryoYMD
     */
    @JsonProperty("txtSearchKeikiShuryoYMD")
    public void setTxtSearchKeikiShuryoYMD(TextBoxDateRange txtSearchKeikiShuryoYMD) {
        this.txtSearchKeikiShuryoYMD = txtSearchKeikiShuryoYMD;
    }

    /*
     * getchk2keiMochi
     * @return chk2keiMochi
     */
    @JsonProperty("chk2keiMochi")
    public CheckBoxList getChk2keiMochi() {
        return chk2keiMochi;
    }

    /*
     * setchk2keiMochi
     * @param chk2keiMochi chk2keiMochi
     */
    @JsonProperty("chk2keiMochi")
    public void setChk2keiMochi(CheckBoxList chk2keiMochi) {
        this.chk2keiMochi = chk2keiMochi;
    }

    // </editor-fold>
}
