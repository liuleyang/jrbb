/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.maisukanri.TohyoYoshiMaisuKanri;
import jp.co.ndensan.reams.af.afa.business.maisukanri.TohyoYoshiMaisuSearchResult;
import jp.co.ndensan.reams.af.afa.business.maisukanri.TohyoYoshiMaisuSearchResultList;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5060.MaisuKanriDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5060.dgMaisuInput_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5060.dgMaisuSenkyoList_Row;
import jp.co.ndensan.reams.af.afa.service.core.maisukanri.MaisuKanriManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 投票用紙枚数管理に対応するHandlerクラスです
 *
 * @reamsid_L AF-0660-010 zhanggs
 */
public class MaisuKanriHandler {

    private final MaisuKanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div MaisuKanriDiv
     */
    public MaisuKanriHandler(MaisuKanriDiv div) {
        this.div = div;
    }

    /**
     * 投票用紙枚数管理のHandler初期化
     *
     * @param div MaisuKanriDiv
     * @return MaisuKanriHandler
     */
    public static MaisuKanriHandler of(MaisuKanriDiv div) {
        return new MaisuKanriHandler(div);
    }

    /**
     * 画面_選挙グリッドを取得メソードイベントです。
     *
     * @param shohonNo RString
     */
    public void 画面_選挙グリッド(RString shohonNo) {
        初期化画面の状態();
        List<dgMaisuSenkyoList_Row> list = new ArrayList<>();
        MaisuKanriManager manager = MaisuKanriManager.createInstance();
        List<Senkyo> senkyoList = manager.get選挙By抄本番号(new ShohonNo(shohonNo));
        if (!senkyoList.isEmpty()) {
            dgMaisuSenkyoList_Row maisu;
            for (Senkyo senkyo : senkyoList) {
                maisu = new dgMaisuSenkyoList_Row();
                maisu.setTxtSenkyoNo(new RString(senkyo.get選挙番号().toString()));
                maisu.setTxtSenkyoName(senkyo.get選挙名称());
                list.add(maisu);
            }
        }
        div.getDgMaisuSenkyoList().setDataSource(list);
    }

    private void 初期化画面の状態() {
        div.getCcdShohonNameList().setDisabled(false);
        div.getDgMaisuSenkyoList().setDisabled(false);
        div.getMaisuInput().setDisplayNone(true);
    }

    /**
     * 画面_選挙グリッドを取得メソードイベントです。
     *
     *
     */
    public void 画面_投票用紙枚数入力エリア初期化() {
        RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
        SenkyoShurui 選挙種類 = div.getCcdShohonNameList().getSelectedSenkyoShurui();
        RString 選挙番号 = div.getDgMaisuSenkyoList().getClickedItem().getTxtSenkyoNo();

        List<TohyoYoshiMaisuSearchResult> tohyoYo = 画面_投票用紙枚数取得(抄本番号, 選挙種類, 選挙番号);

        TohyoYoshiMaisuKanri tohyoYoshi = new TohyoYoshiMaisuKanri();
        tohyoYoshi.setEntities(tohyoYo);
        ViewStateHolder.put(ViewStateKeys.投票用紙枚数管理, tohyoYoshi);

        div.getCcdShohonNameList().setDisabled(true);
        div.getDgMaisuSenkyoList().setDisabled(true);
        setDisableMode(false);
    }

