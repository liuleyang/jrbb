package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.AtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout.IAtenaSealLayoutDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.IShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.ShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.IAtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * SealShisetsuParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class SealShisetsuParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SealShisetsuNaiyo")
    private SealShisetsuNaiyoDiv SealShisetsuNaiyo;
    @JsonProperty("ccdShisetsuShubetsu")
    private CodeInputDiv ccdShisetsuShubetsu;
    @JsonProperty("ccdShisetsuCodeRange")
    private ShisetsuCodeSelectRangeDiv ccdShisetsuCodeRange;
    @JsonProperty("ccdSealPosition")
    private AtenaSealPositionGuideDiv ccdSealPosition;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSealShisetsuNaiyo
     * @return SealShisetsuNaiyo
     */
    @JsonProperty("SealShisetsuNaiyo")
    public SealShisetsuNaiyoDiv getSealShisetsuNaiyo() {
        return SealShisetsuNaiyo;
    }

    /*
     * setSealShisetsuNaiyo
     * @param SealShisetsuNaiyo SealShisetsuNaiyo
     */
    @JsonProperty("SealShisetsuNaiyo")
    public void setSealShisetsuNaiyo(SealShisetsuNaiyoDiv SealShisetsuNaiyo) {
        this.SealShisetsuNaiyo = SealShisetsuNaiyo;
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
     * getccdShisetsuCodeRange
     * @return ccdShisetsuCodeRange
     */
    @JsonProperty("ccdShisetsuCodeRange")
    public IShisetsuCodeSelectRangeDiv getCcdShisetsuCodeRange() {
        return ccdShisetsuCodeRange;
    }

    /*
     * getccdSealPosition
     * @return ccdSealPosition
     */
    @JsonProperty("ccdSealPosition")
    public IAtenaSealPositionGuideDiv getCcdSealPosition() {
        return ccdSealPosition;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IAtenaSealLayoutDiv getCcdSealLayout() {
        return this.getSealShisetsuNaiyo().getCcdSealLayout();
    }

    // </editor-fold>
}
