/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubin;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubinIdentifier;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link FuzaishaTohyoShikaku}の編集を行うビルダークラスです。
 */
public class FuzaishaTohyoShikakuBuilder {

    private final AfT114FuzaishaTohyoShikakuEntity entity;
    private final FuzaishaTohyoShikakuIdentifier id;
    private final Models<FuzaishaTohyoShikakuYubinIdentifier, FuzaishaTohyoShikakuYubin> fuzaishaTohyoShikakuYubin;

    /**
     * {@link AfT114FuzaishaTohyoShikakuEntity}より{@link FuzaishaTohyoShikaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT114FuzaishaTohyoShikakuEntity}
     * @param id {@link FuzaishaTohyoShikakuIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    FuzaishaTohyoShikakuBuilder(
            AfT114FuzaishaTohyoShikakuEntity entity,
            FuzaishaTohyoShikakuIdentifier id,
            Models<FuzaishaTohyoShikakuYubinIdentifier, FuzaishaTohyoShikakuYubin> fuzaishaTohyoShikakuYubin) {
        this.entity = entity.clone();
        this.id = id;
        this.fuzaishaTohyoShikakuYubin = fuzaishaTohyoShikakuYubin.clone();
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 投票資格種類を設定します。
     *
     * @param 投票資格種類 投票資格種類
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set投票資格種類(Code 投票資格種類) {
        requireNonNull(投票資格種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票資格種類"));
        entity.setTohyoShikakuShurui(投票資格種類);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set履歴番号(BigSerial 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setSeq(履歴番号);
        return this;
    }

    /**
     * 交付年月日を設定します。
     *
     * @param 交付年月日 交付年月日
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set交付年月日(FlexibleDate 交付年月日) {
        requireNonNull(交付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("交付年月日"));
        entity.setKofuYMD(交付年月日);
        return this;
    }

    /**
     * 交付番号を設定します。
     *
     * @param 交付番号 交付番号
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set交付番号(RString 交付番号) {
        requireNonNull(交付番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交付番号"));
        entity.setKofuNo(交付番号);
        return this;
    }

    /**
     * 資格登録年月日を設定します。
     *
     * @param 資格登録年月日 資格登録年月日
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set資格登録年月日(FlexibleDate 資格登録年月日) {
        requireNonNull(資格登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格登録年月日"));
        entity.setShikakuTorokuYMD(資格登録年月日);
        return this;
    }

    /**
     * 資格満了年月日を設定します。
     *
     * @param 資格満了年月日 資格満了年月日
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set資格満了年月日(FlexibleDate 資格満了年月日) {
        requireNonNull(資格満了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格満了年月日"));
        entity.setShikakuManryoYMD(資格満了年月日);
        return this;
    }

    /**
     * 資格抹消年月日を設定します。
     *
     * @param 資格抹消年月日 資格抹消年月日
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set資格抹消年月日(FlexibleDate 資格抹消年月日) {
        requireNonNull(資格抹消年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格抹消年月日"));
        entity.setShikakuMasshoYMD(資格抹消年月日);
        return this;
    }

    /**
     * 資格抹消事由コードを設定します。
     *
     * @param 資格抹消事由コード 資格抹消事由コード
     * @return {@link FuzaishaTohyoShikakuBuilder}
     */
    public FuzaishaTohyoShikakuBuilder set資格抹消事由コード(Code 資格抹消事由コード) {
        requireNonNull(資格抹消事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格抹消事由コード"));
        entity.setShikakuMasshoJiyuCode(資格抹消事由コード);
        return this;
    }

    /**
     * 郵便投票資格付随情報のキー情報について判定します。<br>
     * 不在者投票資格情報に関連できる郵便投票資格付随情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は郵便投票資格付随情報リストに郵便投票資格付随情報{@link FuzaishaTohyoShikakuYubin}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 郵便投票資格付随情報 {@link FuzaishaTohyoShikakuYubin}
     * @return {@link FuzaishaTohyoShikakuYubinBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public FuzaishaTohyoShikakuBuilder setFuzaishaTohyoShikakuYubin(FuzaishaTohyoShikakuYubin 郵便投票資格付随情報) {
        if (hasSameIdentifier(郵便投票資格付随情報.identifier())) {
            fuzaishaTohyoShikakuYubin.add(郵便投票資格付随情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(FuzaishaTohyoShikakuYubinIdentifier 郵便投票資格付随情報識別子) {
        return id.get識別コード().equals(郵便投票資格付随情報識別子.get識別コード());
    }

    /**
     * {@link FuzaishaTohyoShikaku}のインスタンスを生成します。
     *
     * @return {@link FuzaishaTohyoShikaku}のインスタンス
     */
    public FuzaishaTohyoShikaku build() {
        return new FuzaishaTohyoShikaku(entity, id, fuzaishaTohyoShikakuYubin);
    }
}
