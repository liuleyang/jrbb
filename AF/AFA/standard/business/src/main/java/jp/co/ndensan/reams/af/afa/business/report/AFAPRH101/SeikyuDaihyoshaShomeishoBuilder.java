/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRH101;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRH101.SeikyuDaihyoshaShomeishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 請求代表者証明書
 *
 * @reamsid_L AF-0140-030 wangh
 */
public class SeikyuDaihyoshaShomeishoBuilder implements ISeikyuDaihyoshaShomeishoBuilder {

    private final SeikyuDaihyoshaShomeishoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link TohyoJiyuChoshoEditor}
     */
    public SeikyuDaihyoshaShomeishoBuilder(SeikyuDaihyoshaShomeishoEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return TohyoJiyuChoshoSource
     */
    @Override
    public SeikyuDaihyoshaShomeishoSource build() {
        return ReportEditorJoiner.from(new SeikyuDaihyoshaShomeishoSource()).join(this.editor).buildSource();
    }

}
