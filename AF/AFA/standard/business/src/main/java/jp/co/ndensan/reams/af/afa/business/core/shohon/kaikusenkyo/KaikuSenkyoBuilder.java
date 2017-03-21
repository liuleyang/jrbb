/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shohon.kaikusenkyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 海区漁業調整委員会委員選挙人名簿作成するクラスです。
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public class KaikuSenkyoBuilder {

    private final AfT131KaikuSenkyoEntity entity;
    private final KaikuSenkyoIdentifier id;

    /**
     * {@link AfT111SenkyoEntity}より{@link Senkyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT111SenkyoEntity}
     * @param id {@link SenkyoIdentifier}
     *
     */
    KaikuSenkyoBuilder(AfT131KaikuSenkyoEntity entity, KaikuSenkyoIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 ShohonNo
     * @return {@link KaikuSenkyoBuilder}
     */
    public KaikuSenkyoBuilder set抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        entity.setShohonNo(抄本番号);
        return this;
    }

    /**
     * 年度を設定します。
     *
     * @param 年度 RYear
     * @return {@link KaikuSenkyoBuilder}
     */
    public KaikuSenkyoBuilder set年度(RYear 年度) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        entity.setNendo(年度);
        return this;
    }

    /**
     * 名簿作成年月日を設定します。
     *
     * @param 名簿作成年月日 FlexibleDate
     * @return {@link KaikuSenkyoBuilder}
     */
    public KaikuSenkyoBuilder set名簿作成年月日(FlexibleDate 名簿作成年月日) {
        requireNonNull(名簿作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("名簿作成年月日"));
        entity.setSakuseiYMD(名簿作成年月日);
        return this;
    }

    /**
     * 名簿確定年月日を設定します。
     *
     * @param 名簿確定年月日 FlexibleDate
     * @return {@link KaikuSenkyoBuilder}
     */
    public KaikuSenkyoBuilder set名簿確定年月日(FlexibleDate 名簿確定年月日) {
        requireNonNull(名簿確定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("名簿確定年月日"));
        entity.setKakuteiYMD(名簿確定年月日);
        return this;
    }

    /**
     * 名簿最新化年月日を設定します。
     *
     * @param 名簿最新化年月日 FlexibleDate
     * @return {@link KaikuSenkyoBuilder}
     */
    public KaikuSenkyoBuilder set名簿最新化年月日(FlexibleDate 名簿最新化年月日) {
        requireNonNull(名簿最新化年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("名簿最新化年月日"));
        entity.setSaishinkaYMD(名簿最新化年月日);
        return this;
    }

    /**
     * 選挙時登録フラグを設定します。
     *
     * @param 選挙時登録フラグ boolean
     * @return {@link KaikuSenkyoBuilder}
     */
    public KaikuSenkyoBuilder set選挙時登録フラグ(boolean 選挙時登録フラグ) {
        requireNonNull(選挙時登録フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙時登録フラグ"));
        entity.setSenkyojiTorokuFlag(選挙時登録フラグ);
        return this;
    }

    /**
     * {@link Senkyo}のインスタンスを生成します。
     *
     * @return {@link Senkyo}のインスタンス
     */
    public KaikuSenkyo build() {
        return new KaikuSenkyo(entity, id);
    }
}
