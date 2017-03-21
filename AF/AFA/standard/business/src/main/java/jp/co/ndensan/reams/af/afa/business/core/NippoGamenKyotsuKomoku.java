package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 画面側から帳票作成入力項目
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class NippoGamenKyotsuKomoku {

    private RString 施設コード開始;
    private RString 施設コード終了;
    private RDate 投票日開始;
    private RDate 投票日終了;
    private RDate 交付日開始;
    private RDate 交付日終了;
    private RDate 受理日開始;
    private RDate 受理日終了;
    private RString 投票区コード開始;
    private RString 投票区コード終了;
    private RDate 期日前投票日開始;
    private RDate 期日前投票日終了;
    private RTime 投票時刻開始;
    private RTime 投票時刻終了;
    private RTime 受理時刻開始;
    private RTime 受理時刻終了;
    private RDate 受理日;

    /**
     * 施設コード開始を設定します。
     *
     * @param 施設コード開始 RString
     */
    public void set施設コード開始(RString 施設コード開始) {
        this.施設コード開始 = 施設コード開始;
    }

    /**
     * 施設コード終了を設定します。
     *
     * @param 施設コード終了 RString
     */
    public void set施設コード終了(RString 施設コード終了) {
        this.施設コード終了 = 施設コード終了;
    }

    /**
     * 投票日開始を設定します。
     *
     * @param 投票日開始 RDate
     */
    public void set投票日開始(RDate 投票日開始) {
        this.投票日開始 = 投票日開始;
    }

    /**
     * 投票日終了を設定します。
     *
     * @param 投票日終了 RDate
     */
    public void set投票日終了(RDate 投票日終了) {
        this.投票日終了 = 投票日終了;
    }

    /**
     * 交付日開始を設定します。
     *
     * @param 交付日開始 RDate
     */
    public void set交付日開始(RDate 交付日開始) {
        this.交付日開始 = 交付日開始;
    }

    /**
     * 交付日終了を設定します。
     *
     * @param 交付日終了 RDate
     */
    public void set交付日終了(RDate 交付日終了) {
        this.交付日終了 = 交付日終了;
    }

    /**
     * 受理日開始を設定します。
     *
     * @param 受理日開始 RDate
     */
    public void set受理日開始(RDate 受理日開始) {
        this.受理日開始 = 受理日開始;
    }

    /**
     * 受理日終了を設定します。
     *
     * @param 受理日終了 RDate
     */
    public void set受理日終了(RDate 受理日終了) {
        this.受理日終了 = 受理日終了;
    }

    /**
     * 投票区コード開始を設定します。
     *
     * @param 投票区コード開始 RString
     */
    public void set投票区コード開始(RString 投票区コード開始) {
        this.投票区コード開始 = 投票区コード開始;
    }

    /**
     * 投票区コード終了を設定します。
     *
     * @param 投票区コード終了 RString
     */
    public void set投票区コード終了(RString 投票区コード終了) {
        this.投票区コード終了 = 投票区コード終了;
    }

    /**
     * 期日前投票日開始を設定します。
     *
     * @param 期日前投票日開始 RDate
     */
    public void set期日前投票日開始(RDate 期日前投票日開始) {
        this.期日前投票日開始 = 期日前投票日開始;
    }

    /**
     * 期日前投票日終了を設定します。
     *
     * @param 期日前投票日終了 RDate
     */
    public void set期日前投票日終了(RDate 期日前投票日終了) {
        this.期日前投票日終了 = 期日前投票日終了;
    }

    /**
     * 投票時刻開始を設定します。
     *
     * @param 投票時刻開始 RTime
     */
    public void set投票時刻開始(RTime 投票時刻開始) {
        this.投票時刻開始 = 投票時刻開始;
    }

    /**
     * 投票時刻終了を設定します。
     *
     * @param 投票時刻終了 RTime
     */
    public void set投票時刻終了(RTime 投票時刻終了) {
        this.投票時刻終了 = 投票時刻終了;
    }

    /**
     * 受理時刻開始を設定します。
     *
     * @param 受理時刻開始 RTime
     */
    public void set受理時刻開始(RTime 受理時刻開始) {
        this.受理時刻開始 = 受理時刻開始;
    }

    /**
     * 受理時刻終了を設定します。
     *
     * @param 受理時刻終了 RTime
     */
    public void set受理時刻終了(RTime 受理時刻終了) {
        this.受理時刻終了 = 受理時刻終了;
    }

    /**
     * 受理日を設定します。
     *
     * @param 受理日 RDate
     */
    public void set受理日(RDate 受理日) {
        this.受理日 = 受理日;
    }

    /**
     * 施設コード開始を返します。
     *
     * @return 施設コード開始
     */
    public RString get施設コード開始() {
        return this.施設コード開始;
    }

    /**
     * 施設コード終了を返します。
     *
     * @return 施設コード終了
     */
    public RString get施設コード終了() {
        return this.施設コード終了;
    }

    /**
     * 投票日開始を返します。
     *
     * @return 投票日開始
     */
    public RDate get投票日開始() {
        return this.投票日開始;
    }

    /**
     * 投票日終了を返します。
     *
     * @return 投票日終了
     */
    public RDate get投票日終了() {
        return this.投票日終了;
    }

    /**
     * 交付日開始を返します。
     *
     * @return 交付日開始
     */
    public RDate get交付日開始() {
        return this.交付日開始;
    }

    /**
     * 交付日終了を返します。
     *
     * @return 交付日終了
     */
    public RDate get交付日終了() {
        return this.交付日終了;
    }

    /**
     * 受理日開始を返します。
     *
     * @return 受理日開始
     */
    public RDate get受理日開始() {
        return this.受理日開始;
    }

    /**
     * 受理日終了を返します。
     *
     * @return 受理日終了
     */
    public RDate get受理日終了() {
        return this.受理日終了;
    }

    /**
     * 投票区コード開始を返します。
     *
     * @return 投票区コード開始
     */
    public RString get投票区コード開始() {
        return this.投票区コード開始;
    }

    /**
     * 投票区コード終了を返します。
     *
     * @return 投票区コード終了
     */
    public RString get投票区コード終了() {
        return this.投票区コード終了;
    }

    /**
     * 期日前投票日開始を返します。
     *
     * @return 期日前投票日開始
     */
    public RDate get期日前投票日開始() {
        return this.期日前投票日開始;
    }

    /**
     * 期日前投票日終了を返します。
     *
     * @return 期日前投票日終了
     */
    public RDate get期日前投票日終了() {
        return this.期日前投票日終了;
    }

    /**
     * 投票時刻開始を返します。
     *
     * @return 投票時刻開始
     */
    public RTime get投票時刻開始() {
        return this.投票時刻開始;
    }

    /**
     * 投票時刻終了を返します。
     *
     * @return 投票時刻終了
     */
    public RTime get投票時刻終了() {
        return this.投票時刻終了;
    }

    /**
     * 受理時刻開始を返します。
     *
     * @return 受理時刻開始
     */
    public RTime get受理時刻開始() {
        return this.受理時刻開始;
    }

    /**
     * 受理時刻終了を返します。
     *
     * @return 受理時刻終了
     */
    public RTime get受理時刻終了() {
        return this.受理時刻終了;
    }

    /**
     * 受理日を返します。
     *
     * @return 受理日
     */
    public RDate get受理日() {
        return this.受理日;
    }
}
