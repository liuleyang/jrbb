/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.doitsujinbutsuChosa;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 同一人物調査
 *
 * @reamsid_L AF-0690-020 wanghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTM107BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SHIMEI = "氏名";
    private static final String KEY_SHI = "氏";
    private static final String KEY_MEI = "名";
    private static final String KEY_KANA = "カナ";
    private static final String KEY_KANZI = "漢字";
    private static final String KEY_SEINENTSUKIHI = "生年月日";
    private static final String KEY_SEIBETSU = "性別";
    private static final String KEY_JUSHOCODE = "住所コード";
    private static final String KEY_JUSHO = "住所";
    private static final String KEY_BANCHICODE = "番地コード";
    private static final String KEY_TOUHYOUSEINENTSUKIHI = "投票年月日";
    private static final String KEY_SHOHONMEI = "抄本名";

    @BatchParameter(key = KEY_SHOHON, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHIMEI, name = "氏名", order = 2)
    private Boolean 氏名;
    @BatchParameter(key = KEY_SHI, name = "氏", order = 3)
    private Boolean 氏;
    @BatchParameter(key = KEY_MEI, name = "名", order = 4)
    private Boolean 名;
    @BatchParameter(key = KEY_KANA, name = "カナ", order = 5)
    private Boolean カナ;
    @BatchParameter(key = KEY_KANZI, name = "漢字", order = 6)
    private Boolean 漢字;
    @BatchParameter(key = KEY_SEINENTSUKIHI, name = "生年月日", order = 7)
    private Boolean 生年月日;
    @BatchParameter(key = KEY_SEIBETSU, name = "性別", order = 8)
    private Boolean 性別;
    @BatchParameter(key = KEY_JUSHOCODE, name = "住所コード", order = 9)
    private Boolean 住所コード;
    @BatchParameter(key = KEY_JUSHO, name = "住所", order = 10)
    private Boolean 住所;
    @BatchParameter(key = KEY_BANCHICODE, name = "番地コード", order = 11)
    private Boolean 番地コード;
    @BatchParameter(key = KEY_TOUHYOUSEINENTSUKIHI, name = "投票年月日", order = 12)
    private FlexibleDate 投票年月日;
    @BatchParameter(key = KEY_SHOHONMEI, name = "抄本名", order = 13)
    private RString 抄本名;

}
