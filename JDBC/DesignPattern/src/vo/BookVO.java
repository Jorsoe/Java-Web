package vo;

public class BookVO {

    String id;
    String usernname;
    String password;
    String email;

    public String getId() {
        return id;
    }

    public BookVO(String usernname, String password, String email) {
        this.usernname = usernname;
        this.password = password;
        this.email = email;
    }

    public String getUsernname() {
        return usernname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
