package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L AF-0280-010 lit
 */
public interface IShisetsuCodeSelectRangeDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     */
    void initialize();

    /**
     * 引数の施設コードから、この共有子Divの初期表示を行います。
     *
     * @param fromCode 開始施設コード
     * @param toCode 終了施設コード
     * @param 施設種別 ShisetsuShubetsu
     */
    void initialize(RString fromCode, RString toCode, ShisetsuShubetsu 施設種別);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 施設コードFROMを返す。
     *
     * @return 施設コードFROM
     */
    RString get施設コードFROM();

    /**
     * 施設コードTOを返す。
     *
     * @return 施設コードTO
     */
    RString get施設コードTO();

    /**
     * 施設名称を返す。
     *
     * @return 施設コードFROM
     */
    RString get施設名称From();

    /**
     * 施設名称を返す。
     *
     * @return 施設コードTo
     */
    RString get施設名称To();

    /**
     * 関係チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs 関係チェック();
}
