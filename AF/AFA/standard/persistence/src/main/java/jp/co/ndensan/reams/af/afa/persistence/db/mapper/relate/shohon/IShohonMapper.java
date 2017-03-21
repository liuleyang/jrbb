/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.shohon;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shohon.shohon.ShohonEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 抄本のマッパーインタフェースです。
 */
public interface IShohonMapper {

//    /**
//     * 抄本情報をキー検索で１件取得します。
//     *
//     * @param 抄本検索条件 抄本検索条件
//     * @return ShohonEntity
//     */
//    ShohonEntity select抄本ByKey(ShohonMapperParameter 抄本検索条件);
    /**
     * 抄本情報をキー検索で１件取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return ShohonEntity
     */
    ShohonEntity select抄本By番号(@Param("抄本番号") ShohonNo 抄本番号);

    /**
     * 最後に実行した定時登録の抄本情報をキー検索で１件取得します。
     *
     * @param isシミュレーション boolean
     * @return FlexibleDate 最後定時登録
     */
    FlexibleDate select最後定時登録(@Param("isシミュレーション") boolean isシミュレーション);

    /**
     * 抄本情報を取得します。
     *
     * @param isシミュレーション Boolean
     * @param is過去分のみ Boolean
     * @param is過去分も含める Boolean
     * @param is海区 Boolean
     * @param 選挙時登録フラグ Boolean
     * @param isNotEq定時登録 Boolean
     * @param isUseSenkyoShurui Boolean
     * @param senkyoShurui RString
     * @param kijunYmd FlexibleDate
     * @param 名簿調製用連携の選挙種類List RString{@code list}
     * @return List<AfT100ShohonEntity> 抄本情報
     */
    List<AfT100ShohonEntity> select抄本DDL(@Param("isシミュレーション") Boolean isシミュレーション,
            @Param("is過去分のみ") Boolean is過去分のみ,
            @Param("is過去分も含める") Boolean is過去分も含める,
            @Param("is海区") Boolean is海区,
            @Param("選挙時登録フラグ") Boolean 選挙時登録フラグ,
            @Param("isNotEq定時登録") Boolean isNotEq定時登録,
            @Param("isUseSenkyoShurui") Boolean isUseSenkyoShurui,
            @Param("senkyoShurui") RString senkyoShurui,
            @Param("kijunYmd") FlexibleDate kijunYmd, 
            @Param("名簿調製用連携の選挙種類List") List<RString> 名簿調製用連携の選挙種類List);
}
