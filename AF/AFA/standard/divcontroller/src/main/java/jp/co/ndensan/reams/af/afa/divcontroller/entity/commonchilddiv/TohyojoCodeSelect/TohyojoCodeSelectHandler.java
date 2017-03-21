/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoCodeSelect;

import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.Tohyojo;
import jp.co.ndensan.reams.af.afa.service.core.tohyojo.TohyojoFinder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * TohyojoCodeSelectDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTohyojoCodeSelectDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public class TohyojoCodeSelectHandler {

    private final TohyojoCodeSelectDiv div;
    private final TohyojoFinder finder;

    /**
     * コンストラクタです。
     *
     * @param div 選挙人投票状況入力Div
     */
    public TohyojoCodeSelectHandler(TohyojoCodeSelectDiv div) {
        this.div = div;
        finder = InstanceProvider.create(TohyojoFinder.class);
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param code RString
     */
    public void initialize(RString code) {

        if (code != null && !code.isEmpty()) {
            div.getTxtTohyojoCode().setValue(code);
            div.getTxtTohyojoName().setValue(get投票所名称(code));
        } else {
            div.getTxtTohyojoCode().setValue(RString.EMPTY);
            div.getTxtTohyojoName().setValue(RString.EMPTY);
        }
    }

    /**
     * 投票所コードで投票所名称を取得します。
     *
     * @param 投票所コード RString
     * @return 投票所名称 RString
     */
    public RString get投票所名称(RString 投票所コード) {
        Tohyojo 投票所 = finder.get投票所By投票所コード(投票所コード);
        return 投票所 == null ? RString.EMPTY : 投票所.get投票所名();
    }

}
