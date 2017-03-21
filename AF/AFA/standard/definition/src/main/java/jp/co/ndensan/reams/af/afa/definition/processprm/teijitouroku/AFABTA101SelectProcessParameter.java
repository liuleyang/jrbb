/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShoriModel;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * 定時登録バッチデータ取得パラメータクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTA101SelectProcessParameter implements IBatchProcessParameter {

    private IShikibetsuTaishoPSMSearchKey key;
    private IShikibetsuTaishoPSMSearchKey keyForAll;
    private FlexibleDate ageForselect;
    private RString table;
    private RString shuriShubetu;
    private RString shohonMei;
    private ShohonNo shohonNo;
    private FlexibleDate kijunbi;
    private FlexibleDate tourokubi;
    private FlexibleDate touhyobi;
    private FlexibleDate tenshutuKigenbi;
    private FlexibleDate tennyuKigenbi;
    private FlexibleDate nenreiKigenbi;
    private RString sort;
    private List<FlexibleDate> kikaKikan;
    private RString selectKijun;
    private RString 発行番号_第;
    private RString 発行番号_番号;
    private RString 発行番号_号;
    private FlexibleDate 転入期間_開始日;
    private FlexibleDate 転入期間_終了日;
    private RString 出力条件;
    private RString 識別コード;
    private FlexibleDate 指定日Form;
    private FlexibleDate 指定日To;
    private RString 異動事由;
    private FlexibleDate 前回基準日;
    private RString 投票区From;
    private RString 投票区To;
    private RString 登録者数リスト_投票区From;
    private RString 登録者数リスト_投票区To;
    private RString 有権者数調べ_投票区From;
    private RString 有権者数調べ_投票区To;
    private RString 処理モード;
    private SenkyoShurui senkyoShurui;

    /**
     * コンストラクタです。
     *
     * @param 処理種別 RString
     * @param 抄本番号 ShohonNo
     * @param 抄本名 RString
     * @param 基準日 FlexibleDate
     * @param 登録日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 転出期限日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @param 年齢期限日 FlexibleDate
     * @param 帰化期間 ArrayList<FlexibleDate>
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @param 出力条件 RString
     * @param 識別コード RString
     * @param 指定日Form FlexibleDate
     * @param 指定日To FlexibleDate
     * @param 異動事由 RString
     * @param 投票区From 投票区From
     * @param 投票区To 投票区To
     * @param 処理モード 処理モード
     */
    public AFABTA101SelectProcessParameter(RString 処理種別, ShohonNo 抄本番号, RString 抄本名, FlexibleDate 基準日,
            FlexibleDate 登録日, FlexibleDate 投票日, FlexibleDate 転出期限日, FlexibleDate 転入期限日, FlexibleDate 年齢期限日,
            List<FlexibleDate> 帰化期間, IShikibetsuTaishoPSMSearchKey key, IShikibetsuTaishoPSMSearchKey keyForAll, RString 出力条件, RString 識別コード,
            FlexibleDate 指定日Form, FlexibleDate 指定日To, RString 異動事由, RString 投票区From, RString 投票区To, RString 処理モード) {
        this.shuriShubetu = 処理種別;
        this.shohonNo = 抄本番号;
        this.shohonMei = 抄本名;
        this.kijunbi = 基準日;
        this.tourokubi = 登録日;
        this.touhyobi = 投票日;
        this.tenshutuKigenbi = 転出期限日;
        this.tennyuKigenbi = 転入期限日;
        this.nenreiKigenbi = 年齢期限日;
        this.kikaKikan = 帰化期間;
        this.key = key;
        this.keyForAll = keyForAll;
        this.出力条件 = 出力条件;
        this.識別コード = 識別コード;
        this.指定日Form = 指定日Form;
        this.指定日To = 指定日To;
        this.異動事由 = 異動事由;
        this.前回基準日 = FlexibleDate.EMPTY;
        this.投票区From = 投票区From;
        this.投票区To = 投票区To;
        this.処理モード = 処理モード;
    }

    /**
     * コンストラクタです。
     */
    public AFABTA101SelectProcessParameter() {
        this.shuriShubetu = RString.EMPTY;
        this.shohonNo = null;
        this.shohonMei = RString.EMPTY;
        this.kijunbi = FlexibleDate.EMPTY;
        this.tourokubi = FlexibleDate.EMPTY;
        this.touhyobi = FlexibleDate.EMPTY;
        this.tenshutuKigenbi = FlexibleDate.EMPTY;
        this.tennyuKigenbi = FlexibleDate.EMPTY;
        this.nenreiKigenbi = FlexibleDate.EMPTY;
        this.kikaKikan = Arrays.asList(FlexibleDate.EMPTY, FlexibleDate.EMPTY);
        this.key = null;
        this.keyForAll = null;
        this.出力条件 = RString.EMPTY;
        this.識別コード = RString.EMPTY;
        this.指定日Form = FlexibleDate.EMPTY;
        this.指定日To = FlexibleDate.EMPTY;
        this.異動事由 = RString.EMPTY;
        this.投票区From = RString.EMPTY;
        this.投票区To = RString.EMPTY;
        this.処理モード = ShoriModel.通常処理.code();
    }

    /**
     * BatchMybatisParameter変換のメソッド
     *
     * @return BatchMybatisParameter
     */
    public BatchMybatisParameter toBatchMybatisParameter() {
        return new BatchMybatisParameter(shuriShubetu, ageForselect, kijunbi, nenreiKigenbi, tourokubi, kikaKikan.get(0), kikaKikan.get(1),
                key, keyForAll, shohonNo, sort, table, selectKijun, 転入期間_開始日, 転入期間_終了日, 出力条件, 識別コード,
                指定日Form, 指定日To, 異動事由, 投票区From, 投票区To, 登録者数リスト_投票区From, 登録者数リスト_投票区To,
                有権者数調べ_投票区From, 有権者数調べ_投票区To);
    }

    /**
     * TeijiTourokuDataDeleteMybatisParameter変換のメソッド
     *
     * @return TeijiTourokuDataDeleteMybatisParameter
     */
    public TeijiTourokuDataDeleteMybatisParameter toTeijiTourokuDataDeleteMybatisParameter() {
        FlexibleDate 基準日_検索用 = kijunbi.minusYear(Integer.valueOf(
                BusinessConfig.get(ConfigKeysAFA.抄本保有年数_定時, SubGyomuCode.AFA選挙本体).toString()));
        return new TeijiTourokuDataDeleteMybatisParameter(shuriShubetu, 基準日_検索用, shohonNo);
    }

    /**
     * コンストラクタです。
     *
     * @param parameter 選挙時登録バッチデータ
     */
    public AFABTA101SelectProcessParameter(AFABTB101SelectProcessParameter parameter) {
        this.shuriShubetu = parameter.getShuriShubetu();
        this.shohonNo = parameter.getShohonNo();
        this.shohonMei = parameter.getShohonMei();
        this.kijunbi = parameter.getKijunbi();
        this.tourokubi = parameter.getTourokubi();
        this.touhyobi = parameter.getTouhyobi();
        this.tenshutuKigenbi = parameter.getTenshutuKigenbi();
        this.tennyuKigenbi = parameter.getTennyuKigenbi();
        this.nenreiKigenbi = parameter.getNenreiKigenbi();
        this.kikaKikan = parameter.getKikaKikan();
        this.key = parameter.getKey();
        this.keyForAll = parameter.getKeyForAll();
        this.ageForselect = parameter.getAgeForselect();
        this.table = parameter.getTable();
        this.sort = parameter.getSort();
        this.selectKijun = parameter.getSelectKijun();
        this.発行番号_号 = parameter.get発行番号_号();
        this.発行番号_番号 = parameter.get発行番号_番号();
        this.発行番号_第 = parameter.get発行番号_第();
        this.転入期間_開始日 = parameter.get転入期間_開始日();
        this.転入期間_終了日 = parameter.get転入期間_終了日();
        this.出力条件 = parameter.get出力条件();
        this.識別コード = parameter.get識別コード();
        this.指定日Form = parameter.get指定日Form();
        this.指定日To = parameter.get指定日To();
        this.異動事由 = parameter.get異動事由();
        this.前回基準日 = parameter.get前回基準日();
        this.投票区From = parameter.get投票区From();
        this.投票区To = parameter.get投票区To();
        this.処理モード = RString.EMPTY;
        this.senkyoShurui = parameter.getSenkyoShurui();
    }
}
