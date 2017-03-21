/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * AFAGME5020 投票受付　投票録作成の画面対象
 */
@lombok.Getter
@lombok.Setter
public class TohyorokuGamen implements Serializable {

    private RString 抄本 = RString.EMPTY;
    private RDate 投票日;
    private RString 選挙名 = RString.EMPTY;
    private RString 投票所 = RString.EMPTY;
    private RString 投票区 = RString.EMPTY;
    private RDate 調製日;
    private RString 投票所設置状況 = RString.EMPTY;
    private RString 投票所開設場所 = RString.EMPTY;
    private RDate 投票所開始年月日;
    private RDate 投票所終了年月日;
    private RTime 投票所開始時刻;
    private RTime 投票所終了時刻;
    private List<TohyouSha> 投票立会人リスト = new ArrayList<>();
    private List<TohyouSha> 投票管理者リスト = new ArrayList<>();
    private List<TohyouSha> 再交付者リスト = new ArrayList<>();
    private List<TohyouSha> 決定書または裁決書リスト = new ArrayList<>();
    private Decimal 選管書記人数 = Decimal.ZERO;
    private Decimal 職員人数 = Decimal.ZERO;
    private Decimal その他人数 = Decimal.ZERO;

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 90 LINES
    @Override
    public boolean equals(Object target) {
        if (null == target || !(target instanceof TohyorokuGamen)) {
            return false;
        }

        TohyorokuGamen o = (TohyorokuGamen) target;
        if (!抄本.equals(o.抄本)) {
            return false;
        }
        if ((null == 投票日 && null != o.投票日)
                || (null != 投票日 && null == o.投票日)
                || (null != 投票日 && null != o.投票日 && !投票日.equals(o.投票日))) {
            return false;
        }
        if (!選挙名.equals(o.選挙名)) {
            return false;
        }
        if (!投票所.equals(o.投票所)) {
            return false;
        }
        if (!投票区.equals(o.投票区)) {
            return false;
        }
        if ((null == 調製日 && null != o.調製日)
                || (null != 調製日 && null == o.調製日)
                || (null != 調製日 && null != o.調製日 && !調製日.equals(o.調製日))) {
            return false;
        }
        if (!投票所設置状況.equals(o.投票所設置状況)) {
            return false;
        }
        if (!投票所開設場所.equals(o.投票所開設場所)) {
            return false;
        }
        if ((null == 投票所開始年月日 && null != o.投票所開始年月日)
                || (null != 投票所開始年月日 && null == o.投票所開始年月日)
                || (null != 投票所開始年月日 && null != o.投票所開始年月日 && !投票所開始年月日.equals(o.投票所開始年月日))) {
            return false;
        }
        if ((null == 投票所終了年月日 && null != o.投票所終了年月日)
                || (null != 投票所終了年月日 && null == o.投票所終了年月日)
                || (null != 投票所終了年月日 && null != o.投票所終了年月日 && !投票所終了年月日.equals(o.投票所終了年月日))) {
            return false;
        }
        if ((null == 投票所開始時刻 && null != o.投票所開始時刻)
                || (null != 投票所開始時刻 && null == o.投票所開始時刻)
                || (null != 投票所開始時刻 && null != o.投票所開始時刻 && !投票所開始時刻.equals(o.投票所開始時刻))) {
            return false;
        }
        if ((null == 投票所終了時刻 && null != o.投票所終了時刻)
                || (null != 投票所終了時刻 && null == o.投票所終了時刻)
                || (null != 投票所終了時刻 && null != o.投票所終了時刻 && !投票所終了時刻.equals(o.投票所終了時刻))) {
            return false;
        }

        if (!checkEqual(投票立会人リスト, o.投票立会人リスト)) {
            return false;
        }

        if (!checkEqual(投票管理者リスト, o.投票管理者リスト)) {
            return false;
        }

        if (!checkEqual(再交付者リスト, o.再交付者リスト)) {
            return false;
        }

        if (!checkEqual(決定書または裁決書リスト, o.決定書または裁決書リスト)) {
            return false;
        }

        if ((null == 選管書記人数 && null != o.選管書記人数)
                || (null != 選管書記人数 && null == o.選管書記人数)
                || (null != 選管書記人数 && null != o.選管書記人数 && !選管書記人数.equals(o.選管書記人数))) {
            return false;
        }
        if ((null == 職員人数 && null != o.職員人数)
                || (null != 職員人数 && null == o.職員人数)
                || (null != 職員人数 && null != o.職員人数 && !職員人数.equals(o.職員人数))) {
            return false;
        }
        if ((null == その他人数 && null != o.その他人数)
                || (null != その他人数 && null == o.その他人数)
                || (null != その他人数 && null != o.その他人数 && !その他人数.equals(o.その他人数))) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.抄本);
        hash = 71 * hash + Objects.hashCode(this.投票日);
        hash = 71 * hash + Objects.hashCode(this.選挙名);
        hash = 71 * hash + Objects.hashCode(this.投票所);
        hash = 71 * hash + Objects.hashCode(this.投票区);
        hash = 71 * hash + Objects.hashCode(this.調製日);
        hash = 71 * hash + Objects.hashCode(this.投票所設置状況);
        hash = 71 * hash + Objects.hashCode(this.投票所開設場所);
        hash = 71 * hash + Objects.hashCode(this.投票所開始年月日);
        hash = 71 * hash + Objects.hashCode(this.投票所終了年月日);
        hash = 71 * hash + Objects.hashCode(this.投票所開始時刻);
        hash = 71 * hash + Objects.hashCode(this.投票所終了時刻);
        hash = 71 * hash + Objects.hashCode(this.投票立会人リスト);
        hash = 71 * hash + Objects.hashCode(this.投票管理者リスト);
        hash = 71 * hash + Objects.hashCode(this.再交付者リスト);
        hash = 71 * hash + Objects.hashCode(this.決定書または裁決書リスト);
        hash = 71 * hash + Objects.hashCode(this.選管書記人数);
        hash = 71 * hash + Objects.hashCode(this.職員人数);
        hash = 71 * hash + Objects.hashCode(this.その他人数);
        return hash;
    }

    private boolean checkEqual(List<?> o1, List<?> o2) {
        if (null == o1 && null == o2) {
            return true;
        }

        if ((null == o1 && null != o2)
                || (null != o1 && null == o2)
                || (null != o1 && null != o2 && o1.size() != o2.size())) {
            return false;
        }

        if (null != o1 && null != o2) {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
