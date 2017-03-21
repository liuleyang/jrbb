/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.jushojokenselect;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.Chiku1ConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.Chiku2ConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.Chiku3ConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.GyoseikuConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.JushoConditionResult;
import jp.co.ndensan.reams.af.afa.business.core.jushojokenselect.TohyokuConditionResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT143GyoseikuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT145Chiku1ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT146Chiku2ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT147Chiku3ConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT142TohyokuConditionDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT143GyoseikuConditionDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT144JushoConditionDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT145Chiku1ConditionDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT146Chiku2ConditionDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT147Chiku3ConditionDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT501TohyokuDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.AssociationKey;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.chikubunrui1.ChikuBunrui1;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.chikubunrui2.ChikuBunrui2;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.chikubunrui3.ChikuBunrui3;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.gyoseiku.Gyoseiku;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.choiki.ChoikiItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.chikubunrui1.ChikuBunrui1FinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.chikubunrui1.IChikuBunrui1Finder;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.chikubunrui2.ChikuBunrui2FinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.chikubunrui2.IChikuBunrui2Finder;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.chikubunrui3.ChikuBunrui3FinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.chikubunrui3.IChikuBunrui3Finder;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.gyoseiku.GyoseikuFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.gyoseiku.IGyoseikuFinder;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.tohyoku.ITohyokuFinder;
import jp.co.ndensan.reams.ur.urz.service.core.chiku.tohyoku.TohyokuFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.jusho.choiki.ChoikiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.jusho.choiki.IChoikiManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住所条件選択の取得
 *
 * @reamsid_L AF-0450-011 jihb
 */
public class JushoJokenSelectManager {

    private final AfT142TohyokuConditionDac 投票区抽出条件dac;
    private final AfT143GyoseikuConditionDac 行政区抽出条件dac;
    private final AfT144JushoConditionDac 住所抽出条件dac;
    private final AfT145Chiku1ConditionDac 地区1抽出条件dac;
    private final AfT146Chiku2ConditionDac 地区2抽出条件dac;
    private final AfT147Chiku3ConditionDac 地区3抽出条件dac;
    private final AfT501TohyokuDac aFT投票区dac;
    private final ITohyokuFinder 投票区Finder;
    private final IGyoseikuFinder 行政区Finder;
    private final IChoikiManager 町域Manager;
    private final IChikuBunrui1Finder 地区1Finder;
    private final IChikuBunrui2Finder 地区2Finder;
    private final IChikuBunrui3Finder 地区3Finder;
    private final Association association;
    private final RString msg選挙種類 = new RString("選挙種類");

    /**
     * コンストラクタです。
     */
    public JushoJokenSelectManager() {
        this.投票区抽出条件dac = InstanceProvider.create(AfT142TohyokuConditionDac.class);
        this.行政区抽出条件dac = InstanceProvider.create(AfT143GyoseikuConditionDac.class);
        this.住所抽出条件dac = InstanceProvider.create(AfT144JushoConditionDac.class);
        this.地区1抽出条件dac = InstanceProvider.create(AfT145Chiku1ConditionDac.class);
        this.地区2抽出条件dac = InstanceProvider.create(AfT146Chiku2ConditionDac.class);
        this.地区3抽出条件dac = InstanceProvider.create(AfT147Chiku3ConditionDac.class);
        this.aFT投票区dac = InstanceProvider.create(AfT501TohyokuDac.class);
        this.投票区Finder = TohyokuFinderFactory.createInstance();
        this.行政区Finder = GyoseikuFinderFactory.createInstance();
        this.町域Manager = ChoikiManagerFactory.createInstance();
        this.地区1Finder = ChikuBunrui1FinderFactory.createInstance();
        this.地区2Finder = ChikuBunrui2FinderFactory.createInstance();
        this.地区3Finder = ChikuBunrui3FinderFactory.createInstance();
        this.association = AssociationFinderFactory.createInstance().getAssociation();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JushoJokenSelectManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JushoJokenSelectManager}のインスタンス
     */
    public static JushoJokenSelectManager createInstance() {
        return InstanceProvider.create(JushoJokenSelectManager.class);
    }

    /**
     * 抄本番号に合致する投票区抽出条件を返します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return TohyokuConditionResult nullが返る可能性があります。
     */
    @Transaction
    public List<TohyokuConditionResult> get投票区抽出条件(ShohonNo 抄本番号) {

        List<TohyokuConditionResult> resultList = new ArrayList();
        if (抄本番号 == null) {
            return resultList;
        }

        List<AfT142TohyokuConditionEntity> entityList = 投票区抽出条件dac.selectListByShohonNo(抄本番号);

        for (AfT142TohyokuConditionEntity entity : entityList) {
            resultList.add(new TohyokuConditionResult(entity));
        }
        return resultList;
    }

    /**
     * 抄本番号に合致する行政区抽出条件を返します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return GyoseikuConditionResult nullが返る可能性があります。
     */
    @Transaction
    public List<GyoseikuConditionResult> get行政区抽出条件(ShohonNo 抄本番号) {
        List<GyoseikuConditionResult> resultList = new ArrayList();
        if (抄本番号 == null) {
            return resultList;
        }

        List<AfT143GyoseikuConditionEntity> entityList = 行政区抽出条件dac.selectListByShohonNo(抄本番号);

        for (AfT143GyoseikuConditionEntity entity : entityList) {
            resultList.add(new GyoseikuConditionResult(entity));
        }
        return resultList;
    }

