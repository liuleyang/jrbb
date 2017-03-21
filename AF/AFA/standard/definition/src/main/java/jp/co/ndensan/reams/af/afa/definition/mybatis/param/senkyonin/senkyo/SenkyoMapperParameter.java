/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SenkyoMapperParameter {

    private final RString 選挙名称;
    private final RString 選挙略称;

    private final boolean uses選挙名称;
    private final boolean uses選挙略称;

    /**
     * コンストラクタです。
     *
     * @param 選挙名称 選挙名称
     * @param 選挙略称 選挙略称
     * @param uses選挙名称 uses選挙名称
     * @param uses選挙略称 uses選挙略称
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private SenkyoMapperParameter(
            @lombok.NonNull RString 選挙名称,
            @lombok.NonNull RString 選挙略称,
            boolean uses選挙名称,
            boolean uses選挙略称) {

        this.選挙名称 = 選挙名称;
        this.選挙略称 = 選挙略称;

        this.uses選挙名称 = uses選挙名称;
        this.uses選挙略称 = uses選挙略称;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 選挙名称 選挙名称
     * @param uses選挙略称 選挙略称
     * @return 身体手帳検索パラメータ
     */
    public static SenkyoMapperParameter createSelectByKeyParam(
            RString 選挙名称,
            RString uses選挙略称) {
        return new SenkyoMapperParameter(選挙名称, uses選挙略称, true, true);
    }
}
