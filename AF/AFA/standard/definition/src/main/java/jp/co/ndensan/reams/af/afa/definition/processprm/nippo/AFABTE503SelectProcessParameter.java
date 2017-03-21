/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.nippo;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 日報関連帳票バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE503SelectProcessParameter implements IBatchProcessParameter {

    private IShikibetsuTaishoPSMSearchKey key;
    private boolean 無投票選挙出力Flg;
    private ShohonNo 抄本番号;

    private boolean processFlg;
    private boolean subProcessFlg;

    private RString 施設コードFr;
    private RString 施設コードTo;
    private FlexibleDate 投票日Fr;
    private FlexibleDate 投票日To;
    private FlexibleDate 交付日Fr;
    private FlexibleDate 交付日To;
    private FlexibleDate 受理日Fr;
    private FlexibleDate 受理日To;
    private RString 投票区コードFr;
    private RString 投票区コードTo;
    private FlexibleDate 期日前投票日Fr;
    private FlexibleDate 期日前投票日To;
    private RTime 投票時刻Fr;
    private RTime 投票時刻To;
    private RTime 受理時刻Fr;
    private RTime 受理時刻To;
    private List<RString> 投票状況リスト;
    private RString 投票事由コード;
    private FlexibleDate 受理日;
    private boolean 代理投票有フラグ;
    private boolean 点字フラグ;
    private RString order順;
    private List<RString> 改頁項目;
    private RString 地方公共団体コード;
    private int 地方公共団体コード連番;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 無投票選挙出力Flg boolean
     * @param 抄本番号 ShohonNo
     * @param processFlg boolean
     * @param subProcessFlg boolean
     * @param 施設コードFr RString
     * @param 施設コードTo RString
     * @param 投票日Fr FlexibleDate
     * @param 投票日To FlexibleDate
     * @param 交付日Fr FlexibleDate
     * @param 交付日To FlexibleDate
     * @param 受理日Fr FlexibleDate
     * @param 受理日To FlexibleDate
     * @param 投票区コードFr RString
     * @param 投票区コードTo RString
     * @param 期日前投票日Fr FlexibleDate
     * @param 期日前投票日To FlexibleDate
     * @param 投票時刻Fr RTime
     * @param 投票時刻To RTime
     * @param 受理時刻Fr RTime
     * @param 受理時刻To RTime
     * @param 投票状況リスト List<RString>
     * @param 投票事由コード RString
     * @param 受理日 FlexibleDate
     * @param 代理投票有フラグ boolean
     * @param 点字フラグ boolean
     * @param order順 RString
     * @param 改頁項目 List<RString>
     * @param 地方公共団体コード RString
     * @param 地方公共団体コード連番 int
     */
    public AFABTE503SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            boolean 無投票選挙出力Flg,
            ShohonNo 抄本番号,
            boolean processFlg,
            boolean subProcessFlg,
            RString 施設コードFr,
            RString 施設コードTo,
            FlexibleDate 投票日Fr,
            FlexibleDate 投票日To,
            FlexibleDate 交付日Fr,
            FlexibleDate 交付日To,
            FlexibleDate 受理日Fr,
            FlexibleDate 受理日To,
            RString 投票区コードFr,
            RString 投票区コードTo,
            FlexibleDate 期日前投票日Fr,
            FlexibleDate 期日前投票日To,
            RTime 投票時刻Fr,
            RTime 投票時刻To,
            RTime 受理時刻Fr,
            RTime 受理時刻To,
            List<RString> 投票状況リスト,
            RString 投票事由コード,
            FlexibleDate 受理日,
            boolean 代理投票有フラグ,
            boolean 点字フラグ,
            RString order順,
            List<RString> 改頁項目,
            RString 地方公共団体コード,
            int 地方公共団体コード連番
    ) {
        this.key = key;
        this.無投票選挙出力Flg = 無投票選挙出力Flg;
        this.抄本番号 = 抄本番号;

        this.processFlg = processFlg;
        this.subProcessFlg = subProcessFlg;

        this.施設コードFr = 施設コードFr;
        this.施設コードTo = 施設コードTo;
        this.投票日Fr = 投票日Fr;
        this.投票日To = 投票日To;
        this.交付日Fr = 交付日Fr;
        this.交付日To = 交付日To;
        this.受理日Fr = 受理日Fr;
        this.受理日To = 受理日To;
        this.投票区コードFr = 投票区コードFr;
        this.投票区コードTo = 投票区コードTo;
        this.期日前投票日Fr = 期日前投票日Fr;
        this.期日前投票日To = 期日前投票日To;
        this.投票時刻Fr = 投票時刻Fr;
        this.投票時刻To = 投票時刻To;
        this.受理時刻Fr = 受理時刻Fr;
        this.受理時刻To = 受理時刻To;
        this.投票状況リスト = 投票状況リスト;
        this.投票事由コード = 投票事由コード;
        this.受理日 = 受理日;
        this.代理投票有フラグ = 代理投票有フラグ;
        this.点字フラグ = 点字フラグ;
        this.order順 = order順;
        this.改頁項目 = 改頁項目;
        this.地方公共団体コード = 地方公共団体コード;
        this.地方公共団体コード連番 = 地方公共団体コード連番;
    }

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 無投票選挙出力Flg boolean
     * @param 抄本番号 ShohonNo
     * @param processFlg boolean
     * @param subProcessFlg boolean
     * @param 投票状況リスト List<RString>
     * @param order順 RString
     * @param 改頁項目 List<RString>
     */
    public AFABTE503SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key,
            boolean 無投票選挙出力Flg,
            ShohonNo 抄本番号,
            boolean processFlg,
            boolean subProcessFlg,
            List<RString> 投票状況リスト,
            RString order順,
            List<RString> 改頁項目) {
        this.key = key;
        this.無投票選挙出力Flg = 無投票選挙出力Flg;
        this.抄本番号 = 抄本番号;
        this.改頁項目 = 改頁項目;

        this.processFlg = processFlg;
        this.subProcessFlg = subProcessFlg;

        this.投票状況リスト = 投票状況リスト;
        this.order順 = order順;
    }

    /**
     * NippoMybatisParameter変換のメソッド
     *
     * @return NippoMybatisParameter
     */
    public NippoMybatisParameter toNippoMybatisParameter() {
        return new NippoMybatisParameter(key, 無投票選挙出力Flg, 抄本番号, processFlg, subProcessFlg, 施設コードFr,
                施設コードTo, 投票日Fr, 投票日To, 交付日Fr, 交付日To, 受理日Fr, 受理日To, 投票区コードFr, 投票区コードTo,
                期日前投票日Fr, 期日前投票日To, 投票時刻Fr, 投票時刻To, 受理時刻Fr, 受理時刻To, 投票状況リスト,
                投票事由コード, 受理日, 代理投票有フラグ, 点字フラグ, order順, 地方公共団体コード, 地方公共団体コード連番);
    }
}
