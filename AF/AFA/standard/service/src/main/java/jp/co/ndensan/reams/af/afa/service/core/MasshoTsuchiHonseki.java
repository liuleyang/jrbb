/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.InnjiFlg;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.IZenkokuJushoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 抹消通知
 *
 * @reamsid_L AF-0350-020 lis
 */
public class MasshoTsuchiHonseki {

    private static final int インデックス_通知先市町村1 = 0;
    private static final int インデックス_通知先市町村2 = 1;
    private static final int インデックス_氏名 = 0;
    private static final int インデックス_氏名1 = 1;
    private static final int インデックス_氏名2 = 2;
    private static final int インデックス_氏名3 = 3;
    private static final int インデックス_氏名4 = 4;
    private static final int インデックス_本籍1 = 0;
    private static final int インデックス_本籍2 = 1;
    private static final int インデックス_本籍3 = 2;
    private static final int 本籍全国住所コード_上5桁_インデックス = 5;
    private static final int インデックス_本籍4 = 3;
    private static final int インデックス_抹消事由1 = 0;
    private static final int インデックス_抹消事由2 = 1;
    private static final int インデックス_抹消事由3 = 2;
    private static final int インデックス_抹消事由4 = 3;

    private static final RString 全角スペース = new RString("　");
    private static final RString スペース = new RString(" ");
    private static final RString 漢字氏名_長 = new RString("長");
    private static final RString 漢字氏名_殿 = new RString("殿");
    private static final RString 丸印 = new RString("○");
    private static final RString 郵便番号_印字 = new RString("〒");
    private static final RString 抹消事由コード_1 = new RString("01");
    private static final RString 抹消事由コード_2 = new RString("02");
    private static final RString 抹消事由コード_3 = new RString("03");
    private static final RString 抹消事由コード_4 = new RString("04");
    private static final RString 本籍全国住所コード_下6桁 = new RString("000000");

