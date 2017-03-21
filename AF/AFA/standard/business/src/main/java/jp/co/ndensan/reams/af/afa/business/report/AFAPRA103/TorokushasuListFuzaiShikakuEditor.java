/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoShikakuShurui;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * {@link TorokushasuListSource}を編集します。
 *
 * @reamsid_L AF-0030-031 liss
 */
public class TorokushasuListFuzaiShikakuEditor implements ITorokushasuListFuzaiShikakuEditor {

    private final TorokushasuListFuzaiShikakuItem item;
    private static final RString 帳票タイトル_郵便 = new RString("登録者数リスト（郵便投票）");
    private static final RString 帳票タイトル_船員 = new RString("登録者数リスト（洋上投票）");
    private static final RString 帳票タイトル_南極 = new RString("登録者数リスト（南極投票）");
    private final FlexibleDate 基準日;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param item {@link SenkyoninTohyoJokyoItem}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @param 基準日 FlexibleDate
     */
    public TorokushasuListFuzaiShikakuEditor(TorokushasuListFuzaiShikakuItem item, TeijiCommonJohoItem 帳票共通ヘッダー, FlexibleDate 基準日) {
        this.item = item;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        this.基準日 = 基準日;
    }

    @Override
    public TorokushasuListSource edit(TorokushasuListSource source) {
        setヘッダ(source);
        set明細(source);
        setフッタ(source);
        return source;
    }

    private void setフッタ(TorokushasuListSource source) {
        source.sakuseiJoken1 = 帳票共通ヘッダー.get作成条件();
        source.sakuseiJoken2 = 基準日.wareki().toDateString().concat(new RString("時点で出力"));
    }

    private void setヘッダ(TorokushasuListSource source) {
        source.title = get帳票タイトル();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.senkyoMei = item.get選挙名称();
        source.meisaiTitleJusho = item.get明細タイトル住所();
    }

    private void set明細(TorokushasuListSource source) {
        source.listMeisai_1 = item.get投票区コード();
        source.listMeisai_2 = item.get集計地区名();
        source.listMeisai_3 = new RStringBuilder().append(item.get有権者_男数()).toRString();
        source.listMeisai_4 = new RStringBuilder().append(item.get有権者_女数()).toRString();
        source.listMeisai_5 = new RStringBuilder().append(item.get有権者_男数() + item.get有権者_女数()).toRString();
        source.listMeisai_6 = new RStringBuilder().append(item.get表示者_男数()).toRString();
        source.listMeisai_7 = new RStringBuilder().append(item.get表示者_女数()).toRString();
        source.listMeisai_8 = new RStringBuilder().append(item.get表示者_男数() + item.get表示者_女数()).toRString();
        source.listMeisai_9 = new RStringBuilder().append(item.get公民権停止者_男数()).toRString();
        source.listMeisai_10 = new RStringBuilder().append(item.get公民権停止者_女数()).toRString();
        source.listMeisai_11 = new RStringBuilder().append(
                item.get公民権停止者_男数() + item.get公民権停止者_女数()).toRString();
        source.listMeisai_12 = new RStringBuilder().append(
                item.get有権者_男数() + item.get表示者_男数() + item.get公民権停止者_男数()).toRString();
        source.listMeisai_13 = new RStringBuilder().append(
                item.get有権者_女数() + item.get表示者_女数() + item.get公民権停止者_女数()).toRString();
        source.listMeisai_14 = new RStringBuilder().append(
                item.get有権者_男数() + item.get表示者_男数() + item.get公民権停止者_男数()
                + item.get有権者_女数() + item.get表示者_女数() + item.get公民権停止者_女数()).toRString();
    }

    private RString get帳票タイトル() {
        if (new Code(TohyoShikakuShurui.投票資格種類_郵便.getCode()).equals(item.get投票資格種類())) {
            return 帳票タイトル_郵便;
        } else if (new Code(TohyoShikakuShurui.投票資格種類_船員.getCode()).equals(item.get投票資格種類())) {
            return 帳票タイトル_船員;
        } else if (new Code(TohyoShikakuShurui.投票資格種類_南極.getCode()).equals(item.get投票資格種類())) {
            return 帳票タイトル_南極;
        } else {
            return RString.EMPTY;
        }
    }
}
