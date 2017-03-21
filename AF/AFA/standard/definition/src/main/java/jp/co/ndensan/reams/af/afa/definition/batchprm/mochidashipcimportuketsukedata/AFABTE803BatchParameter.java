/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipcimportuketsukedata;

import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 当日受付データ取込バッチパラメータクラスです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTE803BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_TOUHYOYMD = "投票日";
    private static final String KEY_TOUHYOKUCODE = "投票区コード";
    private static final String KEY_SHOHONTORIKOMIFILELIST = "抄本取込ファイル名";
    private static final String KEY_TOHYOJOKYOTORIKOMIFILELIST = "投票状況取込ファイル名";
    private static final String KEY_SHOHONFIELDID = "抄本ファイルId";
    private static final String KEY_TOHYOJOFIELDID = "投票状況ファイルId";
    @BatchParameter(key = KEY_TOUHYOYMD, name = "投票日")
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_TOUHYOKUCODE, name = "投票区コード")
    private RString 投票区コード;
    @BatchParameter(key = KEY_SHOHONTORIKOMIFILELIST, name = "抄本取込ファイル名")
    private RString 抄本取込ファイル名;
    @BatchParameter(key = KEY_TOHYOJOKYOTORIKOMIFILELIST, name = "投票状況取込ファイル名")
    private RString 投票状況取込ファイル名;
    @BatchParameter(key = KEY_SHOHONFIELDID, name = "抄本ファイルId")
    private RDateTime 抄本ファイルId;
    @BatchParameter(key = KEY_TOHYOJOFIELDID, name = "投票状況ファイルId")
    private RDateTime 投票状況ファイルId;

    /**
     * AFABTE803SelectProcessParameterの変換のメソッド
     *
     * @return AFABTE803SelectProcessParameter
     */
    public AFABTE803SelectProcessParameter toAFABTE803SelectProcessParameter() {
        return new AFABTE803SelectProcessParameter(
                投票日,
                投票区コード,
                抄本ファイルId,
                投票状況ファイルId);
    }

}
