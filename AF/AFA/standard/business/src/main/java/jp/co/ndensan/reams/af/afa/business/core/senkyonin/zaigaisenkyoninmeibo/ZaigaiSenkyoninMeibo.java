/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.zaigaisenkyoninmeibo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙人名簿を管理するクラスです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
public class ZaigaiSenkyoninMeibo {

    private final AfT121ZaigaiSenkyoninMeiboEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT121ZaigaiSenkyoninMeiboEntity}より{@link ZaigaiSenkyoninMeibo}を生成します。
     *
     * @param entity DBより取得した{@link AfT121ZaigaiSenkyoninMeiboEntity}
     */
    public ZaigaiSenkyoninMeibo(AfT121ZaigaiSenkyoninMeiboEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * グループコードを返します。
     *
     * @return グループコード
     */
    public RString getグループコード() {
        return entity.getGroupCode();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return entity.getTohyokuCode();
    }

    /**
     * 国外分類コードを返します。
     *
     * @return 国外分類コード
     */
    public RString get国外分類コード() {
        return entity.getKokugaiBunruiCode();
    }

    /**
     * 冊を返します。
     *
     * @return 冊
     */
    public RString get冊() {
        return entity.getSatsu();
    }

    /**
     * 頁を返します。
     *
     * @return 頁
     */
    public int get頁() {
        return entity.getPage();
    }

    /**
     * 行を返します。
     *
     * @return 行
     */
    public int get行() {
        return entity.getGyo();
    }
}
