/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.mastercsvoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.AfCodeCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.AfConfigCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.HojoshaCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.KumiaiCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.RyojikanCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.SenkyokuCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.ShisetsuCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.TohyojoCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.TohyokuAFCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.TohyokuUrCsvResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.mastercsvoutput.MasterCsvOutputEnum;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.mastercsvoutput.MasterCsvOutputMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput.CodeInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput.HojoshaInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput.TohyokuAFInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput.TohyokuURInfoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT502TohyojoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT503SenkyokuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT507ShisetsuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT509KumiaiDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT510RyojikanDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mastercsvoutput.IMasterCsvOutputMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0006CodeShubetsuEntity;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.config.entity.UzT0001StandardConfigEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 各種マスタデータ出力の取得
 *
 * @reamsid_L AF-0670-010 lis
 */
public class MasterCsvOutputManager {

    private final AfT502TohyojoDac 投票所dac;
    private final AfT503SenkyokuDac 選挙区dac;
    private final AfT507ShisetsuDac 施設dac;
    private final AfT510RyojikanDac 領事館dac;
    private final AfT509KumiaiDac 組合dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public MasterCsvOutputManager() {
        this.投票所dac = InstanceProvider.create(AfT502TohyojoDac.class);
        this.選挙区dac = InstanceProvider.create(AfT503SenkyokuDac.class);
        this.施設dac = InstanceProvider.create(AfT507ShisetsuDac.class);
        this.領事館dac = InstanceProvider.create(AfT510RyojikanDac.class);
        this.組合dac = InstanceProvider.create(AfT509KumiaiDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link MasterCsvOutputManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link MasterCsvOutputManager}のインスタンス
     */
    public static MasterCsvOutputManager createInstance() {
        return InstanceProvider.create(MasterCsvOutputManager.class);
    }

    /**
     * UR投票区情報を返します。
     *
     * @param 選挙種類 Code
     * @return List<TohyokuURCsvResult>
     */
    @Transaction
    public List<TohyokuUrCsvResult> get投票区UR情報(Code 選挙種類) {
        IMasterCsvOutputMapper mapper = mapperProvider.create(IMasterCsvOutputMapper.class);
        List<TohyokuUrCsvResult> resultList = new ArrayList();
        TohyokuUrCsvResult result;
        TohyokuURInfoEntity entity;
        List<TohyokuURInfoEntity> 投票区情報 = mapper.select投票区UR情報(選挙種類);
        if (null == 投票区情報 || 投票区情報.isEmpty()) {
            return resultList;
        }
        for (int i = 0; i < 投票区情報.size(); i++) {
            entity = 投票区情報.get(i);
            result = new TohyokuUrCsvResult();
            result.set投票区コード(toRString(entity.get投票区Entity().getTohyokuCode()));
            result.set地方公共団体コード(toRString(entity.get投票区Entity().getLasdecCode()));
            result.set地方公共団体コード連番(toRString(entity.get投票区Entity().getLasdecCodeRenban()));
            result.set有効開始年月日(toRString(entity.get投票区Entity().getYukoKaishiYMD()));
            result.set有効終了年月日(toRString(entity.get投票区Entity().getYukoShuryoYMD()));
            result.set漢字名称(entity.get投票区Entity().getName());
            result.setカナ名称(entity.get投票区Entity().getKanaName());
            result.set検索カナ(entity.get投票区Entity().getKensakuKana());
            result.set表示順(toRString(entity.get投票区Entity().getHyojiJun()));
            result.set投票所コード(entity.get投票所Entity().getTohyojoCode());
            result.set投票所名(entity.get投票所Entity().getTohyojoName());
            result.set投票所住所(toRString(entity.get投票所Entity().getJusho()));
            result.set選挙区コード(entity.get選挙区Entity().getSenkyokuCode());
            result.set選挙区名(entity.get選挙区Entity().getSenkyokuName());
            resultList.add(result);
        }
        return resultList;
    }

    /**
     * AF投票区情報を返します。
     *
     * @param 選挙種類 RString
     * @return List<TohyokuAFCsvResult>
     */
    @Transaction
    public List<TohyokuAFCsvResult> get投票区AF情報(Code 選挙種類) {
        IMasterCsvOutputMapper mapper = mapperProvider.create(IMasterCsvOutputMapper.class);
        List<TohyokuAFCsvResult> resultList = new ArrayList();
        TohyokuAFCsvResult result;
        TohyokuAFInfoEntity entity;
        List<TohyokuAFInfoEntity> 投票区情報 = mapper.select投票区AF情報(選挙種類);
        if (null == 投票区情報 || 投票区情報.isEmpty()) {
            return resultList;
        }
        for (int i = 0; i < 投票区情報.size(); i++) {
            entity = 投票区情報.get(i);
            result = new TohyokuAFCsvResult();
            result.set選挙種類(toRString(選挙種類));
            result.set選挙種類名(CodeMaster.getCodeMeisho(AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), 選挙種類));
            result.set投票区コード(entity.get投票区Entity().getTohyokuCode());
            result.set投票区名(entity.get投票区Entity().getTohyokuName());
            result.setカナ投票区名(entity.get投票区Entity().getKanaTohyokuName());
            result.set検索用カナ投票区名(entity.get投票区Entity().getSearchKanaTohyokuName());
            result.set表示順(toRString(entity.get投票区Entity().getHyojijun()));
            result.set投票所コード(entity.get投票所Entity().getTohyojoCode());
            result.set投票所名(entity.get投票所Entity().getTohyojoName());
            result.set投票所住所(toRString(entity.get投票所Entity().getJusho()));
            result.set選挙区コード(entity.get選挙区Entity().getSenkyokuCode());
            result.set選挙区名(entity.get選挙区Entity().getSenkyokuName());
            resultList.add(result);
        }
        return resultList;
    }

