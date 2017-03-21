/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.HonninJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.ZaigaiSenkyoIdouRuisekiResult;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.ZaigaiSenkyoninJohoResult;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JushoShuruiKubun;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT121ZaigaiSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoIdouRuisekiEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibotorokuzaigai.ZaigaiSenkyoninShinseiJohoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT121ZaigaiSenkyoninMeiboDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT122ZaigaiSenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT123ZaigaiSenkyoninJushoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.meibotorokuzaigai.IMeibotorokuZaigaiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 在外選挙人名簿登録
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
public class MeibotorokuZaigai {

    private static final int インデックス_在外選挙人名簿_頁 = 0;
    private static final int インデックス_在外選挙人名簿_行 = 1;
    private static final RString 在外選挙人名簿管理メニュー = new RString("AFAMNB3");
    private static final RString 在外投票人名簿管理メニュー = new RString("AFAMNG3");
    private static final RString 衆議院小選挙区 = new RString("衆議院小選挙区");
    private static final RString 全角スペース5文字 = new RString("　　　　　");

    private final AfT121ZaigaiSenkyoninMeiboDac dac_AfT121;
    private final UaFt200FindShikibetsuTaishoFunctionDac dac_UaFt200;
    private final AfT122ZaigaiSenkyoShikakuDac dac_AfT122;
    private final AfT123ZaigaiSenkyoninJushoDac dac_AfT123;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public MeibotorokuZaigai() {
        dac_AfT121 = InstanceProvider.create(AfT121ZaigaiSenkyoninMeiboDac.class);
        dac_UaFt200 = InstanceProvider.create(UaFt200FindShikibetsuTaishoFunctionDac.class);
        dac_AfT122 = InstanceProvider.create(AfT122ZaigaiSenkyoShikakuDac.class);
        dac_AfT123 = InstanceProvider.create(AfT123ZaigaiSenkyoninJushoDac.class);
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac_AfT121 {@link AfT121ZaigaiSenkyoninMeiboDac}
     * @param dac_UaFt200 {@link UaFt200FindShikibetsuTaishoFunctionDac}
     * @param dac_AfT122 {@link AfT122ZaigaiSenkyoShikakuDac}
     * @param dac_AfT123 {@link AfT123ZaigaiSenkyoninJushoDac}
     * @param mapperProvider {@link AfaMapperProvider}
     */
    MeibotorokuZaigai(
            AfT121ZaigaiSenkyoninMeiboDac dac_AfT121,
            UaFt200FindShikibetsuTaishoFunctionDac dac_UaFt200,
            AfT122ZaigaiSenkyoShikakuDac dac_AfT122,
            AfT123ZaigaiSenkyoninJushoDac dac_AfT123,
            AfaMapperProvider mapperProvider) {
        this.dac_AfT121 = dac_AfT121;
        this.dac_UaFt200 = dac_UaFt200;
        this.dac_AfT122 = dac_AfT122;
        this.dac_AfT123 = dac_AfT123;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link MeibotorokuZaigai}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link MeibotorokuZaigai}のインスタンス
     */
    public static MeibotorokuZaigai createInstance() {
        return InstanceProvider.create(MeibotorokuZaigai.class);
    }

    /**
     * パラメータより、在外選挙人名簿．頁と行を取得する。
     *
     * @param 抄本番号 ShohonNo
     * @param 投票区コード RString
     * @param 国外分類コード RString
     * @return 在外選挙人名簿リスト List<Integer>{在外選挙人名簿_頁,在外選挙人名簿_行}
     */
    public List<Integer> get在外選挙人名簿_頁と行(ShohonNo 抄本番号, RString 投票区コード, RString 国外分類コード) {
        List<Integer> 在外選挙人名簿リスト = new ArrayList<>();
        for (int i = 0; i <= インデックス_在外選挙人名簿_行; i++) {
            在外選挙人名簿リスト.add(0);
        }
        int 在外選挙人名簿_頁 = 0;
        int 在外選挙人名簿_行 = 0;
        int 最大頁 = 0;
        int 最大行 = 0;
        AfT121ZaigaiSenkyoninMeiboEntity entityMaxPage = dac_AfT121.selectMaxPage(抄本番号, 国外分類コード, 国外分類コード);
        if (null == entityMaxPage) {
            return 在外選挙人名簿リスト;
        }
        最大頁 = entityMaxPage.getPage();
        AfT121ZaigaiSenkyoninMeiboEntity entityMaxGyo = dac_AfT121.selectMaxGyo(最大頁);
        if (null == entityMaxGyo) {
            return 在外選挙人名簿リスト;
        }
        最大行 = entityMaxGyo.getGyo();
        RString 抄本_在外_ページ行数 = BusinessConfig.get(ConfigKeysAFA.抄本_在外_ページ行数, SubGyomuCode.AFA選挙本体);
        int 最大印字行 = RString.isNullOrEmpty(抄本_在外_ページ行数) ? 0 : Integer.valueOf(抄本_在外_ページ行数.toString());
        if (最大行 < 最大印字行) {
            在外選挙人名簿_頁 = 最大頁;
            在外選挙人名簿_行 = 最大行 + 1;
        }
        if (最大行 == 最大印字行) {
            在外選挙人名簿_頁 = 最大頁 + 1;
            在外選挙人名簿_行 = 1;
        }
        在外選挙人名簿リスト.set(インデックス_在外選挙人名簿_頁, 在外選挙人名簿_頁);
        在外選挙人名簿リスト.set(インデックス_在外選挙人名簿_行, 在外選挙人名簿_行);
        return 在外選挙人名簿リスト;
    }

