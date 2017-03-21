/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 選挙一覧内容を格納するクラスです。
 *
 * @reamsid_L AF-0030-020 liss
 */
public class AFABTB101Senkyoichiran implements Serializable {

    private SenkyoNo senkyoNo;
    private Code senkyoLevel;
    private RString senkyoName;
    private RString senkyoRyakusho;
    private RString senkyoMark;
    private FlexibleDate kijunYMD;
    private FlexibleDate meiboTorokuYMD;
    private FlexibleDate kokujiYMD;
    private FlexibleDate tenshutsuKigenYMD;
    private FlexibleDate tennyuKigenYMD;
    private FlexibleDate tohyoUketsukeYMD;
    private Boolean mutohyoSenkyoFlag;

    /**
     * 選挙番号のgetメソッドです。
     * <br/>
     * <br/>複数選挙ある場合の連番
     *
     * @return 選挙番号
     */
    public SenkyoNo getSenkyoNo() {
        return senkyoNo;
    }

    /**
     * 選挙番号のsetメソッドです。
     * <br/>
     * <br/>複数選挙ある場合の連番
     *
     * @param senkyoNo 選挙番号
     */
    public void setSenkyoNo(SenkyoNo senkyoNo) {
        this.senkyoNo = senkyoNo;
    }

    /**
     * 選挙レベルのgetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @return 選挙レベル
     */
    public Code getSenkyoLevel() {
        return senkyoLevel;
    }

    /**
     * 選挙レベルのsetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @param senkyoLevel 選挙レベル
     */
    public void setSenkyoLevel(Code senkyoLevel) {
        this.senkyoLevel = senkyoLevel;
    }