    /**
     * 画面_選挙グリッドを取得メソードイベントです。
     *
     * @param 抄本番号 RString
     * @param 選挙種類 SenkyoShurui
     * @param 選挙番号 RString
     * @return List<TohyoYoshiMaisuSearchResult>
     */
    public List<TohyoYoshiMaisuSearchResult> 画面_投票用紙枚数取得(RString 抄本番号, SenkyoShurui 選挙種類, RString 選挙番号) {
        MaisuKanriManager manager = MaisuKanriManager.createInstance();
        List<TohyoYoshiMaisuSearchResult> list = manager.get投票用紙枚数リスト(抄本番号, 選挙種類, 選挙番号);

        List<dgMaisuInput_Row> dgMaisuInputList = new ArrayList<>();
        TohyoYoshiMaisuSearchResultList motoList = new TohyoYoshiMaisuSearchResultList();
        dgMaisuInput_Row dgMaisuInputEntity;

        for (TohyoYoshiMaisuSearchResult maisu : list) {
            dgMaisuInputEntity = new dgMaisuInput_Row();
            dgMaisuInputEntity.setTxtTohyokuCode(maisu.get投票区コード());
            dgMaisuInputEntity.getTxtTohyoYoshiMaisu().setValue(new Decimal(maisu.getEntity().getAfT251Entity().getTohyoYoshiMaisu()));
            dgMaisuInputEntity.getTxtTenjiYoshiMaisu().setValue(new Decimal(maisu.getEntity().getAfT251Entity().getTenjiYoshiMaisu()));
            dgMaisuInputEntity.getTxtKariFutoMaisu().setValue(new Decimal(maisu.getEntity().getAfT251Entity().getKariFutoMaisu()));
            dgMaisuInputEntity.setHidMotoData(new RString(Base64Serializer.serialize(maisu)));

            dgMaisuInputList.add(dgMaisuInputEntity);
        }
        div.getDgMaisuInput().getDataSource().addAll(dgMaisuInputList);
        motoList.set投票用紙枚数リスト(list);
        div.setHidMaisuKanriMoto(new RString(Base64Serializer.serialize(motoList)));

        return list;
    }

    /**
     * 保存するボタンのinsert投票用紙枚数管理イベントです。
     *
     * @param 投票情報 TohyoYoshiMaisuSearchResultList
     */
    public void save投票用紙枚数管理(TohyoYoshiMaisuSearchResultList 投票情報) {
        投票用紙枚数入力再付値(投票情報);

        MaisuKanriManager manager = MaisuKanriManager.createInstance();
        manager.save投票用紙枚数管理(投票情報);

    }

    private void 投票用紙枚数入力再付値(TohyoYoshiMaisuSearchResultList 投票情報) {
        List<dgMaisuInput_Row> dataSource = div.getDgMaisuInput().getDataSource();
        for (int i = 0; i < dataSource.size(); i++) {
            RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
            RString 選挙番号 = div.getDgMaisuSenkyoList().getClickedItem().getTxtSenkyoNo();
            投票情報.get投票用紙枚数リスト().get(i).getEntity().getAfT251Entity().setShohonNo(new ShohonNo(抄本番号));
            投票情報.get投票用紙枚数リスト().get(i).getEntity().getAfT251Entity().setSenkyoNo(new SenkyoNo(選挙番号));
            投票情報.get投票用紙枚数リスト().get(i).getEntity().getAfT251Entity().setKariFutoMaisu(decimal転化Int(dataSource.get(i).getTxtKariFutoMaisu().getValue()));
            投票情報.get投票用紙枚数リスト().get(i).getEntity().getAfT251Entity().setTenjiYoshiMaisu(decimal転化Int(dataSource.get(i).getTxtTenjiYoshiMaisu().getValue()));
            投票情報.get投票用紙枚数リスト().get(i).getEntity().getAfT251Entity().setTohyoYoshiMaisu(decimal転化Int(dataSource.get(i).getTxtTohyoYoshiMaisu().getValue()));
        }
    }

    private int decimal転化Int(Decimal 変換データ) {
        if (null != 変換データ) {
            return Integer.valueOf(変換データ.toString());
        }
        return 0;
    }

