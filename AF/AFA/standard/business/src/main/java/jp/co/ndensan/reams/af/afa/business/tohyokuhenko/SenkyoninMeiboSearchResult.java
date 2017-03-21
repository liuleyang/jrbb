/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokuhenko;

import java.io.Serializable;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 名簿情報検索結果です。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SenkyoninMeiboSearchResult implements Serializable {

    private final AfT112SenkyoninMeiboEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT112SenkyoninMeiboEntity
     */
    public SenkyoninMeiboSearchResult(AfT112SenkyoninMeiboEntity entity) {
        this.entity = entity;
    }

    /**
     * 抄本番号のgetメソッドです。
     *
     * @return 抄本番号
     */
    public ShohonNo getShohonNo() {
        return entity.getShohonNo();
    }

    /**
     * グループコードのgetメソッドです。
     *
     * @return グループコード
     */
    public RString getGroupCode() {
        return entity.getGroupCode();
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString getTohyokuCode() {
        return entity.getTohyokuCode();
    }

    /**
     * 冊のgetメソッドです。
     *
     * @return 冊
     */
    public RString getSatsu() {
        return entity.getSatsu();
    }

    /**
     * 頁のgetメソッドです。
     *
     * @return 頁
     */
    public int getPage() {
        return entity.getPage();
    }

    /**
     * 行のgetメソッドです。
     *
     * @return 行
     */
    public int getGyo() {
        return entity.getGyo();
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public BigSerial getSeq() {
        return entity.getSeq();
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return entity.getShikibetsuCode();
    }

    /**
     * 投票区変更抹消フラグのgetメソッドです。
     *
     * @return 投票区変更抹消フラグ
     */
    public boolean isTohyokuHenkoMasshoFlag() {
        return entity.getTohyokuHenkoMasshoFlag();
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    @CheckForNull
    public int getRenban() {
        return entity.getRenban();
    }

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    @CheckForNull
    public int getEdaban() {
        return entity.getEdaban();
    }

}
