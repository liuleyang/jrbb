/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import static jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoReportOutputType.values;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種お知らせ作成の出力順項目を表す列挙型です。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public enum ShisetsuSofushoReportOutputType implements IReportItems {

    /**
     * 世帯コード
     */
    世帯コード(new RString("0010"), new RString(""), new RString("\"ShikibetsuTaisho\".\"setaiCode\"")),
    /**
     * 住所コード
     */
    住所コード(new RString("0020"), new RString(""), new RString("\"ShikibetsuTaisho\".\"saishuJutochiZenkokuJushoCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0030"), new RString(""), new RString("\"ShikibetsuTaisho\".\"gyoseikuCode\"")),
    /**
     * 地区コード１
     */
    地区コード１(new RString("0041"), new RString(""), new RString("\"ShikibetsuTaisho\".\"chikuCode1\"")),
    /**
     * 地区コード２
     */
    地区コード２(new RString("0042"), new RString(""), new RString("\"ShikibetsuTaisho\".\"chikuCode2\"")),
    /**
     * 地区コード３
     */
    地区コード３(new RString("0043"), new RString(""), new RString("\"ShikibetsuTaisho\".\"chikuCode3\"")),
    /**
     * 生年月日
     */
    生年月日(new RString("0070"), new RString(""), new RString("\"ShikibetsuTaisho\".\"seinengappiYMD\"")),
    /**
     * 性別
     */
    性別(new RString("0080"), new RString(""), new RString("\"ShikibetsuTaisho\".\"seibetsuCode\"")),
    /**
     * 続柄
     */
    続柄(new RString("0090"), new RString(""), new RString("\"ShikibetsuTaisho\".\"tsuzukigaraCode\"")),
    /**
     * 異動事由コード
     */
    異動事由コード(new RString("0100"), new RString(""), new RString("\"ShikibetsuTaisho\".\"idoJiyuCode\"")),
    /**
     * 異動年月日
     */
    異動年月日(new RString("0101"), new RString(""), new RString("\"ShikibetsuTaisho\".\"idoYMD\"")),
    /**
     * 選挙資格区分
     */
    選挙資格区分(new RString("0110"), new RString(""), new RString("\"master\".\"shikakuKubun\"")),
    /**
     * 投票区コード
     */
    投票区コード(new RString("0120"), new RString(""), new RString("\"master\".\"tohyokuCode\"")),
    /**
     * カナ名称
     */
    カナ名称(new RString("0150"), new RString(""), new RString("\"ShikibetsuTaisho\".\"kanaMeisho\"")),
    /**
     * カナ世帯主名
     */
    カナ世帯主名(new RString("0160"), new RString(""), new RString("\"ShikibetsuTaisho\".\"setainushiMei\"")),
    /**
     * 転出先全国住所コード
     */
    転出先全国住所コード(new RString("0170"), new RString(""), new RString("\"ShikibetsuTaisho\".\"zenkokuJushoCode\"")),
    /**
     * 住民種別コード
     */
    住民種別コード(new RString("0180"), new RString(""), new RString("\"ShikibetsuTaisho\".\"juminShubetsuCode\"")),
    /**
     * 住民状態コード
     */
    住民状態コード(new RString("0181"), new RString(""), new RString("\"ShikibetsuTaisho\".\"juminJotaiCode\"")),
    /**
     * 番地コード
     */
    番地コード(new RString("0190"), new RString(""), new RString("\"ShikibetsuTaisho\".\"banchiCode1\"")),
    /**
     * グループコード
     */
    グループコード(new RString("0200"), new RString(""), new RString("\"master\".\"groupCode\"")),
    /**
     * 住民票表示順
     */
    住民票表示順(new RString("0210"), new RString(""), new RString("\"ShikibetsuTaisho\".\"juminhyoHyojijun\"")),
    /**
     * 冊
     */
    冊(new RString("0220"), new RString(""), new RString("\"master\".\"satsu\"")),
    /**
     * 方書
     */
    方書(new RString("0250"), new RString(""), new RString("\"ShikibetsuTaisho\".\"saishuJutochiKatagaki\"")),
    /**
     * 転入前全国住所コード
     */
    転入前全国住所コード(new RString("0280"), new RString(""), new RString("\"ShikibetsuTaisho\".\"tennyumaeZenkokuJushoCode\"")),
    /**
     * 抹消事由コード
     */
    抹消事由コード(new RString("0290"), new RString(""), new RString("\"master\".\"masshoJiyuCode\"")),
    /**
     * 抹消年月日
     */
    抹消年月日(new RString("0291"), new RString(""), new RString("\"master\".\"masshoYMD\"")),
    /**
     * 交付番号
     */
    交付番号(new RString("0300"), new RString(""), new RString("\"master\".\"kofuNo\"")),
    /**
     * 投票資格種類
     */
    投票資格種類(new RString("0310"), new RString(""), new RString("\"master\".\"tohyoShikakuShurui\"")),
    /**
     * 交付年月日
     */
    交付年月日(new RString("0320"), new RString(""), new RString("\"master\".\"kofuYMD\"")),
    /**
     * 資格満了年月日
     */
    資格満了年月日(new RString("0330"), new RString(""), new RString("\"master\".\"shikakuManryoYMD\"")),
    /**
     * 資格抹消年月日
     */
    資格抹消年月日(new RString("0340"), new RString(""), new RString("\"master\".\"shikakuMasshoYMD\"")),
    /**
     * 申請番号
     */
    申請番号(new RString("0350"), new RString(""), new RString("\"master\".\"shinseiNo\"")),
    /**
     * 選挙番号
     */
    選挙番号(new RString("0500"), new RString(""), new RString("\"master\".\"senkyoNo\"")),
    /**
     * 表示事由コード
     */
    表示事由コード(new RString("0590"), new RString(""), new RString("\"master\".\"hyojiJiyuCode\"")),
    /**
     * 表示年月日
     */
    表示年月日(new RString("0591"), new RString(""), new RString("\"master\".\"hyojiYMD\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0900"), new RString(""), new RString("\"master\".\"shikibetsuCode\"")),
    /**
     * 処理日時
     */
    処理日時(new RString("0910"), new RString(""), new RString("\"master\".\"insertTimestamp\"")),
    /**
     * 施設コード
     */
    施設コード(new RString("0510"), new RString(""), new RString("\"master\".\"shisetsuCode\"")),
    /**
     * 受理年月日
     */
    受理年月日(new RString("0570"), new RString(""), new RString("\"master\".\"juriYMD\"")),
    /**
     * 受付番号
     */
    受付番号(new RString("0530"), new RString(""), new RString("\"master\".\"uketsukeNo\"")),
    /**
     * 名簿番号
     */
    名簿番号(new RString("0550"), new RString(""), new RString("\"master\".\"groupCode\",\"master\".\"tohyokuCode\","
            + "\"master\".\"satsu\",\"master\".\"page\",\"master\".\"gyo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private ShisetsuSofushoReportOutputType(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
        for (ShisetsuSofushoReportOutputType type : values()) {
            if (type.get項目ID().equals(項目ID)) {
                return type.getMyBatis項目名();
            }
        }

        return RString.EMPTY;

    }
}
