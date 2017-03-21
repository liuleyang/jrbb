/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE521;

import jp.co.ndensan.reams.af.afa.business.core.JikanbetsuTohyoshaParam;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE521.JikanbetsuTohyoshaReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * {@link JikanbetsuTohyoshaReportSource}を編集します。
 *
 * @reamsid_L AF-0290-037 lit
 */
public class JikanbetsuTohyoshaEditor implements IJikanbetsuTohyoshaEditor {

    private final JikanbetsuTohyoshaParam data;

    /**
     * コンストラクタです。
     *
     * @param data 時間別投票者集計表帳票対象クラス
     */
    public JikanbetsuTohyoshaEditor(JikanbetsuTohyoshaParam data) {
        this.data = data;
    }

    @Override
    public JikanbetsuTohyoshaReportSource edit(JikanbetsuTohyoshaReportSource source) {
        set帳票共通ヘッダー(source);
        set帳票基本情報(source);
        set帳票明細情報(source);
        return source;
    }

    private void set帳票共通ヘッダー(JikanbetsuTohyoshaReportSource source) {
        ZenjitsuCommonJohoItem 帳票共通ヘッダー = data.getCommonHeader();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void set帳票基本情報(JikanbetsuTohyoshaReportSource source) {
        source.senkyoMei = data.get選挙名();
        source.senkyoNo = data.get選挙番号();
    }

    private void set帳票明細情報(JikanbetsuTohyoshaReportSource source) {
        source.subTitle = data.getサブタイトル();
        source.jikantai1 = data.get時間帯1();
        source.jikantai2 = data.get時間帯2();
        source.jikantai3 = data.get時間帯3();
        source.jikantai4 = data.get時間帯4();
        source.jikantai5 = data.get時間帯5();
        source.listMeisai_1 = data.get投票区コード();
        source.listMeisai_2 = data.get投票所名称();
        source.listMeisai_3 = getFormatNumber(data.get時間帯1男数());
        source.listMeisai_4 = getFormatNumber(data.get時間帯1女数());
        source.listMeisai_5 = getFormatNumber(data.get時間帯1計数());
        source.listMeisai_6 = getFormatNumber(data.get時間帯2男数());
        source.listMeisai_7 = getFormatNumber(data.get時間帯2女数());
        source.listMeisai_8 = getFormatNumber(data.get時間帯2計数());
        source.listMeisai_9 = getFormatNumber(data.get時間帯3男数());
        source.listMeisai_10 = getFormatNumber(data.get時間帯3女数());
        source.listMeisai_11 = getFormatNumber(data.get時間帯3計数());
        source.listMeisai_12 = getFormatNumber(data.get時間帯4男数());
        source.listMeisai_13 = getFormatNumber(data.get時間帯4女数());
        source.listMeisai_14 = getFormatNumber(data.get時間帯4計数());
        source.listMeisai_15 = getFormatNumber(data.get時間帯5男数());
        source.listMeisai_16 = getFormatNumber(data.get時間帯5女数());
        source.listMeisai_17 = getFormatNumber(data.get時間帯5計数());
    }

    private RString getFormatNumber(Decimal target) {
        return null == target ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(target, 0);
    }
}
