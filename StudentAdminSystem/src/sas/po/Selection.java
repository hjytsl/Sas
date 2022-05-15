package sas.po;

public class Selection {

    private Integer cnum;
    private Integer snum;
    private Double grades;

    @Override
    public String toString() {     //重写toString方法以便打印选课信息成绩单
        return  "\n课程编号："+this.cnum+
                "\n学生姓名："+this.snum+
                "\n学生成绩："+this.grades;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Double getGrades() {
        return grades;
    }

    public void setGrades(Double grades) {
        this.grades = grades;
    }
}
