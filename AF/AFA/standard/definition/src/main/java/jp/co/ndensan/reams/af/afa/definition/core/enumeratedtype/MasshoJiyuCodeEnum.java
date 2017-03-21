/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抹消事由コードを表す列挙型です。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public enum MasshoJiyuCodeEnum {

    /**
     * 死亡抹消
     */
    死亡抹消(new RString("01")),
    /**
     * 国籍喪失抹消
     */
    国籍喪失抹消(new RString("02")),
    /**
     * 転出4カ月経過抹消
     */
    転出4カ月経過抹消(new RString("03")),
    /**
     * 誤載抹消
     */
    誤載抹消(new RString("04")),
    /**
     * 二重登録抹消
     */
    二重登録抹消(new RString("05")),
    /**
     * 基準日前異動抹消
     */
    基準日前異動抹消(new RString("06")),
    /**
     * 職権消除4カ月経過抹消
     */
    職権消除4カ月経過抹消(new RString("07")),
    /**
     * 居住要件抹消
     */
    居住要件抹消(new RString("08")),
    /**
     * その他
     */
    その他(new RString("09"));
    private final RString value;

    private MasshoJiyuCodeEnum(RString value) {
        this.value = value;
    }

    /**
     * 抹消事由コードを取得する
     *
     * @return 年月日検索基準
     */
    public RString getValue() {
        return value;
    }

    /**
     * 抹消事由コードを取得する
     *
     * @return 年月日検索基準
     */
    public Code getCode() {
        return new Code(value);
    }
}
