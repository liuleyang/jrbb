/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.zaigaihenko;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT122ZaigaiSenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT123ZaigaiSenkyoninJushoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT124ZaigaiSenkyoninShinseiDac;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 証明書記載事項変更マネージャクラスです。
 *
 * @reamsid_L AF-0330-010 guancy
 */
public class ZaigaiHenkoManager {

    private final AfT122ZaigaiSenkyoShikakuDac zaigaiSenkyoShikakuDac;
    private final AfT123ZaigaiSenkyoninJushoDac zaigaiSenkyoninJushoDac;
    private final AfT124ZaigaiSenkyoninShinseiDac zaigaiSenkyoninShinseiDac;

    /**
     * コンストラクタです。
     */
    public ZaigaiHenkoManager() {
        zaigaiSenkyoShikakuDac = InstanceProvider.create(AfT122ZaigaiSenkyoShikakuDac.class);
        zaigaiSenkyoninJushoDac = InstanceProvider.create(AfT123ZaigaiSenkyoninJushoDac.class);
        zaigaiSenkyoninShinseiDac = InstanceProvider.create(AfT124ZaigaiSenkyoninShinseiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ZaigaiHenkoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ZaigaiHenkoManager}のインスタンス
     */
    public static ZaigaiHenkoManager createInstance() {
        return InstanceProvider.create(ZaigaiHenkoManager.class);
    }

    /**
     * 在外選挙人名簿をインサートします。
     *
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 在外選挙人申請情報 AfT124ZaigaiSenkyoninShinseiEntity
     * @param 本籍地住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 国外転出前最終住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 国内転入先住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 海外住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 海外送付先住所 AfT123ZaigaiSenkyoninJushoEntity
     * @return int
     */
    @Transaction
    public boolean insert在外選挙情報(
            AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            AfT124ZaigaiSenkyoninShinseiEntity 在外選挙人申請情報,
            AfT123ZaigaiSenkyoninJushoEntity 本籍地住所,
            AfT123ZaigaiSenkyoninJushoEntity 国外転出前最終住所,
            AfT123ZaigaiSenkyoninJushoEntity 国内転入先住所,
            AfT123ZaigaiSenkyoninJushoEntity 海外住所,
            AfT123ZaigaiSenkyoninJushoEntity 海外送付先住所) {
        在外選挙資格.setState(EntityDataState.Added);
        在外選挙人申請情報.setState(EntityDataState.Added);
        本籍地住所.setState(EntityDataState.Added);

        国外転出前最終住所.setState(EntityDataState.Added);
        if (国内転入先住所 != null) {
            国内転入先住所.setState(EntityDataState.Added);
        }

        海外住所.setState(EntityDataState.Added);
        海外送付先住所.setState(EntityDataState.Added);
        return 0 != zaigaiSenkyoShikakuDac.save(在外選挙資格)
                && 0 != zaigaiSenkyoninShinseiDac.save(在外選挙人申請情報)
                && 0 != zaigaiSenkyoninJushoDac.save(本籍地住所)
                && 0 != zaigaiSenkyoninJushoDac.save(国外転出前最終住所)
                && (国内転入先住所 == null || 0 != zaigaiSenkyoninJushoDac.save(国内転入先住所))
                && 0 != zaigaiSenkyoninJushoDac.save(海外住所)
                && 0 != zaigaiSenkyoninJushoDac.save(海外送付先住所);
    }
}
