/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisTokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT113SenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 入場券発行（一括）のファインダーです。
 *
 * @reamsid_L AF-0160-020 guyq
 *
 */
public class NyujokenIkkatsuFinder {

    private final AfT100ShohonDac afT100ShohonDac;
    private final AfT111SenkyoDac afT111SenkyoDac;
    private final AfT113SenkyoShikakuDac afT113SenkyoShikakuDac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public NyujokenIkkatsuFinder() {
        afT100ShohonDac = InstanceProvider.create(AfT100ShohonDac.class);
        afT111SenkyoDac = InstanceProvider.create(AfT111SenkyoDac.class);
        afT113SenkyoShikakuDac = InstanceProvider.create(AfT113SenkyoShikakuDac.class);
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static NyujokenIkkatsuFinder createInstance() {
        return InstanceProvider.create(NyujokenIkkatsuFinder.class);
    }

    /**
     * 抄本番号により、抄本選挙情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return 抄本 検索結果 AfT100ShohonEntity
     */
    @Transaction
    public AfT100ShohonEntity get抄本情報(ShohonNo 抄本番号) {
        return afT100ShohonDac.select(抄本番号);
    }

    /**
     * 選挙種類、識別コードにより、選挙資格情報を取得します。
     *
     * @param 選挙種類 RString
     * @param 識別コード ShikibetsuCode
     * @return 抄本 検索結果 AfT100ShohonEntity
     */
    @Transaction
    public AfT113SenkyoShikakuEntity get選挙資格情報(RString 選挙種類, ShikibetsuCode 識別コード) {
        return afT113SenkyoShikakuDac.select(new Code(選挙種類), 識別コード);
    }

    /**
     * 投票区一覧を取得します。
     *
     * @param 選挙種類 RString
     * @return List<NyujokenIkkatsuMybatisTokyo>
     */
    public List<NyujokenIkkatsuMybatisTokyo> select投票区一覧(RString 選挙種類) {
        INyujokenIkkatsuMapper mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
        return mapper.select投票区一覧(選挙種類);
    }

    /**
     * 投票区一覧明細を取得します。
     *
     * @return List<NyujokenIkkatsuMybatisTokyo>
     */
    public List<NyujokenIkkatsuMybatisTokyo> select投票区一覧明細() {
        INyujokenIkkatsuMapper mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
        return mapper.select投票区一覧明細();
    }

    /**
     * 転出期限年月日MINを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return AfT111SenkyoEntity
     */
    public AfT111SenkyoEntity select転出期限年月日MIN(ShohonNo 抄本番号) {
        return afT111SenkyoDac.select転出期限年月日MIN(抄本番号).get(0);
    }
}
