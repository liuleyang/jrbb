/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.shisetsu;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT507ShisetsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 施設を管理するクラスです。
 */
    public class ShisetsuManager {

    private final AfT507ShisetsuDac dac;

    /**
     * コンストラクタです。
     */
    public ShisetsuManager() {
        dac = InstanceProvider.create(AfT507ShisetsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT507ShisetsuDac}
     */
    public ShisetsuManager(AfT507ShisetsuDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShisetsuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShisetsuManager}のインスタンス
     */
    public static ShisetsuManager createInstance() {
        return InstanceProvider.create(ShisetsuManager.class);
    }

    /**
     * 施設コードに合致する施設を返します。
     *
     * @param 施設コード 施設コード
     * @return Shisetsu
     */
    @Transaction
    public Shisetsu get施設By施設コード(RString 施設コード) {
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));

        AfT507ShisetsuEntity entity = dac.select(施設コード);
        if (null == entity) {
            return null;
        }

        return new Shisetsu(entity);
    }

    /**
     * 施設コードに合致する施設を返します。
     *
     * @return Shisetsu
     */
    @Transaction
    public List<Shisetsu> get施設全件() {

        List<AfT507ShisetsuEntity> entitys = dac.select();
        if (entitys == null || entitys.isEmpty()) {
            return null;
        }
        List<Shisetsu> shisetsuList = new ArrayList<>();
        for (AfT507ShisetsuEntity entity : entitys) {
            entity.initializeMd5();
            shisetsuList.add(new Shisetsu(entity));
        }
        return shisetsuList;
    }

    /**
     * 施設種別コードリストに合致する施設を返します。
     *
     * @param 施設種別コードリスト 施設種別コードリスト
     * @return Shisetsu
     */
    @Transaction
    public List<Shisetsu> get施設By施設種別コードリスト(RString... 施設種別コードリスト) {
        requireNonNull(施設種別コードリスト, UrSystemErrorMessages.値がnull.getReplacedMessage("施設種別コードリスト"));

        List<AfT507ShisetsuEntity> entityList = dac.selectBy施設種別コードリスト(施設種別コードリスト);
        if (entityList.isEmpty()) {
            return null;
        }

        List<Shisetsu> shisetsuList = new ArrayList<>();
        for (AfT507ShisetsuEntity entity : entityList) {
            entity.initializeMd5();
            shisetsuList.add(new Shisetsu(entity));
        }
        return shisetsuList;
    }

    /**
     * 選挙{@link Shisetsu}を保存します。
     *
     * @param 施設 {@link Shisetsu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save施設(Shisetsu 施設) {
        requireNonNull(施設, UrSystemErrorMessages.値がnull.getReplacedMessage("施設"));
        if (!施設.hasChanged()) {
            return false;
        }
        return 1 == dac.save(施設.toEntity());
    }
}
