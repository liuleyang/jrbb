/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jumintohyoji;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101DbProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;

/**
 * 住民投票時登録のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminTohyojiZaisankuJuminDBEditor {

    private final AfT141ZaisankuJuminTohyoConditionEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public JuminTohyojiZaisankuJuminDBEditor(AfT141ZaisankuJuminTohyoConditionEntity entity) {
        this.entity = entity;
    }

    /**
     * 財産区と住民投票選挙人抽出条件データの編集仕様
     *
     * @param shohonNo ShohonNo
     * @param dbProcessParameter AFABTI101DbProcessParameter
     * @return AfT100ShohonEntity
     */
    public AfT141ZaisankuJuminTohyoConditionEntity edit財産区データの編集(ShohonNo shohonNo,
            AFABTI101DbProcessParameter dbProcessParameter) {

        entity.setShohonNo(shohonNo);
        entity.setNenreiKeisanKijunYMD(dbProcessParameter.get年齢計算基準日());
        entity.setNenrei(Integer.valueOf(dbProcessParameter.get何歳以上().toString()));
        entity.setBirthdayFukumuFlag(dbProcessParameter.is基準日翌日の誕生日の人を含むフラグ());
        if (dbProcessParameter.is期間中_年以上連続で居住フラグ()) {
            entity.setKyojuNensu(Integer.valueOf(dbProcessParameter.get期間中_年以上連続で居住().toString()));
        } else {
            entity.setKyojuNensu(0);
        }

        entity.setJuteiFirstYMD(dbProcessParameter.get住定期間From());
        entity.setJuteiLastYMD(dbProcessParameter.get住定期間To());
        entity.setJapaneseFlag(dbProcessParameter.is日本人フラグ());
        entity.setForeignerFlag(dbProcessParameter.is外国人フラグ());
        entity.setJuminFlag(dbProcessParameter.is住民フラグ());
        entity.setTenshutsushaFlag(dbProcessParameter.is転出者フラグ());
        entity.setTennyushaFlag(dbProcessParameter.is転入者フラグ());
        entity.setTeishishaFukumuFlag(dbProcessParameter.is抽出対象者に公民権停止者の人を含めるフラグ());
        return entity;
    }

}
