package jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人一括情報取得入力パラメータクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuWriteProcessParameter implements IBatchProcessParameter {

    private ShohonNo 抄本番号;
    private RString 抄本名;
    private RString 選挙種類;
    private RString 出力順;
    private FlexibleDate 投票年月日;

    /**
     * オブジェクトを作成します。
     *
     * @param 抄本番号 ShohonNo
     * @param 抄本名 RString
     * @param 選挙種類 RString
     * @param 出力順 RString
     * @param 投票年月日 FlexibleDate
     */
    public NyujokenIkkatsuWriteProcessParameter(ShohonNo 抄本番号, RString 抄本名, RString 選挙種類, RString 出力順, FlexibleDate 投票年月日) {
        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.選挙種類 = 選挙種類;
        this.出力順 = 出力順;
        this.投票年月日 = 投票年月日;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return 抄本番号;
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
     * 選挙種類を返します。
     *
     * @return 選挙種類
     */
    public RString get選挙種類() {
        return 選挙種類;
    }

    /**
     * 出力順を返します。
     *
     * @return 出力順
     */
    public RString get出力順() {
        return 出力順;
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return 投票年月日;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 ShohonNo
     */
    public void set抄本番号(ShohonNo 抄本番号) {
        this.抄本番号 = 抄本番号;
    }

    /**
     * 選挙種類を設定します。
     *
     * @param 選挙種類 RString
     */
    public void set選挙種類(RString 選挙種類) {
        this.選挙種類 = 選挙種類;
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
     * 出力順を設定します。
     *
     * @param 出力順 RString
     */
    public void set出力順(RString 出力順) {
        this.出力順 = 出力順;
    }

    /**
     * 投票年月日を設定します。
     *
     * @param 投票年月日 FlexibleDate
     */
    public void set投票年月日(FlexibleDate 投票年月日) {
        this.投票年月日 = 投票年月日;
    }

}
