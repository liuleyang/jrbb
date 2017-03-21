/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA105;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboKokuminSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 補正登録者名簿のShinkiTorokushaMeiboKokuminBuilderです。
 *
 * @reamsid_L AF-0360-051 zhoujie3
 */
public class ShinkiTorokushaMeiboKokuminBuilder implements IShinkiTorokushaMeiboKokuminBuilder {

    private final IShinkiTorokushaMeiboKokuminEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor {@link IShinkiTorokushaMeiboKokuminEditor}
     */
    public ShinkiTorokushaMeiboKokuminBuilder(IShinkiTorokushaMeiboKokuminEditor editor) {
        this.editor = editor;
    }

    @Override
    public ShinkiTorokushaMeiboKokuminSource build() {
        return ReportEditorJoiner.from(new ShinkiTorokushaMeiboKokuminSource()).join(editor).buildSource();
    }

}
