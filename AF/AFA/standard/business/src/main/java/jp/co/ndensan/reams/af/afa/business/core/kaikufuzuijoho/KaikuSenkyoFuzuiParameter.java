/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.kaikufuzuijoho;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区付随情報クラスです。
 *
 * @reamsid_L AF-0500-020 gyq
 */
public class KaikuSenkyoFuzuiParameter {

    private ShohonNo 抄本番号;
    private ShikibetsuCode 識別コード;
    private RString 判定条件;

    /**
     * 抄本番号を取得します。
     *
     * @return ShohonNo
     */
    public ShohonNo get抄本番号() {
        return 抄本番号;
    }

    /**
     * 識別コードを取得します。
     *
     * @return ShikibetsuCode
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 ShohonNo
     */
    public void set抄本番号(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
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
     * 抄判定条件を取得します。
     *
     * @return RString
     */
    public RString get判定条件() {
        return 判定条件;
    }

    /**
     * 判定条件を設定します。
     *
     * @param 判定条件 RString
     */
    public void set判定条件(RString 判定条件) {
        this.判定条件 = 判定条件;
    }
}
