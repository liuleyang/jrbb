/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.nyujokenikkatsu;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.SenkyoninIrain;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入場券発行（個別）バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0170-030 guyq
 */
public class AFABTB202SelectProcessParameter implements IBatchProcessParameter {

    private RString sort;

    private RString order順;

    private List<RString> 改頁項目IDリスト;

    private ShohonNo 抄本番号;

    private RString 抄本名;

    private RString 選挙種類;

    private FlexibleDate 投票日;

    private List<Senkyomeishou> 選挙リスト;

    private RString 入場券名1;

    private RString 入場券名2;

    private RString 入場券名3;

    private List<SenkyoninIrain> 選挙人一覧リスト;

    private RString 印刷タイプ;

    private RString 世帯印字人数;

    private Boolean 対象者を個々に作成する有無;

    private Boolean 対象者の世帯で作成する有無;

    private RString サンプル文字;

    private RString 帳票ID;

    /**
     *
     *
     * @param 抄本番号 RString
     * @param 抄本名 RString
     * @param 選挙種類 RString
     * @param 投票日 FlexibleDate
     * @param 選挙リスト List<SenkyomeishouParam>
     * @param 入場券名1 RString
     * @param 入場券名2 RString
     * @param 入場券名3 RString
     * @param 選挙人一覧リスト List<SenkyoninIrain>
     * @param 印刷タイプ RString
     * @param 世帯印字人数 RString
     * @param 対象者を個々に作成する有無 Boolean
     * @param 対象者の世帯で作成する有無 Boolean
     * @param サンプル文字 RString
     * @param 帳票ID RString
     * @param 改頁項目IDリスト List<RString>
     */
    public AFABTB202SelectProcessParameter(
            ShohonNo 抄本番号,
            RString 抄本名,
            RString 選挙種類,
            FlexibleDate 投票日,
            List<Senkyomeishou> 選挙リスト,
            RString 入場券名1,
            RString 入場券名2,
            RString 入場券名3,
            List<SenkyoninIrain> 選挙人一覧リスト,
            RString 印刷タイプ,
            RString 世帯印字人数,
            Boolean 対象者を個々に作成する有無,
            Boolean 対象者の世帯で作成する有無,
            RString サンプル文字,
            RString 帳票ID,
            List<RString> 改頁項目IDリスト) {

        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.選挙種類 = 選挙種類;
        this.投票日 = 投票日;
        this.選挙リスト = 選挙リスト;
        this.入場券名1 = 入場券名1;
        this.入場券名2 = 入場券名2;
        this.入場券名3 = 入場券名3;
        this.選挙人一覧リスト = 選挙人一覧リスト;
        this.印刷タイプ = 印刷タイプ;
        this.世帯印字人数 = 世帯印字人数;
        this.対象者を個々に作成する有無 = 対象者を個々に作成する有無;
        this.対象者の世帯で作成する有無 = 対象者の世帯で作成する有無;
        this.サンプル文字 = サンプル文字;
        this.帳票ID = 帳票ID;
        this.改頁項目IDリスト = 改頁項目IDリスト;

    }

    /**
     * sortを返します。
     *
     * @return sort RString
     */
    public RString getSort() {
        return this.sort;
    }

    /**
     * order順を返します。
     *
     * @return order順 RString
     */
    public RString getOrder順() {
        return this.order順;
    }

