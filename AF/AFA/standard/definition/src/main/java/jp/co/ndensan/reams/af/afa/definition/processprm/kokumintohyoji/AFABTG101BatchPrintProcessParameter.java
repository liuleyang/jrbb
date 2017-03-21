/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 国民投票時登録バッチ出力条件表のパラメータクラスです。
 *
 * @reamsid_L AF-0360-020 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTG101BatchPrintProcessParameter implements IBatchProcessParameter {

    private RString 帳票ID;
    private Long ジョブ番号;
    private RString 帳票名;
    private RString 出力ページ数;
    private RString ファイル名;
    private ShohonNo 抄本番号;
    private RString 抄本名;
    private FlexibleDate 投票日;
    private FlexibleDate 基準日;
    private FlexibleDate 名簿登録日;
    private FlexibleDate 年齢到達日;
    private FlexibleDate 特定期間開始日;
    private FlexibleDate 特定期限日;
    private FlexibleDate 受付開始日;
    private List<AFABTB101Senkyoichiran> 選挙一覧リスト;
    private Boolean 投票人名簿抄本出力有無;
    private Integer 投票人名簿抄本出力数;
    private Integer 投票人名簿抄本縦覧出力数;
    private Boolean 投票人名簿登録者数リスト出力有無;
    private Integer 投票人名簿登録者数リスト出力数;
    private FlexibleDate 時点日;
    private Boolean 不在者投票資格者分出力有無;
    private Integer 不在者投票資格者分出力数;
    private Boolean 不在資格対象者名簿出力有無;
    private Integer 不在資格対象者名簿出力数;
    private Boolean 一号資格登録通知出力有無;
    private Integer 一号資格登録通知出力数;
    private FlexibleDate 一号資格登録通知発行日;
    private RString 一号資格登録通知発行番号の第;
    private RString 一号資格登録通知発行番号の番号;
    private RString 一号資格登録通知発行番号の号;
    private Boolean 一号資格登録通知送付先宛名シール出力有無;
    private Integer 一号資格登録通知送付先宛名シール出力数;
    private Boolean 一号資格登録通知一覧表出力有無;
    private Integer 一号資格登録通知一覧表出力数;
    private Boolean 二号資格調査票出力有無;
    private Integer 二号資格調査票照会出力数;
    private Integer 二号資格調査票回答出力数;
    private FlexibleDate 二号資格調査票発行日;
    private RString 二号資格調査票発行番号の第;
    private RString 二号資格調査票発行番号の番号;
    private RString 二号資格調査票発行番号の号;
    private Boolean 二号資格調査票送付先宛名シール出力有無;
    private Integer 二号資格調査票送付先宛名シール出力数;
    private Boolean 二号資格調査一覧表出力有無;
    private Integer 二号資格調査一覧表出力数;
    private Boolean 二号資格候補者一覧表出力有無;
    private Integer 二号資格候補者一覧表出力数;
    private Boolean 補正登録者名簿出力有無;
    private Integer 補正登録者名簿出力数;
    private Boolean 補正登録者名簿縦覧用出力有無;
    private Integer 補正登録者名簿縦覧用出力数;
    private Boolean 補正登録者送付先宛名シール出力有無;
    private Integer 補正登録者送付先宛名シール出力数;
    private Boolean 抹消者名簿出力有無;
    private Integer 抹消者名簿出力数;
    private FlexibleDate 抹消日;
    private Boolean 抹消者名簿縦覧用出力有無;
    private Integer 抹消者名簿縦覧用出力数;
    private Boolean 訂正者名簿出力有無;
    private Integer 訂正者名簿出力数;
    private Boolean 未登録者抹消通知出力有無;
    private Integer 未登録者抹消通知出力数;
    private FlexibleDate 未登録者抹消通知発行日;
    private RString 未登録者抹消通知発行番号の第;
    private RString 未登録者抹消通知発行番号の番号;
    private RString 未登録者抹消通知発行番号の号;
    private Boolean 未登録者抹消通知送付先宛名シール出力有無;
    private Integer 未登録者抹消通知送付先宛名シール出力数;
    private Boolean 未登録者抹消通知一覧出力有無;
    private Integer 未登録者抹消通知一覧出力数;
    private Boolean 国内転入者調査票出力有無;
    private Integer 国内転入者調査票照会出力数;
    private Integer 国内転入者調査票回答出力数;
    private FlexibleDate 国内転入者調査票発行日;
    private RString 国内転入者調査票発行番号の第;
    private RString 国内転入者調査票発行番号の番号;
    private RString 国内転入者調査票発行番号の号;
    private Boolean 国内転入者調査票送付先宛名シール出力有無;
    private Integer 国内転入者調査票送付先宛名シール出力数;
    private Boolean 国内転入者調査一覧表出力有無;
    private Integer 国内転入者調査一覧表出力数;
    private Boolean 国外転入者調査票出力有無;
    private Integer 国外転入者調査票照会出力数;
    private Integer 国外転入者調査票回答出力数;
    private FlexibleDate 国外転入者調査票発行日;
    private RString 国外転入者調査票発行番号の第;
    private RString 国外転入者調査票発行番号の番号;
    private RString 国外転入者調査票発行番号の号;
    private Boolean 国外転入者調査票送付先宛名シール出力有無;
    private Integer 国外転入者調査票送付先宛名シール出力数;
    private Boolean 国外転入者調査一覧表出力有無;
    private Integer 国外転入者調査一覧表出力数;
    private Boolean 在外投票人名簿抄本出力有無;
    private Integer 在外投票人名簿抄本出力数;
    private Boolean 在外投票資格者名簿出力有無;
    private Integer 在外投票資格者名簿出力数;
    private Boolean 在外投票管理表出力有無;
    private Integer 在外投票管理表出力数;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     * @param 抄本名 RString
     * @param 投票日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @param 名簿登録日 FlexibleDate
     * @param 年齢到達日 FlexibleDate
     * @param 特定期間開始日 FlexibleDate
     * @param 特定期限日 FlexibleDate
     * @param 受付開始日 FlexibleDate
     * @param 選挙一覧リスト List<AFABTB101Senkyoichiran>
     * @param 投票人名簿抄本出力有無 boolean
     * @param 投票人名簿登録者数リスト出力有無 boolean
     * @param 時点日 FlexibleDate
     * @param 不在者投票資格者分出力有無 boolean
     * @param 不在資格対象者名簿出力有無 boolean
     * @param 一号資格登録通知出力有無 boolean
     * @param 在外投票管理表出力有無 boolean
     * @param 一号資格登録通知発行日 FlexibleDate
     * @param 一号資格登録通知発行番号の第 RString
     * @param 在外投票資格者名簿出力有無 boolean
     * @param 一号資格登録通知発行番号の番号 RString
     * @param 一号資格登録通知発行番号の号 RString
     * @param 在外投票人名簿抄本出力有無 boolean
     * @param 一号資格登録通知送付先宛名シール出力有無 boolean
     * @param 国外転入者調査一覧表出力有無 boolean
     * @param 一号資格登録通知一覧表出力有無 boolean
     * @param 国外転入者調査票送付先宛名シール出力有無 boolean
     * @param 二号資格調査票出力有無 boolean
     * @param 国外転入者調査票発行番号の号 RString
     * @param 国外転入者調査票発行番号の番号 RString
     * @param 二号資格調査票発行日 FlexibleDate
     * @param 国外転入者調査票発行番号の第 RString
     * @param 二号資格調査票発行番号の第 RString
     * @param 国外転入者調査票発行日 FlexibleDate
     * @param 二号資格調査票発行番号の番号 RString
     * @param 二号資格調査票発行番号の号 RString
     * @param 国外転入者調査票出力有無 boolean
     * @param 二号資格調査票送付先宛名シール出力有無 boolean
     * @param 二号資格調査一覧表出力有無 boolean
     * @param 国内転入者調査一覧表出力有無 boolean
     * @param 国内転入者調査票送付先宛名シール出力有無 boolean
     * @param 二号資格候補者一覧表出力有無 boolean
     * @param 国内転入者調査票発行番号の号 RString
     * @param 国内転入者調査票発行番号の番号 RString
     * @param 補正登録者名簿出力有無 boolean
     * @param 国内転入者調査票発行番号の第 RString
     * @param 国内転入者調査票発行日 FlexibleDate
     * @param 補正登録者名簿縦覧用出力有無 boolean
     * @param 国内転入者調査票出力有無 boolean
     * @param 補正登録者送付先宛名シール出力有無 boolean
     * @param 未登録者抹消通知一覧出力有無 boolean
     * @param 抹消者名簿出力有無 boolean
     * @param 未登録者抹消通知送付先宛名シール出力有無 boolean
     * @param 抹消日 FlexibleDate
     * @param 未登録者抹消通知発行番号の番号 RString
     * @param 抹消者名簿縦覧用出力有無 boolean
     * @param 未登録者抹消通知発行番号の第 RString
     * @param 未登録者抹消通知発行日 FlexibleDate
     * @param 訂正者名簿出力有無 boolean
     * @param 未登録者抹消通知出力有無 boolean
     * @param 未登録者抹消通知発行番号の号 RString
     */
    public AFABTG101BatchPrintProcessParameter(
            ShohonNo 抄本番号,
            RString 抄本名,
            FlexibleDate 投票日,
            FlexibleDate 基準日,
            FlexibleDate 名簿登録日,
            FlexibleDate 年齢到達日,
            FlexibleDate 特定期間開始日,
            FlexibleDate 特定期限日,
            FlexibleDate 受付開始日,
            List<AFABTB101Senkyoichiran> 選挙一覧リスト,
            Boolean 投票人名簿抄本出力有無,
            Boolean 投票人名簿登録者数リスト出力有無,
            FlexibleDate 時点日,
            Boolean 不在者投票資格者分出力有無,
            Boolean 不在資格対象者名簿出力有無,
            Boolean 一号資格登録通知出力有無,
            FlexibleDate 一号資格登録通知発行日,
            RString 一号資格登録通知発行番号の第,
            RString 一号資格登録通知発行番号の番号,
            RString 一号資格登録通知発行番号の号,
            Boolean 一号資格登録通知送付先宛名シール出力有無,
            Boolean 一号資格登録通知一覧表出力有無,
            Boolean 二号資格調査票出力有無,
            FlexibleDate 二号資格調査票発行日,
            RString 二号資格調査票発行番号の第,
            RString 二号資格調査票発行番号の番号,
            RString 二号資格調査票発行番号の号,
            Boolean 二号資格調査票送付先宛名シール出力有無,
            Boolean 二号資格調査一覧表出力有無,
            Boolean 二号資格候補者一覧表出力有無,
            Boolean 補正登録者名簿出力有無,
            Boolean 補正登録者名簿縦覧用出力有無,
            Boolean 補正登録者送付先宛名シール出力有無,
            Boolean 抹消者名簿出力有無,
            FlexibleDate 抹消日,
            Boolean 抹消者名簿縦覧用出力有無,
            Boolean 訂正者名簿出力有無,
            Boolean 未登録者抹消通知出力有無,
            FlexibleDate 未登録者抹消通知発行日,
            RString 未登録者抹消通知発行番号の第,
            RString 未登録者抹消通知発行番号の番号,
            RString 未登録者抹消通知発行番号の号,
            Boolean 未登録者抹消通知送付先宛名シール出力有無,
            Boolean 未登録者抹消通知一覧出力有無,
            Boolean 国内転入者調査票出力有無,
            FlexibleDate 国内転入者調査票発行日,
            RString 国内転入者調査票発行番号の第,
            RString 国内転入者調査票発行番号の番号,
            RString 国内転入者調査票発行番号の号,
            Boolean 国内転入者調査票送付先宛名シール出力有無,
            Boolean 国内転入者調査一覧表出力有無,
            Boolean 国外転入者調査票出力有無,
            FlexibleDate 国外転入者調査票発行日,
            RString 国外転入者調査票発行番号の第,
            RString 国外転入者調査票発行番号の番号,
            RString 国外転入者調査票発行番号の号,
            Boolean 国外転入者調査票送付先宛名シール出力有無,
            Boolean 国外転入者調査一覧表出力有無,
            Boolean 在外投票人名簿抄本出力有無,
            Boolean 在外投票資格者名簿出力有無,
            Boolean 在外投票管理表出力有無) {

        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.投票日 = 投票日;
        this.基準日 = 基準日;
        this.名簿登録日 = 名簿登録日;
        this.年齢到達日 = 年齢到達日;
        this.特定期間開始日 = 特定期間開始日;
        this.特定期限日 = 特定期限日;
        this.受付開始日 = 受付開始日;
        this.選挙一覧リスト = 選挙一覧リスト;
        this.投票人名簿抄本出力有無 = 投票人名簿抄本出力有無;
        this.投票人名簿登録者数リスト出力有無 = 投票人名簿登録者数リスト出力有無;
        this.時点日 = 時点日;
        this.不在者投票資格者分出力有無 = 不在者投票資格者分出力有無;
        this.不在資格対象者名簿出力有無 = 不在資格対象者名簿出力有無;
        this.一号資格登録通知出力有無 = 一号資格登録通知出力有無;
        this.一号資格登録通知発行日 = 一号資格登録通知発行日;
        this.一号資格登録通知発行番号の第 = 一号資格登録通知発行番号の第;
        this.一号資格登録通知発行番号の番号 = 一号資格登録通知発行番号の番号;
        this.一号資格登録通知発行番号の号 = 一号資格登録通知発行番号の号;
        this.一号資格登録通知送付先宛名シール出力有無 = 一号資格登録通知送付先宛名シール出力有無;
        this.一号資格登録通知一覧表出力有無 = 一号資格登録通知一覧表出力有無;
        this.二号資格調査票出力有無 = 二号資格調査票出力有無;
        this.二号資格調査票発行日 = 二号資格調査票発行日;
        this.二号資格調査票発行番号の第 = 二号資格調査票発行番号の第;
        this.二号資格調査票発行番号の番号 = 二号資格調査票発行番号の番号;
        this.二号資格調査票発行番号の号 = 二号資格調査票発行番号の号;
        this.二号資格調査票送付先宛名シール出力有無 = 二号資格調査票送付先宛名シール出力有無;
        this.二号資格調査一覧表出力有無 = 二号資格調査一覧表出力有無;
        this.二号資格候補者一覧表出力有無 = 二号資格候補者一覧表出力有無;
        this.補正登録者名簿出力有無 = 補正登録者名簿出力有無;
        this.補正登録者名簿縦覧用出力有無 = 補正登録者名簿縦覧用出力有無;
        this.補正登録者送付先宛名シール出力有無 = 補正登録者送付先宛名シール出力有無;
        this.抹消者名簿出力有無 = 抹消者名簿出力有無;
        this.抹消日 = 抹消日;
        this.抹消者名簿縦覧用出力有無 = 抹消者名簿縦覧用出力有無;
        this.訂正者名簿出力有無 = 訂正者名簿出力有無;
        this.未登録者抹消通知出力有無 = 未登録者抹消通知出力有無;
        this.未登録者抹消通知発行日 = 未登録者抹消通知発行日;
        this.未登録者抹消通知発行番号の第 = 未登録者抹消通知発行番号の第;
        this.未登録者抹消通知発行番号の番号 = 未登録者抹消通知発行番号の番号;
        this.未登録者抹消通知発行番号の号 = 未登録者抹消通知発行番号の号;
        this.未登録者抹消通知送付先宛名シール出力有無 = 未登録者抹消通知送付先宛名シール出力有無;
        this.未登録者抹消通知一覧出力有無 = 未登録者抹消通知一覧出力有無;
        this.国内転入者調査票出力有無 = 国内転入者調査票出力有無;
        this.国内転入者調査票発行日 = 国内転入者調査票発行日;
        this.国内転入者調査票発行番号の第 = 国内転入者調査票発行番号の第;
        this.国内転入者調査票発行番号の番号 = 国内転入者調査票発行番号の番号;
        this.国内転入者調査票発行番号の号 = 国内転入者調査票発行番号の号;
        this.国内転入者調査票送付先宛名シール出力有無 = 国内転入者調査票送付先宛名シール出力有無;
        this.国内転入者調査一覧表出力有無 = 国内転入者調査一覧表出力有無;
        this.国外転入者調査票出力有無 = 国外転入者調査票出力有無;
        this.国外転入者調査票発行日 = 国外転入者調査票発行日;
        this.国外転入者調査票発行番号の第 = 国外転入者調査票発行番号の第;
        this.国外転入者調査票発行番号の番号 = 国外転入者調査票発行番号の番号;
        this.国外転入者調査票発行番号の号 = 国外転入者調査票発行番号の号;
        this.国外転入者調査票送付先宛名シール出力有無 = 国外転入者調査票送付先宛名シール出力有無;
        this.国外転入者調査一覧表出力有無 = 国外転入者調査一覧表出力有無;
        this.在外投票人名簿抄本出力有無 = 在外投票人名簿抄本出力有無;
        this.在外投票資格者名簿出力有無 = 在外投票資格者名簿出力有無;
        this.在外投票管理表出力有無 = 在外投票管理表出力有無;
    }
}
