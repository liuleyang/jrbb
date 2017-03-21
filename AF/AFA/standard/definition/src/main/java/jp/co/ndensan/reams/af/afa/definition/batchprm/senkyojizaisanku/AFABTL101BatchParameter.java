/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojizaisanku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101BatchPrintProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku.AFABTL101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区議会議員選挙時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class AFABTL101BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHORISHUBETSU = "処理種別";
    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_TOHYOYMD = "投票日";
    private static final String KEY_KIJUNYMD = "基準日";
    private static final String KEY_TOROKUYMD = "登録日";
    private static final String KEY_TENSHUTSUKIGENYMD = "転出期限日";
    private static final String KEY_TENNYUKIGENYMD = "転入期限日";
    private static final String KEY_NENREIKIGENYMD = "年齢期限日";
    private static final String KEY_ZAISANKUKYOJUNENSU = "財産区内居住年数";
    private static final String KEY_STARTTOHYOYMD = "投票開始日";
    private static final String KEY_TAISHOSHAJUSHOJOKENLIST = "対象者住所条件選択レコードリスト";
    private static final String KEY_SHOSAICITELIST = "詳細指定選択レコードリスト";
    private static final String KEY_HASSENKYONINMEIBOSHOHONNO = "選挙人名簿抄本有無";

    @BatchParameter(key = KEY_SHORISHUBETSU, name = "処理種別")
    private RString 処理種別;
    @BatchParameter(key = KEY_SHOHON, name = "抄本番号")
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名")
    private RString 抄本名;
    @BatchParameter(key = KEY_TOHYOYMD, name = "投票日")
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_TOROKUYMD, name = "登録日")
    private FlexibleDate 登録日;
    @BatchParameter(key = KEY_TENSHUTSUKIGENYMD, name = "転出期限日")
    private FlexibleDate 転出期限日;
    @BatchParameter(key = KEY_TENNYUKIGENYMD, name = "転入期限日")
    private FlexibleDate 転入期限日;
    @BatchParameter(key = KEY_NENREIKIGENYMD, name = "年齢期限日")
    private FlexibleDate 年齢期限日;
    @BatchParameter(key = KEY_ZAISANKUKYOJUNENSU, name = "財産区内居住年数")
    private Integer 財産区内居住年数;
    @BatchParameter(key = KEY_STARTTOHYOYMD, name = "投票開始日")
    private FlexibleDate 投票開始日;
    @BatchParameter(key = KEY_TAISHOSHAJUSHOJOKENLIST, name = "対象者住所条件選択レコードリスト")
    private List<RString> 対象者住所条件選択レコードリスト;
    @BatchParameter(key = KEY_SHOSAICITELIST, name = "詳細指定選択レコードリスト")
    private List<RString> 詳細指定選択レコードリスト;
    @BatchParameter(key = KEY_HASSENKYONINMEIBOSHOHONNO, name = "選挙人名簿抄本有無")
    private Boolean 選挙人名簿抄本有無;
    private RString order順;
    private RString 改頁項目ID;
    private RString 画面ID;
    private IShikibetsuTaishoPSMSearchKey key;
    private List<RString> 集計項目IDリスト;

    /**
     * AFABTL101BatchPrintProcessParameterの変換のメソッドです。
     *
     * @return AFABTL101BatchPrintProcessParameter
     */
    public AFABTL101BatchPrintProcessParameter toAFABTL101BatchPrintProcessParameter() {
        if (対象者住所条件選択レコードリスト == null) {
            対象者住所条件選択レコードリスト = new ArrayList<>();
        }
        if (詳細指定選択レコードリスト == null) {
            詳細指定選択レコードリスト = new ArrayList<>();
        }
        return new AFABTL101BatchPrintProcessParameter(
                抄本番号,
                抄本名,
                投票日,
                基準日,
                登録日,
                転出期限日,
                転入期限日,
                年齢期限日,
                財産区内居住年数,
                投票開始日,
                対象者住所条件選択レコードリスト,
                詳細指定選択レコードリスト,
                選挙人名簿抄本有無);
    }

    /**
     * AFABTL101SelectProcessParameterの変換のメソッドです。
     *
     * @return AFABTL101SelectProcessParameter
     */
    public AFABTL101SelectProcessParameter toAFABTL101SelectProcessParameter() {
        return new AFABTL101SelectProcessParameter(key,
                処理種別,
                抄本番号,
                抄本名,
                投票日,
                基準日,
                登録日,
                転出期限日,
                転入期限日,
                年齢期限日,
                財産区内居住年数,
                投票開始日,
                対象者住所条件選択レコードリスト,
                詳細指定選択レコードリスト,
                選挙人名簿抄本有無,
                order順,
                改頁項目ID,
                集計項目IDリスト,
                null,
                null,
                null,
                null,
                null,
                null,
                画面ID);
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public RString get抄本番号() {
        return 抄本番号;
    }

    /**
     * 処理種別を返します。
     *
     * @return 処理種別
     */
    public RString get処理種別() {
        return 処理種別;
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名
     */
    public RString get抄本名() {
        return 抄本名;
    }

    /**
     * 投票日を返します。
     *
     * @return 投票日
     */
    public FlexibleDate get投票日() {
        return 投票日;
    }

    /**
     * 基準日を返します。
     *
     * @return 基準日
     */
    public FlexibleDate get基準日() {
        return 基準日;
    }

    /**
     * 登録日を返します。
     *
     * @return 登録日
     */
    public FlexibleDate get登録日() {
        return 登録日;
    }

    /**
     * 転出期限日を返します。
     *
     * @return 転出期限日
     */
    public FlexibleDate get転出期限日() {
        return 転出期限日;
    }

    /**
     * 転入期限日を返します。
     *
     * @return 転入期限日
     */
    public FlexibleDate get転入期限日() {
        return 転入期限日;
    }

    /**
     * 年齢期限日を返します。
     *
     * @return 年齢期限日
     */
    public FlexibleDate get年齢期限日() {
        return 年齢期限日;
    }

    /**
     * 財産区内居住年数を返します。
     *
     * @return 財産区内居住年数
     */
    public Integer get財産区内居住年数() {
        return 財産区内居住年数;
    }

    /**
     * 投票開始日を返します。
     *
     * @return 投票開始日
     */
    public FlexibleDate get投票開始日() {
        return 投票開始日;
    }

    /**
     * 抄対象者住所条件選択レコードリストを返します。
     *
     * @return 対象者住所条件選択レコードリスト
     */
    public List<RString> get対象者住所条件選択レコードリスト() {
        return 対象者住所条件選択レコードリスト;
    }

    /**
     * 詳細指定選択レコードリストを返します。
     *
     * @return 詳細指定選択レコードリスト
     */
    public List<RString> get詳細指定選択レコードリスト() {
        return 詳細指定選択レコードリスト;
    }

    /**
     * 選挙人名簿抄本有無を返します。
     *
     * @return 選挙人名簿抄本有無
     */
    public Boolean is選挙人名簿抄本有無() {
        return 選挙人名簿抄本有無;
    }

    /**
     * order順を返します。
     *
     * @return order順
     */
    public RString getOrder順() {
        return order順;
    }

    /**
     * keyを返します。
     *
     * @return key
     */
    public IShikibetsuTaishoPSMSearchKey getKey() {
        return key;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 RString
     */
    public void set抄本番号(RString 抄本番号) {
        this.抄本番号 = 抄本番号;
    }

    /**
     * 処理種別を設定します。
     *
     * @param 処理種別 RString
     */
    public void set処理種別(RString 処理種別) {
        this.処理種別 = 処理種別;
    }

    /**
     * 抄本名を設定します。
     *
     * @param 抄本名 RString
     */
    public void set抄本名(RString 抄本名) {
        this.抄本名 = 抄本名;
    }

    /**
     * 投票日を設定します。
     *
     * @param 投票日 FlexibleDate
     */
    public void set投票日(FlexibleDate 投票日) {
        this.投票日 = 投票日;
    }

    /**
     * 基準日を設定します。
     *
     * @param 基準日 FlexibleDate
     */
    public void set基準日(FlexibleDate 基準日) {
        this.基準日 = 基準日;
    }

    /**
     * 登録日を設定します。
     *
     * @param 登録日 FlexibleDate
     */
    public void set登録日(FlexibleDate 登録日) {
        this.登録日 = 登録日;
    }

    /**
     * 転出期限日を設定します。
     *
     * @param 転出期限日 FlexibleDate
     */
    public void set転出期限日(FlexibleDate 転出期限日) {
        this.転出期限日 = 転出期限日;
    }

    /**
     * 転入期限日を設定します。
     *
     * @param 転入期限日 FlexibleDate
     */
    public void set転入期限日(FlexibleDate 転入期限日) {
        this.転入期限日 = 転入期限日;
    }

    /**
     * 年齢期限日を設定します。
     *
     * @param 年齢期限日 FlexibleDate
     */
    public void set年齢期限日(FlexibleDate 年齢期限日) {
        this.年齢期限日 = 年齢期限日;
    }

    /**
     * 財産区内居住年数を設定します。
     *
     * @param 財産区内居住年数 Integer
     */
    public void set財産区内居住年数(Integer 財産区内居住年数) {
        this.財産区内居住年数 = 財産区内居住年数;
    }

    /**
     * 投票開始日を設定します。
     *
     * @param 投票開始日 FlexibleDate
     */
    public void set投票開始日(FlexibleDate 投票開始日) {
        this.投票開始日 = 投票開始日;
    }

    /**
     * 対象者住所条件選択レコードリストを設定します。
     *
     * @param 対象者住所条件選択レコードリスト (List<RString>
     */
    public void set対象者住所条件選択レコードリスト(List<RString> 対象者住所条件選択レコードリスト) {
        this.対象者住所条件選択レコードリスト = 対象者住所条件選択レコードリスト;
    }

    /**
     * 詳細指定選択レコードリストを設定します。
     *
     * @param 詳細指定選択レコードリスト (List<RString>
     */
    public void set詳細指定選択レコードリスト(List<RString> 詳細指定選択レコードリスト) {
        this.詳細指定選択レコードリスト = 詳細指定選択レコードリスト;
    }

    /**
     * 選挙人名簿抄本有無を設定します。
     *
     * @param 選挙人名簿抄本有無 Boolean
     */
    public void set選挙人名簿抄本有無(Boolean 選挙人名簿抄本有無) {
        this.選挙人名簿抄本有無 = 選挙人名簿抄本有無;
    }

    /**
     * order順を設定します。
     *
     * @param order順 RString
     */
    public void setOrder順(RString order順) {
        this.order順 = order順;
    }

    /**
     * 改頁項目IDを設定します。
     *
     * @param 改頁項目ID RString
     */
    public void set改頁項目ID(RString 改頁項目ID) {
        this.改頁項目ID = 改頁項目ID;
    }

    /**
     * 画面IDを設定します。
     *
     * @param 画面ID RString
     */
    public void set画面ID(RString 画面ID) {
        this.画面ID = 画面ID;
    }

    /**
     * keyを設定します。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public void setKey(IShikibetsuTaishoPSMSearchKey key) {
        this.key = key;
    }

    /**
     * 集計項目IDリストを設定します。
     *
     * @return List<RString>
     */
    public List<RString> get集計項目IDリスト() {
        return 集計項目IDリスト;
    }

    /**
     * 集計項目IDリストを設定します。
     *
     * @param 集計項目IDリスト List<RString>
     */
    public void set集計項目IDリスト(List<RString> 集計項目IDリスト) {
        this.集計項目IDリスト = 集計項目IDリスト;
    }

}
