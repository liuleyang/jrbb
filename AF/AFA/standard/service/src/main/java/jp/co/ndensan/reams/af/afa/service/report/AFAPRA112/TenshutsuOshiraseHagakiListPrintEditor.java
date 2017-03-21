package jp.co.ndensan.reams.af.afa.service.report.AFAPRA112;

import jp.co.ndensan.reams.af.afa.business.core.TenshutsuOshiraseHagakiListParam;
import jp.co.ndensan.reams.af.afa.service.core.Nyujoken3tsuori;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転出者お知らせハガキ作成対象者一覧表
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class TenshutsuOshiraseHagakiListPrintEditor {

    private static final RString ZERO = new RString("0");

    /**
     * 転出者お知らせハガキ作成対象者一覧表
     *
     * @param tenshutsuOshiraseHagaki TenshutsuOshiraseHagakiListParam
     * @return TenshutsuOshiraseHagakiListParam
     */
    public TenshutsuOshiraseHagakiListParam print転出者お知らせハガキ作成対象者一覧表(TenshutsuOshiraseHagakiListParam tenshutsuOshiraseHagaki) {

        Nyujoken3tsuori nyujoken3tsuori = new Nyujoken3tsuori();

        set名簿番号(tenshutsuOshiraseHagaki, nyujoken3tsuori);
        set生年月日(tenshutsuOshiraseHagaki, nyujoken3tsuori);

        return tenshutsuOshiraseHagaki;

    }

    private void set生年月日(TenshutsuOshiraseHagakiListParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get投票所入場券情報()) {
            RString 生年月日 = nyujoken3tsuori.getSeinengappi(param.get投票所入場券情報().get住民種別コード(), param.get投票所入場券情報().get生年月日());
            param.set生年月日(生年月日);
        }
    }

    private void set名簿番号(TenshutsuOshiraseHagakiListParam param, Nyujoken3tsuori nyujoken3tsuori) {
        if (null != param.get投票所入場券情報()) {
            RString 投票区コード = nyujoken3tsuori.getTohyokuCode(param.get投票所入場券情報().get投票区コード());
            RString 名簿番号 = nyujoken3tsuori.getMeiboNo(投票区コード, Integer.valueOf(changeNullToEmpty(param.get投票所入場券情報().get頁()).toString()),
                    Integer.valueOf(changeNullToEmpty(param.get投票所入場券情報().get行()).toString()));
            param.set名簿番号(名簿番号);
        }
    }

    private RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? ZERO : 文字列;
    }
}
