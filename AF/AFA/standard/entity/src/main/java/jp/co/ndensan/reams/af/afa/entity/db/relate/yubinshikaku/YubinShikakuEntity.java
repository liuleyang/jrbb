/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.yubinshikaku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;

/**
 * 投票資格情報RelateEntityクラスです。
 *
 * @reamsid_L AF-0200-020 liuj2
 */
@lombok.Getter
@lombok.Setter
public class YubinShikakuEntity implements Cloneable, Serializable {

    private AfT114FuzaishaTohyoShikakuEntity 不在者投票資格;

    private AfT115FuzaishaTohyoShikakuYubinEntity 郵便投票資格付随情報;
}
