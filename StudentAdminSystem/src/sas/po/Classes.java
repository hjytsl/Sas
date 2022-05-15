package sas.po;

public class Classes {

    private Integer cnum;
    private String cname;


    @Override
    public String toString() {         //重写toString方法以便打印课程信息
        return  "\n课程编号："+this.cnum+
                "\n课程名称："+this.cname;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
