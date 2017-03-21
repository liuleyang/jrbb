/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.tohyojokyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票状況を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0130-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public final class TohyojokyoMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo 抄本番号;
    private final ShikibetsuCode 識別コード;
    private final RString 端末ID;
    private final SenkyoNo 選挙番号;
    private final FlexibleDate 報告年月日;
    private final RString 施設コード;
    private final RString 投票区コード;
    private final RString 投票状況;
    private final RString 性別コード;
    private final Code 期日前不在者区分;
    private final boolean use選挙人名簿;

    private final boolean use報告年月日;
    private final boolean use施設コード;
    private final boolean use投票区コード;
    private final boolean use投票状況;
    private final boolean use性別コード;
    private final boolean use期日前不在者区分;

    private boolean 代理投票有フラグ;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param 端末ID 端末ID
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況
     * @param 性別コード 性別コード
     * @param 期日前不在者区分 期日前不在者区分
     * @param use選挙人名簿 use選挙人名簿
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    private TohyojokyoMapperParameter(
            ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            RString 端末ID,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況,
            RString 性別コード,
            Code 期日前不在者区分,
            boolean use選挙人名簿,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.抄本番号 = 抄本番号;
        this.識別コード = 識別コード;
        this.端末ID = 端末ID;
        this.選挙番号 = 選挙番号;
        this.報告年月日 = 報告年月日;
        this.施設コード = 施設コード;
        this.投票区コード = 投票区コード;
        this.投票状況 = 投票状況;
        this.性別コード = 性別コード;
        this.期日前不在者区分 = 期日前不在者区分;
        this.use選挙人名簿 = use選挙人名簿;
        this.use報告年月日 = (null != 報告年月日 && !報告年月日.isEmpty());
        this.use投票区コード = (null != 投票区コード && !投票区コード.isNullOrEmpty());
        this.use施設コード = (null != 施設コード && !施設コード.isNullOrEmpty());
        this.use投票状況 = (null != 投票状況 && !投票状況.isNullOrEmpty());
        this.use性別コード = (null != 性別コード && !性別コード.isEmpty());
        this.use期日前不在者区分 = (null != 期日前不在者区分 && !期日前不在者区分.isEmpty());
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況
     * @param 性別コード 性別コード
     * @param 期日前不在者区分 期日前不在者区分
     * @param use選挙人名簿 use選挙人名簿
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return 投票状況検索パラメータ
     */
    public static TohyojokyoMapperParameter createParam(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況,
            RString 性別コード,
            Code 期日前不在者区分,
            boolean use選挙人名簿,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));
        return new TohyojokyoMapperParameter(抄本番号, null, null, 選挙番号, 報告年月日, 施設コード, 投票区コード,
                投票状況, 性別コード, 期日前不在者区分, use選挙人名簿, searchKey);
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return 投票状況検索パラメータ
     */
    public static TohyojokyoMapperParameter createParam(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));

        Code 期日前不在者区分 = Code.EMPTY;
        boolean use選挙人名簿 = false;
        if (投票状況.equals(TohyoJokyo.期日前.getCode())) {
            期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.期日前投票.value());
        } else if (投票状況.equals(TohyoJokyo.当日.getCode())) {
            期日前不在者区分 = new Code(KijitsumaeFuzaishaKubun.当日投票.value());
            use選挙人名簿 = true;
        }
        return new TohyojokyoMapperParameter(抄本番号, null, null, 選挙番号, 報告年月日, 施設コード, 投票区コード,
                投票状況, RString.EMPTY, 期日前不在者区分, use選挙人名簿, searchKey);
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード ShikibetsuCode
     * @param 端末ID RString
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return 投票状況検索パラメータ
     */
    public static TohyojokyoMapperParameter createParam(
            ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            RString 端末ID,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        return new TohyojokyoMapperParameter(抄本番号, 識別コード, 端末ID, null, null, null, null,
                null, null, null, false, searchKey);
    }
}
