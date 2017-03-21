/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 登録者数リスト（海区選挙）
 *
 * @reamsid_L AF-0460-033 wanghj
 */
public class TorokushasuListKaikuParentParam {

    private RDate 基準日;
    private RString 明細タイトル住所;
    private RString 投票区コード;
    private RString 集計地区名;
    private RString 選挙番号;
    private RString 合計タイプ;

    /**
     * コンストラクタです。
     *
     */
    public TorokushasuListKaikuParentParam() {
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
     * 合計タイプ
     *
     * @param 合計タイプ RString
     */
    public void set合計タイプ(RString 合計タイプ) {
        this.合計タイプ = 合計タイプ;
    }

    /**
     * 選挙番号
     *
     * @return 選挙番号
     */
    public RString get選挙番号() {
        return 選挙番号;
    }

    /**
     * 合計タイプ
     *
     * @return 合計タイプ
     */
    public RString get合計タイプ() {
        return 合計タイプ;
    }

    /**
     * 投票区コードを設定します。
     *
     * @param 投票区コード RString
     */
    public void set投票区コード(RString 投票区コード) {
        this.投票区コード = 投票区コード;
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード RString
     */
    public RString get投票区コード() {
        return this.投票区コード;
    }

    /**
     * 集計地区名を返します。
     *
     * @return 集計地区名 RString
     */
    public RString get集計地区名() {
        return this.集計地区名;
    }

    /**
     * 集計地区名を設定します。
     *
     * @param 集計地区名 RString
     */
    public void set集計地区名(RString 集計地区名) {
        this.集計地区名 = 集計地区名;
    }

    /**
     * 基準日を設定します。
     *
     * @param 基準日 RDate
     */
    public void set基準日(RDate 基準日) {
        this.基準日 = 基準日;
    }

    /**
     * 明細タイトル住所を設定します。
     *
     * @param 明細タイトル住所 RString
     */
    public void set明細タイトル住所(RString 明細タイトル住所) {
        this.明細タイトル住所 = 明細タイトル住所;
    }

    /**
     * 明細タイトル住所
     *
     * @return 明細タイトル住所 RString
     */
    public RString get明細タイトル住所() {
        return 明細タイトル住所;
    }

    /**
     * 基準日
     *
     * @return 基準日 RDate
     */
    public RDate get基準日() {
        return 基準日;
    }

}
