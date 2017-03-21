/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyojizaisanku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT142TohyokuConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT144JushoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojizaisanku.SenkyojiZaisankuEntity;

/**
 * 財産区議会議員選挙時登録のマッパーインタフェースです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public interface ISenkyojiZaisankuMapper {

    /**
     * 宛名識別対象情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 宛名識別対象情報 List<SenkyojiZaisankuEntity>
     */
    List<SenkyojiZaisankuEntity> select宛名識別対象情報(AFABTL101SelectProcessMyBatisParameter parameter);

    /**
     * 財産区選挙人名簿抄本縦覧情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 財産区選挙人名簿抄本縦覧情報 List<SenkyojiZaisankuEntity>
     */
    List<SenkyojiZaisankuEntity> select財産区選挙人名簿抄本縦覧情報(AFABTL101SelectProcessMyBatisParameter parameter);

    /**
     * 抄本情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 財産区選挙人名簿抄本情報 List<AfT100ShohonEntity>
     */
    List<AfT100ShohonEntity> select抄本By抄本番号(AFABTL101SelectProcessMyBatisParameter parameter);

    /**
     * 選挙情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 財産区選挙人名簿抄本情報 List<AfT111SenkyoEntity>
     */
    List<AfT111SenkyoEntity> select選挙By抄本番号(AFABTL101SelectProcessMyBatisParameter parameter);

    /**
     * 選挙人名簿情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 財産区選挙人名簿抄本情報 List<AfT112SenkyoninMeiboEntity>
     */
    List<AfT112SenkyoninMeiboEntity> select選挙人名簿By抄本番号(AFABTL101SelectProcessMyBatisParameter parameter);

    /**
     * 住民投票選挙人抽出条件情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 財産区選挙人名簿抄本情報 List<AfT141ZaisankuJuminTohyoConditionEntity>
     */
    List<AfT141ZaisankuJuminTohyoConditionEntity> select住民投票選挙人抽出条件By抄本番号(AFABTL101SelectProcessMyBatisParameter parameter);

    /**
     * 投票区抽出条件情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 財産区選挙人名簿抄本情報 List<AfT142TohyokuConditionEntity>
     */
    List<AfT142TohyokuConditionEntity> select投票区抽出条件By抄本番号(AFABTL101SelectProcessMyBatisParameter parameter);

    /**
     * 住所抽出条件情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 財産区選挙人名簿抄本情報 List<AfT144JushoConditionEntity>
     */
    List<AfT144JushoConditionEntity> select住所抽出条件By抄本番号(AFABTL101SelectProcessMyBatisParameter parameter);

    /**
     * 投票区抽出条件情報を取得する。
     *
     * @param parameter AFABTL101SelectProcessMyBatisParameter
     * @return 財産区選挙人名簿抄本情報 List<AfT142TohyokuConditionEntity>
     */
    List<AfT142TohyokuConditionEntity> select投票区抽出条件(AFABTL101SelectProcessMyBatisParameter parameter);

}
