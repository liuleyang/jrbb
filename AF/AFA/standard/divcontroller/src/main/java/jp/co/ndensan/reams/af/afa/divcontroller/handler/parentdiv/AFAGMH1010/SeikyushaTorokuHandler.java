/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SeikyuDaihyoshaShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.core.seikyushatoroku.SeikyushaTorokuJoho;
import jp.co.ndensan.reams.af.afa.business.seikyushatoroku.SeikyuDaihyoshaGamenData;
import jp.co.ndensan.reams.af.afa.business.seikyushatoroku.SeikyushaTorokuGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyushaTorokuEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.SeikyushaTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.SeikyushaTorokuNaiyoNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.dgSeikyushaTorokuDaihyoshaIchiran_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.dgSeikyushaTorokuSeikyuIchiran_Row;
import jp.co.ndensan.reams.af.afa.service.core.seikyushatoroku.SeikyushaTorokuManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 請求代表者証明書交付
 *
 * @reamsid_L AF-0140-010 wangh
 */
public class SeikyushaTorokuHandler {

    private final SeikyushaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SeikyushaTorokuDiv
     */
    public SeikyushaTorokuHandler(SeikyushaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 一覧データを取得処理。
     *
     * @return List<dgSeikyushaTorokuSeikyuIchiran_Row>
     */
    public List<dgSeikyushaTorokuSeikyuIchiran_Row> get一覧データ() {

        SeikyushaTorokuManager manager = SeikyushaTorokuManager.createInstance();
        List<SeikyushaTorokuGamenData> 検索結果List = manager.get直接請求一覧データ();
        List<dgSeikyushaTorokuSeikyuIchiran_Row> rowList = new ArrayList();
        if (!検索結果List.isEmpty()) {
            for (SeikyushaTorokuGamenData 検索結果 : 検索結果List) {
                dgSeikyushaTorokuSeikyuIchiran_Row row = new dgSeikyushaTorokuSeikyuIchiran_Row();
                if (検索結果.isTorokuZumiFlag()) {
                    row.setTxtShomeiboSakusei(SeikyushaTorokuEnum.署名簿作成.getValue());
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                }
                row.setTxtSeikyuName(検索結果.getSeikyuMei());
                FlexibleDate 請求年月日 = 検索結果.getSeikyuYMD();
                row.getTxtSeikyuYMD().setValue(請求年月日 == null || 請求年月日.isEmpty() ? null : new RDate(請求年月日.toString()));
                FlexibleDate 交付年月日 = 検索結果.getKofuYMD();
                row.getTxtKofuYMD().setValue(交付年月日 == null || 交付年月日.isEmpty() ? null : new RDate(交付年月日.toString()));
                FlexibleDate 提出期限年月日 = 検索結果.getTeishutsuKigenYMD();
                if (null != 提出期限年月日 && !提出期限年月日.isEmpty()) {
                    row.getTxtTeishutsuKigenYMD().setValue(new RDate(提出期限年月日.toString()));
                }
                if (edit提出期限年月日チェック(提出期限年月日)) {
                    row.setModifyButtonState(DataGridButtonState.Disabled);
                }
                row.getTxtTeishutsuKigenYMD().setValue(提出期限年月日 == null || 提出期限年月日.isEmpty()
                        ? null : new RDate(提出期限年月日.toString()));
                row.setTxtKofuSoshiki(検索結果.getKofuSoshikiCodeMeisho());
                row.setTxtSeikyuNaiyo(検索結果.getSeikyuNaiyo());
                row.setTxtSeikyuNo(new RString(検索結果.getSeikyuNo()));
                ShohonNo 抄本番号 = 検索結果.getShohonNo();
                if (null != 抄本番号) {
                    row.setTxtShohonNo(new RString(抄本番号.getColumnValue()));
                }
                rowList.add(row);
            }
        }

        return rowList;
    }

    /**
     * 交付組織リスト取得処理。
     */
    public void get交付組織リスト() {

        List<UzT0007CodeEntity> codeEntityList = CodeMaster.getCode(SubGyomuCode.AFA選挙本体,
                new CodeShubetsu(SeikyushaTorokuEnum.地方公共団体.getValue()));
        List<KeyValueDataSource> datalist = new ArrayList();
        if (!codeEntityList.isEmpty()) {
            for (UzT0007CodeEntity entity : codeEntityList) {
                KeyValueDataSource datasource = new KeyValueDataSource();
                datasource.setKey(entity.getコード().getColumnValue());
                datasource.setValue(entity.getコード名称());
                datalist.add(datasource);
            }
            div.getSeikyushaTorokuNaiyoNyuryoku().getDdlKofuSoshiki().setDataSource(datalist);
            div.getSeikyushaTorokuNaiyoNyuryoku().getDdlKofuSoshiki().setSelectedValue(codeEntityList.get(0).getコード名称());
            div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofushaName().setValue(codeEntityList.get(0).getオプション１());
        }
    }

    /**
     * 交付者名取得処理。
     *
     * @param 交付コード RString
     */
    public void get交付者名(RString 交付コード) {

        List<UzT0007CodeEntity> codeEntityList = CodeMaster.getCode(SubGyomuCode.AFA選挙本体,
                new CodeShubetsu(SeikyushaTorokuEnum.地方公共団体.getValue()));
        if (!codeEntityList.isEmpty()) {
            for (UzT0007CodeEntity entity : codeEntityList) {
                if (交付コード.equals(entity.getコード().getColumnValue())) {
                    div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofushaName().setValue(entity.getオプション１());
                }
            }
        }
    }

    /**
     * 交付者名取得処理。
     */
    public void set請求内容入力() {

        SeikyushaTorokuManager manager = SeikyushaTorokuManager.createInstance();
        get交付組織リスト();
        RString 直接請求番号 = div.getTxtHdnSeikyuNo();
        List<SeikyushaTorokuJoho> 請求代表者リスト = manager.get請求代表者一覧(Integer.valueOf(直接請求番号.toString()));
        List<dgSeikyushaTorokuDaihyoshaIchiran_Row> rowlist = div.getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource();
        if (null != 請求代表者リスト && !請求代表者リスト.isEmpty()) {
            for (SeikyushaTorokuJoho seikyushaJoho : 請求代表者リスト) {
                dgSeikyushaTorokuDaihyoshaIchiran_Row row = new dgSeikyushaTorokuDaihyoshaIchiran_Row();
                row.setTxtShimei(seikyushaJoho.get氏名());
                row.setTxtSeibetsu(seikyushaJoho.get性別名称());
                row.setTxtSeinengappiYMD(seikyushaJoho.get生年月日());
                row.setTxtJusho(seikyushaJoho.get住所());
                row.setTxtSenkyoShikaku(seikyushaJoho.get選挙資格名称());
                row.setTxtJuminShubetsu(seikyushaJoho.get住民種別名称());
                row.setTxtShikibetsuCode(seikyushaJoho.get識別コード());
                rowlist.add(row);
            }
        }
        div.getDgSeikyushaTorokuDaihyoshaIchiran().setDataSource(rowlist);

        SeikyushaTorokuGamenData 検索結果 = manager.get直接請求データ(Integer.valueOf(直接請求番号.toString()));
        div.setHidMotoData(new RString(Base64Serializer.serialize(検索結果)));
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuYMD().setValue(new RDate(検索結果.getSeikyuYMD().toString()));
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuName().setValue(検索結果.getSeikyuMei());
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuNaiyo().setValue(検索結果.getSeikyuNaiyo());
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD().setValue(new RDate(検索結果.getKofuYMD().toString()));
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtTeishutsuKigenYMD().setValue(new RDate(検索結果.getTeishutsuKigenYMD().toString()));

        RString 交付コード = 検索結果.getKofuSoshikiCode().getColumnValue();
        div.getSeikyushaTorokuNaiyoNyuryoku().getDdlKofuSoshiki().setSelectedKey(交付コード);
        get交付者名(交付コード);

    }

    /**
     * 画面から入力したデータを直接請求と直接請求代表者に保存する。
     *
     * @return SeikyushaTorokuGamenData
     */
    public SeikyushaTorokuGamenData set直接請求データ() {
        SeikyushaTorokuGamenData gamenData = new SeikyushaTorokuGamenData();
        SeikyushaTorokuNaiyoNyuryokuDiv nykDiv = div.getSeikyushaTorokuNaiyoNyuryoku();
        gamenData = set入力直接請求データ(nykDiv, gamenData);
        int 直接請求番号 = Integer.parseInt(String.valueOf(
                Saiban.get(SubGyomuCode.AFA選挙本体, SeikyushaTorokuEnum.汎用キー.getValue()).next()));
        gamenData.setSeikyuNo(直接請求番号);
        gamenData.setTorokuZumiFlag(false);
        gamenData.setShohonNo(new ShohonNo(SeikyushaTorokuEnum.INSERT用抄本番号.getValue()));

        List<dgSeikyushaTorokuDaihyoshaIchiran_Row> rowList = div.
                getSeikyushaTorokuDaihyosha().getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            List<ShikibetsuCode> shikibetsuCdList = distinct直接請求代表者(rowList);
            List<SeikyuDaihyoshaGamenData> seikyushaList = new ArrayList();
            for (ShikibetsuCode shikibetsu : shikibetsuCdList) {
                SeikyuDaihyoshaGamenData seikyushaData = new SeikyuDaihyoshaGamenData();
                seikyushaData.setSeikyuNo(直接請求番号);
                seikyushaData.setSeikyuShikibetsuCode(shikibetsu);
                seikyushaData.setState(EntityDataState.Added);
                seikyushaList.add(seikyushaData);
            }
            gamenData.setSeikyushaList(seikyushaList);
        }

        return gamenData;
    }

