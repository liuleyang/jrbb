/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.shikakushokai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.SenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.shikakushokai.FuzaishaTohyoShikakuResult;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.shikakushokai.FuzaishaTohyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.shikakushokai.SenkyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shikakushokai.FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT122ZaigaiSenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.basic.IAfT113SenkyoShikakuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.shikakushokai.IShikakuShokaiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住所条件選択の取得
 *
 * @reamsid_L AF-0190-010 guancy
 */
public class ShikakuShokaiManager {

    private final AfT122ZaigaiSenkyoShikakuDac 在外選挙資格dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShikakuShokaiManager() {
        this.在外選挙資格dac = InstanceProvider.create(AfT122ZaigaiSenkyoShikakuDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT509KumiaiDac}
     */
//    public ShikakuShokaiManager(AfT509KumiaiDac dac) {
//        this.dac = dac;
//    }
    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuShokaiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShikakuShokaiManager}のインスタンス
     */
    public static ShikakuShokaiManager createInstance() {
        return InstanceProvider.create(ShikakuShokaiManager.class);
    }

    /**
     * 選挙種類と識別コードに合致する選挙資格情報を返します。
     *
     * @param 選挙種類 SennkyoSikakuShurui
     * @param 識別コード ShikibetsuCode
     *
     * @return List<SenkyoShikakuResult> nullが返る可能性があります。
     */
    @Transaction
    public List<SenkyoShikakuResult> get選挙資格情報(SennkyoSikakuShurui 選挙種類, ShikibetsuCode 識別コード) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        IAfT113SenkyoShikakuMapper 選挙資格mapper = mapperProvider.create(IAfT113SenkyoShikakuMapper.class);
        List<AfT113SenkyoShikakuEntity> 選挙資格 = 選挙資格mapper.select選挙資格リストByKey(
                SenkyoShikakuMapperParameter.createSelectListParam(選挙種類.value(), 識別コード));
        if (null == 選挙資格 || 選挙資格.isEmpty()) {
            return null;
        }
        List<SenkyoShikakuResult> senkyoShikakuResultList = new ArrayList<>();
        for (int i = 0; i < 選挙資格.size(); i++) {
            senkyoShikakuResultList.add(new SenkyoShikakuResult(選挙資格.get(i)));
        }
        return senkyoShikakuResultList;
    }

    /**
     * 識別コードに合致する在外選挙資格情報を返します。
     *
     * @param 識別コード ShikibetsuCode
     *
     * @return List<ZaigaiSenkyoShikakuResult> nullが返る可能性があります。
     */
    @Transaction
    public List<ZaigaiSenkyoShikakuResult> get在外選挙資格情報(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        List<AfT122ZaigaiSenkyoShikakuEntity> 在外選挙資格情報 = 在外選挙資格dac.select(識別コード);

        if (在外選挙資格情報 == null || 在外選挙資格情報.isEmpty()) {
            return null;
        }
        Collections.reverse(在外選挙資格情報);
        List<ZaigaiSenkyoShikakuResult> senkyoShikakuResultList = new ArrayList<>();
        for (int i = 0; i < 在外選挙資格情報.size(); i++) {
            senkyoShikakuResultList.add(new ZaigaiSenkyoShikakuResult(在外選挙資格情報.get(i)));
        }
        return senkyoShikakuResultList;
    }

    /**
     * 識別コードに合致する在者投票資格情報を返します。
     *
     * @param 識別コード ShikibetsuCode
     *
     * @return FuzaishaTohyoShikakuResult nullが返る可能性があります。
     */
    @Transaction
    public List<FuzaishaTohyoShikakuResult> get不在者投票資格情報(ShikibetsuCode 識別コード) {
        IShikakuShokaiMapper 不在者投票資格mapper = mapperProvider.create(IShikakuShokaiMapper.class);
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        List<FuzaishaTohyoShikakuEntity> 不在者投票資格 = 不在者投票資格mapper
                .select不在者投票資格リストByKey1(FuzaishaTohyoShikakuMapperParameter.createSelectListParam(識別コード));
        if (不在者投票資格 == null || 不在者投票資格.isEmpty()) {
            return null;
        }
        List<FuzaishaTohyoShikakuResult> fuzaishaTohyoShikakuResultList = new ArrayList<>();
        for (int i = 0; i < 不在者投票資格.size(); i++) {
            fuzaishaTohyoShikakuResultList.add(new FuzaishaTohyoShikakuResult(
                    不在者投票資格.get(i).get不在者投票資格Entity(), 不在者投票資格.get(i).get郵便投票資格付随情報Entity()));
        }
        return fuzaishaTohyoShikakuResultList;
    }

}
