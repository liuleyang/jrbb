/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.seikyushatoroku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.seikyushatoroku.SeikyushaTorokuJoho;
import jp.co.ndensan.reams.af.afa.business.seikyushatoroku.SeikyuDaihyoshaGamenData;
import jp.co.ndensan.reams.af.afa.business.seikyushatoroku.SeikyushaTorokuGamenData;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.seikyushatoroku.SeikyushaTorokuParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT402SeikyuDaihyoshaEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SeikyushaTorokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT401ChokusetsuSeikyuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT402SeikyuDaihyoshaDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.seikyushatoroku.ISeikyushaTorokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 請求代表者証明書交付
 *
 * @reamsid_L AF-0140-010 wangh
 */
public class SeikyushaTorokuManager {

    private final AfT401ChokusetsuSeikyuDac aft401Dac;
    private final AfT402SeikyuDaihyoshaDac aft402Dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SeikyushaTorokuManager() {
        this.aft401Dac = InstanceProvider.create(AfT401ChokusetsuSeikyuDac.class);
        this.aft402Dac = InstanceProvider.create(AfT402SeikyuDaihyoshaDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeikyushaTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SeikyushaTorokuManager}のインスタンス
     */
    public static SeikyushaTorokuManager createInstance() {
        return InstanceProvider.create(SeikyushaTorokuManager.class);
    }

    /**
     * 指定されたキーに該当する、直接請求一覧データを取得します。
     *
     * @return 請求代表者一覧データ List<SeikyushaTorokuGamenData>
     */
    @Transaction
    public List<SeikyushaTorokuGamenData> get直接請求一覧データ() {

        List<SeikyushaTorokuGamenData> 請求代表者List = new ArrayList();
        List<AfT401ChokusetsuSeikyuEntity> 検索結果List = aft401Dac.selectAll();

        for (AfT401ChokusetsuSeikyuEntity 検索結果 : 検索結果List) {
            SeikyushaTorokuGamenData 請求代表者 = new SeikyushaTorokuGamenData(検索結果);
            請求代表者List.add(請求代表者);
        }

        return 請求代表者List;
    }

    /**
     * 指定されたキーに該当する、直接請求データを取得します。
     *
     * @param 直接請求番号 int
     * @return 直接請求データ SeikyushaTorokuGamenData
     */
    @Transaction
    public SeikyushaTorokuGamenData get直接請求データ(int 直接請求番号) {

        AfT401ChokusetsuSeikyuEntity 検索結果 = aft401Dac.select(直接請求番号);

        return new SeikyushaTorokuGamenData(検索結果);
    }

    /**
     * SearchSimpleJuminDialog画面から請求代表者一覧を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return List<SeikyushaTorokuJohoShikaku>
     */
    @Transaction
    public List<SeikyushaTorokuJoho> get検索結果一覧(ShikibetsuCode 識別コード) {

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey psmKey = build.build();
        SeikyushaTorokuParameter 請求代表者検索条件 = new SeikyushaTorokuParameter(psmKey);

        requireNonNull(請求代表者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("請求代表者検索条件"));
        ISeikyushaTorokuMapper mapper = mapperProvider.create(ISeikyushaTorokuMapper.class);

        List<PersonalData> personalDataList = new ArrayList<>();
        List<SeikyushaTorokuEntity> entitys = mapper.select請求代表者一覧(請求代表者検索条件);
        List<SeikyushaTorokuJoho> list = new ArrayList<>();

        for (SeikyushaTorokuEntity entity : entitys) {
            list.add(new SeikyushaTorokuJoho(entity));
            personalDataList.add(PersonalData.of(entity.getShikibetsuTaisho().getShikibetsuCode()));
        }

        if (!personalDataList.isEmpty()) {
            AccessLogger.log(AccessLogType.照会, personalDataList);
        }

        return list;
    }

    /**
     * 「修正」or「削除」ボタンをクリックした請求代表者一覧を取得します。
     *
     * @param 直接請求番号 int
     * @return List<SeikyushaTorokuJohoShikaku>
     */
    @Transaction
    public List<SeikyushaTorokuJoho> get請求代表者一覧(int 直接請求番号) {

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey psmKey = build.build();
        SeikyushaTorokuParameter 請求代表者検索条件 = new SeikyushaTorokuParameter(psmKey);
        請求代表者検索条件.set直接請求番号(直接請求番号);

        requireNonNull(請求代表者検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("請求代表者検索条件"));
        ISeikyushaTorokuMapper mapper = mapperProvider.create(ISeikyushaTorokuMapper.class);

        List<PersonalData> personalDataList = new ArrayList<>();
        List<SeikyushaTorokuEntity> entitys = mapper.select直接請求代表者一覧(請求代表者検索条件);
        List<SeikyushaTorokuJoho> list = new ArrayList<>();

        for (SeikyushaTorokuEntity entity : entitys) {
            list.add(new SeikyushaTorokuJoho(entity));
            personalDataList.add(PersonalData.of(entity.getShikibetsuTaisho().getShikibetsuCode()));
        }

        if (!personalDataList.isEmpty()) {
            AccessLogger.log(AccessLogType.照会, personalDataList);
        }

        return list;
    }

    /**
     * 画面から入力したデータを直接請求と直接請求代表者に保存する。
     *
     * @param data SeikyushaTorokuGamenData
     * @return 更新状態
     */
    @Transaction
    public Boolean save直接請求データ(SeikyushaTorokuGamenData data) {

        AfT401ChokusetsuSeikyuEntity aft401Entity = data.getAft401Entity();
        List<AfT402SeikyuDaihyoshaEntity> aft402EntityList = new ArrayList();
        List<SeikyuDaihyoshaGamenData> seikyushaList = data.getSeikyushaList();

        if (null != seikyushaList && !seikyushaList.isEmpty()) {
            for (SeikyuDaihyoshaGamenData seikyusha : seikyushaList) {
                AfT402SeikyuDaihyoshaEntity aft402Entity = new AfT402SeikyuDaihyoshaEntity();
                aft402Entity.setSeikyuShikibetsuCode(seikyusha.getSeikyuShikibetsuCode());
                aft402Entity.setSeikyuNo(seikyusha.getSeikyuNo());
                aft402Entity.setState(seikyusha.getState());
                aft402EntityList.add(aft402Entity);
            }
        }

        if (EntityDataState.Modified.equals(aft401Entity.getState())) {
            List<AfT402SeikyuDaihyoshaEntity> aft402DbEntityList = aft402Dac.select(aft401Entity.getSeikyuNo());
            aft402Dac.deletePhysical(aft402DbEntityList);
        }

        boolean upDateFlg = 1 == aft401Dac.save(aft401Entity);
        if (upDateFlg) {
            upDateFlg = save請求代表者データ(aft402EntityList);
        }
        return upDateFlg;
    }

    /**
     * 画面から選択したデータを直接請求と直接請求代表者に削除する。
     *
     * @param data SeikyushaTorokuGamenData
     * @return 更新状態
     */
    @Transaction
    public Boolean delect直接請求データ(SeikyushaTorokuGamenData data) {

        Boolean delectFlg = false;
        AfT401ChokusetsuSeikyuEntity aft401Entity = data.getAft401Entity();

        if (1 == aft401Dac.delete(aft401Entity)) {
            List<AfT402SeikyuDaihyoshaEntity> aft402DbEntityList = aft402Dac.select(aft401Entity.getSeikyuNo());
            if (!aft402DbEntityList.isEmpty()) {
                aft402Dac.deletePhysical(aft402DbEntityList);
                delectFlg = true;
                setアクセスログ(delectFlg, aft402DbEntityList);
            }
        }

        return delectFlg;
    }

    private Boolean save請求代表者データ(List<AfT402SeikyuDaihyoshaEntity> aft402EntityList) {

        boolean updateFlg = false;
        if (!aft402EntityList.isEmpty()) {
            List<PersonalData> personalDataList = new ArrayList<>();

            for (AfT402SeikyuDaihyoshaEntity entity : aft402EntityList) {
                personalDataList.add(PersonalData.of(entity.getSeikyuShikibetsuCode()));
                updateFlg = 1 == aft402Dac.save(entity);
            }

            if (!personalDataList.isEmpty()) {
                AccessLogger.log(AccessLogType.更新, personalDataList);
            }
        }
        return updateFlg;
    }

    private void setアクセスログ(boolean delectFlg, List<AfT402SeikyuDaihyoshaEntity> aft402DbEntityList) {
        if (delectFlg) {

            List<PersonalData> personalDataList = new ArrayList<>();

            for (AfT402SeikyuDaihyoshaEntity entity : aft402DbEntityList) {
                personalDataList.add(PersonalData.of(entity.getSeikyuShikibetsuCode()));
            }

            if (!personalDataList.isEmpty()) {
                AccessLogger.log(AccessLogType.更新, personalDataList);
            }
        }
    }

}
