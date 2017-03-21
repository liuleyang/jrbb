/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikakuIdentifier;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoIdentifier;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link SenkyoninMeibo}の編集を行うビルダークラスです。
 */
public class SenkyoninMeiboBuilder {

    private final AfT112SenkyoninMeiboEntity entity;
    private final SenkyoninMeiboIdentifier id;
    private final Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku;
    private final Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo;

    /**
     * {@link AfT112SenkyoninMeiboEntity}より{@link SenkyoninMeibo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT112SenkyoninMeiboEntity}
     * @param id {@link SenkyoninMeiboIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    SenkyoninMeiboBuilder(
            AfT112SenkyoninMeiboEntity entity,
            SenkyoninMeiboIdentifier id,
            Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku,
            Models<TohyoJokyoIdentifier, TohyoJokyo> tohyoJokyo
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.senkyoShikaku = senkyoShikaku.clone();
        this.tohyoJokyo = tohyoJokyo.clone();

    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 抄本番号
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        entity.setShohonNo(抄本番号);
        return this;
    }

    /**
     * グループコードを設定します。
     *
     * @param グループコード グループコード
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder setグループコード(RString グループコード) {
        requireNonNull(グループコード, UrSystemErrorMessages.値がnull.getReplacedMessage("グループコード"));
        entity.setGroupCode(グループコード);
        return this;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード 投票区コード
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set投票区コード(RString 投票区コード) {
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        entity.setTohyokuCode(投票区コード);
        return this;
    }

    /**
     * 冊を設定します。
     *
     * @param 冊 冊
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set冊(RString 冊) {
        requireNonNull(冊, UrSystemErrorMessages.値がnull.getReplacedMessage("冊"));
        entity.setSatsu(冊);
        return this;
    }

    /**
     * 頁を設定します。
     *
     * @param 頁 頁
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set頁(int 頁) {
        requireNonNull(頁, UrSystemErrorMessages.値がnull.getReplacedMessage("頁"));
        entity.setPage(頁);
        return this;
    }

    /**
     * 行を設定します。
     *
     * @param 行 行
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set行(int 行) {
        requireNonNull(行, UrSystemErrorMessages.値がnull.getReplacedMessage("行"));
        entity.setGyo(行);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set履歴番号(BigSerial 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setSeq(履歴番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 投票区変更抹消フラグを設定します。
     *
     * @param 投票区変更抹消フラグ 投票区変更抹消フラグ
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set投票区変更抹消フラグ(boolean 投票区変更抹消フラグ) {
        requireNonNull(投票区変更抹消フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区変更抹消フラグ"));
        entity.setTohyokuHenkoMasshoFlag(投票区変更抹消フラグ);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * 枝番を設定します。
     *
     * @param 枝番 枝番
     * @return {@link SenkyoninMeiboBuilder}
     */
    public SenkyoninMeiboBuilder set枝番(int 枝番) {
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        entity.setEdaban(枝番);
        return this;
    }

    // <editor-fold defaultstate="collapsed" desc="子階層のリレーションテーブルのBusinessをメンバー変数で保持する場合">
    /**
     * 選挙資格のキー情報について判定します。<br>
     * 選挙人名簿に関連できる選挙資格である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は選挙資格リストに選挙資格{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 選挙資格 {@link SeishinTechoNini}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public SenkyoninMeiboBuilder setSenkyoShikaku(SenkyoShikaku 選挙資格) {
        if (hasSameIdentifier(選挙資格.identifier())) {
            senkyoShikaku.add(選挙資格);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(SenkyoShikakuIdentifier 選挙資格識別子) {
        return id.get識別コード().equals(選挙資格識別子.get識別コード());
    }

    /**
     * 投票状況のキー情報について判定します。<br>
     * 選挙人名簿に関連できる投票状況である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は投票状況リストに投票状況{@link TohyoJokyo}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 投票状況 {@link Todokedesha}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public SenkyoninMeiboBuilder setTohyoJokyo(TohyoJokyo 投票状況) {
        if (hasSameIdentifier(投票状況.identifier())) {
            tohyoJokyo.add(投票状況);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(TohyoJokyoIdentifier 投票状況識別子) {
        return (id.get抄本番号().equals(投票状況識別子.get抄本番号())
                && id.get識別コード() == 投票状況識別子.get識別コード());
    }

    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    /**
     * {@link SenkyoninMeibo}のインスタンスを生成します。
     *
     * @return {@link SenkyoninMeibo}のインスタンス
     */
    public SenkyoninMeibo build() {
        return new SenkyoninMeibo(entity, id, senkyoShikaku, tohyoJokyo);
    }
    // </editor-fold>
}
