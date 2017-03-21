/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB300.MeiboShohonZaigaiParameter;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.CommonConstant;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 在外選挙人名簿抄本のクラスです。
 *
 * @reamsid_L AF-0030-035 xiaoj
 */
public class MeiboShohonZaigaiReportProcessCore {

    private static final ReportId REPORT_ID = new ReportId(ReportIdKeys.在外選挙人名簿抄本.value());
    private static final RString SEPARATOR = new RString(" ＞ ");
    private static final RString グループコード = new RString("グループコード");
    private static final RString 投票区コード = new RString("投票区コード");
    private static final RString 領事官コード = new RString("領事官コード");
    private static final RString 国籍コード = new RString("国籍コード");
    private static final RString 冊 = new RString("冊");
    private static final int 帳票最大行 = 25;
    private static final RString 出力区分 = new RString("データ");

    private ShikakuHantei shikakuHantei;
    private int itemCout;
    private int page;
    private Decimal totalPage;
    private int ページ計男;
    private int ページ計女;
    private Decimal 計１男;
    private Decimal 計１女;
    private Decimal 計２男;
    private Decimal 計２女;
    private Decimal 計３男;
    private Decimal 計３女;
    private Decimal 計４男;
    private Decimal 計４女;
    private final List<RString> 出力順ID;
    private final int 最大印字行;
    private final AFABTB101SelectProcessParameter parameter;
    private final Association association;

