/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE2050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shisetsusofusho.ShisetsuSofushoBusinessEditor;
import jp.co.ndensan.reams.af.afa.definition.batchprm.shisetsusofusho.AFABTE205BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shisetsusofusho.ShisetsusofushoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.shisetsusofusho.IShisetsuSofushoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 施設送付書発行のクラスです。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public class ShisetsuSofushoNinsuReportProcess extends BatchKeyBreakBase<ShisetsusofushoEntity> {

    private AFABTE205BatchParameter parameter;
    private AFABTE205SelectProcessMyBatisParameter mybatisParam;
    private AFABTE205SelectProcessParameter mybatisParam1;
    private IShisetsuSofushoMapper mapper;
    private NyujokenIkkatsuFinder finder;
    private AfaMapperProvider mapperProvider;
    private Decimal ninsu;
    private List<Decimal> 人数リスト;
    private List<RString> 改ページキーリスト;
    private static final RString 期日前不在者区分_不在者投票 = new RString("2");

    private static final RString 交付施設コード_コード = new RString("0510");
    private static final RString 選挙番号_コード = new RString("0500");

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.shisetsusofusho.IShisetsuSofushoMapper.getShisetsuSofushoList");

    /**
     * 人数Parameterです。
     */
    public static final RString NINSU_LIST;

    static {
        NINSU_LIST = new RString("ninsuList");
    }
    OutputParameter<List<Decimal>> ninsuList;

    @Override
    protected void initialize() {
        ninsu = Decimal.ZERO;
        人数リスト = new ArrayList<>();
        改ページキーリスト = new ArrayList<>();
        改ページキーリスト.add(交付施設コード_コード);
        改ページキーリスト.add(選挙番号_コード);
        parameter.set改ページキーリスト(改ページキーリスト);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先);
        RString 住基連動_氏名 = BusinessConfig.get(ConfigKeysAFA.抄本_住基連動_氏名, SubGyomuCode.AFA選挙本体);
        mybatisParam1 = parameter.toAFABTE205SelectProcessParameter();
        finder = NyujokenIkkatsuFinder.createInstance();
        AfT100ShohonEntity 抄本 = finder.get抄本情報(new ShohonNo(parameter.get抄本番号()));
        if (抄本 == null) {
            mybatisParam1.set処理年月日(FlexibleDate.EMPTY);
        } else if (抄本.getShoriYMD() == null) {
            mybatisParam1.set処理年月日(FlexibleDate.EMPTY);
        } else {
            mybatisParam1.set処理年月日(抄本.getShoriYMD());
        }
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(IShisetsuSofushoMapper.class);
        mybatisParam1.set抄本番号(new ShohonNo(parameter.get抄本番号()));
        mybatisParam1.set基準年月日(new FlexibleDate(RDate.getNowDate().toDateString()));
        ShisetsusofushoEntity 選挙 = mapper.select選挙の一番未来の日(mybatisParam1);
        if (選挙 == null) {
            mybatisParam1.set基準年月日(FlexibleDate.EMPTY);
        } else if (選挙.get名簿基準年月日() == null) {
            mybatisParam1.set基準年月日(FlexibleDate.EMPTY);
        } else {
            mybatisParam1.set基準年月日(選挙.get名簿基準年月日());
        }
        if (AFAConfigKeysValue.抄本_住基連動_氏名_抄本作成時.configKeyValue().equals(住基連動_氏名)) {
            build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
            build.set基準日(mybatisParam1.get処理年月日());
        } else if (AFAConfigKeysValue.抄本_住基連動_氏名_基準日時点.configKeyValue().equals(住基連動_氏名)) {
            build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
            build.set基準日(mybatisParam1.get基準年月日());
        } else if (AFAConfigKeysValue.抄本_住基連動_氏名_最新.configKeyValue().equals(住基連動_氏名)) {
            build.setデータ取得区分(DataShutokuKubun.直近レコード);
        }
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisParam = new AFABTE205SelectProcessMyBatisParameter(shikibetsuTaishoPSMSearchKey,
                parameter.get施設コード開始(),
                parameter.get施設コード終了(),
                parameter.get交付日開始(),
                parameter.get交付日終了(),
                new ShohonNo(parameter.get抄本番号()),
                RString.EMPTY,
                parameter.is無投票選挙も出力する());
        ninsuList = new OutputParameter<>();
        mybatisParam.set期日前不在者区分(期日前不在者区分_不在者投票);
        mybatisParam.setOrder順(parameter.getOrder順());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParam);
    }

    @Override
    protected void keyBreakProcess(ShisetsusofushoEntity entity) {
        ShisetsuSofushoBusinessEditor editor = new ShisetsuSofushoBusinessEditor();
        Boolean is改ページ = editor.hasBreak(改ページキーリスト, getBefore(), entity);
        if (is改ページ) {
            人数リスト.add(ninsu);
            ninsu = Decimal.ZERO;
        }

    }

    @Override
    protected void usualProcess(ShisetsusofushoEntity entity) {
        if (entity != null) {
            ninsu = ninsu.add(1);
        }
    }

    @Override
    protected void afterExecute() {
        人数リスト.add(ninsu);
        ninsuList.setValue(人数リスト);
    }

}
