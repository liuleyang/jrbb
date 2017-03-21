///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.af.afa.divcontroller.helper;
//
//import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
//import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
//import jp.co.ndensan.reams.uz.uza.core.mybatis._DbSession;
//import jp.co.ndensan.reams.uz.uza.lang.SystemException;
//import jp.co.ndensan.reams.uz.uza.workflow.context._WorkFlowSession;
//import jp.co.ndensan.reams.uz.uza.workflow.flow.dac._FlowDefinitionDac;
//import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowKey;
//
///**
// * ワークフローIDを取得するクラスです。
// *
// * @author N1823 有澤 礼恵
// */
//public final class WorkFlowIdFinder {
//
//    /**
//     * 現在のワークフローIDを取得します。
//     *
//     * @return String 現在のワークフローID
//     */
//    public String currentFlowId() {
//        SqlSession session = _DbSession.get(_WorkFlowSession.KEY);
//
//        try {
//            _FlowDefinitionDac dac = new _FlowDefinitionDac(session);
//
////            if (_ControlDataHolder.getControlData().getFlowContext().getFlowInstanceId().getInstanceId() != null) {
//            if (_ControlDataHolder.getControlData().getFlowContext() != null) {
//                FlowKey flowKey = dac.getFlowKey(_ControlDataHolder.getControlData().getFlowContext().getFlowInstanceId());
//                return flowKey.getFlowId().getId();
//            } else {
//                return "";
//            }
//        } catch (Exception e) {
//            throw new SystemException(e);
//        }
//    }
//
//}
