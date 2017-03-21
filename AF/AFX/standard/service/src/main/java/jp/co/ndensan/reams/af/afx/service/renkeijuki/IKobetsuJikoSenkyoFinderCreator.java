/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.renkeijuki;

/**
 *
 * @author
 */
public class IKobetsuJikoSenkyoFinderCreator {

    /**
     * 業務使用用インスタンスを返します。
     *
     * @return IKobetsuJikoSenkyoFinder
     */
    public static IKobetsuJikoSenkyoFinder createInstance() {
        return new KobetsuJikoSenkyoManager();
    }

}
