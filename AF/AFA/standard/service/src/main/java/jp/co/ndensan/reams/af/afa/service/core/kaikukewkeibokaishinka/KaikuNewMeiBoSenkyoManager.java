/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kaikukewkeibokaishinka;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.kaikunewmeibosenkyo.KaikuNewMeiBoSenkyoMapperParam;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT201TohyoJokyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.kaikunewmeibosenkyo.IKaikuNewMeiBoSenkyoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化Manager <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
public class KaikuNewMeiBoSenkyoManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT201TohyoJokyoDac dac;

    /**
     * コンストラクタです。
     */
    public KaikuNewMeiBoSenkyoManager() {
        dac = InstanceProvider.create(AfT201TohyoJokyoDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaikuNewMeiBoSenkyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaikuNewMeiBoSenkyoManager}のインスタンス
     */
    public static KaikuNewMeiBoSenkyoManager createInstance() {
        return InstanceProvider.create(KaikuNewMeiBoSenkyoManager.class);
    }

    /**
     * 検索結果一覧を取得します。
     *
     * @return List<KaikuNewMeiBoSenkyoMapperParam>
     */
    @Transaction
    public List<KaikuNewMeiBoSenkyoMapperParam> get検索結果一覧() {
        IKaikuNewMeiBoSenkyoMapper mapper = mapperProvider.create(IKaikuNewMeiBoSenkyoMapper.class);
        List<KaikuNewMeiBoSenkyoMapperParam> kaikuNewMeiBoSenkyoJouhou = mapper.select検索結果一覧(FlexibleDate.getNowDate().getNendo(),
                FlexibleDate.getNowDate().plusYear(1).getNendo());
        if (null != kaikuNewMeiBoSenkyoJouhou) {
            return kaikuNewMeiBoSenkyoJouhou;
        }
        return null;
    }

    /**
     * 投票状況を取得します。
     *
     * @param 抄本番号 RString
     * @return 投票状況有無
     */
    public Boolean get投票状況有無(RString 抄本番号) {
        List<AfT201TohyoJokyoEntity> entityList = dac.selectByShohon(new ShohonNo(抄本番号));
        return !entityList.isEmpty();
    }
}
