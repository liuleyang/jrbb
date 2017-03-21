/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 定時登録バッチ出力条件表のパラメータクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTA101BatchPrintProcessParameter implements IBatchProcessParameter {

    private RString 処理種別;
    private ShohonNo 抄本番号;
    private RString 抄本名;
    private FlexibleDate 投票日;
    private FlexibleDate 基準日;
    private FlexibleDate 登録日;
    private FlexibleDate 転出期限日;
    private FlexibleDate 転入期限日;
    private FlexibleDate 年齢期限日;
    private Boolean 選挙人名簿抄本出力有無;
    private Integer 選挙人名簿抄本出力数;
    private Integer 選挙人名簿抄本縦覧出力数;
    private Boolean 永久選挙人名簿出力有無;
    private Integer 永久選挙人名簿出力数;
    private RString 出力条件;
    private RString 識別コード;
    private List<FlexibleDate> 指定日;
    private RString 異動事由;
    private Boolean 選挙人名簿索引簿出力有無;
    private Integer 選挙人名簿索引簿出力数;
    private Integer 選挙人名簿索引簿投票区別出力数;
    private RString 投票区From;
    private RString 投票区To;
    private Boolean 登録者数リスト出力有無;
    private Integer 登録者数リスト出力数;
    private FlexibleDate 時点;
    private Boolean 不在者投票資格者分作成有無;
    private Integer 不在者投票資格者分作成出力数;
    private Boolean 不在資格対象者名簿作成有無;
    private Integer 不在資格対象者名簿作成出力数;
    private Boolean 有榷者数調べ出力有無;
    private Integer 有榷者数調べ出力数;
    private Boolean 二重登録通知出力有無;
    private Integer 二重登録通知出力数;
    private FlexibleDate 発行日;
    private RString 発行番号の第;
    private RString 発行番号の番号;
    private RString 発行番号の号;
    private List<FlexibleDate> 転入期間;
    private Boolean 送付先宛名シール作成有無;
    private Integer 送付先宛名シール作成出力数;
    private Boolean 二重登録通知一覧表作成有無;
    private Integer 二重登録通知一覧表作成出力数;
    private Boolean 登録者名簿出力有無;
    private Integer 登録者名簿出力数;
    private Boolean 縦覧用作成有無_登録者;
    private Integer 登録者名簿縦覧用出力数;
    private Boolean 新規登録者宛名シール作成有無;
    private Integer 新規登録者宛名シール作成出力数;
    private Boolean 帰化対象者名簿出力有無;
    private Integer 帰化対象者名簿出力数;
    private List<FlexibleDate> 帰化期間;
    private Boolean 抹消者名簿出力有無;
    private Integer 抹消者名簿出力数;
    private Boolean 縦覧用作成有無_抹消者;
    private Integer 抹消者名簿縦覧用出力数;
    private Boolean 居住要件抹消者名簿出力有無;
    private Integer 居住要件抹消者名簿出力数;
    private Boolean 表示者名簿出力有無;
    private Integer 表示者名簿出力数;
    private Boolean 表示消除者名簿出力有無;
    private Integer 表示消除者名簿出力数;
    private Boolean 規定年齢前名簿出力有無;
    private Integer 規定年齢前名簿出力数;
    private Boolean 規定年齢前シール作成有無;
    private Integer 規定年齢前シール作成出力数;
    private Boolean 規定年齢未到達者名簿出力有無;
    private Integer 規定年齢未到達者名簿出力数;
    private Boolean 再転入者名簿出力有無;
    private Integer 再転入者名簿出力数;
    private Boolean 訂正者名簿出力有無;
    private Integer 訂正者名簿出力数;
    private Boolean 転出者名簿出力有無;
    private Integer 転出者名簿出力数;
    private Boolean 登録停止者名簿出力有無;
    private Integer 登録停止者名簿出力数;
    private Boolean 在外選挙人名簿抄本出力有無;
    private Integer 在外選挙人名簿抄本出力数;
    private Integer 在外選挙人名簿抄本縦覧用出力数;
    private Boolean 在外投票資格者名簿出力有無;
    private Integer 在外投票資格者名簿出力数;

    private RString 帳票ID;
    private Long ジョブ番号;
    private RString 帳票名;
    private RString 出力ページ数;
    private RString ファイル名_CSV;

    /**
     * コンストラクタです。
     *
     * @param 処理種別 RString
     * @param 抄本番号 ShohonNo
     * @param 抄本名 RString
     * @param 投票日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @param 登録日 FlexibleDate
     * @param 転出期限日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @param 年齢期限日 FlexibleDate
     * @param 選挙人名簿抄本出力有無 Boolean
     * @param 投票区From 投票区From
     * @param 投票区To 投票区To
     * @param 永久選挙人名簿出力有無 Boolean
     * @param 出力条件 RString
     * @param 識別コード RString
     * @param 指定日 List<FlexibleDate>
     * @param 異動事由 RString
     * @param 選挙人名簿索引簿出力有無 Boolean
     * @param 登録者数リスト出力有無 Boolean
     * @param 時点 FlexibleDate
     * @param 不在者投票資格者分作成有無 Boolean
     * @param 不在資格対象者名簿作成有無 Boolean
     * @param 有榷者数調べ出力有無 Boolean
     * @param 二重登録通知出力有無 Boolean
     * @param 発行日 FlexibleDate
     * @param 発行番号の第 RString
     * @param 発行番号の番号 RString
     * @param 発行番号の号 RString
     * @param 転入期間 List<FlexibleDate>
     * @param 送付先宛名シール作成有無 Boolean
     * @param 二重登録通知一覧表作成有無 Boolean
     * @param 登録者名簿出力有無 Boolean
     * @param 縦覧用作成有無_登録者 Boolean
     * @param 新規登録者宛名シール作成有無 Boolean
     * @param 帰化対象者名簿出力有無 Boolean
     * @param 帰化期間 List<FlexibleDate>
     * @param 抹消者名簿出力有無 Boolean
     * @param 縦覧用作成有無_抹消者 Boolean
     * @param 居住要件抹消者名簿出力有無 Boolean
     * @param 表示者名簿出力有無 Boolean
     * @param 表示消除者名簿出力有無 Boolean
     * @param 規定年齢前名簿出力有無 Boolean
     * @param 規定年齢前シール作成有無 Boolean
     * @param 規定年齢未到達者名簿出力有無 Boolean
     * @param 再転入者名簿出力有無 Boolean
     * @param 訂正者名簿出力有無 Boolean
     * @param 転出者名簿出力有無 Boolean
     * @param 登録停止者名簿出力有無 Boolean
     * @param 在外選挙人名簿抄本出力有無 Boolean
     * @param 在外投票資格者名簿出力有無 Boolean
     */
    public AFABTA101BatchPrintProcessParameter(RString 処理種別, ShohonNo 抄本番号, RString 抄本名, FlexibleDate 投票日, FlexibleDate 基準日,
            FlexibleDate 登録日, FlexibleDate 転出期限日, FlexibleDate 転入期限日, FlexibleDate 年齢期限日, Boolean 選挙人名簿抄本出力有無,
            RString 投票区From, RString 投票区To,
            Boolean 永久選挙人名簿出力有無, RString 出力条件, RString 識別コード, List<FlexibleDate> 指定日, RString 異動事由,
            Boolean 選挙人名簿索引簿出力有無, Boolean 登録者数リスト出力有無, FlexibleDate 時点, Boolean 不在者投票資格者分作成有無,
            Boolean 不在資格対象者名簿作成有無, Boolean 有榷者数調べ出力有無, Boolean 二重登録通知出力有無, FlexibleDate 発行日, RString 発行番号の第,
            RString 発行番号の番号, RString 発行番号の号, List<FlexibleDate> 転入期間, Boolean 送付先宛名シール作成有無,
            Boolean 二重登録通知一覧表作成有無, Boolean 登録者名簿出力有無, Boolean 縦覧用作成有無_登録者, Boolean 新規登録者宛名シール作成有無,
            Boolean 帰化対象者名簿出力有無, List<FlexibleDate> 帰化期間, Boolean 抹消者名簿出力有無, Boolean 縦覧用作成有無_抹消者,
            Boolean 居住要件抹消者名簿出力有無, Boolean 表示者名簿出力有無, Boolean 表示消除者名簿出力有無, Boolean 規定年齢前名簿出力有無,
            Boolean 規定年齢前シール作成有無, Boolean 規定年齢未到達者名簿出力有無, Boolean 再転入者名簿出力有無, Boolean 訂正者名簿出力有無,
            Boolean 転出者名簿出力有無, Boolean 登録停止者名簿出力有無, Boolean 在外選挙人名簿抄本出力有無, Boolean 在外投票資格者名簿出力有無) {
        this.処理種別 = 処理種別;
        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.投票日 = 投票日;
        this.基準日 = 基準日;
        this.登録日 = 登録日;
        this.転出期限日 = 転出期限日;
        this.転入期限日 = 転入期限日;
        this.年齢期限日 = 年齢期限日;
        this.選挙人名簿抄本出力有無 = 選挙人名簿抄本出力有無;
        this.永久選挙人名簿出力有無 = 永久選挙人名簿出力有無;
        this.出力条件 = 出力条件;
        this.識別コード = 識別コード;
        this.指定日 = 指定日;
        this.異動事由 = 異動事由;
        this.選挙人名簿索引簿出力有無 = 選挙人名簿索引簿出力有無;
        this.投票区From = 投票区From;
        this.投票区To = 投票区To;
        this.登録者数リスト出力有無 = 登録者数リスト出力有無;
        this.時点 = 時点;
        this.不在者投票資格者分作成有無 = 不在者投票資格者分作成有無;
        this.不在資格対象者名簿作成有無 = 不在資格対象者名簿作成有無;
        this.有榷者数調べ出力有無 = 有榷者数調べ出力有無;
        this.二重登録通知出力有無 = 二重登録通知出力有無;
        this.発行日 = 発行日;
        this.発行番号の第 = 発行番号の第;
        this.発行番号の番号 = 発行番号の番号;
        this.発行番号の号 = 発行番号の号;
        this.転入期間 = 転入期間;
        this.送付先宛名シール作成有無 = 送付先宛名シール作成有無;
        this.二重登録通知一覧表作成有無 = 二重登録通知一覧表作成有無;
        this.登録者名簿出力有無 = 登録者名簿出力有無;
        this.縦覧用作成有無_登録者 = 縦覧用作成有無_登録者;
        this.新規登録者宛名シール作成有無 = 新規登録者宛名シール作成有無;
        this.帰化対象者名簿出力有無 = 帰化対象者名簿出力有無;
        this.帰化期間 = 帰化期間;
        this.抹消者名簿出力有無 = 抹消者名簿出力有無;
        this.縦覧用作成有無_抹消者 = 縦覧用作成有無_抹消者;
        this.居住要件抹消者名簿出力有無 = 居住要件抹消者名簿出力有無;
        this.表示者名簿出力有無 = 表示者名簿出力有無;
        this.表示消除者名簿出力有無 = 表示消除者名簿出力有無;
        this.規定年齢前名簿出力有無 = 規定年齢前名簿出力有無;
        this.規定年齢前シール作成有無 = 規定年齢前シール作成有無;
        this.規定年齢未到達者名簿出力有無 = 規定年齢未到達者名簿出力有無;
        this.再転入者名簿出力有無 = 再転入者名簿出力有無;
        this.訂正者名簿出力有無 = 訂正者名簿出力有無;
        this.転出者名簿出力有無 = 転出者名簿出力有無;
        this.登録停止者名簿出力有無 = 登録停止者名簿出力有無;
        this.在外選挙人名簿抄本出力有無 = 在外選挙人名簿抄本出力有無;
        this.在外投票資格者名簿出力有無 = 在外投票資格者名簿出力有無;
    }
}
