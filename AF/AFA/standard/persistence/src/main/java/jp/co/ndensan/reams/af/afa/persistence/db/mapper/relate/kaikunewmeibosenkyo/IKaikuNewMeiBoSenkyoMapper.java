/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.kaikunewmeibosenkyo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.kaikunewmeibosenkyo.KaikuNewMeiBoSenkyoMapperParam;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import org.apache.ibatis.annotations.Param;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化Mapper <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
public interface IKaikuNewMeiBoSenkyoMapper {

    /**
     * 検索結果一覧を取得します。
     *
     * @param 年度 年度
     * @param 年度加 年度加
     * @return List<KaikuNewMeiBoSenkyoMapperParam>
     */
    List<KaikuNewMeiBoSenkyoMapperParam> select検索結果一覧(@Param("年度") FlexibleYear 年度, @Param("年度加") FlexibleYear 年度加);
}
