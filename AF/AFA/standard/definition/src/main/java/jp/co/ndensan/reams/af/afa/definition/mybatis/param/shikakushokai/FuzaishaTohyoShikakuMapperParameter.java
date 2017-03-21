/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.shikakushokai;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 不在者投票資格を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0190-010 guancy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class FuzaishaTohyoShikakuMapperParameter {

    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private FuzaishaTohyoShikakuMapperParameter(
            @lombok.NonNull ShikibetsuCode 識別コード) {

        this.識別コード = 識別コード;
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 識別コード 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static FuzaishaTohyoShikakuMapperParameter createSelectListParam(
            ShikibetsuCode 識別コード) {
        return new FuzaishaTohyoShikakuMapperParameter(識別コード);
    }
}