    /**
     * 画面から選択したデータを直接請求と直接請求代表者に変更する。
     *
     * @return SeikyushaTorokuGamenData
     */
    public SeikyushaTorokuGamenData set修正後直接請求データ() {

        SeikyushaTorokuNaiyoNyuryokuDiv nykDiv = div.getSeikyushaTorokuNaiyoNyuryoku();
        dgSeikyushaTorokuSeikyuIchiran_Row row = div.getDgSeikyushaTorokuSeikyuIchiran().getClickedItem();
        SeikyushaTorokuGamenData gamenData = Base64Serializer.deSerialize(
                div.getHidMotoData().toString(), SeikyushaTorokuGamenData.class);
        int 直接請求番号 = Integer.valueOf(row.getTxtSeikyuNo().toString());
        gamenData = set入力直接請求データ(nykDiv, gamenData);
        gamenData.setState(EntityDataState.Modified);

        List<dgSeikyushaTorokuDaihyoshaIchiran_Row> rowList = div.
                getSeikyushaTorokuDaihyosha().getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            List<ShikibetsuCode> shikibetsuCdList = distinct直接請求代表者(rowList);
            List<SeikyuDaihyoshaGamenData> seikyushaList = new ArrayList();
            for (ShikibetsuCode shikibetsu : shikibetsuCdList) {
                SeikyuDaihyoshaGamenData seikyushaData = new SeikyuDaihyoshaGamenData();
                seikyushaData.setSeikyuNo(直接請求番号);
                seikyushaData.setSeikyuShikibetsuCode(shikibetsu);
                seikyushaData.setState(EntityDataState.Added);
                seikyushaList.add(seikyushaData);
            }
            gamenData.setSeikyushaList(seikyushaList);
        }

