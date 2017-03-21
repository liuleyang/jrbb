/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 投票状況を表す列挙型です。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0130-020 lit
 */
public enum TohyoJokyo implements IRStringConvertable {

    /**
     * なし<br />
     * コード：<br />
     */
    なし(""),
    /**
     * 請求<br />
     * コード：1<br />
     */
    請求("1"),
    /**
     * 交付<br />
     * コード：2<br />
     */
    交付("2"),
    /**
     * 受理<br />
     * コード：3<br />
     */
    受理("3"),
    /**
     * 返還<br />
     * コード：4<br />
     */
    返還("4"),
    /**
     * 棄権<br />
     * コード：5<br />
     */
    棄権("5"),
    /**
     * 期日前<br />
     * コード：6<br />
     */
    期日前("6"),
    /**
     * 当日<br />
     * コード：7<br />
     */
    当日("7"),
    /**
     * 受付拒否<br />
     * コード：8<br />
     */
    受付拒否("8"),
    /**
     * 仮投票<br />
     * コード：9<br />
     */
    仮投票("9"),
    /**
     * 取消<br />
     * コード：0<br />
     */
    取消("0"),
    /**
     * 受取<br />
     * コード：A<br />
     */
    受取("A"),
    /**
     * 送致<br />
     * コード：B<br />
     */
    送致("B"),
    /**
     * 無投票<br />
     * コード：Z<br />
     */
    無投票("Z");
    private final RString code;

    private TohyoJokyo(String cd) {
        this.code = new RString(cd);
    }

    /**
     * 指定された投票状況コードの投票状況を返します。
     *
     * @param code 投票状況コード
     * @return 投票状況
     */
    public static TohyoJokyo toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("コード"));
        for (TohyoJokyo item : TohyoJokyo.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        return TohyoJokyo.なし;
    }

    /**
     * 投票状況コードを返します。
     *
     * @return 投票状況コード
     */
    public RString getCode() {
        return code;
    }

    @Override
    public RString toRString() {
        return new RString(TohyoJokyo.this.toString());
    }

    /**
     * 投票状況コードリストを返す。
     *
     * @return 投票状況コードリスト
     */
    public static List<RString> getTohyoJokyoList() {
        List<RString> result = new ArrayList<>();
        for (TohyoJokyo tohyoJokyo : TohyoJokyo.values()) {
            if (!tohyoJokyo.getCode().isNullOrEmpty()) {
                result.add(tohyoJokyo.getCode());
            }
        }
        return result;
    }
}