    /**
     * 投票所全レコードを返します。
     *
     * @return List<TohyojoCsvResult>
     */
    @Transaction
    public List<TohyojoCsvResult> get投票所() {
        List<AfT502TohyojoEntity> 投票所 = 投票所dac.select();
        List<TohyojoCsvResult> resultList = new ArrayList();
        TohyojoCsvResult result;
        AfT502TohyojoEntity entity;
        if (null == 投票所 || 投票所.isEmpty()) {
            return resultList;
        }
        for (int i = 0; i < 投票所.size(); i++) {
            entity = 投票所.get(i);
            result = new TohyojoCsvResult();
            result.set投票所コード(entity.getTohyojoCode());
            result.set投票所名称(entity.getTohyojoName());
            result.setカナ投票所名称(entity.getKanaTohyojoName());
            result.set検索用カナ投票所名称(entity.getSearchKanaTohyojoName());
            result.set投票開始時刻(toRString(entity.getTohyoStartTime()));
            result.set投票終了時刻(toRString(entity.getTohyoStopTime()));
            result.set在外投票可能フラグ(toRString(String.valueOf(entity.getZaigaiTohyoKanoFlag())));
            result.set郵便番号(toRString(entity.getYubinNo()));
            result.set住所(toRString(entity.getJusho()));
            result.set投票所宛名(toRString(entity.getTohyojoAtena()));
            result.set電話番号(toRString(entity.getTelNo()));
            result.setファクス番号(toRString(entity.getFaxNo()));
            result.set地図ファイル名(entity.getMapImage());
            resultList.add(result);
        }
        return resultList;
    }

    /**
     * 選挙区全レコードを返します。
     *
     * @return List<SenkyokuCsvResult> 。
     */
    @Transaction
    public List<SenkyokuCsvResult> get選挙区() {
        List<AfT503SenkyokuEntity> 選挙区 = 選挙区dac.select();
        List<SenkyokuCsvResult> resultList = new ArrayList();
        if (null == 選挙区 || 選挙区.isEmpty()) {
            return resultList;
        }
        set選挙区(選挙区, resultList);
        return resultList;
    }

    /**
     * 選挙区全レコードを返します。
     *
     * @param 選挙種類 Code。
     * @return List<SenkyokuCsvResult>。
     */
    @Transaction
    public List<SenkyokuCsvResult> get選挙区(Code 選挙種類) {
        List<AfT503SenkyokuEntity> 選挙区 = 選挙区dac.select(選挙種類);
        List<SenkyokuCsvResult> resultList = new ArrayList();
        if (null == 選挙区 || 選挙区.isEmpty()) {
            return resultList;
        }
        set選挙区(選挙区, resultList);
        return resultList;
    }

