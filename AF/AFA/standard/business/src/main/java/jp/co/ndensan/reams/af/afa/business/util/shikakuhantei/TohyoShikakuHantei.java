/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.util.shikakuhantei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TenshutuHyoujiKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfInformationMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfQuestionMessages;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 投票資格判定クラス。
 *
 * @reamsid_L AF-0070-031 liss
 */
public class TohyoShikakuHantei {

    private final List<AfT201TohyoJokyoEntity> 投票状況Lst;
    private final List<AfT201TohyoJokyoEntity> 不在者投票情報Lst;
    private final List<AfT201TohyoJokyoEntity> 期日前当日情報Lst;
    private static final RString 改行 = new RString("<br>");
    private static final RString 識別コード標識 = new RString("識別コード");
    private static final RString 投票資格情報標識 = new RString("投票資格情報");
    private static final RString 括弧_左 = new RString("【");
    private static final RString 括弧_右 = new RString("】");
    private static final RString 投票受付_有 = new RString("投票可");
    private static final RString 投票受付_無 = new RString("投票不可");

    private ShikakuHantei shikakuHantei;

    /**
     * コンストラクタです。
     */
    public TohyoShikakuHantei() {
        this.投票状況Lst = new ArrayList<>();
        this.不在者投票情報Lst = new ArrayList<>();
        this.期日前当日情報Lst = new ArrayList<>();
        shikakuHantei = new ShikakuHantei();
    }

    /**
     * コンストラクタです。
     *
     * @param 投票状況Lst 投票状況Lst
     * @param 不在者投票情報Lst 不在者投票情報Lst
     * @param 期日前当日情報Lst 期日前当日情報Lst
     */
    public TohyoShikakuHantei(List<AfT201TohyoJokyoEntity> 投票状況Lst, List<AfT201TohyoJokyoEntity> 不在者投票情報Lst,
            List<AfT201TohyoJokyoEntity> 期日前当日情報Lst) {
        this.投票状況Lst = 投票状況Lst;
        this.不在者投票情報Lst = 不在者投票情報Lst;
        this.期日前当日情報Lst = 期日前当日情報Lst;
        shikakuHantei = new ShikakuHantei();
    }

