/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG116;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG116.NigoShikakuKohoshaListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * AFAPRG116_2goShikakuKohoshaList_2号資格候補者一覧表のBuilderクラスです。
 *
 * @reamsid_L AF-0360-063 fulc
 */
public class NigoShikakuKohoshaListBuilder implements INigoShikakuKohoshaListBuilder {

    private final INigoShikakuKohoshaListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link INigoShikakuKohoshaListEditor}
     */
    public NigoShikakuKohoshaListBuilder(INigoShikakuKohoshaListEditor editor) {
        this.editor = editor;
    }

    @Override
    public NigoShikakuKohoshaListSource build() {
        return ReportEditorJoiner.from(new NigoShikakuKohoshaListSource()).join(editor).buildSource();
    }
}
