/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodejuri.BarCodeJuriSearchResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KofuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.BarCodeJuriDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.BarCodeJuriJohoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.BarCodeJuriNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.dgBarCodeJuriTaishosha_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理のハンドラクラスです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
public class BarCodeJuriHandler {

    private final BarCodeJuriDiv div;
    private static final RString キー_0 = new RString("0");
    private static final RString 交付時と同じ = new RString("交付時と同じ");
    private static final RString 直接 = new RString("直接");

    /**
     * コンストラクタです。
     *
     * @param div BarCodeJuriDiv
     */
    public BarCodeJuriHandler(BarCodeJuriDiv div) {
        this.div = div;
    }

    /**
     * 初期化のメソッドです。
     *
     * @return boolean
     */
    public boolean is正常に初期化する() {
        BarCodeJuriNyuryokuDiv barCodeJuriNyuryokuパネル = div.getBarCodeJuriNyuryoku();

        ViewState.setメニューID(AFAMenuId.AFAMNE2040_施設バーコード一括受理.menuId());
        barCodeJuriNyuryokuパネル.getCcdShohonNameList().initialize();
        if (barCodeJuriNyuryokuパネル.getCcdShohonNameList().getShohonListSize() == 0) {
            barCodeJuriNyuryokuパネル.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
            barCodeJuriNyuryokuパネル.getCcdShohonNameList().click_chkKakoShohon();
            barCodeJuriNyuryokuパネル.getCcdShohonNameList().initialize();
            if (barCodeJuriNyuryokuパネル.getCcdShohonNameList().getShohonListSize() == 0) {
                return false;
            } else {
                barCodeJuriNyuryokuパネル.getCcdShohonNameList().selectedShohon(barCodeJuriNyuryokuパネル.getCcdShohonNameList().get一番近い過去抄本番号());
            }
        }
        barCodeJuriNyuryokuパネル.getCcdJuriBarCode().initialize(TohyoJokyo.受理, false);

        barCodeJuriNyuryokuパネル.getDgBarCodeJuriTaishosha().init();

        setBarCodeJuriJohoパネルを初期化する();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnAccept"), true);
        return true;
    }

    private void setBarCodeJuriJohoパネルを初期化する() {
        BarCodeJuriJohoDiv barCodeJuriJohoパネル = div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho();
        barCodeJuriJohoパネル.getTxtJuriYMD().clearValue();
        barCodeJuriJohoパネル.getTxtJuriTime().clearValue();
        barCodeJuriJohoパネル.getTxtJuriYMD().setValue(RDate.getNowDate());
        barCodeJuriJohoパネル.getTxtJuriTime().setValue(RDate.getNowTime());
        barCodeJuriJohoパネル.getRadJuriHoho().setSelectedKey(キー_0);
    }

    /**
     * データをセットします。
     *
     * @param results List<BarCodeJuriSearchResult>
     */
    public void setData(List<BarCodeJuriSearchResult> results) {
        BarCodeJuriNyuryokuDiv barCodeJuriNyuryokuパネル = div.getBarCodeJuriNyuryoku();
        RString barCode = div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getBarCode();
        barCodeJuriNyuryokuパネル.getDgBarCodeJuriTaishosha().setDataSource(createKojinTohyoJokyoDataSource(results, barCode));
    }

    private List<dgBarCodeJuriTaishosha_Row> createKojinTohyoJokyoDataSource(List<BarCodeJuriSearchResult> results, RString barCode) {

        List<dgBarCodeJuriTaishosha_Row> dataSourceList = div.getBarCodeJuriNyuryoku().getDgBarCodeJuriTaishosha().getDataSource();

        for (BarCodeJuriSearchResult result : results) {
            dataSourceList.add(createDataRow(result, barCode));
        }
        return dataSourceList;
    }

