/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG117;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG117.MitorokushaMasshoTsuchiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * AFAPRG117_MitorokushaMasshoTsuchi_未登録者抹消通知のBuilderクラスです。
 *
 * @reamsid_L AF-0360-064 b_caiyf
 */
public class MitorokushaMasshoTsuchiBuilder implements IMitorokushaMasshoTsuchiBuilder {

    private final IMitorokushaMasshoTsuchiEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link IMitorokushaMasshoTsuchiEditor}
     */
    public MitorokushaMasshoTsuchiBuilder(IMitorokushaMasshoTsuchiEditor editor) {
        this.editor = editor;
    }

    @Override
    public MitorokushaMasshoTsuchiSource build() {
        return ReportEditorJoiner.from(new MitorokushaMasshoTsuchiSource()).join(editor).buildSource();
    }

}
