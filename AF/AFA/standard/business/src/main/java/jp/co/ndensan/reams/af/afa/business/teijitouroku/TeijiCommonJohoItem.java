/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.teijitouroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙帳票共通情報クラス
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TeijiCommonJohoItem {

    /**
     * コンストラクタです。
     *
     * @param 市町村名 RString
     * @param 市町村コード RString
     * @param 作成日時 RString
     */
    public TeijiCommonJohoItem(RString 市町村名, RString 市町村コード, RString 作成日時) {
        this.市町村名 = 市町村名;
        this.市町村コード = 市町村コード;
        this.作成日時 = 作成日時;
    }

    private RString 市町村名;
    private RString 市町村コード;
    private RString 作成日時;
    private RString 選挙名称;
    private RString 帳票タイトル;
    private RString 帳票ID;
    private RString 出力順;
    private RString 作成条件;
    private RString 都道府県区分;
}
