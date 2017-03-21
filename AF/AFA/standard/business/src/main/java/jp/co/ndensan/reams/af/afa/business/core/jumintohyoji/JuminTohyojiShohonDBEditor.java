/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jumintohyoji;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101DbProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 住民投票時登録のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminTohyojiShohonDBEditor {

    private final AfT100ShohonEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public JuminTohyojiShohonDBEditor(AfT100ShohonEntity entity) {
        this.entity = entity;
    }

    /**
     * 抄本データの編集仕様
     *
     * @param shohonNo ShohonNo
     * @param dbProcessParameter AFABTI101DbProcessParameter
     * @return AfT100ShohonEntity
     */
    public AfT100ShohonEntity edit抄本データの編集(ShohonNo shohonNo,
            AFABTI101DbProcessParameter dbProcessParameter) {
        entity.setShohonNo(shohonNo);
        entity.setSenkyoShurui(new Code(SenkyoShurui.住民投票.getCode()));
        entity.setShohonName(dbProcessParameter.get抄本名());
        entity.setTohyoYMD(dbProcessParameter.get投票日());
        entity.setKiteiNenreiTotatsuYMD(dbProcessParameter.get年齢計算基準日());
        entity.setShoriYMD(FlexibleDate.getNowDate());
        return entity;
    }

}
