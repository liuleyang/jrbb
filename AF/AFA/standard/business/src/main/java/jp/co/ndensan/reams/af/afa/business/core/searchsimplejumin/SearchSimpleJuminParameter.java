/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.searchsimplejumin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索（簡易版）の選挙人情報取得Resultクラスです。
 *
 * @reamsid_L AF-0170-020 lis
 */
public class SearchSimpleJuminParameter {

    private ShohonNo shohonNo;
    private RString tohyokuCode;
    private List<Code> tohyoShikakuShuruiList;
    private Code senkyoShurui;
    private FlexibleDate tohyoYMD;
    private List<Code> shikakuKubunList;
    private ShikibetsuCode 識別コード;

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return shohonNo;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString getTohyokuCode() {
        return tohyokuCode;
    }

    /**
     * 投票資格を返します。
     *
     * @return 投票資格List
     */
    public List<Code> getTohyoShikakuShuruiList() {
        return tohyoShikakuShuruiList;
    }

    /**
     * 投票資格を返します。
     *
     * @return 投票資格List
     */
    public List<Code> getShikakuKubunList() {
        return shikakuKubunList;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public Code getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日
     */
    public FlexibleDate getTohyoYMD() {
        return tohyoYMD;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param shohonNo ShohonNo
     */
    public void setShohonNo(ShohonNo shohonNo) {
        this.shohonNo = shohonNo;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param tohyokuCode RString
     */
    public void setTohyokuCode(RString tohyokuCode) {
        this.tohyokuCode = tohyokuCode;
    }

    /**
     * 投票資格リストを設定します。
     *
     * @param tohyoShikakuShuruiList List
     */
    public void setTohyoShikakuShuruiList(List<Code> tohyoShikakuShuruiList) {
        this.tohyoShikakuShuruiList = tohyoShikakuShuruiList;
    }

    /**
     * 選挙種類を設定します。
     *
     * @param senkyoShurui Code
     */
    public void setSenkyoShurui(Code senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 投票年月日を設定します。
     *
     * @param tohyoYMD FlexibleDate
     */
    public void setTohyoYMD(FlexibleDate tohyoYMD) {
        this.tohyoYMD = tohyoYMD;
    }

    /**
     * 投票資格リストを設定します。
     *
     * @param shikakuKubunList List
     */
    public void setShikakuKubunList(List<Code> shikakuKubunList) {
        this.shikakuKubunList = shikakuKubunList;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }
}
