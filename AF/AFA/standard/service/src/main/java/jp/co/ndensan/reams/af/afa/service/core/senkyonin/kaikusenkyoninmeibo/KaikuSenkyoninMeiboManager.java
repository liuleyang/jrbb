/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.kaikusenkyoninmeibo;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho.KaikuSenkyoFuzuiResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyofuzui.KaikuSenkyoFuzui;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyoshikaku.KaikuSenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyoshikaku.SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.definition.core.KaikuSenkyoninMeiboEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT112SenkyoninMeiboDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT113SenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT133KaikuSenkyoFuzuiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 海区選挙人名簿を管理するクラスです。
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class KaikuSenkyoninMeiboManager {

    private final AfT112SenkyoninMeiboDac 選挙人名簿Dac;
    private final AfT113SenkyoShikakuDac 選挙資格Dac;
    private final AfT133KaikuSenkyoFuzuiDac 海区付随情報Dac;

    /**
     * コンストラクタです。
     */
    KaikuSenkyoninMeiboManager() {
        this.選挙人名簿Dac = InstanceProvider.create(AfT112SenkyoninMeiboDac.class);
        this.選挙資格Dac = InstanceProvider.create(AfT113SenkyoShikakuDac.class);
        this.海区付随情報Dac = InstanceProvider.create(AfT133KaikuSenkyoFuzuiDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 選挙人名簿Dac 選挙人名簿Dac
     * @param 選挙資格Dac 選挙資格Dac
     * @param 海区付随情報Dac 海区付随情報Dac
     */
    KaikuSenkyoninMeiboManager(
            AfT112SenkyoninMeiboDac 選挙人名簿Dac,
            AfT113SenkyoShikakuDac 選挙資格Dac,
            AfT133KaikuSenkyoFuzuiDac 海区付随情報Dac
    ) {
        this.選挙人名簿Dac = 選挙人名簿Dac;
        this.選挙資格Dac = 選挙資格Dac;
        this.海区付随情報Dac = 海区付随情報Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoninMeiboManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyoninMeiboManager}のインスタンス
     */
    public static KaikuSenkyoninMeiboManager createInstance() {
        return InstanceProvider.create(KaikuSenkyoninMeiboManager.class);
    }

    /**
     * 主キー2に合致する選挙人名簿のリストを返します。
     *
     * @param shohonNo 抄本NO
     * @param shikibetsuCode 識別コード
     * @return SenkyoninMeibo
     */
    @Transaction
    public SenkyoninMeiboEntity getSenkyoninMeiboList(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        requireNonNull(shohonNo, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.抄本番号.name()));
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.識別コード.name()));

        選挙人名簿Dac.selectWithOrder(shohonNo, shikibetsuCode, false);

        List<AfT112SenkyoninMeiboEntity> relateEntityList = 選挙人名簿Dac.selectWithOrder(shohonNo, shikibetsuCode, false);
        if (relateEntityList != null && !relateEntityList.isEmpty()) {
            return new SenkyoninMeiboEntity(relateEntityList.get(0));
        }
        return null;
    }

    /**
     * 海区付随情報{@link KaikuSenkyoFuzui}を保存します。
     *
     * @param 選挙資格 選挙資格
     * @param 選挙人名簿 選挙人名簿
     * @param 海区付随情報 海区付随情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean insert海区付随情報(KaikuSenkyoShikaku 選挙資格, SenkyoninMeiboEntity 選挙人名簿, KaikuSenkyoFuzui 海区付随情報) {
        requireNonNull(海区付随情報, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.海区付随情報.name()));
        requireNonNull(選挙資格, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.選挙資格.name()));
        requireNonNull(選挙人名簿, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.選挙人名簿.name()));
        AfT112SenkyoninMeiboEntity senkyoninMeiboEntity = 選挙人名簿.toEntity();
        senkyoninMeiboEntity.setState(EntityDataState.Added);

        AfT113SenkyoShikakuEntity senkyoShikakuEntity = 選挙資格.toEntity();
        senkyoShikakuEntity.setState(EntityDataState.Added);

        AfT133KaikuSenkyoFuzuiEntity kaikuSenkyoFuzuiEntity = 海区付随情報.toEntity();
        kaikuSenkyoFuzuiEntity.setState(EntityDataState.Added);
        return 1 == 海区付随情報Dac.save(kaikuSenkyoFuzuiEntity) && 1 == 選挙資格Dac.save(senkyoShikakuEntity) && 1 == 選挙人名簿Dac.save(senkyoninMeiboEntity);
    }

    /**
     * 海区付随情報{@link SenkyoninMeibo}を削除します。
     *
     * @param 選挙資格 選挙資格
     * @param 選挙人名簿 選挙人名簿
     * @param 海区付随情報 海区付随情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean delete海区付随情報(KaikuSenkyoShikaku 選挙資格, SenkyoninMeiboEntity 選挙人名簿, KaikuSenkyoFuzuiResult 海区付随情報) {
        requireNonNull(海区付随情報, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.海区付随情報.name()));
        requireNonNull(選挙資格, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.選挙資格.name()));
        requireNonNull(選挙人名簿, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.選挙人名簿.name()));
        AfT113SenkyoShikakuEntity senkyoShikakuEntity = 選挙資格.toEntity();
        senkyoShikakuEntity.setState(EntityDataState.Added);
        AfT112SenkyoninMeiboEntity senkyoninMeiboEntity = 選挙人名簿.toEntity();
        senkyoninMeiboEntity.setState(EntityDataState.Added);

        AfT133KaikuSenkyoFuzuiEntity kaikuSenkyoFuzuiEntity = 海区付随情報Dac.select(海区付随情報.get抄本番号(), 海区付随情報.get識別コード());
        if (kaikuSenkyoFuzuiEntity == null) {
            return false;
        }
        kaikuSenkyoFuzuiEntity = 海区付随情報.getEntity();
        kaikuSenkyoFuzuiEntity.setState(EntityDataState.Deleted);
        return 1 == 海区付随情報Dac.delete(kaikuSenkyoFuzuiEntity) && 1 == 選挙資格Dac.save(senkyoShikakuEntity) && 1 == 選挙人名簿Dac.save(senkyoninMeiboEntity);
    }

    /**
     * 海区付随情報{@link SenkyoninMeibo}を更新します。
     *
     * @param 選挙資格 選挙資格
     * @param 選挙人名簿 選挙人名簿
     * @param 海区付随情報 海区付随情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean update海区付随情報(KaikuSenkyoShikaku 選挙資格, SenkyoninMeiboEntity 選挙人名簿, KaikuSenkyoFuzuiResult 海区付随情報) {
        requireNonNull(選挙人名簿, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.選挙人名簿.name()));
        requireNonNull(海区付随情報, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.海区付随情報.name()));
        requireNonNull(選挙資格, UrSystemErrorMessages.値がnull.getReplacedMessage(KaikuSenkyoninMeiboEnum.選挙資格.name()));

        AfT113SenkyoShikakuEntity senkyoShikakuEntity = 選挙資格.toEntity();
        senkyoShikakuEntity.setState(EntityDataState.Added);

        AfT112SenkyoninMeiboEntity senkyoninMeiboEntity = 選挙人名簿.toEntity();
        senkyoninMeiboEntity.setState(EntityDataState.Added);
        AfT133KaikuSenkyoFuzuiEntity entity = 海区付随情報.getEntity();
        entity.setState(EntityDataState.Modified);
        return 1 == 海区付随情報Dac.save(entity) && 1 == 選挙資格Dac.save(senkyoShikakuEntity) && 1 == 選挙人名簿Dac.save(senkyoninMeiboEntity);
    }
}
