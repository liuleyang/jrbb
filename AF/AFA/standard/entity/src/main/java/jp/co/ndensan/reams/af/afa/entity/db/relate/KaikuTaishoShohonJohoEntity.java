package jp.co.ndensan.reams.af.afa.entity.db.relate;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;

/**
 * 海区対象抄本情報共有子Div用Entityクラスです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaikuTaishoShohonJohoEntity {

    private AfT100ShohonEntity aft100Entity;
    private AfT111SenkyoEntity aft111Entity;

}
