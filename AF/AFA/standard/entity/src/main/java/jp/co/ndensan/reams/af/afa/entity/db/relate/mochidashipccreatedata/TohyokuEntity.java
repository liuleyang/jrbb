package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata;

import java.io.Serializable;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 投票区Entity
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class TohyokuEntity implements IDbAccessable, Serializable {

    private RString senkyoShurui;
    private RString tohyokuCode;
    private RString tohyokuName;
    private RString kanaTohyokuName;
    private RString searchKanaTohyokuName;

    /**
     * 選挙種類のgetメソッドです。
     *
     * @return 選挙種類
     */
    public RString getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 選挙種類のsetメソッドです。
     *
     * @param senkyoShurui 選挙種類
     */
    public void setSenkyoShurui(@Nonnull RString senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString getTohyokuCode() {
        return tohyokuCode;
    }

    /**
     * 投票区コードのsetメソッドです。
     *
     * @param tohyokuCode 投票区コード
     */
    public void setTohyokuCode(@Nonnull RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * 投票区名のgetメソッドです。
     * <br/>
     * <br/>通常選挙時：UR投票区から取得、修正不可。 その他：自テーブルから取得、修正可能。
     *
     * @return 投票区名
     */
    @CheckForNull
    public RString getTohyokuName() {
        return tohyokuName;
    }

    /**
     * 投票区名のsetメソッドです。
     * <br/>
     * <br/>通常選挙時：UR投票区から取得、修正不可。 その他：自テーブルから取得、修正可能。
     *
     * @param tohyokuName 投票区名
     */
    public void setTohyokuName(RString tohyokuName) {
        this.tohyokuName = tohyokuName;
    }

    /**
     * カナ投票区名のgetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @return カナ投票区名
     */
    @CheckForNull
    public RString getKanaTohyokuName() {
        return kanaTohyokuName;
    }

    /**
     * カナ投票区名のsetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @param kanaTohyokuName カナ投票区名
     */
    public void setKanaTohyokuName(RString kanaTohyokuName) {
        this.kanaTohyokuName = kanaTohyokuName;
    }

    /**
     * 検索用カナ投票区名のgetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @return 検索用カナ投票区名
     */
    @CheckForNull
    public RString getSearchKanaTohyokuName() {
        return searchKanaTohyokuName;
    }

    /**
     * 検索用カナ投票区名のsetメソッドです。
     * <br/>
     * <br/>　〃
     *
     * @param searchKanaTohyokuName 検索用カナ投票区名
     */
    public void setSearchKanaTohyokuName(RString searchKanaTohyokuName) {
        this.searchKanaTohyokuName = searchKanaTohyokuName;
    }

}
