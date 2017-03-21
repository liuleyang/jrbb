/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA109;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA109.TorokuTeishishaMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 登録停止者名簿Builderです。
 *
 */
public class TorokuTeishishaMeiboBuilder implements ITorokuTeishishaMeiboBuilder {

    private final ITorokuTeishishaMeiboEditor meiboEditor;

    /**
     * コンストラクタです。
     *
     * @param meiboEditor ITorokuTeishishaMeiboEditor
     */
    public TorokuTeishishaMeiboBuilder(ITorokuTeishishaMeiboEditor meiboEditor) {
        this.meiboEditor = meiboEditor;
    }

    @Override
    public TorokuTeishishaMeiboSource build() {
        return ReportEditorJoiner.from(new TorokuTeishishaMeiboSource()).join(meiboEditor).buildSource();
    }

}
