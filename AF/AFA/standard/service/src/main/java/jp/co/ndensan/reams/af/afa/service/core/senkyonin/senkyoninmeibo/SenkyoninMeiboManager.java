/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoninmeibo.SenkyoninMeiboMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoninmeibo.SenkyoninMeiboPsmMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoshikaku.SenkyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectShohonNoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoninmeibo.SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT112SenkyoninMeiboDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku.IMeiboSakuseiKaikuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin.ISenkyoninMeiboMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoshikaku.SenkyoShikakuManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙人名簿を管理するクラスです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class SenkyoninMeiboManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT112SenkyoninMeiboDac 選挙人名簿Dac;
    private final SenkyoShikakuManager 選挙資格Manager;
    private final TohyoJokyoManager 投票状況Manager;

    /**
     * コンストラクタです。
     */
    SenkyoninMeiboManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.選挙人名簿Dac = InstanceProvider.create(AfT112SenkyoninMeiboDac.class);
        this.選挙資格Manager = SenkyoShikakuManager.createInstance();
        this.投票状況Manager = new TohyoJokyoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 選挙人名簿Dac 選挙人名簿Dac
     * @param 選挙資格Manager 選挙資格Manager
     * @param 投票状況Manager 投票状況Manager
     */
    SenkyoninMeiboManager(
            AfaMapperProvider mapperProvider,
            AfT112SenkyoninMeiboDac 選挙人名簿Dac,
            SenkyoShikakuManager 選挙資格Manager,
            TohyoJokyoManager 投票状況Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.選挙人名簿Dac = 選挙人名簿Dac;
        this.選挙資格Manager = 選挙資格Manager;
        this.投票状況Manager = 投票状況Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoninMeiboManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link SenkyoninMeiboManager}のインスタンス
     */
    public static SenkyoninMeiboManager createInstance() {
        return InstanceProvider.create(SenkyoninMeiboManager.class);
    }

    /**
     * 主キーに合致する選挙人名簿を返します。
     *
     * @param 選挙人名簿検索条件 選挙人名簿検索条件
     * @return SenkyoninMeibo nullが返る可能性があります。
     */
    @Transaction
    public SenkyoninMeibo get選挙人名簿(SenkyoninMeiboMapperParameter 選挙人名簿検索条件) {
        requireNonNull(選挙人名簿検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人名簿検索条件"));
        ISenkyoninMeiboMapper mapper = mapperProvider.create(ISenkyoninMeiboMapper.class);

        SenkyoninMeiboEntity relateEntity = mapper.select選挙人名簿ByKey(選挙人名簿検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        SenkyoninMeiboEntity senkyoninMeiboEntity = new SenkyoninMeiboEntity();
        senkyoninMeiboEntity.set投票状況Entity(relateEntity.get投票状況Entity());
        senkyoninMeiboEntity.set選挙人名簿Entity(relateEntity.get選挙人名簿Entity());
        senkyoninMeiboEntity.set選挙資格Entity(relateEntity.get選挙資格Entity());
        return new SenkyoninMeibo(senkyoninMeiboEntity);
    }

    /**
     * 主キー1に合致する選挙人名簿のリストを返します。
     *
     * @param 選挙人名簿検索条件 選挙人名簿検索条件
     * @return SenkyoninMeiboの{@code list}
     */
    @Transaction
    public List<SenkyoninMeibo> get選挙人名簿リストBy主キー1(SenkyoninMeiboMapperParameter 選挙人名簿検索条件) {
        requireNonNull(選挙人名簿検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人名簿検索条件"));
        ISenkyoninMeiboMapper mapper = mapperProvider.create(ISenkyoninMeiboMapper.class);

        List<SenkyoninMeiboEntity> relateEntityList = mapper.select選挙人名簿リストBy主キー1(選挙人名簿検索条件);

        ArrayList<SenkyoninMeibo> 選挙人名簿List = new ArrayList<>();
        for (SenkyoninMeiboEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            選挙人名簿List.add(new SenkyoninMeibo(relateEntity));
        }
        return 選挙人名簿List;
    }

    /**
     * 主キー2に合致する選挙人名簿のリストを返します。
     *
     * @param shohonNo 抄本NO
     * @param shikibetsuCode 識別コード
     * @return SenkyoninMeibo
     */
    @Transaction
    public SenkyoninMeibo getSenkyoninMeiboList(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        requireNonNull(shohonNo, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本NO"));
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

       // 選挙人名簿Dac.selectWithOrder(shohonNo, shikibetsuCode, false);
        IMeiboSakuseiKaikuMapper mapper = mapperProvider.create(IMeiboSakuseiKaikuMapper.class);
        List<ShohonNo> 抄本番号List = new ArrayList();
        抄本番号List.add(shohonNo);
        SelectShohonNoMybatisParameter param = new SelectShohonNoMybatisParameter(抄本番号List, shikibetsuCode, Boolean.FALSE);
        List<AfT112SenkyoninMeiboEntity> relateEntityList = mapper.select選挙人名簿By抄本番号(param);
//        List<AfT112SenkyoninMeiboEntity> relateEntityList = 選挙人名簿Dac.selectWithOrder(shohonNo, shikibetsuCode, false);
        if (relateEntityList != null && !relateEntityList.isEmpty()) {
            SenkyoninMeiboEntity relateEntity = new SenkyoninMeiboEntity();
            relateEntity.set選挙人名簿Entity(relateEntityList.get(0));
            relateEntity.initializeMd5ToEntities();
            return new SenkyoninMeibo(relateEntity);
        }
        return null;
    }

    /**
     * 選挙人名簿のリストを返します。
     *
     * @param shohonNo 抄本NO
     * @param shikibetsuCode 識別コード
     * @return SenkyoninMeibo
     */
    @Transaction
    public SenkyoninMeibo get名簿番号(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode) {
        requireNonNull(shohonNo, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本NO"));
        AfT112SenkyoninMeiboEntity relateEntity = 選挙人名簿Dac.select(shohonNo, shikibetsuCode);
        if (relateEntity != null) {
            SenkyoninMeiboEntity entity = new SenkyoninMeiboEntity();
            entity.set選挙人名簿Entity(relateEntity);
            entity.initializeMd5ToEntities();
            return new SenkyoninMeibo(entity);
        }
        return null;
    }

    /**
     * 選挙人名簿{@link SenkyoninMeibo}を保存します。
     *
     * @param 選挙人名簿 選挙人名簿
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(SenkyoninMeibo 選挙人名簿) {
        requireNonNull(選挙人名簿, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人名簿"));

        if (!選挙人名簿.hasChanged()) {
            return false;
        }
        選挙人名簿 = 選挙人名簿.modifiedModel();

        save選挙資格リスト(選挙資格Manager.get選挙資格リストBy主キー1(SenkyoShikakuMapperParameter.createSelectByKeyParam(Code.EMPTY, RString.EMPTY)));
        save投票状況リスト(投票状況Manager.get投票状況一覧());
        return 1 == 選挙人名簿Dac.insert(選挙人名簿.toEntity());
    }

    private void save選挙資格リスト(List<SenkyoShikaku> 選挙資格List) {
        for (SenkyoShikaku 選挙資格 : 選挙資格List) {
            選挙資格Manager.save(選挙資格);
        }
    }

    private void save投票状況リスト(List<TohyoJokyo> 投票状況List) {
        for (TohyoJokyo 投票状況 : 投票状況List) {
            投票状況Manager.save投票状況(投票状況);
        }
    }

    /**
     * 主キー1に合致する選挙人名簿のリストを返します。
     *
     * @param 選挙人名簿検索条件 選挙人名簿検索条件
     * @return 選挙人名簿人数
     */
    @Transaction
    public int get選挙人名簿人数(SenkyoninMeiboPsmMapperParameter 選挙人名簿検索条件) {
        requireNonNull(選挙人名簿検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人名簿検索条件"));
        ISenkyoninMeiboMapper mapper = mapperProvider.create(ISenkyoninMeiboMapper.class);

        return mapper.selectSenkyoninMeiboCount(選挙人名簿検索条件);
    }
}
