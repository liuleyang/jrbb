package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 */
public interface IJushoJokenSelectDiv extends ICommonChildDivBaseProperties {

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJushoJoken
     * @return radJushoJoken
     */
    RadioButton getRadJushoJoken();

    /*
     * setradJushoJoken
     * @param radJushoJoken radJushoJoken
     */
    void setRadJushoJoken(RadioButton radJushoJoken);

    /*
     * getdgJushoJokenList
     * @return dgJushoJokenList
     */
    DataGrid<dgJushoJokenList_Row> getDgJushoJokenList();

    /*
     * setdgJushoJokenList
     * @param dgJushoJokenList dgJushoJokenList
     */
    void setDgJushoJokenList(DataGrid<dgJushoJokenList_Row> dgJushoJokenList);

    /*
     * getshohonNoValue
     * @return shohonNoValue
     */
    RString getShohonNoValue();

    /*
     * setshohonNoValue
     * @param shohonNoValue shohonNoValue
     */
    void setShohonNoValue(RString shohonNoValue);

    /*
     * getsenkyoShuruiKey
     * @return senkyoShuruiKey
     */
    RString getSenkyoShuruiKey();

    /*
     * setsenkyoShuruiKey
     * @param senkyoShuruiKey senkyoShuruiKey
     */
    void setSenkyoShuruiKey(RString senkyoShuruiKey);
    /*
     * getsenkyoShuruiValue
     * @return senkyoShuruiValue
     */

    RString getSenkyoShuruiValue();

    /*
     * setsenkyoShuruiValue
     * @param senkyoShuruiValue senkyoShuruiValue
     */
    void setSenkyoShuruiValue(RString senkyoShuruiValue);

    /*
     * getradioButtonName
     * @return radioButtonName
     */
    RString getRadioButtonName();

    /*
     * setradioButtonName
     * @param radioButtonName radioButtonName
     */
    void setRadioButtonName(RString radioButtonName);

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙種類 Code
     */
    void initialize(ShohonNo 抄本番号, Code 選挙種類);

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 選挙種類 Code
     */
    void initialize(Code 選挙種類);

    /**
     * ラジオボタンのonChangeのイベントメソッドです。
     *
     */
    void onChange_radJushoJoken();

    /**
     * グリッド内容チェック。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs gridContextCheck();

}
