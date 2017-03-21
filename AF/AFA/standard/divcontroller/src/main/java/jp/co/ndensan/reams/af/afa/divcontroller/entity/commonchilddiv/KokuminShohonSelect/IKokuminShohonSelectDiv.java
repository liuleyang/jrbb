package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminShohonSelect;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 */
public interface IKokuminShohonSelectDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @return boolean
     */
    boolean initialize();

    DataGrid<dgKokuminShohon_Row> getDgKokuminShohon();

    RString getHdnMasshoYMD();

    RString getHdnShohonNo();
}