        return gamenData;
    }

    /**
     * 請求代表者証明書交付の画面制御を設定します。
     *
     */
    public void set地区別の画面制御() {
        if (!ResponseHolder.isReRequest()) {
            div.getSeikyushaTorokuDaihyosha().setDisplayNone(true);
            div.getSeikyushaTorokuNaiyoNyuryoku().setDisplayNone(true);
        }
    }

    /**
     * 検索結果を一覧に設定します。
     *
     * @param 識別コード ShikibetsuCode
     * @param rowlist List<dgSeikyushaTorokuDaihyoshaIchiran_Row>
     * @return dgSeikyushaTorokuDaihyoshaIchiran_Row
     */
    public List<dgSeikyushaTorokuDaihyoshaIchiran_Row> get請求代表者一覧(
            ShikibetsuCode 識別コード,
            List<dgSeikyushaTorokuDaihyoshaIchiran_Row> rowlist) {

        SeikyushaTorokuManager manager = SeikyushaTorokuManager.createInstance();
        List<SeikyushaTorokuJoho> seikyushaJoholist = manager.get検索結果一覧(識別コード);
        if (!seikyushaJoholist.isEmpty()) {
            for (SeikyushaTorokuJoho seikyushaJoho : seikyushaJoholist) {
                dgSeikyushaTorokuDaihyoshaIchiran_Row row = new dgSeikyushaTorokuDaihyoshaIchiran_Row();
                row.setTxtShimei(seikyushaJoho.get氏名());
                row.setTxtSeibetsu(seikyushaJoho.get性別名称());
                row.setTxtSeinengappiYMD(seikyushaJoho.get生年月日());
                row.setTxtJusho(seikyushaJoho.get住所());
                row.setTxtSenkyoShikaku(seikyushaJoho.get選挙資格名称());
                row.setTxtJuminShubetsu(seikyushaJoho.get住民種別名称());
                row.setTxtShikibetsuCode(seikyushaJoho.get識別コード());
                rowlist.add(row);
            }
        }
        return rowlist;
    }

    /**
     * 検索結果を一覧に設定します。
     *
     * @param btn RString
     */
    public void get画面制御(RString btn) {
        if (SeikyushaTorokuEnum.新規制御.getValue().equals(btn)) {
            div.getSeikyushaTorokuSeikyuList().setDisabled(true);
            div.getSeikyushaTorokuDaihyosha().setDisabled(false);
            div.getSeikyushaTorokuDaihyosha().setDisplayNone(false);
            div.getSeikyushaTorokuNaiyoNyuryoku().setDisplayNone(false);
            div.getSeikyushaTorokuNaiyoNyuryoku().getBtnAddNew().setText(SeikyushaTorokuEnum.追加_YES.getValue());
            div.getSeikyushaTorokuNaiyoNyuryoku().getBtnStop().setText(SeikyushaTorokuEnum.追加_NO.getValue());
        } else if (SeikyushaTorokuEnum.修正制御.getValue().equals(btn)) {
            div.getSeikyushaTorokuSeikyuList().setDisabled(true);
            div.getSeikyushaTorokuDaihyosha().setDisabled(false);
            div.getSeikyushaTorokuDaihyosha().setDisplayNone(false);
            div.getSeikyushaTorokuNaiyoNyuryoku().setDisplayNone(false);
            div.getSeikyushaTorokuNaiyoNyuryoku().getBtnAddNew().setText(SeikyushaTorokuEnum.修正_YES.getValue());
            div.getSeikyushaTorokuNaiyoNyuryoku().getBtnStop().setText(SeikyushaTorokuEnum.修正_NO.getValue());
        } else if (SeikyushaTorokuEnum.削除制御.getValue().equals(btn)) {
            div.getSeikyushaTorokuSeikyuList().setDisabled(true);
            div.getSeikyushaTorokuDaihyosha().setDisabled(true);
            div.getSeikyushaTorokuDaihyosha().setDisplayNone(false);
            div.getSeikyushaTorokuNaiyoNyuryoku().setDisplayNone(false);
            div.getSeikyushaTorokuNaiyoNyuryoku().getBtnAddNew().setText(SeikyushaTorokuEnum.削除_YES.getValue());
            div.getSeikyushaTorokuNaiyoNyuryoku().getBtnStop().setText(SeikyushaTorokuEnum.削除_NO.getValue());
        }
    }

    /**
     * 請求代表者証明書帳票を出力
     *
     * @return List<SeikyuDaihyoshaShomeishoParam>
     */
    public List<SeikyuDaihyoshaShomeishoParam> print請求代表者証明書() {

        List<SeikyuDaihyoshaShomeishoParam> paramList = new ArrayList();
        List<RString> 氏名リスト = new ArrayList();
        List<dgSeikyushaTorokuDaihyoshaIchiran_Row> rowList = div.
                getSeikyushaTorokuDaihyosha().getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource();
        if (!rowList.isEmpty()) {

            for (dgSeikyushaTorokuDaihyoshaIchiran_Row row : rowList) {
                氏名リスト.add(row.getTxtShimei());
            }
        }
        RString 請求名 = div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuName().getText();
        RDate 交付日 = div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD().getValue();
        SeikyuDaihyoshaShomeishoParam param = new SeikyuDaihyoshaShomeishoParam(氏名リスト, 請求名, 交付日);
        paramList.add(param);

        return paramList;
    }

    /**
     * 初期化以外状態。
     *
     */
    public void set初期化以外状態() {
        div.getSeikyushaTorokuSeikyuList().setDisabled(true);
        div.getSeikyushaTorokuDaihyosha().setDisplayNone(false);
        div.getSeikyushaTorokuNaiyoNyuryoku().setDisplayNone(false);
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuName().clearValue();
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuNaiyo().clearValue();
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD().clearValue();
        div.getSeikyushaTorokuNaiyoNyuryoku().getTxtTeishutsuKigenYMD().clearValue();
        div.getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource().clear();
    }

    /**
     * 初期化状態。
     *
     */
    public void set初期化状態() {
        div.getSeikyushaTorokuSeikyuList().setDisabled(false);
        div.getSeikyushaTorokuDaihyosha().setDisplayNone(true);
        div.getSeikyushaTorokuNaiyoNyuryoku().setDisplayNone(true);
    }

    private boolean edit提出期限年月日チェック(FlexibleDate date) {
        boolean checkFlg = false;
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        if (null != date && !date.isEmpty() && date.isBefore(システム日付)) {
            checkFlg = true;
        }
        return checkFlg;
    }

    private SeikyushaTorokuGamenData set入力直接請求データ(SeikyushaTorokuNaiyoNyuryokuDiv nykDiv, SeikyushaTorokuGamenData gamenData) {

        gamenData.setSeikyuYMD(new FlexibleDate(nykDiv.getTxtSeikyuYMD().getValue().toDateString()));
        gamenData.setSeikyuMei(nykDiv.getTxtSeikyuName().getValue());
        gamenData.setSeikyuNaiyo(nykDiv.getTxtSeikyuNaiyo().getValue());
        gamenData.setKofuYMD(new FlexibleDate(nykDiv.getTxtKofuYMD().getValue().toDateString()));
        gamenData.setTeishutsuKigenYMD(new FlexibleDate(nykDiv.getTxtTeishutsuKigenYMD().getValue().toDateString()));
        gamenData.setKofuSoshikiCode(new Code(nykDiv.getDdlKofuSoshiki().getSelectedKey()));

        return gamenData;
    }

    private List<ShikibetsuCode> distinct直接請求代表者(List<dgSeikyushaTorokuDaihyoshaIchiran_Row> rowList) {

        List<ShikibetsuCode> shikibetsuCdList = new ArrayList();
        for (dgSeikyushaTorokuDaihyoshaIchiran_Row row : rowList) {
            if (!shikibetsuCdList.contains(new ShikibetsuCode(row.getTxtShikibetsuCode()))) {
                shikibetsuCdList.add(new ShikibetsuCode(row.getTxtShikibetsuCode()));
            }
        }
        return shikibetsuCdList;
    }
}
