/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG103;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG103.TorokushasuListKokuminSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link TorokushasuListKokuminSource}を編集します。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
public class TorokushasuListEditor implements ITorokushasuListEditor {

    private final TorokushasuListParameter param;
    private static final RString 作成条件1 = new RString("時点で出力");
    private static final RString 作成条件2 = new RString("　　投票日：");

    /**
     * テスト用のコンストラクタです。
     *
     * @param param {@link TorokushasuListParameter}
     */
    public TorokushasuListEditor(TorokushasuListParameter param) {
        this.param = param;
    }

    @Override
    public TorokushasuListKokuminSource edit(TorokushasuListKokuminSource source) {
        setヘッダフッタ(source);
        set明細(source);
        return source;
    }

    private void setヘッダフッタ(TorokushasuListKokuminSource source) {
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

    private void set明細(TorokushasuListKokuminSource source) {
        source.listMeisai_1 = param.get投票区コード();
        source.listMeisai_2 = param.get集計地区名();
        source.listMeisai_3 = formatInt(param.get一号資格者_男数());
        source.listMeisai_4 = formatInt(param.get一号資格者_女数());
        source.listMeisai_5 = formatInt(param.get一号資格者_男数().add(param.get一号資格者_女数()));
        source.listMeisai_6 = formatInt(param.get二号資格者_男数());
        source.listMeisai_7 = formatInt(param.get二号資格者_女数());
        source.listMeisai_8 = formatInt(param.get二号資格者_男数().add(param.get二号資格者_女数()));
        Decimal 合計_男数 = param.get一号資格者_男数().add(param.get二号資格者_男数());
        Decimal 合計_女数 = param.get一号資格者_女数().add(param.get二号資格者_女数());
        source.listMeisai_9 = formatInt(合計_男数);
        source.listMeisai_10 = formatInt(合計_女数);
        source.listMeisai_11 = formatInt(合計_男数.add(合計_女数));

        source.senkyoNo = param.get選挙番号();
        source.sumType = param.getSumType();
    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }
}