    /**
     * 施設全レコードを返します。
     *
     * @return List<ShisetsuCsvResult> 。
     */
    @Transaction
    public List<ShisetsuCsvResult> get施設() {
        List<AfT507ShisetsuEntity> 施設 = 施設dac.select();
        List<ShisetsuCsvResult> resultList = new ArrayList();
        ShisetsuCsvResult result;
        AfT507ShisetsuEntity entity;
        if (null == 施設 || 施設.isEmpty()) {
            return resultList;
        }
        for (int i = 0; i < 施設.size(); i++) {
            entity = 施設.get(i);
            result = new ShisetsuCsvResult();
            set選挙区(entity, result);
            resultList.add(result);
        }
        return resultList;
    }

    /**
     * 施設全レコードを返します。
     *
     * @param 施設種別 RString。
     * @return ShisetsuCsvResult 。
     */
    @Transaction
    public List<ShisetsuCsvResult> get施設(RString 施設種別) {
        AfT507ShisetsuEntity 施設 = 施設dac.select(施設種別);
        List<ShisetsuCsvResult> resultList = new ArrayList();
        ShisetsuCsvResult result = new ShisetsuCsvResult();
        if (null == 施設) {
            return resultList;
        }
        set選挙区(施設, result);
        resultList.add(result);
        return resultList;
    }

