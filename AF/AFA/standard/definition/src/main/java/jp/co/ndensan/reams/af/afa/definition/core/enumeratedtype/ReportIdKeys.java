/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ReportIdを表す列挙型です。
 *
 * @reamsid_L AF-0270-020 xul
 */
public enum ReportIdKeys {

    /**
     * 選挙人名簿抄本<br />
     * code：AFAPRA100_MeiboShohon
     */
    選挙人名簿抄本("AFAPRA100_MeiboShohon", "選挙人名簿抄本", "AFAPRA100_MeiboShohon.csv"),
    /**
     * 選挙人名簿抄本_縦覧用<br />
     * code：AFAPRA100_MeiboShohonJuran
     */
    選挙人名簿抄本_縦覧用("AFAPRA100_MeiboShohonJuran", "選挙人名簿抄本（縦覧用）", "AFAPRA100_MeiboShohonJuran.csv"),
    /**
     * 在外選挙人名簿抄本<br />
     * code：AFAPRB300_MeiboShohonZaigai
     */
    在外選挙人名簿抄本("AFAPRB300_MeiboShohonZaigai", "在外選挙人名簿抄本", "AFAPRB300_MeiboShohonZaigai.csv"),
    /**
     * 在外選挙人名簿抄本_縦覧用<br />
     * code：AFAPRB300_MeiboShohonZaigaiJuran
     */
    在外選挙人名簿抄本_縦覧用("AFAPRB300_MeiboShohonZaigaiJuran", "在外選挙人名簿抄本（縦覧用）", "AFAPRB300_MeiboShohonZaigaiJuran.csv"),
    /**
     * 永久選挙人名簿<br />
     * code：AFAPRA101_EikyuMeibo
     */
    永久選挙人名簿("AFAPRA101_EikyuMeibo", "永久選挙人名簿", "AFAPRA101_EikyuMeibo.csv"),
    /**
     * 選挙人索引簿<br />
     * code：AFAPRA102_Sakuinbo
     */
    選挙人名簿索引簿("AFAPRA102_Sakuinbo", "選挙人名簿索引簿", "AFAPRA102_Sakuinbo.csv"),
    /**
     * 選挙人名簿索引簿（投票区別50音順）<br />
     * code：AFAPRA102_Sakuinbo
     */
    選挙人名簿索引簿_投票区別50音順("AFAPRA102_SakuinboTohyoku", "選挙人名簿索引簿（投票区別50音順）", "AFAPRA102_SakuinboTohyoku.csv"),
    /**
     * 登録者数リスト<br />
     * code：AFAPRA103_TorokushasuList
     */
    登録者数リスト("AFAPRA103_TorokushasuList", "登録者数リスト", "AFAPRA103_TorokushasuLis.csv"),
    /**
     * 不在者投票資格者分<br />
     * code：AFAPRA103_TorokushasuListFuzaiShikaku
     */
    不在者投票資格者分("AFAPRA103_TorokushasuListFuzaiShikaku", "登録者数リスト（不在者投票資格者分）", "AFAPRA103_TorokushasuListFuzaiShikaku.csv"),
    /**
     * 不在資格対象者名簿<br />
     * code：AFAPRC204_FuzaiShikakushaMeibo
     */
    不在資格対象者名簿("AFAPRC204_FuzaiShikakushaMeibo", "不在資格対象者名簿", "AFAPRC204_FuzaiShikakushaMeibo.csv"),
    /**
     * 有権者数調べ<br />
     * code：AFAPRA104_YukenshasuShirabe
     */
    有権者数調べ("AFAPRA104_YukenshasuShirabe", "有権者数調べ", "AFAPRA104_YukenshasuList.csv"),
    /**
     * 新規登録者名簿<br />
     * code：AFAPRA105_ShinkiTorokushaMeibo
     */
    新規登録者名簿("AFAPRA105_ShinkiTorokushaMeibo", "新規登録者名簿", "AFAPRA105_ShinkiTorokushaMeibo.csv"),
    /**
     * 新規登録者名簿国民<br />
     * code：AFAPRA105_ShinkiTorokushaMeiboKokumin
     */
    新規登録者名簿国民("AFAPRA105_ShinkiTorokushaMeiboKokumin", "新規登録者名簿国民", "AFAPRA105_ShinkiTorokushaMeiboKokumin.csv"),
    /**
     * 新規登録者名簿海区<br />
     * code：AFAPRA105_ShinkiTorokushaMeibokaiku
     */
    新規登録者名簿海区("AFAPRK105_ShinkiTorokushaMeiboKaiku", "新規登録者名簿海区", "AFAPRK105_ShinkiTorokushaMeiboKaiku.csv"),
    /**
     * 新規登録者名簿海区<br />
     * code：AFAPRA105_ShinkiTorokushaMeibokaiku
     */
    新規登録者名簿海区縦覧("AFAPRK105_ShinkiTorokushaMeiboKaiku", "新規登録者名簿海区(縦覧)", "AFAPRK105_ShinkiTorokushaMeiboKaikuJuran.csv"),
    /**
     * 新規登録者宛名シール<br />
     * code：AFAPRA213_ShinkiTorokushaAtenaSeal
     */
    新規登録者宛名シール("AFAPRA213_ShinkiTorokushaAtenaSeal", "新規登録者宛名シール", "AFAPRA213_ShinkiTorokushaAtenaSeal.csv"),
    /**
     * 新規登録者宛名シール<br />
     * code：AFAPRA214_ShinkiTorokushaAtenaSeal
     */
    新規登録者宛名シール_21("AFAPRA214_ShinkiTorokushaAtenaSeal", "新規登録者宛名シール_21", "AFAPRA214_ShinkiTorokushaAtenaSeal.csv"),
    /**
     * 抹消者名簿<br />
     * code：AFAPRA105_MasshoshaMeibo
     */
    抹消者名簿("AFAPRA105_MasshoshaMeibo", "抹消者名簿", "AFAPRA105_MasshoshaMeibo.csv"),
    /**
     * 抹消者名簿海区<br />
     * code：AFAPRA105_MasshoshaMeibokaiku
     */
    抹消者名簿海区("AFAPRK105_MasshoshaMeiboKaiku", "抹消者名簿海区", "AFAPRK105_MasshoshaMeiboKaiku.csv"),
    /**
     * 抹消者名簿国民<br />
     * code：AFAPRA105_MasshoshaMeibokaiku
     */
    抹消者名簿国民("AFAPRA105_MasshoshaMeiboKokumin", "抹消者名簿国民", "AFAPRA105_MasshoshaMeiboKokumin.csv"),
    /**
     * 未登録者抹消通知一覧表<br />
     * code：AFAPRG112_MitorokushaMasshoTsuchiList
     */
    未登録者抹消通知一覧表("AFAPRG112_MitorokushaMasshoTsuchiList", "未登録者抹消通知一覧表", "AFAPRG112_MitorokushaMasshoTsuchiList.csv"),
    /**
     * 未登録者抹消通知<br />
     * code：AFAPRG112_MitorokushaMasshoTsuchi
     */
    未登録者抹消通知("AFAPRG117_MitorokushaMasshoTsuchi", "未登録者抹消通知", "AFAPRG117_MitorokushaMasshoTsuchi.csv"),
    /**
     * 居住要件抹消者名簿<br />
     * code：AFAPRA105_KyojuMasshoshaMeibo
     */
    居住要件抹消者名簿("AFAPRA105_KyojuMasshoshaMeibo", "居住要件抹消者名簿", "AFAPRA105_KyojuMasshoshaMeibo.csv"),
    /**
     * 国内転入者調査一覧表<br />
     * code：AFAPRG112_KokunaiTennyushaChosahyoList
     */
    国内転入者調査一覧表("AFAPRG112_KokunaiTennyushaChosahyoList", "国内転入者調査一覧表", "AFAPRG112_KokunaiTennyushaChosahyoList.csv"),
    /**
     * 国外転入者調査一覧表<br />
     * code：AFAPRG112_KokunaiTennyushaChosahyoList
     */
    国外転入者調査一覧表("AFAPRG112_KokugaiTennyushaChosahyoList", "国外転入者調査一覧表", "AFAPRG112_KokugaiTennyushaChosahyoList.csv"),
    /**
     * 国外転入者調査票（照会）<br />
     * code：AFAPRG301_KokugaiTennyushaChosahyoShokai
     */
    国外転入者調査票照会("AFAPRG301_KokugaiTennyushaChosahyoShokai", "国外転入者調査票（照会）", "AFAPRG301_KokugaiTennyushaChosahyoShokai.csv"),
    /**
     * 国内転入者調査票（照会）<br />
     * code：AFAPRG301_KokunaiTennyushaChosahyoShokai
     */
    国内転入者調査票照会("AFAPRG301_KokunaiTennyushaChosahyoShokai", "国内転入者調査票（照会）", "AFAPRG301_KokunaiTennyushaChosahyoShokai.csv"),
    /**
     * 国内転入者調査票（回答）<br />
     * code：AFAPRG302_KokunaiTennyushaChosahyoKaito
     */
    国内転入者調査票回答("AFAPRG302_KokunaiTennyushaChosahyoKaito", "国内転入者調査票（回答）", "AFAPRG302_KokunaiTennyushaChosahyoKaito.csv"),
    /**
     * 国外転入者調査票（回答）<br />
     * code：AFAPRG303_KokugaiTennyushaChosahyoKaito
     */
    国外転入者調査票回答("AFAPRG303_KokugaiTennyushaChosahyoKaito", "国外転入者調査票（回答）", "AFAPRG303_KokugaiTennyushaChosahyoKaito.csv"),
    /**
     * 抹消予定者名簿<br />
     * code：AFAPRA105_MasshoYoteishaMeibo
     */
    抹消予定者名簿("AFAPRA105_MasshoYoteishaMeibo", "抹消予定者名簿", "AFAPRA105_MasshoYoteishaMeibo.csv"),
    /**
     * 失権者名簿<br />
     * code：AFAPRA105_ShikkenshaMeibo
     */
    失権者名簿("AFAPRA105_ShikkenshaMeibo", "失権者名簿", "AFAPRA105_ShikkenshaMeibo.csv"),
    /**
     * 失権者名簿海区<br />
     * code：AFAPRA105_ShikkenshaMeibokaiku
     */
    失権者名簿海区("AFAPRK105_ShikkenshaMeiboKaiku", "失権者名簿海区", "AFAPRK105_ShikkenshaMeiboKaiku.csv"),
    /**
     * 表示者名簿<br />
     * code：AFAPRA105_HyojishaMeibo
     */
    表示者名簿("AFAPRA105_HyojishaMeibo", "表示者名簿", "AFAPRA105_HyojishaMeibo.csv"),
    /**
     * 表示者名簿海区<br />
     * code：AFAPRA105_HyojishaMeibokaiku
     */
    表示者名簿海区("AFAPRK105_HyojishaMeiboKaiku", "表示者名簿海区", "AFAPRK105_HyojishaMeiboKaiku.csv"),
    /**
     * 表示消除者名簿<br />
     * code：AFAPRA105_HyojiShojoshaMeibo
     */
    表示消除者名簿("AFAPRA105_HyojiShojoshaMeibo", "表示消除者名簿", "AFAPRA105_HyojiShojoshaMeibo.csv"),
    /**
     * 表示消除予定者名簿<br />
     * code：AFAPRA105_HyojiShojoYoteishaMeibo
     */
    表示消除予定者名簿("AFAPRA105_HyojiShojoYoteishaMeibo", "表示消除予定者名簿", "AFAPRA105_HyojiShojoYoteishaMeibo.csv"),
    /**
     * 規定年齢前名簿<br />
     * code：AFAPRA105_KiteiNenreiMaeMeibo
     */
    規定年齢前名簿("AFAPRA105_KiteiNenreiMaeMeibo", "規定年齢前名簿", "AFAPRA105_KiteiNenreiMaeMeibo.csv"),
    /**
     * 規定年齢前シール<br />
     * code：AFAPRA213_KiteiNenreiMaeAtenaSeal
     */
    規定年齢前シール("AFAPRA213_KiteiNenreiMaeAtenaSeal", "規定年齢前シール", "AFAPRA213_KiteiNenreiMaeAtenaSeal.csv"),
    /**
     * 規定年齢前シール<br />
     * code：AFAPRA214_KiteiNenreiMaeAtenaSeal
     */
    規定年齢前シール_21("AFAPRA214_KiteiNenreiMaeAtenaSeal", "規定年齢前シール_21", "AFAPRA214_KiteiNenreiMaeAtenaSeal.csv"),
    /**
     * 再転入者名簿<br />
     * code：AFAPRA105_SaiTennyushaMeibo
     */
    再転入者名簿("AFAPRA105_SaiTennyushaMeibo", "再転入者名簿", "AFAPRA105_SaiTennyushaMeibo.csv"),
    /**
     * 転出者名簿<br />
     * code：AFAPRA105_TenshutsushaMeibo
     */
    転出者名簿("AFAPRA105_TenshutsushaMeibo", "転出者名簿", "AFAPRA105_TenshutsushaMeibo.csv"),
    /**
     * 職権消除者名簿<br />
     * code：AFAPRA105_ShokenShojoshaMeibo
     */
    職権消除者名簿("AFAPRA105_ShokenShojoshaMeibo", "職権消除者名簿", "AFAPRA105_ShokenShojoshaMeibo.csv"),
    /**
     * 規定年齢未到達者名簿<br />
     * code：AFAPRA105_MitotatsushaMeibo
     */
    規定年齢未到達者名簿("AFAPRA105_MitotatsushaMeibo", "規定年齢未到達者名簿", "AFAPRA105_MitotatsushaMeibo.csv"),
    /**
     * 新規登録者名簿縦覧<br />
     * code：AFAPRA106_ShinkiTorokushaMeiboJuran
     */
    新規登録者名簿縦覧("AFAPRA106_ShinkiTorokushaMeiboJuran", "新規登録者名簿縦覧", "AFAPRA106_ShinkiTorokushaMeiboJuran.csv"),
    /**
     * 新規登録者名簿縦覧国民<br />
     * code：AFAPRA106_ShinkiTorokushaMeiboJuranKokumin
     */
    新規登録者名簿縦覧国民("AFAPRA106_ShinkiTorokushaMeiboJuranKokumin", "新規登録者名簿縦覧国民", "AFAPRA106_ShinkiTorokushaMeiboJuranKokumin.csv"),
    /**
     * 抹消者名簿縦覧<br />
     * code：AFAPRA106_MasshoshaMeiboJuran
     */
    抹消者名簿縦覧("AFAPRA106_MasshoshaMeiboJuran", "抹消者名簿縦覧", "AFAPRA106_MasshoshaMeiboJuran.csv"),
    /**
     * 抹消者名簿縦覧国民<br />
     * code：AFAPRA106_MasshoshaMeiboJuran
     */
    抹消者名簿縦覧国民("AFAPRA106_MasshoshaMeiboJuranKokumin", "抹消者名簿縦覧国民", "AFAPRA106_MasshoshaMeiboJuranKokumin.csv"),
    /**
     * 帰化対象者リスト<br />
     * code：AFAPRA107_KikaTaishoshaList
     */
    帰化対象者リスト("AFAPRA107_KikaTaishoshaList", "帰化対象者リスト", "AFAPRA107_KikaTaishoshaList.csv"),
    /**
     * 訂正者名簿<br />
     * code：AFAPRA108_TeiseishaMeibo
     */
    訂正者名簿("AFAPRA108_TeiseishaMeibo", "訂正者名簿", "AFAPRA108_TeiseishaMeibo.csv"),
    /**
     * 訂正者名簿海区<br />
     * code：AFAPRA108_TeiseishaMeibokaiku
     */
    訂正者名簿海区("AFAPRK108_TeiseishaMeiboKaiku", "訂正者名簿海区", "AFAPRK108_TeiseishaMeiboKaiku.csv"),
    /**
     * 訂正者名簿国民<br />
     * code：AFAPRA108_TeiseishaMeiboKokumin
     */
    訂正者名簿国民("AFAPRA108_TeiseishaMeiboKokumin", "訂正者名簿国民", "AFAPRA108_TeiseishaMeiboKokumin.csv"),
    /**
     * 登録停止者名簿<br />
     * code：AFAPRA109_TorokuTeishishaMeibo
     */
    登録停止者名簿("AFAPRA109_TorokuTeishishaMeibo", "登録停止者名簿", "AFAPRA109_TorokuTeishishaMeibo.csv"),
    /**
     * 二重登録通知書<br />
     * code：AFAPRA111_NijuTorokuTsuchisho
     */
    二重登録通知書("AFAPRA111_NijuTorokuTsuchisho", "二重登録通知書", "AFAPRA111_NijuTorokuTsuchisho.csv"),
    /**
     * 送付先宛名シール作成<br />
     * code：AFAPRA213_SofusakiAtenaSeal
     */
    送付先宛名シール作成("AFAPRA213_SofusakiAtenaSeal", "送付先宛名シール作成", "AFAPRA213_SofusakiAtenaSeal.csv"),
    /**
     * 送付先宛名シール作成<br />
     * code：AFAPRA214_SofusakiAtenaSeal
     */
    送付先宛名シール作成_21("AFAPRA214_SofusakiAtenaSeal", "送付先宛名シール作成_21", "AFAPRA214_SofusakiAtenaSeal.csv"),
    /**
     * 二重登録者通知一覧表<br />
     * code：AFAPRA112_NijuTorokuTsuchishoList
     */
    二重登録者通知一覧表("AFAPRA112_NijuTorokuTsuchishoList", "二重登録者通知一覧表", "AFAPRA112_NijuTorokuTsuchishoList.csv"),
    /**
     * 二重登録調査票_照会<br />
     * code：AFAPRB100_NijuTorokuChosaShokai
     */
    二重登録調査票_照会("AFAPRB100_NijuTorokuChosaShokai", "二重登録調査票（照会）", "AFAPRB100_NijuTorokuChosaShokai.csv"),
    /**
     * 二重登録調査票_回答<br />
     * code：AFAPRB101_NijuTorokuChosaKaito
     */
    二重登録調査票_回答("AFAPRB101_NijuTorokuChosaKaito", "二重登録調査票（回答）", "AFAPRB101_NijuTorokuChosaKaito.csv"),
    /**
     * 二重登録調査一覧表<br />
     * code：AFAPRA112_NijuTorokuChosaList
     */
    二重登録調査一覧表("AFAPRA112_NijuTorokuChosaList", "二重登録調査一覧表", "AFAPRA112_NijuTorokuChosaList.csv"),
    /**
     * 当日投票録。
     */
    当日投票録("AFAPRE301_TojitsuTohyoroku", "当日投票録", "AFAPRE301_TojitsuTohyoroku.csv"),
    /**
     * 期日前投票録1枚タイプ。
     */
    期日前投票録1枚タイプ("AFAPRE506_KijitsumaeTohyoroku1mai", "期日前投票録", "AFAPRE506_KijitsumaeTohyoroku1mai.csv"),
    /**
     * 期日前投票録3枚（甲乙丙）タイプ。
     */
    期日前投票録3枚タイプ("AFAPRE506_KijitsumaeTohyoroku3mai", "期日前投票録", "AFAPRE506_KijitsumaeTohyoroku3mai.csv"),
    /**
     * 投票集計表。
     */
    投票集計表("AFAPRE508_TohyoShukeihyo", "投票集計表", "AFAPRE508_TohyoShukeihyo.csv"),
    /**
     * 受理状況一覧表。
     */
    受理状況一覧表("AFAPRE509_JurijokyoIchiranhyo", "期日前・受理状況一覧表", "AFAPRE509_JurijokyoIchiranhyo.csv"),
    /**
     * 施設交付一覧表。
     */
    施設交付一覧表("AFAPRE510_ShisetsuKofuIchiranhyo", "施設交付一覧表", "AFAPRE510_ShisetsuKofuIchiranhyo.csv"),
    /**
     * 代理投票集計表。
     */
    代理投票集計表("AFAPRE511_DairiTohyoShukeihyo", "代理投票集計表", "AFAPRE511_DairiTohyoShukeihyo.csv"),
    /**
     * 代理投票集計表_期日前。
     */
    代理投票集計表_期日前("AFAPRE511_DairiTohyoShukeihyo_Kijitsumae", "代理投票集計表（期日前）", "AFAPRE511_DairiTohyoShukeihyo.csv"),
    /**
     * 代理投票集計表_不在者。
     */
    代理投票集計表_不在者("AFAPRE511_DairiTohyoShukeihyo_Fuzaisha", "代理投票集計表（不在者）", "AFAPRE511_DairiTohyoShukeihyo.csv"),
    /**
     * 年代別投票状況調べ。
     */
    年代別投票状況調べ("AFAPRE512_NendaibetsuJokyoShirabe", "年代別投票状況調べ表", "AFAPRE512_NendaibetsuJokyoShirabe.csv"),
    /**
     * 時間別投票状況表　合計。
     */
    時間別投票状況表合計("AFAPRE513_JikanbetsuJokyoGokei", "時間別投票状況表　合計", "AFAPRE513_JikanbetsuJokyoGokei.csv"),
    /**
     * 時間別投票状況表　投票所別。
     */
    時間別投票状況表投票所別("AFAPRE514_JikanbetsuJokyoTohyojo", "時間別投票状況表　投票所別", "AFAPRE514_JikanbetsuJokyoTohyojo.csv"),
    /**
     * 事務処理簿。
     */
    事務処理簿("AFAPRE515_Jimushoribo", "事務処理簿", "AFAPRE515_Jimushoribo.csv"),
    /**
     * 事務処理簿。
     */
    事務処理簿_期日前("AFAPRE515_Jimushoribo_Kijitsumae", "事務処理簿（期日前）", "AFAPRE515_Jimushoribo.csv"),
    /**
     * 事務処理簿。
     */
    事務処理簿_不在者("AFAPRE515_Jimushoribo_Fuzaisha", "事務処理簿（不在者）", "AFAPRE515_Jimushoribo.csv"),
    /**
     * 不在者投票に関する調書（25号様式）。
     */
    不在者投票に関する調書25号様式("AFAPRE516_FuzaishaTohyoChosho", "不在者投票に関する調書（25号様式）", "AFAPRE516_FuzaishaTohyoChosho.csv"),
    /**
     * 不在者投票用紙等の調書。
     */
    不在者投票用紙等の調書("AFAPRE517_FuzaishaTohyoYoshiChosho", "不在者投票用紙等の調書", "AFAPRE517_FuzaishaTohyoYoshiChosho.csv"),
    /**
     * 不在者投票管理者別の調書。
     */
    不在者投票管理者別の調書("AFAPRE518_FuzaishaTohyoKanrishabetsuChosho", "不在者投票管理者別の調書", "AFAPRE518_FuzaishaTohyoKanrishabetsuChosho.csv"),
    /**
     * 送致書。
     */
    送致書("AFAPRE519_Sochisho", "送致書", "AFAPRE519_Sochisho.csv"),
    /**
     * 年代別投票率集計表。
     */
    年代別投票率集計表("AFAPRE520_NendaibetsuTohyoritsu", "年代別投票率集計表", "AFAPRE520_NendaibetsuTohyoritsu.csv"),
    /**
     * 年齢別投票率集計表。
     */
    年齢別投票率集計表("AFAPRE520_NenreibetsuTohyoritsu", "年齢別投票率集計表", "AFAPRE520_NenreibetsuTohyoritsu.csv"),
    /**
     * 時間別投票者集計表。
     */
    時間別投票者集計表("AFAPRE521_JikanbetsuTohyoshaShukeihyo", "時間別投票者集計表", "AFAPRE521_JikanbetsuTohyoshaShukeihyo.csv"),
    /**
     * 宣誓書。
     */
    宣誓書("AFAPRE101_Senseisho", "宣誓書", "AFAPRE101_Senseisho.csv"),
    /**
     * ラベルシール（専用ラベル）。
     */
    ラベルシール_専用ラベル("AFAPRE202_LabelSeal", "ラベルシール（専用ラベル）", "AFAPRE202_LabelSeal.csv"),
    /**
     * 不在者投票証明書（12号様式）。
     */
    不在者投票証明書_12号様式("AFAPRE201_FuzaishaTohyoShomeisho", "不在者投票証明書（12号様式）", "AFAPRE201_FuzaishaTohyoShomeisho.csv"),
    /**
     * AFAPRC201_郵便等投票証明書。
     */
    AFAPRC201_郵便等投票証明書("AFAPRC201_YubinTohyoShomeisho", "郵便等投票証明書", "AFAPRC201_YubinTohyoShomeisho.csv"),
    /**
     * AFAPRC202_選挙人名簿登録証明書。
     */
    AFAPRC202_選挙人名簿登録証明書("AFAPRC202_SenkyoninMeiboTorokuShomeisho", "選挙人名簿登録証明書", "AFAPRC202_SenkyoninMeiboTorokuShomeisho.csv"),
    /**
     * AFAPRC203_南極選挙人証。
     */
    AFAPRC203_南極選挙人証("AFAPRC203_NankyokuSenkyoninShomeisho", "南極選挙人証", "AFAPRC203_NankyokuSenkyoninShomeisho.csv"),
    /**
     * AFAPRB301_在外選挙人証。
     */
    AFAPRB301_在外選挙人証("AFAPRB301_ZaigaiSenkyoninSho", "在外選挙人証", "AFAPRB301_ZaigaiSenkyoninSho.csv"),
    /**
     * AFAPRB302_申請者の被登録資格の照会文書。
     */
    AFAPRB302_申請者の被登録資格の照会文書("AFAPRB302_ShinseishaShokaiBunsho", "申請者の被登録資格の照会文書", "AFAPRB302_ShinseishaShokaiBunsho.csv"),
    /**
     * AFAPRB303_登録した旨の通知。
     */
    AFAPRB303_登録した旨の通知("AFAPRB303_TorokuTsuchi", "登録した旨の通知", "AFAPRB303_TorokuTsuchi.csv"),
    /**
     * AFAPRB303_登録した旨の通知。
     */
    AFAPRB303_抹消通知_本籍地("AFAPRB303_MasshoTsuchiHonseki", "抹消通知（本籍地）", "AFAPRB303_TorokuTsuchi.csv"),
    /**
     * AFAPRB304_登録を行わなかった旨の通知（本人）。
     */
    AFAPRB304_登録を行わなかった旨の通知_本人("AFAPRB304_NotTorokuTsuchiHonnin", "登録を行わなかった旨の通知（本人）", "AFAPRB304_NotTorokuTsuchiHonnin.csv"),
    /**
     * AFAPRB305_登録を行わなかった旨の通知（領事官）。
     */
    AFAPRB305_登録を行わなかった旨の通知_領事官("AFAPRB305_NotTorokuTsuchiRyojikan", "登録を行わなかった旨の通知（領事官）", "AFAPRB305_NotTorokuTsuchiRyojikan.csv"),
    /**
     * AFAPRB305_再交付通知。
     */
    AFAPRB305_再交付通知("AFAPRB305_SaikofuTsuchi", "再交付通知", "AFAPRB305_NotTorokuTsuchiRyojikan.csv"),
    /**
     * AFAPRB305_記載事項変更通知_本人。
     */
    AFAPRB305_記載事項変更通知_本人("AFAPRB305_KisaijikoHenkoTsuchiHonnin", "記載事項変更通知（本人）", "AFAPRB305_NotTorokuTsuchiRyojikan.csv"),
    /**
     * AFAPRB306_記載事項変更通知（領事官）。
     */
    AFAPRB306_記載事項変更通知_領事官("AFAPRB306_KisaijikoHenkoTsuchiRyojikan", "記載事項変更通知（領事官）", "AFAPRB306_KisaijikoHenkoTsuchiRyojikan.csv"),
    /**
     * AFAPRB306_記載事項変更通知（領事官）。
     */
    AFAPRB306_抹消通知_領事官("AFAPRB306_MasshoTsuchiRyojikan", "抹消通知（領事官）", "AFAPRB306_KisaijikoHenkoTsuchiRyojikan.csv"),
    /**
     * AFAPRE507_投票立会人引継書。
     */
    AFAPRE507_投票立会人引継書("AFAPRE507_TachiaininHikitsugisho", "投票立会人引継書", "AFAPRE507_TachiaininHikitsugisho.csv"),
    /**
     * AFAPRB201_投票所入場券（個票3つ折り）。
     */
    AFAPRB201_投票所入場券_個票3つ折り("AFAPRB201_Nyujoken3tsuori", "投票所入場券（個票3つ折り）", "AFAPRB201_Nyujoken3tsuori.csv"),
    /**
     * AFAPRB202_投票所入場券（はがき4つ切り）。
     */
    AFAPRB202_投票所入場券_はがき4つ切り("AFAPRB202_NyujokenHagaki", "投票所入場券（はがき4つ切り）", "AFAPRB202_NyujokenHagaki.csv"),
    /**
     * AFAPRB203_投票所入場券（シーラー）。
     */
    AFAPRB203_投票所入場券_シーラー("AFAPRB203_NyujokenSealer", "投票所入場券（シーラー）", "AFAPRB203_NyujokenSealer.csv"),
    /**
     * AFAPRB204_投票所入場券（ポステックス）。
     */
    AFAPRB204_投票所入場券_ポステックス("AFAPRB204_NyujokenPostex", "投票所入場券（ポステックス）", "AFAPRB204_NyujokenPostex.csv"),
    /**
     * AFAPRB204_投票所入場券（ポステックス）。
     */
    AFAPRB204_投票所入場券_ポステックス_地図右下版("AFAPRB204_NyujokenPostex_4ninMapRight", "投票所入場券（ポステックス）_地図右下版", "AFAPRB204_NyujokenPostex_4ninMapRight.csv"),
    /**
     * AFAPRB204_投票所入場券（ポステックス）。
     */
    AFAPRB204_投票所入場券_ポステックス_地図真中版("AFAPRB204_NyujokenPostex_4ninMapCenter", "投票所入場券（ポステックス）_地図真中版", "AFAPRB204_NyujokenPostex_4ninMapCenter.csv"),
    /**
     * AFAPRB204_投票所入場券（ポステックス）。
     */
    AFAPRB204_投票所入場券_ポステックス_南魚沼市版("AFAPRB204_NyujokenPostex_152269", "投票所入場券（ポステックス）_南魚沼市版", "AFAPRB204_NyujokenPostex_152269.csv"),
    /**
     * AFAPRB210__転出者お知らせハガキ。
     */
    AFAPRB210_転出者お知らせハガキ("AFAPRB210_TenshutsuOshiraseHagaki", "転出者お知らせハガキ", "AFAPRB210_TenshutsuOshiraseHagaki.csv"),
    /**
     * AFAPRB212_投票所入場券印刷枚数表。
     */
    AFAPRB212_投票所入場券印刷枚数表("AFAPRB212_NyujokenMaisuhyo", "投票所入場券印刷枚数表", "AFAPRB212_NyujokenMaisuhyo.csv"),
    /**
     * AFAPRB213_n人以上世帯一覧表。
     */
    AFAPRB213_n人以上世帯一覧表("AFAPRB213_NninIjoSetaiList", "n人以上世帯一覧表", "AFAPRB213_NninIjoSetaiList.csv"),
    /**
     * AFAPRB309_在外投票資格者名簿。
     */
    AFAPRB309_在外投票資格者名簿("AFAPRB309_ZaigaiShikakushaMeibo", "在外投票資格者名簿", "AFAPRB309_ZaigaiShikakushaMeibo.csv"),
    /**
     * AFAPRB310_在外選挙投票管理表。
     */
    AFAPRB310_在外選挙投票管理表("AFAPRB310_TohyoKanrihyo", "在外選挙投票管理表", "AFAPRB310_TohyoKanrihyo.csv"),
    /**
     * AFAPRE500_期日前投票日報。
     */
    AFAPRE500_期日前投票日報("AFAPRE500_KijitsumaeNippo", "期日前投票日報", "AFAPRE500_KijitsumaeNippo.csv"),
    /**
     * AFAPRE501_不在者投票日報。
     */
    AFAPRE501_不在者投票日報("AFAPRE501_FuzaihsaNippo", "不在者投票日報", "AFAPRE501_FuzaihsaNippo.csv"),
    /**
     * AFAPRE501_不在者投票日報。
     */
    AFAPRE501_不在者投票日報_交付日報("AFAPRE501_FuzaihsaNippoKofu", "不在者投票日報（交付日報）", "AFAPRE501_FuzaihsaNippo.csv"),
    /**
     * AFAPRE501_不在者投票日報。
     */
    AFAPRE501_不在者投票日報_受理日報("AFAPRE501_FuzaihsaNippoJuri", "不在者投票日報（受理日報）", "AFAPRE501_FuzaihsaNippo.csv"),
    /**
     * AFAPRE502_期日前投票者一覧表。
     */
    AFAPRE502_期日前投票者一覧表("AFAPRE502_KijitsumaeTohyoshaList", "期日前投票者一覧表", "AFAPRE502_KijitsumaeTohyoshaList.csv"),
    /**
     * AFAPRE502_不在者投票者一覧表。
     */
    AFAPRE502_不在者投票者一覧表("AFAPRE502_FuzaishaTohyoshaList", "不在者投票者一覧表", "AFAPRE502_KijitsumaeTohyoshaList.csv"),
    /**
     * AFAPRE503_投票者一覧表。
     */
    AFAPRE503_投票者一覧表("AFAPRE503_TohyoshaListSenkyoAll", "投票者一覧表", "AFAPRE503_TohyoshaListSenkyoAll.csv"),
    /**
     * AFAPRE503_投票者一覧表_混在。
     */
    AFAPRE503_投票者一覧表_混在("AFAPRE503_TohyoshaListSenkyoKonZai", "投票者一覧表（混在）", "AFAPRE503_TohyoshaListSenkyoKonZai.csv"),
    /**
     * AFAPRE503_投票者一覧表_期日前。
     */
    AFAPRE503_投票者一覧表_期日前("AFAPRE503_TohyoshaListSenkyoKijitsu", "投票者一覧表（期日前）", "AFAPRE503_TohyoshaListSenkyoKijitsu.csv"),
    /**
     * AFAPRE503_投票者一覧表_不在者。
     */
    AFAPRE503_投票者一覧表_不在者("AFAPRE503_TohyoshaListSenkyoFuzai", "投票者一覧表（不在者）", "AFAPRE503_TohyoshaListSenkyoFuzai.csv"),
    /**
     * 投票事由調書。
     */
    AFAPRE504_投票事由調書("AFAPRE504_TohyoJiyuChosho", "投票事由調書", "AFAPRE504_TohyoJiyuChosho.csv"),
    /**
     * 投票事由調書。
     */
    AFAPRE504_投票事由調書_期日前("AFAPRE504_TohyoJiyuChoshoKijitsu", "投票事由調書（期日前）", "AFAPRE504_TohyoJiyuChosho.csv"),
    /**
     * 投票事由調書。
     */
    AFAPRE504_投票事由調書_不在者("AFAPRE504_TohyoJiyuChoshoFuzai", "投票事由調書（不在者）", "AFAPRE504_TohyoJiyuChosho.csv"),
    /**
     * 集計整理表。
     */
    AFAPRE505_集計整理表("AFAPRE505_ShukeiSeirihyo", "集計整理表", "AFAPRE505_ShukeiSeirihyo.csv"),
    /**
     * 集計整理表。
     */
    AFAPRE505_集計整理表_不在者投票分("AFAPRE505_ShukeiSeirihyoFuzai", "集計整理表（不在者投票分）", "AFAPRE505_ShukeiSeirihyo.csv"),
    /**
     * 住民投票時登録
     */
    AFAPRI100_住民投票時登録("AFAPRI100_MeiboShohonJumin", "住民投票資格者名簿抄本", "AFAPRI100_MeiboShohonJumin.csv"),
    /**
     * 住民投票資格者名簿抄本
     */
    AFAPRI100_住民投票資格者名簿抄本_縦覧("AFAPRI100_MeiboShohonJumin", "住民投票資格者名簿抄本（縦覧）", "AFAPRI100_MeiboShohonJuminJuran.csv"),
    /**
     * 請求代表者証明書
     */
    AFAPRH101_請求代表者証明書("AFAPRH101_SeikyuDaihyoshaShomeisho", "請求代表者証明書", "AFAPRH101_SeikyuDaihyoshaShomeisho.csv"),
    /**
     * 施設送付書
     */
    AFAPRE205_施設送付書("AFAPRE205_ShisetsuSofusho", "施設送付書", "AFAPRE205_ShisetsuSofusho.csv"),
    /**
     * 海区漁業調整委員会委員選挙人名簿抄本
     */
    AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本("AFAPRK100_MeiboShohonKaiku", "海区漁業調整委員会委員選挙人名簿抄本", "AFAPRK100_MeiboShohonKaiku.csv"),
    /**
     * 海区漁業調整委員会委員選挙人名簿抄本
     */
    AFAPRK100_海区漁業調整委員会委員選挙人名簿抄本縦覧("AFAPRK100_MeiboShohonKaiku", "海区漁業調整委員会委員選挙人名簿抄本（縦覧）", "AFAPRK100_MeiboShohonJuranKaiku.csv"),
    /**
     * 申請書チェックリスト
     */
    AFAPRK101_申請書チェックリスト("AFAPRK101_ShinseishoCheckListKaiku", "申請書チェックリスト", "AFAPRK101_ShinseishoCheckListKaiku.csv"),
    /**
     * ラベルシール（宛名シール用紙12面）
     */
    AFAPRE203_ラベルシール_宛名シール用紙12面("AFAPRE203_LabelSealAtena12", "ラベルシール（宛名シール用紙12面）", "AFAPRE203_LabelSealAtena12.csv"),
    /**
     * ラベルシール（宛名シール用紙21面）
     */
    AFAPRE204_ラベルシール_宛名シール用紙21面("AFAPRE204_LabelSealAtena21", "ラベルシール（宛名シール用紙21面）", "AFAPRE204_LabelSealAtena21.csv"),
    /**
     * 宛名シール12面
     */
    AFAPRE213_宛名シール12面("AFAPRE213_AtenaSeal12", "宛名シール12面", "AFAPRE213_AtenaSeal12.csv"),
    /**
     * 宛名シール21面
     */
    AFAPRE214_宛名シール21面("AFAPRE214_AtenaSeal21", "宛名シール21面", "AFAPRE214_AtenaSeal21.csv"),
    /**
     * 送付先宛名シール（1号資格登録通知）
     */
    AFAPRE213_宛名シール1号資格登録通知("AFAPRE213_SofusakiAtenaSeal_1go", "送付先宛名シール（1号資格登録通知）", "AFAPRE213_SofusakiAtenaSeal_1go.csv"),
    /**
     * 送付先宛名シール（2号資格調査票）
     */
    AFAPRE213_宛名シール2号資格調査票("AFAPRE213_SofusakiAtenaSeal_2go", "送付先宛名シール（2号資格調査票）", "AFAPRE213_SofusakiAtenaSeal_2go.csv"),
    /**
     * 補正登録者宛名シール
     */
    AFAPRE213_補正登録者宛名シール("AFAPRE213_HoseiTorokushaAtenaSeal", "補正登録者宛名シール", "AFAPRE213_HoseiTorokushaAtenaSeal.csv"),
    /**
     * 送付先宛名シール未登録者抹消通知
     */
    AFAPRE213_宛名シール未登録者抹消通知("AFAPRE213_SofusakiAtenaSeal_Mitoroku", "送付先宛名シール（未登録者抹消通知）", "AFAPRE213_SofusakiAtenaSeal_Mitoroku.csv"),
    /**
     * 送付先宛名シール国内転入者調査票
     */
    AFAPRE213_宛名シール国内転入者調査票("AFAPRE213_SofusakiAtenaSeal_Kokunai", "送付先宛名シール（国内転入者調査票）", "AFAPRE213_SofusakiAtenaSeal_Kokunai.csv"),
    /**
     * 送付先宛名シール国外転入者調査票
     */
    AFAPRE213_宛名シール国外転入者調査票("AFAPRE213_SofusakiAtenaSeal_Kokugai", "送付先宛名シール（国外転入者調査票）", "AFAPRE213_SofusakiAtenaSeal_Kokugai.csv"),
    /**
     * 送付先宛名シール（1号資格登録通知）
     */
    AFAPRE214_宛名シール1号資格登録通知("AFAPRE214_SofusakiAtenaSeal_1go", "送付先宛名シール（1号資格登録通知）", "AFAPRE214_SofusakiAtenaSeal_1go.csv"),
    /**
     * 送付先宛名シール（2号資格調査票）
     */
    AFAPRE214_宛名シール2号資格調査票("AFAPRE214_SofusakiAtenaSeal_2go", "送付先宛名シール（2号資格調査票）", "AFAPRE214_SofusakiAtenaSeal_2go.csv"),
    /**
     * 補正登録者宛名シール
     */
    AFAPRE214_補正登録者宛名シール("AFAPRE214_HoseiTorokushaAtenaSeal", "補正登録者宛名シール", "AFAPRE214_HoseiTorokushaAtenaSeal.csv"),
    /**
     * 送付先宛名シール未登録者抹消通知
     */
    AFAPRE214_宛名シール未登録者抹消通知("AFAPRE214_SofusakiAtenaSeal_Mitoroku", "送付先宛名シール（未登録者抹消通知）", "AFAPRE214_SofusakiAtenaSeal_Mitoroku.csv"),
    /**
     * 送付先宛名シール国内転入者調査票
     */
    AFAPRE214_宛名シール国内転入者調査票("AFAPRE214_SofusakiAtenaSeal_Kokunai", "送付先宛名シール（国内転入者調査票）", "AFAPRE214_SofusakiAtenaSeal_Kokunai.csv"),
    /**
     * 送付先宛名シール国外転入者調査票
     */
    AFAPRE214_宛名シール国外転入者調査票("AFAPRE214_SofusakiAtenaSeal_Kokugai", "送付先宛名シール（国外転入者調査票）", "AFAPRE214_SofusakiAtenaSeal_Kokugai.csv"),
    /**
     * 転出者お知らせハガキ作成対象者一覧表
     */
    AFAPRA112_転出者お知らせハガキ作成対象者一覧表("AFAPRA112_TenshutsuOshiraseHagakiList", "転出者お知らせハガキ作成対象者一覧表", "AFAPRA112_TenshutsuOshiraseHagakiList.csv"),
    /**
     * AFAPRA112
     */
    AFAPRB211_転出者お知らせハガキ作成対象者一覧表("AFAPRA112_NijuTorokuTsuchishoList", "転出者お知らせハガキ作成対象者一覧表", "AFAPRA112_NijuTorokuTsuchishoList.csv"),
    /**
     * 補正登録者名簿。
     */
    AFAPRA105_補正登録者名簿("AFAPRA105_ShinkiTorokushaMeiboKokumin", "補正登録者名簿", "AFAPRA105_ShinkiTorokushaMeiboKokumin.csv"),
    /**
     * 抹消者名簿。
     */
    AFAPRA105_抹消者名簿("AFAPRA105_MasshoshaMeiboKokumin", "抹消者名簿", "AFAPRA105_MasshoshaMeiboKokumin.csv"),
    /**
     * 補正登録者名簿縦覧。
     */
    AFAPRA106_補正登録者名簿縦覧("AFAPRA106_ShinkiTorokushaMeiboJuranKokumin", "補正登録者名簿（縦覧）", "AFAPRA106_ShinkiTorokushaMeiboJuranKokumin.csv"),
    /**
     * 抹消者名簿縦覧。
     */
    AFAPRA106_抹消者名簿縦覧("AFAPRA106_MasshoshaMeiboJuranKokumin", "抹消者名簿（縦覧）", "AFAPRA106_MasshoshaMeiboJuranKokumin.csv"),
    /**
     * 訂正者名簿。
     */
    AFAPRA108_訂正者名簿("AFAPRA108_TeiseishaMeiboKokumin", "訂正者名簿", "AFAPRA108_TeiseishaMeiboKokumin.csv"),
    /**
     * 宛名シール出力対象者一覧
     */
    AFAPRE215_宛名シール出力対象者一覧("AFAPRE215_AtenaSealList", "宛名シール出力対象者一覧", "AFAPRE215_AtenaSealList.csv"),
    /**
     * 入場券テストデータ抽出一覧表
     */
    AFAPRB214_入場券テストデータ抽出一覧表("AFAPRB214_NyujokenTestPrintDataList", "入場券テストデータ抽出一覧表", "AFAPRB214_NyujokenTestPrintDataList.csv"),
    /**
     * 登録者数リスト（海区選挙）
     */
    AFAPRA103_登録者数リスト海区選挙("AFAPRA103_TorokushasuList", "登録者数リスト海区選挙", "AFAPRA103_TorokushasuListKaiku.csv"),
    /**
     * 財産区選挙人名簿抄本
     */
    AFAPRL100_財産区選挙人名簿抄本("AFAPRL100_MeiboShohonZaisanku", "財産区選挙人名簿抄本", "AFAPRL100_MeiboShohonZaisanku.csv"),
    /**
     * 財産区選挙人名簿抄本
     */
    AFAPRL100_財産区選挙人名簿抄本縦覧("AFAPRL100_MeiboShohonZaisanku", "財産区選挙人名簿抄本（縦覧）", "AFAPRL100_MeiboShohonZaisanku.csv"),
    /**
     * 投票人名簿抄本
     */
    投票人名簿抄本("AFAPRA100_MeiboShohonKokumin", "投票人名簿抄本", "AFAPRA100_MeiboShohonKokumin.csv"),
    /**
     * 投票人名簿抄本（縦覧）
     */
    投票人名簿抄本_縦覧("AFAPRA100_MeiboShohonKokuminJuran", "投票人名簿抄本_縦覧", "AFAPRA100_MeiboShohonKokuminJuran.csv"),
    /**
     * 訂正者名簿国民投票時登録
     */
    訂正者名簿国民投票時登録("AFAPRA108_TeiseishaMeiboKokumin", "訂正者名簿", "AFAPRA108_TeiseishaMeiboKokumin.csv"),
    /**
     * 1号資格登録通知（様式1）
     */
    AFAPRG111_1号資格登録通知_様式1("AFAPRG111_1goShikakuTorokuTsuchi", "1号資格登録通知（様式1）", "AFAPRG111_1goShikakuTorokuTsuchi.csv"),
    /**
     * 1号資格登録通知一覧表
     */
    AFAPRG112_1号資格登録通知一覧表("AFAPRG112_1goShikakuTorokuTsuchiList", "1号資格登録通知一覧表", "AFAPRG112_1goShikakuTorokuTsuchiList.csv"),
    /**
     * 2号資格調査一覧表
     */
    AFAPRG112_2号資格調査一覧表("AFAPRG112_2goShikakuChosahyoList", "2号資格調査一覧表", "AFAPRG112_2goShikakuChosahyoList.csv"),
    /**
     * 2号資格調査票（照会）
     */
    AFAPRG113_2号資格調査票_照会("AFAPRG113_2goShikakuChosahyoShokai", "2号資格調査票（照会）（様式2-1）", "AFAPRG113_2goShikakuChosahyoShokai.csv"),
    /**
     * 2号資格候補者一覧表
     */
    AFAPRG116_2号資格候補者一覧表("AFAPRG116_2goShikakuKohoshaList", "2号資格候補者一覧表", "AFAPRG116_2goShikakuKohoshaList.csv"),
    /**
     * 2号資格調査票_回答
     */
    AFAPRG114_2号資格調査票_回答("AFAPRG114_2goShikakuChosahyoKaito", "2号資格調査票（回答）", "AFAPRG114_2goShikakuChosahyoKaito.csv"),
    /**
     * 在外投票管理表
     */
    AFAPRB310_在外投票管理表("AFAPRB310_TohyoKanrihyoKokumin", "在外投票管理表", "AFAPRB310_TohyoKanrihyoKokumin.csv"),
    /**
     * 投票人名簿登録者数リスト
     */
    AFAPRG103_投票人名簿登録者数リスト("AFAPRG103_TorokushasuListKokumin", "投票人名簿登録者数リスト", "AFAPRG103_TorokushasuListKokumin.csv"),
    /**
     * 投票人名簿登録者数リスト
     */
    登録者数リスト不在者投票資格者分("AFAPRG103_TorokushasuListFuzaiShikakuKokumin", "登録者数リスト（不在者投票資格者分）", "AFAPRG103_TorokushasuListFuzaiShikakuKokumin.csv"),
    /**
     * 同一人物調査結果
     */
    AFAPRM320_同一人物調査結果("AFAPRM320_DoitsujinbutsuChosa", "同一人物調査結果", "DoitsujinbutsuChosa.csv"),
    /**
     * 在外投票人名簿抄本
     */
    AFAPRB300_在外投票人名簿抄本("AFAPRB300_MeiboShohonZaigaiKokumin", "在外投票人名簿抄本", "AFAPRB300_MeiboShohonZaigaiKokumin.csv"),
    /**
     * 未登録者抹消通知<br />
     * code：AFAPRG117_MitorokushaMasshoTsuchi
     */
    AFAPRG117_未登録者抹消通知("AFAPRG117_MitorokushaMasshoTsuchi", "未登録者抹消通知（様式5）", "AFAPRG117_MitorokushaMasshoTsuchi.csv");

    private final RString reportID;
    private final RString eucFileName;
    private final RString reportName;

    private ReportIdKeys(String reportID, String reportName, String eucFileName) {
        this.reportID = new RString(reportID);
        this.reportName = new RString(reportName);
        this.eucFileName = new RString(eucFileName);
    }

    /**
     * 帳票IDを取得します。
     *
     * @return 帳票ID
     */
    public RString value() {
        return this.reportID;
    }

    /**
     * 帳票Nameを取得します。
     *
     * @return 帳票Name
     */
    public RString getName() {
        return this.reportName;
    }

    /**
     * EUCフィル名を取得します。
     *
     * @return EUCフィル名
     */
    public RString getEucFileName() {
        return null == eucFileName ? RString.EMPTY : eucFileName;
    }

    /**
     * 帳票名を取得します。
     *
     * @return 帳票名
     */
    public RString getReportName() {
        return null == reportName ? RString.EMPTY : reportName;
    }
}
