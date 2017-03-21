/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.af.afa.business.core.TorokushasuListKaikuParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 登録者数リスト（海区選挙）
 *
 * @reamsid_L AF-0460-033 wanghj
 */
public class TorokushasuListKaikuEditor implements ITorokushasuListKaikuEditor {

    private final TorokushasuListKaikuParam data;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    private final RString 帳票タイトル = new RString("登録者数リスト（海区選挙）");
    private final RString 作成条件2 = new RString("時点で出力");

    /**
     * コンストラクタです。
     *
     * @param data TorokushasuListKaikuParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TorokushasuListKaikuEditor(TorokushasuListKaikuParam data, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.data = data;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    @Override
    public TorokushasuListSource edit(TorokushasuListSource source) {
        setヘッダフッタ(source);
        set明細(source);
        return source;
    }

    private void setヘッダフッタ(TorokushasuListSource source) {
        source.title = 帳票タイトル;
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.sakuseiJoken1 = 帳票共通ヘッダー.get作成条件();
        if (null != data.get登録者情報()) {
            source.meisaiTitleJusho = data.get登録者情報().get明細タイトル住所();
            source.sakuseiJoken2 = null == data.get登録者情報().get基準日() ? RString.EMPTY : data.get登録者情報().get基準日().wareki().toDateString().concat(作成条件2);
        }
    }

    private void set明細(TorokushasuListSource source) {
        if (null != data.get登録者情報()) {
            source.listMeisai_1 = data.get登録者情報().get投票区コード();
            source.listMeisai_2 = data.get登録者情報().get集計地区名();
            source.senkyoNo = data.get登録者情報().get選挙番号();
            source.sumType = data.get登録者情報().get合計タイプ();
        }
        if (null != data.get合計情報()) {
            source.listMeisai_3 = formatInt(null == data.get合計情報().get有権者_男数() ? Decimal.ZERO : data.get合計情報().get有権者_男数());
            source.listMeisai_4 = formatInt(null == data.get合計情報().get有権者_女数() ? Decimal.ZERO : data.get合計情報().get有権者_女数());
            source.listMeisai_5 = formatInt(null == data.get合計情報().get有権者_男数() ? Decimal.ZERO : data.get合計情報().get有権者_男数()
                    .add(null == data.get合計情報().get有権者_女数() ? Decimal.ZERO : data.get合計情報().get有権者_女数()));
            source.listMeisai_6 = formatInt(data.get合計情報().get表示者_男数());
            source.listMeisai_7 = formatInt(data.get合計情報().get表示者_女数());
            source.listMeisai_8 = formatInt(null == data.get合計情報().get表示者_男数() ? Decimal.ZERO : data.get合計情報().get表示者_男数()
                    .add(null == data.get合計情報().get表示者_女数() ? Decimal.ZERO : data.get合計情報().get表示者_女数()));
            source.listMeisai_9 = formatInt(data.get合計情報().get公民権停止者_男数());
            source.listMeisai_10 = formatInt(data.get合計情報().get公民権停止者_女数());
            source.listMeisai_11 = formatInt(null == data.get合計情報().get公民権停止者_男数() ? Decimal.ZERO : data.get合計情報().get公民権停止者_男数()
                    .add(null == data.get合計情報().get公民権停止者_女数() ? Decimal.ZERO : data.get合計情報().get公民権停止者_女数()));

            Decimal 合計_男数 = null == data.get合計情報().get有権者_男数() ? Decimal.ZERO : data.get合計情報().get有権者_男数()
                    .add(null == data.get合計情報().get表示者_男数() ? Decimal.ZERO : data.get合計情報().get表示者_男数())
                    .add(null == data.get合計情報().get公民権停止者_男数() ? Decimal.ZERO : data.get合計情報().get公民権停止者_男数());
            Decimal 合計_女数 = null == data.get合計情報().get有権者_女数() ? Decimal.ZERO : data.get合計情報().get有権者_女数()
                    .add(null == data.get合計情報().get表示者_女数() ? Decimal.ZERO : data.get合計情報().get表示者_女数())
                    .add(null == data.get合計情報().get公民権停止者_女数() ? Decimal.ZERO : data.get合計情報().get公民権停止者_女数());
            source.listMeisai_12 = formatInt(合計_男数);
            source.listMeisai_13 = formatInt(合計_女数);
            source.listMeisai_14 = formatInt(合計_男数.add(合計_女数));
        }
    }

    private RString formatInt(Decimal trgt) {
        if (null == trgt) {
            return new RString("0");
        }
        return new RString(trgt.toString("#,##0"));
    }

}
