/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA100;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA100.MeiboShohonSource;
import jp.co.ndensan.reams.uz.uza.report.IReportBuilder;

/**
 * {@link MeiboShohonSource}をソースファイルへ出力できる形へ編集するインタフェースです。
 *
 * @param <T> 選挙人名簿抄本ソースの型
 */
public interface IMeiboShohonBuilder<T extends MeiboShohonSource> extends IReportBuilder<MeiboShohonSource> {

}
