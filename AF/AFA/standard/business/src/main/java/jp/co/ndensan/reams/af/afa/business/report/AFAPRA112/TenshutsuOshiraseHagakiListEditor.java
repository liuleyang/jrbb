/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA112;

import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiListParam;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.uz.uza.biz.HojinNo;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 転出者お知らせハガキ作成対象者一覧表
 *
 * @reamsid_L AF-0160-030 jihb
 */
public class TenshutsuOshiraseHagakiListEditor implements ITenshutsuOshiraseHagakiListEditor {

    private static final RString 帳票タイトル_通知 = new RString("転出者お知らせハガキ作成対象者一覧表");
    private static final RString 住所タイトル_通知 = new RString("転出先住所");
    private static final RString 日付タイトル_通知 = new RString("転出年月日");
    private static final RString 全角スペース = new RString("　");
    private static final RString 空白 = new RString(" ");

    private final TenshutsuOshiraseHagakiListParam data;

    /**
     * コンストラクタです。
     *
     * @param data {@link NijuTorokuTsuchishoListParamter}
     */
    public TenshutsuOshiraseHagakiListEditor(TenshutsuOshiraseHagakiListParam data) {
        this.data = data;
    }

    @Override
    public NijuTorokuTsuchishoListSource edit(NijuTorokuTsuchishoListSource source) {
        setヘッダ(source);
        set明細(source);
        editログの出力(source);
        return source;
    }

    private void editログの出力(NijuTorokuTsuchishoListSource source) {
        if (null == data.get投票所入場券情報()
                || null == data.get投票所入場券情報().get識別コード()) {
            return;
        }
        source.識別コード1 = data.get投票所入場券情報().get識別コード();
        source.個人番号使用 = KojinNo.EMPTY;
        source.法人番号使用 = HojinNo.EMPTY;
    }

    private RString get日付() {
        if (null != data.get投票所入場券情報() && null != data.get投票所入場券情報().get登録届出年月日()) {
            return data.get投票所入場券情報().get登録届出年月日().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get氏名() {
        if (null != data.get投票所入場券情報()) {
            return data.get投票所入場券情報().get名称();
        }
        return RString.EMPTY;
    }

    private RString get性別() {
        if (FEMALE.getCode().equals(data.get投票所入場券情報().get性別コード())) {
            return FEMALE.getName().getShortJapanese();
        } else if (MALE.getCode().equals(data.get投票所入場券情報().get性別コード())) {
            return MALE.getName().getShortJapanese();
        }
        return RString.EMPTY;
    }

    private RString get住所() {
        if (data.is合計Flag()) {
            return data.get合計出力内容();
        } else {
            return changeNullToEmpty(data.get投票所入場券情報().get住所()).replace(空白, RString.EMPTY).replace(全角スペース, RString.EMPTY)
                    .concat(changeNullToEmpty(data.get投票所入場券情報().get番地()).replace(空白, RString.EMPTY).replace(全角スペース, RString.EMPTY))
                    .concat(全角スペース).concat(changeNullToEmpty(data.get投票所入場券情報().get方書()));
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private void setヘッダ(NijuTorokuTsuchishoListSource source) {
        source.title = 帳票タイトル_通知;
        source.headJushoName = 住所タイトル_通知;
        source.headYmdName = 日付タイトル_通知;

        source.shichosonMei = data.get帳票共通ヘッダー().get市町村名();
        source.shichosonCode = data.get帳票共通ヘッダー().get市町村コード();
        source.senkyoMei = data.get抄本名();
        source.sakuseiYmdTime = data.get帳票共通ヘッダー().get作成日時();
    }

    private void set明細(NijuTorokuTsuchishoListSource source) {
        source.listMeisai_1 = get氏名();
        source.listMeisai_2 = data.get名簿番号();
        source.listMeisai_3 = data.get生年月日();
        source.listMeisai_4 = get性別();
        source.listMeisai_5 = get住所();
        source.listMeisai_6 = get日付();
    }

}
