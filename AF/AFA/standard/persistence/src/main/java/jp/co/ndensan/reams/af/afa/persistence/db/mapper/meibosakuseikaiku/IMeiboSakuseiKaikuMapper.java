/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibosakuseikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.MeiboSakuseiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.MeiboShohonKaikuDbMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectShohonNoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectTempTableMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboSakuseiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibosakuseikaiku.MeiboTempTableEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.AFABTK101tempTblEntity;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成クラスです。
 *
 * @reamsid_L AF-0460-020 wanghj
 */
public interface IMeiboSakuseiKaikuMapper {

    /**
     * 宛名識別対象を取得する。
     *
     * @param parameter MeiboSakuseiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<MeiboSakuseiKaikuEntity> select宛名識別対象(MeiboSakuseiKaikuMybatisParameter parameter);

    /**
     * select登録者数リストデータを取得する。
     *
     * @param parameter MeiboShohonKaikuDbMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<MeiboSakuseiKaikuEntity> select登録者数リスト(MeiboShohonKaikuDbMybatisParameter parameter);

    /**
     * 選挙人名簿抄本データを取得する。
     *
     * @param parameter MeiboSakuseiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<MeiboSakuseiKaikuEntity> select選挙人名簿抄本(MeiboShohonKaikuDbMybatisParameter parameter);

    /**
     * 選挙人名簿抄本データを取得する。
     *
     * @param parameter MeiboSakuseiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<MeiboTempTableEntity> select申請書リスト(SelectTempTableMybatisParameter parameter);

    /**
     * 抄本番号を取得する。
     *
     * @param parameter MeiboSakuseiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<AfT100ShohonEntity> select抄本番号(MeiboSakuseiKaikuMybatisParameter parameter);

    /**
     * 抄本データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 住民投票時登録対象 JuminTohyojiEntity
     */
    List<AfT100ShohonEntity> select抄本By抄本番号(SelectShohonNoMybatisParameter parameter);

    /**
     * 選挙データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 選挙データ AfT111SenkyoEntity
     */
    List<AfT111SenkyoEntity> select選挙By抄本番号(SelectShohonNoMybatisParameter parameter);

    /**
     * 選挙データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<AfT112SenkyoninMeiboEntity> select選挙人名簿By抄本番号(SelectShohonNoMybatisParameter parameter);

    /**
     * 海区名簿更新日データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<AfT131KaikuSenkyoEntity> select海区名簿更新日By抄本番号(SelectShohonNoMybatisParameter parameter);

    /**
     * 海区付随情報データを取得する。
     *
     * @param parameter JuminTohyojiDelMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<AfT133KaikuSenkyoFuzuiEntity> select海区付随情報By抄本番号(SelectShohonNoMybatisParameter parameter);

    /**
     * 組合マスタデータを取得する。
     *
     * @return 組合マスタデータ List<AfT509KumiaiEntity>
     */
    List<AfT509KumiaiEntity> select組合マスタ();

    /**
     * 投票区データを取得する。
     *
     * @return 投票区データ List<AfT501TohyokuEntity>
     */
    List<AfT501TohyokuEntity> select投票区データ();

    /**
     * 一時テーブルデータを取得する。
     *
     * @param parameter SelectTempTableMybatisParameter
     *
     * @return 投票区データ List<AFABTK101tempTblEntity>
     */
    List<AFABTK101tempTblEntity> select一時テーブル(SelectTempTableMybatisParameter parameter);

    /**
     * 識別コードないのデータを取得する。
     *
     * @param parameter SelectTempTableMybatisParameter
     *
     * @return 投票区データ List<AfT501TohyokuEntity>
     */
    List<MeiboTempTableEntity> select識別コードない(SelectTempTableMybatisParameter parameter);

    /**
     * 識別コードあるのデータを取得する。
     *
     * @return 投票区データ List<AfT501TohyokuEntity>
     *
     * @param parameter SelectTempTableMybatisParameter
     */
    List<MeiboTempTableEntity> select識別コードある(SelectTempTableMybatisParameter parameter);

}
