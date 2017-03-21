/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.atenasealsakusei.AFABTE601SelectProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名シール作成バッチパラメータクラスです。
 *
 * @reamsid_L AF-0620-020 guancy
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTE6010BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_MEINYOID = "起動画面ID";
    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_JUSHOJOKEN = "住所条件";
    private static final String KEY_JUSHOLIST = "住所一覧リスト";
    private static final String KEY_OBJSENKYO = "対象選挙";
    private static final String KEY_SENKYOLEVEL = "選挙レベル";
    private static final String KEY_OBJSENKYONAME = "対象選挙名称";
    private static final String KEY_FIRSTYMD = "対象期間FROM";
    private static final String KEY_LASTYMD = "対象期間TO";
    private static final String KEY_SHISETSUSHUBETSU = "施設種別";
    private static final String KEY_SHISETSUSHUBETSUNAME = "施設種別名称";
    private static final String KEY_SHISETSUCODEFROM = "施設コードFROM";
    private static final String KEY_SHISETSUNAMEFROM = "施設名称FROM";
    private static final String KEY_SHISETSUCODETO = "施設コードTO";
    private static final String KEY_SHISETSUNAMETO = "施設名称TO";
    private static final String KEY_YOSUMIKOMOKUMIGIUECODE = "四隅項目コード_右上隅";
    private static final String KEY_YOSUMIKOMOKUMIGIUE = "四隅項目_右上隅";
    private static final String KEY_JUSHO = "住所コード";
    private static final String KEY_JUSHOCODE = "住所名称";
    private static final String KEY_JUSHOHYOJI = "住所表示";
    private static final String KEY_ATENACODE = "宛名コード";
    private static final String KEY_ATENA = "宛名コード名称";
    private static final String KEY_MEISYO_UP = "名称_上段";
    private static final String KEY_MEISYO_DOWN = "名称_下段";
    private static final String KEY_SETAIMUSICODE = "世帯主敬称コード";
    private static final String KEY_SETAIMUSI = "世帯主敬称";
    private static final String KEY_HONNINCODE = "本人敬称コード";
    private static final String KEY_HONNIN = "本人敬称";
    private static final String KEY_YOSUMIKOMOKUMIGISITACODE = "四隅項目コード_左下隅";
    private static final String KEY_YOSUMIKOMOKUMIGISITA = "四隅項目_左下隅";
    private static final String KEY_YOSUMIKOMOKUHITARISITACODE = "四隅項目コード_右下隅";
    private static final String KEY_YOSUMIKOMOKUHITARISITA = "四隅項目_右下隅";
    private static final String KEY_JUSHOMAE = "住所の前に市町村名を付加";
    private static final String KEY_SETAIMUSINOMI = "世帯主のみ印刷対象とする有無";
    private static final String KEY_KAISIINNJIIQI = "開始印字位置番号";

    @BatchParameter(key = KEY_MEINYOID, name = "起動画面ID")
    private RString 起動画面ID;
    @BatchParameter(key = KEY_SHOHON, name = "抄本番号")
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名")
    private RString 抄本名;
    @BatchParameter(key = KEY_JUSHOJOKEN, name = "住所条件")
    private RString 住所条件;
    @BatchParameter(key = KEY_JUSHOLIST, name = "住所一覧リスト")
    private List<JushoIchiranMeisai> 住所一覧リスト;
    @BatchParameter(key = KEY_OBJSENKYO, name = "対象選挙")
    private RString 対象選挙;
    @BatchParameter(key = KEY_SENKYOLEVEL, name = "選挙レベル")
    private RString 選挙レベル;
    @BatchParameter(key = KEY_OBJSENKYONAME, name = "対象選挙名称")
    private RString 対象選挙名称;
    @BatchParameter(key = KEY_FIRSTYMD, name = "対象期間FROM")
    private RDate 対象期間FROM;
    @BatchParameter(key = KEY_LASTYMD, name = "対象期間TO")
    private RDate 対象期間TO;
    @BatchParameter(key = KEY_SHISETSUSHUBETSU, name = "施設種別")
    private RString 施設種別;
    @BatchParameter(key = KEY_SHISETSUSHUBETSUNAME, name = "施設種別名称")
    private RString 施設種別名称;
    @BatchParameter(key = KEY_SHISETSUCODEFROM, name = "施設コードFROM")
    private RString 施設コードFROM;
    @BatchParameter(key = KEY_SHISETSUNAMEFROM, name = "施設名称FROM")
    private RString 施設名称FROM;
    @BatchParameter(key = KEY_SHISETSUCODETO, name = "施設コードTO")
    private RString 施設コードTO;
    @BatchParameter(key = KEY_SHISETSUNAMETO, name = "施設名称TO")
    private RString 施設名称TO;
    @BatchParameter(key = KEY_YOSUMIKOMOKUMIGIUECODE, name = "四隅項目コード_右上隅")
    private RString 四隅項目コード_右上隅;
    @BatchParameter(key = KEY_YOSUMIKOMOKUMIGIUE, name = "四隅項目_右上隅")
    private RString 四隅項目_右上隅;
    @BatchParameter(key = KEY_JUSHO, name = "住所コード")
    private RString 住所コード;
    @BatchParameter(key = KEY_JUSHOCODE, name = "住所名称")
    private RString 住所コード名称;
    @BatchParameter(key = KEY_JUSHOHYOJI, name = "住所表示")
    private RString 住所表示;
    @BatchParameter(key = KEY_ATENACODE, name = "宛名コード")
    private RString 宛名コード;
    @BatchParameter(key = KEY_ATENA, name = "宛名コード名称")
    private RString 宛名コード名称;
    @BatchParameter(key = KEY_MEISYO_UP, name = "名称_上段")
    private RString 名称_上段;
    @BatchParameter(key = KEY_MEISYO_DOWN, name = "名称_下段")
    private RString 名称_下段;
    @BatchParameter(key = KEY_SETAIMUSICODE, name = "世帯主敬称コード")
    private RString 世帯主敬称コード;
    @BatchParameter(key = KEY_SETAIMUSI, name = "世帯主敬称")
    private RString 世帯主敬称;
    @BatchParameter(key = KEY_HONNINCODE, name = "本人敬称コード")
    private RString 本人敬称コード;
    @BatchParameter(key = KEY_HONNIN, name = "本人敬称")
    private RString 本人敬称;
    @BatchParameter(key = KEY_YOSUMIKOMOKUMIGISITACODE, name = "四隅項目コード_左下隅")
    private RString 四隅項目コード_左下隅;
    @BatchParameter(key = KEY_YOSUMIKOMOKUMIGISITA, name = "四隅項目_左下隅")
    private RString 四隅項目_左下隅;
    @BatchParameter(key = KEY_YOSUMIKOMOKUHITARISITACODE, name = "四隅項目コード_右下隅")
    private RString 四隅項目コード_右下隅;
    @BatchParameter(key = KEY_YOSUMIKOMOKUHITARISITA, name = "四隅項目_右下隅")
    private RString 四隅項目_右下隅;
    @BatchParameter(key = KEY_JUSHOMAE, name = "住所の前に市町村名を付加")
    private RString 住所の前に市町村名を付加;
    @BatchParameter(key = KEY_SETAIMUSINOMI, name = "世帯主のみ印刷対象とする有無")
    private Boolean 世帯主のみ印刷対象とする有無;
    @BatchParameter(key = KEY_KAISIINNJIIQI, name = "開始印字位置番号")
    private RString 開始印字位置番号;

    /**
     * コンストラクタ作成します。
     *
     *
     * @return AtenaSealSakuseiMybatisParameter
     */
    public AFABTE601SelectProcessParameter toAFABTE601SelectProcessParameter() {
        return new AFABTE601SelectProcessParameter(
                起動画面ID,
                抄本番号,
                抄本名,
                住所条件,
                住所一覧リスト,
                RString.isNullOrEmpty(対象選挙) ? new SenkyoNo(0) : new SenkyoNo(対象選挙),
                選挙レベル,
                対象選挙名称,
                対象期間FROM,
                対象期間TO,
                施設種別,
                施設種別名称,
                施設コードFROM,
                施設名称FROM,
                施設コードTO,
                施設名称TO,
                四隅項目コード_右上隅,
                四隅項目_右上隅,
                住所コード,
                住所コード名称,
                住所表示,
                宛名コード,
                宛名コード名称,
                名称_上段,
                名称_下段,
                世帯主敬称コード,
                世帯主敬称,
                本人敬称コード,
                本人敬称,
                四隅項目コード_左下隅,
                四隅項目_左下隅,
                四隅項目コード_右下隅,
                四隅項目_右下隅,
                住所の前に市町村名を付加,
                世帯主のみ印刷対象とする有無,
                開始印字位置番号);
    }
}
