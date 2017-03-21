/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG301;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG301.KokugaiTennyushaChosahyoShokaiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * AFAPRG301_KokugaiTennyushaChosahyoShokai_国外転入者調査票（照会）のBuilderクラスです。
 *
 * @reamsid_L AF-0360-065 b_caiyf
 */
public class KokugaiTennyushaChosahyoShokaiBuilder implements IKokugaiTennyushaChosahyoShokaiBuilder {

    private final IKokugaiTennyushaChosahyoShokaiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link IKokugaiTennyushaChosahyoShokaiEditor}
     */
    public KokugaiTennyushaChosahyoShokaiBuilder(IKokugaiTennyushaChosahyoShokaiEditor editor) {
        this.editor = editor;
    }

    @Override
    public KokugaiTennyushaChosahyoShokaiSource build() {
        return ReportEditorJoiner.from(new KokugaiTennyushaChosahyoShokaiSource()).join(editor).buildSource();
    }

}
