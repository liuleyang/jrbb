/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT131KaikuSenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku.TempSenkyoninMeiboEntity;

/**
 * 海区漁業調整委員会委員選挙時登録のマッパクラスのインタフェースです。
 *
 *
 * @reamsid_L AF-0470-030 jihb
 */
public interface ISenkyojiKaikuMapper {

    /**
     * 宛名識別対象を取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select宛名識別対象1(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 宛名識別対象を取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select宛名識別対象(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 選挙人名簿抄本データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return SenkyojiKaikuEntity List<SenkyojiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select選挙人名簿抄本(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 選挙人名簿抄本縦覧データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return SenkyojiKaikuEntity List<SenkyojiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select選挙人名簿抄本縦覧(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 登録者数リストデータを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select登録者数リスト(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 抄本番号を取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return MeiboSakuseiKaikuEntity List<MeiboSakuseiKaikuEntity>
     */
    List<AfT100ShohonEntity> select抄本番号(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 抄本データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 住民投票時登録対象 JuminTohyojiEntity
     */
    List<AfT100ShohonEntity> select抄本By抄本番号(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 選挙データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 選挙データ AfT111SenkyoEntity
     */
    List<AfT111SenkyoEntity> select選挙By抄本番号(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 選挙データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<AfT112SenkyoninMeiboEntity> select選挙人名簿By抄本番号(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 選挙データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<TempSenkyoninMeiboEntity> selectTempMeiboBy抄本番号(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 海区名簿更新日データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<AfT131KaikuSenkyoEntity> select海区名簿更新日By抄本番号(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 海区付随情報データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<AfT133KaikuSenkyoFuzuiEntity> select海区付随情報By抄本番号(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 選挙資格データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<AfT113SenkyoShikakuEntity> select選挙資格By抄本番号(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 選挙人名簿の識別コードを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return 選挙人名簿データ AfT112SenkyoninMeiboEntity
     */
    List<SenkyojiKaikuEntity> select選挙人名簿の識別コードBy抄本番号(SenkyojiKaikuMybatisParameter parameter);

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
     * 登録者名簿データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return SenkyojiKaikuEntity List<SenkyojiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select登録者名簿データ(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 登録者名簿データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return SenkyojiKaikuEntity List<SenkyojiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select登録者名簿縦覧データ(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 抹消者名簿帳票データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return SenkyojiKaikuEntity List<SenkyojiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select抹消者名簿帳票データ(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 表示者名簿データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return SenkyojiKaikuEntity List<SenkyojiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select表示者名簿データ(SenkyojiKaikuMybatisParameter parameter);

    /**
     * 失権者名簿データを取得する。
     *
     * @param parameter SenkyojiKaikuMybatisParameter
     * @return SenkyojiKaikuEntity List<SenkyojiKaikuEntity>
     */
    List<SenkyojiKaikuEntity> select失権者名簿データ(SenkyojiKaikuMybatisParameter parameter);

}
