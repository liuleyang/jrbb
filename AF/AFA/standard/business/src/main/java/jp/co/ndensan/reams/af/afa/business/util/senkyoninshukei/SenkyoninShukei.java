/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.util.senkyoninshukei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.SenkyoninTohyoJokyoSearchResult;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.SyukeiJyouken;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.TohyoJokyoJohoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 選挙人集計
 *
 * @reamsid_L AF-0010-032 wangm
 */
public class SenkyoninShukei {

    private final ShikakuHantei 資格判定;
//    private AfT201TohyoJokyoEntity 投票状況Entity;
    private static final int 零歳 = 0;
    private static final int 十歳 = 10;
    private static final int 二十歳 = 20;
    private static final int 三十歳 = 30;
    private static final int 四十歳 = 40;
    private static final int 五十歳 = 50;
    private static final int 六十歳 = 60;
    private static final int 七十歳 = 70;
    private static final int 八十歳 = 80;
    private static final int 九十歳 = 90;
    private static final int 百歳 = 100;

    /**
     * コンストラクタです。
     *
     */
    public SenkyoninShukei() {
        this.資格判定 = new ShikakuHantei();
    }

    /**
     * 登録者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 前回基準日 前回基準日
     * @return 登録者の人数 int
     */
    public int count登録者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日,
            SyukeiJyouken 集計条件, FlexibleDate 前回基準日) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is名簿登録者(entity, 前回基準日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 登録者の人数を返す
     *
     * @param 選挙人資格 List<SenkyoninTohyoJokyoSearchResult>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 前回基準日 前回基準日
     * @return 登録者の人数 int
     */
    public int count登録者数BySearchResult(List<SenkyoninTohyoJokyoSearchResult> 選挙人資格, FlexibleDate 基準日,
            SyukeiJyouken 集計条件, FlexibleDate 前回基準日) {
        return count登録者数(convertSearchResultToEntity(選挙人資格), 基準日, 集計条件, 前回基準日);
    }

    /**
     * 有権者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return 有権者の人数
     */
    public int count有権者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is有権者(entity.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日,
                    entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD(),
                    SenkyoShurui.toValue(entity.getSenkyoJohoEntity().getShohonEntity().getSenkyoShurui().value()),
                    entity.getSenkyoShikakuEntity())) {
                count++;
            }
        }

        return count;
    }

    /**
     * 表示者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @param 前回基準日 FlexibleDate
     * @return 表示者の人数
     */
    public int count表示者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日, FlexibleDate 前回基準日) {
        int count = 0;

        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is表示者(entity.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日, 前回基準日,
                    entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD(),
                    SenkyoShurui.toValue(entity.getSenkyoJohoEntity().getShohonEntity().getSenkyoShurui().value()))) {
                count++;
            }
        }

        return count;
    }

    /**
     * 公民権停止者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 年齢到達期限日 FlexibleDate
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 公民権停止者の人数
     */
    public int count公民権停止者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 年齢到達期限日,
            FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件)
                    && 資格判定.is公民権停止者(entity.getAtenaPSMEntity(), entity.getSenkyoShikakuEntity(), 年齢到達期限日, 基準日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 新規登録者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 前回基準日 前回基準日
     * @return 新規登録者の人数
     */
    public int count新規登録者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日,
            SyukeiJyouken 集計条件, FlexibleDate 前回基準日) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is新規登録者(entity, 基準日, 前回基準日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 死亡者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return 死亡者の人数
     */
    public int count死亡者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is抹消者(entity.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日)
                    && new ShikakuHantei.ShikakuHanteiWithInfo(Arrays.asList(entity))
                    .get抹消事由(entity.getAtenaPSMEntity().getShikibetsuCode()).value().equals(JiyuCode.死亡.getKey())) {
                count++;
            }
        }
        return count;
    }

    /**
     * 国籍喪失者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return t国籍喪失者の人数
     */
    public int count国籍喪失者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        int count = 0;

        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is抹消者(entity.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日)
                    && new ShikakuHantei.ShikakuHanteiWithInfo(Arrays.asList(entity))
                    .get抹消事由(entity.getAtenaPSMEntity().getShikibetsuCode()).value().equals(JiyuCode.国籍喪失.getKey())) {
                count++;
            }
        }
        return count;
    }

    /**
     * ４ヶ月抹消者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return ４ヶ月抹消者の人数
     */
    public int count４ヶ月抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        int count = count前日までの４ヶ月抹消者数(選挙人資格リスト, 基準日, 集計条件, 転出期限日, 年齢到達期限日)
                + count当日４ヶ月抹消者数(選挙人資格リスト, 基準日, 集計条件, 転出期限日, 年齢到達期限日);
        return count;
    }

    /**
     * 投票日前日までに４ヶ月抹消になる人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return 投票日前日までに４ヶ月抹消になる人数
     */
    public int count前日までの４ヶ月抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        int count = 0;

        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is抹消者(entity.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日)
                    && Arrays.asList(JiyuCode.誤載.getKey(), JiyuCode.職権消除.getKey())
                    .contains(new ShikakuHantei.ShikakuHanteiWithInfo(Arrays.asList(entity))
                            .get抹消事由(entity.getAtenaPSMEntity().getShikibetsuCode()).value())
                    && 基準日.isBeforeOrEquals(entity.getSenkyoShikakuEntity().getMasshoYMD())
                    && NullHandler.getNullToFlexibleDate(entity.getSenkyoShikakuEntity().getMasshoYMD()).isBefore(
                            NullHandler.getNullToFlexibleDate(entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD()))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 投票日当日に４ヶ月抹消になる人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return 投票日当日に４ヶ月抹消になる人数
     */
    public int count当日４ヶ月抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        int count = 0;

        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is抹消者(entity.getAtenaPSMEntity(), 転出期限日, 年齢到達期限日)
                    && Arrays.asList(JiyuCode.誤載.getKey(), JiyuCode.職権消除.getKey())
                    .contains(new ShikakuHantei.ShikakuHanteiWithInfo(Arrays.asList(entity))
                            .get抹消事由(entity.getAtenaPSMEntity().getShikibetsuCode()).value())
                    && NullHandler.getNullToFlexibleDate(entity.getSenkyoShikakuEntity().getMasshoYMD()).equals(
                            NullHandler.getNullToFlexibleDate(entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD()))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 職権消除4ヶ月抹消者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 職権消除4ヶ月抹消者の人数
     */
    public int count職権消除4ヶ月抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is職権消除4ヶ月抹消者_日付指定(entity, 基準日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 転出4ヶ月抹消者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 転出4ヶ月抹消者の人数
     */
    public int count転出4ヶ月抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is転出4ヶ月抹消者_日付指定(entity, 基準日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 基準日前異動抹消者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 基準日前異動抹消者の人数
     */
    public int count基準日前異動抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is基準日前異動抹消者(entity, 基準日)) {
                count++;
            }
        }

        return count;
    }

    /**
     * 誤載抹消者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 誤載抹消者の人数
     */
    public int count誤載抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is誤載抹消者(entity)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 抹消者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return 抹消者の人数
     */
    public int count抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        int count = 0;
        if (BusinessConfig.get(ConfigKeysAFA.二重登録抹消者集計判定区分, SubGyomuCode.AFA選挙本体).equals(new RString("1"))) {
            count = count死亡者数(選挙人資格リスト, 集計条件, 転出期限日, 年齢到達期限日)
                    + count前日までの４ヶ月抹消者数(選挙人資格リスト, 基準日, 集計条件, 転出期限日, 年齢到達期限日)
                    + count誤載抹消者数(選挙人資格リスト, 基準日, 集計条件);
        } else if (BusinessConfig.get(ConfigKeysAFA.二重登録抹消者集計判定区分, SubGyomuCode.AFA選挙本体).equals(new RString("2"))) {
            count = count死亡者数(選挙人資格リスト, 集計条件, 転出期限日, 年齢到達期限日)
                    + count４ヶ月抹消者数(選挙人資格リスト, 基準日, 集計条件, 転出期限日, 年齢到達期限日);
        }
        return count;
    }

    /**
     * 法11条関連者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 表示事由コード RString
     * @return 法11条関連者の人数
     */
    public int count法11条関連者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            RString 表示事由コード) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is法11条関連者(entity)) {
                if (RString.isNullOrEmpty(表示事由コード)) {
                    count++;
                } else {
                    if (表示事由コード.equals(NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode()))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 二重登録者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 二重登録者の人数
     */
    public int count二重登録者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is二重登録者(entity, 基準日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 居住要件抹消者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 転出転入日 List<FlexibleDate>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 居住要件抹消者の人数
     */
    public int count居住要件抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, List<FlexibleDate> 転出転入日,
            FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        if (選挙人資格リスト != null) {
            for (int i = 0; i < 選挙人資格リスト.size(); i++) {
                SenkyoninTohyoJokyoEntity entity = 選挙人資格リスト.get(i);
                List<FlexibleDate> sub転出転入日 = new ArrayList<>();
                sub転出転入日.add(転出転入日.get(i * 2));
                sub転出転入日.add(転出転入日.get(i * 2 + 1));
                if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is居住要件抹消者(sub転出転入日, 基準日)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * その他抹消者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return その他抹消者の人数
     */
    public int countその他抹消者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.isその他抹消者(entity, 基準日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 転出者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 転出表示区分 RString
     * @return 転出者の人数
     */
    public int count転出者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件, RString 転出表示区分) {
        int count = 0;
        if (RString.isNullOrEmpty(転出表示区分)) {
            for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
                if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is転出者(entity)) {
                    count++;
                }
            }
        } else {
            for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
                if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is都道府県内転出者(entity) || 資格判定.is都道府県外転出者(entity)
                        || 資格判定.is国外転出者(entity) || (資格判定.is転出者(entity) && !資格判定.is都道府県内転出者(entity)
                        && !資格判定.is都道府県外転出者(entity) && !資格判定.is国外転出者(entity))) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 職権修正の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 職権修正の人数
     */
    public int count職権修正者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日,
            FlexibleDate 年齢到達期限日, SyukeiJyouken 集計条件) {
        int count = 0;

        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is職権修正者(entity.getAtenaPSMEntity(), 年齢到達期限日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 加算有権者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 加算有権者の人数
     */
    public int count加算有権者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            Map<Integer, AfT201TohyoJokyoEntity> 投票状況 = this.get投票状況(entity);
            if (this.is集計条件別適合(entity, 集計条件)) {
                for (AfT111SenkyoEntity newEntity : entity.getSenkyoJohoEntity().getSenkyoEntity()) {
                    if (null == 投票状況.get(newEntity.getShohonNo().value()) ? false : 資格判定.is加算有権者(entity,
                            new TohyoJokyoJohoEntity(投票状況.get(newEntity.getShohonNo().value())))) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 加算有権者（抹消者）の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 加算有権者（抹消者）の人数
     */
    public int count加算有権者_抹消者_数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            Map<Integer, AfT201TohyoJokyoEntity> 投票状況 = this.get投票状況(entity);
            if (this.is集計条件別適合(entity, 集計条件)) {
                for (AfT111SenkyoEntity newEntity : entity.getSenkyoJohoEntity().getSenkyoEntity()) {
                    if (null == 投票状況.get(newEntity.getShohonNo().value()) ? false : 資格判定.is加算有権者_抹消(entity,
                            new TohyoJokyoJohoEntity(投票状況.get(newEntity.getShohonNo().value())))) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 加算有権者（失権者）の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 加算有権者（失権者）の人数
     */
    public int count加算有権者_失権者_数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            Map<Integer, AfT201TohyoJokyoEntity> 投票状況 = this.get投票状況(entity);
            if (this.is集計条件別適合(entity, 集計条件)) {
                for (AfT111SenkyoEntity newEntity : entity.getSenkyoJohoEntity().getSenkyoEntity()) {
                    if (null == 投票状況.get(newEntity.getShohonNo().value()) ? false : 資格判定.is加算有権者_失権(entity,
                            new TohyoJokyoJohoEntity(投票状況.get(newEntity.getShohonNo().value())))) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 当日有権者数の人数を返す
     *
     * @param 選挙人資格 List<SenkyoninTohyoJokyoSearchResult>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 前回基準日 FlexibleDate
     * @return 当日有権者数の人数
     */
    public int count当日有権者数BySearchResult(List<SenkyoninTohyoJokyoSearchResult> 選挙人資格, FlexibleDate 基準日,
            SyukeiJyouken 集計条件, FlexibleDate 前回基準日) {
        return count当日有権者数(convertSearchResultToEntity(選挙人資格), 基準日, 集計条件, 前回基準日);
    }

    /**
     * 当日有権者数の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 前回基準日 FlexibleDate
     * @return 当日有権者数の人数
     */
    public int count当日有権者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日,
            SyukeiJyouken 集計条件, FlexibleDate 前回基準日) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            Map<Integer, AfT201TohyoJokyoEntity> 投票状況 = this.get投票状況(entity);
            if (this.is集計条件別適合(entity, 集計条件)) {
                for (AfT111SenkyoEntity newEntity : entity.getSenkyoJohoEntity().getSenkyoEntity()) {
                    if (null == 投票状況.get(newEntity.getShohonNo().value()) ? false : 資格判定.is当日有権者(entity,
                            new TohyoJokyoJohoEntity(投票状況.get(newEntity.getShohonNo().value())), 前回基準日)) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 失権失格者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @return 失権失格者の人数
     */
    public int count失権失格者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is失権失格者(entity, 基準日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 選挙期日登録者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 転出期限日 FlexibleDate
     * @param 年齢到達期限日 FlexibleDate
     * @param 前回基準日 前回基準日
     * @return 選挙期日登録者の人数
     */
    public int count選挙期日登録者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            FlexibleDate 転出期限日, FlexibleDate 年齢到達期限日, FlexibleDate 前回基準日) {
        int count = count登録者数(選挙人資格リスト, 基準日, 集計条件, 前回基準日)
                + count新規登録者数(選挙人資格リスト, 基準日, 集計条件, 前回基準日)
                - count抹消者数(選挙人資格リスト, 基準日, 集計条件, 転出期限日, 年齢到達期限日);
        return count;
    }

    /**
     * 投票状況別の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 集計基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 投票状況 RString
     * @return 投票状況別の人数
     */
    public List<Integer> count状況別投票人数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 集計基準日,
            SyukeiJyouken 集計条件, RString 投票状況) {
        int count_基準日まで = 0;
        int count_基準日当日 = 0;
        List<Integer> 状況別投票人数 = new ArrayList<>();
//        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
//            if (this.is集計条件別適合(entity, 集計条件)) {
//                for (AfT201TohyoJokyoEntity newEntity : entity.getTohyoJokyoEntityList()) {
//                    if (RString.isNullOrEmpty(投票状況) ? true : this.is投票状況同じ(entity, 投票状況)
//                            && null == 投票状況Entity ? false : toMinWhenNullOrEmpty(投票状況Entity.getJuriYMD()).isBeforeOrEquals(集計基準日)) {
//                        count_基準日まで++;
//                        if (null == 投票状況Entity ? false : toMinWhenNullOrEmpty(投票状況Entity.getJuriYMD()).equals(集計基準日)) {
//                            count_基準日当日++;
//                        }
//                        break;
//                    }
//                }
//            }
//        }
        状況別投票人数.add(count_基準日まで);
        状況別投票人数.add(count_基準日当日);
        return 状況別投票人数;
    }

//    private Boolean is投票状況同じ(SenkyoninTohyoJokyoEntity entity, RString 投票状況) {
//        for (AfT201TohyoJokyoEntity tohyoJokyoEntity : entity.getTohyoJokyoEntityList()) {
//            if (NullHandler.getNullToRString(tohyoJokyoEntity.getTohyoJokyo()).equals(投票状況)) {
//                投票状況Entity = tohyoJokyoEntity;
//                return true;
//            }
//        }
//        return false;
//    }
    /**
     * 投票事由別の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 集計基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 投票事由コード RString
     * @return 投票事由別の人数
     */
    public List<Integer> count事由別投票人数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 集計基準日,
            SyukeiJyouken 集計条件, RString 投票事由コード) {
        int count_基準日まで = 0;
        int count_基準日当日 = 0;
        List<Integer> 事由別投票人数 = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件)) {
                for (AfT201TohyoJokyoEntity newEntity : entity.getTohyoJokyoEntityList()) {
                    if (RString.isNullOrEmpty(投票事由コード) ? true : NullHandler.getNullToRString(newEntity.getTohyoJiyuCode()).equals(投票事由コード)
                            && toMinWhenNullOrEmpty(entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD()).isBeforeOrEquals(集計基準日)) {
                        count_基準日まで++;
//                        if (toMinWhenNullOrEmpty(entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD()).equals(集計基準日)) {
//                            count_基準日当日++;
//                        }
                        break;
                    }
                }
            }
        }
        事由別投票人数.add(count_基準日まで);
        事由別投票人数.add(count_基準日当日);
        return 事由別投票人数;
    }

    /**
     * 代理投票の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 代理投票の人数
     */
    public List<Integer> count代理投票人数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count_基準日まで = 0;
        int count_基準日当日 = 0;
        List<Integer> 代理投票人数 = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件)) {
                for (AfT201TohyoJokyoEntity newEntity : entity.getTohyoJokyoEntityList()) {
                    if (newEntity.getDairiTohyoAriFlag() && toMinWhenNullOrEmpty(entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD())
                            .isBeforeOrEquals(基準日)) {
                        count_基準日まで++;
//                        if (toMinWhenNullOrEmpty(entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD()).equals(基準日)) {
//                            count_基準日当日++;
//                        }
                        break;
                    }
                }
            }
        }
        代理投票人数.add(count_基準日まで);
        代理投票人数.add(count_基準日当日);
        return 代理投票人数;
    }

    /**
     * 点字投票の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @return 点字投票の人数
     */
    public List<Integer> count点字投票人数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件) {
        int count_基準日まで = 0;
        int count_基準日当日 = 0;
        List<Integer> 点字投票人数 = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件)) {
                for (AfT201TohyoJokyoEntity newEntity : entity.getTohyoJokyoEntityList()) {
                    if (newEntity.getTenjiFlag() && toMinWhenNullOrEmpty(entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD())
                            .isBeforeOrEquals(基準日)) {
                        count_基準日まで++;
//                        if (toMinWhenNullOrEmpty(entity.getSenkyoJohoEntity().getShohonEntity().getTohyoYMD()).equals(基準日)) {
//                            count_基準日当日++;
//                        }
                        break;
                    }
                }
            }
        }
        点字投票人数.add(count_基準日まで);
        点字投票人数.add(count_基準日当日);
        return 点字投票人数;
    }

    /**
     * 1号資格者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 年齢到達期限日 FlexibleDate
     * @return 1号資格者の人数
     */
    public int count1号資格者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            FlexibleDate 年齢到達期限日) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is1号資格者(entity.getAtenaPSMEntity(), 基準日, 年齢到達期限日)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 2号資格者の人数を返す
     *
     * @param 選挙人資格リスト List<SenkyoninTohyoJokyoEntity>
     * @param 基準日 FlexibleDate
     * @param 集計条件 SyukeiJyouken
     * @param 年齢到達期限日 FlexibleDate
     * @return 2号資格者の人数
     */
    public int count2号資格者数(List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト, FlexibleDate 基準日, SyukeiJyouken 集計条件,
            FlexibleDate 年齢到達期限日) {
        int count = 0;
        for (SenkyoninTohyoJokyoEntity entity : 選挙人資格リスト) {
            if (this.is集計条件別適合(entity, 集計条件) && 資格判定.is2号資格者(entity.getAtenaPSMEntity(), 基準日, 年齢到達期限日)) {
                count++;
            }
        }
        return count;
    }

    private Map<Integer, AfT201TohyoJokyoEntity> get投票状況(SenkyoninTohyoJokyoEntity senkyoEntity) {
        Map<Integer, AfT201TohyoJokyoEntity> 投票状況Map = new HashMap<>();
        if (senkyoEntity.getTohyoJokyoEntityList().isEmpty()) {
            return 投票状況Map;
        }
        for (AfT201TohyoJokyoEntity entity : senkyoEntity.getTohyoJokyoEntityList()) {
            投票状況Map.put(entity.getSenkyoNo().value(), entity);
        }
        return 投票状況Map;
    }

    private Boolean is集計条件別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get選挙別())) {
            for (AfT111SenkyoEntity senkyoEntity : entity.getSenkyoJohoEntity().getSenkyoEntity()) {
                if (senkyoEntity.getSenkyoNo().equals(new SenkyoNo(集計条件.get選挙別()))) {
                    return this.is投票区別適合(entity, 集計条件);
                }
            }
        }
        return false;

    }

    private Boolean is投票区別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get投票区別())
                && NullHandler.getNullToRString(entity.getAtenaPSMEntity().getTohyokuCode()).equals(集計条件.get投票区別())) {
            return this.is住所別適合(entity, 集計条件);
        }
        return false;
    }

    private Boolean is住所別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get住所別())
                && NullHandler.getNullToRString(entity.getAtenaPSMEntity().getJutonaiJusho()).equals(集計条件.get住所別())) {
            return this.is行政区別適合(entity, 集計条件);
        }
        return false;
    }

    private Boolean is行政区別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get行政区別())
                && NullHandler.getNullToRString(entity.getAtenaPSMEntity().getGyoseikuCode()).equals(集計条件.get行政区別())) {
            return this.is地区1別適合(entity, 集計条件);
        }
        return false;
    }

    private Boolean is地区1別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get地区1別())
                && NullHandler.getNullToRString(entity.getAtenaPSMEntity().getChikuCode1()).equals(集計条件.get地区1別())) {
            return this.is地区2別適合(entity, 集計条件);
        }
        return false;
    }

    private Boolean is地区2別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get地区2別())
                && NullHandler.getNullToRString(entity.getAtenaPSMEntity().getChikuCode2()).equals(集計条件.get地区2別())) {
            return this.is地区3別適合(entity, 集計条件);
        }
        return false;
    }

    private Boolean is地区3別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get地区3別())
                && NullHandler.getNullToRString(entity.getAtenaPSMEntity().getChikuCode3()).equals(集計条件.get地区3別())) {
            return this.is男女別適合(entity, 集計条件);
        }
        return false;
    }

    private Boolean is男女別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get男女別())
                && NullHandler.getNullToRString(entity.getAtenaPSMEntity().getSeibetsuCode()).equals(集計条件.get男女別())) {
            return this.is年齢別適合(entity, 集計条件);
        }
        return false;
    }

    private Boolean is年齢別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        if (!RString.isNullOrEmpty(集計条件.get年齢別())
                && ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.getAtenaPSMEntity()).to個人().get年齢算出().get年齢()
                .equals(集計条件.get年齢別())) {
            return this.is年代別適合(entity, 集計条件);
        }
        return false;
    }

    private Boolean is年代別適合(SenkyoninTohyoJokyoEntity entity, SyukeiJyouken 集計条件) {
        return !RString.isNullOrEmpty(集計条件.get年代別())
                && get年代(ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.getAtenaPSMEntity()).to個人().get年齢算出())
                .equals(集計条件.get年代別());
    }

    /**
     * 年代を取得する
     *
     * @param age
     * @return 年代
     */
    private RString get年代(AgeCalculator age) {
        return this.get年代ByCase1(age);
    }

    private RString get年代ByCase1(AgeCalculator age) {
        int 年齢 = Integer.valueOf(age.get年齢().toString());
        if (零歳 <= 年齢 && 年齢 < 十歳) {
            return new RString("0代");
        } else if (十歳 <= 年齢 && 年齢 < 二十歳) {
            return new RString("10代");
        } else if (二十歳 <= 年齢 && 年齢 < 三十歳) {
            return new RString("20代");
        } else if (三十歳 <= 年齢 && 年齢 < 四十歳) {
            return new RString("30代");
        } else if (四十歳 <= 年齢 && 年齢 < 五十歳) {
            return new RString("40代");
        } else if (五十歳 <= 年齢 && 年齢 < 六十歳) {
            return new RString("50代");
        } else {
            return get年代ByCase2(年齢);
        }
    }

    private RString get年代ByCase2(int 年齢) {
        if (六十歳 <= 年齢 && 年齢 < 七十歳) {
            return new RString("60代");
        } else if (七十歳 <= 年齢 && 年齢 < 八十歳) {
            return new RString("70代");
        } else if (八十歳 <= 年齢 && 年齢 < 九十歳) {
            return new RString("80代");
        } else if (九十歳 <= 年齢 && 年齢 < 百歳) {
            return new RString("90代");
        } else {
            return new RString("100代");
        }
    }

    private FlexibleDate toMinWhenNullOrEmpty(FlexibleDate date) {
        if (null == date || date.isEmpty()) {
            return FlexibleDate.MIN;
        }
        return date;
    }

    private List<SenkyoninTohyoJokyoEntity> convertSearchResultToEntity(List<SenkyoninTohyoJokyoSearchResult> 選挙人資格) {
        List<SenkyoninTohyoJokyoEntity> 選挙人資格リスト = new ArrayList<>();
        for (SenkyoninTohyoJokyoSearchResult result : 選挙人資格) {
            選挙人資格リスト.add(result.getEntity());
        }
        return 選挙人資格リスト;
    }
}
