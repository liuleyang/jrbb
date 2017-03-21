/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.fuzaishatohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.SenkyoninSearchResult;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不在者投票ValidationService
 *
 * @reamsid_L AF-0080-010 lit
 */
public class FuzaishaTohyoValidationService {

    /**
     * コンストラクタです。
     */
    FuzaishaTohyoValidationService() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FuzaishaTohyoValidationService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FuzaishaTohyoValidationService}のインスタンス
     */
    public static FuzaishaTohyoValidationService createInstance() {
        return InstanceProvider.create(FuzaishaTohyoValidationService.class);
    }

    /**
     * バリデーション結果を返します。<br/> {@link FuzaishaTohyoRepositoryValidator}を利用します。
     *
     * @param 選挙人リスト List<SenkyoninSearchResult>
     * @param 投票年月日 FlexibleDate
     * @return バリデーション突合結果
     */
    @Transaction
    public IValidationMessages validate各種チェック(List<SenkyoninSearchResult> 選挙人リスト, FlexibleDate 投票年月日) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        TohyoShikakuHantei hantei = new TohyoShikakuHantei();
        List<SenkyoninTohyoJokyoEntity> resultList = convertResultToEntity(選挙人リスト);
        for (SenkyoninTohyoJokyoEntity entity : resultList) {
            messages = hantei.各種エラーチェック(entity, 投票年月日);
            if (null != messages) {
                return messages;
            }
        }
        return messages;
    }

    /**
     * バリデーション結果を返します。<br/> {@link FuzaishaTohyoRepositoryValidator}を利用します。
     *
     * @param 選挙人リスト List<SenkyoninSearchResult>
     * @param 投票年月日 FlexibleDate
     * @return バリデーション突合結果
     */
    @Transaction
    public IValidationMessages validate確認チェック(List<SenkyoninSearchResult> 選挙人リスト, FlexibleDate 投票年月日) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        TohyoShikakuHantei hantei = new TohyoShikakuHantei();
        List<SenkyoninTohyoJokyoEntity> resultList = convertResultToEntity(選挙人リスト);
        for (SenkyoninTohyoJokyoEntity entity : resultList) {
            messages = hantei.確認チェック(entity, 投票年月日);
            if (null != messages) {
                return messages;
            }
        }
        return messages;
    }

    private List<SenkyoninTohyoJokyoEntity> convertResultToEntity(List<SenkyoninSearchResult> 選挙人リスト) {
        List<SenkyoninTohyoJokyoEntity> resultList = new ArrayList<>();
        SenkyoninTohyoJokyoEntity result = new SenkyoninTohyoJokyoEntity();
        RString 前識別コード = RString.EMPTY;
        List<AfT111SenkyoEntity> 選挙リスト = new ArrayList<>();
        SenkyoJohoEntity 抄本選挙情報 = new SenkyoJohoEntity();
        SenkyoninSearchResult 前選挙人 = null;
        for (SenkyoninSearchResult 選挙人 : 選挙人リスト) {
            if (前識別コード.isEmpty() || 前識別コード.equals(選挙人.get識別コード())) {
                選挙リスト.add(選挙人.getEntity().get選挙Entity());
            } else {
                抄本選挙情報.setShohonEntity(前選挙人.getEntity().get抄本Entity());
                抄本選挙情報.setSenkyoEntity(選挙リスト);
                result.setSenkyoJohoEntity(抄本選挙情報);
                result.setSenkyoninMeiboEntity(前選挙人.getEntity().get選挙人名簿Entity());
                result.setSenkyoShikakuEntity(前選挙人.getEntity().get選挙資格Entity());
                result.setAtenaPSMEntity(前選挙人.getEntity().get宛名情報Entity());
                result.setTohyoJokyoEntityList(new ArrayList<AfT201TohyoJokyoEntity>());
                resultList.add(result);

                result = new SenkyoninTohyoJokyoEntity();
                抄本選挙情報 = new SenkyoJohoEntity();
                選挙リスト = new ArrayList<>();
            }
            前識別コード = 選挙人.get識別コード();
            前選挙人 = 選挙人;
        }

        抄本選挙情報.setShohonEntity(前選挙人.getEntity().get抄本Entity());
        抄本選挙情報.setSenkyoEntity(選挙リスト);
        result.setSenkyoJohoEntity(抄本選挙情報);
        result.setSenkyoninMeiboEntity(前選挙人.getEntity().get選挙人名簿Entity());
        result.setSenkyoShikakuEntity(前選挙人.getEntity().get選挙資格Entity());
        result.setAtenaPSMEntity(前選挙人.getEntity().get宛名情報Entity());
        result.setTohyoJokyoEntityList(new ArrayList<AfT201TohyoJokyoEntity>());
        resultList.add(result);

        return resultList;
    }
}
