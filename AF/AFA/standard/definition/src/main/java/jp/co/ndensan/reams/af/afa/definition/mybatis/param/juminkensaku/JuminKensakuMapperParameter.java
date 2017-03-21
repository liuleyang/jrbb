/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.juminkensaku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住民検索を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public final class JuminKensakuMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo 抄本番号;
    private final Code 選挙種類;
    private final RString 投票区コード;
    private final List<Code> 選挙資格リスト;
    private final List<Code> 投票資格リスト;
    private final FlexibleDate 名簿登録日From;
    private final FlexibleDate 名簿登録日To;
    private final Code 登録事由コード;
    private final FlexibleDate 登録停止日From;
    private final FlexibleDate 登録停止日To;
    private final Code 登録停止事由コード;
    private final FlexibleDate 抹消日From;
    private final FlexibleDate 抹消日To;
    private final Code 抹消事由コード;
    private final FlexibleDate 表示日From;
    private final FlexibleDate 表示日To;
    private final Code 表示事由コード;
    private final FlexibleDate 消除予定日From;
    private final FlexibleDate 消除予定日To;
    private final FlexibleDate 表示消除日From;
    private final FlexibleDate 表示消除日To;
    private final FlexibleDate 刑期終了日From;
    private final FlexibleDate 刑期終了日To;
    private final RString 冊;
    private final int 頁;
    private final int 行;
    private final List<Code> 投票状況リスト;
    private final FlexibleDate 受付日From;
    private final FlexibleDate 受付日To;
    private final RTime 受付時刻From;
    private final RTime 受付時刻To;
    private final int 受付番号;
    private final RString 施設コード;
    private final int 最大表示件数;
    private final boolean is在外;
    private final ShikibetsuCode 識別コード;

    private final boolean isUsing投票区コード;
    private final boolean is選挙資格リスト1件以上;
    private final boolean is投票資格リスト1件以上;
    private final boolean isUsing名簿登録日From;
    private final boolean isUsing名簿登録日To;
    private final boolean isUsing登録事由コード;
    private final boolean isUsing登録停止日From;
    private final boolean isUsing登録停止日To;
    private final boolean isUsing登録停止事由コード;
    private final boolean isUsing抹消日From;
    private final boolean isUsing抹消日To;
    private final boolean isUsing抹消事由コード;
    private final boolean isUsing表示日From;
    private final boolean isUsing表示日To;
    private final boolean isUsing表示事由コード;
    private final boolean isUsing消除予定日From;
    private final boolean isUsing消除予定日To;
    private final boolean isUsing表示消除日From;
    private final boolean isUsing表示消除日To;
    private final boolean isUsing刑期終了日From;
    private final boolean isUsing刑期終了日To;
    private final boolean isUsing冊;
    private final boolean isUsing頁;
    private final boolean isUsing行;
    private final boolean is投票状況リスト1件以上;
    private final boolean isUsing受付日From;
    private final boolean isUsing受付日To;
    private final boolean isUsing受付時刻From;
    private final boolean isUsing受付時刻To;
    private final boolean isUsing受付番号;
    private final boolean isUsing施設コード;
    private final boolean is2刑持ち;
    private final boolean isUsing識別コード;
    private final boolean is宛名情報あり;
    private final boolean is選挙情報あり;
    private final boolean is投票状況情報あり;

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 抄本番号 RString
     * @param 選挙種類コード Code
     * @param 投票区コード RString
     * @param 選挙資格リスト List
     * @param 投票資格リスト List
     * @param 名簿登録日From FlexibleDate
     * @param 名簿登録日To FlexibleDate
     * @param 登録事由コード RString
     * @param 登録停止日From FlexibleDate
     * @param 登録停止日To FlexibleDate
     * @param 登録停止事由コード RString
     * @param 抹消日From FlexibleDate
     * @param 抹消日To FlexibleDate
     * @param 抹消事由コード RString
     * @param 表示日From FlexibleDate
     * @param 表示日To FlexibleDate
     * @param 表示事由コード RString
     * @param 消除予定日From FlexibleDate
     * @param 消除予定日To FlexibleDate
     * @param 表示消除日From FlexibleDate
     * @param 表示消除日To FlexibleDate
     * @param 刑期終了日From FlexibleDate
     * @param 刑期終了日To FlexibleDate
     * @param 冊 RString
     * @param 頁 Decimal
     * @param 行 Decimal
     * @param 投票状況リスト List
     * @param 受付日From FlexibleDate
     * @param 受付日To FlexibleDate
     * @param 受付時刻From RTime
     * @param 受付時刻To RTime
     * @param 受付番号 RString
     * @param 施設コード RString
     * @param 最大表示件数 int
     * @param 識別コード ShikibetsuCode
     * @param is在外 boolean
     * @param is2刑持ち boolean
     * @param is宛名情報あり boolean
     * @param is選挙情報あり boolean
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public JuminKensakuMapperParameter(
            RString 抄本番号,
            Code 選挙種類コード,
            RString 投票区コード,
            List<Code> 選挙資格リスト,
            List<Code> 投票資格リスト,
            FlexibleDate 名簿登録日From,
            FlexibleDate 名簿登録日To,
            RString 登録事由コード,
            FlexibleDate 登録停止日From,
            FlexibleDate 登録停止日To,
            RString 登録停止事由コード,
            FlexibleDate 抹消日From,
            FlexibleDate 抹消日To,
            RString 抹消事由コード,
            FlexibleDate 表示日From,
            FlexibleDate 表示日To,
            RString 表示事由コード,
            FlexibleDate 消除予定日From,
            FlexibleDate 消除予定日To,
            FlexibleDate 表示消除日From,
            FlexibleDate 表示消除日To,
            FlexibleDate 刑期終了日From,
            FlexibleDate 刑期終了日To,
            RString 冊,
            Decimal 頁,
            Decimal 行,
            List<Code> 投票状況リスト,
            FlexibleDate 受付日From,
            FlexibleDate 受付日To,
            RTime 受付時刻From,
            RTime 受付時刻To,
            RString 受付番号,
            RString 施設コード,
            int 最大表示件数,
            ShikibetsuCode 識別コード,
            boolean is在外,
            boolean is2刑持ち,
            boolean is宛名情報あり,
            boolean is選挙情報あり,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.抄本番号 = new ShohonNo(抄本番号);
        this.選挙種類 = 選挙種類コード;
        this.投票区コード = 投票区コード;
        this.選挙資格リスト = 選挙資格リスト;
        this.投票資格リスト = 投票資格リスト;
        this.名簿登録日From = 名簿登録日From;
        this.名簿登録日To = 名簿登録日To;
        this.登録事由コード = new Code(登録事由コード);
        this.登録停止日From = 登録停止日From;
        this.登録停止日To = 登録停止日To;
        this.登録停止事由コード = new Code(登録停止事由コード);
        this.抹消日From = 抹消日From;
        this.抹消日To = 抹消日To;
        this.抹消事由コード = new Code(抹消事由コード);
        this.表示日From = 表示日From;
        this.表示日To = 表示日To;
        this.表示事由コード = new Code(表示事由コード);
        this.消除予定日From = 消除予定日From;
        this.消除予定日To = 消除予定日To;
        this.表示消除日From = 表示消除日From;
        this.表示消除日To = 表示消除日To;
        this.刑期終了日From = 刑期終了日From;
        this.刑期終了日To = 刑期終了日To;
        this.冊 = 冊;
        this.頁 = 頁 == null ? Integer.MIN_VALUE : 頁.intValue();
        this.行 = 行 == null ? Integer.MIN_VALUE : 行.intValue();
        this.投票状況リスト = 投票状況リスト;
        this.受付日From = 受付日From;
        this.受付日To = 受付日To;
        this.受付時刻From = 受付時刻From;
        this.受付時刻To = 受付時刻To;
        this.受付番号 = RString.isNullOrEmpty(受付番号) ? Integer.MIN_VALUE : Integer.parseInt(受付番号.toString());
        this.施設コード = 施設コード;
        this.最大表示件数 = 最大表示件数;
        this.識別コード = 識別コード;
        this.is在外 = is在外;
        this.is2刑持ち = is2刑持ち;
        this.isUsing投票区コード = !RString.isNullOrEmpty(投票区コード);
        this.is選挙資格リスト1件以上 = 選挙資格リスト.size() >= 1;
        this.is投票資格リスト1件以上 = 投票資格リスト.size() >= 1;
        this.isUsing名簿登録日From = isUsing日付(名簿登録日From);
        this.isUsing名簿登録日To = isUsing日付(名簿登録日To);
        this.isUsing登録事由コード = isUsingコード(登録事由コード);
        this.isUsing登録停止日From = isUsing日付(登録停止日From);
        this.isUsing登録停止日To = isUsing日付(登録停止日To);
        this.isUsing登録停止事由コード = isUsingコード(登録停止事由コード);
        this.isUsing抹消日From = isUsing日付(抹消日From);
        this.isUsing抹消日To = isUsing日付(抹消日To);
        this.isUsing抹消事由コード = isUsingコード(抹消事由コード);
        this.isUsing表示日From = isUsing日付(表示日From);
        this.isUsing表示日To = isUsing日付(表示日To);
        this.isUsing表示事由コード = isUsingコード(表示事由コード);
        this.isUsing消除予定日From = isUsing日付(消除予定日From);
        this.isUsing消除予定日To = isUsing日付(消除予定日To);
        this.isUsing表示消除日From = isUsing日付(表示消除日From);
        this.isUsing表示消除日To = isUsing日付(表示消除日To);
        this.isUsing刑期終了日From = isUsing日付(刑期終了日From);
        this.isUsing刑期終了日To = isUsing日付(刑期終了日To);
        this.isUsing冊 = !RString.isNullOrEmpty(冊);
        this.isUsing頁 = 頁 != null;
        this.isUsing行 = 行 != null;
        this.is投票状況リスト1件以上 = 投票状況リスト.size() >= 1;
        this.isUsing受付日From = isUsing日付(受付日From);
        this.isUsing受付日To = isUsing日付(受付日To);
        this.isUsing受付時刻From = isUsing時刻(受付時刻From);
        this.isUsing受付時刻To = isUsing時刻(受付時刻To);
        this.isUsing受付番号 = !RString.isNullOrEmpty(受付番号);
        this.isUsing施設コード = !RString.isNullOrEmpty(施設コード);
        this.isUsing識別コード = isUsingShikibetsuCode(識別コード);
        this.is宛名情報あり = is宛名情報あり;
        this.is選挙情報あり = is選挙情報あり;
        this.is投票状況情報あり = isUsing投票状況情報();
    }

    private static boolean isUsing日付(FlexibleDate 日付) {
        return 日付 != null && !日付.isEmpty();
    }

    private static boolean isUsingコード(RString コード) {
        return !RString.isNullOrEmpty(コード);
    }

    private static boolean isUsing時刻(RTime 時刻) {
        return 時刻 != null;
    }

    private static boolean isUsingShikibetsuCode(ShikibetsuCode 識別コード) {
        return 識別コード != null && !識別コード.isEmpty();
    }

    private boolean isUsing投票状況情報() {
        return isUsing冊 || isUsing頁 || isUsing行 || is投票状況リスト1件以上 || isUsing受付日From || isUsing受付日To
                || isUsing受付時刻From || isUsing受付時刻To || isUsing受付番号 || isUsing施設コード;
    }
}
