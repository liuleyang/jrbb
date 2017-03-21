package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiSenkyoninJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.JiyuNameListDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 *
 * @reamsid_L AF-0320-011 lis
 */
public class ZaigaiSenkyoninJohoDiv extends Panel implements IZaigaiSenkyoninJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdHenkoJiyu")
    private JiyuNameListDiv ccdHenkoJiyu;
    @JsonProperty("ZaigaiHonninJoho")
    private ZaigaiHonninJohoDiv ZaigaiHonninJoho;
    @JsonProperty("ZaigaiZaijuJoho")
    private ZaigaiZaijuJohoDiv ZaigaiZaijuJoho;
    @JsonProperty("ZaigaiShinseiJoho")
    private ZaigaiShinseiJohoDiv ZaigaiShinseiJoho;
    @JsonProperty("hiddenShikibetsuCode")
    private RString hiddenShikibetsuCode;
    @JsonProperty("hdnJushoShuruiKubun1")
    private RString hdnJushoShuruiKubun1;
    @JsonProperty("hdnJushoShuruiKubun2")
    private RString hdnJushoShuruiKubun2;
    @JsonProperty("hdnJushoShuruiKubun3")
    private RString hdnJushoShuruiKubun3;
    @JsonProperty("hdnJushoShuruiKubun4")
    private RString hdnJushoShuruiKubun4;
    @JsonProperty("hdnJushoShuruiKubun5")
    private RString hdnJushoShuruiKubun5;
    @JsonProperty("hdnZaigaiSenkyoninShinsei")
    private RString hdnZaigaiSenkyoninShinsei;
    @JsonProperty("hdnZaigaiSenkyoShikaku")
    private RString hdnZaigaiSenkyoShikaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdHenkoJiyu
     * @return ccdHenkoJiyu
     */
    @JsonProperty("ccdHenkoJiyu")
    public IJiyuNameListDiv getCcdHenkoJiyu() {
        return ccdHenkoJiyu;
    }

    /*
     * getZaigaiHonninJoho
     * @return ZaigaiHonninJoho
     */
    @JsonProperty("ZaigaiHonninJoho")
    @Override
    public ZaigaiHonninJohoDiv getZaigaiHonninJoho() {
        return ZaigaiHonninJoho;
    }

    /*
     * setZaigaiHonninJoho
     * @param ZaigaiHonninJoho ZaigaiHonninJoho
     */
    @JsonProperty("ZaigaiHonninJoho")
    public void setZaigaiHonninJoho(ZaigaiHonninJohoDiv ZaigaiHonninJoho) {
        this.ZaigaiHonninJoho = ZaigaiHonninJoho;
    }

    /*
     * getZaigaiZaijuJoho
     * @return ZaigaiZaijuJoho
     */
    @JsonProperty("ZaigaiZaijuJoho")
    @Override
    public ZaigaiZaijuJohoDiv getZaigaiZaijuJoho() {
        return ZaigaiZaijuJoho;
    }

    /*
     * setZaigaiZaijuJoho
     * @param ZaigaiZaijuJoho ZaigaiZaijuJoho
     */
    @JsonProperty("ZaigaiZaijuJoho")
    public void setZaigaiZaijuJoho(ZaigaiZaijuJohoDiv ZaigaiZaijuJoho) {
        this.ZaigaiZaijuJoho = ZaigaiZaijuJoho;
    }

    /*
     * getZaigaiShinseiJoho
     * @return ZaigaiShinseiJoho
     */
    @JsonProperty("ZaigaiShinseiJoho")
    @Override
    public ZaigaiShinseiJohoDiv getZaigaiShinseiJoho() {
        return ZaigaiShinseiJoho;
    }

    /*
     * setZaigaiShinseiJoho
     * @param ZaigaiShinseiJoho ZaigaiShinseiJoho
     */
    @JsonProperty("ZaigaiShinseiJoho")
    public void setZaigaiShinseiJoho(ZaigaiShinseiJohoDiv ZaigaiShinseiJoho) {
        this.ZaigaiShinseiJoho = ZaigaiShinseiJoho;
    }

    /*
     * gethiddenShikibetsuCode
     * @return hiddenShikibetsuCode
     */
    @JsonProperty("hiddenShikibetsuCode")
    public RString getHiddenShikibetsuCode() {
        return hiddenShikibetsuCode;
    }

    /*
     * sethiddenShikibetsuCode
     * @param hiddenShikibetsuCode hiddenShikibetsuCode
     */
    @JsonProperty("hiddenShikibetsuCode")
    public void setHiddenShikibetsuCode(RString hiddenShikibetsuCode) {
        this.hiddenShikibetsuCode = hiddenShikibetsuCode;
    }

    /*
     * gethdnJushoShuruiKubun1
     * @return hdnJushoShuruiKubun1
     */
    @JsonProperty("hdnJushoShuruiKubun1")
    @Override
    public RString getHdnJushoShuruiKubun1() {
        return hdnJushoShuruiKubun1;
    }

    /*
     * sethdnJushoShuruiKubun1
     * @param hdnJushoShuruiKubun1 hdnJushoShuruiKubun1
     */
    @JsonProperty("hdnJushoShuruiKubun1")
    public void setHdnJushoShuruiKubun1(RString hdnJushoShuruiKubun1) {
        this.hdnJushoShuruiKubun1 = hdnJushoShuruiKubun1;
    }

    /*
     * gethdnJushoShuruiKubun2
     * @return hdnJushoShuruiKubun2
     */
    @JsonProperty("hdnJushoShuruiKubun2")
    @Override
    public RString getHdnJushoShuruiKubun2() {
        return hdnJushoShuruiKubun2;
    }

    /*
     * sethdnJushoShuruiKubun2
     * @param hdnJushoShuruiKubun2 hdnJushoShuruiKubun2
     */
    @JsonProperty("hdnJushoShuruiKubun2")
    public void setHdnJushoShuruiKubun2(RString hdnJushoShuruiKubun2) {
        this.hdnJushoShuruiKubun2 = hdnJushoShuruiKubun2;
    }

    /*
     * gethdnJushoShuruiKubun3
     * @return hdnJushoShuruiKubun3
     */
    @JsonProperty("hdnJushoShuruiKubun3")
    @Override
    public RString getHdnJushoShuruiKubun3() {
        return hdnJushoShuruiKubun3;
    }

    /*
     * sethdnJushoShuruiKubun3
     * @param hdnJushoShuruiKubun3 hdnJushoShuruiKubun3
     */
    @JsonProperty("hdnJushoShuruiKubun3")
    public void setHdnJushoShuruiKubun3(RString hdnJushoShuruiKubun3) {
        this.hdnJushoShuruiKubun3 = hdnJushoShuruiKubun3;
    }

    /*
     * gethdnJushoShuruiKubun4
     * @return hdnJushoShuruiKubun4
     */
    @JsonProperty("hdnJushoShuruiKubun4")
    @Override
    public RString getHdnJushoShuruiKubun4() {
        return hdnJushoShuruiKubun4;
    }

    /*
     * sethdnJushoShuruiKubun4
     * @param hdnJushoShuruiKubun4 hdnJushoShuruiKubun4
     */
    @JsonProperty("hdnJushoShuruiKubun4")
    public void setHdnJushoShuruiKubun4(RString hdnJushoShuruiKubun4) {
        this.hdnJushoShuruiKubun4 = hdnJushoShuruiKubun4;
    }

    /*
     * gethdnJushoShuruiKubun5
     * @return hdnJushoShuruiKubun5
     */
    @JsonProperty("hdnJushoShuruiKubun5")
    @Override
    public RString getHdnJushoShuruiKubun5() {
        return hdnJushoShuruiKubun5;
    }

    /*
     * sethdnJushoShuruiKubun5
     * @param hdnJushoShuruiKubun5 hdnJushoShuruiKubun5
     */
    @JsonProperty("hdnJushoShuruiKubun5")
    public void setHdnJushoShuruiKubun5(RString hdnJushoShuruiKubun5) {
        this.hdnJushoShuruiKubun5 = hdnJushoShuruiKubun5;
    }

    /*
     * gethdnZaigaiSenkyoninShinsei
     * @return hdnZaigaiSenkyoninShinsei
     */
    @JsonProperty("hdnZaigaiSenkyoninShinsei")
    @Override
    public RString getHdnZaigaiSenkyoninShinsei() {
        return hdnZaigaiSenkyoninShinsei;
    }

    /*
     * sethdnZaigaiSenkyoninShinsei
     * @param hdnZaigaiSenkyoninShinsei hdnZaigaiSenkyoninShinsei
     */
    @JsonProperty("hdnZaigaiSenkyoninShinsei")
    public void setHdnZaigaiSenkyoninShinsei(RString hdnZaigaiSenkyoninShinsei) {
        this.hdnZaigaiSenkyoninShinsei = hdnZaigaiSenkyoninShinsei;
    }

    /*
     * gethdnZaigaiSenkyoShikaku
     * @return hdnZaigaiSenkyoShikaku
     */
    @JsonProperty("hdnZaigaiSenkyoShikaku")
    @Override
    public RString getHdnZaigaiSenkyoShikaku() {
        return hdnZaigaiSenkyoShikaku;
    }

    /*
     * sethdnZaigaiSenkyoShikaku
     * @param hdnZaigaiSenkyoShikaku hdnZaigaiSenkyoShikaku
     */
    @JsonProperty("hdnZaigaiSenkyoShikaku")
    public void setHdnZaigaiSenkyoShikaku(RString hdnZaigaiSenkyoShikaku) {
        this.hdnZaigaiSenkyoShikaku = hdnZaigaiSenkyoShikaku;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ShikibetsuCode 識別コード, RString 申請番号) {
        getHandler().initialize(識別コード, 申請番号);
    }

    /**
     * この共有子Divの申請情報初期再表示を行います。
     *
     * @param 識別コード Code
     * @param 申請番号 RString
     */
    @Override
    public void 申請情報再表示(ShikibetsuCode 識別コード, RString 申請番号) {
        getHandler().initializeSenkyojyohou(識別コード, 申請番号);
    }

    private ZaigaiSenkyoninJohoHandler getHandler() {
        return new ZaigaiSenkyoninJohoHandler(this);
    }
}
