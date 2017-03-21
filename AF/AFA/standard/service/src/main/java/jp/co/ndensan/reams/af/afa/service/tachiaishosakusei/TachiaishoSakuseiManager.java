/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.tachiaishosakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.Tohyoroku;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugi;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT204TohyorokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT206TachiaininHikitsugiJohoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT204TohyorokuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT206TachiaininHikitsugiJohoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tachiaishosakusei.ITachiaishoSakuseiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 立会人引継書ビジネスクラス
 *
 * @reamsid_L AF-0120-010 xul
 */
public class TachiaishoSakuseiManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT206TachiaininHikitsugiJohoDac tachiaininHikitsugiJohoDac;
    private final AfT204TohyorokuDac tohyorokuDac;

    /**
     * コンストラクタです。
     */
    TachiaishoSakuseiManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.tachiaininHikitsugiJohoDac = InstanceProvider.create(AfT206TachiaininHikitsugiJohoDac.class);
        this.tohyorokuDac = InstanceProvider.create(AfT204TohyorokuDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaokuManager}のインスタンス
     */
    public static TachiaishoSakuseiManager createInstance() {
        return InstanceProvider.create(TachiaishoSakuseiManager.class);
    }

    /**
     * 抄本番号をキー検索で選挙名情報取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return List<AfT111SenkyoEntity>
     */
    @Transaction
    public List<Senkyo> select選挙名By抄本番号(ShohonNo 抄本番号) {
        ITachiaishoSakuseiMapper tachiaishoSakuseiMapper = mapperProvider.create(ITachiaishoSakuseiMapper.class);
        List<AfT111SenkyoEntity> list = tachiaishoSakuseiMapper.select選挙名By抄本番号(抄本番号);
        List<Senkyo> result = new ArrayList<>();
        if (null != list && !list.isEmpty()) {
            for (AfT111SenkyoEntity entity : list) {
                Senkyo senkyo = new Senkyo(entity);
                result.add(senkyo);
            }
        }
        return result;
    }

    /**
     * 立会人引継情報新規します。
     *
     * @param 期日前当日投票録情報 Tohyoroku
     * @param 選管 TachiaininHikitsugi
     * @param 投票用紙再交付者 List<TachiaininHikitsugi>
     * @param 決定書裁決書 List<TachiaininHikitsugi>
     * @return 新規結果
     */
    @Transaction
    public boolean insert立会人引継情報(Tohyoroku 期日前当日投票録情報, TachiaininHikitsugi 選管,
            List<TachiaininHikitsugi> 投票用紙再交付者, List<TachiaininHikitsugi> 決定書裁決書) {
        return this.insert(期日前当日投票録情報, 選管, 投票用紙再交付者, 決定書裁決書);
    }

    private boolean insert(Tohyoroku 期日前当日投票録情報, TachiaininHikitsugi 選管,
            List<TachiaininHikitsugi> 投票用紙再交付者, List<TachiaininHikitsugi> 決定書裁決書) {
        if (null != 期日前当日投票録情報) {
            AfT204TohyorokuEntity entity = 期日前当日投票録情報.toEntity();
            entity.setState(EntityDataState.Added);
            if (1 != tohyorokuDac.save(entity)) {
                return false;
            }
        }
        AfT206TachiaininHikitsugiJohoEntity entity_選管 = 選管.toEntity();
        entity_選管.setState(EntityDataState.Added);
        if (1 != tachiaininHikitsugiJohoDac.save(entity_選管)) {
            return false;
        }
        if (null != 投票用紙再交付者 && !投票用紙再交付者.isEmpty()) {
            for (int i = 0; i < 投票用紙再交付者.size(); i++) {
                AfT206TachiaininHikitsugiJohoEntity entity_投票用紙再交付者 = 投票用紙再交付者.get(i).toEntity();
                if (1 != tachiaininHikitsugiJohoDac.save(entity_投票用紙再交付者)) {
                    return false;
                }
            }
        }
        if (null != 決定書裁決書 && !決定書裁決書.isEmpty()) {
            for (int i = 0; i < 決定書裁決書.size(); i++) {
                AfT206TachiaininHikitsugiJohoEntity entity_決定書裁決書 = 決定書裁決書.get(i).toEntity();
                if (1 != tachiaininHikitsugiJohoDac.save(entity_決定書裁決書)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 立会人引継情報削除します。
     *
     * @param 選管 TachiaininHikitsugi
     * @param 投票用紙再交付者 List<TachiaininHikitsugi>
     * @param 決定書裁決書 List<TachiaininHikitsugi>
     * @return 削除結果
     */
    @Transaction
    public boolean delete立会人引継情報(TachiaininHikitsugi 選管, List<TachiaininHikitsugi> 投票用紙再交付者, List<TachiaininHikitsugi> 決定書裁決書) {
        return this.deletePhysical(選管, 投票用紙再交付者, 決定書裁決書);
    }

    private boolean deletePhysical(TachiaininHikitsugi 選管, List<TachiaininHikitsugi> 投票用紙再交付者, List<TachiaininHikitsugi> 決定書裁決書) {
        if (1 != tachiaininHikitsugiJohoDac.deletePhysical(選管.toEntity())) {
            return false;
        }
        if (null != 投票用紙再交付者 && !投票用紙再交付者.isEmpty()) {
            for (TachiaininHikitsugi tachiaininHikitsugi : 投票用紙再交付者) {
                if (1 != tachiaininHikitsugiJohoDac.deletePhysical(tachiaininHikitsugi.toEntity())) {
                    return false;
                }
            }
        }
        if (null != 決定書裁決書 && !決定書裁決書.isEmpty()) {
            for (TachiaininHikitsugi tachiainin : 決定書裁決書) {
                if (1 != tachiaininHikitsugiJohoDac.deletePhysical(tachiainin.toEntity())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 立会人引継情報更新します。
     *
     * @param 元選管 TachiaininHikitsugi
     * @param 元投票用紙再交付者 List<TachiaininHikitsugi>
     * @param 元決定書裁決書 List<TachiaininHikitsugi>
     * @param 期日前当日投票録情報 Tohyoroku
     * @param 選管 TachiaininHikitsugi
     * @param 投票用紙再交付者 List<TachiaininHikitsugi>
     * @param 決定書裁決書 List<TachiaininHikitsugi>
     * @return 削除結果
     */
    @Transaction
    public boolean update立会人引継情報(TachiaininHikitsugi 元選管, List<TachiaininHikitsugi> 元投票用紙再交付者, List<TachiaininHikitsugi> 元決定書裁決書,
            Tohyoroku 期日前当日投票録情報, TachiaininHikitsugi 選管, List<TachiaininHikitsugi> 投票用紙再交付者, List<TachiaininHikitsugi> 決定書裁決書) {
        if (!this.deletePhysical(元選管, 元投票用紙再交付者, 元決定書裁決書)) {
            return false;
        }
        return this.insert(期日前当日投票録情報, 選管, 投票用紙再交付者, 決定書裁決書);
    }
}
