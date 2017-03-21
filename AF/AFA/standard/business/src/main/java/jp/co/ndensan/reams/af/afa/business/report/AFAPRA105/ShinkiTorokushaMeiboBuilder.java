/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA105;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link ShinkiTorokushaMeiboReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 */
public class ShinkiTorokushaMeiboBuilder implements IShinkiTorokushaMeiboBuilder {

    private final IShinkiTorokushaMeiboEditor meiboEditor;

    /**
     * インスタンスを生成します。
     *
     * @param meiboEditor IShinkiTorokushaMeiboEditor
     * @throws NullPointerException 引数がNullの場合
     */
    public ShinkiTorokushaMeiboBuilder(IShinkiTorokushaMeiboEditor meiboEditor) {
        this.meiboEditor = meiboEditor;
    }

    @Override
    public ShinkiTorokushaMeiboSource build() {
        return ReportEditorJoiner.from(new ShinkiTorokushaMeiboSource()).join(meiboEditor).buildSource();
    }

}
