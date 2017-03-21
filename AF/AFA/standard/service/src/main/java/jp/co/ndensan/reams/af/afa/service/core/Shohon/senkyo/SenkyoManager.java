/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙を管理するクラスです。
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public class SenkyoManager {

    private final AfT111SenkyoDac dac;
    private final RString 抄本番号RSr = new RString("抄本番号");

    /**
     * コンストラクタです。
     */
    public SenkyoManager() {
        dac = InstanceProvider.create(AfT111SenkyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT111SenkyoDac}
     */
    public SenkyoManager(AfT111SenkyoDac dac) {
        this.dac = dac;
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
     * 主キーに合致する抄本を返します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 SenkyoNo
     * @return Senkyo nullが返る可能性があります。
     */
    @Transaction
    public Senkyo get選挙(ShohonNo 抄本番号, SenkyoNo 選挙番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(抄本番号RSr.toString()));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));

        AfT111SenkyoEntity entity = dac.selectByKey(抄本番号, 選挙番号);

        if (entity == null) {
            return null;
        }
        return new Senkyo(entity);
    }

    /**
     * 抄本番号に合致する選挙リストを返します。
     *
     * @param 抄本番号 抄本番号
     * @return Senkyoリスト
     */
    @Transaction
    public List<Senkyo> get選挙By抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(抄本番号RSr.toString()));

        List<AfT111SenkyoEntity> entityList = dac.selectBy抄本番号(抄本番号);
        if (entityList.isEmpty()) {
            return null;
        }

        List<Senkyo> senkyoList = new ArrayList<>();
        for (AfT111SenkyoEntity entity : entityList) {
            entity.initializeMd5();
            senkyoList.add(new Senkyo(entity));
        }
        return senkyoList;
    }

    /**
     * 抄本番号に合致する選挙リストを返します。
     *
     * @param 抄本番号 抄本番号
     * @return Senkyoリスト
     */
    @Transaction
    public List<Senkyo> get有投票選挙選挙By抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(抄本番号RSr.toString()));

        List<AfT111SenkyoEntity> entityList = dac.selectBy抄本番号withOrder(抄本番号);
        if (entityList.isEmpty()) {
            return null;
        }

        List<Senkyo> senkyoList = new ArrayList<>();
        for (AfT111SenkyoEntity entity : entityList) {
            entity.initializeMd5();
            senkyoList.add(new Senkyo(entity));
        }
        return senkyoList;
    }

    /**
     * 選挙{@link Senkyo}を保存します。
     *
     * @param 選挙 {@link Senkyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save選挙(Senkyo 選挙) {
        requireNonNull(選挙, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙"));
        if (!選挙.hasChanged()) {
            return false;
        }
        return 1 == dac.save(選挙.toEntity());
    }

    /**
     * 抄本番号、選挙レベルと基準日に合致する選挙を返します。
     *
     * @param 抄本番号 Shohon
     * @param 選挙レベル Code
     * @param 基準日 RDate
     * @return Senkyo
     */
    @Transaction
    public List<Senkyo> get選挙By抄本番号と選挙レベルと基準日(ShohonNo 抄本番号, Code 選挙レベル, FlexibleDate 基準日) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(抄本番号RSr.toString()));
        requireNonNull(選挙レベル, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙レベル"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));

        List<AfT111SenkyoEntity> entityList = dac.selectBy抄本番号と選挙レベルと基準日(抄本番号, 選挙レベル, 基準日);
        if (entityList.isEmpty()) {
            return null;
        }

        List<Senkyo> senkyoList = new ArrayList<>();
        for (AfT111SenkyoEntity entity : entityList) {
            entity.initializeMd5();
            senkyoList.add(new Senkyo(entity));
        }
        return senkyoList;
    }

    /**
     * 主キーに合致する抄本を返します。
     *
     * @return Senkyo nullが返る可能性があります。
     */
    @Transaction
    public List<Senkyo> get抄本() {

        List<AfT111SenkyoEntity> entityList = dac.select最新抄本();
        if (entityList.isEmpty()) {
            return null;
        }
        List<Senkyo> senkyoList = new ArrayList<>();
        for (AfT111SenkyoEntity entity : entityList) {
            entity.initializeMd5();
            senkyoList.add(new Senkyo(entity));
        }
        return senkyoList;
    }

    /**
     * 取得したMIN(名簿基準年月日）より、行の最小値を取得する。
     *
     * @param 抄本番号 ShohonNo
     * @return Senkyo nullが返る可能性があります。
     */
    @Transaction
    public Senkyo get最小名簿基準年月日(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(抄本番号RSr.toString()));
        AfT111SenkyoEntity entity = dac.selectMinKijunYMDByShohonNo(抄本番号);

        if (entity == null) {
            return null;
        }
        return new Senkyo(entity);
    }
}
