/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.shohon.shohon;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.SimulationMenuId;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shohon.shohon.ShohonEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.shohon.IShohonMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 抄本を管理するクラスです。
 */
public class ShohonManager {

    private final AfaMapperProvider mapperProvider;
    private final AfT100ShohonDac 抄本Dac;
    private final SenkyoManager 選挙Manager;
    private final TohyoJokyoManager 投票状況Manager;

    /**
     * コンストラクタです。
     */
    ShohonManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.抄本Dac = InstanceProvider.create(AfT100ShohonDac.class);
        this.選挙Manager = InstanceProvider.create(SenkyoManager.class);
        this.投票状況Manager = InstanceProvider.create(TohyoJokyoManager.class);

    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 抄本Dac 抄本Dac
     * @param 選挙Manager 選挙Manager
     */
    ShohonManager(
            AfaMapperProvider mapperProvider,
            AfT100ShohonDac 抄本Dac,
            SenkyoManager 選挙Manager,
            TohyoJokyoManager 投票状況Manager) {
        this.mapperProvider = mapperProvider;
        this.抄本Dac = 抄本Dac;
        this.選挙Manager = 選挙Manager;
        this.投票状況Manager = 投票状況Manager;
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
     * @param 抄本番号 ShohonNo
     * @return Shohon nullが返る可能性があります。
     */
    @Transaction
    public Shohon get抄本(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本検索条件"));
        IShohonMapper mapper = mapperProvider.create(IShohonMapper.class);

        ShohonEntity relateEntity = mapper.select抄本By番号(抄本番号);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        ShohonEntity shohonEntity = new ShohonEntity();
        shohonEntity.set抄本Entity(relateEntity.get抄本Entity());
        shohonEntity.set選挙Entity(relateEntity.get選挙Entity());
        return new Shohon(shohonEntity);
    }

    /**
     * 主キーに合致する抄本を返します。
     *
     * @return List<Shohon> nullが返る可能性があります。
     */
    @Transaction
    public List<Shohon> get抄本By定時登録() {
        List<AfT100ShohonEntity> afT100ShohonEntityList = 抄本Dac.select(new Code(SenkyoShurui.定時登録.getCode()));
        if (afT100ShohonEntityList == null) {
            return null;
        }
        List<Shohon> shohonList = new ArrayList<>();
        for (AfT100ShohonEntity afT100ShohonEntity : afT100ShohonEntityList) {
            ShohonEntity shohonEntity = new ShohonEntity();
            shohonEntity.set抄本Entity(afT100ShohonEntity);
            shohonList.add(new Shohon(shohonEntity));
        }
        return shohonList;
    }

    /**
     * 選挙登録有無チェック結果を返します。
     *
     * @return boolean
     */
    @Transaction
    public boolean 選挙登録有無チェック() {
        List<AfT100ShohonEntity> afT100ShohonEntityList = 抄本Dac.selectFor選挙登録有無チェック();
        return afT100ShohonEntityList == null;
    }

    /**
     * 指定された選挙種類に該当する、抄本エンティティリストを取得します
     *
     * @param isシミュレーション Boolean
     * @param is過去分のみ Boolean
     * @param is過去分も含める Boolean
     * @param is海区 Boolean
     * @param 選挙時登録フラグ Boolean
     * @param isNotEq定時登録 Boolean
     * @param senkyoShurui RString
     * @param 名簿調製用連携の選挙種類List RString{@code list}
     * @return Shohon nullが返る可能性があります。
     */
    @Transaction
    public List<Shohon> get抄本(Boolean isシミュレーション,
            Boolean is過去分のみ,
            Boolean is過去分も含める,
            Boolean is海区,
            Boolean 選挙時登録フラグ,
            Boolean isNotEq定時登録,
            RString senkyoShurui,
            List<RString> 名簿調製用連携の選挙種類List) {

        FlexibleDate kijunYmd = FlexibleDate.getNowDate();
        IShohonMapper mapper = mapperProvider.create(IShohonMapper.class);
        List<AfT100ShohonEntity> afT100ShohonEntityList = mapper.select抄本DDL(isシミュレーション,
                is過去分のみ,
                is過去分も含める,
                is海区,
                選挙時登録フラグ,
                isNotEq定時登録,
                !RString.isNullOrEmpty(senkyoShurui),
                senkyoShurui,
                kijunYmd,
                名簿調製用連携の選挙種類List);

        List<Shohon> shohonList = new ArrayList<>();
        for (AfT100ShohonEntity afT100ShohonEntity : afT100ShohonEntityList) {
            ShohonEntity shohonEntity = new ShohonEntity();
            shohonEntity.set抄本Entity(afT100ShohonEntity);
            shohonList.add(new Shohon(shohonEntity));
        }
        return shohonList;
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
        save選挙リスト(選挙Manager.get選挙By抄本番号(抄本.get抄本番号()));
        return 1 == 抄本Dac.save(抄本.toEntity());
    }

    private void save選挙リスト(List<Senkyo> 選挙List) {
        for (Senkyo 選挙 : 選挙List) {
            選挙Manager.save選挙(選挙);
        }
    }

    /**
     * 最後定時登録を返します。
     *
     * @return FlexibleDate nullが返る可能性があります。
     */
    @Transaction
    public FlexibleDate get最後定時登録() {
        IShohonMapper mapper = mapperProvider.create(IShohonMapper.class);

        FlexibleDate 定時登録 = mapper.select最後定時登録(new SimulationMenuId().isSimulationMenuId(ResponseHolder.getMenuID()));
        if (定時登録 == null) {
            return null;
        }
        return 定時登録;
    }

    /**
     * 抄本{@link Shohon}を更新します。
     *
     * @param 抄本 Shohon
     * @param 選挙リスト List<Senkyo>
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean updateForSenkyoShusei(Shohon 抄本, List<Senkyo> 選挙リスト) {
        requireNonNull(抄本, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本"));
        requireNonNull(選挙リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙リスト"));

        抄本 = 抄本.modifiedModel();
        Boolean 抄本フラグ = Boolean.TRUE;
        if (1 != 抄本Dac.save(抄本.toEntity())) {
            抄本フラグ = Boolean.FALSE;
        }

        Boolean 選挙フラグ = Boolean.TRUE;
        List<SenkyoNo> 選挙番号リスト = new ArrayList<>();
        for (Senkyo 選挙 : 選挙リスト) {
            if (選挙.hasChanged()) {
                選挙フラグ = 選挙Manager.save選挙(選挙);
            }
            if (選挙フラグ && 選挙.is無投票選挙フラグ()) {
                選挙番号リスト.add(選挙.get選挙番号());
            }
        }
        Boolean 投票状況フラグ = Boolean.FALSE;
        if (!選挙番号リスト.isEmpty()) {
            if (投票状況Manager.delete投票状況By抄本選挙番号(抄本.get抄本番号(), 選挙番号リスト) >= 0) {
                投票状況フラグ = Boolean.TRUE;
            }
            return 抄本フラグ && 選挙フラグ && 投票状況フラグ;
        }

        return 抄本フラグ && 選挙フラグ;
    }

}
