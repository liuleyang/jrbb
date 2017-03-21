/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG303;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG303.KokugaiTennyushaChosahyoKaitoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 国外転入者調査票（回答）のBuilderクラスです。
 *
 * @reamsid_L AF-0360-068 b_caiyf
 */
public class KokugaiTennyushaChosahyoKaitoBuilder implements IKokugaiTennyushaChosahyoKaitoBuilder {

    private final IKokugaiTennyushaChosahyoKaitoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link IKokugaiTennyushaChosahyoKaitoEditor}
     */
    public KokugaiTennyushaChosahyoKaitoBuilder(IKokugaiTennyushaChosahyoKaitoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KokugaiTennyushaChosahyoKaitoSource build() {
        return ReportEditorJoiner.from(new KokugaiTennyushaChosahyoKaitoSource()).join(editor).buildSource();
    }

}
