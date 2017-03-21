/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請書チェックリスト
 *
 * @reamsid_L AF-0460-032 wanghj
 */
public class ShinseishoCheckListKaikuParam {

    private ShisetsuTorokuMeiboJoho 海区選挙人名簿;
    private RString ページ;

    /**
     * コンストラクタです。
     *
     * @param 海区選挙人名簿 ShisetsuTorokuMeiboJoho
     */
    public ShinseishoCheckListKaikuParam(ShisetsuTorokuMeiboJoho 海区選挙人名簿) {
        this.海区選挙人名簿 = 海区選挙人名簿;
    }

    /**
     * ページ
     *
     * @param ページ RString
     */
    public void setページ(RString ページ) {
        this.ページ = ページ;
    }

    /**
     * ページ
     *
     * @return ページ RString
     */
    public RString getページ() {
        return ページ;
    }

    /**
     * 海区選挙人名簿
     *
     * @param 海区選挙人名簿 ShisetsuTorokuMeiboJoho
     */
    public void set海区選挙人名簿(ShisetsuTorokuMeiboJoho 海区選挙人名簿) {
        this.海区選挙人名簿 = 海区選挙人名簿;
    }

    /**
     * 海区選挙人名簿
     *
     * @return 海区選挙人名簿 ShisetsuTorokuMeiboJoho
     */
    public ShisetsuTorokuMeiboJoho get海区選挙人名簿() {
        return 海区選挙人名簿;
    }

}
