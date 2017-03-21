/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE509;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE509.JurijokyoIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE509_JurijokyoIchiranhyo_受理状況一覧表のBuilderクラスです。
 *
 * @reamsid_L AF-0280-026 wangm
 */
public class JurijokyoIchiranhyoBuilder implements IJurijokyoIchiranhyoBuilder {

    private final IJurijokyoIchiranhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link JurijokyoIchiranhyoEditor}
     */
    public JurijokyoIchiranhyoBuilder(IJurijokyoIchiranhyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public JurijokyoIchiranhyoSource build() {
        return ReportEditorJoiner.from(new JurijokyoIchiranhyoSource()).join(editor).buildSource();
    }

}