    /**
     * 投票用紙枚数入力エリアの「入力をやめるボタン」を使用可能にし、他の入力項目とボタンを非活性にする。
     *
     * @param flg Boolean
     */
    public void setDisableMode(Boolean flg) {
        if (flg) {
            div.getDgMaisuInput().getGridSetting().getColumn("txtTohyoYoshiMaisu").getCellDetails().setReadOnly(Boolean.TRUE);
            div.getDgMaisuInput().getGridSetting().getColumn("txtTenjiYoshiMaisu").getCellDetails().setReadOnly(Boolean.TRUE);
            div.getDgMaisuInput().getGridSetting().getColumn("txtKariFutoMaisu").getCellDetails().setReadOnly(Boolean.TRUE);
            div.getBtnUpdate().setDisabled(Boolean.TRUE);
        } else {
            div.getDgMaisuInput().getGridSetting().getColumn("txtTohyoYoshiMaisu").getCellDetails().setReadOnly(Boolean.FALSE);
            div.getDgMaisuInput().getGridSetting().getColumn("txtTenjiYoshiMaisu").getCellDetails().setReadOnly(Boolean.FALSE);
            div.getDgMaisuInput().getGridSetting().getColumn("txtKariFutoMaisu").getCellDetails().setReadOnly(Boolean.FALSE);
            div.getBtnUpdate().setDisabled(Boolean.FALSE);
        }
    }

    /**
     * 投票用紙枚数入力エリアEntity化
     *
     * @return Boolean
     */
    public List<TohyoYoshiMaisuSearchResult> 投票用紙枚数入力エリアEntity化() {
        List<dgMaisuInput_Row> dgMaisuInputList = div.getMaisuInput().getDgMaisuInput().getDataSource();
        List<TohyoYoshiMaisuSearchResult> tempTohyoYo = new ArrayList<>();
        TohyoYoshiMaisuSearchResult tohyo;
        for (dgMaisuInput_Row dg : dgMaisuInputList) {
            tohyo = new TohyoYoshiMaisuSearchResult();
            tohyo.set投票区コード(dg.getTxtTohyokuCode());
            tohyo.set投票用紙枚数(Integer.valueOf(changeEmptyToZero(dg.getTxtTohyoYoshiMaisu().getText()).toString()));
            tohyo.set点字投票用紙枚数(Integer.valueOf(changeEmptyToZero(dg.getTxtTenjiYoshiMaisu().getText()).toString()));
            tohyo.set仮投票用封筒枚数(Integer.valueOf(changeEmptyToZero(dg.getTxtKariFutoMaisu().getText()).toString()));

            tempTohyoYo.add(tohyo);
        }
        return tempTohyoYo;
    }

    /**
     * 投票用紙枚数入力エリアのデータとDB既存データ比較<br>
     *
     * @return Boolean
     */
    public Boolean 投票用紙枚数入力エリアとDB比較結果() {
        List<TohyoYoshiMaisuSearchResult> tempTohyoYo = 投票用紙枚数入力エリアEntity化();
        TohyoYoshiMaisuKanri tohyoYoshiTemp = ViewStateHolder.get(ViewStateKeys.投票用紙枚数管理, TohyoYoshiMaisuKanri.class);
        List<TohyoYoshiMaisuSearchResult> tohyoYoshi = tohyoYoshiTemp.getEntities();

        return 対象比較(tempTohyoYo, tohyoYoshi);
    }

    /**
     * 投票用紙枚数入力エリアのデータとDB既存データ比較<br>
     *
     * @param tempTohyoYo List<TohyoYoshiMaisuSearchResult>
     * @param tohyoYoshi List<TohyoYoshiMaisuSearchResult>
     * @return Boolean
     */
    public Boolean 対象比較(List<TohyoYoshiMaisuSearchResult> tempTohyoYo, List<TohyoYoshiMaisuSearchResult> tohyoYoshi) {
        Boolean flg = false;
        for (int i = 0; i < tempTohyoYo.size(); i++) {
            if (tempTohyoYo.get(i).get投票用紙枚数() == tohyoYoshi.get(i).get投票用紙枚数()
                    && tempTohyoYo.get(i).get点字投票用紙枚数() == tohyoYoshi.get(i).get点字投票用紙枚数()
                    && tempTohyoYo.get(i).get仮投票用封筒枚数() == tohyoYoshi.get(i).get仮投票用封筒枚数()) {
                flg = true;
            } else {
                flg = false;
                break;
            }
        }
        return flg;

    }

    private RString changeEmptyToZero(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? new RString(0) : 文字列;
    }

}
