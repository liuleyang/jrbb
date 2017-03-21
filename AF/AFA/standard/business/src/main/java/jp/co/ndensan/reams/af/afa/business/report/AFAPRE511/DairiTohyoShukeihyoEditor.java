/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE511;

import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE511.DairiTohyoShukeihyoParam.女;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE511.DairiTohyoShukeihyoParam.男;
import static jp.co.ndensan.reams.af.afa.business.report.AFAPRE511.DairiTohyoShukeihyoParam.計;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE511.DairiTohyoShukeihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票AFAPRE511_DairiTohyoShukeihyo_代理投票集計表を編集するクラスです。
 *
 * @reamsid_L AF-0280-028 wangm
 */
public class DairiTohyoShukeihyoEditor implements IDairiTohyoShukeihyoEditor {

    

    private final DairiTohyoShukeihyoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link DairiTohyoShukeihyoParam}
     */
    public DairiTohyoShukeihyoEditor(DairiTohyoShukeihyoParam target) {
        this.target = target;
    }

    @Override
    public DairiTohyoShukeihyoSource edit(DairiTohyoShukeihyoSource source) {

        editタイトル(source);
        editDetail(source);
        return source;
    }

    private void editタイトル(DairiTohyoShukeihyoSource source) {
        ZenjitsuCommonJohoItem 選挙帳票共通情報 = target.get選挙帳票共通情報();

        // サブタイトル
        source.subTitle = target.getサブタイトル();
        // 市町村コード
        source.shichosonCode = 選挙帳票共通情報.get市町村コード();
        // 市町村名
        source.shichosonMei = 選挙帳票共通情報.get市町村名();
        // 選挙名称
        source.senkyoMei = target.get選挙名称();
        // タイトル　対象期間
        source.titleTaishoKikan = target.getタイトル_対象期間();
        // 対象期間
        source.taishoKikanYmd = target.get対象期間();
        // 作成日時
        source.sakuseiYmdTime = 選挙帳票共通情報.get作成日時();
        // ページ
        source.pagecnt = new RString(String.valueOf(target.getページ()));
        // 投票種類
        source.tohyoShurui = target.get投票種類();
        // 洋上投票タイトル上
        source.yojoTitleJo = target.get洋上投票タイトル上();
        // 洋上投票タイトル下
        source.yojoTitleGe = target.get洋上投票タイトル下();
    }

    private void editDetail(DairiTohyoShukeihyoSource source) {
        // 投票区
        source.listMeisai_1 = target.get投票区();
        // 投票者数（男）
        source.listMeisai_2 = formatInt(target.get投票者数().get(男));
        // 投票者数（女）
        source.listMeisai_3 = formatInt(target.get投票者数().get(女));
        // 投票者数（計）
        source.listMeisai_4 = formatInt(target.get投票者数().get(計));
        // 代理投票者数（男）
        source.listMeisai_5 = formatInt(target.get代理投票者数().get(男));
        // 代理投票者数（女）
        source.listMeisai_6 = formatInt(target.get代理投票者数().get(女));
        // 代理投票者数（計）
        source.listMeisai_7 = formatInt(target.get代理投票者数().get(計));
        // 点字投票者数
        source.listMeisai_8 = formatInt(target.get点字投票者数());
        if (!RString.isNullOrEmpty(target.get洋上投票タイトル上())) {
            // 洋上投票者数
            source.listMeisai_9 = formatInt(target.get洋上投票者数());
        }
    }

    private RString formatInt(Decimal trgt) {
        return new RString(trgt.toString("#,##0"));
    }

}
