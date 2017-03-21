/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.EikyuSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.SakuinboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataDeleteEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateZaigaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushasuListDataEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.YukenshasuListDataEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFABTA101tempTblEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFABTA101tempTblForSelectEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 宛名識別対象取得データのマッパクラスのインタフェースです。
 *
 */
public interface IAFABTA101Mapper {

    /**
     * 選挙人投票情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectTeijiTourokuList(BatchMybatisParameter mybatisparameter);

    /**
     * 宛名一時テーブルを取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 宛名一時テーブル List<AFABTA101tempTblEntity>
     */
    List<AFABTA101tempTblEntity> selectTempTable(BatchMybatisParameter mybatisparameter);

    /**
     * 宛名一時テーブルを更新します。
     *
     * @param updateParam Map<String, Object>
     */
    void updateTempTable(Map<String, Object> updateParam);

    /**
     * 前回基準日を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙情報 AfT111SenkyoEntity
     */
    AfT111SenkyoEntity selectLastKijunYMD(BatchMybatisParameter mybatisparameter);

    /**
     * 選挙人投票情報を取得します。(宛名一時テーブル)
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<AFABTA101tempTblForSelectEntity>
     */
    List<AFABTA101tempTblForSelectEntity> selectSenkyoNinTouhyouJyohouTempTableList(BatchMybatisParameter mybatisparameter);

    /**
     * 削除条件を取得します。
     *
     * @param kijunbi FlexibleDate
     * @return 削除条件 List<AfT100ShohonEntity>
     */
    List<AfT100ShohonEntity> selectSakujyoJyouken(@Param("kijunbi") FlexibleDate kijunbi);

    /**
     * 選挙人名簿の削除。
     *
     * @param 抄本番号List List<ShohonNo>
     */
    void deleteMeiboBy抄本番号List(@Param("shohonLst") List<ShohonNo> 抄本番号List);

    /**
     * 選挙の削除。
     *
     * @param 抄本番号List List<ShohonNo>
     */
    void deleteSenkyoBy抄本番号List(@Param("shohonLst") List<ShohonNo> 抄本番号List);

    /**
     * 在外選挙人名簿の削除。
     *
     * @param 抄本番号List List<ShohonNo>
     */
    void deleteZaigaiBy抄本番号List(@Param("shohonLst") List<ShohonNo> 抄本番号List);

    /**
     * 抄本の削除。
     *
     * @param 抄本番号List List<ShohonNo>
     */
    void deleteShohonBy抄本番号List(@Param("shohonList") List<ShohonNo> 抄本番号List);

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
     * @param 識別コードList 識別コードList
     * @return 選挙人名簿List
     */
    List<AfT112SenkyoninMeiboEntity> selectSenkyoNinMeiboList(@Param("shikibetsuCdList") List<ShikibetsuCode> 識別コードList);

    /**
     * 選挙人名簿の新規。
     *
     * @param 選挙人名簿 AfT112SenkyoninMeiboEntity
     */
    void insertSenkyoNinMeibo(AfT112SenkyoninMeiboEntity 選挙人名簿);

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
     * 在外選挙人名簿の検索。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人資格List
     */
    List<TeijiTourokuDataUpdateZaigaiEntity> select在外選挙人名簿By抄本番号(BatchMybatisParameter mybatisparameter);

    /**
     * 在外選挙資格の対象の識別コード検索。
     *
     * @param 基準日 基準日
     * @return 識別コードList
     */
    List<ShikibetsuCode> selectZaigaiSenkyoShikakuShikibetsuCodeList(@Param("kijunYMD") FlexibleDate 基準日);

    /**
     * 在外選挙人名簿 の新規。
     *
     * @param 在外選挙人 在外選挙人
     */
    void insert在外選挙人名簿(AfT121ZaigaiSenkyoninMeiboEntity 在外選挙人);

