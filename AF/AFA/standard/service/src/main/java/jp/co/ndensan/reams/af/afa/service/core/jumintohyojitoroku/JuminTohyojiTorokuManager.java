/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.jumintohyojitoroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyojitoroku.ShohonJohoResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyojitoroku.ShohonJohoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.jumintohyojitoroku.IJuminTohyojiTorokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住所条件選択の取得
 *
 * @reamsid_L AF-0450-010 jihb
 */
public class JuminTohyojiTorokuManager {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public JuminTohyojiTorokuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JuminTohyojiTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JuminTohyojiTorokuManager}のインスタンス
     */
    public static JuminTohyojiTorokuManager createInstance() {
        return InstanceProvider.create(JuminTohyojiTorokuManager.class);
    }

    /**
     * 抄本番号に合致する抄本情報を返します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return ShohonJohoResult nullが返る可能性があります。
     */
    @Transaction
    public ShohonJohoResult get抄本情報(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        IJuminTohyojiTorokuMapper 抄本情報mapper = mapperProvider.create(IJuminTohyojiTorokuMapper.class);
        ShohonJohoEntity 抄本情報 = 抄本情報mapper.select抄本情報By抄本番号(抄本番号);
        if (null == 抄本情報) {
            return null;
        }
        return new ShohonJohoResult(抄本情報);
    }

}
