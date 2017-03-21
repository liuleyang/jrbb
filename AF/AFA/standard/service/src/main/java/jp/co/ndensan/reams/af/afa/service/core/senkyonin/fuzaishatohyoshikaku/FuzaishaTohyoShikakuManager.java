/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.fuzaishatohyoshikaku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubin;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT114FuzaishaTohyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin.IFuzaishaTohyoShikakuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubinManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不在者投票資格を管理するクラスです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class FuzaishaTohyoShikakuManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT114FuzaishaTohyoShikakuDac 不在者投票資格Dac;
    private final FuzaishaTohyoShikakuYubinManager 郵便投票資格付随情報Manager;

    /**
     * コンストラクタです。
     */
    FuzaishaTohyoShikakuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.不在者投票資格Dac = InstanceProvider.create(AfT114FuzaishaTohyoShikakuDac.class);
        this.郵便投票資格付随情報Manager = new FuzaishaTohyoShikakuYubinManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 不在者投票資格Dac 不在者投票資格Dac
     * @param 郵便投票資格付随情報Manager 郵便投票資格付随情報Manager
     */
    FuzaishaTohyoShikakuManager(
            AfaMapperProvider mapperProvider,
            AfT114FuzaishaTohyoShikakuDac 不在者投票資格Dac,
            FuzaishaTohyoShikakuYubinManager 郵便投票資格付随情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.不在者投票資格Dac = 不在者投票資格Dac;
        this.郵便投票資格付随情報Manager = 郵便投票資格付随情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FuzaishaTohyoShikakuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FuzaishaTohyoShikakuManager}のインスタンス
     */
    public static FuzaishaTohyoShikakuManager createInstance() {
        return InstanceProvider.create(FuzaishaTohyoShikakuManager.class);
    }

    /**
     * 主キーに合致する不在者投票資格を返します。
     *
     * @param 不在者投票資格検索条件 不在者投票資格検索条件
     * @return FuzaishaTohyoShikaku nullが返る可能性があります。
     */
    @Transaction
    public FuzaishaTohyoShikaku get不在者投票資格(FuzaishaTohyoShikakuMapperParameter 不在者投票資格検索条件) {
        requireNonNull(不在者投票資格検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格検索条件"));
        IFuzaishaTohyoShikakuMapper mapper = mapperProvider.create(IFuzaishaTohyoShikakuMapper.class);

        FuzaishaTohyoShikakuEntity relateEntity = mapper.select不在者投票資格ByKey(不在者投票資格検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        FuzaishaTohyoShikakuEntity fuzaishaTohyoShikakuEntity = new FuzaishaTohyoShikakuEntity();
        fuzaishaTohyoShikakuEntity.set不在者投票資格Entity(relateEntity.get不在者投票資格Entity());
        fuzaishaTohyoShikakuEntity.set郵便投票資格付随情報Entity(relateEntity.get郵便投票資格付随情報Entity());
        return new FuzaishaTohyoShikaku(fuzaishaTohyoShikakuEntity);
    }

    /**
     * 主キー1に合致する不在者投票資格のリストを返します。
     *
     * @param 不在者投票資格検索条件 不在者投票資格検索条件
     * @return FuzaishaTohyoShikakuの{@code list}
     */
    @Transaction
    public List<FuzaishaTohyoShikaku> get不在者投票資格リストBy主キー1(FuzaishaTohyoShikakuMapperParameter 不在者投票資格検索条件) {
        requireNonNull(不在者投票資格検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格検索条件"));
        IFuzaishaTohyoShikakuMapper mapper = mapperProvider.create(IFuzaishaTohyoShikakuMapper.class);

        List<FuzaishaTohyoShikakuEntity> relateEntityList = mapper.select不在者投票資格リストBy主キー1(不在者投票資格検索条件);

        ArrayList<FuzaishaTohyoShikaku> 不在者投票資格List = new ArrayList<>();
        for (FuzaishaTohyoShikakuEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            不在者投票資格List.add(new FuzaishaTohyoShikaku(relateEntity));
        }
        return 不在者投票資格List;

    }

    /**
     * 不在者投票資格全件を取得します。
     *
     * @return 不在者投票資格
     */
    public List<AfT114FuzaishaTohyoShikakuEntity> selectAll() {
        return 不在者投票資格Dac.selectAll();
    }

    /**
     * 不在者投票資格{@link FuzaishaTohyoShikaku}を保存します。
     *
     * @param 不在者投票資格 不在者投票資格
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(FuzaishaTohyoShikaku 不在者投票資格) {
        requireNonNull(不在者投票資格, UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格"));

        if (!不在者投票資格.hasChanged()) {
            return false;
        }
        不在者投票資格 = 不在者投票資格.modifiedModel();
        save郵便投票資格付随情報リスト(郵便投票資格付随情報Manager.get郵便投票資格付随情報一覧());
        return 1 == 不在者投票資格Dac.save(不在者投票資格.toEntity());
    }

    /**
     * 不在者投票資格{@link FuzaishaTohyoShikaku}を保存します。
     *
     * @param 不在者投票資格 不在者投票資格
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save不在者投票(FuzaishaTohyoShikaku 不在者投票資格) {
        requireNonNull(不在者投票資格, UrSystemErrorMessages.値がnull.getReplacedMessage("不在者投票資格"));

        if (!不在者投票資格.hasChanged()) {
            return false;
        }
        不在者投票資格 = 不在者投票資格.modifiedModel();
        save郵便投票資格付随情報リスト(不在者投票資格.getFuzaishaTohyoShikakuYubinList());
        return 1 == 不在者投票資格Dac.save不在者投票(不在者投票資格.toEntity());
    }

    private void save郵便投票資格付随情報リスト(List<FuzaishaTohyoShikakuYubin> 郵便投票資格付随情報List) {
        for (FuzaishaTohyoShikakuYubin 郵便投票資格付随情報 : 郵便投票資格付随情報List) {
            郵便投票資格付随情報Manager.save郵便投票(郵便投票資格付随情報);
        }
    }
}
