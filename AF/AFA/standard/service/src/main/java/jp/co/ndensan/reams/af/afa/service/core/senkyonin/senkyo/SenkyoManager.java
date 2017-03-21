/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyo.SenkyoMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo.SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin.ISenkyoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙を管理するクラスです。
 */
public class SenkyoManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT111SenkyoDac 選挙Dac;
    private final TohyoJokyoManager 投票状況Manager;

    /**
     * コンストラクタです。
     */
    SenkyoManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.選挙Dac = InstanceProvider.create(AfT111SenkyoDac.class);
        this.投票状況Manager = new TohyoJokyoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 選挙Dac 選挙Dac
     * @param 投票状況Manager 投票状況Manager
     */
    SenkyoManager(
            AfaMapperProvider mapperProvider,
            AfT111SenkyoDac 選挙Dac,
            TohyoJokyoManager 投票状況Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.選挙Dac = 選挙Dac;
        this.投票状況Manager = 投票状況Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyoManager}のインスタンス
     */
    public static SenkyoManager createInstance() {
        return InstanceProvider.create(SenkyoManager.class);
    }

    /**
     * 主キーに合致する選挙を返します。
     *
     * @param 選挙検索条件 選挙検索条件
     * @return Senkyo nullが返る可能性があります。
     */
    @Transaction
    public Senkyo get選挙(SenkyoMapperParameter 選挙検索条件) {
        requireNonNull(選挙検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙検索条件"));
        ISenkyoMapper mapper = mapperProvider.create(ISenkyoMapper.class);

        SenkyoEntity relateEntity = mapper.select選挙ByKey(選挙検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        SenkyoEntity senkyoEntity = new SenkyoEntity();
        senkyoEntity.set投票状況Entity(relateEntity.get投票状況Entity());
        senkyoEntity.set選挙Entity(relateEntity.get選挙Entity());

        return new Senkyo(senkyoEntity);
    }

    /**
     * 主キー1に合致する選挙のリストを返します。
     *
     * @param 選挙検索条件 選挙検索条件
     * @return Senkyoの{@code list}
     */
    @Transaction
    public List<Senkyo> get選挙リストBy主キー1(SenkyoMapperParameter 選挙検索条件) {
        requireNonNull(選挙検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙検索条件"));
        ISenkyoMapper mapper = mapperProvider.create(ISenkyoMapper.class);

        List<SenkyoEntity> relateEntityList = mapper.select選挙リストBy主キー1(選挙検索条件);

        ArrayList<Senkyo> 選挙List = new ArrayList<>();
        for (SenkyoEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            選挙List.add(new Senkyo(relateEntity));
        }
        return 選挙List;

    }

    /**
     * 選挙{@link Senkyo}を保存します。
     *
     * @param 選挙 選挙
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(Senkyo 選挙) {
        requireNonNull(選挙, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙"));

        if (!選挙.hasChanged()) {
            return false;
        }
        選挙 = 選挙.modifiedModel();
        save投票状況リスト(投票状況Manager.get投票状況一覧());
        return 1 == 選挙Dac.save(選挙.toEntity());
    }

    private void save投票状況リスト(List<TohyoJokyo> 投票状況List) {
        for (TohyoJokyo 投票状況 : 投票状況List) {
            投票状況Manager.save投票状況(投票状況);
        }
    }
}
