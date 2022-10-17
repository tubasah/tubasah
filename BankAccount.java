public class BankAccount {
    private String id,accnumber,owner,type,bankName,startdate,endđate;
    private long ballance;

    public BankAccount(String id, String accnumber, String owner, String type, String bankName, String startdate, String endđate, long ballance) {
        this.id = id;
        this.accnumber = accnumber;
        this.owner = owner;
        this.type = type;
        this.bankName = bankName;
        this.startdate = startdate;
        this.endđate = endđate;
        this.ballance = ballance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccnumber() {
        return accnumber;
    }

    public void setAccnumber(String accnumber) {
        this.accnumber = accnumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEndđate() {
        return endđate;
    }

    public void setEndđate(String endđate) {
        this.endđate = endđate;
    }

    public long getBallance() {
        return ballance;
    }

    public void setBallance(long ballance) {
        this.ballance = ballance;
    }
    public boolean naptien(long money){
        if(money>0){
            ballance=ballance+money;
            return true;}
        return false;
    }
    public boolean ruttien(long money){
        if(money>0){
            ballance=ballance-money;
            return true;}
        return false;
    }
    public boolean chuyenkhoan(long money,BankAccount other){
        if(money>0&&ballance>money){
            other.ballance+=money;
            ballance-=money;
            return true;
        }
        return false;
    }
    public void kiemtrasodu(){
        System.out.println("Số dư hiện tại là :"+getBallance());
    }

}
