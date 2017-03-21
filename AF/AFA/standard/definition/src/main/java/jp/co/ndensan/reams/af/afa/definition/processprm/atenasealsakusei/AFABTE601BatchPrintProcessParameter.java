/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.atenasealsakusei;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.Senkyomeishou;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu.SenkyoninIrain;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名シール作成バッチ出力条件表のパラメータクラスです。
 *
 * * @reamsid_L AF-0620-020 guancy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE601BatchPrintProcessParameter implements IBatchProcessParameter {

    private RString 帳票ID;
    private RString 地方公共団体コード;
    private RString 市町村名;
    private Long ジョブ番号;
    private RString 帳票名;
    private RString 出力ページ数;
    private RString ファイル名_CSV;

    private ShohonNo 抄本番号;
    private RString 抄本名;

    private RString 選挙種類;

    private FlexibleDate 投票日;

    private List<Senkyomeishou> 選挙リスト;

    private RString 入場券名1;

    private RString 入場券名2;

    private RString 入場券名3;

    private List<SenkyoninIrain> 選挙人一覧リスト;

    private RString 印刷タイプ;

    private RString 世帯印字人数;

    private Boolean 対象者を個々に作成する有無;

    private Boolean 対象者の世帯で作成する有無;

    private RString サンプル文字;

    /**
     *
     *
     * @param 抄本番号 RString
     * @param 抄本名 RString
     * @param 選挙種類 RString
     * @param 投票日 FlexibleDate
     * @param 選挙リスト List<SenkyomeishouParam>
     * @param 入場券名1 RString
     * @param 入場券名2 RString
     * @param 入場券名3 RString
     * @param 選挙人一覧リスト List<SenkyoninIrain>
     * @param 印刷タイプ RString
     * @param 世帯印字人数 RString
     * @param 対象者を個々に作成する有無 Boolean
     * @param 対象者の世帯で作成する有無 Boolean
     * @param サンプル文字 RString
     */
    public AFABTE601BatchPrintProcessParameter(
            ShohonNo 抄本番号,
            RString 抄本名,
            RString 選挙種類,
            FlexibleDate 投票日,
            List<Senkyomeishou> 選挙リスト,
            RString 入場券名1,
            RString 入場券名2,
            RString 入場券名3,
            List<SenkyoninIrain> 選挙人一覧リスト,
            RString 印刷タイプ,
            RString 世帯印字人数,
            Boolean 対象者を個々に作成する有無,
            Boolean 対象者の世帯で作成する有無,
            RString サンプル文字) {

        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.選挙種類 = 選挙種類;
        this.投票日 = 投票日;
        this.選挙リスト = 選挙リスト;
        this.入場券名1 = 入場券名1;
        this.入場券名2 = 入場券名2;
        this.入場券名3 = 入場券名3;
        this.選挙人一覧リスト = 選挙人一覧リスト;
        this.印刷タイプ = 印刷タイプ;
        this.世帯印字人数 = 世帯印字人数;
        this.対象者を個々に作成する有無 = 対象者を個々に作成する有無;
        this.対象者の世帯で作成する有無 = 対象者の世帯で作成する有無;
        this.サンプル文字 = サンプル文字;
    }

}
