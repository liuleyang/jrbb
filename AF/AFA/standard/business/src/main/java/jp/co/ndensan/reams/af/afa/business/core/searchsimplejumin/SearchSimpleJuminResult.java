/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.searchsimplejumin;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.searchsimplejumin.SearchSimpleJuminEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索（簡易版）の選挙人情報取得Resultクラスです。
 *
 * @reamsid_L AF-0170-020 lis
 */
public class SearchSimpleJuminResult {

    private final SearchSimpleJuminEntity 選挙人情報;

    /**
     * 選挙人情報を戻します。
     *
     * @return SearchSimpleJuminEntity
     */
    public SearchSimpleJuminEntity get選挙人情報() {
        return 選挙人情報;
    }

    /**
     * コンストラクタです。
     *
     * @param entity SearchSimpleJuminEntity
     */
    public SearchSimpleJuminResult(SearchSimpleJuminEntity entity) {
        this.選挙人情報 = entity;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getShikibetsuCode();
    }

    /**
     * 投票資格種類を返します。
     *
     * @return 投票資格種類
     */
    public Code get投票資格種類() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getTohyoShikakuShurui();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getSeq();
    }

    /**
     * 交付年月日を返します。
     *
     * @return 交付年月日
     */
    public FlexibleDate get交付年月日() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getKofuYMD();
    }

    /**
     * 交付番号を返します。
     *
     * @return 交付番号
     */
    public RString get交付番号() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getKofuNo();
    }

    /**
     * 資格登録年月日を返します。
     *
     * @return 資格登録年月日
     */
    public FlexibleDate get資格登録年月日() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getShikakuTorokuYMD();
    }

    /**
     * 資格満了年月日を返します。
     *
     * @return 資格満了年月日
     */
    public FlexibleDate get資格満了年月日() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getShikakuManryoYMD();
    }

    /**
     * 資格抹消年月日を返します。
     *
     * @return 資格抹消年月日
     */
    public FlexibleDate get資格抹消年月日() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getShikakuMasshoYMD();
    }

    /**
     * 資格抹消事由コードを返します。
     *
     * @return 資格抹消事由コード
     */
    public Code get資格抹消事由コード() {
        return 選挙人情報.getAfT114FuzaishaTohyoShikaku().getShikakuMasshoJiyuCode();
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getShohonNo();
    }

    /**
     * グループコードを返します。
     *
     * @return グループコード
     */
    public RString getグループコード() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getGroupCode();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getTohyokuCode();
    }

    /**
     * 冊を返します。
     *
     * @return 冊
     */
    public RString get冊() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getSatsu();
    }

    /**
     * 頁を返します。
     *
     * @return 頁
     */
    public int get頁() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getPage();
    }

    /**
     * 行を返します。
     *
     * @return 行
     */
    public int get行() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getGyo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号1() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getSeq();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード1() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getShikibetsuCode();
    }

    /**
     * 投票区変更抹消フラグを返します。
     *
     * @return 投票区変更抹消フラグ
     */
    public boolean is投票区変更抹消フラグ() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getTohyokuHenkoMasshoFlag();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getRenban();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public int get枝番() {
        return 選挙人情報.getAfT112SenkyoninMeibo().getEdaban();
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return 選挙人情報.getAfT113SenkyoShikaku().getSenkyoShurui();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード2() {
        return 選挙人情報.getAfT113SenkyoShikaku().getShikibetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public BigSerial get履歴番号2() {
        return 選挙人情報.getAfT113SenkyoShikaku().getSeq();
    }

    /**
     * 選挙資格区分を返します。
     *
     * @return 選挙資格区分
     */
    public Code get選挙資格区分() {
        return 選挙人情報.getAfT113SenkyoShikaku().getShikakuKubun();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード2() {
        return 選挙人情報.getAfT113SenkyoShikaku().getTohyokuCode();
    }

    /**
     * 名簿登録年月日を返します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return 選挙人情報.getAfT113SenkyoShikaku().getMeiboTorokuYMD();
    }

    /**
     * 登録事由コードを返します。
     *
     * @return 登録事由コード
     */
    public Code get登録事由コード() {
        return 選挙人情報.getAfT113SenkyoShikaku().getTorokuJiyuCode();
    }

    /**
     * 登録停止年月日を返します。
     *
     * @return 登録停止年月日
     */
    public FlexibleDate get登録停止年月日() {
        return 選挙人情報.getAfT113SenkyoShikaku().getTorokuTeishiYMD();
    }

    /**
     * 登録停止事由コードを返します。
     *
     * @return 登録停止事由コード
     */
    public Code get登録停止事由コード() {
        return 選挙人情報.getAfT113SenkyoShikaku().getTorokuTeishiJiyuCode();
    }

    /**
     * 表示年月日を返します。
     *
     * @return 表示年月日
     */
    public FlexibleDate get表示年月日() {
        return 選挙人情報.getAfT113SenkyoShikaku().getHyojiYMD();
    }

    /**
     * 表示事由コードを返します。
     *
     * @return 表示事由コード
     */
    public Code get表示事由コード() {
        return 選挙人情報.getAfT113SenkyoShikaku().getHyojiJiyuCode();
    }

    /**
     * 表示消除年月日を返します。
     *
     * @return 表示消除年月日
     */
    public FlexibleDate get表示消除年月日() {
        return 選挙人情報.getAfT113SenkyoShikaku().getHyojiShojoYMD();
    }

    /**
     * 表示消除予定年月日を返します。
     *
     * @return 表示消除予定年月日
     */
    public FlexibleDate get表示消除予定年月日() {
        return 選挙人情報.getAfT113SenkyoShikaku().getHyojiShojoYoteiYMD();
    }

    /**
     * 抹消年月日を返します。
     *
     * @return 抹消年月日
     */
    public FlexibleDate get抹消年月日() {
        return 選挙人情報.getAfT113SenkyoShikaku().getMasshoYMD();
    }

    /**
     * 抹消事由コードを返します。
     *
     * @return 抹消事由コード
     */
    public Code get抹消事由コード() {
        return 選挙人情報.getAfT113SenkyoShikaku().getMasshoJiyuCode();
    }

    /**
     * 刑期終了年月日を返します。
     *
     * @return 刑期終了年月日
     */
    public FlexibleDate get刑期終了年月日() {
        return 選挙人情報.getAfT113SenkyoShikaku().getKeikiShuryoYMD();
    }

    /**
     * 2刑持ちフラグを返します。
     *
     * @return 2刑持ちフラグ
     */
    public boolean is2刑持ち() {
        return 選挙人情報.getAfT113SenkyoShikaku().getNikeimochiFlag();
    }

}
