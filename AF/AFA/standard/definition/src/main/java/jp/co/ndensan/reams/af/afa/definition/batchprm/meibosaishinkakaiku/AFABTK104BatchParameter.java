/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.meibosaishinkakaiku;

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
 * 海区漁業調整委員会委員選挙人名簿最新化BatchParameter <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTK104BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHONNO = "抄本番号";
    private static final String KEY_SHOHONMEI = "抄本名";
    private static final String KEY_KIJUNYMD = "基準日";
    private static final String KEY_MEIBOKAKUTEIYMD = "名簿確定日";
    private static final String KEY_NENREITOTATSUYMD = "年齢到達日";
    private static final String KEY_TOHYOYMD = "投票日";
    private static final String KEY_NENDO = "年度";
    private static final String KEY_SHORIYMD = "処理日";
    private static final String KEY_SAISHINKAYMD = "最新化時点日";
    private static final String KEY_SAISHINKAFLG = "最新化有無";
    private static final String KEY_MEIBONARABIKAEFLG = "名簿並び替え有無";
    private static final String KEY_CHOHYOMEIBOSHOHONFLG = "選挙人名簿抄本出力有無";
    private static final String KEY_TOROKUSHASULISTFLG = "登録者数リスト出力有無";
    private static final String KEY_TOROKUSHASULISTKIJUNYMD = "時点";
    private static final String KEY_TOROKUSHAMEIBOFLG = "登録者名簿出力有無";
    private static final String KEY_TOROKUSHAMEIBOATENASEALFLG = "新規登録者宛名シール作成有無";
    private static final String KEY_MASSHOSHAMEIBOFLG = "抹消者名簿出力有無";
    private static final String KEY_SHIKKENSHAMEIBOFLG = "失権者名簿出力有無";
    private static final String KEY_HYOJISHAMEIBOFLG = "表示者名簿出力有無";
    private static final String KEY_TEISEISHAMEIBOFLG = "訂正者名簿出力有無";

    @BatchParameter(key = KEY_SHOHONNO, name = "抄本番号")
    private RString 抄本番号;
    @BatchParameter(key = KEY_SHOHONMEI, name = "抄本名")
    private RString 抄本名;
    @BatchParameter(key = KEY_KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_MEIBOKAKUTEIYMD, name = "名簿確定日")
    private FlexibleDate 名簿確定日;
    @BatchParameter(key = KEY_NENREITOTATSUYMD, name = "年齢到達日")
    private FlexibleDate 年齢到達日;
    @BatchParameter(key = KEY_TOHYOYMD, name = "投票日")
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_NENDO, name = "年度")
    private RString 年度;
    @BatchParameter(key = KEY_SHORIYMD, name = "処理日")
    private FlexibleDate 処理日;
    @BatchParameter(key = KEY_SAISHINKAYMD, name = "最新化時点日")
    private FlexibleDate 最新化時点日;
    @BatchParameter(key = KEY_SAISHINKAFLG, name = "最新化有無")
    private boolean 最新化有無;
    @BatchParameter(key = KEY_MEIBONARABIKAEFLG, name = "名簿並び替え有無")
    private boolean 名簿並び替え有無;
    @BatchParameter(key = KEY_CHOHYOMEIBOSHOHONFLG, name = "選挙人名簿抄本出力有無")
    private boolean 選挙人名簿抄本出力有無;
    @BatchParameter(key = KEY_TOROKUSHASULISTFLG, name = "登録者数リスト出力有無")
    private boolean 登録者数リスト出力有無;
    @BatchParameter(key = KEY_TOROKUSHASULISTKIJUNYMD, name = "時点")
    private FlexibleDate 時点;
    @BatchParameter(key = KEY_TOROKUSHAMEIBOFLG, name = "登録者名簿出力有無")
    private boolean 登録者名簿出力有無;
    @BatchParameter(key = KEY_TOROKUSHAMEIBOATENASEALFLG, name = "新規登録者宛名シール作成有無")
    private boolean 新規登録者宛名シール作成有無;
    @BatchParameter(key = KEY_MASSHOSHAMEIBOFLG, name = "抹消者名簿出力有無")
    private boolean 抹消者名簿出力有無;
    @BatchParameter(key = KEY_SHIKKENSHAMEIBOFLG, name = "失権者名簿出力有無")
    private boolean 失権者名簿出力有無;
    @BatchParameter(key = KEY_HYOJISHAMEIBOFLG, name = "表示者名簿出力有無")
    private boolean 表示者名簿出力有無;
    @BatchParameter(key = KEY_TEISEISHAMEIBOFLG, name = "訂正者名簿出力有無")
    private boolean 訂正者名簿出力有無;

    /**
     * AFABTK101SelectProcessParameterの変換のメソッドです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     *
     * @return AFABTI101SelectProcessParameter
     */
    public AFABTK103SelectProcessParameter toAFABTK104SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll) {

        ShohonNo 抄本番号Class = null;
        if (抄本番号 != null) {
            抄本番号Class = new ShohonNo(抄本番号);
        }

        return new AFABTK103SelectProcessParameter(null, 抄本番号Class, 抄本名, null, 基準日,
                投票日, null, 選挙人名簿抄本出力有無, 登録者数リスト出力有無, 時点,
                登録者名簿出力有無, 新規登録者宛名シール作成有無, 抹消者名簿出力有無, 失権者名簿出力有無,
                表示者名簿出力有無, 訂正者名簿出力有無, null, null, null,
                null, key, keyForAll, null, null, null, 名簿確定日, 年齢到達日, 最新化時点日, 最新化有無, 名簿並び替え有無, null, 0, null);
    }

}
