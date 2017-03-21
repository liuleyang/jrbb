/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.shikakushokai;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙資格を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0190-010 guancy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SenkyoShikakuMapperParameter {

    private final RString 選挙種類;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param 選挙種類 選挙種類
     * @param 識別コード 識別コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private SenkyoShikakuMapperParameter(
            @lombok.NonNull RString 選挙種類,
            @lombok.NonNull ShikibetsuCode 識別コード) {

        this.選挙種類 = 選挙種類;
        this.識別コード = 識別コード;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 選挙種類 SenkyoShurui
     * @param 識別コード ShikibetsuCode
     * @return 身体手帳検索パラメータ
     */
    public static SenkyoShikakuMapperParameter createSelectListParam(
            RString 選挙種類, ShikibetsuCode 識別コード) {
        return new SenkyoShikakuMapperParameter(選挙種類, 識別コード);
    }
}
