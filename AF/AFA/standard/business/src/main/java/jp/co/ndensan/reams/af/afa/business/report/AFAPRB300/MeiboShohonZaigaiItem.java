/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB300;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA100.TotalParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 在外選挙人名簿抄本のパラメタです。
 *
 * @reamsid_L AF-0030-035 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class MeiboShohonZaigaiItem {

    private SenkyoninTohyoJokyoEntity entity;
    private RString 在外選挙人国内住所;
    private RString 領事官名称;
    private RString 投票区名称;
    private RString 出力区分;
    private RString page;
    private RString totalPage;
    private Association 導入団体;
    private List<RString> 出力順List;
    private List<Integer> pageCountList;
    private TotalParameter 集計List1;
    private TotalParameter 集計List2;
    private TotalParameter 集計List3;
    private TotalParameter 集計List4;

    /**
     * コンストラクタです。
     *
     * @param entity SenkyoninTohyoJokyoEntity
     * @param 在外選挙人国内住所 RString
     * @param 領事官名称 RString
     * @param 投票区名称 RString
     * @param 出力区分 RString
     * @param page RString
     * @param totalPage RString
     * @param 導入団体 Association
     * @param 出力順List List<RString>
     */
    public MeiboShohonZaigaiItem(SenkyoninTohyoJokyoEntity entity, RString 在外選挙人国内住所, RString 領事官名称, RString 投票区名称,
            RString 出力区分, RString page, RString totalPage, Association 導入団体, List<RString> 出力順List) {
        this.entity = entity;
        this.在外選挙人国内住所 = 在外選挙人国内住所;
        this.領事官名称 = 領事官名称;
        this.投票区名称 = 投票区名称;
        this.出力区分 = 出力区分;
        this.page = page;
        this.totalPage = totalPage;
        this.導入団体 = 導入団体;
        this.出力順List = 出力順List;
    }
}
