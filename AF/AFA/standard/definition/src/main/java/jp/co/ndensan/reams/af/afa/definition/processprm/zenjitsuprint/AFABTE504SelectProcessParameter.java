/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票日前日関連帳票バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0280-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE504SelectProcessParameter implements IBatchProcessParameter {

    private boolean 無投票選挙出力FLG;
    private RString 投票区コードFROM;
    private RString 投票区コードTO;
    private FlexibleDate 受理日FROM;
    private FlexibleDate 受理日TO;
    private List<SenkyoNo> 選挙番号リスト;
    private List<RString> 投票状況リスト;
    private ShohonNo 抄本番号;
    private IShikibetsuTaishoPSMSearchKey key;
    private RString 施設コードFROM = RString.EMPTY;
    private RString 施設コードTO = RString.EMPTY;
    private boolean 施設交付一覧FLG = false;
    private boolean 投票事由コードFLG = false;
    private boolean 期日前不在者区分FLG = false;
    private RString order順 = RString.EMPTY;
    private boolean 印字有無フラグ = false;
    private RString 地方公共団体コード = RString.EMPTY;
    private int 連番;

    /**
     * コンストラクタです。
     *
     * @param 無投票選挙出力FLG boolean
     * @param 投票区コードFROM RString
     * @param 投票区コードTO RString
     * @param 受理日FROM FlexibleDate
     * @param 受理日TO FlexibleDate
     * @param 選挙番号リスト List<SenkyoNo>
     * @param 投票状況リスト List<RString>
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 抄本番号 ShohonNo
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     */
    public AFABTE504SelectProcessParameter(boolean 無投票選挙出力FLG, RString 投票区コードFROM,
            RString 投票区コードTO, FlexibleDate 受理日FROM, FlexibleDate 受理日TO, List<SenkyoNo> 選挙番号リスト,
            List<RString> 投票状況リスト, IShikibetsuTaishoPSMSearchKey key, ShohonNo 抄本番号,
            RString order順, RString 地方公共団体コード, int 連番) {
        this.無投票選挙出力FLG = 無投票選挙出力FLG;
        this.投票区コードFROM = 投票区コードFROM;
        this.投票区コードTO = 投票区コードTO;
        this.受理日FROM = 受理日FROM;
        this.受理日TO = 受理日TO;
        this.選挙番号リスト = 選挙番号リスト;
        this.投票状況リスト = 投票状況リスト;
        this.抄本番号 = 抄本番号;
        this.key = key;
        this.order順 = order順;
        this.地方公共団体コード = 地方公共団体コード;
        this.連番 = 連番;
    }

    /**
     * ZenjitsuPrintMybatisParameter変換のメソッド
     *
     * @return ZenjitsuPrintMybatisParameter
     */
    public ZenjitsuPrintMybatisParameter toZenjitsuPrintMybatisParameter() {
        return new ZenjitsuPrintMybatisParameter(無投票選挙出力FLG, 施設交付一覧FLG,
                投票区コードFROM, 投票区コードTO, 受理日FROM, 受理日TO,
                選挙番号リスト, 投票状況リスト, key, 抄本番号,
                施設コードFROM, 施設コードTO, 投票事由コードFLG, 期日前不在者区分FLG,
                order順, 地方公共団体コード, 連番);
    }
}
