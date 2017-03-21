/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101Senkyoichiran;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.TeijiTourokuDataDeleteMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * 選挙時登録バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTB101SelectProcessParameter implements IBatchProcessParameter {

    private IShikibetsuTaishoPSMSearchKey key;
    private IShikibetsuTaishoPSMSearchKey keyForAll;
    private FlexibleDate ageForselect;
    private RString table;
    private RString shuriShubetu;
    private RString shohonMei;
    private ShohonNo shohonNo;
    private ShohonNo 研修用発番抄本番号;
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
    private FlexibleDate 転出期間_開始日;
    private FlexibleDate 転出期間_終了日;
    private RString 出力条件;
    private RString 識別コード;
    private FlexibleDate 指定日Form;
    private FlexibleDate 指定日To;
    private RString 異動事由;
    private FlexibleDate 前回基準日;
    private FlexibleDate 投票年月日;
    private FlexibleDate 名簿基準年月日;
    private RString 処理モード;
    private Boolean 研修用データも作成有無;
    private List<AFABTB101Senkyoichiran> 選択一覧リスト;
    private RString tohyokuCodeFrom;
    private RString tohyokuCodeTo;
    private RString order順;
    private RString 改頁項目ID;
    private RString 投票区From;
    private RString 投票区To;
    private SenkyoShurui senkyoShurui;

    /**
     * コンストラクタです。
     *
     * @param 処理種別 RString
     * @param 選択一覧リスト List
     * @param 抄本番号 ShohonNo
     * @param 抄本名 RString
     * @param 基準日 FlexibleDate
     * @param 登録日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 転出期限日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @param 年齢期限日 FlexibleDate
     * @param 帰化期間 List<FlexibleDate>
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @param 出力条件 RString
     * @param 識別コード RString
     * @param 指定日Form FlexibleDate
     * @param 指定日To FlexibleDate
     * @param 異動事由 RString
     * @param 処理モード RString
     * @param 研修用データも作成有無 Boolean
     * @param order順 RString
     * @param 投票区From 投票区From
     * @param 投票区To 投票区To
     */
    public AFABTB101SelectProcessParameter(RString 処理種別,
            List<AFABTB101Senkyoichiran> 選択一覧リスト,
            ShohonNo 抄本番号,
            RString 抄本名,
            FlexibleDate 基準日,
            FlexibleDate 登録日,
            FlexibleDate 投票日,
            FlexibleDate 転出期限日,
            FlexibleDate 転入期限日,
            FlexibleDate 年齢期限日,
            List<FlexibleDate> 帰化期間,
            IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll,
            RString 出力条件,
            RString 識別コード,
            FlexibleDate 指定日Form,
            FlexibleDate 指定日To,
            RString 異動事由,
            RString 処理モード,
            Boolean 研修用データも作成有無,
            RString order順,
            RString 投票区From,
            RString 投票区To) {
        this(処理種別,
                選択一覧リスト,
                抄本番号,
                抄本名,
                基準日,
                登録日,
                投票日,
                転出期限日,
                転入期限日,
                年齢期限日,
                帰化期間,
                key,
                keyForAll,
                出力条件,
                識別コード,
                指定日Form,
                指定日To,
                異動事由,
                処理モード,
                研修用データも作成有無,
                order順,
                RString.EMPTY,
                投票区From,
                投票区To);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理種別 RString
     * @param 選択一覧リスト List
     * @param 抄本番号 ShohonNo
     * @param 抄本名 RString
     * @param 基準日 FlexibleDate
     * @param 登録日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 転出期限日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @param 年齢期限日 FlexibleDate
     * @param 帰化期間 List<FlexibleDate>
     * @param key IShikibetsuTaishoPSMSearchKey.
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @param 出力条件 RString
     * @param 識別コード RString
     * @param 指定日Form FlexibleDate
     * @param 指定日To FlexibleDate
     * @param 異動事由 RString
     * @param 処理モード RString
     * @param 研修用データも作成有無 Boolean
     * @param order順 RString
     * @param 改頁項目ID RString
     * @param 投票区From 投票区From
     * @param 投票区To 投票区To
     */
    public AFABTB101SelectProcessParameter(RString 処理種別,
            List<AFABTB101Senkyoichiran> 選択一覧リスト,
            ShohonNo 抄本番号,
            RString 抄本名,
            FlexibleDate 基準日,
            FlexibleDate 登録日,
            FlexibleDate 投票日,
            FlexibleDate 転出期限日,
            FlexibleDate 転入期限日,
            FlexibleDate 年齢期限日,
            List<FlexibleDate> 帰化期間,
            IShikibetsuTaishoPSMSearchKey key,
            IShikibetsuTaishoPSMSearchKey keyForAll,
            RString 出力条件,
            RString 識別コード,
            FlexibleDate 指定日Form,
            FlexibleDate 指定日To,
            RString 異動事由,
            RString 処理モード,
            Boolean 研修用データも作成有無,
            RString order順,
            RString 改頁項目ID,
            RString 投票区From,
            RString 投票区To) {
        this.shuriShubetu = 処理種別;
        this.選択一覧リスト = 選択一覧リスト;
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
        this.処理モード = 処理モード;
        this.研修用データも作成有無 = 研修用データも作成有無;
        this.order順 = order順;
        this.改頁項目ID = 改頁項目ID;
        this.投票区From = 投票区From;
        this.投票区To = 投票区To;
    }

    /**
     * コンストラクタです。
     */
    public AFABTB101SelectProcessParameter() {
        this.shuriShubetu = RString.EMPTY;
        this.shohonNo = null;
        this.shohonMei = RString.EMPTY;
        this.kijunbi = FlexibleDate.EMPTY;
        this.tourokubi = FlexibleDate.EMPTY;
        this.touhyobi = FlexibleDate.EMPTY;
        this.tenshutuKigenbi = FlexibleDate.EMPTY;
        this.tennyuKigenbi = FlexibleDate.EMPTY;
        this.nenreiKigenbi = FlexibleDate.EMPTY;
        this.kikaKikan = new ArrayList<>();
        this.key = null;
        this.keyForAll = null;
        this.出力条件 = RString.EMPTY;
        this.識別コード = RString.EMPTY;
        this.指定日Form = FlexibleDate.EMPTY;
        this.指定日To = FlexibleDate.EMPTY;
        this.異動事由 = RString.EMPTY;
        this.order順 = RString.EMPTY;
        this.改頁項目ID = RString.EMPTY;
        this.投票区From = RString.EMPTY;
        this.投票区To = RString.EMPTY;
    }

    /**
     * SenkyojiMybatisParameterを返します。
     *
     * @return SenkyojiMybatisParameter
     */
    public SenkyojiMybatisParameter toSenkyojiMybatisParameter() {
        RString 改頁;
        if (!RString.isNullOrEmpty(this.改頁項目ID)) {
            改頁 = this.改頁項目ID;
        } else {
            改頁 = new RString("''");
        }

        RString order;
        if (RString.isNullOrEmpty(order順)) {
            order = new RString("order by");
        } else {
            order = order順.concat(new RString(","));
        }

        return new SenkyojiMybatisParameter(shuriShubetu,
                ageForselect,
                kijunbi,
                nenreiKigenbi,
                tourokubi,
                kikaKikan.get(0),
                kikaKikan.get(1),
                key,
                shohonNo,
                sort,
                table,
                selectKijun,
                転入期間_開始日,
                転入期間_終了日,
                転出期間_開始日,
                転出期間_終了日,
                出力条件,
                識別コード,
                指定日Form,
                指定日To,
                異動事由,
                tohyokuCodeFrom,
                tohyokuCodeTo,
                order,
                改頁);
    }

    /**
     * コンストラクタです。
     *
     * @param parameter 定時登録バッチデータ
     */
    public AFABTB101SelectProcessParameter(AFABTA101SelectProcessParameter parameter) {
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
        this.出力条件 = parameter.get出力条件();
        this.識別コード = parameter.get識別コード();
        this.指定日Form = parameter.get指定日Form();
        this.指定日To = parameter.get指定日To();
        this.異動事由 = parameter.get異動事由();
        this.投票区From = parameter.get投票区From();
        this.投票区To = parameter.get投票区To();
        // TODO
        // this.order順 = parameter.getOrder順();
        this.senkyoShurui = parameter.getSenkyoShurui();
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
}
