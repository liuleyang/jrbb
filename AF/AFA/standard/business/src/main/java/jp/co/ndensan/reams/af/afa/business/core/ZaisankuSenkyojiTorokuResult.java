/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT141ZaisankuJuminTohyoConditionEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区議会議員選挙時登録
 *
 * @reamsid_L AF-0600-010 lis
 */
public class ZaisankuSenkyojiTorokuResult {

    private AfT501TohyokuEntity aft501Entity;
    private AfT100ShohonEntity aft100Entity;
    private AfT111SenkyoEntity aft111Entity;
    private AfT141ZaisankuJuminTohyoConditionEntity aft141Entity;

    /**
     * コンストラクタです。
     */
    public ZaisankuSenkyojiTorokuResult() {
        aft501Entity = new AfT501TohyokuEntity();
        aft100Entity = new AfT100ShohonEntity();
        aft111Entity = new AfT111SenkyoEntity();
        aft141Entity = new AfT141ZaisankuJuminTohyoConditionEntity();
    }

    /**
     * 投票区を返します。
     *
     * @return 投票区 AfT501TohyokuEntity
     */
    public AfT501TohyokuEntity getAft501Entity() {
        return this.aft501Entity;
    }

    /**
     * 投票区を設定します。
     *
     * @param aft501Entity AfT501TohyokuEntity
     */
    public void setAft501Entity(AfT501TohyokuEntity aft501Entity) {
        this.aft501Entity = aft501Entity;
    }

    /**
     * 抄本を返します。
     *
     * @return 抄本 AfT100ShohonEntity
     */
    public AfT100ShohonEntity getAft100Entity() {
        return this.aft100Entity;
    }

    /**
     * 抄本を設定します。
     *
     * @param aft100Entity AfT100ShohonEntity
     */
    public void setAft100Entity(AfT100ShohonEntity aft100Entity) {
        this.aft100Entity = aft100Entity;
    }

    /**
     * 選挙を返します。
     *
     * @return 選挙 AfT111SenkyoEntity
     */
    public AfT111SenkyoEntity getAft111Entity() {
        return this.aft111Entity;
    }

    /**
     * 選挙を設定します。
     *
     * @param aft111Entity AfT111SenkyoEntity
     */
    public void setAft111Entity(AfT111SenkyoEntity aft111Entity) {
        this.aft111Entity = aft111Entity;
    }

    /**
     * 財産区・住民投票選挙人抽出条件を返します。
     *
     * @return 財産区・住民投票選挙人抽出条件 AfT141ZaisankuJuminTohyoConditionEntity
     */
    public AfT141ZaisankuJuminTohyoConditionEntity getAft141Entity() {
        return this.aft141Entity;
    }

