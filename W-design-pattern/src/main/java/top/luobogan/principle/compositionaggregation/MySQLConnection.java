package top.luobogan.principle.compositionaggregation;

/**
 * Created by luobogan
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
