/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku;

import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_10;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_100;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_20;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_30;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_40;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_50;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_60;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_70;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_80;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuIntEnum.INT_90;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.一百以上;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.七十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.三十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.不明;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.九十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.二十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.五十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.八十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.六十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.十歳未満;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.四十代;
import static jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype.SeikyuShomeiboTorokuRStringEnum.横線;
import jp.co.ndensan.reams.af.afa.entity.db.relate.seikyushomeibotoroku.ShomeiboEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * AFAGMH1030_署名簿登録のクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public class ShomeiboResult {

    private final ShomeiboEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity コンストラクタです。
     */
    public ShomeiboResult(ShomeiboEntity entity) {
        this.entity = entity;

    }

    /**
     * 直接請求番号のgetメソッドです。
     *
     * @return 直接請求番号
     */
    public int getSeikyuNo() {
        return entity.getSeikyuNo();
    }

    /**
     * 冊のgetメソッドです。
     *
     * @return 冊
     */
    public RString getSatsu() {
        return entity.getSatsu();
    }

    /**
     * 頁のgetメソッドです。
     *
     * @return 頁
     */
    public int getPage() {
        return entity.getPage();
    }

    /**
     * 行のgetメソッドです。
     *
     * @return 行
     */
    public int getGyo() {
        return entity.getGyo();
    }

    /**
     * 審査区分のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分
     */
    public Code getShinsaKubun() {
        return entity.getShinsaKubun();
    }

    /**
     * 審査区分の名称のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分の名称
     */
    public RString getShinsaKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.審査区分.getCodeShubetsu(), entity.getShikakuKubun());
    }

    /**
     * 審査区分の略称のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分の略称
     */
    public RString getShinsaKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.審査区分.getCodeShubetsu(), entity.getShikakuKubun());
    }

    /**
     * 無効事由コードのgetメソッドです。
     *
     * @return 無効事由コード
     */
    public Code getMukoJiyuCode() {
        return entity.getMukoJiyuCode();
    }

    /**
     * 無効事由コードの名称のgetメソッドです。
     *
     * @return 無効事由コードの名称
     */
    public RString getMukoJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.無効事由コード.getCodeShubetsu(), entity.getMukoJiyuCode());
    }

    /**
     * 署名年月日のgetメソッドです。
     * <br/>
     * <br/>署名人が記入した日付を入力するため、暦上日とは限らない
     *
     * @return 署名年月日
     */
    public FlexibleDate getShomeiYMD() {
        return entity.getShomeiYMD();
    }

    /**
     * 署名年月日のgetメソッドです。
     *
     * @return 署名年月日
     */
    public RString get署名年月日和暦() {
        FlexibleDate 署名年月日 = entity.getShomeiYMD();
        return 署名年月日 == null ? RString.EMPTY : to和暦(署名年月日);
    }

    /**
     * 署名者識別コードのgetメソッドです。
     *
     * @return 署名者識別コード
     */
    public ShikibetsuCode getShomeishaShikibetsuCode() {
        return entity.getShomeishaShikibetsuCode();
    }

    /**
     * 漢字氏名のgetメソッドです。
     *
     * @return 漢字氏名
     */
    public RString getKanjiShimei() {
        return null == entity.getKanjiShimei() ? RString.EMPTY : entity.getKanjiShimei().getColumnValue();
    }

    /**
     * カナ氏名のgetメソッドです。
     *
     * @return カナ氏名
     */
    public RString getKanaShimei() {
        return null == entity.getKanaShimei() ? RString.EMPTY : entity.getKanaShimei().getColumnValue();
    }

    /**
     * 検索用カナ氏名のgetメソッドです。
     *
     * @return 検索用カナ氏名
     */
    public RString getSearchKanaShimei() {
        return null == entity.getSearchKanaShimei() ? RString.EMPTY : entity.getSearchKanaShimei().getColumnValue();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public RString get生年月日和暦() {
        FlexibleDate 生年月日 = entity.getSeinengappiYMD();
        return 生年月日 == null ? RString.EMPTY : to和暦(生年月日);
    }

    /**
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    public RString getSeibetsuCode() {
        return entity.getSeibetsuCode();
    }

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    public RString getJusho() {
        return null == entity.getJusho() ? RString.EMPTY : entity.getJusho().getColumnValue();
    }

    /**
     * 代筆者識別コードのgetメソッドです。
     *
     * @return 代筆者識別コード
     */
    public ShikibetsuCode getDaihitsushaShikibetsuCode() {
        return entity.getDaihitsushaShikibetsuCode();
    }

    /**
     * 代筆者漢字氏名のgetメソッドです。
     *
     * @return 代筆者漢字氏名
     */
    public RString getDaihitsushaKanjiShimei() {
        return null == entity.getDaihitsushaKanjiShimei() ? RString.EMPTY : entity.getDaihitsushaKanjiShimei().getColumnValue();
    }

    /**
     * 代筆者生年月日のgetメソッドです。
     *
     * @return 代筆者生年月日
     */
    public FlexibleDate getDaihitsushaSeinengappiYMD() {
        return entity.getDaihitsushaSeinengappiYMD();
    }

    /**
     * 代筆者生年月日のgetメソッドです。
     *
     * @return 代筆者生年月日
     */
    public RString get代筆者生年月日和暦() {
        FlexibleDate 代筆者生年月日 = entity.getDaihitsushaSeinengappiYMD();
        return 代筆者生年月日 == null ? RString.EMPTY : to和暦(代筆者生年月日);
    }

    /**
     * 年齢のgetメソッドです。
     *
     * @return 年齢
     */
    public RString get年齢() {
        FlexibleDate 生年月日 = entity.getSeinengappiYMD();
        if (null == 生年月日 || 生年月日.isEmpty()) {
            return 不明.getKey();
        } else {
            return new RString(to年齢(生年月日));
        }
    }

    /**
     * 年代のgetメソッドです。
     *
     * @return 年代
     */
    public RString get年代() {
        FlexibleDate 生年月日 = entity.getSeinengappiYMD();
        if (null == 生年月日 || 生年月日.isEmpty()) {
            return 不明.getKey();
        } else {
            return to年代(to年齢(生年月日));
        }
    }

    /**
     * 代筆者性別コードのgetメソッドです。
     *
     * @return 代筆者性別コード
     */
    public RString getDaihitsushaSeibetsuCode() {
        return entity.getDaihitsushaSeibetsuCode();
    }

    /**
     * 代筆者住所のgetメソッドです。
     *
     * @return 代筆者住所
     */
    public RString getDaihitsushaJusho() {
        return null == entity.getDaihitsushaJusho() ? RString.EMPTY : entity.getDaihitsushaJusho().getColumnValue();
    }

    /**
     * 選挙資格区分のgetメソッドです。
     *
     * @return 選挙資格区分
     */
    public Code get選挙資格区分() {
        return entity.getShikakuKubun();
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return null == entity.getTohyokuCode() ? RString.EMPTY : entity.getTohyokuCode();
    }

    /**
     * 投票区名のgetメソッドです。
     *
     * @return 投票区名
     */
    public RString get投票区名() {
        return entity.getTohyokuName();
    }

    /**
     * 投票所コードのgetメソッドです。
     *
     * @return 投票所コード
     */
    public RString get投票所コード() {
        return null == entity.getTohyokuCode() ? RString.EMPTY : entity.getTohyojoCode();
    }

    /**
     * 投票所名のgetメソッドです。
     *
     * @return 投票所名
     */
    public RString get投票所名() {
        return entity.getTohyojoName();
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString get住登内町域コード() {
        return null == entity.getJutonaiChoikiCode() ? RString.EMPTY : entity.getJutonaiChoikiCode().getColumnValue();
    }

    /**
     * 投票区名のgetメソッドです。
     *
     * @return 投票区名
     */
    public RString get住登内住所() {
        return entity.getJutonaiJusho();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getYukenshasuMan() {
        return null == entity.getYukenshasuMan() ? 0 : entity.getYukenshasuMan();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getYukenshasuWoman() {
        return null == entity.getYukenshasuWoman() ? 0 : entity.getYukenshasuWoman();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int get有権者計() {
        return getYukenshasuMan() + getYukenshasuWoman();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getYukosuMan() {
        return null == entity.getYukosuMan() ? 0 : entity.getYukosuMan();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getYukosuWoman() {
        return null == entity.getYukosuWoman() ? 0 : entity.getYukosuWoman();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int get署名有効計() {
        return getYukosuMan() + getYukosuWoman();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukosuMan() {
        return null == entity.getMukosuMan() ? 0 : entity.getMukosuMan();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukosuWoman() {
        return null == entity.getMukosuWoman() ? 0 : entity.getMukosuWoman();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int get署名無効計() {
        return getMukosuMan() + getMukosuWoman();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int get署名合計_男() {
        return getYukosuMan() + getMukosuMan();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int get署名合計_女() {
        return getYukosuWoman() + getMukosuWoman();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int get署名合計() {
        return get署名合計_男() + get署名合計_女();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu01_名簿未登録() {
        return null == entity.getMukoJiyu01() ? 0 : entity.getMukoJiyu01();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu02_管外居住() {
        return null == entity.getMukoJiyu02() ? 0 : entity.getMukoJiyu02();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu03_署名日未記載() {
        return null == entity.getMukoJiyu03() ? 0 : entity.getMukoJiyu03();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu04_住所未記載() {
        return null == entity.getMukoJiyu04() ? 0 : entity.getMukoJiyu04();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu05_生年月日未記載() {
        return null == entity.getMukoJiyu05() ? 0 : entity.getMukoJiyu05();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu06_無捺印() {
        return null == entity.getMukoJiyu06() ? 0 : entity.getMukoJiyu06();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu07_自書と認めず() {
        return null == entity.getMukoJiyu07() ? 0 : entity.getMukoJiyu07();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu08_同一筆跡代筆() {
        return null == entity.getMukoJiyu08() ? 0 : entity.getMukoJiyu08();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu09_重複署名() {
        return null == entity.getMukoJiyu09() ? 0 : entity.getMukoJiyu09();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu10_何人か未確認() {
        return null == entity.getMukoJiyu10() ? 0 : entity.getMukoJiyu10();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu11_期間外署名() {
        return null == entity.getMukoJiyu11() ? 0 : entity.getMukoJiyu11();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu12_委任日前() {
        return null == entity.getMukoJiyu12() ? 0 : entity.getMukoJiyu12();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu13_無契印() {
        return null == entity.getMukoJiyu13() ? 0 : entity.getMukoJiyu13();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu14_欄外署名() {
        return null == entity.getMukoJiyu14() ? 0 : entity.getMukoJiyu14();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu15_委任状瑕疵() {
        return null == entity.getMukoJiyu15() ? 0 : entity.getMukoJiyu15();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu16_受任者未登録() {
        return null == entity.getMukoJiyu16() ? 0 : entity.getMukoJiyu16();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu17_委任届なし() {
        return null == entity.getMukoJiyu17() ? 0 : entity.getMukoJiyu17();
    }

    /**
     * getメソッドです。
     *
     * @return RString
     */
    public int getMukoJiyu18_その他() {
        return null == entity.getMukoJiyu18() ? 0 : entity.getMukoJiyu18();
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString get投票区投票所年齢key() {
        return get投票区コード().concat(横線.getKey()).concat(get投票所コード()).concat(横線.getKey())
                .concat(get年齢());
    }

    /**
     * 投票区コードのgetメソッドです。
     *
     * @return 投票区コード
     */
    public RString get投票区投票所年代key() {
        return get投票区コード().concat(横線.getKey()).concat(get投票所コード()).concat(横線.getKey())
                .concat(get年代());
    }

    /**
     * AfT403ShomeiboEntityを返します。
     *
     * @return AfT403ShomeiboEntity
     */
    public ShomeiboEntity getEntity() {
        return entity;
    }

    private RString to和暦(FlexibleDate 日付) {
        return 日付.wareki().toDateString();
    }

    private int to年齢(FlexibleDate 生日) {
        RDate nowDate = RDate.getNowDate();
        int 年齢 = nowDate.getYearValue() - 生日.getYearValue();
        if (nowDate.getMonthValue() < 生日.getMonthValue()) {
            return 年齢 - 1;
        }
        if (nowDate.getMonthValue() > 生日.getMonthValue()) {
            return 年齢;
        }
        if (nowDate.getDayValue() < 生日.getDayValue()) {
            return 年齢 - 1;
        }
        return 年齢;
    }

    private RString to年代(int 年齢) {
        if (年齢 >= 0 && 年齢 < SeikyuShomeiboTorokuIntEnum.INT_10.getKey()) {
            return 十歳未満.getKey();
        } else if (年齢 >= INT_10.getKey()
                && 年齢 < INT_20.getKey()) {
            return 十代.getKey();
        } else if (年齢 >= INT_20.getKey()
                && 年齢 < INT_30.getKey()) {
            return 二十代.getKey();
        } else if (年齢 >= INT_30.getKey()
                && 年齢 < INT_40.getKey()) {
            return 三十代.getKey();
        } else if (年齢 >= INT_40.getKey()
                && 年齢 < INT_50.getKey()) {
            return 四十代.getKey();
        } else if (年齢 >= INT_50.getKey()
                && 年齢 < INT_60.getKey()) {
            return 五十代.getKey();
        } else if (年齢 >= INT_60.getKey()
                && 年齢 < INT_70.getKey()) {
            return 六十代.getKey();
        } else if (年齢 >= INT_70.getKey()
                && 年齢 < INT_80.getKey()) {
            return 七十代.getKey();
        } else if (年齢 >= INT_80.getKey()
                && 年齢 < INT_90.getKey()) {
            return 八十代.getKey();
        }
        return to年代九十代以上(年齢);
    }

    private RString to年代九十代以上(int 年齢) {
        if (年齢 >= INT_90.getKey()
                && 年齢 < INT_100.getKey()) {
            return 九十代.getKey();
        }
        return 一百以上.getKey();
    }
}
