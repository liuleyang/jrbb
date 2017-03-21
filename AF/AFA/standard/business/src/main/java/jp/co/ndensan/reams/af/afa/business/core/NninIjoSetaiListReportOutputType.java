/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種お知らせ作成の出力順項目を表す列挙型です。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public enum NninIjoSetaiListReportOutputType implements IReportItems {

    /**
     * 投票区コード
     */
    投票区コード(new RString("0120"), new RString(""), new RString("\"AFABTB201SoufusakiJouhou\".\"tohyokuCode\"")),
    /**
     * 名簿番号
     */
    名簿番号(new RString("0550"), new RString(""), new RString("\"AFABTB201SoufusakiJouhou\".\"page\",\"AFABTB201SoufusakiJouhou\".\"gyo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private NninIjoSetaiListReportOutputType(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
        this.項目ID = 項目ID;
        this.フォームフィールド名 = フォームフィールド名;
        this.myBatis項目名 = myBatis項目名;
    }

    @Override
    public RString get項目ID() {
        return 項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return myBatis項目名;

    }

    /**
     * MyBatis項目名を取得します。
     *
     * @param 項目ID RString
     * @return MyBatis項目名
     */
    public static RString getMyBatis項目名(RString 項目ID) {

        if (RString.isNullOrEmpty(項目ID)) {
            return RString.EMPTY;
        }
        for (NninIjoSetaiListReportOutputType type : values()) {
            if (type.get項目ID().equals(項目ID)) {
                return type.getMyBatis項目名();
            }
        }

        return RString.EMPTY;

    }
}
