/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyokutohyojo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokutohyojo.TohyokuTohyojoForMap;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokutohyojo.TohyokuTohyojoZeroForMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 投票区投票所のマッパーインタフェースです。
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public interface ITohyokuTohyojoMapper {

    /**
     * 投票区投票所対応情報を検索する。
     *
     * @param 選挙種類 RString
     * @param 導入団体コード LasdecCode
     * @param 導入団体コード連番 int
     * @param システム日付 FlexibleDate
     * @return TohyokuTohyojo
     */
    List<TohyokuTohyojoZeroForMap> select投票区投票所対応情報By選挙種類がゼロ(@Param("選挙種類") RString 選挙種類,
            @Param("導入団体コード") LasdecCode 導入団体コード, @Param("導入団体コード連番") int 導入団体コード連番,
            @Param("システム日付") FlexibleDate システム日付);

    /**
     * 投票区投票所対応情報を検索する
     *
     * @param 選挙種類 RString
     * @return TohyokuTohyojo
     */
    List<TohyokuTohyojoForMap> select投票区投票所対応情報(@Param("選挙種類") RString 選挙種類);
}
