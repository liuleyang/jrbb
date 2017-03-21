/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.meibosakuseikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.MeiboSakuseiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.MeiboShohonKaikuDbMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectShohonNoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibosakuseikaiku.SelectTempTableMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 海区漁業調整委員会委員選挙人名簿作成バッチパラメータクラスです。
 *
 * @reamsid_L AF-0460-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTK101SelectProcessParameter implements IBatchProcessParameter {

    private RString 作成方法;
    private RString 処理種別;
    private ShohonNo 抄本番号;
    private RString 抄本名;
    private FlexibleDate 基準日;
    private FlexibleDate 名簿確定日;
    private FlexibleDate 年齢到達日;
    private boolean 選挙人名簿抄本出力有無;
    private boolean 登録者数リスト出力有無;
    private FlexibleDate 時点日;
    private List<RString> 集計項目IDリスト;
    private RString 帳票ID;
    private RString sort;

    private RString order順;

    private List<RString> 改頁項目IDリスト;
    private RString 出力順;
    private IShikibetsuTaishoPSMSearchKey key;

    private List<ShohonNo> 抄本番号List;

    private RString table;

    private Code 選挙種類;

    /**
     *
     * @param 作成方法 RString
     * @param 処理種別 RString
     * @param 抄本番号 ShohonNo
     * @param 抄本名 抄本名
     * @param 基準日 基準日
     * @param 名簿確定日 名簿確定日
     * @param 年齢到達日 年齢到達日
     * @param 選挙人名簿抄本出力有無 選挙人名簿抄本出力有無
     * @param 登録者数リスト出力有無 登録者数リスト出力有無
     * @param 時点日 時点日
     * @param 集計項目IDリスト 集計項目IDリスト
     * @param 帳票ID 帳票ID
     * @param sort sort
     * @param order順 order順
     * @param 改頁項目IDリスト 改頁項目IDリスト
     * @param 出力順 出力順
     * @param key key
     * @param 抄本番号List List<ShohonNo>
     * @param table RString
     * @param 選挙種類 Code
     */
    public AFABTK101SelectProcessParameter(RString 作成方法, RString 処理種別, ShohonNo 抄本番号, RString 抄本名,
            FlexibleDate 基準日, FlexibleDate 名簿確定日, FlexibleDate 年齢到達日, boolean 選挙人名簿抄本出力有無,
            boolean 登録者数リスト出力有無, FlexibleDate 時点日, List<RString> 集計項目IDリスト, RString 帳票ID, RString sort,
            RString order順, List<RString> 改頁項目IDリスト, RString 出力順, IShikibetsuTaishoPSMSearchKey key, List<ShohonNo> 抄本番号List,
            RString table, Code 選挙種類) {
        this.作成方法 = 作成方法;
        this.処理種別 = 処理種別;
        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.基準日 = 基準日;
        this.名簿確定日 = 名簿確定日;
        this.年齢到達日 = 年齢到達日;
        this.選挙人名簿抄本出力有無 = 選挙人名簿抄本出力有無;
        this.登録者数リスト出力有無 = 登録者数リスト出力有無;
        this.時点日 = 時点日;
        this.集計項目IDリスト = 集計項目IDリスト;
        this.帳票ID = 帳票ID;
        this.sort = sort;
        this.order順 = order順;
        this.改頁項目IDリスト = 改頁項目IDリスト;
        this.出力順 = 出力順;
        this.key = key;
        this.抄本番号List = 抄本番号List;
        this.table = table;
        this.選挙種類 = 選挙種類;
    }

    /**
     * AFABTK101SelectProcessParameterの変換のメソッドです。
     *
     *
     * @return AFABTI101SelectProcessParameter
     */
    public MeiboSakuseiKaikuMybatisParameter toMeiboSakuseiKaikuMybatisParameter() {

        return new MeiboSakuseiKaikuMybatisParameter(null, 基準日, null, null,
                null, 抄本番号, key, 処理種別);
    }

    /**
     * AFABTK101SelectProcessParameterの変換のメソッドです。
     *
     *
     * @return AFABTI101SelectProcessParameter
     */
    public SelectShohonNoMybatisParameter toSelectShohonNoMybatisParameter() {

        return new SelectShohonNoMybatisParameter(抄本番号List);
    }

    /**
     * AFABTK101SelectProcessParameterの変換のメソッドです。
     *
     *
     * @return AFABTI101SelectProcessParameter
     */
    public MeiboShohonKaikuDbMybatisParameter toMeiboShohonKaikuDbMybatisParameter() {

        return new MeiboShohonKaikuDbMybatisParameter(抄本番号List, 出力順, key, null);
    }

    /**
     * AFABTK101SelectProcessParameterの変換のメソッドです。
     *
     *
     * @return AFABTI101SelectProcessParameter
     */
    public SelectTempTableMybatisParameter toSelectTempTableMybatisParameter() {

        return new SelectTempTableMybatisParameter(出力順, table, 抄本番号, 抄本番号List,
                key, 処理種別, null, null);
    }

}
