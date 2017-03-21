/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.mochidashipcimportuketsukedata;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 *
 * 投票状況ファイルの一時テーブル作成用entityクラスです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyoJokyoCsvTempTableEntity extends DbTableEntityBase<TohyoJokyoCsvTempTableEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private ShohonNo shohonNo;

    @TempTableColumnOrder(2)
    private SenkyoNo senkyoNo;

    @TempTableColumnOrder(3)
    private RString groupCode;

    @TempTableColumnOrder(4)
    private RString tohyokuCode;

    @TempTableColumnOrder(5)
    private RString satsu;

    @TempTableColumnOrder(6)
    private RString page;

    @TempTableColumnOrder(7)
    private RString gyo;

    @TempTableColumnOrder(8)
    private RString juminCode;

    @TempTableColumnOrder(9)
    private FlexibleDate seikyuYMD;

    @TempTableColumnOrder(10)
    private RString seikyuHoho;

    @TempTableColumnOrder(11)
    private RString seikyuJiyu;

    @TempTableColumnOrder(12)
    private RString kofuHyoji;

    @TempTableColumnOrder(13)
    private FlexibleDate kofuYMD;

    @TempTableColumnOrder(14)
    private RTime kofuTime;

    @TempTableColumnOrder(15)
    private RString kofuKubun;

    @TempTableColumnOrder(16)
    private RString kofuUketsukeNo;

    @TempTableColumnOrder(17)
    private RString kofuHoho;

    @TempTableColumnOrder(18)
    private RString kofuShisetsuCode;

    @TempTableColumnOrder(19)
    private RString tenjiFlag;

    @TempTableColumnOrder(20)
    private RString shomeishoPrintFlag;

    @TempTableColumnOrder(21)
    private RString juriHyoji;

    @TempTableColumnOrder(22)
    private FlexibleDate juriYMD;

    @TempTableColumnOrder(23)
    private RTime juriTime;

    @TempTableColumnOrder(24)
    private RString juriHoho;

    @TempTableColumnOrder(25)
    private RString juriShisetsuShubetsu;

    @TempTableColumnOrder(26)
    private FlexibleDate henkanYMD;

    @TempTableColumnOrder(27)
    private RTime henkanTime;

    @TempTableColumnOrder(28)
    private RString dairiTohyoAriFlag;

    @TempTableColumnOrder(29)
    private RString hojoshaShimei1;

    @TempTableColumnOrder(30)
    private RString hojoshaShimei2;

    @TempTableColumnOrder(31)
    private RString tanmatsuId;

    @TempTableColumnOrder(32)
    private RString isDeleted;

    @TempTableColumnOrder(33)
    private RString updateCount;

    @TempTableColumnOrder(34)
    private RString insertDataTimestamp;

    @TempTableColumnOrder(35)
    private RString insertDataLoginId;

    @TempTableColumnOrder(36)
    private RString lastUpdateDataTimestamp;

    @TempTableColumnOrder(37)
    private RString lastUpdateDataLoginId;

}
