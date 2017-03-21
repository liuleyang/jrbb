/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo.SenkyokuJoho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 選挙区のマッパーインタフェースです。
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public interface ISenkyokuMapper {

    /**
     * 選挙区情報を取得する。
     *
     * @param 選挙種類 RString
     * @return List<SenkyokuJoho>
     */
    List<SenkyokuJoho> select選挙区情報を検索(@Param("選挙種類") RString 選挙種類);
}
