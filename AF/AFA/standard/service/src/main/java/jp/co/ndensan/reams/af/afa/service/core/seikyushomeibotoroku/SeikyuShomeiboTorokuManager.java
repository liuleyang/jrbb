/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.seikyushomeibotoroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.seikyushatoroku.SeikyushaTorokuJoho;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.business.seikyushaselect.SeikyushaSelectGamenData;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.Aft403ShomeiboResult;
import jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku.ShomeiboResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.seikyushatoroku.SeikyushaTorokuParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.seikyushomeibotoroku.SeikyuShomeiboTorokuParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT401ChokusetsuSeikyuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT403ShomeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SeikyushaTorokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.seikyushomeibotoroku.ShomeiboEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT401ChokusetsuSeikyuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT403ShomeiboDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.seikyushomeibotoroku.ISeikyuShomeiboTorokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 請求代表者証明書交付
 *
 * @reamsid_L AF-0150-010 wangh
 */
public class SeikyuShomeiboTorokuManager {

    private final AfT403ShomeiboDac dac;
    private final AfT100ShohonDac afT100ShohonDac;
    private final AfT401ChokusetsuSeikyuDac afT401ChokusetsuSeikyuDac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SeikyuShomeiboTorokuManager() {
        this.dac = InstanceProvider.create(AfT403ShomeiboDac.class);
        this.afT100ShohonDac = InstanceProvider.create(AfT100ShohonDac.class);
        this.afT401ChokusetsuSeikyuDac = InstanceProvider.create(AfT401ChokusetsuSeikyuDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeikyuShomeiboTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SeikyuShomeiboTorokuManager}のインスタンス
     */
    public static SeikyuShomeiboTorokuManager createInstance() {
        return InstanceProvider.create(SeikyuShomeiboTorokuManager.class);
    }

    /**
     * 指定されたキーに該当する、年齢別年代別投票率集計データを取得します。
     *
     * @param seikyuNo int
     * @return 署名者データ List<ShomeiboResult>
     */
    @Transaction
    public SeikyushaSelectGamenData get直接請求データ(int seikyuNo) {
        AfT401ChokusetsuSeikyuEntity entity = afT401ChokusetsuSeikyuDac.select(seikyuNo);
        if (null == entity) {
            return null;
        }
        return new SeikyushaSelectGamenData(entity);
    }

    /**
     * 指定されたキーに該当する、署名者一覧情報を取得します。
     *
     * @param seikyuNo int
     * @return 名者名簿データの件数 int
     */
    @Transaction
    public int get署名者名簿データ件数(int seikyuNo) {
        List<AfT403ShomeiboEntity> list = dac.select(seikyuNo);
        if (null != list && !list.isEmpty()) {
            return dac.select(seikyuNo).size();
        }
        return 0;
    }

    /**
     * SearchSimpleJuminDialog画面から請求代表者一覧を取得します。
     *
     * @param shohonNo ShohonNo
     * @param 識別コード ShikibetsuCode
     * @return List<SeikyushaTorokuJohoShikaku>
     */
    @Transaction
    public SeikyushaTorokuJoho get署名者情報と代筆者選択情報(ShohonNo shohonNo, ShikibetsuCode 識別コード) {

        new ShohonResult(afT100ShohonDac.select(shohonNo)).get投票年月日();
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.set基準日(new ShohonResult(afT100ShohonDac.select(shohonNo)).get投票年月日());
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey psmKey = build.build();
        SeikyushaTorokuParameter param = new SeikyushaTorokuParameter(psmKey);

        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);

        SeikyushaTorokuEntity entity = mapper.selectShomeiboByShikibetsuCode(param);
        if (null == entity) {
            return null;
        }
        return new SeikyushaTorokuJoho(entity);
    }

    /**
     * 指定されたキーに該当する、署名者一覧情報を取得します。
     *
     * @param seikyuNo int
     * @return 請求代表者一覧データ List<ShomeiboResult>
     */
    @Transaction
    public List<Aft403ShomeiboResult> get署名者情報(int seikyuNo) {

        List<Aft403ShomeiboResult> 署名者情報 = new ArrayList();
        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);
        List<ShomeiboEntity> 署名者data = mapper.selectShomeibo(seikyuNo);
        if (null == 署名者data || 署名者data.isEmpty()) {
            return null;
        }
        for (ShomeiboEntity entity : 署名者data) {
            署名者情報.add(new Aft403ShomeiboResult(entity));
        }

