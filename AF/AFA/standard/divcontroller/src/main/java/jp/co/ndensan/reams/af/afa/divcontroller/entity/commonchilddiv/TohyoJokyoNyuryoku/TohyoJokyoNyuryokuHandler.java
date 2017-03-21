/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeSenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * TohyoJokyoNyuryokuDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTohyoJokyoNyuryokuDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0070-014 liss
 */
public class TohyoJokyoNyuryokuHandler {

    private static final int 投票 = 0;
    private static final int 棄権 = 1;
    private static final int 受付拒否 = 2;
    private static final int 投票取消 = 3;

    private static final List<RString> 期日前メニューID = Arrays.asList(AFAMenuId.AFAMNE1010_期日前投票.menuId(), AFAMenuId.AFAMNE7010_期日前投票.menuId());
    private static final List<RString> 当日投票メニューID = Arrays.asList(AFAMenuId.AFAMNE3010_当日投票.menuId(), AFAMenuId.AFAMNE7020_当日投票.menuId());

    private final TohyoJokyoNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 選挙人投票状況入力Div
     */
    public TohyoJokyoNyuryokuHandler(TohyoJokyoNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     * @param tohyoJokyo TohyoJokyo 投票状況
     * @param shohonNo RString 選挙NO
     */
    public void initialize(SenkyoShurui senkyoShurui, jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo tohyoJokyo, RString shohonNo) {
        div.getDgTohyoJokyo().init();
        div.getCcdTohyoJiyu().initialize(senkyoShurui, tohyoJokyo);
        div.getCcdDairiTohyo().initialize(shohonNo);
        div.getCcdKyohiJiyuNyuryoku().initialize();
        clearThisPanel();
        if (is当日投票()) {
            div.getRadSeikyusha().setDisplayNone(Boolean.TRUE);
            div.getCcdTohyoJiyu().setDisplayNone(Boolean.TRUE);
            div.getCcdKofuShisetsu().setDisplayNone(Boolean.TRUE);
        }
    }

    /**
     * 抄本番号と識別コードを渡された時のイベントメソッドです。
     *
     * @param tohyokuCode RString
     * @param shohonNo RString
     * @param shikibetsuCode ShikibetsuCode
     */
    public void initialize(RString shohonNo, ShikibetsuCode shikibetsuCode, RString tohyokuCode) {

        clearThisPanel();
        div.setTxtHdnShohonNo(shohonNo);
        if (shikibetsuCode.value().isEmpty()) {
            div.getDgTohyoJokyo().getDataSource().clear();
        } else {
            editKojinTohyoJoho(new ShohonNo(shohonNo), shikibetsuCode);
            div.getCcdDairiTohyo().initialize(shohonNo, tohyokuCode);
            div.getCcdKyohiJiyuNyuryoku().initialSetting();
        }
    }

    /**
     * 抄本番号と識別コードを渡された時のイベントメソッドです。
     *
     * @param tohyokuCode RString
     * @param shohonNo RString
     * @param shikibetsuCode ShikibetsuCode
     * @param 投票状況情報List
     * @param 投票資格情報
     */
    public void initializeDg(RString shohonNo, ShikibetsuCode shikibetsuCode, RString tohyokuCode, List<KijitsumaeTohyoJokyo> 投票状況情報List, KijitsumaeSenkyoShikaku 投票資格情報) {
        clearThisPanel();
        div.setTxtHdnShohonNo(shohonNo);
        if (shikibetsuCode.value().isEmpty()) {
            div.getDgTohyoJokyo().getDataSource().clear();
        } else {
            List<dgTohyoJokyo_Row> dataSource = new ArrayList<>();
            for (KijitsumaeTohyoJokyo 投票状況情報 : 投票状況情報List) {
                boolean has投票資格 = 投票資格情報.has投票資格(Arrays.asList(投票状況情報), FlexibleDate.getNowDate());
                dgTohyoJokyo_Row row = new dgTohyoJokyo_Row();
                row.setTxtSenkyoRyakusho(投票状況情報.get選挙略称());
                row.getTxtSenkyoNo().setValue(new Decimal(投票状況情報.get選挙番号().value()));
                row.setChkMutohyo(投票状況情報.is無投票選挙());

                row.setTohyoJokyoFlg(投票状況情報.has投票状況());
                row.setSenkyoShikakuFlg(has投票資格);

                row.setRowData(RString.EMPTY);
                if (投票状況情報.has投票状況()) {
                    row.setRowData(投票状況情報.get投票状況Entity());
                    row.setTxtTohyoJokyo(投票状況情報.get投票状況名称());
                    row.setTxtUketsukeNo(new RString(投票状況情報.get受付番号()));
                    row.getTxtUketsukeYMD().setValue(投票状況情報.get受理年月日());
                    row.getTxtUketsukeTime().setValue(投票状況情報.get受理時刻());
                    row.setTxtTohyoJiyuCode(getCode(投票状況情報.get投票事由コード()));
                    row.setTxtTohyoJiyu(投票状況情報.get投票事由コード名称());
                    row.setTxtShisetsuCode(投票状況情報.get施設コード());
                    row.setTxtShisetsu(投票状況情報.get施設名称());
                    row.setTxtSeikyuHohoCode(getCode(投票状況情報.get請求方法()));
                    row.setTxtSeikyuHoho(投票状況情報.get請求方法名称());
                    row.setChkTenjiFlag(投票状況情報.is点字フラグ());
                    row.setChkDairiFlag(投票状況情報.is代理投票有フラグ());
                    row.setTxtHojoshaShimei1(edit氏名(投票状況情報.get補助者氏名1()));
                    row.setTxtHojoshaShimei2(edit氏名(投票状況情報.get補助者氏名2()));
                    row.setTxtHojoshaShikibetsuCode1(edit識別コード(投票状況情報.get補助者識別コード1()));
                    row.setTxtHojoshaShikibetsuCode2(edit識別コード(投票状況情報.get補助者識別コード2()));
                    row.setTxtKyohiJiyu(投票状況情報.get拒否事由());
                    row.setTohyoJokyoCode(getCode(投票状況情報.get投票状況()));
                    row.getTxtTohyoUketsukeYMD().setValue(投票状況情報.get投票受付開始年月日());
                    row.setReamsClientId(投票状況情報.get端末ID());

                }

                setCheckBoxSelected(row);
                dataSource.add(row);
            }

            div.getDgTohyoJokyo().getDataSource().addAll(dataSource);
            setDgTohyoJokyo();
            TohyoJokyoManager manager = TohyoJokyoManager.createInstance();
            AfT201TohyoJokyoEntity last投票状況情報 = manager.getLast投票状況情報(new ShohonNo(shohonNo), ControlDataHolder.getClientId(), TohyoJokyo.期日前.getCode());
            if (last投票状況情報 == null) {
                div.getCcdKofuShisetsu().clear();
            } else {
                div.getCcdKofuShisetsu().initialize(last投票状況情報.getShisetsuCode());
            }
            div.getCcdDairiTohyo().initialize(shohonNo, tohyokuCode);
            div.getCcdKyohiJiyuNyuryoku().initialSetting();
        }
    }

    /**
     * 抄本番号と識別コードと選挙番号を渡された時のイベントメソッドです。
     *
     * @param tohyokuCode RString
     * @param shohonNo RString
     * @param shikibetsuCode ShikibetsuCode
     * @param 選挙番号 SenkyoNo
     */
    public void initializeBy選挙番号(RString shohonNo, ShikibetsuCode shikibetsuCode, RString tohyokuCode,
            SenkyoNo 選挙番号) {

        clearThisPanel();
        div.setTxtHdnShohonNo(shohonNo);
        if (shikibetsuCode.value().isEmpty()) {
            div.getDgTohyoJokyo().getDataSource().clear();
        } else {
            editKojinTohyoJohoBy選挙番号(new ShohonNo(shohonNo), shikibetsuCode, 選挙番号);
            div.getCcdDairiTohyo().initialize(shohonNo, tohyokuCode);
            div.getCcdKyohiJiyuNyuryoku().initialSetting();
        }
    }

    /**
     * 画面クリアのメソッドです。
     *
     */
    public void clearThisPanel() {
        div.getTohyoJokyoSelect().getRadTohyoJokyo().setSelectedIndex(0);
        set投票情報を入力不可にする(false);
        set拒否事由を入力不可にする(true);

        div.getDgTohyoJokyo().getDataSource().clear();
        set初期値();
    }

    /**
     * 共有子Divの使用状態（照会／入力）モードを設定します。
     *
     * @param readOnlySetMode 使用状態（照会／入力）
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        set投票情報を入力不可にする(readOnlySetMode);
        div.setReadOnly(readOnlySetMode);
    }

    /**
     * 共有子Divの識別コードを設定します。
     *
     * @param shikibetsuCode ShikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        div.setTxtHdnShikibetsuCode(shikibetsuCode.getColumnValue());
    }

    /**
     * 投票状況ラジオボタンを変更したときのイベントメソッドです。
     *
     * @param shikibetsuCode ShikibetsuCode 識別コード
     */
    public void changeRadTohyoJokyo(ShikibetsuCode shikibetsuCode) {

        int 投票区分 = div.getTohyoJokyoSelect().getRadTohyoJokyo().getSelectedIndex();

        switch (投票区分) {
            case 投票:
                set投票情報を入力不可にする(false);
                set拒否事由を入力不可にする(true);
                break;
            case 棄権:
                set使用不可状態にする();
                break;
            case 受付拒否:
                set使用不可状態にする();
                set拒否事由を入力不可にする(false);
                break;
            case 投票取消:
                set使用不可状態にする();
                break;
            default:
        }

        // ラジオボタンの選択状態により、グリッドのチェックボックスのOn、Offや、使用可不可をかえるべき！！
        List<dgTohyoJokyo_Row> source = div.getDgTohyoJokyo().getDataSource();
        for (dgTohyoJokyo_Row row : source) {
            setCheckBoxSelected(row);
        }
        setDgTohyoJokyo();

    }

    private void set投票情報を入力不可にする(Boolean blnShiyoFuka) {

        div.getRadSeikyusha().setDisabled(blnShiyoFuka);
        div.getChkTenjiYoshi().setDisabled(blnShiyoFuka);
        div.getTxtTohyoYMD().setReadOnly(blnShiyoFuka);
        div.getTxtTohyoTime().setReadOnly(blnShiyoFuka);
        div.getCcdTohyoJiyu().setReadOnlyMode(blnShiyoFuka);
        div.getCcdKofuShisetsu().setReadOnlyMode(blnShiyoFuka);
        div.getCcdDairiTohyo().setReadOnlyMode(blnShiyoFuka);
    }

    private void set拒否事由を入力不可にする(Boolean blnShiyoFuka) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可
        div.getCcdKyohiJiyuNyuryoku().setReadOnlyMode(blnShiyoFuka);
        div.getChkKariTohyo().setDisabled(blnShiyoFuka);
    }

