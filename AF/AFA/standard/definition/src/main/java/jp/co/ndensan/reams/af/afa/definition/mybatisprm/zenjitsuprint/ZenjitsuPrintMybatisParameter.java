/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 投票日前日関連帳票バッチパラメータクラスです。
 *
 * @reamsid_L AF-0280-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ZenjitsuPrintMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final boolean 無投票選挙出力FLG;
    private final boolean 施設交付一覧FLG;
    private final RString 投票区コードFROM;
    private final RString 投票区コードTO;
    private final FlexibleDate 受理日FROM;
    private final FlexibleDate 受理日TO;
    private final List<SenkyoNo> 選挙番号リスト;
    private final List<RString> 投票状況リスト;
    private final ShohonNo 抄本番号;
    private final RString 施設コードFROM;
    private final RString 施設コードTO;
    private final boolean 投票事由コードFLG;
    private final boolean 期日前不在者区分FLG;
    private final RString order順;
    private final RString 地方公共団体コード;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 無投票選挙出力FLG boolean
     * @param 施設交付一覧FLG boolean
     * @param 投票区コードFROM RString
     * @param 投票区コードTO RString
     * @param 受理日FROM FlexibleDate
     * @param 受理日TO FlexibleDate
     * @param 選挙番号リスト List<SenkyoNo>
     * @param 投票状況リスト List<RString>
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 抄本番号 ShohonNo
     * @param 施設コードFROM RString
     * @param 施設コードTO RString
     * @param 投票事由コードFLG boolean
     * @param 期日前不在者区分FLG boolean
     * @param order順 RString
     * @param 地方公共団体コード RString
     * @param 連番 int
     */
    public ZenjitsuPrintMybatisParameter(boolean 無投票選挙出力FLG, boolean 施設交付一覧FLG, RString 投票区コードFROM,
            RString 投票区コードTO, FlexibleDate 受理日FROM, FlexibleDate 受理日TO, List<SenkyoNo> 選挙番号リスト,
            List<RString> 投票状況リスト, IShikibetsuTaishoPSMSearchKey key, ShohonNo 抄本番号,
            RString 施設コードFROM, RString 施設コードTO, boolean 投票事由コードFLG, boolean 期日前不在者区分FLG,
            RString order順, RString 地方公共団体コード, int 連番) {
        super(key);
        this.無投票選挙出力FLG = 無投票選挙出力FLG;
        this.施設交付一覧FLG = 施設交付一覧FLG;
        this.投票区コードFROM = 投票区コードFROM;
        this.投票区コードTO = 投票区コードTO;
        this.受理日FROM = 受理日FROM;
        this.受理日TO = 受理日TO;
        this.選挙番号リスト = 選挙番号リスト;
        this.投票状況リスト = 投票状況リスト;
        this.抄本番号 = 抄本番号;
        this.施設コードFROM = 施設コードFROM;
        this.施設コードTO = 施設コードTO;
        this.投票事由コードFLG = 投票事由コードFLG;
        this.期日前不在者区分FLG = 期日前不在者区分FLG;
        this.order順 = order順;
        this.地方公共団体コード = 地方公共団体コード;
        this.連番 = 連番;
    }
}
