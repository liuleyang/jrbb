package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * MasterCsvOutputParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class MasterCsvOutputParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTohyoku")
    private CheckBoxList chkTohyoku;
    @JsonProperty("chkTohyojo")
    private CheckBoxList chkTohyojo;
    @JsonProperty("chkSenkyoku")
    private CheckBoxList chkSenkyoku;
    @JsonProperty("chkShisetsu")
    private CheckBoxList chkShisetsu;
    @JsonProperty("chkHojosha")
    private CheckBoxList chkHojosha;
    @JsonProperty("chkKumiai")
    private CheckBoxList chkKumiai;
    @JsonProperty("chkRyojikan")
    private CheckBoxList chkRyojikan;
    @JsonProperty("chkCode")
    private CheckBoxList chkCode;
    @JsonProperty("chkConfig")
    private CheckBoxList chkConfig;
    @JsonProperty("ccdShisetsuShubetsu")
    private CodeInputDiv ccdShisetsuShubetsu;
    @JsonProperty("ccdShohonNameListHojosha")
    private ShohonNameListDiv ccdShohonNameListHojosha;
    @JsonProperty("ccdSenkyoShuruiTohyoku")
    private CodeInputDiv ccdSenkyoShuruiTohyoku;
    @JsonProperty("ccdSenkyoShuruiSenkyoku")
    private CodeInputDiv ccdSenkyoShuruiSenkyoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTohyoku
     * @return chkTohyoku
     */
    @JsonProperty("chkTohyoku")
    public CheckBoxList getChkTohyoku() {
        return chkTohyoku;
    }

    /*
     * setchkTohyoku
     * @param chkTohyoku chkTohyoku
     */
    @JsonProperty("chkTohyoku")
    public void setChkTohyoku(CheckBoxList chkTohyoku) {
        this.chkTohyoku = chkTohyoku;
    }

    /*
     * getchkTohyojo
     * @return chkTohyojo
     */
    @JsonProperty("chkTohyojo")
    public CheckBoxList getChkTohyojo() {
        return chkTohyojo;
    }

    /*
     * setchkTohyojo
     * @param chkTohyojo chkTohyojo
     */
    @JsonProperty("chkTohyojo")
    public void setChkTohyojo(CheckBoxList chkTohyojo) {
        this.chkTohyojo = chkTohyojo;
    }

    /*
     * getchkSenkyoku
     * @return chkSenkyoku
     */
    @JsonProperty("chkSenkyoku")
    public CheckBoxList getChkSenkyoku() {
        return chkSenkyoku;
    }

    /*
     * setchkSenkyoku
     * @param chkSenkyoku chkSenkyoku
     */
    @JsonProperty("chkSenkyoku")
    public void setChkSenkyoku(CheckBoxList chkSenkyoku) {
        this.chkSenkyoku = chkSenkyoku;
    }

    /*
     * getchkShisetsu
     * @return chkShisetsu
     */
    @JsonProperty("chkShisetsu")
    public CheckBoxList getChkShisetsu() {
        return chkShisetsu;
    }

    /*
     * setchkShisetsu
     * @param chkShisetsu chkShisetsu
     */
    @JsonProperty("chkShisetsu")
    public void setChkShisetsu(CheckBoxList chkShisetsu) {
        this.chkShisetsu = chkShisetsu;
    }

    /*
     * getchkHojosha
     * @return chkHojosha
     */
    @JsonProperty("chkHojosha")
    public CheckBoxList getChkHojosha() {
        return chkHojosha;
    }

    /*
     * setchkHojosha
     * @param chkHojosha chkHojosha
     */
    @JsonProperty("chkHojosha")
    public void setChkHojosha(CheckBoxList chkHojosha) {
        this.chkHojosha = chkHojosha;
    }

    /*
     * getchkKumiai
     * @return chkKumiai
     */
    @JsonProperty("chkKumiai")
    public CheckBoxList getChkKumiai() {
        return chkKumiai;
    }

    /*
     * setchkKumiai
     * @param chkKumiai chkKumiai
     */
    @JsonProperty("chkKumiai")
    public void setChkKumiai(CheckBoxList chkKumiai) {
        this.chkKumiai = chkKumiai;
    }

    /*
     * getchkRyojikan
     * @return chkRyojikan
     */
    @JsonProperty("chkRyojikan")
    public CheckBoxList getChkRyojikan() {
        return chkRyojikan;
    }

    /*
     * setchkRyojikan
     * @param chkRyojikan chkRyojikan
     */
    @JsonProperty("chkRyojikan")
    public void setChkRyojikan(CheckBoxList chkRyojikan) {
        this.chkRyojikan = chkRyojikan;
    }

    /*
     * getchkCode
     * @return chkCode
     */
    @JsonProperty("chkCode")
    public CheckBoxList getChkCode() {
        return chkCode;
    }

    /*
     * setchkCode
     * @param chkCode chkCode
     */
    @JsonProperty("chkCode")
    public void setChkCode(CheckBoxList chkCode) {
        this.chkCode = chkCode;
    }

    /*
     * getchkConfig
     * @return chkConfig
     */
    @JsonProperty("chkConfig")
    public CheckBoxList getChkConfig() {
        return chkConfig;
    }

    /*
     * setchkConfig
     * @param chkConfig chkConfig
     */
    @JsonProperty("chkConfig")
    public void setChkConfig(CheckBoxList chkConfig) {
        this.chkConfig = chkConfig;
    }

    /*
     * getccdShisetsuShubetsu
     * @return ccdShisetsuShubetsu
     */
    @JsonProperty("ccdShisetsuShubetsu")
    public ICodeInputDiv getCcdShisetsuShubetsu() {
        return ccdShisetsuShubetsu;
    }

    /*
     * getccdShohonNameListHojosha
     * @return ccdShohonNameListHojosha
     */
    @JsonProperty("ccdShohonNameListHojosha")
    public IShohonNameListDiv getCcdShohonNameListHojosha() {
        return ccdShohonNameListHojosha;
    }

    /*
     * getccdSenkyoShuruiTohyoku
     * @return ccdSenkyoShuruiTohyoku
     */
    @JsonProperty("ccdSenkyoShuruiTohyoku")
    public ICodeInputDiv getCcdSenkyoShuruiTohyoku() {
        return ccdSenkyoShuruiTohyoku;
    }

    /*
     * getccdSenkyoShuruiSenkyoku
     * @return ccdSenkyoShuruiSenkyoku
     */
    @JsonProperty("ccdSenkyoShuruiSenkyoku")
    public ICodeInputDiv getCcdSenkyoShuruiSenkyoku() {
        return ccdSenkyoShuruiSenkyoku;
    }

    // </editor-fold>
}
