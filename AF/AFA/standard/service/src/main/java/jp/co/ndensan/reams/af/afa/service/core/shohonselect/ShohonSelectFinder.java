/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.shohonselect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.SenkyoResult;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 抄本選択共有子div用ファインダークラスです。
 *
 * @reamsid_L AF-0160-011 guyq
 */
public class ShohonSelectFinder {

    private final AfT111SenkyoDac afT111SenkyoDac;
    private final AfT100ShohonDac afT100ShohonDac;

    /**
     * コンストラクタです。
     */
    public ShohonSelectFinder() {
        afT111SenkyoDac = InstanceProvider.create(AfT111SenkyoDac.class);
        afT100ShohonDac = InstanceProvider.create(AfT100ShohonDac.class);

    }

    ShohonSelectFinder(AfT111SenkyoDac afT111SenkyoDac, AfT100ShohonDac afT100ShohonDac) {
        this.afT111SenkyoDac = afT111SenkyoDac;
        this.afT100ShohonDac = afT100ShohonDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShohonSelectFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShohonSelectFinder}のインスタンス
     */
    public static ShohonSelectFinder createInstance() {
        return InstanceProvider.create(ShohonSelectFinder.class);
    }

    /**
     * 抄本番号と識別コードで在外選挙人名簿を取得します。
     *
     * @param shohonNo ShohonNo
     * @return 外選挙人名簿リスト
     */
    public List<SenkyoResult> getBy抄本番号(ShohonNo shohonNo) {

        List<AfT111SenkyoEntity> entityList = afT111SenkyoDac.selectBy抄本番号(shohonNo);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<SenkyoResult> resultList = new ArrayList<>();
        for (AfT111SenkyoEntity entity : entityList) {
            resultList.add(new SenkyoResult(entity));
        }
        return resultList;
    }

    /**
     * 抄本番号で抄本を取得します。
     *
     * @param shohonNo ShohonNo
     * @return 外選挙人名簿リスト
     */
    public ShohonResult getByShohonNo(ShohonNo shohonNo) {

        AfT100ShohonEntity entity = afT100ShohonDac.select(shohonNo);
        if (entity == null) {
            return null;
        }

        return new ShohonResult(entity);
    }

}
