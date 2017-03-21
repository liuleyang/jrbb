/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE514;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE514.JikanbetsuJokyoTohyojoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE514_JikanbetsuJokyoTohyojo_時間別投票状況表　投票所別のBuilderクラスです。
 *
 * @reamsid_L AF-0280-031 wangm
 */
public class JikanbetsuJokyoTohyojoBuilder implements IJikanbetsuJokyoTohyojoBuilder {

    private final IJikanbetsuJokyoTohyojoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link JikanbetsuJokyoTohyojoEditor}
     */
    public JikanbetsuJokyoTohyojoBuilder(IJikanbetsuJokyoTohyojoEditor editor) {
        this.editor = editor;
    }

    @Override
    public JikanbetsuJokyoTohyojoSource build() {
        return ReportEditorJoiner.from(new JikanbetsuJokyoTohyojoSource()).join(editor).buildSource();
    }

}
