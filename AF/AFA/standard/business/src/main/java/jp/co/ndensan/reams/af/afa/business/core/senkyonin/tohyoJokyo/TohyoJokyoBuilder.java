/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * {@link TohyoJokyo}の編集を行うビルダークラスです。
 */
public class TohyoJokyoBuilder {

    private final AfT201TohyoJokyoEntity entity;
    private final TohyoJokyoIdentifier id;

    /**
     * {@link AfT201TohyoJokyoEntity}より{@link TohyoJokyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link AfT201TohyoJokyoEntity}
     * @param id {@link TohyoJokyoIdentifier}
     *
     */
    TohyoJokyoBuilder(
            AfT201TohyoJokyoEntity entity,
            TohyoJokyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 抄本番号
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        entity.setShohonNo(抄本番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 選挙番号を設定します。
     *
     * @param 選挙番号 選挙番号
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set選挙番号(SenkyoNo 選挙番号) {
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        entity.setSenkyoNo(選挙番号);
        return this;
    }

    /**
     * 投票状況を設定します。
     *
     * @param 投票状況 投票状況
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set投票状況(Code 投票状況) {
        entity.setTohyoJokyo(投票状況);
        return this;
    }

    /**
     * 投票事由コードを設定します。
     *
     * @param 投票事由コード 投票事由コード
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set投票事由コード(Code 投票事由コード) {
        entity.setTohyoJiyuCode(投票事由コード);
        return this;
    }

    /**
     * 請求年月日を設定します。
     *
     * @param 請求年月日 請求年月日
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set請求年月日(FlexibleDate 請求年月日) {
        entity.setSeikyuYMD(請求年月日);
        return this;
    }

    /**
     * 請求方法を設定します。
     *
     * @param 請求方法 請求方法
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set請求方法(Code 請求方法) {
        entity.setSeikyuHoho(請求方法);
        return this;
    }

    /**
     * 受付番号を設定します。
     *
     * @param 受付番号 受付番号
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set受付番号(Integer 受付番号) {
        entity.setUketsukeNo(受付番号);
        return this;
    }

    /**
     * 交付年月日を設定します。
     *
     * @param 交付年月日 交付年月日
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set交付年月日(FlexibleDate 交付年月日) {
        entity.setKofuYMD(交付年月日);
        return this;
    }

    /**
     * 交付時刻を設定します。
     *
     * @param 交付時刻 交付時刻
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set交付時刻(RTime 交付時刻) {
        entity.setKofuTime(交付時刻);
        return this;
    }

    /**
     * 交付方法を設定します。
     *
     * @param 交付方法 交付方法
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set交付方法(Code 交付方法) {
        entity.setKofuHoho(交付方法);
        return this;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード 施設コード
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set施設コード(RString 施設コード) {
        entity.setShisetsuCode(施設コード);
        return this;
    }

    /**
     * 受取年月日を設定します。
     *
     * @param 受取年月日 受取年月日
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set受取年月日(FlexibleDate 受取年月日) {
        entity.setUketoriYMD(受取年月日);
        return this;
    }

    /**
     * 受理年月日を設定します。
     *
     * @param 受理年月日 受理年月日
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set受理年月日(FlexibleDate 受理年月日) {
        entity.setJuriYMD(受理年月日);
        return this;
    }

    /**
     * 受理時刻を設定します。
     *
     * @param 受理時刻 受理時刻
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set受理時刻(RTime 受理時刻) {
        entity.setJuriTime(受理時刻);
        return this;
    }

    /**
     * 受理方法を設定します。
     *
     * @param 受理方法 受理方法
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set受理方法(Code 受理方法) {
        entity.setJuriHoho(受理方法);
        return this;
    }

    /**
     * 受理施設種別を設定します。
     *
     * @param 受理施設種別 受理施設種別
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set受理施設種別(Code 受理施設種別) {
        entity.setJuriShisetsuShubetsu(受理施設種別);
        return this;
    }

    /**
     * 棄権年月日を設定します。
     *
     * @param 棄権年月日 棄権年月日
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set棄権年月日(FlexibleDate 棄権年月日) {
        entity.setKikenYMD(棄権年月日);
        return this;
    }

    /**
     * 返還年月日を設定します。
     *
     * @param 返還年月日 返還年月日
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set返還年月日(FlexibleDate 返還年月日) {
        entity.setHenkanYMD(返還年月日);
        return this;
    }

    /**
     * 点字フラグを設定します。
     *
     * @param 点字フラグ 点字フラグ
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set点字フラグ(boolean 点字フラグ) {
        requireNonNull(点字フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("点字フラグ"));
        entity.setTenjiFlag(点字フラグ);
        return this;
    }

    /**
     * 代理投票有フラグを設定します。
     *
     * @param 代理投票有フラグ 代理投票有フラグ
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set代理投票有フラグ(boolean 代理投票有フラグ) {
        requireNonNull(代理投票有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("代理投票有フラグ"));
        entity.setDairiTohyoAriFlag(代理投票有フラグ);
        return this;
    }

    /**
     * 補助者識別コード1を設定します。
     *
     * @param 補助者識別コード1 補助者識別コード1
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set補助者識別コード1(ShikibetsuCode 補助者識別コード1) {
        entity.setHojoshaShikibetsuCode1(補助者識別コード1);
        return this;
    }

    /**
     * 補助者氏名1を設定します。
     *
     * @param 補助者氏名1 補助者氏名1
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set補助者氏名1(AtenaMeisho 補助者氏名1) {
        entity.setHojoshaShimei1(補助者氏名1);
        return this;
    }

    /**
     * 補助者識別コード2を設定します。
     *
     * @param 補助者識別コード2 補助者識別コード2
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set補助者識別コード2(ShikibetsuCode 補助者識別コード2) {
        entity.setHojoshaShikibetsuCode2(補助者識別コード2);
        return this;
    }

    /**
     * 補助者氏名2を設定します。
     *
     * @param 補助者氏名2 補助者氏名2
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set補助者氏名2(AtenaMeisho 補助者氏名2) {
        entity.setHojoshaShimei2(補助者氏名2);
        return this;
    }

    /**
     * 拒否事由を設定します。
     *
     * @param 拒否事由 拒否事由
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set拒否事由(RString 拒否事由) {
        entity.setKyohiJiyu(拒否事由);
        return this;
    }

    /**
     * 証明書出力フラグを設定します。
     *
     * @param 証明書出力フラグ 証明書出力フラグ
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set証明書出力フラグ(boolean 証明書出力フラグ) {
        requireNonNull(証明書出力フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("証明書出力フラグ"));
        entity.setShomeishoPrintFlag(証明書出力フラグ);
        return this;
    }

    /**
     * 送致済フラグを設定します。
     *
     * @param 送致済フラグ 送致済フラグ
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set送致済フラグ(boolean 送致済フラグ) {
        requireNonNull(送致済フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("送致済フラグ"));
        entity.setSochiZumiFlag(送致済フラグ);
        return this;
    }

    /**
     * 期日前不在者区分を設定します。
     *
     * @param 期日前不在者区分 期日前不在者区分
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set期日前不在者区分(Code 期日前不在者区分) {
        entity.setKijitsuFuzaiKubun(期日前不在者区分);
        return this;
    }

    /**
     * 更新端末IDを設定します。
     *
     * @param 更新端末ID 更新端末ID
     * @return {@link TohyoJokyoBuilder}
     */
    public TohyoJokyoBuilder set更新端末ID(RString 更新端末ID) {
        entity.setReamsClientId(更新端末ID);
        return this;
    }

    /**
     * {@link TohyoJokyo}のインスタンスを生成します。
     *
     * @return {@link TohyoJokyo}のインスタンス
     */
    public TohyoJokyo build() {
        return new TohyoJokyo(entity, id);
    }

    /**
     * {@link TohyoJokyo}の受付番号の設定を判断します。
     *
     * @return 判断結果
     */
    public boolean need設定受付番号() {
        Integer uketsukeNo = entity.getUketsukeNo();
        return EntityDataState.Added == entity.getState() || uketsukeNo == null || uketsukeNo == 0;
    }

    /**
     * {@link TohyoJokyo}のStateを返します。
     *
     * @return State
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
