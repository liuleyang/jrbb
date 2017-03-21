/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tohyokekkashukeisakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tohyokekkashukeisakusei.SenkyoJoho;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT111SenkyoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 選挙情報を管理するクラスです。
 * @reamsid_L AF-0290-011 wangxt2
 */
public class TohyoKekkaShukeiSakuseiManager {

    private final AfT111SenkyoDac afT111SenkyoDac;

    /**
     * コンストラクタです。
     */
    public TohyoKekkaShukeiSakuseiManager() {
        afT111SenkyoDac = InstanceProvider.create(AfT111SenkyoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param afT111SenkyoDac AfT111SenkyoDac
     */
    TohyoKekkaShukeiSakuseiManager(AfT111SenkyoDac afT111SenkyoDac) {
        this.afT111SenkyoDac = afT111SenkyoDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyoKekkaShukeiSakuseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyoKekkaShukeiSakuseiManager}のインスタンス
     */
    public static TohyoKekkaShukeiSakuseiManager createInstance() {
        return InstanceProvider.create(TohyoKekkaShukeiSakuseiManager.class);
    }

    /**
     * 選挙情報リストを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return 選挙情報リスト
     */
    public List<SenkyoJoho> getSenkyoJoho(ShohonNo 抄本番号) {
        List<AfT111SenkyoEntity> entityList = afT111SenkyoDac.selectBy抄本番号withOrder(抄本番号);
        if (entityList.isEmpty()) {
            return null;
        }
        List<SenkyoJoho> senkyoJohoList = new ArrayList<>();
        for (AfT111SenkyoEntity entity : entityList) {
            entity.initializeMd5();
            senkyoJohoList.add(new SenkyoJoho(entity));
        }
        return senkyoJohoList;
    }

    /**
     * 選挙情報リストを取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return 選挙情報リスト
     */
    public List<SenkyoJoho> getSenkyoJohoWithFlag(ShohonNo 抄本番号) {
        List<AfT111SenkyoEntity> entityList = afT111SenkyoDac.selectBy抄本番号と無投票選挙フラグwithOrder(抄本番号);
        if (entityList.isEmpty()) {
            return null;
        }
        List<SenkyoJoho> senkyoJohoList = new ArrayList<>();
        for (AfT111SenkyoEntity entity : entityList) {
            entity.initializeMd5();
            senkyoJohoList.add(new SenkyoJoho(entity));
        }
        return senkyoJohoList;
    }
}
