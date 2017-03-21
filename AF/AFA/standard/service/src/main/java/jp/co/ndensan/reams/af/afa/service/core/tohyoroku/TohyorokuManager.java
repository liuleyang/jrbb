/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tohyoroku;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.Tohyoroku;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tohyorokufuzui.TohyorokuFuzui;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204TohyorokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT204TohyorokuDac;
import jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tohyorokufuzui.TohyorokuFuzuiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票録を管理するクラスです。
 */
public class TohyorokuManager {

    private final AfT204TohyorokuDac dac;
    private final TohyorokuFuzuiManager 投票録付随Manager;

    /**
     * コンストラクタです。
     */
    public TohyorokuManager() {
        dac = InstanceProvider.create(AfT204TohyorokuDac.class);
        投票録付随Manager = InstanceProvider.create(TohyorokuFuzuiManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT204TohyorokuDac}
     * @param tohyorokuFuzuiManager {@link TohyorokuFuzuiManager}
     */
    public TohyorokuManager(AfT204TohyorokuDac dac, TohyorokuFuzuiManager tohyorokuFuzuiManager) {
        this.dac = dac;
        this.投票録付随Manager = tohyorokuFuzuiManager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyorokuManager}のインスタンス
     */
    public static TohyorokuManager createInstance() {
        return InstanceProvider.create(TohyorokuManager.class);
    }

    /**
     * 検索条件合致するの投票録を返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @return TachiaininHikitsugi
     */
    @Transaction
    public Tohyoroku get投票録ByKey(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));

        AfT204TohyorokuEntity entity = dac.select(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード);
        if (null == entity) {
            return null;
        }
        return new Tohyoroku(entity);
    }

    /**
     * 投票録{@link Tohyoroku}、投票録付随情報リスト{@link TohyorokuFuzui}を保存します。
     *
     * @param 投票録 投票録
     * @param 投票録付随情報リスト 投票録付随情報リスト
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(Tohyoroku 投票録, List<TohyorokuFuzui> 投票録付随情報リスト) {
        requireNonNull(投票録, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録"));

        boolean hasChanged = false;
        if (!投票録.hasChanged()) {
            for (TohyorokuFuzui 投票録付随 : 投票録付随情報リスト) {
                if (投票録付随.hasChanged()) {
                    hasChanged = true;
                    break;
                }
            }
        } else {
            hasChanged = true;
        }

        if (!hasChanged) {
            return false;
        }

        投票録 = 投票録.modifiedModel();
        if (1 == dac.save(投票録.toEntity())) {
            save投票録付随リスト(投票録付随情報リスト);
        } else {
            return false;
        }
        return true;
    }

    private void save投票録付随リスト(List<TohyorokuFuzui> 投票録付随List) {
        for (TohyorokuFuzui 投票録付随 : 投票録付随List) {
            投票録付随Manager.save(投票録付随);
        }
    }
}
