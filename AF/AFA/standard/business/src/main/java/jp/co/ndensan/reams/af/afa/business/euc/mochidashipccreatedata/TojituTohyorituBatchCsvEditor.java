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
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.TohyoShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipccreatedata.AFABTE801SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.TojituTohyorituEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.TojituTohyorituCsvEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 管理情報ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class TojituTohyorituBatchCsvEditor {

    private final TojituTohyorituCsvEntity data1;
    private final TojituTohyorituCsvEntity data2;
    private final TojituTohyorituCsvEntity data3;
    private final Map<RString, Integer> map1 = new HashMap<>();
    private final Map<RString, Integer> map2 = new HashMap<>();
    private final Map<RString, Integer> map3 = new HashMap<>();
    private final MochidashiPcCommonUtil common;
    private final RString zero = MochidashiPcCreateDataEnum.ZERO.getRString();
    private final RString one = MochidashiPcCreateDataEnum.ONE.getRString();
    private final RString two = MochidashiPcCreateDataEnum.TWO.getRString();
    private final RString three = MochidashiPcCreateDataEnum.THREE.getRString();
    private final RString four = MochidashiPcCreateDataEnum.FOUR.getRString();
    private final RString five = MochidashiPcCreateDataEnum.FIVE.getRString();
    private final RString 男 = MochidashiPcCreateDataEnum.男.getRString();
    private final RString 女 = MochidashiPcCreateDataEnum.女.getRString();
    private final RString 代理投票者 = MochidashiPcCreateDataEnum.代理投票者.getRString();
    private final RString 点字用紙 = MochidashiPcCreateDataEnum.点字用紙.getRString();
    private final RString 棄権 = MochidashiPcCreateDataEnum.棄権.getRString();
    private final RString システム日付;
    private final int 終了時刻 = MochidashiPcCreateDataEnum.終了時刻.getInteger();
    private final int 五分刻み = MochidashiPcCreateDataEnum.FIVE.getInteger();
    private final RString 六十分 = MochidashiPcCreateDataEnum.SIXTY.getRString();
    private final int 四十 = MochidashiPcCreateDataEnum.FORTY.getInteger();
    private final TohyoShikakuHantei tohyoShikakuHantei;
    private final FlexibleDate 基準日;
    private final RString loginUserId;
    private final RString clientId;
    private final List<TojituTohyorituCsvEntity> 当日投票率 = new ArrayList<>();
    private int 開始時刻;
    private TojituTohyorituEntity entity;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE801SelectProcessParameter
     * @param loginUserId RString
     */
    public TojituTohyorituBatchCsvEditor(AFABTE801SelectProcessParameter parameter, RString loginUserId) {
        common = MochidashiPcCommonUtil.createInstance();
        システム日付 = common.toRString(RDateTime.now());
        開始時刻 = MochidashiPcCreateDataEnum.開始時刻.getInteger();
        tohyoShikakuHantei = new TohyoShikakuHantei();
        data1 = new TojituTohyorituCsvEntity();
        data2 = new TojituTohyorituCsvEntity();
        data3 = new TojituTohyorituCsvEntity();
        putMap(map1);
        putMap(map2);
        putMap(map3);
        基準日 = parameter.get受理日();
        this.loginUserId = loginUserId;
        this.clientId = parameter.get端末ID();
    }

    /**
     * usualProcessCount
     *
     * @param current TojituTohyorituEntity
     */
    public void usualProcess(TojituTohyorituEntity current) {
        if (null != current.get選挙人名簿Entity()) {
            期日前不在者集計セット(current, map1, MochidashiPcCreateDataEnum.ONE.getCode());
            期日前不在者集計セット(current, map2, MochidashiPcCreateDataEnum.TWO.getCode());
            if (null != current.get選挙資格Entity()) {
                有権者集計セット(current, map3);
            }
        }
        entity = current;
    }

    /**
     * keyBreakProcess
     *
     * @param current TojituTohyorituEntity
     * @param before TojituTohyorituEntity
     * @return TojituTohyorituCsvEntity
     */
    public List<TojituTohyorituCsvEntity> keyBreakProcessBySenkyo(TojituTohyorituEntity current, TojituTohyorituEntity before) {
        if (isNew選挙(before, current)) {
            当日投票率セット(before);
            return 当日投票率;
        }
        return null;
    }

    /**
     * keyBreakProcessByShohonNo
     *
     * @param before TojituTohyorituEntity
     * @param current TojituTohyorituEntity
     * @return Boolean
     */
    public List<TojituTohyorituCsvEntity> keyBreakProcessByShohonNo(TojituTohyorituEntity current, TojituTohyorituEntity before) {
        if (isNew抄本(before, current)) {
            当日投票率セット(before);
            return 当日投票率;
        }
        return null;
    }

    /**
     * keyBreakProcessByTohyoku
     *
     * @param current TojituTohyorituEntity
     * @param before TojituTohyorituEntity
     * @return Boolean
     */
    public List<TojituTohyorituCsvEntity> keyBreakProcessByTohyoku(TojituTohyorituEntity current, TojituTohyorituEntity before) {
        if (isNew投票区コード(before, current)) {
            当日投票率セット(before);
            return 当日投票率;
        }
        return null;
    }

    /**
     * 選挙判断。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew選挙(TojituTohyorituEntity before, TojituTohyorituEntity current) {
        if (null == before) {
            return false;
        }
        SenkyoNo 選挙前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙前 && null != 選挙現 && 選挙前.equals(選挙現));

    }

    /**
     * 抄本判断。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew抄本(TojituTohyorituEntity before, TojituTohyorituEntity current) {
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
    private boolean isNew投票区コード(TojituTohyorituEntity before, TojituTohyorituEntity current) {
        if (null == before) {
            return false;
        }
        RString 投票区前 = before.get投票区Entity().getTohyokuCode();
        RString 投票区現 = current.get投票区Entity().getTohyokuCode();

        return !(null != 投票区前 && null != 投票区現 && 投票区前.equals(投票区現));

    }

    /**
     * createLastProcess
     *
     * @return TojituTohyorituCsvEntity
     */
    public List<TojituTohyorituCsvEntity> createLastProcess() {
        if (null != entity) {
            当日投票率セット(entity);
            return 当日投票率;
        }
        return null;
    }

    private void 当日投票率セット(TojituTohyorituEntity current) {
        当日投票率.clear();
        tojituTohyorituセット(current, one, map1, data1);
        tojituTohyorituセット(current, two, map2, data2);
        tojituTohyorituセット(current, four, map3, data3);
        当日投票率.add(data1);
        当日投票率.add(data2);
        当日投票率.addAll(get五分刻みセット(current, three));
        当日投票率.add(data3);
        当日投票率.addAll(get五分刻みセット(current, five));

    }

    private void 期日前不在者集計セット(TojituTohyorituEntity current, Map<RString, Integer> map, Code kubun) {
        if (kubun.equals(current.get投票状況Entity().getKijitsuFuzaiKubun())) {
            if (one.equals(current.get宛名PSMEntity().getSeibetsuCode())) {
                map.put(男, map.get(男) + 1);
            } else {
                map.put(女, map.get(女) + 1);
            }

            if (current.get投票状況Entity().getDairiTohyoAriFlag()) {
                map.put(代理投票者, map.get(代理投票者) + 1);
            }

            if (current.get投票状況Entity().getTenjiFlag()) {
                map.put(点字用紙, map.get(点字用紙) + 1);
            }

            if (MochidashiPcCreateDataEnum.FIVE.getCode().equals(current.get投票状況Entity().getTohyoJokyo())) {
                map.put(棄権, map.get(棄権) + 1);
            }

        }
    }

    private void 有権者集計セット(TojituTohyorituEntity current, Map<RString, Integer> map) {

        SenkyoninTohyoJokyoEntity senkyoninTohyoJokyoEntity = new SenkyoninTohyoJokyoEntity();
        SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
        senkyoJohoEntity.setShohonEntity(current.get抄本Entity());
        List<AfT111SenkyoEntity> senkyoList = new ArrayList<>();
        senkyoList.add(current.get選挙Entity());
        senkyoJohoEntity.setSenkyoEntity(senkyoList);
        senkyoninTohyoJokyoEntity.setSenkyoShikakuEntity(current.get選挙資格Entity());
        senkyoninTohyoJokyoEntity.setSenkyoJohoEntity(senkyoJohoEntity);
        senkyoninTohyoJokyoEntity.setAtenaPSMEntity(current.get宛名PSMEntity());
        if (tohyoShikakuHantei.has投票資格Old(senkyoninTohyoJokyoEntity, current.get選挙人名簿Entity().getShikibetsuCode(), 基準日)) { //TODO
            if (one.equals(current.get宛名PSMEntity().getSeibetsuCode())) {
                map.put(男, map.get(男) + 1);
            } else {
                map.put(女, map.get(女) + 1);
            }
        }
    }

    private void tojituTohyorituセット(TojituTohyorituEntity current, RString type, Map<RString, Integer> map, TojituTohyorituCsvEntity data) {
        data.set抄本番号(common.toRString(current.get抄本Entity().getShohonNo()));
        data.set選挙番号(common.toRString(current.get選挙Entity().getSenkyoNo()));
        data.set投票区コード(current.get投票区Entity().getTohyokuCode());
        data.setデータ区分(type);
        data.set開始時刻(MochidashiPcCreateDataEnum.ALL0.getRString());
        data.set終了時刻(MochidashiPcCreateDataEnum.ALL9.getRString());
        data.set投票数_男(common.toRString(map.get(男)));
        data.set投票数_女(common.toRString(map.get(女)));
        data.set投票数_計(common.toRString(map.get(男) + map.get(女)));
        data.set代理投票者数(common.toRString(map.get(代理投票者)));
        data.set点字用紙数(common.toRString(map.get(点字用紙)));
        data.set棄権数(common.toRString(map.get(棄権)));
        data.set共通投票所_投票数_男(zero);
        data.set共通投票所_投票数_女(zero);
        data.set共通投票所_投票数_計(zero);
        data.set共通投票所_代理投票者数(zero);
        data.set共通投票所_点字用紙数(zero);
        data.set共通投票所_棄権数(zero);
        data.set端末ID(clientId);
        data.set削除フラグ(MochidashiPcCreateDataEnum.FALSE.getRString());
        data.set更新カウンタ(zero);
        data.set作成日時(システム日付);
        data.set作成ユーザ(loginUserId);
        data.set更新日時(システム日付);
        data.set更新ユーザ(loginUserId);
        putMap(map);
    }

    private List<TojituTohyorituCsvEntity> get五分刻みセット(TojituTohyorituEntity current, RString type) {
        List<TojituTohyorituCsvEntity> list = new ArrayList<>();
        TojituTohyorituCsvEntity fiveMin;
        while (開始時刻 != 終了時刻) {
            fiveMin = new TojituTohyorituCsvEntity();
            fiveMin.set抄本番号(common.toRString(current.get抄本Entity().getShohonNo()));
            fiveMin.set選挙番号(common.toRString(current.get選挙Entity().getSenkyoNo()));
            fiveMin.set投票区コード(current.get投票区Entity().getTohyokuCode());
            fiveMin.setデータ区分(type);
            fiveMin.set開始時刻(common.padZeroToLeft(common.toRString(開始時刻)));
            開始時刻 = 開始時刻 + 五分刻み;
            if (common.subRStringRight(common.toRString(開始時刻),
                    MochidashiPcCreateDataEnum.TWO.getInteger()).equals(六十分)) {
                開始時刻 = 開始時刻 + 四十;
            }
            fiveMin.set終了時刻(common.padZeroToLeft(common.toRString(開始時刻)));
            fiveMin.set投票数_男(zero);
            fiveMin.set投票数_女(zero);
            fiveMin.set投票数_計(zero);
            fiveMin.set代理投票者数(zero);
            fiveMin.set点字用紙数(zero);
            fiveMin.set棄権数(zero);
            fiveMin.set共通投票所_投票数_男(zero);
            fiveMin.set共通投票所_投票数_女(zero);
            fiveMin.set共通投票所_投票数_計(zero);
            fiveMin.set共通投票所_代理投票者数(zero);
            fiveMin.set共通投票所_点字用紙数(zero);
            fiveMin.set共通投票所_棄権数(zero);
            fiveMin.set端末ID(clientId);
            fiveMin.set削除フラグ(MochidashiPcCreateDataEnum.FALSE.getRString());
            fiveMin.set更新カウンタ(zero);
            fiveMin.set作成日時(システム日付);
            fiveMin.set作成ユーザ(loginUserId);
            fiveMin.set更新日時(システム日付);
            fiveMin.set更新ユーザ(loginUserId);
            list.add(fiveMin);
        }
        開始時刻 = MochidashiPcCreateDataEnum.開始時刻.getInteger();
        return list;
    }

    private void putMap(Map<RString, Integer> map) {
        map.put(男, 0);
        map.put(女, 0);
        map.put(代理投票者, 0);
        map.put(点字用紙, 0);
        map.put(棄権, 0);
    }

}
