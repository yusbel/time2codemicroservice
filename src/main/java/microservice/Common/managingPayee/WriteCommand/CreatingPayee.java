package microservice.Common.managingPayee.WriteCommand;

public class CreatingPayee {
    final public String key;
    final public String name;

    public CreatingPayee(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getKey(){
        return this.key;
    }
}
