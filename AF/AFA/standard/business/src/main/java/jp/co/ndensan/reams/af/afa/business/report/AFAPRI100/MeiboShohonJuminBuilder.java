/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRI100;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRI100.MeiboShohonJuminSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-030 lis
 */
public class MeiboShohonJuminBuilder implements IMeiboShohonJuminBuilder {

    private final MeiboShohonJuminEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link MeiboShohonJuminEditor}
     */
    public MeiboShohonJuminBuilder(MeiboShohonJuminEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return MeiboShohonJuminSource
     */
    @Override
    public MeiboShohonJuminSource build() {
        return ReportEditorJoiner.from(new MeiboShohonJuminSource()).join(this.editor).buildSource();
    }

}
