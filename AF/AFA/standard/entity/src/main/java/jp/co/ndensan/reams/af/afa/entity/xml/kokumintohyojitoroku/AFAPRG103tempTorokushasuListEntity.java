/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.kokumintohyojitoroku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 登録者数リストの一時テーブル検索用entityクラスです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFAPRG103tempTorokushasuListEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(2)
    private RString seibetsuCode;
    @TempTableColumnOrder(3)
    private SenkyoNo senkyoNo;
    @TempTableColumnOrder(4)
    private RString tohyokuCode;
    @TempTableColumnOrder(5)
    private RString orderCode;
    @TempTableColumnOrder(6)
    private boolean ichigoShikakuKubun;
    @TempTableColumnOrder(7)
    private boolean nigoShikakuKubun;
    @TempTableColumnOrder(8)
    private RString tohyokuMeisho;
    @TempTableColumnOrder(9)
    private FlexibleDate kijunYMD;
    @TempTableColumnOrder(10)
    private FlexibleDate tohyoYMD;
    @TempTableColumnOrder(11)
    private RString senkyoName;
}
