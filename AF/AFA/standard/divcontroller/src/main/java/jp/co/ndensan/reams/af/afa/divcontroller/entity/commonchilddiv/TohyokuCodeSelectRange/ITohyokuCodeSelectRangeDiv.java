package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L AF-0280-010 lit
 */
public interface ITohyokuCodeSelectRangeDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * 引数の投票区コードから、この共有子Divの初期表示を行います。
     *
     * @param fromCode 開始投票区コード
     * @param toCode 終了投票区コード
     */
    void initialize(RString fromCode, RString toCode);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 投票区コードFROMを返す。
     *
     * @return 投票区コードFROM
     */
    RString get投票区コードFROM();

    /**
     * 投票区コードTOを返す。
     *
     * @return 投票区コードTO
     */
    RString get投票区コードTO();

    /**
     * 関係チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs 関係チェック();
}