    /**
     * コンストラクタです。
     */
    public MasshoTsuchiHonseki() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link MasshoTsuchiHonseki}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link MasshoTsuchiHonseki}のインスタンス
     */
    public static MasshoTsuchiHonseki createInstance() {
        return InstanceProvider.create(MasshoTsuchiHonseki.class);
    }

    /**
     * 郵便番号取得
     *
     * @param 本籍全国住所コード RString
     * @return 郵便番号 RString
     */
    public RString get郵便番号(RString 本籍全国住所コード) {
        YubinNo 本籍郵便番号 = YubinNo.EMPTY;
        if (RString.isNullOrEmpty(本籍全国住所コード)) {
            return RString.EMPTY;
        }
        RString 印字有無 = BusinessConfig.get(ConfigKeysAFA.二重登録_印字有無_カスタマーバーコード, SubGyomuCode.AFA選挙本体);
        if (!InnjiFlg.印字する.value().equals(印字有無)) {
            return RString.EMPTY;
        }
        ZenkokuJushoCode 全国住所コード = new ZenkokuJushoCode(本籍全国住所コード);
        ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
        LasdecCode 地方公共団体コード = new LasdecCode(全国住所コード.getShichosonCode6());
        ShichosonAtesaki atesaki = finder.get市町村宛先(地方公共団体コード, SofusakiGroup.選挙人情報関連.getCode());
        if (null != atesaki) {
            本籍郵便番号 = atesaki.get郵便番号();
        }
        if (null == 本籍郵便番号 || 本籍郵便番号.isEmpty()) {
            return RString.EMPTY;
        }
        return 郵便番号_印字.concat(本籍郵便番号.getEditedYubinNo());
    }

    /**
     * 通知先市町村１～２取得
     *
     * @param 本籍全国住所コード RString
     * @param 長さ_通知先市町村名１ int
     * @return 通知先市町村名リスト List<RString>{通知先市町村１、通知先市町村2}
     */
    public List<RString> get通知先市町村１_２(RString 本籍全国住所コード, int 長さ_通知先市町村名１) {
        List<RString> 通知先市町村名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_通知先市町村2; i++) {
            通知先市町村名リスト.add(RString.EMPTY);
        }
        if (RString.isNullOrEmpty(本籍全国住所コード) || 本籍全国住所コード_上5桁_インデックス > 本籍全国住所コード.length()) {
            return 通知先市町村名リスト;
        }
        IZenkokuJushoFinder zenkokuJushoFinder = ZenkokuJushoFinderFactory.createInstance();
        ZenkokuJushoItem zenkokuJushoItem = zenkokuJushoFinder.get全国住所By全国住所コード(new ZenkokuJushoCode(
                本籍全国住所コード.substring(0, 本籍全国住所コード_上5桁_インデックス).concat(本籍全国住所コード_下6桁)));
        if (null != zenkokuJushoItem) {
            RString 通知先市町村名 = changeNullToEmpty(zenkokuJushoItem.get都道府県名())
                    .concat(changeNullToEmpty(zenkokuJushoItem.get市町村名())).replace(スペース, RString.EMPTY);
            if (長さ_通知先市町村名１ >= 通知先市町村名.length()) {
                通知先市町村名リスト.set(インデックス_通知先市町村1, 通知先市町村名.concat(漢字氏名_長)
                        .concat(全角スペース).concat(漢字氏名_殿));
            } else {
                通知先市町村名リスト.set(インデックス_通知先市町村2, 通知先市町村名.concat(漢字氏名_長)
                        .concat(全角スペース).concat(漢字氏名_殿));
            }
        }
        return 通知先市町村名リスト;
    }

    /**
     * 氏名と氏名１～４取得
     *
     * @param 漢字氏名 RString
     * @param 長さ_氏名 int
     * @param 長さ_氏名1 int
     * @param 長さ_氏名2 int
     * @param 長さ_氏名3 int
     * @return 氏名リスト List<RString>{氏名、氏名１、氏名２、氏名３、氏名４}
     */
    public List<RString> get氏名と氏名１_４(RString 漢字氏名, int 長さ_氏名, int 長さ_氏名1, int 長さ_氏名2, int 長さ_氏名3) {
        List<RString> 氏名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_氏名4; i++) {
            氏名リスト.add(RString.EMPTY);
        }
        漢字氏名 = changeNullToEmpty(漢字氏名);
        if (長さ_氏名 >= 漢字氏名.length()) {
            氏名リスト.set(インデックス_氏名, 漢字氏名);
        } else if (長さ_氏名2 >= 漢字氏名.length()) {
            氏名リスト.set(インデックス_氏名2, 漢字氏名);
        } else if (長さ_氏名2 + 長さ_氏名3 >= 漢字氏名.length()) {
            氏名リスト.set(インデックス_氏名2, 漢字氏名.substring(0, 長さ_氏名2));
            氏名リスト.set(インデックス_氏名3, 漢字氏名.substring(長さ_氏名2));
        } else {
            氏名リスト.set(インデックス_氏名1, 漢字氏名.substring(0, 長さ_氏名1));
            氏名リスト.set(インデックス_氏名2, 漢字氏名.substring(長さ_氏名1, 長さ_氏名1 + 長さ_氏名2));
            氏名リスト.set(インデックス_氏名3, 漢字氏名.substring(長さ_氏名1 + 長さ_氏名2, 長さ_氏名1 + 長さ_氏名2 + 長さ_氏名3));
            氏名リスト.set(インデックス_氏名4, 漢字氏名.substring(長さ_氏名1 + 長さ_氏名2 + 長さ_氏名3));
        }
        return 氏名リスト;
    }

    /**
     * 本籍１～４取得
     *
     * @param 本籍住所 RString
     * @param 本籍番地 RString
     * @param 長さ_本籍1 int
     * @param 長さ_本籍2 int
     * @param 長さ_本籍3 int
     * @return 本籍リスト List<RString>{本籍１、本籍2、本籍3、本籍4}
     */
    public List<RString> get本籍１_４(RString 本籍住所, RString 本籍番地, int 長さ_本籍1, int 長さ_本籍2, int 長さ_本籍3) {
        List<RString> 本籍リスト = new ArrayList();
        for (int i = 0; i <= インデックス_本籍4; i++) {
            本籍リスト.add(RString.EMPTY);
        }
        RString 連結 = changeNullToEmpty(本籍住所).concat(changeNullToEmpty(本籍番地)).replace(スペース, RString.EMPTY);
        if (長さ_本籍2 >= 連結.length()) {
            本籍リスト.set(インデックス_本籍2, 連結);
        } else if (長さ_本籍2 + 長さ_本籍3 >= 連結.length()) {
            本籍リスト.set(インデックス_本籍2, 連結.substring(0, 長さ_本籍2));
            本籍リスト.set(インデックス_本籍3, 連結.substring(長さ_本籍2));
        } else if (長さ_本籍1 + 長さ_本籍2 + 長さ_本籍3 >= 連結.length()) {
            本籍リスト.set(インデックス_本籍1, 連結.substring(0, 長さ_本籍1));
            本籍リスト.set(インデックス_本籍2, 連結.substring(長さ_本籍1, 長さ_本籍1 + 長さ_本籍2));
            本籍リスト.set(インデックス_本籍3, 連結.substring(長さ_本籍1 + 長さ_本籍2));
        } else {
            本籍リスト.set(インデックス_本籍1, 連結.substring(0, 長さ_本籍1));
            本籍リスト.set(インデックス_本籍2, 連結.substring(長さ_本籍1, 長さ_本籍1 + 長さ_本籍2));
            本籍リスト.set(インデックス_本籍3, 連結.substring(長さ_本籍1 + 長さ_本籍2, 長さ_本籍1 + 長さ_本籍2 + 長さ_本籍3));
            本籍リスト.set(インデックス_本籍4, 連結.substring(長さ_本籍1 + 長さ_本籍2 + 長さ_本籍3));
        }
        return 本籍リスト;
    }

    /**
     * 抹消理由１～４取得
     *
     * @param 抹消事由コード RString
     * @return 抹消理由リスト List<RString>{抹消理由1、抹消理由2、抹消理由3、抹消理由4}
     */
    public List<RString> get抹消理由１_４(RString 抹消事由コード) {
        List<RString> 抹消理由リスト = new ArrayList();
        for (int i = 0; i <= インデックス_抹消事由4; i++) {
            抹消理由リスト.add(RString.EMPTY);
        }
        if (抹消事由コード_1.equals(抹消事由コード)) {
            抹消理由リスト.set(インデックス_抹消事由1, 丸印);
        } else if (抹消事由コード_2.equals(抹消事由コード)) {
            抹消理由リスト.set(インデックス_抹消事由2, 丸印);
        } else if (抹消事由コード_3.equals(抹消事由コード)) {
            抹消理由リスト.set(インデックス_抹消事由3, 丸印);
        } else if (抹消事由コード_4.equals(抹消事由コード)) {
            抹消理由リスト.set(インデックス_抹消事由4, 丸印);
        }
        return 抹消理由リスト;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }
}
