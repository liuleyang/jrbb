/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.maisukanri;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.relate.maisukanri.MaisuKanriJouhou;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票用紙枚数検索結果のクラスです。
 *
 * @reamsid_L AF-0660-010 zhanggs
 */
public class TohyoYoshiMaisuSearchResult implements Serializable {

    private static final long serialVersionUID = 351901586803745749L;

    private MaisuKanriJouhou entity;
    private boolean 更新Flag;

    /**
     * コンストラクタです。
     */
    public TohyoYoshiMaisuSearchResult() {
        entity = new MaisuKanriJouhou();
    }

    /**
     * 更新Flag
     *
     * @return 更新Flag boolean
     */
    public boolean is更新Flag() {
        return 更新Flag;
    }

    /**
     * 更新Flag
     *
     * @param 更新Flag boolean
     */
    public void set更新Flag(boolean 更新Flag) {
        this.更新Flag = 更新Flag;
    }

    /**
     * コンストラクタです。
     *
     * @param entity MaisuKanriJouhou
     */
    public TohyoYoshiMaisuSearchResult(MaisuKanriJouhou entity) {
        this.entity = entity;
    }

    /**
     * entity
     *
     * @param entity MaisuKanriJouhou
     */
    public void setEntity(MaisuKanriJouhou entity) {
        this.entity = entity;
    }

    /**
     * コンストラクタです。
     *
     * @return MaisuKanriJouhou
     */
    public MaisuKanriJouhou getEntity() {
        return entity;
    }

    /**
     * 投票区コードを取得します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return entity.get投票区コード();
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.entity.set投票区コード(投票区コード);
    }

    /**
     * 投票用紙枚数を取得します。
     *
     * @return 投票用紙枚数
     */
    public int get投票用紙枚数() {
        return entity.get投票用紙枚数();
    }

    /**
     * 投票用紙枚数を設定します。
     *
     * @param 投票用紙枚数 RString
     */
    public void set投票用紙枚数(int 投票用紙枚数) {
        this.entity.set投票用紙枚数(投票用紙枚数);
    }

    /**
     * 点字投票用紙枚数を取得します。
     *
     * @return 点字投票用紙枚数
     */
    public int get点字投票用紙枚数() {
        return entity.get点字投票用紙枚数();
    }

    /**
     * 点字投票用紙枚数を設定します。
     *
     * @param 点字投票用紙枚数 RString
     */
    public void set点字投票用紙枚数(int 点字投票用紙枚数) {
        this.entity.set点字投票用紙枚数(点字投票用紙枚数);
    }

    /**
     * 仮投票用封筒枚数を取得します。
     *
     * @return 仮投票用封筒枚数
     */
    public int get仮投票用封筒枚数() {
        return entity.get仮投票用封筒枚数();
    }

    /**
     * 仮投票用封筒枚数を設定します。
     *
     * @param 仮投票用封筒枚数 RString
     */
    public void set仮投票用封筒枚数(int 仮投票用封筒枚数) {
        this.entity.set仮投票用封筒枚数(仮投票用封筒枚数);
    }

}
