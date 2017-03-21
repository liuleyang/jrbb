/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodetojitsu.BarCodeTojitsuResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.BarCodeTojitsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.dgBarCodeTojitsuTaishosha_Row;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * バーコード一括当日投票入力のHandlerクラス
 *
 * @reamsid_L AF-0115-010 xul
 */
public class BarCodeTojitsuHandler {

    private final BarCodeTojitsuDiv div;
    private final RString 投票資格_有 = new RString("1");
    private final RString 投票資格_無 = new RString("0");
    private final Code 投票状況_当日 = new Code("7");
    private final Code 期日前不在者区分_当日投票 = new Code("3");
    private static final int 受付番号_0 = 0;
    private static final SenkyoNo 選挙番号_1 = new SenkyoNo(1);
    private static final SenkyoNo 選挙番号_2 = new SenkyoNo(2);
    private static final SenkyoNo 選挙番号_3 = new SenkyoNo(3);
    private static final SenkyoNo 選挙番号_4 = new SenkyoNo(4);
    private static final SenkyoNo 選挙番号_5 = new SenkyoNo(5);
    private static final SenkyoNo 選挙番号_6 = new SenkyoNo(6);
    private static final SenkyoNo 選挙番号_7 = new SenkyoNo(7);
    private static final SenkyoNo 選挙番号_8 = new SenkyoNo(8);
    private static final SenkyoNo 選挙番号_9 = new SenkyoNo(9);
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString KEY3 = new RString("3");
    private static final RString KEY4 = new RString("4");
    private static final RString KEY5 = new RString("5");
    private static final RString KEY6 = new RString("6");
    private static final RString KEY7 = new RString("7");
    private static final RString KEY8 = new RString("8");
    private static final RString KEY9 = new RString("9");
    private static final RString コロン = new RString("：");
    private static final RString 無投票 = new RString("（無投票）");
    private static final RString 全角スペース = RString.FULL_SPACE;
    private final RString 開閉時刻 = new RString("00:00");

    /**
     * コンストラクタです。
     *
     * @param div BarCodeTojitsuDiv
     */
    public BarCodeTojitsuHandler(BarCodeTojitsuDiv div) {
        this.div = div;
    }

    /**
     * グリッドの内容をクリア
     *
     */
    public void clearThisPanel() {
        div.getDgBarCodeTojitsuTaishosha().getDataSource().clear();
    }

