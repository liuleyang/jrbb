/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import jp.co.ndensan.reams.af.afa.testhelper.AfaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link AFACodeShubetsu}のテストクラスです。
 *
 * @author n1823 有澤 礼恵
 */
@RunWith(Enclosed.class)
public class AFACodeShubetsuTest {

    public static class getCodeShubetsuTest extends AfaTestBase {

        @Test
        public void 宛名編集区分_選挙人宛名シールの場合_getCodeShubetsuは1010を返す() {
            assertThat(AFACodeShubetsu.宛名編集区分_選挙人宛名シール.getCodeShubetsu(), is(new CodeShubetsu("1010")));
        }

        @Test
        public void 宛名編集区分_施設宛名シールの場合_getCodeShubetsuは1011を返す() {
            assertThat(AFACodeShubetsu.宛名編集区分_施設宛名シール.getCodeShubetsu(), is(new CodeShubetsu("1011")));
        }

        @Test
        public void 永久選挙人名簿異動条件指定の場合_getCodeShubetsuは1610を返す() {
            assertThat(AFACodeShubetsu.永久選挙人名簿異動条件指定.getCodeShubetsu(), is(new CodeShubetsu("1610")));
        }

        @Test
        public void 却下事由コードの場合_getCodeShubetsuは2210を返す() {
            assertThat(AFACodeShubetsu.却下事由コード.getCodeShubetsu(), is(new CodeShubetsu("2210")));
        }

        @Test
        public void 漁業種類の場合_getCodeShubetsuは2220を返す() {
            assertThat(AFACodeShubetsu.漁業種類.getCodeShubetsu(), is(new CodeShubetsu("2220")));
        }

        @Test
        public void 漁船種別の場合_getCodeShubetsuは2230を返す() {
            assertThat(AFACodeShubetsu.漁船種別.getCodeShubetsu(), is(new CodeShubetsu("2230")));
        }

        @Test
        public void 居住区分の場合_getCodeShubetsuは2240を返す() {
            assertThat(AFACodeShubetsu.居住区分.getCodeShubetsu(), is(new CodeShubetsu("2240")));
        }

        @Test
        public void 拒否事由コードの場合_getCodeShubetsuは2250を返す() {
            assertThat(AFACodeShubetsu.拒否事由コード.getCodeShubetsu(), is(new CodeShubetsu("2250")));
        }

        @Test
        public void 期日前不在者区分の場合_getCodeShubetsuは2260を返す() {
            assertThat(AFACodeShubetsu.期日前不在者区分.getCodeShubetsu(), is(new CodeShubetsu("2260")));
        }

        @Test
        public void 交付_受理方法の場合_getCodeShubetsuは2810を返す() {
            assertThat(AFACodeShubetsu.交付_受理方法.getCodeShubetsu(), is(new CodeShubetsu("2810")));
        }

        @Test
        public void 交付組織コードの場合_getCodeShubetsuは2820を返す() {
            assertThat(AFACodeShubetsu.交付組織コード.getCodeShubetsu(), is(new CodeShubetsu("2820")));
        }

        @Test
        public void 国民投票区分の場合_getCodeShubetsuは2830を返す() {
            assertThat(AFACodeShubetsu.国民投票区分.getCodeShubetsu(), is(new CodeShubetsu("2830")));
        }

        @Test
        public void 再交付事由コードの場合_getCodeShubetsuは3010を返す() {
            assertThat(AFACodeShubetsu.再交付事由コード.getCodeShubetsu(), is(new CodeShubetsu("3010")));
        }

        @Test
        public void 裁判員審査員区分の場合_getCodeShubetsuは3020を返す() {
            assertThat(AFACodeShubetsu.裁判員審査員区分.getCodeShubetsu(), is(new CodeShubetsu("3020")));
        }

        @Test
        public void 施設種別の場合_getCodeShubetsuは3210を返す() {
            assertThat(AFACodeShubetsu.施設種別.getCodeShubetsu(), is(new CodeShubetsu("3210")));
        }

        @Test
        public void 修正区分の場合_getCodeShubetsuは3220を返す() {
            assertThat(AFACodeShubetsu.修正区分.getCodeShubetsu(), is(new CodeShubetsu("3220")));
        }

        @Test
        public void 住所種類区分の場合_getCodeShubetsuは3230を返す() {
            assertThat(AFACodeShubetsu.住所種類区分.getCodeShubetsu(), is(new CodeShubetsu("3230")));
        }

        @Test
        public void 申請区分の場合_getCodeShubetsuは3240を返す() {
            assertThat(AFACodeShubetsu.申請区分.getCodeShubetsu(), is(new CodeShubetsu("3240")));
        }