        return 署名者情報;
    }

    /**
     * 指定されたキーに該当する、署名者一覧情報を取得します。
     *
     * @param seikyuNo int
     * @return 請求代表者一覧データ List<ShomeiboResult>
     */
    @Transaction
    public List<ShomeiboResult> get署名者情報バク(int seikyuNo) {

        List<ShomeiboResult> 署名者情報 = new ArrayList();
        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);
        List<ShomeiboEntity> 署名者data = mapper.selectShomeiboback(seikyuNo);
        if (null == 署名者data || 署名者data.isEmpty()) {
            return null;
        }
        for (ShomeiboEntity entity : 署名者data) {
            署名者情報.add(new ShomeiboResult(entity));
        }

        return 署名者情報;
    }

    /**
     * 指定されたキーに該当する、署名件数表（投票区別）データを取得します。
     *
     * @param seikyuNo int
     * @return 署名者データ List<ShomeiboResult>
     */
    @Transaction
    public List<ShomeiboResult> get署名件数表_投票区別データ(int seikyuNo) {

        List<ShomeiboResult> 署名件数表_投票区別データ = new ArrayList();
        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);
        ShomeiboEntity 不明者 = mapper.selectShukeiKensuTohyokuFumei(seikyuNo);
        if (null != 不明者) {
            不明者.setTohyokuCode(RString.EMPTY);
            不明者.setTohyojoName(SeikyuShomeiboTorokuRStringEnum.不明者.getKey());
            署名件数表_投票区別データ.add(new ShomeiboResult(不明者));
        }

        List<ShomeiboEntity> 署名者data = mapper.selectShukeiKensuTohyoku(seikyuNo);
        if (null == 不明者
                && (null == 署名者data || 署名者data.isEmpty())) {
            return null;
        }
        for (ShomeiboEntity entity : 署名者data) {
            署名件数表_投票区別データ.add(new ShomeiboResult(entity));
        }
        return 署名件数表_投票区別データ;
    }

    /**
     * 指定されたキーに該当する、無効件数無効事由内訳表（投票区別）データを取得します。
     *
     * @param seikyuNo int
     * @return 署名者データ List<ShomeiboResult>
     */
    @Transaction
    public List<ShomeiboResult> get無効件数無効事由内訳表_投票区別データ(int seikyuNo) {

        List<ShomeiboResult> 無効件数無効事由内訳表_投票区別データ = new ArrayList();
        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);
        ShomeiboEntity 不明者 = mapper.selectShukeiMukoTohyokuFumei(seikyuNo);
        if (null != 不明者) {
            不明者.setTohyokuCode(RString.EMPTY);
            不明者.setTohyojoName(SeikyuShomeiboTorokuRStringEnum.不明者.getKey());
            無効件数無効事由内訳表_投票区別データ.add(new ShomeiboResult(不明者));
        }
        List<ShomeiboEntity> 署名者data = mapper.selectShukeiMukoTohyoku(seikyuNo);
        if (null == 不明者
                && (null == 署名者data || 署名者data.isEmpty())) {
            return null;
        }
        for (ShomeiboEntity entity : 署名者data) {
            無効件数無効事由内訳表_投票区別データ.add(new ShomeiboResult(entity));
        }
        return 無効件数無効事由内訳表_投票区別データ;
    }

    /**
     * 指定されたキーに該当する、無効件数無効事由内訳表（住所別）データを取得します。
     *
     * @param seikyuNo int
     * @return 署名者データ List<ShomeiboResult>
     */
    @Transaction
    public List<ShomeiboResult> get無効件数無効事由内訳表_住所別データ(int seikyuNo) {

        List<ShomeiboResult> 無効件数無効事由内訳表_住所別データ = new ArrayList();
        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);

        ShomeiboEntity 不明者 = mapper.selectShukeiMukoJushoFumei(seikyuNo);
        if (null != 不明者) {
            不明者.setJutonaiChoikiCode(ChoikiCode.EMPTY);
            不明者.setJutonaiJusho(SeikyuShomeiboTorokuRStringEnum.不明者.getKey());
            無効件数無効事由内訳表_住所別データ.add(new ShomeiboResult(不明者));
        }

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(FlexibleDate.getNowDate());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        SeikyuShomeiboTorokuParameter param = new SeikyuShomeiboTorokuParameter(
                shikibetsuTaishoPSMSearchKey, seikyuNo);
        List<ShomeiboEntity> 署名者data = mapper.selectShukeiMukoJusho(param);
        if (null == 不明者
                && (null == 署名者data || 署名者data.isEmpty())) {
            return null;
        }
        for (ShomeiboEntity entity : 署名者data) {
            無効件数無効事由内訳表_住所別データ.add(new ShomeiboResult(entity));
        }
        return 無効件数無効事由内訳表_住所別データ;
    }

    /**
     * 指定されたキーに該当する、署名件数表（住所別）データを取得します。
     *
     * @param seikyuNo int
     * @return 署名者データ List<ShomeiboResult>
     */
    @Transaction
    public List<ShomeiboResult> get署名件数表_住所別データ(int seikyuNo) {

        List<ShomeiboResult> 署名件数表_住所別データ = new ArrayList();
        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);
        ShomeiboEntity 不明者 = mapper.selectShukeiKensuJushoFumei(seikyuNo);
        if (null != 不明者) {
            不明者.setJutonaiChoikiCode(ChoikiCode.EMPTY);
            不明者.setJutonaiJusho(SeikyuShomeiboTorokuRStringEnum.不明者.getKey());
            署名件数表_住所別データ.add(new ShomeiboResult(不明者));
        }

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(FlexibleDate.getNowDate());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        SeikyuShomeiboTorokuParameter param = new SeikyuShomeiboTorokuParameter(
                shikibetsuTaishoPSMSearchKey, seikyuNo);
        List<ShomeiboEntity> 署名者data = mapper.selectShukeiKensuJusho(param);
        if (null == 不明者 && (null == 署名者data || 署名者data.isEmpty())) {
            return null;
        }
        for (ShomeiboEntity entity : 署名者data) {
            署名件数表_住所別データ.add(new ShomeiboResult(entity));
        }
        return 署名件数表_住所別データ;
    }

    /**
     * 指定されたキーに該当する、年齢別年代別投票率集計データを取得します。
     *
     * @param seikyuNo int
     * @return 署名者データ List<ShomeiboResult>
     */
    @Transaction
    public List<ShomeiboResult> get年齢別年代別データ_不明者(int seikyuNo) {

        List<ShomeiboResult> 年齢別年代別データ = new ArrayList();
        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);

        List<ShomeiboEntity> 不明者 = mapper.selectShukeiNenreiNendaiFumei(seikyuNo);
        if ((null == 不明者 || 不明者.isEmpty())) {
            return null;
        }
        for (ShomeiboEntity entity : 不明者) {
            entity.setTohyokuCode(RString.EMPTY);
            entity.setTohyojoName(SeikyuShomeiboTorokuRStringEnum.不明者.getKey());
            年齢別年代別データ.add(new ShomeiboResult(entity));
        }
        return 年齢別年代別データ;
    }

    /**
     * 指定されたキーに該当する、年齢別年代別投票率集計データを取得します。
     *
     * @param seikyuNo int
     * @return 署名者データ List<ShomeiboResult>
     */
    @Transaction
    public List<ShomeiboResult> get年齢別年代別データ(int seikyuNo) {

        List<ShomeiboResult> 年齢別年代別データ = new ArrayList();
        ISeikyuShomeiboTorokuMapper mapper = mapperProvider.create(ISeikyuShomeiboTorokuMapper.class);

        List<ShomeiboEntity> 署名者data = mapper.selectShukeiNenreiNendai(seikyuNo);
        if (null == 署名者data || 署名者data.isEmpty()) {
            return null;
        }
        for (ShomeiboEntity entity : 署名者data) {
            年齢別年代別データ.add(new ShomeiboResult(entity));
        }
        return 年齢別年代別データ;
    }

    /**
     * 選挙種類と選挙区コードと端末Idにより、選挙区情報を取得します。
     *
     * @param seikyuNo int
     * @param 署名者情報 List< Aft403ShomeiboResult>
     * @param 直接請求データ SeikyushaSelectGamenData
     * @return count int
     */
    @Transaction
    public int deleteSAndInsert署名者情報(int seikyuNo, List<Aft403ShomeiboResult> 署名者情報, SeikyushaSelectGamenData 直接請求データ) {
        int count = 0;
        afT401ChokusetsuSeikyuDac.save(直接請求データ.getEntity());
        List<AfT403ShomeiboEntity> entityList = dac.select(seikyuNo);
        if (null != entityList) {
            for (AfT403ShomeiboEntity entity : entityList) {
                dac.deletePhysical(entity);
            }
        }
        if (null != 署名者情報 && !署名者情報.isEmpty()) {
            for (Aft403ShomeiboResult result : 署名者情報) {
                dac.save(result.getAfT403ShomeiboEntity());
                count++;
            }
        }
        return count;
    }
}
