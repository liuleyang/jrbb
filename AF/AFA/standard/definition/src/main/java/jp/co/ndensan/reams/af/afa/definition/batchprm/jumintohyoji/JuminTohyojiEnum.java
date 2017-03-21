/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.jumintohyoji;

import jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
public final class JuminTohyojiEnum {

    private JuminTohyojiEnum() {

    }

    /**
     * コンストラクタ作成します。
     *
     * @return JuminTohyojiEnum
     */
    public JuminTohyojiEnum creatInstance() {
        return new JuminTohyojiEnum();
    }
    /**
     * 出力条件_処理種別
     */
    public static final RString 出力条件_処理種別;
    /**
     * 出力条件_抄本
     */
    public static final RString 出力条件_抄本;
    /**
     * 出力条件_住民投票名
     */
    public static final RString 出力条件_住民投票名;
    /**
     * 出力条件_投票日
     */
    public static final RString 出力条件_投票日;
    /**
     * 出力条件_投票開始日
     */
    public static final RString 出力条件_投票開始日;
    /**
     * 出力条件_住民種別
     */
    public static final RString 出力条件_住民種別;
    /**
     * 出力条件_住民状態
     */
    public static final RString 出力条件_住民状態;
    /**
     * 出力条件_転出日
     */
    public static final RString 出力条件_転出日;
    /**
     * 出力条件_転入日
     */
    public static final RString 出力条件_転入日;
    /**
     * 出力条件_抽出対象者に公民権停止者の人
     */
    public static final RString 出力条件_抽出対象者に公民権停止者の人;

    /**
     * 出力条件_年齢計算基準日
     */
    public static final RString 出力条件_年齢計算基準日;
    /**
     * 出力条件_何歳以上
     */
    public static final RString 出力条件_何歳以上;
    /**
     * 出力条件_基準日翌日の誕生日の人
     */
    public static final RString 出力条件_基準日翌日の誕生日の人;
    /**
     * 出力条件_住定期間
     */
    public static final RString 出力条件_住定期間;
    /**
     * 出力条件_期間中連続で居住
     */
    public static final RString 出力条件_期間中連続で居住;
    /**
     * 出力条件_住所条件
     */
    public static final RString 出力条件_住所条件;
    /**
     * 出力条件_住所条件選択リスト
     */
    public static final RString 出力条件_住所条件選択リスト;
    /**
     * 出力条件_住民投票資格者名簿抄本
     */
    public static final RString 出力条件_住民投票資格者名簿抄本;

    /**
     * 出力内容_連絡符号１
     */
    public static final RString 出力内容_連絡符号１;
    /**
     * 出力内容_連絡符号２
     */
    public static final RString 出力内容_連絡符号２;

    /**
     * CSV出力有無_有り
     */
    public static final RString CSV出力有無_有り;
    /**
     * 出力内容_出力
     */
    public static final RString 出力内容_出力;
    /**
     * 出力内容_出力しない
     */
    public static final RString 出力内容_出力しない;
    /**
     * 出力内容_含む
     */
    public static final RString 出力内容_含む;
    /**
     * 出力内容_含まない
     */
    public static final RString 出力内容_含まない;
    /**
     * 出力内容_年以上
     */
    public static final RString 出力内容_年以上;
    /**
     * 出力内容_以降
     */
    public static final RString 出力内容_以降;
    /**
     * 出力内容_以前
     */
    public static final RString 出力内容_以前;
    /**
     * 住民状態_住民
     */
    public static final RString 住民状態_住民;
    /**
     * 住民状態_転出者
     */
    public static final RString 住民状態_転出者;
    /**
     * 住民状態_転入者
     */
    public static final RString 住民状態_転入者;
    /**
     * 住民種別_日本人
     */
    public static final RString 住民種別_日本人;
    /**
     * 住民種別_外国人
     */
    public static final RString 住民種別_外国人;
    /**
     * RST_0
     */
    public static final RString RST_0;
    /**
     * RST_1
     */
    public static final RString RST_1;
    /**
     * RST_2
     */
    public static final RString RST_2;
    /**
     * INT_10
     */
    public static final int INT_10;

    static {
        RST_0 = new RString("0");
        RST_1 = new RString("1");
        RST_2 = new RString("2");
        INT_10 = KaikuNumberEdit.固定数_10.getKey();
        出力条件_処理種別 = new RString("【処理種別】");
        出力条件_抄本 = new RString("【抄本】 ");
        出力条件_住民投票名 = new RString("【住民投票名】");
        出力条件_投票日 = new RString("【投票日】 ");
        出力条件_投票開始日 = new RString("【投票開始日】 ");
        出力条件_住民種別 = new RString("【住民種別】 ");
        出力条件_住民状態 = new RString("【住民状態】 ");
        出力条件_転出日 = new RString("【転出日】 ");
        出力条件_転入日 = new RString("【転入日】 ");
        出力条件_抽出対象者に公民権停止者の人 = new RString("【抽出対象者に公民権停止者の人】");

        出力条件_年齢計算基準日 = new RString("【年齢計算基準日】 ");
        出力条件_何歳以上 = new RString("【何歳以上】 ");
        出力条件_基準日翌日の誕生日の人 = new RString("【基準日＋1日の誕生日の人】");
        出力条件_住定期間 = new RString("【住定期間】 ");
        出力条件_期間中連続で居住 = new RString("【期間中連続で居住】 ");
        出力条件_住所条件 = new RString("【住所条件】 ");
        出力条件_住所条件選択リスト = new RString("【住所条件選択リスト】 ");
        出力条件_住民投票資格者名簿抄本 = new RString("【住民投票資格者名簿抄本】");

        出力内容_連絡符号１ = new RString("、");
        出力内容_連絡符号２ = new RString("～");

        CSV出力有無_有り = new RString("有り");
        出力内容_出力 = new RString("出力");
        出力内容_出力しない = new RString("出力しない");
        出力内容_含む = new RString("含む");
        出力内容_含まない = new RString("含まない");
        出力内容_年以上 = new RString("年以上");
        出力内容_以降 = new RString(" 以降");
        出力内容_以前 = new RString(" 以前");
        住民状態_住民 = new RString("住民");
        住民状態_転出者 = new RString("転出者");
        住民状態_転入者 = new RString("転入者");
        住民種別_日本人 = new RString("日本人");
        住民種別_外国人 = new RString("外国人");
    }

}
