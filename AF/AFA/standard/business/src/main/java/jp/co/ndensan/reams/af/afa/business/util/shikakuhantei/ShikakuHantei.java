/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.util.shikakuhantei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeEnum;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_グループコード_居住区分毎;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MeiboShohonConfigValue.抄本_グループコード_資格区分毎;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TenshutuHyoujiKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.TohyoJokyoJohoEntity;
import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai.住民;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai.死亡者;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai.消除者;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai.転出者;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu.日本人;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.住所設定;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.出生;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.国籍取得;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.国籍喪失;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.失踪宣告;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.就籍;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.帰化;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.死亡;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.法務大臣への住居地届出;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.特例による転入;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.特例による転出;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.第30条の46届出;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.第30条の47届出;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.職権修正;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.職権消除;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.職権記載;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.転入;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.転入通知受理;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.転出;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.転出取消;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu.転居;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 選挙人資格判定クラス
 *
 * @reamsid_L AF-0070-031 wangm
 */
public class ShikakuHantei {

    private static final int 投票区コード数 = 4;
    private static final int 冊数 = 3;
    private static final int 頁数 = 6;
    private static final int 行数 = 2;
    private static final int 日_14 = 14;

    private static final RString 名簿番号_接続符 = new RString("-");

    private static final int 経過_３ヶ月 = 3;
    private static final int 経過_４ヶ月 = 4;
    private static final int 経過_１ヶ月 = 1;
    private static final int 経過_1４ヶ日 = 14;
    private static final RString 国外転出者_全国住所コードの上2桁 = new RString("99");
    private static final int 基準月_12月 = 12;
    private static final int 基準月_9月 = 9;
    private static final int 基準月_6月 = 6;
    private static final int 基準月_3月 = 3;
    private static final int 基準日_1日 = 1;

    /**
     * コンストラクタです。
     *
     */
    public ShikakuHantei() {

    }

    /**
     * 選挙人資格判定クラス(選挙人資格情報付け)
     *
     */
    public static class ShikakuHanteiWithInfo {

        private final List<SenkyoninTohyoJokyoEntity> 選挙人資格情報List;
        private Boolean isデータ存在 = Boolean.FALSE;

        /**
         * コンストラクタです。
         *
         * @param 選挙人資格情報List 選挙人資格情報List
         */
        public ShikakuHanteiWithInfo(List<SenkyoninTohyoJokyoEntity> 選挙人資格情報List) {
            this.選挙人資格情報List = 選挙人資格情報List;
        }

