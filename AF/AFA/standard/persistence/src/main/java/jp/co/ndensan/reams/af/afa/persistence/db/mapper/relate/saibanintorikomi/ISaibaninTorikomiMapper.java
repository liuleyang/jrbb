/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.saibanintorikomi;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.saibanintorikomi.SaibaninTorikomiMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT302SaibaninYoteishaEntity;

/**
 * 裁判員候補者予定者取込のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0310-010 guancy
 */
public interface ISaibaninTorikomiMapper {

    /**
     * 裁判員候補者予定者取込一時テーブル作成。
     *
     */
    void createSaibaninTorikomiTemp();

    /**
     * 裁判員候補者予定者取込一時テーブル削除。
     *
     */
    void dropSaibaninTorikomiTemp();

    /**
     * 裁判員候補者予定者取込一時テーブルデータセット
     *
     * @param parameter SaibaninTorikomiMapperParameter
     */
    void insertSaibaninTorikomiTemp(SaibaninTorikomiMapperParameter parameter);

    /**
     * 裁判員候補者予定者取込一時テーブルデータセット
     *
     * @param parameter SaibaninTorikomiMapperParameter
     * @return List<AfT302SaibaninYoteishaEntity>
     */
    List<AfT302SaibaninYoteishaEntity> select裁判員候補者予定者情報(SaibaninTorikomiMapperParameter parameter);

}
