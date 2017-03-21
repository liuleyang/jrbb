package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IFuzaishaShikakuDiv extends ICommonChildDivBaseProperties {

    void initialize(Code 投票資格種類, ShikibetsuCode 識別コード);

    void clear();

    void set有りの場合();

    void set無しの場合();

    /**
     * この共有子Div情報を取得する。
     *
     * @return FuzaishaShikakuDiv
     */
    FuzaishaShikakuDiv get不在者資格情報();

}
