/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 登録を行わなかった旨の通知（本人）
 *
 * @reamsid_L AF-0320-033 lis2
 */
public class NotTorokuTsuchiHonninParam {

    private final ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報;
    private final ZaigaiSakuseiChohyo 画面帳票作成入力項目;

    private Association 地方公共団体;

    private RString honninShimei1;
    private RString honninShimei2;
    private RString hakkoDaino;
    private RString hakkoYmd;
    private RString tsuchiMoto1;
    private RString tsuchiMoto2;
    private RString iinchoMei1;
    private RString iinchoMei2;
    private RString senkyoShurui;
    private RString honbun1;
    private RString honbun2;
    private RString honbun3;
    private RString shimei;
    private RString shimei1;
    private RString shimei2;
    private RString ryojikan;
    private RString ryojikan1;
    private RString ryojikan2;
    private RString riyu1;
    private RString riyu2;
    private RString riyu3;
    private RString riyu4;
    private RString riyu5;
    private RString riyu6;
    private RString riyu7;
    private RString riyu8;
    private RString riyu9;

    /**
     * コンストラクタです。
     *
     * @param 在外選挙人申請情報 ZaigaiSenkyoninShinseiJohoEntity
     * @param 画面帳票作成入力項目 ZaigaiSakuseiChohyo
     */
    public NotTorokuTsuchiHonninParam(
            ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報,
            ZaigaiSakuseiChohyo 画面帳票作成入力項目) {
        this.在外選挙人申請情報 = 在外選挙人申請情報;
        this.画面帳票作成入力項目 = 画面帳票作成入力項目;
    }

    /**
     * 画面帳票作成入力項目
     *
     * @return 画面帳票作成入力項目 ZaigaiSakuseiChohyo
     */
    public ZaigaiSakuseiChohyo get画面帳票作成入力項目() {
        return 画面帳票作成入力項目;
    }

    /**
     * 在外選挙人申請情報list
     *
     * @return 在外選挙人申請情報list ZaigaiSenkyoninShinseiJohoEntity
     */
    public ZaigaiSenkyoninShinseiJohoEntity get在外選挙人申請情報() {
        return 在外選挙人申請情報;
    }

    /**
     * 地方公共団体
     *
     * @return 地方公共団体 Association
     */
    public Association get地方公共団体() {
        return 地方公共団体;
    }

    /**
     * 地方公共団体
     *
     * @param 地方公共団体 Association
     */
    public void set地方公共団体(Association 地方公共団体) {
        this.地方公共団体 = 地方公共団体;
    }

    /**
     * 本人氏名1
     *
     * @param honninShimei1 RString
     */
    public void setHonninShimei1(RString honninShimei1) {
        this.honninShimei1 = honninShimei1;
    }

    /**
     * 本人氏名２
     *
     * @param honninShimei2 RString
     */
    public void setHonninShimei2(RString honninShimei2) {
        this.honninShimei2 = honninShimei2;
    }

    /**
     * 発行番号
     *
     * @param hakkoDaino RString
     */
    public void setHakkoDaino(RString hakkoDaino) {
        this.hakkoDaino = hakkoDaino;
    }

    /**
     * 発行年月日
     *
     * @param hakkoYmd RString
     */
    public void setHakkoYmd(RString hakkoYmd) {
        this.hakkoYmd = hakkoYmd;
    }

    /**
     * 通知元市町村名1
     *
     * @param tsuchiMoto1 RString
     */
    public void setTsuchiMoto1(RString tsuchiMoto1) {
        this.tsuchiMoto1 = tsuchiMoto1;
    }

    /**
     * 通知元市町村名２
     *
     * @param tsuchiMoto2 RString
     */
    public void setTsuchiMoto2(RString tsuchiMoto2) {
        this.tsuchiMoto2 = tsuchiMoto2;
    }

    /**
     * 委員長名1
     *
     * @param iinchoMei1 RString
     */
    public void setIinchoMei1(RString iinchoMei1) {
        this.iinchoMei1 = iinchoMei1;
    }

    /**
     * 委員長名２
     *
     * @param iinchoMei2 RString
     */
    public void setIinchoMei2(RString iinchoMei2) {
        this.iinchoMei2 = iinchoMei2;
    }

    /**
     * 選挙種類
     *
     * @param senkyoShurui RString
     */
    public void setSenkyoShurui(RString senkyoShurui) {
        this.senkyoShurui = senkyoShurui;
    }

    /**
     * 本文1
     *
     * @param honbun1 RString
     */
    public void setHonbun1(RString honbun1) {
        this.honbun1 = honbun1;
    }

    /**
     * 本文2
     *
     * @param honbun2 RString
     */
    public void setHonbun2(RString honbun2) {
        this.honbun2 = honbun2;
    }

    /**
     * 本文３
     *
     * @param honbun3 RString
     */
    public void setHonbun3(RString honbun3) {
        this.honbun3 = honbun3;
    }

    /**
     * 氏名
     *
     * @param shimei RString
     */
    public void setShimei(RString shimei) {
        this.shimei = shimei;
    }

    /**
     * 氏名1
     *
     * @param shimei1 RString
     */
    public void setShimei1(RString shimei1) {
        this.shimei1 = shimei1;
    }

    /**
     * 氏名２
     *
     * @param shimei2 RString
     */
    public void setShimei2(RString shimei2) {
        this.shimei2 = shimei2;
    }

    /**
     * 領事官
     *
     * @param ryojikan RString
     */
    public void setRyojikan(RString ryojikan) {
        this.ryojikan = ryojikan;
    }

