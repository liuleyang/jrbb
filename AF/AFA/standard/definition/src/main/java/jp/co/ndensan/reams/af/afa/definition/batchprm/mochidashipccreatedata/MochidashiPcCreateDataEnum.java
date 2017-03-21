/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata;

import java.util.Objects;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 選挙種類を表す列挙型です。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public enum MochidashiPcCreateDataEnum implements IRStringConvertable {

    /**
     * ZERO<br />
     * code：1
     */
    ZERO("0"),
    /**
     * ONE<br />
     * code：1
     */
    ONE("1"),
    /**
     * TWO<br />
     * code：2
     */
    TWO("2"),
    /**
     * THREE<br />
     * code：3
     */
    THREE("3"),
    /**
     * FOUR<br />
     * code：4
     */
    FOUR("4"),
    /**
     * FIVE<br />
     * code：5
     */
    FIVE("5"),
    /**
     * SIX<br />
     * code：6
     */
    SIX("6"),
    /**
     * SEVEN<br />
     * code：7
     */
    SEVEN("7"),
    /**
     * EIGHT<br />
     * code：8
     */
    EIGHT("8"),
    /**
     * NINE<br />
     * code：9
     */
    NINE("9"),
    /**
     * SIXTING<br />
     * code：60
     */
    SIXTY("60"),
    /**
     * forty<br />
     * code：40
     */
    FORTY("40"),
    /**
     * HUNDRED<br />
     * code：100
     */
    HUNDRED("100"),
    /**
     * 抄本名<br />
     * code：抄本名
     */
    抄本名("抄本名"),
    /**
     * 識別コード<br />
     * code：識別コード
     */
    識別コード("識別コード"),
    /**
     * 00:00:00<br />
     * code：00:00:00
     */
    HHMMSS("00:00:00"),
    /**
     * XXXX<br />
     * code：xxxx
     */
    XXXX("xxxx"),
    /**
     * _<br />
     * code：_
     */
    UNDERLINE("_"),
    /**
     * 注意種類コード<br />
     * code：01
     */
    注意種類コード("01"),
    /**
     * FALSE<br />
     * code：FALSE
     */
    FALSE("FALSE"),
    /**
     * CSV_DELIMITER<br />
     * code：,
     */
    CSV_DELIMITER(","),
    /**
     * FILE_PATH<br />
     * code：filePath
     */
    FILE_PATH("filePath"),
    /**
     * 選挙マスタ<br />
     * code：選挙マスタ
     */
    選挙マスタ("選挙マスタ"),
    /**
     * 抄本名_投票区_投票状況<br />
     * code：抄本名_投票区xxxx_投票状況
     */
    抄本名_投票区_投票状況("抄本名_投票区xxxx_投票状況"),
    /**
     * 抄本名_投票区_当日投票率<br />
     * code：抄本名_投票区xxxx_当日投票率
     */
    抄本名_投票区_当日投票率("抄本名_投票区xxxx_当日投票率"),
    /**
     * 抄本名_投票区_抄本<br />
     * code：抄本名_投票区xxxx_抄本
     */
    抄本名_投票区_抄本("抄本名_投票区xxxx_抄本"),
    /**
     * 投票区マスタ<br />
     * code：投票区マスタ
     */
    投票区マスタ("投票区マスタ"),
    /**
     * 管理情報<br />
     * code：管理情報
     */
    管理情報("管理情報"),
    /**
     * コード管理マスタ<br />
     * code：コード管理マスタ
     */
    コード管理マスタ("コード管理マスタ"),
    /**
     * コードマスタ<br />
     * code：コードマスタ
     */
    コードマスタ("コードマスタ"),
    /**
     * 選挙区マスタ<br />
     * code：選挙マスタ
     */
    選挙区マスタ("選挙区マスタ"),
    /**
     * 出力条件_投票日<br />
     * code：【投票日】
     */
    出力条件_投票日("【投票日】　"),
    /**
     * 出力条件_抄本番号<br />
     * code：【抄本番号】
     */
    出力条件_抄本番号("【抄本番号】　"),
    /**
     * あり<br />
     * code：あり
     */
    ALL0("0000"),
    /**
     * あり<br />
     * code：あり
     */
    ALL9("9999"),
    /**
     * 開始時刻<br />
     * code：開始時刻
     */
    開始時刻("700"),
    /**
     * 終了時刻<br />
     * code：終了時刻
     */
    終了時刻("2000"),
    /**
     * 男<br />
     * code：男
     */
    男("男"),
    /**
     * 女<br />
     * code：女
     */
    女("女"),
    /**
     * 代理投票者<br />
     * code：代理投票者
     */
    代理投票者("代理投票者"),
    /**
     * 点字用紙<br />
     * code：点字用紙
     */
    点字用紙("点字用紙"),
    /**
     * 棄権<br />
     * code：棄権
     */
    棄権("棄権"),
    /**
     * 処理可能な<br />
     * code：処理可能な
     */
    処理可能な("処理可能な"),
    /**
     * あり<br />
     * code：あり
     */
    あり("あり"),
    /**
     * なし<br />
     * code：なし
     */
    なし("なし");

    private final RString code;

    private MochidashiPcCreateDataEnum(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定された選挙種類codeの選挙種類を返します。
     *
     * @param code 選挙種類code
     * @return 選挙種類
     */
    public static MochidashiPcCreateDataEnum toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類コード"));
        for (MochidashiPcCreateDataEnum item : MochidashiPcCreateDataEnum.values()) {
            if (item.getRString().equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当の選挙種類コード").toString());
    }

    /**
     * 選挙種類コードを返します。
     *
     * @return 選挙種類コード
     */
    public RString getRString() {
        return code;
    }

    /**
     * 選挙種類コードを返します。
     *
     * @return 選挙種類コード
     */
    public Integer getInteger() {
        return Integer.valueOf(code.toString());
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号コード
     */
    public SenkyoNo getSenkyoNo() {
        return new SenkyoNo(code);
    }

    /**
     * 選挙番号を返します。
     *
     * @return 選挙番号コード
     */
    public Code getCode() {
        return new Code(code);
    }

    @Override
    public RString toRString() {
        return new RString(MochidashiPcCreateDataEnum.this.toString());
    }

}