    /**
     * 改頁項目IDリストを返します。
     *
     * @return 改頁項目IDリスト List<RString>
     */
    public List<RString> get改頁項目IDリスト() {
        return this.改頁項目IDリスト;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号 ShohonNo
     */
    public ShohonNo get抄本番号() {
        return this.抄本番号;
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名 RString
     */
    public RString get抄本名() {
        return this.抄本名;
    }

    /**
     * 選挙種類を返します。
     *
     * @return 選挙種類 RString
     */
    public RString get選挙種類() {
        return this.選挙種類;
    }

    /**
     * 投票日を返します。
     *
     * @return 投票日 FlexibleDate
     */
    public FlexibleDate get投票日() {
        return this.投票日;
    }

    /**
     * 選挙リストを返します。
     *
     * @return 選挙リスト List<Senkyomeishou>
     */
    public List<Senkyomeishou> get選挙リスト() {
        return this.選挙リスト;
    }

    /**
     * 入場券名1を返します。
     *
     * @return 入場券名1 RString
     */
    public RString get入場券名1() {
        return this.入場券名1;
    }

    /**
     * 入場券名2を返します。
     *
     * @return 入場券名2 RString
     */
    public RString get入場券名2() {
        return this.入場券名2;
    }

    /**
     * 入場券名3を返します。
     *
     * @return 入場券名3 RString
     */
    public RString get入場券名3() {
        return this.入場券名3;
    }

    /**
     * 選挙人一覧リストを返します。
     *
     * @return 選挙人一覧リスト List<SenkyoninIrain>
     */
    public List<SenkyoninIrain> get選挙人一覧リスト() {
        return this.選挙人一覧リスト;
    }

    /**
     * 印刷タイプを返します。
     *
     * @return 印刷タイプ RString
     */
    public RString get印刷タイプ() {
        return this.印刷タイプ;
    }

    /**
     * 世帯印字人数を返します。
     *
     * @return 世帯印字人数 RString
     */
    public RString get世帯印字人数() {
        return this.世帯印字人数;
    }

    /**
     * 対象者を個々に作成する有無を返します。
     *
     * @return 対象者を個々に作成する有無 Boolean
     */
    public Boolean get対象者を個々に作成する有無() {
        return this.対象者を個々に作成する有無;
    }

    /**
     * 対象者の世帯で作成する有無を返します。
     *
     * @return 対象者の世帯で作成する有無 Boolean
     */
    public Boolean get対象者の世帯で作成する有無() {
        return this.対象者の世帯で作成する有無;
    }

    /**
     * サンプル文字を返します。
     *
     * @return サンプル文字 RString
     */
    public RString getサンプル文字() {
        return this.サンプル文字;
    }

    /**
     * 帳票IDを返します。
     *
     * @return 帳票ID RString
     */
    public RString get帳票ID() {
        return this.帳票ID;
    }

    /**
     * sortを設定します。
     *
     * @param sort RString
     */
    public void setSort(RString sort) {
        this.sort = sort;
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
     * 改頁項目IDリストを設定します。
     *
     * @param 改頁項目IDリスト List<RString>
     */
    public void set改頁項目IDリスト(List<RString> 改頁項目IDリスト) {
        this.改頁項目IDリスト = 改頁項目IDリスト;
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
     * 抄本名を設定します。
     *
     * @param 抄本名 RString
     */
    public void set抄本名(RString 抄本名) {
        this.抄本名 = 抄本名;
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
     * 投票日を設定します。
     *
     * @param 投票日 FlexibleDate
     */
    public void set投票日(FlexibleDate 投票日) {
        this.投票日 = 投票日;
    }

    /**
     * 選挙リストを設定します。
     *
     * @param 選挙リスト List<Senkyomeishou>
     */
    public void set選挙リスト(List<Senkyomeishou> 選挙リスト) {
        this.選挙リスト = 選挙リスト;
    }

    /**
     * 入場券名1を設定します。
     *
     * @param 入場券名1 RString
     */
    public void set入場券名1(RString 入場券名1) {
        this.入場券名1 = 入場券名1;
    }

    /**
     * 入場券名2を設定します。
     *
     * @param 入場券名2 RString
     */
    public void set入場券名2(RString 入場券名2) {
        this.入場券名2 = 入場券名2;
    }

    /**
     * 入場券名3を設定します。
     *
     * @param 入場券名3 RString
     */
    public void set入場券名3(RString 入場券名3) {
        this.入場券名3 = 入場券名3;
    }

    /**
     * 選挙人一覧リストを設定します。
     *
     * @param 選挙人一覧リスト List<SenkyoninIrain>
     */
    public void set選挙人一覧リスト(List<SenkyoninIrain> 選挙人一覧リスト) {
        this.選挙人一覧リスト = 選挙人一覧リスト;
    }

    /**
     * 印刷タイプを設定します。
     *
     * @param 印刷タイプ RString
     */
    public void set印刷タイプ(RString 印刷タイプ) {
        this.印刷タイプ = 印刷タイプ;
    }

    /**
     * 世帯印字人数を設定します。
     *
     * @param 世帯印字人数 RString
     */
    public void set世帯印字人数(RString 世帯印字人数) {
        this.世帯印字人数 = 世帯印字人数;
    }

    /**
     * 対象者を個々に作成する有無を設定します。
     *
     * @param 対象者を個々に作成する有無 Boolean
     */
    public void set対象者を個々に作成する有無(Boolean 対象者を個々に作成する有無) {
        this.対象者を個々に作成する有無 = 対象者を個々に作成する有無;
    }

    /**
     * 対象者の世帯で作成する有無を設定します。
     *
     * @param 対象者の世帯で作成する有無 Boolean
     */
    public void set対象者の世帯で作成する有無(Boolean 対象者の世帯で作成する有無) {
        this.対象者の世帯で作成する有無 = 対象者の世帯で作成する有無;
    }

    /**
     * サンプル文字を設定します。
     *
     * @param サンプル文字 RString
     */
    public void setサンプル文字(RString サンプル文字) {
        this.サンプル文字 = サンプル文字;
    }

    /**
     * 帳票IDを設定します。
     *
     * @param 帳票ID RString
     */
    public void set帳票ID(RString 帳票ID) {
        this.帳票ID = 帳票ID;
    }

}
