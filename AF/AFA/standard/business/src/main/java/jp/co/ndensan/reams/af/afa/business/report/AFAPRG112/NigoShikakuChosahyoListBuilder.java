/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.MitorokushaMasshoTsuchiListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * AFAPRG112_2goShikakuChosahyoList_2号資格調査一覧表のBuilderクラスです。
 *
 * @reamsid_L AF-0360-057 fulc
 */
public class NigoShikakuChosahyoListBuilder implements INigoShikakuChosahyoListBuilder {

    private final INigoShikakuChosahyoListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link INigoShikakuChosahyoListEditor}
     */
    public NigoShikakuChosahyoListBuilder(INigoShikakuChosahyoListEditor editor) {
        this.editor = editor;
    }

    @Override
    public MitorokushaMasshoTsuchiListSource build() {
        return ReportEditorJoiner.from(new MitorokushaMasshoTsuchiListSource()).join(editor).buildSource();
    }

}
