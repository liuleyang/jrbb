/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE518;

import jp.co.ndensan.reams.af.afa.business.core.FuzaishaKanribetsuChoshoParam;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE518.FuzaishaKanribetsuChoshoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * {@link FuzaishaKanribetsuChoshoReportSource}を編集します。
 *
 * @reamsid_L AF-0280-035 lit
 */
public class FuzaishaKanribetsuChoshoEditor implements IFuzaishaKanribetsuChoshoEditor {

    private final FuzaishaKanribetsuChoshoParam param;

    /**
     * コンストラクタです。
     *
     * @param param 不在者投票管理者別の調書帳票対象クラス
     */
    public FuzaishaKanribetsuChoshoEditor(FuzaishaKanribetsuChoshoParam param) {
        this.param = param;
    }

    @Override
    public FuzaishaKanribetsuChoshoReportSource edit(FuzaishaKanribetsuChoshoReportSource source) {
        set帳票共通ヘッダー(source);
        set帳票基本情報(source);
        set帳票明細情報(source);
        return source;
    }

    private void set帳票共通ヘッダー(FuzaishaKanribetsuChoshoReportSource source) {
        ZenjitsuCommonJohoItem 帳票共通ヘッダー = param.getCommonHeader();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
    }

    private void set帳票基本情報(FuzaishaKanribetsuChoshoReportSource source) {
        ZenjitsuPrintEntity entity = param.getEntity();
        source.senkyoNo = new RString(String.valueOf(entity.get選挙Entity().getSenkyoNo().value()));
        source.senkyoMei = entity.get選挙Entity().getSenkyoName();

        AFABTE504SelectProcessParameter parameter = param.getParam();
        if (!parameter.get投票区コードFROM().isEmpty() || !parameter.get投票区コードTO().isEmpty()) {
            source.sakuseiJoken1 = new RString("投票区コード：")
                    .concat(parameter.get投票区コードFROM())
                    .concat(new RString("～"))
                    .concat(parameter.get投票区コードTO());
        }
        source.sakuseiJoken2 = RString.EMPTY;
    }

    private void set帳票明細情報(FuzaishaKanribetsuChoshoReportSource source) {
        source.listMeisai_1 = param.get投票区コード();
        source.listMeisai_2 = getFormatNumber(param.get属する市町村数());
        source.listMeisai_3 = getFormatNumber(param.get業務地又は旅行地数());
        source.listMeisai_4 = getFormatNumber(param.get船長数());
        source.listMeisai_5 = getFormatNumber(param.get施設数());
        source.listMeisai_6 = getFormatNumber(param.get監獄数());
        source.listMeisai_7 = getFormatNumber(param.get少年院数());
        source.listMeisai_8 = getFormatNumber(param.get特定国外数());
        source.listMeisai_9 = getFormatNumber(param.get合計());
    }

    private RString getFormatNumber(Decimal target) {
        return DecimalFormatter.toコンマ区切りRString(target, 0);
    }
}
