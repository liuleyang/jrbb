/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.kaikusenkyofuzui;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 海区付随情報を管理するクラスです。
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KaikuSenkyoFuzuiIdentifier implements Serializable {

    private final ShohonNo 抄本番号;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     */
    public KaikuSenkyoFuzuiIdentifier(ShohonNo 抄本番号,
            ShikibetsuCode 識別コード
    ) {
        this.抄本番号 = 抄本番号;
        this.識別コード = 識別コード;
    }
}
