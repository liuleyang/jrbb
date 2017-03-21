/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateZaigaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.FuzaiShikakushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.NijuTorokuChosaKaitoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.NijuTorokuChosaShokaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.SenkyojiTourokuDataDeleteEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFABTA101tempTblEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 宛名識別対象取得データのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public interface IAFABTB101Mapper {

    /**
     * 選挙人投票情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectSenkyoNinTouhyouJyohouList(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 宛名一時テーブルを取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 宛名一時テーブル List<AFABTA101tempTblEntity>
     */
    List<AFABTA101tempTblEntity> selectTempTable(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 宛名一時テーブルを更新します。
     *
     * @param updateParam Map
     */
    void updateTempTable(Map<String, Object> updateParam);

    /**
     * 削除条件を取得します。
     *
     * @param kijunbi FlexibleDate
     * @return 削除条件 List<AfT100ShohonEntity>
     */
    List<AfT100ShohonEntity> selectSakujyoJyouken(@Param("kijunbi") FlexibleDate kijunbi);

    /**
     * 表示消除予定者名簿用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectHyojishojoYoteishaMeiboList(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 登録者数リスト（不在者投票資格者分）名簿用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectTorokushasuListFuzaiShikaku(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 不在者投票資格者分名簿用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 不在者投票資格者情報 List<FuzaiShikakushaMeiboEntity>
     */
    List<FuzaiShikakushaMeiboEntity> selectselectFuzaiShikakushaMeibo(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 在外選挙人名簿抄本名簿用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectSenkyoninmeiboshohonWithZaigai(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 二重登録調査票用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectNijuTorokuIchirannList(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 二重登録調査票用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectNijuTorokuChosaIchiran(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 二重登録調査票（回答）用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 二重登録調査票（回答）情報 List<NijuTorokuChosaKaitoEntity>
     */
    List<NijuTorokuChosaKaitoEntity> selectNijuTorokuChosaKaito(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 二重登録調査票（照会）用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 二重登録調査票（照会）情報 List<NijuTorokuChosaShokaiEntity>
     */
    List<NijuTorokuChosaShokaiEntity> selectNijuTorokuChosaShokai(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 抹消予定者名簿用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectMasshoYoteishaMeiboList(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 失権者名簿用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectShikkenshaMeiboList(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 選挙人名簿の削除。
     *
     * @param 抄本番号List List
     */
    void deleteMeiboBy抄本番号List(@Param("shohonList") List<ShohonNo> 抄本番号List);

    /**
     * 投票状況の削除。
     *
     * @param 抄本番号List List
     */
    void deleteTohyoJyokyoBy抄本番号List(@Param("shohonLst") List<ShohonNo> 抄本番号List);

    /**
     * 選挙の削除。
     *
     * @param 抄本番号List List
     */
    void deleteSenkyoBy抄本番号List(@Param("shohonLst") List<ShohonNo> 抄本番号List);

    /**
     * 抄本の削除。
     *
     * @param 抄本番号List List
     */
    void deleteShohonBy抄本番号List(@Param("shohonLst") List<ShohonNo> 抄本番号List);

    /**
     * 抄本の新規。
     *
     * @param 抄本 AfT100ShohonEntity
     */
    void insertShohon(AfT100ShohonEntity 抄本);

    /**
     * 抄本名の取得。
     *
     * @param 抄本番号 ShohonNo
     * @return 抄本名
     */
    RString selectShohonName(@Param("shohonNo") ShohonNo 抄本番号);

    /**
     * 選挙の新規。
     *
     * @param 選挙 AfT111SenkyoEntity
     */
    void insertSenkyo(AfT111SenkyoEntity 選挙);

    /**
     * 選挙人名簿の検索。
     *
     * @param 抄本番号 ShohonNo
     * @param 識別コード ShikibetsuCode
     * @return AfT112SenkyoninMeiboEntity
     */
    AfT112SenkyoninMeiboEntity selectSenkyoNinMeibo(@Param("shohonNo") ShohonNo 抄本番号, @Param("shikibetsuCd") ShikibetsuCode 識別コード);

    /**
     * 選挙人名簿の新規。
     *
     * @param 選挙人名簿 AfT112SenkyoninMeiboEntity
     */
    void insertSenkyoNinMeibo(AfT112SenkyoninMeiboEntity 選挙人名簿);

    /**
     * 選挙人資格の検索。
     *
     * @param 識別コード ShikibetsuCode
     * @return 選挙人資格
     */
    AfT113SenkyoShikakuEntity selectSenkyoShikaku(@Param("shikibetsuCd") ShikibetsuCode 識別コード);

    /**
     * 選挙人名簿の検索。
     *
     * @param 識別コードList 識別コードList
     * @return 選挙人名簿List
     */
    List<AfT112SenkyoninMeiboEntity> selectSenkyoNinMeiboList(@Param("shikibetsuCdList") List<ShikibetsuCode> 識別コードList);

    /**
     * 選挙人資格の検索。
     *
     * @param 識別コードList 識別コードList
     * @return 選挙人資格List
     */
    List<AfT113SenkyoShikakuEntity> selectSenkyoShikakuList(@Param("shikibetsuCdList") List<ShikibetsuCode> 識別コードList);

    /**
     * 選挙人資格の新規。
     *
     * @param 選挙人資格 AfT113SenkyoShikakuEntity
     */
    void insertSenkyoShikaku(AfT113SenkyoShikakuEntity 選挙人資格);

    /**
     * 二重登録系の帳票作成条件を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return AfT111SenkyoEntity List<AfT111SenkyoEntity>
     */
    List<AfT111SenkyoEntity> selectSenkyojiNijuTorokuHandanJoken(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 前回基準日を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙情報 AfT111SenkyoEntity
     */
    AfT111SenkyoEntity selectLastKijunYMD(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 選挙時登録データ削除用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙時登録データ削除用情報 List<SenkyojiTourokuDataDeleteEntity>
     */
    List<SenkyojiTourokuDataDeleteEntity> selectSenkyojiTourokuDataDeleteTrgt(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 選挙時登録データ(抄本)削除用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙時登録データ削除用抄本情報 List<AfT100ShohonEntity>
     */
    List<AfT100ShohonEntity> selectSenkyojiTourokuDataDeleteTrgtShohon(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 選挙時登録データ更新用情報を取得します。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙時登録データ更新用情報 List<TeijiTourokuDataUpdateSenkyoninMeiboEntity>
     */
    List<TeijiTourokuDataUpdateSenkyoninMeiboEntity> selectSenkyoNinTouhyouJyohouTempTableList(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 在外選挙人名簿の検索。
     *
     * @param mybatisparameter SenkyojiMybatisParameter
     * @return 選挙人資格List
     */
    List<TeijiTourokuDataUpdateZaigaiEntity> select在外選挙人名簿By抄本番号(SenkyojiMybatisParameter mybatisparameter);

    /**
     * 選挙人名簿の削除。
     *
     * @param mybatisparameter TeijiTourokuDataDeleteMybatisParameter
     */
    void deleteMeibo(TeijiTourokuDataDeleteMybatisParameter mybatisparameter);

    /**
     * 選挙の削除。
     *
     * @param mybatisparameter TeijiTourokuDataDeleteMybatisParameter
     */
    void deleteSenkyo(TeijiTourokuDataDeleteMybatisParameter mybatisparameter);

    /**
     * 在外選挙人名簿の削除。
     *
     * @param mybatisparameter TeijiTourokuDataDeleteMybatisParameter
     */
    void deleteZaigai(TeijiTourokuDataDeleteMybatisParameter mybatisparameter);

    /**
     * 抄本の削除。
     *
     * @param mybatisparameter TeijiTourokuDataDeleteMybatisParameter
     */
    void deleteShohon(TeijiTourokuDataDeleteMybatisParameter mybatisparameter);

}
