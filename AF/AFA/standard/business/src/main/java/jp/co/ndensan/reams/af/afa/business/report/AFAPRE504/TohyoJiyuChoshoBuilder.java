/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE504;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE504.TohyoJiyuChoshoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 投票事由調書
 *
 * @reamsid_L AF-0270-035 wangl
 */
public class TohyoJiyuChoshoBuilder implements ITohyoJiyuChoshoBuilder {

    private final TohyoJiyuChoshoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link TohyoJiyuChoshoEditor}
     */
    public TohyoJiyuChoshoBuilder(TohyoJiyuChoshoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return TohyoJiyuChoshoSource
     */
    @Override
    public TohyoJiyuChoshoSource build() {
        return ReportEditorJoiner.from(new TohyoJiyuChoshoSource()).join(this.editor).buildSource();
    }

}
