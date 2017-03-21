/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.BigSerial;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 海区漁業調整委員会委員選挙人名簿最新化する。<br/>
 * 選挙人名簿temp。
 *
 * @reamsid_L AF-0480-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TempSenkyoninMeiboEntity extends DbTableEntityBase<TempSenkyoninMeiboEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private ShohonNo shohonNo;
    @TempTableColumnOrder(2)
    private RString groupCode;
    @TempTableColumnOrder(3)
    private RString tohyokuCode;
    @TempTableColumnOrder(4)
    private RString satsu;
    @TempTableColumnOrder(5)
    private int page;
    @TempTableColumnOrder(6)
    private int gyo;
    @TempTableColumnOrder(7)
    private BigSerial seq;
    @TempTableColumnOrder(8)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(9)
    private boolean tohyokuHenkoMasshoFlag;
    @TempTableColumnOrder(10)
    private int renban;
    @TempTableColumnOrder(11)
    private int edaban;

}
