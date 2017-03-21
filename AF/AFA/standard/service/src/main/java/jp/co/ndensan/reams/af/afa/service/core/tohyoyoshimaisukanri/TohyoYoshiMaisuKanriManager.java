/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tohyoyoshimaisukanri;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.tohyoyoshimaisukanri.TohyoYoshiMaisuKanri;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT251TohyoYoshiMaisuKanriEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT251TohyoYoshiMaisuKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票用紙枚数管理を管理するクラスです。
 *
 * @reamsid_L AF-0130-020 lit
 */
public class TohyoYoshiMaisuKanriManager {

    private final AfT251TohyoYoshiMaisuKanriDac dac;

    /**
     * コンストラクタです。
     */
    public TohyoYoshiMaisuKanriManager() {
        dac = InstanceProvider.create(AfT251TohyoYoshiMaisuKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT251TohyoYoshiMaisuKanriDac}
     */
    public TohyoYoshiMaisuKanriManager(AfT251TohyoYoshiMaisuKanriDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyoYoshiMaisuKanriManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyoYoshiMaisuKanriManager}のインスタンス
     */
    public static TohyoYoshiMaisuKanriManager createInstance() {
        return InstanceProvider.create(TohyoYoshiMaisuKanriManager.class);
    }

    /**
     * 投票用紙枚数管理に合致する投票用紙枚数管理を返します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 SenkyoNo
     * @param 投票区コード RString
     * @return TohyoYoshiMaisuKanri
     */
    @Transaction
    public TohyoYoshiMaisuKanri get投票用紙枚数管理ByKey(ShohonNo 抄本番号, SenkyoNo 選挙番号, RString 投票区コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));

        AfT251TohyoYoshiMaisuKanriEntity entity = dac.select(抄本番号, 選挙番号, 投票区コード);
        if (null == entity) {
            return null;
        }

        return new TohyoYoshiMaisuKanri(entity);
    }

    /**
     * 投票用紙枚数管理{@link TohyoYoshiMaisuKanri}を保存します。
     *
     * @param 投票用紙枚数管理 {@link TohyoYoshiMaisuKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save投票用紙枚数管理(TohyoYoshiMaisuKanri 投票用紙枚数管理) {
        requireNonNull(投票用紙枚数管理, UrSystemErrorMessages.値がnull.getReplacedMessage("投票用紙枚数管理"));
        if (!投票用紙枚数管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(投票用紙枚数管理.toEntity());
    }
}
