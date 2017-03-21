/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.zaigaimeibotoroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninMeiboResult;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT121ZaigaiSenkyoninMeiboDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT122ZaigaiSenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT123ZaigaiSenkyoninJushoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT124ZaigaiSenkyoninShinseiDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zaigaimeibotoroku.IZaigaiMeiboTorokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 在外選挙人名簿登録マネージャクラスです。
 *
 * @reamsid_L AF-0320-010 lis
 */
public class ZaigaiMeiboTorokuManager {

    private final AfT121ZaigaiSenkyoninMeiboDac zaigaiSenkyoninMeiboDac;
    private final AfT122ZaigaiSenkyoShikakuDac zaigaiSenkyoShikakuDac;
    private final AfT123ZaigaiSenkyoninJushoDac zaigaiSenkyoninJushoDac;
    private final AfT124ZaigaiSenkyoninShinseiDac zaigaiSenkyoninShinseiDac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ZaigaiMeiboTorokuManager() {
        zaigaiSenkyoninMeiboDac = InstanceProvider.create(AfT121ZaigaiSenkyoninMeiboDac.class);
        zaigaiSenkyoShikakuDac = InstanceProvider.create(AfT122ZaigaiSenkyoShikakuDac.class);
        zaigaiSenkyoninJushoDac = InstanceProvider.create(AfT123ZaigaiSenkyoninJushoDac.class);
        zaigaiSenkyoninShinseiDac = InstanceProvider.create(AfT124ZaigaiSenkyoninShinseiDac.class);
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ZaigaiMeiboTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ZaigaiMeiboTorokuManager}のインスタンス
     */
    public static ZaigaiMeiboTorokuManager createInstance() {
        return InstanceProvider.create(ZaigaiMeiboTorokuManager.class);
    }

    /**
     * 在外選挙人名簿をインサートします。
     *
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 在外選挙人申請情報 AfT124ZaigaiSenkyoninShinseiEntity
     * @param 本籍地住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 国外転出前最終住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 海外住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 海外送付先住所 AfT123ZaigaiSenkyoninJushoEntity
     * @return int
     */
    @Transaction
    public int insert在外選挙情報(
            AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            AfT124ZaigaiSenkyoninShinseiEntity 在外選挙人申請情報,
            AfT123ZaigaiSenkyoninJushoEntity 本籍地住所,
            AfT123ZaigaiSenkyoninJushoEntity 国外転出前最終住所,
            AfT123ZaigaiSenkyoninJushoEntity 海外住所,
            AfT123ZaigaiSenkyoninJushoEntity 海外送付先住所) {
        在外選挙資格.setState(EntityDataState.Added);
        在外選挙人申請情報.setState(EntityDataState.Added);
        本籍地住所.setState(EntityDataState.Added);
        国外転出前最終住所.setState(EntityDataState.Added);
        海外住所.setState(EntityDataState.Added);
        海外送付先住所.setState(EntityDataState.Added);
        if (0 == zaigaiSenkyoShikakuDac.save(在外選挙資格)
                || 0 == zaigaiSenkyoninShinseiDac.save(在外選挙人申請情報)
                || 0 == zaigaiSenkyoninJushoDac.save(本籍地住所)
                || 0 == zaigaiSenkyoninJushoDac.save(国外転出前最終住所)
                || 0 == zaigaiSenkyoninJushoDac.save(海外住所)
                || 0 == zaigaiSenkyoninJushoDac.save(海外送付先住所)) {
            return 0;
        }
        return 1;
    }

    /**
     * 在外選挙人名簿を更新します。
     *
     * @param 在外選挙人名簿リスト List<ZaigaiSenkyoninMeiboResult>
     * @param 在外選挙資格 AfT122ZaigaiSenkyoShikakuEntity
     * @param 在外選挙人申請情報 AfT124ZaigaiSenkyoninShinseiEntity
     * @param 本籍地住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 国外転出前最終住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 海外住所 AfT123ZaigaiSenkyoninJushoEntity
     * @param 海外送付先住所 AfT123ZaigaiSenkyoninJushoEntity
     * @return int
     */
    @Transaction
    public int update在外選挙情報(
            List<ZaigaiSenkyoninMeiboResult> 在外選挙人名簿リスト,
            AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格,
            AfT124ZaigaiSenkyoninShinseiEntity 在外選挙人申請情報,
            AfT123ZaigaiSenkyoninJushoEntity 本籍地住所,
            AfT123ZaigaiSenkyoninJushoEntity 国外転出前最終住所,
            AfT123ZaigaiSenkyoninJushoEntity 海外住所,
            AfT123ZaigaiSenkyoninJushoEntity 海外送付先住所) {
        if (null != 在外選挙人名簿リスト && !在外選挙人名簿リスト.isEmpty()) {
            for (ZaigaiSenkyoninMeiboResult 在外選挙人名簿 : 在外選挙人名簿リスト) {
                在外選挙人名簿.getEntity().setState(EntityDataState.Added);
                if (0 == zaigaiSenkyoninMeiboDac.save(在外選挙人名簿.getEntity())) {
                    return 0;
                }
            }
        }
        在外選挙資格.setState(EntityDataState.Modified);
        在外選挙人申請情報.setState(EntityDataState.Modified);
        本籍地住所.setState(EntityDataState.Modified);
        国外転出前最終住所.setState(EntityDataState.Modified);
        海外住所.setState(EntityDataState.Modified);
        海外送付先住所.setState(EntityDataState.Modified);
        if (0 == zaigaiSenkyoShikakuDac.save(在外選挙資格)
                || 0 == zaigaiSenkyoninShinseiDac.save(在外選挙人申請情報)
                || 0 == zaigaiSenkyoninJushoDac.save(本籍地住所)
                || 0 == zaigaiSenkyoninJushoDac.save(国外転出前最終住所)
                || 0 == zaigaiSenkyoninJushoDac.save(海外住所)
                || 0 == zaigaiSenkyoninJushoDac.save(海外送付先住所)) {
            return 0;
        }
        return 1;
    }

    /**
     * 抄本番号を取得します。
     *
     * @param 登録日 FlexibleDate
     * @return List<ShohonResult>
     */
    @Transaction
    public List<ShohonResult> get抄本番号リスト(RDate 登録日) {
        IZaigaiMeiboTorokuMapper mapper = mapperProvider.create(IZaigaiMeiboTorokuMapper.class);
        List<AfT100ShohonEntity> list = mapper.get抄本番号リスト(登録日);
        if (null == list || list.isEmpty()) {
            return null;
        }
        List<ShohonResult> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(new ShohonResult(list.get(i)));
        }
        return result;
    }

    /**
     * 前回在外選挙資格件数を取得する。
     *
     * @param 識別コード ShikibetsuCode
     * @param 選挙認証交付日 FlexibleDate
     * @return 前回在外選挙資格件数
     */
    public int select前回在外選挙資格件数(ShikibetsuCode 識別コード, FlexibleDate 選挙認証交付日) {
        List<AfT122ZaigaiSenkyoShikakuEntity> list = zaigaiSenkyoShikakuDac.select(識別コード, 選挙認証交付日);
        return null == list || list.isEmpty() ? 0 : list.size();
    }
}
