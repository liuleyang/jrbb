package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;

/**
 * 集計整理表
 *
 * @reamsid_L AF-0270-036 wangl
 */
public class TohyoShukeiSeirihyo {

    private List<AfT100ShohonEntity> 抄本;
    private List<AfT111SenkyoEntity> 選挙;
    private List<AfT112SenkyoninMeiboEntity> 選挙人名簿;
    private List<AfT113SenkyoShikakuEntity> 選挙資格;
    private List<AfT201TohyoJokyoEntity> 投票状況;

    /**
     * 抄本を設定します。
     *
     * @param 抄本 List<AfT100ShohonEntity>
     */
    public void set抄本(List<AfT100ShohonEntity> 抄本) {
        this.抄本 = 抄本;
    }

    /**
     * 選挙を設定します。
     *
     * @param 選挙 List<AfT111SenkyoEntity>
     */
    public void set選挙(List<AfT111SenkyoEntity> 選挙) {
        this.選挙 = 選挙;
    }

    /**
     * 選挙人名簿を設定します。
     *
     * @param 選挙人名簿 List<AfT112SenkyoninMeiboEntity>
     */
    public void set選挙人名簿(List<AfT112SenkyoninMeiboEntity> 選挙人名簿) {
        this.選挙人名簿 = 選挙人名簿;
    }

    /**
     * 選挙資格を設定します。
     *
     * @param 選挙資格 List<AfT113SenkyoShikakuEntity>
     */
    public void set選挙資格(List<AfT113SenkyoShikakuEntity> 選挙資格) {
        this.選挙資格 = 選挙資格;
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
     * 抄本を返します。
     *
     * @return 抄本
     */
    public List<AfT100ShohonEntity> get抄本() {
        return this.抄本;
    }

    /**
     * 選挙を返します。
     *
     * @return 選挙
     */
    public List<AfT111SenkyoEntity> get選挙() {
        return this.選挙;
    }

    /**
     * 選挙人名簿を返します。
     *
     * @return 選挙人名簿
     */
    public List<AfT112SenkyoninMeiboEntity> get選挙人名簿() {
        return this.選挙人名簿;
    }

    /**
     * 選挙資格を返します。
     *
     * @return 選挙資格
     */
    public List<AfT113SenkyoShikakuEntity> get選挙資格() {
        return this.選挙資格;
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
