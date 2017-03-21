/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.shohon;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoshikaku.SenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyo.SenkyoMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoninmeibo.SenkyoninMeiboMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoshikaku.SenkyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.shohon.ShohonMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.shohon.ShohonEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin.IShohonMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyo.SenkyoManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoshikaku.SenkyoShikakuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 抄本を管理するクラスです。
 */
public class ShohonManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT100ShohonDac 抄本Dac;
    private final SenkyoManager 選挙Manager;
    private final SenkyoninMeiboManager 選挙人名簿Manager;
    private final SenkyoShikakuManager 選挙資格Manager;

    /**
     * コンストラクタです。
     */
    ShohonManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.抄本Dac = InstanceProvider.create(AfT100ShohonDac.class);
        this.選挙Manager = InstanceProvider.create(SenkyoManager.class);
        this.選挙人名簿Manager = InstanceProvider.create(SenkyoninMeiboManager.class);
        this.選挙資格Manager = InstanceProvider.create(SenkyoShikakuManager.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 抄本Dac 抄本Dac
     * @param 選挙Manager 選挙Manager
     * @param 選挙人名簿Manager 選挙人名簿Manager
     * @param 選挙資格Manager 選挙資格Manager
     */
    ShohonManager(
            AfaMapperProvider mapperProvider,
            AfT100ShohonDac 抄本Dac,
            SenkyoManager 選挙Manager,
            SenkyoninMeiboManager 選挙人名簿Manager,
            SenkyoShikakuManager 選挙資格Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.抄本Dac = 抄本Dac;
        this.選挙Manager = 選挙Manager;
        this.選挙人名簿Manager = 選挙人名簿Manager;
        this.選挙資格Manager = 選挙資格Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShohonManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShohonManager}のインスタンス
     */
    public static ShohonManager createInstance() {
        return InstanceProvider.create(ShohonManager.class);
    }

    /**
     * 主キーに合致する抄本を返します。
     *
     * @param 抄本検索条件 抄本検索条件
     * @return Shohon nullが返る可能性があります。
     */
    @Transaction
    public Shohon get抄本(ShohonMapperParameter 抄本検索条件) {
        requireNonNull(抄本検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本検索条件"));
        IShohonMapper mapper = mapperProvider.create(IShohonMapper.class);

        ShohonEntity relateEntity = mapper.select抄本ByKey(抄本検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        ShohonEntity shohonEntity = new ShohonEntity();
        shohonEntity.set抄本Entity(relateEntity.get抄本Entity());
        shohonEntity.set選挙Entity(relateEntity.get選挙Entity());
        shohonEntity.set選挙人名簿Entity(relateEntity.get選挙人名簿Entity());
        shohonEntity.set選挙資格Entity(relateEntity.get選挙資格Entity());
        return new Shohon(shohonEntity);
    }

    /**
     * 主キー1に合致する抄本のリストを返します。
     *
     * @param 抄本検索条件 抄本検索条件
     * @return Shohonの{@code list}
     */
    @Transaction
    public List<Shohon> get抄本リストBy主キー1(ShohonMapperParameter 抄本検索条件) {
        requireNonNull(抄本検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本検索条件"));
        IShohonMapper mapper = mapperProvider.create(IShohonMapper.class);

        List<ShohonEntity> relateEntityList = mapper.select抄本リストBy主キー1(抄本検索条件);

        ArrayList<Shohon> 抄本List = new ArrayList<>();
        for (ShohonEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            抄本List.add(new Shohon(relateEntity));
        }
        return 抄本List;
    }

    /**
     * 抄本{@link Shohon}を保存します。
     *
     * @param 抄本 抄本
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(Shohon 抄本) {
        requireNonNull(抄本, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本"));

        if (!抄本.hasChanged()) {
            return false;
        }
        抄本 = 抄本.modifiedModel();
        save選挙リスト(選挙Manager.get選挙リストBy主キー1(SenkyoMapperParameter.createSelectByKeyParam(RString.EMPTY, RString.EMPTY)));
        SenkyoninMeiboMapperParameter 選挙人名簿検索条件 = SenkyoninMeiboMapperParameter.createSelectByKeyParam(抄本.get抄本番号(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, Integer.MIN_VALUE, Integer.MIN_VALUE, new BigSerial(0), null, true, 0, 0,
                true, false, false, false, false, false, false, false, false, false, false);
        save選挙人名簿リスト(選挙人名簿Manager.get選挙人名簿リストBy主キー1(選挙人名簿検索条件));
        save選挙資格リスト(選挙資格Manager.get選挙資格リストBy主キー1(SenkyoShikakuMapperParameter.createSelectListParam(Code.EMPTY)));
        save選挙リスト(選挙Manager.get選挙リストBy主キー1(SenkyoMapperParameter.createSelectByKeyParam(RString.EMPTY, RString.EMPTY)));
        return 1 == 抄本Dac.save(抄本.toEntity());
    }

    private void save選挙リスト(List<Senkyo> 選挙List) {
        for (Senkyo 選挙 : 選挙List) {
            選挙Manager.save(選挙);
        }
    }

    private void save選挙人名簿リスト(List<SenkyoninMeibo> 選挙人名簿List) {
        for (SenkyoninMeibo 選挙人名簿 : 選挙人名簿List) {
            選挙人名簿Manager.save(選挙人名簿);
        }
    }

    private void save選挙資格リスト(List<SenkyoShikaku> 選挙資格List) {
        for (SenkyoShikaku 選挙資格 : 選挙資格List) {
            選挙資格Manager.save(選挙資格);
        }
    }
}