    private dgBarCodeJuriTaishosha_Row createDataRow(BarCodeJuriSearchResult result, RString barCode) {
        dgBarCodeJuriTaishosha_Row row = new dgBarCodeJuriTaishosha_Row();
        row.setTxtUketsukeNo(new RString(String.valueOf(result.get受付番号())));
        row.setTxtShimei(result.get名称());
        row.setTxtSenkyoRyakusho(result.get選挙略称());
        row.setTxtSenkyoNo(result.get選挙No());
        row.getDdlTohyoJokyo().setDataSource(createDataSourceTohyoJokyo());
        row.getDdlTohyoJokyo().setSelectedValue(TohyoJokyo.受理.toRString());
        row.setTxtTohyojokyo(new jp.co.ndensan.reams.af.afa.definition.core.TohyoJokyo(result.get投票状況()).getRyakusho());
        row.setTxtSeibetsu(result.get性別());
        row.setTxtSeinengappiYMD(result.get生年月日());
        row.setTxtShisetsuName(get施設名称(result.get施設コード()));
        row.setTxtShikibetsuCode(result.get識別コード());
        row.setTxtSetaiCode(result.get世帯コード());
        row.setTxtTohyokuCode(result.get投票区コード());
        row.setChkDairiTohyo(result.is代理投票有フラグ());
        row.setTxtHojoshaShimei1(result.get補助者氏名１().getColumnValue());
        row.setTxtHojoshaShimei2(result.get補助者氏名２().getColumnValue());
        row.setTxtHojoshaShikibetsuCode1(result.get補助者識別コード１().getColumnValue());
        row.setTxtHojoshaShikibetsuCode2(result.get補助者識別コード２().getColumnValue());
        row.getTxtTohyoYMD().setValue(toRDate(result.get抄本の投票年月日()));
        row.getTxtTohyoUketsukeYMD().setValue(toRDate(result.get投票受付開始年月日()));
        row.getTxtKofuYMD().setValue(toRDate(result.get交付年月日()));
        row.setTxtKofuHoho(result.get交付方法().value());
        row.setTxtShisetsuCode(result.get施設コード());
        row.setTxtShohonNo(result.get抄本番号());
        row.setTxtTohyoJokyoEntity(result.toTohyoJokyo());
        row.setTxtBarCode(barCode);
        return row;
    }

    private static RDate toRDate(FlexibleDate 日付) {
        return (日付 != null && !FlexibleDate.EMPTY.equals(日付)) ? new RDate(日付.getYearValue(), 日付.getMonthValue(), 日付.getDayValue()) : RDate.MIN;
    }

    private RString get施設名称(RString 施設コード) {
        Shisetsu 施設 = ShisetsuManager.createInstance().get施設By施設コード(施設コード);
        return 施設 == null ? RString.EMPTY : 施設.get施設名称();
    }

    private List<KeyValueDataSource> createDataSourceTohyoJokyo() {
        List<KeyValueDataSource> source = new ArrayList<>();
        KeyValueDataSource row1 = new KeyValueDataSource(TohyoJokyo.受理.getCode(), TohyoJokyo.受理.toRString());
        source.add(row1);
        KeyValueDataSource row2 = new KeyValueDataSource(TohyoJokyo.返還.getCode(), TohyoJokyo.返還.toRString());
        source.add(row2);
        KeyValueDataSource row3 = new KeyValueDataSource(TohyoJokyo.棄権.getCode(), TohyoJokyo.棄権.toRString());
        source.add(row3);

        return source;
    }

    /**
     * 投票状況情報を更新する。
     *
     * @param rowList List<dgBarCodeJuriTaishosha_Row> rowList
     * @return boolean
     */
    public boolean updateData(List<dgBarCodeJuriTaishosha_Row> rowList) {
        TohyoJokyoManager tohyoJokyoManager = TohyoJokyoManager.createInstance();
        List<jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo> updateList = new ArrayList<>();
        List<PersonalData> personalDatas = new ArrayList<>();
        for (dgBarCodeJuriTaishosha_Row row : rowList) {
            TohyoJokyoBuilder builder = jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo.createBuilderForEdit(
                    row.getTxtTohyoJokyoEntity(),
                    new ShohonNo(row.getTxtShohonNo()),
                    new ShikibetsuCode(row.getTxtShikibetsuCode()),
                    new SenkyoNo(row.getTxtSenkyoNo()));

            if (row.getDdlTohyoJokyo().getSelectedValue().equals(TohyoJokyo.受理.toRString())) {
                updateList.add(editTohyoJokyoFor受理(builder, row));
            }
            if (row.getDdlTohyoJokyo().getSelectedValue().equals(TohyoJokyo.返還.toRString())) {
                updateList.add(editTohyoJokyoFor返還(builder));
            }
            if (row.getDdlTohyoJokyo().getSelectedValue().equals(TohyoJokyo.棄権.toRString())) {
                updateList.add(editTohyoJokyoFor棄権(builder));
            }
            personalDatas.add(PersonalData.of(new ShikibetsuCode(row.getTxtShikibetsuCode())));

        }
        tohyoJokyoManager.save投票状況(updateList);
        AccessLogger.log(AccessLogType.更新, personalDatas);
        return true;
    }

