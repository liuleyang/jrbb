/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealSelectDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtena12Param;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtena21Param;
import jp.co.ndensan.reams.af.afa.business.core.LabelSealAtenaPartParam;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.labelsealselectdialog.LabelSealSelectDialog;
import jp.co.ndensan.reams.af.afa.business.labelsealselectdialog.LabelSealSelectDialogModel;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE101.SenseishoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE202.LabelSealParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SealShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho.ILabelSealPrintTaishoDiv;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE101.SenseishoPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE201.FuzaishaTohyoShomeishoPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE202.LabelSealPrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE203.LabelSealAtena12PrintService;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE204.LabelSealAtena21PrintService;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SealMensu;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import static jp.co.ndensan.reams.uz.uza.lang.FlexibleDate.getNowDate;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ラベルシール印刷確認ダイアログ用ハンドラークラスです。
 *
 * @reamsid_L AF-0620-015 liuyj
 */
public class LabelSealSelectDialogHandler {

    private final LabelSealSelectDialogDiv div;
    private static final RString ZERO = new RString("0");
    private final Association association;
    private static final int 面1 = 1;
    private static final int 面2 = 2;
    private static final int 面3 = 3;
    private static final int 面4 = 4;
    private static final int 面5 = 5;
    private static final int 面6 = 6;
    private static final int 面7 = 7;
    private static final int 面8 = 8;
    private static final int 面9 = 9;
    private static final int 面10 = 10;
    private static final int 面11 = 11;
    private static final int 面12 = 12;
    private static final int 面13 = 13;
    private static final int 面14 = 14;
    private static final int 面15 = 15;
    private static final int 面16 = 16;
    private static final int 面17 = 17;
    private static final int 面18 = 18;
    private static final int 面19 = 19;
    private static final int 面20 = 20;
    private static final int 面21 = 21;

