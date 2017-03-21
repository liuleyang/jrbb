/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuIdentifier;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link SenkyoShikaku}の編集を行うビルダークラスです。
 */
public class SenkyoShikakuBuilder {

    private final AfT113SenkyoShikakuEntity entity;
    private final SenkyoShikakuIdentifier id;
    private final Models<FuzaishaTohyoShikakuIdentifier, FuzaishaTohyoShikaku> fuzaishaTohyoShikaku;

    /**
     * {@link AfT113SenkyoShikakuEntity}より{@link SenkyoShikaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT113SenkyoShikakuEntity}
     * @param id {@link SenkyoShikakuIdentifier}
     * @param fuzaishaTohyoShikaku {@link Models}
     *
     */
    SenkyoShikakuBuilder(
            AfT113SenkyoShikakuEntity entity,
            SenkyoShikakuIdentifier id,
            Models<FuzaishaTohyoShikakuIdentifier, FuzaishaTohyoShikaku> fuzaishaTohyoShikaku
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.fuzaishaTohyoShikaku = fuzaishaTohyoShikaku.clone();

    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 選挙種類
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set選挙種類(Code 選挙種類) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        entity.setSenkyoShurui(選挙種類);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set履歴番号(BigSerial 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setSeq(履歴番号);
        return this;
    }

    /**
     * 選挙資格区分を設定します。
     *
     * @param 選挙資格区分 選挙資格区分
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set選挙資格区分(Code 選挙資格区分) {
        requireNonNull(選挙資格区分, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙資格区分"));
        entity.setShikakuKubun(選挙資格区分);
        return this;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード 投票区コード
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set投票区コード(RString 投票区コード) {
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        entity.setTohyokuCode(投票区コード);
        return this;
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param 名簿登録年月日 名簿登録年月日
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set名簿登録年月日(FlexibleDate 名簿登録年月日) {
        requireNonNull(名簿登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("名簿登録年月日"));
        entity.setMeiboTorokuYMD(名簿登録年月日);
        return this;
    }

    /**
     * 登録事由コードを設定します。
     *
     * @param 登録事由コード 登録事由コード
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set登録事由コード(Code 登録事由コード) {
        requireNonNull(登録事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("登録事由コード"));
        entity.setTorokuJiyuCode(登録事由コード);
        return this;
    }

    /**
     * 登録停止年月日を設定します。
     *
     * @param 登録停止年月日 登録停止年月日
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set登録停止年月日(FlexibleDate 登録停止年月日) {
        requireNonNull(登録停止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録停止年月日"));
        entity.setTorokuTeishiYMD(登録停止年月日);
        return this;
    }

    /**
     * 登録停止事由コードを設定します。
     *
     * @param 登録停止事由コード 登録停止事由コード
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set登録停止事由コード(Code 登録停止事由コード) {
        requireNonNull(登録停止事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("登録停止事由コード"));
        entity.setTorokuTeishiJiyuCode(登録停止事由コード);
        return this;
    }

    /**
     * 表示年月日を設定します。
     *
     * @param 表示年月日 表示年月日
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set表示年月日(FlexibleDate 表示年月日) {
        requireNonNull(表示年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("表示年月日"));
        entity.setHyojiYMD(表示年月日);
        return this;
    }

    /**
     * 表示事由コードを設定します。
     *
     * @param 表示事由コード 表示事由コード
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set表示事由コード(Code 表示事由コード) {
        requireNonNull(表示事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("表示事由コード"));
        entity.setHyojiJiyuCode(表示事由コード);
        return this;
    }

    /**
     * 表示消除年月日を設定します。
     *
     * @param 表示消除年月日 表示消除年月日
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set表示消除年月日(FlexibleDate 表示消除年月日) {
        requireNonNull(表示消除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("表示消除年月日"));
        entity.setHyojiShojoYMD(表示消除年月日);
        return this;
    }

    /**
     * 表示消除予定年月日を設定します。
     *
     * @param 表示消除予定年月日 表示消除予定年月日
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set表示消除予定年月日(FlexibleDate 表示消除予定年月日) {
        requireNonNull(表示消除予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("表示消除予定年月日"));
        entity.setHyojiShojoYoteiYMD(表示消除予定年月日);
        return this;
    }

    /**
     * 抹消年月日を設定します。
     *
     * @param 抹消年月日 抹消年月日
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set抹消年月日(FlexibleDate 抹消年月日) {
        requireNonNull(抹消年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("抹消年月日"));
        entity.setMasshoYMD(抹消年月日);
        return this;
    }

    /**
     * 抹消事由コードを設定します。
     *
     * @param 抹消事由コード 抹消事由コード
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set抹消事由コード(Code 抹消事由コード) {
        requireNonNull(抹消事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("抹消事由コード"));
        entity.setMasshoJiyuCode(抹消事由コード);
        return this;
    }

    /**
     * 刑期終了年月日を設定します。
     *
     * @param 刑期終了年月日 刑期終了年月日
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set刑期終了年月日(FlexibleDate 刑期終了年月日) {
        requireNonNull(刑期終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("刑期終了年月日"));
        entity.setKeikiShuryoYMD(刑期終了年月日);
        return this;
    }

    /**
     * 2刑持ちフラグを設定します。
     *
     * @param にけい刑持ちフラグ にけい刑持ちフラグ
     * @return {@link SenkyoShikakuBuilder}
     */
    public SenkyoShikakuBuilder set2刑持ちフラグ(boolean にけい刑持ちフラグ) {
        requireNonNull(にけい刑持ちフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("2刑持ちフラグ")
        );
        entity.setNikeimochiFlag(にけい刑持ちフラグ);
        return this;
    }

    /**
     * 不在者投票資格のキー情報について判定します。<br>
     * 選挙資格に関連できる不在者投票資格である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は不在者投票資格リストに不在者投票資格{@link FuzaishaTohyoShikaku}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 不在者投票資格 {@link FuzaishaTohyoShikaku}
     * @return {@link FuzaishaTohyoShikakuBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public SenkyoShikakuBuilder setFuzaishaTohyoShikaku(FuzaishaTohyoShikaku 不在者投票資格) {
        if (hasSameIdentifier(不在者投票資格.identifier())) {
            fuzaishaTohyoShikaku.add(不在者投票資格);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(FuzaishaTohyoShikakuIdentifier 不在者投票資格識別子) {
        return id.get識別コード().equals(不在者投票資格識別子.get識別コード());
    }

//TODO 子階層のリレーション有無に応じて、選択して下さい
    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    /**
     * {@link SenkyoShikaku}のインスタンスを生成します。
     *
     * @return {@link SenkyoShikaku}のインスタンス
     */
    public SenkyoShikaku build() {
        return new SenkyoShikaku(entity, id, fuzaishaTohyoShikaku);
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="無しの場合">
    /**
     * {@link SenkyoShikaku}のインスタンスを生成します。
     *
     * @return {@link SenkyoShikaku}のインスタンス
     */
    public SenkyoShikaku build2() {
        return new SenkyoShikaku(entity, id, null);
    }
    // </editor-fold>
}
