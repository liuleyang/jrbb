/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoshikaku;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙資格を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SenkyoShikakuMapperParameter {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private final Code 選挙資格区分;
    private final RString 投票区コード;

    private final boolean uses選挙資格区分;
    private final boolean uses投票区コード;

// TODO 用途に応じてアクセス修飾子を修正してください。
    /**
     * コンストラクタです。
     *
     * @param 選挙資格区分 選挙資格区分
     * @param 投票区コード 投票区コード
     * @param uses選挙資格区分 uses選挙資格区分
     * @param uses投票区コード uses投票区コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private SenkyoShikakuMapperParameter(
            @lombok.NonNull Code 選挙資格区分,
            @lombok.NonNull RString 投票区コード,
            boolean uses選挙資格区分,
            boolean uses投票区コード) {

        this.選挙資格区分 = 選挙資格区分;
        this.投票区コード = 投票区コード;

        this.uses選挙資格区分 = uses選挙資格区分;
        this.uses投票区コード = uses投票区コード;
    }

// TODO 用途に応じたパラメータ生成メソッドを追加、修正してください。
    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 選挙資格区分 選挙資格区分
     * @param 投票区コード 投票区コード
     * @return 身体手帳検索パラメータ
     */
    public static SenkyoShikakuMapperParameter createSelectByKeyParam(
            Code 選挙資格区分,
            RString 投票区コード) {
        return new SenkyoShikakuMapperParameter(選挙資格区分, 投票区コード, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 選挙資格区分 選挙資格区分
     * @return 身体手帳検索パラメータ
     */
    public static SenkyoShikakuMapperParameter createSelectListParam(
            Code 選挙資格区分) {
        return new SenkyoShikakuMapperParameter(選挙資格区分, RString.EMPTY, true, false);
    }
}
