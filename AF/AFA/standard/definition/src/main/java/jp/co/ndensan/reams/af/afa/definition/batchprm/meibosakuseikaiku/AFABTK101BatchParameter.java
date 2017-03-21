/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku.AFABTK101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 海区漁業調整委員会委員選挙人名簿作成バッチパラメータクラスです。
 *
 * @reamsid_L AF-0460-020 wanghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTK101BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_MAKEMETHOD = "作成方法";
    private static final String KEY_SHORISHURUI = "処理種別";
    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_KIJUNYMD = "基準日";
    private static final String KEY_KAKUTEIYMD = "名簿確定日";
    private static final String KEY_NENREITOTATSUYMD = "年齢到達日";
    private static final String KEY_KAIKUSSHOHON = "選挙人名簿抄本出力有無";
    private static final String KEY_KAIKUSHASULIST = "登録者数リスト出力有無";
    private static final String KEY_TOROKUSHASULISTKIJUNYMD = " 時点日";

    @BatchParameter(key = KEY_MAKEMETHOD, name = "作成方法")
    private RString 作成方法;
    @BatchParameter(key = KEY_SHORISHURUI, name = "処理種別")
    private RString 処理種別;
    @BatchParameter(key = KEY_SHOHON, name = "抄本番号")
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名")
    private RString 抄本名;
    @BatchParameter(key = KEY_KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_KAKUTEIYMD, name = "名簿確定日")
    private FlexibleDate 名簿確定日;
    @BatchParameter(key = KEY_NENREITOTATSUYMD, name = "年齢到達日")
    private FlexibleDate 年齢到達日;
    @BatchParameter(key = KEY_KAIKUSSHOHON, name = "選挙人名簿抄本出力有無")
    private boolean 選挙人名簿抄本出力有無;
    @BatchParameter(key = KEY_KAIKUSHASULIST, name = "登録者数リスト出力有無")
    private boolean 登録者数リスト出力有無;
    @BatchParameter(key = KEY_TOROKUSHASULISTKIJUNYMD, name = "時点日")
    private FlexibleDate 時点日;

    /**
     * AFABTK101SelectProcessParameterの変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     *
     * @return AFABTI101SelectProcessParameter
     */
    public AFABTK101SelectProcessParameter toAFABTK101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key) {

        ShohonNo 抄本番号Class = null;
        if (抄本番号 != null) {
            抄本番号Class = new ShohonNo(抄本番号);
        }

        return new AFABTK101SelectProcessParameter(作成方法, 処理種別, 抄本番号Class, 抄本名,
                基準日, 名簿確定日, 年齢到達日, 選挙人名簿抄本出力有無,
                登録者数リスト出力有無, 時点日, null, null, null,
                null, null, null, key, null, null, null);
    }
}
