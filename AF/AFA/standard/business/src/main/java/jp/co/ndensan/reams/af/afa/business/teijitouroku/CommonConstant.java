/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.teijitouroku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共通定数の宣言クラス
 *
 */
public final class CommonConstant {

    private static final int THREE = 3;
    private static final int FOUR = 4;
    /**
     * 3ヶ月
     */
    public static final int 月_3ヶ;
    /**
     * 4ヶ月
     */
    public static final int 月_4ヶ;
    /**
     * index 3
     */
    public static final int キー3;
    /**
     * index 4
     */
    public static final int キー4;
    /**
     * 新規処理
     */
    public static final RString 新規処理;
    /**
     * ページbreakキーです。
     */
    public static final List<RString> PAGE_BREAK_KEYS;

    static {
        月_3ヶ = THREE;
        月_4ヶ = FOUR;
        キー3 = THREE;
        キー4 = FOUR;
        新規処理 = new RString("新規処理");
        PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("subTitle")));
    }

    private CommonConstant() {
    }
}