        /**
         * [宛名識別対象]．識別対象を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 宛名識別対象 ．識別対象
         */
        public IShikibetsuTaisho get識別対象(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity());
                }
            }
            throwException();
            return null;
        }

        /**
         * [選挙人名簿情報]．グループコードを返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人名簿情報．グループコード
         */
        public RString getグループコード(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoninMeiboEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoninMeiboEntity().getGroupCode();

                }
            }
            throwException();
            return RString.EMPTY;
        }

        /**
         * [選挙人名簿情報]．冊を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人名簿情報．冊
         */
        public RString get冊(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoninMeiboEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoninMeiboEntity().getSatsu();
                }
            }
            throwException();
            return RString.EMPTY;
        }

        /**
         * [選挙人名簿情報]．投票区を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人名簿情報．投票区
         *
         */
        public RString get投票区(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getTohyokuCode();
                }
            }
            throwException();
            return RString.EMPTY;
        }

        /**
         * [選挙人名簿情報]．頁を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人名簿情報．頁
         */
        public int get頁(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoninMeiboEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoninMeiboEntity().getPage();
                }
            }
            throwException();
            return 0;
        }

        /**
         * [選挙人名簿情報]．行を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人名簿情報．行
         */
        public int get行(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoninMeiboEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoninMeiboEntity().getGyo();
                }
            }
            throwException();
            return 0;
        }

        /**
         * [選挙人名簿情報]．名簿番号を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return [選挙人名簿情報]．名簿番号
         */
        public RString get名簿番号(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoninMeiboEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    if (AFAConfigKeysValue.抄本_冊区分管理_使用しない.isEqual(ConfigKeysAFA.抄本_冊区分管理)) {

                        return build名簿番号(選挙人資格情報.getSenkyoninMeiboEntity().getTohyokuCode().padLeft(投票区コード数),
                                padLeft(選挙人資格情報.getSenkyoninMeiboEntity().getPage(), 頁数),
                                padLeft(選挙人資格情報.getSenkyoninMeiboEntity().getGyo(), 行数));

                    } else {
                        return build名簿番号(選挙人資格情報.getSenkyoninMeiboEntity().getTohyokuCode().padLeft(投票区コード数),
                                選挙人資格情報.getSenkyoninMeiboEntity().getSatsu().padLeft(冊数),
                                padLeft(選挙人資格情報.getSenkyoninMeiboEntity().getPage(), 頁数),
                                padLeft(選挙人資格情報.getSenkyoninMeiboEntity().getGyo(), 行数));
                    }
                }
            }
            throwException();
            return RString.EMPTY;
        }

        private RString padLeft(int 項目, int 文字数) {
            RString 項目RStr = new RString(String.valueOf(項目));
            return 項目RStr.padLeft(文字数);

        }

        /**
         * [選挙資格情報]．名簿登録年月日を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．名簿登録年月日
         */
        public FlexibleDate get名簿登録年月日(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getMeiboTorokuYMD();
                }
            }
            throwException();
            return FlexibleDate.EMPTY;
        }

        private RString build名簿番号(RString 名簿番号Head, RString... 名簿番号s) {
            RStringBuilder 名簿番号Builder = new RStringBuilder(名簿番号Head);
            for (RString 名簿番号 : 名簿番号s) {
                名簿番号Builder.append(名簿番号_接続符);
                名簿番号Builder.append(名簿番号);
            }
            return 名簿番号Builder.toRString();
        }

        /**
         * [選挙資格情報]．選挙資格区分を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．選挙資格区分
         */
        public Code get選挙資格区分(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getShikakuKubun();
                }
            }
            throwException();
            return Code.EMPTY;
        }

        /**
         * [選挙資格情報]．登録事由を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．登録事由
         */
        public Code get登録事由(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getTorokuJiyuCode();
                }
            }
            throwException();
            return Code.EMPTY;
        }

        /**
         * [選挙資格情報]．登録停止年月日を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．登録停止年月日
         */
        public FlexibleDate get登録停止年月日(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getTorokuTeishiYMD();
                }
            }
            throwException();
            return FlexibleDate.EMPTY;
        }

        /**
         * [選挙資格情報]．登録停止事由を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．登録停止事由
         */
        public Code get登録停止事由(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getTorokuTeishiJiyuCode();
                }
            }
            throwException();
            return Code.EMPTY;
        }

        /**
         * [選挙資格情報]．表示年月日を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．表示年月日
         */
        public FlexibleDate get表示年月日(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getHyojiYMD();
                }
            }
            throwException();
            return FlexibleDate.EMPTY;
        }

        /**
         * [選挙資格情報]．表示事由を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．表示事由
         */
        public Code get表示事由(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getHyojiJiyuCode();
                }
            }
            throwException();
            return Code.EMPTY;
        }

        /**
         * [選挙資格情報]．表示消除年月日を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．表示消除年月日
         */
        public FlexibleDate get表示消除年月日(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getHyojiShojoYMD();
                }
            }
            throwException();
            return FlexibleDate.EMPTY;
        }

        /**
         * [選挙資格情報]．抹消年月日を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．抹消年月日
         */
        public FlexibleDate get抹消年月日(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getMasshoYMD();
                }
            }
            throwException();
            return FlexibleDate.EMPTY;
        }

        /**
         * [選挙資格情報]．抹消事由を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．抹消事由
         */
        public Code get抹消事由(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getMasshoJiyuCode();
                }
            }
            throwException();
            return Code.EMPTY;
        }

        /**
         * [選挙資格情報]．刑期終了年月日を返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．刑期終了年月日
         */
        public FlexibleDate get刑期終了年月日(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getKeikiShuryoYMD();
                }
            }
            throwException();
            return FlexibleDate.EMPTY;
        }

        /**
         * [選挙資格情報]．2刑持ちかどうかを返す。
         *
         * @param 識別コード ShikibetsuCode
         * @return 選挙人資格情報 ．2刑持ちかどうか
         */
        public Boolean is2刑(ShikibetsuCode 識別コード) {
            for (SenkyoninTohyoJokyoEntity 選挙人資格情報 : 選挙人資格情報List) {
                if (選挙人資格情報.getSenkyoShikakuEntity() != null
                        && 識別コード.equals(ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity()).get識別コード())) {
                    isデータ存在 = Boolean.TRUE;
                    return 選挙人資格情報.getSenkyoShikakuEntity().getNikeimochiFlag();
                }
            }
            throwException();
            return false;
        }

        private void throwException() {
            if (!isデータ存在) {
                throw new SystemException(UrErrorMessages.該当データなし.toString());
            }
        }
    }

    /**
     * [選挙資格情報]．郵便投票資格者どうかを返す。
     *
     * @param 識別コード ShikibetsuCode
     * @param 基準日 基準日
     * @param 不在者投票資格List 不在者投票資格List
     * @return 郵便投票資格者どうかを返す
     */
    @SuppressWarnings("null")
    public Boolean has郵便投票資格(ShikibetsuCode 識別コード, FlexibleDate 基準日, List<AfT114FuzaishaTohyoShikakuEntity> 不在者投票資格List) {
        for (AfT114FuzaishaTohyoShikakuEntity 不在者投票資格 : 不在者投票資格List) {
            if (不在者投票資格.getShikibetsuCode().equals(識別コード)
                    && 不在者投票資格.getTohyoShikakuShurui().equals(new Code(new RString("1")))
                    && this.toMinWhenNullOrEmpty(不在者投票資格.getKofuYMD()).isBefore(基準日)
                    && 基準日.isBeforeOrEquals(this.toMinWhenNullOrEmpty(不在者投票資格.getShikakuManryoYMD()))
                    && (isNullOrEmpty(不在者投票資格.getShikakuMasshoYMD()) || 基準日.isBefore(不在者投票資格.getShikakuMasshoYMD()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * [選挙資格情報]．洋上投票資格者どうかを返す。
     *
     * @param 識別コード ShikibetsuCode
     * @param 基準日 基準日
     * @param 不在者投票資格List 不在者投票資格List
     * @return 洋上投票資格者どうかを返す
     */
    public Boolean has洋上投票資格(ShikibetsuCode 識別コード, FlexibleDate 基準日, List<AfT114FuzaishaTohyoShikakuEntity> 不在者投票資格List) {
        for (AfT114FuzaishaTohyoShikakuEntity 不在者投票資格 : 不在者投票資格List) {
            if (不在者投票資格.getShikibetsuCode().equals(識別コード)
                    && 不在者投票資格.getTohyoShikakuShurui().equals(new Code(new RString("2")))
                    && this.toMinWhenNullOrEmpty(不在者投票資格.getKofuYMD()).isBefore(基準日)
                    && 基準日.isBeforeOrEquals(this.toMinWhenNullOrEmpty(不在者投票資格.getShikakuManryoYMD()))
                    && (isNullOrEmpty(不在者投票資格.getShikakuMasshoYMD()) || 基準日.isBefore(不在者投票資格.getShikakuMasshoYMD()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * [選挙資格情報]．南極投票資格者どうかを返す。
     *
     * @param 識別コード ShikibetsuCode
     * @param 基準日 基準日
     * @param 不在者投票資格List 不在者投票資格List
     * @return 南極投票資格者どうかを返す
     */
    public Boolean has南極投票資格(ShikibetsuCode 識別コード, FlexibleDate 基準日, List<AfT114FuzaishaTohyoShikakuEntity> 不在者投票資格List) {
        for (AfT114FuzaishaTohyoShikakuEntity 不在者投票資格 : 不在者投票資格List) {
            if (不在者投票資格.getShikibetsuCode().equals(識別コード)
                    && 不在者投票資格.getTohyoShikakuShurui().equals(new Code(new RString("3")))
                    && this.toMinWhenNullOrEmpty(不在者投票資格.getKofuYMD()).isBefore(基準日)
                    && 基準日.isBeforeOrEquals(this.toMinWhenNullOrEmpty(不在者投票資格.getShikakuManryoYMD()))
                    && (isNullOrEmpty(不在者投票資格.getShikakuMasshoYMD()) || 基準日.isBefore(不在者投票資格.getShikakuMasshoYMD()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * [定時登録バッチ処理用の判定]．有権者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 転入期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     * @param 選挙資格 AfT113SenkyoShikakuEntity
     * @return 有権者かどうか
     */
    public Boolean is有権者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 転入期限日, FlexibleDate 年齢到達期限日, FlexibleDate 投票日,
            SenkyoShurui 選挙種類, AfT113SenkyoShikakuEntity 選挙資格) {
        if (is公民権停止者(宛名識別対象, 選挙資格, 年齢到達期限日, 投票日)) {
            return false;
        }
        return is有権者(宛名識別対象, 転入期限日, 年齢到達期限日, 投票日, 選挙種類);
    }

    /**
     * [定時登録バッチ処理用の判定]．有権者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 転入期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     * @return 有権者かどうか
     */
    public Boolean is有権者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 転入期限日, FlexibleDate 年齢到達期限日, FlexibleDate 投票日,
            SenkyoShurui 選挙種類) {
        転入期限日 = toMinWhenNullOrEmpty(転入期限日);
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        投票日 = toMinWhenNullOrEmpty(投票日);

        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        if (宛名.to個人().get住民種別().equals(日本人) && 宛名.to個人().get住民状態().equals(住民)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日)
                && (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(ConfigKeysAFA.登録年月日検索基準)
                ? toMinWhenNullOrEmpty(宛名.to個人().get登録届出年月日()).isBeforeOrEquals(転入期限日)
                : toMinWhenNullOrEmpty(宛名.to個人().get登録異動年月日()).isBeforeOrEquals(転入期限日))) {
            return true;
        } else {
            return this.is転出者(宛名, 選挙種類, 投票日, 年齢到達期限日);
        }
    }

    private Boolean is転出者(IShikibetsuTaisho 宛名, SenkyoShurui 選挙種類, FlexibleDate 投票日, FlexibleDate 年齢到達期限日) {
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        if (宛名.to個人().get住民種別().equals(日本人) && 宛名.to個人().get住民状態().equals(転出者)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日)) {
            if (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)) {
                return 選挙種類.equals(SenkyoShurui.定時登録)
                        ? 投票日.isBefore(toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()))
                        : 投票日.isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()));
            }
            if (AFAConfigKeysValue.消除年月日検索基準_消除異動年月日.isEqual(消除年月日検索基準)) {
                return 選挙種類.equals(SenkyoShurui.定時登録)
                        ? 投票日.isBefore(toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日()))
                        : 投票日.isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日()));
            }
        }
        return false;
    }

    /**
     * [定時登録バッチ処理用の判定]．表示者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 前回基準日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     * @param 選挙資格 AfT113SenkyoShikakuEntity
     * @return 表示者フラグかどうか
     */
    public Boolean is表示者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日,
            FlexibleDate 投票日, FlexibleDate 前回基準日, SenkyoShurui 選挙種類, AfT113SenkyoShikakuEntity 選挙資格) {
        if (is公民権停止者(宛名識別対象, 選挙資格, 年齢到達期限日, 投票日)) {
            return false;
        }
        return is表示者(宛名識別対象, 転出期限日, 年齢到達期限日, 投票日, 前回基準日, 選挙種類);
    }

    /**
     * [定時登録バッチ処理用の判定]．表示者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 前回基準日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     * @return 表示者フラグかどうか
     */
    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 30 LINES
    public Boolean is表示者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日,
            FlexibleDate 投票日, FlexibleDate 前回基準日, SenkyoShurui 選挙種類) {
        転出期限日 = toMinWhenNullOrEmpty(転出期限日);
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        投票日 = toMinWhenNullOrEmpty(投票日);
        前回基準日 = toMinWhenNullOrEmpty(前回基準日);
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);

        if (宛名.to個人().get住民種別().equals(日本人) && 宛名.to個人().get住民状態().equals(転出者)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日)) {
            if (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)
                    && 転出期限日.isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()))
                    && ((選挙種類.equals(SenkyoShurui.定時登録) && toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()).isBeforeOrEquals(投票日))
                    || (選挙種類.equals(SenkyoShurui.国政選挙_地方選挙) && toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()).isBefore(投票日)))) {
                return true;
            }
            if (AFAConfigKeysValue.消除年月日検索基準_消除異動年月日.isEqual(消除年月日検索基準)
                    && 転出期限日.isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日()))
                    && ((選挙種類.equals(SenkyoShurui.定時登録) && toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日()).isBeforeOrEquals(投票日))
                    || (選挙種類.equals(SenkyoShurui.国政選挙_地方選挙) && toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日()).isBefore(投票日)))) {
                return true;
            }
        } else if (宛名.to個人().get住民種別().equals(日本人) && 宛名.to個人().get住民状態().equals(消除者)
                && 宛名.to個人().get異動事由().equals(職権消除)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日)) {
            if (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)) {
                return 前回基準日.isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()));
            }
            if (AFAConfigKeysValue.消除年月日検索基準_消除異動年月日.isEqual(消除年月日検索基準)) {
                return 前回基準日.isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日()));
            }
        }
        return false;
    }

    /**
     * [定時登録バッチ処理用の判定]．抹消者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return 抹消者かどうか
     */
    public Boolean is抹消者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        転出期限日 = toMinWhenNullOrEmpty(転出期限日);
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        if (宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(死亡者)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日)) {
            return true;
        } else if (宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(消除者)
                && 宛名.to個人().get異動事由().equals(国籍喪失)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日)) {
            return true;
        } else {
            return is抹消者ByCase1(宛名, 転出期限日, 年齢到達期限日);
        }
    }

    private boolean is抹消者ByCase1(IShikibetsuTaisho 宛名, FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        if (宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(転出者)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日)
                && (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)
                ? toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()).isBefore(転出期限日)
                : toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日()).isBefore(転出期限日))) {
            return true;
        } else if (宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(消除者)
                && 宛名.to個人().get異動事由().equals(職権消除)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日)) {
            return AFAConfigKeysValue.消除年月日検索基準_消除異動年月日.isEqual(消除年月日検索基準)
                    ? toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()).isBefore(転出期限日)
                    : toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日()).isBefore(転出期限日);
        }
        return false;
    }

    /**
     * [定時登録バッチ処理用の判定]．転居者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 年齢到達期限日 FlexibleDate
     * @return 転居者かどうか
     */
    public Boolean is転居者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 年齢到達期限日) {
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        return 宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(住民)
                && 宛名.to個人().get異動事由().equals(転居)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日);
    }

    /**
     * [定時登録バッチ処理用の判定]．職権修正者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 年齢到達期限日 FlexibleDate
     * @return 職権修正者かどうか
     */
    public Boolean is職権修正者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 年齢到達期限日) {
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        return 宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(住民)
                && 宛名.to個人().get異動事由().equals(職権修正)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日);
    }

    /**
     * [定時登録バッチ処理用の判定]．公民権停止者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 選挙資格 AfT113SenkyoShikakuEntity
     * @param 年齢到達期限日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @return 公民権停止者かどうか
     */
    public boolean is公民権停止者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, AfT113SenkyoShikakuEntity 選挙資格, FlexibleDate 年齢到達期限日,
            FlexibleDate 基準日) {
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        基準日 = toMinWhenNullOrEmpty(基準日);
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        if (null != 選挙資格) {
            return SenkyoShikaku.公民権停止者.getコード().equals(NullHandler.getNullToRString(選挙資格.getShikakuKubun()))
                    && 宛名.to個人().get住民種別().equals(日本人)
                    && (宛名.to個人().get住民状態().equals(住民) || 宛名.to個人().get住民状態().equals(転出者))
                    && this.is選挙資格年齢到達(宛名, 年齢到達期限日)
                    && (toMinWhenNullOrEmpty(選挙資格.getTorokuTeishiYMD()).isBeforeOrEquals(基準日)
                    && !NullHandler.getNullToFlexibleDate(選挙資格.getTorokuTeishiYMD()).isEmpty());
        }
        return false;
    }

    /**
     * [定時登録バッチ処理用の判定]．再転入者かどうかを返す。
     *
     * @param 宛名識別対象_全件 List<UaFt200FindShikibetsuTaishoEntity>
     * @param 転出期限日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return 再転入者かどうか
     */
    public Boolean is再転入者(List<UaFt200FindShikibetsuTaishoEntity> 宛名識別対象_全件, FlexibleDate 転出期限日,
            FlexibleDate 転入期限日, FlexibleDate 年齢到達期限日) {
        転出期限日 = toMinWhenNullOrEmpty(転出期限日);
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        転入期限日 = toMinWhenNullOrEmpty(転入期限日);
        List<IShikibetsuTaisho> 宛名_全件 = new ArrayList<>();
        for (UaFt200FindShikibetsuTaishoEntity 宛名識別対象 : 宛名識別対象_全件) {
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
            if (宛名.to個人().get住民種別().equals(日本人)
                    && 宛名.to個人().get住民状態().equals(住民)
                    && this.is選挙資格年齢到達(宛名, 年齢到達期限日)
                    && (this.is増事由(宛名.to個人().get異動事由())
                    || this.is減事由(宛名.to個人().get異動事由()))) {
                宛名_全件.add(宛名);
            }
        }
        if (宛名_全件.isEmpty()) {
            return false;
        }
        Collections.sort(宛名_全件, new Comparator<IShikibetsuTaisho>() {
            @Override
            public int compare(IShikibetsuTaisho arg0, IShikibetsuTaisho arg1) {
                return Integer.valueOf(arg1.get履歴番号()).compareTo(Integer.valueOf(arg0.get履歴番号()));
            }
        });
        for (IShikibetsuTaisho shikibetsuTaisho : 宛名_全件) {
            if (shikibetsuTaisho.to個人().get異動事由().equals(転入)) {
                return this.登録日チェック(宛名識別対象_全件, 転入期限日, 転出期限日, shikibetsuTaisho.get履歴番号());
            }
        }
        return false;
    }

    private Boolean 登録日チェック(List<UaFt200FindShikibetsuTaishoEntity> 宛名識別対象_全件, FlexibleDate 転入期限日,
            FlexibleDate 転出期限日, int 取得した履歴番号) {
        RString 登録年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
        Boolean flag = true;
        for (UaFt200FindShikibetsuTaishoEntity 宛名識別対象 : 宛名識別対象_全件) {
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
            if (!(AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(登録年月日検索基準)
                    ? toMinWhenNullOrEmpty(宛名.to個人().get登録届出年月日()).isBeforeOrEquals(転入期限日)
                    && 転出期限日.isBefore(toMinWhenNullOrEmpty(宛名.to個人().get登録届出年月日()))
                    : toMinWhenNullOrEmpty(宛名.to個人().get登録異動年月日()).isBeforeOrEquals(転入期限日)
                    && 転出期限日.isBefore(toMinWhenNullOrEmpty(宛名.to個人().get登録異動年月日())))) {
                flag = false;
            }
        }
        if (flag) {
            return this.データ取得(宛名識別対象_全件, 取得した履歴番号, 転出期限日);
        }
        return false;
    }

    private Boolean データ取得(List<UaFt200FindShikibetsuTaishoEntity> 宛名識別対象_全件, int 取得した履歴番号, FlexibleDate 転出期限日) {
        List<IShikibetsuTaisho> 宛名_全件 = new ArrayList<>();
        for (UaFt200FindShikibetsuTaishoEntity 宛名識別対象 : 宛名識別対象_全件) {
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
            if (this.is減事由(宛名.to個人().get異動事由()) && 宛名.get履歴番号() < 取得した履歴番号) {
                宛名_全件.add(宛名);
            }
        }
        if (宛名_全件.isEmpty()) {
            return false;
        }
        Collections.sort(宛名_全件, new Comparator<IShikibetsuTaisho>() {
            @Override
            public int compare(IShikibetsuTaisho arg0, IShikibetsuTaisho arg1) {
                return Integer.valueOf(arg1.get履歴番号()).compareTo(Integer.valueOf(arg0.get履歴番号()));
            }
        });
        for (IShikibetsuTaisho shikibetsuTaisho : 宛名_全件) {
            if (shikibetsuTaisho.to個人().get異動事由().equals(転出)) {
                return 消除日チェック(宛名識別対象_全件, 転出期限日);
            }
        }
        return false;
    }

    private Boolean 消除日チェック(List<UaFt200FindShikibetsuTaishoEntity> 宛名識別対象_全件, FlexibleDate 転出期限日) {
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        Boolean flag = true;
        for (UaFt200FindShikibetsuTaishoEntity 宛名識別対象 : 宛名識別対象_全件) {
            IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
            if (!(AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)
                    ? 転出期限日.isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get消除届出年月日()))
                    : 転出期限日.isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get消除異動年月日())))) {
                flag = false;
            }
        }
        return flag;
    }

    private Boolean is増事由(IIdoJiyu 異動事由) {
        return 異動事由.equals(転入) || 異動事由.equals(特例による転入) || 異動事由.equals(出生)
                || 異動事由.equals(就籍) || 異動事由.equals(職権記載) || 異動事由.equals(帰化)
                || 異動事由.equals(国籍取得) || 異動事由.equals(住所設定) || 異動事由.equals(第30条の46届出)
                || 異動事由.equals(第30条の47届出) || 異動事由.equals(法務大臣への住居地届出);
    }

    private Boolean is減事由(IIdoJiyu 異動事由) {
        return 異動事由.equals(転出) || 異動事由.equals(特例による転出) || 異動事由.equals(転出取消)
                || 異動事由.equals(転入通知受理) || 異動事由.equals(死亡) || 異動事由.equals(職権消除)
                || 異動事由.equals(国籍喪失) || 異動事由.equals(失踪宣告);
    }

    /**
     * [定時登録バッチ処理用の判定]．帰化対象者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 年齢到達期限日 FlexibleDate
     * @return 帰化対象者かどうか
     */
    public Boolean is帰化対象者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 年齢到達期限日) {
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        return 宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(住民)
                && 宛名.to個人().get異動事由().equals(帰化)
                && this.is選挙資格年齢到達(宛名, 年齢到達期限日);
    }

    /**
     * 選挙人資格情報．登録事由コードを返す。
     *
     * @param 選挙人資格情報 SenkyoninTohyoJokyoEntity
     * @param 年齢到達期限日 FlexibleDate
     * @param 転入期限日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     * @return 選挙人資格情報．登録事由コード
     */
    public RString get新規登録事由(SenkyoninTohyoJokyoEntity 選挙人資格情報,
            FlexibleDate 転入期限日, FlexibleDate 年齢到達期限日, FlexibleDate 投票日, SenkyoShurui 選挙種類) {
        転入期限日 = toMinWhenNullOrEmpty(転入期限日);
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        投票日 = toMinWhenNullOrEmpty(投票日);
        IShikibetsuTaisho 宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity());
        int 選挙資格到達年齢 = Integer.parseInt(BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体).toString());
        if (is有権者(選挙人資格情報.getAtenaPSMEntity(), 転入期限日, 年齢到達期限日, 投票日, 選挙種類, 選挙人資格情報.getSenkyoShikakuEntity())) {
            if (宛名識別対象.to個人().get生年月日().toFlexibleDate().toString().compareToIgnoreCase(
                    年齢到達期限日.minusYear(選挙資格到達年齢).toString()) == 0) {
                return JiyuCode.年齢到達.getKey();
            }
            if (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(ConfigKeysAFA.登録年月日検索基準)
                    ? toMinWhenNullOrEmpty(宛名識別対象.to個人().get登録届出年月日()).isBeforeOrEquals(転入期限日)
                    : toMinWhenNullOrEmpty(宛名識別対象.to個人().get登録異動年月日()).isBeforeOrEquals(転入期限日)) {
                return JiyuCode.転入3カ月経過.getKey();
            }
        }
        return null;
    }

    /**
     * 選挙人資格情報．抹消事由コードを返す。
     *
     * @param 選挙人資格情報 SenkyoninTohyoJokyoEntity
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return [選挙人資格情報]．抹消事由コード
     */
    public RString get新規抹消事由(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        転出期限日 = toMinWhenNullOrEmpty(転出期限日);
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        IShikibetsuTaisho 宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity());
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        if (is抹消者(選挙人資格情報.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日)) {
            if (宛名識別対象.to個人().get消除事由().equals(死亡)) {
                return MasshoJiyuCodeEnum.死亡抹消.getValue();
            } else if (宛名識別対象.to個人().get消除事由().equals(国籍喪失)) {
                return MasshoJiyuCodeEnum.国籍喪失抹消.getValue();
            } else if (宛名識別対象.to個人().get消除事由().equals(転出)
                    && (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)
                    ? toMinWhenNullOrEmpty(宛名識別対象.to個人().get消除届出年月日()).isBefore(転出期限日)
                    : toMinWhenNullOrEmpty(宛名識別対象.to個人().get消除異動年月日()).isBefore(転出期限日))) {
                return MasshoJiyuCodeEnum.転出4カ月経過抹消.getValue();
            } else if (宛名識別対象.to個人().get消除事由().equals(職権消除)
                    && (AFAConfigKeysValue.消除年月日検索基準_消除届出年月日.isEqual(消除年月日検索基準)
                    ? toMinWhenNullOrEmpty(宛名識別対象.to個人().get消除届出年月日()).isBefore(転出期限日)
                    : toMinWhenNullOrEmpty(宛名識別対象.to個人().get消除異動年月日()).isBefore(転出期限日))) {
                return MasshoJiyuCodeEnum.職権消除4カ月経過抹消.getValue();
            }
        }
        return null;
    }

    /**
     * 選挙人資格情報．表示事由コードを返す。
     *
     * @param 選挙人資格情報 SenkyoninTohyoJokyoEntity
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @param 投票日 FlexibleDate
     * @param 前回基準日 FlexibleDate
     * @param 選挙種類 SenkyoShurui
     * @return [選挙人資格情報]．表示事由コード
     */
    public RString get新規表示事由(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日,
            FlexibleDate 投票日, FlexibleDate 前回基準日, SenkyoShurui 選挙種類) {
        転出期限日 = toMinWhenNullOrEmpty(転出期限日);
        年齢到達期限日 = toMinWhenNullOrEmpty(年齢到達期限日);
        投票日 = toMinWhenNullOrEmpty(投票日);
        前回基準日 = toMinWhenNullOrEmpty(前回基準日);
        IShikibetsuTaisho 宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity());
        if (this.is表示者(選挙人資格情報.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日, 投票日, 前回基準日, SenkyoShurui.定時登録)) {
            if (宛名識別対象.to個人().get住民状態().equals(転出者)) {
                return JiyuCode.転出.getKey();
            }
            if (宛名識別対象.to個人().get住民状態().equals(消除者)) {
                return JiyuCode.職権消除_表示.getKey();
            }
        }
        return null;
    }

    /**
     * [国民投票時登録バッチ処理用の判定]．1号資格者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 基準日 FlexibleDate
     * @param 年齢到達日 FlexibleDate
     * @return 1号資格者かどうか
     */
    public Boolean is1号資格者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 基準日, FlexibleDate 年齢到達日) {
        基準日 = toMinWhenNullOrEmpty(基準日);
        年齢到達日 = toMinWhenNullOrEmpty(年齢到達日);
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        return 宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(住民)
                && 宛名.to個人().get異動事由().equals(職権消除)
                && this.is選挙資格年齢到達_国民投票(宛名, 年齢到達日)
                && (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(ConfigKeysAFA.登録年月日検索基準)
                ? toMinWhenNullOrEmpty(宛名.to個人().get登録届出年月日()).equals(基準日)
                : toMinWhenNullOrEmpty(宛名.to個人().get登録異動年月日()).equals(基準日));
    }

    /**
     * [国民投票時登録バッチ処理用の判定]．2号資格者かどうかを返す。
     *
     * @param 宛名識別対象 UaFt200FindShikibetsuTaishoEntity
     * @param 基準日 FlexibleDate
     * @param 年齢到達日 FlexibleDate
     * @return 2号資格者かどうか
     */
    public boolean is2号資格者(UaFt200FindShikibetsuTaishoEntity 宛名識別対象, FlexibleDate 基準日, FlexibleDate 年齢到達日) {
        基準日 = toMinWhenNullOrEmpty(基準日);
        年齢到達日 = toMinWhenNullOrEmpty(年齢到達日);
        IShikibetsuTaisho 宛名 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象);
        return 宛名.to個人().get住民種別().equals(日本人)
                && 宛名.to個人().get住民状態().equals(住民)
                && this.is選挙資格年齢到達_国民投票(宛名, 年齢到達日)
                && (AFAConfigKeysValue.登録年月日検索基準_登録届出年月日.isEqual(ConfigKeysAFA.登録年月日検索基準)
                ? 基準日.plusDay(1).isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get登録届出年月日()))
                && toMinWhenNullOrEmpty(宛名.to個人().get登録届出年月日()).isBeforeOrEquals(基準日.plusDay(日_14))
                : 基準日.plusDay(1).isBeforeOrEquals(toMinWhenNullOrEmpty(宛名.to個人().get登録異動年月日()))
                && toMinWhenNullOrEmpty(宛名.to個人().get登録異動年月日()).isBeforeOrEquals(基準日.plusDay(日_14)));
    }

    private Boolean is選挙資格年齢到達(IShikibetsuTaisho 宛名, FlexibleDate 年齢到達期限日) {
        int 選挙資格到達年齢 = Integer.parseInt(BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体).toString());
        return 宛名.to個人().get生年月日().toFlexibleDate().toString().compareToIgnoreCase(
                年齢到達期限日.minusYear(選挙資格到達年齢).toString()) <= 0;
    }

    private Boolean is選挙資格年齢到達_国民投票(IShikibetsuTaisho 宛名, FlexibleDate 年齢到達期限日) {
        int 選挙資格到達年齢_国民投票
                = Integer.parseInt(BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢_国民投票, SubGyomuCode.AFA選挙本体).toString());
        return 宛名.to個人().get生年月日().toFlexibleDate().toString().compareToIgnoreCase(
                年齢到達期限日.minusYear(選挙資格到達年齢_国民投票).toString()) <= 0;
    }

    private RString padLeft(int 項目, int 文字数) {
        RString 項目RStr = new RString(String.valueOf(項目));
        return 項目RStr.padLeft(文字数);

    }

    /**
     * 名簿登録者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 前回基準日 前回基準日
     * @return 名簿登録者かどうか
     */
    public Boolean is名簿登録者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 前回基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        前回基準日 = toMinWhenNullOrEmpty(前回基準日);
        List<SenkyoninTohyoJokyoEntity> 選挙人資格情報Lst = new ArrayList<>();
        選挙人資格情報Lst.add(選挙人資格情報);

        FlexibleDate 転出期限日 = 選挙人資格情報.getSenkyoJohoEntity().getSenkyoEntity().get(0).getTenshutsuKigenYMD();
        FlexibleDate 年齢到達期限日 = 選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getKiteiNenreiTotatsuYMD();
        FlexibleDate 投票日 = 選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD();
        SenkyoShurui 選挙種類 = SenkyoShurui.toValue(選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getSenkyoShurui().value());

        return this.is有権者(選挙人資格情報.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日, 投票日, 選挙種類,
                選挙人資格情報.getSenkyoShikakuEntity())
                || this.is表示者(選挙人資格情報.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日, 投票日, 前回基準日, 選挙種類);
    }

    /**
     * 新規登録者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @param 前回基準日 前回基準日
     * @return 新規登録者かどうか
     */
    public Boolean is新規登録者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日, FlexibleDate 前回基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        前回基準日 = toMinWhenNullOrEmpty(前回基準日);
        if (is名簿登録者(選挙人資格情報, 前回基準日)) {
            RString 選挙資格到達年齢 = BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体);
            FlexibleDate 生年月日 = 選挙人資格情報.getAtenaPSMEntity().getSeinengappiYMD();
            if (生年月日 != null && !基準日.isBefore(生年月日.plusYear(Integer.valueOf(選挙資格到達年齢.toString())))) {
                return true;
            }

            FlexibleDate 登録年月日 = get登録年月日(選挙人資格情報);
            return (null != 登録年月日 && !登録年月日.isEmpty())
                    && 登録年月日.plusMonth(経過_３ヶ月).isBeforeOrEquals(基準日);
        } else {
            return false;
        }
    }

    /**
     * 死亡抹消者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 前回基準日 前回基準日
     * @return 死亡抹消者かどうか
     */
    public Boolean is死亡抹消者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 前回基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        前回基準日 = toMinWhenNullOrEmpty(前回基準日);
        Code 抹消事由コード = 選挙人資格情報.getSenkyoShikakuEntity().getMasshoJiyuCode();
        return null != 抹消事由コード
                && JiyuCode.死亡.getKey().equals(抹消事由コード.value())
                && 前回基準日.isBeforeOrEquals(選挙人資格情報.getSenkyoShikakuEntity().getMasshoYMD());
    }

    /**
     * 登録停止者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 登録停止者かどうか
     */
    public Boolean is登録停止者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 登録停止年月日 = 選挙人資格情報.getSenkyoShikakuEntity().getTorokuTeishiYMD();
        return null != 登録停止年月日 && !登録停止年月日.isEmpty() && 基準日.isBeforeOrEquals(登録停止年月日);
    }

    /**
     * 転出4ヶ月抹消者かどうか（期間指定）を返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日from 基準日from
     * @param 基準日to 基準日to
     * @return 転出4ヶ月抹消者かどうか（期間指定）
     */
    public Boolean is転出4ヶ月抹消者_期間指定(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日from, FlexibleDate 基準日to) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日from = toMinWhenNullOrEmpty(基準日from);
        基準日to = toMinWhenNullOrEmpty(基準日to);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();

        return (null != 消除年月日 && !消除年月日.isEmpty())
                && JukiIdoJiyu.転出.get異動事由コード().equals(宛名識別対象.getShojoJiyuCode())
                && 基準日from.isBefore(消除年月日)
                && 消除年月日.plusMonth(経過_４ヶ月).isBeforeOrEquals(基準日to);
    }

    /**
     * 転出4ヶ月抹消者かどうか（日付指定）を返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 転出4ヶ月抹消者かどうか（日付指定）
     */
    public Boolean is転出4ヶ月抹消者_日付指定(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();

        return (null != 消除年月日 && !消除年月日.isEmpty())
                && JukiIdoJiyu.転出.get異動事由コード().equals(宛名識別対象.getShojoJiyuCode())
                && 基準日.equals(消除年月日.plusMonth(経過_４ヶ月));
    }

    /**
     * 転出4ヶ月抹消予定者かどうか（日付指定）を返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 転出4ヶ月抹消予定者かどうか（日付指定）
     */
    public Boolean is転出4ヶ月抹消予定者_日付指定(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        //CHECKSTYLE IGNORE FileLength FOR NEXT 5 LINES
        Code 選挙資格区分 = null;
        if (選挙人資格情報.getSenkyoShikakuEntity() == null) {
            選挙資格区分 = 選挙人資格情報.getZaigaiSenkyoShikakuEntity().getShikakuKubun();
        } else {
            選挙資格区分 = 選挙人資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        }

        return (null != 消除年月日 && !消除年月日.isEmpty() && null != 選挙資格区分)
                && SennkyoSikakuKubun.表示者.value().equals(選挙資格区分.value())
                && 消除年月日.plusMonth(経過_４ヶ月).isBefore(基準日);
    }

    /**
     * 職権消除4ヶ月抹消者かどうか（期間指定）を返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日from 基準日from
     * @param 基準日to 基準日to
     * @return 職権消除4ヶ月抹消者かどうか（期間指定）
     */
    public Boolean is職権消除4ヶ月抹消者_期間指定(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日from, FlexibleDate 基準日to) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日from = toMinWhenNullOrEmpty(基準日from);
        基準日to = toMinWhenNullOrEmpty(基準日to);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();

        return (null != 消除年月日 && !消除年月日.isEmpty())
                && JukiIdoJiyu.職権消除.get異動事由コード().equals(宛名識別対象.getShojoJiyuCode())
                && 基準日from.isBefore(消除年月日)
                && 消除年月日.plusMonth(経過_４ヶ月).isBeforeOrEquals(基準日to);
    }

    /**
     * 職権消除4ヶ月抹消者かどうか（日付指定）を返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 職権消除4ヶ月抹消者かどうか（日付指定）
     */
    public Boolean is職権消除4ヶ月抹消者_日付指定(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();

        return (null != 消除年月日 && !消除年月日.isEmpty())
                && JukiIdoJiyu.職権消除.get異動事由コード().equals(宛名識別対象.getShojoJiyuCode())
                && 基準日.equals(消除年月日.plusMonth(経過_４ヶ月));
    }

    /**
     * 誤載抹消者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 誤載抹消者かどうか
     */
    public Boolean is誤載抹消者(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));

        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();
        FlexibleDate 投票年月日 = 選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD();

        return (null != 消除年月日 && !消除年月日.isEmpty())
                && (JukiIdoJiyu.職権消除.get異動事由コード().equals(宛名識別対象.getShojoJiyuCode())
                || JukiIdoJiyu.転出.get異動事由コード().equals(宛名識別対象.getShojoJiyuCode()))
                && 消除年月日.plusMonth(経過_４ヶ月).isBefore(投票年月日);
    }

    /**
     * 国籍喪失者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 国籍喪失者かどうか
     */
    public Boolean is国籍喪失者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        Code 抹消事由コード = 選挙人資格情報.getSenkyoShikakuEntity().getMasshoJiyuCode();
        return null != 抹消事由コード
                && JiyuCode.国籍喪失.getKey().equals(抹消事由コード.value())
                && 基準日.isBeforeOrEquals(選挙人資格情報.getSenkyoShikakuEntity().getMasshoYMD());
    }

    /**
     * 居住要件抹消者かどうかを返す.
     *
     * @param 転出転入日 転出転入日
     * @param 基準日 基準日
     * @return 居住要件抹消者かどうか
     */
    public Boolean is居住要件抹消者(List<FlexibleDate> 転出転入日, FlexibleDate 基準日) {
        FlexibleDate 転出日 = 転出転入日.get(0);
        FlexibleDate 転入日 = 転出転入日.get(1);
        return !FlexibleDate.EMPTY.equals(転出日) && !FlexibleDate.EMPTY.equals(転入日)
                && 転出日.plusMonth(経過_４ヶ月).isBeforeOrEquals(基準日) && 基準日.isBefore(転入日.plusMonth(経過_３ヶ月));
    }

    /**
     * 基準日前異動抹消者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 基準日前異動抹消者かどうか
     */
    public Boolean is基準日前異動抹消者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 抹消年月日 = 選挙人資格情報.getSenkyoShikakuEntity().getMasshoYMD();
        Code 選挙資格区分 = 選挙人資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        return null != 抹消年月日 && !抹消年月日.isEmpty()
                && null != 選挙資格区分
                && SennkyoSikakuKubun.抹消者.value().equals(選挙資格区分.value())
                && 抹消年月日.isBefore(基準日);

    }

    /**
     * その他抹消者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return その他抹消者かどうか
     */
    public Boolean isその他抹消者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 抹消年月日 = 選挙人資格情報.getSenkyoShikakuEntity().getMasshoYMD();
        Code 抹消事由コード = 選挙人資格情報.getSenkyoShikakuEntity().getMasshoJiyuCode();
        return null != 抹消年月日 && !抹消年月日.isEmpty()
                && null != 抹消事由コード
                && JiyuCode.その他_抹消.getKey().equals(抹消事由コード.value())
                && 基準日.isBeforeOrEquals(抹消年月日);
    }

    /**
     * 法11条関連者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 法11条関連者かどうか
     */
    public Boolean is法11条関連者(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));

        Code 表示事由コード = 選挙人資格情報.getSenkyoShikakuEntity().getHyojiJiyuCode();
        RString 表示事由コードString = RString.EMPTY;
        if (null != 表示事由コード) {
            表示事由コードString = 表示事由コード.value();
        }
        Code 選挙資格区分 = 選挙人資格情報.getSenkyoShikakuEntity().getShikakuKubun();

        return null != 選挙資格区分
                && SennkyoSikakuKubun.表示者.value().equals(選挙資格区分.value())
                && (表示事由コードString.equals(new RString("12"))
                || 表示事由コードString.equals(new RString("13"))
                || 表示事由コードString.equals(new RString("14"))
                || 表示事由コードString.equals(new RString("15"))
                || 表示事由コードString.equals(new RString("20")));

    }

    /**
     * 二重登録者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 二重登録者かどうか
     */
    public Boolean is二重登録者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 登録年月日 = get登録年月日(選挙人資格情報);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();

        if ((null != 消除年月日 && !消除年月日.isEmpty())
                && JukiIdoJiyu.転出.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())
                && 消除年月日.plusMonth(経過_３ヶ月).isBeforeOrEquals(基準日)
                && 基準日.isBefore(消除年月日.plusMonth(経過_４ヶ月))) {
            return true;
        }

        if ((null != 登録年月日 && !登録年月日.isEmpty())
                && JukiIdoJiyu.転入.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())
                && 登録年月日.plusMonth(経過_３ヶ月).isBeforeOrEquals(基準日)
                && 基準日.isBefore(登録年月日.plusMonth(経過_４ヶ月))) {
            return true;
        }

        return false;

    }

    /**
     * 失権失格者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 失権失格者かどうか
     */
    public Boolean is失権失格者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 登録年月日 = get登録年月日(選挙人資格情報);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        if (登録年月日 == null || 基準日 == null) {
            return Boolean.FALSE;
        }
        return (消除年月日 != null && !消除年月日.isEmpty())
                && 消除年月日.plusMonth(経過_１ヶ月).isBefore(登録年月日)
                && 消除年月日.plusMonth(経過_４ヶ月).isBeforeOrEquals(基準日);
    }

    /**
     * 選挙期日登録者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 投票日 投票日
     * @return 選挙期日登録者かどうか
     */
    public Boolean is選挙期日登録者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 投票日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        投票日 = toMinWhenNullOrEmpty(投票日);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();

        if (消除年月日 == null || 消除年月日.isEmpty()) {
            return false;
        }
        if (JukiIdoJiyu.転出.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())) {
            return 消除年月日.plusMonth(経過_４ヶ月).isBefore(投票日);
        } else if (JukiIdoJiyu.職権消除.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())) {
            return 消除年月日.plusMonth(経過_４ヶ月).isBefore(投票日);
        } else if (JukiIdoJiyu.死亡.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())) {
            return 消除年月日.isBefore(投票日);
        } else if (JukiIdoJiyu.国籍喪失.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())) {
            return 消除年月日.isBefore(投票日);
        }
        return false;
    }

    /**
     * 都道府県内転出者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 都道府県内転出者かどうか
     */
    public Boolean is都道府県内転出者(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();
        ZenkokuJushoCode 本籍全国住所コード = 宛名識別対象.getHonsekiZenkokuJushoCode();
        ZenkokuJushoCode 全国住所コード = 宛名識別対象.getZenkokuJushoCode();

        return null == 本籍全国住所コード || null == 全国住所コード || 本籍全国住所コード.isEmpty() || 全国住所コード.isEmpty() ? false
                : JukiIdoJiyu.転出.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())
                && 本籍全国住所コード.getTodofukenCode().equals(全国住所コード.getTodofukenCode());
    }

    /**
     * 都道府県外転出者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 都道府県外転出者かどうか
     */
    public Boolean is都道府県外転出者(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();
        ZenkokuJushoCode 本籍全国住所コード = 宛名識別対象.getHonsekiZenkokuJushoCode();
        ZenkokuJushoCode 全国住所コード = 宛名識別対象.getZenkokuJushoCode();

        return null == 本籍全国住所コード || null == 全国住所コード || 本籍全国住所コード.isEmpty() || 全国住所コード.isEmpty() ? false
                : JukiIdoJiyu.転出.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())
                && !本籍全国住所コード.getTodofukenCode().equals(全国住所コード.getTodofukenCode());
    }

    /**
     * 国外転出者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 国外転出者かどうか
     */
    public Boolean is国外転出者(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();
        ZenkokuJushoCode 全国住所コード = 宛名識別対象.getZenkokuJushoCode();

        return null == 全国住所コード || 全国住所コード.isEmpty() ? false : JukiIdoJiyu.転出.get異動事由コード().equals(宛名識別対象.getIdoJiyuCode())
                && 国外転出者_全国住所コードの上2桁.equals(全国住所コード.getTodofukenCode());
    }

    /**
     * 転出者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 転出者かどうか
     */
    public Boolean is転出者(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        return JukiIdoJiyu.転出.get異動事由コード().equals(選挙人資格情報.getAtenaPSMEntity().getIdoJiyuCode());
    }

    /**
     * 転出表示区分を返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 転出表示区分
     */
    public Code get転出表示区分(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        if (is都道府県内転出者(選挙人資格情報)) {
            return new Code(TenshutuHyoujiKubun.県内転出.value());
        } else if (is都道府県外転出者(選挙人資格情報)) {
            return new Code(TenshutuHyoujiKubun.県外転出.value());

        } else if (is国外転出者(選挙人資格情報)) {
            return new Code(TenshutuHyoujiKubun.国外転出.value());
        } else {
            return new Code(TenshutuHyoujiKubun.不明.value());
        }
    }

    /**
     * 職権消除者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 職権消除者かどうか
     */
    public Boolean is職権消除者(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        return JukiIdoJiyu.職権消除.get異動事由コード().equals(選挙人資格情報.getAtenaPSMEntity().getIdoJiyuCode());
    }

    /**
     * 加算有権者_抹消かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 投票状況情報 投票状況情報
     * @return 加算有権者_抹消かどうか
     */
    public Boolean is加算有権者_抹消(SenkyoninTohyoJokyoEntity 選挙人資格情報, TohyoJokyoJohoEntity 投票状況情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        requireNonNull(投票状況情報, UrSystemErrorMessages.値がnull.getReplacedMessage("投票状況情報"));
        List<SenkyoninTohyoJokyoEntity> 選挙人資格情報Lst = new ArrayList<>();
        選挙人資格情報Lst.add(選挙人資格情報);

        FlexibleDate 転出期限日 = 選挙人資格情報.getSenkyoJohoEntity().getSenkyoEntity().get(0).getTenshutsuKigenYMD();
        FlexibleDate 年齢到達期限日 = 選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getKiteiNenreiTotatsuYMD();
        Code 投票状況 = 投票状況情報.getTohyoJokyoEntity().getTohyoJokyo();

        return this.is抹消者(選挙人資格情報.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日)
                && null != 投票状況
                && TohyoJokyo.期日前.getCode().equals(投票状況.value());
    }

    /**
     * 加算有権者_失権かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 投票状況情報 投票状況情報
     * @return 加算有権者_失権かどうか
     */
    public Boolean is加算有権者_失権(SenkyoninTohyoJokyoEntity 選挙人資格情報, TohyoJokyoJohoEntity 投票状況情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        requireNonNull(投票状況情報, UrSystemErrorMessages.値がnull.getReplacedMessage("投票状況情報"));

        FlexibleDate 投票年月日 = 選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD();
        if (null == 投票年月日) {
            return Boolean.FALSE;
        } else {
            if (is失権失格者(選挙人資格情報, 投票年月日)) {
                Code 投票状況 = 投票状況情報.getTohyoJokyoEntity().getTohyoJokyo();
                return null != 投票状況 && TohyoJokyo.期日前.getCode().equals(投票状況.value());
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 加算有権者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 投票状況情報 投票状況情報
     * @return 加算有権者かどうか
     */
    public Boolean is加算有権者(SenkyoninTohyoJokyoEntity 選挙人資格情報, TohyoJokyoJohoEntity 投票状況情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        requireNonNull(投票状況情報, UrSystemErrorMessages.値がnull.getReplacedMessage("投票状況情報"));
        return is加算有権者_抹消(選挙人資格情報, 投票状況情報) || is加算有権者_失権(選挙人資格情報, 投票状況情報);
    }

    /**
     * 当日有権者かどうかを返す.
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 投票状況情報 投票状況情報
     * @param 前回基準日 前回基準日
     * @return 当日有権者かどうか
     */
    public Boolean is当日有権者(SenkyoninTohyoJokyoEntity 選挙人資格情報, TohyoJokyoJohoEntity 投票状況情報, FlexibleDate 前回基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        requireNonNull(投票状況情報, UrSystemErrorMessages.値がnull.getReplacedMessage("投票状況情報"));
        前回基準日 = toMinWhenNullOrEmpty(前回基準日);
        List<SenkyoninTohyoJokyoEntity> 選挙人資格情報Lst = new ArrayList<>();
        選挙人資格情報Lst.add(選挙人資格情報);

        FlexibleDate 転出期限日 = 選挙人資格情報.getSenkyoJohoEntity().getSenkyoEntity().get(0).getTenshutsuKigenYMD();
        FlexibleDate 年齢到達期限日 = 選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getKiteiNenreiTotatsuYMD();
        FlexibleDate 投票日 = 選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD();
        SenkyoShurui 選挙種類 = SenkyoShurui.toValue(選挙人資格情報.getSenkyoJohoEntity().getShohonEntity().getSenkyoShurui().value());

        return this.is有権者(選挙人資格情報.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日, 投票日, 選挙種類,
                選挙人資格情報.getSenkyoShikakuEntity())
                || this.is表示者(選挙人資格情報.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日, 投票日, 前回基準日, 選挙種類)
                || is加算有権者_抹消(選挙人資格情報, 投票状況情報)
                || is加算有権者_失権(選挙人資格情報, 投票状況情報);
    }

    /**
     * 次回年齢到達予定者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 次回年齢到達予定者かどうか
     */
    public Boolean is次回年齢到達予定者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 一番近い未来の1日 = get一番近い未来の1日(基準日);
        FlexibleDate 生年月日 = 選挙人資格情報.getAtenaPSMEntity().getSeinengappiYMD();
        RString 規定年齢Config値 = BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体);
        return null != 生年月日 && !生年月日.isEmpty()
                && 一番近い未来の1日.isBeforeOrEquals(生年月日.plusYear(Integer.valueOf(規定年齢Config値.toString())));

    }

    /**
     * 年齢未到達登録者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 年齢未到達登録者かどうか
     */
    public Boolean is年齢未到達登録者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 一番近い未来の1日 = get一番近い未来の1日(基準日);
        FlexibleDate 生年月日 = 選挙人資格情報.getAtenaPSMEntity().getSeinengappiYMD();
        Code 選挙資格区分 = 選挙人資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        RString 規定年齢Config値 = BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, SubGyomuCode.AFA選挙本体);
        return null != 生年月日 && !生年月日.isEmpty()
                && null != 選挙資格区分
                && 生年月日.plusYear(Integer.valueOf(規定年齢Config値.toString())).isBefore(一番近い未来の1日)
                && (SennkyoSikakuKubun.有権者.value().equals(選挙資格区分.value())
                || SennkyoSikakuKubun.表示者.value().equals(選挙資格区分.value()));
    }

    /**
     * 1号資格者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 1号資格者かどうか
     */
    public Boolean is1号資格者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 消除年月日 = get消除年月日(選挙人資格情報);
        FlexibleDate 登録年月日 = get登録年月日(選挙人資格情報);

        return 登録年月日.isBeforeOrEquals(基準日)
                && (null == 消除年月日 || 消除年月日.isEmpty() || 基準日.isBefore(消除年月日));
    }

    /**
     * 2号資格者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 2号資格者かどうか
     */
    public Boolean is2号資格者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        FlexibleDate 登録年月日 = get登録年月日(選挙人資格情報);
        return 基準日.isBefore(登録年月日)
                && 登録年月日.isBeforeOrEquals(基準日.plusDay(経過_1４ヶ日));
    }

    /**
     * 抄本グループコードかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @return 抄本グループコード
     */
    public Code get抄本グループコード(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        RString 居住 = BusinessConfig.get(ConfigKeysAFA.抄本_グループコード, SubGyomuCode.AFA選挙本体);

        IShikibetsuTaisho 住民 = ShikibetsuTaishoFactory.createShikibetsuTaisho(選挙人資格情報.getAtenaPSMEntity());
        if (居住.equals(抄本_グループコード_居住区分毎.getValue())) {
            if (住民.get住民種別().equals(日本人)) {
                return new Code("1");
            } else {
                return new Code("2");
            }
        } else if (居住.equals(抄本_グループコード_資格区分毎.getValue())) {
            return 選挙人資格情報.getSenkyoShikakuEntity().getShikakuKubun();
        } else {
            return Code.EMPTY;
        }
    }

    /**
     * 表示消除者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @return 表示消除者かどうか
     */
    public Boolean is表示消除者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        return 基準日.equals(選挙人資格情報.getSenkyoShikakuEntity().getHyojiShojoYMD());
    }

    /**
     * 表示消除予定者かどうかを返す。
     *
     * @param 選挙人資格情報 選挙人資格情報
     * @param 基準日 基準日
     * @param 投票日 投票日
     * @return 表示消除予定者かどうか
     */
    public Boolean is表示消除予定者(SenkyoninTohyoJokyoEntity 選挙人資格情報, FlexibleDate 基準日, FlexibleDate 投票日) {
        requireNonNull(選挙人資格情報, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙人資格情報"));
        基準日 = toMinWhenNullOrEmpty(基準日);
        投票日 = toMinWhenNullOrEmpty(投票日);
        FlexibleDate 登録異動年月日 = 選挙人資格情報.getAtenaPSMEntity().getTorokuIdoYMD();
        return null != 登録異動年月日 && !登録異動年月日.isEmpty()
                && 基準日.isBeforeOrEquals(登録異動年月日.plusMonth(経過_３ヶ月))
                && 登録異動年月日.plusMonth(経過_３ヶ月).isBeforeOrEquals(投票日);
    }

    private FlexibleDate get消除年月日(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        FlexibleDate 消除年月日 = FlexibleDate.EMPTY;
        RString 消除年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();
        if (YMDKensakuKijunConfig.消除届出年月日.getValue().equals(消除年月日検索基準)) {
            消除年月日 = 宛名識別対象.getShojoTodokedeYMD();
        } else if (YMDKensakuKijunConfig.消除異動年月日.getValue().equals(消除年月日検索基準)) {
            消除年月日 = 宛名識別対象.getShojoIdoYMD();
        }
        return 消除年月日;
    }

    private FlexibleDate get登録年月日(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        FlexibleDate 登録年月日 = FlexibleDate.EMPTY;
        RString 登録年月日検索基準Config = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象 = 選挙人資格情報.getAtenaPSMEntity();
        if (YMDKensakuKijunConfig.登録届出年月日.getValue().equals(登録年月日検索基準Config)) {
            登録年月日 = 宛名識別対象.getTorokuTodokedeYMD();
        } else if (YMDKensakuKijunConfig.登録異動年月日.getValue().equals(登録年月日検索基準Config)) {
            登録年月日 = 宛名識別対象.getTorokuIdoYMD();
        }
        return 登録年月日;
    }

    private FlexibleDate get一番近い未来の1日(FlexibleDate 基準日) {
        基準日 = toMinWhenNullOrEmpty(基準日);
        int 基準月 = 基準日.getMonthValue();

        if (基準日.getDayValue() == 基準日_1日
                && (基準月 == 基準月_3月
                || 基準月 == 基準月_6月
                || 基準月 == 基準月_9月
                || 基準月 == 基準月_12月)) {
            switch (基準月) {
                case 基準月_3月:
                    基準日 = new FlexibleDate(基準日.getYearValue(), 基準月_6月, 基準日_1日);
                    break;
                case 基準月_6月:
                    基準日 = new FlexibleDate(基準日.getYearValue(), 基準月_9月, 基準日_1日);
                    break;
                case 基準月_9月:
                    基準日 = new FlexibleDate(基準日.getYearValue(), 基準月_12月, 基準日_1日);
                    break;
                case 基準月_12月:
                    基準日 = new FlexibleDate(基準日.getYearValue() + 1, 基準月_3月, 基準日_1日);
                    break;
                default:
            }
            return 基準日;
        }

        if (基準日.getMonthValue() >= 基準月_9月) {
            return new FlexibleDate(基準日.getYearValue(), 基準月_12月, 基準日_1日);
        } else if (基準日.getMonthValue() >= 基準月_6月) {
            return new FlexibleDate(基準日.getYearValue(), 基準月_9月, 基準日_1日);
        } else if (基準日.getMonthValue() >= 基準月_3月) {
            return new FlexibleDate(基準日.getYearValue(), 基準月_6月, 基準日_1日);
        } else {
            return new FlexibleDate(基準日.getYearValue(), 基準月_3月, 基準日_1日);
        }
    }

    private FlexibleDate toMinWhenNullOrEmpty(FlexibleDate date) {
        if (null == date || date.isEmpty()) {
            return FlexibleDate.MIN;
        }
        return date;
    }

    private Boolean isNullOrEmpty(FlexibleDate date) {
        return null == date || date.isEmpty();
    }

}
