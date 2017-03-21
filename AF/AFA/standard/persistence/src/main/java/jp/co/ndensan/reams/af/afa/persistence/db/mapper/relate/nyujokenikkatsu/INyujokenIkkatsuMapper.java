/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisTokyo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201MeiciJyohouSoufusakiEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201NyujokenMaisuhyoEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201SoufusakiJouhouEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.NyujokenIkkatsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 入場券発行のマッパーインタフェースです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public interface INyujokenIkkatsuMapper {

    /**
     * 選挙人一括情報取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 選挙人情報 NyujokenKobetsuJouhou
     */
    List<NyujokenKobetsuJouhou> select選挙人情報リスト(NyujokenIkkatsuMybatisParameter param);

    /**
     * 前回基準日情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 選挙人情報 NyujokenKobetsuJouhou
     */
    NyujokenKobetsuJouhou select抄本の前回基準日(NyujokenIkkatsuMybatisParameter param);

    /**
     * 前回基準日情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 選挙人情報 NyujokenKobetsuJouhou
     */
    NyujokenKobetsuJouhou select選挙の転入期限日(NyujokenIkkatsuMybatisParameter param);

    /**
     * 名簿基準年月日を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 選挙人情報 NyujokenKobetsuJouhou
     */
    NyujokenKobetsuJouhou select選挙の名簿基準年月日(NyujokenIkkatsuMybatisParameter param);

    /**
     * 宛名識別対象を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 宛名識別対象 IdoSearchJuminShikakuEntity
     */
    IdoSearchJuminShikakuEntity select宛名識別対象(NyujokenIkkatsuMybatisParameter param);

    /**
     * 選挙人一括情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 選挙人情報 NyujokenKobetsuJouhou
     */
    List<NyujokenKobetsuJouhou> selectSenkyoninMeiciJyohouTempTable(NyujokenIkkatsuMybatisParameter param);

    /**
     * 送付先情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 選挙人情報 AFABTB201SoufusakiJouhouEntity
     */
    List<AFABTB201MeiciJyohouSoufusakiEntity> selectSoufusakiJouhouTempTable(NyujokenIkkatsuMybatisParameter param);

    /**
     * 入場券集計情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 入場券集計情報 AFABTB201NyujokenMaisuhyoEntity
     */
    List<AFABTB201NyujokenMaisuhyoEntity> selectNyujokenMaisuhyoTempTable(NyujokenIkkatsuMybatisParameter param);

    /**
     * 世帯一覧表情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 世帯一覧表情報 AFABTB201SoufusakiJouhouEntity
     */
    List<AFABTB201SoufusakiJouhouEntity> selectNninIjoSetaiListTempTable(NyujokenIkkatsuMybatisParameter param);

    /**
     * 投票所入場券情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 投票所入場券情報 AFABTB201MeiciJyohouSoufusakiEntity
     */
    List<AFABTB201MeiciJyohouSoufusakiEntity> selectMeiciJyohouSoufusakiTempTable(NyujokenIkkatsuMybatisParameter param);

    /**
     * 抄本情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 抄本情報 AfT100ShohonEntity
     */
    AfT100ShohonEntity selectAfT100ShohonTable(NyujokenIkkatsuMybatisParameter param);

    /**
     * 投票区一覧情報を取得する。
     *
     * @param 選挙種類 RString
     * @return List<NyujokenIkkatsuMybatisTokyo>
     */
    List<NyujokenIkkatsuMybatisTokyo> select投票区一覧(@Param("選挙種類") RString 選挙種類);

    /**
     * 投票区一覧情報を取得する。
     *
     * @return List<NyujokenIkkatsuMybatisTokyo>
     */
    List<NyujokenIkkatsuMybatisTokyo> select投票区一覧明細();

    /**
     * 選挙人明細情報取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 選挙人情報 NyujokenKobetsuJouhou
     */
    List<NyujokenIkkatsuEntity> select選挙人明細情報リスト(NyujokenIkkatsuMybatisParameter param);

    /**
     * 投票所入場券情報を取得する。
     *
     * @param param NyujokenIkkatsuMybatisParameter
     * @return 投票所入場券情報 AFABTB201MeiciJyohouSoufusakiEntity
     */
    List<AFABTB201MeiciJyohouSoufusakiEntity> selectJyohouSoufusakiTempTable(NyujokenIkkatsuMybatisParameter param);
}
