/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGML1010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.ZaisankuSenkyojiTorokuResult;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojizaisanku.AFABTL101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.ZaisankuMeiboKoshinKijunDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.ZaisankuSenkyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.dgZaisankuJusho_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.dgZaisankuTohyoku_Row;
import jp.co.ndensan.reams.af.afa.service.core.zaisankusenkyojitoroku.ZaisankuSenkyojiTorokuManager;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.choiki.ChoikiItem;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 財産区議会議員選挙時登録handler
 *
 * @reamsid_L AF-0600-010 lis
 */
public class ZaisankuSenkyojiTorokuHandler {

    private final ZaisankuSenkyojiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 海区漁業調整委員会委員選挙人名簿登録Div
     */
    public ZaisankuSenkyojiTorokuHandler(ZaisankuSenkyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化情報の取得
     *
     * @param 選挙種類 Code
     */
    public void get画面情報(Code 選挙種類) {

        ZaisankuSenkyojiTorokuManager manager = new ZaisankuSenkyojiTorokuManager();
        List<ZaisankuSenkyojiTorokuResult> resultList = manager.get投票区情報By選挙種類(選挙種類);

        List<dgZaisankuTohyoku_Row> tohyokuRowList = div.getZaisankuJushoJoken().getDgZaisankuTohyoku().getDataSource();
        if (null != resultList && !resultList.isEmpty()) {
            for (ZaisankuSenkyojiTorokuResult result : resultList) {
                dgZaisankuTohyoku_Row tohyokuRow = new dgZaisankuTohyoku_Row();
                tohyokuRow.setTxtTohyokuCode(result.getTohyokuCode());
                tohyokuRow.setTxtTohyokuName(result.getTohyokuName());
                tohyokuRowList.add(tohyokuRow);
            }
            div.getZaisankuJushoJoken().getDgZaisankuTohyoku().setDataSource(tohyokuRowList);
        }

        div.getZaisankuSenkyojiTorokuParam().getDgZaisankuJusho()
                .setDataSource(get画面住所情報(manager.get住所情報(), new TohyokuCode(RString.EMPTY)));
    }

    /**
     * 画面住所情報の取得
     *
     * @param 住所情報 List<ChoikiItem>
     * @param 投票区コード TohyokuCode
     * @return List<dgZaisankuJusho_Row>
     */
    public List<dgZaisankuJusho_Row> get画面住所情報(List<ChoikiItem> 住所情報, TohyokuCode 投票区コード) {

        List<dgZaisankuJusho_Row> jushoRowList1 = new ArrayList();
        List<dgZaisankuJusho_Row> jushoRowList2 = new ArrayList();

        for (ChoikiItem item : 住所情報) {
            dgZaisankuJusho_Row jushoRow = new dgZaisankuJusho_Row();
            jushoRow.setTxtChoikiCode(item.get町域コード().getColumnValue());
            jushoRow.setTxtChoikiName(item.get漢字名称());
            if (投票区コード.equals(item.get投票区コード())) {
                jushoRowList1.add(jushoRow);
            }
            jushoRowList2.add(jushoRow);
        }
        if (!投票区コード.isEmpty()) {
            return jushoRowList1;
        } else {
            return jushoRowList2;
        }
    }

    /**
     * 新規処理と再処理ラジオボタンをクリック時画面情報の取得
     *
     * @param 抄本番号 ShohonNo
     */
    public void set再処理画面情報(ShohonNo 抄本番号) {

        ZaisankuSenkyojiTorokuManager manager = ZaisankuSenkyojiTorokuManager.createInstance();
        ZaisankuSenkyojiTorokuResult result = manager.get選挙情報(抄本番号);
        div.getZaisankuSenkyojiTorokuParam().getDgZaisankuJusho()
                .setDataSource(get画面住所情報(manager.get住所情報(), new TohyokuCode(RString.EMPTY)));

        if (null != result) {
            div.getZaisankuMeiboKoshinKijun().getTxtShohonName().setValue(result.getShohonName());
            div.getZaisankuMeiboKoshinKijun().getTxtTohyoYMD().setValue(new RDate(result.getTohyoYMD().toString()));
            div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD().setValue(new RDate(result.getKijunYMD().toString()));
            div.getZaisankuMeiboKoshinKijun().getTxtMeiboTorokuYMD().setValue(new RDate(result.getMeiboTorokuYMD().toString()));
            div.getZaisankuMeiboKoshinKijun().getTxtTenshutsuYMD().setValue(new RDate(result.getTenshutsuKigenYMD().toString()));
            div.getZaisankuMeiboKoshinKijun().getTxtTennyuYMD().setValue(new RDate(result.getTennyuKigenYMD().toString()));
            div.getZaisankuMeiboKoshinKijun().getTxtNenreiTotatsuYMD().setValue(new RDate(result.getKiteiNenreiTotatsuYMD().toString()));
            div.getZaisankuMeiboKoshinKijun().getTxtKyojuNensu().setValue(new Decimal(result.getKyojuNensu()));
            div.getZaisankuMeiboKoshinKijun().getTxtTohyoKaishiYMD().setValue(new RDate(result.getTohyoUketsukeYMD().toString()));
        } else {
            clearKijunPanel();
        }

        List<RString> 投票区コードリスト = manager.get投票区コード情報(抄本番号);
        List<dgZaisankuTohyoku_Row> tohyokuRowList = div.getZaisankuJushoJoken().getDgZaisankuTohyoku().getDataSource();
        List<dgZaisankuTohyoku_Row> shohonTohyokuList = new ArrayList();
        Map tohyokuMap = get投票区MAP(tohyokuRowList);
        for (RString 投票区コード : 投票区コードリスト) {
            if (tohyokuMap.containsKey(投票区コード)) {
                shohonTohyokuList.add((dgZaisankuTohyoku_Row) tohyokuMap.get(投票区コード));
            }
        }
        if (!shohonTohyokuList.isEmpty()) {
            div.getZaisankuJushoJoken().getDgZaisankuTohyoku().setSelectedItems(shohonTohyokuList);
        } else {
            clearDataGridTohyoku();
        }

        List<ChoikiCode> 町域コードリスト = manager.get町域コード情報(抄本番号);
        List<dgZaisankuJusho_Row> jushoRowList = div.getZaisankuSenkyojiTorokuParam().getDgZaisankuJusho().getDataSource();
        List<dgZaisankuJusho_Row> shohonJushoList = new ArrayList();
        Map choikiMap = get町域MAP(jushoRowList);
        for (ChoikiCode 町域コード : 町域コードリスト) {
            if (choikiMap.containsKey(new RString(町域コード.toString()))) {
                shohonJushoList.add((dgZaisankuJusho_Row) choikiMap.get(new RString(町域コード.toString())));
            }
        }
        if (!shohonJushoList.isEmpty()) {
            div.getZaisankuSenkyojiTorokuParam().getDgZaisankuJusho().setSelectedItems(shohonJushoList);
        } else {
            clearDataGridJusho();
        }
    }

    /**
     * 新規処理時画面情報のクリア
     *
     */
    public void clearKijunPanel() {

        div.getZaisankuMeiboKoshinKijun().getTxtShohonName().clearValue();
        div.getZaisankuMeiboKoshinKijun().getTxtTohyoYMD().clearValue();
        div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD().clearValue();
        div.getZaisankuMeiboKoshinKijun().getTxtMeiboTorokuYMD().clearValue();
        div.getZaisankuMeiboKoshinKijun().getTxtTenshutsuYMD().clearValue();
        div.getZaisankuMeiboKoshinKijun().getTxtTennyuYMD().clearValue();
        div.getZaisankuMeiboKoshinKijun().getTxtNenreiTotatsuYMD().clearValue();
        div.getZaisankuMeiboKoshinKijun().getTxtKyojuNensu().clearValue();
        div.getZaisankuMeiboKoshinKijun().getTxtTohyoKaishiYMD().clearValue();
    }

    /**
     * 新規処理時画面情報のクリア
     *
     */
    public void clearDataGridTohyoku() {

        List<dgZaisankuTohyoku_Row> shohonTohyokuList = new ArrayList();
        div.getZaisankuJushoJoken().getDgZaisankuTohyoku().setSelectedItems(shohonTohyokuList);
    }

    /**
     * 新規処理時画面情報のクリア
     *
     */
    public void clearDataGridJusho() {

        List<dgZaisankuJusho_Row> shohonJushoList = new ArrayList();
        div.getZaisankuSenkyojiTorokuParam().getDgZaisankuJusho().setSelectedItems(shohonJushoList);
    }

    /**
     * 「実行する」ボタン押下のチェックする。
     *
     * @return param AFABTL101BatchParameter
     */
    public AFABTL101BatchParameter setバッチパラメータ() {

        ZaisankuMeiboKoshinKijunDiv zaisankuDiv = div.getZaisankuMeiboKoshinKijun();
        AFABTL101BatchParameter param = new AFABTL101BatchParameter();
        param.set処理種別(zaisankuDiv.getRadShori().getSelectedKey());
        param.set抄本番号(zaisankuDiv.getCcdShohonNameList().getSelectedShohonNo());
        param.set抄本名(zaisankuDiv.getTxtShohonName().getText());
        param.set投票日(new FlexibleDate(zaisankuDiv.getTxtTohyoYMD().getText()));
        param.set基準日(new FlexibleDate(zaisankuDiv.getTxtKijunYMD().getText()));
        param.set登録日(new FlexibleDate(zaisankuDiv.getTxtMeiboTorokuYMD().getText()));
        param.set転出期限日(new FlexibleDate(zaisankuDiv.getTxtTenshutsuYMD().getText()));
        param.set転入期限日(new FlexibleDate(zaisankuDiv.getTxtTennyuYMD().getText()));
        param.set年齢期限日(new FlexibleDate(zaisankuDiv.getTxtNenreiTotatsuYMD().getText()));
        if (null != zaisankuDiv.getTxtKyojuNensu().getText() && !zaisankuDiv.getTxtKyojuNensu().getText().isEmpty()) {
            param.set財産区内居住年数(Integer.parseInt(zaisankuDiv.getTxtKyojuNensu().getText().toString()));
        }
        param.set投票開始日(new FlexibleDate(zaisankuDiv.getTxtTohyoKaishiYMD().getText()));

        List<dgZaisankuTohyoku_Row> tohyokuRowList = div.getZaisankuJushoJoken().getDgZaisankuTohyoku().getSelectedItems();
        if (!tohyokuRowList.isEmpty()) {
            List<RString> tohyokuCdList = new ArrayList();
            for (dgZaisankuTohyoku_Row row : tohyokuRowList) {
                tohyokuCdList.add(row.getTxtTohyokuCode());
            }
            param.set対象者住所条件選択レコードリスト(tohyokuCdList);
        }

        List<dgZaisankuJusho_Row> jushoRowList = div.getZaisankuSenkyojiTorokuParam().getDgZaisankuJusho().getSelectedItems();
        if (!jushoRowList.isEmpty()) {
            List<RString> choikiCdList = new ArrayList();
            for (dgZaisankuJusho_Row row : jushoRowList) {
                choikiCdList.add(row.getTxtChoikiCode());
            }
            param.set詳細指定選択レコードリスト(choikiCdList);
        }

        param.set選挙人名簿抄本有無(div.getZaisankuSakuseiChohyo().getZaisankuSakuseiChohyoMeiboShohon().isIsPublish());

        return param;
    }

    private Map get投票区MAP(List<dgZaisankuTohyoku_Row> tohyokuRowList) {

        Map<RString, dgZaisankuTohyoku_Row> map = new HashMap<>();

        if (null != tohyokuRowList && !tohyokuRowList.isEmpty()) {
            for (dgZaisankuTohyoku_Row row : tohyokuRowList) {
                RString 投票区コード = row.getTxtTohyokuCode();
                map.put(投票区コード, row);
            }
        }

        return map;
    }

    private Map get町域MAP(List<dgZaisankuJusho_Row> jushoRowList) {

        Map<RString, dgZaisankuJusho_Row> map = new HashMap<>();

        if (null != jushoRowList && !jushoRowList.isEmpty()) {
            for (dgZaisankuJusho_Row row : jushoRowList) {
                RString 投票区コード = row.getTxtChoikiCode();
                map.put(投票区コード, row);
            }
        }

        return map;
    }
}
