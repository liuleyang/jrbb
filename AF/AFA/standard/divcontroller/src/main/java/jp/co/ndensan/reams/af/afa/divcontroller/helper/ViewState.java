/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.barcodejuri.BarCodeJuriSearchResult;
import jp.co.ndensan.reams.af.afa.business.barcodetojitsu.BarCodeTojitsuResult;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * ViewStateHolderのラッパークラスです
 *
 * @reamsid_L AF-0115-010 xul
 */
public final class ViewState {

    private ViewState() {
    }

    /**
     * 選挙種類 をViewStateにputします
     *
     * @param senkyoShurui 選挙種類
     */
    public static void set選挙種類(SenkyoShurui senkyoShurui) {
        ViewStateHolder.put(ViewStateKeys.住民検索_選挙種類, senkyoShurui);
    }

    /**
     * 選挙種類 をViewStateからgetします
     *
     * @return 選挙種類
     */
    public static SenkyoShurui get選挙種類() {
        return ViewStateHolder.get(ViewStateKeys.住民検索_選挙種類, SenkyoShurui.class);
    }

    /**
     * メニューID をViewStateにputします
     *
     * @param menuID RString
     */
    public static void setメニューID(RString menuID) {
        ViewStateHolder.put(ViewStateKeys.メニューID, menuID);
    }

    /**
     * メニューID をViewStateからgetします
     *
     * @return menuID RString
     */
    public static RString getメニューID() {
        return ViewStateHolder.get(ViewStateKeys.メニューID, RString.class);
    }

    /**
     * メニューID をViewStateにputします
     *
     * @param shohonNo RString
     */
    public static void set抄本番号(RString shohonNo) {
        ViewStateHolder.put(ViewStateKeys.抄本番号, shohonNo);
    }

    /**
     * メニューID をViewStateからgetします
     *
     * @return 抄本番号 RString
     */
    public static RString get抄本番号() {
        return ViewStateHolder.get(ViewStateKeys.抄本番号, RString.class);
    }

    /**
     * 氏名をViewStateにputします
     *
     * @param 氏名 RString
     */
    public static void set氏名(RString 氏名) {
        ViewStateHolder.put(ViewStateKeys.氏名, 氏名);
    }

    /**
     * 氏名をViewStateからgetします
     *
     * @return 氏名 RString
     */
    public static RString get氏名() {
        return ViewStateHolder.get(ViewStateKeys.氏名, RString.class);
    }

    /**
     * 受付番号をViewStateにputします
     *
     * @param 受付番号 RString
     */
    public static void set受付番号(RString 受付番号) {
        ViewStateHolder.put(ViewStateKeys.受付番号, 受付番号);
    }

    /**
     * 受付番号をViewStateからgetします
     *
     * @return 受付番号 RString
     */
    public static RString get受付番号() {
        return ViewStateHolder.get(ViewStateKeys.受付番号, RString.class);
    }

    /**
     * 投票状況データをViewStateにputします
     *
     * @param 投票状況データ List<BarCodeJuriSearchResult>
     */
    public static void set投票状況データ(List<BarCodeJuriSearchResult> 投票状況データ) {
        ViewStateHolder.put(ViewStateKeys.投票状況データ, new ArrayList<>(投票状況データ));
    }

    /**
     * 投票状況データをViewStateからgetします
     *
     * @return 投票状況データ List<BarCodeJuriSearchResult>
     */
    public static List<BarCodeJuriSearchResult> get投票状況データ() {
        return ViewStateHolder.get(ViewStateKeys.投票状況データ, ArrayList.class);
    }

    /**
     * 選挙人名簿データをViewStateにputします
     *
     * @param 選挙人名簿データ List<BarCodeTojitsuResult>
     */
    public static void set選挙人名簿データ(List<BarCodeTojitsuResult> 選挙人名簿データ) {
        ViewStateHolder.put(ViewStateKeys.選挙人名簿データ, (Serializable) 選挙人名簿データ);
    }

    /**
     * 選挙人名簿データをViewStateからgetします
     *
     * @return 選挙人名簿データ List<BarCodeTojitsuResult>
     */
    public static List<BarCodeTojitsuResult> get選挙人名簿データ() {
        return ViewStateHolder.get(ViewStateKeys.選挙人名簿データ, ArrayList.class);
    }

    /**
     * 選挙種類の入力情報を全て削除します。
     */
    public static void removeAll() {
        ViewStateHolder.remove(ViewStateKeys.住民検索_選挙種類.toString());
        ViewStateHolder.remove(ViewStateKeys.住民検索_選挙種類.toString());
    }

    /**
     * ViewStateからsetします.
     *
     * @param key ViewStateKeys
     * @param target Object
     */
    public static void setData(ViewStateKeys key, Serializable target) {
        ViewStateHolder.put(key, target);
    }

    /**
     * ViewStateからgetします.
     *
     * @param <T> 取得対象するクラス型
     * @param key 取得対象のキー
     * @param clazz 取得対象するクラス型
     * @return 取得された内容
     */
    public static <T> T getData(Enum key, Class<T> clazz) {
        return ViewStateHolder.get(key, clazz);
    }
}
