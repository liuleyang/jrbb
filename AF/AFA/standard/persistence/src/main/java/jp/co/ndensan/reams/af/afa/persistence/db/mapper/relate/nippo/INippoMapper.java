/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPrintEntity;

/**
 * 日報関連帳票のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public interface INippoMapper {

    /**
     * 期日前投票日報帳票情報を取得します。
     *
     * @param 期日前投票日報帳票検索条件 NippoMybatisParameter
     * @return List<NippoPrintEntity>
     */
    List<NippoPSMPrintEntity> select期日前投票日報リスト(NippoMybatisParameter 期日前投票日報帳票検索条件);

    /**
     * 不在者投票日報交付帳票情報を取得します。
     *
     * @param 不在者投票日報交付帳票検索条件 NippoMybatisParameter
     * @return List<NippoPrintEntity>
     */
    List<NippoPSMPrintEntity> select不在者投票日報交付リスト(NippoMybatisParameter 不在者投票日報交付帳票検索条件);

    /**
     * 不在者投票日報受理帳票情報を取得します。
     *
     * @param 不在者投票日報受理帳票検索条件 NippoMybatisParameter
     * @return List<NippoPrintEntity>
     */
    List<NippoPSMPrintEntity> select不在者投票日報受理リスト(NippoMybatisParameter 不在者投票日報受理帳票検索条件);

    /**
     * 期日前投票者一覧表帳票情報を取得します。
     *
     * @param 期日前投票者一覧表帳票検索条件 NippoMybatisParameter
     * @return List<NippoPrintEntity>
     */
    List<NippoPSMPrintEntity> select期日前投票者一覧表リスト(NippoMybatisParameter 期日前投票者一覧表帳票検索条件);

    /**
     * 不在者投票者一覧表帳票情報を取得します。
     *
     * @param 不在者投票者一覧表帳票検索条件 NippoMybatisParameter
     * @return List<NippoPSMPrintEntity>
     */
    List<NippoPSMPrintEntity> select不在者投票者一覧表リスト(NippoMybatisParameter 不在者投票者一覧表帳票検索条件);

    /**
     * 投票者一覧表全帳票情報を取得します。
     *
     * @param 投票者一覧表全帳票検索条件 NippoMybatisParameter
     * @return List<NippoPSMPrintEntity>
     */
    List<NippoPSMPrintEntity> select投票者一覧表全リスト(NippoMybatisParameter 投票者一覧表全帳票検索条件);

    /**
     * 投票者一覧表選挙全帳票情報を取得します。
     *
     * @param 投票者一覧表選挙全帳票検索条件 NippoMybatisParameter
     * @return List<NippoPSMPrintEntity>
     */
    List<NippoPSMPrintEntity> select投票者一覧表選挙全リスト(NippoMybatisParameter 投票者一覧表選挙全帳票検索条件);

    /**
     * 投票者一覧期日前帳票情報を取得します。
     *
     * @param 投票者一覧期日前表帳票検索条件 NippoMybatisParameter
     * @return List<NippoPSMPrintEntity>
     */
    List<NippoPSMPrintEntity> select投票者一覧期日前表(NippoMybatisParameter 投票者一覧期日前表帳票検索条件);

    /**
     * 投票者一覧選挙期日前帳票情報を取得します。
     *
     * @param 投票者一覧選挙期日前表帳票検索条件 NippoMybatisParameter
     * @return List<NippoPSMPrintEntity>
     */
    List<NippoPSMPrintEntity> select投票者一覧選挙期日前表(NippoMybatisParameter 投票者一覧選挙期日前表帳票検索条件);

    /**
     * 投票者一覧不在者表帳票情報を取得します。
     *
     * @param 投票者一覧不在者表帳票検索条件 NippoMybatisParameter
     * @return List<NippoPSMPrintEntity>
     */
    List<NippoPSMPrintEntity> select投票者一覧不在者表(NippoMybatisParameter 投票者一覧不在者表帳票検索条件);

    /**
     * 投票者一覧選挙不在者表帳票情報を取得します。
     *
     * @param 投票者一覧選挙不在者表帳票検索条件 NippoMybatisParameter
     * @return List<NippoPSMPrintEntity>
     */
    List<NippoPSMPrintEntity> select投票者一覧選挙不在者表(NippoMybatisParameter 投票者一覧選挙不在者表帳票検索条件);

    /**
     * 期日前投票の事由に関する調書帳票情報を取得します。
     *
     * @param 期日前投票の事由に関する調書帳票検索条件 NippoMybatisParameter
     * @return List<NippoPrintEntity>
     */
    List<NippoPrintEntity> select期日前投票の事由に関する調書(NippoMybatisParameter 期日前投票の事由に関する調書帳票検索条件);

    /**
     * 不在者投票の事由に関する調書帳票情報を取得します。
     *
     * @param 不在者投票の事由に関する調書帳票検索条件 NippoMybatisParameter
     * @return List<NippoPrintEntity>
     */
    List<NippoPrintEntity> select不在者投票の事由に関する調書(NippoMybatisParameter 不在者投票の事由に関する調書帳票検索条件);

    /**
     * 投票集計整理帳票情報を取得します。
     *
     * @param 受理日だけの集計帳票検索条件 NippoMybatisParameter
     * @return List<NippoPSMPrintEntity>
     */
    List<NippoPSMPrintEntity> select投票集計整理(NippoMybatisParameter 受理日だけの集計帳票検索条件);

}
