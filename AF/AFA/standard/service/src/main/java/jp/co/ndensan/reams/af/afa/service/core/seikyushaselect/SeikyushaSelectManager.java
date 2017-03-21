/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.seikyushaselect;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.seikyushaselect.SeikyushaSelectGamenData;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT401ChokusetsuSeikyuDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 請求代表者選択
 *
 * @reamsid_L AF-0140-020 wangh
 */
public class SeikyushaSelectManager {

    private final AfT401ChokusetsuSeikyuDac dac;

    /**
     * コンストラクタです。
     */
    public SeikyushaSelectManager() {
        this.dac = InstanceProvider.create(AfT401ChokusetsuSeikyuDac.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeikyushaSelectManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SeikyushaSelectManager}のインスタンス
     */
    public static SeikyushaSelectManager createInstance() {
        return InstanceProvider.create(SeikyushaSelectManager.class);
    }

    /**
     * 指定されたキーに該当する、直接請求一覧データを取得します。
     *
     * @return 請求代表者一覧データ List<SeikyushaSelectGamenData>
     */
    @Transaction
    public List<SeikyushaSelectGamenData> get直接請求一覧データ() {

        List<SeikyushaSelectGamenData> 請求代表者List = new ArrayList();
        List<AfT401ChokusetsuSeikyuEntity> 検索結果List = dac.selectAll();

        for (AfT401ChokusetsuSeikyuEntity 検索結果 : 検索結果List) {
            SeikyushaSelectGamenData 請求代表者 = new SeikyushaSelectGamenData(検索結果);
            請求代表者List.add(請求代表者);
        }

        return 請求代表者List;
    }

    /**
     * 指定されたキーに該当する、直接請求データを取得します。
     *
     * @param 直接請求番号 int
     * @return 直接請求データ AfT401ChokusetsuSeikyuEntity
     */
    @Transaction
    public AfT401ChokusetsuSeikyuEntity get直接請求データ(int 直接請求番号) {

        AfT401ChokusetsuSeikyuEntity 検索結果 = dac.select(直接請求番号);

        return 検索結果;
    }

    /**
     * 指定されたキーに該当する、直接請求データを取得します。
     *
     * @param data SeikyushaSelectGamenData
     * @return 更新状態
     */
    @Transaction
    public Boolean save直接請求データ(SeikyushaSelectGamenData data) {
        AfT401ChokusetsuSeikyuEntity entity = data.getEntity();

        if (entity == null) {
            return Boolean.FALSE;
        }

        return 1 == dac.save(entity);
    }
}
