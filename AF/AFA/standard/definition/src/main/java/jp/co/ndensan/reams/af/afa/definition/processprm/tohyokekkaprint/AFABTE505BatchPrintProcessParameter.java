/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票結果集計表バッチ出力条件表のパラメータクラスです。
 *
 * @reamsid_L AF-0290-020 zhanggs
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE505BatchPrintProcessParameter implements IBatchProcessParameter {

    private Long ジョブ番号;
    private ShohonNo 抄本番号;
    private Boolean 年齢別投票率集計表出力有無;
    private Boolean 年齢別EUCデータを作成する有無;
    private RString 投票区年齢別投票率集計表_投票区from;
    private RString 投票区年齢別投票率集計表_投票区to;
    private Boolean 年代別投票率集計表出力有無;
    private Boolean 年代別EUCデータを作成する有無;
    private RString 投票区年代別投票率集計表_投票区from;
    private RString 投票区年代別投票率集計表_投票区to;
    private Boolean 時間別投票者集計表出力有無;

    private Integer 年齢別投票率集計表出力数;
    private Integer 年代別投票率集計表出力数;
    private Integer 時間別投票者集計表出力数;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     * @param 年齢別投票率集計表出力有無 Boolean
     * @param 時間別投票者集計表出力有無 Boolean
     * @param 年齢別EUCデータを作成する有無 Boolean
     * @param 投票区年代別投票率集計表_投票区from RString
     * @param 投票区年齢別投票率集計表_投票区from RString
     * @param 年代別EUCデータを作成する有無 Boolean
     * @param 投票区年齢別投票率集計表_投票区to RString
     * @param 投票区年代別投票率集計表_投票区to RString
     * @param 年代別投票率集計表出力有無 Boolean
     */
    public AFABTE505BatchPrintProcessParameter(ShohonNo 抄本番号,
            Boolean 年齢別投票率集計表出力有無,
            Boolean 年齢別EUCデータを作成する有無,
            RString 投票区年齢別投票率集計表_投票区from,
            RString 投票区年齢別投票率集計表_投票区to,
            Boolean 年代別投票率集計表出力有無,
            Boolean 年代別EUCデータを作成する有無,
            RString 投票区年代別投票率集計表_投票区from,
            RString 投票区年代別投票率集計表_投票区to,
            Boolean 時間別投票者集計表出力有無) {
        this.抄本番号 = 抄本番号;
        this.年齢別投票率集計表出力有無 = 年齢別投票率集計表出力有無;
        this.年齢別EUCデータを作成する有無 = 年齢別EUCデータを作成する有無;
        this.投票区年齢別投票率集計表_投票区from = 投票区年齢別投票率集計表_投票区from;
        this.投票区年齢別投票率集計表_投票区to = 投票区年齢別投票率集計表_投票区to;
        this.年代別投票率集計表出力有無 = 年代別投票率集計表出力有無;
        this.年代別EUCデータを作成する有無 = 年代別EUCデータを作成する有無;
        this.投票区年代別投票率集計表_投票区from = 投票区年代別投票率集計表_投票区from;
        this.投票区年代別投票率集計表_投票区to = 投票区年代別投票率集計表_投票区to;
        this.時間別投票者集計表出力有無 = 時間別投票者集計表出力有無;

    }
}