        @Test
        public void 申請取下事由コードの場合_getCodeShubetsuは3250を返す() {
            assertThat(AFACodeShubetsu.申請取下事由コード.getCodeShubetsu(), is(new CodeShubetsu("3250")));
        }

        @Test
        public void 申請内容変更事由コードの場合_getCodeShubetsuは3260を返す() {
            assertThat(AFACodeShubetsu.申請内容変更事由コード.getCodeShubetsu(), is(new CodeShubetsu("3260")));
        }

        @Test
        public void 審査区分の場合_getCodeShubetsuは3270を返す() {
            assertThat(AFACodeShubetsu.審査区分.getCodeShubetsu(), is(new CodeShubetsu("3270")));
        }

        @Test
        public void 失権区分の場合_getCodeShubetsuは3280を返す() {
            assertThat(AFACodeShubetsu.失権区分.getCodeShubetsu(), is(new CodeShubetsu("3280")));
        }

        @Test
        public void 状態区分の場合_getCodeShubetsuは3290を返す() {
            assertThat(AFACodeShubetsu.状態区分.getCodeShubetsu(), is(new CodeShubetsu("3290")));
        }

        @Test
        public void 住所編集区分_宛名シールの場合_getCodeShubetsuは3300を返す() {
            assertThat(AFACodeShubetsu.住所編集区分_宛名シール.getCodeShubetsu(), is(new CodeShubetsu("3300")));
        }

        @Test
        public void 請求方法の場合_getCodeShubetsuは3610を返す() {
            assertThat(AFACodeShubetsu.請求方法.getCodeShubetsu(), is(new CodeShubetsu("3610")));
        }

        @Test
        public void 選挙種類の場合_getCodeShubetsuは3620を返す() {
            assertThat(AFACodeShubetsu.選挙種類.getCodeShubetsu(), is(new CodeShubetsu("3620")));
        }

        @Test
        public void 選挙資格種類の場合_getCodeShubetsuは3621を返す() {
            assertThat(AFACodeShubetsu.選挙資格種類.getCodeShubetsu(), is(new CodeShubetsu("3621")));
        }

        @Test
        public void 選挙レベルの場合_getCodeShubetsuは3630を返す() {
            assertThat(AFACodeShubetsu.選挙レベル.getCodeShubetsu(), is(new CodeShubetsu("3630")));
        }

        @Test
        public void 選挙資格区分の場合_getCodeShubetsuは3640を返す() {
            assertThat(AFACodeShubetsu.選挙資格区分.getCodeShubetsu(), is(new CodeShubetsu("3640")));
        }

        @Test
        public void 選挙資格区分_国民の場合_getCodeShubetsuは3641を返す() {
            assertThat(AFACodeShubetsu.選挙資格区分_国民.getCodeShubetsu(), is(new CodeShubetsu("3641")));
        }

        @Test
        public void 代理記載者入力区分の場合_getCodeShubetsuは4010を返す() {
            assertThat(AFACodeShubetsu.代理記載者入力区分.getCodeShubetsu(), is(new CodeShubetsu("4010")));
        }

        @Test
        public void 転出表示区分の場合_getCodeShubetsuは4610を返す() {
            assertThat(AFACodeShubetsu.転出表示区分.getCodeShubetsu(), is(new CodeShubetsu("4610")));
        }

        @Test
        public void 投票資格種類の場合_getCodeShubetsuは4810を返す() {
            assertThat(AFACodeShubetsu.投票資格種類.getCodeShubetsu(), is(new CodeShubetsu("4810")));
        }

        @Test
        public void 投票状況の場合_getCodeShubetsuは4820を返す() {
            assertThat(AFACodeShubetsu.投票状況.getCodeShubetsu(), is(new CodeShubetsu("4820")));
        }

        @Test
        public void 投票事由コードの場合_getCodeShubetsuは4830を返す() {
            assertThat(AFACodeShubetsu.投票事由コード.getCodeShubetsu(), is(new CodeShubetsu("4830")));
        }

        @Test
        public void 投票事由コード_国民の場合_getCodeShubetsuは4831を返す() {
            assertThat(AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), is(new CodeShubetsu("4831")));
        }

        @Test
        public void 投票録項目種類の場合_getCodeShubetsuは4840を返す() {
            assertThat(AFACodeShubetsu.投票録項目種類.getCodeShubetsu(), is(new CodeShubetsu("4840")));
        }

        @Test
        public void 登録事由コードの場合_getCodeShubetsuは4850を返す() {
            assertThat(AFACodeShubetsu.登録事由コード.getCodeShubetsu(), is(new CodeShubetsu("4850")));
        }

        @Test
        public void 登録事由コード_国民の場合_getCodeShubetsuは4851を返す() {
            assertThat(AFACodeShubetsu.登録事由コード_国民.getCodeShubetsu(), is(new CodeShubetsu("4851")));
        }

