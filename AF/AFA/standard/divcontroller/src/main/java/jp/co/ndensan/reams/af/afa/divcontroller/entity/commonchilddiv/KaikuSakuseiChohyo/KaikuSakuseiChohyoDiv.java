package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 海区作成帳票共有子DIV
 *
 * @reamsid_L AF-0460-011 liuyj
 */
public class KaikuSakuseiChohyoDiv extends Panel implements IKaikuSakuseiChohyoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaikuSakuseiChohyoMeiboShohon")
    private KaikuSakuseiChohyoMeiboShohonDiv KaikuSakuseiChohyoMeiboShohon;
    @JsonProperty("KaikuSakuseiChohyoTorokushasuList")
    private KaikuSakuseiChohyoTorokushasuListDiv KaikuSakuseiChohyoTorokushasuList;
    @JsonProperty("KaikuSakuseiChohyoIdoTorokushaMeibo")
    private KaikuSakuseiChohyoIdoTorokushaMeiboDiv KaikuSakuseiChohyoIdoTorokushaMeibo;
    @JsonProperty("KaikuSakuseiChohyoIdoMasshoshaMeibo")
    private KaikuSakuseiChohyoIdoMasshoshaMeiboDiv KaikuSakuseiChohyoIdoMasshoshaMeibo;
    @JsonProperty("KaikuSakuseiChohyoIdoShikkenshaMeibo")
    private KaikuSakuseiChohyoIdoShikkenshaMeiboDiv KaikuSakuseiChohyoIdoShikkenshaMeibo;
    @JsonProperty("KaikuSakuseiChohyoIdoHyojishaMeibo")
    private KaikuSakuseiChohyoIdoHyojishaMeiboDiv KaikuSakuseiChohyoIdoHyojishaMeibo;
    @JsonProperty("KaikuSakuseiChohyoIdoTeiseishaMeibo")
    private KaikuSakuseiChohyoIdoTeiseishaMeiboDiv KaikuSakuseiChohyoIdoTeiseishaMeibo;
    @JsonProperty("KaikuSakuseiChohyoIdoJukiIdoshaList")
    private KaikuSakuseiChohyoIdoJukiIdoshaListDiv KaikuSakuseiChohyoIdoJukiIdoshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaikuSakuseiChohyoMeiboShohon
     * @return KaikuSakuseiChohyoMeiboShohon
     */
    @JsonProperty("KaikuSakuseiChohyoMeiboShohon")
    public KaikuSakuseiChohyoMeiboShohonDiv getKaikuSakuseiChohyoMeiboShohon() {
        return KaikuSakuseiChohyoMeiboShohon;
    }

    /*
     * setKaikuSakuseiChohyoMeiboShohon
     * @param KaikuSakuseiChohyoMeiboShohon KaikuSakuseiChohyoMeiboShohon
     */
    @JsonProperty("KaikuSakuseiChohyoMeiboShohon")
    public void setKaikuSakuseiChohyoMeiboShohon(KaikuSakuseiChohyoMeiboShohonDiv KaikuSakuseiChohyoMeiboShohon) {
        this.KaikuSakuseiChohyoMeiboShohon = KaikuSakuseiChohyoMeiboShohon;
    }

    /*
     * getKaikuSakuseiChohyoTorokushasuList
     * @return KaikuSakuseiChohyoTorokushasuList
     */
    @JsonProperty("KaikuSakuseiChohyoTorokushasuList")
    public KaikuSakuseiChohyoTorokushasuListDiv getKaikuSakuseiChohyoTorokushasuList() {
        return KaikuSakuseiChohyoTorokushasuList;
    }

    /*
     * setKaikuSakuseiChohyoTorokushasuList
     * @param KaikuSakuseiChohyoTorokushasuList KaikuSakuseiChohyoTorokushasuList
     */
    @JsonProperty("KaikuSakuseiChohyoTorokushasuList")
    public void setKaikuSakuseiChohyoTorokushasuList(KaikuSakuseiChohyoTorokushasuListDiv KaikuSakuseiChohyoTorokushasuList) {
        this.KaikuSakuseiChohyoTorokushasuList = KaikuSakuseiChohyoTorokushasuList;
    }

    /*
     * getKaikuSakuseiChohyoIdoTorokushaMeibo
     * @return KaikuSakuseiChohyoIdoTorokushaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoTorokushaMeibo")
    public KaikuSakuseiChohyoIdoTorokushaMeiboDiv getKaikuSakuseiChohyoIdoTorokushaMeibo() {
        return KaikuSakuseiChohyoIdoTorokushaMeibo;
    }

    /*
     * setKaikuSakuseiChohyoIdoTorokushaMeibo
     * @param KaikuSakuseiChohyoIdoTorokushaMeibo KaikuSakuseiChohyoIdoTorokushaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoTorokushaMeibo")
    public void setKaikuSakuseiChohyoIdoTorokushaMeibo(KaikuSakuseiChohyoIdoTorokushaMeiboDiv KaikuSakuseiChohyoIdoTorokushaMeibo) {
        this.KaikuSakuseiChohyoIdoTorokushaMeibo = KaikuSakuseiChohyoIdoTorokushaMeibo;
    }

    /*
     * getKaikuSakuseiChohyoIdoMasshoshaMeibo
     * @return KaikuSakuseiChohyoIdoMasshoshaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoMasshoshaMeibo")
    public KaikuSakuseiChohyoIdoMasshoshaMeiboDiv getKaikuSakuseiChohyoIdoMasshoshaMeibo() {
        return KaikuSakuseiChohyoIdoMasshoshaMeibo;
    }

    /*
     * setKaikuSakuseiChohyoIdoMasshoshaMeibo
     * @param KaikuSakuseiChohyoIdoMasshoshaMeibo KaikuSakuseiChohyoIdoMasshoshaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoMasshoshaMeibo")
    public void setKaikuSakuseiChohyoIdoMasshoshaMeibo(KaikuSakuseiChohyoIdoMasshoshaMeiboDiv KaikuSakuseiChohyoIdoMasshoshaMeibo) {
        this.KaikuSakuseiChohyoIdoMasshoshaMeibo = KaikuSakuseiChohyoIdoMasshoshaMeibo;
    }

    /*
     * getKaikuSakuseiChohyoIdoShikkenshaMeibo
     * @return KaikuSakuseiChohyoIdoShikkenshaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoShikkenshaMeibo")
    public KaikuSakuseiChohyoIdoShikkenshaMeiboDiv getKaikuSakuseiChohyoIdoShikkenshaMeibo() {
        return KaikuSakuseiChohyoIdoShikkenshaMeibo;
    }

    /*
     * setKaikuSakuseiChohyoIdoShikkenshaMeibo
     * @param KaikuSakuseiChohyoIdoShikkenshaMeibo KaikuSakuseiChohyoIdoShikkenshaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoShikkenshaMeibo")
    public void setKaikuSakuseiChohyoIdoShikkenshaMeibo(KaikuSakuseiChohyoIdoShikkenshaMeiboDiv KaikuSakuseiChohyoIdoShikkenshaMeibo) {
        this.KaikuSakuseiChohyoIdoShikkenshaMeibo = KaikuSakuseiChohyoIdoShikkenshaMeibo;
    }

    /*
     * getKaikuSakuseiChohyoIdoHyojishaMeibo
     * @return KaikuSakuseiChohyoIdoHyojishaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoHyojishaMeibo")
    public KaikuSakuseiChohyoIdoHyojishaMeiboDiv getKaikuSakuseiChohyoIdoHyojishaMeibo() {
        return KaikuSakuseiChohyoIdoHyojishaMeibo;
    }

    /*
     * setKaikuSakuseiChohyoIdoHyojishaMeibo
     * @param KaikuSakuseiChohyoIdoHyojishaMeibo KaikuSakuseiChohyoIdoHyojishaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoHyojishaMeibo")
    public void setKaikuSakuseiChohyoIdoHyojishaMeibo(KaikuSakuseiChohyoIdoHyojishaMeiboDiv KaikuSakuseiChohyoIdoHyojishaMeibo) {
        this.KaikuSakuseiChohyoIdoHyojishaMeibo = KaikuSakuseiChohyoIdoHyojishaMeibo;
    }

    /*
     * getKaikuSakuseiChohyoIdoTeiseishaMeibo
     * @return KaikuSakuseiChohyoIdoTeiseishaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoTeiseishaMeibo")
    public KaikuSakuseiChohyoIdoTeiseishaMeiboDiv getKaikuSakuseiChohyoIdoTeiseishaMeibo() {
        return KaikuSakuseiChohyoIdoTeiseishaMeibo;
    }

    /*
     * setKaikuSakuseiChohyoIdoTeiseishaMeibo
     * @param KaikuSakuseiChohyoIdoTeiseishaMeibo KaikuSakuseiChohyoIdoTeiseishaMeibo
     */
    @JsonProperty("KaikuSakuseiChohyoIdoTeiseishaMeibo")
    public void setKaikuSakuseiChohyoIdoTeiseishaMeibo(KaikuSakuseiChohyoIdoTeiseishaMeiboDiv KaikuSakuseiChohyoIdoTeiseishaMeibo) {
        this.KaikuSakuseiChohyoIdoTeiseishaMeibo = KaikuSakuseiChohyoIdoTeiseishaMeibo;
    }

    /*
     * getKaikuSakuseiChohyoIdoJukiIdoshaList
     * @return KaikuSakuseiChohyoIdoJukiIdoshaList
     */
    @JsonProperty("KaikuSakuseiChohyoIdoJukiIdoshaList")
    public KaikuSakuseiChohyoIdoJukiIdoshaListDiv getKaikuSakuseiChohyoIdoJukiIdoshaList() {
        return KaikuSakuseiChohyoIdoJukiIdoshaList;
    }

    /*
     * setKaikuSakuseiChohyoIdoJukiIdoshaList
     * @param KaikuSakuseiChohyoIdoJukiIdoshaList KaikuSakuseiChohyoIdoJukiIdoshaList
     */
    @JsonProperty("KaikuSakuseiChohyoIdoJukiIdoshaList")
    public void setKaikuSakuseiChohyoIdoJukiIdoshaList(KaikuSakuseiChohyoIdoJukiIdoshaListDiv KaikuSakuseiChohyoIdoJukiIdoshaList) {
        this.KaikuSakuseiChohyoIdoJukiIdoshaList = KaikuSakuseiChohyoIdoJukiIdoshaList;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void set時点日(RDate 名簿基準年月日) {
        getHandler().set時点日(名簿基準年月日);
    }

    @Override
    public void edit選挙人名簿最新化(Boolean 選挙時登録フラグ) {
        getHandler().edit選挙人名簿最新化(選挙時登録フラグ);
    }

    @Override
    public KaikuSakuseiChohyoDiv get海区作成帳票情報() {
        return this;
    }

    @JsonIgnore
    public KaikuSakuseiChohyoHandler getHandler() {
        return new KaikuSakuseiChohyoHandler(this);
    }
}
