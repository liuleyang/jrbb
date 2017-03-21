/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokuhenko;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 名簿情報です。
 */
public interface ISenkyoninMeiboJoho {

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    boolean hasIsDeleted();

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    void setIsDeleted(boolean isDeleted);

    /**
     * 抄本番号のgetメソッドです。
     *
     * @return 抄本番号
     */
    ShohonNo getShohonNo();

    /**
     * 抄本番号のsetメソッドです。
     *
     * @param shohonNo 抄本番号
     */
    void setShohonNo(ShohonNo shohonNo);

    /**
     * グループコードのgetメソッドです。
     *
     * @return グループコード
     */
    RString getGroupCode();

    /**
     * グループコードのsetメソッドです。
     *
     * @param groupCode グループコード
     */
    void setGroupCode(RString groupCode);

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    RString getTohyokuCode();

    /**
     * 投票区コードのsetメソッドです。
     *
     * @param tohyokuCode 投票区コード
     */
    void setTohyokuCode(RString tohyokuCode);

    /**
     * 冊のgetメソッドです。
     *
     * @return 冊
     */
    RString getSatsu();

    /**
     * 冊のsetメソッドです。
     *
     * @param satsu 冊
     */
    void setSatsu(RString satsu);

    /**
     * 頁のgetメソッドです。
     *
     * @return 頁
     */
    int getPage();

    /**
     * 頁のsetメソッドです。
     *
     * @param page 頁
     */
    void setPage(int page);

    /**
     * 行のgetメソッドです。
     *
     * @return 行
     */
    int getGyo();

    /**
     * 行のsetメソッドです。
     *
     * @param gyo 行
     */
    void setGyo(int gyo);

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    BigSerial getSeq();

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param seq 履歴番号
     */
    void setSeq(BigSerial seq);

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    ShikibetsuCode getShikibetsuCode();

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    void setShikibetsuCode(ShikibetsuCode shikibetsuCode);

    /**
     * 投票区変更抹消フラグのgetメソッドです。
     *
     * @return 投票区変更抹消フラグ
     */
    boolean isTohyokuHenkoMasshoFlag();

    /**
     * 投票区変更抹消フラグのsetメソッドです。
     *
     * @param tohyokuHenkoMasshoFlag 投票区変更抹消フラグ
     */
    void setTohyokuHenkoMasshoFlag(boolean tohyokuHenkoMasshoFlag);

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    int getRenban();

    /**
     * 連番のsetメソッドです。
     *
     * @param renban 連番
     */
    void setRenban(int renban);

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    int getEdaban();

    /**
     * 枝番のsetメソッドです。
     *
     * @param edaban 枝番
     */
    void setEdaban(int edaban);
}
