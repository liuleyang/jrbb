/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.meibosakuseikaiku;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * csvファイルの一時テーブル作成用entityクラスです。
 *
 * @reamsid_L AF-0460-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TempCsvMeiboEntity extends DbTableEntityBase<TempCsvMeiboEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(2)
    private RString tohyokuCode;
    @TempTableColumnOrder(3)
    private YubinNo yubinNo;
    @TempTableColumnOrder(4)
    private AtenaJusho jusho;
    @TempTableColumnOrder(5)
    private AtenaMeisho kanjiShimei;
    @TempTableColumnOrder(6)
    private AtenaKanaMeisho kanaShimei;
    @TempTableColumnOrder(7)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(8)
    private RString seibetsuCode;
    @TempTableColumnOrder(9)
    private RString gyogyoshaNo;
    @TempTableColumnOrder(10)
    private RString kumiaiCode;
    @TempTableColumnOrder(11)
    private int nissuGyogyosha;
    @TempTableColumnOrder(12)
    private int nissuJujisha;
    @TempTableColumnOrder(13)
    private RString gyogyoShurui;
    @TempTableColumnOrder(14)
    private RString gyosenShubetsu;
    @TempTableColumnOrder(15)
    private RString senmei;
    @TempTableColumnOrder(16)
    private RString torokuNo;
}
