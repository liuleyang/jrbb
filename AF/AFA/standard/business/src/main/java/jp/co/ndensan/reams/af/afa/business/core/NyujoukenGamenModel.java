/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入場券発行情報（一括）モデル
 *
 * @reamsid_L AF-0160-032 guyq
 */
public class NyujoukenGamenModel {

    private RString 抄本番号;
    private RString 抄本名;
    private RDate 投票年月日;
    private RDate 告示年月日;
    private RDate 基準日;
    private List<SenkyomeishouParam> 選挙名称;
    private RString 入場券名称1;
    private RString 入場券名称2;
    private RString 入場券名称3;
    private RString サンプル文字;
    private Association 地方公共団体情報;

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号 RString
     */
    public RString get抄本番号() {
        return this.抄本番号;
    }

    /**
     * 告示年月日を返します。
     *
     * @return 告示年月日 RDate
     */
    public RDate get告示年月日() {
        return 告示年月日;
    }

    /**
     * 基準日を返します。
     *
     * @return 基準日 RDate
     */
    public RDate get基準日() {
        return 基準日;
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
     * 投票年月日を返します。
     *
     * @return 投票年月日 RDate
     */
    public RDate get投票年月日() {
        return this.投票年月日;
    }

    /**
     * 選挙名称を返します。
     *
     * @return 選挙名称 List<SenkyomeishouParam>
     */
    public List<SenkyomeishouParam> get選挙名称() {
        return this.選挙名称;
    }

    /**
     * サンプル文字を返します。
     *
     * @return サンプル文字 RString
     */
    public RString getサンプル文字() {
        return サンプル文字;
    }

    /**
     * 入場券名称1を返します。
     *
     * @return 入場券名称1 RString
     */
    public RString get入場券名称1() {
        return this.入場券名称1;
    }

    /**
     * 入場券名称2を返します。
     *
     * @return 入場券名称2 RString
     */
    public RString get入場券名称2() {
        return this.入場券名称2;
    }

    /**
     * 入場券名称3を返します。
     *
     * @return 入場券名称3 RString
     */
    public RString get入場券名称3() {
        return this.入場券名称3;
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
     * 告示年月日を設定します。
     *
     * @param 告示年月日 RDate
     */
    public void set告示年月日(RDate 告示年月日) {
        this.告示年月日 = 告示年月日;
    }

    /**
     * 投票年月日を設定します。
     *
     * @param 投票年月日 RDate
     */
    public void set投票年月日(RDate 投票年月日) {
        this.投票年月日 = 投票年月日;
    }

    /**
     * 基準日を設定します。
     *
     * @param 基準日 RDate
     */
    public void set基準日(RDate 基準日) {
        this.基準日 = 基準日;
    }

    /**
     * 選挙名称を設定します。
     *
     * @param 選挙名称 List<SenkyomeishouParam>
     */
    public void set選挙名称(List<SenkyomeishouParam> 選挙名称) {
        this.選挙名称 = 選挙名称;
    }

    /**
     * 入場券名称1を設定します。
     *
     * @param 入場券名称1 RString
     */
    public void set入場券名称1(RString 入場券名称1) {
        this.入場券名称1 = 入場券名称1;
    }

    /**
     * 入場券名称2を設定します。
     *
     * @param 入場券名称2 RString
     */
    public void set入場券名称2(RString 入場券名称2) {
        this.入場券名称2 = 入場券名称2;
    }

    /**
     * 入場券名称3を設定します。
     *
     * @param 入場券名称3 RString
     */
    public void set入場券名称3(RString 入場券名称3) {
        this.入場券名称3 = 入場券名称3;
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
     * 地方公共団体情報を返します。
     *
     * @return 地方公共団体情報 Association
     */
    public Association get地方公共団体情報() {
        return 地方公共団体情報;
    }

    /**
     * 地方公共団体情報を設定します。
     *
     * @param 地方公共団体情報 Association
     */
    public void set地方公共団体情報(Association 地方公共団体情報) {
        this.地方公共団体情報 = 地方公共団体情報;
    }

}
