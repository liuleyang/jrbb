/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA107;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帰化対象者リストのパラメータクラスです。
 *
 * @reamsid_L AF-0010-041 xiaoj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KikaTaishoshaListParameter {

    private SenkyoMeiboShohonEntity 選挙人資格の情報;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    private RString 出力区分;
    private RString 集計;
}
