/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuShimeiNyuryoku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyojokyoDairishaSerachResult;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugi;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tohyorokufuzui.TohyorokuFuzui;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyorokuKomokuShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.tohyojokyo.TohyojokyoMapperParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5020.TohyorokuSakuseiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugiManager;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tohyorokufuzui.TohyorokuFuzuiManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * TohyorokuShimeiNyuryokuDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTohyorokuShimeiNyuryokuDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0130-013 lit
 */
public class TohyorokuShimeiNyuryokuHandler {

    private final TohyorokuShimeiNyuryokuDiv div;
    private List<TohyorokuFuzui> 決定書判決書リスト = new ArrayList<>();
    private static final int 投票者_行数 = 8;

    /**
     * コンストラクタです。
     *
     * @param div 投票録氏名入力Div
     */
    public TohyorokuShimeiNyuryokuHandler(TohyorokuShimeiNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 指定行数分の空行を作成する。
     *
     * @param 行数
     */
    public void load(int 行数) {
        List<dgTohyorokuShimeiNyuryoku_Row> dataSource = new ArrayList<>();

        for (int i = 1; i <= 行数; i++) {
            dgTohyorokuShimeiNyuryoku_Row row = new dgTohyorokuShimeiNyuryoku_Row();
            row.setTxtShimei1(new TextBox());
            row.setTxtShimei2(new TextBox());
            row.setTxtShimei3(new TextBox());
            row.setTxtShimei4(new TextBox());
            dataSource.add(row);
        }
        div.getDgTohyorokuShimeiNyuryoku().setDataSource(dataSource);
    }

    /**
     * 項目クリアのメソッドです。
     *
     */
    public void clearDataSource() {
        List<dgTohyorokuShimeiNyuryoku_Row> dataSource = div.getDgTohyorokuShimeiNyuryoku().getDataSource();
        List<dgTohyorokuShimeiNyuryoku_Row> newSource = new ArrayList<>();

        for (dgTohyorokuShimeiNyuryoku_Row row : dataSource) {
            row.getTxtShimei1().clearValue();
            row.getTxtShimei2().clearValue();
            row.getTxtShimei3().clearValue();
            row.getTxtShimei4().clearValue();
            newSource.add(row);
        }
        div.getDgTohyorokuShimeiNyuryoku().setDataSource(newSource);
    }

    /**
     * 引数のデータから、この共有子Divの初期表示を行います。
     *
     * @param item
     */
    public void initialize(HashMap item) {
        List<dgTohyorokuShimeiNyuryoku_Row> dataSource = div.getDgTohyorokuShimeiNyuryoku().getDataSource();

        for (dgTohyorokuShimeiNyuryoku_Row row : dataSource) {
            if (row.getTxtShimei1().getValue().isEmpty()) {
                row.getTxtShimei1().setValue(YamlLoader.getTextBoxText(item, "氏名").getValue());
                break;
            }
            if (row.getTxtShimei2().getValue().isEmpty()) {
                row.getTxtShimei2().setValue(YamlLoader.getTextBoxText(item, "氏名").getValue());
                break;
            }
            if (row.getTxtShimei3().getValue().isEmpty()) {
                row.getTxtShimei3().setValue(YamlLoader.getTextBoxText(item, "氏名").getValue());
                break;
            }
            if (row.getTxtShimei4().getValue().isEmpty()) {
                row.getTxtShimei4().setValue(YamlLoader.getTextBoxText(item, "氏名").getValue());
                break;
            }
        }
        div.getDgTohyorokuShimeiNyuryoku().setDataSource(dataSource);
    }

    /**
     * 引数のデータから、この共有子Divの初期表示を行います。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況（期日前　or　当日）
     * @param 投票録項目種類 投票録項目種類（決定書・裁決書　or　用紙返還　or　点字による投票）
     * @param 立会人連番 立会人連番（※立会人引継書の場合のみ）
     * @param 行数 行数
     */
    public void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況,
            Code 投票録項目種類,
            RString 立会人連番,
            int 行数) {

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先));
        TohyojokyoMapperParameter parameter
                = TohyojokyoMapperParameter.createParam(抄本番号, 選挙番号, 報告年月日, 施設コード,
                        投票区コード, 投票状況, key.getPSM検索キー());

        TohyoJokyoManager tohyoJokyoManager = TohyoJokyoManager.createInstance();
        TohyorokuFuzuiManager tohyorokuFuzuiManager = TohyorokuFuzuiManager.createInstance();
        TachiaininHikitsugiManager tachiaininHikitsugiManager = TachiaininHikitsugiManager.createInstance();

        if (ViewState.getメニューID().equals(AFAMenuId.AFAMNE5020_投票録.menuId())) {
            if (投票録項目種類.value().equals(TohyorokuKomokuShurui.決定書_判決書.getCode())) {
                this.決定書判決書リスト = tohyorokuFuzuiManager.get投票録付随情報(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 投票状況);
                if (!setDataListByResultList(this.決定書判決書リスト, 行数)
                        && TohyoJokyo.期日前.getCode().equals(投票状況)) {
                    setDataListByResultList(tachiaininHikitsugiManager.get立会人引継情報With投票状況(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票状況, 投票録項目種類), 行数);
                }

            } else if (投票録項目種類.value().equals(TohyorokuKomokuShurui.用紙返還.getCode())) {
                setDataListByResultList(tohyoJokyoManager.get用紙返還投票者状況一覧(parameter), 行数);
            }

        } else if (ViewState.getメニューID().equals(AFAMenuId.AFAMNE5010_立会人引継書.menuId())) {
            if (投票録項目種類.value().equals(TohyorokuKomokuShurui.決定書_判決書.getCode())) {
                setDataListByResultList(tachiaininHikitsugiManager.get立会人引継情報With投票状況(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票状況, 投票録項目種類, 立会人連番), 行数);
            } else if (投票録項目種類.value().equals(TohyorokuKomokuShurui.用紙返還.getCode())
                    && TohyoJokyo.期日前.getCode().equals(投票状況)) {
                setDataListByResultList(tohyoJokyoManager.get用紙返還投票者状況一覧(parameter), 行数);
            } else if (投票録項目種類.value().equals(TohyorokuKomokuShurui.投票の拒否.getCode())) {
                setDataListByResultList(tohyoJokyoManager.get点字により投票者状況一覧(parameter), 行数);
            }

        } else if (ViewState.getメニューID().equals(AFAMenuId.AFAMNE3020_当日投票録.menuId())) {
            if (投票録項目種類.value().equals(TohyorokuKomokuShurui.決定書_判決書.getCode())) {
                this.決定書判決書リスト = tohyorokuFuzuiManager.get投票録付随情報(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, 投票状況);
                setDataListByResultList(this.決定書判決書リスト, 行数);
            } else if (投票録項目種類.value().equals(TohyorokuKomokuShurui.用紙返還.getCode())) {
                setDataListByResultList(tohyoJokyoManager.get用紙返還投票者状況一覧(parameter), 行数);
            }
        }

        if (投票録項目種類.value().equals(TohyorokuKomokuShurui.決定書_判決書.getCode())) {
            ViewStateHolder.put(TohyorokuSakuseiHandler.TohyorokuSakuseiEnum.決定書または裁決書投票者,
                    (Serializable) get固定リスト(this.決定書判決書リスト, 投票者_行数));
        }
    }

    private boolean setDataListByResultList(List<?> targetList, int 行数) {
        List<dgTohyorokuShimeiNyuryoku_Row> rowList = new ArrayList<>();
        if (null == targetList || targetList.size() <= 0) {
            return false;
        }

        dgTohyorokuShimeiNyuryoku_Row row = new dgTohyorokuShimeiNyuryoku_Row();
        AtenaMeisho 氏名Cls;
        for (int i = 1; i <= 行数 * 4; i++) {
            RString 氏名 = RString.EMPTY;
            if (i <= targetList.size()) {
                Object target = targetList.get(i - 1);
                if (target instanceof TohyorokuFuzui) {
                    氏名 = ((TohyorokuFuzui) target).get氏名().getColumnValue();
                } else if (target instanceof TachiaininHikitsugi) {
                    氏名 = ((TachiaininHikitsugi) target).get氏名().getColumnValue();
                } else if (target instanceof TohyojokyoDairishaSerachResult) {
                    氏名Cls = ((TohyojokyoDairishaSerachResult) target).getKanjiShimei();
                    氏名 = null != 氏名Cls ? 氏名Cls.getColumnValue() : RString.EMPTY;
                }
            }

            if (i % 4 == 1) {
                row = new dgTohyorokuShimeiNyuryoku_Row();
                row.getTxtShimei1().setValue(氏名);
            } else if (i % 4 == 2) {
                row.getTxtShimei2().setValue(氏名);
            } else if (i % 4 == 3) {
                row.getTxtShimei3().setValue(氏名);
            } else if (i % 4 == 0) {
                row.getTxtShimei4().setValue(氏名);
                rowList.add(row);
                row = new dgTohyorokuShimeiNyuryoku_Row();
            }
        }
        div.getDgTohyorokuShimeiNyuryoku().setDataSource(rowList);

        return true;
    }

    private List<?> get固定リスト(List<?> targetList, int endIndex) {
        if (null == targetList || targetList.isEmpty()) {
            return new ArrayList<>();
        }
        if (targetList.size() <= endIndex) {
            return targetList;
        }
        return new ArrayList<>(targetList.subList(0, endIndex));
    }

    /**
     * この共有子DIVの編集モードを設定する。
     *
     * @param editFlg editFlg
     */
    public void setEditMode(boolean editFlg) {
        div.getDgTohyorokuShimeiNyuryoku().setDisabled(editFlg);
    }
}
