/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.labelsealselectdialog;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ラベルシール印刷確認ダイアログ用ビジネスです。
 *
 * @reamsid_L AF-0620-015 liuyj
 */
public class LabelSealSelectDialog {

    private final KijitsumaeTohyoChohyoData chohyoData;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link KijitsumaeTohyoChohyoData}より{@link LabelSealSelectDialog}を生成します。
     *
     * @param chohyoData DBより取得した{@link KijitsumaeTohyoChohyoData}
     */
    public LabelSealSelectDialog(KijitsumaeTohyoChohyoData chohyoData) {
        this.chohyoData = requireNonNull(chohyoData);
    }

    /**
     * 選挙名称リストを返します。
     *
     * @return 選挙名称リスト List<RString>
     */
    public List<RString> get選挙名称リスト() {
        List<RString> list = new ArrayList<>();
        List<AfT111SenkyoEntity> senkyoEntitys = chohyoData.getEntity().getSenkyoJohoEntity().getSenkyoEntity();
        for (AfT111SenkyoEntity entity : senkyoEntitys) {
            list.add(entity.getSenkyoName());
        }
        return list;
    }

    /**
     * 選挙マークリストを返します。
     *
     * @return 選挙マークリスト List<RString>
     */
    public List<RString> get選挙マークリスト() {
        List<RString> list = new ArrayList<>();
        List<AfT111SenkyoEntity> senkyoEntitys = chohyoData.getEntity().getSenkyoJohoEntity().getSenkyoEntity();
        for (AfT111SenkyoEntity entity : senkyoEntitys) {
            list.add(entity.getSenkyoMark());
        }
        return list;
    }

    /**
     * 施設コードリストを返します。
     *
     * @return 施設コードリスト List<RString>
     */
    public List<RString> get施設コードリスト() {
        List<RString> list = new ArrayList<>();
        List<AfT201TohyoJokyoEntity> tohyoJokyoEntitys = chohyoData.getEntity().getTohyoJokyoEntityList();
        for (AfT201TohyoJokyoEntity entity : tohyoJokyoEntitys) {
            list.add(entity.getShisetsuCode());
        }
        return list;
    }
}
