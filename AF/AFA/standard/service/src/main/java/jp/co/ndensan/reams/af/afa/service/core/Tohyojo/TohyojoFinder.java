/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tohyojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyojoForCtrl;
import jp.co.ndensan.reams.af.afa.business.core.tohyojyo.Tohyojo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyojo.TohyojoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT502TohyojoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.tohyojo.ITohyojoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票所を管理するクラスです。
 *
 * @reamsid_L AF-0710-010 liuyj
 */
public class TohyojoFinder {

    private final AfT502TohyojoDac dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TohyojoFinder() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        dac = InstanceProvider.create(AfT502TohyojoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link AfaMapperProvider}
     * @param dac {@link AfT502TohyojoDac}
     */
    public TohyojoFinder(AfaMapperProvider mapperProvider, AfT502TohyojoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyojoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyojoFinder}のインスタンス
     */
    public static TohyojoFinder createInstance() {
        return InstanceProvider.create(TohyojoFinder.class);
    }

    /**
     * 投票所コードに合致するの投票所を返します。
     *
     * @param 投票所コード RString
     * @return Shisetsu
     */
    @Transaction
    public Tohyojo get投票所By投票所コード(RString 投票所コード) {

        AfT502TohyojoEntity entity = dac.select(投票所コード);
        if (null == entity) {
            return null;
        }

        return new Tohyojo(entity);
    }

    /**
     * 投票所コードに合致するの投票所を返します。
     *
     * @param senkyoShurui Code
     * @param 投票区コード RString
     * @return Shisetsu
     */
    @Transaction
    public Tohyojo get投票所By投票区コード(Code senkyoShurui, RString 投票区コード) {

        ITohyojoMapper mapper = mapperProvider.create(ITohyojoMapper.class);

        AfT502TohyojoEntity entity = mapper.selectTohyojo(new TohyojoMybatisParameter(senkyoShurui, 投票区コード));
        if (null == entity) {
            return null;
        }

        return new Tohyojo(entity);
    }

    /**
     * 投票所コードに合致する投票所リストを返します。
     *
     * @return List<Tohyojo>
     */
    @Transaction
    public List<Tohyojo> get投票所全件() {

        List<AfT502TohyojoEntity> entitys = dac.select();
        if (entitys == null || entitys.isEmpty()) {
            return null;
        }
        List<Tohyojo> tohyojoList = new ArrayList<>();
        for (AfT502TohyojoEntity entity : entitys) {
            entity.initializeMd5();
            tohyojoList.add(new Tohyojo(entity));
        }
        return tohyojoList;
    }

    /**
     * 投票所コードに合致するの投票所を返します。
     *
     * @param 投票所コード RString
     * @return AfT502TohyojoEntity
     */
    @Transaction
    public AfT502TohyojoEntity get投票所保守By投票所コード(RString 投票所コード) {
        return dac.select(投票所コード);
    }

    /**
     * 投票所コードに合致する投票所リストを返します。
     *
     * @return List<Tohyojo>
     */
    @Transaction
    public List<TohyojoForCtrl> get投票所保守全件() {
        List<TohyojoForCtrl> tohyojoForCtrlList = new ArrayList();
        List<AfT502TohyojoEntity> entitys = dac.select();
        if (entitys == null) {
            return Collections.EMPTY_LIST;
        }
        for (AfT502TohyojoEntity entity : entitys) {
            tohyojoForCtrlList.add(new TohyojoForCtrl(entity));
        }
        return tohyojoForCtrlList;
    }

    /**
     * 投票所情報を追加します。
     *
     * @param 投票所 Tohyojo
     * @return int
     */
    @Transaction
    public int insert投票所保守情報(TohyojoForCtrl 投票所) {
        return dac.insertOrUpdate(投票所.getEntity());
    }

    /**
     * 投票所情報を削除します。
     *
     * @param 投票所 TohyojoForCtrl
     * @return int
     */
    @Transaction
    public boolean deltete投票所保守情報(TohyojoForCtrl 投票所) {
        AfT502TohyojoEntity afT502Entity = 投票所.getEntity();
        int deleteNo = dac.deletePhysical(afT502Entity);
        return deleteNo > 0;
    }
}
