package top.luobogan.principle.compositionaggregation;

/**
 * Created by luobogan
 */
public class PostgreSQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "PostgreSQL数据库连接";
    }
}
