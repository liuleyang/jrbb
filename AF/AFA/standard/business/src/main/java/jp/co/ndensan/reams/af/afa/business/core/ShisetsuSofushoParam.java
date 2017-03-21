/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.relate.shisetsusofusho.ShisetsusofushoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設送付書
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoParam {

    private ShisetsuSofushoGamenJoho 画面情報;
    private ShisetsusofushoEntity 施設送付書;
    private RString ページ;
    private RString 総ページ;
    private RString 人数を集計;
    private RString 施設コード;
    private RString 選挙番号;
    private ShikibetsuCode 識別コード;

    private Association 地方公共団体情報;

    /**
     * コンストラクタです。
     *
     * @param 画面情報 ShisetsuSofushoGamenJoho
     * @param 施設送付書 ShisetsusofushoEntity
     * @param ページ RString
     * @param 総ページ RString
     * @param 人数を集計 RString
     * @param 識別コード ShikibetsuCode
     */
    public ShisetsuSofushoParam(ShisetsuSofushoGamenJoho 画面情報,
            ShisetsusofushoEntity 施設送付書, RString ページ, RString 総ページ, RString 人数を集計, ShikibetsuCode 識別コード) {
        this.画面情報 = 画面情報;
        this.施設送付書 = 施設送付書;
        this.ページ = ページ;
        this.総ページ = 総ページ;
        this.人数を集計 = 人数を集計;
        this.識別コード = 識別コード;
    }

    /**
     * 施設コード
     *
     * @param 施設コード RString
     */
    public void set施設コード(RString 施設コード) {
        this.施設コード = 施設コード;
    }

    /**
     * 選挙番号
     *
     * @param 選挙番号 RString
     */
    public void set選挙番号(RString 選挙番号) {
        this.選挙番号 = 選挙番号;
    }

    /**
     * 施設コード
     *
     * @return 施設コード RString
     */
    public RString get施設コード() {
        return 施設コード;
    }

    /**
     * 選挙番号
     *
     * @return 選挙番号 RString
     */
    public RString get選挙番号() {
        return 選挙番号;
    }

    /**
     * 画面情報を設定します。
     *
     * @param 画面情報 ShisetsuSofushoGamenJoho
     */
    public void set画面情報(ShisetsuSofushoGamenJoho 画面情報) {
        this.画面情報 = 画面情報;
    }

    /**
     * 施設送付書を設定します。
     *
     * @param 施設送付書 ShisetsusofushoEntity
     */
    public void set施設送付書(ShisetsusofushoEntity 施設送付書) {
        this.施設送付書 = 施設送付書;
    }

    /**
     * ページを設定します。
     *
     * @param ページ RString
     */
    public void setページ(RString ページ) {
        this.ページ = ページ;
    }

    /**
     * 総ページを設定します。
     *
     * @param 総ページ RString
     */
    public void set総ページ(RString 総ページ) {
        this.総ページ = 総ページ;
    }

    /**
     * 人数を集計を設定します。
     *
     * @param 人数を集計 RString
     */
    public void set人数を集計(RString 人数を集計) {
        this.人数を集計 = 人数を集計;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 施設送付書
     *
     * @return 施設送付書 ShisetsusofushoEntity
     */
    public ShisetsusofushoEntity get施設送付書() {
        return 施設送付書;
    }

    /**
     * 識別コード
     *
     * @return 識別コード ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 画面情報を返します。
     *
     * @return 画面情報 ShisetsuSofushoGamenJoho
     */
    public ShisetsuSofushoGamenJoho get画面情報() {
        return 画面情報;
    }

    /**
     * ページを返します。
     *
     * @return ページ RString
     */
    public RString getページ() {
        return ページ;
    }

    /**
     * 総ページを返します。
     *
     * @return 総ページ RString
     */
    public RString get総ページ() {
        return 総ページ;
    }

    /**
     * 人数を集計を返します。
     *
     * @return 人数を集計 RString
     */
    public RString get人数を集計() {
        return 人数を集計;
    }

    /**
     * 地方公共団体情報を返します。
     *
     * @return 地方公共団体情報 Association
     */
    public Association get地方公共団体情報() {
        return this.地方公共団体情報;
    }

    /**
     * 地方公共団体情報を設定します。
     *
     * @param 地方公共団体情報 Association
     */
    public void set地方公共団体情報(Association 地方公共団体情報) {
        this.地方公共団体情報 = 地方公共団体情報;
    }

}
