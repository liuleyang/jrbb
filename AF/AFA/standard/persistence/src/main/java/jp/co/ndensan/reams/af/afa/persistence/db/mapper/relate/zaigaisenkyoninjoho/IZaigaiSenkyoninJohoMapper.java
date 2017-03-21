/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zaigaisenkyoninjoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 在外選挙資格のMapperクラス
 *
 * @reamsid_L AF-0320-011 lis
 */
public interface IZaigaiSenkyoninJohoMapper {

    /**
     * 在外選挙資格情報件数を取得します。
     *
     * @param kofuNo RString
     * @return int
     */
    int selectAfT122ZaigaiSenkyoShikakuCountByKofuNo(@Param("kofuNo") RString kofuNo);

}
