/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE510;

import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE510.ShisetsuKofuIchiranhyoSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票AFAPRE510_ShisetsuKofuIchiranhyo_施設交付一覧表を編集するクラスです。
 *
 * @reamsid_L AF-0280-027 wangm
 */
public class ShisetsuKofuIchiranhyoEditor implements IShisetsuKofuIchiranhyoEditor {

    private final ShisetsuKofuIchiranhyoParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target {@link ShisetsuKofuIchiranhyoParam}
     */
    public ShisetsuKofuIchiranhyoEditor(ShisetsuKofuIchiranhyoParam target) {
        this.target = target;
    }

    @Override
    public ShisetsuKofuIchiranhyoSource edit(ShisetsuKofuIchiranhyoSource source) {

        ZenjitsuCommonJohoItem 選挙帳票共通情報 = target.get選挙帳票共通情報();

        // 市町村コード
        source.shichosonCode = 選挙帳票共通情報.get市町村コード();

        // 市町村名
        source.shichosonMei = 選挙帳票共通情報.get市町村名();

        source.senkyoCode = new RString(target.get選挙番号().toString());
        // 選挙名称
        source.senkyoMei = target.get選挙名称();

        // 作成日時
        source.sakuseiYmdTime = 選挙帳票共通情報.get作成日時();

        // ページ
        source.pagecnt = new RString(String.valueOf(target.getPage()));

        // 番号_上
        source.listMeisai1_1 = target.get施設コード();

        // 病院施設名_上
        source.listMeisai1_2 = target.get施設名称();

        // 病院施設名_下
        source.listMeisai2_2 = target.get住所();

        // 請求人数_上
        Integer 請求人数 = target.get請求人数();
        source.listMeisai1_3 = getFormatNumber(請求人数);

        // 交付年月日_上
        source.listMeisai1_4 = editDate(target.get交付年月日());

        // 受理年月日_上
        source.listMeisai1_5 = editDate(target.get受理年月日());

        // 受理人数_上
        Integer 受理人数 = target.get受理人数();
        source.listMeisai1_6 = getFormatNumber(受理人数);

        // 番号_下
        source.listMeisai2_1 = RString.EMPTY;

        // 請求人数_下
        source.listMeisai2_3 = RString.EMPTY;

        // 交付年月日_下
        source.listMeisai2_4 = RString.EMPTY;

        // 受理年月日_下
        source.listMeisai2_5 = RString.EMPTY;

        // 受理人数_下
        source.listMeisai2_6 = RString.EMPTY;

        return source;
    }

    private RString editDate(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private RString getFormatNumber(Integer target) {
        return target == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(new Decimal(target), 0);
    }
}
