/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.zaigaisenkyoninmeibo;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.zaigaisenkyoninmeibo.ZaigaiSenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT121ZaigaiSenkyoninMeiboDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 在外選挙人名簿マネージャクラスです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
public class ZaigaiSenkyoninMeiboManager {

    private final AfT121ZaigaiSenkyoninMeiboDac dac;

    /**
     * コンストラクタです。
     */
    public ZaigaiSenkyoninMeiboManager() {
        dac = InstanceProvider.create(AfT121ZaigaiSenkyoninMeiboDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ZaigaiSenkyoninMeiboManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ZaigaiSenkyoninMeiboManager}のインスタンス
     */
    public static ZaigaiSenkyoninMeiboManager createInstance() {
        return InstanceProvider.create(ZaigaiSenkyoninMeiboManager.class);
    }

    /**
     * 抄本番号と識別コードで在外選挙人名簿を取得します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @return ZaigaiSenkyoninMeibo
     */
    @Transaction
    public ZaigaiSenkyoninMeibo get在外選挙人名簿(ShohonNo 抄本番号, ShikibetsuCode 識別コード) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        List<AfT121ZaigaiSenkyoninMeiboEntity> entitys = dac.selectByShohonNoAndShikibetsuCode(抄本番号, 識別コード);
        if (entitys == null || entitys.isEmpty()) {
            return null;
        }
        return new ZaigaiSenkyoninMeibo(entitys.get(0));
    }
}
