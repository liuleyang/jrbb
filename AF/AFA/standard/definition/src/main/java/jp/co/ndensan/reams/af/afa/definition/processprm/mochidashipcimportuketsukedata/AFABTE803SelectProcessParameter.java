/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 当日受付データ取込バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE803SelectProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 投票日;
    private RString 投票区コード;
    private List<ShikibetsuCode> 識別コードリスト;
    private List<ShohonNo> 抄本番号リスト;
    private RString 抄本ファイル名;
    private RString 投票状況ファイル名;
    private RString table;
    private RString table1;
    private RDateTime 抄本ファイルId;
    private RDateTime 投票状況ファイルId;

    /**
     * コンストラクタです。
     *
     * @param 投票日 FlexibleDate
     * @param 投票区コード RString
     * @param 抄本ファイルId RDateTime
     * @param 投票状況ファイルId RDateTime
     */
    public AFABTE803SelectProcessParameter(FlexibleDate 投票日,
            RString 投票区コード,
            RDateTime 抄本ファイルId,
            RDateTime 投票状況ファイルId) {
        this.投票日 = 投票日;
        this.投票区コード = 投票区コード;
        this.抄本ファイルId = 抄本ファイルId;
        this.投票状況ファイルId = 投票状況ファイルId;
    }

    /**
     * AFABTE803SelectProcessMyBatisParameter変換のメソッド
     *
     * @return AFABTE803SelectProcessMyBatisParameter
     */
    public AFABTE803SelectProcessMyBatisParameter toAFABTE803SelectProcessMyBatisParameter() {
        if (RString.isNullOrEmpty(投票区コード)) {
            return new AFABTE803SelectProcessMyBatisParameter(投票日, Code.EMPTY);
        } else {
            return new AFABTE803SelectProcessMyBatisParameter(投票日, new Code(投票区コード));
        }

    }

}
