/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区対象抄本情報共有子Div表示用データクラスです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
public class KaikuTaishoShohonJohoData implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;
    private final AfT100ShohonEntity aft100Entity;
    private final AfT111SenkyoEntity aft111Entity;

    /**
     * コンストラクタです。
     */
    public KaikuTaishoShohonJohoData() {
        aft100Entity = new AfT100ShohonEntity();
        aft111Entity = new AfT111SenkyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param aft100Entity DBより取得した{@link AfT100ShohonEntity}
     * @param aft111Entity DBより取得した{@link AfT111SenkyoEntity}
     */
    public KaikuTaishoShohonJohoData(AfT100ShohonEntity aft100Entity, AfT111SenkyoEntity aft111Entity) {
        this.aft100Entity = requireNonNull(aft100Entity);
        this.aft111Entity = requireNonNull(aft111Entity);
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
     * 選挙を返します。
     *
     * @return 選挙 AfT111SenkyoEntity
     */
    public AfT111SenkyoEntity getAft111Entity() {
        return this.aft111Entity;
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
     * 選挙名称のgetメソッドです。
     *
     * @return 選挙名称
     */
    public RString getSenkyoName() {
        return aft111Entity.getSenkyoName();
    }

    /**
     * 選挙名称のsetメソッドです。
     *
     * @param 選挙名称 RString
     */
    public void setSenkyoName(RString 選挙名称) {
        this.aft111Entity.setSenkyoName(選挙名称);
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
     * 無投票選挙フラグのgetメソッドです。
     *
     * @return 無投票選挙フラグ
     */
    public boolean isMutohyoSenkyoFlag() {
        return aft111Entity.getMutohyoSenkyoFlag();
    }

    /**
     * 無投票選挙フラグのsetメソッドです。
     *
     * @param 無投票選挙フラグ boolean
     */
    public void setMutohyoSenkyoFlag(boolean 無投票選挙フラグ) {
        this.aft111Entity.setMutohyoSenkyoFlag(無投票選挙フラグ);
    }
}
