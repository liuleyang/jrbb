/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.definition.mybatis;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * KobetsuJikoSenkyoFinderのパラメータです。
 */
public class KobetsuJikoSenkyoFinderParameter {

    private final RString shikibetsuCodes;
    private final FlexibleDate kijunbi;

    /**
     * コンストラクタです。
     *
     * @param codes List<ShikibetsuCode>
     * @param kijunbi FlexibleDate
     */
    public KobetsuJikoSenkyoFinderParameter(List<ShikibetsuCode> codes, FlexibleDate kijunbi) {
        this.shikibetsuCodes = covertListToSQL(codes);
        this.kijunbi = kijunbi;
    }

    /**
     * 識別コード列を返します。
     *
     * @return RString
     */
    public RString getShikibetsuCodes() {
        return shikibetsuCodes;
    }

    /**
     * 基準日を返します。
     *
     * @return FlexibleDate
     */
    public FlexibleDate getKijunbi() {
        return kijunbi;
    }

    private RString covertListToSQL(List<ShikibetsuCode> taisho) {
        if (taisho == null || taisho.isEmpty()) {
            return null;
        }
        RStringBuilder builder = new RStringBuilder("(");
        for (ShikibetsuCode code : taisho) {
            builder.append("'");
            builder.append(code.value());
            builder.append("',");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append(")");

        return builder.toRString();
    }

}
