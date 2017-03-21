/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijitourokuCommonEditor;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtg101.TohyoninMeiboTorokushasuListEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kokumintohyojitoroku.AFAPRG103tempTorokushasuListEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票人名簿登録者数リストの一時テーブル作成のクラスです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
public class TorokushasuListDataSelectProcess extends BatchProcessBase<TohyoninMeiboTorokushasuListEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisParameter;
    private OutputParameter<RString> outTempAFAPRG103;
    private OutputParameter<SenkyoShurui> outSenkyoShurui;
    private RString 帳票出力順;
    private TeijitourokuCommonEditor commonEditor;
    private static final RString 出力順_住所コード = new RString("投票区コード ＞ 住所コード");
    private static final RString 出力順_行政区コード = new RString("投票区コード ＞ 行政区コード");
    private static final RString 出力順_地区コード1 = new RString("投票区コード ＞ 地区コード１");
    private static final RString 出力順_地区コード2 = new RString("投票区コード ＞ 地区コード２");
    private static final RString 出力順_地区コード3 = new RString("投票区コード ＞ 地区コード３");

    /**
     * 一時テーブルです。
     */
    public static final RString OUT_TEMP_TABLE_NAME;
    /**
     * 選挙種類です。
     */
    public static final RString OUT_SENKYO_SHURUI;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempAFAPRG103");
        OUT_SENKYO_SHURUI = new RString("outSenkyoShurui");
    }
    private ShikakuHantei 資格判定;
    private static final RString TEMP_TABLE_NAME = new RString("TempAFAPRG103");
    private static final RString データ取得
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectTohyoninMeiboTorokushasuList");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisParameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoPSMSearchKey);
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 出力順List = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体,
                new ReportId(ReportIdKeys.AFAPRG103_投票人名簿登録者数リスト.value()));
        帳票出力順 = 出力順List.isEmpty() ? RString.EMPTY : 出力順List.get(0).getFormated出力順項目().trim();
        資格判定 = new ShikakuHantei();
        commonEditor = new TeijitourokuCommonEditor();

    }

    @Override
    protected void beforeExecute() {
        outTempAFAPRG103 = new OutputParameter<>();
        outSenkyoShurui = new OutputParameter<>();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(データ取得, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_NAME, AFAPRG103tempTorokushasuListEntity.class);
    }

    @Override
    protected void process(TohyoninMeiboTorokushasuListEntity entity) {
        if (entity != null) {
            tempDbWriter.insert(create一時テーブル(entity));
        }
    }

    @Override
    protected void afterExecute() {
        outTempAFAPRG103.setValue(TEMP_TABLE_NAME);
    }

    private AFAPRG103tempTorokushasuListEntity create一時テーブル(TohyoninMeiboTorokushasuListEntity entity) {
        AFAPRG103tempTorokushasuListEntity tempEntity = new AFAPRG103tempTorokushasuListEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名 = entity.getShikibetsuTaishoEntity();
        IShikibetsuTaisho 宛名PSM = commonEditor.toShikibetsuTaisho(entity.getShikibetsuTaishoEntity());
        AfT100ShohonEntity 抄本 = entity.getShohonEntity();
        AfT111SenkyoEntity 選挙 = entity.getSenkyoEntity();
        SenkyoShurui senkyoShurui = SenkyoShurui.toValue(抄本.getSenkyoShurui().value());
        parameter.set選挙種類(senkyoShurui);
        outSenkyoShurui.setValue(senkyoShurui);

        tempEntity.setShikibetsuCode(宛名PSM.get識別コード());
        tempEntity.setOrderCode(getOrderCode(宛名PSM));
        tempEntity.setSeibetsuCode(宛名PSM.to個人().get性別().getCode());
        tempEntity.setTohyokuCode(entity.getSenkyoninMeiboEntity().getTohyokuCode());
        tempEntity.setTohyokuMeisho(RString.EMPTY);
        if (SenkyoShurui.国政選挙_地方選挙.equals(senkyoShurui)) {
            if (null != entity.getUrTohyokuEntity()) {
                tempEntity.setTohyokuMeisho(entity.getUrTohyokuEntity().getName());
            }
        } else {
            if (null != entity.getAfTohyokuEntity()) {
                tempEntity.setTohyokuMeisho(entity.getAfTohyokuEntity().getTohyokuName());
            }
        }
        tempEntity.setSenkyoNo(選挙.getSenkyoNo());
        tempEntity.setSenkyoName(選挙.getSenkyoName());
        tempEntity.setKijunYMD(選挙.getKijunYMD());
        tempEntity.setTohyoYMD(SenkyoShurui.定時登録.equals(senkyoShurui) ? null : 抄本.getTohyoYMD());
        // 一号資格者
        tempEntity.setIchigoShikakuKubun(資格判定.is1号資格者(宛名,
                parameter.get基準日(),
                parameter.get年齢到達日()));
        // 二号資格者
        tempEntity.setNigoShikakuKubun(資格判定.is2号資格者(宛名,
                parameter.get基準日(),
                parameter.get年齢到達日()));
        return tempEntity;
    }

    private RString getOrderCode(IShikibetsuTaisho 宛名PSM) {
        if (出力順_住所コード.equals(帳票出力順)) {
            return 宛名PSM.to個人().get住所().get町域コード().value()
                    .concat(宛名PSM.to個人().get住登内住所().get住所());
        } else if (出力順_行政区コード.equals(帳票出力順)) {
            return 宛名PSM.to個人().get行政区画().getGyoseiku().getコード().value()
                    .concat(宛名PSM.to個人().get行政区画().getGyoseiku().get名称());
        } else if (出力順_地区コード1.equals(帳票出力順)) {
            return 宛名PSM.to個人().get行政区画().getChiku1().getコード().value()
                    .concat(宛名PSM.to個人().get行政区画().getChiku1().get名称());
        } else if (出力順_地区コード2.equals(帳票出力順)) {
            return 宛名PSM.to個人().get行政区画().getChiku2().getコード().value()
                    .concat(宛名PSM.to個人().get行政区画().getChiku2().get名称());
        } else if (出力順_地区コード3.equals(帳票出力順)) {
            return 宛名PSM.to個人().get行政区画().getChiku3().getコード().value()
                    .concat(宛名PSM.to個人().get行政区画().getChiku3().get名称());
        } else {
            return 宛名PSM.to個人().get行政区画().getGyoseiku().getコード().value()
                    .concat(宛名PSM.to個人().get行政区画().getGyoseiku().get名称());
        }
    }
}
