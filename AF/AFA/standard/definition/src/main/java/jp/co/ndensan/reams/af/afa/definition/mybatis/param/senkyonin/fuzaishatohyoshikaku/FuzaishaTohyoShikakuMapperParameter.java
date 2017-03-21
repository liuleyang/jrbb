/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.fuzaishatohyoshikaku;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 不在者投票資格を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class FuzaishaTohyoShikakuMapperParameter {

    private final ShikibetsuCode 識別コード;
    private final Code 投票資格種類;

    private final boolean uses識別コード;
    private final boolean uses投票資格種類;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 投票資格種類 投票資格種類
     * @param uses識別コード uses識別コード
     * @param uses投票資格種類 uses投票資格種類
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private FuzaishaTohyoShikakuMapperParameter(
            @lombok.NonNull ShikibetsuCode 識別コード,
            @lombok.NonNull Code 投票資格種類,
            boolean uses識別コード,
            boolean uses投票資格種類) {

        this.識別コード = 識別コード;
        this.投票資格種類 = 投票資格種類;
        this.uses識別コード = uses識別コード;
        this.uses投票資格種類 = uses投票資格種類;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @param 投票資格種類 投票資格種類
     * @return 身体手帳検索パラメータ
     */
    public static FuzaishaTohyoShikakuMapperParameter createSelectByKeyParam(
            ShikibetsuCode 識別コード, Code 投票資格種類
    ) {
        return new FuzaishaTohyoShikakuMapperParameter(識別コード, 投票資格種類, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 識別コード 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static FuzaishaTohyoShikakuMapperParameter createSelectListParam(
            ShikibetsuCode 識別コード) {
        return new FuzaishaTohyoShikakuMapperParameter(識別コード, Code.EMPTY, true, false);
    }
}
