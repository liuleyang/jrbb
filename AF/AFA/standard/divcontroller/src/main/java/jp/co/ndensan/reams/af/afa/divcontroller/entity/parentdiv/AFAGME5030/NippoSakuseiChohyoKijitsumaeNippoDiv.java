package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.IShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange.ShisetsuCodeSelectRangeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * NippoSakuseiChohyoKijitsumaeNippo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NippoSakuseiChohyoKijitsumaeNippoDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijitsumaNippoTohyoYMD")
    private TextBoxDateRange txtKijitsumaNippoTohyoYMD;
    @JsonProperty("ccdKijitsumaeNippoShisetsuCode")
    private ShisetsuCodeSelectRangeDiv ccdKijitsumaeNippoShisetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijitsumaNippoTohyoYMD
     * @return txtKijitsumaNippoTohyoYMD
     */
    @JsonProperty("txtKijitsumaNippoTohyoYMD")
    public TextBoxDateRange getTxtKijitsumaNippoTohyoYMD() {
        return txtKijitsumaNippoTohyoYMD;
    }

    /*
     * settxtKijitsumaNippoTohyoYMD
     * @param txtKijitsumaNippoTohyoYMD txtKijitsumaNippoTohyoYMD
     */
    @JsonProperty("txtKijitsumaNippoTohyoYMD")
    public void setTxtKijitsumaNippoTohyoYMD(TextBoxDateRange txtKijitsumaNippoTohyoYMD) {
        this.txtKijitsumaNippoTohyoYMD = txtKijitsumaNippoTohyoYMD;
    }

    /*
     * getccdKijitsumaeNippoShisetsuCode
     * @return ccdKijitsumaeNippoShisetsuCode
     */
    @JsonProperty("ccdKijitsumaeNippoShisetsuCode")
    public IShisetsuCodeSelectRangeDiv getCcdKijitsumaeNippoShisetsuCode() {
        return ccdKijitsumaeNippoShisetsuCode;
    }

    // </editor-fold>
}
