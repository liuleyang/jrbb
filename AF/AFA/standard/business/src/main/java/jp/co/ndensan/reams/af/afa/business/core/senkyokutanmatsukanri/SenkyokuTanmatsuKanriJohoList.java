/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyokutanmatsukanri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 選挙区端末管理を管理するクラスです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuTanmatsuKanriJohoList implements Serializable {

    private static final long serialVersionUID = -6967514159611800360L;

    private List<SenkyokuTanmatsuKanriJoho> 選挙区リスト;

    /**
     * コンストラクタです。
     */
    public SenkyokuTanmatsuKanriJohoList() {
        選挙区リスト = new ArrayList();
    }

    /**
     * 選挙区リスト
     *
     * @return AfT505SenkyokuTanmatsuKanriEntity
     */
    public List<SenkyokuTanmatsuKanriJoho> get選挙区リスト() {
        return 選挙区リスト;
    }

    /**
     * 選挙区リスト
     *
     * @param 選挙区リスト List<SenkyokuTanmatsuKanriJoho>
     */
    public void set選挙区リスト(List<SenkyokuTanmatsuKanriJoho> 選挙区リスト) {
        this.選挙区リスト = 選挙区リスト;
    }
}
