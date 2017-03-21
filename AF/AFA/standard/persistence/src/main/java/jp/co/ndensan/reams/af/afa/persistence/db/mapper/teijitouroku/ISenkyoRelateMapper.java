/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.apache.ibatis.annotations.Param;

/**
 * 基準日に一番近い過去の選挙.名簿基準年月日を取得するためのマッパーインタフェースです。
 *
 */
public interface ISenkyoRelateMapper {

    /**
     * 基準日に一番近い過去の選挙.名簿基準年月日を取得します。
     *
     * @param kijunbi FlexibleDate
     * @return 基準日に一番近い過去の選挙.名簿基準年月日
     */
    FlexibleDate getMeiboTorokuYMD(@Param("kijunbi") FlexibleDate kijunbi);
}
