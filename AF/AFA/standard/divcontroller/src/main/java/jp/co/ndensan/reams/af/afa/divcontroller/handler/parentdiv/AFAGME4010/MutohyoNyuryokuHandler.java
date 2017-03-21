/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku.TohyoJokyoJoho;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mutohyonyuryoku.MutohyoNyuryokuMybatisParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010.MutohyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010.dgMutohyoData_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.mutohyonyuryoku.MutohyoNyuryokuManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 無投票入力のハンドラクラスです。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
public class MutohyoNyuryokuHandler {

    private final MutohyoNyuryokuDiv div;
    private static final RString 無投票入力_入力方法_0 = new RString("投票しなかった人にチェック");
    private static final RString 無投票入力_入力方法_1 = new RString("投票した人にチェック");
    private static final RString グループコード_居住区分毎 = new RString("1");
    private static final RString グループコード_資格区分毎 = new RString("2");
    private static final RString ラベル_居住区分 = new RString("居住区分");
    private static final RString ラベル_資格区分 = new RString("資格区分");
    private static final int 選挙番号_ONE = 0;
    private static final int 選挙番号_TWO = 1;
    private static final int 選挙番号_THREE = 2;
    private static final int 選挙番号_FOUR = 3;
    private static final int 選挙番号_FIVE = 4;
    private static final int 選挙番号_SIX = 5;
    private static final int 選挙番号_SEVEN = 6;
    private static final int 選挙番号_EIGHT = 7;
    private static final int 選挙番号_NINE = 8;
    private static final RString KEY_1 = new RString("1");
    private static final RString KEY_2 = new RString("2");
    private static final RString KEY_3 = new RString("3");
    private static final RString KEY_4 = new RString("4");
    private static final RString KEY_5 = new RString("5");
    private static final RString KEY_6 = new RString("6");
    private static final RString KEY_7 = new RString("7");
    private static final RString KEY_8 = new RString("8");
    private static final RString KEY_9 = new RString("9");
    private static final RString 棄権 = new RString("5");
    private static final RString 当日 = new RString("7");
    private static final RString JOKYO_棄権 = new RString("棄権");
    private static final RString JOKYO_当日 = new RString("当日");
    private static final RString 性別_男 = new RString("男");
    private static final RString 性別_女 = new RString("女");

    private static final Map<Code, RString> 投票状況_MAP = new HashMap<>();

    static {
        投票状況_MAP.put(new Code(TohyoJokyo.請求.getCode()), new RString("請求"));
        投票状況_MAP.put(new Code(TohyoJokyo.交付.getCode()), new RString("交付"));
        投票状況_MAP.put(new Code(TohyoJokyo.受理.getCode()), new RString("受理"));
        投票状況_MAP.put(new Code(TohyoJokyo.返還.getCode()), new RString("返還"));
        投票状況_MAP.put(new Code(TohyoJokyo.棄権.getCode()), new RString("棄権"));
        投票状況_MAP.put(new Code(TohyoJokyo.期日前.getCode()), new RString("期日前"));
        投票状況_MAP.put(new Code(TohyoJokyo.当日.getCode()), new RString("当日"));
        投票状況_MAP.put(new Code(TohyoJokyo.受付拒否.getCode()), new RString("拒否"));
        投票状況_MAP.put(new Code(TohyoJokyo.仮投票.getCode()), new RString("仮投票"));
        投票状況_MAP.put(new Code(TohyoJokyo.無投票.getCode()), new RString("無投票"));
    }

