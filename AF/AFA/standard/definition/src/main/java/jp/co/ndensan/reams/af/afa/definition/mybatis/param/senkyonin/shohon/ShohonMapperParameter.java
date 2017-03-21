/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.shohon;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 抄本を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ShohonMapperParameter {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private final ShohonNo 抄本番号;
    private final Code 選挙種類;

//    private final RString 抄本名;
//    private final FlexibleDate 投票年月日;
//    private final FlexibleDate 規定年齢到達年月日;
//    private final FlexibleDate 処理年月日;
//    private final Decimal 入場券発行固有連番;
    private final boolean uses抄本番号;
    private final boolean uses選挙種類;
//    private final boolean uses抄本名;
//    private final boolean uses投票年月日;
//    private final boolean uses規定年齢到達年月日;
//    private final boolean uses処理年月日;
//    private final boolean uses入場券発行固有連番;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙種類 選挙種類
     * @param uses抄本番号 uses抄本番号
     * @param uses選挙種類 uses選挙種類
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShohonMapperParameter(
            @lombok.NonNull ShohonNo 抄本番号,
            @lombok.NonNull Code 選挙種類,
            boolean uses抄本番号,
            boolean uses選挙種類) {

        this.抄本番号 = 抄本番号;
        this.選挙種類 = 選挙種類;

        this.uses抄本番号 = uses抄本番号;
        this.uses選挙種類 = uses選挙種類;
    }

// TODO 用途に応じたパラメータ生成メソッドを追加、修正してください。
    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙種類 選挙種類
     * @return 身体手帳検索パラメータ
     */
    public static ShohonMapperParameter createSelectByKeyParam(
            ShohonNo 抄本番号,
            Code 選挙種類) {
        return new ShohonMapperParameter(抄本番号, 選挙種類, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 抄本番号 抄本番号
     * @return 身体手帳検索パラメータ
     */
    public static ShohonMapperParameter createSelectListParam(
            ShohonNo 抄本番号) {
        return new ShohonMapperParameter(抄本番号, Code.EMPTY, true, false);
    }
}
