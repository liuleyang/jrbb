/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.yubinshikakutoroku;

import jp.co.ndensan.reams.af.afa.entity.db.relate.reprintteiji.shohonsenkyo.ShohonSenkyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.apache.ibatis.annotations.Param;

/**
 * 郵便等投票資格登録のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public interface IyubinshikakutorokuMapper {

    /**
     * 抄本選挙情報を取得します。
     *
     * @param 登録日 FlexibleDate
     * @return 抄本選挙情報 ShohonSenkyoEntity
     */
    ShohonSenkyoEntity getShohonSenkyo(@Param("torokuYMD") FlexibleDate 登録日);

    /**
     * 最新抄本選挙情報を取得します。
     *
     * @return 抄本選挙情報 ShohonSenkyoEntity
     */
    ShohonSenkyoEntity getSaisinShohonSenkyo();
}
