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
 * @reamsid_L AF-0170-030 guyq
 */
public enum ZaigaiReportOutputTypeWithMaster implements IReportItems {

    /**
     * 生年月日
     */
    生年月日(new RString("0070"), new RString(""), new RString("master.\"afT124ZaigaiSenkyoninShinsei_seinengappiYMD\"")),
    /**
     * 性別
     */
    性別(new RString("0080"), new RString(""), new RString("master.\"afT124ZaigaiSenkyoninShinsei_seibetsuCode\"")),
    /**
     * 冊
     */
    冊(new RString("0220"), new RString(""), new RString("master.\"afT121ZaigaiSenkyoninMeibo_satsu\"")),
    /**
     * 投票区コード
     */
    投票区コード(new RString("0120"), new RString(""), new RString("master.\"afT121ZaigaiSenkyoninMeibo_tohyokuCode\"")),
    /**
     * カナ名称
     */
    カナ名称(new RString("0150"), new RString(""), new RString("master.\"afT124ZaigaiSenkyoninShinsei_shinseishaKanaShimei\"")),
    /**
     * グループコード
     */
    グループコード(new RString("0200"), new RString(""), new RString("master.\"afT121ZaigaiSenkyoninMeibo_groupCode\"")),
    /**
     * 交付番号
     */
    交付番号(new RString("0300"), new RString(""), new RString("master.\"afT122ZaigaiSenkyoShikaku_kofuNo\"")),
    /**
     * 申請番号
     */
    申請番号(new RString("0350"), new RString(""), new RString("master.\"afT122ZaigaiSenkyoShikaku_shinseiNo\"")),
    // TODO
    /**
     * 領事官コード
     */
    領事官コード(new RString("0400"), new RString(""), new RString("master.\"afT124ZaigaiSenkyoninShinsei_ryojikanCode\"")),
    /**
     * 国籍コード
     */
    国籍コード(new RString("0410"), new RString(""), new RString("master.\"afT124ZaigaiSenkyoninShinsei_kokusekiCode\"")),
    /**
     * 選挙資格区分
     */
    選挙資格区分(new RString("0110"), new RString(""), new RString("master.\"afT122ZaigaiSenkyoShikaku_shikakuKubun\"")),
    /**
     * 国外分類コード
     */
    国外分類コード(new RString("0430"), new RString(""), new RString("master.\"afT121ZaigaiSenkyoninMeibo_kokugaiBunruiCode\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private ZaigaiReportOutputTypeWithMaster(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
        for (ZaigaiReportOutputTypeWithMaster type : values()) {
            if (type.get項目ID().equals(項目ID)) {
                return type.getMyBatis項目名();
            }
        }

        return RString.EMPTY;

    }
}
