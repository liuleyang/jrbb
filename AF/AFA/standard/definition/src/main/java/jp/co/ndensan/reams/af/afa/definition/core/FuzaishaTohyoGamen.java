/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * AFAGME2010 不在者投票　不在者投票作成の画面対象
 *
 * @reamsid_L AF-0080-010 lit
 */
@lombok.Getter
@lombok.Setter
public class FuzaishaTohyoGamen implements Serializable {

    private FuzaishaTohyoSearchArea 不在者投票検索エリア;
    private FuzaishaTohyoSenkyoninArea 不在者投票選挙人エリア;
    private FuzaishaTohyoJokyoArea 不在者投票状況エリア;

    /**
     * FuzaishaTohyoSearchAreaのInstanceを返す。
     *
     * @return FuzaishaTohyoSearchArea
     */
    public FuzaishaTohyoSearchArea createFuzaishaTohyoSearchAreaInstance() {
        return new FuzaishaTohyoSearchArea();
    }

    /**
     * FuzaishaTohyoSenkyoninAreaのInstanceを返す。
     *
     * @return FuzaishaTohyoSenkyoninArea
     */
    public FuzaishaTohyoSenkyoninArea createFuzaishaTohyoSenkyoninAreaInstance() {
        return new FuzaishaTohyoSenkyoninArea();
    }

    /**
     * FuzaishaTohyoJokyoAreaのInstanceを返す。
     *
     * @return FuzaishaTohyoJokyoArea
     */
    public FuzaishaTohyoJokyoArea createFuzaishaTohyoJokyoAreaInstance() {
        return new FuzaishaTohyoJokyoArea();
    }

    /**
     * 投票状況エリアが変化かどうか。
     *
     * @param target FuzaishaTohyoGamen
     * @return 変化かどうか
     */
    public boolean isEqual投票状況(FuzaishaTohyoGamen target) {

        return 不在者投票状況エリア.equals(target.get不在者投票状況エリア());
    }

    /**
     * 選挙人エリアが変化かどうか。
     *
     * @param target FuzaishaTohyoGamen
     * @return 変化かどうか
     */
    public boolean isEqual選挙人(FuzaishaTohyoGamen target) {

        return 不在者投票選挙人エリア.equals(target.get不在者投票選挙人エリア());
    }

    /**
     * 不在者投票検索エリア保存用クラス。
     */
    @lombok.Getter
    @lombok.Setter
    public static final class FuzaishaTohyoSearchArea implements Serializable {

        private RString 抄本;
        private RString 施設コード;

        FuzaishaTohyoSearchArea() {
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 79 * hash + Objects.hashCode(this.抄本);
            hash = 79 * hash + Objects.hashCode(this.施設コード);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final FuzaishaTohyoSearchArea other = (FuzaishaTohyoSearchArea) obj;
            if (!Objects.equals(this.抄本, other.抄本)) {
                return false;
            }
            if (!Objects.equals(this.施設コード, other.施設コード)) {
                return false;
            }
            return true;
        }

    }

    /**
     * 不在者投票選挙人エリア保存用クラス。
     */
    @lombok.Getter
    @lombok.Setter
    public static final class FuzaishaTohyoSenkyoninArea implements Serializable {

        private RString 入場券バーコード;
        private int 選挙人数;

        FuzaishaTohyoSenkyoninArea() {
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 43 * hash + Objects.hashCode(this.入場券バーコード);
            hash = 43 * hash + this.選挙人数;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final FuzaishaTohyoSenkyoninArea other = (FuzaishaTohyoSenkyoninArea) obj;
            if (!Objects.equals(this.入場券バーコード, other.入場券バーコード)) {
                return false;
            }
            if (this.選挙人数 != other.選挙人数) {
                return false;
            }
            return true;
        }

    }

    /**
     * 不在者投票状況エリア保存用クラス。
     */
    @lombok.Getter
    @lombok.Setter
    public static final class FuzaishaTohyoJokyoArea implements Serializable {

        private RString 投票状況 = RString.EMPTY;
        private boolean 選択フラグ = false;

        // 請求情報
        private RString 請求方法 = RString.EMPTY;
        private RDate 請求日;
        private RString 投票事由 = RString.EMPTY;

