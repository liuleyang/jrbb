/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 海区漁業調整委員会委員選挙時登録<br>
 * 何年前のデータを取得する。
 *
 *
 * @reamsid_L AF-0470-030 jihb
 */
public class KaikuSelectShohonNoProcess extends BatchProcessBase<AfT100ShohonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.ISenkyojiKaikuMapper.select抄本番号");

    private AFABTK103SelectProcessParameter processParameter;
    private SenkyojiKaikuMybatisParameter mybatisParameter;

    private RString 抄本保有年数_海区;
    private FlexibleDate 名簿基準日;
    private List<ShohonNo> 抄本番号List;

    @Override
    protected void initialize() {
        mybatisParameter = processParameter.toSenkyojiKaikuMybatisParameter();
        抄本保有年数_海区 = BusinessConfig.get(
                ConfigKeysAFA.抄本保有年数_海区, SubGyomuCode.AFA選挙本体);
        名簿基準日 = processParameter.get基準日().minusYear(Integer.valueOf(抄本保有年数_海区.toString()));

        mybatisParameter.set名簿基準日(名簿基準日);
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        抄本番号List = new ArrayList<>();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void process(AfT100ShohonEntity entity) {
        抄本番号List.add(entity.getShohonNo());
    }

    @Override
    protected void afterExecute() {
        processParameter.set抄本番号List(抄本番号List);
    }
}
