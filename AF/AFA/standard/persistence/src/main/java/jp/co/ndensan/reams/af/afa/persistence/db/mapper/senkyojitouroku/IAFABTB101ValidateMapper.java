/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.apache.ibatis.annotations.Param;

/**
 * 選挙時登録の入力チェックのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public interface IAFABTB101ValidateMapper {

    /**
     * 定時登録データ件数を取得します。
     *
     * @param 基準日From FlexibleDate
     * @param 基準日To FlexibleDate
     * @return 定時登録データ件数
     */
    int selectTeijitourokuCount(@Param("kijunbiFrom") FlexibleDate 基準日From, @Param("kijunbiTo") FlexibleDate 基準日To);

    /**
     * 投票日と同じ抄本データ件数を取得します。
     *
     * @param 投票日 FlexibleDate
     * @return 抄本データ件数
     */
    int selectShohonCount(@Param("tohyoYMD") FlexibleDate 投票日);
}