    /**
     * 補助者全レコードを返します。
     *
     * @param 抄本番号 ShohonNo
     * @return List<HojoshaCsvResult> 。
     */
    @Transaction
    public List<HojoshaCsvResult> get補助者(ShohonNo 抄本番号) {
        IMasterCsvOutputMapper mapper = mapperProvider.create(IMasterCsvOutputMapper.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先));
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        MasterCsvOutputMapperParameter parameter = new MasterCsvOutputMapperParameter(抄本番号, key.getPSM検索キー());
        List<HojoshaInfoEntity> 補助者 = mapper.select補助者情報(parameter);
        List<HojoshaCsvResult> resultList = new ArrayList();
        if (null == 補助者 || 補助者.isEmpty()) {
            return resultList;
        }
        set補助者(補助者, resultList);
        return resultList;
    }

    /**
     * 補助者全レコードを返します。
     *
     * @return List<HojoshaCsvResult> 。
     */
    @Transaction
    public List<HojoshaCsvResult> get補助者() {
        IMasterCsvOutputMapper mapper = mapperProvider.create(IMasterCsvOutputMapper.class);
        List<HojoshaInfoEntity> 補助者 = mapper.select補助者情報();
        List<HojoshaCsvResult> resultList = new ArrayList();
        if (null == 補助者 || 補助者.isEmpty()) {
            return resultList;
        }
        set補助者(補助者, resultList);
        return resultList;
    }

    /**
     * 組合全レコードを返します。
     *
     * @return List<KumiaiCsvResult> 。
     */
    @Transaction
    public List<KumiaiCsvResult> get組合() {
        List<AfT509KumiaiEntity> 組合 = 組合dac.select();
        List<KumiaiCsvResult> resultList = new ArrayList();
        KumiaiCsvResult result;
        AfT509KumiaiEntity entity;
        if (null == 組合 || 組合.isEmpty()) {
            return resultList;
        }

        for (int i = 0; i < 組合.size(); i++) {
            entity = 組合.get(i);
            result = new KumiaiCsvResult();
            result.set組合コード(entity.getKumiaiCode());
            result.set組合名称(entity.getKumiaiName());
            result.setカナ組合名称(entity.getKanaKumiaiName());
            result.set検索用カナ組合名称(entity.getSearchKumiaiName());
            result.set組合の住所等(toRString(entity.getJusho()));

            resultList.add(result);
        }
        return resultList;
    }

    /**
     * 領事館全レコードを返します。
     *
     * @return List<RyojikanResult> 。
     */
    @Transaction
    public List<RyojikanCsvResult> get領事館() {
        List<AfT510RyojikanEntity> 領事館 = 領事館dac.select();
        List<RyojikanCsvResult> resultList = new ArrayList();
        RyojikanCsvResult result;
        AfT510RyojikanEntity entity;
        if (null == 領事館 || 領事館.isEmpty()) {
            return resultList;
        }

        for (int i = 0; i < 領事館.size(); i++) {
            entity = 領事館.get(i);
            result = new RyojikanCsvResult();
            result.set領事官コード(entity.getRyojikanCode());
            result.set領事官名称(entity.getRyojikanName());
            result.setカナ領事官名称(entity.getKanaRyojikanName());
            result.set検索用カナ領事官名称(entity.getSearchKanaRyojikanName());
            result.set表示順(toRString(entity.getHyojijun()));
            resultList.add(result);
        }

        return resultList;
    }

    /**
     * コード全レコードを返します。
     *
     * @return List<AfCodeCsvResult> 。
     */
    @Transaction
    public List<AfCodeCsvResult> getコード() {
        IMasterCsvOutputMapper mapper = mapperProvider.create(IMasterCsvOutputMapper.class);
        List<AfCodeCsvResult> resultList = new ArrayList();
        AfCodeCsvResult result;
        UzT0006CodeShubetsuEntity コード種別;
        UzT0007CodeEntity コード;
        List<CodeInfoEntity> codes = mapper.select全コード();
        if (null == codes || codes.isEmpty()) {
            return resultList;
        }
        for (int i = 0; i < codes.size(); i++) {
            コード種別 = codes.get(i).getコード種別Entity();
            コード = codes.get(i).getコードEntity();
            result = new AfCodeCsvResult();
            result.setスキーマ名(MasterCsvOutputEnum.RGAF.getRString());
            result.setサブ業務コード(toRString(コード種別.getサブ業務コード()));
            result.setコード種別(toRString(コード種別.getコード種別()));
            result.setコード種別名称(コード種別.getコード種別名称());
            result.set有効桁数(toRString(コード種別.get有効桁数()));
            result.setコード追加可否(toRString(String.valueOf(コード種別.is追加可否区分())));
            result.setコード種別説明(コード種別.get種別概要());
            result.setオプション1名称(コード種別.getオプション１名称());
            result.setオプション2名称(コード種別.getオプション２名称());
            result.setオプション3名称(コード種別.getオプション３名称());
            result.setコード(toRString(コード.getコード()));
            result.setコード名称(コード.getコード名称());
            result.setコード略称(コード.getコード略称());
            result.set更新可否(toRString(String.valueOf(コード.get更新可否区分())));
            result.set表示順(toRString(コード.get表示順()));
            result.setオプション1(コード.getオプション１());
            result.setオプション2(コード.getオプション２());
            result.setオプション3(コード.getオプション３());
            result.set有効開始年月日(toRString(コード.get有効開始年月日()));
            result.set有効終了年月日(toRString(コード.get有効終了年月日()));
            resultList.add(result);
        }
        return resultList;

    }

    /**
     * コード全レコードを返します。
     *
     * @return List<AfConfigCsvResult> 。
     */
    @Transaction
    public List<AfConfigCsvResult> getコンフィグ() {
        IMasterCsvOutputMapper mapper = mapperProvider.create(IMasterCsvOutputMapper.class
        );
        List<AfConfigCsvResult> resultList = new ArrayList();
        AfConfigCsvResult result;
        UzT0001StandardConfigEntity コンフィグ;
        List<UzT0001StandardConfigEntity> configs = mapper.selectコンフィグ();
        for (int i = 0;
                i < configs.size();
                i++) {
            コンフィグ = configs.get(i);
            result = new AfConfigCsvResult();
            result.setスキーマ名(コンフィグ.getSchemaName());
            result.setサブ業務コード(toRString(コンフィグ.getSubGyomuCode()));
            result.setコンフィグ名(コンフィグ.getConfigName());
            result.set値(コンフィグ.getConfigValue());
            result.set説明(コンフィグ.getConfigDesc());
            result.setデータ型(コンフィグ.getJavaType());
            result.set更新可否(new RString(String.valueOf(コンフィグ.getTheyCanChange())));
            resultList.add(result);
        }
        return resultList;
    }

    private void set選挙区(List<AfT503SenkyokuEntity> 選挙区, List<SenkyokuCsvResult> resultList) {
        SenkyokuCsvResult result;
        AfT503SenkyokuEntity entity;
        for (int i = 0; i < 選挙区.size(); i++) {
            entity = 選挙区.get(i);
            result = new SenkyokuCsvResult();
            result.set選挙種類(toRString(entity.getSenkyoShurui()));
            result.set選挙種類名(CodeMaster.getCodeMeisho(AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), entity.getSenkyoShurui()));
            result.set選挙区コード(entity.getSenkyokuCode());
            result.set選挙区名(entity.getSenkyokuName());
            resultList.add(result);
        }
    }

    private void set選挙区(AfT507ShisetsuEntity entity, ShisetsuCsvResult result) {
        result.set施設コード(entity.getShisetsuCode());
        result.set施設種別(toRString(entity.getShisetsuShubetsu()));
        result.set施設種別名(CodeMaster.getCodeMeisho(AFACodeShubetsu.施設種別.getCodeShubetsu(), entity.getShisetsuShubetsu()));
        result.set施設名称(entity.getShisetsuName());
        result.setカナ施設名称(entity.getKanaShisetsuName());
        result.set検索用カナ施設名称(entity.getSearchKanaShisetsuName());
        result.set郵便番号(toRString(entity.getYubinNo()));
        result.set住所(toRString(entity.getJusho()));
        result.set施設宛名(toRString(entity.getShisetsuAtena()));
        result.set電話番号(toRString(entity.getTelNo()));
        result.setファクス番号(toRString(entity.getFaxNo()));
    }

    private void set補助者(List<HojoshaInfoEntity> 補助者, List<HojoshaCsvResult> resultList) {
        HojoshaCsvResult result;
        HojoshaInfoEntity entity;
        for (int i = 0; i < 補助者.size(); i++) {
            entity = 補助者.get(i);
            result = new HojoshaCsvResult();
            result.set抄本番号(toRString(entity.get補助者Entity().getShohonNo()));
            result.set抄本名(entity.get抄本Entity().getShohonName());
            result.set識別コード(toRString(entity.get補助者Entity().getShikibetsuCode()));
            result.set補助者氏名(toRString(entity.get宛名PSMEntity().getMeisho()));
            result.set投票所コード(entity.get補助者Entity().getTohyojoCode());
            result.set投票所名称(entity.get投票所Entity().getTohyojoName());
            resultList.add(result);
        }
    }

    /**
     * toRString
     *
     * @param date FlexibleDate
     * @return RString
     */
    private RString toRString(FlexibleDate date) {
        if (null == date || date.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    /**
     * toRString
     *
     * @param code Code
     * @return RString
     */
    private RString toRString(Code code) {
        if (null == code || code.isEmpty()) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param no ShohonNo
     * @return RString
     */
    private RString toRString(ShohonNo no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return new RString(no.value());
    }

    /**
     * toRString
     *
     * @param no YubinNo
     * @return RString
     */
    private RString toRString(YubinNo no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return no.getYubinNo();
    }

    /**
     * toRString
     *
     * @param code SubGyomuCode
     * @return RString
     */
    private RString toRString(SubGyomuCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code TohyokuCode
     * @return RString
     */
    private RString toRString(TohyokuCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code CodeShubetsu
     * @return RString
     */
    private RString toRString(CodeShubetsu code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code ShikibetsuCode
     * @return RString
     */
    private RString toRString(ShikibetsuCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param code LasdecCode
     * @return RString
     */
    private RString toRString(LasdecCode code) {
        if (null == code) {
            return RString.EMPTY;
        }
        return code.value();
    }

    /**
     * toRString
     *
     * @param jusho AtenaJusho
     * @return RString
     */
    private RString toRString(AtenaJusho jusho) {
        if (null == jusho) {
            return RString.EMPTY;
        }
        return jusho.value();
    }

    /**
     * toRString
     *
     * @param meisho AtenaMeisho
     * @return RString
     */
    private RString toRString(AtenaMeisho meisho) {
        if (null == meisho) {
            return RString.EMPTY;
        }
        return meisho.value();
    }

    /**
     * toRString
     *
     * @param no AtenaMeisho
     * @return RString
     */
    private RString toRString(TelNo no) {
        if (null == no) {
            return RString.EMPTY;
        }
        return no.value();
    }

    /**
     * toRString
     *
     * @param integer Integer
     * @return RString
     */
    private RString toRString(Integer integer) {
        if (null == integer) {
            return RString.EMPTY;
        }
        return new RString(integer);
    }

    /**
     * toRString
     *
     * @param str String
     * @return RString
     */
    private RString toRString(String str) {
        if (null == str) {
            return RString.EMPTY;
        }
        return new RString(str);
    }

    /**
     * toRString
     *
     * @param time String
     * @return RString
     */
    private RString toRString(RTime time) {
        if (null == time) {
            return RString.EMPTY;
        }
        return time.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
    }
}
