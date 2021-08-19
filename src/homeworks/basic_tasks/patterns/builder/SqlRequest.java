package homeworks.basic_tasks.patterns.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SqlRequest {
    private List<String> parametersList;
    private List<String> conditionsList;
    private String tableName;
    private Selector selector;
    private String request;

    private SqlRequest() {
        parametersList = new ArrayList<>();
        conditionsList = new ArrayList<>();
    }

    public static SqlRequestBuilder create() {
        return new SqlRequestBuilder();
    }

    @Override
    public String toString() {
        return request;
    }

    public static class SqlRequestBuilder {
        private static final String FROM = " FROM ";
        private static final String WHERE = " WHERE ";
        private static final String SELECCT = "SELECT ";
        private static final String ALL_PARAMETERS = "*";
        private static final String SEPARATOR = ", ";
        private SqlRequest sqlRequest;

        SqlRequestBuilder() {

            sqlRequest = new SqlRequest();
        }

        public SqlRequestBuilder buildParameter(String parameter) {
            sqlRequest.parametersList.add(parameter);
            return this;
        }

        public SqlRequestBuilder buildTableName(String tableName) {
            sqlRequest.tableName = tableName;
            return this;
        }

        public SqlRequestBuilder buildCondition(String condition) {
            sqlRequest.conditionsList.add(condition);
            return this;
        }

        public SqlRequestBuilder buildSelector(Selector selector) {
            sqlRequest.selector = selector;

            return this;
        }

        public SqlRequest build() {
            StringBuilder request = new StringBuilder();
            if (sqlRequest.parametersList.isEmpty()) {
                request.append(SELECCT).append(ALL_PARAMETERS);
            }
            StringBuilder parameters = getDataFromList(sqlRequest.parametersList, SEPARATOR, SELECCT);
            request.append(parameters);
            request.append(FROM).append(sqlRequest.tableName);
            StringBuilder conditions = getDataFromList(
                    sqlRequest.conditionsList, sqlRequest.selector.getShortName(), WHERE);
            request.append(conditions);
            sqlRequest.request = request.toString();
            return sqlRequest;
        }

        private StringBuilder getDataFromList(List<String> list, String separator, String operator) {
            StringBuilder stringBuilder = new StringBuilder();
            if (list.isEmpty()) {
                return stringBuilder;
            }
            stringBuilder.append(operator);
            if (list.size() > 1) {
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    stringBuilder.append(iterator.next());
                    if (iterator.hasNext()) {
                        stringBuilder.append(separator);
                    }
                }
                return stringBuilder;
            }
            return stringBuilder.append(list.get(0));
        }
    }
}
