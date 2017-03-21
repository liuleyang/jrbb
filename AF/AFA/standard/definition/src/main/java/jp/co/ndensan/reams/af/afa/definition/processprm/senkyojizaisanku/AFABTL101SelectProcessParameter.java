/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 財産区議会議員選挙時登録バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTL101SelectProcessParameter implements IBatchProcessParameter {

    private IShikibetsuTaishoPSMSearchKey key;
    private RString 処理種別;
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
    private RString order順;
    private RString 改頁項目ID;
    private List<RString> 集計項目IDリスト;
    private RString riyoKubun;
    private RString chushutsuKubun;
    private RDateTime zenkaiChushutsu;
    private RDateTime konkaiChushutsu;
    private RString chuiShuruiCode;
    private RString yukoKigenKubun;
    private RString 画面ID;
    private List<ShohonNo> 抄本番号List;
    private RString table;

    /**
     * コンストラクタです。
     *
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 処理種別 RString
     * @param 抄本番号 RString
     * @param 抄本名 RString
     * @param 投票日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @param 転出期限日 FlexibleDate
     * @param 登録日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @param 年齢期限日 FlexibleDate
     * @param 財産区内居住年数 Integer
     * @param 投票開始日 FlexibleDate
     * @param 対象者住所条件選択レコードリスト List<RString>
     * @param order順 RString
     * @param konkaiChushutsu RDateTime
     * @param 詳細指定選択レコードリスト List<RString>
     * @param 改頁項目ID RString
     * @param 選挙人名簿抄本有無 Boolean
     * @param 集計項目IDリスト List<RString>
     * @param riyoKubun RString
     * @param yukoKigenKubun RString
     * @param zenkaiChushutsu RString
     * @param chushutsuKubun RString
     * @param chuiShuruiCode RString
     * @param 画面ID RString
     */
    public AFABTL101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            RString 処理種別,
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
            Boolean 選挙人名簿抄本有無,
            RString order順,
            RString 改頁項目ID,
            List<RString> 集計項目IDリスト,
            RString riyoKubun,
            RString chushutsuKubun,
            RDateTime zenkaiChushutsu,
            RDateTime konkaiChushutsu,
            RString chuiShuruiCode,
            RString yukoKigenKubun,
            RString 画面ID) {
        this.key = key;
        this.処理種別 = 処理種別;
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
        this.order順 = order順;
        this.改頁項目ID = 改頁項目ID;
        this.集計項目IDリスト = 集計項目IDリスト;
        this.riyoKubun = riyoKubun;
        this.chushutsuKubun = chushutsuKubun;
        this.zenkaiChushutsu = zenkaiChushutsu;
        this.konkaiChushutsu = konkaiChushutsu;
        this.chuiShuruiCode = chuiShuruiCode;
        this.yukoKigenKubun = yukoKigenKubun;
        this.画面ID = 画面ID;
    }

    /**
     * AFABTL101SelectProcessMyBatisParameterを返します。
     *
     * @return AFABTL101SelectProcessMyBatisParameter
     */
    public AFABTL101SelectProcessMyBatisParameter toAFABTL101SelectProcessMyBatisParameter() {
        if (対象者住所条件選択レコードリスト == null) {
            対象者住所条件選択レコードリスト = new ArrayList<>();
        }
        if (詳細指定選択レコードリスト == null) {
            詳細指定選択レコードリスト = new ArrayList<>();
        }
        return new AFABTL101SelectProcessMyBatisParameter(
                key,
                処理種別,
                RString.isNullOrEmpty(抄本番号) ? new ShohonNo(0) : new ShohonNo(抄本番号),
                年齢期限日,
                order順,
                対象者住所条件選択レコードリスト,
                詳細指定選択レコードリスト,
                抄本番号List);
    }

}
