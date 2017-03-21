/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kaikutaishoshohonjoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.KaikuTaishoShohonJohoData;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.kaikutaishoshohonjoho.KaikuTaishoShohonJohoParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.KaikuTaishoShohonJohoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT131KaikuSenkyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.kaikutaishoshohonjoho.IKaikuTaishoShohonJohoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 海区対象抄本情報共有子DivのDB操作クラスです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
public class KaikuTaishoShohonJohoManager {

    private final AfT131KaikuSenkyoDac aft131Dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KaikuTaishoShohonJohoManager() {
        this.aft131Dac = InstanceProvider.create(AfT131KaikuSenkyoDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaikuTaishoShohonJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaikuTaishoShohonJohoManager}のインスタンス
     */
    public static KaikuTaishoShohonJohoManager createInstance() {
        return InstanceProvider.create(KaikuTaishoShohonJohoManager.class);
    }

    /**
     * 在外選挙資格を返します。
     *
     * @param 年度 RYear
     * @return ZaigaiSenkyoShikakuResult nullが返る可能性があります。
     */
    @Transaction
    public boolean get海区名簿更新日情報(RYear 年度) {
        List<AfT131KaikuSenkyoEntity> entityList = aft131Dac.select(年度);
        return null == entityList || entityList.isEmpty();
    }

    /**
     * 各種日付情報を返します。
     *
     * @param 抄本番号 ShohonNo
     * @return 日付情報 KaikuTaishoShohonJohoData
     */
    @Transaction
    public KaikuTaishoShohonJohoData get日付情報(ShohonNo 抄本番号) {
        KaikuTaishoShohonJohoParameter 日付検索条件 = new KaikuTaishoShohonJohoParameter(抄本番号);

        requireNonNull(日付検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("日付検索条件"));
        IKaikuTaishoShohonJohoMapper mapper = mapperProvider.create(IKaikuTaishoShohonJohoMapper.class);
        KaikuTaishoShohonJohoEntity entity = mapper.select日付情報(日付検索条件);

        return new KaikuTaishoShohonJohoData(entity.getAft100Entity(), entity.getAft111Entity());

    }
}
