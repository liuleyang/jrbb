/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.business.core;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 選挙人資格情報のコレクションを表すクラスです。
 *
 * @author N2311 関　和可奈
 * @jpName 選挙人資格リスト
 * @bizDomain 選挙
 * @category 選挙人
 * @subCategory 選挙人資格
 * @mainClass
 * @reference
 * @deprecated 使用してません
 */
public class _SenkyoninShikakuList implements ISenkyoninShikakuList {

    private final List<ISenkyoninShikaku> 選挙人資格List;

    /**
     * コンストラクタです。
     *
     * @param senkyoninShikakuList 選挙人資格情報のリスト
     * @throws NullPointerException {@code senkyoninShikakuList}がnullの場合
     */
    public _SenkyoninShikakuList(List<ISenkyoninShikaku> senkyoninShikakuList)
            throws NullPointerException {
        this.選挙人資格List = Objects.requireNonNull(senkyoninShikakuList,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("選挙人資格情報リスト", "選挙人資格情報コレクション"));
    }

    @Override
    public long size() {
        return 選挙人資格List.size();
    }

    @Override
    public Iterator<ISenkyoninShikaku> iterator() {
        return 選挙人資格List.iterator();
    }

    @Override
    public ISenkyoninShikaku get選挙人資格(ShikibetsuCode 選挙人識別コード)
            throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(選挙人識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人識別コード"));

        for (ISenkyoninShikaku 選挙人資格 : 選挙人資格List) {
            if (isMatch選挙人識別コード(選挙人資格, 選挙人識別コード)) {
                return 選挙人資格;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する選挙人資格情報").evaluate());
    }

    private boolean isMatch選挙人識別コード(ISenkyoninShikaku 選挙人資格, ShikibetsuCode 選挙人識別コード) {
        return 選挙人資格.get選挙人識別コード().equals(選挙人識別コード);
    }
}
