/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 海区漁業調整委員会委員選挙時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0470-030 jihb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTK103SelectProcessParameter implements IBatchProcessParameter {

    private RString 処理種別;
    private ShohonNo 抄本番号;
    private RString 抄本名;
    private RString 選挙名;
    private FlexibleDate 基準日;
    private FlexibleDate 投票日;
    private FlexibleDate 受付開始日;

    private boolean 選挙人名簿抄本出力有無;
    private boolean 登録者数リスト出力有無;
    private FlexibleDate 時点日;
    private boolean 登録者名簿出力有無;
    private boolean 新規登録者宛名シール作成有無;
    private boolean 抹消者名簿出力有無;
    private boolean 失権者名簿出力有無;
    private boolean 表示者名簿出力有無;
    private boolean 訂正者名簿出力有無;
    private List<RString> 集計項目IDリスト;
    private RString 帳票ID;
    private List<RString> 改頁項目IDリスト;
    private RString 出力順;
    private IShikibetsuTaishoPSMSearchKey key;
    private IShikibetsuTaishoPSMSearchKey keyForAll;
    private List<ShohonNo> 抄本番号List;

    private RString table;

    private Code 選挙種類;

    private FlexibleDate 名簿確定日;
    private FlexibleDate 年齢到達日;
    private FlexibleDate 最新化時点日;
    private boolean 最新化有無;
    private boolean 名簿並び替え有無;

    private RString 画面区分;

    private int 削除count;

    private List<ShikibetsuCode> 識別コードList;

    /**
     *
     * @param 処理種別 RString
     * @param 抄本番号 ShohonNo
     * @param 抄本名 RString
     * @param 選挙名 RString
     * @param 基準日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 受付開始日 FlexibleDate
     * @param 選挙人名簿抄本出力有無 boolean
     * @param 登録者数リスト出力有無 boolean
     * @param 時点日 FlexibleDate
     * @param 登録者名簿出力有無 boolean
     * @param 新規登録者宛名シール作成有無 boolean
     * @param 抹消者名簿出力有無 boolean
     * @param 失権者名簿出力有無 boolean
     * @param 表示者名簿出力有無 boolean
     * @param 訂正者名簿出力有無 boolean
     * @param 集計項目IDリスト List<RString>
     * @param 帳票ID RString
     * @param 改頁項目IDリスト List<RString>
     * @param 出力順 RString
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 抄本番号List List<ShohonNo>
     * @param table RString
     * @param 選挙種類 Code
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @param 名簿確定日 FlexibleDate
     * @param 年齢到達日 FlexibleDate
     * @param 最新化時点日 FlexibleDate
     * @param 最新化有無 boolean
     * @param 名簿並び替え有無 boolean
     * @param 画面区分 RString
     * @param 削除count int
     * @param 識別コードList List<ShikibetsuCode>
     */
    public AFABTK103SelectProcessParameter(RString 処理種別, ShohonNo 抄本番号, RString 抄本名, RString 選挙名, FlexibleDate 基準日,
            FlexibleDate 投票日, FlexibleDate 受付開始日, boolean 選挙人名簿抄本出力有無, boolean 登録者数リスト出力有無, FlexibleDate 時点日,
            boolean 登録者名簿出力有無, boolean 新規登録者宛名シール作成有無, boolean 抹消者名簿出力有無, boolean 失権者名簿出力有無,
            boolean 表示者名簿出力有無, boolean 訂正者名簿出力有無, List<RString> 集計項目IDリスト, RString 帳票ID, List<RString> 改頁項目IDリスト,
            RString 出力順, IShikibetsuTaishoPSMSearchKey key, IShikibetsuTaishoPSMSearchKey keyForAll, List<ShohonNo> 抄本番号List, RString table,
            Code 選挙種類, FlexibleDate 名簿確定日, FlexibleDate 年齢到達日, FlexibleDate 最新化時点日, boolean 最新化有無, boolean 名簿並び替え有無,
            RString 画面区分, int 削除count, List<ShikibetsuCode> 識別コードList) {
        this.処理種別 = 処理種別;
        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.選挙名 = 選挙名;
        this.基準日 = 基準日;
        this.投票日 = 投票日;
        this.受付開始日 = 受付開始日;
        this.選挙人名簿抄本出力有無 = 選挙人名簿抄本出力有無;
        this.登録者数リスト出力有無 = 登録者数リスト出力有無;
        this.時点日 = 時点日;
        this.登録者名簿出力有無 = 登録者名簿出力有無;
        this.新規登録者宛名シール作成有無 = 新規登録者宛名シール作成有無;
        this.抹消者名簿出力有無 = 抹消者名簿出力有無;
        this.失権者名簿出力有無 = 失権者名簿出力有無;
        this.表示者名簿出力有無 = 表示者名簿出力有無;
        this.訂正者名簿出力有無 = 訂正者名簿出力有無;
        this.集計項目IDリスト = 集計項目IDリスト;
        this.帳票ID = 帳票ID;
        this.改頁項目IDリスト = 改頁項目IDリスト;
        this.出力順 = 出力順;
        this.key = key;
        this.keyForAll = keyForAll;
        this.抄本番号List = 抄本番号List;
        this.table = table;
        this.選挙種類 = 選挙種類;
        this.名簿確定日 = 名簿確定日;
        this.年齢到達日 = 年齢到達日;
        this.最新化時点日 = 最新化時点日;
        this.最新化有無 = 最新化有無;
        this.名簿並び替え有無 = 名簿並び替え有無;
        this.画面区分 = 画面区分;
        this.削除count = 削除count;
        this.識別コードList = 識別コードList;
    }

    /**
     * SenkyojiKaikuMybatisParameterの変換のメソッドです。
     *
     *
     * @return SenkyojiKaikuMybatisParameter
     */
    public SenkyojiKaikuMybatisParameter toSenkyojiKaikuMybatisParameter() {

        return new SenkyojiKaikuMybatisParameter(null, 基準日, 選挙種類, null,
                抄本番号, 出力順, 処理種別, table, 抄本番号List, key, keyForAll, null, null, null, null,
                null, null, null, null, 名簿確定日, 年齢到達日, 最新化時点日, 最新化有無, 名簿並び替え有無, null, 識別コードList);

    }

}
