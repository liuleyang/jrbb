/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * BarCodeNyuryokuDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してBarCodeNyuryokuDivの表示の制御を行ったり、情報を受け取ったりすることができます。 <br />
 * 入場券用バーコード：識別コード(15)＋抄本番号(4) <br />
 * 受理用バーコード　：識別コード(15)＋抄本番号(4)＋選挙番号(1) <br />
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-020 qiuxy
 */
public class BarCodeNyuryokuHandler {

    private final BarCodeNyuryokuDiv div;
    private static final int KETA_SHOHONNO = 4;
    private static final int KETA_SHOHONNO_ADD = 1;
    private static final int KETA_SHIKIBETSUCODE = 15;
    private static final int ゼロ = 0;

    /**
     * コンストラクタです。
     *
     * @param div バーコード入力Div
     */
    public BarCodeNyuryokuHandler(BarCodeNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param tohyoJokyo TohyoJokyo
     * @param isシミュレーション boolean
     */
    public void initialize(TohyoJokyo tohyoJokyo, boolean isシミュレーション) {
        ViewStateHolder.put(ViewStateKeys.isシミュレーション, isシミュレーション);
        if (tohyoJokyo == TohyoJokyo.期日前) {
            if (isシミュレーション) {
                div.getTxtBarCode().setMaxLength(Integer.parseInt(BusinessConfig.get(ConfigKeysAFA.バーコード桁数_入場券用_シミュレーション, SubGyomuCode.AFA選挙本体).toString()));
            } else {
                div.getTxtBarCode().setMaxLength(Integer.parseInt(BusinessConfig.get(ConfigKeysAFA.バーコード桁数_入場券用, SubGyomuCode.AFA選挙本体).toString()));
            }
        } else if (tohyoJokyo == TohyoJokyo.受理) {
            div.getTxtBarCode().setMaxLength(Integer.parseInt(BusinessConfig.get(ConfigKeysAFA.バーコード桁数_不在者投票受理用, SubGyomuCode.AFA選挙本体).toString()));
        }
        div.getLength().setText(new RString(div.getTxtBarCode().getMaxLength()));
    }

    /**
     * 画面クリアのメソッドです。
     *
     */
    public void clearThisPanel() {
        div.getTxtBarCode().clearValue();
    }

    /**
     * バーコードを取得する
     *
     * @return バーコード
     */
    public RString getBarCode() {
        return div.getTxtBarCode().getValue();
    }

    /**
     * バーコードから抄本番号を取得する
     *
     * @return 抄本番号
     */
    public RString getShohonNo() {
        return getBarCode().substringEmptyOnError(KETA_SHIKIBETSUCODE, KETA_SHIKIBETSUCODE + getShohonNoLength());
    }

    /**
     * バーコードから選挙番号を取得する。
     *
     * @return 選挙番号
     */
    public RString getSenkyoNo() {
        return (getBarCode().length() == KETA_SHIKIBETSUCODE + KETA_SHOHONNO
                || (getBarCode().length() == KETA_SHIKIBETSUCODE + KETA_SHOHONNO + KETA_SHOHONNO_ADD
                && ViewStateHolder.get(ViewStateKeys.isシミュレーション, boolean.class))) ? RString.EMPTY
                : getBarCode().substringEmptyOnError(KETA_SHIKIBETSUCODE + getShohonNoLength());
    }

//識別コードを取得するのに、入場券用と受理用と分ける必要はないので、修正が必要（どちらも1～15桁を取得する）
    /**
     * 入場券用バーコードから識別コードを取得する
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCodeNyujoken() {
        return new ShikibetsuCode(getBarCode().substringEmptyOnError(ゼロ, KETA_SHIKIBETSUCODE));
    }

    /**
     * 不在者投票受理用バーコードから識別コードを取得する
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCodeJuri() {
        // 不在者投票受理用バーコードから識別コードを取得する
        // TODO　受理用の識別コードは15桁から返還テーブルを使用した10桁程度にするかも
        RString juminCode = getBarCode().substringEmptyOnError(ゼロ, KETA_SHIKIBETSUCODE);
        // 抄本番号、選挙番号、juminCodeを使用して、返還テーブルを読み、正しい識別コードを取得する。
//            shikibetsuCode=new ShikibetsuCode(取得した識別コード);
        // とりあえず、このままコードを返却。
        return new ShikibetsuCode(juminCode);
    }

    /**
     * 読み込みバーコードと指定抄本番号のチェックメソッドです。
     *
     * @param shohonNo RString
     * @return Boolean true:抄本番号が一致
     */
    public Boolean isMatchShohonNo(RString shohonNo) {
        return getShohonNo().equalsIgnoreCase(shohonNo.padZeroToLeft(getShohonNoLength()));
    }

    /**
     * 入場券バーコードをセットする。
     *
     * @param shohonNo 抄本番号
     * @param shikibetsuCode 識別コード
     */
    public void setBarCodeForNyujoken(RString shohonNo, ShikibetsuCode shikibetsuCode) {
        div.getTxtBarCode().setValue(shikibetsuCode.getColumnValue().concat(shohonNo.padZeroToLeft(getShohonNoLength())));
    }

    private int getShohonNoLength() {
        if (ViewStateHolder.get(ViewStateKeys.isシミュレーション, boolean.class)) {
            return KETA_SHOHONNO + KETA_SHOHONNO_ADD;
        }
        return KETA_SHOHONNO;
    }

}
