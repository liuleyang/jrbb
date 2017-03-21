/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.euc;

import static jp.co.ndensan.reams.af.afa.definition.core.euc.EucOutputType.CSV;
import static jp.co.ndensan.reams.af.afa.definition.core.euc.EucOutputType.ZIP;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * EUCエンティティIDを表す列挙型です。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public enum AFAEucEntityId {

    /**
     * 登録者数リスト。
     */
    登録者数リスト("AFAPRA103tempTorokushasuList", "AFAPRA103tempTorokushasuList", CSV),
    /**
     * 登録者数リスト（不在者投票資格者分）。
     */
    登録者数リスト不在者投票資格者分("AFAPRA103tempTorokushasuListFuzaiShikaku", "AFAPRA103tempTorokushasuListFuzaiShikaku", CSV),
    /**
     * 有権者数調べ。
     */
    有権者数調べ("AFAPRA104tempYukenshasu", "AFAPRA104tempYukenshasu", CSV),
    /**
     * 定時登録のデータ取得。
     */
    定時登録データ取得("TeijiTourokuDataSelectProcessTemp", "TeijiTourokuDataSelectProcessTemp", CSV),
    /**
     * 選挙時登録_データ取得。
     */
    選挙時登録データ取得("SenkyojiTourokuDataSelectProcessTemp", "SenkyojiTourokuDataSelectProcessTemp", CSV),
    /**
     * 年代別投票率集計表。
     */
    年代別投票率集計表("AFAPRE520_NendaibetsuTohyoritsu", "年代別行政区別投票率集計CSV", CSV),
    /**
     * 年齢別投票率集計表。
     */
    年齢別投票率集計表("AFAPRE520_NenreibetsuTohyoritsu", "年齢別行政区別投票率集計CSV", CSV),
    /**
     * 選挙ファイル。
     */
    選挙ファイル("AFABTE801_Senkyo", "選挙マスタ", CSV),
    /**
     * 選挙ファイル。
     */
    抄本名_投票区ZIP("AFABTE801_ZIP", "抄本名_投票区xxxx", ZIP),
    /**
     * 投票状況ファイル。
     */
    投票状況ファイル("AFABTE801_TohyoJyokyo", "抄本名_投票区xxxx_投票状況", CSV),
    /**
     * 当日投票率ファイル。
     */
    当日投票率ファイル("AFABTE801_TojituTohyoritu", "抄本名_投票区xxxx_当日投票率", CSV),
    /**
     * 抄本ファイル。
     */
    抄本ファイル("AFABTE801_Shohon", "抄本名_投票区xxxx_抄本", CSV),
    /**
     * 投票区ファイル。
     */
    投票区ファイル("AFABTE801_Tohyoku", "投票区マスタ", CSV),
    /**
     * 管理情報ファイル。
     */
    管理情報ファイル("AFABTE801_KanriJyoho", "管理情報", CSV),
    /**
     * コード管理ファイル。
     */
    コード管理ファイル("AFABTE801_CodeKanri", "コード管理マスタ", CSV),
    /**
     * コードファイル。
     */
    コードファイル("AFABTE801_Code", "コードマスタ", CSV),
    /**
     * 選挙区ファイル。
     */
    選挙区ファイル("AFABTE801_Senkyoku", "選挙区マスタ", CSV),
    /**
     * 投票区マスタ。
     */
    投票区マスタ("AFAGMM3010_Tohyoku", "TohyokuMaster", CSV),
    /**
     * 署名件数表_投票区別。
     */
    署名件数表_投票区別("AFAMNH1020_KensuTohyoku", "署名件数表（投票区別）", CSV),
    /**
     * 署名件数表_投票区別。
     */
    署名件数表_住所別("AFAMNH1020_KensuJusho", "署名件数表（住所別）", CSV),
    /**
     * 署名件数表_投票区別。
     */
    無効件数無効事由内訳表_投票区別("AFAMNH1020_MukoTohyoku", "無効件数無効事由内訳表（投票区別）", CSV),
    /**
     * 署名件数表_投票区別。
     */
    無効件数無効事由内訳表_住所別("AFAMNH1020_MukoJusho", "無効件数無効事由内訳表（住所別）", CSV),
    /**
     * 署名件数表_投票区別。
     */
    年齢別投票率("AFAMNH1020_Nenrei", "年齢別投票率集計表", CSV),
    /**
     * 署名件数表_投票区別。
     */
    年代別投票率("AFAMNH1020_Nendai", "年代別投票率集計表", CSV),
    /**
     * 投票所マスタ。
     */
    投票所マスタ("AFAGMM3010_Tohyojo", "TohyojoMaster", CSV),
    /**
     * 選挙区マスタ。
     */
    選挙区マスタ("AFAGMM3010_Senkyoku", "SenkyokuMaster", CSV),
    /**
     * 施設マスタ。
     */
    施設マスタ("AFAGMM3010_Shisetsu", "ShisetsuMaster", CSV),
    /**
     * 補助者マスタ。
     */
    補助者マスタ("AFAGMM3010_Hojosha", "HojoshaMaster", CSV),
    /**
     * 組合マスタ。
     */
    組合マスタ("AFAGMM3010_Kumiai", "KumiaiMaster", CSV),
    /**
     * 領事官マスタ。
     */
    領事官マスタ("AFAGMM3010_Ryojikan", "RyojikanMaster", CSV),
    /**
     * コードマスタ。
     */
    コードマスタ("AFAGMM3010_AfCodeMaster", "AfCodeMaster", CSV),
    /**
     * コンフィグ。
     */
    コンフィグ("AFAGMM3010_AfConfig", "AfConfig", CSV),
    /**
     * 名簿調製用連携ファイル作成。
     */
    名簿調製用連携ファイル作成("AFABTF101_MeiboChoseiFileSakusei", "MeiboChoseiFileSakusei", CSV),
    /**
     * 同一人物調査結果。
     */
    同一人物調査結果("AFAPRM320_DoitsujinbutsuChosa", "DoitsujinbutsuChosa", CSV);

    private final EucEntityId eucEntityId;
    private final RString fileName;
    private final EucOutputType type;

    private AFAEucEntityId(String eucEntityId, String fileName, EucOutputType type) {
        this.eucEntityId = new EucEntityId(eucEntityId);
        this.fileName = new RString(fileName);
        this.type = type;
    }

    /**
     * EUCエンティティIDを返します。
     *
     * @return EUCエンティティID
     */
    public EucEntityId getEucEntityId() {
        return this.eucEntityId;
    }

    /**
     * EUCエンティティIDをRStringで返します。
     *
     * @return EUCエンティティID
     */
    public RString value() {
        return this.eucEntityId.toRString();
    }

    /**
     * ファイル名を返します。
     *
     * @return ファイル名
     */
    public RString getFileName() {
        return new RStringBuilder(this.fileName).append(this.type.getSuffix()).toRString();
    }

    /**
     * ファイル名に現在日時を足したものを返します。
     *
     * @return ファイル名＋現在日時
     */
    public RString getFileNameWithDateTime() {
        RDateTime rDateTime = RDateTime.now();
        return new RStringBuilder(this.fileName)
                .append("_")
                .append(getDateString(rDateTime))
                .append(getTimeString(rDateTime))
                .append(this.type.getSuffix()).toRString();
    }

    private RString getDateString(RDateTime rDateTime) {
        return rDateTime.getDate().toDateString();
    }

    private RString getTimeString(RDateTime rDateTime) {
        return new RStringBuilder(rDateTime.getHour()).append(rDateTime.getMinute()).append(rDateTime.getSecond()).toRString();
    }

    /**
     * ファイル名に現在日付を足したものを返します。
     *
     * @return ファイル名＋現在日付
     */
    public RString getFileNameWithDateString() {
        RDateTime rDateTime = RDateTime.now();
        return new RStringBuilder(this.fileName)
                .append("_")
                .append(getDateString(rDateTime))
                .append(this.type.getSuffix()).toRString();
    }

    /**
     * ファイル名に現在日付を足したものを返します
     *
     * @return ファイル名＋システム日付（時間）
     */
    public RString getFileNameWithDateHHMMString() {
        RDateTime rDateTime = RDateTime.now();
        return new RStringBuilder(this.fileName)
                .append("_")
                .append(getDateString(rDateTime))
                .append(new RString(Integer.toString(rDateTime.getHour())).padZeroToLeft(2))
                .append(new RString(Integer.toString(rDateTime.getMinute())).padZeroToLeft(2))
                .append(this.type.getSuffix()).toRString();
    }
}

/**
 * 出力形式の列挙型です。
 */
enum EucOutputType {

    Excel(".xlsx"),
    XLS(".xls"),
    CSV(".csv"),
    ZIP(".zip"),
    TXT(".txt");

    private final RString suffix;

    private EucOutputType(String type) {
        this.suffix = new RString(type);
    }

    /**
     * 出力形式を返します
     *
     * @return 出力形式
     */
    public RString getSuffix() {
        return suffix;
    }
}
