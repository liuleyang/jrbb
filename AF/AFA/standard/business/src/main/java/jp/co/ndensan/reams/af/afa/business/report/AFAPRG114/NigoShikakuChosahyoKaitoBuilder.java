/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG114;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG114.NigoShikakuChosahyoKaitoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * AFAPRG114_2goShikakuChosahyoKaito_2号資格調査票（回答）（様式2-2）のBuilderクラスです。
 *
 * @reamsid_L AF-0360-062 fulc
 */
public class NigoShikakuChosahyoKaitoBuilder implements INigoShikakuChosahyoKaitoBuilder {

    private final INigoShikakuChosahyoKaitoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link INigoShikakuChosahyoKaitoEditor}
     */
    public NigoShikakuChosahyoKaitoBuilder(INigoShikakuChosahyoKaitoEditor editor) {
        this.editor = editor;
    }

    @Override
    public NigoShikakuChosahyoKaitoSource build() {
        return ReportEditorJoiner.from(new NigoShikakuChosahyoKaitoSource()).join(editor).buildSource();
    }

}
