/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 登録者数リスト（海区選挙）
 *
 * @reamsid_L AF-0460-033 wanghj
 */
class TorokushasuListKaikuBuilder implements ITorokushasuListKaikuBuilder {

    private final ITorokushasuListKaikuEditor editor;

    public TorokushasuListKaikuBuilder(ITorokushasuListKaikuEditor editor) {
        this.editor = editor;
    }

    @Override
    public TorokushasuListSource build() {
        return ReportEditorJoiner.from(new TorokushasuListSource()).join(editor).buildSource();
    }
}
