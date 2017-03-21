/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.shohon.shohon;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 抄本をリストで保持するクラスです。
 */
public class ShohonList {

    private final List<Shohon> 抄本リスト;

    /**
     * コンストラクタです。
     *
     * @param shohonEntityList 抄本エンティティのリスト
     * @throws NullPointerException {@code shohonEntityList}がnullの場合
     */
    public ShohonList(List<AfT100ShohonEntity> shohonEntityList)
            throws NullPointerException {
        requireNonNull(shohonEntityList,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("抄本エンティティリスト", "抄本リスト"));
        List<Shohon> list = new ArrayList<>();
        if (shohonEntityList != null) {
            for (AfT100ShohonEntity entity : shohonEntityList) {
                list.add(new Shohon(entity.getShohonNo()));
            }
        }
        this.抄本リスト = list;
    }

    /**
     * 抄本のリストを返します。
     *
     * @return 抄本リスト
     */
    public List<Shohon> getList() {
        return 抄本リスト;
    }
}
