/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tojitsutohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.message.AfInformationMessages;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のチェッククラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyoValidationService {

    private final TojitsuTohyoRepositoryValidator repositoryValidator;
    private final ShohonManager shohonManager;

    /**
     * コンストラクタです。
     */
    TojitsuTohyoValidationService() {
        this.repositoryValidator = InstanceProvider.create(TojitsuTohyoRepositoryValidator.class);
        this.shohonManager = ShohonManager.createInstance();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param repositoryValidator KijitsumaeTohyoRepositoryValidator
     * @param shohonManager ShohonManager
     */
    TojitsuTohyoValidationService(TojitsuTohyoRepositoryValidator repositoryValidator, ShohonManager shohonManager) {
        this.repositoryValidator = repositoryValidator;
        this.shohonManager = shohonManager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TojitsuTohyoValidationService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TojitsuTohyoValidationService}のインスタンス
     */
    public static TojitsuTohyoValidationService createInstance() {
        return InstanceProvider.create(TojitsuTohyoValidationService.class);
    }

    /**
     * バリデーション結果を返します。<br/> {@link TojitsuTohyoRepositoryValidator}を利用します。
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
     * @param shohonNo ShohonNo
     * @return Message
     */
    @Transaction
    public Message 各種エラーチェック1(ShohonNo shohonNo) {

        Shohon shohon = shohonManager.get抄本(shohonNo);

        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setShohonEntity(shohon.toEntity());
        List<AfT111SenkyoEntity> list = new ArrayList<>();
        for (Senkyo senkyo : shohon.getSenkyoList()) {
            list.add(senkyo.toEntity());
        }

        senkyoJohoEntity.setSenkyoEntity(list);
        senkyoninTohyoJokyoEntity.setSenkyoJohoEntity(senkyoJohoEntity);
        TohyoShikakuHantei 投票資格判定クラス = new TohyoShikakuHantei();

        IValidationMessages messg = 投票資格判定クラス.各種エラーチェック1(senkyoninTohyoJokyoEntity);
        if (messg.getSize() > 0) {
            return messg.getList().get(0).getMessage();
        }
        return null;
    }

    /**
     * 各種エラーチェック結果を返します。
     *
     * @param chohyoData KijitsumaeTohyoChohyoData
     * @return Message
     */
    @Transaction
    public Message 各種エラーチェック(KijitsumaeTohyoChohyoData chohyoData) {
        SenkyoninTohyoJokyoEntity tohyoJokyoEntity = chohyoData.getEntity();
        TohyoShikakuHantei 投票資格判定 = new TohyoShikakuHantei(tohyoJokyoEntity.getTohyoJokyoEntityList(), null, null);

        IValidationMessages messgs = 投票資格判定.各種エラーチェック(tohyoJokyoEntity, FlexibleDate.getNowDate());
        if (messgs != null) {
            return messgs.getList().get(0).getMessage();
        }
        return null;
    }

    /**
     * 確認チェック結果を返します。
     *
     * @param chohyoData KijitsumaeTohyoChohyoData
     * @return Message
     */
    public IValidationMessages 確認チェック(KijitsumaeTohyoChohyoData chohyoData) {
        SenkyoninTohyoJokyoEntity entity = chohyoData.getEntity();
        TohyoShikakuHantei 投票資格判定 = new TohyoShikakuHantei(entity.getTohyoJokyoEntityList(), null, null);

        return 投票資格判定.確認チェック(entity, FlexibleDate.getNowDate());
    }

    /**
     * 確認チェック結果を返します。
     *
     * @param chohyoData KijitsumaeTohyoChohyoData
     * @return Message
     */
    public RString 確認チェックのチェック１(KijitsumaeTohyoChohyoData chohyoData) {
        SenkyoninTohyoJokyoEntity entity = chohyoData.getEntity();
        TohyoShikakuHantei 投票資格判定 = new TohyoShikakuHantei(entity.getTohyoJokyoEntityList(), null, null);

        IValidationMessages messgs = 投票資格判定.確認チェック(entity, FlexibleDate.getNowDate());
        if (messgs != null) {
            if (messgs.getList().get(0).getMessage().evaluate().equals(AfInformationMessages.投票受付完了.getMessage().evaluate())) {
                return new RString(AfInformationMessages.投票受付完了.getMessage().evaluate());
            }
            if (messgs.getList().get(0).getMessage().evaluate().equals(AfInformationMessages.一部交付済み.getMessage().evaluate())) {
                return new RString(AfInformationMessages.一部交付済み.getMessage().evaluate());
            }
            if (messgs.getList().get(0).getMessage().evaluate().equals(AfInformationMessages.一部受付済み.getMessage().evaluate())) {
                return new RString(AfInformationMessages.一部受付済み.getMessage().evaluate());
            }
        }
        return RString.EMPTY;
    }

}