    /**
     * 抄本番号に合致する住所抽出条件を返します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return JushoConditionResult nullが返る可能性があります。
     */
    @Transaction
    public List<JushoConditionResult> get住所抽出条件(ShohonNo 抄本番号) {
        List<JushoConditionResult> resultList = new ArrayList();
        if (抄本番号 == null) {
            return resultList;
        }

        List<AfT144JushoConditionEntity> entityList = 住所抽出条件dac.selectListByShohonNo(抄本番号);

        for (AfT144JushoConditionEntity entity : entityList) {
            resultList.add(new JushoConditionResult(entity));
        }
        return resultList;
    }

    /**
     * 抄本番号に合致する地区1抽出条件を返します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return Chiku1ConditionResult nullが返る可能性があります。
     */
    @Transaction
    public List<Chiku1ConditionResult> get地区1抽出条件(ShohonNo 抄本番号) {

        List<Chiku1ConditionResult> resultList = new ArrayList();
        if (抄本番号 == null) {
            return resultList;
        }

        List<AfT145Chiku1ConditionEntity> entityList = 地区1抽出条件dac.selectListByShohonNo(抄本番号);

        for (AfT145Chiku1ConditionEntity entity : entityList) {
            resultList.add(new Chiku1ConditionResult(entity));
        }
        return resultList;
    }

    /**
     * 抄本番号に合致する地区2抽出条件を返します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return Chiku2ConditionResult nullが返る可能性があります。
     */
    @Transaction
    public List<Chiku2ConditionResult> get地区2抽出条件(ShohonNo 抄本番号) {
        List<Chiku2ConditionResult> resultList = new ArrayList();
        if (抄本番号 == null) {
            return resultList;
        }

        List<AfT146Chiku2ConditionEntity> entityList = 地区2抽出条件dac.selectListByShohonNo(抄本番号);

        for (AfT146Chiku2ConditionEntity entity : entityList) {
            resultList.add(new Chiku2ConditionResult(entity));
        }
        return resultList;
    }

    /**
     * 抄本番号に合致する地区3抽出条件を返します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return Chiku3ConditionResult nullが返る可能性があります。
     */
    @Transaction
    public List<Chiku3ConditionResult> get地区3抽出条件(ShohonNo 抄本番号) {

        List<Chiku3ConditionResult> resultList = new ArrayList();
        if (抄本番号 == null) {
            return resultList;
        }

        List<AfT147Chiku3ConditionEntity> entityList = 地区3抽出条件dac.selectListByShohonNo(抄本番号);

        for (AfT147Chiku3ConditionEntity entity : entityList) {
            resultList.add(new Chiku3ConditionResult(entity));
        }
        return resultList;
    }

    /**
     * 投票区種別コードリストに合致する投票区を返します。
     *
     * @param 選挙種類 Code
     * @return 投票区情報 List<jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku>
     */
    @Transaction
    public List<jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku> getAFT投票区情報(Code 選挙種類) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage(msg選挙種類.toString()));
        List<AfT501TohyokuEntity> 投票区情報 = aFT投票区dac.select(選挙種類);
        if (投票区情報.isEmpty()) {
            return null;
        }

        List<jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku> tohyokuList = new ArrayList<>();
        for (AfT501TohyokuEntity entity : 投票区情報) {
            entity.initializeMd5();
            tohyokuList.add(new jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku(entity));
        }
        return tohyokuList;
    }

    /**
     * 投票区情報を返します。
     *
     *
     * @return List<Tohyoku> 投票区情報。
     */
    @Transaction
    public List<Tohyoku> getURT投票区情報() {
        List<Tohyoku> 投票区情報 = 投票区Finder.get投票区by地方公共団体and基準日(
                new AssociationKey(association.get地方公共団体コード(), association.get連番()), FlexibleDate.getNowDate());
        return 投票区情報;
    }

    /**
     * 行政区情報を返します。
     *
     *
     * @return List<Gyoseiku> 行政区情報。
     */
    @Transaction
    public List<Gyoseiku> get行政区情報() {
        List<Gyoseiku> 行政区情報 = 行政区Finder.get行政区一覧by地方公共団体and基準日(
                new AssociationKey(association.get地方公共団体コード(), association.get連番()), FlexibleDate.getNowDate());
        return 行政区情報;
    }

    /**
     * 住所情報を返します。
     *
     *
     * @return List<ChoikiItem> 住所情報。
     */
    @Transaction
    public List<ChoikiItem> get住所情報() {

        List<ChoikiItem> 住所情報 = 町域Manager.get町域一覧by地方公共団体(
                new AssociationKey(association.get地方公共団体コード(), association.get連番()));

        return 住所情報;
    }

    /**
     * 地区1情報を返します。
     *
     *
     * @return List<ChikuBunrui1> 地区1情報。
     */
    @Transaction
    public List<ChikuBunrui1> get地区1情報() {
        List<ChikuBunrui1> 地区1情報 = 地区1Finder.get地区分類１by地方公共団体and基準日(
                new AssociationKey(association.get地方公共団体コード(), association.get連番()), FlexibleDate.getNowDate());

        return 地区1情報;
    }

    /**
     * 地区2情報を返します。
     *
     *
     * @return List<ChikuBunrui2> 地区2情報。
     */
    @Transaction
    public List<ChikuBunrui2> get地区2情報() {
        List<ChikuBunrui2> 地区2情報 = 地区2Finder.get地区分類２by地方公共団体and基準日(
                new AssociationKey(association.get地方公共団体コード(), association.get連番()), FlexibleDate.getNowDate());

        return 地区2情報;
    }

    /**
     * 地区3情報を返します。
     *
     *
     * @return List<ChikuBunrui3> 地区3情報。
     */
    @Transaction
    public List<ChikuBunrui3> get地区3情報() {
        List<ChikuBunrui3> 地区3情報 = 地区3Finder.get地区分類３by地方公共団体and基準日(
                new AssociationKey(association.get地方公共団体コード(), association.get連番()), FlexibleDate.getNowDate());

        return 地区3情報;
    }

}
