/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.nippo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.nippo.TohyoshaListSenkyoResult;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo.INippoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 日報情報を管理するクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class NippoManager {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public NippoManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NippoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NippoManager}のインスタンス
     */
    public static NippoManager createInstance() {
        return InstanceProvider.create(NippoManager.class);
    }

    /**
     * 選挙番号に合致するリストを返します。
     *
     * @param 投票者一覧表選挙全帳票検索条件 NippoMybatisParameter
     * @return Tohyoku
     */
    @Transaction
    public TohyoshaListSenkyoResult get投票者一覧表混在セット(NippoMybatisParameter 投票者一覧表選挙全帳票検索条件) {
        INippoMapper 日報mapper = mapperProvider.create(INippoMapper.class);
        List<NippoPSMPrintEntity> 投票者一覧表 = 日報mapper.select投票者一覧表選挙全リスト(投票者一覧表選挙全帳票検索条件);
        if (null == 投票者一覧表 || 投票者一覧表.isEmpty()) {
            return new TohyoshaListSenkyoResult();
        }
        FlexibleDate 現在日時 = FlexibleDate.getNowDate();
        NippoPSMPrintEntity entity = 投票者一覧表.get(0);
        int temp = Integer.parseInt(現在日時.toString());
        for (int i = 0; i < 投票者一覧表.size(); i++) {
            FlexibleDate 受理日 = 投票者一覧表.get(i).get投票状況Entity().getJuriYMD();
            if (null != 受理日 && !受理日.isEmpty() && (temp > Math.abs(現在日時.getBetweenDays(受理日)))) {
                temp = Math.abs(現在日時.getBetweenDays(受理日));
                entity = 投票者一覧表.get(i);
            }
        }
        FlexibleDate 交付日 = entity.get投票状況Entity().getKofuYMD();
        temp = (交付日 == null || 交付日.isEmpty()) ? Integer.parseInt(現在日時.toString()) : Math.abs(現在日時.getBetweenDays(交付日));
        for (int i = 0; i < 投票者一覧表.size(); i++) {
            交付日 = 投票者一覧表.get(i).get投票状況Entity().getKofuYMD();
            if (交付日 != null && !交付日.isEmpty() && (temp > Math.abs(現在日時.getBetweenDays(交付日)))) {
                temp = Math.abs(現在日時.getBetweenDays(交付日));
                entity.get投票状況Entity().setKofuYMD(交付日);
            }
        }
        return new TohyoshaListSenkyoResult(entity);
    }

    /**
     * 選挙番号に合致するリストを返します。
     *
     * @param 投票者一覧表選挙期日前帳票検索条件 NippoMybatisParameter
     * @return Tohyoku
     */
    @Transaction
    public TohyoshaListSenkyoResult get投票者一覧選挙期日前表セット(NippoMybatisParameter 投票者一覧表選挙期日前帳票検索条件) {
        INippoMapper 日報mapper = mapperProvider.create(INippoMapper.class);
        List<NippoPSMPrintEntity> 投票者一覧表 = 日報mapper.select投票者一覧選挙期日前表(投票者一覧表選挙期日前帳票検索条件);
        if (null == 投票者一覧表 || 投票者一覧表.isEmpty()) {
            return new TohyoshaListSenkyoResult();
        }
        FlexibleDate 現在日時 = FlexibleDate.getNowDate();
        NippoPSMPrintEntity entity = 投票者一覧表.get(0);
        int temp = Integer.parseInt(現在日時.toString());
        for (int i = 0; i < 投票者一覧表.size(); i++) {
            FlexibleDate 受理日 = 投票者一覧表.get(i).get投票状況Entity().getJuriYMD();
            if (null != 受理日 && !受理日.isEmpty() && (temp > Math.abs(現在日時.getBetweenDays(受理日)))) {
                temp = Math.abs(現在日時.getBetweenDays(受理日));
                entity = 投票者一覧表.get(i);
            }
        }
        FlexibleDate 交付日 = entity.get投票状況Entity().getKofuYMD();
        temp = (交付日 == null || 交付日.isEmpty()) ? Integer.parseInt(現在日時.toString()) : Math.abs(現在日時.getBetweenDays(交付日));
        for (int i = 0; i < 投票者一覧表.size(); i++) {
            交付日 = 投票者一覧表.get(i).get投票状況Entity().getKofuYMD();
            if (交付日 != null && !交付日.isEmpty() && (temp > Math.abs(現在日時.getBetweenDays(交付日)))) {
                temp = Math.abs(現在日時.getBetweenDays(交付日));
                entity.get投票状況Entity().setKofuYMD(交付日);
            }
        }
        return new TohyoshaListSenkyoResult(entity);
    }

    /**
     * 選挙番号に合致するリストを返します。
     *
     * @param 投票者一覧表選挙不在者帳票検索条件 NippoMybatisParameter
     * @return Tohyoku
     */
    @Transaction
    public TohyoshaListSenkyoResult get投票者一覧選挙不在者表セット(NippoMybatisParameter 投票者一覧表選挙不在者帳票検索条件) {
        INippoMapper 日報mapper = mapperProvider.create(INippoMapper.class);
        List<NippoPSMPrintEntity> 投票者一覧表 = 日報mapper.select投票者一覧選挙不在者表(投票者一覧表選挙不在者帳票検索条件);
        if (null == 投票者一覧表 || 投票者一覧表.isEmpty()) {
            return new TohyoshaListSenkyoResult();
        }
        FlexibleDate 現在日時 = FlexibleDate.getNowDate();
        NippoPSMPrintEntity entity = 投票者一覧表.get(0);
        int temp = Integer.parseInt(現在日時.toString());
        for (int i = 0; i < 投票者一覧表.size(); i++) {
            FlexibleDate 受理日 = 投票者一覧表.get(i).get投票状況Entity().getJuriYMD();
            if (null != 受理日 && !受理日.isEmpty() && (temp > Math.abs(現在日時.getBetweenDays(受理日)))) {
                temp = Math.abs(現在日時.getBetweenDays(受理日));
                entity = 投票者一覧表.get(i);
            }
        }
        FlexibleDate 交付日 = entity.get投票状況Entity().getKofuYMD();
        temp = (交付日 == null || 交付日.isEmpty()) ? Integer.parseInt(現在日時.toString()) : Math.abs(現在日時.getBetweenDays(交付日));
        for (int i = 0; i < 投票者一覧表.size(); i++) {
            交付日 = 投票者一覧表.get(i).get投票状況Entity().getKofuYMD();
            if (交付日 != null && !交付日.isEmpty() && (temp > Math.abs(現在日時.getBetweenDays(交付日)))) {
                temp = Math.abs(現在日時.getBetweenDays(交付日));
                entity.get投票状況Entity().setKofuYMD(交付日);
            }
        }
        return new TohyoshaListSenkyoResult(entity);
    }

}
