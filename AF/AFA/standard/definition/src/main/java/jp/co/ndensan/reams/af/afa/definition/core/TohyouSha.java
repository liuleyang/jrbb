/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 投票者クラスです。
 */
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class TohyouSha implements Serializable {

    private RString 党派 = RString.EMPTY;
    private RString 氏名 = RString.EMPTY;
    private FlexibleDate 選任年月日 = FlexibleDate.EMPTY;
    private RTime 立会時間開始;
    private RTime 立会時間終了;
    private RTime 参会時刻;
    private RTime 辞職時刻;
    private RString 事由 = RString.EMPTY;
    private RString 補助者1氏名 = RString.EMPTY;
    private RString 補助者2氏名 = RString.EMPTY;
    private boolean 仮投票フラグ = false;

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 61 LINES
    @Override
    public boolean equals(Object target) {
        if (null == target || !(target instanceof TohyouSha)) {
            return false;
        }

        TohyouSha o = (TohyouSha) target;
        if (!党派.equals(o.党派)) {
            return false;
        }

        if (!氏名.equals(o.氏名)) {
            return false;
        }

        if (!選任年月日.equals(o.選任年月日)) {
            return false;
        }

        if ((null == 立会時間開始 && null != o.立会時間開始)
                || (null != 立会時間開始 && null == o.立会時間開始)
                || (null != 立会時間開始 && null != o.立会時間開始 && !立会時間開始.equals(o.立会時間開始))) {
            return false;
        }

        if ((null == 立会時間終了 && null != o.立会時間終了)
                || (null != 立会時間終了 && null == o.立会時間終了)
                || (null != 立会時間終了 && null != o.立会時間終了 && !立会時間終了.equals(o.立会時間終了))) {
            return false;
        }

        if ((null == 参会時刻 && null != o.参会時刻)
                || (null != 参会時刻 && null == o.参会時刻)
                || (null != 参会時刻 && null != o.参会時刻 && !参会時刻.equals(o.参会時刻))) {
            return false;
        }

        if ((null == 辞職時刻 && null != o.辞職時刻)
                || (null != 辞職時刻 && null == o.辞職時刻)
                || (null != 辞職時刻 && null != o.辞職時刻 && !辞職時刻.equals(o.辞職時刻))) {
            return false;
        }

        if (!事由.equals(o.事由)) {
            return false;
        }

        if (!補助者1氏名.equals(o.補助者1氏名)) {
            return false;
        }

        if (!補助者2氏名.equals(o.補助者2氏名)) {
            return false;
        }

        if (仮投票フラグ != o.仮投票フラグ) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.党派);
        hash = 53 * hash + Objects.hashCode(this.氏名);
        hash = 53 * hash + Objects.hashCode(this.選任年月日);
        hash = 53 * hash + Objects.hashCode(this.立会時間開始);
        hash = 53 * hash + Objects.hashCode(this.立会時間終了);
        hash = 53 * hash + Objects.hashCode(this.参会時刻);
        hash = 53 * hash + Objects.hashCode(this.辞職時刻);
        hash = 53 * hash + Objects.hashCode(this.事由);
        hash = 53 * hash + Objects.hashCode(this.補助者1氏名);
        hash = 53 * hash + Objects.hashCode(this.補助者2氏名);
        hash = 53 * hash + Objects.hashCode(this.仮投票フラグ);
        return hash;
    }
}
