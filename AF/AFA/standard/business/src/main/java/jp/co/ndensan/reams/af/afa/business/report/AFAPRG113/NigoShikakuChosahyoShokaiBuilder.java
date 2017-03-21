/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG113;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG113.NigoShikakuChosahyoShokaiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link NigoShikakuChosahyoShokaiSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0360-061 qiuxy
 */
class NigoShikakuChosahyoShokaiBuilder implements INigoShikakuChosahyoShokaiBuilder {

    private final INigoShikakuChosahyoShokaiEditor editor;

    public NigoShikakuChosahyoShokaiBuilder(INigoShikakuChosahyoShokaiEditor editor) {
        this.editor = editor;
    }

    @Override
    public NigoShikakuChosahyoShokaiSource build() {
        return ReportEditorJoiner.from(new NigoShikakuChosahyoShokaiSource()).join(editor).buildSource();
    }
}
