/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tohyorokufuzui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tohyorokufuzui.TohyorokuFuzui;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT205TohyorokuFuzui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT205TohyorokuFuzuiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT205TohyorokuFuzuiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票録付随情報を管理するクラスです。
 */
public class TohyorokuFuzuiManager {

    private final AfT205TohyorokuFuzuiDac dac;

    /**
     * 投票録付随情報のorder
     */
    public enum OrderTohyorokuFuzui {

        /**
         * 選管順
         */
        選管順(new RString("選管順")),
        /**
         * 管理者順
         */
        管理者順(new RString("管理者順")),
        /**
         * 再交付者順
         */
        再交付者順(new RString("再交付者順"));

        private final RString key;

        OrderTohyorokuFuzui(RString key) {
            this.key = key;
        }

        RString getKey() {
            return this.key;
        }

        List<AfT205TohyorokuFuzui> getOrderList() {
            List<AfT205TohyorokuFuzui> orderList = new ArrayList();
            if (this.key.equals(選管順.getKey())) {
                orderList = Arrays.asList(AfT205TohyorokuFuzui.renban);
            } else if (this.key.equals(管理者順.getKey())) {
                orderList = Arrays.asList(AfT205TohyorokuFuzui.renban, AfT205TohyorokuFuzui.toha,
                        AfT205TohyorokuFuzui.shimei, AfT205TohyorokuFuzui.sankaiTime);
            } else if (this.key.equals(再交付者順.getKey())) {
                orderList = Arrays.asList(AfT205TohyorokuFuzui.renban, AfT205TohyorokuFuzui.shimei, AfT205TohyorokuFuzui.jiyu);
            }
            return orderList;
        }
    }

    /**
     * コンストラクタです。
     */
    public TohyorokuFuzuiManager() {
        dac = InstanceProvider.create(AfT205TohyorokuFuzuiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT205TohyorokuFuzuiDac}
     */
    public TohyorokuFuzuiManager(AfT205TohyorokuFuzuiDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyorokuFuzuiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyorokuFuzuiManager}のインスタンス
     */
    public static TohyorokuFuzuiManager createInstance() {
        return InstanceProvider.create(TohyorokuFuzuiManager.class);
    }

    /**
     * 検索条件合致するの期日前投票録付随情報を返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票録項目種類 投票録項目種類
     * @param 投票状況 投票状況
     * @return TohyorokuFuzui
     */
    @Transaction
    public List<TohyorokuFuzui> get投票録付随情報(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            Code 投票録項目種類,
            RString 投票状況) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));

        List<AfT205TohyorokuFuzuiEntity> entityList;

        if (TohyoJokyo.期日前.getCode().equals(投票状況)) {
            requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
            entityList = dac.selectByShisetsuCode(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票録項目種類);
        } else if (TohyoJokyo.当日.getCode().equals(投票状況)) {
            requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
            entityList = dac.selectByTohyokuCode(抄本番号, 選挙番号, 報告年月日, 投票区コード, 投票録項目種類);
        } else {
            entityList = dac.select(抄本番号, 選挙番号, 報告年月日, 投票録項目種類);
        }

        if (entityList.isEmpty()) {
            return null;
        }

        List<TohyorokuFuzui> tohyorokuFuzuiList = new ArrayList<>();
        for (AfT205TohyorokuFuzuiEntity entity : entityList) {
            entity.initializeMd5();
            tohyorokuFuzuiList.add(new TohyorokuFuzui(entity));
        }
        return tohyorokuFuzuiList;
    }

    /**
     * 検索条件合致するの期日前投票録付随情報を返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票録項目種類 投票録項目種類
     * @param 順種類 順種類
     * @param orderAsc Order順
     * @return TohyorokuFuzui
     */
    @Transaction
    public List<TohyorokuFuzui> get投票録付随情報WithOrderBy(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            Code 投票録項目種類,
            OrderTohyorokuFuzui 順種類,
            List<Order> orderAsc) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録項目種類"));
        requireNonNull(順種類, UrSystemErrorMessages.値がnull.getReplacedMessage("順種類"));

        List<AfT205TohyorokuFuzui> orderName = 順種類.getOrderList();
        if (!(null != orderName && null != orderAsc && orderName.size() == orderAsc.size())) {
            return null;
        }

        List<AfT205TohyorokuFuzuiEntity> entityList
                = dac.selectWithOrderBy(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類, orderName, orderAsc);

        if (entityList.isEmpty()) {
            return null;
        }

        List<TohyorokuFuzui> tohyorokuFuzuiList = new ArrayList<>();
        for (AfT205TohyorokuFuzuiEntity entity : entityList) {
            entity.initializeMd5();
            tohyorokuFuzuiList.add(new TohyorokuFuzui(entity));
        }
        return tohyorokuFuzuiList;
    }

    /**
     * 検索条件合致するの期日前投票録付随情報を返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票録項目種類 投票録項目種類
     * @return Max連番
     */
    @Transaction
    public int get投票録付随情報Max連番(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            Code 投票録項目種類) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年月日"));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区コード"));
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録項目種類"));

        return dac.selectMaxRenban(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類);
    }

    /**
     * 投票録付随{@link TohyorokuFuzui}を保存します。
     *
     * @param 投票録付随 {@link TohyorokuFuzui}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save(TohyorokuFuzui 投票録付随) {
        requireNonNull(投票録付随, UrSystemErrorMessages.値がnull.getReplacedMessage("投票録付随"));
        if (!投票録付随.hasChanged()) {
            return false;
        }
        return 1 == dac.save(投票録付随.toEntity());
    }
}
