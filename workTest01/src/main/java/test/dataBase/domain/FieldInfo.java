package test.dataBase.domain;

public class FieldInfo {
    private String name;
    private String notice;

    public FieldInfo() {
    }

    public FieldInfo(String name, String notice) {
        this.name = name;
        this.notice = notice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "name='" + name + '\'' +
                ", notice='" + notice + '\'' +
                '}';
    }
}
