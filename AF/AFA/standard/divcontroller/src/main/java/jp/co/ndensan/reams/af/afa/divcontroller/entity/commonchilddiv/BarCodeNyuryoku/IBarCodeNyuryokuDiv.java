package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 */
public interface IBarCodeNyuryokuDiv extends ICommonChildDivBaseProperties {

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param tohyoJokyo TohyoJokyo 投票状況
     * @param isシミュレーション boolean
     */
    void initialize(TohyoJokyo tohyoJokyo, boolean isシミュレーション);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * バーコードを取得する
     *
     * @return バーコード
     */
    RString getBarCode();

    /**
     * バーコードから抄本番号を取得する
     *
     * @return 抄本番号
     */
    RString getShohonNo();

    /**
     * バーコードから選挙番号を取得する
     *
     * @return 選挙番号
     */
    RString getSenkyoNo();

    /**
     * 入場券用バーコードから識別コードを取得する
     *
     * @return 識別コード
     */
    ShikibetsuCode getShikibetsuCodeNyujoken();

    /**
     * 不在者投票受理用バーコードから識別コードを取得する
     *
     * @return 識別コード
     */
    ShikibetsuCode getShikibetsuCodeJuri();

    /**
     * バーコードテキストボックスのSelectControlIdを取得する
     *
     * @return バーコードのSelectControlId
     */
    RString getSelectControlIdForBarCode();

    /**
     * 読み込みバーコードと指定抄本番号のチェックメソッドです。
     *
     * @param shohonNo RString
     * @return Boolean true:抄本番号が一致
     */
    Boolean isMatchShohonNo(RString shohonNo);

    /**
     * 入場券バーコードをセットする。
     *
     * @param shohonNo 抄本番号
     * @param shikibetsuCode 識別コード
     */
    void setBarCodeForNyujoken(RString shohonNo, ShikibetsuCode shikibetsuCode);

    /**
     * 入場券バーコードTxtを返す。
     *
     * @return TextBox バーコードテキストボックス
     */
    TextBox getTxtBarCode();

    /**
     * BarCodeNyuryokuValidationHandlerを返す。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs validateバーコード();
}
