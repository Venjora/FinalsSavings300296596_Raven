package samplePackage;

public class Savings {
    public Savings(int custno, String custname) {
        this.custno = custno;
        this.custname = custname;
    }

    private int custno;
    private String custname;
    private double cdep;
    private int nyears;

    public int getCustno() {
        return custno;
    }

    public void setCustno(int custno) {
        this.custno = custno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public double getCdep() {
        return cdep;
    }

    public void setCdep(double cdep) {
        this.cdep = cdep;
    }

    public int getNyears() {
        return nyears;
    }

    public void setNyears(int nyears) {
        this.nyears = nyears;
    }

    public String getSavtype() {
        return savtype;
    }

    public void setSavtype(String savtype) {
        this.savtype = savtype;
    }

    private String savtype;
}
