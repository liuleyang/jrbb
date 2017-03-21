package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 不在者投票者一覧表
 *
 * @reamsid_L AF-0270-032 wangl
 */
public class FuzaishaTohyoshaListParam {

    private final KijitsumaeTohyoshaIchiran 不在者投票者明細;
    private final NippoGamenKyotsuKomoku 画面入力項目;
    private List<RString> 改頁リスト;
    private RString 施設名;
    private RString 施設種別;
    private RString 施設種別名称;
    private RString 施設種別略称;
    private RString 合計エリア１;
    private RString 合計エリア2;
    private RString ページ;
    private Decimal カウント;

    /**
     * コンストラクタです。
     *
     * @param 不在者投票者明細 KijitsumaeTohyoshaIchiran
     * @param 画面入力項目 KijitsumaeNippoGamenKomoku
     */
    public FuzaishaTohyoshaListParam(
            KijitsumaeTohyoshaIchiran 不在者投票者明細,
            NippoGamenKyotsuKomoku 画面入力項目) {
        this.不在者投票者明細 = 不在者投票者明細;
        this.画面入力項目 = 画面入力項目;
    }

    /**
     * 不在者投票者明細
     *
     * @return 不在者投票者明細 KijitsumaeTohyoshaIchiran
     */
    public KijitsumaeTohyoshaIchiran get不在者投票者明細() {
        return 不在者投票者明細;
    }

    /**
     * 画面入力項目
     *
     * @return 画面入力項目 KijitsumaeNippoGamenKomoku
     */
    public NippoGamenKyotsuKomoku get画面入力項目() {
        return 画面入力項目;
    }

    /**
     * 改頁リスト
     *
     * @return 改頁リスト List<RString>
     */
    public List<RString> get改頁リスト() {
        return 改頁リスト;
    }

    /**
     * 改頁リストを設定します。
     *
     * @param 改頁リスト List<RString>
     */
    public void set改頁リスト(List<RString> 改頁リスト) {
        this.改頁リスト = 改頁リスト;
    }

    /**
     * 施設名を設定します。
     *
     * @param 施設名 RString
     */
    public void set施設名(RString 施設名) {
        this.施設名 = 施設名;
    }

    /**
     * 施設種別を設定します。
     *
     * @param 施設種別 RString
     */
    public void set施設種別(RString 施設種別) {
        this.施設種別 = 施設種別;
    }

    /**
     * 施設種別名称を設定します。
     *
     * @param 施設種別名称 RString
     */
    public void set施設種別名称(RString 施設種別名称) {
        this.施設種別名称 = 施設種別名称;
    }

    /**
     * 施設種別略称を設定します。
     *
     * @param 施設種別略称 RString
     */
    public void set施設種別略称(RString 施設種別略称) {
        this.施設種別略称 = 施設種別略称;
    }

    /**
     * 合計エリア１を設定します。
     *
     * @param 合計エリア１ RString
     */
    public void set合計エリア１(RString 合計エリア１) {
        this.合計エリア１ = 合計エリア１;
    }

    /**
     * 合計エリア2を設定します。
     *
     * @param 合計エリア2 RString
     */
    public void set合計エリア2(RString 合計エリア2) {
        this.合計エリア2 = 合計エリア2;
    }

    /**
     * ページを設定します。
     *
     * @param ページ RString
     */
    public void setページ(RString ページ) {
        this.ページ = ページ;
    }

    /**
     * カウントを設定します。
     *
     * @param カウント Decimal
     */
    public void setカウント(Decimal カウント) {
        this.カウント = カウント;
    }

    /**
     * 施設名を返します。
     *
     * @return 施設名
     */
    public RString get施設名() {
        return this.施設名;
    }

    /**
     * 施設種別を返します。
     *
     * @return 施設種別
     */
    public RString get施設種別() {
        return this.施設種別;
    }

    /**
     * 施設種別名称を返します。
     *
     * @return 施設種別名称
     */
    public RString get施設種別名称() {
        return this.施設種別名称;
    }

    /**
     * 施設種別略称を返します。
     *
     * @return 施設種別略称
     */
    public RString get施設種別略称() {
        return this.施設種別略称;
    }

    /**
     * 合計エリア１を返します。
     *
     * @return 合計エリア１
     */
    public RString get合計エリア１() {
        return this.合計エリア１;
    }

    /**
     * 合計エリア2を返します。
     *
     * @return 合計エリア2
     */
    public RString get合計エリア2() {
        return this.合計エリア2;
    }

    /**
     * ページを返します。
     *
     * @return ページ
     */
    public RString getページ() {
        return this.ページ;
    }

    /**
     * カウントを返します。
     *
     * @return カウント
     */
    public Decimal getカウント() {
        return this.カウント;
    }
}
