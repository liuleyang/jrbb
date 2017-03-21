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
 * 有権者数調べの一時テーブル検索用entityクラスです。
 *
 * @reamsid_L AF-0010-020 qiuxy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFAPRA104tempYukenshasuEntity extends DbTableEntityBase<AFAPRA104tempYukenshasuEntity> implements IDbAccessable {

    /**
     * コンストラクタです。
     */
    public AFAPRA104tempYukenshasuEntity() {
    }

    /**
     * 登録者数リストの一時テーブル
     */
    @TableName
    public static final RString TEMP_TABLE_NAME;

    static {
        TEMP_TABLE_NAME = new RString("TempAFAPRA104");
    }
    @CsvField(order = 1, name = "識別コード")
    @TempTableColumnOrder(1)
    private ShikibetsuCode 識別コード;
    @CsvField(order = 2, name = "性別")
    @TempTableColumnOrder(2)
    private RString 性別;
    @CsvField(order = 3, name = "選挙番号")
    @TempTableColumnOrder(3)
    private SenkyoNo 選挙番号;
    @CsvField(order = 4, name = "投票区コード")
    @TempTableColumnOrder(4)
    private RString 投票区コード;
    @CsvField(order = 5, name = "投票区名称")
    @TempTableColumnOrder(5)
    private RString 投票区名称;
    @CsvField(order = 6, name = "地区コード")
    @TempTableColumnOrder(6)
    private RString 地区コード;
    @CsvField(order = 7, name = "地区名称")
    @TempTableColumnOrder(7)
    private RString 地区名称;
    @CsvField(order = 8, name = "登録者区分")
    @TempTableColumnOrder(8)
    private boolean 登録者区分;
    @CsvField(order = 9, name = "追加登録者区分")
    @TempTableColumnOrder(9)
    private boolean 追加登録者区分;
    @CsvField(order = 10, name = "死亡区分")
    @TempTableColumnOrder(10)
    private boolean 死亡区分;
    @CsvField(order = 11, name = "四ヶ月抹消区分")
    @TempTableColumnOrder(11)
    private boolean 四ヶ月抹消区分;
    @CsvField(order = 12, name = "当日四ヶ月抹消区分")
    @TempTableColumnOrder(12)
    private boolean 当日四ヶ月抹消区分;
    @CsvField(order = 13, name = "誤載区分")
    @TempTableColumnOrder(13)
    private boolean 誤載区分;
    @CsvField(order = 14, name = "国籍喪失区分")
    @TempTableColumnOrder(14)
    private boolean 国籍喪失区分;
    @CsvField(order = 15, name = "その他抹消区分")
    @TempTableColumnOrder(15)
    private boolean その他抹消区分;
    @CsvField(order = 16, name = "法11条関連区分")
    @TempTableColumnOrder(16)
    private boolean 法11条関連区分;
    @CsvField(order = 17, name = "二重登録区分")
    @TempTableColumnOrder(17)
    private boolean 二重登録区分;
    @CsvField(order = 18, name = "抹消者総区分")
    @TempTableColumnOrder(18)
    private boolean 抹消者総区分;
    @CsvField(order = 19, name = "失権失格者区分")
    @TempTableColumnOrder(19)
    private boolean 失権失格者区分;
    @CsvField(order = 20, name = "選挙期日登録者区分")
    @TempTableColumnOrder(20)
    private boolean 選挙期日登録者区分;
    @CsvField(order = 21, name = "n内転出者区分")
    @TempTableColumnOrder(21)
    private boolean n内転出者区分;
    @CsvField(order = 22, name = "n外転出者区分")
    @TempTableColumnOrder(22)
    private boolean n外転出者区分;
    @CsvField(order = 23, name = "国外転出者区分")
    @TempTableColumnOrder(23)
    private boolean 国外転出者区分;
    @CsvField(order = 24, name = "職権削除者区分")
    @TempTableColumnOrder(24)
    private boolean 職権削除者区分;
    @CsvField(order = 25, name = "加算有権者_抹消者区分")
    @TempTableColumnOrder(25)
    private boolean 加算有権者_抹消者区分;
    @CsvField(order = 26, name = "加算有権者_失権者区分")
    @TempTableColumnOrder(26)
    private boolean 加算有権者_失権者区分;
    @CsvField(order = 27, name = "加算有権者_計区分")
    @TempTableColumnOrder(27)
    private boolean 加算有権者_計区分;
    @CsvField(order = 28, name = "当日有権者区分")
    @TempTableColumnOrder(28)
    private boolean 当日有権者区分;
    @CsvField(order = 29, name = "名簿基準年月日")
    @TempTableColumnOrder(29)
    private FlexibleDate 名簿基準年月日;
    @CsvField(order = 30, name = "投票年月日")
    @TempTableColumnOrder(30)
    private FlexibleDate 投票年月日;
    @CsvField(order = 31, name = "選挙種類")
    @TempTableColumnOrder(31)
    private RString 選挙種類;
    @CsvField(order = 32, name = "選挙名称")
    @TempTableColumnOrder(32)
    private RString 選挙名称;
}