    /**
     * 選挙レベルの名称のgetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @return 選挙レベルの名称
     */
    public RString getSenkyoLevelMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙レベル.getCodeShubetsu(), senkyoLevel);
    }

    /**
     * 選挙レベルの略称のgetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @return 選挙レベルの略称
     */
    public RString getSenkyoLevelRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙レベル.getCodeShubetsu(), senkyoLevel);
    }

    /**
     * 選挙レベルのDescriptionのgetメソッドです。
     * <br/>
     * <br/>選挙種類＝国政・地方選挙を、さらに詳細に分類
     *
     * @return 選挙レベルのDescription
     */
    public RString getSenkyoLevelDescription() {
        return CodeMaster.getOption1(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.選挙レベル.getCodeShubetsu(), senkyoLevel);
    }

    /**
     * 選挙名称のgetメソッドです。
     *
     * @return 選挙名称
     */
    public RString getSenkyoName() {
        return senkyoName;
    }

    /**
     * 選挙名称のsetメソッドです。
     *
     * @param senkyoName 選挙名称
     */
    public void setSenkyoName(RString senkyoName) {
        this.senkyoName = senkyoName;
    }

    /**
     * 選挙略称のgetメソッドです。
     *
     * @return 選挙略称
     */
    public RString getSenkyoRyakusho() {
        return senkyoRyakusho;
    }

    /**
     * 選挙略称のsetメソッドです。
     *
     * @param senkyoRyakusho 選挙略称
     */
    public void setSenkyoRyakusho(RString senkyoRyakusho) {
        this.senkyoRyakusho = senkyoRyakusho;
    }

    /**
     * 選挙マークのgetメソッドです。
     *
     * @return 選挙マーク
     */
    public RString getSenkyoMark() {
        return senkyoMark;
    }

    /**
     * 選挙マークのsetメソッドです。
     *
     * @param senkyoMark 選挙マーク
     */
    public void setSenkyoMark(RString senkyoMark) {
        this.senkyoMark = senkyoMark;
    }

    /**
     * 名簿基準年月日のgetメソッドです。
     * <br/>
     * <br/>定時登録：3、6、9、12月1日 選挙時：告示（公示）年月日の前日 農委：1月1日 海区：9月1日
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate getKijunYMD() {
        return kijunYMD;
    }

    /**
     * 名簿基準年月日のsetメソッドです。
     * <br/>
     * <br/>定時登録：3、6、9、12月1日 選挙時：告示（公示）年月日の前日 農委：1月1日 海区：9月1日
     *
     * @param kijunYMD 名簿基準年月日
     */
    public void setKijunYMD(FlexibleDate kijunYMD) {
        this.kijunYMD = kijunYMD;
    }

    /**
     * 名簿登録年月日のgetメソッドです。
     * <br/>
     * <br/>定時登録：名簿基準年月日の翌日 選挙時：名簿基準年月日 農委：3月31日 海区：12月5日
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate getMeiboTorokuYMD() {
        return meiboTorokuYMD;
    }

    /**
     * 名簿登録年月日のsetメソッドです。
     * <br/>
     * <br/>定時登録：名簿基準年月日の翌日 選挙時：名簿基準年月日 農委：3月31日 海区：12月5日
     *
     * @param meiboTorokuYMD 名簿登録年月日
     */
    public void setMeiboTorokuYMD(FlexibleDate meiboTorokuYMD) {
        this.meiboTorokuYMD = meiboTorokuYMD;
    }

    /**
     * 告示（公示）年月日のgetメソッドです。
     * <br/>
     * <br/>名簿基準年月日の翌日
     *
     * @return 告示（公示）年月日
     */
    public FlexibleDate getKokujiYMD() {
        return kokujiYMD;
    }

    /**
     * 告示（公示）年月日のsetメソッドです。
     * <br/>
     * <br/>名簿基準年月日の翌日
     *
     * @param kokujiYMD 告示（公示）年月日
     */
    public void setKokujiYMD(FlexibleDate kokujiYMD) {
        this.kokujiYMD = kokujiYMD;
    }

    /**
     * 転出期限年月日のgetメソッドです。
     * <br/>
     * <br/>国民投票の場合は、特定期間開始年月日（基準日の翌日）をセット
     *
     * @return 転出期限年月日
     */
    public FlexibleDate getTenshutsuKigenYMD() {
        return tenshutsuKigenYMD;
    }

    /**
     * 転出期限年月日のsetメソッドです。
     * <br/>
     * <br/>国民投票の場合は、特定期間開始年月日（基準日の翌日）をセット
     *
     * @param tenshutsuKigenYMD 転出期限年月日
     */
    public void setTenshutsuKigenYMD(FlexibleDate tenshutsuKigenYMD) {
        this.tenshutsuKigenYMD = tenshutsuKigenYMD;
    }

    /**
     * 転入期限年月日のgetメソッドです。
     * <br/>
     * <br/>国民投票の場合は、特定期限年月日（基準日＋14日）をセット
     *
     * @return 転入期限年月日
     */
    public FlexibleDate getTennyuKigenYMD() {
        return tennyuKigenYMD;
    }

    /**
     * 転入期限年月日のsetメソッドです。
     * <br/>
     * <br/>国民投票の場合は、特定期限年月日（基準日＋14日）をセット
     *
     * @param tennyuKigenYMD 転入期限年月日
     */
    public void setTennyuKigenYMD(FlexibleDate tennyuKigenYMD) {
        this.tennyuKigenYMD = tennyuKigenYMD;
    }

    /**
     * 投票受付開始年月日のgetメソッドです。
     *
     * @return 投票受付開始年月日
     */
    public FlexibleDate getTohyoUketsukeYMD() {
        return tohyoUketsukeYMD;
    }

    /**
     * 投票受付開始年月日のsetメソッドです。
     *
     * @param tohyoUketsukeYMD 投票受付開始年月日
     */
    public void setTohyoUketsukeYMD(FlexibleDate tohyoUketsukeYMD) {
        this.tohyoUketsukeYMD = tohyoUketsukeYMD;
    }

    /**
     * 無投票選挙フラグのgetメソッドです。
     *
     * @return 無投票選挙フラグ
     */
    public Boolean isMutohyoSenkyoFlag() {
        return mutohyoSenkyoFlag;
    }

    /**
     * 無投票選挙フラグのsetメソッドです。
     *
     * @param mutohyoSenkyoFlag 無投票選挙フラグ
     */
    public void setMutohyoSenkyoFlag(Boolean mutohyoSenkyoFlag) {
        this.mutohyoSenkyoFlag = mutohyoSenkyoFlag;
    }

}
