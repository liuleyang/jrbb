/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030;

import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 当日受付データ取込のアクセスログ出力のクラスです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
public class MochidashiPcImportUketsukeDataAccessLogProcess extends SimpleBatchProcessBase {

    private AFABTE803SelectProcessParameter selectProcessParameter;

    @Override
    protected void process() {
        for (ShikibetsuCode 識別コード : selectProcessParameter.get識別コードリスト()) {
            AccessLogger.log(AccessLogType.更新, PersonalData.of(識別コード));
        }

    }

}
