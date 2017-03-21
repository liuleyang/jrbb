/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区漁業調整委員会委員選挙人名簿抄本
 *
 * @reamsid_L AF-0460-031 wanghj
 */
public class MeiboShohonKaikuParam {

    private MeiboShohonJuminJouhou 住民投票資格者名簿抄本情報;
    private MeiboShohonJuminJouhouShuukei 住民投票資格者名簿抄本情報集計;
    private UaFt200FindShikibetsuTaishoEntity 宛名識別対象;
    private AfT113SenkyoShikakuEntity 選挙資格;
    private Association 地方公共団体情報;
    private RString 帳票ID;

    /**
     * コンストラクタです。
     *
     * @param 住民投票資格者名簿抄本情報 MeiboShohonJuminJouhou
     * @param 住民投票資格者名簿抄本情報集計 MeiboShohonJuminJouhouShuukei
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 選挙資格 AfT113SenkyoShikakuEntity
     * @param 地方公共団体情報 Association
     * @param 帳票ID RString
     */
    public MeiboShohonKaikuParam(MeiboShohonJuminJouhou 住民投票資格者名簿抄本情報, MeiboShohonJuminJouhouShuukei 住民投票資格者名簿抄本情報集計,
            UaFt200FindShikibetsuTaishoEntity 宛名識別対象, AfT113SenkyoShikakuEntity 選挙資格, Association 地方公共団体情報, RString 帳票ID) {
        this.住民投票資格者名簿抄本情報 = 住民投票資格者名簿抄本情報;
        this.住民投票資格者名簿抄本情報集計 = 住民投票資格者名簿抄本情報集計;
        this.宛名識別対象 = 宛名識別対象;
        this.選挙資格 = 選挙資格;
        this.地方公共団体情報 = 地方公共団体情報;
        this.帳票ID = 帳票ID;
    }

    /**
     * 住民投票資格者名簿抄本情報を設定します。
     *
     * @param 住民投票資格者名簿抄本情報 MeiboShohonJuminJouhou
     */
    public void set住民投票資格者名簿抄本情報(MeiboShohonJuminJouhou 住民投票資格者名簿抄本情報) {
        this.住民投票資格者名簿抄本情報 = 住民投票資格者名簿抄本情報;
    }

    /**
     * 住民投票資格者名簿抄本情報集計を設定します。
     *
     * @param 住民投票資格者名簿抄本情報集計 MeiboShohonJuminJouhouShuukei
     */
    public void set住民投票資格者名簿抄本情報集計(MeiboShohonJuminJouhouShuukei 住民投票資格者名簿抄本情報集計) {
        this.住民投票資格者名簿抄本情報集計 = 住民投票資格者名簿抄本情報集計;
    }

    /**
     * 宛名識別対象を設定します。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     */
    public void set宛名識別対象(UaFt200FindShikibetsuTaishoEntity 宛名識別対象) {
        this.宛名識別対象 = 宛名識別対象;
    }

    /**
     * 選挙資格を設定します。
     *
     * @param 選挙資格 AfT113SenkyoShikakuEntity
     */
    public void set選挙資格(AfT113SenkyoShikakuEntity 選挙資格) {
        this.選挙資格 = 選挙資格;
    }

    /**
     * 地方公共団体情報を設定します。
     *
     * @param 地方公共団体情報 Association
     */
    public void set地方公共団体情報(Association 地方公共団体情報) {
        this.地方公共団体情報 = 地方公共団体情報;
    }

    /**
     * 帳票IDを設定します。
     *
     * @param 帳票ID RString
     */
    public void set帳票ID(RString 帳票ID) {
        this.帳票ID = 帳票ID;
    }

    /**
     * 帳票ID
     *
     * @return 帳票ID RString
     */
    public RString get帳票ID() {
        return 帳票ID;
    }

    /**
     * 住民投票資格者名簿抄本情報
     *
     * @return 住民投票資格者名簿抄本情報 MeiboShohonJuminJouhou
     */
    public MeiboShohonJuminJouhou get住民投票資格者名簿抄本情報() {
        return 住民投票資格者名簿抄本情報;
    }

    /**
     * 住民投票資格者名簿抄本情報集計
     *
     * @return 住民投票資格者名簿抄本情報集計 MeiboShohonJuminJouhouShuukei
     */
    public MeiboShohonJuminJouhouShuukei get住民投票資格者名簿抄本情報集計() {
        return 住民投票資格者名簿抄本情報集計;
    }

    /**
     * 宛名識別対象を返します。
     *
     * @return 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名識別対象() {
        return this.宛名識別対象;
    }

    /**
     * 選挙資格を返します。
     *
     * @return 選挙資格 AfT113SenkyoShikakuEntity
     */
    public AfT113SenkyoShikakuEntity get選挙資格() {
        return this.選挙資格;
    }

    /**
     * 地方公共団体情報を返します。
     *
     * @return 地方公共団体情報 AfT113SenkyoShikakuEntity
     */
    public Association get地方公共団体情報() {
        return this.地方公共団体情報;
    }
}
