package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiCodeSelect;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKumiaiCodeSelectDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * 引数のコードから、投票区名称を取得し初期表示を行う。
     *
     * @param code 組合コード
     */
    void initialize(RString code);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clear();

    /**
     * 共有子Div自身のsetReadOnlyをセットします
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * この共有子Div情報を取得する。
     *
     * @return KumiaiCodeSelectDiv
     */
    KumiaiCodeSelectDiv get組合コード選択Div();

}
