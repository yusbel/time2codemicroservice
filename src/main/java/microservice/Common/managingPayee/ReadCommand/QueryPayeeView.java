package microservice.Common.managingPayee.ReadCommand;

public class QueryPayeeView {
    final String key;
    final String name;

    public QueryPayeeView(String key, String name) {
        this.key = key;
        this.name = name;
    }
}
