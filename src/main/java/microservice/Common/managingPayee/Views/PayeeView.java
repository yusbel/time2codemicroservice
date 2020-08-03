package microservice.Common.managingPayee.Views;

public class PayeeView {

    public static PayeeView createDefault() {
        return new PayeeView("", "", "");
    }

    public static PayeeView create(String key, String name, String accountNum) {
        return new PayeeView(key, name, accountNum);
    }

    private String key;
    private String name;
    private String accountNum;

    protected PayeeView(String key, String name, String accountNum) {
        this.key = key;
        this.name = name;
        this.accountNum = accountNum;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

}
