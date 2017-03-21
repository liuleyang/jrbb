/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kijitsumaetohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のチェッククラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyoValidationService {

    private final KijitsumaeTohyoRepositoryValidator repositoryValidator;
    private final ShohonManager shohonManager;

    /**
     * コンストラクタです。
     */
    KijitsumaeTohyoValidationService() {
        this.repositoryValidator = InstanceProvider.create(KijitsumaeTohyoRepositoryValidator.class);
        this.shohonManager = ShohonManager.createInstance();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param repositoryValidator KijitsumaeTohyoRepositoryValidator
     * @param shohonManager ShohonManager
     */
    KijitsumaeTohyoValidationService(KijitsumaeTohyoRepositoryValidator repositoryValidator, ShohonManager shohonManager) {
        this.repositoryValidator = repositoryValidator;
        this.shohonManager = shohonManager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KijitsumaeTohyoValidationService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KijitsumaeTohyoValidationService}のインスタンス
     */
    public static KijitsumaeTohyoValidationService createInstance() {
        return InstanceProvider.create(KijitsumaeTohyoValidationService.class);
    }

    /**
     * バリデーション結果を返します。<br/> {@link KijitsumaeTohyoRepositoryValidator}を利用します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @return バリデーション結果
     */
    @Transaction
    public boolean validate選挙人(ShohonNo 抄本番号, ShikibetsuCode 識別コード) {
        return repositoryValidator.validate選挙人名簿データ存在(抄本番号, 識別コード);
    }

    /**
     * 各種エラーチェック結果を返します。
     *
     * @param 抄本番号 抄本番号
     * @return Message
     */
    @Transaction
    public Message 各種エラーチェック1(ShohonNo 抄本番号) {

        Shohon shohon = shohonManager.get抄本(抄本番号);

        SenkyoninTohyoJokyoEntity entity = new SenkyoninTohyoJokyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setShohonEntity(shohon.toEntity());
        List<AfT111SenkyoEntity> senkyoList = new ArrayList<>();
        for (Senkyo senkyo : shohon.getSenkyoList()) {
            senkyoList.add(senkyo.toEntity());
        }

        senkyoJohoEntity.setSenkyoEntity(senkyoList);
        entity.setSenkyoJohoEntity(senkyoJohoEntity);
        TohyoShikakuHantei 投票資格判定クラス = new TohyoShikakuHantei();

        IValidationMessages messages = 投票資格判定クラス.各種エラーチェック1(entity);
        if (messages.getSize() > 0) {
            return messages.getList().get(0).getMessage();
        }
        return null;
    }

    /**
     * 各種エラーチェック結果を返します。
     *
     * @param kijitsumaeTohyoChohyoData KijitsumaeTohyoChohyoData
     * @return Message
     */
    @Transaction
    public Message 各種エラーチェック(KijitsumaeTohyoChohyoData kijitsumaeTohyoChohyoData) {
        SenkyoninTohyoJokyoEntity entity = kijitsumaeTohyoChohyoData.getEntity();
        TohyoShikakuHantei 投票資格判定クラス = new TohyoShikakuHantei(entity.getTohyoJokyoEntityList(), null, null);

        IValidationMessages messages = 投票資格判定クラス.各種エラーチェック(entity, FlexibleDate.getNowDate());
        if (messages != null) {
            return messages.getList().get(0).getMessage();
        }
        return null;
    }

    /**
     * 確認チェック結果を返します。
     *
     * @param kijitsumaeTohyoChohyoData KijitsumaeTohyoChohyoData
     * @return Message
     */
    public Message 確認チェック(KijitsumaeTohyoChohyoData kijitsumaeTohyoChohyoData) {
        SenkyoninTohyoJokyoEntity entity = kijitsumaeTohyoChohyoData.getEntity();
        TohyoShikakuHantei 投票資格判定クラス = new TohyoShikakuHantei(entity.getTohyoJokyoEntityList(), null, null);

        IValidationMessages messages = 投票資格判定クラス.確認チェック(entity, FlexibleDate.getNowDate());
        if (messages != null) {
            return messages.getList().get(0).getMessage();
        }
        return null;
    }
    
}
