/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人名簿の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class SenkyoninMeiboIdentifier implements Serializable {

    private final ShohonNo 抄本番号;
    private final RString グループコード;
    private final RString 投票区コード;
    private final RString 冊;
    private final int 頁;
    private final int 行;
    private final BigSerial 履歴番号;
    private final ShikibetsuCode 識別コード;
    private final boolean 投票区変更抹消フラグ;
    private final int 連番;
    private final int 枝番;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param グループコード グループコード
     * @param 投票区コード 投票区コード
     * @param 冊 冊
     * @param 頁 頁
     * @param 行 行
     * @param 履歴番号 履歴番号
     * @param 識別コード 識別コード
     * @param 投票区変更抹消フラグ 投票区変更抹消フラグ
     * @param 連番 連番
     * @param 枝番 枝番
     */
    public SenkyoninMeiboIdentifier(ShohonNo 抄本番号,
            RString グループコード,
            RString 投票区コード,
            RString 冊,
            int 頁,
            int 行,
            BigSerial 履歴番号,
            ShikibetsuCode 識別コード,
            boolean 投票区変更抹消フラグ,
            int 連番,
            int 枝番) {
        this.抄本番号 = 抄本番号;
        this.グループコード = グループコード;
        this.投票区コード = 投票区コード;
        this.冊 = 冊;
        this.頁 = 頁;
        this.行 = 行;
        this.履歴番号 = 履歴番号;
        this.識別コード = 識別コード;
        this.投票区変更抹消フラグ = 投票区変更抹消フラグ;
        this.連番 = 連番;
        this.枝番 = 枝番;
    }
}
