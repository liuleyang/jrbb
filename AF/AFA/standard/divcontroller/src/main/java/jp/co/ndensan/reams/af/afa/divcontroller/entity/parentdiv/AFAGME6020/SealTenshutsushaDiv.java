package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.AtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.IAtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.IAtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SealTenshutsusha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SealTenshutsushaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SealTenshutsushaParam")
    private SealTenshutsushaParamDiv SealTenshutsushaParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSealTenshutsushaParam
     * @return SealTenshutsushaParam
     */
    @JsonProperty("SealTenshutsushaParam")
    public SealTenshutsushaParamDiv getSealTenshutsushaParam() {
        return SealTenshutsushaParam;
    }

    /*
     * setSealTenshutsushaParam
     * @param SealTenshutsushaParam SealTenshutsushaParam
     */
    @JsonProperty("SealTenshutsushaParam")
    public void setSealTenshutsushaParam(SealTenshutsushaParamDiv SealTenshutsushaParam) {
        this.SealTenshutsushaParam = SealTenshutsushaParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSenkyo() {
        return this.getSealTenshutsushaParam().getRadSenkyo();
    }

    @JsonIgnore
    public void  setRadSenkyo(RadioButton radSenkyo) {
        this.getSealTenshutsushaParam().setRadSenkyo(radSenkyo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKikan() {
        return this.getSealTenshutsushaParam().getTxtTaishoKikan();
    }

    @JsonIgnore
    public void  setTxtTaishoKikan(TextBoxDateRange txtTaishoKikan) {
        this.getSealTenshutsushaParam().setTxtTaishoKikan(txtTaishoKikan);
    }

    @JsonIgnore
    public SealTenshutsushaNaiyoDiv getSealTenshutsushaNaiyo() {
        return this.getSealTenshutsushaParam().getSealTenshutsushaNaiyo();
    }

    @JsonIgnore
    public void  setSealTenshutsushaNaiyo(SealTenshutsushaNaiyoDiv SealTenshutsushaNaiyo) {
        this.getSealTenshutsushaParam().setSealTenshutsushaNaiyo(SealTenshutsushaNaiyo);
    }

    @JsonIgnore
    public IAtenaSealLayoutDiv getCcdSealLayout() {
        return this.getSealTenshutsushaParam().getSealTenshutsushaNaiyo().getCcdSealLayout();
    }

    @JsonIgnore
    public IAtenaSealPositionGuideDiv getCcdSealPosition() {
        return this.getSealTenshutsushaParam().getCcdSealPosition();
    }

    @JsonIgnore
    public IShohonNameListDiv getCcdShohonNameList() {
        return this.getSealTenshutsushaParam().getCcdShohonNameList();
    }

    // </editor-fold>
}
