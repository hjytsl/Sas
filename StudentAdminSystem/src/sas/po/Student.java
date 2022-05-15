package sas.po;

public class Student {

    private Integer snum;
    private String sname;
    private String major;
    private String gender;
    private Integer age;


    @Override
    public String toString() {     //重写toString方法以便打印学生信息
        return  "\n学生编号："+this.snum+
                "\n学生姓名："+this.sname+
                "\n专业："+this.major+
                "\n性别："+this.gender+
                "\n年龄："+this.age;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
