package studentmgmt;

public class Student {
    private int id;
    private String name;
    private String phone;
    private String city;

    public Student (int id, String name, String phone, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    public Student(String _name) {
        this.name = _name;
    }

    public Student (String _name, String _phone) {
        this.name = _name;
        this.phone = _phone;
    }

    public Student (String _name, String _phone, String _city) {
        this.name = _name;
        this.phone = _phone;
        this.city = _city;
    }

    public int getId() {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String  getCity() {
        return this.city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity (String city) {
        this.city = city;
    }
}