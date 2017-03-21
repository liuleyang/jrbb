/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link TorokushasuListSource}を編集します。
 *
 * @reamsid_L AF-0010-037 wangm
 */
public class TorokushasuListEditor implements ITorokushasuListEditor {

    private final TorokushasuListParam param;

    private static final RString 作成条件1 = new RString("時点で出力");
    private static final RString 作成条件2 = new RString("　　投票日：");

    /**
     * コンストラクタです。
     *
     * @param param {@link TorokushasuListParam}
     */
    public TorokushasuListEditor(TorokushasuListParam param) {
        this.param = param;
    }

    @Override
    public TorokushasuListSource edit(TorokushasuListSource source) {
        setヘッダフッタ(source);
        set明細(source);
        return source;
    }

    private void setヘッダフッタ(TorokushasuListSource source) {
        source.title = param.get帳票タイトル();
        TeijiCommonJohoItem 帳票共通ヘッダー = param.get帳票共通ヘッダー();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.senkyoMei = param.get選挙名称();
        source.meisaiTitleJusho = param.get明細タイトル住所();

        source.sakuseiJoken1 = 帳票共通ヘッダー.get作成条件();

        RStringBuilder 作成条件Builder = new RStringBuilder();
        FlexibleDate 名簿基準年月日 = param.get名簿基準年月日();
        FlexibleDate 投票日 = param.get投票日();
        if (名簿基準年月日 != null) {
            作成条件Builder.append(名簿基準年月日.wareki().toDateString());
            作成条件Builder.append(作成条件1);
        }
        if (投票日 != null) {
            作成条件Builder.append(作成条件2);
            作成条件Builder.append(投票日.wareki().toDateString());
        }
        source.sakuseiJoken2 = 作成条件Builder.toRString();
    }

    private void set明細(TorokushasuListSource source) {
        source.listMeisai_1 = param.get投票区コード();
        source.listMeisai_2 = param.get集計地区名();
        source.listMeisai_3 = formatInt(param.get有権者_男数());
        source.listMeisai_4 = formatInt(param.get有権者_女数());
        source.listMeisai_5 = formatInt(param.get有権者_男数().add(param.get有権者_女数()));
        source.listMeisai_6 = formatInt(param.get表示者_男数());
        source.listMeisai_7 = formatInt(param.get表示者_女数());
        source.listMeisai_8 = formatInt(param.get表示者_男数().add(param.get表示者_女数()));
        source.listMeisai_9 = formatInt(param.get公民権停止者_男数());
        source.listMeisai_10 = formatInt(param.get公民権停止者_女数());
        source.listMeisai_11 = formatInt(param.get公民権停止者_男数().add(param.get公民権停止者_女数()));

        Decimal 合計_男数 = param.get有権者_男数().add(param.get表示者_男数()).add(param.get公民権停止者_男数());
        Decimal 合計_女数 = param.get有権者_女数().add(param.get表示者_女数()).add(param.get公民権停止者_女数());
        source.listMeisai_12 = formatInt(合計_男数);
        source.listMeisai_13 = formatInt(合計_女数);
        source.listMeisai_14 = formatInt(合計_男数.add(合計_女数));

        source.senkyoNo = param.getSenkyoNo();
        source.sumType = param.getSumType();
    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

}
