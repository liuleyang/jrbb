/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * メニューを表す列挙型です。
 *
 * @reamsid_L AF-0160-025 liuj2
 */
public enum AFAChohyoId {

    /**
     * AFAPRA112_転出者お知らせハガキ作成対象者一覧表。
     */
    AFAPRA112_転出者お知らせハガキ作成対象者一覧表("AFAPRA112_TenshutsuOshiraseHagakiList"),
    /**
     * AFAPRB201_投票所入場券（個票3つ折り）。
     */
    AFAPRB201_投票所入場券_個票3つ折り("AFAPRB201_Nyujoken3tsuori"),
    /**
     * AFAPRB202_投票所入場券（はがき4つ切り）。
     */
    AFAPRB202_投票所入場券_はがき4つ切り("AFAPRB202_NyujokenHagaki"),
    /**
     * AFAPRB203_投票所入場券（シーラー）。
     */
    AFAPRB203_投票所入場券_シーラー("AFAPRB203_NyujokenSealer"),
    /**
     * AFAPRB204_投票所入場券（ポステックス）。
     */
    AFAPRB204_投票所入場券_ポステックス("AFAPRB204_NyujokenPostex"),
    /**
     * AFAPRB210_転出者お知らせハガキ。
     */
    AFAPRB210_転出者お知らせハガキ("AFAPRB210_TenshutsuOshiraseHagaki"),
    /**
     * AFAPRB212_投票所入場券印刷枚数表。
     */
    AFAPRB212_投票所入場券印刷枚数表("AFAPRB212_NyujokenMaisuhyo"),
    /**
     * AFAPRB213_n人以上世帯一覧表。
     */
    AFAPRB213_n人以上世帯一覧表("AFAPRB213_NninIjoSetaiList");

    private final RString chohyoId;

    private AFAChohyoId(String chohyoId) {
        this.chohyoId = new RString(chohyoId);
    }

    /**
     * 帳票IDを返します。
     *
     * @return 帳票ID
     */
    public RString chohyoId() {
        return this.chohyoId;
    }
}
