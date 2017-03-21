/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.saibanintorikomi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.saibanintorikomi.SaibaninMeiboSakuseiResult;
import jp.co.ndensan.reams.af.afa.business.core.saibanintorikomi.SaibaninTorikomiCsvResult;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.saibanintorikomi.SaibaninTorikomiEnum;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.saibanintorikomi.SaibaninTorikomiMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT301SaibaninMeiboSakuseiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT302SaibaninYoteishaEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT301SaibaninMeiboSakuseiDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT302SaibaninYoteishaDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.saibanintorikomi.ISaibaninTorikomiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 裁判員候補者予定者取込
 *
 * @reamsid_L AF-0310-010 guancy
 */
public class SaibaninTorikomiManager {

    private final AfT301SaibaninMeiboSakuseiDac 裁判員名簿作成情報dac;
    private final AfT302SaibaninYoteishaDac 裁判員候補者予定者名簿dac;
    private final AfaMapperProvider mapperProvider;
    private final int 卯月 = SaibaninTorikomiEnum.FOUR.getInteger();
    private final int 師走 = SaibaninTorikomiEnum.TWELVE.getInteger();
    private final ShikibetsuTaishoSearchKeyBuilder key;

    /**
     * コンストラクタです。
     */
    public SaibaninTorikomiManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.裁判員名簿作成情報dac = InstanceProvider.create(AfT301SaibaninMeiboSakuseiDac.class);
        this.裁判員候補者予定者名簿dac = InstanceProvider.create(AfT302SaibaninYoteishaDac.class);
        key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先));
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SaibaninTorikomiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SaibaninTorikomiManager}のインスタンス
     */
    public static SaibaninTorikomiManager createInstance() {
        return InstanceProvider.create(SaibaninTorikomiManager.class);
    }

    /**
     * 裁判員候補者予定者取込テーブルをセットします。
     *
     * @param results List<SaibaninTorikomiCsvResult>
     * @return List<AfT302SaibaninYoteishaEntity>
     */
    @Transaction
    public List<AfT302SaibaninYoteishaEntity> get裁判員候補者予定者取込データ(List<SaibaninTorikomiCsvResult> results) {
        裁判員候補者予定者取込テーブル作成();
        for (int i = 0; i < results.size(); i++) {
            裁判員候補者予定者取込テーブルセット(results.get(i));

        }
        SaibaninTorikomiMapperParameter parameter = new SaibaninTorikomiMapperParameter(key.getPSM検索キー());
        ISaibaninTorikomiMapper mapper = mapperProvider.create(ISaibaninTorikomiMapper.class);
        return mapper.select裁判員候補者予定者情報(parameter);

    }

    /**
     * 裁判員名簿作成情報を返します。
     *
     * @return SaibaninMeiboSakuseiResult nullが返る可能性があります。
     */
    @Transaction
    public SaibaninMeiboSakuseiResult get裁判員名簿作成情報() {

        AfT301SaibaninMeiboSakuseiEntity entity = 裁判員名簿作成情報dac.select(getNendo());
        if (null == entity) {
            return null;
        }
        return new SaibaninMeiboSakuseiResult(entity);
    }

    /**
     * 抄本番号に合致する行政区抽出条件を返します。
     *
     * @param list List<AfT302SaibaninYoteishaEntity>
     * @param kubun Code
     */
    @Transaction
    public void 裁判員候補者予定者名簿登録(List<AfT302SaibaninYoteishaEntity> list, Code kubun) {
        RYear year = getNendo();
        List<AfT302SaibaninYoteishaEntity> delList = 裁判員候補者予定者名簿dac.select(year);
        for (AfT302SaibaninYoteishaEntity delEntity : delList) {
            裁判員候補者予定者名簿dac.deletePhysical(delEntity);
        }
        int index = 1;
        List<PersonalData> datas = new ArrayList<>();
        for (AfT302SaibaninYoteishaEntity entity : list) {
            entity.setNendo(year);
            entity.setSenkanRenban(index);
            entity.setSaibaninShinsainKubun(kubun);
            裁判員候補者予定者名簿dac.save(entity);
            datas.add(PersonalData.of(entity.getShikibetsuCode()));
            index++;
        }
        AccessLogger.log(AccessLogType.更新, datas);
        ISaibaninTorikomiMapper mapper = mapperProvider.create(ISaibaninTorikomiMapper.class);
        mapper.dropSaibaninTorikomiTemp();
    }

    /**
     * 抄本番号に合致する行政区抽出条件を返します。
     *
     * @param result SaibaninMeiboSakuseiResult
     * @param list List<AfT302SaibaninYoteishaEntity>
     * @param kubun Code
     */
    @Transaction
    public void 裁判員名簿作成情報テーブル更新(SaibaninMeiboSakuseiResult result, List<AfT302SaibaninYoteishaEntity> list, Code kubun) {
        AfT301SaibaninMeiboSakuseiEntity afT301Entity = result.toEntity();
        RYear year = getNendo();
        afT301Entity.setNendo(year);
        afT301Entity.setMeiboTorikomiZumiFlag(true);
        裁判員名簿作成情報dac.insertOrUpdate(afT301Entity);

        int index = 1;
        for (AfT302SaibaninYoteishaEntity entity : list) {
            entity.setNendo(year);
            entity.setSenkanRenban(index);
            entity.setSaibaninShinsainKubun(kubun);
            裁判員候補者予定者名簿dac.save(entity);
            index++;
        }

        ISaibaninTorikomiMapper mapper = mapperProvider.create(ISaibaninTorikomiMapper.class);
        mapper.dropSaibaninTorikomiTemp();
    }

    /**
     * 裁判員候補者予定者取込テーブル作成します。
     *
     */
    private void 裁判員候補者予定者取込テーブル作成() {
        ISaibaninTorikomiMapper mapper = mapperProvider.create(ISaibaninTorikomiMapper.class);
        mapper.createSaibaninTorikomiTemp();
    }

    /**
     * 裁判員候補者予定者取込テーブルをセットします。
     *
     * @param result SaibaninTorikomiCsvResult
     */
    private void 裁判員候補者予定者取込テーブルセット(SaibaninTorikomiCsvResult result) {
        ISaibaninTorikomiMapper mapper = mapperProvider.create(ISaibaninTorikomiMapper.class);
        SaibaninTorikomiMapperParameter parameter = new SaibaninTorikomiMapperParameter(key.getPSM検索キー());
        parameter.set住所(result.get住所());
        parameter.set本籍(result.get本籍());
        parameter.set氏名(result.get氏名());
        parameter.set生年月日(result.get生年月日());
        parameter.set郵便番号(result.get郵便番号());
        parameter.set識別コード(result.get識別コード());
        mapper.insertSaibaninTorikomiTemp(parameter);
    }

    private RYear getNendo() {
        RDate date = RDate.getNowDate();
        RYear year = date.getNendo();
        if (date.getMonthValue() >= 卯月 && date.getMonthValue() <= 師走) {
            year = year.plusYear(1);
        }
        return year;
    }

}
