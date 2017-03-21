/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.meibochoseifilesakusei;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibochoseifilesakuse.AFABTF101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTF101BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_HOZONSAKI = "保存先";
    private static final String KEY_FILENAME = "ファイル名";
    private static final String KEY_NENREI = "抽出対象年齢";
    private static final String KEY_NENREIKIJUNYMD = "年齢計算基準日";
    private static final String KEY_RESULT = "実行結果";

    @BatchParameter(key = KEY_SHOHON, name = "抄本番号")
    private RString 抄本番号;
    @BatchParameter(key = KEY_HOZONSAKI, name = "保存先")
    private RString 保存先;
    @BatchParameter(key = KEY_FILENAME, name = "ファイル名")
    private RString ファイル名;
    @BatchParameter(key = KEY_NENREI, name = "抽出対象年齢")
    private int 抽出対象年齢;
    @BatchParameter(key = KEY_NENREIKIJUNYMD, name = "年齢計算基準日")
    private FlexibleDate 年齢計算基準日;
    @BatchParameter(key = KEY_RESULT, name = "実行結果")
    private RString 実行結果;

    /**
     * AFABTF101SelectProcessParameterの変換のメソッドです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     *
     * @return AFABTI101SelectProcessParameter
     */
    public AFABTF101SelectProcessParameter toAFABTF101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey) {

        ShohonNo 抄本番号Class = null;
        if (抄本番号 != null) {
            抄本番号Class = new ShohonNo(抄本番号);
        }
        return new AFABTF101SelectProcessParameter(searchKey, 抄本番号Class, 保存先, ファイル名,
                抽出対象年齢, 年齢計算基準日, 実行結果);
    }

}