    /**
     * コンストラクタです。
     *
     * @param div MutohyoNyuryokuDiv
     */
    public MutohyoNyuryokuHandler(MutohyoNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 初期化処理です。
     *
     * @return Success : true || Fail : false
     */
    public boolean initialize() {
        ViewState.setメニューID(AFAMenuId.AFAMNE4010_無投票入力.menuId());
        div.getMutohyoNyuryokuJoken().getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
        div.getMutohyoNyuryokuJoken().getCcdShohonNameList().initialize();
        if (div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getShohonListSize() == 0) {
            return false;
        }
        div.getMutohyoNyuryokuJoken().getCcdShohonNameList().selectedShohon(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().get一番近い過去抄本番号());
        // 投票ラベルの初期化
        if (AFAConfigKeysValue.無投票入力_入力方法_投票しなかった人にチェック.configKeyValue().equals(
                BusinessConfig.get(ConfigKeysAFA.無投票入力_入力方法, SubGyomuCode.AFA選挙本体))) {
            div.getMutohyoDataNyuryoku().getLblCheckNaiyo().setText(無投票入力_入力方法_0);
        }
        if (AFAConfigKeysValue.無投票入力_入力方法_投票した人にチェック.configKeyValue().equals(
                BusinessConfig.get(ConfigKeysAFA.無投票入力_入力方法, SubGyomuCode.AFA選挙本体))) {
            div.getMutohyoDataNyuryoku().getLblCheckNaiyo().setText(無投票入力_入力方法_1);
        }
        initializeCode();
        return true;

    }

    /**
     * コードと投票区の初期化です。
     */
    public void initializeCode() {
        // コードの初期化
        if (グループコード_居住区分毎.equals(BusinessConfig.get(ConfigKeysAFA.抄本_グループコード, SubGyomuCode.AFA選挙本体))) {

            div.getMutohyoNyuryokuJoken().getCcdKubunCode().setCodeLabelMeisho(ラベル_居住区分);
            div.getMutohyoNyuryokuJoken().getCcdKubunCode().applyOptionCodeMaster().load(AFACodeShubetsu.居住区分.getCodeShubetsu());
        } else if (グループコード_資格区分毎.equals(BusinessConfig.get(ConfigKeysAFA.抄本_グループコード, SubGyomuCode.AFA選挙本体))) {
            div.getMutohyoNyuryokuJoken().getCcdKubunCode().setCodeLabelMeisho(ラベル_資格区分);
            if (SenkyoShurui.憲法改正国民投票.equals(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedSenkyoShurui())) {
                div.getMutohyoNyuryokuJoken().getCcdKubunCode().applyOptionCodeMaster().load(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu());
            } else {
                div.getMutohyoNyuryokuJoken().getCcdKubunCode().applyOptionCodeMaster().load(AFACodeShubetsu.選挙資格区分.getCodeShubetsu());
            }
        } else {
            div.getMutohyoNyuryokuJoken().getCcdKubunCode().setDisplay(CodeInputDiv.Display.表示しない);
            div.getMutohyoNyuryokuJoken().getCcdTohyoku().setWrap(Boolean.TRUE);
        }
        // 投票区の初期化
        SenkyoShurui senkyoShurui = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedSenkyoShurui();
        div.getMutohyoNyuryokuJoken().getCcdTohyoku().initialize(senkyoShurui, true);
        // 名簿番号の初期化
        div.getMutohyoNyuryokuJoken().getCcdMeiboBango().initialize();
        // 選挙略称の初期化
        RString 選挙Label = new MutohyoNyuryokuManager().senkyoLabel(new ShohonNo(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo()));
        div.getMutohyoDataNyuryoku().getLblSenkyoRyakuName().setText(選挙Label);
        div.getBtnAfter().setDisabled(true);
        div.getBtnBefore().setDisabled(true);
    }

    /**
     * 検索処理です。
     *
     * @return 検索結果
     */
    public boolean select() {
        div.getMutohyoDataNyuryoku().getDgMutohyoData().init();
        List<dgMutohyoData_Row> datarowList = new ArrayList();
        MutohyoNyuryokuMybatisParameter parameter = createMutohyoNyuryokuMybatisParameter();
        List<List<TohyoJokyoJoho>> johoLists = selectJoho(parameter);
        if (johoLists == null) {
            div.getDgMutohyoData().getDataSource().clear();
            return false;
        }
        int count_選挙番号 = new MutohyoNyuryokuManager().countSenkyo(new ShohonNo(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo()));
        Decimal page = div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get頁();
        if ((page == null ? 1 : page.intValue()) != 1) {
            div.getBtnBefore().setDisabled(false);
        } else {
            div.getBtnBefore().setDisabled(true);
        }
        if (!hasNextPage()) {
            div.getBtnAfter().setDisabled(true);
        } else {
            div.getBtnAfter().setDisabled(false);
        }
        for (List<TohyoJokyoJoho> 投票状況s : johoLists) {
            boolean button = false;
            boolean checkall = true;
            dgMutohyoData_Row datarow = new dgMutohyoData_Row();
            TohyoJokyoJoho 状況 = 投票状況s.get(0);
            int gyo = 状況.getGyo();
            datarow.setTxtGyo(new RString(gyo));
            datarow.setTxtShimei(状況.getMeisho().getColumnValue());
            switch (Integer.valueOf(状況.getSeibetsuCode().toString())) {
                case 1:
                    datarow.setTxtSeibetsu(性別_男);
                    break;
                case 2:
                    datarow.setTxtSeibetsu(性別_女);
                    break;
                default:
            }
            datarow.setTxtJusho(状況.getJutonaiJusho().concat(状況.getJutonaiBanchi().getColumnValue()).concat(RString.FULL_SPACE).
                    concat(状況.getJutonaiKatagaki().getColumnValue()));
            switch (Integer.valueOf(状況.getJuminShubetsuCode().toString())) {
                case 1:
                    datarow.setTxtSeinengappi(状況.getSeinengappiYMD().wareki().toDateString());
                    break;
                case 2:
                    datarow.setTxtSeinengappi(状況.getSeinengappiYMD().seireki().toDateString());
                    break;
                default:
            }
            datarow.setTxtJuminShubetsu(JuminJotai.toValue(状況.getJuminJotaiCode()).住民状態略称());
            datarow.setTxtShikibetsuCode(状況.getShikibetsuCode().getColumnValue());
            datarow.getTxtHyojiYmd().setValue(状況.getHyojiYMD() == null ? FlexibleDate.EMPTY : 状況.getHyojiYMD());
            datarow.getTxtMassyoYmd().setValue(状況.getMasshoYMD() == null ? FlexibleDate.EMPTY : 状況.getMasshoYMD());

            datarow.setTxtSetaiCode(状況.getSetaiCode().getColumnValue());
            datarow.setTxtGyoseikuCode(状況.getGyoseikuCode().getColumnValue());
            if (!div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedSenkyoShurui().equals(SenkyoShurui.憲法改正国民投票)) {
                datarow.setTxtSenkyoShikaku(CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), 状況.getShikakuKubun()));
            } else {
                datarow.setTxtSenkyoShikaku(CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu(), 状況.getShikakuKubun()));
            }
            editTohyoJokyoRow(投票状況s, count_選挙番号, datarow, button, checkall);
            datarowList.add(datarow);
        }
        div.getDgMutohyoData().setDataSource(datarowList);
        return true;

    }

    /**
     * 検索処理です。
     *
     * @param parameter MutohyoNyuryokuMybatisParameter
     * @return List<TohyoJokyoJohoitem>
     */
    public List<List<TohyoJokyoJoho>> selectJoho(MutohyoNyuryokuMybatisParameter parameter) {
        MutohyoNyuryokuManager manager = MutohyoNyuryokuManager.createInstance();
        List<TohyoJokyoJoho> johoList = manager.get投票状況情報(parameter);
        if (johoList == null) {
            return null;
        }
        int count_選挙番号 = manager.countSenkyo(new ShohonNo(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo()));
        List<List<TohyoJokyoJoho>> johoLists = new ArrayList<>();
        List<TohyoJokyoJoho> johotemp = new ArrayList<>();
        for (TohyoJokyoJoho 投票状況 : johoList) {
            if (johotemp.size() == count_選挙番号) {
                johoLists.add(johotemp);
                johotemp = new ArrayList<>();
                johotemp.add(投票状況);
            } else {
                johotemp.add(投票状況);
            }
        }
        johoLists.add(johotemp);
        return johoLists;

    }

    /**
     * 検索用パラメータを作成します。
     *
     * @return MutohyoNyuryokuMybatisParameter
     */
    public MutohyoNyuryokuMybatisParameter createMutohyoNyuryokuMybatisParameter() {
        RString 冊 = div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get冊();
        RString groupCode = div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().value();
        return new MutohyoNyuryokuMybatisParameter(
                new ShohonNo(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo()),
                RString.isNullOrEmpty(groupCode) ? null : groupCode,
                div.getMutohyoNyuryokuJoken().getCcdTohyoku().get投票区コード(),
                RString.isNullOrEmpty(冊) ? null : 冊,
                div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get頁(),
                getSearchKey());

    }

    private IShikibetsuTaishoPSMSearchKey getSearchKey() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙,
                KensakuYusenKubun.住登内優先);
        builder.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        return builder.build();
    }

    /**
     * 全にチェックしたら、活性のチェックボックス全てON
     */
    public void setCheckboxON() {
        div.getMutohyoDataNyuryoku().getDgMutohyoData().getTotalRecords();

    }

    /**
     * 投票状況のgetメソッドです。
     *
     * @param 投票状況 TohyoJokyoJoho
     * @return 投票状況
     */
    public RString edit投票状況(TohyoJokyoJoho 投票状況) {
        RString 状況 = RString.EMPTY;
        if (投票状況.getTohyoJokyoEntity() != null) {
            状況 = 投票状況_MAP.get(投票状況.getTohyoJokyoEntity().getTohyoJokyo());
        }
        return 状況;
    }

    /**
     * 投票資格があるかどうかを返します。
     *
     * @param 投票状況 TohyoJokyoJoho
     * @return 投票資格があるかどうか
     */
    public boolean has投票資格(TohyoJokyoJoho 投票状況) {
        return 投票状況.has投票資格();
    }

    /**
     * 投票状況のgetメソッドです。
     *
     * @param 投票状況s List<TohyoJokyoJoho>
     * @param count_選挙番号 int
     * @param datarow dgMutohyoData_Row
     * @param button boolean
     * @param checkall boolean
     */
    public void editTohyoJokyoRow(List<TohyoJokyoJoho> 投票状況s, int count_選挙番号, dgMutohyoData_Row datarow, boolean button, boolean checkall) {
        int i = 1;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_ONE);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_1, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo1().setDataSource(datalist);
            editCheck1(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo1(), checkall);
        }
        i++;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_TWO);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_2, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo2().setDataSource(datalist);
            editCheck2(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo2(), checkall);
        } else {
            datarow.getChkSenkyo2().setDisplayNone(true);
            datarow.getChkSenkyo2().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo2")).setVisible(false);
        }
        i++;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_THREE);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_3, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo3().setDataSource(datalist);
            editCheck3(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo3(), checkall);
        } else {
            datarow.getChkSenkyo3().setDisplayNone(true);
            datarow.getChkSenkyo3().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo3")).setVisible(false);
        }
        i++;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_FOUR);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_4, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo4().setDataSource(datalist);
            editCheck4(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo4(), checkall);
        } else {
            datarow.getChkSenkyo4().setDisplayNone(true);
            datarow.getChkSenkyo4().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo4")).setVisible(false);
        }
        i++;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_FIVE);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_5, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo5().setDataSource(datalist);
            editCheck5(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo5(), checkall);
        } else {
            datarow.getChkSenkyo5().setDisplayNone(true);
            datarow.getChkSenkyo5().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo5")).setVisible(false);

        }
        i++;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_SIX);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_6, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo6().setDataSource(datalist);
            editCheck6(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo6(), checkall);
        } else {
            datarow.getChkSenkyo6().setDisplayNone(true);
            datarow.getChkSenkyo6().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo6")).setVisible(false);
        }
        i++;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_SEVEN);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_7, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo7().setDataSource(datalist);
            editCheck7(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo7(), checkall);
        } else {
            datarow.getChkSenkyo7().setDisplayNone(true);
            datarow.getChkSenkyo7().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo7")).setVisible(false);
        }
        i++;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_EIGHT);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_8, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo8().setDataSource(datalist);
            editCheck8(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo8(), checkall);
        } else {
            datarow.getChkSenkyo8().setDisplayNone(true);
            datarow.getChkSenkyo8().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo8")).setVisible(false);
        }
        i++;
        if (i <= count_選挙番号) {
            TohyoJokyoJoho 投票状況 = 投票状況s.get(選挙番号_NINE);
            List<KeyValueDataSource> datalist = new ArrayList<>();
            RString 状況 = edit投票状況(投票状況);
            KeyValueDataSource dataSource = new KeyValueDataSource(KEY_9, 状況);
            datalist.add(dataSource);
            datarow.getChkSenkyo9().setDataSource(datalist);
            editCheck9(投票状況, datarow);
            button = button(状況, button);
            checkall = checkALL(datarow.getChkSenkyo9(), checkall);
        } else {
            datarow.getChkSenkyo9().setDisplayNone(true);
            datarow.getChkSenkyo9().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo9")).setVisible(false);
        }
        List<KeyValueDataSource> datalist = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(KEY_1, RString.EMPTY);
        datalist.add(dataSource);
        datarow.getChkAll().setDataSource(datalist);
        datarow.getChkAll().setDisabled(checkall);

        datarow.getBtnJotaiHenko().setDisabled(!button);
    }

    private boolean checkALL(CheckBoxList check, boolean checkall) {
        if (!checkall) {
            return false;
        }
        return check.isDisabled();
    }

    private boolean button(RString 投票状況, boolean button) {
        if (button) {
            return true;
        }
        return 投票状況.equals(JOKYO_棄権) || 投票状況.equals(JOKYO_当日);
    }

    private void editCheck1(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo1().setDisplayNone(true);
            datarow.getChkSenkyo1().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo1")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo1().setDisplayNone(false);
            datarow.getChkSenkyo1().setDisabled(false);
        } else {
            datarow.getChkSenkyo1().setDisplayNone(false);
            datarow.getChkSenkyo1().setDisabled(true);
        }
    }

    private void editCheck2(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo2().setDisplayNone(true);
            datarow.getChkSenkyo2().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo2")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo2().setDisplayNone(false);
            datarow.getChkSenkyo2().setDisabled(false);
        } else {
            datarow.getChkSenkyo2().setDisplayNone(false);
            datarow.getChkSenkyo2().setDisabled(true);
        }
    }

    private void editCheck3(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo3().setDisplayNone(true);
            datarow.getChkSenkyo3().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo3")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo3().setDisplayNone(false);
            datarow.getChkSenkyo3().setDisabled(false);
        } else {
            datarow.getChkSenkyo3().setDisplayNone(false);
            datarow.getChkSenkyo3().setDisabled(true);
        }
    }

    private void editCheck4(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo4().setDisplayNone(true);
            datarow.getChkSenkyo4().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo4")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo4().setDisplayNone(false);
            datarow.getChkSenkyo4().setDisabled(false);
        } else {
            datarow.getChkSenkyo4().setDisplayNone(false);
            datarow.getChkSenkyo4().setDisabled(true);
        }
    }

    private void editCheck5(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo5().setDisplayNone(true);
            datarow.getChkSenkyo5().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo5")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo5().setDisplayNone(false);
            datarow.getChkSenkyo5().setDisabled(false);
        } else {
            datarow.getChkSenkyo5().setDisplayNone(false);
            datarow.getChkSenkyo5().setDisabled(true);
        }
    }

    private void editCheck6(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo6().setDisplayNone(true);
            datarow.getChkSenkyo6().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo6")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo6().setDisplayNone(false);
            datarow.getChkSenkyo6().setDisabled(false);
        } else {
            datarow.getChkSenkyo6().setDisplayNone(false);
            datarow.getChkSenkyo6().setDisabled(true);
        }
    }

    private void editCheck7(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo7().setDisplayNone(true);
            datarow.getChkSenkyo7().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo7")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo7().setDisplayNone(false);
            datarow.getChkSenkyo7().setDisabled(false);
        } else {
            datarow.getChkSenkyo7().setDisplayNone(false);
            datarow.getChkSenkyo7().setDisabled(true);
        }
    }

    private void editCheck8(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo8().setDisplayNone(true);
            datarow.getChkSenkyo8().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo8")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo8().setDisplayNone(false);
            datarow.getChkSenkyo8().setDisabled(false);
        } else {
            datarow.getChkSenkyo8().setDisplayNone(false);
            datarow.getChkSenkyo8().setDisabled(true);
        }
    }

    private void editCheck9(TohyoJokyoJoho 投票状況, dgMutohyoData_Row datarow) {
        if (投票状況.isMutohyoSenkyoFlag()) {
            datarow.getChkSenkyo9().setDisplayNone(true);
            datarow.getChkSenkyo9().setDisabled(true);
            div.getMutohyoDataNyuryoku().getDgMutohyoData().getGridSetting().getColumn(new RString("chkSenkyo9")).setVisible(false);
        } else if (投票状況.getTohyoJokyoEntity() == null && has投票資格(投票状況)) {
            datarow.getChkSenkyo9().setDisplayNone(false);
            datarow.getChkSenkyo9().setDisabled(false);
        } else {
            datarow.getChkSenkyo9().setDisplayNone(false);
            datarow.getChkSenkyo9().setDisabled(true);
        }
    }

    /**
     * 保存処理です。
     *
     * @param i レコード件数
     */
    public void saveData(int i) {
        saveChk1(i);
        saveChk2(i);
        saveChk3(i);
        saveChk4(i);
        saveChk5(i);
        saveChk6(i);
        saveChk7(i);
        saveChk8(i);
        saveChk9(i);
    }

    private boolean saveChk1(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo1().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_ONE + 1, tohyoJokyo);
        }
        return true;
    }

    private boolean saveChk2(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo2().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_TWO + 1, tohyoJokyo);
        }
        return true;
    }

    private boolean saveChk3(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo3().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_THREE + 1, tohyoJokyo);
        }
        return true;
    }

    private boolean saveChk4(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo4().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_FOUR + 1, tohyoJokyo);
        }
        return true;
    }

    private boolean saveChk5(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo5().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_FIVE + 1, tohyoJokyo);
        }
        return true;
    }

    private boolean saveChk6(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo6().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_SIX + 1, tohyoJokyo);
        }
        return true;
    }

    private boolean saveChk7(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo7().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_SEVEN + 1, tohyoJokyo);
        }
        return true;
    }

    private boolean saveChk8(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo8().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_EIGHT + 1, tohyoJokyo);
        }
        return true;
    }

    private boolean saveChk9(int i) {
        RString tohyoJokyo = RString.EMPTY;
        RString shohonNo = div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo();
        RString shikibetsuCode = div.getDgMutohyoData().getDataSource().get(i).getTxtShikibetsuCode();
        if (div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isDisplayNone()) {
            return false;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 棄権;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_0)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isDisabled() && div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 当日;
        }
        if (!div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isDisabled() && !div.getDgMutohyoData().getDataSource().get(i).getChkSenkyo9().isAllSelected()
                && div.getMutohyoDataNyuryoku().getLblCheckNaiyo().getText().equals(無投票入力_入力方法_1)) {
            tohyoJokyo = 棄権;

        }
        if (!tohyoJokyo.isEmpty()) {
            new MutohyoNyuryokuManager().save(shohonNo, shikibetsuCode, 選挙番号_NINE + 1, tohyoJokyo);
        }
        return true;
    }

    /**
     * 画面状態は変更されたかどうかを判断します。
     *
     * @param rowList List<dgMutohyoData_Row>
     * @return boolean 変更されたかどうか
     */
    public boolean is画面変更(List<dgMutohyoData_Row> rowList) {
        for (dgMutohyoData_Row row : rowList) {
            if (isCheckBox変更(row.getChkSenkyo1())
                    || isCheckBox変更(row.getChkSenkyo2())
                    || isCheckBox変更(row.getChkSenkyo3())
                    || isCheckBox変更(row.getChkSenkyo4())
                    || isCheckBox変更(row.getChkSenkyo5())
                    || isCheckBox変更(row.getChkSenkyo6())
                    || isCheckBox変更(row.getChkSenkyo7())
                    || isCheckBox変更(row.getChkSenkyo8())
                    || isCheckBox変更(row.getChkSenkyo9())) {
                return true;
            }
        }
        return false;
    }

    private boolean isCheckBox変更(CheckBoxList checkBox) {
        return !checkBox.getSelectedItems().isEmpty() && !checkBox.isDisabled();
    }

    /**
     * 次ページがあるかどうかを判断します。
     *
     * @return boolean 次ページがあるかどうか
     */
    public boolean hasNextPage() {
        RString 冊 = div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get冊();
        Decimal 頁 = div.getMutohyoNyuryokuJoken().getCcdMeiboBango().get頁();
        Decimal page = 頁 != null ? 頁 : new Decimal(1);
        ShohonNo 抄本番号 = new ShohonNo(div.getMutohyoNyuryokuJoken().getCcdShohonNameList().getSelectedShohonNo());
        RString グループコード = div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue();
        グループコード = RString.isNullOrEmpty(グループコード) ? null : グループコード;
        RString 投票区コード = div.getMutohyoNyuryokuJoken().getCcdTohyoku().get投票区コード();
        冊 = RString.isNullOrEmpty(冊) ? null : 冊;
        return MutohyoNyuryokuManager.createInstance().hasNextPage(抄本番号, グループコード, 投票区コード, 冊, page);

    }

    /**
     * 全てのチェックの設定です
     *
     * @param index int
     */
    public void changeCheckAll(int index) {

        if (div.getDgMutohyoData().getDataSource().get(index).getChkAll().isAllSelected()) {
            changeCheckAllon(index);
        } else {
            changeCheckAlloff(index);
        }
    }

    private void changeCheckAllon(int index) {
        List<RString> key = new ArrayList<>();
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo1().isDisabled()) {
            key.add(KEY_1);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo1().setSelectedItemsByKey(key);
            key.clear();
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo2().isDisabled()) {
            key.add(KEY_2);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo2().setSelectedItemsByKey(key);
            key.clear();
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo3().isDisabled()) {
            key.add(KEY_3);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo3().setSelectedItemsByKey(key);
            key.clear();
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo4().isDisabled()) {
            key.add(KEY_4);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo4().setSelectedItemsByKey(key);
            key.clear();
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo5().isDisabled()) {
            key.add(KEY_5);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo5().setSelectedItemsByKey(key);
            key.clear();
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo6().isDisabled()) {
            key.add(KEY_6);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo6().setSelectedItemsByKey(key);
            key.clear();
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo7().isDisabled()) {
            key.add(KEY_7);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo7().setSelectedItemsByKey(key);
            key.clear();
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo8().isDisabled()) {
            key.add(KEY_8);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo8().setSelectedItemsByKey(key);
            key.clear();
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo9().isDisabled()) {
            key.add(KEY_9);
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo9().setSelectedItemsByKey(key);
            key.clear();
        }
    }

    private void changeCheckAlloff(int index) {
        List<RString> key = new ArrayList<>();
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo1().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo1().setSelectedItemsByKey(key);
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo2().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo2().setSelectedItemsByKey(key);
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo3().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo3().setSelectedItemsByKey(key);
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo4().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo4().setSelectedItemsByKey(key);
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo5().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo5().setSelectedItemsByKey(key);
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo6().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo6().setSelectedItemsByKey(key);
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo7().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo7().setSelectedItemsByKey(key);
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo8().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo8().setSelectedItemsByKey(key);
        }
        if (!div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo9().isDisabled()) {
            div.getDgMutohyoData().getDataSource().get(index).getChkSenkyo9().setSelectedItemsByKey(key);
        }
    }

    /**
     * AccessLogを出力します。
     *
     * @param accessLogType AccessLogType
     */
    public void outAccessLog(AccessLogType accessLogType) {
        List<PersonalData> personalDataList = new ArrayList<>();
        List<dgMutohyoData_Row> rowList = div.getDgMutohyoData().getDataSource();
        for (dgMutohyoData_Row row : rowList) {
            personalDataList.add(PersonalData.of(new ShikibetsuCode(row.getTxtShikibetsuCode())));
        }

        AccessLogger.log(accessLogType, personalDataList);
    }
}
