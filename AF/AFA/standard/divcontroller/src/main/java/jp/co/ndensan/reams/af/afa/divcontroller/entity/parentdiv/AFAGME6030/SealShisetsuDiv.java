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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SealShisetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class SealShisetsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SealShisetsuParam")
    private SealShisetsuParamDiv SealShisetsuParam;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSealShisetsuParam
     * @return SealShisetsuParam
     */
    @JsonProperty("SealShisetsuParam")
    public SealShisetsuParamDiv getSealShisetsuParam() {
        return SealShisetsuParam;
    }

    /*
     * setSealShisetsuParam
     * @param SealShisetsuParam SealShisetsuParam
     */
    @JsonProperty("SealShisetsuParam")
    public void setSealShisetsuParam(SealShisetsuParamDiv SealShisetsuParam) {
        this.SealShisetsuParam = SealShisetsuParam;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public SealShisetsuNaiyoDiv getSealShisetsuNaiyo() {
        return this.getSealShisetsuParam().getSealShisetsuNaiyo();
    }

    @JsonIgnore
    public void  setSealShisetsuNaiyo(SealShisetsuNaiyoDiv SealShisetsuNaiyo) {
        this.getSealShisetsuParam().setSealShisetsuNaiyo(SealShisetsuNaiyo);
    }

    @JsonIgnore
    public IAtenaSealLayoutDiv getCcdSealLayout() {
        return this.getSealShisetsuParam().getSealShisetsuNaiyo().getCcdSealLayout();
    }

    @JsonIgnore
    public ICodeInputDiv getCcdShisetsuShubetsu() {
        return this.getSealShisetsuParam().getCcdShisetsuShubetsu();
    }

    @JsonIgnore
    public IShisetsuCodeSelectRangeDiv getCcdShisetsuCodeRange() {
        return this.getSealShisetsuParam().getCcdShisetsuCodeRange();
    }

    @JsonIgnore
    public IAtenaSealPositionGuideDiv getCcdSealPosition() {
        return this.getSealShisetsuParam().getCcdSealPosition();
    }

    // </editor-fold>
}