        @Test
        public void 登録停止事由コードの場合_getCodeShubetsuは4860を返す() {
            assertThat(AFACodeShubetsu.登録停止事由コード.getCodeShubetsu(), is(new CodeShubetsu("4860")));
        }

        @Test
        public void 日本人外国人区分の場合_getCodeShubetsuは5010を返す() {
            assertThat(AFACodeShubetsu.日本人外国人区分.getCodeShubetsu(), is(new CodeShubetsu("5010")));
        }

        @Test
        public void 表示事由コードの場合_getCodeShubetsuは6210を返す() {
            assertThat(AFACodeShubetsu.表示事由コード.getCodeShubetsu(), is(new CodeShubetsu("6210")));
        }

        @Test
        public void 表示事由コード_国民の場合_getCodeShubetsuは6211を返す() {
            assertThat(AFACodeShubetsu.表示事由コード_国民.getCodeShubetsu(), is(new CodeShubetsu("6211")));
        }

        @Test
        public void 表示事由コード_在外の場合_getCodeShubetsuは6212を返す() {
            assertThat(AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), is(new CodeShubetsu("6212")));
        }

        @Test
        public void 本籍地登録区分の場合_getCodeShubetsuは6810を返す() {
            assertThat(AFACodeShubetsu.本籍地登録区分.getCodeShubetsu(), is(new CodeShubetsu("6810")));
        }

        @Test
        public void 抹消事由コードの場合_getCodeShubetsuは7010を返す() {
            assertThat(AFACodeShubetsu.抹消事由コード.getCodeShubetsu(), is(new CodeShubetsu("7010")));
        }

        @Test
        public void 抹消事由コード_国民の場合_getCodeShubetsuは7011を返す() {
            assertThat(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), is(new CodeShubetsu("7011")));
        }

        @Test
        public void 抹消事由コード_在外の場合_getCodeShubetsuは7012を返す() {
            assertThat(AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), is(new CodeShubetsu("7012")));
        }

        @Test
        public void 抹消事由コード_不在投票資格の場合_getCodeShubetsuは7013を返す() {
            assertThat(AFACodeShubetsu.抹消事由コード_不在投票資格.getCodeShubetsu(), is(new CodeShubetsu("7013")));
        }

        @Test
        public void 無効事由コードの場合_getCodeShubetsuは7410を返す() {
            assertThat(AFACodeShubetsu.無効事由コード.getCodeShubetsu(), is(new CodeShubetsu("7410")));
        }

        @Test
        public void 四隅項目_選挙人用の場合_getCodeShubetsuは8810を返す() {
            assertThat(AFACodeShubetsu.四隅項目_選挙人用.getCodeShubetsu(), is(new CodeShubetsu("8810")));
        }

        @Test
        public void 四隅項目_転出者用の場合_getCodeShubetsuは8811を返す() {
            assertThat(AFACodeShubetsu.四隅項目_転出者用.getCodeShubetsu(), is(new CodeShubetsu("8811")));
        }

        @Test
        public void 四隅項目_施設用の場合_getCodeShubetsuは8812を返す() {
            assertThat(AFACodeShubetsu.四隅項目_施設用.getCodeShubetsu(), is(new CodeShubetsu("8812")));
        }

        @Test
        public void 固定文_二重登録調査票_照会の場合_getCodeShubetsuは0010を返す() {
            assertThat(AFACodeShubetsu.固定文_二重登録調査票_照会.getCodeShubetsu(), is(new CodeShubetsu("0010")));
        }

        @Test
        public void 固定文_二重登録調査票_回答の場合_getCodeShubetsuは0011を返す() {
            assertThat(AFACodeShubetsu.固定文_二重登録調査票_回答.getCodeShubetsu(), is(new CodeShubetsu("0011")));
        }

        @Test
        public void 固定文_1号登録通知の場合_getCodeShubetsuは0020を返す() {
            assertThat(AFACodeShubetsu.固定文_1号登録通知.getCodeShubetsu(), is(new CodeShubetsu("0020")));
        }

        @Test
        public void 固定文_2号資格調査票_照会の場合_getCodeShubetsuは0021を返す() {
            assertThat(AFACodeShubetsu.固定文_2号資格調査票_照会.getCodeShubetsu(), is(new CodeShubetsu("0021")));
        }

        @Test
        public void 固定文_2号資格調査票_回答の場合_getCodeShubetsuは0022を返す() {
            assertThat(AFACodeShubetsu.固定文_2号資格調査票_回答.getCodeShubetsu(), is(new CodeShubetsu("0022")));
        }

        @Test
        public void 固定文_国内転入者調査票_照会の場合_getCodeShubetsuは0023を返す() {
            assertThat(AFACodeShubetsu.固定文_国内転入者調査票_照会.getCodeShubetsu(), is(new CodeShubetsu("0023")));
        }

        @Test
        public void 固定文_国内転入者調査票_回答の場合_getCodeShubetsuは0024を返す() {
            assertThat(AFACodeShubetsu.固定文_国内転入者調査票_回答.getCodeShubetsu(), is(new CodeShubetsu("0024")));
        }

        @Test
        public void 固定文_国外転入者調査票_照会の場合_getCodeShubetsuは0025を返す() {
            assertThat(AFACodeShubetsu.固定文_国外転入者調査票_照会.getCodeShubetsu(), is(new CodeShubetsu("0025")));
        }

        @Test
        public void 固定文_国外転入者調査票_回答の場合_getCodeShubetsuは0026を返す() {
            assertThat(AFACodeShubetsu.固定文_国外転入者調査票_回答.getCodeShubetsu(), is(new CodeShubetsu("0026")));
        }

        @Test
        public void 固定文_登録した旨の通知の場合_getCodeShubetsuは0030を返す() {
            assertThat(AFACodeShubetsu.固定文_登録した旨の通知.getCodeShubetsu(), is(new CodeShubetsu("0030")));
        }

        @Test
        public void 固定文_登録を行わなかった旨の通知_本人の場合_getCodeShubetsuは0031を返す() {
            assertThat(AFACodeShubetsu.固定文_登録を行わなかった旨の通知_本人.getCodeShubetsu(), is(new CodeShubetsu("0031")));
        }

        @Test
        public void 固定文_登録を行わなかった旨の通知_領事官の場合_getCodeShubetsuは0032を返す() {
            assertThat(AFACodeShubetsu.固定文_登録を行わなかった旨の通知_領事官.getCodeShubetsu(), is(new CodeShubetsu("0032")));
        }

        @Test
        public void 固定文_記載事項変更通知_本人の場合_getCodeShubetsuは0033を返す() {
            assertThat(AFACodeShubetsu.固定文_記載事項変更通知_本人.getCodeShubetsu(), is(new CodeShubetsu("0033")));
        }

        @Test
        public void 固定文_記載事項変更通知_領事官の場合_getCodeShubetsuは0034を返す() {
            assertThat(AFACodeShubetsu.固定文_記載事項変更通知_領事官.getCodeShubetsu(), is(new CodeShubetsu("0034")));
        }

        @Test
        public void 固定文_再交付通知の場合_getCodeShubetsuは0035を返す() {
            assertThat(AFACodeShubetsu.固定文_再交付通知.getCodeShubetsu(), is(new CodeShubetsu("0035")));
        }

        @Test
        public void 固定文_抹消通知_本籍地の場合_getCodeShubetsuは0036を返す() {
            assertThat(AFACodeShubetsu.固定文_抹消通知_本籍地.getCodeShubetsu(), is(new CodeShubetsu("0036")));
        }

        @Test
        public void 固定文_抹消通知_領事官の場合_getCodeShubetsuは0037を返す() {
            assertThat(AFACodeShubetsu.固定文_抹消通知_領事官.getCodeShubetsu(), is(new CodeShubetsu("0037")));
        }

        @Test
        public void 連絡先_在外帳票の選挙管理委員会の場合_getCodeShubetsuは0038を返す() {
            assertThat(AFACodeShubetsu.連絡先_在外帳票の選挙管理委員会.getCodeShubetsu(), is(new CodeShubetsu("0038")));
        }
    }

    public static class getSubGyomuCodeTest extends AfaTestBase {

        @Test
        public void getSubGyomuCodeはAFA選挙を返す() {
            assertThat(AFACodeShubetsu.永久選挙人名簿異動条件指定.getSubGyomuCode(), is(SubGyomuCode.AFA選挙本体));
        }
    }

    public static class getReturnTypeTest extends AfaTestBase {

        @Test
        public void 宛名編集区分_選挙人宛名シールの場合_getReturnTypeはAtenaHenshuSealを返す() {
            assertThat(AFACodeShubetsu.宛名編集区分_選挙人宛名シール.getReturnType().getName(), is(AtenaHenshuSeal.class.getName()));
        }

        @Test
        public void 宛名編集区分_施設宛名シールの場合_getReturnTypeはAtenaHenshuSealShisetsuを返す() {
            assertThat(AFACodeShubetsu.宛名編集区分_施設宛名シール.getReturnType().getName(), is(AtenaHenshuSealShisetsu.class.getName()));
        }

        @Test
        public void 永久選挙人名簿異動条件指定の場合_getReturnTypeはMeiboIdoJokenを返す() {
            assertThat(AFACodeShubetsu.永久選挙人名簿異動条件指定.getReturnType().getName(), is(MeiboIdoJoken.class.getName()));
        }

        @Test
        public void 却下事由コードの場合_getReturnTypeはKyakkaJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.却下事由コード.getReturnType().getName(), is(KyakkaJiyuCode.class.getName()));
        }

        @Test
        public void 漁業種類の場合_getReturnTypeはGyogyoShuruiを返す() {
            assertThat(AFACodeShubetsu.漁業種類.getReturnType().getName(), is(GyogyoShurui.class.getName()));
        }

        @Test
        public void 漁船種別の場合_getReturnTypeはGyosenShubetsuを返す() {
            assertThat(AFACodeShubetsu.漁船種別.getReturnType().getName(), is(GyosenShubetsu.class.getName()));
        }

        @Test
        public void 居住区分の場合_getReturnTypeはKyojuKubunを返す() {
            assertThat(AFACodeShubetsu.居住区分.getReturnType().getName(), is(KyojuKubun.class.getName()));
        }

        @Test
        public void 拒否事由コードの場合_getReturnTypeはKyohiJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.拒否事由コード.getReturnType().getName(), is(KyohiJiyuCode.class.getName()));
        }

        @Test
        public void 期日前不在者区分の場合_getReturnTypeはKijitsumaeFuzaishaKubunを返す() {
            assertThat(AFACodeShubetsu.期日前不在者区分.getReturnType().getName(), is(KijitsumaeFuzaishaKubun.class.getName()));
        }

        @Test
        public void 交付_受理方法の場合_getReturnTypeはKofuJuriHohoを返す() {
            assertThat(AFACodeShubetsu.交付_受理方法.getReturnType().getName(), is(KofuJuriHoho.class.getName()));
        }

        @Test
        public void 交付組織コードの場合_getReturnTypeはKofuSoshikiCodeを返す() {
            assertThat(AFACodeShubetsu.交付組織コード.getReturnType().getName(), is(KofuSoshikiCode.class.getName()));
        }

        @Test
        public void 国民投票区分の場合_getReturnTypeはKokuminTohyoKubunを返す() {
            assertThat(AFACodeShubetsu.国民投票区分.getReturnType().getName(), is(KokuminTohyoKubun.class.getName()));
        }

        @Test
        public void 再交付事由コードの場合_getReturnTypeはSaiKofuJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.再交付事由コード.getReturnType().getName(), is(SaiKofuJiyuCode.class.getName()));
        }

        @Test
        public void 裁判員審査員区分の場合_getReturnTypeはSaibaninShisainKubunを返す() {
            assertThat(AFACodeShubetsu.裁判員審査員区分.getReturnType().getName(), is(SaibaninShinsainKubun.class.getName()));
        }

        @Test
        public void 施設種別の場合_getReturnTypeはShisetsuShubetsuを返す() {
            assertThat(AFACodeShubetsu.施設種別.getReturnType().getName(), is(ShisetsuShubetsu.class.getName()));
        }

        @Test
        public void 修正区分の場合_getReturnTypeはShuseiKubunを返す() {
            assertThat(AFACodeShubetsu.修正区分.getReturnType().getName(), is(ShuseiKubun.class.getName()));
        }

        @Test
        public void 住所種類区分の場合_getReturnTypeはJushoShuruiKubunを返す() {
            assertThat(AFACodeShubetsu.住所種類区分.getReturnType().getName(), is(JushoShuruiKubun.class.getName()));
        }

        @Test
        public void 申請区分の場合_getReturnTypeはShinseiKubunを返す() {
            assertThat(AFACodeShubetsu.申請区分.getReturnType().getName(), is(ShinseiKubun.class.getName()));
        }

        @Test
        public void 申請取下事由コードの場合_getReturnTypeはShinseiTorisageJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.申請取下事由コード.getReturnType().getName(), is(ShinseiTorisageJiyuCode.class.getName()));
        }

        @Test
        public void 申請内容変更事由コードの場合_getReturnTypeはShinseiNaiyoHenkoJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.申請内容変更事由コード.getReturnType().getName(), is(ShinseiNaiyoHenkoJiyuCode.class.getName()));
        }

        @Test
        public void 審査区分の場合_getReturnTypeはShinsaKubunを返す() {
            assertThat(AFACodeShubetsu.審査区分.getReturnType().getName(), is(ShinsaKubun.class.getName()));
        }

        @Test
        public void 失権区分の場合_getReturnTypeはShikkenKubunを返す() {
            assertThat(AFACodeShubetsu.失権区分.getReturnType().getName(), is(ShikkenKubun.class.getName()));
        }

        @Test
        public void 状態区分の場合_getReturnTypeはJotaiKubunを返す() {
            assertThat(AFACodeShubetsu.状態区分.getReturnType().getName(), is(JotaiKubun.class.getName()));
        }

        @Test
        public void 住所編集区分_宛名シールの場合_getReturnTypeはJushoHenshuAtenaSealを返す() {
            assertThat(AFACodeShubetsu.住所編集区分_宛名シール.getReturnType().getName(), is(JushoHenshuAtenaSeal.class.getName()));
        }

        @Test
        public void 請求方法の場合_getReturnTypeはSeikyuHohoを返す() {
            assertThat(AFACodeShubetsu.請求方法.getReturnType().getName(), is(SeikyuHoho.class.getName()));
        }

        @Test
        public void 選挙種類の場合_getReturnTypeはSenkyoShuruiを返す() {
            assertThat(AFACodeShubetsu.選挙種類.getReturnType().getName(), is(SenkyoShurui.class.getName()));
        }

        @Test
        public void 選挙資格種類の場合_getReturnTypeはSenkyoShikakuShuruiを返す() {
            assertThat(AFACodeShubetsu.選挙資格種類.getReturnType().getName(), is(SenkyoShikakuShurui.class.getName()));
        }

        @Test
        public void 選挙レベルの場合_getReturnTypeはSenkyoLevelを返す() {
            assertThat(AFACodeShubetsu.選挙レベル.getReturnType().getName(), is(SenkyoLevel.class.getName()));
        }

        @Test
        public void 選挙資格区分の場合_getReturnTypeはSsnkyoShikakuKubunを返す() {
            assertThat(AFACodeShubetsu.選挙資格区分.getReturnType().getName(), is(SsnkyoShikakuKubun.class.getName()));
        }

        @Test
        public void 選挙資格区分_国民の場合_getReturnTypeはSenkyoShikakuKubunKokuminを返す() {
            assertThat(AFACodeShubetsu.選挙資格区分_国民.getReturnType().getName(), is(SenkyoShikakuKubunKokumin.class.getName()));
        }

        @Test
        public void 代理記載者入力区分の場合_getReturnTypeはDairiKisaishaNyuryokuKubunを返す() {
            assertThat(AFACodeShubetsu.代理記載者入力区分.getReturnType().getName(), is(DairiKisaishaNyuryokuKubun.class.getName()));
        }

        @Test
        public void 転出表示区分の場合_getReturnTypeはTenshutsuHyojiKubunを返す() {
            assertThat(AFACodeShubetsu.転出表示区分.getReturnType().getName(), is(TenshutsuHyojiKubun.class.getName()));
        }

        @Test
        public void 投票資格種類の場合_getReturnTypeはTohyoShikakuShuruiを返す() {
            assertThat(AFACodeShubetsu.投票資格種類.getReturnType().getName(), is(TohyoShikakuShurui.class.getName()));
        }

        @Test
        public void 投票状況の場合_getReturnTypeはTohyoJokyoを返す() {
            assertThat(AFACodeShubetsu.投票状況.getReturnType().getName(), is(TohyoJokyo.class.getName()));
        }

        @Test
        public void 投票事由コードの場合_getReturnTypeはTohyoJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.投票事由コード.getReturnType().getName(), is(TohyoJiyuCode.class.getName()));
        }

        @Test
        public void 投票事由コード_国民の場合_getReturnTypeはTohyoJiyuCodeKokuminを返す() {
            assertThat(AFACodeShubetsu.投票事由コード_国民.getReturnType().getName(), is(TohyoJiyuCodeKokumin.class.getName()));
        }

        @Test
        public void 投票録項目種類の場合_getReturnTypeはTohyorokuKomokuShuruiを返す() {
            assertThat(AFACodeShubetsu.投票録項目種類.getReturnType().getName(), is(TohyorokuKomokuShurui.class.getName()));
        }

        @Test
        public void 登録事由コードの場合_getReturnTypeはTorokuJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.登録事由コード.getReturnType().getName(), is(TorokuJiyuCode.class.getName()));
        }

        @Test
        public void 登録事由コード_国民の場合_getReturnTypeはTorokuJiyuCodeKokuminを返す() {
            assertThat(AFACodeShubetsu.登録事由コード_国民.getReturnType().getName(), is(TorokuJiyuCodeKokumin.class.getName()));
        }

        @Test
        public void 登録停止事由コードの場合_getReturnTypeはTorokuTeisiJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.登録停止事由コード.getReturnType().getName(), is(TorokuTeisiJiyuCode.class.getName()));
        }

        @Test
        public void 日本人外国人区分の場合_getReturnTypeはNihonGiakokuKubunを返す() {
            assertThat(AFACodeShubetsu.日本人外国人区分.getReturnType().getName(), is(NihonGiakokuKubun.class.getName()));
        }

        @Test
        public void 表示事由コードの場合_getReturnTypeはHyojiJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.表示事由コード.getReturnType().getName(), is(HyojiJiyuCode.class.getName()));
        }

        @Test
        public void 表示事由コード_国民の場合_getReturnTypeはHyojiJiyuCodeKokuminを返す() {
            assertThat(AFACodeShubetsu.表示事由コード_国民.getReturnType().getName(), is(HyojiJiyuCodeKokumin.class.getName()));
        }

        @Test
        public void 表示事由コード_在外の場合_getReturnTypeはHyojiJiyuCodeZaigaiを返す() {
            assertThat(AFACodeShubetsu.表示事由コード_在外.getReturnType().getName(), is(HyojiJiyuCodeZaigai.class.getName()));
        }

        @Test
        public void 本籍地登録区分の場合_getReturnTypeはHonsekitiTorokuKubunを返す() {
            assertThat(AFACodeShubetsu.本籍地登録区分.getReturnType().getName(), is(HonsekitiTorokuKubun.class.getName()));
        }

        @Test
        public void 抹消事由コードの場合_getReturnTypeはMasshoJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.抹消事由コード.getReturnType().getName(), is(MasshoJiyuCode.class.getName()));
        }

        @Test
        public void 抹消事由コード_国民の場合_getReturnTypeはMasshoJiyuCodeKokuminを返す() {
            assertThat(AFACodeShubetsu.抹消事由コード_国民.getReturnType().getName(), is(MasshoJiyuCodeKokumin.class.getName()));
        }

        @Test
        public void 抹消事由コード_在外の場合_getReturnTypeはMasshoJiyuCodeZaigaiを返す() {
            assertThat(AFACodeShubetsu.抹消事由コード_在外.getReturnType().getName(), is(MasshoJiyuCodeZaigai.class.getName()));
        }

        @Test
        public void 抹消事由コード_不在投票資格の場合_getReturnTypeはMasshoJiyuCodeShikakuを返す() {
            assertThat(AFACodeShubetsu.抹消事由コード_不在投票資格.getReturnType().getName(), is(MasshoJiyuCodeShikaku.class.getName()));
        }

        @Test
        public void 無効事由コードの場合_getReturnTypeはMukoJiyuCodeを返す() {
            assertThat(AFACodeShubetsu.無効事由コード.getReturnType().getName(), is(MukoJiyuCode.class.getName()));
        }

        @Test
        public void 四隅項目_選挙人用の場合_getReturnTypeはYosumiKomokuSenkyoninを返す() {
            assertThat(AFACodeShubetsu.四隅項目_選挙人用.getReturnType().getName(), is(YosumiKomokuSenkyonin.class.getName()));
        }

        @Test
        public void 四隅項目_転出者用の場合_getReturnTypeはYosumiKomokuTenshutsuを返す() {
            assertThat(AFACodeShubetsu.四隅項目_転出者用.getReturnType().getName(), is(YosumiKomokuTenshutsu.class.getName()));
        }

        @Test
        public void 四隅項目_施設用の場合_getReturnTypeはYosumiKomokuShisetsuを返す() {
            assertThat(AFACodeShubetsu.四隅項目_施設用.getReturnType().getName(), is(YosumiKomokuShisetsu.class.getName()));
        }

        @Test
        public void 固定文_二重登録調査票_照会の場合_getReturnTypeはKoteibunNijuTorokuShokaiを返す() {
            assertThat(AFACodeShubetsu.固定文_二重登録調査票_照会.getReturnType().getName(), is(KoteibunNijuTorokuShokai.class.getName()));
        }

        @Test
        public void 固定文_二重登録調査票_回答の場合_getReturnTypeはKoteibunNijuTorokuKaitoを返す() {
            assertThat(AFACodeShubetsu.固定文_二重登録調査票_回答.getReturnType().getName(), is(KoteibunNijuTorokuKaito.class.getName()));
        }

        @Test
        public void 固定文_1号登録通知の場合_getReturnTypeはKoteibun1goTorokuTsuchiを返す() {
            assertThat(AFACodeShubetsu.固定文_1号登録通知.getReturnType().getName(), is(Koteibun1goTorokuTsuchi.class.getName()));
        }

        @Test
        public void 固定文_2号資格調査票_照会の場合_getReturnTypeはKoteibun2goShikakuShokaiを返す() {
            assertThat(AFACodeShubetsu.固定文_2号資格調査票_照会.getReturnType().getName(), is(Koteibun2goShikakuShokai.class.getName()));
        }

        @Test
        public void 固定文_2号資格調査票_回答の場合_getReturnTypeはKoteibun2goShikakuKaitoを返す() {
            assertThat(AFACodeShubetsu.固定文_2号資格調査票_回答.getReturnType().getName(), is(Koteibun2goShikakuKaito.class.getName()));
        }

        @Test
        public void 固定文_国内転入者調査票_照会の場合_getReturnTypeはKoteibunKokunaiTennyuChosaShokaiを返す() {
            assertThat(AFACodeShubetsu.固定文_国内転入者調査票_照会.getReturnType().getName(), is(KoteibunKokunaiTennyuChosaShokai.class.getName()));
        }

        @Test
        public void 固定文_国内転入者調査票_回答の場合_getReturnTypeはKoteibunKokunaiTennyuChosaKaitoを返す() {
            assertThat(AFACodeShubetsu.固定文_国内転入者調査票_回答.getReturnType().getName(), is(KoteibunKokunaiTennyuChosaKaito.class.getName()));
        }

        @Test
        public void 固定文_国外転入者調査票_照会の場合_getReturnTypeはKoteibunKokugaiTennyuChosaShokaiを返す() {
            assertThat(AFACodeShubetsu.固定文_国外転入者調査票_照会.getReturnType().getName(), is(KoteibunKokugaiTennyuChosaShokai.class.getName()));
        }

        @Test
        public void 固定文_国外転入者調査票_回答の場合_getReturnTypeはKoteibunKokugaiTennyuChosaKaitoを返す() {
            assertThat(AFACodeShubetsu.固定文_国外転入者調査票_回答.getReturnType().getName(), is(KoteibunKokugaiTennyuChosaKaito.class.getName()));
        }

        @Test
        public void 固定文_登録した旨の通知の場合_getReturnTypeはKoteibunTorokuTsuchiを返す() {
            assertThat(AFACodeShubetsu.固定文_登録した旨の通知.getReturnType().getName(), is(KoteibunTorokuTsuchi.class.getName()));
        }

        @Test
        public void 固定文_登録を行わなかった旨の通知_本人の場合_getReturnTypeはKoteibunNotTorokuTsuchiHonninを返す() {
            assertThat(AFACodeShubetsu.固定文_登録を行わなかった旨の通知_本人.getReturnType().getName(), is(KoteibunNotTorokuTsuchiHonnin.class.getName()));
        }

        @Test
        public void 固定文_登録を行わなかった旨の通知_領事官の場合_getReturnTypeはKoteibunNotTorokuTsuchiRyojikanを返す() {
            assertThat(AFACodeShubetsu.固定文_登録を行わなかった旨の通知_領事官.getReturnType().getName(), is(KoteibunNotTorokuTsuchiRyojikan.class.getName()));
        }

        @Test
        public void 固定文_記載事項変更通知_本人の場合_getReturnTypeはKoteibunKisaiJikoTsuchiHonninを返す() {
            assertThat(AFACodeShubetsu.固定文_記載事項変更通知_本人.getReturnType().getName(), is(KoteibunKisaiJikoTsuchiHonnin.class.getName()));
        }

        @Test
        public void 固定文_記載事項変更通知_領事官の場合_getReturnTypeはKoteibunKisaiJikoTsuchiRyojikanを返す() {
            assertThat(AFACodeShubetsu.固定文_記載事項変更通知_領事官.getReturnType().getName(), is(KoteibunKisaiJikoTsuchiRyojikan.class.getName()));
        }

        @Test
        public void 固定文_再交付通知の場合_getReturnTypeはKoteibunSaikofuTsuchiを返す() {
            assertThat(AFACodeShubetsu.固定文_再交付通知.getReturnType().getName(), is(KoteibunSaikofuTsuchi.class.getName()));
        }

        @Test
        public void 固定文_抹消通知_本籍地の場合_getReturnTypeはKoteibunMasshoTsuchiHonsekiを返す() {
            assertThat(AFACodeShubetsu.固定文_抹消通知_本籍地.getReturnType().getName(), is(KoteibunMasshoTsuchiHonseki.class.getName()));
        }

        @Test
        public void 固定文_抹消通知_領事官の場合_getReturnTypeはKoteibunMasshoTsuchiRyojikanを返す() {
            assertThat(AFACodeShubetsu.固定文_抹消通知_領事官.getReturnType().getName(), is(KoteibunMasshoTsuchiRyojikan.class.getName()));
        }

        @Test
        public void 連絡先_在外帳票の選挙管理委員会の場合_getReturnTypeはRenrakusakiZaigaiSenkanを返す() {
            assertThat(AFACodeShubetsu.連絡先_在外帳票の選挙管理委員会.getReturnType().getName(), is(RenrakusakiZaigaiSenkan.class.getName()));
        }
    }
}