    /**
     * 財産区・住民投票選挙人抽出条件を設定します。
     *
     * @param aft141Entity AfT141ZaisankuJuminTohyoConditionEntity
     */
    public void setAft141Entity(AfT141ZaisankuJuminTohyoConditionEntity aft141Entity) {
        this.aft141Entity = aft141Entity;
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString getTohyokuCode() {
        return aft501Entity.getTohyokuCode();
    }

    /**
     * 投票区コードのsetメソッドです。
     *
     * @param 投票区コード RString
     */
    public void setTohyokuCode(RString 投票区コード) {
        this.aft501Entity.setTohyokuCode(投票区コード);
    }

    /**
     * 投票区名のgetメソッドです。
     *
     * @return 投票区名
     */
    public RString getTohyokuName() {
        return aft501Entity.getTohyokuName();
    }

    /**
     * 投票区名のsetメソッドです。
     *
     * @param 投票区名 RString
     */
    public void setTohyokuName(RString 投票区名) {
        this.aft501Entity.setTohyokuName(投票区名);
    }

    /**
     * 抄本名のgetメソッドです。
     *
     * @return 抄本名
     */
    public RString getShohonName() {
        return aft100Entity.getShohonName();
    }

    /**
     * 抄本名のsetメソッドです。
     *
     * @param 抄本名 RString
     */
    public void setSeikyuNo(RString 抄本名) {
        this.aft100Entity.setShohonName(抄本名);
    }

    /**
     * 投票年月日のgetメソッドです。
     *
     * @return 投票年月日
     */
    public FlexibleDate getTohyoYMD() {
        return aft100Entity.getTohyoYMD();
    }

    /**
     * 投票年月日のsetメソッドです。
     *
     * @param 投票年月日 FlexibleDate
     */
    public void setTohyoYMD(FlexibleDate 投票年月日) {
        this.aft100Entity.setTohyoYMD(投票年月日);
    }

    /**
     * 規定年齢到達年月日のgetメソッドです。
     *
     * @return 規定年齢到達年月日
     */
    public FlexibleDate getKiteiNenreiTotatsuYMD() {
        return aft100Entity.getKiteiNenreiTotatsuYMD();
    }

    /**
     * 規定年齢到達年月日のsetメソッドです。
     *
     * @param 規定年齢到達年月日 FlexibleDate
     */
    public void setKiteiNenreiTotatsuYMD(FlexibleDate 規定年齢到達年月日) {
        this.aft100Entity.setKiteiNenreiTotatsuYMD(規定年齢到達年月日);
    }

    /**
     * 名簿基準年月日のgetメソッドです。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate getKijunYMD() {
        return aft111Entity.getKijunYMD();
    }

    /**
     * 名簿基準年月日のsetメソッドです。
     *
     * @param 名簿基準年月日 名簿基準年月日
     */
    public void setKijunYMD(FlexibleDate 名簿基準年月日) {
        this.aft111Entity.setKijunYMD(名簿基準年月日);
    }

    /**
     * 名簿登録年月日のgetメソッドです。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate getMeiboTorokuYMD() {
        return aft111Entity.getMeiboTorokuYMD();
    }

    /**
     * 名簿登録年月日のsetメソッドです。
     *
     * @param 名簿登録年月日 FlexibleDate
     */
    public void setMeiboTorokuYMD(FlexibleDate 名簿登録年月日) {
        this.aft111Entity.setMeiboTorokuYMD(名簿登録年月日);
    }

    /**
     * 転出期限年月日のgetメソッドです。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate getTenshutsuKigenYMD() {
        return aft111Entity.getTenshutsuKigenYMD();
    }

    /**
     * 転出期限年月日のsetメソッドです。
     *
     * @param 転出期限年月日 FlexibleDate
     */
    public void setTenshutsuKigenYMD(FlexibleDate 転出期限年月日) {
        this.aft111Entity.setTenshutsuKigenYMD(転出期限年月日);
    }

    /**
     * 転入期限年月日のgetメソッドです。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate getTennyuKigenYMD() {
        return aft111Entity.getTennyuKigenYMD();
    }

    /**
     * 転入期限年月日のsetメソッドです。
     *
     * @param 転入期限年月日 FlexibleDate
     */
    public void setTennyuKigenYMD(FlexibleDate 転入期限年月日) {
        this.aft111Entity.setTennyuKigenYMD(転入期限年月日);
    }

    /**
     * 投票受付開始年月日のgetメソッドです。
     *
     * @return 投票受付開始年月日
     */
    public FlexibleDate getTohyoUketsukeYMD() {
        return aft111Entity.getTohyoUketsukeYMD();
    }

    /**
     * 投票受付開始年月日のsetメソッドです。
     *
     * @param 投票受付開始年月日 投票受付開始年月日
     */
    public void setTohyoUketsukeYMD(FlexibleDate 投票受付開始年月日) {
        this.aft111Entity.setTohyoUketsukeYMD(投票受付開始年月日);
    }

    /**
     * 居住年数のgetメソッドです。
     *
     * @return 居住年数
     */
    public int getKyojuNensu() {
        return aft141Entity.getKyojuNensu();
    }

    /**
     * 居住年数のsetメソッドです。
     *
     * @param 居住年数 int
     */
    public void setKyojuNensu(int 居住年数) {
        this.aft141Entity.setKyojuNensu(居住年数);
    }
}
