/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyoshikaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGMK1060 海区漁業調整委員会委員選挙人名簿登録 <br />
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class SenkyoninMeiboEntity {

    private final AfT112SenkyoninMeiboEntity entity;

    /**
     * コンストラクタです。<br/>
     * 選挙人名簿の新規作成時に使用します。
     *
     * @param 抄本番号 抄本番号
     * @param グループコード グループコード
     * @param 投票区コード 投票区コード
     * @param 冊 冊
     * @param 頁 頁
     * @param 行 行
     * @param 履歴番号 履歴番号
     * @param 識別コード 識別コード
     * @param 投票区変更抹消フラグ 投票区変更抹消フラグ
     * @param 連番 連番
     * @param 枝番 枝番
     */
    public SenkyoninMeiboEntity(ShohonNo 抄本番号,
            RString グループコード,
            RString 投票区コード,
            RString 冊,
            int 頁,
            int 行,
            BigSerial 履歴番号,
            ShikibetsuCode 識別コード,
            boolean 投票区変更抹消フラグ,
            int 連番,
            int 枝番) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(グループコード, UrSystemErrorMessages.値がnull.getReplacedMessage("グループコード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(冊, UrSystemErrorMessages.値がnull.getReplacedMessage("冊"));
        requireNonNull(頁, UrSystemErrorMessages.値がnull.getReplacedMessage("頁"));
        requireNonNull(行, UrSystemErrorMessages.値がnull.getReplacedMessage("行"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(投票区変更抹消フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区変更抹消フラグ"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        this.entity = new AfT112SenkyoninMeiboEntity();
        this.entity.setShohonNo(抄本番号);
        this.entity.setGroupCode(グループコード);
        this.entity.setTohyokuCode(投票区コード);
        this.entity.setSatsu(冊);
        this.entity.setPage(頁);
        this.entity.setGyo(行);
        this.entity.setSeq(履歴番号);
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setTohyokuHenkoMasshoFlag(投票区変更抹消フラグ);
        this.entity.setRenban(連番);
        this.entity.setEdaban(枝番);
    }
    // </editor-fold>
    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link AfT112SenkyoninMeiboEntity}
     */
    public SenkyoninMeiboEntity(
            AfT112SenkyoninMeiboEntity entity
    ) {
        this.entity = entity;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return entity.getShohonNo();
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

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号() {
        return entity.getSeq();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 投票区変更抹消フラグを返します。
     *
     * @return 投票区変更抹消フラグ
     */
    public boolean is投票区変更抹消フラグ() {
        return entity.getTohyokuHenkoMasshoFlag();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public int get枝番() {
        return entity.getEdaban();
    }

    /**
     * {@link AfT112SenkyoninMeiboEntity}のクローンを返します。
     *
     * @return {@link AfT112SenkyoninMeiboEntity}のクローン
     */
    public AfT112SenkyoninMeiboEntity toEntity() {
        return this.entity.clone();
    }

}
