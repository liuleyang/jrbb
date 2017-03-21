/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintaishoshohonjoho;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintaishoshohonjoho.KokuminTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.apache.ibatis.annotations.Param;

/**
 * 国民投票抄本情報共有子DIVのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0360-011 lis
 */
public interface IKokuminTaishoMapper {

    /**
     * 各種情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return List<KokuminTaishoEntity>
     */
    KokuminTaishoEntity select各種情報(@Param("抄本番号") ShohonNo 抄本番号);

    /**
     * 同一投票日存在性チェック
     *
     * @param 投票年月日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     * @return List<AfT100ShohonEntity>
     */
    List<KokuminTaishoEntity> select抄本番号(@Param("投票日") FlexibleDate 投票年月日, @Param("選挙種類") SenkyoShurui 選挙種類);
}
