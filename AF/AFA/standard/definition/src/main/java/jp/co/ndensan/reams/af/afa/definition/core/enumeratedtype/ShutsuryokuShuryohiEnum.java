/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転出者はがき_抽出終了日設定を表す列挙型です。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public enum ShutsuryokuShuryohiEnum {

    /**
     * 投票日を含めない
     */
    投票日を含めない(new RString("0")),
    /**
     * 投票日を含める
     */
    投票日を含める(new RString("1")),
    /**
     * 入場券発行処理日の前日まで
     */
    入場券発行処理日の前日まで(new RString("2")),
    /**
     * 入場券発行処理日まで
     */
    入場券発行処理日まで(new RString("3"));
    private final RString value;

    private ShutsuryokuShuryohiEnum(RString value) {
        this.value = value;
    }

    /**
     * 転出者はがき_抽出終了日設定を取得する
     *
     * @return 年月日検索基準
     */
    public RString getValue() {
        return value;
    }
}
