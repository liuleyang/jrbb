/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokuhenko;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 名簿情報です。
 */
public class SenkyoninMeiboJoho implements ISenkyoninMeiboJoho, Serializable {

    private boolean isDeleted = false;
    private ShohonNo shohonNo;
    private RString groupCode;
    private RString tohyokuCode;
    private RString satsu;
    private int page;
    private int gyo;
    private BigSerial seq;
    private ShikibetsuCode shikibetsuCode;
    private boolean tohyokuHenkoMasshoFlag;
    private int renban;
    private int edaban;

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    @Override
    public boolean hasIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    @Override
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 抄本番号のgetメソッドです。
     *
     * @return 抄本番号
     */
    @Override
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * 抄本番号のsetメソッドです。
     *
     * @param shohonNo 抄本番号
     */
    @Override
    public void setShohonNo(ShohonNo shohonNo) {
        this.shohonNo = shohonNo;
    }

    /**
     * グループコードのgetメソッドです。
     *
     * @return グループコード
     */
    @Override
    public RString getGroupCode() {
        return groupCode;
    }

    /**
     * グループコードのsetメソッドです。
     *
     * @param groupCode グループコード
     */
    @Override
    public void setGroupCode(RString groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    @Override
    public RString getTohyokuCode() {
        return tohyokuCode;
    }

    /**
     * 投票区コードのsetメソッドです。
     *
     * @param tohyokuCode 投票区コード
     */
    @Override
    public void setTohyokuCode(RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * 冊のgetメソッドです。
     *
     * @return 冊
     */
    @Override
    public RString getSatsu() {
        return satsu;
    }

    /**
     * 冊のsetメソッドです。
     *
     * @param satsu 冊
     */
    @Override
    public void setSatsu(RString satsu) {
        this.satsu = satsu;
    }

    /**
     * 頁のgetメソッドです。
     *
     *
     * @return 頁
     */
    @Override
    public int getPage() {
        return page;
    }

    /**
     * 頁のsetメソッドです。
     *
     * @param page 頁
     */
    @Override
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 行のgetメソッドです。
     *
     * @return 行
     */
    @Override
    public int getGyo() {
        return gyo;
    }

    /**
     * 行のsetメソッドです。
     *
     * @param gyo 行
     */
    @Override
    public void setGyo(int gyo) {
        this.gyo = gyo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    @Override
    public BigSerial getSeq() {
        return seq;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param seq 履歴番号
     */
    @Override
    public void setSeq(BigSerial seq) {
        this.seq = seq;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    @Override
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    @Override
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 投票区変更抹消フラグのgetメソッドです。
     *
     * @return 投票区変更抹消フラグ
     */
    @Override
    public boolean isTohyokuHenkoMasshoFlag() {
        return tohyokuHenkoMasshoFlag;
    }

    /**
     * 投票区変更抹消フラグのsetメソッドです。
     *
     * @param tohyokuHenkoMasshoFlag 投票区変更抹消フラグ
     */
    @Override
    public void setTohyokuHenkoMasshoFlag(boolean tohyokuHenkoMasshoFlag) {
        this.tohyokuHenkoMasshoFlag = tohyokuHenkoMasshoFlag;
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    @Override
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param renban 連番
     */
    @Override
    public void setRenban(int renban) {
        this.renban = renban;
    }

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    @Override
    public int getEdaban() {
        return edaban;
    }

    /**
     * 枝番のsetメソッドです。
     *
     * @param edaban 枝番
     */
    @Override
    public void setEdaban(int edaban) {
        this.edaban = edaban;
    }
}
