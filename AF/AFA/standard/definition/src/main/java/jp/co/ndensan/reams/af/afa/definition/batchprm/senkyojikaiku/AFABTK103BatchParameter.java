/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojikaiku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 海区漁業調整委員会委員選挙時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0470-020 wanghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTK103BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHORISHURUI = "処理種別";
    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_SENKYONAME = "選挙名";
    private static final String KEY_KIJUNYMD = "基準日";
    private static final String KEY_TOHYOYMD = "投票日";
    private static final String KEY_TOHYOUKETSUKEYMD = "受付開始日";
    private static final String KEY_KAIKUSSHOHON = "選挙人名簿抄本出力有無";
    private static final String KEY_KAIKUSHASULIST = "登録者数リスト出力有無";
    private static final String KEY_TOROKUSHASULISTKIJUNYMD = " 時点日";

    private static final String KEY_TOROKUSHAMEIBO = "登録者名簿出力有無";
    private static final String KEY_CHKTOROKUSHAMEIBO = "新規登録者宛名シール作成有無";
    private static final String KEY_MASSHOSHAMEIBO = "抹消者名簿出力有無";
    private static final String KEY_SHIKKENSHAMEIBO = "失権者名簿出力有無";
    private static final String KEY_HYOJISHAMEIBO = "表示者名簿出力有無";
    private static final String KEY_TEISEISHAMEIBO = "訂正者名簿出力有無";

    @BatchParameter(key = KEY_SHORISHURUI, name = "処理種別")
    private RString 処理種別;
    @BatchParameter(key = KEY_SHOHON, name = "抄本番号")
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名")
    private RString 抄本名;
    @BatchParameter(key = KEY_SENKYONAME, name = "選挙名")
    private RString 選挙名;
    @BatchParameter(key = KEY_KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_TOHYOYMD, name = "投票日")
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_TOHYOUKETSUKEYMD, name = "受付開始日")
    private FlexibleDate 受付開始日;
    @BatchParameter(key = KEY_KAIKUSSHOHON, name = "選挙人名簿抄本出力有無")
    private boolean 選挙人名簿抄本出力有無;
    @BatchParameter(key = KEY_KAIKUSHASULIST, name = "登録者数リスト出力有無")
    private boolean 登録者数リスト出力有無;
    @BatchParameter(key = KEY_TOROKUSHASULISTKIJUNYMD, name = "時点日")
    private FlexibleDate 時点日;

    @BatchParameter(key = KEY_TOROKUSHAMEIBO, name = "登録者名簿出力有無")
    private boolean 登録者名簿出力有無;

    @BatchParameter(key = KEY_CHKTOROKUSHAMEIBO, name = "新規登録者宛名シール作成有無")
    private boolean 新規登録者宛名シール作成有無;

    @BatchParameter(key = KEY_MASSHOSHAMEIBO, name = "抹消者名簿出力有無")
    private boolean 抹消者名簿出力有無;

    @BatchParameter(key = KEY_SHIKKENSHAMEIBO, name = "失権者名簿出力有無")
    private boolean 失権者名簿出力有無;

    @BatchParameter(key = KEY_HYOJISHAMEIBO, name = "表示者名簿出力有無")
    private boolean 表示者名簿出力有無;

    @BatchParameter(key = KEY_TEISEISHAMEIBO, name = "訂正者名簿出力有無")
    private boolean 訂正者名簿出力有無;

    /**
     * AFABTK101SelectProcessParameterの変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     *
     * @return AFABTI101SelectProcessParameter
     */
    public AFABTK103SelectProcessParameter toAFABTK103SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll) {

        ShohonNo 抄本番号Class = null;
        if (抄本番号 != null) {
            抄本番号Class = new ShohonNo(抄本番号);
        }

        return new AFABTK103SelectProcessParameter(処理種別, 抄本番号Class, 抄本名, 選挙名, 基準日,
                投票日, 受付開始日, 選挙人名簿抄本出力有無, 登録者数リスト出力有無, 時点日,
                登録者名簿出力有無, 新規登録者宛名シール作成有無, 抹消者名簿出力有無, 失権者名簿出力有無,
                表示者名簿出力有無, 訂正者名簿出力有無, null, null, null,
                null, key, keyForAll, null, null, null, null, null, null, false, false, null, 0, null);
    }

}
