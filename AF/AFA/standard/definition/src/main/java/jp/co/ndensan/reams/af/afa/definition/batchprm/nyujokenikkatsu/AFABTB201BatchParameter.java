/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 入場券発行（一括）バッチパラメータクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class AFABTB201BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SENKYOSHURUI = "選挙種類";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_TOUHYOBI = "投票日";
    private static final String KEY_SAKUINLIST = "選挙リスト";
    private static final String KEY_NYUJOKENNAME1 = "入場券名1";
    private static final String KEY_NYUJOKENNAME2 = "入場券名2";
    private static final String KEY_NYUJOKENNAME3 = "入場券名3";
    private static final String KEY_JUMIBUNUMU = "住民分有無";
    private static final String KEY_TEISHUTSUSHABUN = "転出者分有無";
    private static final String KEY_TOUHYOJYOKULIST = "投票区リスト";
    private static final String KEY_INSAKUTYPE = "印刷タイプ";
    private static final String KEY_ISETAIINJININZUU = "世帯印字人数";
    private static final String KEY_TAISHOUSHAWOKOKONIKU = "抽出対象世帯人数有無";
    private static final String KEY_TAISHOUSHAWOSETAINISUU = "抽出対象世帯人数";
    private static final String KEY_TEISHUTSUHYOFROM = "転出日From";
    private static final String KEY_TEISHUTSUHYOTO = "転出日To";
    private static final String KEY_NIJYUTOROKUMASSHOMONO = "二重登録抹消者分も含める有無";
    private static final String KEY_ATENACIRUMOHAKKO = "宛名シールも発行する有無";
    private static final String KEY_SAMPLEBUNJI = "サンプル文字";

    @BatchParameter(key = KEY_SHOHON, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_SENKYOSHURUI, name = "選挙種類", order = 2)
    private RString 選挙種類;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名", order = 3)
    private RString 抄本名;
    @BatchParameter(key = KEY_TOUHYOBI, name = "投票日", order = 4)
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_SAKUINLIST, name = "選挙リスト", order = 5)
    private List<Senkyomeishou> 選挙リスト;
    @BatchParameter(key = KEY_NYUJOKENNAME1, name = "入場券名1", order = 6)
    private RString 入場券名1;
    @BatchParameter(key = KEY_NYUJOKENNAME2, name = "入場券名2", order = 7)
    private RString 入場券名2;
    @BatchParameter(key = KEY_NYUJOKENNAME3, name = "入場券名3", order = 8)
    private RString 入場券名3;
    @BatchParameter(key = KEY_JUMIBUNUMU, name = "住民分有無", order = 9)
    private Boolean 住民分有無;
    @BatchParameter(key = KEY_TEISHUTSUSHABUN, name = "転出者分有無", order = 10)
    private Boolean 転出者分有無;
    @BatchParameter(key = KEY_TOUHYOJYOKULIST, name = "投票区リスト", order = 11)
    private List<TohyokuJyohou> 投票区リスト;
    @BatchParameter(key = KEY_INSAKUTYPE, name = "印刷タイプ", order = 12)
    private RString 印刷タイプ;
    @BatchParameter(key = KEY_ISETAIINJININZUU, name = "世帯印字人数", order = 13)
    private RString 世帯印字人数;
    @BatchParameter(key = KEY_TAISHOUSHAWOKOKONIKU, name = "抽出対象世帯人数有無", order = 14)
    private Boolean 抽出対象世帯人数有無;
    @BatchParameter(key = KEY_TAISHOUSHAWOSETAINISUU, name = "抽出対象世帯人数", order = 15)
    private RString 抽出対象世帯人数;
    @BatchParameter(key = KEY_TEISHUTSUHYOFROM, name = "転出日From", order = 16)
    private FlexibleDate 転出日From;
    @BatchParameter(key = KEY_TEISHUTSUHYOTO, name = "転出日To", order = 17)
    private FlexibleDate 転出日To;
    @BatchParameter(key = KEY_NIJYUTOROKUMASSHOMONO, name = "二重登録抹消者分も含める有無", order = 18)
    private Boolean 二重登録抹消者分も含める有無;
    @BatchParameter(key = KEY_ATENACIRUMOHAKKO, name = "宛名シールも発行する有無", order = 19)
    private Boolean 宛名シールも発行する有無;
    @BatchParameter(key = KEY_SAMPLEBUNJI, name = "サンプル文字", order = 20)
    private RString サンプル文字;

    /**
     * コンストラクタ作成します。
     *
     *
     * @return AFABTB201SelectProcessParameter
     */
    public AFABTB201SelectProcessParameter toAFABTB201SelectProcessParameter() {
        return new AFABTB201SelectProcessParameter(
                null,
                new ShohonNo(抄本番号),
                選挙種類,
                抄本名,
                投票日,
                選挙リスト,
                入場券名1,
                入場券名2,
                入場券名3,
                住民分有無,
                転出者分有無,
                投票区リスト,
                印刷タイプ,
                世帯印字人数,
                抽出対象世帯人数有無,
                抽出対象世帯人数,
                転出日From,
                転出日To,
                null,
                null,
                null,
                null
        );
    }

    /**
     * KEY_SHOHONを返します。
     *
     * @return String
     */
    public static String getKEY_SHOHON() {
        return KEY_SHOHON;
    }

    /**
     * KEY_SENKYOSHURUIを返します。
     *
     * @return String
     */
    public static String getKEY_SENKYOSHURUI() {
        return KEY_SENKYOSHURUI;
    }

    /**
     * KEY_SHOHONNAMEを返します。
     *
     * @return String
     */
    public static String getKEY_SHOHONNAME() {
        return KEY_SHOHONNAME;
    }

    /**
     * KEY_TOUHYOBIを返します。
     *
     * @return String
     */
    public static String getKEY_TOUHYOBI() {
        return KEY_TOUHYOBI;
    }

    /**
     * KEY_SAKUINLISTを返します。
     *
     * @return String
     */
    public static String getKEY_SAKUINLIST() {
        return KEY_SAKUINLIST;
    }

    /**
     * KEY_NYUJOKENNAME1を返します。
     *
     * @return String
     */
    public static String getKEY_NYUJOKENNAME1() {
        return KEY_NYUJOKENNAME1;
    }

    /**
     * KEY_NYUJOKENNAME2を返します。
     *
     * @return String
     */
    public static String getKEY_NYUJOKENNAME2() {
        return KEY_NYUJOKENNAME2;
    }

    /**
     * KEY_NYUJOKENNAME3を返します。
     *
     * @return String
     */
    public static String getKEY_NYUJOKENNAME3() {
        return KEY_NYUJOKENNAME3;
    }

    /**
     * KEY_JUMIBUNUMUを返します。
     *
     * @return String
     */
    public static String getKEY_JUMIBUNUMU() {
        return KEY_JUMIBUNUMU;
    }

    /**
     * KEY_TEISHUTSUSHABUNを返します。
     *
     * @return String
     */
    public static String getKEY_TEISHUTSUSHABUN() {
        return KEY_TEISHUTSUSHABUN;
    }

    /**
     * KEY_TOUHYOJYOKULISTを返します。
     *
     * @return String
     */
    public static String getKEY_TOUHYOJYOKULIST() {
        return KEY_TOUHYOJYOKULIST;
    }

    /**
     * KEY_INSAKUTYPEを返します。
     *
     * @return String
     */
    public static String getKEY_INSAKUTYPE() {
        return KEY_INSAKUTYPE;
    }

    /**
     * KEY_ISETAIINJININZUUを返します。
     *
     * @return String
     */
    public static String getKEY_ISETAIINJININZUU() {
        return KEY_ISETAIINJININZUU;
    }

    /**
     * KEY_TAISHOUSHAWOKOKONIKUを返します。
     *
     * @return String
     */
    public static String getKEY_TAISHOUSHAWOKOKONIKU() {
        return KEY_TAISHOUSHAWOKOKONIKU;
    }

    /**
     * KEY_TAISHOUSHAWOSETAINISUUを返します。
     *
     * @return String
     */
    public static String getKEY_TAISHOUSHAWOSETAINISUU() {
        return KEY_TAISHOUSHAWOSETAINISUU;
    }

    /**
     * KEY_TEISHUTSUHYOFROMを返します。
     *
     * @return String
     */
    public static String getKEY_TEISHUTSUHYOFROM() {
        return KEY_TEISHUTSUHYOFROM;
    }

    /**
     * KEY_TEISHUTSUHYOTOを返します。
     *
     * @return String
     */
    public static String getKEY_TEISHUTSUHYOTO() {
        return KEY_TEISHUTSUHYOTO;
    }

    /**
     * KEY_NIJYUTOROKUMASSHOMONOを返します。
     *
     * @return String
     */
    public static String getKEY_NIJYUTOROKUMASSHOMONO() {
        return KEY_NIJYUTOROKUMASSHOMONO;
    }

    /**
     * KEY_ATENACIRUMOHAKKOを返します。
     *
     * @return String
     */
    public static String getKEY_ATENACIRUMOHAKKO() {
        return KEY_ATENACIRUMOHAKKO;
    }

    /**
     * KEY_SAMPLEBUNJIを返します。
     *
     * @return String
     */
    public static String getKEY_SAMPLEBUNJI() {
        return KEY_SAMPLEBUNJI;
    }

    /**
     * 抄本番号を返します。
     *
     * @return String
     */
    public RString get抄本番号() {
        return 抄本番号;
    }

    /**
     * 選挙種類を返します。
     *
     * @return String
     */
    public RString get選挙種類() {
        return 選挙種類;
    }

    /**
     * 抄本名を返します。
     *
     * @return String
     */
    public RString get抄本名() {
        return 抄本名;
    }

    /**
     * 投票日を返します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get投票日() {
        return 投票日;
    }

    /**
     * 選挙リストを返します。
     *
     * @return List<Senkyomeishou>
     */
    public List<Senkyomeishou> get選挙リスト() {
        return 選挙リスト;
    }

    /**
     * 入場券名1を返します。
     *
     * @return RString
     */
    public RString get入場券名1() {
        return 入場券名1;
    }

    /**
     * 入場券名2を返します。
     *
     * @return RString
     */
    public RString get入場券名2() {
        return 入場券名2;
    }

    /**
     * 入場券名3を返します。
     *
     * @return RString
     */
    public RString get入場券名3() {
        return 入場券名3;
    }

    /**
     * 住民分有無を返します。
     *
     * @return Boolean
     */
    public Boolean is住民分有無() {
        return 住民分有無;
    }

    /**
     * 転出者分有無を返します。
     *
     * @return Boolean
     */
    public Boolean is転出者分有無() {
        return 転出者分有無;
    }

    /**
     * 投票区リストを返します。
     *
     * @return List<TohyokuJyohou>
     */
    public List<TohyokuJyohou> get投票区リスト() {
        return 投票区リスト;
    }

    /**
     * 印刷タイプを返します。
     *
     * @return RString
     */
    public RString get印刷タイプ() {
        return 印刷タイプ;
    }

    /**
     * 世帯印字人数を返します。
     *
     * @return RString
     */
    public RString get世帯印字人数() {
        return 世帯印字人数;
    }

    /**
     * 抽出対象世帯人数有無を返します。
     *
     * @return Boolean
     */
    public Boolean is抽出対象世帯人数有無() {
        return 抽出対象世帯人数有無;
    }

    /**
     * 抽出対象世帯人数を返します。
     *
     * @return RString
     */
    public RString get抽出対象世帯人数() {
        return 抽出対象世帯人数;
    }

    /**
     * 転出日Fromを返します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get転出日From() {
        return 転出日From;
    }

    /**
     * 転出日Toを返します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate get転出日To() {
        return 転出日To;
    }

    /**
     * 二重登録抹消者分も含める有無を返します。
     *
     * @return Boolean
     */
    public Boolean is二重登録抹消者分も含める有無() {
        return 二重登録抹消者分も含める有無;
    }

    /**
     * 宛名シールも発行する有無を返します。
     *
     * @return Boolean
     */
    public Boolean is宛名シールも発行する有無() {
        return 宛名シールも発行する有無;
    }

    /**
     * サンプル文字を返します。
     *
     * @return RString
     */
    public RString getサンプル文字() {
        return サンプル文字;
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
     * 投票日を設定します。
     *
     * @param 投票日 RString
     */
    public void set投票日(FlexibleDate 投票日) {
        this.投票日 = 投票日;
    }

    /**
     * 選挙リストを設定します。
     *
     * @param 選挙リスト RString
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
     * 住民分有無を設定します。
     *
     * @param 住民分有無 RString
     */
    public void set住民分有無(Boolean 住民分有無) {
        this.住民分有無 = 住民分有無;
    }

    /**
     * 転出者分有無を設定します。
     *
     * @param 転出者分有無 RString
     */
    public void set転出者分有無(Boolean 転出者分有無) {
        this.転出者分有無 = 転出者分有無;
    }

    /**
     * 投票区リストを設定します。
     *
     * @param 投票区リスト RString
     */
    public void set投票区リスト(List<TohyokuJyohou> 投票区リスト) {
        this.投票区リスト = 投票区リスト;
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
     * 抽出対象世帯人数有無を設定します。
     *
     * @param 抽出対象世帯人数有無 RString
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
     * @param 転出日From RString
     */
    public void set転出日From(FlexibleDate 転出日From) {
        this.転出日From = 転出日From;
    }

    /**
     * 転出日Toを設定します。
     *
     * @param 転出日To RString
     */
    public void set転出日To(FlexibleDate 転出日To) {
        this.転出日To = 転出日To;
    }

    /**
     * 二重登録抹消者分も含める有無を設定します。
     *
     * @param 二重登録抹消者分も含める有無 RString
     */
    public void set二重登録抹消者分も含める有無(Boolean 二重登録抹消者分も含める有無) {
        this.二重登録抹消者分も含める有無 = 二重登録抹消者分も含める有無;
    }

    /**
     * 宛名シールも発行する有無を設定します。
     *
     * @param 宛名シールも発行する有無 RString
     */
    public void set宛名シールも発行する有無(Boolean 宛名シールも発行する有無) {
        this.宛名シールも発行する有無 = 宛名シールも発行する有無;
    }

    /**
     * サンプル文字を設定します。
     *
     * @param サンプル文字 RString
     */
    public void setサンプル文字(RString サンプル文字) {
        this.サンプル文字 = サンプル文字;
    }

}
