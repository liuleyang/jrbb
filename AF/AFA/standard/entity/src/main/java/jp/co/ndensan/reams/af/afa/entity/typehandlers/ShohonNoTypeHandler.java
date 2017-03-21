package jp.co.ndensan.reams.af.afa.entity.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;

public class ShohonNoTypeHandler extends BaseTypeHandler<ShohonNo> {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ShohonNo parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter == null ? null : parameter.getColumnValue());
    }

    @Override
    public ShohonNo getNullableResult(ResultSet r, String c) throws SQLException {
        return new ShohonNo(r.getInt(c));
    }

    @Override
    public ShohonNo getNullableResult(ResultSet r, int c) throws SQLException {
        return new ShohonNo(r.getInt(c));
    }

    @Override
    public ShohonNo getNullableResult(CallableStatement r, int c) throws SQLException {
        return new ShohonNo(r.getInt(c));
    }

// </editor-fold>
}
