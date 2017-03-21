/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.kumiai;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 組合コードのBusiness
 *
 * @reamsid_L AF-0500-030 guyq
 */
public class KumiaiResult {

    private final AfT509KumiaiEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link AfT509KumiaiEntity}より{@link KumiaiResult}を生成します。
     *
     * @param entity DBより取得した{@link ZaigaiSenkyoIdouRuisekiEntity}
     */
    public KumiaiResult(AfT509KumiaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("組合コード選択"));
    }

    /**
     * 組合コードを返します。
     *
     * @return 組合コード
     */
    public RString get組合コード() {
        return this.entity.getKumiaiCode();
    }

    /**
     * 組合名称を返します。
     *
     * @return 組合名称
     */
    public RString get組合名称() {
        return this.entity.getKumiaiName();
    }

    /**
     * カナ組合名称を返します。
     *
     * @return カナ組合名称
     */
    public RString getカナ組合名称() {
        return this.entity.getKanaKumiaiName();
    }

    /**
     * 検索用カナ組合名称を返します。
     *
     * @return 検索用カナ組合名称
     */
    public RString get検索用カナ組合名称() {
        return this.entity.getSearchKumiaiName();
    }

    /**
     * 組合の住所等を返します。
     *
     * @return 組合の住所等
     */
    public AtenaJusho get組合の住所等() {
        return this.entity.getJusho();
    }

}