    /**
     * １～N表示する列の数が決定する
     *
     * @param shohonNo RString
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> setDatasource_選挙(RString shohonNo) {
        ResponseData<BarCodeTojitsuDiv> response = new ResponseData<>();
        List<Senkyo> 選挙list = SenkyoManager.createInstance().get選挙By抄本番号(new ShohonNo(shohonNo));
        if (null != 選挙list && !選挙list.isEmpty()) {
            div.getLblSenkyoRyakuName().setText(get略称(選挙list));
        }
        response.data = div;
        return response;
    }

    private RString get略称(List<Senkyo> 選挙list) {
        RString 選挙略称label = new RString("");
        for (int i = 0; i < 選挙list.size(); i++) {
            RString 選挙番号 = new RString(選挙list.get(i).get選挙番号().toString());
            RString 選挙略称 = 選挙list.get(i).get選挙略称();
            RString 無投票選挙 = 選挙list.get(i).is無投票選挙フラグ() ? 無投票 : RString.EMPTY;
            選挙略称label = 選挙略称label.concat(選挙番号).concat(コロン).concat(選挙略称).concat(無投票選挙).concat(全角スペース);
        }
        return 選挙略称label;
    }

    /**
     * １～Nチェックボックス`をONが決定する
     *
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> チェックボックスon() {
        List<RString> key1 = new ArrayList<>();
        key1.add(KEY1);
        List<RString> key2 = new ArrayList<>();
        key2.add(KEY2);
        List<RString> key3 = new ArrayList<>();
        key3.add(KEY3);
        List<RString> key4 = new ArrayList<>();
        key4.add(KEY4);
        List<RString> key5 = new ArrayList<>();
        key5.add(KEY5);
        List<RString> key6 = new ArrayList<>();
        key6.add(KEY6);
        List<RString> key7 = new ArrayList<>();
        key7.add(KEY7);
        List<RString> key8 = new ArrayList<>();
        key8.add(KEY8);
        List<RString> key9 = new ArrayList<>();
        key9.add(KEY9);
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo1().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo1().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo1().setSelectedItemsByKey(key1);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo2().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo2().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo2().setSelectedItemsByKey(key2);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo3().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo3().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo3().setSelectedItemsByKey(key3);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo4().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo4().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo4().setSelectedItemsByKey(key4);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo5().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo5().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo5().setSelectedItemsByKey(key5);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo6().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo6().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo6().setSelectedItemsByKey(key6);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo7().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo7().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo7().setSelectedItemsByKey(key7);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo8().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo8().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo8().setSelectedItemsByKey(key8);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo9().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo9().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo9().setSelectedItemsByKey(key9);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * １～Nチェックボックス`をOFFが決定する
     *
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> チェックボックスoff() {
        List<RString> key0 = new ArrayList<>();
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo1().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo1().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo1().setSelectedItemsByKey(key0);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo2().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo2().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo2().setSelectedItemsByKey(key0);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo3().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo3().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo3().setSelectedItemsByKey(key0);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo4().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo4().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo4().setSelectedItemsByKey(key0);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo5().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo5().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo5().setSelectedItemsByKey(key0);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo6().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo6().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo6().setSelectedItemsByKey(key0);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo7().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo7().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo7().setSelectedItemsByKey(key0);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo8().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo8().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo8().setSelectedItemsByKey(key0);
        }
        if (!div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo9().isDisabled()
                && !div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo9().isDisplayNone()) {
            div.getDgBarCodeTojitsuTaishosha().getClickedItem().getChkSenkyo9().setSelectedItemsByKey(key0);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 投票資格があるかどうかを返します。
     *
     * @param 選挙人名簿データ List<BarCodeTojitsuResult>
     * @return 投票資格があるかどうか
     */
    public RString get投票資格(List<BarCodeTojitsuResult> 選挙人名簿データ) {
        for (int i = 0; i < 選挙人名簿データ.size(); i++) {
            Code 選挙資格 = 選挙人名簿データ.get(i).get選挙資格区分();
            RString 選挙資格Str = null != 選挙資格 ? 選挙資格.value() : RString.EMPTY;
            if (SennkyoSikakuKubun.資格なし.value().equals(選挙資格Str)) {
                return 投票資格_無;
            }
        }
        return 投票資格_有;
    }

