/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.shohon;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyo.SenkyoIdentifier;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikakuIdentifier;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeiboIdentifier;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link Shohon}の編集を行うビルダークラスです。
 */
public class ShohonBuilder {

    private final AfT100ShohonEntity entity;
    private final ShohonIdentifier id;
    private final Models<SenkyoIdentifier, Senkyo> senkyo;
    private final Models<SenkyoninMeiboIdentifier, SenkyoninMeibo> senkyoninMeibo;
    private final Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku;

    /**
     * {@link AfT100ShohonEntity}より{@link Shohon}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT100ShohonEntity}
     * @param id {@link ShohonIdentifier}
     * @param seishinTechoNini {@link Models}
     * @param todokedesha {@link Models}
     *
     */
    ShohonBuilder(
            AfT100ShohonEntity entity,
            ShohonIdentifier id,
            Models<SenkyoIdentifier, Senkyo> senkyo,
            Models<SenkyoninMeiboIdentifier, SenkyoninMeibo> senkyoninMeibo,
            Models<SenkyoShikakuIdentifier, SenkyoShikaku> senkyoShikaku
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.senkyo = senkyo;
        this.senkyoninMeibo = senkyoninMeibo;
        this.senkyoShikaku = senkyoShikaku;

    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 抄本番号
     * @return {@link ShohonBuilder}
     */
    public ShohonBuilder set抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        entity.setShohonNo(抄本番号);
        return this;
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 選挙種類
     * @return {@link ShohonBuilder}
     */
    public ShohonBuilder set選挙種類(Code 選挙種類) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        entity.setSenkyoShurui(選挙種類);
        return this;
    }

    /**
     * 抄本名を設定します。
     *
     * @param 抄本名 抄本名
     * @return {@link ShohonBuilder}
     */
    public ShohonBuilder set抄本名(RString 抄本名) {
        requireNonNull(抄本名, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本名"));
        entity.setShohonName(抄本名);
        return this;
    }

    /**
     * 投票年月日を設定します。
     *
     * @param 投票年月日 投票年月日
     * @return {@link ShohonBuilder}
     */
    public ShohonBuilder set投票年月日(FlexibleDate 投票年月日) {
        requireNonNull(投票年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("投票年月日"));
        entity.setTohyoYMD(投票年月日);
        return this;
    }

    /**
     * 規定年齢到達年月日を設定します。
     *
     * @param 規定年齢到達年月日 規定年齢到達年月日
     * @return {@link ShohonBuilder}
     */
    public ShohonBuilder set規定年齢到達年月日(FlexibleDate 規定年齢到達年月日) {
        requireNonNull(規定年齢到達年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("規定年齢到達年月日"));
        entity.setKiteiNenreiTotatsuYMD(規定年齢到達年月日);
        return this;
    }

    /**
     * 処理年月日を設定します。
     *
     * @param 処理年月日 処理年月日
     * @return {@link ShohonBuilder}
     */
    public ShohonBuilder set処理年月日(FlexibleDate 処理年月日) {
        requireNonNull(処理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月日"));
        entity.setShoriYMD(処理年月日);
        return this;
    }

    /**
     * 入場券発行固有連番を設定します。
     *
     * @param 入場券発行固有連番 入場券発行固有連番
     * @return {@link ShohonBuilder}
     */
    public ShohonBuilder set入場券発行固有連番(Decimal 入場券発行固有連番) {
        requireNonNull(入場券発行固有連番, UrSystemErrorMessages.値がnull.getReplacedMessage("入場券発行固有連番"));
        entity.setNyujokenReportIndex(入場券発行固有連番);
        return this;
    }

    // <editor-fold defaultstate="collapsed" desc="子階層のリレーションテーブルのBusinessをメンバー変数で保持する場合">
    /**
     * 選挙のキー情報について判定します。<br>
     * 抄本に関連できる選挙である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は選挙リストに選挙{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 選挙 {@link Senkyo}
     * @return {@link SenkyoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShohonBuilder setSenkyo(Senkyo 選挙) {
        if (hasSameIdentifier(選挙.identifier())) {
            senkyo.add(選挙);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(SenkyoIdentifier 選挙識別子) {
        return id.get抄本番号().equals(選挙識別子.get抄本番号());
    }

    /**
     * 選挙人名簿のキー情報について判定します。<br>
     * 抄本に関連できる選挙人名簿である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は選挙人名簿リストに選挙人名簿{@link Todokedesha}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 選挙人名簿 {@link Todokedesha}
     * @return Builder
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShohonBuilder setSenkyoninMeibo(SenkyoninMeibo 選挙人名簿) {
        if (hasSameIdentifier(選挙人名簿.identifier())) {
            senkyoninMeibo.add(選挙人名簿);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(SenkyoninMeiboIdentifier 選挙人名簿識別子) {
        return id.get抄本番号().equals(選挙人名簿識別子.get抄本番号());
    }

    /**
     * 選挙資格のキー情報について判定します。<br>
     * 抄本に関連できる選挙資格である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は選挙資格リストに選挙資格{@link SeishinTechoNini}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 選挙資格 {@link SeishinTechoNini}
     * @return {@link SeishinTechoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public ShohonBuilder setSenkyoShikaku(SenkyoShikaku 選挙資格) {
        if (hasSameIdentifier(選挙資格.identifier())) {
            senkyoShikaku.add(選挙資格);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(SenkyoShikakuIdentifier 選挙資格識別子) {
        return id.get選挙種類().equals(選挙資格識別子.get選挙種類());
    }

    // <editor-fold defaultstate="collapsed" desc="ありの場合">
    /**
     * {@link Shohon}のインスタンスを生成します。
     *
     * @return {@link Shohon}のインスタンス
     */
    public Shohon build() {
        return new Shohon(entity, id, senkyo, senkyoninMeibo, senkyoShikaku);
    }

}
