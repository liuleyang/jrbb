/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tohyoroku.tachiaininhikitsugi;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.tachiaininhikitsugi.TachiaininHikitsugi;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.tohyoroku.TachiaininHikitsugiMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT206TachiaininHikitsugiJohoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT206TachiaininHikitsugiJohoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyoroku.ITachiaininHikitsugiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 立会人引継情報を管理するクラスです。
 *
 * @reamsid_L AF-0120-010 xul
 */
public class TachiaininHikitsugiManager {

    private final AfT206TachiaininHikitsugiJohoDac dac;
    private final AfaMapperProvider mapperProvider;
    private static final RString メッセージ抄本番号 = new RString("抄本番号");
    private static final RString メッセージ選挙番号 = new RString("選挙番号");
    private static final RString メッセージ報告年月日 = new RString("報告年月日");
    private static final RString メッセージ施設コード = new RString("施設コード");
    private static final RString メッセージ投票区コード = new RString("投票区コード");
    private static final RString メッセージ投票録項目種類 = new RString("投票録項目種類");

    /**
     * コンストラクタです。
     */
    public TachiaininHikitsugiManager() {
        dac = InstanceProvider.create(AfT206TachiaininHikitsugiJohoDac.class);
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT206TachiaininHikitsugiJohoDac}
     * @param mapperProvider {@link AfaMapperProvider}
     */
    public TachiaininHikitsugiManager(AfT206TachiaininHikitsugiJohoDac dac, AfaMapperProvider mapperProvider) {
        this.dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TachiaininHikitsugiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TachiaininHikitsugiManager}のインスタンス
     */
    public static TachiaininHikitsugiManager createInstance() {
        return InstanceProvider.create(TachiaininHikitsugiManager.class);
    }

