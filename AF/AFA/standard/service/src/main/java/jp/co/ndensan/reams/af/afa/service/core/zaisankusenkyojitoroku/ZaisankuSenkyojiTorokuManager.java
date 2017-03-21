/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.zaisankusenkyojitoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaisankuSenkyojiTorokuResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.zaisankusenkyojitoroku.ZaisankuSenkyojiTorokuParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.ZaisankuSenkyojiTorokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT142TohyokuConditionDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT144JushoConditionDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT501TohyokuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zaisankusenkyojitoroku.IZaisankuSenkyojiTorokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.AssociationKey;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.choiki.ChoikiItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.jusho.choiki.ChoikiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.jusho.choiki.IChoikiManager;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 財産区議会議員選挙時登録のDB操作クラスです。
 *
 * @reamsid_L AF-0600-010 lis
 */
public class ZaisankuSenkyojiTorokuManager {

    private final AfT501TohyokuDac aft501Dac;
    private final AfT142TohyokuConditionDac aft142Dac;
    private final AfT144JushoConditionDac aft144Dac;
    private final IChoikiManager 町域Manager;
    private final AfaMapperProvider mapperProvider;
    private final Association association;

    /**
     * コンストラクタです。
     */
    public ZaisankuSenkyojiTorokuManager() {
        aft501Dac = InstanceProvider.create(AfT501TohyokuDac.class);
        aft142Dac = InstanceProvider.create(AfT142TohyokuConditionDac.class);
        aft144Dac = InstanceProvider.create(AfT144JushoConditionDac.class);
        this.町域Manager = ChoikiManagerFactory.createInstance();
        this.association = AssociationFinderFactory.createInstance().getAssociation();
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ZaisankuSenkyojiTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ZaisankuSenkyojiTorokuManager}のインスタンス
     */
    public static ZaisankuSenkyojiTorokuManager createInstance() {
        return InstanceProvider.create(ZaisankuSenkyojiTorokuManager.class);
    }

    /**
     * 選挙種類で投票区情報を取得します。
     *
     * @param 選挙種類 Code
     * @return 外選挙人名簿リスト
     */
    @Transaction
    public List<ZaisankuSenkyojiTorokuResult> get投票区情報By選挙種類(Code 選挙種類) {

        List<AfT501TohyokuEntity> entityList = aft501Dac.select(選挙種類);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<ZaisankuSenkyojiTorokuResult> resultList = new ArrayList<>();
        for (AfT501TohyokuEntity entity : entityList) {
            ZaisankuSenkyojiTorokuResult result = new ZaisankuSenkyojiTorokuResult();
            result.setAft501Entity(entity);
            resultList.add(result);
        }
        return resultList;
    }

    /**
     * 住所情報を返します。
     *
     * @return List<ChoikiItem> 住所情報。
     */
    @Transaction
    public List<ChoikiItem> get住所情報() {

        return 町域Manager.get町域一覧by地方公共団体(
                new AssociationKey(association.get地方公共団体コード(), association.get連番()), FlexibleDate.getNowDate());
    }

    /**
     * 選挙情報を返します。
     *
     * @param 抄本番号 ShohonNo
     * @return ZaisankuSenkyojiTorokuResult 住所情報。
     */
    @Transaction
    public ZaisankuSenkyojiTorokuResult get選挙情報(ShohonNo 抄本番号) {

        ZaisankuSenkyojiTorokuResult result = new ZaisankuSenkyojiTorokuResult();
        IZaisankuSenkyojiTorokuMapper mapper = mapperProvider.create(IZaisankuSenkyojiTorokuMapper.class);
        ZaisankuSenkyojiTorokuEntity entity = mapper.select選挙情報(new ZaisankuSenkyojiTorokuParameter(抄本番号));

        if (null == entity) {
            return null;
        }

        result.setAft100Entity(entity.getAft100Entity());
        result.setAft111Entity(entity.getAft111Entity());
        result.setAft141Entity(entity.getAft141Entity());

        return result;
    }

    /**
     * 投票区コード情報を返します。
     *
     * @param 抄本番号 ShohonNo
     * @return 投票区コード List<RString>
     */
    @Transaction
    public List<RString> get投票区コード情報(ShohonNo 抄本番号) {

        List<AfT142TohyokuConditionEntity> entityList = aft142Dac.selectListByShohonNo(抄本番号);
        List<RString> tohyokuCdList = new ArrayList();
        if (null != entityList && !entityList.isEmpty()) {
            for (AfT142TohyokuConditionEntity entity : entityList) {
                tohyokuCdList.add(entity.getTohyokuCode());
            }
        }

        return tohyokuCdList;
    }

    /**
     * 町域コード情報を返します。
     *
     * @param 抄本番号 ShohonNo
     * @return 町域コード List<ChoikiCode>
     */
    @Transaction
    public List<ChoikiCode> get町域コード情報(ShohonNo 抄本番号) {

        List<AfT144JushoConditionEntity> entityList = aft144Dac.selectListByShohonNo(抄本番号);
        List<ChoikiCode> codeList = new ArrayList();
        if (null != entityList && !entityList.isEmpty()) {
            for (AfT144JushoConditionEntity entity : entityList) {
                codeList.add(entity.getChoikiCode());
            }
        }

        return codeList;
    }

}
