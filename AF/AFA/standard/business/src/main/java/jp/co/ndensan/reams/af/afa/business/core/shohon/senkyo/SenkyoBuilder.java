/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link Senkyo}の編集を行うビルダークラスです。
 */
public class SenkyoBuilder {

    private final AfT111SenkyoEntity entity;
    private final SenkyoIdentifier id;

    /**
     * {@link AfT111SenkyoEntity}より{@link Senkyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT111SenkyoEntity}
     * @param id {@link SenkyoIdentifier}
     *
     */
    SenkyoBuilder(
            AfT111SenkyoEntity entity,
            SenkyoIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 抄本番号
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        entity.setShohonNo(抄本番号);
        return this;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 選挙番号
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set選挙番号(SenkyoNo 選挙番号) {
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        entity.setSenkyoNo(選挙番号);
        return this;
    }

    /**
     * 選挙レベルを設定します。
     *
     * @param 選挙レベル 選挙レベル
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set選挙レベル(Code 選挙レベル) {
        requireNonNull(選挙レベル, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙レベル"));
        entity.setSenkyoLevel(選挙レベル);
        return this;
    }

    /**
     * 選挙名称を設定します。
     *
     * @param 選挙名称 選挙名称
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set選挙名称(RString 選挙名称) {
        requireNonNull(選挙名称, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙名称"));
        entity.setSenkyoName(選挙名称);
        return this;
    }

    /**
     * 選挙略称を設定します。
     *
     * @param 選挙略称 選挙略称
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set選挙略称(RString 選挙略称) {
        requireNonNull(選挙略称, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙略称"));
        entity.setSenkyoRyakusho(選挙略称);
        return this;
    }

    /**
     * 選挙マークを設定します。
     *
     * @param 選挙マーク 選挙マーク
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set選挙マーク(RString 選挙マーク) {
        requireNonNull(選挙マーク, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙マーク"));
        entity.setSenkyoMark(選挙マーク);
        return this;
    }

    /**
     * 名簿基準年月日を設定します。
     *
     * @param 名簿基準年月日 名簿基準年月日
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set名簿基準年月日(FlexibleDate 名簿基準年月日) {
        requireNonNull(名簿基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("名簿基準年月日"));
        entity.setKijunYMD(名簿基準年月日);
        return this;
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param 名簿登録年月日 名簿登録年月日
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set名簿登録年月日(FlexibleDate 名簿登録年月日) {
        requireNonNull(名簿登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("名簿登録年月日"));
        entity.setMeiboTorokuYMD(名簿登録年月日);
        return this;
    }

    /**
     * 告示（公示）年月日を設定します。
     *
     * @param 告示_公示年月日 告示（公示）年月日
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set告示_公示年月日(FlexibleDate 告示_公示年月日) {
        requireNonNull(告示_公示年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("告示（公示）年月日"));
        entity.setKokujiYMD(告示_公示年月日);
        return this;
    }

    /**
     * 転出期限年月日を設定します。
     *
     * @param 転出期限年月日 転出期限年月日
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set転出期限年月日(FlexibleDate 転出期限年月日) {
        requireNonNull(転出期限年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("転出期限年月日"));
        entity.setTenshutsuKigenYMD(転出期限年月日);
        return this;
    }

    /**
     * 転入期限年月日を設定します。
     *
     * @param 転入期限年月日 転入期限年月日
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set転入期限年月日(FlexibleDate 転入期限年月日) {
        requireNonNull(転入期限年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("転入期限年月日"));
        entity.setTennyuKigenYMD(転入期限年月日);
        return this;
    }

    /**
     * 投票受付開始年月日を設定します。
     *
     * @param 投票受付開始年月日 投票受付開始年月日
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set投票受付開始年月日(FlexibleDate 投票受付開始年月日) {
        requireNonNull(投票受付開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("投票受付開始年月日"));
        entity.setTohyoUketsukeYMD(投票受付開始年月日);
        return this;
    }

    /**
     * 無投票選挙フラグを設定します。
     *
     * @param 無投票選挙フラグ 無投票選挙フラグ
     * @return {@link SenkyoBuilder}
     */
    public SenkyoBuilder set無投票選挙フラグ(boolean 無投票選挙フラグ) {
        requireNonNull(無投票選挙フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("無投票選挙フラグ"));
        entity.setMutohyoSenkyoFlag(無投票選挙フラグ);
        return this;
    }

    /**
     * {@link Senkyo}のインスタンスを生成します。
     *
     * @return {@link Senkyo}のインスタンス
     */
    public Senkyo build() {
        return new Senkyo(entity, id);
    }
}
