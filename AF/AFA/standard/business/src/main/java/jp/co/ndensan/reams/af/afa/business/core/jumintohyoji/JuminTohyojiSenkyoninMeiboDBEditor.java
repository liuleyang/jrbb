/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.jumintohyoji;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.jumintohyoji.AFABTI101DbProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyoji.JuminTohyojiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 住民投票時登録のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public class JuminTohyojiSenkyoninMeiboDBEditor {

    private final AfT112SenkyoninMeiboEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity AfT100ShohonEntity
     */
    public JuminTohyojiSenkyoninMeiboDBEditor(AfT112SenkyoninMeiboEntity entity) {
        this.entity = entity;
    }

    /**
     * 選挙人名簿データの編集仕様
     *
     * @param shohonNo ShohonNo
     * @param dbProcessParameter AFABTI101DbProcessParameter
     * @param juminTohyojiEntity JuminTohyojiEntity
     * @param i int
     * @param 投票区コード_連番 int
     * @return AfT100ShohonEntity
     */
    public AfT112SenkyoninMeiboEntity edit選挙人名簿データの編集(ShohonNo shohonNo,
            AFABTI101DbProcessParameter dbProcessParameter, JuminTohyojiEntity juminTohyojiEntity, int i, int 投票区コード_連番) {
        RString ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_署名簿_ページ行数, SubGyomuCode.AFA選挙本体);

        entity.setShohonNo(shohonNo);
        entity.setGroupCode(RString.EMPTY);

        entity.setSatsu(RString.EMPTY);
        int page = 0;
        if (juminTohyojiEntity.getAfT112SenkyoninMeibEntity() != null) {
            page = juminTohyojiEntity.getAfT112SenkyoninMeibEntity().getPage();
        }

        if (投票区コード_連番 != 1) {
            entity.setPage(投票区コード_連番 + page);
        } else {
            entity.setPage(投票区コード_連番);
        }

        if (i > Integer.valueOf(ページ行数.toString())) {
            entity.setGyo(1);
        } else {
            entity.setGyo(i);
        }
        entity.setSeq(new BigSerial(1));
        if (juminTohyojiEntity.getUaFt200Entity() != null) {
            TohyokuCode 投票区コード = juminTohyojiEntity.getUaFt200Entity().getTohyokuCode();
            ShikibetsuCode 識別コード = juminTohyojiEntity.getUaFt200Entity().getShikibetsuCode();
            entity.setShikibetsuCode(識別コード != null ? 識別コード : ShikibetsuCode.EMPTY);
            entity.setTohyokuCode(投票区コード != null ? 投票区コード.value() : RString.EMPTY);
        }
        entity.setTohyokuHenkoMasshoFlag(false);
        entity.setRenban(i);
        entity.setEdaban(0);

        return entity;
    }

}