    /**
     * [投票状況]．投票状況を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 投票状況 投票状況
     */
    public List<Code> get投票状況(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));

        List<Code> 投票状況内容Lst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 投票状況内容Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    投票状況内容Lst.add(entity.getTohyoJokyo());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    投票状況内容Lst.add(entity.getTohyoJokyo());
                }
            }
        }
        return 投票状況内容Lst;
    }

    /**
     * [投票状況]．投票事由コードを返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 投票事由コード 投票事由コード
     */
    public List<Code> get投票事由コード(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));

        List<Code> 投票事由コードLst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 投票事由コードLst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    投票事由コードLst.add(entity.getTohyoJiyuCode());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    投票事由コードLst.add(entity.getTohyoJiyuCode());
                }
            }
        }
        return 投票事由コードLst;
    }

    /**
     * [投票状況]．代理投票有フラグを返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 代理投票有フラグ 代理投票有フラグ
     */
    public List<Boolean> get代理投票有フラグ(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));

        List<Boolean> 代理投票有フラグLst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 代理投票有フラグLst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    代理投票有フラグLst.add(entity.getDairiTohyoAriFlag());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    代理投票有フラグLst.add(entity.getDairiTohyoAriFlag());
                }
            }
        }
        return 代理投票有フラグLst;
    }

    /**
     * [投票状況]．点字フラグを返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 点字フラグ 点字フラグ
     */
    public List<Boolean> get点字フラグ(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));

        List<Boolean> 点字フラグLst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 点字フラグLst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    点字フラグLst.add(entity.getTenjiFlag());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    点字フラグLst.add(entity.getTenjiFlag());
                }
            }
        }
        return 点字フラグLst;
    }

    /**
     * [投票状況]．証明書出力フラグを返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 証明書出力フラグ 証明書出力フラグ
     */
    public List<Boolean> get証明書出力フラグ(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));

        List<Boolean> 証明書出力フラグLst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 証明書出力フラグLst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    証明書出力フラグLst.add(entity.getShomeishoPrintFlag());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    証明書出力フラグLst.add(entity.getShomeishoPrintFlag());
                }
            }
        }
        return 証明書出力フラグLst;
    }

    /**
     * [投票状況]．棄権年月日を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 棄権年月日 棄権年月日
     */
    public List<FlexibleDate> get棄権年月日(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<FlexibleDate> 棄権年月日Lst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 棄権年月日Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    棄権年月日Lst.add(entity.getKikenYMD());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    棄権年月日Lst.add(entity.getKikenYMD());
                }
            }
        }
        return 棄権年月日Lst;
    }

    /**
     * [投票状況]．返還年月日を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 返還年月日 返還年月日
     */
    public List<FlexibleDate> get返還年月日(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<FlexibleDate> 返還年月日Lst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 返還年月日Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    返還年月日Lst.add(entity.getHenkanYMD());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    返還年月日Lst.add(entity.getHenkanYMD());
                }
            }
        }
        return 返還年月日Lst;
    }

    /**
     * [投票状況]．補助者識別コード1を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 補助者識別コード1 補助者識別コード1
     */
    public List<ShikibetsuCode> get補助者識別コード1(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<ShikibetsuCode> 補助者識別コード1Lst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 補助者識別コード1Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    補助者識別コード1Lst.add(entity.getHojoshaShikibetsuCode1());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    補助者識別コード1Lst.add(entity.getHojoshaShikibetsuCode1());
                }
            }
        }
        return 補助者識別コード1Lst;
    }

    /**
     * [投票状況]．補助者氏名1を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 補助者氏名1 補助者氏名1
     */
    public List<AtenaMeisho> get補助者氏名1(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<AtenaMeisho> 補助者氏名1Lst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 補助者氏名1Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    補助者氏名1Lst.add(entity.getHojoshaShimei1());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    補助者氏名1Lst.add(entity.getHojoshaShimei1());
                }
            }
        }
        return 補助者氏名1Lst;
    }

    /**
     * [投票状況]．補助者識別コード1を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 補助者識別コード2 補助者識別コード2
     */
    public List<ShikibetsuCode> get補助者識別コード2(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<ShikibetsuCode> 補助者識別コード2Lst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 補助者識別コード2Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    補助者識別コード2Lst.add(entity.getHojoshaShikibetsuCode2());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    補助者識別コード2Lst.add(entity.getHojoshaShikibetsuCode2());
                }
            }
        }
        return 補助者識別コード2Lst;
    }

    /**
     * [投票状況]．補助者氏名2を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 補助者氏名2 補助者氏名2
     */
    public List<AtenaMeisho> get補助者氏名2(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<AtenaMeisho> 補助者氏名2Lst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 補助者氏名2Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    補助者氏名2Lst.add(entity.getHojoshaShimei2());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    補助者氏名2Lst.add(entity.getHojoshaShimei2());
                }
            }
        }
        return 補助者氏名2Lst;
    }

    /**
     * [投票状況]．拒否事由を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 拒否事由 拒否事由
     */
    public List<RString> get拒否事由(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<RString> 拒否事由Lst = new ArrayList<>();
        if (null == 投票状況Lst || 投票状況Lst.isEmpty()) {
            return 拒否事由Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 投票状況Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    拒否事由Lst.add(entity.getKyohiJiyu());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    拒否事由Lst.add(entity.getKyohiJiyu());
                }
            }
        }
        return 拒否事由Lst;
    }

    /**
     * [不在者投票情報]．請求年月日を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 請求年月日 請求年月日
     */
    public List<FlexibleDate> get請求年月日(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<FlexibleDate> 請求年月日Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 請求年月日Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    請求年月日Lst.add(entity.getSeikyuYMD());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    請求年月日Lst.add(entity.getSeikyuYMD());
                }
            }
        }
        return 請求年月日Lst;
    }

    /**
     * [不在者投票情報]．請求方法を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 請求方法 請求方法
     */
    public List<Code> get請求方法_不在者(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<Code> 請求方法Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 請求方法Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    請求方法Lst.add(entity.getSeikyuHoho());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    請求方法Lst.add(entity.getSeikyuHoho());
                }
            }
        }
        return 請求方法Lst;
    }

    /**
     * [不在者投票情報]．受付番号を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受付番号 受付番号
     */
    public List<Integer> get受付番号_不在者(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<Integer> 受付番号Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 受付番号Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受付番号Lst.add(entity.getUketsukeNo());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受付番号Lst.add(entity.getUketsukeNo());
                }
            }
        }
        return 受付番号Lst;
    }

    /**
     * [不在者投票情報]．交付年月日を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 交付年月日 交付年月日
     */
    public List<FlexibleDate> get交付年月日(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<FlexibleDate> 交付年月日Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 交付年月日Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    交付年月日Lst.add(entity.getKofuYMD());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    交付年月日Lst.add(entity.getKofuYMD());
                }
            }
        }
        return 交付年月日Lst;
    }

    /**
     * [不在者投票情報]．交付時刻を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 交付時刻 交付時刻
     */
    public List<RTime> get交付時刻(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<RTime> 交付時刻Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 交付時刻Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    交付時刻Lst.add(entity.getKofuTime());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    交付時刻Lst.add(entity.getKofuTime());
                }
            }
        }
        return 交付時刻Lst;
    }

    /**
     * [不在者投票情報]．交付方法を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 交付方法 交付方法
     */
    public List<Code> get交付方法(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<Code> 交付方法Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 交付方法Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    交付方法Lst.add(entity.getKofuHoho());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    交付方法Lst.add(entity.getKofuHoho());
                }
            }
        }
        return 交付方法Lst;
    }

    /**
     * [不在者投票情報]．交付施設コードを返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 交付施設コード 交付施設コード
     */
    public List<RString> get交付施設コード(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<RString> 交付施設コードLst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 交付施設コードLst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    交付施設コードLst.add(entity.getShisetsuCode());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    交付施設コードLst.add(entity.getShisetsuCode());
                }
            }
        }
        return 交付施設コードLst;
    }

    /**
     * [不在者投票情報]．受取年月日を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受取年月日 受取年月日
     */
    public List<FlexibleDate> get受取年月日(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<FlexibleDate> 受取年月日Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 受取年月日Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受取年月日Lst.add(entity.getUketoriYMD());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受取年月日Lst.add(entity.getUketoriYMD());
                }
            }
        }
        return 受取年月日Lst;
    }

    /**
     * [不在者投票情報]．受理年月日を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受理年月日 受理年月日
     */
    public List<FlexibleDate> get受理年月日(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<FlexibleDate> 受理年月日Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 受理年月日Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受理年月日Lst.add(entity.getJuriYMD());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受理年月日Lst.add(entity.getJuriYMD());
                }
            }
        }
        return 受理年月日Lst;
    }

    /**
     * [不在者投票情報]．受理時刻を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受理時刻 受理時刻
     */
    public List<RTime> get受理時刻(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<RTime> 受理時刻Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 受理時刻Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受理時刻Lst.add(entity.getJuriTime());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受理時刻Lst.add(entity.getJuriTime());
                }
            }
        }
        return 受理時刻Lst;
    }

    /**
     * [不在者投票情報]．受理方法を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受理方法 受理方法
     */
    public List<Code> get受理方法(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<Code> 受理方法Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 受理方法Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受理方法Lst.add(entity.getJuriHoho());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受理方法Lst.add(entity.getJuriHoho());
                }
            }
        }
        return 受理方法Lst;
    }

    /**
     * [不在者投票情報]．受理施設種別を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受理施設種別 受理施設種別
     */
    public List<Code> get受理施設種別(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<Code> 受理施設種別Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 受理施設種別Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受理施設種別Lst.add(entity.getJuriShisetsuShubetsu());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受理施設種別Lst.add(entity.getJuriShisetsuShubetsu());
                }
            }
        }
        return 受理施設種別Lst;
    }

    /**
     * [不在者投票情報]．返還年月日を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 返還年月日 返還年月日
     */
    public List<FlexibleDate> get返還年月日_不在者(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<FlexibleDate> 返還年月日Lst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 返還年月日Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    返還年月日Lst.add(entity.getHenkanYMD());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    返還年月日Lst.add(entity.getHenkanYMD());
                }
            }
        }
        return 返還年月日Lst;
    }

    /**
     * [不在者投票情報]．送致済フラグを返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 送致済フラグ 送致済フラグ
     */
    public List<Boolean> get送致済フラグ(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<Boolean> 送致済フラグLst = new ArrayList<>();
        if (null == 不在者投票情報Lst || 不在者投票情報Lst.isEmpty()) {
            return 送致済フラグLst;
        }
        for (AfT201TohyoJokyoEntity entity : 不在者投票情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    送致済フラグLst.add(entity.getSochiZumiFlag());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    送致済フラグLst.add(entity.getSochiZumiFlag());
                }
            }
        }
        return 送致済フラグLst;
    }

    /**
     * [期日前・当日情報]．受付番号を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受付番号 受付番号
     */
    public List<Integer> get受付番号(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<Integer> 受付番号Lst = new ArrayList<>();
        if (null == 期日前当日情報Lst || 期日前当日情報Lst.isEmpty()) {
            return 受付番号Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 期日前当日情報Lst) {
            ShikibetsuCode コード = entity.getShikibetsuCode();
            if (null != コード && コード.getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受付番号Lst.add(entity.getUketsukeNo());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受付番号Lst.add(entity.getUketsukeNo());
                }
            }
        }
        return 受付番号Lst;
    }

    /**
     * [期日前・当日情報]．受付年月日を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受付年月日 受付年月日
     */
    public List<FlexibleDate> get受付年月日(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<FlexibleDate> 受付年月日Lst = new ArrayList<>();
        if (null == 期日前当日情報Lst || 期日前当日情報Lst.isEmpty()) {
            return 受付年月日Lst;
        }

        for (AfT201TohyoJokyoEntity entity : 期日前当日情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受付年月日Lst.add(entity.getUketoriYMD());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受付年月日Lst.add(entity.getUketoriYMD());
                }
            }
        }
        return 受付年月日Lst;
    }

    /**
     * [期日前・当日情報]．受付時刻を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 受付時刻 受付時刻
     */
    public List<RTime> get受付時刻(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<RTime> 受付時刻Lst = new ArrayList<>();
        if (null == 期日前当日情報Lst || 期日前当日情報Lst.isEmpty()) {
            return 受付時刻Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 期日前当日情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    受付時刻Lst.add(entity.getJuriTime());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    受付時刻Lst.add(entity.getJuriTime());
                }
            }
        }
        return 受付時刻Lst;
    }

    /**
     * [期日前・当日情報]．請求方法を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 請求方法 請求方法
     */
    public List<Code> get請求方法(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<Code> 請求方法Lst = new ArrayList<>();
        if (null == 期日前当日情報Lst || 期日前当日情報Lst.isEmpty()) {
            return 請求方法Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 期日前当日情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    請求方法Lst.add(entity.getSeikyuHoho());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    請求方法Lst.add(entity.getSeikyuHoho());
                }
            }
        }
        return 請求方法Lst;
    }

    /**
     * [期日前・当日情報]．請求方法名を返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 期日前 期日前
     */
    public List<RString> get請求方法名(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<RString> 期日前Lst = new ArrayList<>();
        if (null == 期日前当日情報Lst || 期日前当日情報Lst.isEmpty()) {
            return 期日前Lst;
        }
        for (AfT201TohyoJokyoEntity entity : 期日前当日情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    期日前Lst.add(entity.getSeikyuHohoMeisho());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    期日前Lst.add(entity.getSeikyuHohoMeisho());
                }
            }
        }
        return 期日前Lst;
    }

    /**
     * [期日前・当日情報]．施設コードを返します。
     *
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return 施設コード 施設コード
     */
    public List<RString> get施設コード(RString 識別コード, RString 選挙番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        List<RString> 施設コードLst = new ArrayList<>();
        if (null == 期日前当日情報Lst || 期日前当日情報Lst.isEmpty()) {
            return 施設コードLst;
        }
        for (AfT201TohyoJokyoEntity entity : 期日前当日情報Lst) {
            if (entity.getShikibetsuCode().getColumnValue().equals(識別コード)) {
                if (選挙番号.isNullOrEmpty()) {
                    施設コードLst.add(entity.getShisetsuCode());
                } else if (!選挙番号.isNullOrEmpty() && 選挙番号.equals(new RString(entity.getSenkyoNo().getColumnValue().toString()))) {
                    施設コードLst.add(entity.getShisetsuCode());
                }
            }
        }
        return 施設コードLst;
    }

    /**
     * 加算有権者かどうかを返します。
     *
     * @param 投票資格情報 投票資格情報
     * @param 識別コード 識別コード
     * @param 判定基準日 判定基準日
     * @param 選挙番号 選挙番号
     * @return 加算有権者かどうか 加算有権者かどうか
     */
    public Boolean is加算有権者(SenkyoninTohyoJokyoEntity 投票資格情報, RString 識別コード, FlexibleDate 判定基準日, RString 選挙番号) {
        requireNonNull(投票資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage(投票資格情報標識.toString()));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
        requireNonNull(判定基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("判定基準日"));
        Code 選挙資格 = 投票資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        Code 選挙種類 = 投票資格情報.getSenkyoJohoEntity().getShohonEntity().getSenkyoShurui();
        Code 選挙レベル = 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity().get(0).getSenkyoLevel();
        RString 選挙資格Str = null != 選挙資格 ? 選挙資格.value() : RString.EMPTY;
        RString 選挙種類Str = null != 選挙種類 ? 選挙種類.value() : RString.EMPTY;
        RString 投票状況 = RString.EMPTY;
        Code 投票状況Code = 投票資格情報.getTohyoJokyoEntityList().get(0).getTohyoJokyo();
        RString 有権者数集計方法 = BusinessConfig.get(ConfigKeysAFA.有権者数調べ_県内転出者加算区分, SubGyomuCode.AFA選挙本体);
        if (null != 投票状況Code) {
            投票状況 = 投票状況Code.getKey();
        }
        if (SenkyoShurui.憲法改正国民投票.getCode().equals(選挙種類Str)) {
            return (SennkyoSikakuKubun.資格なし.value().equals(選挙資格Str) || SennkyoSikakuKubun.抹消者.value().equals(選挙資格Str))
                    && 投票状況.equals(TohyoJokyo.期日前.getCode());
        }
        if (SennkyoSikakuKubun.資格なし.value().equals(選挙資格Str) || SennkyoSikakuKubun.抹消者.value().equals(選挙資格Str)
                || SennkyoSikakuKubun.公民権停止.value().equals(選挙資格Str)) {
            return 投票状況.equals(TohyoJokyo.期日前.getCode());
        }
        if (SennkyoSikakuKubun.有権者.value().equals(選挙資格Str)) {
            return false;
        }
        if (SennkyoSikakuKubun.表示者.value().equals(選挙資格Str) && 選挙種類Str.equals(SenkyoShurui.国政選挙_地方選挙.getCode())) {
            if (new Code(SennkyoLevel.都道府県.value()).equals(選挙レベル)) {
                return (投票状況.equals(TohyoJokyo.期日前.getCode()) || 投票状況.equals(TohyoJokyo.受理.getCode()))
                        && !new RString("0").equals(有権者数集計方法);
            } else {
                return 投票状況.equals(TohyoJokyo.期日前.getCode());
            }
        }

        return false;
    }

    /**
     * 投票資格があるかどうかを返します。
     *
     * @param 投票資格情報 投票資格情報
     * @param 識別コード 識別コード
     * @param 判定基準日 判定基準日
     *
     * @return 投票資格があるかどうか 投票資格があるかどうか
     */
    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 100 LINES
    public List<Boolean> has投票資格(SenkyoninTohyoJokyoEntity 投票資格情報, ShikibetsuCode 識別コード, FlexibleDate 判定基準日) {
        //TODO FindBugsの一時対応、後確認する必要がある。
//        requireNonNull(投票資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage(投票資格情報標識.toString()));
//        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
//        requireNonNull(判定基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("判定基準日"));
        List<AfT111SenkyoEntity> afT111SenkyoEntitys = 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity();
        int size = afT111SenkyoEntitys.size();
        Code 選挙資格 = 投票資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        Code 選挙種類 = 投票資格情報.getSenkyoJohoEntity().getShohonEntity().getSenkyoShurui();
        RString 選挙資格Str = null != 選挙資格 ? 選挙資格.value() : RString.EMPTY;
        RString 選挙種類Str = null != 選挙種類 ? 選挙種類.value() : RString.EMPTY;
        if (SenkyoShurui.憲法改正国民投票.getCode().equals(選挙種類Str)) {
            return createBooleanList(!(SennkyoSikakuKubun.資格なし.value().equals(選挙資格Str)
                    || SennkyoSikakuKubun.抹消者.value().equals(選挙資格Str)), size);
        }

        if (SennkyoSikakuKubun.資格なし.value().equals(選挙資格Str)
                || SennkyoSikakuKubun.抹消者.value().equals(選挙資格Str)
                || SennkyoSikakuKubun.公民権停止.value().equals(選挙資格Str)) {
            return createBooleanList(false, size);
        } else if (SennkyoSikakuKubun.有権者.value().equals(選挙資格Str)) {
            List<Boolean> trgt = new ArrayList<>();
            for (AfT111SenkyoEntity entity : afT111SenkyoEntitys) {
                Code 選挙レベル = entity.getSenkyoLevel();
                RString 選挙レベルStr = null != 選挙レベル ? 選挙レベル.value() : RString.EMPTY;
                FlexibleDate 年齢到達期限日 = 投票資格情報.getSenkyoJohoEntity().getShohonEntity().getKiteiNenreiTotatsuYMD();
                boolean is再転入者 = shikakuHantei.is再転入者(Arrays.asList(投票資格情報.getAtenaPSMEntity()),
                        entity.getTenshutsuKigenYMD(),
                        entity.getTennyuKigenYMD(),
                        年齢到達期限日);

                trgt.add(!is再転入者 || !SennkyoLevel.都道府県.value().equals(選挙レベルStr));

            }
            return trgt;
        }

        if (SenkyoShurui.国政選挙_地方選挙.getCode().equals(選挙種類Str)) {
            List<Boolean> trgt = new ArrayList<>();
            for (AfT111SenkyoEntity entity : afT111SenkyoEntitys) {
                Code 選挙レベル = entity.getSenkyoLevel();
                RString 選挙レベルStr = null != 選挙レベル ? 選挙レベル.value() : RString.EMPTY;
                if (SennkyoLevel.国.value().equals(選挙レベルStr)) {
                    trgt.add(true);
                } else if (SennkyoLevel.都道府県.value().equals(選挙レベルStr)) {
                    trgt.add(new Code(TenshutuHyoujiKubun.県内転出.value()).equals(shikakuHantei.get転出表示区分(投票資格情報)));
                } else if (SennkyoLevel.市区町村.value().equals(選挙レベルStr)) {
                    RString 転出期限日検索基準Config = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
                    trgt.add((YMDKensakuKijunConfig.消除届出年月日.getValue().equals(転出期限日検索基準Config)
                            && !ShikibetsuTaishoFactory.createKojin(投票資格情報.getAtenaPSMEntity()).get消除届出年月日().isBefore(判定基準日))
                            || (YMDKensakuKijunConfig.消除異動年月日.getValue().equals(転出期限日検索基準Config)
                            && !ShikibetsuTaishoFactory.createKojin(投票資格情報.getAtenaPSMEntity()).get消除異動年月日().isBefore(判定基準日)));
                } else {
                    trgt.add(false);
                }
            }
            return trgt;
        } else {
            return createBooleanList(true, size);
        }

    }

    private List<Boolean> createBooleanList(boolean rslt, int size) {
        List<Boolean> trgt = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            trgt.add(rslt);
        }
        return trgt;
    }

    /**
     * 投票資格があるかどうかを返します。
     *
     * @param 投票資格情報 投票資格情報
     * @param 識別コード 識別コード
     * @param 判定基準日 判定基準日
     *
     * @return 投票資格があるかどうか 投票資格があるかどうか
     */
    public Boolean has投票資格Old(SenkyoninTohyoJokyoEntity 投票資格情報, ShikibetsuCode 識別コード, FlexibleDate 判定基準日) {
        //TODO FindBugsの一時対応、後確認する必要がある。
//        requireNonNull(投票資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage(投票資格情報標識.toString()));
//        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage(識別コード標識.toString()));
//        requireNonNull(判定基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("判定基準日"));
        Code 選挙資格 = 投票資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        Code 選挙種類 = 投票資格情報.getSenkyoJohoEntity().getShohonEntity().getSenkyoShurui();
        RString 選挙資格Str = null != 選挙資格 ? 選挙資格.value() : RString.EMPTY;
        RString 選挙種類Str = null != 選挙種類 ? 選挙種類.value() : RString.EMPTY;
        if (SenkyoShurui.憲法改正国民投票.getCode().equals(選挙種類Str)) {
            return !(SennkyoSikakuKubun.資格なし.value().equals(選挙資格Str)
                    || SennkyoSikakuKubun.抹消者.value().equals(選挙資格Str));
        }

        if (SennkyoSikakuKubun.資格なし.value().equals(選挙資格Str)
                || SennkyoSikakuKubun.抹消者.value().equals(選挙資格Str)
                || SennkyoSikakuKubun.公民権停止.value().equals(選挙資格Str)) {
            return false;
        } else if (SennkyoSikakuKubun.有権者.value().equals(選挙資格Str)) {
            AfT111SenkyoEntity entity = 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity().get(0);
            Code 選挙レベル = entity.getSenkyoLevel();
            RString 選挙レベルStr = null != 選挙レベル ? 選挙レベル.value() : RString.EMPTY;
            FlexibleDate 年齢到達期限日 = 投票資格情報.getSenkyoJohoEntity().getShohonEntity().getKiteiNenreiTotatsuYMD();
            boolean is再転入者 = shikakuHantei.is再転入者(Arrays.asList(投票資格情報.getAtenaPSMEntity()),
                    entity.getTenshutsuKigenYMD(),
                    entity.getTennyuKigenYMD(),
                    年齢到達期限日);

            return !is再転入者 || !SennkyoLevel.都道府県.value().equals(選挙レベルStr);
        }

        if (SenkyoShurui.国政選挙_地方選挙.getCode().equals(選挙種類Str)) {
            Code 選挙レベル = 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity().get(0).getSenkyoLevel();
            RString 選挙レベルStr = null != 選挙レベル ? 選挙レベル.value() : RString.EMPTY;
            if (SennkyoLevel.国.value().equals(選挙レベルStr)) {
                return true;
            } else if (SennkyoLevel.都道府県.value().equals(選挙レベルStr)) {
                return new Code(TenshutuHyoujiKubun.県内転出.value()).equals(shikakuHantei.get転出表示区分(投票資格情報));
            } else if (SennkyoLevel.市区町村.value().equals(選挙レベルStr)) {
                RString 転出期限日検索基準Config = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
                return (YMDKensakuKijunConfig.消除届出年月日.getValue().equals(転出期限日検索基準Config)
                        && !ShikibetsuTaishoFactory.createKojin(投票資格情報.getAtenaPSMEntity()).get消除届出年月日().isBefore(判定基準日))
                        || (YMDKensakuKijunConfig.消除異動年月日.getValue().equals(転出期限日検索基準Config)
                        && !ShikibetsuTaishoFactory.createKojin(投票資格情報.getAtenaPSMEntity()).get消除異動年月日().isBefore(判定基準日));
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    /**
     * 各種エラーチェック。
     *
     * @param 投票資格情報 投票資格情報
     *
     * @return チェック結果
     */
    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 154 LINES
    //CHECKSTYLE IGNORE MethodLength FOR NEXT 154 LINES
    public IValidationMessages 各種エラーチェック1(SenkyoninTohyoJokyoEntity 投票資格情報) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        // チェック１：選挙テーブルの情報での判定
        boolean 無投票選挙フラグ = true;
        boolean 受付開始日前フラグ = true;
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        for (AfT111SenkyoEntity 選挙 : 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity()) {
            if (!選挙.getMutohyoSenkyoFlag()) {
                無投票選挙フラグ = false;
            }
            if (!システム日付.isBefore(選挙.getTohyoUketsukeYMD())) {
                受付開始日前フラグ = false;
            }
        }
        if (無投票選挙フラグ) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, "無投票です。"));
        } else if (受付開始日前フラグ) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, "受付開始日前です。"));
        }
        return messages;
    }

    /**
     * 各種エラーチェック。
     *
     * @param 投票資格情報 投票資格情報
     * @param チェック基準日 チェック基準日
     *
     * @return チェック結果
     */
    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 154 LINES
    //CHECKSTYLE IGNORE MethodLength FOR NEXT 154 LINES
    public IValidationMessages 各種エラーチェック(SenkyoninTohyoJokyoEntity 投票資格情報, FlexibleDate チェック基準日) {
        requireNonNull(投票資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage(投票資格情報標識.toString()));

        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        IValidationMessages messages = 各種エラーチェック1(投票資格情報);
        if (messages.getSize() > 0) {
            return messages;
        }
        // チェック２：選挙資格テーブルから取得した選挙資格での判定
        Code 選挙資格 = 投票資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        if (new Code(SenkyoShikaku.公民権停止者.getコード()).equals(選挙資格)) {
            RString replacements = new RString("選挙資格なし（").concat(
                    投票資格情報.getSenkyoShikakuEntity().getHyojiJiyuCodeMeisho()).concat(new RString("）"));
            messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, replacements.toString()));
            return messages;
        }
        FlexibleDate masshoYMD = 投票資格情報.getSenkyoShikakuEntity().getMasshoYMD();
        if (new Code(SenkyoShikaku.抹消者.getコード()).equals(選挙資格)
                && masshoYMD != null
                && masshoYMD.isBeforeOrEquals(チェック基準日)) {
            RString replacements = new RString("抹消事由（").concat(
                    投票資格情報.getSenkyoShikakuEntity().getMasshoJiyuCodeMeisho()).concat(new RString("）"));
            messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, replacements.toString()));
            return messages;
        }
        if (new Code(SenkyoShikaku.なし.getコード()).equals(選挙資格)) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, "選挙資格なし"));
            return messages;
        }
        // チェック３：選挙人の住基情報からの判定
        FlexibleDate 年齢到達期限日 = 投票資格情報.getSenkyoJohoEntity().getShohonEntity().getKiteiNenreiTotatsuYMD();

        for (AfT111SenkyoEntity afT111SenkyoEntity : 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity()) {
            FlexibleDate 転出期限日 = afT111SenkyoEntity.getTenshutsuKigenYMD();
            if (shikakuHantei.is抹消者(
                    投票資格情報.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日)) {
                Code 抹消事由コード = 投票資格情報.getSenkyoShikakuEntity().getMasshoJiyuCode();
                if (抹消事由コード != null && JiyuCode.死亡.getKey().equals(抹消事由コード.getColumnValue())) {
                    messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, "死亡者です。"));
                    return messages;
                }
            }
        }
        FlexibleDate 投票日 = 投票資格情報.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD();
        int 選挙資格到達年齢 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体).toString());
        FlexibleDate 生年月日 = 投票資格情報.getAtenaPSMEntity().getSeinengappiYMD();
        if (生年月日 == null) {
            生年月日 = FlexibleDate.MIN;
        }
        if (投票日 == null || 投票日.isBefore(生年月日.plusYear(選挙資格到達年齢))) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, "基準年齢に達していません。"));
            return messages;
        } else if (システム日付.isBefore(生年月日.plusYear(選挙資格到達年齢))) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.年齢未到達));
            return messages;
        }

        // チェック４：選挙区での判定（国レベル)
        boolean 国レベル選挙あり = false;
        for (AfT111SenkyoEntity senkyoEntity : 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity()) {
            if (new Code(SennkyoLevel.国.value()).equals(senkyoEntity.getSenkyoLevel())) {
                国レベル選挙あり = true;
                break;
            }
        }
        if (国レベル選挙あり && AFAConfigKeysValue.期日前_選挙区確認有無_あり.isEqual(ConfigKeysAFA.期日前_選挙区確認の有無)) {
            if (投票資格情報.getAft505Count() == 0) {
                messages.add(new TohyoShikakuHanteiValidationMessage(UrErrorMessages.存在しない, "選挙区情報"));
                return messages;
            }
            List<AfT505SenkyokuTanmatsuKanriEntity> 選挙区端末管理リスト = 投票資格情報.getSenkyokuTanmatsuKanriEntityList();

            if (選挙区端末管理リスト == null || 選挙区端末管理リスト.isEmpty()) {
                messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, "選挙区が違います。"));
                return messages;
            }

        }

        // チェック５：取得した選挙ごとに判定（複数選挙で、レベル違い等があった場合のこと）
        boolean 選挙ごと判定 = true;
        boolean needチェック５ = false;
        for (AfT111SenkyoEntity entity : 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity()) {
            if (選挙資格 != null
                    && ((SenkyoShikaku.有権者.getコード().equals(選挙資格.getColumnValue())
                    && shikakuHantei.is再転入者(Arrays.asList(投票資格情報.getAtenaPSMEntity()),
                            entity.getTenshutsuKigenYMD(),
                            entity.getTennyuKigenYMD(),
                            年齢到達期限日))
                    || SenkyoShikaku.表示者.getコード().equals(選挙資格.getColumnValue()))) {
                needチェック５ = true;
            }

            SenkyoninTohyoJokyoEntity new投票資格情報 = new SenkyoninTohyoJokyoEntity();
            List<AfT111SenkyoEntity> senkyoEntityList = new ArrayList<>();
            senkyoEntityList.add(entity);

            SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
            senkyoJohoEntity.setShohonEntity(投票資格情報.getSenkyoJohoEntity().getShohonEntity());
            senkyoJohoEntity.setSenkyoEntity(senkyoEntityList);
            new投票資格情報.setSenkyoJohoEntity(senkyoJohoEntity);
            new投票資格情報.setSenkyoninMeiboEntity(投票資格情報.getSenkyoninMeiboEntity());
            new投票資格情報.setSenkyoShikakuEntity(投票資格情報.getSenkyoShikakuEntity());
            new投票資格情報.setFuzaishaTohyoShikakuEntity(投票資格情報.getFuzaishaTohyoShikakuEntity());
            new投票資格情報.setFuzaishaTohyoShikakuYubinEntity(投票資格情報.getFuzaishaTohyoShikakuYubinEntity());
            new投票資格情報.setTohyoJokyoEntityList(投票資格情報.getTohyoJokyoEntityList());
            new投票資格情報.setAtenaPSMEntity(投票資格情報.getAtenaPSMEntity());
            new投票資格情報.setZaigaiSenkyoninMeiboEntity(投票資格情報.getZaigaiSenkyoninMeiboEntity());
            new投票資格情報.setZaigaiSenkyoShikakuEntity(投票資格情報.getZaigaiSenkyoShikakuEntity());
            new投票資格情報.setZaigaiSenkyoninShinseiEntity(投票資格情報.getZaigaiSenkyoninShinseiEntity());
            new投票資格情報.setZaigaiSenkyoninJushoEntity(投票資格情報.getZaigaiSenkyoninJushoEntity());
            Boolean has投票資格 = has投票資格Old(new投票資格情報, new投票資格情報.getAtenaPSMEntity().getShikibetsuCode(), entity.getKijunYMD());
            if (has投票資格 != null && has投票資格) {
                選挙ごと判定 = false;
            }
        }
        if (選挙ごと判定 && needチェック５) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可, "投票資格なし"));
            return messages;
        }
        // チェック６：投票状況テーブルの情報で判定
        List<AfT201TohyoJokyoEntity> 投票状況リスト = 投票資格情報.getTohyoJokyoEntityList();
        if (投票状況リスト != null && !投票状況リスト.isEmpty()) {
            boolean 棄権登録済み = true;
            boolean 不在者投票処理済み = true;
            boolean 当日投票済み = true;
            for (AfT201TohyoJokyoEntity tohyoJokyoEntity : 投票状況リスト) {
                if (tohyoJokyoEntity == null
                        || (!new Code(TohyoJokyo.棄権.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                        && !new Code(TohyoJokyo.無投票.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo()))) {
                    棄権登録済み = false;
                }
                if (tohyoJokyoEntity == null
                        || (!new Code(TohyoJokyo.交付.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                        && !new Code(TohyoJokyo.受理.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo()))
                        && !new Code(TohyoJokyo.棄権.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                        && !new Code(TohyoJokyo.無投票.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())) {
                    不在者投票処理済み = false;
                }
                if (tohyoJokyoEntity == null
                        || (!new Code(TohyoJokyo.当日.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo()))
                        && !new Code(TohyoJokyo.棄権.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                        && !new Code(TohyoJokyo.無投票.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())) {
                    当日投票済み = false;
                }
            }
            if (棄権登録済み) {
                messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可_理由付き, "棄権登録済み"));
                return messages;
            }
            if (不在者投票処理済み) {
                messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可_理由付き, "不在者投票での処理済み"));
                return messages;
            }
            if (当日投票済み) {
                messages.add(new TohyoShikakuHanteiValidationMessage(AfErrorMessages.投票受付不可_理由付き, "当日投票済み"));
                return messages;
            }
        }
        return null;
    }

    /**
     * 確認チェック。
     *
     * @param 投票資格情報 SenkyoninTohyoJokyoEntity
     * @param チェック基準日 FlexibleDate
     * @return チェック結果
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    public IValidationMessages 確認チェック(SenkyoninTohyoJokyoEntity 投票資格情報, FlexibleDate チェック基準日) {
        requireNonNull(投票資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage(投票資格情報標識.toString()));

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        // チェック１：投票状況テーブルの情報で判定
        //  boolean 投票受付済み = true;
        boolean 投票受付済み = false;
        int 受理Cnt = 0;
        int 受付Cnt = 0;
        for (AfT201TohyoJokyoEntity tohyoJokyoEntity : 投票資格情報.getTohyoJokyoEntityList()) {
            if (tohyoJokyoEntity != null
                    && (new Code(TohyoJokyo.棄権.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                    || new Code(TohyoJokyo.期日前.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                    || new Code(TohyoJokyo.当日.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                    || new Code(TohyoJokyo.無投票.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo()))) {
                投票受付済み = true;
            }
            if (tohyoJokyoEntity != null
                    && (new Code(TohyoJokyo.交付.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                    || new Code(TohyoJokyo.無投票.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo()))) {
                受理Cnt++;
            }
            if (tohyoJokyoEntity != null
                    && (new Code(TohyoJokyo.受理.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                    || new Code(TohyoJokyo.期日前.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo())
                    || new Code(TohyoJokyo.無投票.getCode()).equals(tohyoJokyoEntity.getTohyoJokyo()))) {
                受付Cnt++;
            }
        }
        if (投票受付済み) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfInformationMessages.投票受付完了));
        }
        if (受理Cnt > 0 && 受理Cnt != 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity().size()) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfInformationMessages.一部交付済み));
        }
        if (受付Cnt > 0 && 受付Cnt != 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity().size()) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfInformationMessages.一部受付済み));
        }

        // チェック２：受付開始日を過ぎた、県レベル選挙が存在するとき
        RString 転出期限日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        FlexibleDate 転出期限日 = FlexibleDate.MIN;
        if (new RString("1").equals(転出期限日検索基準)) {
            転出期限日 = 投票資格情報.getAtenaPSMEntity().getShojoTodokedeYMD();
        } else if (new RString("2").equals(転出期限日検索基準)) {
            転出期限日 = 投票資格情報.getAtenaPSMEntity().getShojoIdoYMD();
        }
        Code 選挙資格 = 投票資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        if (((new Code(SenkyoShikaku.表示者.getコード()).equals(選挙資格)
                && new Code(TenshutuHyoujiKubun.県内転出.value()).equals(shikakuHantei.get転出表示区分(投票資格情報)))
                || (new Code(SenkyoShikaku.抹消者.getコード()).equals(選挙資格)))
                && !チェック基準日.isBefore(転出期限日)) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfInformationMessages.引き続き証明書提示));
        }

        //チェック３：郵便投票資格のチェック
        RString menuId = ResponseHolder.getMenuID();
        List<AfT114FuzaishaTohyoShikakuEntity> 不在者投票資格List = new ArrayList<>();
        AfT114FuzaishaTohyoShikakuEntity aft114 = 投票資格情報.getFuzaishaTohyoShikakuEntity();
        if (aft114 != null) {
            不在者投票資格List.add(aft114);
        }
        if (Arrays.asList(AFAMenuId.AFAMNE1010_期日前投票.menuId(), AFAMenuId.AFAMNE7010_期日前投票.menuId()).contains(menuId)
                && AFAConfigKeysValue.期日前_郵便投票資格有無の確認_チェックする.isEqual(ConfigKeysAFA.期日前_郵便投票資格有無の確認)
                && shikakuHantei.has郵便投票資格(
                        投票資格情報.getAtenaPSMEntity().getShikibetsuCode(), チェック基準日, 不在者投票資格List)) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfInformationMessages.郵便資格あり));

        }
        // チェック４：船員投票資格のチェック
        if (((Arrays.asList(AFAMenuId.AFAMNE1010_期日前投票.menuId(), AFAMenuId.AFAMNE7010_期日前投票.menuId()).contains(menuId)
                && AFAConfigKeysValue.期日前_洋上投票資格有無の確認_チェックする.isEqual(ConfigKeysAFA.期日前_洋上投票資格有無の確認))
                || (Arrays.asList(AFAMenuId.AFAMNE2010_不在者投票用紙請求.menuId(),
                        AFAMenuId.AFAMNE2020_不在者投票用紙交付.menuId(),
                        AFAMenuId.AFAMNE2030_不在者投票用紙受理.menuId(),
                        AFAMenuId.AFAMNE2040_施設バーコード一括受理.menuId()).contains(menuId)
                && AFAConfigKeysValue.不在者_洋上投票資格有無の確認_チェックする.isEqual(ConfigKeysAFA.不在者_洋上投票資格有無の確認)))
                && shikakuHantei.has洋上投票資格(
                        投票資格情報.getAtenaPSMEntity().getShikibetsuCode(), チェック基準日, 不在者投票資格List)) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfInformationMessages.船員資格あり));
        }
        // チェック５：取得した選挙ごとに判定
        RStringBuilder messageNaiyo = new RStringBuilder();
        boolean 選挙ごと判定 = false;
        for (AfT111SenkyoEntity entity : 投票資格情報.getSenkyoJohoEntity().getSenkyoEntity()) {
            SenkyoninTohyoJokyoEntity new投票資格情報 = new SenkyoninTohyoJokyoEntity();
            List<AfT111SenkyoEntity> senkyoEntityList = new ArrayList<>();
            senkyoEntityList.add(entity);

            SenkyoJohoEntity senkyoJohoEntity = new SenkyoJohoEntity();
            senkyoJohoEntity.setShohonEntity(投票資格情報.getSenkyoJohoEntity().getShohonEntity());
            senkyoJohoEntity.setSenkyoEntity(senkyoEntityList);
            new投票資格情報.setSenkyoJohoEntity(senkyoJohoEntity);
            new投票資格情報.setSenkyoninMeiboEntity(投票資格情報.getSenkyoninMeiboEntity());
            new投票資格情報.setSenkyoShikakuEntity(投票資格情報.getSenkyoShikakuEntity());
            new投票資格情報.setFuzaishaTohyoShikakuEntity(投票資格情報.getFuzaishaTohyoShikakuEntity());
            new投票資格情報.setFuzaishaTohyoShikakuYubinEntity(投票資格情報.getFuzaishaTohyoShikakuYubinEntity());
            new投票資格情報.setTohyoJokyoEntityList(投票資格情報.getTohyoJokyoEntityList());
            new投票資格情報.setAtenaPSMEntity(投票資格情報.getAtenaPSMEntity());
            new投票資格情報.setZaigaiSenkyoninMeiboEntity(投票資格情報.getZaigaiSenkyoninMeiboEntity());
            new投票資格情報.setZaigaiSenkyoShikakuEntity(投票資格情報.getZaigaiSenkyoShikakuEntity());
            new投票資格情報.setZaigaiSenkyoninShinseiEntity(投票資格情報.getZaigaiSenkyoninShinseiEntity());
            new投票資格情報.setZaigaiSenkyoninJushoEntity(投票資格情報.getZaigaiSenkyoninJushoEntity());
            Boolean has投票資格 = has投票資格Old(new投票資格情報, new投票資格情報.getAtenaPSMEntity().getShikibetsuCode(), チェック基準日);
            if (has投票資格 != null) {
                messageNaiyo.append(改行);
                messageNaiyo.append(括弧_左);
                messageNaiyo.append(entity.getSenkyoRyakusho());
                messageNaiyo.append(括弧_右);
                messageNaiyo.append(has投票資格 ? 投票受付_有 : 投票受付_無);
                if (has投票資格) {
                    選挙ごと判定 = true;
                }
            }
        }

        boolean 転出異動日当日の受付 = AFAConfigKeysValue.期日前_転出異動日当日確認の有無_あり.isEqual(ConfigKeysAFA.期日前_転出異動日当日確認の有無)
                && チェック基準日.equals(転出期限日);

        //CHECKSTYLE IGNORE SimplifyBooleanExpression FOR NEXT 5 LINES
        if ((messages.getSize() != 0 || 転出異動日当日の受付 == true) && 選挙ごと判定) {
            messages.add(new TohyoShikakuHanteiValidationMessage(AfQuestionMessages.投票受付判断,
                    messageNaiyo.append(転出異動日当日の受付 ? 改行.concat("転出異動日当日の受付です。") : RString.EMPTY).toString()));
            return buildMsg(true, messages);
        }

        return buildMsg(false, messages);
    }

    private static class TohyoShikakuHanteiValidationMessage implements IValidationMessage {

        private final Message message;

        TohyoShikakuHanteiValidationMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        TohyoShikakuHanteiValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        TohyoShikakuHanteiValidationMessage(Message message) {
            this.message = message;
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private IValidationMessages buildMsg(boolean isQuestion, IValidationMessages messages) {
        if (messages.getSize() == 0) {
            return null;
        }
        IValidationMessages rslt = ValidationMessagesFactory.createInstance();
        RStringBuilder builder = new RStringBuilder();
        for (IValidationMessage message : messages.getList()) {
            builder.append(message.getMessage().evaluate()).append(改行);
        }
        rslt.add(new TohyoShikakuHanteiValidationMessage(isQuestion
                ? new QuestionMessage(messages.getList().get(messages.getSize() - 1).getMessage().getCode(), builder.toString())
                : new InformationMessage(messages.getList().get(messages.getSize() - 1).getMessage().getCode(), builder.toString())));
        return rslt;
    }
}
