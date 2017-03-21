/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kaikusenkyojohoshusei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.KaikuTaishoShohonJohoData;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * AFAGMK1050 海区漁業調整委員会委員選挙選挙情報修正Manager <br />
 *
 * @reamsid_L AF-0490-010 lis
 */
public class KaikuSenkyoJohoShuseiManager {

    private final AfT100ShohonDac 抄本Dac;
    private final AfT111SenkyoDac 選挙Dac;

    /**
     * コンストラクタです。
     */
    KaikuSenkyoJohoShuseiManager() {
        抄本Dac = InstanceProvider.create(AfT100ShohonDac.class);
        選挙Dac = InstanceProvider.create(AfT111SenkyoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaikuNewMeiBoSenkyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaikuNewMeiBoSenkyoManager}のインスタンス
     */
    public static KaikuSenkyoJohoShuseiManager createInstance() {
        return InstanceProvider.create(KaikuSenkyoJohoShuseiManager.class);
    }

    /**
     * 抄本選挙情報{@link Shohon}を更新します。
     *
     * @param 抄本選挙情報 抄本選挙情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean update抄本選挙情報(KaikuTaishoShohonJohoData 抄本選挙情報) {
        requireNonNull(抄本選挙情報, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本情報"));
        AfT100ShohonEntity shohonEntity = 抄本選挙情報.getAft100Entity();
        AfT111SenkyoEntity senkyoEntity = 抄本選挙情報.getAft111Entity();
        shohonEntity.setState(EntityDataState.Modified);
        senkyoEntity.setState(EntityDataState.Modified);
        return 1 == 抄本Dac.save(shohonEntity) && 1 == 選挙Dac.save(senkyoEntity);
    }
}
