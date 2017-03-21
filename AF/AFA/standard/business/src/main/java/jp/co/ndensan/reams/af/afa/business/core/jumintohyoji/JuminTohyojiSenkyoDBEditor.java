/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jumintohyoji;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101DbProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民投票時登録のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminTohyojiSenkyoDBEditor {

    private final AfT111SenkyoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public JuminTohyojiSenkyoDBEditor(AfT111SenkyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 選挙データの編集仕様
     *
     * @param shohonNo ShohonNo
     * @param dbProcessParameter AFABTI101DbProcessParameter
     * @return AfT100ShohonEntity
     */
    public AfT111SenkyoEntity edit選挙データの編集(ShohonNo shohonNo,
            AFABTI101DbProcessParameter dbProcessParameter) {
        entity.setShohonNo(shohonNo);
        entity.setSenkyoNo(new SenkyoNo(1));
        entity.setSenkyoLevel(new Code(new RString("9")));
        entity.setSenkyoName(dbProcessParameter.get抄本名());
        entity.setSenkyoRyakusho(new RString("住民投票"));
        entity.setSenkyoMark(RString.EMPTY);
        entity.setKijunYMD(FlexibleDate.EMPTY);
        entity.setMeiboTorokuYMD(FlexibleDate.EMPTY);
        entity.setKokujiYMD(FlexibleDate.EMPTY);
        entity.setTenshutsuKigenYMD(dbProcessParameter.get転出日());
        entity.setTennyuKigenYMD(dbProcessParameter.get転入日());
        entity.setTohyoUketsukeYMD(dbProcessParameter.get投票開始日());
        entity.setMutohyoSenkyoFlag(false);

        return entity;
    }

}
