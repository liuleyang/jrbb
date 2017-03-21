/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG302;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG302.KokunaiTennyushaChosahyoKaitoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * AFAPRG302_KokunaiTennyushaChosahyoKaito_国内転入者調査票（回答）のBuilderクラスです。
 *
 * @reamsid_L AF-0360-067 b_caiyf
 */
public class KokunaiTennyushaChosahyoKaitoBuilder implements IKokunaiTennyushaChosahyoKaitoBuilder {

    private final IKokunaiTennyushaChosahyoKaitoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link IKokunaiTennyushaChosahyoKaitoEditor}
     */
    public KokunaiTennyushaChosahyoKaitoBuilder(IKokunaiTennyushaChosahyoKaitoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KokunaiTennyushaChosahyoKaitoSource build() {
        return ReportEditorJoiner.from(new KokunaiTennyushaChosahyoKaitoSource()).join(editor).buildSource();
    }

}