    /**
     * コンストラクタです。
     *
     * @param parameter AFABTB101SelectProcessParameter
     */
    public MeiboShohonZaigaiReportProcessCore(AFABTB101SelectProcessParameter parameter) {
        itemCout = 0;
        page = 1;
        totalPage = Decimal.ONE;
        ページ計男 = 0;
        ページ計女 = 0;
        計１男 = Decimal.ZERO;
        計１女 = Decimal.ZERO;
        計２男 = Decimal.ZERO;
        計２女 = Decimal.ZERO;
        計３男 = Decimal.ZERO;
        計３女 = Decimal.ZERO;
        計４男 = Decimal.ZERO;
        計４女 = Decimal.ZERO;
        出力順ID = get出力順List();
        最大印字行 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_在外_ページ行数, SubGyomuCode.AFA選挙本体).toString());
        this.parameter = parameter;
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        association = associationFinder.getAssociation();
        shikakuHantei = new ShikakuHantei();
    }

    /**
     * キーブレイク判定、キーブレイクした場合の処理、集計値の初期化を実施する。
     *
     * @param before SenkyoMeiboShohonEntity
     * @param current SenkyoMeiboShohonEntity
     * @return 在外選挙人名簿抄本のパラメタ
     */
    public MeiboShohonZaigaiParameter keyBreakProcess(SenkyoMeiboShohonEntity before, SenkyoMeiboShohonEntity current) {
        boolean isキー4Break = isBreak集計項目4(before, current);
        boolean isキー3Break = isBreak集計項目3(before, current);
        boolean isキー2Break = isBreak集計項目2(before, current);
        boolean isキー1Break = isBreak集計項目1(before, current);
        if (isキー1Break) {
            isキー2Break = true;
            isキー3Break = true;
            isキー4Break = true;
        } else if (isキー2Break) {
            isキー3Break = true;
            isキー4Break = true;
        } else if (isキー3Break) {
            isキー4Break = true;
        }
        if (出力順ID.size() == CommonConstant.キー3) {
            isキー4Break = false;
        } else if (出力順ID.size() == 2) {
            isキー4Break = false;
            isキー3Break = false;
        } else if (出力順ID.size() == 1) {
            isキー4Break = false;
            isキー3Break = false;
            isキー2Break = false;
        }
        MeiboShohonZaigaiParameter param = new MeiboShohonZaigaiParameter(before,
                出力区分, new RString(String.valueOf(page)),
                new RString(String.valueOf(totalPage)), association, 出力順ID,
                isキー1Break, isキー2Break, isキー3Break, isキー4Break, ページ計男, ページ計女,
                計１男, 計１女, 計２男, 計２女, 計３男,
                計３女, 計４男, 計４女);
        itemCout++;
        set集計情報(isキー1Break, isキー2Break, isキー3Break, isキー4Break);
        return param;
    }

    /**
     * 主に加算処理を実施する。
     *
     * @param current SenkyoMeiboShohonEntity
     */
    public void usualProcess(SenkyoMeiboShohonEntity current) {
        if (isCount(current)) {
            if (NullHandler.getNullToRString(current.getAtenaPSMEntity().getSeibetsuCode()).equals(new RString("1"))) {
                ページ計男++;
                計１男 = 計１男.add(1);
                計２男 = 計２男.add(1);
                計３男 = 計３男.add(1);
                計４男 = 計４男.add(1);
            }
            if (NullHandler.getNullToRString(current.getAtenaPSMEntity().getSeibetsuCode()).equals(new RString("2"))) {
                ページ計女++;
                計１女 = 計１女.add(1);
                計２女 = 計２女.add(1);
                計３女 = 計３女.add(1);
                計４女 = 計４女.add(1);
            }
        }
    }

    /**
     * 最後行を集計値設定して戻ります。
     *
     * @param before SenkyoMeiboShohonEntity
     * @return 在外選挙人名簿抄本のパラメタ
     */
    public MeiboShohonZaigaiParameter getLastLow(SenkyoMeiboShohonEntity before) {
        boolean isキー4Break = false;
        boolean isキー3Break = false;
        boolean isキー2Break = false;
        boolean isキー1Break = false;
        if (出力順ID.size() >= CommonConstant.キー4) {
            isキー4Break = true;
            isキー3Break = true;
            isキー2Break = true;
            isキー1Break = true;
        } else if (出力順ID.size() >= CommonConstant.キー3) {
            isキー3Break = true;
            isキー2Break = true;
            isキー1Break = true;
        } else if (出力順ID.size() >= 2) {
            isキー2Break = true;
            isキー1Break = true;
        } else if (出力順ID.size() >= 1) {
            isキー1Break = true;
        }
        return new MeiboShohonZaigaiParameter(before,
                出力区分, new RString(String.valueOf(page)),
                new RString(String.valueOf(totalPage)), association, 出力順ID,
                isキー1Break, isキー2Break, isキー3Break, isキー4Break, ページ計男, ページ計女,
                計１男, 計１女, 計２男, 計２女, 計３男,
                計３女, 計４男, 計４女);
    }

    private void set集計情報(boolean isキー1Break, boolean isキー2Break, boolean isキー3Break, boolean isキー4Break) {
        if (itemCout == (最大印字行 > 帳票最大行 ? 帳票最大行 : 最大印字行)) {
            pageBreak();
        }
        if (isキー1Break) {
            計１男 = Decimal.ZERO;
            計１女 = Decimal.ZERO;
            計２男 = Decimal.ZERO;
            計２女 = Decimal.ZERO;
            計３男 = Decimal.ZERO;
            計３女 = Decimal.ZERO;
            計４男 = Decimal.ZERO;
            計４女 = Decimal.ZERO;
            pageBreak();
            page = 1;
        } else if (isキー2Break) {
            計２男 = Decimal.ZERO;
            計２女 = Decimal.ZERO;
            計３男 = Decimal.ZERO;
            計３女 = Decimal.ZERO;
            計４男 = Decimal.ZERO;
            計４女 = Decimal.ZERO;
            pageBreak();
        } else if (isキー3Break) {
            計３男 = Decimal.ZERO;
            計３女 = Decimal.ZERO;
            計４男 = Decimal.ZERO;
            計４女 = Decimal.ZERO;
            pageBreak();
        } else if (isキー4Break) {
            計４男 = Decimal.ZERO;
            計４女 = Decimal.ZERO;
            pageBreak();
        }
    }

    private void pageBreak() {
        totalPage = totalPage.add(1);
        page++;
        itemCout = 0;
        ページ計男 = 0;
        ページ計女 = 0;
    }

    private Boolean isBreak集計項目4(SenkyoMeiboShohonEntity before, SenkyoMeiboShohonEntity current) {
        return 出力順ID.size() >= CommonConstant.キー4 && !this.get集計項目(出力順ID.get(CommonConstant.キー3), before)
                .equals(this.get集計項目(出力順ID.get(CommonConstant.キー3), current));
    }

    private Boolean isBreak集計項目3(SenkyoMeiboShohonEntity before, SenkyoMeiboShohonEntity current) {
        return 出力順ID.size() >= CommonConstant.キー3
                && !this.get集計項目(出力順ID.get(2), before).equals(this.get集計項目(出力順ID.get(2), current));
    }

    private Boolean isBreak集計項目2(SenkyoMeiboShohonEntity before, SenkyoMeiboShohonEntity current) {
        return 出力順ID.size() >= 2
                && !this.get集計項目(出力順ID.get(1), before).equals(this.get集計項目(出力順ID.get(1), current));
    }

    private Boolean isBreak集計項目1(SenkyoMeiboShohonEntity before, SenkyoMeiboShohonEntity current) {
        return 出力順ID.size() >= 1
                && !this.get集計項目(出力順ID.get(0), before).equals(this.get集計項目(出力順ID.get(0), current));
    }

    private Boolean isCount(SenkyoMeiboShohonEntity entity) {
        if (!NullHandler.getNullToRString(entity.getZaigaiSenkyoShikakuEntity().getMasshoJiyuCode()).isEmpty()
                && !NullHandler.getNullToRString(entity.getZaigaiSenkyoShikakuEntity().getMasshoJiyuCode()).equals(JiyuCode.二重登録.getKey())) {
            return false;
        }
        SenkyoninTohyoJokyoEntity jokyoEntity = new SenkyoninTohyoJokyoEntity();
        jokyoEntity.setAtenaPSMEntity(entity.getAtenaPSMEntity());
        jokyoEntity.setZaigaiSenkyoShikakuEntity(entity.getZaigaiSenkyoShikakuEntity());
        if (shikakuHantei.is転出4ヶ月抹消予定者_日付指定(jokyoEntity, parameter.getKijunbi())) {
            return false;
        }
        if (NullHandler.getNullToRString(entity.getZaigaiSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.公民権停止.value())) {
            return false;
        }
        return !RString.isNullOrEmpty(entity.getAtenaPSMEntity().getSeibetsuCode());
    }

    private RString get集計項目(RString 集計キー, SenkyoMeiboShohonEntity entity) {
        if (グループコード.equals(集計キー)) {
            return entity.getZaigaiSenkyoninMeiboEntity().getGroupCode();
        } else if (投票区コード.equals(集計キー)) {
            return entity.getZaigaiSenkyoninMeiboEntity().getTohyokuCode();
        } else if (領事官コード.equals(集計キー)) {
            return entity.getZaigaiSenkyoninShinseiEntity().getRyojikanCode();
        } else if (国籍コード.equals(集計キー)) {
            return entity.getZaigaiSenkyoninShinseiEntity().getKokusekiCode();
        } else if (冊.equals(集計キー)) {
            return entity.getZaigaiSenkyoninMeiboEntity().getSatsu();
        }
        return RString.EMPTY;
    }

    private List<RString> get出力順List() {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 帳票出力順 = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, REPORT_ID);
        List<RString> 出力順List = new ArrayList<>();
        for (IOutputOrder order : 帳票出力順) {
            出力順List.addAll(order.getFormated集計項目().split(SEPARATOR.toString()));
        }
        return 出力順List;
    }
}
