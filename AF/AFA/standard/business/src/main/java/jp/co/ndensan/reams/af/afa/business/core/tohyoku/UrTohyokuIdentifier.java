/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * UR投票区の識別子です。
 *
 * @reamsid_L AF-0290-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class UrTohyokuIdentifier implements Serializable {

    private final TohyokuCode 投票区コード;
    private final LasdecCode 地方公共団体コード;
    private final int 連番;
    private final FlexibleDate 有効開始年月日;

    /**
     * コンストラクタです。
     *
     * @param 投票区コード 投票区コード
     * @param 地方公共団体コード 地方公共団体コード
     * @param 連番 連番
     * @param 有効開始年月日 有効開始年月日
     */
    public UrTohyokuIdentifier(TohyokuCode 投票区コード, LasdecCode 地方公共団体コード, int 連番, FlexibleDate 有効開始年月日) {
        this.投票区コード = 投票区コード;
        this.地方公共団体コード = 地方公共団体コード;
        this.連番 = 連番;
        this.有効開始年月日 = 有効開始年月日;
    }
}
