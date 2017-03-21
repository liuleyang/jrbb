/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE508;

import jp.co.ndensan.reams.af.afa.business.core.TohyoShukeiData;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508.TohyoShukeiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * {@link TohyoShukeiReportSource}を編集します。
 *
 * @reamsid_L AF-0280-025 lit
 */
public class TohyoShukeiEditor implements ITohyoShukeiEditor {

    private final TohyoShukeiData item;

    /**
     * コンストラクタです。
     *
     * @param item {@link TohyoShukeiData}
     */
    public TohyoShukeiEditor(TohyoShukeiData item) {
        this.item = item;
    }

    @Override
    public TohyoShukeiReportSource edit(TohyoShukeiReportSource source) {
        set帳票共通ヘッダー(source);
        set帳票基本情報(source);
        set帳票リストデータ情報(source);
        return source;
    }

    private void set帳票共通ヘッダー(TohyoShukeiReportSource source) {
        ZenjitsuCommonJohoItem 帳票共通ヘッダー = item.getCommonHeader();
        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時();
        source.pagecnt = new RString(String.valueOf(item.getPageCount()));
    }

    private void set帳票基本情報(TohyoShukeiReportSource source) {

        ZenjitsuPrintEntity entity = item.getEntity();
        if (item.getDataType() == TohyoShukeiReportSource.DataType.データ.getKey()
                || item.getDataType() == TohyoShukeiReportSource.DataType.小計.getKey()) {
            RString 投票区コード = entity.get選挙人名簿Entity().getTohyokuCode();
            source.tohyokuCode = 投票区コード;
            if (null != 投票区コード && !投票区コード.isEmpty()) {
                source.tohyokuMei = new RString("第").concat(投票区コード).concat(new RString("投票所"));
            }
        }
        SenkyoNo 選挙番号 = null != entity.get選挙Entity() ? entity.get選挙Entity().getSenkyoNo() : null;
        source.senkyoNo = null != 選挙番号 ? new RString(String.valueOf(選挙番号.value())) : RString.EMPTY;
        source.senkyoMei = null != entity.get選挙Entity() ? entity.get選挙Entity().getSenkyoName() : RString.EMPTY;

        AFABTE504SelectProcessParameter param = item.getParam();
        if (!param.get受理日FROM().isEmpty() || !param.get受理日TO().isEmpty()) {
            source.tohyoKikanTitle = new RString("投票日：");
            source.tohyoYmdStart = getKanjiYmd(param.get受理日FROM());
            source.kara = new RString("～");
            source.tohyoYmdEnd = getKanjiYmd(param.get受理日TO());
        }
        source.meisaiTitle = item.get明細タイトル();
        if (!param.get投票区コードFROM().isEmpty() || !param.get投票区コードTO().isEmpty()) {
            source.sakuseiJoken1 = new RString("投票区コード：")
                    .concat(param.get投票区コードFROM())
                    .concat(new RString("～"))
                    .concat(param.get投票区コードTO());
        }
        source.sakuseiJoken2 = RString.EMPTY;
    }

    private void set帳票リストデータ情報(TohyoShukeiReportSource source) {
        source.listMeisai_1 = item.get地区名称();
        source.listMeisai_2 = getFormatNumber(item.get期日前投票男数());
        source.listMeisai_3 = getFormatNumber(item.get期日前投票女数());
        source.listMeisai_4 = getFormatNumber(item.get期日前投票男数() + item.get期日前投票女数());
        source.listMeisai_5 = getFormatNumber(item.get不在者投票男数());
        source.listMeisai_6 = getFormatNumber(item.get不在者投票女数());
        source.listMeisai_7 = getFormatNumber(item.get不在者投票男数() + item.get不在者投票女数());
        source.listMeisai_8 = getFormatNumber(item.get期日前投票男数() + item.get不在者投票男数());
        source.listMeisai_9 = getFormatNumber(item.get期日前投票女数() + item.get不在者投票女数());
        source.listMeisai_10 = getFormatNumber(item.get期日前投票男数() + item.get不在者投票男数()
                + item.get期日前投票女数() + item.get不在者投票女数());
    }

    private RString getFormatNumber(int target) {
        return DecimalFormatter.toコンマ区切りRString(new Decimal(target), 0);
    }

    private RString getKanjiYmd(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return RString.EMPTY;
        }
        return target.wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString();
    }
}
