/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyoShukeiData;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.Seibetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508.TohyoShukeiReportSource;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 投票日前日関連帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0280-020 lit
 */
public class TohyoShukeiBreakCore {

    private int 期日前投票男数;
    private int 期日前投票女数;
    private int 不在者投票男数;
    private int 不在者投票女数;
    private int 期日前投票男数小計用;
    private int 期日前投票女数小計用;
    private int 不在者投票男数小計用;
    private int 不在者投票女数小計用;
    private List<TohyoShukeiData> 小計リスト = new ArrayList<>();
    private final ZenjitsuCommonJohoItem 帳票共通ヘッダー;
    private final AFABTE504SelectProcessParameter param;

    private static final RString 投票区計 = new RString("＊＊＊　投　票　区　計　＊＊＊");
    private static final RString 選挙計 = new RString("＊＊＊　選　挙　　　計　＊＊＊");
    private static final RString 明細タイトル_合計 = new RString("投票区：投票区名");
    private static final int MAX_ROW = 30;
    private static final int 投票区名称_上限 = 13;
    private int ページ = 1;
    private int dataCount = 0;

    /**
     * 抄本_住所編集_ヘッダ部住所のENUM。
     */
    public enum ShohonJushoEditEnum {

        /**
         * 住所
         */
        住所(new RString("11"), new RString("住所")),
        /**
         * 行政区
         */
        行政区(new RString("12"), new RString("行政区")),
        /**
         * 地区コード1
         */
        地区コード1(new RString("13"), new RString("コード名称_地区の分類１")),
        /**
         * 地区コード2
         */
        地区コード2(new RString("14"), new RString("コード名称_地区の分類２")),
        /**
         * 地区コード3
         */
        地区コード3(new RString("15"), new RString("コード名称_地区の分類３"));
        private final RString key;
        private final RString 明細タイトル;

        /**
         * コンストラクス。
         *
         * @param key
         * @param 明細タイトル
         */
        ShohonJushoEditEnum(RString key, RString 明細タイトル) {
            this.key = key;
            this.明細タイトル = 明細タイトル;
        }

        /**
         * Keyを返す。
         *
         * @return Key
         */
        public RString getKey() {
            return this.key;
        }

