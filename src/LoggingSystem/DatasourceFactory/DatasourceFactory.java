package LoggingSystem.DatasourceFactory;

import LoggingSystem.DataSource.Database;
import LoggingSystem.DataSource.IDataSource;
import LoggingSystem.DataSource.FileAppender;



public class DatasourceFactory {

    public static final FileAppender logfile = new FileAppender("");
    public static final Database database = new Database();

    private static volatile DatasourceFactory instance;

    private DatasourceFactory() {

    }

    public static DatasourceFactory getInstance() {
        if(instance == null) {
            synchronized (DatasourceFactory.class) {
                if(instance == null) {
                    instance = new DatasourceFactory();
                }
            }
        }
        return instance;
    }

    public IDataSource getDataSource(String dataSourceName) {
        if (dataSourceName == null) return null;
        switch (dataSourceName.toUpperCase()) {
            case "LOG":
                return logfile;
            case "DATABASE":
                return database;
            default:
                return logfile;
        }
    }
}
