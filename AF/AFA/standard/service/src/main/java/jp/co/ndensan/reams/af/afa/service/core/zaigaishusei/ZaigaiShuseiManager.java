/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.zaigaishusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoShikakuResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninJushoResult;
import jp.co.ndensan.reams.af.afa.business.core.ZaigaiSenkyoninMeiboResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT121ZaigaiSenkyoninMeiboDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT122ZaigaiSenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT123ZaigaiSenkyoninJushoDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 在外選挙人名簿修正を管理するクラスです。
 *
 * @reamsid_L AF-0325-034 guyq
 */
public class ZaigaiShuseiManager {

    private final AfT123ZaigaiSenkyoninJushoDac afT123ZaigaiSenkyoninJushoDac;
    private final AfT121ZaigaiSenkyoninMeiboDac afT121ZaigaiSenkyoninMeiboDac;
    private final AfT122ZaigaiSenkyoShikakuDac afT122ZaigaiSenkyoShikakuDac;

    /**
     * コンストラクタです。
     */
    public ZaigaiShuseiManager() {
        afT123ZaigaiSenkyoninJushoDac = InstanceProvider.create(AfT123ZaigaiSenkyoninJushoDac.class);
        afT121ZaigaiSenkyoninMeiboDac = InstanceProvider.create(AfT121ZaigaiSenkyoninMeiboDac.class);
        afT122ZaigaiSenkyoShikakuDac = InstanceProvider.create(AfT122ZaigaiSenkyoShikakuDac.class);

    }

    ZaigaiShuseiManager(AfT123ZaigaiSenkyoninJushoDac afT123ZaigaiSenkyoninJushoDac,
            AfT121ZaigaiSenkyoninMeiboDac afT121ZaigaiSenkyoninMeiboDac,
            AfT122ZaigaiSenkyoShikakuDac afT122ZaigaiSenkyoShikakuDac) {
        this.afT123ZaigaiSenkyoninJushoDac = afT123ZaigaiSenkyoninJushoDac;
        this.afT121ZaigaiSenkyoninMeiboDac = afT121ZaigaiSenkyoninMeiboDac;
        this.afT122ZaigaiSenkyoShikakuDac = afT122ZaigaiSenkyoShikakuDac;

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ZaigaiShuseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ZaigaiShuseiManager}のインスタンス
     */
    public static ZaigaiShuseiManager createInstance() {
        return InstanceProvider.create(ZaigaiShuseiManager.class);
    }

