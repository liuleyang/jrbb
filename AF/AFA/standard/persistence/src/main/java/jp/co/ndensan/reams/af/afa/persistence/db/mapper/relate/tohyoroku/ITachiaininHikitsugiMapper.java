/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyoroku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.tohyoroku.TachiaininHikitsugiMapperParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 立会人引継情報を管理するクラス。
 */
public interface ITachiaininHikitsugiMapper {

    /**
     * 検索キーに合致する立会人引継情報の氏名リストを取得します。
     *
     * @param 立会人引継情報検索条件 立会人引継情報検索条件
     * @return RString{@code list}
     */
    List<RString> select立会人引継情報氏名(TachiaininHikitsugiMapperParameter 立会人引継情報検索条件);
}
