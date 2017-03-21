package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SeikyuHoho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HojoshaNyuryoku.IHojoshaNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KyohiJiyuNyuryoku.IKyohiJiyuNyuryokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect.IShisetsuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.ITohyoJiyuCodeDiv;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITohyoJokyoNyuryokuDiv extends ICommonChildDivBaseProperties {

    /**
     * 投票状況グリッドを取得します。
     *
     * @return DataGrid<dgTohyoJokyo_Row> 投票状況リスト
     */
    DataGrid<dgTohyoJokyo_Row> getDgTohyoJokyo();

    ITohyoJiyuCodeDiv getCcdTohyoJiyu();

    IShisetsuCodeSelectDiv getCcdKofuShisetsu();

    IHojoshaNyuryokuDiv getCcdDairiTohyo();

    IKyohiJiyuNyuryokuDiv getCcdKyohiJiyuNyuryoku();

    /**
     * 投票区分を取得します。
     *
     * @return TohyoJokyo 投票区分
     */
    TohyoJokyo getTohyoKubun();

    /**
     * 請求者を取得します。
     *
     * @return SeikyuHoho 請求者
     */
    SeikyuHoho getSeikyusha();

    /**
     * 投票日を取得します。
     *
     * @return RDate
     */
    RDate getTohyoYMD();

    /**
     * 投票時間を取得します。
     *
     * @return RTime 投票時間
     */
    RTime getTohyoTime();

    /**
     * 点字投票の有無を返します。
     *
     * @return Boolean 点字投票用紙を使用する場合true
     */
    Boolean isTenjiTohyo();

    /**
     * 仮投票の有無を返します。
     *
     * @return Boolean 仮投票させる場合true
     */
    Boolean isKariTohyo();

    /**
     * この共有子Divを使用するときに必ず呼ぶメソッドです。
     *
     * @param senkyoShurui SenkyoShurui 選挙種類
     * @param tohyoJokyo TohyoJokyo 投票状況
     * @param shohonNo RString 抄本NO
     */
    void initialize(SenkyoShurui senkyoShurui, TohyoJokyo tohyoJokyo, RString shohonNo);

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param shohonNo RString 抄本番号
     * @param shikibetsuCode ShikibetsuCode 識別コード
     * @param tohyokuCode RString
     */
    void initialize(RString shohonNo, ShikibetsuCode shikibetsuCode, RString tohyokuCode);

    /**
     * この共有子Divの初期表示を行います。
     *
     * @param shohonNo RString 抄本番号
     * @param shikibetsuCode ShikibetsuCode 識別コード
     * @param tohyokuCode RString
     * @param 選挙番号 SenkyoNo
     */
    void initialize(RString shohonNo, ShikibetsuCode shikibetsuCode, RString tohyokuCode, SenkyoNo 選挙番号);

    /**
     * この共有子Divに設定されているデータをすべてクリアします。
     *
     */
    void clearData();

    /**
     * 共有子Div自身の識別コードをセットします
     *
     * @param shikibetsuCode ShikibetsuCode 識別コード
     */
    void setShikibetsuCode(ShikibetsuCode shikibetsuCode);

    /**
     * 共有子Div自身のsetReadOnlyをセットします
     *
     * @param readOnlySetMode True：照会　False：入力
     */
    void setReadOnlyMode(Boolean readOnlySetMode);

    /**
     * 選挙人投票情報を取得済みかを判定します。
     *
     * @return 検索済みの場合、Trueを返します。
     */
    boolean isSearchAlready();

}
