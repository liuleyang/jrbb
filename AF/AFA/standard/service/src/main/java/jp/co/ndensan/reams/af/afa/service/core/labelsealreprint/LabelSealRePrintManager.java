/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.labelsealreprint;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.labelsealreprint.LabelSealRePrintGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.labelsealreprint.LabelSealRePrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.labelsealreprint.ILabelSealRePrintMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ラベルシール再印刷のDB操作クラスです。
 *
 * @reamsid_L AF-0620-014 jihb
 */
public class LabelSealRePrintManager {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public LabelSealRePrintManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link LabelSealRePrintManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link LabelSealRePrintManager}のインスタンス
     */
    public static LabelSealRePrintManager createInstance() {
        return InstanceProvider.create(LabelSealRePrintManager.class);
    }

    /**
     * 指定されたキーに該当する、一括交付者データを取得します。
     *
     * @param shohonNo 抄本番号
     * @param shisetsuCode 施設種別コード
     * @return 一括交付者データ List<LabelSealRePrintGamenData>
     */
    @Transaction
    public List<LabelSealRePrintGamenData> get一括交付者データ(ShohonNo shohonNo, RString shisetsuCode) {

        ILabelSealRePrintMapper mapper = mapperProvider.create(ILabelSealRePrintMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        LabelSealRePrintMybatisParameter param = new LabelSealRePrintMybatisParameter(shikibetsuTaishoPSMSearchKey, shohonNo, shisetsuCode);

        List<SenkyoninTohyoJokyoEntity> 検索結果List = mapper.selectChohyoData(param);

        List<PersonalData> personalDataList = new ArrayList<>();

        List<LabelSealRePrintGamenData> 一括交付者データList = new ArrayList();
        for (SenkyoninTohyoJokyoEntity 検索結果 : 検索結果List) {
            for (AfT201TohyoJokyoEntity 投票状況 : 検索結果.getTohyoJokyoEntityList()) {
                LabelSealRePrintGamenData 一括交付者データ = new LabelSealRePrintGamenData(検索結果.getAtenaPSMEntity(), 投票状況);
                一括交付者データList.add(一括交付者データ);
            }
            personalDataList.add(PersonalData.of(検索結果.getAtenaPSMEntity().getShikibetsuCode()));
        }

        if (!personalDataList.isEmpty()) {
            AccessLogger.log(AccessLogType.照会, personalDataList);
        }

        return 一括交付者データList;
    }

    /**
     * 指定されたキーに該当する、選挙人データを取得します。
     *
     * @param shohonNo 抄本番号
     * @param 識別コードリスト List
     * @return SenkyoninTohyoJokyoEntity List
     */
    @Transaction
    public List<LabelSealRePrintGamenData> get選挙人データ(ShohonNo shohonNo, List<ShikibetsuCode> 識別コードリスト) {

        ILabelSealRePrintMapper mapper = mapperProvider.create(ILabelSealRePrintMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        LabelSealRePrintMybatisParameter param = new LabelSealRePrintMybatisParameter(shikibetsuTaishoPSMSearchKey, shohonNo, RString.EMPTY);
        param.setShikibetsuCodeList(識別コードリスト);

        List<SenkyoninTohyoJokyoEntity> 検索結果List = mapper.selectChohyoData(param);

        List<LabelSealRePrintGamenData> 選挙人データList = new ArrayList();

        List<PersonalData> personalDataList = new ArrayList<>();

        for (SenkyoninTohyoJokyoEntity 検索結果 : 検索結果List) {
            for (AfT201TohyoJokyoEntity 投票状況 : 検索結果.getTohyoJokyoEntityList()) {
                LabelSealRePrintGamenData 選挙人データ = new LabelSealRePrintGamenData(検索結果.getAtenaPSMEntity(), 投票状況);
                選挙人データList.add(選挙人データ);
            }
            personalDataList.add(PersonalData.of(検索結果.getAtenaPSMEntity().getShikibetsuCode()));
        }

        if (!personalDataList.isEmpty()) {
            AccessLogger.log(AccessLogType.照会, personalDataList);
        }

        return 選挙人データList;
    }

    /**
     * 指定されたキーに該当する、帳票データを取得します。
     *
     * @param shohonNo 抄本番号
     * @param 識別コードリスト List
     * @return SenkyoninTohyoJokyoEntity List
     */
    @Transaction
    public List<KijitsumaeTohyoChohyoData> get帳票データ(ShohonNo shohonNo, List<ShikibetsuCode> 識別コードリスト) {

        ILabelSealRePrintMapper mapper = mapperProvider.create(ILabelSealRePrintMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        LabelSealRePrintMybatisParameter param = new LabelSealRePrintMybatisParameter(shikibetsuTaishoPSMSearchKey, shohonNo, RString.EMPTY);
        param.setShikibetsuCodeList(識別コードリスト);

        List<SenkyoninTohyoJokyoEntity> 検索結果List = mapper.selectChohyoData(param);

        if (検索結果List.isEmpty()) {
            return null;
        }

        List<PersonalData> personalDataList = new ArrayList<>();

        List<KijitsumaeTohyoChohyoData> 帳票データlist = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : 検索結果List) {
            帳票データlist.add(new KijitsumaeTohyoChohyoData(entity));
            personalDataList.add(PersonalData.of(entity.getAtenaPSMEntity().getShikibetsuCode()));
        }

        if (!personalDataList.isEmpty()) {
            AccessLogger.log(AccessLogType.照会, personalDataList);
        }
        return 帳票データlist;
    }
}
