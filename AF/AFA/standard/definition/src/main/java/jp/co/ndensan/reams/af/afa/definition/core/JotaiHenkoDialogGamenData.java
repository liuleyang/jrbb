/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 状態変更ダイアログ画面データ用のクラスです。
 *
 * @reamsid_L AF-0110-010 qiuxy
 */
public class JotaiHenkoDialogGamenData implements Serializable {

    private final List<RString> 投票状況リスト;

    /**
     * コンストラクタです。
     *
     *
     * @param 投票状況リスト List<RString>
     */
    public JotaiHenkoDialogGamenData(List<RString> 投票状況リスト) {

        this.投票状況リスト = 投票状況リスト;
    }

    /**
     * 投票状況リストのgetメソッドです。
     *
     * @return List<RString>
     */
    public List<RString> get投票状況リスト() {
        return 投票状況リスト;
    }

}
