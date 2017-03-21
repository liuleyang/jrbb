package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 *
 */
public class KokuminSakuseiChohyoDiv extends Panel implements IKokuminSakuseiChohyoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuminSakuseiChohyoMeiboShohon")
    private KokuminSakuseiChohyoMeiboShohonDiv KokuminSakuseiChohyoMeiboShohon;
    @JsonProperty("KokuminSakuseiChohyoTorokushasuList")
    private KokuminSakuseiChohyoTorokushasuListDiv KokuminSakuseiChohyoTorokushasuList;
    @JsonProperty("KokuminSakuseiChohyo1goShikakuTsuchi")
    private KokuminSakuseiChohyo1goShikakuTsuchiDiv KokuminSakuseiChohyo1goShikakuTsuchi;
    @JsonProperty("KokuminSakuseiChohyo2goShikakuChosahyo")
    private KokuminSakuseiChohyo2goShikakuChosahyoDiv KokuminSakuseiChohyo2goShikakuChosahyo;
    @JsonProperty("KokuminSakuseiChohyo2goKohoList")
    private KokuminSakuseiChohyo2goKohoListDiv KokuminSakuseiChohyo2goKohoList;
    @JsonProperty("KokuminSakuseiChohyoIdoTorokushaMeibo")
    private KokuminSakuseiChohyoIdoTorokushaMeiboDiv KokuminSakuseiChohyoIdoTorokushaMeibo;
    @JsonProperty("KokuminSakuseiChohyoIdoMasshoshaMeibo")
    private KokuminSakuseiChohyoIdoMasshoshaMeiboDiv KokuminSakuseiChohyoIdoMasshoshaMeibo;
    @JsonProperty("KokuminSakuseiChohyoIdoTeiseishaMeibo")
    private KokuminSakuseiChohyoIdoTeiseishaMeiboDiv KokuminSakuseiChohyoIdoTeiseishaMeibo;
    @JsonProperty("KokuminSakuseiChohyoMasshoTsuchi")
    private KokuminSakuseiChohyoMasshoTsuchiDiv KokuminSakuseiChohyoMasshoTsuchi;
    @JsonProperty("KokuminSakuseiChohyoKokunaiChosahyo")
    private KokuminSakuseiChohyoKokunaiChosahyoDiv KokuminSakuseiChohyoKokunaiChosahyo;
    @JsonProperty("KokuminSakuseiChohyoKokugaiChosahyo")
    private KokuminSakuseiChohyoKokugaiChosahyoDiv KokuminSakuseiChohyoKokugaiChosahyo;
    @JsonProperty("KokuminSakuseiChohyoZaigai")
    private KokuminSakuseiChohyoZaigaiDiv KokuminSakuseiChohyoZaigai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuminSakuseiChohyoMeiboShohon
     * @return KokuminSakuseiChohyoMeiboShohon
     */
    @JsonProperty("KokuminSakuseiChohyoMeiboShohon")
    public KokuminSakuseiChohyoMeiboShohonDiv getKokuminSakuseiChohyoMeiboShohon() {
        return KokuminSakuseiChohyoMeiboShohon;
    }

    /*
     * setKokuminSakuseiChohyoMeiboShohon
     * @param KokuminSakuseiChohyoMeiboShohon KokuminSakuseiChohyoMeiboShohon
     */
    @JsonProperty("KokuminSakuseiChohyoMeiboShohon")
    public void setKokuminSakuseiChohyoMeiboShohon(KokuminSakuseiChohyoMeiboShohonDiv KokuminSakuseiChohyoMeiboShohon) {
        this.KokuminSakuseiChohyoMeiboShohon = KokuminSakuseiChohyoMeiboShohon;
    }

    /*
     * getKokuminSakuseiChohyoTorokushasuList
     * @return KokuminSakuseiChohyoTorokushasuList
     */
    @JsonProperty("KokuminSakuseiChohyoTorokushasuList")
    public KokuminSakuseiChohyoTorokushasuListDiv getKokuminSakuseiChohyoTorokushasuList() {
        return KokuminSakuseiChohyoTorokushasuList;
    }

    /*
     * setKokuminSakuseiChohyoTorokushasuList
     * @param KokuminSakuseiChohyoTorokushasuList KokuminSakuseiChohyoTorokushasuList
     */
    @JsonProperty("KokuminSakuseiChohyoTorokushasuList")
    public void setKokuminSakuseiChohyoTorokushasuList(KokuminSakuseiChohyoTorokushasuListDiv KokuminSakuseiChohyoTorokushasuList) {
        this.KokuminSakuseiChohyoTorokushasuList = KokuminSakuseiChohyoTorokushasuList;
    }

    /*
     * getKokuminSakuseiChohyo1goShikakuTsuchi
     * @return KokuminSakuseiChohyo1goShikakuTsuchi
     */
    @JsonProperty("KokuminSakuseiChohyo1goShikakuTsuchi")
    public KokuminSakuseiChohyo1goShikakuTsuchiDiv getKokuminSakuseiChohyo1goShikakuTsuchi() {
        return KokuminSakuseiChohyo1goShikakuTsuchi;
    }

    /*
     * setKokuminSakuseiChohyo1goShikakuTsuchi
     * @param KokuminSakuseiChohyo1goShikakuTsuchi KokuminSakuseiChohyo1goShikakuTsuchi
     */
    @JsonProperty("KokuminSakuseiChohyo1goShikakuTsuchi")
    public void setKokuminSakuseiChohyo1goShikakuTsuchi(KokuminSakuseiChohyo1goShikakuTsuchiDiv KokuminSakuseiChohyo1goShikakuTsuchi) {
        this.KokuminSakuseiChohyo1goShikakuTsuchi = KokuminSakuseiChohyo1goShikakuTsuchi;
    }

    /*
     * getKokuminSakuseiChohyo2goShikakuChosahyo
     * @return KokuminSakuseiChohyo2goShikakuChosahyo
     */
    @JsonProperty("KokuminSakuseiChohyo2goShikakuChosahyo")
    public KokuminSakuseiChohyo2goShikakuChosahyoDiv getKokuminSakuseiChohyo2goShikakuChosahyo() {
        return KokuminSakuseiChohyo2goShikakuChosahyo;
    }

    /*
     * setKokuminSakuseiChohyo2goShikakuChosahyo
     * @param KokuminSakuseiChohyo2goShikakuChosahyo KokuminSakuseiChohyo2goShikakuChosahyo
     */
    @JsonProperty("KokuminSakuseiChohyo2goShikakuChosahyo")
    public void setKokuminSakuseiChohyo2goShikakuChosahyo(KokuminSakuseiChohyo2goShikakuChosahyoDiv KokuminSakuseiChohyo2goShikakuChosahyo) {
        this.KokuminSakuseiChohyo2goShikakuChosahyo = KokuminSakuseiChohyo2goShikakuChosahyo;
    }

    /*
     * getKokuminSakuseiChohyo2goKohoList
     * @return KokuminSakuseiChohyo2goKohoList
     */
    @JsonProperty("KokuminSakuseiChohyo2goKohoList")
    public KokuminSakuseiChohyo2goKohoListDiv getKokuminSakuseiChohyo2goKohoList() {
        return KokuminSakuseiChohyo2goKohoList;
    }

    /*
     * setKokuminSakuseiChohyo2goKohoList
     * @param KokuminSakuseiChohyo2goKohoList KokuminSakuseiChohyo2goKohoList
     */
    @JsonProperty("KokuminSakuseiChohyo2goKohoList")
    public void setKokuminSakuseiChohyo2goKohoList(KokuminSakuseiChohyo2goKohoListDiv KokuminSakuseiChohyo2goKohoList) {
        this.KokuminSakuseiChohyo2goKohoList = KokuminSakuseiChohyo2goKohoList;
    }

    /*
     * getKokuminSakuseiChohyoIdoTorokushaMeibo
     * @return KokuminSakuseiChohyoIdoTorokushaMeibo
     */
    @JsonProperty("KokuminSakuseiChohyoIdoTorokushaMeibo")
    public KokuminSakuseiChohyoIdoTorokushaMeiboDiv getKokuminSakuseiChohyoIdoTorokushaMeibo() {
        return KokuminSakuseiChohyoIdoTorokushaMeibo;
    }

    /*
     * setKokuminSakuseiChohyoIdoTorokushaMeibo
     * @param KokuminSakuseiChohyoIdoTorokushaMeibo KokuminSakuseiChohyoIdoTorokushaMeibo
     */
    @JsonProperty("KokuminSakuseiChohyoIdoTorokushaMeibo")
    public void setKokuminSakuseiChohyoIdoTorokushaMeibo(KokuminSakuseiChohyoIdoTorokushaMeiboDiv KokuminSakuseiChohyoIdoTorokushaMeibo) {
        this.KokuminSakuseiChohyoIdoTorokushaMeibo = KokuminSakuseiChohyoIdoTorokushaMeibo;
    }

    /*
     * getKokuminSakuseiChohyoIdoMasshoshaMeibo
     * @return KokuminSakuseiChohyoIdoMasshoshaMeibo
     */
    @JsonProperty("KokuminSakuseiChohyoIdoMasshoshaMeibo")
    public KokuminSakuseiChohyoIdoMasshoshaMeiboDiv getKokuminSakuseiChohyoIdoMasshoshaMeibo() {
        return KokuminSakuseiChohyoIdoMasshoshaMeibo;
    }

    /*
     * setKokuminSakuseiChohyoIdoMasshoshaMeibo
     * @param KokuminSakuseiChohyoIdoMasshoshaMeibo KokuminSakuseiChohyoIdoMasshoshaMeibo
     */
    @JsonProperty("KokuminSakuseiChohyoIdoMasshoshaMeibo")
    public void setKokuminSakuseiChohyoIdoMasshoshaMeibo(KokuminSakuseiChohyoIdoMasshoshaMeiboDiv KokuminSakuseiChohyoIdoMasshoshaMeibo) {
        this.KokuminSakuseiChohyoIdoMasshoshaMeibo = KokuminSakuseiChohyoIdoMasshoshaMeibo;
    }

    /*
     * getKokuminSakuseiChohyoIdoTeiseishaMeibo
     * @return KokuminSakuseiChohyoIdoTeiseishaMeibo
     */
    @JsonProperty("KokuminSakuseiChohyoIdoTeiseishaMeibo")
    public KokuminSakuseiChohyoIdoTeiseishaMeiboDiv getKokuminSakuseiChohyoIdoTeiseishaMeibo() {
        return KokuminSakuseiChohyoIdoTeiseishaMeibo;
    }

    /*
     * setKokuminSakuseiChohyoIdoTeiseishaMeibo
     * @param KokuminSakuseiChohyoIdoTeiseishaMeibo KokuminSakuseiChohyoIdoTeiseishaMeibo
     */
    @JsonProperty("KokuminSakuseiChohyoIdoTeiseishaMeibo")
    public void setKokuminSakuseiChohyoIdoTeiseishaMeibo(KokuminSakuseiChohyoIdoTeiseishaMeiboDiv KokuminSakuseiChohyoIdoTeiseishaMeibo) {
        this.KokuminSakuseiChohyoIdoTeiseishaMeibo = KokuminSakuseiChohyoIdoTeiseishaMeibo;
    }

    /*
     * getKokuminSakuseiChohyoMasshoTsuchi
     * @return KokuminSakuseiChohyoMasshoTsuchi
     */
    @JsonProperty("KokuminSakuseiChohyoMasshoTsuchi")
    public KokuminSakuseiChohyoMasshoTsuchiDiv getKokuminSakuseiChohyoMasshoTsuchi() {
        return KokuminSakuseiChohyoMasshoTsuchi;
    }

    /*
     * setKokuminSakuseiChohyoMasshoTsuchi
     * @param KokuminSakuseiChohyoMasshoTsuchi KokuminSakuseiChohyoMasshoTsuchi
     */
    @JsonProperty("KokuminSakuseiChohyoMasshoTsuchi")
    public void setKokuminSakuseiChohyoMasshoTsuchi(KokuminSakuseiChohyoMasshoTsuchiDiv KokuminSakuseiChohyoMasshoTsuchi) {
        this.KokuminSakuseiChohyoMasshoTsuchi = KokuminSakuseiChohyoMasshoTsuchi;
    }

    /*
     * getKokuminSakuseiChohyoKokunaiChosahyo
     * @return KokuminSakuseiChohyoKokunaiChosahyo
     */
    @JsonProperty("KokuminSakuseiChohyoKokunaiChosahyo")
    public KokuminSakuseiChohyoKokunaiChosahyoDiv getKokuminSakuseiChohyoKokunaiChosahyo() {
        return KokuminSakuseiChohyoKokunaiChosahyo;
    }

    /*
     * setKokuminSakuseiChohyoKokunaiChosahyo
     * @param KokuminSakuseiChohyoKokunaiChosahyo KokuminSakuseiChohyoKokunaiChosahyo
     */
    @JsonProperty("KokuminSakuseiChohyoKokunaiChosahyo")
    public void setKokuminSakuseiChohyoKokunaiChosahyo(KokuminSakuseiChohyoKokunaiChosahyoDiv KokuminSakuseiChohyoKokunaiChosahyo) {
        this.KokuminSakuseiChohyoKokunaiChosahyo = KokuminSakuseiChohyoKokunaiChosahyo;
    }

    /*
     * getKokuminSakuseiChohyoKokugaiChosahyo
     * @return KokuminSakuseiChohyoKokugaiChosahyo
     */
    @JsonProperty("KokuminSakuseiChohyoKokugaiChosahyo")
    public KokuminSakuseiChohyoKokugaiChosahyoDiv getKokuminSakuseiChohyoKokugaiChosahyo() {
        return KokuminSakuseiChohyoKokugaiChosahyo;
    }

    /*
     * setKokuminSakuseiChohyoKokugaiChosahyo
     * @param KokuminSakuseiChohyoKokugaiChosahyo KokuminSakuseiChohyoKokugaiChosahyo
     */
    @JsonProperty("KokuminSakuseiChohyoKokugaiChosahyo")
    public void setKokuminSakuseiChohyoKokugaiChosahyo(KokuminSakuseiChohyoKokugaiChosahyoDiv KokuminSakuseiChohyoKokugaiChosahyo) {
        this.KokuminSakuseiChohyoKokugaiChosahyo = KokuminSakuseiChohyoKokugaiChosahyo;
    }

    /*
     * getKokuminSakuseiChohyoZaigai
     * @return KokuminSakuseiChohyoZaigai
     */
    @JsonProperty("KokuminSakuseiChohyoZaigai")
    public KokuminSakuseiChohyoZaigaiDiv getKokuminSakuseiChohyoZaigai() {
        return KokuminSakuseiChohyoZaigai;
    }

    /*
     * setKokuminSakuseiChohyoZaigai
     * @param KokuminSakuseiChohyoZaigai KokuminSakuseiChohyoZaigai
     */
    @JsonProperty("KokuminSakuseiChohyoZaigai")
    public void setKokuminSakuseiChohyoZaigai(KokuminSakuseiChohyoZaigaiDiv KokuminSakuseiChohyoZaigai) {
        this.KokuminSakuseiChohyoZaigai = KokuminSakuseiChohyoZaigai;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void initialize(RString shohonNo) {
        getHandler().initialize(shohonNo);
    }

    @Override
    public void initialize(RDate tokuteiKigenYmd, RDate kijunKigenYmd, RDate shoriYmd) {
        getHandler().initialize(tokuteiKigenYmd, kijunKigenYmd, shoriYmd);
    }

    @Override
    public void clearData() {
        getHandler().clearData();
    }

    @JsonIgnore
    public KokuminSakuseiChohyoHandler getHandler() {
        return new KokuminSakuseiChohyoHandler(this);
    }

    @Override
    public ValidationMessageControlPairs validate時点日() {
        return new KokuminSakuseiChohyoValidationHandler(this).validate();
    }

    @Override
    public TextBoxDate get時点日() {
        return getHandler().get時点日();
    }

    @Override
    public KokuminSakuseiChohyoMeiboShohonDiv get投票人名簿抄本() {
        return getHandler().get投票人名簿抄本();
    }

    @Override
    public KokuminSakuseiChohyoTorokushasuListDiv get投票人名簿登録者数リスト() {
        return getHandler().get投票人名簿登録者数リスト();
    }

    @Override
    public KokuminSakuseiChohyo1goShikakuTsuchiDiv get1号資格登録通知() {
        return getHandler().get1号資格登録通知();
    }

    @Override
    public KokuminSakuseiChohyo2goShikakuChosahyoDiv get2号資格調査票() {
        return getHandler().get2号資格調査票();
    }

    @Override
    public KokuminSakuseiChohyo2goKohoListDiv get2号資格候補者一覧表() {
        return getHandler().get2号資格候補者一覧表();
    }

    @Override
    public KokuminSakuseiChohyoIdoTorokushaMeiboDiv get補正登録者名簿() {
        return getHandler().get補正登録者名簿();
    }

    @Override
    public KokuminSakuseiChohyoIdoMasshoshaMeiboDiv get抹消者名簿() {
        return getHandler().get抹消者名簿();
    }

    @Override
    public KokuminSakuseiChohyoIdoTeiseishaMeiboDiv get訂正者名簿() {
        return getHandler().get訂正者名簿();
    }

    @Override
    public KokuminSakuseiChohyoMasshoTsuchiDiv get未登録者抹消通知() {
        return getHandler().get未登録者抹消通知();
    }

    @Override
    public KokuminSakuseiChohyoKokunaiChosahyoDiv get国内転入者調査票() {
        return getHandler().get国内転入者調査票();
    }

    @Override
    public KokuminSakuseiChohyoKokugaiChosahyoDiv get国外転入者調査票() {
        return getHandler().get国外転入者調査票();
    }

    @Override
    public KokuminSakuseiChohyoZaigaiDiv get在外投票関連() {
        return getHandler().get在外投票関連();
    }
}
