/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.KokuminSakuseiChohyo1goShikakuTsuchi;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.KokuminSakuseiChohyo2goShikakuChosahyo;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.KokuminSakuseiChohyoIdoMasshoshaMeibo;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.KokuminSakuseiChohyoKokugaiChosahyo;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.KokuminSakuseiChohyoKokunaiChosahyo;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.KokuminSakuseiChohyoMasshoTsuchi;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * KokuminSakuseiChohyoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してKokuminSakuseiChohyoDivの入力可否、表示・非表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-012 liwul
 */
public class KokuminSakuseiChohyoHandler {

    private final KokuminSakuseiChohyoDiv div;
    private static final RString 表示しない = new RString(0);
    private static final RString 出力する = new RString(1);
    private static final RString SELECTED_KEY = new RString("key0");
    private static final RString 未登録者抹消通知一覧 = new RString("key1");

    /**
     * コンストラクタです。
     *
     * @param div 国民投票作成帳票Div
     */
    public KokuminSakuseiChohyoHandler(KokuminSakuseiChohyoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     */
    public void initialize() {
        KokuminSakuseiChohyo1goShikakuTsuchi.setData(div.getKokuminSakuseiChohyo1goShikakuTsuchi());
        KokuminSakuseiChohyo2goShikakuChosahyo.setData(div.getKokuminSakuseiChohyo2goShikakuChosahyo());
        KokuminSakuseiChohyoKokugaiChosahyo.setData(div.getKokuminSakuseiChohyoKokugaiChosahyo());
        KokuminSakuseiChohyoKokunaiChosahyo.setData(div.getKokuminSakuseiChohyoKokunaiChosahyo());
        KokuminSakuseiChohyoMasshoTsuchi.setData(div.getKokuminSakuseiChohyoMasshoTsuchi());
        RString menuID = ResponseHolder.getMenuID();
        if (AFAMenuId.AFAMNG1010_国民投票時登録.menuId().equals(menuID)) {
            div.getKokuminSakuseiChohyoMeiboShohon().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_投票人名簿抄本_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoTorokushasuList().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_投票人名簿登録者数リスト_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo1goShikakuTsuchi().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_1号資格登録通知_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo2goShikakuChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_2号資格調査票_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo2goKohoList().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_2号資格候補者一覧表_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoTorokushaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_補正登録者名簿_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoMasshoshaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_抹消者名簿_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoTeiseishaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_訂正者名簿_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoMasshoTsuchi().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_未登録者抹消通知_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoKokunaiChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_国内転入者調査票_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoKokugaiChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_国外転入者調査票_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票人名簿抄本_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiShikakushaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票資格者名簿_国民投票, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiTohyoKanrihyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票管理票_国民投票, SubGyomuCode.AFA選挙本体)));
        }
        if (AFAMenuId.AFAMNG1050_投票人名簿最新化.menuId().equals(menuID)) {
            div.getKokuminSakuseiChohyoMeiboShohon().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_投票人名簿抄本_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoTorokushasuList().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_投票人名簿登録者数リスト_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo1goShikakuTsuchi().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_1号資格登録通知_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo2goShikakuChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_2号資格調査票_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo2goKohoList().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_2号資格候補者一覧表_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoTorokushaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_補正登録者名簿_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoMasshoshaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_抹消者名簿_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoTeiseishaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_訂正者名簿_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoMasshoTsuchi().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_未登録者抹消通知_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoKokunaiChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_国内転入者調査票_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoKokugaiChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_国外転入者調査票_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票人名簿抄本_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiShikakushaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票資格者名簿_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiTohyoKanrihyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票管理票_国民投票_最新化, SubGyomuCode.AFA選挙本体)));
        }
        if (AFAMenuId.AFAMNG1060_帳票再発行.menuId().equals(menuID)) {
            div.getKokuminSakuseiChohyoMeiboShohon().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_投票人名簿抄本_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoTorokushasuList().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_投票人名簿登録者数リスト_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo1goShikakuTsuchi().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_1号資格登録通知_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo2goShikakuChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_2号資格調査票_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyo2goKohoList().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_2号資格候補者一覧表_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoTorokushaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_補正登録者名簿_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoMasshoshaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_抹消者名簿_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoIdoTeiseishaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_訂正者名簿_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoMasshoTsuchi().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_未登録者抹消通知_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoKokunaiChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_国内転入者調査票_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoKokugaiChosahyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_国外転入者調査票_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票人名簿抄本_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiShikakushaMeibo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票資格者名簿_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
            div.getKokuminSakuseiChohyoZaigai().getKokuminSakuseiChohyoZaigaiTohyoKanrihyo().setIsPublish(対象帳票の出力チェック(
                    BusinessConfig.get(ConfigKeysAFA.帳票出力初期値_在外投票管理票_国民投票_再発行, SubGyomuCode.AFA選挙本体)));
        }
        List<RString> selectedKeys = new ArrayList<>();
        selectedKeys.add(SELECTED_KEY);
        div.getKokuminSakuseiChohyoTorokushasuList().setIsOpen(Boolean.FALSE);
        div.getKokuminSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().setValue(RDate.getNowDate());
        div.getKokuminSakuseiChohyoTorokushasuList().getChkTorokuListFuzaishabun().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoTorokushasuList().getChkFuzaiTohyoMeibo().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyo1goShikakuTsuchi().setIsOpen(Boolean.FALSE);
        div.getKokuminSakuseiChohyo1goShikakuTsuchi().getCcdPrintNaiyo1goTsuchi().getTxtIinchoName().setReadOnly(Boolean.TRUE);
        div.getKokuminSakuseiChohyo1goShikakuTsuchi().getChkSeal1goTsuchi().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyo1goShikakuTsuchi().getChk1goTsuchiIchiran().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyo2goShikakuChosahyo().setIsOpen(Boolean.FALSE);
        div.getKokuminSakuseiChohyo2goShikakuChosahyo().getCcdPrintNaiyo2goChosahyo().getTxtIinchoName().setReadOnly(Boolean.TRUE);
        div.getKokuminSakuseiChohyo2goShikakuChosahyo().getChkSeal2goChosahyo().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyo2goShikakuChosahyo().getChk2goChosaIchiran().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoIdoTorokushaMeibo().setIsOpen(Boolean.FALSE);
        div.getKokuminSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeiboJuran().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoIdoTorokushaMeibo().getChkSealTorokushaMeibo().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoIdoMasshoshaMeibo().setIsOpen(Boolean.FALSE);
        div.getKokuminSakuseiChohyoIdoMasshoshaMeibo().getTxtMasshoYMD().clearValue();
        div.getKokuminSakuseiChohyoIdoMasshoshaMeibo().getChkMasshoshaMeiboJuran().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoMasshoTsuchi().setIsOpen(Boolean.FALSE);
        div.getKokuminSakuseiChohyoMasshoTsuchi().getCcdPrintNaiyoMasshoTsuchi().getTxtIinchoName().setReadOnly(Boolean.TRUE);
        div.getKokuminSakuseiChohyoMasshoTsuchi().getChkSealMasshoTsuchi().setSelectedItemsByKey(selectedKeys);
        List<RString> 未登録者抹消通知一覧List = new ArrayList<>();
        未登録者抹消通知一覧List.add(未登録者抹消通知一覧);
        div.getKokuminSakuseiChohyoMasshoTsuchi().getChkMasshoTsuchiIchiran().setSelectedItemsByKey(未登録者抹消通知一覧List);
        div.getKokuminSakuseiChohyoKokunaiChosahyo().setIsOpen(Boolean.FALSE);
        div.getKokuminSakuseiChohyoKokunaiChosahyo().getCcdPrintNaiyoKokunaiChosa().getTxtIinchoName().setReadOnly(Boolean.TRUE);
        div.getKokuminSakuseiChohyoKokunaiChosahyo().getChkSealKokunaiChosa().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoKokunaiChosahyo().getChkKokunaiChosaIchiran().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoKokugaiChosahyo().setIsOpen(Boolean.FALSE);
        div.getKokuminSakuseiChohyoKokugaiChosahyo().getCcdPrintNaiyoKokugaiChosa().getTxtIinchoName().setReadOnly(Boolean.TRUE);
        div.getKokuminSakuseiChohyoKokugaiChosahyo().getChkSealKokugaiChosa().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoKokugaiChosahyo().getChkKokugaiChosaIchiran().setSelectedItemsByKey(selectedKeys);
        div.getKokuminSakuseiChohyoZaigai()
                .setDisplayNone(表示しない.equals(BusinessConfig.get(ConfigKeysAFA.在外_関連帳票表示有無, SubGyomuCode.AFA選挙本体)));

    }

    /**
     * 帳票再作成で、抄本が選択された時のメソッドです。
     *
     * @param shohonNo RString
     */
    public void initialize(RString shohonNo) {
        HashMap targetData = get抄本情報(shohonNo);
        setData作成帳票();
        KokuminSakuseiChohyoIdoMasshoshaMeibo.setData(div.getKokuminSakuseiChohyoIdoMasshoshaMeibo(),
                targetData.get("処理年月日").toString());

    }

    /**
     * 国民投票時登録画面で、帳票条件設定ボタンクリック時に呼ばれるメソッドです。<br />
     *
     * @param tokuteiKigenYmd RDate 特定期限日
     * @param kijunKigenYmd RDate 基準日
     * @param shoriYmd RDate 抄本を作成した日付
     */
    public void initialize(RDate tokuteiKigenYmd, RDate kijunKigenYmd, RDate shoriYmd) {
        setData作成帳票();
        KokuminSakuseiChohyoIdoMasshoshaMeibo.setData(div.getKokuminSakuseiChohyoIdoMasshoshaMeibo(), shoriYmd.toString().toString());
    }

    /**
     * 時点日を取得する
     *
     * @return 時点日
     */
    public TextBoxDate get時点日() {
        return div.getKokuminSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd();
    }

    /**
     * 投票人名簿抄本取得
     *
     * @return 投票人名簿抄本
     */
    KokuminSakuseiChohyoMeiboShohonDiv get投票人名簿抄本() {
        return div.getKokuminSakuseiChohyoMeiboShohon();
    }

    /**
     * 投票人名簿登録者数リスト取得
     *
     * @return 投票人名簿登録者数リスト
     */
    KokuminSakuseiChohyoTorokushasuListDiv get投票人名簿登録者数リスト() {
        return div.getKokuminSakuseiChohyoTorokushasuList();
    }

    /**
     * 1号資格登録通知取得
     *
     * @return 1号資格登録通知
     */
    KokuminSakuseiChohyo1goShikakuTsuchiDiv get1号資格登録通知() {
        return div.getKokuminSakuseiChohyo1goShikakuTsuchi();
    }

    /**
     * 2号資格調査票取得
     *
     * @return 2号資格調査票
     */
    KokuminSakuseiChohyo2goShikakuChosahyoDiv get2号資格調査票() {
        return div.getKokuminSakuseiChohyo2goShikakuChosahyo();
    }

    /**
     * 2号資格候補者一覧表取得
     *
     * @return 2号資格候補者一覧表
     */
    KokuminSakuseiChohyo2goKohoListDiv get2号資格候補者一覧表() {
        return div.getKokuminSakuseiChohyo2goKohoList();
    }

    /**
     * 補正登録者名簿取得
     *
     * @return 補正登録者名簿
     */
    KokuminSakuseiChohyoIdoTorokushaMeiboDiv get補正登録者名簿() {
        return div.getKokuminSakuseiChohyoIdoTorokushaMeibo();
    }

    /**
     * 抹消者名簿取得
     *
     * @return 抹消者名簿
     */
    KokuminSakuseiChohyoIdoMasshoshaMeiboDiv get抹消者名簿() {
        return div.getKokuminSakuseiChohyoIdoMasshoshaMeibo();
    }

    /**
     * 訂正者名簿取得
     *
     * @return 訂正者名簿
     */
    KokuminSakuseiChohyoIdoTeiseishaMeiboDiv get訂正者名簿() {
        return div.getKokuminSakuseiChohyoIdoTeiseishaMeibo();
    }

    /**
     * 未登録者抹消通知取得
     *
     * @return 未登録者抹消通知
     */
    KokuminSakuseiChohyoMasshoTsuchiDiv get未登録者抹消通知() {
        return div.getKokuminSakuseiChohyoMasshoTsuchi();
    }

    /**
     * 国内転入者調査票取得
     *
     * @return 国内転入者調査票
     */
    KokuminSakuseiChohyoKokunaiChosahyoDiv get国内転入者調査票() {
        return div.getKokuminSakuseiChohyoKokunaiChosahyo();
    }

    /**
     * 国外転入者調査票取得
     *
     * @return 国外転入者調査票
     */
    KokuminSakuseiChohyoKokugaiChosahyoDiv get国外転入者調査票() {
        return div.getKokuminSakuseiChohyoKokugaiChosahyo();
    }

    /**
     * 在外投票関連取得
     *
     * @return 在外投票関連
     */
    KokuminSakuseiChohyoZaigaiDiv get在外投票関連() {
        return div.getKokuminSakuseiChohyoZaigai();
    }

    private void setData作成帳票() {
        clearData();
        KokuminSakuseiChohyo1goShikakuTsuchi.setData(div.getKokuminSakuseiChohyo1goShikakuTsuchi());
        KokuminSakuseiChohyo2goShikakuChosahyo.setData(div.getKokuminSakuseiChohyo2goShikakuChosahyo());
        KokuminSakuseiChohyoMasshoTsuchi.setData(div.getKokuminSakuseiChohyoMasshoTsuchi());
        KokuminSakuseiChohyoKokunaiChosahyo.setData(div.getKokuminSakuseiChohyoKokunaiChosahyo());
        KokuminSakuseiChohyoKokugaiChosahyo.setData(div.getKokuminSakuseiChohyoKokugaiChosahyo());
    }

    /**
     * 各パネルの条件をクリアします。
     *
     */
    public void clearData() {
        KokuminSakuseiChohyo1goShikakuTsuchi.clearData(div.getKokuminSakuseiChohyo1goShikakuTsuchi());
        KokuminSakuseiChohyo2goShikakuChosahyo.clearData(div.getKokuminSakuseiChohyo2goShikakuChosahyo());
        KokuminSakuseiChohyoIdoMasshoshaMeibo.clearData(div.getKokuminSakuseiChohyoIdoMasshoshaMeibo());
        KokuminSakuseiChohyoMasshoTsuchi.clearData(div.getKokuminSakuseiChohyoMasshoTsuchi());
        KokuminSakuseiChohyoKokunaiChosahyo.clearData(div.getKokuminSakuseiChohyoKokunaiChosahyo());
        KokuminSakuseiChohyoKokugaiChosahyo.clearData(div.getKokuminSakuseiChohyoKokugaiChosahyo());
    }

    private static HashMap get抄本情報(RString shohonNo) {
        RString yamlFile;
        yamlFile = new RString("ShohonKokumin.yml");
        List<HashMap> sourceShohon = YamlLoader.loadAsList(yamlFile);
        for (HashMap item : sourceShohon) {
            if (new RString(item.get("key").toString()).equals(shohonNo)) {
                return item;
            }
        }
        return null;
    }

    private boolean 対象帳票の出力チェック(RString result) {
        return 出力する.equals(result);
    }

}