        /**
         * 明細タイトルを返す。
         *
         * @return 明細タイトル
         */
        public RString get明細タイトル() {
            if (this.key.equals(地区コード1.getKey())) {
                return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
            } else if (this.key.equals(地区コード2.getKey())) {
                return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
            } else if (this.key.equals(地区コード3.getKey())) {
                return BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系);
            }
            return this.明細タイトル;
        }
    }

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE504SelectProcessParameter
     */
    public TohyoShukeiBreakCore(AFABTE504SelectProcessParameter parameter) {
        期日前投票男数 = 0;
        期日前投票女数 = 0;
        不在者投票男数 = 0;
        不在者投票女数 = 0;
        期日前投票男数小計用 = 0;
        期日前投票女数小計用 = 0;
        不在者投票男数小計用 = 0;
        不在者投票女数小計用 = 0;
        帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        this.param = parameter;
    }

    /**
     * Instanceを作成しました。
     *
     * @param 抄本_住所編集_ヘッダ部住所 抄本_住所編集_ヘッダ部住所
     * @return TohyoShukeiBreakCore
     */
    public TohyoShukeiBreakCore createInstance(RString 抄本_住所編集_ヘッダ部住所) {
        if (ShohonJushoEditEnum.住所.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
            return new TohyoShukeiBreakCoreJusho(param);
        } else if (ShohonJushoEditEnum.行政区.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
            return new TohyoShukeiBreakCoreGyoseiku(param);
        } else if (ShohonJushoEditEnum.地区コード1.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
            return new TohyoShukeiBreakCoreChiku1(param);
        } else if (ShohonJushoEditEnum.地区コード2.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
            return new TohyoShukeiBreakCoreChiku2(param);
        } else if (ShohonJushoEditEnum.地区コード3.getKey().equals(抄本_住所編集_ヘッダ部住所)) {
            return new TohyoShukeiBreakCoreChiku3(param);
        }
        return null;
    }

    /**
     * usualProcess
     *
     * @param current current
     */
    public void usualProcess(ZenjitsuPrintEntity current) {
        count(current);
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return List<TohyoShukeiData>
     */
    public List<TohyoShukeiData> keyBreakProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        List<TohyoShukeiData> writeEntityList = new ArrayList<>();
        if (isNewData(before, current) || isNew投票区コード(before, current) || isNew選挙(before, current)) {
            dataCount = dataCount + 1;
            writeEntityList.add(createPrintEntity(TohyoShukeiReportSource.DataType.データ.getKey(), before));
            clearDataCount();
        }

        if (isNew投票区コード(before, current) || isNew選挙(before, current)) {
            dataCount = dataCount + 1;
            writeEntityList.add(createPrintEntity(TohyoShukeiReportSource.DataType.小計.getKey(), before));
            小計リスト追加(createPrintEntity(TohyoShukeiReportSource.DataType.小計.getKey(), before));
            clear小計Count();
            pageIncrease();
        }

        if (isNew選挙(before, current)) {
            for (TohyoShukeiData shukeiData : 小計リスト) {
                dataCount = dataCount + 1;
                if (MAX_ROW < dataCount) {
                    pageIncrease();
                }
                shukeiData.setPageCount(ページ);
                shukeiData.set地区名称(get地区名(shukeiData));
                shukeiData.setDataType(TohyoShukeiReportSource.DataType.合計の行.getKey());
            }
            writeEntityList.addAll(小計リスト);

            dataCount = dataCount + 1;
            writeEntityList.add(createPrintEntity(TohyoShukeiReportSource.DataType.合計.getKey(), before));
            clear合計();
        }

        return writeEntityList;
    }

    private RString get地区名(TohyoShukeiData data) {
        RString 投票区コード = data.getEntity().get選挙人名簿Entity().getTohyokuCode();
        Code 選挙種類 = data.getEntity().get抄本Entity().getSenkyoShurui();
        RString 投票区名 = RString.EMPTY;
        if (null != 選挙種類 && SenkyoShurui.国政選挙_地方選挙.getCode().equals(選挙種類.value())) {
            if (null != data.getEntity().get投票区UrEntity()) {
                投票区名 = data.getEntity().get投票区UrEntity().getName();
            }
        } else {
            if (null != data.getEntity().get投票区Entity()) {
                投票区名 = data.getEntity().get投票区Entity().getTohyokuName();
            }
        }
        投票区名 = null != 投票区名 && 投票区名.length() > 投票区名称_上限 ? 投票区名.substring(0, 投票区名称_上限) : 投票区名;
        return null != 投票区コード ? 投票区コード.concat(":").concat(投票区名) : RString.EMPTY;
    }

    private void 小計リスト追加(TohyoShukeiData data) {
        if (小計リスト.isEmpty()) {
            小計リスト.add(data);
            return;
        }

        TohyoShukeiData 最末データ = 小計リスト.get(小計リスト.size() - 1);
        RString 最末データ投票区コード = 最末データ.getEntity().get選挙人名簿Entity().getTohyokuCode();
        RString 投票区コード = data.getEntity().get選挙人名簿Entity().getTohyokuCode();

        if (null != 最末データ投票区コード && 最末データ投票区コード.equals(投票区コード)) {
            最末データ.set不在者投票男数(最末データ.get不在者投票男数() + data.get不在者投票男数());
            最末データ.set不在者投票女数(最末データ.get不在者投票女数() + data.get不在者投票女数());
            最末データ.set期日前投票男数(最末データ.get期日前投票男数() + data.get期日前投票男数());
            最末データ.set期日前投票女数(最末データ.get期日前投票女数() + data.get期日前投票女数());
        } else {
            小計リスト.add(data);
        }

    }

    private void pageIncrease() {
        ページ = ページ + 1;
        dataCount = 0;
    }

    /**
     * createLastProcess
     *
     * @param before before
     * @return List<TohyoShukeiData>
     */
    public List<TohyoShukeiData> createLastProcess(ZenjitsuPrintEntity before) {
        List<TohyoShukeiData> writeEntityList = new ArrayList<>();
        dataCount = dataCount + 1;
        writeEntityList.add(createPrintEntity(TohyoShukeiReportSource.DataType.データ.getKey(), before));
        dataCount = dataCount + 1;
        writeEntityList.add(createPrintEntity(TohyoShukeiReportSource.DataType.小計.getKey(), before));

        // 最終ページの設定
        pageIncrease();
        小計リスト追加(createPrintEntity(TohyoShukeiReportSource.DataType.小計.getKey(), before));
        for (TohyoShukeiData shukeiData : 小計リスト) {
            dataCount = dataCount + 1;
            if (MAX_ROW < dataCount) {
                pageIncrease();
            }
            shukeiData.setPageCount(ページ);
            shukeiData.set地区名称(get地区名(shukeiData));
            shukeiData.setDataType(TohyoShukeiReportSource.DataType.合計の行.getKey());
        }
        writeEntityList.addAll(小計リスト);

        // 合計リストの設定
        dataCount = dataCount + 1;
        writeEntityList.add(createPrintEntity(TohyoShukeiReportSource.DataType.合計.getKey(), before));
        return writeEntityList;

    }

    /**
     * NewDataかどうか。
     *
     * @param before before
     * @param current current
     * @return NewDataかどうか
     */
    protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        return false;
    }

    /**
     * 明細タイトルを返す。
     *
     * @return 明細タイトル
     */
    protected RString get明細タイトル() {
        return RString.EMPTY;
    }

    /**
     * 地区名称を返す。
     *
     * @param before before
     * @return 地区名称
     */
    protected RString get地区名称(ZenjitsuPrintEntity before) {
        return RString.EMPTY;
    }

    private boolean isNew選挙(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        if (null == before) {
            return false;
        }

        if (null == current) {
            return true;
        }

        int 選挙番号前 = before.get選挙Entity().getSenkyoNo().value();
        int 選挙番号現 = current.get選挙Entity().getSenkyoNo().value();

        return 選挙番号前 != 選挙番号現;
    }

    private boolean isNew投票区コード(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        if (null == before) {
            return false;
        }

        if (null == current) {
            return true;
        }

        RString 投票区コード前 = before.get選挙人名簿Entity().getTohyokuCode();
        RString 投票区コード現 = current.get選挙人名簿Entity().getTohyokuCode();

        return !(null != 投票区コード前 && null != 投票区コード現 && 投票区コード前.equals(投票区コード現));
    }

    private void count(ZenjitsuPrintEntity current) {
        if (null == current.get投票状況Entity() || null == current.get投票状況Entity().getTohyoJokyo()) {
            return;
        }
        Code 投票状況 = current.get投票状況Entity().getTohyoJokyo();

        if (Seibetsu.男.code().equals(current.get宛名情報Entity().getSeibetsuCode())) {
            if (TohyoJokyo.受理.getCode().equals(投票状況.value())) {
                不在者投票男数 = 不在者投票男数 + 1;
                不在者投票男数小計用 = 不在者投票男数小計用 + 1;
            } else if (TohyoJokyo.期日前.getCode().equals(投票状況.value())) {
                期日前投票男数 = 期日前投票男数 + 1;
                期日前投票男数小計用 = 期日前投票男数小計用 + 1;
            }

        } else if (Seibetsu.女.code().equals(current.get宛名情報Entity().getSeibetsuCode())) {
            if (TohyoJokyo.受理.getCode().equals(投票状況.value())) {
                不在者投票女数 = 不在者投票女数 + 1;
                不在者投票女数小計用 = 不在者投票女数小計用 + 1;
            } else if (TohyoJokyo.期日前.getCode().equals(投票状況.value())) {
                期日前投票女数 = 期日前投票女数 + 1;
                期日前投票女数小計用 = 期日前投票女数小計用 + 1;
            }
        }
    }

    private TohyoShukeiData createPrintEntity(int データタイプ, ZenjitsuPrintEntity entity) {
        if (MAX_ROW < dataCount) {
            pageIncrease();
        }

        TohyoShukeiData writeEntity = new TohyoShukeiData();
        if (null != entity.get選挙Entity()) {
            if (TohyoShukeiReportSource.DataType.データ.getKey() == データタイプ) {
                writeEntity.set期日前投票女数(期日前投票女数);
                writeEntity.set期日前投票男数(期日前投票男数);
                writeEntity.set不在者投票女数(不在者投票女数);
                writeEntity.set不在者投票男数(不在者投票男数);
                writeEntity.set明細タイトル(get明細タイトル());
                writeEntity.set地区名称(get地区名称(entity));
            } else if (TohyoShukeiReportSource.DataType.小計.getKey() == データタイプ) {
                writeEntity.set期日前投票女数(期日前投票女数小計用);
                writeEntity.set期日前投票男数(期日前投票男数小計用);
                writeEntity.set不在者投票女数(不在者投票女数小計用);
                writeEntity.set不在者投票男数(不在者投票男数小計用);
                writeEntity.set明細タイトル(get明細タイトル());
                writeEntity.set地区名称(投票区計);
            } else if (TohyoShukeiReportSource.DataType.合計.getKey() == データタイプ) {
                for (TohyoShukeiData data : 小計リスト) {
                    writeEntity.set期日前投票女数(writeEntity.get期日前投票女数() + data.get期日前投票女数());
                    writeEntity.set期日前投票男数(writeEntity.get期日前投票男数() + data.get期日前投票男数());
                    writeEntity.set不在者投票女数(writeEntity.get不在者投票女数() + data.get不在者投票女数());
                    writeEntity.set不在者投票男数(writeEntity.get不在者投票男数() + data.get不在者投票男数());
                }
                writeEntity.set明細タイトル(明細タイトル_合計);
                writeEntity.set地区名称(選挙計);
            }
        }

        writeEntity.setPageCount(ページ);
        writeEntity.setCommonHeader(帳票共通ヘッダー);
        writeEntity.setParam(param);
        writeEntity.setEntity(entity);
        writeEntity.setDataType(データタイプ);

        return writeEntity;
    }

    private void clearDataCount() {
        期日前投票男数 = 0;
        期日前投票女数 = 0;
        不在者投票男数 = 0;
        不在者投票女数 = 0;
    }

    private void clear小計Count() {
        期日前投票男数小計用 = 0;
        期日前投票女数小計用 = 0;
        不在者投票男数小計用 = 0;
        不在者投票女数小計用 = 0;
    }

    private void clear合計() {
        小計リスト = new ArrayList<>();
    }

    /**
     * 住所の場合のCoreクラス。
     */
    static class TohyoShukeiBreakCoreJusho extends TohyoShukeiBreakCore {

        /**
         * コンストラクス。
         *
         * @param parameter AFABTE504SelectProcessParameter
         */
        public TohyoShukeiBreakCoreJusho(AFABTE504SelectProcessParameter param) {
            super(param);
        }

        @Override
        protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
            if (null == before) {
                return false;
            }

            if (null == current) {
                return true;
            }

            AtenaJusho 住所前 = before.get宛名情報Entity().getJusho();
            AtenaJusho 住所現 = current.get宛名情報Entity().getJusho();

            return !(null != 住所前 && null != 住所現 && 住所前.value().equals(住所現.value()));
        }

        @Override
        protected RString get明細タイトル() {
            return ShohonJushoEditEnum.住所.get明細タイトル();
        }

        @Override
        protected RString get地区名称(ZenjitsuPrintEntity before) {
            if (null == before) {
                return RString.EMPTY;
            }
            AtenaJusho 住所 = before.get宛名情報Entity().getJusho();
            return null != 住所 ? 住所.value() : RString.EMPTY;
        }
    }

    /**
     * 行政区の場合のCoreクラス。
     */
    static class TohyoShukeiBreakCoreGyoseiku extends TohyoShukeiBreakCore {

        /**
         * コンストラクス。
         *
         * @param parameter AFABTE504SelectProcessParameter
         */
        public TohyoShukeiBreakCoreGyoseiku(AFABTE504SelectProcessParameter param) {
            super(param);
        }

        @Override
        protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
            if (null == before) {
                return false;
            }

            if (null == current) {
                return true;
            }

            RString 行政区名前 = before.get宛名情報Entity().getGyoseikuName();
            RString 行政区名現 = current.get宛名情報Entity().getGyoseikuName();

            return !(null != 行政区名前 && null != 行政区名現 && 行政区名前.equals(行政区名現));
        }

        @Override
        protected RString get明細タイトル() {
            return ShohonJushoEditEnum.行政区.get明細タイトル();
        }

        @Override
        protected RString get地区名称(ZenjitsuPrintEntity before) {
            return null != before ? before.get宛名情報Entity().getGyoseikuName() : RString.EMPTY;
        }
    }

    /**
     * 地区１の場合のCoreクラス。
     */
    static class TohyoShukeiBreakCoreChiku1 extends TohyoShukeiBreakCore {

        /**
         * コンストラクス。
         *
         * @param parameter AFABTE504SelectProcessParameter
         */
        public TohyoShukeiBreakCoreChiku1(AFABTE504SelectProcessParameter param) {
            super(param);
        }

        @Override
        protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
            if (null == before) {
                return false;
            }

            if (null == current) {
                return true;
            }

            RString 地区名1前 = before.get宛名情報Entity().getChikuName1();
            RString 地区名1現 = current.get宛名情報Entity().getChikuName1();

            return !(null != 地区名1前 && null != 地区名1現 && 地区名1前.equals(地区名1現));
        }

        @Override
        protected RString get明細タイトル() {
            return ShohonJushoEditEnum.地区コード1.get明細タイトル();
        }

        @Override
        protected RString get地区名称(ZenjitsuPrintEntity before) {
            return null != before ? before.get宛名情報Entity().getChikuName1() : RString.EMPTY;
        }
    }

    /**
     * 地区２の場合のCoreクラス。
     */
    static class TohyoShukeiBreakCoreChiku2 extends TohyoShukeiBreakCore {

        /**
         * コンストラクス。
         *
         * @param parameter AFABTE504SelectProcessParameter
         */
        public TohyoShukeiBreakCoreChiku2(AFABTE504SelectProcessParameter param) {
            super(param);
        }

        @Override
        protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
            if (null == before) {
                return false;
            }

            if (null == current) {
                return true;
            }

            RString 地区名2前 = before.get宛名情報Entity().getChikuName2();
            RString 地区名2現 = current.get宛名情報Entity().getChikuName2();

            return !(null != 地区名2前 && null != 地区名2現 && 地区名2前.equals(地区名2現));
        }

        @Override
        protected RString get明細タイトル() {
            return ShohonJushoEditEnum.地区コード2.get明細タイトル();
        }

        @Override
        protected RString get地区名称(ZenjitsuPrintEntity before) {
            return null != before ? before.get宛名情報Entity().getChikuName2() : RString.EMPTY;
        }
    }

    /**
     * 地区３の場合のCoreクラス。
     */
    static class TohyoShukeiBreakCoreChiku3 extends TohyoShukeiBreakCore {

        /**
         * コンストラクス。
         *
         * @param parameter AFABTE504SelectProcessParameter
         */
        public TohyoShukeiBreakCoreChiku3(AFABTE504SelectProcessParameter param) {
            super(param);
        }

        @Override
        protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
            if (null == before) {
                return false;
            }

            if (null == current) {
                return true;
            }

            RString 地区名3前 = before.get宛名情報Entity().getChikuName3();
            RString 地区名3現 = current.get宛名情報Entity().getChikuName3();

            return !(null != 地区名3前 && null != 地区名3現 && 地区名3前.equals(地区名3現));
        }

        @Override
        protected RString get明細タイトル() {
            return ShohonJushoEditEnum.地区コード3.get明細タイトル();
        }

        @Override
        protected RString get地区名称(ZenjitsuPrintEntity before) {
            return null != before ? before.get宛名情報Entity().getChikuName3() : RString.EMPTY;
        }
    }
}
