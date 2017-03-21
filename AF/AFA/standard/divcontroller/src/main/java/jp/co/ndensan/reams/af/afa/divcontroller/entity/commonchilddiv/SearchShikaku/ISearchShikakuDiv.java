package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect.ITohyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L AF-0180-011 liuyj
 */
public interface ISearchShikakuDiv extends ICommonChildDivBaseProperties {

    ITohyokuCodeSelectDiv getCcdTohyokuCode();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui
     */
    void initialize(SenkyoShurui senkyoShurui);

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     */
    void initialize();

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 投票区コードを返します。
     *
     * @return RString
     */
    RString get投票区コード();

    /**
     * 選挙資格リストを返します。
     *
     * @return List<RString>
     */
    List<RString> get選挙資格リスト();

    /**
     * 投票資格リストを返します。
     *
     * @return List<RString>
     */
    List<RString> get投票資格リスト();

    /**
     * 名簿登録日Fromを取得します。
     *
     * @return 名簿登録日From
     */
    FlexibleDate get名簿登録日From();

    /**
     * 名簿登録日Toを取得します。
     *
     * @return 名簿登録日To
     */
    FlexibleDate get名簿登録日To();

    /**
     * 登録停止日Fromを取得します。
     *
     * @return 登録停止日From
     */
    FlexibleDate get登録停止日From();

    /**
     * 登録停止日Toを取得します。
     *
     * @return 登録停止日To
     */
    FlexibleDate get登録停止日To();

    /**
     * 抹消日Fromを取得します。
     *
     * @return 抹消日From
     */
    FlexibleDate get抹消日From();

    /**
     * 抹消日Toを取得します。
     *
     * @return 抹消日To
     */
    FlexibleDate get抹消日To();

    /**
     * 表示日Fromを取得します。
     *
     * @return 表示日From
     */
    FlexibleDate get表示日From();

    /**
     * 表示日Toを取得します。
     *
     * @return 表示日To
     */
    FlexibleDate get表示日To();

    /**
     * 消除予定日Fromを取得します。
     *
     * @return 消除予定日From
     */
    FlexibleDate get消除予定日From();

    /**
     * 消除予定日Toを取得します。
     *
     * @return 消除予定日To
     */
    FlexibleDate get消除予定日To();

    /**
     * 表示消除日Fromを取得します。
     *
     * @return 表示消除日From
     */
    FlexibleDate get表示消除日From();

    /**
     * 表示消除日Toを取得します。
     *
     * @return 表示消除日To
     */
    FlexibleDate get表示消除日To();

    /**
     * 刑期終了日Fromを取得します。
     *
     * @return 刑期終了日From
     */
    FlexibleDate get刑期終了日From();

    /**
     * 刑期終了日Toを取得します。
     *
     * @return 刑期終了日To
     */
    FlexibleDate get刑期終了日To();

    /**
     * 登録事由を取得します。
     *
     * @return 登録事由
     */
    RString get登録事由();

    /**
     * 登録停止事由を取得します。
     *
     * @return 登録停止事由
     */
    RString get登録停止事由();

    /**
     * 抹消事由を取得します。
     *
     * @return 抹消事由
     */
    RString get抹消事由();

    /**
     * 表示事由を取得します。
     *
     * @return 表示事由
     */
    RString get表示事由();

    /**
     * 2刑持ちフラグを取得します。
     *
     * @return 2刑持ち2刑持ち
     */
    boolean is2刑持ち();

    /**
     * 日期の大小関係チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs 日期大小関係チェック();

    /**
     * 投票資格チェックボックスを取得します。
     *
     * @return 投票資格チェックボックス
     */
    CheckBoxList getChkSearchTohyoShikaku();

    /**
     * 選挙資格チェックボックスを取得します。
     *
     * @return 選挙資格チェックボックス
     */
    CheckBoxList getChkSearchSenkyoShikaku();
}
