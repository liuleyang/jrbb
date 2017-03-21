package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class SakuseiChohyoDiv extends Panel implements ISakuseiChohyoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SakuseiChohyoSenkyoninMeiboShohon")
    private SakuseiChohyoSenkyoninMeiboShohonDiv SakuseiChohyoSenkyoninMeiboShohon;
    @JsonProperty("SakuseiChohyoEikyuSenkyoninMeibo")
    private SakuseiChohyoEikyuSenkyoninMeiboDiv SakuseiChohyoEikyuSenkyoninMeibo;
    @JsonProperty("SakuseiChohyoSenkyoninMeiboSakuinbo")
    private SakuseiChohyoSenkyoninMeiboSakuinboDiv SakuseiChohyoSenkyoninMeiboSakuinbo;
    @JsonProperty("SakuseiChohyoTorokushasuList")
    private SakuseiChohyoTorokushasuListDiv SakuseiChohyoTorokushasuList;
    @JsonProperty("SakuseiChohyoYukenshasuList")
    private SakuseiChohyoYukenshasuListDiv SakuseiChohyoYukenshasuList;
    @JsonProperty("SakuseiChohyoNijuTorokuTsuchi")
    private SakuseiChohyoNijuTorokuTsuchiDiv SakuseiChohyoNijuTorokuTsuchi;
    @JsonProperty("SakuseiChohyoNijuChosahyo")
    private SakuseiChohyoNijuChosahyoDiv SakuseiChohyoNijuChosahyo;
    @JsonProperty("SakuseiChohyoIdoTorokushaMeibo")
    private SakuseiChohyoIdoTorokushaMeiboDiv SakuseiChohyoIdoTorokushaMeibo;
    @JsonProperty("SakuseiChohyoIdoKikaMeibo")
    private SakuseiChohyoIdoKikaMeiboDiv SakuseiChohyoIdoKikaMeibo;
    @JsonProperty("SakuseiChohyoIdoMasshoshaMeibo")
    private SakuseiChohyoIdoMasshoshaMeiboDiv SakuseiChohyoIdoMasshoshaMeibo;
    @JsonProperty("SakuseiChohyoIdoGakuseiMasshoshaMeibo")
    private SakuseiChohyoIdoGakuseiMasshoshaMeiboDiv SakuseiChohyoIdoGakuseiMasshoshaMeibo;
    @JsonProperty("SakuseiChohyoIdoMasshoYoteishaMeibo")
    private SakuseiChohyoIdoMasshoYoteishaMeiboDiv SakuseiChohyoIdoMasshoYoteishaMeibo;
    @JsonProperty("SakuseiChohyoIdoShikkenshaMeibo")
    private SakuseiChohyoIdoShikkenshaMeiboDiv SakuseiChohyoIdoShikkenshaMeibo;
    @JsonProperty("SakuseiChohyoIdoHyojishaMeibo")
    private SakuseiChohyoIdoHyojishaMeiboDiv SakuseiChohyoIdoHyojishaMeibo;
    @JsonProperty("SakuseiChohyoIdoHyojiShojoshaMeibo")
    private SakuseiChohyoIdoHyojiShojoshaMeiboDiv SakuseiChohyoIdoHyojiShojoshaMeibo;
    @JsonProperty("SakuseiChohyoIdoHyojiShojoYoteishaMeibo")
    private SakuseiChohyoIdoHyojiShojoYoteishaMeiboDiv SakuseiChohyoIdoHyojiShojoYoteishaMeibo;
    @JsonProperty("SakuseiChohyoIdo19saishaMeibo")
    private SakuseiChohyoIdo19saishaMeiboDiv SakuseiChohyoIdo19saishaMeibo;
    @JsonProperty("SakuseiChohyoIdoMiseinenshaMeibo")
    private SakuseiChohyoIdoMiseinenshaMeiboDiv SakuseiChohyoIdoMiseinenshaMeibo;
    @JsonProperty("SakuseiChohyoIdoSaiTennyushaMeibo")
    private SakuseiChohyoIdoSaiTennyushaMeiboDiv SakuseiChohyoIdoSaiTennyushaMeibo;
    @JsonProperty("SakuseiChohyoIdoTeiseishaMeibo")
    private SakuseiChohyoIdoTeiseishaMeiboDiv SakuseiChohyoIdoTeiseishaMeibo;
    @JsonProperty("SakuseiChohyoIdoTenshutsushaMeibo")
    private SakuseiChohyoIdoTenshutsushaMeiboDiv SakuseiChohyoIdoTenshutsushaMeibo;
    @JsonProperty("SakuseiChohyoIdoTeishishaMeibo")
    private SakuseiChohyoIdoTeishishaMeiboDiv SakuseiChohyoIdoTeishishaMeibo;
    @JsonProperty("SakuseiChohyoZaigai")
    private SakuseiChohyoZaigaiDiv SakuseiChohyoZaigai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSakuseiChohyoSenkyoninMeiboShohon
     * @return SakuseiChohyoSenkyoninMeiboShohon
     */
    @JsonProperty("SakuseiChohyoSenkyoninMeiboShohon")
    public SakuseiChohyoSenkyoninMeiboShohonDiv getSakuseiChohyoSenkyoninMeiboShohon() {
        return SakuseiChohyoSenkyoninMeiboShohon;
    }

    /*
     * setSakuseiChohyoSenkyoninMeiboShohon
     * @param SakuseiChohyoSenkyoninMeiboShohon SakuseiChohyoSenkyoninMeiboShohon
     */
    @JsonProperty("SakuseiChohyoSenkyoninMeiboShohon")
    public void setSakuseiChohyoSenkyoninMeiboShohon(SakuseiChohyoSenkyoninMeiboShohonDiv SakuseiChohyoSenkyoninMeiboShohon) {
        this.SakuseiChohyoSenkyoninMeiboShohon = SakuseiChohyoSenkyoninMeiboShohon;
    }

    /*
     * getSakuseiChohyoEikyuSenkyoninMeibo
     * @return SakuseiChohyoEikyuSenkyoninMeibo
     */
    @JsonProperty("SakuseiChohyoEikyuSenkyoninMeibo")
    public SakuseiChohyoEikyuSenkyoninMeiboDiv getSakuseiChohyoEikyuSenkyoninMeibo() {
        return SakuseiChohyoEikyuSenkyoninMeibo;
    }

    /*
     * setSakuseiChohyoEikyuSenkyoninMeibo
     * @param SakuseiChohyoEikyuSenkyoninMeibo SakuseiChohyoEikyuSenkyoninMeibo
     */
    @JsonProperty("SakuseiChohyoEikyuSenkyoninMeibo")
    public void setSakuseiChohyoEikyuSenkyoninMeibo(SakuseiChohyoEikyuSenkyoninMeiboDiv SakuseiChohyoEikyuSenkyoninMeibo) {
        this.SakuseiChohyoEikyuSenkyoninMeibo = SakuseiChohyoEikyuSenkyoninMeibo;
    }

    /*
     * getSakuseiChohyoSenkyoninMeiboSakuinbo
     * @return SakuseiChohyoSenkyoninMeiboSakuinbo
     */
    @JsonProperty("SakuseiChohyoSenkyoninMeiboSakuinbo")
    public SakuseiChohyoSenkyoninMeiboSakuinboDiv getSakuseiChohyoSenkyoninMeiboSakuinbo() {
        return SakuseiChohyoSenkyoninMeiboSakuinbo;
    }

    /*
     * setSakuseiChohyoSenkyoninMeiboSakuinbo
     * @param SakuseiChohyoSenkyoninMeiboSakuinbo SakuseiChohyoSenkyoninMeiboSakuinbo
     */
    @JsonProperty("SakuseiChohyoSenkyoninMeiboSakuinbo")
    public void setSakuseiChohyoSenkyoninMeiboSakuinbo(SakuseiChohyoSenkyoninMeiboSakuinboDiv SakuseiChohyoSenkyoninMeiboSakuinbo) {
        this.SakuseiChohyoSenkyoninMeiboSakuinbo = SakuseiChohyoSenkyoninMeiboSakuinbo;
    }

    /*
     * getSakuseiChohyoTorokushasuList
     * @return SakuseiChohyoTorokushasuList
     */
    @JsonProperty("SakuseiChohyoTorokushasuList")
    public SakuseiChohyoTorokushasuListDiv getSakuseiChohyoTorokushasuList() {
        return SakuseiChohyoTorokushasuList;
    }

    /*
     * setSakuseiChohyoTorokushasuList
     * @param SakuseiChohyoTorokushasuList SakuseiChohyoTorokushasuList
     */
    @JsonProperty("SakuseiChohyoTorokushasuList")
    public void setSakuseiChohyoTorokushasuList(SakuseiChohyoTorokushasuListDiv SakuseiChohyoTorokushasuList) {
        this.SakuseiChohyoTorokushasuList = SakuseiChohyoTorokushasuList;
    }

    /*
     * getSakuseiChohyoYukenshasuList
     * @return SakuseiChohyoYukenshasuList
     */
    @JsonProperty("SakuseiChohyoYukenshasuList")
    public SakuseiChohyoYukenshasuListDiv getSakuseiChohyoYukenshasuList() {
        return SakuseiChohyoYukenshasuList;
    }

    /*
     * setSakuseiChohyoYukenshasuList
     * @param SakuseiChohyoYukenshasuList SakuseiChohyoYukenshasuList
     */
    @JsonProperty("SakuseiChohyoYukenshasuList")
    public void setSakuseiChohyoYukenshasuList(SakuseiChohyoYukenshasuListDiv SakuseiChohyoYukenshasuList) {
        this.SakuseiChohyoYukenshasuList = SakuseiChohyoYukenshasuList;
    }

    /*
     * getSakuseiChohyoNijuTorokuTsuchi
     * @return SakuseiChohyoNijuTorokuTsuchi
     */
    @JsonProperty("SakuseiChohyoNijuTorokuTsuchi")
    public SakuseiChohyoNijuTorokuTsuchiDiv getSakuseiChohyoNijuTorokuTsuchi() {
        return SakuseiChohyoNijuTorokuTsuchi;
    }

    /*
     * setSakuseiChohyoNijuTorokuTsuchi
     * @param SakuseiChohyoNijuTorokuTsuchi SakuseiChohyoNijuTorokuTsuchi
     */
    @JsonProperty("SakuseiChohyoNijuTorokuTsuchi")
    public void setSakuseiChohyoNijuTorokuTsuchi(SakuseiChohyoNijuTorokuTsuchiDiv SakuseiChohyoNijuTorokuTsuchi) {
        this.SakuseiChohyoNijuTorokuTsuchi = SakuseiChohyoNijuTorokuTsuchi;
    }

    /*
     * getSakuseiChohyoNijuChosahyo
     * @return SakuseiChohyoNijuChosahyo
     */
    @JsonProperty("SakuseiChohyoNijuChosahyo")
    public SakuseiChohyoNijuChosahyoDiv getSakuseiChohyoNijuChosahyo() {
        return SakuseiChohyoNijuChosahyo;
    }

    /*
     * setSakuseiChohyoNijuChosahyo
     * @param SakuseiChohyoNijuChosahyo SakuseiChohyoNijuChosahyo
     */
    @JsonProperty("SakuseiChohyoNijuChosahyo")
    public void setSakuseiChohyoNijuChosahyo(SakuseiChohyoNijuChosahyoDiv SakuseiChohyoNijuChosahyo) {
        this.SakuseiChohyoNijuChosahyo = SakuseiChohyoNijuChosahyo;
    }

    /*
     * getSakuseiChohyoIdoTorokushaMeibo
     * @return SakuseiChohyoIdoTorokushaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoTorokushaMeibo")
    public SakuseiChohyoIdoTorokushaMeiboDiv getSakuseiChohyoIdoTorokushaMeibo() {
        return SakuseiChohyoIdoTorokushaMeibo;
    }

    /*
     * setSakuseiChohyoIdoTorokushaMeibo
     * @param SakuseiChohyoIdoTorokushaMeibo SakuseiChohyoIdoTorokushaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoTorokushaMeibo")
    public void setSakuseiChohyoIdoTorokushaMeibo(SakuseiChohyoIdoTorokushaMeiboDiv SakuseiChohyoIdoTorokushaMeibo) {
        this.SakuseiChohyoIdoTorokushaMeibo = SakuseiChohyoIdoTorokushaMeibo;
    }

    /*
     * getSakuseiChohyoIdoKikaMeibo
     * @return SakuseiChohyoIdoKikaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoKikaMeibo")
    public SakuseiChohyoIdoKikaMeiboDiv getSakuseiChohyoIdoKikaMeibo() {
        return SakuseiChohyoIdoKikaMeibo;
    }

    /*
     * setSakuseiChohyoIdoKikaMeibo
     * @param SakuseiChohyoIdoKikaMeibo SakuseiChohyoIdoKikaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoKikaMeibo")
    public void setSakuseiChohyoIdoKikaMeibo(SakuseiChohyoIdoKikaMeiboDiv SakuseiChohyoIdoKikaMeibo) {
        this.SakuseiChohyoIdoKikaMeibo = SakuseiChohyoIdoKikaMeibo;
    }

    /*
     * getSakuseiChohyoIdoMasshoshaMeibo
     * @return SakuseiChohyoIdoMasshoshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoMasshoshaMeibo")
    public SakuseiChohyoIdoMasshoshaMeiboDiv getSakuseiChohyoIdoMasshoshaMeibo() {
        return SakuseiChohyoIdoMasshoshaMeibo;
    }

    /*
     * setSakuseiChohyoIdoMasshoshaMeibo
     * @param SakuseiChohyoIdoMasshoshaMeibo SakuseiChohyoIdoMasshoshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoMasshoshaMeibo")
    public void setSakuseiChohyoIdoMasshoshaMeibo(SakuseiChohyoIdoMasshoshaMeiboDiv SakuseiChohyoIdoMasshoshaMeibo) {
        this.SakuseiChohyoIdoMasshoshaMeibo = SakuseiChohyoIdoMasshoshaMeibo;
    }

    /*
     * getSakuseiChohyoIdoGakuseiMasshoshaMeibo
     * @return SakuseiChohyoIdoGakuseiMasshoshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoGakuseiMasshoshaMeibo")
    public SakuseiChohyoIdoGakuseiMasshoshaMeiboDiv getSakuseiChohyoIdoGakuseiMasshoshaMeibo() {
        return SakuseiChohyoIdoGakuseiMasshoshaMeibo;
    }

    /*
     * setSakuseiChohyoIdoGakuseiMasshoshaMeibo
     * @param SakuseiChohyoIdoGakuseiMasshoshaMeibo SakuseiChohyoIdoGakuseiMasshoshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoGakuseiMasshoshaMeibo")
    public void setSakuseiChohyoIdoGakuseiMasshoshaMeibo(SakuseiChohyoIdoGakuseiMasshoshaMeiboDiv SakuseiChohyoIdoGakuseiMasshoshaMeibo) {
        this.SakuseiChohyoIdoGakuseiMasshoshaMeibo = SakuseiChohyoIdoGakuseiMasshoshaMeibo;
    }

    /*
     * getSakuseiChohyoIdoMasshoYoteishaMeibo
     * @return SakuseiChohyoIdoMasshoYoteishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoMasshoYoteishaMeibo")
    public SakuseiChohyoIdoMasshoYoteishaMeiboDiv getSakuseiChohyoIdoMasshoYoteishaMeibo() {
        return SakuseiChohyoIdoMasshoYoteishaMeibo;
    }

    /*
     * setSakuseiChohyoIdoMasshoYoteishaMeibo
     * @param SakuseiChohyoIdoMasshoYoteishaMeibo SakuseiChohyoIdoMasshoYoteishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoMasshoYoteishaMeibo")
    public void setSakuseiChohyoIdoMasshoYoteishaMeibo(SakuseiChohyoIdoMasshoYoteishaMeiboDiv SakuseiChohyoIdoMasshoYoteishaMeibo) {
        this.SakuseiChohyoIdoMasshoYoteishaMeibo = SakuseiChohyoIdoMasshoYoteishaMeibo;
    }

    /*
     * getSakuseiChohyoIdoShikkenshaMeibo
     * @return SakuseiChohyoIdoShikkenshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoShikkenshaMeibo")
    public SakuseiChohyoIdoShikkenshaMeiboDiv getSakuseiChohyoIdoShikkenshaMeibo() {
        return SakuseiChohyoIdoShikkenshaMeibo;
    }

    /*
     * setSakuseiChohyoIdoShikkenshaMeibo
     * @param SakuseiChohyoIdoShikkenshaMeibo SakuseiChohyoIdoShikkenshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoShikkenshaMeibo")
    public void setSakuseiChohyoIdoShikkenshaMeibo(SakuseiChohyoIdoShikkenshaMeiboDiv SakuseiChohyoIdoShikkenshaMeibo) {
        this.SakuseiChohyoIdoShikkenshaMeibo = SakuseiChohyoIdoShikkenshaMeibo;
    }

    /*
     * getSakuseiChohyoIdoHyojishaMeibo
     * @return SakuseiChohyoIdoHyojishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoHyojishaMeibo")
    public SakuseiChohyoIdoHyojishaMeiboDiv getSakuseiChohyoIdoHyojishaMeibo() {
        return SakuseiChohyoIdoHyojishaMeibo;
    }

    /*
     * setSakuseiChohyoIdoHyojishaMeibo
     * @param SakuseiChohyoIdoHyojishaMeibo SakuseiChohyoIdoHyojishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoHyojishaMeibo")
    public void setSakuseiChohyoIdoHyojishaMeibo(SakuseiChohyoIdoHyojishaMeiboDiv SakuseiChohyoIdoHyojishaMeibo) {
        this.SakuseiChohyoIdoHyojishaMeibo = SakuseiChohyoIdoHyojishaMeibo;
    }

    /*
     * getSakuseiChohyoIdoHyojiShojoshaMeibo
     * @return SakuseiChohyoIdoHyojiShojoshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoHyojiShojoshaMeibo")
    public SakuseiChohyoIdoHyojiShojoshaMeiboDiv getSakuseiChohyoIdoHyojiShojoshaMeibo() {
        return SakuseiChohyoIdoHyojiShojoshaMeibo;
    }

    /*
     * setSakuseiChohyoIdoHyojiShojoshaMeibo
     * @param SakuseiChohyoIdoHyojiShojoshaMeibo SakuseiChohyoIdoHyojiShojoshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoHyojiShojoshaMeibo")
    public void setSakuseiChohyoIdoHyojiShojoshaMeibo(SakuseiChohyoIdoHyojiShojoshaMeiboDiv SakuseiChohyoIdoHyojiShojoshaMeibo) {
        this.SakuseiChohyoIdoHyojiShojoshaMeibo = SakuseiChohyoIdoHyojiShojoshaMeibo;
    }

    /*
     * getSakuseiChohyoIdoHyojiShojoYoteishaMeibo
     * @return SakuseiChohyoIdoHyojiShojoYoteishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoHyojiShojoYoteishaMeibo")
    public SakuseiChohyoIdoHyojiShojoYoteishaMeiboDiv getSakuseiChohyoIdoHyojiShojoYoteishaMeibo() {
        return SakuseiChohyoIdoHyojiShojoYoteishaMeibo;
    }

    /*
     * setSakuseiChohyoIdoHyojiShojoYoteishaMeibo
     * @param SakuseiChohyoIdoHyojiShojoYoteishaMeibo SakuseiChohyoIdoHyojiShojoYoteishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoHyojiShojoYoteishaMeibo")
    public void setSakuseiChohyoIdoHyojiShojoYoteishaMeibo(SakuseiChohyoIdoHyojiShojoYoteishaMeiboDiv SakuseiChohyoIdoHyojiShojoYoteishaMeibo) {
        this.SakuseiChohyoIdoHyojiShojoYoteishaMeibo = SakuseiChohyoIdoHyojiShojoYoteishaMeibo;
    }

    /*
     * getSakuseiChohyoIdo19saishaMeibo
     * @return SakuseiChohyoIdo19saishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdo19saishaMeibo")
    public SakuseiChohyoIdo19saishaMeiboDiv getSakuseiChohyoIdo19saishaMeibo() {
        return SakuseiChohyoIdo19saishaMeibo;
    }

    /*
     * setSakuseiChohyoIdo19saishaMeibo
     * @param SakuseiChohyoIdo19saishaMeibo SakuseiChohyoIdo19saishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdo19saishaMeibo")
    public void setSakuseiChohyoIdo19saishaMeibo(SakuseiChohyoIdo19saishaMeiboDiv SakuseiChohyoIdo19saishaMeibo) {
        this.SakuseiChohyoIdo19saishaMeibo = SakuseiChohyoIdo19saishaMeibo;
    }

    /*
     * getSakuseiChohyoIdoMiseinenshaMeibo
     * @return SakuseiChohyoIdoMiseinenshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoMiseinenshaMeibo")
    public SakuseiChohyoIdoMiseinenshaMeiboDiv getSakuseiChohyoIdoMiseinenshaMeibo() {
        return SakuseiChohyoIdoMiseinenshaMeibo;
    }

    /*
     * setSakuseiChohyoIdoMiseinenshaMeibo
     * @param SakuseiChohyoIdoMiseinenshaMeibo SakuseiChohyoIdoMiseinenshaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoMiseinenshaMeibo")
    public void setSakuseiChohyoIdoMiseinenshaMeibo(SakuseiChohyoIdoMiseinenshaMeiboDiv SakuseiChohyoIdoMiseinenshaMeibo) {
        this.SakuseiChohyoIdoMiseinenshaMeibo = SakuseiChohyoIdoMiseinenshaMeibo;
    }

    /*
     * getSakuseiChohyoIdoSaiTennyushaMeibo
     * @return SakuseiChohyoIdoSaiTennyushaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoSaiTennyushaMeibo")
    public SakuseiChohyoIdoSaiTennyushaMeiboDiv getSakuseiChohyoIdoSaiTennyushaMeibo() {
        return SakuseiChohyoIdoSaiTennyushaMeibo;
    }

    /*
     * setSakuseiChohyoIdoSaiTennyushaMeibo
     * @param SakuseiChohyoIdoSaiTennyushaMeibo SakuseiChohyoIdoSaiTennyushaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoSaiTennyushaMeibo")
    public void setSakuseiChohyoIdoSaiTennyushaMeibo(SakuseiChohyoIdoSaiTennyushaMeiboDiv SakuseiChohyoIdoSaiTennyushaMeibo) {
        this.SakuseiChohyoIdoSaiTennyushaMeibo = SakuseiChohyoIdoSaiTennyushaMeibo;
    }

    /*
     * getSakuseiChohyoIdoTeiseishaMeibo
     * @return SakuseiChohyoIdoTeiseishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoTeiseishaMeibo")
    public SakuseiChohyoIdoTeiseishaMeiboDiv getSakuseiChohyoIdoTeiseishaMeibo() {
        return SakuseiChohyoIdoTeiseishaMeibo;
    }

    /*
     * setSakuseiChohyoIdoTeiseishaMeibo
     * @param SakuseiChohyoIdoTeiseishaMeibo SakuseiChohyoIdoTeiseishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoTeiseishaMeibo")
    public void setSakuseiChohyoIdoTeiseishaMeibo(SakuseiChohyoIdoTeiseishaMeiboDiv SakuseiChohyoIdoTeiseishaMeibo) {
        this.SakuseiChohyoIdoTeiseishaMeibo = SakuseiChohyoIdoTeiseishaMeibo;
    }

    /*
     * getSakuseiChohyoIdoTenshutsushaMeibo
     * @return SakuseiChohyoIdoTenshutsushaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoTenshutsushaMeibo")
    public SakuseiChohyoIdoTenshutsushaMeiboDiv getSakuseiChohyoIdoTenshutsushaMeibo() {
        return SakuseiChohyoIdoTenshutsushaMeibo;
    }

    /*
     * setSakuseiChohyoIdoTenshutsushaMeibo
     * @param SakuseiChohyoIdoTenshutsushaMeibo SakuseiChohyoIdoTenshutsushaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoTenshutsushaMeibo")
    public void setSakuseiChohyoIdoTenshutsushaMeibo(SakuseiChohyoIdoTenshutsushaMeiboDiv SakuseiChohyoIdoTenshutsushaMeibo) {
        this.SakuseiChohyoIdoTenshutsushaMeibo = SakuseiChohyoIdoTenshutsushaMeibo;
    }

    /*
     * getSakuseiChohyoIdoTeishishaMeibo
     * @return SakuseiChohyoIdoTeishishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoTeishishaMeibo")
    public SakuseiChohyoIdoTeishishaMeiboDiv getSakuseiChohyoIdoTeishishaMeibo() {
        return SakuseiChohyoIdoTeishishaMeibo;
    }

    /*
     * setSakuseiChohyoIdoTeishishaMeibo
     * @param SakuseiChohyoIdoTeishishaMeibo SakuseiChohyoIdoTeishishaMeibo
     */
    @JsonProperty("SakuseiChohyoIdoTeishishaMeibo")
    public void setSakuseiChohyoIdoTeishishaMeibo(SakuseiChohyoIdoTeishishaMeiboDiv SakuseiChohyoIdoTeishishaMeibo) {
        this.SakuseiChohyoIdoTeishishaMeibo = SakuseiChohyoIdoTeishishaMeibo;
    }

    /*
     * getSakuseiChohyoZaigai
     * @return SakuseiChohyoZaigai
     */
    @JsonProperty("SakuseiChohyoZaigai")
    public SakuseiChohyoZaigaiDiv getSakuseiChohyoZaigai() {
        return SakuseiChohyoZaigai;
    }

    /*
     * setSakuseiChohyoZaigai
     * @param SakuseiChohyoZaigai SakuseiChohyoZaigai
     */
    @JsonProperty("SakuseiChohyoZaigai")
    public void setSakuseiChohyoZaigai(SakuseiChohyoZaigaiDiv SakuseiChohyoZaigai) {
        this.SakuseiChohyoZaigai = SakuseiChohyoZaigai;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(SenkyoShurui senkyoShurui) {
        getHandler().initialize(senkyoShurui);
    }

    @Override
    public void initialize(SenkyoShurui senkyoShurui, RString shohonNo) {
        getHandler().initialize(senkyoShurui, shohonNo);
    }

    @Override
    public void initialize(RDate tennyuKigenYmd, RDate tenshutsuKigenYmd, RDate kijunKigenYmd, RDate shoriYmd) {
        getHandler().initialize(tennyuKigenYmd, tenshutsuKigenYmd, kijunKigenYmd, shoriYmd);
    }

    @Override
    public void clearData() {
        getHandler().clearData();
    }

    @Override
    public ValidationMessageControlPairs get入力チェック() {
        return getHandler().get入力チェック();
    }

    @JsonIgnore
    public SakuseiChohyoHandler getHandler() {
        return new SakuseiChohyoHandler(this);
    }

}
