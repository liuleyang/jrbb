/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA111;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA111.NijuTorokuTsuchishoCommonSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {
 *
 * @link{NijuTorokuTsuchishoCommonSource}を、ソースファイルへ出力できる形へ編集します。
 */
public class NijuTorokuTsuchishoBuilder implements INijuTorokuTsuchishoBuilder {

    private final INijuTorokuTsuchishoEditor meiboEditor;

    /**
     * インスタンスを生成します。
     *
     * @param meiboEditor INijuTorokuTsuchishoEditor
     * @throws NullPointerException 引数がNullの場合
     */
    public NijuTorokuTsuchishoBuilder(INijuTorokuTsuchishoEditor meiboEditor) {
        this.meiboEditor = meiboEditor;
    }

    @Override
    public NijuTorokuTsuchishoCommonSource build() {
        return ReportEditorJoiner.from(new NijuTorokuTsuchishoCommonSource()).join(meiboEditor).buildSource();
    }

}
