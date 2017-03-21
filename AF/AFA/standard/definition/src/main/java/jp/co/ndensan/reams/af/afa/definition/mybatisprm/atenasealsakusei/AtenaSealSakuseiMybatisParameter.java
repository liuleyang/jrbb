/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.atenasealsakusei;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名シール作成
 *
 * @reamsid_L AF-0620-020 guancy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AtenaSealSakuseiMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private static final RString 住所条件_なし = new RString("0");
    private static final RString 住所条件_投票区 = new RString("1");
    private static final RString 住所条件_行政区 = new RString("2");
    private static final RString 住所条件_住所 = new RString("3");
    private static final RString 住所条件_地区1 = new RString("4");
    private static final RString 住所条件_地区2 = new RString("5");
    private static final RString 住所条件_地区3 = new RString("6");
    private static final RString 住所条件VALUE_なし = new RString("なし");
    private static final RString 住所条件VALUE_投票区 = new RString("投票区");
    private static final RString 住所条件VALUE_行政区 = new RString("行政区");
    private static final RString 住所条件VALUE_住所 = new RString("住所");
    private static final RString 住所条件VALUE_地区1 = new RString("地区1");
    private static final RString 住所条件VALUE_地区2 = new RString("地区2");
    private static final RString 住所条件VALUE_地区3 = new RString("地区3");

    private RString 施設コードFROM;
    private RString 施設コードTO;
    private Code 施設種別;
    private RString 出力順;
    private RString 住所条件;
    private List<RString> 住所一覧リスト;
    private Boolean 世帯主のみ印刷対象とする有無;
    private SenkyoNo 選挙番号;
    private FlexibleDate 対象期間FROM;
    private FlexibleDate 対象期間TO;
    private ShohonNo 抄本番号;
    private RString 転出期限日検索基準;
    private IShikibetsuTaishoPSMSearchKey key;
    private FlexibleDate 名簿基準年月日;
    private UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * コンストラクタ作成します。
     *
     * @param shikibetsutaishoParam IShikibetsuTaishoPSMSearchKey
     * @param 施設コードFROM RString
     * @param 施設コードTO RString
     * @param 施設種別 Code
     * @param 出力順 RString
     * @param 住所条件 RString
     * @param 住所一覧リスト List<RString>
     * @param 世帯主のみ印刷対象とする有無 Boolean
     * @param 選挙番号 SenkyoNo
     * @param 対象期間FROM FlexibleDate
     * @param 対象期間TO FlexibleDate
     * @param 抄本番号 ShohonNo
     */
    public AtenaSealSakuseiMybatisParameter(IShikibetsuTaishoPSMSearchKey shikibetsutaishoParam,
            RString 施設コードFROM,
            RString 施設コードTO,
            Code 施設種別,
            RString 出力順,
            RString 住所条件,
            List<RString> 住所一覧リスト,
            Boolean 世帯主のみ印刷対象とする有無,
            SenkyoNo 選挙番号,
            FlexibleDate 対象期間FROM,
            FlexibleDate 対象期間TO,
            ShohonNo 抄本番号) {
        super(shikibetsutaishoParam);
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(shikibetsutaishoParam);
        this.施設コードFROM = 施設コードFROM;
        this.施設コードTO = 施設コードTO;
        this.施設種別 = 施設種別;
        this.出力順 = 出力順;
        this.住所条件 = get出力条件_住所条件CODE(住所条件);
        this.住所一覧リスト = 住所一覧リスト;
        this.世帯主のみ印刷対象とする有無 = 世帯主のみ印刷対象とする有無;
        this.選挙番号 = 選挙番号;
        this.対象期間FROM = 対象期間FROM;
        this.対象期間TO = 対象期間TO;
        this.抄本番号 = 抄本番号;
    }

    private RString get出力条件_住所条件CODE(RString 住所条件) {
        if (住所条件VALUE_なし.equals(住所条件)) {
            return 住所条件_なし;
        }
        if (住所条件VALUE_住所.equals(住所条件)) {
            return 住所条件_住所;
        }
        if (住所条件VALUE_投票区.equals(住所条件)) {
            return 住所条件_投票区;
        }
        if (住所条件VALUE_行政区.equals(住所条件)) {
            return 住所条件_行政区;
        }
        if (住所条件VALUE_地区1.equals(住所条件)) {
            return 住所条件_地区1;
        }
        if (住所条件VALUE_地区2.equals(住所条件)) {
            return 住所条件_地区2;
        }
        if (住所条件VALUE_地区3.equals(住所条件)) {
            return 住所条件_地区3;
        }
        return RString.EMPTY;
    }
}
