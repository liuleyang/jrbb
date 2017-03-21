/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 登録者数リストの一時テーブル検索用entityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFAPRA103tempTorokushasuListEntity extends DbTableEntityBase<AFAPRA103tempTorokushasuListEntity> implements IDbAccessable {

    /**
     * 登録者数リストの一時テーブル
     */
    @TableName
    public static final RString TEMP_TABLE_NAME;

    static {
        TEMP_TABLE_NAME = new RString("outTempAFAPRA103");
    }

    @CsvField(order = 1, name = "shikibetsuCode")
    @TempTableColumnOrder(1)
    private ShikibetsuCode shikibetsuCode;
    @CsvField(order = 2, name = "seibetsuCode")
    @TempTableColumnOrder(2)
    private RString seibetsuCode;
    @CsvField(order = 3, name = "senkyoNo")
    @TempTableColumnOrder(3)
    private SenkyoNo senkyoNo;
    @CsvField(order = 4, name = "tohyokuCode")
    @TempTableColumnOrder(4)
    private RString tohyokuCode;
    @CsvField(order = 5, name = "orderCode")
    @TempTableColumnOrder(5)
    private RString orderCode;
    @CsvField(order = 6, name = "kenaiTenshutsushaKubun")
    @TempTableColumnOrder(6)
    private boolean kenaiTenshutsushaKubun;
    @CsvField(order = 7, name = "ukeshaKubun")
    @TempTableColumnOrder(7)
    private boolean ukeshaKubun;
    @CsvField(order = 8, name = "hyojishaKubun")
    @TempTableColumnOrder(8)
    private boolean hyojishaKubun;
    @CsvField(order = 9, name = "kominkenTeshishaKubun")
    @TempTableColumnOrder(9)
    private boolean kominkenTeshishaKubun;
    @CsvField(order = 10, name = "tohyokuMeisho")
    @TempTableColumnOrder(10)
    private RString tohyokuMeisho;
    @CsvField(order = 11, name = "kijunYMD")
    @TempTableColumnOrder(11)
    private FlexibleDate kijunYMD;
    @CsvField(order = 12, name = "tohyoYMD")
    @TempTableColumnOrder(12)
    private FlexibleDate tohyoYMD;
    @CsvField(order = 13, name = "senkyoName")
    @TempTableColumnOrder(13)
    private RString senkyoName;
}
