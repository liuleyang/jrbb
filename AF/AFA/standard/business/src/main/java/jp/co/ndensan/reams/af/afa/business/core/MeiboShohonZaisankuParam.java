package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区選挙人名簿抄本
 *
 * @reamsid_L AF-0600-030 lis
 */
public class MeiboShohonZaisankuParam {

    private ShohonZaisankuMeiboJoho 財産区選挙人名簿の情報;
    private SenkyoninTohyoJokyoEntity 選挙人資格情報;
    private MeiboShohonJuminJouhouShuukei 名簿抄本情報集計;
    private Association 地方公共団体情報;
    private RString 画面ID;
    private boolean is公民権停止者;

    /**
     * コンストラクタです。
     *
     * @param 財産区選挙人名簿の情報 ShohonZaisankuMeiboJoho
     * @param 選挙人資格情報 SenkyoninTohyoJokyoEntity
     * @param 名簿抄本情報集計 MeiboShohonJuminJouhouShuukei
     * @param 地方公共団体情報 Association
     * @param 画面ID RString
     */
    public MeiboShohonZaisankuParam(ShohonZaisankuMeiboJoho 財産区選挙人名簿の情報, SenkyoninTohyoJokyoEntity 選挙人資格情報,
            MeiboShohonJuminJouhouShuukei 名簿抄本情報集計, Association 地方公共団体情報, RString 画面ID) {
        this.財産区選挙人名簿の情報 = 財産区選挙人名簿の情報;
        this.選挙人資格情報 = 選挙人資格情報;
        this.地方公共団体情報 = 地方公共団体情報;
        this.名簿抄本情報集計 = 名簿抄本情報集計;
        this.画面ID = 画面ID;

    }

    /**
     * 財産区選挙人名簿の情報を返します。
     *
     * @return 財産区選挙人名簿の情報 ShohonZaisankuMeiboJoho
     */
    public ShohonZaisankuMeiboJoho get財産区選挙人名簿の情報() {
        return 財産区選挙人名簿の情報;
    }

    /**
     * 選挙人資格情報を返します。
     *
     * @return 選挙人資格情報 SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity get選挙人資格情報() {
        return 選挙人資格情報;
    }

    /**
     * 名簿抄本情報集計を返します。
     *
     * @return 名簿抄本情報集計 MeiboShohonJuminJouhouShuukei
     */
    public MeiboShohonJuminJouhouShuukei get名簿抄本情報集計() {
        return 名簿抄本情報集計;
    }

    /**
     * 地方公共団体情報を返します。
     *
     * @return 地方公共団体情報 Association
     */
    public Association get地方公共団体情報() {
        return 地方公共団体情報;
    }

    /**
     * 画面IDを返します。
     *
     * @return 画面ID RString
     */
    public RString get画面ID() {
        return 画面ID;
    }

    /**
     * is公民権停止者を返します。
     *
     * @return is公民権停止者 boolean
     */
    public boolean isIs公民権停止者() {
        return is公民権停止者;
    }

    /**
     * 財産区選挙人名簿の情報を設定します。
     *
     * @param 財産区選挙人名簿の情報 ShohonZaisankuMeiboJoho
     */
    public void set財産区選挙人名簿の情報(ShohonZaisankuMeiboJoho 財産区選挙人名簿の情報) {
        this.財産区選挙人名簿の情報 = 財産区選挙人名簿の情報;
    }

    /**
     * 選挙人資格情報を設定します。
     *
     * @param 選挙人資格情報 SenkyoninTohyoJokyoEntity
     */
    public void set選挙人資格情報(SenkyoninTohyoJokyoEntity 選挙人資格情報) {
        this.選挙人資格情報 = 選挙人資格情報;
    }

    /**
     * 名簿抄本情報集計を設定します。
     *
     * @param 名簿抄本情報集計 MeiboShohonJuminJouhouShuukei
     */
    public void set名簿抄本情報集計(MeiboShohonJuminJouhouShuukei 名簿抄本情報集計) {
        this.名簿抄本情報集計 = 名簿抄本情報集計;
    }

    /**
     * 地方公共団体情報を設定します。
     *
     * @param 地方公共団体情報 Association
     */
    public void set地方公共団体情報(Association 地方公共団体情報) {
        this.地方公共団体情報 = 地方公共団体情報;
    }

    /**
     * 画面IDを設定します。
     *
     * @param 画面ID RString
     */
    public void set画面ID(RString 画面ID) {
        this.画面ID = 画面ID;
    }

    /**
     * is公民権停止者を設定します。
     *
     * @param is公民権停止者 boolean
     */
    public void setIs公民権停止者(boolean is公民権停止者) {
        this.is公民権停止者 = is公民権停止者;
    }

}
