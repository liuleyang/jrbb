/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.ur.urz.business.core.chiku.tohyoku.Tohyoku;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人の資格情報を表すクラスです。
 *
 * @author N2311 関　和可奈
 * @jpName 選挙人資格
 * @bizDomain 選挙
 * @category 選挙人
 * @subCategory 選挙人資格
 * @mainClass
 * @reference
 * @deprecated 使用してません
 */
public class _SenkyoninShikaku implements ISenkyoninShikaku {

    private final ShikibetsuCode 選挙人識別コード;
    private final SenkyoShikaku 選挙資格;
    private final Tohyoku 投票区;
    private final RDate 選挙人名簿登録年月日;

    /**
     * コンストラクタです。
     *
     * @param 選挙人識別コード 選挙人識別コード
     * @param 選挙資格 選挙資格
     * @param 投票区 投票区
     * @param 選挙人名簿登録年月日 選挙人名簿登録年月日
     * @throws NullPointerException 引数がNullの場合
     */
    public _SenkyoninShikaku(ShikibetsuCode 選挙人識別コード, SenkyoShikaku 選挙資格,
            Tohyoku 投票区, RDate 選挙人名簿登録年月日) throws NullPointerException {

        RString message = new RString("選挙人資格情報");
        this.選挙人識別コード = requireNonNull(選挙人識別コード, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("選挙人識別コード", message.toString()));
        this.選挙資格 = requireNonNull(選挙資格, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("選挙資格", message.toString()));
        this.投票区 = requireNonNull(投票区, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("投票区", message.toString()));
        this.選挙人名簿登録年月日 = requireNonNull(選挙人名簿登録年月日, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("選挙人名簿登録年月日", message.toString()));
    }

    @Override
    public ShikibetsuCode get選挙人識別コード() {
        return 選挙人識別コード;
    }

    @Override
    public SenkyoShikaku get選挙資格() {
        return 選挙資格;
    }

    @Override
    public Tohyoku get投票区() {
        return 投票区;
    }

    @Override
    public RDate get選挙人名簿登録年月日() {
        return 選挙人名簿登録年月日;
    }
}
