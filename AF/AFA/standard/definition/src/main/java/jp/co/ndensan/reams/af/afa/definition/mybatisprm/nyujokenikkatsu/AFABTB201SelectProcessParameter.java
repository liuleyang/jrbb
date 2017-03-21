/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.TohyokuJyohou;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 入場券発行（一括）バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class AFABTB201SelectProcessParameter implements IBatchProcessParameter {

    private RString sort;

    private RString order順;

    private List<RString> 改頁項目IDリスト;

    private ShohonNo 抄本番号;

    private RString 選挙種類;

    private RString 抄本名;

    private FlexibleDate 投票日;

    private List<Senkyomeishou> 選挙リスト;

    private RString 入場券名1;

    private RString 入場券名2;

    private RString 入場券名3;

    private Boolean 住民分有無;

    private Boolean 転出者分有無;

    private List<TohyokuJyohou> 投票区リスト;

    private RString 印刷タイプ;

    private RString 世帯印字人数;

    private Boolean 抽出対象世帯人数有無;

    private RString 抽出対象世帯人数;

    private FlexibleDate 転出日From;

    private FlexibleDate 転出日To;

    private Boolean 二重登録抹消者分も含める有無;

    private Boolean 宛名シールも発行する有無;

    private RString サンプル文字;
    private List<Decimal> 入場券発行固有連番リスト;
    private RString 帳票ID;
    private FlexibleDate 転入期限日;
    private FlexibleDate 年齢到達期限日;
    private FlexibleDate 前回基準日;
    private RString table;
    private RString soufusakiJouhoutable;
    private RString groupKubun;
    private List<RString> 帳票名リスト;
    private List<Decimal> ページ数リスト;
    private List<RString> 出力順リスト;
    private List<RString> 改頁条件リスト;
    private List<RString> 詳細設定リスト;
    private RString ジョブ番号;
    private IShikibetsuTaishoPSMSearchKey key;

    private SetaiCode setaiCode;
    private Integer setaiCodeCount;

    /**
     *
     *
     * @param 抄本番号 RString
     * @param 抄本名 RString
     * @param 選挙種類 RString
     * @param 投票日 FlexibleDate
     * @param 選挙リスト List<Senkyomeishou>
     * @param 入場券名1 RString
     * @param 入場券名2 RString
     * @param 入場券名3 RString
     * @param 住民分有無 Boolean
     * @param 転出者分有無 Boolean
     * @param 投票区リスト List<TohyokuJyohou>
     * @param 印刷タイプ RString Boolean
     * @param 世帯印字人数 RString Boolean
     * @param 抽出対象世帯人数有無 Boolean
     * @param 抽出対象世帯人数 Boolean
     * @param 転出日From FlexibleDate
     * @param 転出日To FlexibleDate
     * @param 二重登録抹消者分も含める有無 Boolean
     * @param 宛名シールも発行する有無 Boolean
     * @param サンプル文字 RString
     * @param 帳票ID RString
     * @param 改頁項目IDリスト List<RString>
     */
    public AFABTB201SelectProcessParameter(
            List<RString> 改頁項目IDリスト,
            ShohonNo 抄本番号,
            RString 選挙種類,
            RString 抄本名,
            FlexibleDate 投票日,
            List<Senkyomeishou> 選挙リスト,
            RString 入場券名1,
            RString 入場券名2,
            RString 入場券名3,
            Boolean 住民分有無,
            Boolean 転出者分有無,
            List<TohyokuJyohou> 投票区リスト,
            RString 印刷タイプ,
            RString 世帯印字人数,
            Boolean 抽出対象世帯人数有無,
            RString 抽出対象世帯人数,
            FlexibleDate 転出日From,
            FlexibleDate 転出日To,
            Boolean 二重登録抹消者分も含める有無,
            Boolean 宛名シールも発行する有無,
            RString サンプル文字,
            RString 帳票ID) {
        this.改頁項目IDリスト = 改頁項目IDリスト;
        this.抄本番号 = 抄本番号;
        this.選挙種類 = 選挙種類;
        this.抄本名 = 抄本名;
        this.投票日 = 投票日;
        this.選挙リスト = 選挙リスト;
        this.入場券名1 = 入場券名1;
        this.入場券名2 = 入場券名2;
        this.入場券名3 = 入場券名3;
        this.住民分有無 = 住民分有無;
        this.転出者分有無 = 転出者分有無;
        this.投票区リスト = 投票区リスト;
        this.印刷タイプ = 印刷タイプ;
        this.世帯印字人数 = 世帯印字人数;
        this.抽出対象世帯人数有無 = 抽出対象世帯人数有無;
        this.抽出対象世帯人数 = 抽出対象世帯人数;
        this.転出日From = 転出日From;
        this.転出日To = 転出日To;
        this.二重登録抹消者分も含める有無 = 二重登録抹消者分も含める有無;
        this.宛名シールも発行する有無 = 宛名シールも発行する有無;
        this.サンプル文字 = サンプル文字;
        this.帳票ID = 帳票ID;
    }

    /**
     * コンストラクタ作成します。
     *
     * @return NyujokenIkkatsuMybatisParameter
     */
    public NyujokenIkkatsuMybatisParameter toNyujokenIkkatsuMybatisParameter() {
        return new NyujokenIkkatsuMybatisParameter(
                key,
                抄本番号,
                選挙種類,
                order順,
                null,
                0,
                null);
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

    /**
     * 住民分有無を設定します。
     *
     * @return 住民分有無
     */
    public Boolean is住民分有無() {
        return 住民分有無;
    }

    /**
     * 転出者分有無を設定します。
     *
     * @return 転出者分有無
     */
    public Boolean is転出者分有無() {
        return 転出者分有無;
    }

    /**
     * 投票区リストを設定します。
     *
     * @return 投票区リスト
     */
    public List<TohyokuJyohou> get投票区リスト() {
        return 投票区リスト;
    }

    /**
     * 抽出対象世帯人数有無を設定します。
     *
     * @return 抽出対象世帯人数有無
     */
    public Boolean is抽出対象世帯人数有無() {
        return 抽出対象世帯人数有無;
    }

    /**
     * 抽出対象世帯人数を設定します。
     *
     * @return 抽出対象世帯人数
     */
    public RString get抽出対象世帯人数() {
        return 抽出対象世帯人数;
    }

    /**
     * 転出日Fromを設定します。
     *
     * @return 転出日From
     */
    public FlexibleDate get転出日From() {
        return 転出日From;
    }

    /**
     * 転出日Toを設定します。
     *
     * @return 転出日To
     */
    public FlexibleDate get転出日To() {
        return 転出日To;
    }

    /**
     * 二重登録抹消者分も含める有無を設定します。
     *
     * @return 二重登録抹消者分も含める有無
     */
    public Boolean is二重登録抹消者分も含める有無() {
        return 二重登録抹消者分も含める有無;
    }

    /**
     * 宛名シールも発行する有無を設定します。
     *
     * @return 宛名シールも発行する有無
     */
    public Boolean is宛名シールも発行する有無() {
        return 宛名シールも発行する有無;
    }

    /**
     * 転入期限日を設定します。
     *
     * @return 転入期限日
     */
    public FlexibleDate get転入期限日() {
        return 転入期限日;
    }

    /**
     * 年齢到達期限日を設定します。
     *
     * @return 年齢到達期限日
     */
    public FlexibleDate get年齢到達期限日() {
        return 年齢到達期限日;
    }

    /**
     * 前回基準日を設定します。
     *
     * @return 前回基準日
     */
    public FlexibleDate get前回基準日() {
        return 前回基準日;
    }

    /**
     * tableを設定します。
     *
     * @return table
     */
    public RString getTable() {
        return table;
    }

    /**
     * 住民分有無を設定します。
     *
     * @param 住民分有無 Boolean
     */
    public void set住民分有無(Boolean 住民分有無) {
        this.住民分有無 = 住民分有無;
    }

    /**
     * 転出者分有無を設定します。
     *
     * @param 転出者分有無 Boolean
     */
    public void set転出者分有無(Boolean 転出者分有無) {
        this.転出者分有無 = 転出者分有無;
    }

    /**
     * 投票区リストを設定します。
     *
     * @param 投票区リスト List<TohyokuJyohou>
     */
    public void set投票区リスト(List<TohyokuJyohou> 投票区リスト) {
        this.投票区リスト = 投票区リスト;
    }

    /**
     * 抽出対象世帯人数有無を設定します。
     *
     * @param 抽出対象世帯人数有無 Boolean
     */
    public void set抽出対象世帯人数有無(Boolean 抽出対象世帯人数有無) {
        this.抽出対象世帯人数有無 = 抽出対象世帯人数有無;
    }

    /**
     * 抽出対象世帯人数を設定します。
     *
     * @param 抽出対象世帯人数 RString
     */
    public void set抽出対象世帯人数(RString 抽出対象世帯人数) {
        this.抽出対象世帯人数 = 抽出対象世帯人数;
    }

    /**
     * 転出日Fromを設定します。
     *
     * @param 転出日From FlexibleDate
     */
    public void set転出日From(FlexibleDate 転出日From) {
        this.転出日From = 転出日From;
    }

    /**
     * 転出日Toを設定します。
     *
     * @param 転出日To FlexibleDate
     */
    public void set転出日To(FlexibleDate 転出日To) {
        this.転出日To = 転出日To;
    }

    /**
     * 二重登録抹消者分も含める有無を設定します。
     *
     * @param 二重登録抹消者分も含める有無 Boolean
     */
    public void set二重登録抹消者分も含める有無(Boolean 二重登録抹消者分も含める有無) {
        this.二重登録抹消者分も含める有無 = 二重登録抹消者分も含める有無;
    }

    /**
     * 宛名シールも発行する有無を設定します。
     *
     * @param 宛名シールも発行する有無 Boolean
     */
    public void set宛名シールも発行する有無(Boolean 宛名シールも発行する有無) {
        this.宛名シールも発行する有無 = 宛名シールも発行する有無;
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
     * 年齢到達期限日を設定します。
     *
     * @param 年齢到達期限日 FlexibleDate
     */
    public void set年齢到達期限日(FlexibleDate 年齢到達期限日) {
        this.年齢到達期限日 = 年齢到達期限日;
    }

    /**
     * 前回基準日を設定します。
     *
     * @param 前回基準日 FlexibleDate
     */
    public void set前回基準日(FlexibleDate 前回基準日) {
        this.前回基準日 = 前回基準日;
    }

    /**
     * tableを設定します。
     *
     * @param table RString
     */
    public void setTable(RString table) {
        this.table = table;
    }

    /**
     * soufusakiJouhoutableを返します。
     *
     * @return soufusakiJouhoutable RString
     */
    public RString getSoufusakiJouhoutable() {
        return soufusakiJouhoutable;
    }

    /**
     * soufusakiJouhoutableを設定します。
     *
     * @param soufusakiJouhoutable RString
     */
    public void setSoufusakiJouhoutable(RString soufusakiJouhoutable) {
        this.soufusakiJouhoutable = soufusakiJouhoutable;
    }

    /**
     * groupKubunを設定します。
     *
     * @param groupKubun RString
     */
    public void setGroupKubun(RString groupKubun) {
        this.groupKubun = groupKubun;
    }

    /**
     * groupKubunを返します。
     *
     * @return groupKubun RString
     */
    public RString getGroupKubun() {
        return groupKubun;
    }

    /**
     * 帳票名リストを返します。
     *
     * @return 帳票名リスト List<RString>
     */
    public List<RString> get帳票名リスト() {
        return 帳票名リスト;
    }

    /**
     * ページ数リストを返します。
     *
     * @return ページ数リスト List<Decimal>
     */
    public List<Decimal> getページ数リスト() {
        return ページ数リスト;
    }

    /**
     * 帳票名リストを設定します。
     *
     * @param 帳票名リスト List<RString>
     */
    public void set帳票名リスト(List<RString> 帳票名リスト) {
        this.帳票名リスト = 帳票名リスト;
    }

    /**
     * ページ数リストを設定します。
     *
     * @param ページ数リスト List<Decimal>
     */
    public void setページ数リスト(List<Decimal> ページ数リスト) {
        this.ページ数リスト = ページ数リスト;
    }

    /**
     * 出力順リストを返します。
     *
     * @return 出力順リスト List<RString>
     */
    public List<RString> get出力順リスト() {
        return 出力順リスト;
    }

    /**
     * 改頁条件リストを返します。
     *
     * @return 改頁条件リスト List<RString>
     */
    public List<RString> get改頁条件リスト() {
        return 改頁条件リスト;
    }

    /**
     * 詳細設定リストを返します。
     *
     * @return 詳細設定リスト List<RString>
     */
    public List<RString> get詳細設定リスト() {
        return 詳細設定リスト;
    }

    /**
     * 出力順リストを設定します。
     *
     * @param 出力順リスト List<RString>
     */
    public void set出力順リスト(List<RString> 出力順リスト) {
        this.出力順リスト = 出力順リスト;
    }

    /**
     * 改頁条件リストを設定します。
     *
     * @param 改頁条件リスト List<RString>
     */
    public void set改頁条件リスト(List<RString> 改頁条件リスト) {
        this.改頁条件リスト = 改頁条件リスト;
    }

    /**
     * 詳細設定リストを設定します。
     *
     * @param 詳細設定リスト List<RString>
     */
    public void set詳細設定リスト(List<RString> 詳細設定リスト) {
        this.詳細設定リスト = 詳細設定リスト;
    }

    /**
     * 入場券発行固有連番リストを設定します。
     *
     * @return 入場券発行固有連番リスト List<Decimal>
     */
    public List<Decimal> get入場券発行固有連番リスト() {
        return 入場券発行固有連番リスト;
    }

    /**
     * 入場券発行固有連番リストを設定します。
     *
     * @param 入場券発行固有連番リスト List<Decimal>
     */
    public void set入場券発行固有連番リスト(List<Decimal> 入場券発行固有連番リスト) {
        this.入場券発行固有連番リスト = 入場券発行固有連番リスト;
    }

    /**
     * ジョブ番号を設定します。
     *
     * @return ジョブ番号 List<RString>
     */
    public RString getジョブ番号() {
        return ジョブ番号;
    }

    /**
     * ジョブ番号を設定します。
     *
     * @param ジョブ番号 List<RString>
     */
    public void setジョブ番号(RString ジョブ番号) {
        this.ジョブ番号 = ジョブ番号;
    }

    /**
     * keyを設定します。
     *
     * @return key IShikibetsuTaishoPSMSearchKey
     */
    public IShikibetsuTaishoPSMSearchKey getKey() {
        return key;
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
     * SetaiCodeを設定します。
     *
     * @return setaiCode SetaiCode
     */
    public SetaiCode getSetaiCode() {
        return setaiCode;
    }

    /**
     * keyを設定します。
     *
     * @return setaiCodeCount Integer
     */
    public Integer getSetaiCodeCount() {
        return setaiCodeCount;
    }

    /**
     * setaiCodeを設定します。
     *
     * @param setaiCode SetaiCode
     */
    public void setSetaiCode(SetaiCode setaiCode) {
        this.setaiCode = setaiCode;
    }

    /**
     * setaiCodeCountを設定します。
     *
     * @param setaiCodeCount Integer
     */
    public void setSetaiCodeCount(Integer setaiCodeCount) {
        this.setaiCodeCount = setaiCodeCount;
    }

}
