/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE513;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE513.JikanbetsuJokyoGokeiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE513_JikanbetsuJokyoGokei_時間別投票状況表　合計のBuilderクラスです。
 *
 * @reamsid_L AF-0280-030 wangm
 */
public class JikanbetsuJokyoGokeiBuilder implements IJikanbetsuJokyoGokeiBuilder {

    private final IJikanbetsuJokyoGokeiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link JikanbetsuJokyoGokeiEditor}
     */
    public JikanbetsuJokyoGokeiBuilder(IJikanbetsuJokyoGokeiEditor editor) {
        this.editor = editor;
    }

    @Override
    public JikanbetsuJokyoGokeiSource build() {
        return ReportEditorJoiner.from(new JikanbetsuJokyoGokeiSource()).join(editor).buildSource();
    }

}
