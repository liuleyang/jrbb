/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyojitoroku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT100ShohonDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101ValidateMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のチェックロジッククラスです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public class SenkyojiTourokuRepositoryValidator {

    private final AfT100ShohonDac dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SenkyojiTourokuRepositoryValidator() {
        this.dac = InstanceProvider.create(AfT100ShohonDac.class);
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT100ShohonDac}
     * @param mapperProvider {@link AfaMapperProvider}
     */
    SenkyojiTourokuRepositoryValidator(AfT100ShohonDac dac, AfaMapperProvider mapperProvider) {
        this.dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * 投票日に関する、データアクセスを含めたバリデーションを実施します。
     *
     * @param 投票日
     * @return バリデーション結果
     */
    @Transaction
    boolean validate同じ抄本(RString 投票日) {
        IAFABTB101ValidateMapper mapper = mapperProvider.create(IAFABTB101ValidateMapper.class);
        return mapper.selectShohonCount(new FlexibleDate(投票日)) == 0;
    }

    /**
     * 抄本番号に関する、データアクセスを含めたバリデーションを実施します。
     *
     * @param 抄本番号
     * @return バリデーション結果
     */
    @Transaction
    boolean validate入場券発行済(RString 抄本番号) {
        boolean 入場券が発行済 = true;
        AfT100ShohonEntity entity = dac.select(new ShohonNo(抄本番号));
        if (entity != null) {
            Decimal nyujokenReportIndex = entity.getNyujokenReportIndex();
            if (nyujokenReportIndex != null && !nyujokenReportIndex.toString().isEmpty()
                    && nyujokenReportIndex.compareTo(Decimal.ZERO) != 0) {
                入場券が発行済 = false;
            }
        }
        return 入場券が発行済;
    }

    /**
     * 定時登録実行有無に関する、データアクセスを含めたバリデーションを実施します。
     *
     * @param 抄本番号
     * @return バリデーション結果
     */
    @Transaction
    boolean validate定時登録実行有無(FlexibleDate 基準日From, FlexibleDate 基準日To) {
        IAFABTB101ValidateMapper mapper = mapperProvider.create(IAFABTB101ValidateMapper.class);

        return mapper.selectTeijitourokuCount(基準日From, 基準日To) == 0;
    }

}
