/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票日前日関連帳票共通情報クラス
 *
 * @reamsid_L AF-0280-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ZenjitsuCommonJohoItem {

    private RString 市町村名;
    private RString 市町村コード;
    private RString 作成日時;

    /**
     * コンストラクタです。
     */
    public ZenjitsuCommonJohoItem() {
    }
}
