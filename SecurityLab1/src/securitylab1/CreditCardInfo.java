
package securitylab1;


public class CreditCardInfo {
    private String lname, fname;
    private String cNum;
    private String expYear, expMon;
    private String CVC;

    public CreditCardInfo() {
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getcNum() {
        return cNum;
    }

    public void setcNum(String cNum) {
        this.cNum = cNum;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public String getExpMon() {
        return expMon;
    }

    public void setExpMon(String expMon) {
        this.expMon = expMon;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }
    
    
}
