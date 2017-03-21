/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tojitsutohyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tojitsutohyo.ShohonSearchEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抄本と選挙情報の検索結果のクラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class ShohonSearchResult implements Serializable {

    private final ShohonSearchEntity entity;

    /**
     * コンストラクタです。
     */
    public ShohonSearchResult() {
        entity = new ShohonSearchEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity ShohonSenkyoEntity
     */
    public ShohonSearchResult(ShohonSearchEntity entity) {
        this.entity = entity;
    }

    /**
     * 抄本番号を取得します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return entity.getShohonNo();
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 ShohonNo
     */
    public void set抄本番号(ShohonNo 抄本番号) {
        this.entity.setShohonNo(抄本番号);
    }

    /**
     * 抄本名称を取得します。
     *
     * @return 抄本名称
     */
    public RString get抄本名称() {
        return entity.getShohonName();
    }

    /**
     * 抄本名称を設定します。
     *
     * @param 抄本名称 Code
     */
    public void set抄本名称(RString 抄本名称) {
        this.entity.setShohonName(抄本名称);
    }

    /**
     * 選挙種類を取得します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return entity.getSenkyoShurui();
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 Code
     */
    public void set選挙種類(Code 選挙種類) {
        this.entity.setSenkyoShurui(選挙種類);
    }

    /**
     * 投票年月日を取得します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return entity.getTohyoYMD();
    }

    /**
     * 投票年月日を設定します。
     *
     * @param 投票年月日 FlexibleDate
     */
    public void set投票年月日(FlexibleDate 投票年月日) {
        this.entity.setTohyoYMD(投票年月日);
    }

    /**
     * 規定年齢到達年月日を取得します。
     *
     * @return 規定年齢到達年月日
     */
    public FlexibleDate get規定年齢到達年月日() {
        return entity.getKiteiNenreiTotatsuYMD();
    }

    /**
     * 規定年齢到達年月日を設定します。
     *
     * @param 規定年齢到達年月日 FlexibleDate
     */
    public void set規定年齢到達年月日(FlexibleDate 規定年齢到達年月日) {
        this.entity.setKiteiNenreiTotatsuYMD(規定年齢到達年月日);
    }

    /**
     * 処理年月日を取得します。
     *
     * @return 処理年月日
     */
    public FlexibleDate get処理年月日() {
        return entity.getShoriYMD();
    }

    /**
     * 処理年月日を設定します。
     *
     * @param 処理年月日 FlexibleDate
     */
    public void set処理年月日(FlexibleDate 処理年月日) {
        this.entity.setShoriYMD(処理年月日);
    }

    /**
     * 名簿基準年月日を取得します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿基準年月日() {
        return entity.getKijunYMD();
    }

    /**
     * 名簿基準年月日を設定します。
     *
     * @param 名簿基準年月日 RDate
     */
    public void set名簿基準年月日(FlexibleDate 名簿基準年月日) {
        this.entity.setKijunYMD(名簿基準年月日);
    }

    /**
     * 名簿登録年月日を取得します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return entity.getMeiboTorokuYMD();
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param 名簿登録年月日 FlexibleDate
     */
    public void set名簿登録年月日(FlexibleDate 名簿登録年月日) {
        this.entity.setMeiboTorokuYMD(名簿登録年月日);
    }

    /**
     * 転出期限年月日を取得します。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate get転出期限年月日() {
        return entity.getTenshutsuKigenYMD();
    }

    /**
     * 転出期限年月日を設定します。
     *
     * @param 転出期限年月日 FlexibleDate
     */
    public void set転出期限年月日(FlexibleDate 転出期限年月日) {
        this.entity.setTenshutsuKigenYMD(転出期限年月日);
    }

    /**
     * 転入期限年月日を取得します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get転入期限年月日() {
        return entity.getTennyuKigenYMD();
    }

    /**
     * 転入期限年月日を設定します。
     *
     * @param 転入期限年月日 FlexibleDate
     */
    public void set転入期限年月日(FlexibleDate 転入期限年月日) {
        this.entity.setTennyuKigenYMD(転入期限年月日);
    }

    /**
     * 転入期限年月日を取得します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get投票受付開始年月日() {
        return entity.getTohyoUketsukeYMD();
    }

    /**
     * 投票受付開始年月日を設定します。
     *
     * @param 投票受付開始年月日 FlexibleDate
     */
    public void set投票受付開始年月日(FlexibleDate 投票受付開始年月日) {
        this.entity.setTohyoUketsukeYMD(投票受付開始年月日);
    }
}
