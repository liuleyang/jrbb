/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRH101;

import jp.co.ndensan.reams.af.afa.business.core.SeikyuDaihyoshaShomeishoParam;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRH101.SeikyuDaihyoshaShomeishoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 請求代表者証明書
 *
 * @reamsid_L AF-0140-030 wangh
 */
public class SeikyuDaihyoshaShomeishoEditor implements ISeikyuDaihyoshaShomeishoEditor {

    private static final RString タイトル_文字_1 = new RString("【");
    private static final RString タイトル_文字_2 = new RString("】に係る代表証明書");
    private static final RString 宣告_文字_1 = new RString("上記の者は、【");
    private static final RString 宣告_文字_2 = new RString("】に係る請求代表者であることを証明する。");
    private final SeikyuDaihyoshaShomeishoParam data;
    private RString 委員長名;

    /**
     * コンストラクタです。
     *
     * @param data {@link SeikyuDaihyoshaShomeishoParam}
     */
    public SeikyuDaihyoshaShomeishoEditor(SeikyuDaihyoshaShomeishoParam data) {
        this.data = data;
    }

    @Override
    public SeikyuDaihyoshaShomeishoSource edit(SeikyuDaihyoshaShomeishoSource source) {
        editタイトル(source);
        edit請求代表者名(source);
        edit宣告(source);
        edit発行年月日(source);
        edit市町村名(source);
        edit委員長名(source);
        return source;
    }

    private void editタイトル(SeikyuDaihyoshaShomeishoSource source) {
        source.title = タイトル_文字_1.concat(data.get請求名()).concat(タイトル_文字_2);
    }

    private void edit請求代表者名(SeikyuDaihyoshaShomeishoSource source) {
        source.ListDaihyoshaMei_1 = data.get請求代表者名();
    }

    private void edit宣告(SeikyuDaihyoshaShomeishoSource source) {
        source.sentence = 宣告_文字_1.concat(data.get請求名()).concat(宣告_文字_2);
    }

    private void edit発行年月日(SeikyuDaihyoshaShomeishoSource source) {
        source.hakkoYmd = data.get交付日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private void edit市町村名(SeikyuDaihyoshaShomeishoSource source) {
        source.shichosonMei = data.get市町村名();
    }

    private void edit委員長名(SeikyuDaihyoshaShomeishoSource source) {
        委員長名 = BusinessConfig.get(ConfigKeysAFA.選挙管理委員会委員長名, SubGyomuCode.AFA選挙本体);
        source.iinchoMei = 委員長名;
    }

}
