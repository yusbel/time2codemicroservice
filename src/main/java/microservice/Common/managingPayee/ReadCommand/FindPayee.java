package microservice.Common.managingPayee.ReadCommand;

public class FindPayee {
    final Integer id;
    final String name;

    public FindPayee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() { return id; }
}
