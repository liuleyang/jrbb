/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.mastercsvoutput;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.mastercsvoutput.MasterCsvOutputMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput.CodeInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput.HojoshaInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput.TohyokuAFInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mastercsvoutput.TohyokuURInfoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.config.entity.UzT0001StandardConfigEntity;

/**
 * 各種マスタデータ出力のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0670-010 lis
 */
public interface IMasterCsvOutputMapper {

    /**
     * AF投票区情報を取得します。
     *
     * @param 選挙種類 Code
     * @return List<TohyokuAFInfoEntity>
     */
    List<TohyokuAFInfoEntity> select投票区AF情報(Code 選挙種類);

    /**
     * UR投票区情報を取得します。
     *
     * @param 選挙種類 Code
     * @return List<TohyokuURInfoEntity>
     */
    List<TohyokuURInfoEntity> select投票区UR情報(Code 選挙種類);

    /**
     * 補助者情報を取得します。
     *
     * @param parameter MasterCsvOutputMapperParameter
     * @return List<HojoshaInfoEntity>
     */
    List<HojoshaInfoEntity> select補助者情報(MasterCsvOutputMapperParameter parameter);

    /**
     * 補助者情報を取得します。
     *
     * @return List<HojoshaInfoEntity>
     */
    List<HojoshaInfoEntity> select補助者情報();

    /**
     * コンフィグを取得します。
     *
     * @return List<UzT0001StandardConfigEntity>
     */
    List<UzT0001StandardConfigEntity> selectコンフィグ();

    /**
     * 全コードを取得します。
     *
     * @return List<UzT0001StandardConfigEntity>
     */
    List<CodeInfoEntity> select全コード();

}
