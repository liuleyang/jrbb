/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoninmeibo;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人名簿を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SenkyoninMeiboMapperParameter {

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

    private final boolean uses抄本番号;
    private final boolean usesグループコード;
    private final boolean uses投票区コード;
    private final boolean uses冊;
    private final boolean uses頁;
    private final boolean uses行;
    private final boolean uses履歴番号;
    private final boolean uses識別コード;
    private final boolean uses投票区変更抹消フラグ;
    private final boolean uses連番;
    private final boolean uses枝番;

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
     * @param uses抄本番号 uses抄本番号
     * @param usesグループコード usesグループコード
     * @param uses投票区コード uses投票区コード
     * @param uses冊 uses冊
     * @param uses頁 uses頁
     * @param uses行 uses行
     * @param uses履歴番号 uses履歴番号
     * @param uses識別コード uses識別コード
     * @param uses投票区変更抹消フラグ uses投票区変更抹消フラグ
     * @param uses連番 uses連番
     * @param uses枝番 uses枝番
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private SenkyoninMeiboMapperParameter(
            @lombok.NonNull ShohonNo 抄本番号,
            @lombok.NonNull RString グループコード,
            @lombok.NonNull RString 投票区コード,
            @lombok.NonNull RString 冊,
            int 頁,
            int 行,
            @lombok.NonNull BigSerial 履歴番号,
            @lombok.NonNull ShikibetsuCode 識別コード,
            @lombok.NonNull boolean 投票区変更抹消フラグ,
            @lombok.NonNull int 連番,
            @lombok.NonNull int 枝番,
            @lombok.NonNull boolean uses抄本番号,
            @lombok.NonNull boolean usesグループコード,
            @lombok.NonNull boolean uses投票区コード,
            @lombok.NonNull boolean uses冊,
            @lombok.NonNull boolean uses頁,
            @lombok.NonNull boolean uses行,
            @lombok.NonNull boolean uses履歴番号,
            @lombok.NonNull boolean uses識別コード,
            @lombok.NonNull boolean uses投票区変更抹消フラグ,
            @lombok.NonNull boolean uses連番,
            @lombok.NonNull boolean uses枝番
    ) {

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

        this.uses抄本番号 = uses抄本番号;
        this.usesグループコード = usesグループコード;
        this.uses投票区コード = uses投票区コード;
        this.uses冊 = uses冊;
        this.uses頁 = uses頁;
        this.uses行 = uses行;
        this.uses履歴番号 = uses履歴番号;
        this.uses識別コード = uses識別コード;
        this.uses投票区変更抹消フラグ = uses投票区変更抹消フラグ;
        this.uses連番 = uses連番;
        this.uses枝番 = uses枝番;

    }

    /**
     * キー検索用のパラメータを生成します。
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
     * @return 身体手帳検索パラメータ
     */
    public static SenkyoninMeiboMapperParameter createSelectByKeyParam(
            ShohonNo 抄本番号,
            RString グループコード,
            RString 投票区コード,
            RString 冊,
            int 頁,
            int 行,
            BigSerial 履歴番号,
            ShikibetsuCode 識別コード,
            boolean 投票区変更抹消フラグ,
            int 連番,
            int 枝番
    ) {
        return new SenkyoninMeiboMapperParameter(
                抄本番号,
                グループコード,
                投票区コード,
                冊,
                頁,
                行,
                履歴番号,
                識別コード,
                投票区変更抹消フラグ,
                連番,
                枝番,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true);
    }

    /**
     * キー検索用のパラメータを生成します。
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
     * @param uses抄本番号 uses抄本番号
     * @param usesグループコード usesグループコード
     * @param uses投票区コード uses投票区コード
     * @param uses冊 uses冊
     * @param uses頁 uses頁
     * @param uses行 uses行
     * @param uses履歴番号 uses履歴番号
     * @param uses識別コード uses識別コード
     * @param uses投票区変更抹消フラグ uses投票区変更抹消フラグ
     * @param uses連番 uses連番
     * @param uses枝番 uses枝番
     * @return 選挙人名簿パラメータ
     */
    public static SenkyoninMeiboMapperParameter createSelectByKeyParam(
            ShohonNo 抄本番号,
            RString グループコード,
            RString 投票区コード,
            RString 冊,
            int 頁,
            int 行,
            BigSerial 履歴番号,
            ShikibetsuCode 識別コード,
            boolean 投票区変更抹消フラグ,
            int 連番,
            int 枝番,
            boolean uses抄本番号,
            boolean usesグループコード,
            boolean uses投票区コード,
            boolean uses冊,
            boolean uses頁,
            boolean uses行,
            boolean uses履歴番号,
            boolean uses識別コード,
            boolean uses投票区変更抹消フラグ,
            boolean uses連番,
            boolean uses枝番
    ) {
        return new SenkyoninMeiboMapperParameter(
                抄本番号,
                グループコード,
                投票区コード,
                冊,
                頁,
                行,
                履歴番号,
                識別コード,
                投票区変更抹消フラグ,
                連番,
                枝番,
                uses抄本番号,
                usesグループコード,
                uses投票区コード,
                uses冊,
                uses頁,
                uses行,
                uses履歴番号,
                uses識別コード,
                uses投票区変更抹消フラグ,
                uses連番,
                uses枝番
        );
    }

//    /**
//     * 一覧検索用のパラメータを生成します。
//     *
//     * @param 主キー1 主キー1
//     * @return パラメータパラメータ
//     */
//    public static SenkyoninMeiboMapperParameter createSelectListParam(
//            主キー型1 主キー1) {
//        return new SenkyoninMeiboMapperParameter(主キー1, 主キー型2.ZERO, true, false);
//    }
}
