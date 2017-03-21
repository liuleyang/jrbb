/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture.AfT252Result;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture.MochidashiPcJotaiKanriResult;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture.TakeOutPcDataCaptureResult;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipcimportuketsukedata.AFABTE803BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.横線;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.カンマ;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.抄本ファイル名;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.投票状況ファイル名;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.TakeOutPcDataCaptureDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.dgResult_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.dgShohonSenkyo_Row;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;

/**
 * TakeOutPcDataCaptureDivに対応するHandlerクラスです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public class TakeOutPcDataCaptureHandler {

    private final TakeOutPcDataCaptureDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TakeOutPcDataCaptureDiv
     */
    public TakeOutPcDataCaptureHandler(TakeOutPcDataCaptureDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param メニューID RString
     */
    public void onLoad(RString メニューID) {
    }

    /**
     * 投票日リストから、画面内容をセットする。
     *
     * @param 投票日リスト List<TakeOutPcDataCaptureResult>
     */
    public void 画面設定_投票日ドロップダウン(List<AfT252Result> 投票日リスト) {
        KeyValueDataSource dataSource;
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int i = 0; i < 投票日リスト.size(); i++) {
            dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(投票日リスト.get(i).get投票年月日().toString()));
            dataSource.setValue(投票日リスト.get(i).get投票年月日().wareki().toDateString());
            dataSourceList.add(dataSource);
        }
        div.getDdlTohyoYmd().setDataSource(dataSourceList);
        div.getDdlTohyoYmd().setSelectedIndex(投票日リスト.size() - 1);
    }

    /**
     * 端末用データから、画面内容をセットする。
     *
     * @param 端末用データ List<TakeOutPcDataCaptureResult>
     */
    public void 画面設定_抄本選挙一覧(List<TakeOutPcDataCaptureResult> 端末用データ) {
        TakeOutPcDataCaptureResult result;
        RString 選挙名;
        List<dgShohonSenkyo_Row> rows = new ArrayList<>();
        dgShohonSenkyo_Row dg;
        for (int i = 0; i < 端末用データ.size(); i++) {
            result = 端末用データ.get(i);
            選挙名 = RString.EMPTY;
            for (int j = 0; j < result.get選挙List().size(); j++) {
                if (j == result.get選挙List().size() - 1) {
                    選挙名 = 選挙名.concat(result.get選挙List().get(j).getSenkyoRyakusho());
                } else {
                    選挙名 = 選挙名.concat(result.get選挙List().get(j).getSenkyoRyakusho()).concat(カンマ.getKey());
                }
            }

            dg = new dgShohonSenkyo_Row(result.get抄本名(), 選挙名, toRString(result.get抄本番号()));
            rows.add(dg);
        }
        div.getDgShohonSenkyo().setDataSource(rows);
    }

    /**
     * 取込データから、画面内容をセットする。
     *
     * @param 取込データ List<MochidashiPcJotaiKanriResult>
     */
    public void 画面設定_取込一覧(List<MochidashiPcJotaiKanriResult> 取込データ) {
        List<dgResult_Row> dataSource = new ArrayList<>();
        if (null != 取込データ && !取込データ.isEmpty()) {
            for (MochidashiPcJotaiKanriResult result : 取込データ) {
                dgResult_Row row = new dgResult_Row();
                row.setTxtApCopyKubun(getコード名称(AFACodeShubetsu.データ引継区分.getCodeShubetsu(), result.getAP受渡区分()));
                row.setTxtApCopyYMD(null == result.getAP受渡日時()
                        ? RString.EMPTY : new RString(result.getAP受渡日時().toString()));
                row.setTxtDataCopyKubun(getコード名称(AFACodeShubetsu.データ引継区分.getCodeShubetsu(), result.getデータ受渡区分()));
                row.setTxtDataCopyYMD(null == result.getデータ受渡日時()
                        ? RString.EMPTY : new RString(result.getデータ受渡日時().toString()));
                row.setTxtDataCreateKubun(getコード名称(AFACodeShubetsu.データ引継区分.getCodeShubetsu(), result.getデータ作成区分()));
                row.setTxtDataCreateYMD(null == result.get作成日時()
                        ? RString.EMPTY : new RString(result.get作成日時().toString()));
                row.setTxtDataImportKubun(getコード名称(AFACodeShubetsu.データ引継区分.getCodeShubetsu(), result.getデータ取込区分()));
                row.setTxtDataImportKubunCode(result.getデータ取込区分().getColumnValue());
                row.setTxtDataImportYMD(null == result.get取込日時()
                        ? RString.EMPTY : new RString(result.get取込日時().toString()));
                row.setTxtTohyokuCode(result.get投票区コード());
                dataSource.add(row);
            }
        }
        div.getDgResult().setDataSource(dataSource);
    }

    /**
     * 取込データから、画面内容をセットする。
     *
     * @param filename ArrayList
     * @param fileid ArrayList
     * @return AFABTE803BatchParameter
     */
    public AFABTE803BatchParameter setBatchParameter(ArrayList filename, ArrayList fileid) {
        AFABTE803BatchParameter param = new AFABTE803BatchParameter();
        param.set投票区コード(div.getHdnTohyokuCode());
        param.set投票日(new FlexibleDate(div.getHdnTohyoYMD()));
        for (int i = 0; i < filename.size(); i++) {
            if (new RString(filename.get(i).toString()).split(横線.getKey().toString()).get(0).equals(抄本ファイル名.getKey())) {
                param.set抄本ファイルId(RDateTime.parse(fileid.get(i).toString()));
                param.set抄本取込ファイル名(new RString(filename.get(i).toString()));
            } else if (new RString(filename.get(i).toString()).split(横線.getKey().toString()).get(0).equals(投票状況ファイル名.getKey())) {
                param.set投票状況ファイルId(RDateTime.parse(fileid.get(i).toString()));
                param.set投票状況取込ファイル名(new RString(filename.get(i).toString()));
            }
        }
        return param;
    }

    private RString toRString(ShohonNo 抄本番号) {
        if (null == 抄本番号) {
            return RString.EMPTY;
        }
        return new RString(抄本番号.value());
    }

    private RString getコード名称(CodeShubetsu コード種別, Code コード) {
        return CodeMasterNoOption.getCodeMeisho(コード種別, コード);
    }

}