    /**
     * 領事官1
     *
     * @param ryojikan1 RString
     */
    public void setRyojikan1(RString ryojikan1) {
        this.ryojikan1 = ryojikan1;
    }

    /**
     * 領事官２
     *
     * @param ryojikan2 RString
     */
    public void setRyojikan2(RString ryojikan2) {
        this.ryojikan2 = ryojikan2;
    }

    /**
     * 理由1
     *
     * @param riyu1 RString
     */
    public void setRiyu1(RString riyu1) {
        this.riyu1 = riyu1;
    }

    /**
     * 理由2
     *
     * @param riyu2 RString
     */
    public void setRiyu2(RString riyu2) {
        this.riyu2 = riyu2;
    }

    /**
     * 理由3
     *
     * @param riyu3 RString
     */
    public void setRiyu3(RString riyu3) {
        this.riyu3 = riyu3;
    }

    /**
     * 理由4
     *
     * @param riyu4 RString
     */
    public void setRiyu4(RString riyu4) {
        this.riyu4 = riyu4;
    }

    /**
     * 理由5
     *
     * @param riyu5 RString
     */
    public void setRiyu5(RString riyu5) {
        this.riyu5 = riyu5;
    }

    /**
     * 理由6
     *
     * @param riyu6 RString
     */
    public void setRiyu6(RString riyu6) {
        this.riyu6 = riyu6;
    }

    /**
     * 理由7
     *
     * @param riyu7 RString
     */
    public void setRiyu7(RString riyu7) {
        this.riyu7 = riyu7;
    }

    /**
     * 理由8
     *
     * @param riyu8 RString
     */
    public void setRiyu8(RString riyu8) {
        this.riyu8 = riyu8;
    }

    /**
     * 理由９
     *
     * @param riyu9 RString
     */
    public void setRiyu9(RString riyu9) {
        this.riyu9 = riyu9;
    }

    /**
     * 本人氏名1
     *
     * @return honninShimei1 RString
     */
    public RString getHonninShimei1() {
        return honninShimei1;
    }

    /**
     * 本人氏名２
     *
     * @return honninShimei2 RString
     */
    public RString getHonninShimei2() {
        return honninShimei2;
    }

    /**
     * 発行番号
     *
     * @return hakkoDaino RString
     */
    public RString getHakkoDaino() {
        return hakkoDaino;
    }

    /**
     * 発行年月日
     *
     * @return hakkoYmd RString
     */
    public RString getHakkoYmd() {
        return hakkoYmd;
    }

    /**
     * 通知元市町村名1
     *
     * @return tsuchiMoto1 RString
     */
    public RString getTsuchiMoto1() {
        return tsuchiMoto1;
    }

    /**
     * 通知元市町村名２
     *
     * @return tsuchiMoto2 RString
     */
    public RString getTsuchiMoto2() {
        return tsuchiMoto2;
    }

    /**
     * 委員長名1
     *
     * @return iinchoMei1 RString
     */
    public RString getIinchoMei1() {
        return iinchoMei1;
    }

    /**
     * 委員長名２
     *
     * @return iinchoMei2 RString
     */
    public RString getIinchoMei2() {
        return iinchoMei2;
    }

    /**
     * 選挙種類
     *
     * @return senkyoShurui RString
     */
    public RString getSenkyoShurui() {
        return senkyoShurui;
    }

    /**
     * 本文1
     *
     * @return honbun1 RString
     */
    public RString getHonbun1() {
        return honbun1;
    }

    /**
     * 本文2
     *
     * @return honbun2 RString
     */
    public RString getHonbun2() {
        return honbun2;
    }

    /**
     * 本文３
     *
     * @return honbun3 RString
     */
    public RString getHonbun3() {
        return honbun3;
    }

    /**
     * 氏名
     *
     * @return shimei RString
     */
    public RString getShimei() {
        return shimei;
    }

    /**
     * 氏名1
     *
     * @return shimei1 RString
     */
    public RString getShimei1() {
        return shimei1;
    }

    /**
     * 氏名２
     *
     * @return shimei2 RString
     */
    public RString getShimei2() {
        return shimei2;
    }

    /**
     * 領事官
     *
     * @return ryojikan RString
     */
    public RString getRyojikan() {
        return ryojikan;
    }

    /**
     * 領事官1
     *
     * @return ryojikan1 RString
     */
    public RString getRyojikan1() {
        return ryojikan1;
    }

    /**
     * 領事官２
     *
     * @return ryojikan2 RString
     */
    public RString getRyojikan2() {
        return ryojikan2;
    }

    /**
     * 理由1
     *
     * @return riyu1 RString
     */
    public RString getRiyu1() {
        return riyu1;
    }

    /**
     * 理由2
     *
     * @return riyu2 RString
     */
    public RString getRiyu2() {
        return riyu2;
    }

    /**
     * 理由3
     *
     * @return riyu3 RString
     */
    public RString getRiyu3() {
        return riyu3;
    }

    /**
     * 理由4
     *
     * @return riyu4 RString
     */
    public RString getRiyu4() {
        return riyu4;
    }

    /**
     * 理由5
     *
     * @return riyu5 RString
     */
    public RString getRiyu5() {
        return riyu5;
    }

    /**
     * 理由6
     *
     * @return riyu6 RString
     */
    public RString getRiyu6() {
        return riyu6;
    }

    /**
     * 理由7
     *
     * @return riyu7 RString
     */
    public RString getRiyu7() {
        return riyu7;
    }

    /**
     * 理由8
     *
     * @return riyu8 RString
     */
    public RString getRiyu8() {
        return riyu8;
    }

    /**
     * 理由９
     *
     * @return riyu9 RString
     */
    public RString getRiyu9() {
        return riyu9;
    }

}
