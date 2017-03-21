/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.kokumintaishoshohonjoho;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintaishoshohonjoho.KokuminTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国民投票抄本情報のクラスです。
 *
 * @reamsid_L AF-0360-011 lis
 */
public class KokuminTaishoResult {

    private final KokuminTaishoEntity entity;

    /**
     * コンストラクタです。
     */
    public KokuminTaishoResult() {
        entity = new KokuminTaishoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity ShohonSenkyoEntity
     */
    public KokuminTaishoResult(KokuminTaishoEntity entity) {
        this.entity = entity;
    }

    /**
     * 抄本番号を取得します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return entity.getAfT100Shohon().getShohonNo();
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 ShohonNo
     */
    public void set抄本番号(ShohonNo 抄本番号) {
        this.entity.getAfT100Shohon().setShohonNo(抄本番号);
    }

    /**
     * 抄本名称を取得します。
     *
     * @return 抄本名称
     */
    public RString get抄本名称() {
        return entity.getAfT100Shohon().getShohonName();
    }

    /**
     * 抄本名称を設定します。
     *
     * @param 抄本名称 Code
     */
    public void set抄本名称(RString 抄本名称) {
        this.entity.getAfT100Shohon().setShohonName(抄本名称);
    }

    /**
     * 選挙種類を取得します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return entity.getAfT100Shohon().getSenkyoShurui();
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 Code
     */
    public void set選挙種類(Code 選挙種類) {
        this.entity.getAfT100Shohon().setSenkyoShurui(選挙種類);
    }

    /**
     * 投票年月日を取得します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return entity.getAfT100Shohon().getTohyoYMD();
    }

    /**
     * 投票年月日を設定します。
     *
     * @param 投票年月日 FlexibleDate
     */
    public void set投票年月日(FlexibleDate 投票年月日) {
        this.entity.getAfT100Shohon().setTohyoYMD(投票年月日);
    }

    /**
     * 規定年齢到達年月日を取得します。
     *
     * @return 規定年齢到達年月日
     */
    public FlexibleDate get規定年齢到達年月日() {
        return entity.getAfT100Shohon().getKiteiNenreiTotatsuYMD();
    }

    /**
     * 規定年齢到達年月日を設定します。
     *
     * @param 規定年齢到達年月日 FlexibleDate
     */
    public void set規定年齢到達年月日(FlexibleDate 規定年齢到達年月日) {
        this.entity.getAfT100Shohon().setKiteiNenreiTotatsuYMD(規定年齢到達年月日);
    }

    /**
     * 処理年月日を取得します。
     *
     * @return 処理年月日
     */
    public FlexibleDate get処理年月日() {
        return entity.getAfT100Shohon().getShoriYMD();
    }

    /**
     * 処理年月日を設定します。
     *
     * @param 処理年月日 FlexibleDate
     */
    public void set処理年月日(FlexibleDate 処理年月日) {
        this.entity.getAfT100Shohon().setShoriYMD(処理年月日);
    }

    /**
     * 名簿基準年月日を取得します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿基準年月日() {
        return entity.getAfT111Senkyo().getKijunYMD();
    }

    /**
     * 名簿基準年月日を設定します。
     *
     * @param 名簿基準年月日 RDate
     */
    public void set名簿基準年月日(FlexibleDate 名簿基準年月日) {
        this.entity.getAfT111Senkyo().setKijunYMD(名簿基準年月日);
    }

    /**
     * 名簿登録年月日を取得します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return entity.getAfT111Senkyo().getMeiboTorokuYMD();
    }

    /**
     * 名簿登録年月日を設定します。
     *
     * @param 名簿登録年月日 FlexibleDate
     */
    public void set名簿登録年月日(FlexibleDate 名簿登録年月日) {
        this.entity.getAfT111Senkyo().setMeiboTorokuYMD(名簿登録年月日);
    }

    /**
     * 転出期限年月日を取得します。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate get転出期限年月日() {
        return entity.getAfT111Senkyo().getTenshutsuKigenYMD();
    }

    /**
     * 転出期限年月日を設定します。
     *
     * @param 転出期限年月日 FlexibleDate
     */
    public void set転出期限年月日(FlexibleDate 転出期限年月日) {
        this.entity.getAfT111Senkyo().setTenshutsuKigenYMD(転出期限年月日);
    }

    /**
     * 転入期限年月日を取得します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get転入期限年月日() {
        return entity.getAfT111Senkyo().getTennyuKigenYMD();
    }

    /**
     * 転入期限年月日を設定します。
     *
     * @param 転入期限年月日 FlexibleDate
     */
    public void set転入期限年月日(FlexibleDate 転入期限年月日) {
        this.entity.getAfT111Senkyo().setTennyuKigenYMD(転入期限年月日);
    }

    /**
     * 転入期限年月日を取得します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get投票受付開始年月日() {
        return entity.getAfT111Senkyo().getTohyoUketsukeYMD();
    }

    /**
     * 投票受付開始年月日を設定します。
     *
     * @param 投票受付開始年月日 FlexibleDate
     */
    public void set投票受付開始年月日(FlexibleDate 投票受付開始年月日) {
        this.entity.getAfT111Senkyo().setTohyoUketsukeYMD(投票受付開始年月日);
    }

}
