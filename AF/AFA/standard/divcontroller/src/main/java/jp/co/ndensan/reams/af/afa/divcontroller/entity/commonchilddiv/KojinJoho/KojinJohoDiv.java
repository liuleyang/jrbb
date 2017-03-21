package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.IAtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KojinJoho のクラスファイルです。
 *
 * @reamsid_L AF-0180-014 liuj
 */
public class KojinJohoDiv extends Panel implements IKojinJohoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKojinJohoUR")
    private AtenaShokaiSimpleDiv ccdKojinJohoUR;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKojinJohoUR
     * @return ccdKojinJohoUR
     */
    @JsonProperty("ccdKojinJohoUR")
    @Override
    public IAtenaShokaiSimpleDiv getCcdKojinJohoUR() {
        return ccdKojinJohoUR;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ShikibetsuCode 識別コード) {
        getHandler().initialize(識別コード);
    }

    @Override
    public RString getカナ名称() {
        return getHandler().getカナ名称();
    }

    @Override
    public RString get漢字名称() {
        return getHandler().get漢字名称();
    }

    private KojinJohoHandler getHandler() {
        return new KojinJohoHandler(this);
    }
}
