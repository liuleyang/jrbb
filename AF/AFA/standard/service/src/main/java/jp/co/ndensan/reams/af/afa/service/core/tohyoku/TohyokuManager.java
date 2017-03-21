/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tohyoku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.tohyoku.Tohyoku;
import jp.co.ndensan.reams.af.afa.business.core.tohyoku.UrTohyoku;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyoku.TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyoku.UrTohyokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT501TohyokuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyoku.ITohyokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票区を管理するクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class TohyokuManager {

    private final AfT501TohyokuDac dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TohyokuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        dac = InstanceProvider.create(AfT501TohyokuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT501TohyokuDac}
     */
    public TohyokuManager(AfT501TohyokuDac dac) {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyokuManager}のインスタンス
     */
    public static TohyokuManager createInstance() {
        return InstanceProvider.create(TohyokuManager.class);
    }

    /**
     * 投票区種別コードリストに合致する投票区を返します。
     *
     * @param 選挙種類 選挙種類
     * @return Tohyoku
     */
    @Transaction
    public List<Tohyoku> get投票区By選挙種類(Code 選挙種類) {
        requireNonNull選挙種類(選挙種類);

        List<AfT501TohyokuEntity> entityList = dac.select(選挙種類);
        if (entityList.isEmpty()) {
            return null;
        }

        List<Tohyoku> tohyokuList = new ArrayList<>();
        for (AfT501TohyokuEntity entity : entityList) {
            entity.initializeMd5();
            tohyokuList.add(new Tohyoku(entity));
        }
        return tohyokuList;
    }

    /**
     * 選挙種類,投票区に合致するリストの投票区名を返します。
     *
     * @param 選挙種類 選挙種類
     * @param 投票区 RString
     * @return RString
     */
    @Transaction
    public RString get投票区名(Code 選挙種類, RString 投票区) {
        requireNonNull選挙種類(選挙種類);
        requireNonNull投票区(投票区);

        AfT501TohyokuEntity entity = dac.select(選挙種類, 投票区);
        if (null == entity || null == entity.getTohyokuName()) {
            return RString.EMPTY;
        }

        return entity.getTohyokuName();
    }

    /**
     * 選挙種類に合致するリストの投票区FROM～投票区TO範囲のリストを返します。
     *
     * @param 選挙種類 選挙種類
     * @param 投票区From RString
     * @param 投票区To RString
     * @param 有効開始年月日 FlexibleDate
     * @return 投票区コード
     */
    @Transaction
    public List<RString> get全投票区(Code 選挙種類, RString 投票区From, RString 投票区To, FlexibleDate 有効開始年月日) {
        requireNonNull選挙種類(選挙種類);

        ITohyokuMapper mapper = mapperProvider.create(ITohyokuMapper.class);
        投票区From = null == 投票区From ? RString.EMPTY : 投票区From;
        投票区To = null == 投票区To ? RString.EMPTY : 投票区To;
        return mapper.select全投票区(選挙種類, 投票区From, 投票区To, 有効開始年月日);
    }

    /**
     * 選挙種類に合致するリストの投票区FROM～投票区TO範囲のリストを返します。
     *
     * @param 選挙種類 選挙種類
     * @param 投票区From RString
     * @param 投票区To RString
     * @return Tohyoku
     */
    @Transaction
    public List<Tohyoku> get投票区(Code 選挙種類, RString 投票区From, RString 投票区To) {
        requireNonNull選挙種類(選挙種類);

        ITohyokuMapper mapper = mapperProvider.create(ITohyokuMapper.class);
        投票区From = null == 投票区From ? RString.EMPTY : 投票区From;
        投票区To = null == 投票区To ? RString.EMPTY : 投票区To;
        List<TohyokuEntity> entityList = mapper.select投票区(選挙種類, 投票区From, 投票区To);
        if (entityList.isEmpty()) {
            return null;
        }

        List<Tohyoku> tohyokuList = new ArrayList<>();
        for (TohyokuEntity entity : entityList) {
            entity.initializeMd5ToEntities();
            tohyokuList.add(new Tohyoku(entity));
        }
        return tohyokuList;
    }

    /**
     * 選挙種類に合致するリストの投票区FROM～投票区TO範囲のリストを返します。
     *
     * @param 選挙種類 選挙種類
     * @param 投票区From RString
     * @param 投票区To RString
     * @param 有効開始年月日 FlexibleDate
     * @return Tohyoku
     */
    @Transaction
    public List<UrTohyoku> getUR投票区(Code 選挙種類, RString 投票区From, RString 投票区To, FlexibleDate 有効開始年月日) {
        requireNonNull選挙種類(選挙種類);
        requireNonNull有効開始年月日(有効開始年月日);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 地方公共団体コード = association.get地方公共団体コード().value();
        int 連番 = association.getLasdecCodeRenban_();

        ITohyokuMapper mapper = mapperProvider.create(ITohyokuMapper.class);
        投票区From = null == 投票区From ? RString.EMPTY : 投票区From;
        投票区To = null == 投票区To ? RString.EMPTY : 投票区To;
        List<UrTohyokuEntity> entityList = mapper.selectUR投票区(選挙種類, 投票区From, 投票区To, 地方公共団体コード, 連番, 有効開始年月日);
        if (entityList.isEmpty()) {
            return null;
        }

        List<UrTohyoku> tohyokuList = new ArrayList<>();
        for (UrTohyokuEntity entity : entityList) {
            entity.initializeMd5ToEntities();
            tohyokuList.add(new UrTohyoku(entity));
        }
        return tohyokuList;
    }

    /**
     * 投票区{@link Tohyoku}を保存します。
     *
     * @param 投票区 {@link Tohyoku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save投票区(Tohyoku 投票区) {
        requireNonNull投票区(投票区);
        if (!投票区.hasChanged()) {
            return false;
        }
        return 1 == dac.save(投票区.toEntity());
    }

    private void requireNonNull投票区(Tohyoku 投票区) {
        requireNonNull(投票区, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区"));
    }

    private void requireNonNull投票区(RString 投票区) {
        requireNonNull(投票区, UrSystemErrorMessages.値がnull.getReplacedMessage("投票区"));
    }

    private void requireNonNull選挙種類(Code 選挙種類) {
        requireNonNull(選挙種類, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類"));
    }

    private void requireNonNull有効開始年月日(FlexibleDate 有効開始年月日) {
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
    }
}
