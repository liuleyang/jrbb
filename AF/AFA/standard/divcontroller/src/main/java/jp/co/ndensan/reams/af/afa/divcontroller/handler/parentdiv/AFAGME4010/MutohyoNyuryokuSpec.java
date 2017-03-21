/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4010;

import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KyojuKubun;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010.MutohyoNyuryokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author wangxt2
 */
public enum MutohyoNyuryokuSpec implements IPredicate<MutohyoNyuryokuDiv> {

    /**
     * コード入力値チェック
     */
    コード入力値チェック {

                private final RString コード_ZERO = new RString("0");
                private final RString コード_ONE = new RString("1");
                private final RString コード_TWO = new RString("2");
                private final RString コード_THREE = new RString("3");
                private final RString コード_FOUR = new RString("4");

                @Override
                public boolean apply(MutohyoNyuryokuDiv div) {
                    boolean flag = false;
                    RString code = div.getMutohyoNyuryokuJoken().getCcdKubunCode().getHdnTxtCodeShubetsu();
                    if (div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode() == null) {
                        return true;
                    }
                    if (AFACodeShubetsu.居住区分.getCodeShubetsu().value().equals(code)) {
                        flag = (KyojuKubun.居住.getCode().equals(div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().value())
                        || KyojuKubun.非居住.getCode().equals(div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().value()));
                    }
                    if (AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu().value().equals(code)) {
                        flag = div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_ZERO)
                        || div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_ONE)
                        || div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_TWO)
                        || div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_THREE)
                        || div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_FOUR);
                    }
                    if (AFACodeShubetsu.選挙資格区分.getCodeShubetsu().value().equals(code)) {
                        flag = div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_ZERO)
                        || div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_ONE)
                        || div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_TWO)
                        || div.getMutohyoNyuryokuJoken().getCcdKubunCode().getCode().getColumnValue().equals(コード_THREE);
                    }
                    return flag;
                }
            };
}
