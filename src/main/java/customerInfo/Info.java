package customerInfo;

public class Info {
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String email;

    public Info(){}

    public Info(String id, String pw, String email, String name, String phone) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }


    public Info(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