    /**
     * パラメータより、本人情報初期情報を取得する。
     *
     * @param 識別コード ShikibetsuCode
     * @return 本人情報初期情報
     */
    public HonninJohoResult get本人情報初期情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先));
        key.set識別コード(識別コード);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        IPsmCriteria psmCriteria = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSM情報リスト = dac_UaFt200.select(psmCriteria, 1);
        UaFt200FindShikibetsuTaishoEntity 宛名PSM = null;
        YubinNo 本籍郵便番号 = YubinNo.EMPTY;
        if (null != 宛名PSM情報リスト && !宛名PSM情報リスト.isEmpty()) {
            宛名PSM = 宛名PSM情報リスト.get(0);
            ZenkokuJushoCode 転入前全国住所コード = 宛名PSM.getZenkokuJushoCode();
            ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
            if (null != 転入前全国住所コード && !転入前全国住所コード.isEmpty()) {
                LasdecCode 地方公共団体コード = new LasdecCode(転入前全国住所コード.getShichosonCode6());
                ShichosonAtesaki atesaki = finder.get市町村宛先(地方公共団体コード, SofusakiGroup.選挙人情報関連.getCode());
                本籍郵便番号 = atesaki.get郵便番号();
            }
        }
        return new HonninJohoResult(宛名PSM, 本籍郵便番号);
    }

    /**
     * パラメータより、在外選挙異動累積情報を取得する。
     *
     * @param 識別コード ShikibetsuCode
     * @return 在外選挙異動累積情報 ZaigaiSenkyoIdouRuisekiResult
     */
    public ZaigaiSenkyoIdouRuisekiResult get在外選挙異動累積情報(ShikibetsuCode 識別コード) {
        IMeibotorokuZaigaiMapper mapper = mapperProvider.create(IMeibotorokuZaigaiMapper.class);
        ZaigaiSenkyoIdouRuisekiEntity entity = mapper.select在外選挙異動累積情報(識別コード);
        return new ZaigaiSenkyoIdouRuisekiResult(entity);
    }

    /**
     * パラメータより、在外選挙人情報のデータを取得する。
     *
     * @param 申請番号 int
     * @param 識別コード ShikibetsuCode
     * @return 在外選挙人情報
     */
    public ZaigaiSenkyoninJohoResult get在外選挙人情報のデータ(int 申請番号, ShikibetsuCode 識別コード) {
        ZaigaiSenkyoninShinseiJohoEntity 在外選挙人申請情報 = get在外選挙人申請情報(申請番号, 識別コード);
        AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_本籍 = get在外選挙人住所情報(申請番号, 識別コード,
                JushoShuruiKubun.本籍地住所.getコード());
        AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_最終住所 = get在外選挙人住所情報(申請番号, 識別コード,
                JushoShuruiKubun.国外転出前最終住所.getコード());
        AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_国内転入先住所 = get在外選挙人住所情報(申請番号, 識別コード,
                JushoShuruiKubun.国内転入先住所.getコード());
        AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_海外住所 = get在外選挙人住所情報(申請番号, 識別コード,
                JushoShuruiKubun.海外住所.getコード());
        AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_海外送付先住所 = get在外選挙人住所情報(申請番号, 識別コード,
                JushoShuruiKubun.海外送付先住所.getコード());
        AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格 = get在外選挙資格(申請番号, 識別コード);
        RString 選挙区名 = get選挙区名(申請番号, 識別コード);
        AfT503SenkyokuEntity 選挙情報 = new AfT503SenkyokuEntity();
        選挙情報.setSenkyokuName(選挙区名);
        return new ZaigaiSenkyoninJohoResult(在外選挙人申請情報,
                在外選挙人住所情報_本籍,
                在外選挙人住所情報_最終住所,
                在外選挙人住所情報_国内転入先住所,
                在外選挙人住所情報_海外住所,
                在外選挙人住所情報_海外送付先住所,
                在外選挙資格,
                選挙情報);
    }

    private ZaigaiSenkyoninShinseiJohoEntity get在外選挙人申請情報(int 申請番号, ShikibetsuCode 識別コード) {
        IMeibotorokuZaigaiMapper mapper = mapperProvider.create(IMeibotorokuZaigaiMapper.class);
        return mapper.select在外選挙人申請情報(申請番号, 識別コード);
    }

    private AfT123ZaigaiSenkyoninJushoEntity get在外選挙人住所情報(int 申請番号, ShikibetsuCode 識別コード, Code 住所種類区分) {
        return dac_AfT123.select(識別コード, 申請番号, 住所種類区分);
    }

    private AfT122ZaigaiSenkyoShikakuEntity get在外選挙資格(int 申請番号, ShikibetsuCode 識別コード) {
        return dac_AfT122.select(識別コード, 申請番号);
    }

    private RString get選挙区名(int 申請番号, ShikibetsuCode 識別コード) {
        RString menuID = ResponseHolder.getMenuID();
        if (!RString.isNullOrEmpty(menuID)) {
            if (menuID.startsWith(在外選挙人名簿管理メニュー)) {
                IMeibotorokuZaigaiMapper mapper = mapperProvider.create(IMeibotorokuZaigaiMapper.class);
                AfT503SenkyokuEntity entity = mapper.select選挙情報(申請番号, 識別コード);
                return null == entity ? RString.EMPTY : 衆議院小選挙区.concat(全角スペース5文字).concat(entity.getSenkyokuName());
            }
            if (menuID.startsWith(在外投票人名簿管理メニュー)) {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

}