    /**
     * 検索条件合致するの立会人引継情報を返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票状況 投票状況
     * @param 投票録項目種類 投票録項目種類
     * @return TachiaininHikitsugi
     */
    @Transaction
    public List<TachiaininHikitsugi> get立会人引継情報With投票状況(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票状況,
            Code 投票録項目種類) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ抄本番号.toString()));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ選挙番号.toString()));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ報告年月日.toString()));

        List<AfT206TachiaininHikitsugiJohoEntity> entityList;
        if (TohyoJokyo.期日前.getCode().equals(投票状況)) {
            requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ施設コード.toString()));
            entityList = dac.select(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票録項目種類);
        } else {
            entityList = dac.select(抄本番号, 選挙番号, 報告年月日, 投票録項目種類);
        }

        if (entityList.isEmpty()) {
            return null;
        }

        List<TachiaininHikitsugi> tohyorokuFuzuiList = new ArrayList<>();
        for (AfT206TachiaininHikitsugiJohoEntity entity : entityList) {
            entity.initializeMd5();
            tohyorokuFuzuiList.add(new TachiaininHikitsugi(entity));
        }
        return tohyorokuFuzuiList;
    }

    /**
     * 検索条件合致するの立会人引継情報を返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票状況 投票状況
     * @param 投票録項目種類 投票録項目種類
     * @param 立会人連番 立会人連番
     * @return TachiaininHikitsugi
     */
    @Transaction
    public List<TachiaininHikitsugi> get立会人引継情報With投票状況(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票状況,
            Code 投票録項目種類,
            RString 立会人連番) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ抄本番号.toString()));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ選挙番号.toString()));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ報告年月日.toString()));

        List<AfT206TachiaininHikitsugiJohoEntity> entityList;
        if (TohyoJokyo.期日前.getCode().equals(投票状況)) {
            requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ施設コード.toString()));
            entityList = dac.select(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票録項目種類, 立会人連番);
        } else {
            entityList = dac.select(抄本番号, 選挙番号, 報告年月日, 投票録項目種類, 立会人連番);
        }

        if (entityList.isEmpty()) {
            return null;
        }

        List<TachiaininHikitsugi> tohyorokuFuzuiList = new ArrayList<>();
        for (AfT206TachiaininHikitsugiJohoEntity entity : entityList) {
            entity.initializeMd5();
            tohyorokuFuzuiList.add(new TachiaininHikitsugi(entity));
        }
        return tohyorokuFuzuiList;
    }

    /**
     * 検索条件合致するの立会人引継情報を返します。
     *
     * @param 抄本番号引数 抄本番号
     * @param 選挙番号引数 選挙番号
     * @param 報告年月日引数 報告年月日
     * @param 施設コード引数 施設コード
     * @param 投票区コード引数 投票区コード
     * @param 投票録項目種類引数 投票録項目種類
     * @return TachiaininHikitsugi
     */
    @Transaction
    public List<TachiaininHikitsugi> get立会人引継情報(ShohonNo 抄本番号引数,
            SenkyoNo 選挙番号引数,
            FlexibleDate 報告年月日引数,
            RString 施設コード引数,
            RString 投票区コード引数,
            Code 投票録項目種類引数) {
        requireNonNull(抄本番号引数, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ抄本番号.toString()));
        requireNonNull(選挙番号引数, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ選挙番号.toString()));
        requireNonNull(報告年月日引数, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ報告年月日.toString()));
        requireNonNull(施設コード引数, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ施設コード.toString()));
        requireNonNull(投票区コード引数, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ投票区コード.toString()));
        requireNonNull(投票録項目種類引数, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ投票録項目種類.toString()));

        List<AfT206TachiaininHikitsugiJohoEntity> entityList
                = dac.select(抄本番号引数, 選挙番号引数, 報告年月日引数, 投票録項目種類引数, 施設コード引数, 投票区コード引数);

        if (entityList.isEmpty()) {
            return null;
        }

        List<TachiaininHikitsugi> tohyorokuFuzuiList = new ArrayList<>();
        for (AfT206TachiaininHikitsugiJohoEntity entity : entityList) {
            entity.initializeMd5();
            tohyorokuFuzuiList.add(new TachiaininHikitsugi(entity));
        }
        return tohyorokuFuzuiList;
    }

    /**
     * 検索条件合致するの立会人引継情報氏名リストを返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票録項目種類 投票録項目種類
     * @return List<RString>
     */
    @Transaction
    public List<RString> get立会人引継情報氏名リスト(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            Code 投票録項目種類) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ抄本番号.toString()));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ選挙番号.toString()));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ報告年月日.toString()));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ施設コード.toString()));
        requireNonNull(投票区コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ投票区コード.toString()));
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ投票録項目種類.toString()));

        ITachiaininHikitsugiMapper mapper = mapperProvider.create(ITachiaininHikitsugiMapper.class);

        return mapper.select立会人引継情報氏名(TachiaininHikitsugiMapperParameter.createParam(抄本番号, 選挙番号, 報告年月日, 施設コード, 投票区コード, 投票録項目種類));
    }

    /**
     * 検索条件合致するの立会人引継情報リストを返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票録項目種類 投票録項目種類
     * @return List<RString>
     */
    @Transaction
    public List<TachiaininHikitsugi> get立会人引継情報リスト(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            Code 投票録項目種類) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ抄本番号.toString()));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ選挙番号.toString()));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ報告年月日.toString()));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ施設コード.toString()));
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ投票録項目種類.toString()));

        List<AfT206TachiaininHikitsugiJohoEntity> list
                = dac.select投票立会人情報(抄本番号, 選挙番号, 報告年月日, 投票録項目種類, 施設コード);
        if (null == list || list.isEmpty()) {
            return null;
        }

        List<TachiaininHikitsugi> resultList = new ArrayList<>();
        for (AfT206TachiaininHikitsugiJohoEntity entity : list) {
            entity.initializeMd5();
            resultList.add(new TachiaininHikitsugi(entity));
        }
        return resultList;
    }

    /**
     * 検索条件合致するの立会人引継情報リストを返します。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票録項目種類 投票録項目種類
     * @param 立会人連番 立会人連番
     * @return List<RString>
     */
    @Transaction
    public List<TachiaininHikitsugi> get投票用紙再交付者情報(ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            Code 投票録項目種類,
            int 立会人連番) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ抄本番号.toString()));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ選挙番号.toString()));
        requireNonNull(報告年月日, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ報告年月日.toString()));
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ施設コード.toString()));
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ投票録項目種類.toString()));

        List<AfT206TachiaininHikitsugiJohoEntity> 投票用紙再交付者情報リスト
                = dac.select投票用紙再交付者情報(抄本番号, 選挙番号, 報告年月日, 投票録項目種類, 施設コード, 立会人連番);
        if (null == 投票用紙再交付者情報リスト || 投票用紙再交付者情報リスト.isEmpty()) {
            return null;
        }

        List<TachiaininHikitsugi> resultList = new ArrayList<>();
        for (AfT206TachiaininHikitsugiJohoEntity entity : 投票用紙再交付者情報リスト) {
            entity.initializeMd5();
            resultList.add(new TachiaininHikitsugi(entity));
        }
        return resultList;
    }

    /**
     * 検索条件合致するの立会人引継情報リストを返します。
     *
     * @param 投票録項目種類 投票録項目種類
     * @return TachiaininHikitsugi
     */
    @Transaction
    public TachiaininHikitsugi getMAX立会人連番(Code 投票録項目種類) {
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ投票録項目種類.toString()));
        return new TachiaininHikitsugi(dac.selectMAX立会人連番(投票録項目種類));
    }

    /**
     * 検索条件合致するの立会人引継情報リストを返します。
     *
     * @param 投票録項目種類 投票録項目種類
     * @return TachiaininHikitsugi
     */
    @Transaction
    public TachiaininHikitsugi getMAX連番(Code 投票録項目種類) {
        requireNonNull(投票録項目種類, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ投票録項目種類.toString()));
        return new TachiaininHikitsugi(dac.selectMAX連番(投票録項目種類));
    }

}
