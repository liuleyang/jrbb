/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.reprintsenkyoji;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shohon.shohon.ShohonEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.reprintsenkyoji.IRePrintSenkyojiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録再発行のファインダーです。
 *
 * @reamsid_L AF-0060-010 liss
 */
public class RePrintSenkyojiFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    RePrintSenkyojiFinder() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);

    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static RePrintSenkyojiFinder createInstance() {
        return InstanceProvider.create(RePrintSenkyojiFinder.class);
    }

    /**
     * 選挙時登録抄本を返します。
     *
     * @return List<Shohon> 抄本List。
     */
    @Transaction
    public List<Shohon> get抄本() {
        IRePrintSenkyojiMapper mapper = mapperProvider.create(IRePrintSenkyojiMapper.class);
        List<AfT100ShohonEntity> 抄本List = mapper.selectShohonList();
        List<Shohon> shohonList = new ArrayList<>();
        for (AfT100ShohonEntity afT100ShohonEntity : 抄本List) {
            ShohonEntity shohonEntity = new ShohonEntity();
            shohonEntity.set抄本Entity(afT100ShohonEntity);
            shohonList.add(new Shohon(shohonEntity));
        }
        return shohonList;
    }

    /**
     * 抄本番号に合致する選挙リストを返します。
     *
     * @param 抄本番号 抄本番号
     * @return Senkyoリスト
     */
    @Transaction
    public List<Senkyo> get選挙By抄本番号(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        IRePrintSenkyojiMapper mapper = mapperProvider.create(IRePrintSenkyojiMapper.class);
        List<AfT111SenkyoEntity> entityList = mapper.selectSenkyoList(抄本番号);
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
}