    /**
     * 抄本番号と識別コードで在外選挙人名簿を取得します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @return 外選挙人名簿リスト
     */
    public List<ZaigaiSenkyoninMeiboResult> get外選挙人名簿By抄本番号と識別コード(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {

        List<AfT121ZaigaiSenkyoninMeiboEntity> entityList
                = afT121ZaigaiSenkyoninMeiboDac.selectViewByShohonNoAndShikibetsuCode(shohonNo, shikibetsuCode);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<ZaigaiSenkyoninMeiboResult> resultList = new ArrayList<>();
        for (AfT121ZaigaiSenkyoninMeiboEntity entity : entityList) {
            resultList.add(new ZaigaiSenkyoninMeiboResult(entity));
        }
        return resultList;
    }

    /**
     * 抄本番号と識別コードで在外選挙人名簿を取得します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return 外選挙人名簿リスト
     */
    public List<ZaigaiSenkyoninMeiboResult> get外選挙人名簿By識別コード(ShikibetsuCode shikibetsuCode) {

        List<AfT121ZaigaiSenkyoninMeiboEntity> entityList
                = afT121ZaigaiSenkyoninMeiboDac.selectViewByShikibetsuCode(shikibetsuCode);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<ZaigaiSenkyoninMeiboResult> resultList = new ArrayList<>();
        for (AfT121ZaigaiSenkyoninMeiboEntity entity : entityList) {
            resultList.add(new ZaigaiSenkyoninMeiboResult(entity));
        }
        return resultList;
    }

    /**
     * 在外選挙資格を取得します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param shinseiNo int
     * @return 在外選挙資格情報
     */
    public ZaigaiSenkyoShikakuResult get在外選挙資格Byキー(ShikibetsuCode shikibetsuCode, int shinseiNo) {

        AfT122ZaigaiSenkyoShikakuEntity entity = afT122ZaigaiSenkyoShikakuDac.select(shikibetsuCode, shinseiNo);
        if (entity == null) {
            return null;
        }

        return new ZaigaiSenkyoShikakuResult(entity);
    }

    /**
     * 在外選挙資格を更新します。
     *
     * @param zaigaiSenkyoShikakuResult ZaigaiSenkyoShikakuResult
     * @param zaigaiSenkyoninJushoResult ZaigaiSenkyoninJushoResult
     * @param 国民投票抄本番号更新Flg boolean
     * @return 更新状態
     */
    @Transaction
    public Boolean update在外選挙資格と在外選挙人住所情報(ZaigaiSenkyoShikakuResult zaigaiSenkyoShikakuResult,
            ZaigaiSenkyoninJushoResult zaigaiSenkyoninJushoResult, boolean 国民投票抄本番号更新Flg) {
        boolean 更新結果_在外選挙資格 = update在外選挙資格(zaigaiSenkyoShikakuResult, 国民投票抄本番号更新Flg);
        boolean 更新結果_在外選挙人住所情報 = update在外選挙人住所情報(zaigaiSenkyoninJushoResult);
        return 更新結果_在外選挙資格 && 更新結果_在外選挙人住所情報;
    }

    /**
     * 在外選挙資格を更新します。
     *
     * @param zaigaiSenkyoShikakuResult ZaigaiSenkyoShikakuResult
     * @param 国民投票抄本番号更新Flg boolean
     * @return 更新状態
     */
    private Boolean update在外選挙資格(ZaigaiSenkyoShikakuResult zaigaiSenkyoShikakuResult, boolean 国民投票抄本番号更新Flg) {
        AfT122ZaigaiSenkyoShikakuEntity resultEntity = afT122ZaigaiSenkyoShikakuDac
                .select(zaigaiSenkyoShikakuResult.get識別コード(), zaigaiSenkyoShikakuResult.get申請番号());
        if (resultEntity == null) {
            return Boolean.FALSE;
        }
        if (国民投票抄本番号更新Flg) {
            resultEntity.setKokuminShohonNo(zaigaiSenkyoShikakuResult.get国民投票抄本番号());
        }

        resultEntity.setHyojiYMD(zaigaiSenkyoShikakuResult.get表示年月日());
        resultEntity.setHyojiJiyuCode(zaigaiSenkyoShikakuResult.get表示事由コード());
        resultEntity.setTokkiJiko(zaigaiSenkyoShikakuResult.get特記事項());

        return 1 == afT122ZaigaiSenkyoShikakuDac.updateZaigaiSenkyoShikaku(resultEntity);
    }

    /**
     * 在外選挙資格を更新します。
     *
     * @param zaigaiSenkyoShikakuResult ZaigaiSenkyoShikakuResult
     * @return 更新状態
     */
    @Transaction
    public Boolean update選挙資格(ZaigaiSenkyoShikakuResult zaigaiSenkyoShikakuResult) {
        AfT122ZaigaiSenkyoShikakuEntity resultEntity = afT122ZaigaiSenkyoShikakuDac
                .select(zaigaiSenkyoShikakuResult.get識別コード(), zaigaiSenkyoShikakuResult.get申請番号());
        if (resultEntity == null) {
            return Boolean.FALSE;
        }
        resultEntity.setHyojiYMD(zaigaiSenkyoShikakuResult.get表示年月日());
        resultEntity.setHyojiJiyuCode(zaigaiSenkyoShikakuResult.get表示事由コード());

        return 1 == afT122ZaigaiSenkyoShikakuDac.updateZaigaiSenkyoShikaku(resultEntity);
    }

    /**
     * 在外選挙人住所情報を更新します。
     *
     * @param zaigaiSenkyoninJushoResult ZaigaiSenkyoninJushoResult
     * @return 更新状態
     */
    private Boolean update在外選挙人住所情報(ZaigaiSenkyoninJushoResult zaigaiSenkyoninJushoResult) {
        AfT123ZaigaiSenkyoninJushoEntity resultEntity = afT123ZaigaiSenkyoninJushoDac
                .select(zaigaiSenkyoninJushoResult.get識別コード(), zaigaiSenkyoninJushoResult.get申請番号(), zaigaiSenkyoninJushoResult.get住所種類区分());
        if (resultEntity == null) {
            return Boolean.FALSE;
        }
        resultEntity.setYubinNo(zaigaiSenkyoninJushoResult.get郵便番号());
        resultEntity.setZenkokuJushoCode(zaigaiSenkyoninJushoResult.get全国住所コード());
        resultEntity.setJusho(zaigaiSenkyoninJushoResult.get住所());
        resultEntity.setBanchi(zaigaiSenkyoninJushoResult.get番地());
        resultEntity.setKatagakiCode(zaigaiSenkyoninJushoResult.get方書コード());
        resultEntity.setKatagaki(zaigaiSenkyoninJushoResult.get方書());
        resultEntity.setKokunaiTennyuYMD(zaigaiSenkyoninJushoResult.get国内転入年月日());

        return 1 == afT123ZaigaiSenkyoninJushoDac.updateZaigaiSenkyoninJusho(resultEntity);
    }

}
