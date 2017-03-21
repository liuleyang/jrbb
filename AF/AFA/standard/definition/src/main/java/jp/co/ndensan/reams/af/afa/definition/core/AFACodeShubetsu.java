/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.code.ICodeShubetsu;

/**
 * コード種別を表す列挙型です。
 *
 * @reamsid_L AF-0620-013 jihb
 */
public enum AFACodeShubetsu implements ICodeShubetsu {

    /**
     * 宛名編集区分_選挙人宛名シール
     */
    宛名編集区分_選挙人宛名シール("1010", AtenaHenshuSeal.class),
    /**
     * 宛名編集区分_施設宛名シール
     */
    宛名編集区分_施設宛名シール("1011", AtenaHenshuSealShisetsu.class),
    /**
     * 永久選挙人名簿異動条件指定
     */
    永久選挙人名簿異動条件指定("1610", MeiboIdoJoken.class),
    /**
     * 却下事由コード
     */
    却下事由コード("2210", KyakkaJiyuCode.class),
    /**
     * 漁業種類
     */
    漁業種類("2220", GyogyoShurui.class),
    /**
     * 漁船種別
     */
    漁船種別("2230", GyosenShubetsu.class),
    /**
     * 居住区分
     */
    居住区分("2240", KyojuKubun.class),
    /**
     * 拒否事由コード
     */
    拒否事由コード("2250", KyohiJiyuCode.class),
    /**
     * 期日前不在者区分
     */
    期日前不在者区分("2260", KijitsumaeFuzaishaKubun.class),
    /**
     * 敬称
     */
    敬称("2610", Keisho.class),
    /**
     * 交付_受理方法
     */
    交付_受理方法("2810", KofuJuriHoho.class),
    /**
     * 交付組織コード
     */
    交付組織コード("2820", KofuSoshikiCode.class),
    /**
     * 国民投票区分
     */
    国民投票区分("2830", KokuminTohyoKubun.class),
    /**
     * 再交付事由コード
     */
    再交付事由コード("3010", SaiKofuJiyuCode.class),
    /**
     * 裁判員審査員区分
     */
    裁判員審査員区分("3020", SaibaninShinsainKubun.class),
    /**
     * 施設種別
     */
    施設種別("3210", ShisetsuShubetsu.class),
    /**
     * 修正区分
     */
    修正区分("3220", ShuseiKubun.class),
    /**
     * 住所種類区分
     */
    住所種類区分("3230", JushoShuruiKubun.class),
    /**
     * 申請区分
     */
    申請区分("3240", ShinseiKubun.class),
    /**
     * 申請取下事由コード
     */
    申請取下事由コード("3250", ShinseiTorisageJiyuCode.class),
    /**
     * 申請内容変更事由コード
     */
    申請内容変更事由コード("3260", ShinseiNaiyoHenkoJiyuCode.class),
    /**
     * 審査区分
     */
    審査区分("3270", ShinsaKubun.class),
    /**
     * 失権区分
     */
    失権区分("3280", ShikkenKubun.class),
    /**
     * 状態区分
     */
    状態区分("3290", JotaiKubun.class),
    /**
     * 住所編集区分_宛名シール
     */
    住所編集区分_宛名シール("3300", JushoHenshuAtenaSeal.class),
    /**
     * 請求方法
     */
    請求方法("3610", SeikyuHoho.class),
    /**
     * 選挙種類
     */
    選挙種類("3620", SenkyoShurui.class),
    /**
     * 選挙資格種類
     */
    選挙資格種類("3621", SenkyoShikakuShurui.class),
    /**
     * 選挙レベル
     */
    選挙レベル("3630", SenkyoLevel.class),
    /**
     * 選挙資格区分
     */
    選挙資格区分("3640", SsnkyoShikakuKubun.class),
    /**
     * 選挙資格区分_国民
     */
    選挙資格区分_国民("3641", SenkyoShikakuKubunKokumin.class),
    /**
     * 代理記載者入力区分
     */
    代理記載者入力区分("4010", DairiKisaishaNyuryokuKubun.class),
    /**
     * 転出表示区分
     */
    転出表示区分("4610", TenshutsuHyojiKubun.class),
    /**
     * 転出表示区分
     */
    データ引継区分("4620", DataHikituKubun.class),
    /**
     * 投票資格種類
     */
    投票資格種類("4810", TohyoShikakuShurui.class),
    /**
     * 投票状況
     */
    投票状況("4820", TohyoJokyo.class),
    /**
     * 投票事由コード
     */
    投票事由コード("4830", TohyoJiyuCode.class),
    /**
     * 投票事由コード_国民
     */
    投票事由コード_国民("4831", TohyoJiyuCodeKokumin.class),
    /**
     * 投票録項目種類
     */
    投票録項目種類("4840", TohyorokuKomokuShurui.class),
    /**
     * 登録事由コード
     */
    登録事由コード("4850", TorokuJiyuCode.class),
    /**
     * 登録事由コード_国民
     */
    登録事由コード_国民("4851", TorokuJiyuCodeKokumin.class),
    /**
     * 登録停止事由コード
     */
    登録停止事由コード("4860", TorokuTeisiJiyuCode.class),
    /**
     * 日本人外国人区分
     */
    日本人外国人区分("5010", NihonGiakokuKubun.class),
    /**
     * 表示事由コード
     */
    表示事由コード("6210", HyojiJiyuCode.class),
    /**
     * 表示事由コード_国民
     */
    表示事由コード_国民("6211", HyojiJiyuCodeKokumin.class),
    /**
     * 表示事由コード_在外
     */
    表示事由コード_在外("6212", HyojiJiyuCodeZaigai.class),
    /**
     * 本籍地登録区分
     */
    本籍地登録区分("6810", HonsekitiTorokuKubun.class),
    /**
     * 抹消事由コード
     */
    抹消事由コード("7010", MasshoJiyuCode.class),
    /**
     * 抹消事由コード_国民
     */
    抹消事由コード_国民("7011", MasshoJiyuCodeKokumin.class),
    /**
     * 抹消事由コード_在外
     */
    抹消事由コード_在外("7012", MasshoJiyuCodeZaigai.class),
    /**
     * 抹消事由コード_不在投票資格
     */
    抹消事由コード_不在投票資格("7013", MasshoJiyuCodeShikaku.class),
    /**
     * 無効事由コード
     */
    無効事由コード("7410", MukoJiyuCode.class),
    /**
     * 四隅項目_選挙人用
     */
    四隅項目_選挙人用("8810", YosumiKomokuSenkyonin.class),
    /**
     * 四隅項目_転出者用
     */
    四隅項目_転出者用("8811", YosumiKomokuTenshutsu.class),
    /**
     * 四隅項目_施設用
     */
    四隅項目_施設用("8812", YosumiKomokuShisetsu.class),
    /**
     * 固定文_二重登録調査票_照会
     */
    固定文_二重登録調査票_照会("0010", KoteibunNijuTorokuShokai.class),
    /**
     * 固定文_二重登録調査票_回答
     */
    固定文_二重登録調査票_回答("0011", KoteibunNijuTorokuKaito.class),
    /**
     * 固定文_1号登録通知
     */
    固定文_1号登録通知("0020", Koteibun1goTorokuTsuchi.class),
    /**
     * 固定文_2号資格調査票_照会
     */
    固定文_2号資格調査票_照会("0021", Koteibun2goShikakuShokai.class),
    /**
     * 固定文_2号資格調査票_回答
     */
    固定文_2号資格調査票_回答("0022", Koteibun2goShikakuKaito.class),
    /**
     * 固定文_国内転入者調査票_照会
     */
    固定文_国内転入者調査票_照会("0023", KoteibunKokunaiTennyuChosaShokai.class),
    /**
     * 固定文_国内転入者調査票_回答
     */
    固定文_国内転入者調査票_回答("0024", KoteibunKokunaiTennyuChosaKaito.class),
    /**
     * 固定文_国外転入者調査票_照会
     */
    固定文_国外転入者調査票_照会("0025", KoteibunKokugaiTennyuChosaShokai.class),
    /**
     * 固定文_国外転入者調査票_回答
     */
    固定文_国外転入者調査票_回答("0026", KoteibunKokugaiTennyuChosaKaito.class),
    /**
     * 固定文_登録した旨の通知
     */
    固定文_登録した旨の通知("0030", KoteibunTorokuTsuchi.class),
    /**
     * 固定文_登録を行わなかった旨の通知_本人
     */
    固定文_登録を行わなかった旨の通知_本人("0031", KoteibunNotTorokuTsuchiHonnin.class),
    /**
     * 固定文_登録を行わなかった旨の通知_領事官
     */
    固定文_登録を行わなかった旨の通知_領事官("0032", KoteibunNotTorokuTsuchiRyojikan.class),
    /**
     * 固定文_記載事項変更通知_本人
     */
    固定文_記載事項変更通知_本人("0033", KoteibunKisaiJikoTsuchiHonnin.class),
    /**
     * 固定文_記載事項変更通知_領事官
     */
    固定文_記載事項変更通知_領事官("0034", KoteibunKisaiJikoTsuchiRyojikan.class),
    /**
     * 固定文_再交付通知
     */
    固定文_再交付通知("0035", KoteibunSaikofuTsuchi.class),
    /**
     * 固定文_抹消通知_本籍地
     */
    固定文_抹消通知_本籍地("0036", KoteibunMasshoTsuchiHonseki.class),
    /**
     * 固定文_抹消通知_領事官
     */
    固定文_抹消通知_領事官("0037", KoteibunMasshoTsuchiRyojikan.class),
    /**
     * 連絡先_在外帳票の選挙管理委員会
     */
    連絡先_在外帳票の選挙管理委員会("0038", RenrakusakiZaigaiSenkan.class);

    private final SubGyomuCode subGyomuCode = SubGyomuCode.AFA選挙本体;
    private final CodeShubetsu codeShubetsu;
    private final Class returnType;

    private AFACodeShubetsu(String codeShubetsu, Class returnType) {
        this.codeShubetsu = new CodeShubetsu(codeShubetsu);
        this.returnType = returnType;
    }

    @Override
    public CodeShubetsu getCodeShubetsu() {
        return codeShubetsu;
    }

    @Override
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    @Override
    public Class getReturnType() {
        return returnType;
    }
}
