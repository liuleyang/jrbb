/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT133KaikuSenkyoFuzuiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区付随情報クラスです。
 *
 * @reamsid_L AF-0500-020 gyq
 */
public class KaikuSenkyoFuzuiResult implements Serializable {

    private AfT133KaikuSenkyoFuzuiEntity afT133KaikuSenkyoFuzui;

    /**
     * AfT133KaikuSenkyoFuzuiEntity。
     *
     * @return UdT101HenreiChohyoCommonEntity
     */
    public AfT133KaikuSenkyoFuzuiEntity getEntity() {
        return afT133KaikuSenkyoFuzui;
    }

    /**
     * AfT133KaikuSenkyoFuzuiEntity。
     *
     * @param afT133KaikuSenkyoFuzui AfT133KaikuSenkyoFuzuiEntity
     */
    public void setEntity(AfT133KaikuSenkyoFuzuiEntity afT133KaikuSenkyoFuzui) {
        this.afT133KaikuSenkyoFuzui = afT133KaikuSenkyoFuzui;
    }

    /**
     * コンストラクタです。
     *
     * @param afT133KaikuSenkyoFuzui AfT133KaikuSenkyoFuzuiEntity
     */
    public KaikuSenkyoFuzuiResult(AfT133KaikuSenkyoFuzuiEntity afT133KaikuSenkyoFuzui) {
        this.afT133KaikuSenkyoFuzui = afT133KaikuSenkyoFuzui;
    }

    /**
     * コンストラクタです。
     *
     */
    public KaikuSenkyoFuzuiResult() {
        afT133KaikuSenkyoFuzui = new AfT133KaikuSenkyoFuzuiEntity();
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return afT133KaikuSenkyoFuzui.getShohonNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return afT133KaikuSenkyoFuzui.getShikibetsuCode();
    }

    /**
     * 漁業者番号を返します。
     *
     * @return 漁業者番号
     */
    public RString get漁業者番号() {
        return afT133KaikuSenkyoFuzui.getGyogyoshaNo();
    }

    /**
     * 組合コードを返します。
     *
     * @return 組合コード
     */
    public RString get組合コード() {
        return afT133KaikuSenkyoFuzui.getKumiaiCode();
    }

    /**
     * 漁業日数（漁業者）を返します。
     *
     * @return 漁業日数（漁業者）
     */
    public int get漁業日数_漁業者() {
        return afT133KaikuSenkyoFuzui.getNissuGyogyosha();
    }

    /**
     * 漁業日数（漁業従事者）を返します。
     *
     * @return 漁業日数（漁業従事者）
     */
    public int get漁業日数_漁業従事者() {
        return afT133KaikuSenkyoFuzui.getNissuJujisha();
    }

    /**
     * 漁業種類を返します。
     *
     * @return 漁業種類
     */
    public Code get漁業種類() {
        return afT133KaikuSenkyoFuzui.getGyogyoShurui();
    }

    /**
     * 使用漁船種別を返します。
     *
     * @return 使用漁船種別
     */
    public Code get使用漁船種別() {
        return afT133KaikuSenkyoFuzui.getGyosenShubetsu();
    }

    /**
     * 船名を返します。
     *
     * @return 船名
     */
    public RString get船名() {
        return afT133KaikuSenkyoFuzui.getSenmei();
    }

    /**
     * 登録番号を返します。
     *
     * @return 登録番号
     */
    public RString get登録番号() {
        return afT133KaikuSenkyoFuzui.getTorokuNo();
    }

    /**
     * 抄本番号を設定します。
     *
     * @param shohonNo 抄本番号
     */
    public void set抄本番号(ShohonNo shohonNo) {
        this.afT133KaikuSenkyoFuzui.setShohonNo(shohonNo);
    }

    /**
     * 識別コードを設定します。
     *
     * @param shikibetsuCode 識別コード
     */
    public void set識別コード(ShikibetsuCode shikibetsuCode) {
        this.afT133KaikuSenkyoFuzui.setShikibetsuCode(shikibetsuCode);
    }

    /**
     * 漁業者番号を設定します。
     *
     * @param gyogyoshaNo 漁業者番号
     */
    public void set漁業者番号(RString gyogyoshaNo) {
        this.afT133KaikuSenkyoFuzui.setGyogyoshaNo(gyogyoshaNo);
    }

    /**
     * 組合コードを設定します。
     *
     * @param kumiaiCode 組合コード
     */
    public void set組合コード(RString kumiaiCode) {
        this.afT133KaikuSenkyoFuzui.setKumiaiCode(kumiaiCode);
    }

    /**
     * 漁業日数_漁業者を設定します。
     *
     * @param nissuGyogyosha 漁業日数_漁業者
     */
    public void set漁業日数_漁業者(int nissuGyogyosha) {
        this.afT133KaikuSenkyoFuzui.setNissuGyogyosha(nissuGyogyosha);
    }

    /**
     * 漁業日数_漁業従事者を設定します。
     *
     * @param nissuJujisha 漁業日数_漁業従事者
     */
    public void set漁業日数_漁業従事者(int nissuJujisha) {
        this.afT133KaikuSenkyoFuzui.setNissuJujisha(nissuJujisha);
    }

    /**
     * 漁業種類を設定します。
     *
     * @param gyogyoShurui 漁業種類
     */
    public void set漁業種類(Code gyogyoShurui) {
        this.afT133KaikuSenkyoFuzui.setGyogyoShurui(gyogyoShurui);
    }

    /**
     * 使用漁船種別を設定します。
     *
     * @param gyosenShubetsu 使用漁船種別
     */
    public void set使用漁船種別(Code gyosenShubetsu) {
        this.afT133KaikuSenkyoFuzui.setGyosenShubetsu(gyosenShubetsu);
    }

    /**
     * 船名を設定します。
     *
     * @param senmei 船名
     */
    public void set船名(RString senmei) {
        this.afT133KaikuSenkyoFuzui.setSenmei(senmei);
    }

    /**
     * 登録番号を設定します。
     *
     * @param torokuNo 登録番号
     */
    public void set登録番号(RString torokuNo) {
        this.afT133KaikuSenkyoFuzui.setTorokuNo(torokuNo);
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new KaikuSenkyoFuzuiResult._SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private final AfT133KaikuSenkyoFuzuiEntity afT133KaikuSenkyoFuzui;
        private static final long serialVersionUID = 351900186803745749L;

        private _SerializationProxy(KaikuSenkyoFuzuiResult result) {
            this.afT133KaikuSenkyoFuzui = result.getEntity();
        }

        private Object readResolve() {
            return new KaikuSenkyoFuzuiResult(afT133KaikuSenkyoFuzui);
        }
    }
}
