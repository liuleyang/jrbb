/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設送付書発行バッチ出力条件表のパラメータクラスです。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public class AFABTE205BatchPrintProcessParameter implements IBatchProcessParameter {

    private ShohonNo 抄本番号;
    private Boolean 無投票選挙も出力する;
    private RString 発行番号;
    private FlexibleDate 発行日;
    private RString 施設コード_開始;
    private RString 施設コード_終了;
    private FlexibleDate 交付日_開始;
    private FlexibleDate 交付日_終了;
    private SenkyoNo 選挙番号;
    private RString 帳票ID;
    private Long ジョブ番号;
    private RString 帳票名;
    private RString 出力ページ数;
    private RString ファイル名_CSV;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     * @param 無投票選挙も出力する Boolean
     * @param 発行番号 RString
     * @param 発行日 FlexibleDate
     * @param 施設コード_開始 RString
     * @param 施設コード_終了 RString
     * @param 交付日_開始 FlexibleDate
     * @param 交付日_終了 FlexibleDate
     * @param 選挙番号 SenkyoNo
     *
     */
    public AFABTE205BatchPrintProcessParameter(
            ShohonNo 抄本番号,
            Boolean 無投票選挙も出力する,
            RString 発行番号,
            FlexibleDate 発行日,
            RString 施設コード_開始,
            RString 施設コード_終了,
            FlexibleDate 交付日_開始,
            FlexibleDate 交付日_終了,
            SenkyoNo 選挙番号) {
        this.抄本番号 = 抄本番号;
        this.無投票選挙も出力する = 無投票選挙も出力する;
        this.発行番号 = 発行番号;
        this.発行日 = 発行日;
        this.施設コード_開始 = 施設コード_開始;
        this.施設コード_終了 = 施設コード_終了;
        this.交付日_開始 = 交付日_開始;
        this.交付日_終了 = 交付日_終了;
        this.選挙番号 = 選挙番号;
    }

    /**
     * 抄本番号を取得します。
     *
     * @return ShohonNo
     */
    public ShohonNo get抄本番号() {
        return 抄本番号;
    }

    /**
     * 無投票選挙も出力するを取得します。
     *
     * @return Boolean
     */
    public Boolean is無投票選挙も出力する() {
        return 無投票選挙も出力する;
    }

    /**
     * 発行番号を取得します。
     *
     * @return RString
     */
    public RString get発行番号() {
        return 発行番号;
    }

    /**
     * 発行日を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get発行日() {
        return 発行日;
    }

    /**
     * 施設コード_開始を取得します。
     *
     * @return RString
     */
    public RString get施設コード_開始() {
        return 施設コード_開始;
    }

    /**
     * 施設コード_終了を取得します。
     *
     * @return RString
     */
    public RString get施設コード_終了() {
        return 施設コード_終了;
    }

    /**
     * 交付日_開始を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get交付日_開始() {
        return 交付日_開始;
    }

    /**
     * 交付日_終了を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get交付日_終了() {
        return 交付日_終了;
    }

    /**
     * 選挙番号を取得します。
     *
     * @return SenkyoNo
     */
    public SenkyoNo get選挙番号() {
        return 選挙番号;
    }

    /**
     * 帳票IDを取得します。
     *
     * @return RString
     */
    public RString get帳票ID() {
        return 帳票ID;
    }

    /**
     * ジョブ番号を取得します。
     *
     * @return Long
     */
    public Long getジョブ番号() {
        return ジョブ番号;
    }

    /**
     * 帳票名を取得します。
     *
     * @return RString
     */
    public RString get帳票名() {
        return 帳票名;
    }

    /**
     * 出力ページ数を取得します。
     *
     * @return RString
     */
    public RString get出力ページ数() {
        return 出力ページ数;
    }

    /**
     * ファイル名_CSVを取得します。
     *
     * @return RString
     */
    public RString getファイル名_CSV() {
        return ファイル名_CSV;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 ShohonNo
     */
    public void set抄本番号(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
    }

    /**
     * 無投票選挙も出力するを設定します。
     *
     * @param 無投票選挙も出力する Boolean
     */
    public void set無投票選挙も出力する(Boolean 無投票選挙も出力する) {
        this.無投票選挙も出力する = 無投票選挙も出力する;
    }

    /**
     * 発行番号を設定します。
     *
     * @param 発行番号 RString
     */
    public void set発行番号(RString 発行番号) {
        this.発行番号 = 発行番号;
    }

    /**
     * 発行日を設定します。
     *
     * @param 発行日 FlexibleDate
     */
    public void set発行日(FlexibleDate 発行日) {
        this.発行日 = 発行日;
    }

    /**
     * 施設コード_開始を設定します。
     *
     * @param 施設コード_開始 RString
     */
    public void set施設コード_開始(RString 施設コード_開始) {
        this.施設コード_開始 = 施設コード_開始;
    }

    /**
     * 施設コード_終了を設定します。
     *
     * @param 施設コード_終了 RString
     */
    public void set施設コード_終了(RString 施設コード_終了) {
        this.施設コード_終了 = 施設コード_終了;
    }

    /**
     * 交付日_開始を設定します。
     *
     * @param 交付日_開始 FlexibleDate
     */
    public void set交付日_開始(FlexibleDate 交付日_開始) {
        this.交付日_開始 = 交付日_開始;
    }

    /**
     * 交付日_終了を設定します。
     *
     * @param 交付日_終了 FlexibleDate
     */
    public void set交付日_終了(FlexibleDate 交付日_終了) {
        this.交付日_終了 = 交付日_終了;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 SenkyoNo
     */
    public void set選挙番号(SenkyoNo 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * 帳票IDを設定します。
     *
     * @param 帳票ID RString
     */
    public void set帳票ID(RString 帳票ID) {
        this.帳票ID = 帳票ID;
    }

    /**
     * ジョブ番号を設定します。
     *
     * @param ジョブ番号 Long
     */
    public void setジョブ番号(Long ジョブ番号) {
        this.ジョブ番号 = ジョブ番号;
    }

    /**
     * 帳票名を設定します。
     *
     * @param 帳票名 RString
     */
    public void set帳票名(RString 帳票名) {
        this.帳票名 = 帳票名;
    }

    /**
     * 出力ページ数を設定します。
     *
     * @param 出力ページ数 RString
     */
    public void set出力ページ数(RString 出力ページ数) {
        this.出力ページ数 = 出力ページ数;
    }

    /**
     * ファイル名_CSVを設定します。
     *
     * @param ファイル名_CSV RString
     */
    public void setファイル名_CSV(RString ファイル名_CSV) {
        this.ファイル名_CSV = ファイル名_CSV;
    }

}
