/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE512;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE512.NendaibetsuJokyoShirabeSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE512_NendaibetsuJokyoShirabe_年代別投票状況調べのBuilderクラスです。
 *
 * @reamsid_L AF-0280-029 wangm
 */
public class NendaibetsuJokyoShirabeBuilder implements INendaibetsuJokyoShirabeBuilder {

    private final INendaibetsuJokyoShirabeEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link NendaibetsuJokyoShirabeEditor}
     */
    public NendaibetsuJokyoShirabeBuilder(INendaibetsuJokyoShirabeEditor editor) {
        this.editor = editor;
    }

    @Override
    public NendaibetsuJokyoShirabeSource build() {
        return ReportEditorJoiner.from(new NendaibetsuJokyoShirabeSource()).join(editor).buildSource();
    }

}