    private void set初期値() {
        div.getRadSeikyusha().setSelectedKey(SeikyuHoho.直接_本人.getCode());
        div.getChkTenjiYoshi().getSelectedItems().clear();
        div.getTxtTohyoYMD().setValue(RDate.getNowDate());
//        div.getTxtTohyoTime().setValue(RTime.of(RDate.getNowTime().getHour(), RDate.getNowTime().getSecond()));
        div.getTxtTohyoTime().setValue(RTime.of(RDate.getNowTime().getHour(), RDate.getNowTime().getMinute()));
        div.getCcdTohyoJiyu().clearData();
        div.getCcdKofuShisetsu().clear();

        div.getCcdDairiTohyo().clearData();
        div.getCcdKyohiJiyuNyuryoku().clear();
        div.getChkKariTohyo().getSelectedItems().clear();

    }

    private void set使用不可状態にする() {
        set投票情報を入力不可にする(true);
        set拒否事由を入力不可にする(true);
    }

    private void editKojinTohyoJoho(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {

        TohyoJokyoManager manager = TohyoJokyoManager.createInstance();
        RString tanmatsuID = ControlDataHolder.getClientId();
        List<KijitsumaeTohyoJokyo> 投票状況情報List = manager.get投票状況情報(shohonNo, shikibetsuCode, tanmatsuID);
        KijitsumaeSenkyoShikaku 投票資格情報 = manager.get投票資格情報(shohonNo, shikibetsuCode, tanmatsuID);

        List<dgTohyoJokyo_Row> dataSource = new ArrayList<>();
        for (KijitsumaeTohyoJokyo 投票状況情報 : 投票状況情報List) {
            boolean has投票資格 = 投票資格情報.has投票資格(Arrays.asList(投票状況情報), FlexibleDate.getNowDate());
            dgTohyoJokyo_Row row = new dgTohyoJokyo_Row();
            row.setTxtSenkyoRyakusho(投票状況情報.get選挙略称());
            row.getTxtSenkyoNo().setValue(new Decimal(投票状況情報.get選挙番号().value()));
            row.setChkMutohyo(投票状況情報.is無投票選挙());

            row.setTohyoJokyoFlg(投票状況情報.has投票状況());
            row.setSenkyoShikakuFlg(has投票資格);

            row.setRowData(RString.EMPTY);
            if (投票状況情報.has投票状況()) {
                row.setRowData(投票状況情報.get投票状況Entity());
                row.setTxtTohyoJokyo(投票状況情報.get投票状況名称());
                row.setTxtUketsukeNo(new RString(投票状況情報.get受付番号()));
                row.getTxtUketsukeYMD().setValue(投票状況情報.get受理年月日());
                row.getTxtUketsukeTime().setValue(投票状況情報.get受理時刻());
                row.setTxtTohyoJiyuCode(getCode(投票状況情報.get投票事由コード()));
                row.setTxtTohyoJiyu(投票状況情報.get投票事由コード名称());
                row.setTxtShisetsuCode(投票状況情報.get施設コード());
                row.setTxtShisetsu(投票状況情報.get施設名称());
                row.setTxtSeikyuHohoCode(getCode(投票状況情報.get請求方法()));
                row.setTxtSeikyuHoho(投票状況情報.get請求方法名称());
                row.setChkTenjiFlag(投票状況情報.is点字フラグ());
                row.setChkDairiFlag(投票状況情報.is代理投票有フラグ());
                row.setTxtHojoshaShimei1(edit氏名(投票状況情報.get補助者氏名1()));
                row.setTxtHojoshaShimei2(edit氏名(投票状況情報.get補助者氏名2()));
                row.setTxtHojoshaShikibetsuCode1(edit識別コード(投票状況情報.get補助者識別コード1()));
                row.setTxtHojoshaShikibetsuCode2(edit識別コード(投票状況情報.get補助者識別コード2()));
                row.setTxtKyohiJiyu(投票状況情報.get拒否事由());
                row.setTohyoJokyoCode(getCode(投票状況情報.get投票状況()));
                row.getTxtTohyoUketsukeYMD().setValue(投票状況情報.get投票受付開始年月日());
                row.setReamsClientId(投票状況情報.get端末ID());

            }

            setCheckBoxSelected(row);
            dataSource.add(row);
        }

        div.getDgTohyoJokyo().getDataSource().addAll(dataSource);
        setDgTohyoJokyo();
        AfT201TohyoJokyoEntity last投票状況情報 = manager.getLast投票状況情報(shohonNo, ControlDataHolder.getClientId(), TohyoJokyo.期日前.getCode());
        if (last投票状況情報 == null) {
            div.getCcdKofuShisetsu().clear();
        } else {
            div.getCcdKofuShisetsu().initialize(last投票状況情報.getShisetsuCode());
        }
    }

    private void editKojinTohyoJohoBy選挙番号(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, SenkyoNo 選挙番号) {

        TohyoJokyoManager manager = TohyoJokyoManager.createInstance();
        RString tanmatsuID = ControlDataHolder.getClientId();
        List<KijitsumaeTohyoJokyo> 投票状況情報List = manager.get投票状況情報(shohonNo, shikibetsuCode, tanmatsuID);
        KijitsumaeSenkyoShikaku 投票資格情報 = manager.get投票資格情報(shohonNo, shikibetsuCode, tanmatsuID);

        List<dgTohyoJokyo_Row> dataSource = new ArrayList<>();
        KijitsumaeTohyoJokyo last投票状況情報 = null;
        for (KijitsumaeTohyoJokyo 投票状況情報 : 投票状況情報List) {
            if (!選挙番号.equals(投票状況情報.get選挙番号())) {
                continue;
            }
            boolean has投票資格 = 投票資格情報.has投票資格(Arrays.asList(投票状況情報), FlexibleDate.getNowDate());
            dgTohyoJokyo_Row row = new dgTohyoJokyo_Row();
            row.setTxtSenkyoRyakusho(投票状況情報.get選挙略称());
            row.getTxtSenkyoNo().setValue(new Decimal(投票状況情報.get選挙番号().value()));
            row.setChkMutohyo(投票状況情報.is無投票選挙());

            row.setTohyoJokyoFlg(投票状況情報.has投票状況());
            row.setSenkyoShikakuFlg(has投票資格);

            row.setRowData(RString.EMPTY);
            if (投票状況情報.has投票状況()) {
                row.setRowData(投票状況情報.get投票状況Entity());
                row.setTxtTohyoJokyo(投票状況情報.get投票状況名称());
                row.setTxtUketsukeNo(new RString(投票状況情報.get受付番号()));
                row.getTxtUketsukeYMD().setValue(投票状況情報.get受理年月日());
                row.getTxtUketsukeTime().setValue(投票状況情報.get受理時刻());
                row.setTxtTohyoJiyuCode(getCode(投票状況情報.get投票事由コード()));
                row.setTxtTohyoJiyu(投票状況情報.get投票事由コード名称());
                row.setTxtShisetsuCode(投票状況情報.get施設コード());
                row.setTxtShisetsu(投票状況情報.get施設名称());
                row.setTxtSeikyuHohoCode(getCode(投票状況情報.get請求方法()));
                row.setTxtSeikyuHoho(投票状況情報.get請求方法名称());
                row.setChkTenjiFlag(投票状況情報.is点字フラグ());
                row.setChkDairiFlag(投票状況情報.is代理投票有フラグ());
                row.setTxtHojoshaShimei1(edit氏名(投票状況情報.get補助者氏名1()));
                row.setTxtHojoshaShimei2(edit氏名(投票状況情報.get補助者氏名2()));
                row.setTxtHojoshaShikibetsuCode1(edit識別コード(投票状況情報.get補助者識別コード1()));
                row.setTxtHojoshaShikibetsuCode2(edit識別コード(投票状況情報.get補助者識別コード2()));
                row.setTxtKyohiJiyu(投票状況情報.get拒否事由());
                row.setTohyoJokyoCode(getCode(投票状況情報.get投票状況()));
                row.getTxtTohyoUketsukeYMD().setValue(投票状況情報.get投票受付開始年月日());
                row.setReamsClientId(投票状況情報.get端末ID());

                if (TohyoJokyo.期日前.getCode().equals(getCode(投票状況情報.get投票状況()))
                        && ControlDataHolder.getClientId().equals(投票状況情報.get端末ID())
                        && (last投票状況情報 == null || last投票状況情報.get受理年月日().isBefore(投票状況情報.get受理年月日()))) {
                    last投票状況情報 = 投票状況情報;
                }
            }

            setCheckBoxSelected(row);
            dataSource.add(row);
        }

        div.getDgTohyoJokyo().getDataSource().addAll(dataSource);
        setDgTohyoJokyo();
        if (last投票状況情報 == null) {
            div.getCcdKofuShisetsu().clear();
        } else {
            div.getCcdKofuShisetsu().initialize(last投票状況情報.get施設コード());
        }
    }

    private void setCheckBoxSelected(dgTohyoJokyo_Row row) {

        // 無投票選挙（選挙.無投票選挙フラグ＝True）だった場合は、非活性とする。
        // 返却された投票資格有無フラグがFALSE(投票資格なし)の場合、非活性にする。
        if (row.getChkMutohyo() || !row.getSenkyoShikakuFlg()) {
            row.setSelected(false);
            row.setSelectable(false);
            return;
        }

        int 投票区分 = div.getTohyoJokyoSelect().getRadTohyoJokyo().getSelectedIndex();
        if (!row.getTohyoJokyoFlg()) {
            switch (投票区分) {
                case 投票:
                    row.setSelected(true);
                    row.setSelectable(true);
                    break;
                case 投票取消:
                    row.setSelected(false);
                    row.setSelectable(false);
                    break;
                default:
                    row.setSelected(false);
                    row.setSelectable(true);
            }
            return;
        }

        row.setSelected(false);
        switch (jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo.toValue(row.getTohyoJokyoCode())) {
            case 返還:
                switch (投票区分) {
                    case 投票取消:
                        row.setSelectable(false);
                        break;
                    default:
                        row.setSelectable(true);
                }
                break;
            case 棄権:
                switch (投票区分) {
                    case 投票:
                    case 受付拒否:
                        row.setSelectable(false);
                        break;
                    default:
                        row.setSelectable(true);
                }
                break;
            case 期日前:
                if (is期日前()) {
                    switch (投票区分) {
                        case 投票:
                        case 投票取消:
                            row.setSelectable(true);
                            break;
                        default:
                            row.setSelectable(false);
                    }
                } else {
                    row.setSelectable(false);
                }
                break;
            case 当日:
                if (!is期日前()) {
                    switch (投票区分) {
                        case 投票:
                        case 投票取消:
                            row.setSelectable(true);
                            break;
                        default:
                            row.setSelectable(false);
                    }
                } else {
                    row.setSelectable(false);
                }
                break;
            case 受付拒否:
            case 仮投票:
                switch (投票区分) {
                    case 投票:
                    case 棄権:
                        row.setSelectable(false);
                        break;
                    default:
                        row.setSelectable(true);
                }
                break;
            default:
                row.setSelectable(false);
        }

    }

    private RString getCode(Code code) {
        if (code == null) {
            return RString.EMPTY;
        }
        return code.getColumnValue();
    }

    private RString edit氏名(AtenaMeisho 氏名) {
        if (氏名 == null) {
            return RString.EMPTY;
        }
        return 氏名.getColumnValue();
    }

    private RString edit識別コード(ShikibetsuCode 識別コード) {
        if (識別コード == null) {
            return RString.EMPTY;
        }
        return 識別コード.getColumnValue();
    }

    private boolean is期日前() {
        RString menuID = ResponseHolder.getMenuID();
        return 期日前メニューID.contains(menuID);
    }

    private void setDgTohyoJokyo() {
        DataGrid<dgTohyoJokyo_Row> dataGrid = div.getDgTohyoJokyo();

        boolean isAllDiable = true;
        for (dgTohyoJokyo_Row row : dataGrid.getDataSource()) {
            if (row.getSelectable()) {
                isAllDiable = false;
            }
        }
        dataGrid.setDisabled(isAllDiable);
    }

    private boolean is当日投票() {
        RString menuID = ResponseHolder.getMenuID();
        return 当日投票メニューID.contains(menuID);
    }

}
