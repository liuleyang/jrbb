package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MasterCsvOutput のクラスファイル 
 * 
 * @author 自動生成
 */
public class MasterCsvOutputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("MasterCsvOutputParam")
    private MasterCsvOutputParamDiv MasterCsvOutputParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getMasterCsvOutputParam
     * @return MasterCsvOutputParam
     */
    @JsonProperty("MasterCsvOutputParam")
    public MasterCsvOutputParamDiv getMasterCsvOutputParam() {
        return MasterCsvOutputParam;
    }

    /*
     * setMasterCsvOutputParam
     * @param MasterCsvOutputParam MasterCsvOutputParam
     */
    @JsonProperty("MasterCsvOutputParam")
    public void setMasterCsvOutputParam(MasterCsvOutputParamDiv MasterCsvOutputParam) {
        this.MasterCsvOutputParam = MasterCsvOutputParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkTohyoku() {
        return this.getMasterCsvOutputParam().getChkTohyoku();
    }

    @JsonIgnore
    public void  setChkTohyoku(CheckBoxList chkTohyoku) {
        this.getMasterCsvOutputParam().setChkTohyoku(chkTohyoku);
    }

    @JsonIgnore
    public CheckBoxList getChkTohyojo() {
        return this.getMasterCsvOutputParam().getChkTohyojo();
    }

    @JsonIgnore
    public void  setChkTohyojo(CheckBoxList chkTohyojo) {
        this.getMasterCsvOutputParam().setChkTohyojo(chkTohyojo);
    }

    @JsonIgnore
    public CheckBoxList getChkSenkyoku() {
        return this.getMasterCsvOutputParam().getChkSenkyoku();
    }

    @JsonIgnore
    public void  setChkSenkyoku(CheckBoxList chkSenkyoku) {
        this.getMasterCsvOutputParam().setChkSenkyoku(chkSenkyoku);
    }

    @JsonIgnore
    public CheckBoxList getChkShisetsu() {
        return this.getMasterCsvOutputParam().getChkShisetsu();
    }

    @JsonIgnore
    public void  setChkShisetsu(CheckBoxList chkShisetsu) {
        this.getMasterCsvOutputParam().setChkShisetsu(chkShisetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkHojosha() {
        return this.getMasterCsvOutputParam().getChkHojosha();
    }

    @JsonIgnore
    public void  setChkHojosha(CheckBoxList chkHojosha) {
        this.getMasterCsvOutputParam().setChkHojosha(chkHojosha);
    }

    @JsonIgnore
    public CheckBoxList getChkKumiai() {
        return this.getMasterCsvOutputParam().getChkKumiai();
    }

    @JsonIgnore
    public void  setChkKumiai(CheckBoxList chkKumiai) {
        this.getMasterCsvOutputParam().setChkKumiai(chkKumiai);
    }

    @JsonIgnore
    public CheckBoxList getChkRyojikan() {
        return this.getMasterCsvOutputParam().getChkRyojikan();
    }

    @JsonIgnore
    public void  setChkRyojikan(CheckBoxList chkRyojikan) {
        this.getMasterCsvOutputParam().setChkRyojikan(chkRyojikan);
    }

    @JsonIgnore
    public CheckBoxList getChkCode() {
        return this.getMasterCsvOutputParam().getChkCode();
    }

    @JsonIgnore
    public void  setChkCode(CheckBoxList chkCode) {
        this.getMasterCsvOutputParam().setChkCode(chkCode);
    }

    @JsonIgnore
    public CheckBoxList getChkConfig() {
        return this.getMasterCsvOutputParam().getChkConfig();
    }

    @JsonIgnore
    public void  setChkConfig(CheckBoxList chkConfig) {
        this.getMasterCsvOutputParam().setChkConfig(chkConfig);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdShisetsuShubetsu() {
        return this.getMasterCsvOutputParam().getCcdShisetsuShubetsu();
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameListHojosha() {
        return this.getMasterCsvOutputParam().getCcdShohonNameListHojosha();
    }

    @JsonIgnore
    public ICodeInputDiv getCcdSenkyoShuruiTohyoku() {
        return this.getMasterCsvOutputParam().getCcdSenkyoShuruiTohyoku();
    }

    @JsonIgnore
    public ICodeInputDiv getCcdSenkyoShuruiSenkyoku() {
        return this.getMasterCsvOutputParam().getCcdSenkyoShuruiSenkyoku();
    }

    // </editor-fold>
}
