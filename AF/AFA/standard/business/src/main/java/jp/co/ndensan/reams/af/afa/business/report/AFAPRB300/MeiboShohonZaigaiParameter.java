/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB300;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 在外選挙人名簿抄本のパラメタです。
 *
 * @reamsid_L AF-0030-035 xiaoj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class MeiboShohonZaigaiParameter {

    private final SenkyoMeiboShohonEntity entity;
    private final RString 出力区分;
    private final RString page;
    private final RString totalPage;
    private final Association 導入団体;
    private final List<RString> 出力順List;
    private final boolean 集計1出力フラグ;
    private final boolean 集計2出力フラグ;
    private final boolean 集計3出力フラグ;
    private final boolean 集計4出力フラグ;
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

    /**
     * コンストラクタです。
     *
     * @param entity SenkyoninTohyoJokyoEntity
     * @param 出力区分 RString
     * @param page RString
     * @param totalPage RString
     * @param 導入団体 Association
     * @param 出力順List List<RString>
     * @param 集計1出力フラグ 集計1出力フラグ
     * @param 集計2出力フラグ 集計2出力フラグ
     * @param 集計3出力フラグ 集計3出力フラグ
     * @param 集計4出力フラグ 集計4出力フラグ
     * @param ページ計男 ページ計男
     * @param ページ計女 ページ計女
     * @param 計１男 計１男
     * @param 計１女 計１女
     * @param 計２男 計２男
     * @param 計２女 計２女
     * @param 計３男 計３男
     * @param 計３女 計３女
     * @param 計４男 計４男
     * @param 計４女 計４女
     */
    public MeiboShohonZaigaiParameter(SenkyoMeiboShohonEntity entity,
            RString 出力区分, RString page, RString totalPage, Association 導入団体, List<RString> 出力順List,
            boolean 集計1出力フラグ, boolean 集計2出力フラグ, boolean 集計3出力フラグ, boolean 集計4出力フラグ, int ページ計男,
            int ページ計女, Decimal 計１男, Decimal 計１女, Decimal 計２男, Decimal 計２女,
            Decimal 計３男, Decimal 計３女, Decimal 計４男, Decimal 計４女) {
        this.entity = entity;
        this.出力区分 = 出力区分;
        this.page = page;
        this.totalPage = totalPage;
        this.導入団体 = 導入団体;
        this.出力順List = 出力順List;
        this.集計1出力フラグ = 集計1出力フラグ;
        this.集計2出力フラグ = 集計2出力フラグ;
        this.集計3出力フラグ = 集計3出力フラグ;
        this.集計4出力フラグ = 集計4出力フラグ;
        this.ページ計男 = ページ計男;
        this.ページ計女 = ページ計女;
        this.計１男 = 計１男;
        this.計１女 = 計１女;
        this.計２男 = 計２男;
        this.計２女 = 計２女;
        this.計３男 = 計３男;
        this.計３女 = 計３女;
        this.計４男 = 計４男;
        this.計４女 = 計４女;
    }
}
