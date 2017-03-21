/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.meibosakuseikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT501TohyokuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT509KumiaiDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.ISenkyojiKaikuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 海区漁業調整委員会委員選挙人名簿作成バッチパラメータクラスです。
 *
 * @reamsid_L AF-0460-020 wanghj
 */
public class MeiboSakuseiKaikuFinder {

    private final AfaMapperProvider mapperProvider;
    private final AfT111SenkyoDac afT111SenkyoDac;
    private final AfT501TohyokuDac afT501TohyokuDac;
    private final AfT509KumiaiDac afT509KumiaiDac;

    /**
     * コンストラクタです。
     */
    public MeiboSakuseiKaikuFinder() {

        afT111SenkyoDac = InstanceProvider.create(AfT111SenkyoDac.class);
        afT509KumiaiDac = InstanceProvider.create(AfT509KumiaiDac.class);
        afT501TohyokuDac = InstanceProvider.create(AfT501TohyokuDac.class);
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static MeiboSakuseiKaikuFinder createInstance() {
        return InstanceProvider.create(MeiboSakuseiKaikuFinder.class);
    }

    /**
     * 抄本番号で取得した選挙.選挙番号です。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT111SenkyoEntity
     */
    public List<AfT111SenkyoEntity> getBy抄本番号(ShohonNo 抄本番号) {
        return afT111SenkyoDac.selectBy抄本番号(抄本番号);
    }

    /**
     * 組合マスタのデータを取得する。
     *
     * @return AfT509KumiaiEntity　List<AfT509KumiaiEntity>
     */
    public List<AfT509KumiaiEntity> get組合マスタデータ() {
        return afT509KumiaiDac.select();
    }

    /**
     * 投票区のデータを取得する。
     *
     * @return AfT509KumiaiEntity　List<AfT509KumiaiEntity>
     */
    public List<AfT501TohyokuEntity> get投票区データ() {
        return afT501TohyokuDac.select();
    }

    /**
     * 投票区のデータを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 選挙人名簿　AfT112SenkyoninMeiboEntity
     */
    public List<SenkyojiKaikuEntity> get選挙人名簿の識別コードBy抄本番号(SenkyojiKaikuMybatisParameter parameter) {
        ISenkyojiKaikuMapper mapper = mapperProvider.create(ISenkyojiKaikuMapper.class);
        return mapper.select選挙人名簿の識別コードBy抄本番号(parameter);
    }

}
