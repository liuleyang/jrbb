/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区議会議員選挙時登録バッチ出力条件表のパラメータクラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
public class AFABTL101BatchPrintProcessParameter implements IBatchProcessParameter {

    private RString 抄本番号;
    private RString 抄本名;
    private FlexibleDate 投票日;
    private FlexibleDate 基準日;
    private FlexibleDate 登録日;
    private FlexibleDate 転出期限日;
    private FlexibleDate 転入期限日;
    private FlexibleDate 年齢期限日;
    private Integer 財産区内居住年数;
    private FlexibleDate 投票開始日;
    private List<RString> 対象者住所条件選択レコードリスト;
    private List<RString> 詳細指定選択レコードリスト;
    private Boolean 選挙人名簿抄本有無;
    private Long ジョブ番号;
    private RString 出力ページ数;
    private RString ファイル名_CSV;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 RString
     * @param 抄本名 RString
     * @param 投票日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @param 登録日 FlexibleDate
     * @param 転出期限日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @param 年齢期限日 FlexibleDate
     * @param 財産区内居住年数 Integer
     * @param 投票開始日 FlexibleDate
     * @param 対象者住所条件選択レコードリスト List<RString>
     * @param 詳細指定選択レコードリスト List<RString>
     * @param 選挙人名簿抄本有無 Boolean
     *
     */
    public AFABTL101BatchPrintProcessParameter(
            RString 抄本番号,
            RString 抄本名,
            FlexibleDate 投票日,
            FlexibleDate 基準日,
            FlexibleDate 登録日,
            FlexibleDate 転出期限日,
            FlexibleDate 転入期限日,
            FlexibleDate 年齢期限日,
            Integer 財産区内居住年数,
            FlexibleDate 投票開始日,
            List<RString> 対象者住所条件選択レコードリスト,
            List<RString> 詳細指定選択レコードリスト,
            Boolean 選挙人名簿抄本有無) {
        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.投票日 = 投票日;
        this.基準日 = 基準日;
        this.登録日 = 登録日;
        this.転出期限日 = 転出期限日;
        this.転入期限日 = 転入期限日;
        this.年齢期限日 = 年齢期限日;
        this.財産区内居住年数 = 財産区内居住年数;
        this.投票開始日 = 投票開始日;
        this.対象者住所条件選択レコードリスト = 対象者住所条件選択レコードリスト;
        this.詳細指定選択レコードリスト = 詳細指定選択レコードリスト;
        this.選挙人名簿抄本有無 = 選挙人名簿抄本有無;
    }

    /**
     * 抄本番号を取得します。
     *
     * @return RString
     */
    public RString get抄本番号() {
        return 抄本番号;
    }

    /**
     * 抄本名を取得します。
     *
     * @return RString
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
     * 基準日を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get基準日() {
        return 基準日;
    }

    /**
     * 登録日を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get登録日() {
        return 登録日;
    }

    /**
     * 転出期限日を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get転出期限日() {
        return 転出期限日;
    }

    /**
     * 転入期限日を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get転入期限日() {
        return 転入期限日;
    }

    /**
     * 年齢期限日を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get年齢期限日() {
        return 年齢期限日;
    }

    /**
     * 財産区内居住年数を取得します。
     *
     * @return Integer
     */
    public Integer get財産区内居住年数() {
        return 財産区内居住年数;
    }

    /**
     * 投票開始日を取得します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get投票開始日() {
        return 投票開始日;
    }

    /**
     * 対象者住所条件選択レコードリストを取得します。
     *
     * @return List<RString>
     */
    public List<RString> get対象者住所条件選択レコードリスト() {
        return 対象者住所条件選択レコードリスト;
    }

    /**
     * 詳細指定選択レコードリストを取得します。
     *
     * @return List<RString>
     */
    public List<RString> get詳細指定選択レコードリスト() {
        return 詳細指定選択レコードリスト;
    }

    /**
     * 選挙人名簿抄本有無を取得します。
     *
     * @return Boolean
     */
    public Boolean is選挙人名簿抄本有無() {
        return 選挙人名簿抄本有無;
    }

    /**
     * ジョブ番号を取得します。
     *
     * @return Long
     */
    public Long getジョブ番号() {
        return ジョブ番号;
    }

    /**
     * 出力ページ数を取得します。
     *
     * @return RString
     */
    public RString get出力ページ数() {
        return 出力ページ数;
    }

    /**
     * ファイル名_CSVを取得します。
     *
     * @return RString
     */
    public RString getファイル名_CSV() {
        return ファイル名_CSV;
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
     * @param 対象者住所条件選択レコードリスト List<RString>
     */
    public void set対象者住所条件選択レコードリスト(List<RString> 対象者住所条件選択レコードリスト) {
        this.対象者住所条件選択レコードリスト = 対象者住所条件選択レコードリスト;
    }

    /**
     * 詳細指定選択レコードリストを設定します。
     *
     * @param 詳細指定選択レコードリスト List<RString>
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
     * ジョブ番号を設定します。
     *
     * @param ジョブ番号 Long
     */
    public void setジョブ番号(Long ジョブ番号) {
        this.ジョブ番号 = ジョブ番号;
    }

    /**
     * 出力ページ数を設定します。
     *
     * @param 出力ページ数 RString
     */
    public void set出力ページ数(RString 出力ページ数) {
        this.出力ページ数 = 出力ページ数;
    }

    /**
     * ファイル名_CSVを設定します。
     *
     * @param ファイル名_CSV RString
     */
    public void setファイル名_CSV(RString ファイル名_CSV) {
        this.ファイル名_CSV = ファイル名_CSV;
    }

}
