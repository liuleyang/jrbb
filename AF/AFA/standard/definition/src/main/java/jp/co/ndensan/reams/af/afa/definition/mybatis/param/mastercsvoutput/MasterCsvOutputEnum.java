/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.mastercsvoutput;

import java.util.Objects;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 各種マスタデータ出力の列挙型です。
 *
 * @reamsid_L AF-0670-010 lis
 */
public enum MasterCsvOutputEnum implements IRStringConvertable {

    /**
     * ZERO<br />
     * code：0
     */
    ZERO("0"),
    /**
     * カンマ<br />
     * code：,
     */
    カンマ(","),
    /**
     * RGAF<br />
     * code：rgaf
     */
    RGAF("rgaf");

    private final RString code;

    private MasterCsvOutputEnum(String code) {
        this.code = new RString(code);
    }

    /**
     * 指定された選挙種類codeの選挙種類を返します。
     *
     * @param code 選挙種類code
     * @return 選挙種類
     */
    public static MasterCsvOutputEnum toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙種類コード"));
        for (MasterCsvOutputEnum item : MasterCsvOutputEnum.values()) {
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
        return new RString(MasterCsvOutputEnum.this.toString());
    }

}
