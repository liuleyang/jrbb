/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokuminshohonselect;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tojitsutohyo.ShohonSearchEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.apache.ibatis.annotations.Param;

/**
 * 画面設計_AFAGME3010_当日投票のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0390-020 jihb
 */
public interface IKokuminShohonSelectMapper {

    /**
     * 抄本情報を取得します。
     *
     * @param kijunDate FlexibleDate
     * @return List<ShohonSearchEntity>
     */
    List<ShohonSearchEntity> selectShohon(@Param("kijunDate") FlexibleDate kijunDate);
}
