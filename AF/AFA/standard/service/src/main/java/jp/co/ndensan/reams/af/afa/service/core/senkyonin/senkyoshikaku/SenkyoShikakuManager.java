/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoshikaku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoshikaku.SenkyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoshikaku.SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT113SenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin.ISenkyoShikakuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙資格を管理するクラスです。
 */
public class SenkyoShikakuManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT113SenkyoShikakuDac 選挙資格Dac;
    private final FuzaishaTohyoShikakuManager 不在者投票資格Manager;

    /**
     * コンストラクタです。
     */
    SenkyoShikakuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.選挙資格Dac = InstanceProvider.create(AfT113SenkyoShikakuDac.class);
        this.不在者投票資格Manager = FuzaishaTohyoShikakuManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 選挙資格Dac 選挙資格Dac
     * @param 不在者投票資格Manager 不在者投票資格Manager
     */
    SenkyoShikakuManager(
            AfaMapperProvider mapperProvider,
            AfT113SenkyoShikakuDac 選挙資格Dac,
            FuzaishaTohyoShikakuManager 不在者投票資格Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.選挙資格Dac = 選挙資格Dac;
        this.不在者投票資格Manager = 不在者投票資格Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoShikakuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyoShikakuManager}のインスタンス
     */
    public static SenkyoShikakuManager createInstance() {
        return InstanceProvider.create(SenkyoShikakuManager.class);
    }

    /**
     * 主キーに合致する選挙資格を返します。
     *
     * @param 選挙資格検索条件 選挙資格検索条件
     * @return SenkyoShikaku nullが返る可能性があります。
     */
    @Transaction
    public SenkyoShikaku get選挙資格(SenkyoShikakuMapperParameter 選挙資格検索条件) {
        requireNonNull(選挙資格検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙資格検索条件"));
        ISenkyoShikakuMapper mapper = mapperProvider.create(ISenkyoShikakuMapper.class);

        SenkyoShikakuEntity relateEntity = mapper.select選挙資格ByKey(選挙資格検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        SenkyoShikakuEntity senkyoShikakuEntity = new SenkyoShikakuEntity();
        senkyoShikakuEntity.set選挙資格Entity(relateEntity.get選挙資格Entity());
        senkyoShikakuEntity.set不在者投票資格Entity(relateEntity.get不在者投票資格Entity());
        return new SenkyoShikaku(senkyoShikakuEntity);
    }

    /**
     * 主キー1に合致する選挙資格のリストを返します。
     *
     * @param 選挙資格検索条件 選挙資格検索条件
     * @return SenkyoShikakuの{@code list}
     */
    @Transaction
    public List<SenkyoShikaku> get選挙資格リストBy主キー1(SenkyoShikakuMapperParameter 選挙資格検索条件) {
        requireNonNull(選挙資格検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙資格検索条件"));
        ISenkyoShikakuMapper mapper = mapperProvider.create(ISenkyoShikakuMapper.class);

        List<SenkyoShikakuEntity> relateEntityList = mapper.select選挙資格リストBy主キー1(選挙資格検索条件);

        ArrayList<SenkyoShikaku> 選挙資格List = new ArrayList<>();
        for (SenkyoShikakuEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            選挙資格List.add(new SenkyoShikaku(relateEntity));
        }
        return 選挙資格List;

    }

    /**
     * 選挙種類と識別コードに合致する選挙資格のリストを返します。
     *
     * @param senkyoShurui 選挙種類
     * @param shikibetsuCode 識別コード
     * @return SenkyoShikaku
     */
    @Transaction
    public SenkyoShikaku get選挙資格By選挙種類と識別コード(Code senkyoShurui, ShikibetsuCode shikibetsuCode) {
        requireNonNull(senkyoShurui, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        List<AfT113SenkyoShikakuEntity> senkyoShikakuEntity = 選挙資格Dac.selectWithOrder(senkyoShurui, shikibetsuCode);
        if (senkyoShikakuEntity == null || senkyoShikakuEntity.isEmpty()) {
            return null;
        }
        SenkyoShikakuEntity relateEntity = new SenkyoShikakuEntity();
        relateEntity.set選挙資格Entity(senkyoShikakuEntity.get(0));
        relateEntity.initializeMd5ToEntities();
        return new SenkyoShikaku(relateEntity);
    }

    /**
     * 選挙資格{@link SenkyoShikaku}を保存します。
     *
     * @param 選挙資格 選挙資格
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(SenkyoShikaku 選挙資格) {
        requireNonNull(選挙資格, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙資格"));

        if (!選挙資格.hasChanged()) {
            return false;
        }
        選挙資格 = 選挙資格.modifiedModel();
        save不在者投票資格リスト(不在者投票資格Manager
                .get不在者投票資格リストBy主キー1(FuzaishaTohyoShikakuMapperParameter.createSelectListParam(選挙資格.get識別コード())));
        return 1 == 選挙資格Dac.insert(選挙資格.toEntity());
    }

    private void save不在者投票資格リスト(List<FuzaishaTohyoShikaku> 不在者投票資格List) {
        for (FuzaishaTohyoShikaku 不在者投票資格 : 不在者投票資格List) {
            不在者投票資格Manager.save(不在者投票資格);
        }
    }
}
