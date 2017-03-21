/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE503;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE503.TohyoshaListSenkyoAllSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 投票者一覧表
 *
 * @reamsid_L AF-0270-034 wangl
 */
public class TohyoshaListSenkyoAllBuilder implements ITohyoshaListSenkyoAllBuilder {

    private final TohyoshaListSenkyoAllEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link TohyoshaListSenkyoAllEditor}
     */
    public TohyoshaListSenkyoAllBuilder(TohyoshaListSenkyoAllEditor editor) {
        this.editor = editor;
    }

    /**
     * ソース取得。
     *
     * @return TohyoshaListSenkyoAllSource
     */
    @Override
    public TohyoshaListSenkyoAllSource build() {
        return ReportEditorJoiner.from(new TohyoshaListSenkyoAllSource()).join(this.editor).buildSource();
    }
}
