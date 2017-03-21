/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.NyujokenSakuseiTaishoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入場券発行（一括）Handlerクラスです。
 *
 * @reamsid_L AF-0160-010 guyq
 */
public final class NyujokenSakuseiTaishoHandler {

    private final NyujokenSakuseiTaishoDiv div;

    private static final RString ONE = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div ShohonShokaiDiv
     */
    private NyujokenSakuseiTaishoHandler(NyujokenSakuseiTaishoDiv div) {
        this.div = div;
    }

    /**
     * 在外選挙人名簿登録のHandler初期化
     *
     * @param div 在外選挙人名簿登録DIV
     * @return 在外選挙人名簿登録のHandler
     */
    public static NyujokenSakuseiTaishoHandler of(NyujokenSakuseiTaishoDiv div) {
        return new NyujokenSakuseiTaishoHandler(div);
    }

    /**
     * 世帯で複数枚作成される世帯一覧表を作成するチェックボックスのチェンジ処理のイベントメソッドです。
     *
     */
    public void set世帯で複数() {
        List<RString> 世帯で複数リスト = div.getNyujokenSentaku().getChkSetaiIchiran().getSelectedKeys();
        if (世帯で複数リスト.contains(ONE)) {
            div.getNyujokenSentaku().getTxtSetaiNinzu().setRequired(Boolean.TRUE);
        } else {
            div.getNyujokenSentaku().getTxtSetaiNinzu().setRequired(Boolean.FALSE);
        }
    }
}
