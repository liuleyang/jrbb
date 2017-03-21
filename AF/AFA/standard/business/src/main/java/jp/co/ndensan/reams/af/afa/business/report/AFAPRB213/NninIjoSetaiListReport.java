package jp.co.ndensan.reams.af.afa.business.report.AFAPRB213;

import jp.co.ndensan.reams.af.afa.business.core.NninIjoSetaiListParam;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB213.NninIjoSetaiListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * n人以上世帯一覧表
 *
 * @reamsid_L AF-0160-037 wangh
 */
public class NninIjoSetaiListReport extends Report<NninIjoSetaiListSource> {

    private final NninIjoSetaiListParam target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;

    /**
     * コンストラクタです。
     *
     * @param target NninIjoSetaiListParam
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public NninIjoSetaiListReport(NninIjoSetaiListParam target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * コンストラクタです。 {@link SenkyoninTohyoJokyoItem}から、{@link NijuTorokuTyosaListReport}型のインスタンスを生成し、返します。
     *
     * @param target {@link NninIjoSetaiListParam}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     * @return {@link NijuTorokuTsuchishoListReport}型のインスタンス
     */
    public static NninIjoSetaiListReport createForm(@NonNull NninIjoSetaiListParam target,
            TeijiCommonJohoItem 帳票共通ヘッダー) {
        return new NninIjoSetaiListReport(target, 帳票共通ヘッダー);
    }

    /**
     * 帳票生成する
     *
     * @param reportSourceWriter {@link ReportSourceWriter<NninIjoSetaiListSource>}
     */
    @Override
    public void writeBy(ReportSourceWriter<NninIjoSetaiListSource> reportSourceWriter) {
        NninIjoSetaiListEditor editor = new NninIjoSetaiListEditor(target, 帳票共通ヘッダー);
        INninIjoSetaiListBuilder builder = new NninIjoSetaiListBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
