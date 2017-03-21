package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect;

import jp.co.ndensan.reams.af.afa.business.core.contexts.ShisetsuCodeSelectContext;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * ShisetsuCodeSelectのインタフェースです。
 *
 * @reamsid_L AF-0080-035 qiuxy
 */
public interface IShisetsuCodeSelectDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     */
    void initialize();

    /**
     * 施設コードを引数として、この共有子divの初期表示を行う。
     *
     * @param code 施設コード
     */
    void initialize(RString code);

    /**
     * 施設コードと本庁支所区分を引数として、この共有子divの初期表示を行う。
     *
     * @param code 施設コード
     * @param kubun 本庁支所区分
     */
    void initialize(RString code, boolean kubun);

    /**
     * 施設種別と本庁支所区分と施設コードを引数として、この共有子divの初期表示を行う。<br/>
     * このメソッドは、施設宛名シール画面だけで使います。
     *
     * @param 施設種別 ShisetsuShubetsu
     * @param 本庁支所区分 boolean
     * @param 施設コード RString
     */
    void initialize(ShisetsuShubetsu 施設種別, boolean 本庁支所区分, RString 施設コード);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clear();

    /**
     * 施設コードを取得します。
     *
     * @return 施設コード
     */
    RString get施設コード();

    /**
     * 施設名称を取得します。
     *
     * @return 施設名称
     */
    RString get施設名称();

    /**
     * 共有子Div自身のsetReadOnlyをセットします
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * 施設コード選択用のContextを取得します。
     *
     * @return ShisetsuCodeSelectContext 施設コード選択Context
     */
    ShisetsuCodeSelectContext getShisetsuCodeSelectContext();

    /**
     * 施設コードのTextBoxCodeを取得します。
     *
     * @return TextBoxCode 施設コードのTextBoxCode
     */
    TextBoxCode getTxtShisetsuCode();

}