    /**
     * 投票状況情報をセットする
     *
     * @param 選挙人名簿データ List<BarCodeTojitsuResult>
     * @return ResponseData<BarCodeTojitsuDiv>
     */
    public ResponseData<BarCodeTojitsuDiv> set投票対象者一覧(List<BarCodeTojitsuResult> 選挙人名簿データ) {
        List<dgBarCodeTojitsuTaishosha_Row> list = div.getDgBarCodeTojitsuTaishosha().getDataSource();
        BarCodeTojitsuResult tohyoJokyoData = 選挙人名簿データ.get(0);
        dgBarCodeTojitsuTaishosha_Row row = new dgBarCodeTojitsuTaishosha_Row();
        row.setTxtShimei(tohyoJokyoData.get名称());
        row.setTxtSeibetsu(tohyoJokyoData.get性別());
        row.setTxtJusho(set住所(tohyoJokyoData.get住所(), tohyoJokyoData.get番地(), tohyoJokyoData.get方書()));
        row.getTxtSeinengappi().setValue(set生年月日(tohyoJokyoData.get住民種別(), tohyoJokyoData.get生年月日()));
        row.setTxtJuminShubetsu(set住民種別(tohyoJokyoData.get住民状態コード()));
        RString 識別コード = tohyoJokyoData.get識別コード();
        row.setTxtShikibetsuCode(null == 識別コード ? RString.EMPTY : 識別コード);
        RString 世帯コード = tohyoJokyoData.get世帯コード();
        row.setTxtSeitaiCode(null == 世帯コード ? RString.EMPTY : 世帯コード);
        RString 行政区コード = tohyoJokyoData.get行政区コード();
        row.setTxtGyoseikuCode(null == 行政区コード ? RString.EMPTY : 行政区コード);
        row.setTxtSenkyoShikaku(set選挙資格(tohyoJokyoData.get選挙種類(), tohyoJokyoData.get選挙資格区分()));
        row.getTxtHyojiYmd().setValue(tohyoJokyoData.get表示年月日());
        row.getTxtMassyoYmd().setValue(tohyoJokyoData.get抹消年月日());
        row.setTxtTohyokuCode(tohyoJokyoData.get投票区コード());
        row.setTxtPage(new RString(tohyoJokyoData.get頁()));
        row.setTxtGyo(new RString(tohyoJokyoData.get行()));
        row.setHdnShohonNo(tohyoJokyoData.get抄本番号());
        row.setHdnShikibetsuCode(tohyoJokyoData.get識別コード());
        row.setHdnBarCode(div.getBarCodeTojitsuNyuryoku().getCcdNyujokenBarCode().getBarCode());
        setチェックボックス(row, 選挙人名簿データ);
        list.add(row);
        set列数(選挙人名簿データ);
        div.getDgBarCodeTojitsuTaishosha().setDataSource(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 投票状況情報を更新する
     *
     * @param 投票状況 TohyoJokyo
     * @return 投票状況 TohyoJokyoBuilder
     */
    public TohyoJokyoBuilder edit投票状況(TohyoJokyo 投票状況) {
        return 投票状況.createBuilderForEdit()
                .set交付年月日(FlexibleDate.EMPTY)
                .set交付方法(Code.EMPTY)
                .set交付時刻(new RTime(開閉時刻))
                .set受付番号(受付番号_0)
                .set代理投票有フラグ(false)
                .set受取年月日(FlexibleDate.EMPTY)
                .set受理年月日(FlexibleDate.EMPTY)
                .set受理方法(Code.EMPTY)
                .set受理施設種別(Code.EMPTY)
                .set受理時刻(new RTime(開閉時刻))
                .set投票事由コード(Code.EMPTY)
                .set投票状況(投票状況_当日)
                .set拒否事由(RString.EMPTY)
                .set施設コード(RString.EMPTY)
                .set期日前不在者区分(期日前不在者区分_当日投票)
                .set棄権年月日(FlexibleDate.EMPTY)
                .set点字フラグ(false)
                .set補助者氏名1(AtenaMeisho.EMPTY)
                .set補助者氏名2(AtenaMeisho.EMPTY)
                .set証明書出力フラグ(false)
                .set請求年月日(FlexibleDate.EMPTY)
                .set請求方法(Code.EMPTY)
                .set返還年月日(FlexibleDate.EMPTY)
                .set送致済フラグ(false);
    }

    private RString set住所(RString 住所, RString 番地, RString 方書) {
        RStringBuilder 住所文字列 = new RStringBuilder();
        if (null != 住所) {
            住所文字列.append(住所.trimEnd());
        }
        if (null != 番地) {
            住所文字列.append(番地.trimStart());
        }
        住所文字列.append(RString.FULL_SPACE);
        if (null != 方書) {
            住所文字列.append(方書);
        }
        return 住所文字列.toRString();
    }

    private RDate set生年月日(RString 住民種別, RString 生年月日) {
        if (null != 住民種別
                && null != 生年月日
                && !生年月日.isEmpty()) {
            if (住民種別.equals(JuminShubetsu.日本人.getCode())) {
                return new RDate(生年月日.toString());
            } else if (住民種別.equals(JuminShubetsu.外国人.getCode())) {
                return new RDate(生年月日.toString());
            }
        }
        return null;
    }

    private RString set住民種別(RString 住民状態) {
        if (null == 住民状態) {
            return RString.EMPTY;
        } else {
            return JuminJotai.toValue(住民状態).住民状態略称();
        }
    }

    private RString set選挙資格(Code 選挙種類, Code 選挙資格区分) {
        if (!new Code(SenkyoShurui.憲法改正国民投票.getCode()).equals(選挙種類)) {
            return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), 選挙資格区分);
        } else {
            return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu(), 選挙資格区分);
        }
    }

    /**
     * 選挙番号を取得する
     *
     * @param row dgBarCodeTojitsuTaishosha_Row
     * @return 選挙番号 SenkyoNo
     */
    public List<SenkyoNo> get選択された選挙番号(dgBarCodeTojitsuTaishosha_Row row) {
        List<SenkyoNo> list = new ArrayList<>();
        if (row.getChkSenkyo1().isAllSelected()) {
            list.add(選挙番号_1);
        }
        if (row.getChkSenkyo2().isAllSelected()) {
            list.add(選挙番号_2);
        }
        if (row.getChkSenkyo3().isAllSelected()) {
            list.add(選挙番号_3);
        }
        if (row.getChkSenkyo4().isAllSelected()) {
            list.add(選挙番号_4);
        }
        if (row.getChkSenkyo5().isAllSelected()) {
            list.add(選挙番号_5);
        }
        if (row.getChkSenkyo6().isAllSelected()) {
            list.add(選挙番号_6);
        }
        if (row.getChkSenkyo7().isAllSelected()) {
            list.add(選挙番号_7);
        }
        if (row.getChkSenkyo8().isAllSelected()) {
            list.add(選挙番号_8);
        }
        if (row.getChkSenkyo9().isAllSelected()) {
            list.add(選挙番号_9);
        }
        return list;
    }

    private dgBarCodeTojitsuTaishosha_Row setチェックボックス(dgBarCodeTojitsuTaishosha_Row row, List<BarCodeTojitsuResult> 選挙人名簿データ) {
        RString 投票状況名称_1 = get投票状況_選挙番号(選挙番号_1, 選挙人名簿データ);
        RString 投票状況名称_2 = get投票状況_選挙番号(選挙番号_2, 選挙人名簿データ);
        RString 投票状況名称_3 = get投票状況_選挙番号(選挙番号_3, 選挙人名簿データ);
        RString 投票状況名称_4 = get投票状況_選挙番号(選挙番号_4, 選挙人名簿データ);
        RString 投票状況名称_5 = get投票状況_選挙番号(選挙番号_5, 選挙人名簿データ);
        RString 投票状況名称_6 = get投票状況_選挙番号(選挙番号_6, 選挙人名簿データ);
        RString 投票状況名称_7 = get投票状況_選挙番号(選挙番号_7, 選挙人名簿データ);
        RString 投票状況名称_8 = get投票状況_選挙番号(選挙番号_8, 選挙人名簿データ);
        RString 投票状況名称_9 = get投票状況_選挙番号(選挙番号_9, 選挙人名簿データ);
        List<KeyValueDataSource> keyList0 = new ArrayList<>();
        keyList0.add(new KeyValueDataSource(KEY0, RString.EMPTY));
        row.getChkAll().setDataSource(keyList0);
        List<KeyValueDataSource> keyList1 = new ArrayList<>();
        keyList1.add(new KeyValueDataSource(KEY1, null == 投票状況名称_1 ? RString.EMPTY : 投票状況名称_1));
        row.getChkSenkyo1().setDataSource(keyList1);
        List<KeyValueDataSource> keyList2 = new ArrayList<>();
        keyList2.add(new KeyValueDataSource(KEY2, null == 投票状況名称_2 ? RString.EMPTY : 投票状況名称_2));
        row.getChkSenkyo2().setDataSource(keyList2);
        List<KeyValueDataSource> keyList3 = new ArrayList<>();
        keyList3.add(new KeyValueDataSource(KEY3, null == 投票状況名称_3 ? RString.EMPTY : 投票状況名称_3));
        row.getChkSenkyo3().setDataSource(keyList3);
        List<KeyValueDataSource> keyList4 = new ArrayList<>();
        keyList4.add(new KeyValueDataSource(KEY4, null == 投票状況名称_4 ? RString.EMPTY : 投票状況名称_4));
        row.getChkSenkyo4().setDataSource(keyList4);
        List<KeyValueDataSource> keyList5 = new ArrayList<>();
        keyList5.add(new KeyValueDataSource(KEY5, null == 投票状況名称_5 ? RString.EMPTY : 投票状況名称_5));
        row.getChkSenkyo5().setDataSource(keyList5);
        List<KeyValueDataSource> keyList6 = new ArrayList<>();
        keyList6.add(new KeyValueDataSource(KEY6, null == 投票状況名称_6 ? RString.EMPTY : 投票状況名称_6));
        row.getChkSenkyo6().setDataSource(keyList6);
        List<KeyValueDataSource> keyList7 = new ArrayList<>();
        keyList7.add(new KeyValueDataSource(KEY7, null == 投票状況名称_7 ? RString.EMPTY : 投票状況名称_7));
        row.getChkSenkyo7().setDataSource(keyList7);
        List<KeyValueDataSource> keyList8 = new ArrayList<>();
        keyList8.add(new KeyValueDataSource(KEY8, null == 投票状況名称_8 ? RString.EMPTY : 投票状況名称_8));
        row.getChkSenkyo8().setDataSource(keyList8);
        List<KeyValueDataSource> keyList9 = new ArrayList<>();
        keyList9.add(new KeyValueDataSource(KEY9, null == 投票状況名称_9 ? RString.EMPTY : 投票状況名称_9));
        row.getChkSenkyo9().setDataSource(keyList9);
        row.getChkSenkyo1().setDisabled(null != 投票状況名称_1);
        row.getChkSenkyo2().setDisabled(null != 投票状況名称_2);
        row.getChkSenkyo3().setDisabled(null != 投票状況名称_3);
        row.getChkSenkyo4().setDisabled(null != 投票状況名称_4);
        row.getChkSenkyo5().setDisabled(null != 投票状況名称_5);
        row.getChkSenkyo6().setDisabled(null != 投票状況名称_6);
        row.getChkSenkyo7().setDisabled(null != 投票状況名称_7);
        row.getChkSenkyo8().setDisabled(null != 投票状況名称_8);
        row.getChkSenkyo9().setDisabled(null != 投票状況名称_9);
        for (BarCodeTojitsuResult barCodeTojitsuResult : 選挙人名簿データ) {
            if (!barCodeTojitsuResult.has投票資格()) {
                row.getChkSenkyo1().setDisabled(true);
                row.getChkSenkyo2().setDisabled(true);
                row.getChkSenkyo3().setDisabled(true);
                row.getChkSenkyo4().setDisabled(true);
                row.getChkSenkyo5().setDisabled(true);
                row.getChkSenkyo6().setDisabled(true);
                row.getChkSenkyo7().setDisabled(true);
                row.getChkSenkyo8().setDisabled(true);
                row.getChkSenkyo9().setDisabled(true);
            }
        }
        row.getChkAll().setDisabled(!is全活性(row));
        return row;
    }

    private RString get投票状況_選挙番号(SenkyoNo n, List<BarCodeTojitsuResult> 選挙人名簿データ) {
        for (int i = 0; i < 選挙人名簿データ.size(); i++) {
            if (選挙人名簿データ.get(i).get投票状況データ() != null
                    && n.equals(new SenkyoNo(選挙人名簿データ.get(i).get選挙No()))) {
                Code tohyoJokyo = new Code(選挙人名簿データ.get(i).get投票状況());
                return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.投票状況.getCodeShubetsu(), tohyoJokyo);
            }
        }
        return null;
    }

    private Boolean is無投票選挙(List<BarCodeTojitsuResult> 選挙人名簿データ, SenkyoNo 選挙番号) {
        for (int i = 0; i < 選挙人名簿データ.size(); i++) {
            if (new SenkyoNo(選挙人名簿データ.get(i).get選挙No()).equals(選挙番号)) {
                return 選挙人名簿データ.get(i).is無投票選挙フラグ();
            }
        }
        return false;
    }

    private Boolean is全活性(dgBarCodeTojitsuTaishosha_Row row) {
        if (div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo1").isVisible()
                && !row.getChkSenkyo1().isDisabled()) {
            return true;
        }
        if (div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo2").isVisible()
                && !row.getChkSenkyo2().isDisabled()) {
            return true;
        }
        if (div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo3").isVisible()
                && !row.getChkSenkyo3().isDisabled()) {
            return true;
        }
        if (div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo4").isVisible()
                && !row.getChkSenkyo4().isDisabled()) {
            return true;
        }
        if (div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo5").isVisible()
                && !row.getChkSenkyo5().isDisabled()) {
            return true;
        }
        if (div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo6").isVisible()
                && !row.getChkSenkyo6().isDisabled()) {
            return true;
        }
        if (div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo7").isVisible()
                && !row.getChkSenkyo7().isDisabled()) {
            return true;
        }
        if (div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo8").isVisible()
                && !row.getChkSenkyo8().isDisabled()) {
            return true;
        }
        return div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo9").isVisible()
                && !row.getChkSenkyo9().isDisabled();
    }

    private ResponseData<BarCodeTojitsuDiv> set列数(List<BarCodeTojitsuResult> 選挙人名簿データ) {
        List<SenkyoNo> 選挙番号list = new ArrayList<>();
        for (int i = 0; i < 選挙人名簿データ.size(); i++) {
            選挙番号list.add(new SenkyoNo(選挙人名簿データ.get(i).get選挙No()));
        }
        div.getLblSenkyoRyakuName().setText(set選挙略称(選挙人名簿データ));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo1").setVisible(選挙番号list.contains(選挙番号_1)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_1));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo2").setVisible(選挙番号list.contains(選挙番号_2)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_2));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo3").setVisible(選挙番号list.contains(選挙番号_3)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_3));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo4").setVisible(選挙番号list.contains(選挙番号_4)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_4));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo5").setVisible(選挙番号list.contains(選挙番号_5)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_5));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo6").setVisible(選挙番号list.contains(選挙番号_6)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_6));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo7").setVisible(選挙番号list.contains(選挙番号_7)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_7));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo8").setVisible(選挙番号list.contains(選挙番号_8)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_8));
        div.getDgBarCodeTojitsuTaishosha().getGridSetting().getColumn("chkSenkyo9").setVisible(選挙番号list.contains(選挙番号_9)
                && !is無投票選挙(選挙人名簿データ, 選挙番号_9));
        return ResponseData.of(div).respond();
    }

    private RString set選挙略称(List<BarCodeTojitsuResult> 選挙人名簿データ) {
        RString 選挙略称label = new RString("");
        for (int i = 0; i < 選挙人名簿データ.size(); i++) {
            RString 選挙番号 = 選挙人名簿データ.get(i).get選挙No();
            RString 選挙略称 = 選挙人名簿データ.get(i).get選挙略称();
            RString 無投票選挙 = 選挙人名簿データ.get(i).is無投票選挙フラグ() ? 無投票 : RString.EMPTY;
            選挙略称label = 選挙略称label.concat(選挙番号).concat(コロン).concat(選挙略称).concat(無投票選挙).concat(全角スペース);
        }
        return 選挙略称label;
    }

}
