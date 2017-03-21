package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期日前投票日報
 *
 * @reamsid_L AF-0270-030 wangl
 */
public class TohyoJyohyoInfo {

    private RString 日付;
    private RDate 投票日;
    private RString 施設コード;
    private RString 選挙番号;
    private RDate 交付年月日;
    private RDate 受理年月日;
    private boolean 交付_受理フラグ;
    private List<KomokuShukei> 項目集計情報;
    private List<AfT201TohyoJokyoEntity> 投票状況;

    /**
     * 日付を設定します。
     *
     * @param 日付 RDate
     */
    public void set日付(RString 日付) {
        this.日付 = 日付;
    }

    /**
     * 投票日を設定します。
     *
     * @param 投票日 RDate
     */
    public void set投票日(RDate 投票日) {
        this.投票日 = 投票日;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード RString
     */
    public void set施設コード(RString 施設コード) {
        this.施設コード = 施設コード;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 RString
     */
    public void set選挙番号(RString 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * 交付年月日を設定します。
     *
     * @param 交付年月日 RDate
     */
    public void set交付年月日(RDate 交付年月日) {
        this.交付年月日 = 交付年月日;
    }

    /**
     * 受理年月日を設定します。
     *
     * @param 受理年月日 RDate
     */
    public void set受理年月日(RDate 受理年月日) {
        this.受理年月日 = 受理年月日;
    }

    /**
     * 交付_受理フラグを設定します。
     *
     * @param 交付_受理フラグ boolean
     */
    public void set交付_受理フラグ(boolean 交付_受理フラグ) {
        this.交付_受理フラグ = 交付_受理フラグ;
    }

    /**
     * 項目集計情報を設定します。
     *
     * @param 項目集計情報 List<KomokuShukei>
     */
    public void set項目集計情報(List<KomokuShukei> 項目集計情報) {
        this.項目集計情報 = 項目集計情報;
    }

    /**
     * 投票状況を設定します。
     *
     * @param 投票状況 List<AfT201TohyoJokyoEntity>
     */
    public void set投票状況(List<AfT201TohyoJokyoEntity> 投票状況) {
        this.投票状況 = 投票状況;
    }

    /**
     * 日付を返します。
     *
     * @return 日付
     */
    public RString get日付() {
        return this.日付;
    }

    /**
     * 投票日を返します。
     *
     * @return 投票日
     */
    public RDate get投票日() {
        return this.投票日;
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return this.施設コード;
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号
     */
    public RString get選挙番号() {
        return this.選挙番号;
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public RDate get交付年月日() {
        return this.交付年月日;
    }

    /**
     * 受理年月日を返します。
     *
     * @return 受理年月日
     */
    public RDate get受理年月日() {
        return this.受理年月日;
    }

    /**
     * 交付_受理フラグを返します。
     *
     * @return 交付_受理フラグ
     */
    public boolean is交付_受理フラグ() {
        return this.交付_受理フラグ;
    }

    /**
     * 項目集計情報を返します。
     *
     * @return 項目集計情報
     */
    public List<KomokuShukei> get項目集計情報() {
        return this.項目集計情報;
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況
     */
    public List<AfT201TohyoJokyoEntity> get投票状況() {
        return this.投票状況;
    }
}
