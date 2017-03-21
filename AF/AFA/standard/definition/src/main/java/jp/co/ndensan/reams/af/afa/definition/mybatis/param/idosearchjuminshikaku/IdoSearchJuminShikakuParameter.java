/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.idosearchjuminshikaku;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0180-013 liuj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public final class IdoSearchJuminShikakuParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

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
    private final FlexibleDate 生年月日;
    private final int 最大表示件数;
    private final boolean is在外;
    private final boolean is国政選挙_地方選挙;

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
    private final boolean isUsing生年月日;
    private final boolean is選挙資格LeftJoin;
    private final boolean is2刑持ち;
    private final boolean is選挙情報あり;

    /**
     * 検索用のパラメータを生成します。
     *
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
     * @param 生年月日 生年月日
     * @param 最大表示件数 int
     * @param is在外 boolean
     * @param is国政選挙_地方選挙 boolean
     * @param is2刑持ち boolean
     * @param isUsing生年月日 boolean
     * @param is選挙資格LeftJoin boolean
     * @param is選挙情報あり boolean
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public IdoSearchJuminShikakuParameter(
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
            FlexibleDate 生年月日,
            int 最大表示件数,
            boolean is在外,
            boolean is国政選挙_地方選挙,
            boolean is2刑持ち,
            boolean isUsing生年月日,
            boolean is選挙資格LeftJoin,
            boolean is選挙情報あり,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
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
        this.生年月日 = 生年月日;
        this.最大表示件数 = 最大表示件数;
        this.is在外 = is在外;
        this.is国政選挙_地方選挙 = is国政選挙_地方選挙;
        this.is2刑持ち = is2刑持ち;
        this.isUsing生年月日 = isUsing生年月日;
        this.is選挙資格LeftJoin = is選挙資格LeftJoin;
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
        this.is選挙情報あり = is選挙情報あり;
    }

    private static boolean isUsing日付(FlexibleDate 日付) {
        return 日付 != null && !日付.isEmpty();
    }

    private static boolean isUsingコード(RString コード) {
//        return !コード.isNullOrEmpty();
        return コード != null && !コード.isEmpty();
    }

}
