/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE515;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE515.JimushoriboSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE515_Jimushoribo_事務処理簿のBuilderクラスです。
 *
 * @reamsid_L AF-0280-032 wangm
 */
public class JimushoriboBuilder implements IJimushoriboBuilder {

    private final IJimushoriboEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link JimushoriboEditor}
     */
    public JimushoriboBuilder(IJimushoriboEditor editor) {
        this.editor = editor;
    }

    @Override
    public JimushoriboSource build() {
        return ReportEditorJoiner.from(new JimushoriboSource()).join(editor).buildSource();
    }

}
