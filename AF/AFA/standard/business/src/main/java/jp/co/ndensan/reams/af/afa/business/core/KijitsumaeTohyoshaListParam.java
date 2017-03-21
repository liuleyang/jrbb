package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期日前投票者一覧表
 *
 * @reamsid_L AF-0270-033 wangl
 */
public class KijitsumaeTohyoshaListParam {

    private KijitsumaeTohyoshaIchiran 期日前投票者明細;
    private final NippoGamenKyotsuKomoku 画面入力項目;
    private List<RString> 改頁リスト;
    private RString 施設名;
    private RString 合計エリア１;
    private RString 合計エリア2;
    private RString ページ;
    private int カウント;

    /**
     * コンストラクタです。
     *
     * @param 期日前投票者明細 KijitsumaeTohyoshaIchiran
     * @param 画面入力項目 KijitsumaeNippoGamenKomoku
     */
    public KijitsumaeTohyoshaListParam(
            KijitsumaeTohyoshaIchiran 期日前投票者明細,
            NippoGamenKyotsuKomoku 画面入力項目) {
        this.期日前投票者明細 = 期日前投票者明細;
        this.画面入力項目 = 画面入力項目;
    }

    /**
     * 期日前投票者明細
     *
     * @return 期日前投票者明細 KijitsumaeTohyoshaIchiran
     */
    public KijitsumaeTohyoshaIchiran get期日前投票者明細() {
        return 期日前投票者明細;
    }

    /**
     * 期日前投票者明細
     *
     * @param 期日前投票者明細 KijitsumaeTohyoshaIchiran
     */
    public void set期日前投票者明細(KijitsumaeTohyoshaIchiran 期日前投票者明細) {
        this.期日前投票者明細 = 期日前投票者明細;
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
     * @param カウント int
     */
    public void setカウント(int カウント) {
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
    public int getカウント() {
        return this.カウント;
    }

}
