/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 登録者数リスト（不在者投票資格者分）アイテム。
 *
 * @reamsid_L AF-0030-031 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TorokushasuListFuzaiShikakuItem {

    private Code 投票資格種類;
    private RString 選挙名称;
    private RString 投票区コード;
    private RString 明細タイトル住所;
    private RString 集計地区名;
    private int 有権者_男数;
    private int 有権者_女数;
    private int 表示者_男数;
    private int 表示者_女数;
    private int 公民権停止者_男数;
    private int 公民権停止者_女数;

    /**
     * コンストラクタです。
     *
     * @param 投票資格種類 Code
     * @param 投票区コード RString
     * @param 明細タイトル住所 RString
     * @param 集計地区名 RString
     * @param 選挙名称 RString
     * @param 有権者_男数 int
     * @param 有権者_女数 int
     * @param 表示者_男数 int
     * @param 表示者_女数 int
     * @param 公民権停止者_女数 int
     * @param 公民権停止者_男数 int
     */
    public TorokushasuListFuzaiShikakuItem(Code 投票資格種類, RString 投票区コード, RString 明細タイトル住所, RString 集計地区名, RString 選挙名称,
            int 有権者_男数, int 有権者_女数, int 表示者_男数, int 表示者_女数, int 公民権停止者_男数, int 公民権停止者_女数) {
        this.投票資格種類 = 投票資格種類;
        this.投票区コード = 投票区コード;
        this.明細タイトル住所 = 明細タイトル住所;
        this.集計地区名 = 集計地区名;
        this.選挙名称 = 選挙名称;
        this.有権者_男数 = 有権者_男数;
        this.有権者_女数 = 有権者_女数;
        this.表示者_男数 = 表示者_男数;
        this.表示者_女数 = 表示者_女数;
        this.公民権停止者_男数 = 公民権停止者_男数;
        this.公民権停止者_女数 = 公民権停止者_女数;
    }

}
