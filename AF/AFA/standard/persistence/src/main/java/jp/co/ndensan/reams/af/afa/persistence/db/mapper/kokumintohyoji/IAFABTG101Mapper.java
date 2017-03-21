/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeijiTourokuDataUpdateZaigaiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeiseishaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.SenkyojiTourokuDataDeleteEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtg101.NigoShikakuChosahyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtg101.TohyoninMeiboTorokushasuListEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.IchigoShikakuTorokuTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.KokuminTohyojiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.NigoShikakuKohoshaListEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 国民投票時帳票データ検索用マッパーのインタフェースです。
 *
 * @reamsid_L AF-0360-052 qiuxy
 */
public interface IAFABTG101Mapper {

    /**
     * 宛名情報の検索。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 宛名情報List
     */
    List<UaFt200FindShikibetsuTaishoEntity> selectKokuminTohyojiDataList(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * データ削除の検索。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 削除List
     */
    List<SenkyojiTourokuDataDeleteEntity> selectKokuminTohyojiDataDeleteTrgt(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 選挙時登録データ(抄本)削除用情報を取得します。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 国民投票時登録データ削除用抄本情報 List<AfT100ShohonEntity>
     */
    List<AfT100ShohonEntity> selectKokuminTohyojiDataDeleteTrgtShohon(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 国民投票時登録データ更新用情報を取得します。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 国民投票時登録データ更新用情報 List<TeijiTourokuDataUpdateSenkyoninMeiboEntity>
     */
    List<TeijiTourokuDataUpdateSenkyoninMeiboEntity> selectSenkyoNinTouhyouJyohouTempTableList(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 在外選挙人名簿の検索。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 選挙人資格List
     */
    List<TeijiTourokuDataUpdateZaigaiEntity> select在外選挙人名簿By抄本番号(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 補正登録者名簿を取得します。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 補正登録者名簿データリスト List< KokuminTohyojiEntity>
     */
    List<TorokushaMeiboEntity> selectHoseiTorokushaMeibo(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 抹消者名簿を取得します。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 抹消者名簿データリスト List< KokuminTohyojiEntity>
     */
    List<TorokushaMeiboEntity> selectMasshoshaMeibo(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 登録者数リストを取得します。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 登録者数リスト List< KokuminTohyojiEntity>
     */
    List<TohyoninMeiboTorokushasuListEntity> selectTohyoninMeiboTorokushasuList(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 2号資格調査票（照会）（様式2-1）を取得します。
     *
     * @param mybatisParameter KokuminTohyojiMybatisParameter
     * @return 2号資格調査票（照会）（様式2-1）のデータリスト List< KokuminTohyojiEntity>
     */
    List<NigoShikakuChosahyoEntity> selectNigoShikakuChosahyo(KokuminTohyojiMybatisParameter mybatisParameter);

    /**
     * 未登録者抹消通知一覧表を取得します。
     *
     * @param mybatisparameter KokuminTohyojiMybatisParameter
     * @return 未登録者抹消通知一覧表 List< KokuminTohyojiEntity>
     */
    List<KokuminTohyojiEntity> selectMitorokushaMasshoTsuchiList(KokuminTohyojiMybatisParameter mybatisparameter);

    /**
     * 国内転入者調査一覧表を取得します。
     *
     * @param mybatisparameter KokuminTohyojiMybatisParameter
     * @return 国内転入者調査一覧表 List< KokuminTohyojiEntity>
     */
    List<KokuminTohyojiEntity> selectKokunaiTennyushaChosahyoList(KokuminTohyojiMybatisParameter mybatisparameter);

    /**
     * 国外転入者調査一覧表を取得します。
     *
     * @param mybatisparameter KokuminTohyojiMybatisParameter
     * @return 国外転入者調査一覧表 List< KokuminTohyojiEntity>
     */
    List<KokuminTohyojiEntity> selectKokugaiTennyushaChosahyoList(KokuminTohyojiMybatisParameter mybatisparameter);

    /**
     * 2号資格調査一覧表を取得します。
     *
     * @param mybatisparameter KokuminTohyojiMybatisParameter
     * @return 2号資格調査一覧表 List< MitorokushaMasshoTsuchiListEntity>
     */
    List<MitorokushaMasshoTsuchiListEntity> selectNigoShikakuChosahyoList(KokuminTohyojiMybatisParameter mybatisparameter);

    /**
     * 1号資格登録通知出力情報を取得します。
     *
     * @param mybatisparameter KokuminTohyojiMybatisParameter
     * @return 1号資格登録通知出力情報 List< IchigoShikakuTorokuTsuchiListEntity>
     */
    List<IchigoShikakuTorokuTsuchiListEntity> ichigoShikakuTorokuTsuchiList(KokuminTohyojiMybatisParameter mybatisparameter);

    /**
     * 2号資格候補者一覧表情報を取得します。
     *
     * @param mybatisparameter KokuminTohyojiMybatisParameter
     * @return 2号資格候補者一覧表情報 List< NigoShikakuKohoshaListEntity>
     */
    List<NigoShikakuKohoshaListEntity> selectNigoShikakuKohoshaList(KokuminTohyojiMybatisParameter mybatisparameter);

    /**
     * 訂正者名簿用情報を取得します。
     *
     * @param mybatisparameter KokuminTohyojiMybatisParameter
     * @return 訂正者名簿情報 List<TeiseishaMeiboEntity>
     */
    List<TeiseishaMeiboEntity> selectTeiseishaList(KokuminTohyojiMybatisParameter mybatisparameter);
}