        // 交付情報
        private RString 交付方法 = RString.EMPTY;
        private RDate 交付日;
        private boolean 点字投票用紙を使用フラグ = false;
        private boolean 証明書フラグ = false;

        // 受取情報
        private RDate 受取日;

        // 受理情報
        private RString 受理方法 = RString.EMPTY;
        private RDate 受理日;
        private RTime 受理日時;
        private boolean 代理投票フラグ;
        private ShikibetsuCode 補助者１識別コード = ShikibetsuCode.EMPTY;
        private ShikibetsuCode 補助者２識別コード = ShikibetsuCode.EMPTY;
        private RString 拒否事由 = RString.EMPTY;
        private boolean 仮投票フラグ = false;

        // 送致情報
        private boolean 送致済フラグ = false;

        FuzaishaTohyoJokyoArea() {
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 53 * hash + Objects.hashCode(this.投票状況);
            hash = 53 * hash + (this.選択フラグ ? 1 : 0);
            hash = 53 * hash + Objects.hashCode(this.請求方法);
            hash = 53 * hash + Objects.hashCode(this.請求日);
            hash = 53 * hash + Objects.hashCode(this.投票事由);
            hash = 53 * hash + Objects.hashCode(this.交付方法);
            hash = 53 * hash + Objects.hashCode(this.交付日);
            hash = 53 * hash + (this.点字投票用紙を使用フラグ ? 1 : 0);
            hash = 53 * hash + (this.証明書フラグ ? 1 : 0);
            hash = 53 * hash + Objects.hashCode(this.受取日);
            hash = 53 * hash + Objects.hashCode(this.受理方法);
            hash = 53 * hash + Objects.hashCode(this.受理日);
            hash = 53 * hash + Objects.hashCode(this.受理日時);
            hash = 53 * hash + (this.代理投票フラグ ? 1 : 0);
            hash = 53 * hash + Objects.hashCode(this.補助者１識別コード);
            hash = 53 * hash + Objects.hashCode(this.補助者２識別コード);
            hash = 53 * hash + Objects.hashCode(this.拒否事由);
            hash = 53 * hash + (this.仮投票フラグ ? 1 : 0);
            hash = 53 * hash + (this.送致済フラグ ? 1 : 0);
            return hash;
        }

        //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 68 LINES
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final FuzaishaTohyoJokyoArea other = (FuzaishaTohyoJokyoArea) obj;
            if (!Objects.equals(this.投票状況, other.投票状況)) {
                return false;
            }
            if (this.選択フラグ != other.選択フラグ) {
                return false;
            }
            if (!Objects.equals(this.請求方法, other.請求方法)) {
                return false;
            }
            if (!Objects.equals(this.請求日, other.請求日)) {
                return false;
            }
            if (!Objects.equals(this.投票事由, other.投票事由)) {
                return false;
            }
            if (!Objects.equals(this.交付方法, other.交付方法)) {
                return false;
            }
            if (!Objects.equals(this.交付日, other.交付日)) {
                return false;
            }
            if (this.点字投票用紙を使用フラグ != other.点字投票用紙を使用フラグ) {
                return false;
            }
            if (this.証明書フラグ != other.証明書フラグ) {
                return false;
            }
            if (!Objects.equals(this.受取日, other.受取日)) {
                return false;
            }
            if (!Objects.equals(this.受理方法, other.受理方法)) {
                return false;
            }
            if (!Objects.equals(this.受理日, other.受理日)) {
                return false;
            }
            if (!Objects.equals(this.受理日時, other.受理日時)) {
                return false;
            }
            if (this.代理投票フラグ != other.代理投票フラグ) {
                return false;
            }
            if (!Objects.equals(this.補助者１識別コード, other.補助者１識別コード)) {
                return false;
            }
            if (!Objects.equals(this.補助者２識別コード, other.補助者２識別コード)) {
                return false;
            }
            if (!Objects.equals(this.拒否事由, other.拒否事由)) {
                return false;
            }
            if (this.仮投票フラグ != other.仮投票フラグ) {
                return false;
            }
            if (this.送致済フラグ != other.送致済フラグ) {
                return false;
            }
            return true;
        }

    }
}
