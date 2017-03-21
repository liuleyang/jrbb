/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zaigaimeibotoroku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import org.apache.ibatis.annotations.Param;

/**
 * 在外選挙人名簿登録のMapperクラス
 *
 * @reamsid_L AF-0320-010 lis
 */
public interface IZaigaiMeiboTorokuMapper {

    /**
     * 不在者投票資格情報を取得します。
     *
     * @param 登録日 FlexibleDate
     * @return List<AfT100ShohonEntity>
     */
    List<AfT100ShohonEntity> get抄本番号リスト(@Param("torokuYMD") RDate 登録日);

}
