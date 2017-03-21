/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect;

//import jp.co.ndensan.reams.af.afa.business.core.master.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.core.contexts.ShisetsuCodeSelectContext;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ShisetsuCodeSelectDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してShisetsuCodeSelectDivの入力可否、表示・非表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-035 qiuxy
 */
public class ShisetsuCodeSelectHandler {

    private final ShisetsuCodeSelectDiv div;
    private final ShisetsuManager Manager;
    private static final RString 施設種別使用フラグ = new RString("1");
    private static final RString 施設種別未使用フラグ = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div 施設コード選択Div
     */
    public ShisetsuCodeSelectHandler(ShisetsuCodeSelectDiv div) {
        this.div = div;
        Manager = InstanceProvider.create(ShisetsuManager.class);
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     */
    public void initialize() {
        initialize(RString.EMPTY);
    }

    /**
     * 施設コードを引数として、この共有子divの初期表示を行う。
     *
     * @param code 施設コード
     */
    public void initialize(RString code) {
        initialize(code, Boolean.FALSE);
    }

    /**
     * 施設コードと本庁支所区分を引数として、この共有子divの初期表示を行う。
     *
     * @param code 施設コード
     * @param kubun 本庁支所区分
     */
    public void initialize(RString code, boolean kubun) {
        if (!RString.isNullOrEmpty(code)) {
            div.getTxtShisetsuCode().setValue(code);
            div.getTxtShisetsuName().setValue(get施設名称(code));
        }
        div.setIsUsingShisetsuShubetsu(施設種別未使用フラグ);
        ViewStateHolder.put(ViewStateKeys.本庁支所区分, kubun);
    }

    /**
     * 施設種別と本庁支所区分と施設コードを引数として、この共有子divの初期表示を行う。
     *
     * @param 施設種別 ShisetsuShubetsu
     * @param 本庁支所区分 boolean
     * @param 施設コード RString
     */
    public void initialize(ShisetsuShubetsu 施設種別, boolean 本庁支所区分, RString 施設コード) {
        initialize(施設コード, 本庁支所区分);
        div.setIsUsingShisetsuShubetsu(施設種別使用フラグ);
        div.setTxtHdnShisetsuShubetsu(施設種別 == null ? RString.EMPTY : 施設種別.getCode());
    }

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    public void clear() {
        div.getTxtShisetsuCode().clearValue();
        div.getTxtShisetsuName().clearValue();
    }

    /**
     * 施設コードを取得します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return div.getTxtShisetsuCode().getValue();
    }

    /**
     * 施設名称を取得します。
     *
     * @return 施設名称
     */
    public RString get施設名称() {
        return div.getTxtShisetsuName().getValue();
    }

    /**
     * 施設コードで施設名称を取得します。
     *
     * @param 施設コード RString
     * @return 施設名称 RString
     */
    public RString get施設名称(RString 施設コード) {
        Shisetsu 施設 = Manager.get施設By施設コード(施設コード);
        return 施設 == null ? RString.EMPTY : 施設.get施設名称();
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlySetMode 使用状態（照会／入力）
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        div.getTxtShisetsuCode().setRequired(!readOnlySetMode);
        div.setReadOnly(readOnlySetMode);
        div.getBtnShisetsuCode().setDisplayNone(readOnlySetMode);
    }

    /**
     * 施設コード選択用のContextを取得します。
     *
     * @return ShisetsuCodeSelectContext 施設コード選択Context
     */
    public ShisetsuCodeSelectContext getShisetsuCodeSelectContext() {
        return new ShisetsuCodeSelectContext(div.get施設コード());
    }

}
