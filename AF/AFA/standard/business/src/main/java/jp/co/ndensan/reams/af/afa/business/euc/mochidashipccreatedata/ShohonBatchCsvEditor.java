/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.HyojiJiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShikkenKubun;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata.AFABTE801SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.SenkyoninInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.ShohonCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抄本ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class ShohonBatchCsvEditor {

    private final ShohonCsvEntity data;
    private final MochidashiPcCommonUtil common;
    private final ShikakuHantei shikakuHantei;
    private final TohyoShikakuHantei tohyoShikakuHantei;
    private final FlexibleDate 基準日;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE801SelectProcessParameter
     */
    public ShohonBatchCsvEditor(AFABTE801SelectProcessParameter parameter) {
        common = MochidashiPcCommonUtil.createInstance();
        data = new ShohonCsvEntity();
        shikakuHantei = new ShikakuHantei();
        tohyoShikakuHantei = new TohyoShikakuHantei();
        基準日 = parameter.get受理日();
    }

    /**
     * usualProcessCount
     *
     * @param current SenkyoninInfoEntity
     * @param code String
     * @return ShohonCsvEntity
     */
    public ShohonCsvEntity usualProcess(SenkyoninInfoEntity current, RString code) {
        tohyokuセット(current, code);
        return data;
    }

    /**
     * keyBreakProcessByShohonNo
     *
     * @param before SenkyoninInfoEntity
     * @param current SenkyoninInfoEntity
     * @return Boolean
     */
    public Boolean keyBreakProcessByShohonNo(SenkyoninInfoEntity before, SenkyoninInfoEntity current) {
        return isNew抄本(before, current);
    }

    /**
     * keyBreakProcessByTohyoku
     *
     * @param before SenkyoninInfoEntity
     * @param current SenkyoninInfoEntity
     * @return Boolean
     */
    public Boolean keyBreakProcessByTohyoku(SenkyoninInfoEntity before, SenkyoninInfoEntity current) {
        return isNew投票区コード(before, current);
    }

    /**
     * createLastProcess
     *
     * @return ShohonCsvEntity
     */
    public ShohonCsvEntity createLastProcess() {
        return null;
    }

    /**
     * 抄本判断。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew抄本(SenkyoninInfoEntity before, SenkyoninInfoEntity current) {
        if (null == before) {
            return false;
        }
        ShohonNo 抄本前 = before.get抄本Entity().getShohonNo();
        ShohonNo 抄本現 = current.get抄本Entity().getShohonNo();

        return !(null != 抄本前 && null != 抄本現 && 抄本前.equals(抄本現));

    }

    /**
     * 投票区判断。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew投票区コード(SenkyoninInfoEntity before, SenkyoninInfoEntity current) {
        if (null == before) {
            return false;
        }
        RString 投票区前 = before.get選挙人名簿Entity().getTohyokuCode();
        RString 投票区現 = current.get選挙人名簿Entity().getTohyokuCode();

        return !(null != 投票区前 && null != 投票区現 && 投票区前.equals(投票区現));

    }

    private void tohyokuセット(SenkyoninInfoEntity current, RString code) {
        data.set抄本番号(common.toRString(current.get選挙人名簿Entity().getShohonNo()));
        data.setグループコード(current.get選挙人名簿Entity().getGroupCode());
        if (null != current.get投票区投票所対応Entity()) {
            data.set選挙区コード(current.get投票区投票所対応Entity().getSenkyokuCode());
        }
        data.set投票区コード(current.get選挙人名簿Entity().getTohyokuCode());
        data.set冊(current.get選挙人名簿Entity().getSatsu());
        data.set頁(common.toRString(current.get選挙人名簿Entity().getPage()));
        data.set行(common.toRString(current.get選挙人名簿Entity().getGyo()));
        data.set市町村コード(code);
        data.set郵便番号(common.toRString(current.get宛名PSMEntity().getJutonaiYubinNo()));
        data.set住所コード(common.toRString(current.get宛名PSMEntity().getJutonaiChoikiCode()));
        data.set住所(common.convertTtoRString(current.get宛名PSMEntity().getJutonaiJusho()));
        data.set行政区コード(common.toRString(current.get宛名PSMEntity().getGyoseikuCode()));
        data.set行政区名(common.convertTtoRString(current.get宛名PSMEntity().getGyoseikuName()));
        data.set地区コード1(common.toRString(current.get宛名PSMEntity().getChikuCode1()));
        data.set地区名1(common.convertTtoRString(current.get宛名PSMEntity().getChikuName1()));
        data.set地区コード2(common.toRString(current.get宛名PSMEntity().getChikuCode2()));
        data.set地区名2(common.convertTtoRString(current.get宛名PSMEntity().getChikuName2()));
        data.set地区コード3(common.toRString(current.get宛名PSMEntity().getChikuCode3()));
        data.set地区名3(common.convertTtoRString(current.get宛名PSMEntity().getChikuName3()));
        data.set番地コード1(common.toRString(current.get宛名PSMEntity().getJutonaiBanchiCode1()));
        data.set番地コード2(common.toRString(current.get宛名PSMEntity().getJutonaiBanchiCode2()));
        data.set番地コード3(common.toRString(current.get宛名PSMEntity().getJutonaiBanchiCode3()));
        data.set番地(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getJutonaiBanchi())));
        data.set方書コード(RString.EMPTY);
        data.set方書(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getJutonaiKatagaki())));
        data.set転入前郵便番号(common.toRString(current.get宛名PSMEntity().getTennyumaeYubinNo()));
        data.set転入前全国住所コード(common.toRString(current.get宛名PSMEntity().getTennyumaeZenkokuJushoCode()));
        data.set転入前住所(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTennyumaeJusho())));
        data.set転入前番地(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTennyumaeBanchi())));
        data.set転入前方書(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTennyumaeKatagaki())));
        if (RString.isNullOrEmpty(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiYubinNo()))) {
            data.set転出先郵便番号(common.toRString(current.get宛名PSMEntity().getTenshutsuYoteiYubinNo()));
        } else {
            data.set転出先郵便番号(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiYubinNo()));
        }
        if (RString.isNullOrEmpty(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiZenkokuJushoCode()))) {
            data.set転出先全国住所コード(common.toRString(current.get宛名PSMEntity().getTenshutsuYoteiZenkokuJushoCode()));
        } else {
            data.set転出先全国住所コード(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiZenkokuJushoCode()));
        }
        if (RString.isNullOrEmpty(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiJusho()))) {
            data.set転出先住所(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTenshutsuYoteiJusho())));
        } else {
            data.set転出先住所(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiJusho())));
        }
        if (RString.isNullOrEmpty(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiBanchi()))) {
            data.set転出先番地(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTenshutsuYoteiBanchi())));
        } else {
            data.set転出先番地(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiBanchi())));
        }
        if (RString.isNullOrEmpty(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiKatagaki()))) {
            data.set転出先方書(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTenshutsuYoteiKatagaki())));
        } else {
            data.set転出先方書(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getTenshutsuKakuteiKatagaki())));
        }
        if (RString.isNullOrEmpty(current.get宛名PSMEntity().getTenshutsuKakuteiSetainushimei())) {
            data.set転出先世帯主名(common.convertTtoRString(current.get宛名PSMEntity().getTenshutsuYoteiSetainushimei()));
        } else {
            data.set転出先世帯主名(common.convertTtoRString(current.get宛名PSMEntity().getTenshutsuKakuteiSetainushimei()));
        }
        data.set住民コード(common.toRString(current.get選挙人名簿Entity().getShikibetsuCode()));
        data.set漢字氏名(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getMeisho())));
        data.setカナ氏名(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getKanaMeisho())));
        data.set検索用カナ姓名(RString.EMPTY);
        data.set検索用カナ姓(RString.EMPTY);
        data.set検索用カナ名(RString.EMPTY);
        data.set漢字通称名(RString.EMPTY);
        data.setカナ通称名(RString.EMPTY);
        data.set世帯コード(common.toRString(current.get宛名PSMEntity().getSetaiCode()));
        data.set世帯主名(common.convertTtoRString(common.toRString(current.get宛名PSMEntity().getSetainushiMei())));
        data.setカナ世帯主名(common.convertTtoRString(RString.EMPTY));
        data.set住民種別(common.nullToRString(current.get宛名PSMEntity().getJuminShubetsuCode())
                .concat(common.nullToRString(current.get宛名PSMEntity().getJuminJotaiCode())));
        data.set生年月日(common.toRString(current.get宛名PSMEntity().getSeinengappiYMD()));
        data.set性別コード(current.get宛名PSMEntity().getSeibetsuCode());
        data.set続柄コード(common.toRString(current.get宛名PSMEntity().getTsuzukigaraCode()));
        data.set続柄(common.convertTtoRString(current.get宛名PSMEntity().getTsuzukigara()));
        data.set住基表示順(common.toRString(current.get宛名PSMEntity().getJuminhyoHyojijun()));
        data.set住基登録年月日(common.toRString(current.get宛名PSMEntity().getTorokuIdoYMD()));
        data.set住基消除年月日(common.toRString(current.get宛名PSMEntity().getShojoIdoYMD()));
        data.set転入届出年月日(common.toRString(current.get宛名PSMEntity().getJuteiTodokedeYMD()));
        data.set転入異動年月日(common.toRString(current.get宛名PSMEntity().getJuteiIdoYMD()));
        data.set転入区分(current.get宛名PSMEntity().getJuteiJiyuCode());
        data.set転出届出年月日(common.toRString(current.get宛名PSMEntity().getShojoTodokedeYMD()));
        data.set転出異動年月日(common.toRString(current.get宛名PSMEntity().getShojoIdoYMD()));
        data.set転出区分(current.get宛名PSMEntity().getShojoJiyuCode());
        data.set選挙資格区分(common.toRString(current.get選挙資格Entity().getShikakuKubun()));
        data.set選挙登録年月日(common.toRString(current.get選挙資格Entity().getMeiboTorokuYMD()));
        data.set選挙登録理由コード(common.toRString(current.get選挙資格Entity().getTorokuJiyuCode()));
        data.set表示年月日(common.toRString(current.get選挙資格Entity().getHyojiYMD()));
        data.set表示理由コード(common.toRString(current.get選挙資格Entity().getHyojiJiyuCode()));
        data.set抹消年月日(common.toRString(current.get選挙資格Entity().getMasshoYMD()));
        data.set抹消理由コード(common.toRString(current.get選挙資格Entity().getMasshoJiyuCode()));

        setTohyokuData2(current);

    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private void setTohyokuData2(SenkyoninInfoEntity current) {
        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity;
        senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        senkyoninTohyoJokyoEntity.setAtenaPSMEntity(current.get宛名PSMEntity());
        if (shikakuHantei.is都道府県内転出者(senkyoninTohyoJokyoEntity)) {
            if (SennkyoSikakuKubun.表示者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))) {
                data.set転出表示区分(MochidashiPcCreateDataEnum.ONE.getRString());
            } else if (SennkyoSikakuKubun.抹消者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))) {
                data.set転出表示区分(MochidashiPcCreateDataEnum.FOUR.getRString());
            }
        } else if (shikakuHantei.is都道府県外転出者(senkyoninTohyoJokyoEntity)) {
            if (SennkyoSikakuKubun.表示者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))) {
                data.set転出表示区分(MochidashiPcCreateDataEnum.TWO.getRString());
            } else if (SennkyoSikakuKubun.抹消者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))) {
                data.set転出表示区分(MochidashiPcCreateDataEnum.FIVE.getRString());
            }
        } else {
            if (SennkyoSikakuKubun.表示者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))) {
                data.set転出表示区分(MochidashiPcCreateDataEnum.THREE.getRString());
            } else if (SennkyoSikakuKubun.抹消者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))) {
                data.set転出表示区分(MochidashiPcCreateDataEnum.SIX.getRString());
            }
        }

        if (SennkyoSikakuKubun.抹消者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))
                && (MasshoJiyuCodeEnum.転出4カ月経過抹消.getCode().equals(current.get選挙資格Entity().getMasshoJiyuCode())
                || MasshoJiyuCodeEnum.職権消除4カ月経過抹消.getCode().equals(current.get選挙資格Entity().getMasshoJiyuCode()))
                && (MochidashiPcCreateDataEnum.THREE.getRString().equals(current.get宛名PSMEntity().getJuminJotaiCode())
                || MochidashiPcCreateDataEnum.NINE.getRString().equals(current.get宛名PSMEntity().getJuminJotaiCode()))) {
            data.set失権区分(ShikkenKubun.四ヶ月経過抹消者.getKey());
        } else if (SennkyoSikakuKubun.表示者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))
                && (HyojiJiyuCode.公職選挙法第11条1項2号該当.getKey().equals(common.toRString(current.get選挙資格Entity().getHyojiJiyuCode()))
                || HyojiJiyuCode.公職選挙法第11条1項3号該当.getKey().equals(common.toRString(current.get選挙資格Entity().getHyojiJiyuCode()))
                || HyojiJiyuCode.公職選挙法第11条1項4号該当.getKey().equals(common.toRString(current.get選挙資格Entity().getHyojiJiyuCode()))
                || HyojiJiyuCode.公職選挙法第11条1項5号該当.getKey().equals(common.toRString(current.get選挙資格Entity().getHyojiJiyuCode()))
                || HyojiJiyuCode.公職選挙法第11条2項該当.getKey().equals(common.toRString(current.get選挙資格Entity().getHyojiJiyuCode())))) {
            data.set失権区分(ShikkenKubun.失権者.getKey());
        } else if ((SennkyoSikakuKubun.表示者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))
                && HyojiJiyuCode.転出.getKey().equals(common.toRString(current.get選挙資格Entity().getHyojiJiyuCode()))
                && (SennkyoLevel.都道府県.value().equals(common.toRString(current.get選挙Entity().getSenkyoLevel()))
                && !common.subRString(common.toRString(current.get宛名PSMEntity().getGenLasdecCode()),
                        MochidashiPcCreateDataEnum.TWO.getInteger())
                .equals(common.subRString(common.toRString(current.get宛名PSMEntity().getZenkokuJushoCode()),
                                MochidashiPcCreateDataEnum.TWO.getInteger())))
                || (SennkyoLevel.市区町村.value().equals(common.toRString(current.get選挙Entity().getSenkyoLevel()))
                && !common.subRString(common.toRString(current.get宛名PSMEntity().getGenLasdecCode()),
                        MochidashiPcCreateDataEnum.FIVE.getInteger())
                .equals(common.subRString(common.toRString(current.get宛名PSMEntity().getZenkokuJushoCode()),
                                MochidashiPcCreateDataEnum.FIVE.getInteger()))))) {
            data.set失権区分(ShikkenKubun.公民権停止者.getKey());
        } else if (MochidashiPcCreateDataEnum.ONE.getRString().equals(current.get宛名PSMEntity().getJuminJotaiCode())
                && SennkyoSikakuKubun.抹消者.value().equals(common.toRString(current.get選挙資格Entity().getShikakuKubun()))
                && MasshoJiyuCodeEnum.転出4カ月経過抹消.getCode().equals(current.get選挙資格Entity().getMasshoJiyuCode())) {
            data.set失権区分(ShikkenKubun.再転入者.getKey());
        }
        if (MochidashiPcCreateDataEnum.ONE.getRString().equals(current.get宛名PSMEntity().getJuminJotaiCode())) {
            data.set居住区分(MochidashiPcCreateDataEnum.ONE.getRString());
        } else {
            data.set居住区分(MochidashiPcCreateDataEnum.TWO.getRString());
        }

        Map<SenkyoNo, RString> map不在者期日前 = getMap();
        Map<SenkyoNo, RString> map投票状況 = getMap();
        Map<SenkyoNo, RString> map交付施設コード = getMap();

        if (null != current.get投票状況Entity() && map投票状況.containsKey(current.get投票状況Entity().getSenkyoNo())) {
            senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
            SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
            senkyoJohoEntity.setShohonEntity(current.get抄本Entity());
            List<AfT111SenkyoEntity> senkyoList = new ArrayList<>();
            senkyoList.add(current.get選挙Entity());
            senkyoJohoEntity.setSenkyoEntity(senkyoList);
            senkyoninTohyoJokyoEntity.setSenkyoShikakuEntity(current.get選挙資格Entity());
            senkyoninTohyoJokyoEntity.setSenkyoJohoEntity(senkyoJohoEntity);
            senkyoninTohyoJokyoEntity.setAtenaPSMEntity(current.get宛名PSMEntity());
            if (tohyoShikakuHantei.has投票資格Old(senkyoninTohyoJokyoEntity, current.get選挙人名簿Entity().getShikibetsuCode(), 基準日)) {
                map不在者期日前.put(current.get投票状況Entity().getSenkyoNo(), MochidashiPcCreateDataEnum.ONE.getRString());
            } else {
                map不在者期日前.put(current.get投票状況Entity().getSenkyoNo(), MochidashiPcCreateDataEnum.ZERO.getRString());
            }
            map投票状況.put(current.get投票状況Entity().getSenkyoNo(), common.toRString(current.get投票状況Entity().getTohyoJokyo()));
            map交付施設コード.put(current.get投票状況Entity().getSenkyoNo(), current.get投票状況Entity().getShisetsuCode());
        }
        data.set不在者期日前１(map投票状況.get(MochidashiPcCreateDataEnum.ONE.getSenkyoNo()));
        data.set不在者期日前２(map投票状況.get(MochidashiPcCreateDataEnum.TWO.getSenkyoNo()));
        data.set不在者期日前３(map投票状況.get(MochidashiPcCreateDataEnum.THREE.getSenkyoNo()));
        data.set不在者期日前４(map投票状況.get(MochidashiPcCreateDataEnum.FOUR.getSenkyoNo()));
        data.set不在者期日前５(map投票状況.get(MochidashiPcCreateDataEnum.FIVE.getSenkyoNo()));
        data.set不在者期日前６(map投票状況.get(MochidashiPcCreateDataEnum.SIX.getSenkyoNo()));
        data.set不在者期日前７(map投票状況.get(MochidashiPcCreateDataEnum.SEVEN.getSenkyoNo()));
        data.set不在者期日前８(map投票状況.get(MochidashiPcCreateDataEnum.EIGHT.getSenkyoNo()));
        data.set不在者期日前９(map投票状況.get(MochidashiPcCreateDataEnum.NINE.getSenkyoNo()));
        data.set投票状況１(map投票状況.get(MochidashiPcCreateDataEnum.ONE.getSenkyoNo()));
        data.set投票状況２(map投票状況.get(MochidashiPcCreateDataEnum.TWO.getSenkyoNo()));
        data.set投票状況３(map投票状況.get(MochidashiPcCreateDataEnum.THREE.getSenkyoNo()));
        data.set投票状況４(map投票状況.get(MochidashiPcCreateDataEnum.FOUR.getSenkyoNo()));
        data.set投票状況５(map投票状況.get(MochidashiPcCreateDataEnum.FIVE.getSenkyoNo()));
        data.set投票状況６(map投票状況.get(MochidashiPcCreateDataEnum.SIX.getSenkyoNo()));
        data.set投票状況７(map投票状況.get(MochidashiPcCreateDataEnum.SEVEN.getSenkyoNo()));
        data.set投票状況８(map投票状況.get(MochidashiPcCreateDataEnum.EIGHT.getSenkyoNo()));
        data.set投票状況９(map投票状況.get(MochidashiPcCreateDataEnum.NINE.getSenkyoNo()));
        data.set交付施設コード１(map投票状況.get(MochidashiPcCreateDataEnum.ONE.getSenkyoNo()));
        data.set交付施設コード２(map投票状況.get(MochidashiPcCreateDataEnum.TWO.getSenkyoNo()));
        data.set交付施設コード３(map投票状況.get(MochidashiPcCreateDataEnum.THREE.getSenkyoNo()));
        data.set交付施設コード４(map投票状況.get(MochidashiPcCreateDataEnum.FOUR.getSenkyoNo()));
        data.set交付施設コード５(map投票状況.get(MochidashiPcCreateDataEnum.FIVE.getSenkyoNo()));
        data.set交付施設コード６(map投票状況.get(MochidashiPcCreateDataEnum.SIX.getSenkyoNo()));
        data.set交付施設コード７(map投票状況.get(MochidashiPcCreateDataEnum.SEVEN.getSenkyoNo()));
        data.set交付施設コード８(map投票状況.get(MochidashiPcCreateDataEnum.EIGHT.getSenkyoNo()));
        data.set交付施設コード９(map投票状況.get(MochidashiPcCreateDataEnum.NINE.getSenkyoNo()));
        List<AfT114FuzaishaTohyoShikakuEntity> 不在者投票資格List = new ArrayList<>();
        if (null != current.get不在者投票資格Entity() && null != current.get不在者投票資格Entity().getTohyoShikakuShurui()) {
            不在者投票資格List.add(current.get不在者投票資格Entity());
        }
        if (shikakuHantei.has洋上投票資格(current.get選挙人名簿Entity().getShikibetsuCode(), 基準日, 不在者投票資格List)) {
            data.set洋上投票者区分(MochidashiPcCreateDataEnum.ONE.getRString());
        } else {
            data.set洋上投票者区分(MochidashiPcCreateDataEnum.ZERO.getRString());
        }
        data.set耕作面積(RString.EMPTY);
        data.set法人名(RString.EMPTY);
        if (null != current.get海区付随情報Entity()) {
            data.set組合コード(current.get海区付随情報Entity().getKumiaiCode());
        }
        if (null != current.get組合マスタEntity()) {
            data.set組合名(common.convertTtoRString(current.get組合マスタEntity().getKumiaiName()));
        }
        data.set代表者区分(RString.EMPTY);
        data.set従事日数(RString.EMPTY);
        data.set端末ID(RString.EMPTY);
        if (null != current.getFindeCautionShaMapperEntity()) {
            data.set削除フラグ(common.booleanToRString(current.getFindeCautionShaMapperEntity().isGaitoKubun()));
        }
        data.set更新カウンタ(common.toRString(current.get選挙人名簿Entity().getUpdateCount()));
        data.set作成日時(common.toRString(current.get選挙人名簿Entity().getInsertTimestamp()));
        data.set作成ユーザ(current.get選挙人名簿Entity().getInsertReamsLoginId());
        data.set更新日時(common.toRString(current.get選挙人名簿Entity().getLastUpdateTimestamp()));
        data.set更新ユーザ(current.get選挙人名簿Entity().getLastUpdateReamsLoginId());

    }

    private Map<SenkyoNo, RString> getMap() {
        Map<SenkyoNo, RString> map = new HashMap<>();
        map.put(MochidashiPcCreateDataEnum.ONE.getSenkyoNo(), RString.EMPTY);
        map.put(MochidashiPcCreateDataEnum.TWO.getSenkyoNo(), RString.EMPTY);
        map.put(MochidashiPcCreateDataEnum.THREE.getSenkyoNo(), RString.EMPTY);
        map.put(MochidashiPcCreateDataEnum.FOUR.getSenkyoNo(), RString.EMPTY);
        map.put(MochidashiPcCreateDataEnum.FIVE.getSenkyoNo(), RString.EMPTY);
        map.put(MochidashiPcCreateDataEnum.SIX.getSenkyoNo(), RString.EMPTY);
        map.put(MochidashiPcCreateDataEnum.SEVEN.getSenkyoNo(), RString.EMPTY);
        map.put(MochidashiPcCreateDataEnum.EIGHT.getSenkyoNo(), RString.EMPTY);
        map.put(MochidashiPcCreateDataEnum.NINE.getSenkyoNo(), RString.EMPTY);
        return map;
    }

}
