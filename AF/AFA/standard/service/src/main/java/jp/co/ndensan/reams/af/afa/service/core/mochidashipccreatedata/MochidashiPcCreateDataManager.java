/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.mochidashipccreatedata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.mochidashipccreatedata.MochidashiPcCreateDataMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata.AFABTE801SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT252MochidashiPcJotaiKanriEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT252MochidashiPcJotaiKanriDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mochidashipccreatedata.IMochidashiPcCreateDataMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 持出端末用データ作成Manager
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class MochidashiPcCreateDataManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT252MochidashiPcJotaiKanriDac 持出端末状態管理dac;

    /**
     * コンストラクタです。
     */
    public MochidashiPcCreateDataManager() {
        this.持出端末状態管理dac = InstanceProvider.create(AfT252MochidashiPcJotaiKanriDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link MochidashiPcCreateDataManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link MochidashiPcCreateDataManager}のインスタンス
     */
    public static MochidashiPcCreateDataManager createInstance() {
        return InstanceProvider.create(MochidashiPcCreateDataManager.class);
    }

    /**
     * MAX名簿基準年月日を返します。
     *
     * @param 抄本番号 ShohonNo
     * @return List<TohyokuURCsvResult>
     */
    @Transaction
    public RString getMAX名簿基準年月日(ShohonNo 抄本番号) {
        IMochidashiPcCreateDataMapper mapper = mapperProvider.create(IMochidashiPcCreateDataMapper.class);
        RString str = mapper.selectMAX名簿基準年月日(抄本番号);
        if (null == str) {
            str = RString.EMPTY;
        }
        return str;
    }

    /**
     * 抄本番号を返します。
     *
     * @param 投票日 FlexibleDate
     * @return RString
     */
    @Transaction
    public RString select抄本番号By投票日(FlexibleDate 投票日) {
        IMochidashiPcCreateDataMapper mapper = mapperProvider.create(IMochidashiPcCreateDataMapper.class);
        List<RString> list = mapper.select抄本番号By投票日(投票日);
        RString shohons = RString.EMPTY;
        if (null == list || list.isEmpty()) {
            return shohons;
        }
        for (int i = 0; i < list.size(); i++) {
            shohons = shohons.concat(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString()).concat(list.get(i));
        }
        return shohons;
    }

    /**
     * 持出端末状態管理を更新します。
     *
     * @param parameter AFABTE801SelectProcessParameter
     * @param shikibeitsuCode RString
     */
    @Transaction
    public void update持出端末状態管理(AFABTE801SelectProcessParameter parameter, RString shikibeitsuCode) {
        YMDHMS システム日時 = YMDHMS.now();
        IMochidashiPcCreateDataMapper mapper = mapperProvider.create(IMochidashiPcCreateDataMapper.class);
        List<RString> list = mapper.select抄本番号By投票日(parameter.get受理日());
        List<ShohonNo> shohons = new ArrayList<>();
        if (null == list || list.isEmpty()) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            shohons.add(new ShohonNo(list.get(i)));
        }
        List<AfT252MochidashiPcJotaiKanriEntity> entitys = 持出端末状態管理dac.selectBy抄本番号List(shohons);
        if (null != entitys && !entitys.isEmpty()) {
            for (int i = 0; i < entitys.size(); i++) {
                持出端末状態管理dac.deletePhysical(entitys.get(i));
            }
        }
        MochidashiPcCreateDataMybatisParameter mybatisParam = parameter.toMybatisParameter();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        mybatisParam.set地方公共団体コード(association.get地方公共団体コード().value());
        mybatisParam.set地方公共団体コード連番(association.get連番());
        AfT252MochidashiPcJotaiKanriEntity entity;
        for (int i = 0; i < shohons.size(); i++) {
            mybatisParam.set抄本番号(shohons.get(i));
            List<RString> tohyokuCode = mapper.select抄本投票区コード(mybatisParam);
            if (null != tohyokuCode && !tohyokuCode.isEmpty()) {
                for (int j = 0; j < tohyokuCode.size(); j++) {
                    entity = new AfT252MochidashiPcJotaiKanriEntity();
                    entity.setShohonNo(shohons.get(i));
                    entity.setTohyokuCode(tohyokuCode.get(j));
                    entity.setDataCreateKubun(MochidashiPcCreateDataEnum.ONE.getCode());
                    entity.setDataCreateYMD(システム日時);
                    entity.setSystemSendKubun(MochidashiPcCreateDataEnum.ZERO.getCode());
                    entity.setSystemSendYMD(null);
                    entity.setDataSendKubun(MochidashiPcCreateDataEnum.ZERO.getCode());
                    entity.setDataSendYMD(null);
                    entity.setDataImportKubun(MochidashiPcCreateDataEnum.ZERO.getCode());
                    entity.setDataImportYMD(null);
                    持出端末状態管理dac.save(entity);
                }
            }
        }
        shikibeitsuCode = shikibeitsuCode.substring(MochidashiPcCreateDataEnum.ZERO.getInteger(),
                shikibeitsuCode.length() - MochidashiPcCreateDataEnum.ONE.getInteger());
        List<RString> codes = shikibeitsuCode.split(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString().toString());
        Set<RString> codeSet = new HashSet<>();
        for (int i = 0; i < codes.size(); i++) {
            codeSet.add(codes.get(i));
        }
        for (RString rString : codeSet) {
            AccessLogger.log(AccessLogType.更新, PersonalData.of(new ShikibetsuCode(rString)));
        }
    }
}
