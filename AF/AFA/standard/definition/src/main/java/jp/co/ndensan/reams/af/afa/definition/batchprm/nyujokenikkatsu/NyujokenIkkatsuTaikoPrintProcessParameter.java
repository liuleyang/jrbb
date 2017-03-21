/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 代行プリント送付票情報Processパラメータクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NyujokenIkkatsuTaikoPrintProcessParameter implements IBatchProcessParameter {

    private List<NyujokenIkkatsuTaikoPrint> 代行プリント送付票情報リスト;
    private RString ジョブ番号;

    /**
     * コンストラクタです
     */
    public NyujokenIkkatsuTaikoPrintProcessParameter() {
    }

    /**
     * 通知書一括発行Processです。
     *
     * @param 代行プリント送付票情報リスト List<NyujokenIkkatsuTaikoPrint>
     * @param ジョブ番号 RString
     *
     */
    public NyujokenIkkatsuTaikoPrintProcessParameter(
            List<NyujokenIkkatsuTaikoPrint> 代行プリント送付票情報リスト,
            RString ジョブ番号) {
        this.代行プリント送付票情報リスト = 代行プリント送付票情報リスト;
        this.ジョブ番号 = ジョブ番号;

    }

}
