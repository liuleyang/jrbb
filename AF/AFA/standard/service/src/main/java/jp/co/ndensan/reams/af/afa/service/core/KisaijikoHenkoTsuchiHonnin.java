/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShinseiNaiyoHenkoJiyuCode;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT124ZaigaiSenkyoninShinseiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT122ZaigaiSenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT124ZaigaiSenkyoninShinseiDac;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 記載事項変更通知
 *
 * @reamsid_L AF-0330-020 lis2
 */
public class KisaijikoHenkoTsuchiHonnin {

    private static final int インデックス_性別１ = 0;
    private static final int インデックス_性別２ = 1;
    private static final int インデックス_修正理由1 = 0;
    private static final int インデックス_修正理由2 = 1;
    private static final int インデックス_修正理由3 = 2;
    private static final int インデックス_修正理由4 = 3;
    private static final int インデックス_修正理由5 = 4;
    private static final int インデックス_修正前氏名 = 0;
    private static final int インデックス_修正前氏名1 = 1;
    private static final int インデックス_修正前氏名2 = 2;

    private static final RString 性別コード_1 = new RString("1");
    private static final RString 性別コード_2 = new RString("2");
    private static final RString 丸印 = new RString("○");

    private final AfT122ZaigaiSenkyoShikakuDac dac;
    private final AfT124ZaigaiSenkyoninShinseiDac dac2;

    /**
     * コンストラクタです。
     */
    public KisaijikoHenkoTsuchiHonnin() {
        dac = InstanceProvider.create(AfT122ZaigaiSenkyoShikakuDac.class);
        dac2 = InstanceProvider.create(AfT124ZaigaiSenkyoninShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT122ZaigaiSenkyoShikakuDac}
     * @param dac2 {@link AfT124ZaigaiSenkyoninShinseiDac}
     */
    KisaijikoHenkoTsuchiHonnin(AfT122ZaigaiSenkyoShikakuDac dac, AfT124ZaigaiSenkyoninShinseiDac dac2) {
        this.dac = dac;
        this.dac2 = dac2;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KisaijikoHenkoTsuchiHonnin}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KisaijikoHenkoTsuchiHonnin}のインスタンス
     */
    public static KisaijikoHenkoTsuchiHonnin createInstance() {
        return InstanceProvider.create(KisaijikoHenkoTsuchiHonnin.class);
    }

    /**
     * 性別１～２取得
     *
     * @param 性別コード RString
     * @return List<RString>{性別１、性別２}
     */
    public List<RString> get性別１_２(RString 性別コード) {
        List<RString> 性別リスト = new ArrayList();
        for (int i = 0; i <= インデックス_性別２; i++) {
            性別リスト.add(RString.EMPTY);
        }
        性別コード = changeNullToEmpty(性別コード);
        if (性別コード_1.equals(性別コード)) {
            性別リスト.set(インデックス_性別１, 丸印);
        } else if (性別コード_2.equals(性別コード)) {
            性別リスト.set(インデックス_性別２, 丸印);
        }

        return 性別リスト;
    }

    /**
     * 修正理由１～５取得
     *
     * @param 記載事項変更事由コード RString
     * @return List<RString>{修正理由１、修正理由２、修正理由３、修正理由４}
     */
    public List<RString> get修正理由１_５(RString 記載事項変更事由コード) {
        List<RString> 修正理由リスト = new ArrayList();
        for (int i = 0; i <= インデックス_修正理由5; i++) {
            修正理由リスト.add(RString.EMPTY);
        }
        記載事項変更事由コード = changeNullToEmpty(記載事項変更事由コード);
        if (ShinseiNaiyoHenkoJiyuCode.住所変更.getKey().equals(記載事項変更事由コード)) {
            修正理由リスト.set(インデックス_修正理由1, 丸印);
        } else if (ShinseiNaiyoHenkoJiyuCode.氏名変更.getKey().equals(記載事項変更事由コード)) {
            修正理由リスト.set(インデックス_修正理由2, 丸印);
        } else if (ShinseiNaiyoHenkoJiyuCode.本籍地変更.getKey().equals(記載事項変更事由コード)) {
            修正理由リスト.set(インデックス_修正理由3, 丸印);
        } else if (ShinseiNaiyoHenkoJiyuCode.送付先変更.getKey().equals(記載事項変更事由コード)) {
            修正理由リスト.set(インデックス_修正理由4, 丸印);
        } else if (ShinseiNaiyoHenkoJiyuCode.その他.getKey().equals(記載事項変更事由コード)) {
            修正理由リスト.set(インデックス_修正理由5, 丸印);
        }
        return 修正理由リスト;
    }

    /**
     * 修正前情報
     *
     * @param 識別コード RString
     * @param 長さ_修正前氏名１ int
     * @return List<RString>{修正前氏名、修正前氏名１、修正前氏名２}
     */
    public List<RString> get修正前情報(RString 識別コード, int 長さ_修正前氏名１) {
        List<RString> 修正前リスト = new ArrayList();
        for (int i = 0; i <= インデックス_修正前氏名2; i++) {
            修正前リスト.add(RString.EMPTY);
        }
        識別コード = changeNullToEmpty(識別コード);
        AfT122ZaigaiSenkyoShikakuEntity entity1 = dac.selectMaxShinseiNo(new ShikibetsuCode(識別コード));
        int 最大申請番号 = 0;
        int 次申請番号 = 0;
        AtenaMeisho 漢字 = new AtenaMeisho("");
        if (entity1 != null) {
            最大申請番号 = entity1.getShinseiNo();
        }
        AfT122ZaigaiSenkyoShikakuEntity entity2 = dac.selectMaxShinseiNo(new ShikibetsuCode(識別コード), 最大申請番号);
        if (entity2 != null) {
            次申請番号 = entity2.getShinseiNo();
        }
        AfT124ZaigaiSenkyoninShinseiEntity entity3 = dac2.select(次申請番号);
        if (entity3 != null) {
            漢字 = entity3.getShinseishaShimei();
        }
        RString 漢字氏名 = null == 漢字 ? RString.EMPTY : 漢字.getColumnValue();
        if (長さ_修正前氏名１ >= 漢字氏名.length()) {
            修正前リスト.set(インデックス_修正前氏名, 漢字氏名);
        } else {
            修正前リスト.set(インデックス_修正前氏名1, 漢字氏名.substring(0, 長さ_修正前氏名１));
            修正前リスト.set(インデックス_修正前氏名2, 漢字氏名.substring(長さ_修正前氏名１));
        }
        return 修正前リスト;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