    /**
     * 3.0帳票共通出力用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectSenkyoninSakuinboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.1選挙人名簿抄本用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectSenkyoninMeiboShohon(BatchMybatisParameter mybatisparameter);

    /**
     * 3.2永久選挙人名簿出力用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<EikyuSenkyoninMeiboEntity> selectEikyuMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.3選挙人名簿５０音順用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SakuinboEntity>
     */
    List<SakuinboEntity> selectSakuinbo50List(BatchMybatisParameter mybatisparameter);

    /**
     * 3.3選挙人名簿投票区別５０音順用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SakuinboEntity>
     */
    List<SakuinboEntity> selectSakuinboTouhyo50List(BatchMybatisParameter mybatisparameter);

    /**
     * 3.4登録者数リスト一時テーブルを取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 登録者数リスト List<TorokushasuListDataEntity>
     */
    List<TorokushasuListDataEntity> selectSenkyoNinTouhyouJyohouList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.5有権者数調べ用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 有権者数調べ List<YukenshasuListDataEntity>
     */
    List<YukenshasuListDataEntity> selectYukensyaKazuShirabeList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.6二重登録通知用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectNijuTorokuList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.6二重登録通知一覧表用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectNijuTorokuIchirannList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.7登録者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectTorokusyaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.8帰化対象者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectKikaTaishoshaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.9抹消者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectMasshoshaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.10居住要件抹消者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectKyojuMasshoshaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.11表示者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectHyojishaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.12表示消除者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectHyojiShojyoshaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.13規定年齢前名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectKiteiNenreiMaeMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.14規定年齢未到達者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectMitotatsushaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.15再転入者判断用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectSaiTennyushaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.16　訂正者名簿 訂正後データを取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectTeiseishaListAfter(BatchMybatisParameter mybatisparameter);

    /**
     * 3.16.1　訂正者名簿 訂正前データを取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectTeiseishaListBefore(BatchMybatisParameter mybatisparameter);

    /**
     * 3.17転出者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<TorokushaMeiboEntity>
     */
    List<TorokushaMeiboEntity> selectTenshutsushaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 3.18登録停止者名簿用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 選挙人一覧情報 List<SenkyoninTohyoJokyoEntity>
     */
    List<SenkyoninTohyoJokyoEntity> selectTorokuTeishishaMeiboList(BatchMybatisParameter mybatisparameter);

    /**
     * 定時登録データ削除用情報を取得します。
     *
     * @param mybatisparameter TeijiTourokuDataDeleteMybatisParameter
     * @return 定時登録データ削除用情報 List<TeijiTourokuDataDeleteEntity>
     */
    List<TeijiTourokuDataDeleteEntity> selectTeijiTourokuDataDeleteTrgt(TeijiTourokuDataDeleteMybatisParameter mybatisparameter);

    /**
     * 定時登録データ(抄本)削除用情報を取得します。
     *
     * @param mybatisparameter TeijiTourokuDataDeleteMybatisParameter
     * @return 定時登録データ削除用抄本情報 List<AfT100ShohonEntity>
     */
    List<AfT100ShohonEntity> selectTeijiTourokuDataDeleteShohonTrgt(TeijiTourokuDataDeleteMybatisParameter mybatisparameter);

    /**
     * 定時登録データ更新用情報を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return 定時登録データ削除用情報 List<TeijiTourokuDataUpdateSenkyoninMeiboEntity>
     */
    List<TeijiTourokuDataUpdateSenkyoninMeiboEntity> selectTeijiTourokuDataUpdateTrgtSenkyoninMeibo(BatchMybatisParameter mybatisparameter);

    /**
     * 二重登録系の帳票作成条件を取得します。
     *
     * @param mybatisparameter BatchMybatisParameter
     * @return AfT111SenkyoEntity List<AfT111SenkyoEntity>
     */
    List<AfT111SenkyoEntity> selectNijuTorokuHandanJoken(BatchMybatisParameter mybatisparameter);

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
