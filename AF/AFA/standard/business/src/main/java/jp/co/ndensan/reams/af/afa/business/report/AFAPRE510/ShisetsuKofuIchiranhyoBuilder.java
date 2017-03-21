/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE510;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE510.ShisetsuKofuIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE510_ShisetsuKofuIchiranhyo_施設交付一覧表のBuilderクラスです。
 *
 * @reamsid_L AF-0280-027 wangm
 */
public class ShisetsuKofuIchiranhyoBuilder implements IShisetsuKofuIchiranhyoBuilder {

    private final IShisetsuKofuIchiranhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ShisetsuKofuIchiranhyoEditor}
     */
    public ShisetsuKofuIchiranhyoBuilder(IShisetsuKofuIchiranhyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public ShisetsuKofuIchiranhyoSource build() {
        return ReportEditorJoiner.from(new ShisetsuKofuIchiranhyoSource()).join(editor).buildSource();
    }

}
