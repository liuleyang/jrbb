/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyoku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyoku.TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyoku.UrTohyokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 投票区のマッパーインタフェースです。
 *
 * @reamsid_L AF-0290-020 lit
 */
public interface ITohyokuMapper {

    /**
     * 投票区情報を取得します。
     *
     * @param senkyoShurui Code
     * @param tohyokuFrom RString
     * @param tohyokuTo RString
     * @return List<TohyokuEntity> 投票区情報
     */
    List<TohyokuEntity> select投票区(@Param("senkyoShurui") Code senkyoShurui,
            @Param("tohyokuFrom") RString tohyokuFrom, @Param("tohyokuTo") RString tohyokuTo);

    /**
     * UR投票区情報を取得します。
     *
     * @param senkyoShurui Code
     * @param tohyokuFrom RString
     * @param tohyokuTo RString
     * @param lasdecCode RString
     * @param lasdecCodeRenban int
     * @param yukoKaishiYMD FlexibleDate
     * @return List<UrTohyokuEntity> 投票区情報
     */
    List<UrTohyokuEntity> selectUR投票区(@Param("senkyoShurui") Code senkyoShurui,
            @Param("tohyokuFrom") RString tohyokuFrom, @Param("tohyokuTo") RString tohyokuTo,
            @Param("lasdecCode") RString lasdecCode, @Param("lasdecCodeRenban") int lasdecCodeRenban,
            @Param("yukoKaishiYMD") FlexibleDate yukoKaishiYMD);

    /**
     * 全投票区投票区コードを取得します。
     *
     * @param senkyoShurui Code
     * @param tohyokuFrom RString
     * @param tohyokuTo RString
     * @param yukoKaishiYMD FlexibleDate
     * @return List<RString> 投票区コード
     */
    List<RString> select全投票区(@Param("senkyoShurui") Code senkyoShurui,
            @Param("tohyokuFrom") RString tohyokuFrom,
            @Param("tohyokuTo") RString tohyokuTo,
            @Param("yukoKaishiYMD") FlexibleDate yukoKaishiYMD);

}
