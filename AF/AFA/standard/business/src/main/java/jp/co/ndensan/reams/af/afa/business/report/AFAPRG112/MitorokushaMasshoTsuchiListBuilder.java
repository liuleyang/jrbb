/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.MitorokushaMasshoTsuchiListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_AFAPRG112_MitorokushaMasshoTsuchiList_未登録者抹消通知一覧表のBuilderクラスです。
 *
 * @reamsid_L AF-0360-060 zhoujie3
 */
public class MitorokushaMasshoTsuchiListBuilder implements IMitorokushaMasshoTsuchiListBuilder {

    private final IMitorokushaMasshoTsuchiListEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link IMitorokushaMasshoTsuchiListEditor}
     */
    public MitorokushaMasshoTsuchiListBuilder(IMitorokushaMasshoTsuchiListEditor editor) {
        this.editor = editor;
    }

    @Override
    public MitorokushaMasshoTsuchiListSource build() {
        return ReportEditorJoiner.from(new MitorokushaMasshoTsuchiListSource()).join(editor).buildSource();
    }

}