    public LabelSealSelectDialogHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * コンストラクタです。
     *
     * @param div LabelSealSelectDialogDiv
     */
    public LabelSealSelectDialogHandler(LabelSealSelectDialogDiv div) {
        this.div = div;
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    /**
     * 帳票出力の処理です。
     *
     * @param model LabelSealSelectDialogModel
     * @return ResponseData
     */
    public ResponseData<LabelSealSelectDialogDiv> print(LabelSealSelectDialogModel model) {
        ILabelSealPrintTaishoDiv 印刷指示Div = div.getCcdLabelSealPrintTaisho();
        if (印刷指示Div.isChkFuzaishaTohyoShomeishoDisplay() && 印刷指示Div.isCheckedFuzaishaTohyoShomeisho()) {
            print不在者投票証明書12号様式(model);
        }
        if (印刷指示Div.isChkSenseishoDisplay() && 印刷指示Div.isCheckedSenseisho()) {
            print宣誓書(model);
        }
        List<RString> シール種別リスト = 印刷指示Div.getシール種別リスト();
        if (!シール種別リスト.isEmpty()) {
            for (int index = 0; index < シール種別リスト.size(); index++) {
                printラベルシール(model, シール種別リスト.get(index));
            }
        }

        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 不在者投票証明書12号様式帳票の処理です。
     *
     * @param model LabelSealSelectDialogModel
     */
    private void print不在者投票証明書12号様式(LabelSealSelectDialogModel model) {
        List<KijitsumaeTohyoChohyoData> 帳票データs = model.getShoriTaishoJohoList();
        FuzaishaTohyoShomeishoPrintService printer = InstanceProvider.create(FuzaishaTohyoShomeishoPrintService.class);
        if (帳票データs != null && !帳票データs.isEmpty()) {
            for (KijitsumaeTohyoChohyoData 帳票データ : 帳票データs) {
                printer.print(createパラメータFor不在者投票証明書12号様式(帳票データ, model));
            }
        }
    }

    /**
     * パラメータFor不在者投票証明書12号様式帳票の処理です。
     *
     * @param 帳票データ KijitsumaeTohyoChohyoData
     * @param model LabelSealSelectDialogModel
     * @return SenseishoParam List
     */
    private List<SenseishoParam> createパラメータFor不在者投票証明書12号様式(KijitsumaeTohyoChohyoData 帳票データ, LabelSealSelectDialogModel model) {
        List<SenseishoParam> list = new ArrayList<>();
        if (null != 帳票データ) {
            TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();
            SenseishoParam para = new SenseishoParam(帳票データ.getEntity(),
                    帳票共通ヘッダー,
                    model.getKijitsumaeFuzaishaKubun().value(),
                    div.getCcdLabelSealPrintTaisho().isChkSenkyoDisplay() ? div.getCcdLabelSealPrintTaisho().get選挙リスト() : get選挙名称リスト(帳票データ));
            list.add(para);
        }
        return list;
    }

    /**
     * 宣誓書帳票の処理です。
     *
     * @param model LabelSealSelectDialogModel
     */
    private void print宣誓書(LabelSealSelectDialogModel model) {
        List<KijitsumaeTohyoChohyoData> 帳票データs = model.getShoriTaishoJohoList();
        SenseishoPrintService printer = InstanceProvider.create(SenseishoPrintService.class);
        if (帳票データs != null && !帳票データs.isEmpty()) {
            printer.print(createパラメータFor宣誓書(帳票データs, model));
        }
    }

    /**
     * パラメータFor宣誓書帳票の処理です。
     *
     * @param 帳票データs List<KijitsumaeTohyoChohyoData>
     * @param model LabelSealSelectDialogModel
     * @return
     */
    private List<SenseishoParam> createパラメータFor宣誓書(List<KijitsumaeTohyoChohyoData> 帳票データs, LabelSealSelectDialogModel model) {
        List<SenseishoParam> list = new ArrayList<>();
        if (帳票データs != null && !帳票データs.isEmpty()) {
            TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();
            for (KijitsumaeTohyoChohyoData 帳票データ : 帳票データs) {
                SenseishoParam para = new SenseishoParam(帳票データ.getEntity(),
                        帳票共通ヘッダー,
                        model.getKijitsumaeFuzaishaKubun().value(),
                        div.getCcdLabelSealPrintTaisho().isChkSenkyoDisplay() ? div.getCcdLabelSealPrintTaisho().get選挙リスト() : get選挙名称リスト(帳票データ));
                list.add(para);
            }
        }
        return list;
    }

    /**
     * ラベルシール帳票の処理です。
     *
     * @param model LabelSealSelectDialogModel
     * @param シール種別 RString
     */
    private void printラベルシール(LabelSealSelectDialogModel model, RString シール種別) {
        if (ZERO.equals(BusinessConfig.get(ConfigKeysAFA.ラベルシール_ラベルプリンタ使用有無, SubGyomuCode.AFA選挙本体))) {
            if (SealMensu.面数12.code().equals(BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体))) {
                print宛名シール用紙12面(model, シール種別);
            } else {
                print宛名シール用紙21面(model, シール種別);
            }
        } else {
            printラベルシール専用ラベル(model, シール種別);
        }

    }

    /**
     * 宛名シール用紙12面帳票の処理です。
     *
     * @param model LabelSealSelectDialogModel
     * @param シール種別 RString
     */
    private void print宛名シール用紙12面(LabelSealSelectDialogModel model, RString シール種別) {
        List<KijitsumaeTohyoChohyoData> 帳票データs = model.getShoriTaishoJohoList();

        LabelSealAtena12PrintService printer = InstanceProvider.create(LabelSealAtena12PrintService.class);
        if (帳票データs != null && !帳票データs.isEmpty()) {
            if (シール種別.equals(SealShubetsu.封筒貼付用.getシール種別())) {
                printer.print(createパラメータFor宛名シール用紙12面(帳票データs,
                        model, シール種別, div.getCcdLabelSealPrintTaisho().get選挙Indexリスト()));
            } else {
                List<KijitsumaeTohyoChohyoData> 帳票List = new ArrayList();
                for (int index = 0; index < get印刷枚数(シール種別); index++) {
                    帳票List.addAll(帳票データs);
                }
                printer.print(createパラメータFor宛名シール用紙12面(帳票List, model, シール種別, new ArrayList()));
            }

        }
    }

    /**
     * 宛名シール用紙21面帳票の処理です。
     *
     * @param model LabelSealSelectDialogModel
     * @param シール種別 RString
     */
    private void print宛名シール用紙21面(LabelSealSelectDialogModel model, RString シール種別) {
        List<KijitsumaeTohyoChohyoData> 帳票データs = model.getShoriTaishoJohoList();
        LabelSealAtena21PrintService printer = InstanceProvider.create(LabelSealAtena21PrintService.class);

        if (帳票データs != null && !帳票データs.isEmpty()) {
            if (シール種別.equals(SealShubetsu.封筒貼付用.getシール種別())) {
                printer.print(createパラメータFor宛名シール用紙21面(帳票データs,
                        model, シール種別, div.getCcdLabelSealPrintTaisho().get選挙Indexリスト()));
            } else {
                List<KijitsumaeTohyoChohyoData> 帳票List = new ArrayList();
                for (int index = 0; index < get印刷枚数(シール種別); index++) {
                    帳票List.addAll(帳票データs);
                }
                printer.print(createパラメータFor宛名シール用紙21面(帳票List, model, シール種別, new ArrayList()));
            }

        }
    }

    /**
     * パラメータFor宛名シール用紙12面帳票の処理です。
     *
     * @param 帳票データs List<KijitsumaeTohyoChohyoData>
     * @param model LabelSealSelectDialogModel
     * @param シール種別 RString
     * @param 選挙リストIndex int
     * @return List<LabelSealAtena12Param>
     */
    private List<LabelSealAtena12Param> createパラメータFor宛名シール用紙12面(
            List<KijitsumaeTohyoChohyoData> 帳票データs, LabelSealSelectDialogModel model, RString シール種別, List<RString> 選挙リスト) {

        List<LabelSealAtena12Param> param12List = new ArrayList();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体情報 = associationFinder.getAssociation();
        TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();
        int index = 0;

        int 開始印字位置dialog = 1;
        if (null != div.getCcdSealPosition()) {
            開始印字位置dialog = Integer.parseInt(((AtenaSealPositionGuideDiv) div
                    .getCcdSealPosition()).getTxtPosition().getValue().toString());
        }

        if (選挙リスト.isEmpty()) {
            for (KijitsumaeTohyoChohyoData 帳票データ : 帳票データs) {
                index = createパラメータFor宛名シール用紙12面without選挙リスト(帳票データ, model,
                        シール種別, index, 開始印字位置dialog, 地方公共団体情報, 帳票共通ヘッダー,
                        param12List);
            }
        } else {
            for (KijitsumaeTohyoChohyoData 帳票データ : 帳票データs) {
                index = createパラメータFor宛名シール用紙12面By選挙リスト(帳票データ, model,
                        シール種別, 選挙リスト, index, 開始印字位置dialog, 地方公共団体情報, 帳票共通ヘッダー,
                        param12List);
            }
        }

        return param12List;
    }

    private int createパラメータFor宛名シール用紙12面By選挙リスト(
            KijitsumaeTohyoChohyoData 帳票データ,
            LabelSealSelectDialogModel model, RString シール種別, List<RString> 選挙リスト, int index, int 開始印字位置dialog,
            Association 地方公共団体情報, TeijiCommonJohoItem 帳票共通ヘッダー,
            List<LabelSealAtena12Param> param12List) {

        int 印字位置dialog;

        LabelSealAtena12Param param12;
        if (!param12List.isEmpty()) {
            param12 = param12List.get(param12List.size() - 1);
        } else {
            param12 = new LabelSealAtena12Param(地方公共団体情報,
                    帳票共通ヘッダー);
        }

        for (RString 選挙index : 選挙リスト) {
            index++;
            if (index + 開始印字位置dialog - 1 <= 面12) {
                印字位置dialog = 開始印字位置dialog + index - 1;
            } else {
                印字位置dialog = (index + 開始印字位置dialog - 1) % 面12;
            }
            List<RString> 選挙マークリスト = get選挙マークリスト(帳票データ);
            List<RString> 施設種別コード名称リスト = get施設種別コード名称リスト(帳票データ);
            List<RString> 施設名称リスト = get施設名称リスト(帳票データ);
            LabelSealAtenaPartParam param = new LabelSealAtenaPartParam(帳票データ.getEntity(),
                    model.getKijitsumaeFuzaishaKubun().value(),
                    選挙マークリスト,
                    シール種別,
                    施設種別コード名称リスト,
                    施設名称リスト,
                    Integer.parseInt(選挙index.toString()));

            if (印字位置dialog == 開始印字位置dialog && index + 開始印字位置dialog - 1 <= 面12) {
                param12 = new LabelSealAtena12Param(地方公共団体情報,
                        帳票共通ヘッダー);
                param12List.add(param12);
            } else if (印字位置dialog == 面1) {
                param12 = new LabelSealAtena12Param(地方公共団体情報,
                        帳票共通ヘッダー);
                param12List.add(param12);
            }

            if (印字位置dialog == 面1) {
                param12.setParam1(param);
            } else if (印字位置dialog == 面2) {
                param12.setParam2(param);
            } else if (印字位置dialog == 面3) {
                param12.setParam3(param);
            } else if (印字位置dialog == 面4) {
                param12.setParam4(param);
            } else if (印字位置dialog == 面5) {
                param12.setParam5(param);
            } else if (印字位置dialog == 面6) {
                param12.setParam6(param);
            } else if (印字位置dialog == 面7) {
                param12.setParam7(param);
            } else if (印字位置dialog == 面8) {
                param12.setParam8(param);
            } else if (印字位置dialog == 面9) {
                param12.setParam9(param);
            } else if (印字位置dialog == 面10) {
                param12.setParam10(param);
            } else if (印字位置dialog == 面11) {
                param12.setParam11(param);
            } else if (印字位置dialog == 面12 || 印字位置dialog == 0) {
                param12.setParam12(param);
            }
        }

        return index;
    }

    private int createパラメータFor宛名シール用紙12面without選挙リスト(
            KijitsumaeTohyoChohyoData 帳票データ,
            LabelSealSelectDialogModel model, RString シール種別, int index, int 開始印字位置dialog,
            Association 地方公共団体情報, TeijiCommonJohoItem 帳票共通ヘッダー,
            List<LabelSealAtena12Param> param12List) {

        int 印字位置dialog;

        LabelSealAtena12Param param12;
        if (!param12List.isEmpty()) {
            param12 = param12List.get(param12List.size() - 1);
        } else {
            param12 = new LabelSealAtena12Param(地方公共団体情報,
                    帳票共通ヘッダー);
        }

        index++;
        if (index + 開始印字位置dialog - 1 <= 面12) {
            印字位置dialog = 開始印字位置dialog + index - 1;
        } else {
            印字位置dialog = (index + 開始印字位置dialog - 1) % 面12;
        }
        List<RString> 選挙マークリスト = get選挙マークリスト(帳票データ);
        List<RString> 施設種別コード名称リスト = get施設種別コード名称リスト(帳票データ);
        List<RString> 施設名称リスト = get施設名称リスト(帳票データ);
        LabelSealAtenaPartParam param = new LabelSealAtenaPartParam(帳票データ.getEntity(),
                model.getKijitsumaeFuzaishaKubun().value(),
                選挙マークリスト,
                シール種別,
                施設種別コード名称リスト,
                施設名称リスト,
                0);

        if (印字位置dialog == 開始印字位置dialog && index + 開始印字位置dialog - 1 <= 面12) {
            param12 = new LabelSealAtena12Param(地方公共団体情報,
                    帳票共通ヘッダー);
            param12List.add(param12);
        } else if (印字位置dialog == 面1) {
            param12 = new LabelSealAtena12Param(地方公共団体情報,
                    帳票共通ヘッダー);
            param12List.add(param12);
        }

        if (印字位置dialog == 面1) {
            param12.setParam1(param);
        } else if (印字位置dialog == 面2) {
            param12.setParam2(param);
        } else if (印字位置dialog == 面3) {
            param12.setParam3(param);
        } else if (印字位置dialog == 面4) {
            param12.setParam4(param);
        } else if (印字位置dialog == 面5) {
            param12.setParam5(param);
        } else if (印字位置dialog == 面6) {
            param12.setParam6(param);
        } else if (印字位置dialog == 面7) {
            param12.setParam7(param);
        } else if (印字位置dialog == 面8) {
            param12.setParam8(param);
        } else if (印字位置dialog == 面9) {
            param12.setParam9(param);
        } else if (印字位置dialog == 面10) {
            param12.setParam10(param);
        } else if (印字位置dialog == 面11) {
            param12.setParam11(param);
        } else if (印字位置dialog == 面12 || 印字位置dialog == 0) {
            param12.setParam12(param);
        }

        return index;
    }

    /**
     * パラメータFor宛名シール用紙21面帳票の処理です。
     *
     * @param 帳票データs List<KijitsumaeTohyoChohyoData>
     * @param model LabelSealSelectDialogModel
     * @param シール種別 RString
     * @param 選挙リストIndex int
     * @return List<LabelSealAtena21Param>
     */
    private List<LabelSealAtena21Param> createパラメータFor宛名シール用紙21面(
            List<KijitsumaeTohyoChohyoData> 帳票データs, LabelSealSelectDialogModel model, RString シール種別,
            List<RString> 選挙リスト) {
        List<LabelSealAtena21Param> param21List = new ArrayList();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体情報 = associationFinder.getAssociation();
        TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();
        int index = 0;

        int 開始印字位置dialog = 1;
        if (null != div.getCcdSealPosition()) {
            開始印字位置dialog = Integer.parseInt(((AtenaSealPositionGuideDiv) div
                    .getCcdSealPosition()).getTxtPosition().getValue().toString());
        }

        if (選挙リスト.isEmpty()) {
            for (KijitsumaeTohyoChohyoData 帳票データ : 帳票データs) {
                index = createパラメータFor宛名シール用紙21面without選挙リスト(帳票データ, model,
                        シール種別, index, 開始印字位置dialog, 地方公共団体情報, 帳票共通ヘッダー,
                        param21List);
            }
        } else {
            for (KijitsumaeTohyoChohyoData 帳票データ : 帳票データs) {
                index = createパラメータFor宛名シール用紙21面By選挙リスト(帳票データ, model,
                        シール種別, 選挙リスト, index, 開始印字位置dialog, 地方公共団体情報, 帳票共通ヘッダー,
                        param21List);
            }
        }

        return param21List;
    }

    private int createパラメータFor宛名シール用紙21面By選挙リスト(
            KijitsumaeTohyoChohyoData 帳票データ,
            LabelSealSelectDialogModel model, RString シール種別, List<RString> 選挙リスト, int index, int 開始印字位置dialog,
            Association 地方公共団体情報, TeijiCommonJohoItem 帳票共通ヘッダー,
            List<LabelSealAtena21Param> param21List) {
        int 印字位置dialog;
        LabelSealAtena21Param param21;
        if (!param21List.isEmpty()) {
            param21 = param21List.get(param21List.size() - 1);
        } else {
            param21 = new LabelSealAtena21Param(地方公共団体情報,
                    帳票共通ヘッダー);
        }

        for (RString 選挙index : 選挙リスト) {
            index++;
            if (index + 開始印字位置dialog - 1 <= 面21) {
                印字位置dialog = 開始印字位置dialog + index - 1;
            } else {
                印字位置dialog = (index + 開始印字位置dialog - 1) % 面21;
            }
            List<RString> 選挙マークリスト = get選挙マークリスト(帳票データ);
            List<RString> 施設種別コード名称リスト = get施設種別コード名称リスト(帳票データ);
            List<RString> 施設名称リスト = get施設名称リスト(帳票データ);
            LabelSealAtenaPartParam param = new LabelSealAtenaPartParam(帳票データ.getEntity(),
                    model.getKijitsumaeFuzaishaKubun().value(),
                    選挙マークリスト,
                    シール種別,
                    施設種別コード名称リスト,
                    施設名称リスト,
                    Integer.parseInt(選挙index.toString()));

            if (印字位置dialog == 開始印字位置dialog && index + 開始印字位置dialog - 1 <= 面21) {
                param21 = new LabelSealAtena21Param(地方公共団体情報,
                        帳票共通ヘッダー);
                param21List.add(param21);
            } else if (印字位置dialog == 面1) {
                param21 = new LabelSealAtena21Param(地方公共団体情報,
                        帳票共通ヘッダー);
                param21List.add(param21);
            }

            param21データ準備1(param21, param, 印字位置dialog);
            param21データ準備2(param21, param, 印字位置dialog);
        }

        return index;
    }

    private int createパラメータFor宛名シール用紙21面without選挙リスト(
            KijitsumaeTohyoChohyoData 帳票データ,
            LabelSealSelectDialogModel model, RString シール種別, int index, int 開始印字位置dialog,
            Association 地方公共団体情報, TeijiCommonJohoItem 帳票共通ヘッダー,
            List<LabelSealAtena21Param> param21List) {
        int 印字位置dialog;

        LabelSealAtena21Param param21;
        if (!param21List.isEmpty()) {
            param21 = param21List.get(param21List.size() - 1);
        } else {
            param21 = new LabelSealAtena21Param(地方公共団体情報,
                    帳票共通ヘッダー);
        }

        index++;
        if (index + 開始印字位置dialog - 1 <= 面21) {
            印字位置dialog = 開始印字位置dialog + index - 1;
        } else {
            印字位置dialog = (index + 開始印字位置dialog - 1) % 面21;
        }
        List<RString> 選挙マークリスト = get選挙マークリスト(帳票データ);
        List<RString> 施設種別コード名称リスト = get施設種別コード名称リスト(帳票データ);
        List<RString> 施設名称リスト = get施設名称リスト(帳票データ);
        LabelSealAtenaPartParam param = new LabelSealAtenaPartParam(帳票データ.getEntity(),
                model.getKijitsumaeFuzaishaKubun().value(),
                選挙マークリスト,
                シール種別,
                施設種別コード名称リスト,
                施設名称リスト,
                0);

        if (印字位置dialog == 開始印字位置dialog && index + 開始印字位置dialog - 1 <= 面21) {
            param21 = new LabelSealAtena21Param(地方公共団体情報,
                    帳票共通ヘッダー);
            param21List.add(param21);
        } else if (印字位置dialog == 面1) {
            param21 = new LabelSealAtena21Param(地方公共団体情報,
                    帳票共通ヘッダー);
            param21List.add(param21);
        }

        param21データ準備1(param21, param, 印字位置dialog);
        param21データ準備2(param21, param, 印字位置dialog);

        return index;
    }

    private void param21データ準備1(LabelSealAtena21Param param21, LabelSealAtenaPartParam param, int 印字位置dialog) {
        if (印字位置dialog == 面1) {
            param21.setParam1(param);
        } else if (印字位置dialog == 面2) {
            param21.setParam2(param);
        } else if (印字位置dialog == 面3) {
            param21.setParam3(param);
        } else if (印字位置dialog == 面4) {
            param21.setParam4(param);
        } else if (印字位置dialog == 面5) {
            param21.setParam5(param);
        } else if (印字位置dialog == 面6) {
            param21.setParam6(param);
        } else if (印字位置dialog == 面7) {
            param21.setParam7(param);
        } else if (印字位置dialog == 面8) {
            param21.setParam8(param);
        } else if (印字位置dialog == 面9) {
            param21.setParam9(param);
        } else if (印字位置dialog == 面10) {
            param21.setParam10(param);
        }
    }

    private void param21データ準備2(LabelSealAtena21Param param21, LabelSealAtenaPartParam param, int 印字位置dialog) {
        if (印字位置dialog == 面11) {
            param21.setParam11(param);
        } else if (印字位置dialog == 面12) {
            param21.setParam12(param);
        } else if (印字位置dialog == 面13) {
            param21.setParam13(param);
        } else if (印字位置dialog == 面14) {
            param21.setParam14(param);
        } else if (印字位置dialog == 面15) {
            param21.setParam15(param);
        } else if (印字位置dialog == 面16) {
            param21.setParam16(param);
        } else if (印字位置dialog == 面17) {
            param21.setParam17(param);
        } else if (印字位置dialog == 面18) {
            param21.setParam18(param);
        } else if (印字位置dialog == 面19) {
            param21.setParam19(param);
        } else if (印字位置dialog == 面20) {
            param21.setParam20(param);
        } else if (印字位置dialog == 面21 || 印字位置dialog == 0) {
            param21.setParam21(param);
        }
    }

    /**
     * ラベルシール専用ラベル帳票の処理です。
     *
     * @param model LabelSealSelectDialogModel
     * @param シール種別 RString
     */
    private void printラベルシール専用ラベル(LabelSealSelectDialogModel model, RString シール種別) {
        List<KijitsumaeTohyoChohyoData> 帳票データs = model.getShoriTaishoJohoList();
        LabelSealPrintService printer = InstanceProvider.create(LabelSealPrintService.class);
        if (帳票データs != null && !帳票データs.isEmpty()) {
            if (シール種別.equals(SealShubetsu.封筒貼付用.getシール種別())) {
                printer.print(createパラメータForラベルシール専用ラベル(帳票データs,
                        model, シール種別, div.getCcdLabelSealPrintTaisho().get選挙Indexリスト()));
            } else {
                List<KijitsumaeTohyoChohyoData> 帳票List = new ArrayList();
                for (int index = 0; index < get印刷枚数(シール種別); index++) {
                    帳票List.addAll(帳票データs);
                }

                printer.print(createパラメータForラベルシール専用ラベル(帳票List, model, シール種別, new ArrayList()));

            }
        }
    }

    /**
     * 印刷枚数を取得の処理です。
     *
     * @param model LabelSealSelectDialogModel
     * @param シール種別 RString
     * @return int
     */
    private int get印刷枚数(RString シール種別) {
        int 印刷枚数 = 1;
        if (シール種別.equals(SealShubetsu.宣誓書貼付用.getシール種別())) {
            印刷枚数 = div.getCcdLabelSealPrintTaisho().get宣誓書貼付用の印刷枚数();
        }
        if (シール種別.equals(SealShubetsu.抄本貼付用.getシール種別())) {
            印刷枚数 = div.getCcdLabelSealPrintTaisho().get抄本貼付用の印刷枚数();
        }
        if (シール種別.equals(SealShubetsu.入場券貼付用.getシール種別())) {
            印刷枚数 = div.getCcdLabelSealPrintTaisho().get入場券貼付用の印刷枚数();
        }
        return 印刷枚数;
    }

    private List<LabelSealParam> createパラメータForラベルシール専用ラベル(List<KijitsumaeTohyoChohyoData> 帳票データs,
            LabelSealSelectDialogModel model,
            RString シール種別,
            List<RString> 選挙リスト) {
        List<LabelSealParam> list = new ArrayList();
        TeijiCommonJohoItem 帳票共通ヘッダー = create帳票共通ヘッダー();
        RString 期日前不在者区分 = model.getKijitsumaeFuzaishaKubun().value();
        if (選挙リスト.isEmpty()) {
            for (KijitsumaeTohyoChohyoData 帳票データ : 帳票データs) {
                List<RString> 選挙マークリスト = get選挙マークリスト(帳票データ);
                List<RString> 施設種別コード名称リスト = get施設種別コード名称リスト(帳票データ);
                List<RString> 施設名称リスト = get施設名称リスト(帳票データ);
                LabelSealParam param = new LabelSealParam(帳票データ.getEntity(),
                        帳票共通ヘッダー,
                        期日前不在者区分,
                        選挙マークリスト,
                        シール種別,
                        施設種別コード名称リスト,
                        施設名称リスト,
                        0);
                list.add(param);
            }
        } else {
            for (KijitsumaeTohyoChohyoData 帳票データ : 帳票データs) {
                for (RString 選挙index : 選挙リスト) {
                    List<RString> 選挙マークリスト = get選挙マークリスト(帳票データ);
                    List<RString> 施設種別コード名称リスト = get施設種別コード名称リスト(帳票データ);
                    List<RString> 施設名称リスト = get施設名称リスト(帳票データ);
                    LabelSealParam param = new LabelSealParam(帳票データ.getEntity(),
                            帳票共通ヘッダー,
                            期日前不在者区分,
                            選挙マークリスト,
                            シール種別,
                            施設種別コード名称リスト,
                            施設名称リスト,
                            Integer.parseInt(選挙index.toString()));
                    list.add(param);
                }
            }
        }

        return list;
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        return new TeijiCommonJohoItem(get市町村名(), get市町村コード(), get作成日時());

    }

    private RString get市町村名() {
        return association.get市町村名();
    }

    private RString get作成日時() {
        return getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分));
    }

    private RString get市町村コード() {
        return association.getLasdecCode_().value();
    }

    private List<RString> get選挙名称リスト(KijitsumaeTohyoChohyoData 帳票データ) {
        LabelSealSelectDialog service = new LabelSealSelectDialog(帳票データ);
        return service.get選挙名称リスト();
    }

    private List<RString> get選挙マークリスト(KijitsumaeTohyoChohyoData 帳票データ) {
        LabelSealSelectDialog service = new LabelSealSelectDialog(帳票データ);
        return service.get選挙マークリスト();
    }

    private List<RString> get施設種別コード名称リスト(KijitsumaeTohyoChohyoData 帳票データ) {
        LabelSealSelectDialog business = new LabelSealSelectDialog(帳票データ);
        List<RString> 施設コードリスト = business.get施設コードリスト();
        ShisetsuManager manager = ShisetsuManager.createInstance();
        List<RString> 施設種別コード名称リスト = new ArrayList<>();
        for (RString 施設コード : 施設コードリスト) {
            Shisetsu 施設 = manager.get施設By施設コード(施設コード);
            施設種別コード名称リスト.add(施設 == null ? RString.EMPTY : new ShisetsuShubetsu(施設.get施設種別()).getMeisho());
        }
        return 施設種別コード名称リスト;
    }

    private List<RString> get施設名称リスト(KijitsumaeTohyoChohyoData 帳票データ) {
        LabelSealSelectDialog business = new LabelSealSelectDialog(帳票データ);
        List<RString> 施設コードリスト = business.get施設コードリスト();
        ShisetsuManager manager = ShisetsuManager.createInstance();
        List<RString> 施設名称リスト = new ArrayList<>();
        for (RString 施設コード : 施設コードリスト) {
            Shisetsu 施設 = manager.get施設By施設コード(施設コード);
            施設名称リスト.add(施設 == null ? RString.EMPTY : 施設.get施設名称());
        }
        return 施設名称リスト;
    }

}
