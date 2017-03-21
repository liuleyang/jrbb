/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE511;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE511.DairiTohyoShukeihyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE511_DairiTohyoShukeihyo_代理投票集計表のBuilderクラスです。
 *
 * @reamsid_L AF-0280-028 wangm
 */
public class DairiTohyoShukeihyoBuilder implements IDairiTohyoShukeihyoBuilder {

    private final IDairiTohyoShukeihyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link DairiTohyoShukeihyoEditor}
     */
    public DairiTohyoShukeihyoBuilder(IDairiTohyoShukeihyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public DairiTohyoShukeihyoSource build() {
        return ReportEditorJoiner.from(new DairiTohyoShukeihyoSource()).join(editor).buildSource();
    }

}