    private jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo editTohyoJokyoFor受理(
            TohyoJokyoBuilder builder,
            dgBarCodeJuriTaishosha_Row row) {

        builder.set投票状況(new Code(TohyoJokyo.受理.getCode()));
        builder.set受理年月日(div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriYMD().getValue().toFlexibleDate());
        builder.set受理時刻(div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriTime().getValue());
        if (div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getRadJuriHoho().getSelectedValue().equals(交付時と同じ)) {
            builder.set受理方法(new Code(row.getTxtKofuHoho()));
        } else if (div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getRadJuriHoho().getSelectedValue().equals(直接)) {
            builder.set受理方法(new Code(KofuHoho.直接.getCode()));
        } else {
            builder.set受理方法(new Code(KofuHoho.郵便.getCode()));
        }
        builder.set受理施設種別(get施設種別(row.getTxtShisetsuCode()));
        builder.set棄権年月日(FlexibleDate.EMPTY);
        builder.set返還年月日(FlexibleDate.EMPTY);
        builder.set代理投票有フラグ(row.getChkDairiTohyo());
        builder.set補助者識別コード1(new ShikibetsuCode(row.getTxtHojoshaShikibetsuCode1()));
        builder.set補助者氏名1(new AtenaMeisho(row.getTxtHojoshaShimei1()));
        builder.set補助者識別コード2(new ShikibetsuCode(row.getTxtHojoshaShikibetsuCode2()));
        builder.set補助者氏名2(new AtenaMeisho(row.getTxtHojoshaShimei2()));
        return builder.build();
    }

    private jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo editTohyoJokyoFor返還(TohyoJokyoBuilder builder) {
        builder.set投票状況(new Code(TohyoJokyo.返還.getCode()));
        builder.set受理年月日(FlexibleDate.EMPTY);
        builder.set受理時刻(RTime.of(00, 00));
        builder.set受理方法(Code.EMPTY);
        builder.set受理施設種別(Code.EMPTY);
        builder.set棄権年月日(FlexibleDate.EMPTY);
        builder.set返還年月日(div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriYMD().getValue().toFlexibleDate());
        builder.set代理投票有フラグ(false);
        builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        builder.set補助者氏名1(AtenaMeisho.EMPTY);
        builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        builder.set補助者氏名2(AtenaMeisho.EMPTY);
        return builder.build();
    }

    private jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo editTohyoJokyoFor棄権(TohyoJokyoBuilder builder) {
        builder.set投票状況(new Code(TohyoJokyo.棄権.getCode()));
        builder.set受理年月日(FlexibleDate.EMPTY);
        builder.set受理時刻(RTime.of(00, 00));
        builder.set受理方法(Code.EMPTY);
        builder.set受理施設種別(Code.EMPTY);
        builder.set棄権年月日(div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriYMD().getValue().toFlexibleDate());
        builder.set返還年月日(FlexibleDate.EMPTY);
        builder.set代理投票有フラグ(false);
        builder.set補助者識別コード1(ShikibetsuCode.EMPTY);
        builder.set補助者氏名1(AtenaMeisho.EMPTY);
        builder.set補助者識別コード2(ShikibetsuCode.EMPTY);
        builder.set補助者氏名2(AtenaMeisho.EMPTY);
        return builder.build();
    }

    private Code get施設種別(RString 施設コード) {
        ShisetsuManager manager = ShisetsuManager.createInstance();
        Shisetsu 施設 = manager.get施設By施設コード(施設コード);
        return 施設 == null ? Code.EMPTY : 施設.get施設種別();
    }
}
