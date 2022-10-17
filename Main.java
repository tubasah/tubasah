import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choice;
        ArrayList<BankAccount> nganhang=new ArrayList<>();
        do{
            System.out.println("Mời bạn nhập lựa chọn : ");
            choice= scanner.nextInt();
            switch (choice) {
                case 1:
                    BankAccount input = addthongtin(scanner);
                    nganhang.add(input);
                    System.out.println("Thêm tài khoản thành công");
                    break;
                case 2:
                    show(nganhang);
                    break;
                case 3:
                    String id;
                    scanner.nextLine();
                    System.out.println("Nhập mã tk cần nạp tiền");
                    id = scanner.nextLine();
                    System.out.println("Nhập số tiền cần nạp");
                    long money = scanner.nextLong();
                    if (deposit(nganhang, id, money) != false) {
                        System.out.println("Nạp thành công");
                        show(nganhang);
                    } else {
                        System.out.println("Nạp thất bại");
                    }
                case 4:
                    scanner.nextLine();
                    System.out.println("Nhập mã tk cần rút tiền");
                    id = scanner.nextLine();
                    System.out.println("Nhập số tiền cần rút");
                    money = scanner.nextLong();
                    if (ruttien(nganhang, id, money) != false) {
                        System.out.println("Rút thành công");
                        show(nganhang);
                    } else {
                        System.out.println("Rút thất bại");
                    }
                case 5:
                    scanner.nextLine();
                    System.out.println("Nhập mã tk của bạn");
                    id = scanner.nextLine();

                    System.out.println("Nhập số tiền cần chuyển");
                    money = scanner.nextLong();
                    scanner.nextLine();
                    ;
                    System.out.println("Nhập mã tk muốn chuyển tới");
                    String idnhan = scanner.nextLine();
                    if (chuyentien(nganhang, id, idnhan, money) != false) {
                        System.out.println("Chuyển thành công");
                        show(nganhang);
                    } else {
                        System.out.println("Chuyển thất bại");
                    }
                    break;
                case 6:
                    String name;
                    System.out.println("Nhập tên muốn tìm");
                    name = scanner.nextLine();
                    scanner.nextLine();
                    ArrayList<BankAccount> res=Searchname(nganhang,name);
                    show(res);
            }

        }while(choice<8);

    }
    public static BankAccount addthongtin(Scanner scanner){
        scanner.nextLine();
        System.out.println("Mời bạn nhập mã tài khoản: ");
        String id=scanner.nextLine();
        System.out.println("Mời bạn nhập stk: ");
        String accnumber=scanner.nextLine();
        System.out.println("Mời bạn nhập tên tài khoản : ");
        String owner=scanner.nextLine();
        System.out.println("Mời bạn nhập loại tài khoản: ");
       String type=scanner.nextLine();
        System.out.println("Mời bạn nhập số dư: ");
        long ballance=scanner.nextLong();
        scanner.nextLine();
        System.out.println("Mời bạn nhập tên ngân hàng: ");
        String bankname =scanner.nextLine();
        System.out.println("Mời bạn nhập ngày phát hành: ");
        String startdate=scanner.nextLine();
        System.out.println("Mời bạn nhập ngày hết hạn: ");
        String enddate=scanner.nextLine();
        BankAccount bank= new BankAccount(id,accnumber,owner,type,bankname,startdate,enddate,ballance);
        return bank;
    }
    public static void thongtin(BankAccount bank){
        System.out.printf("%-12s%-15s%-25s%-15s%-15s%-20s%-15s%-15d\n",bank.getId(),bank.getAccnumber(),bank.getOwner(),bank.getType(),bank.getBankName(),bank.getStartdate(),bank.getEndđate(),bank.getBallance());
    }
    public static void show(ArrayList<BankAccount> bam){
        System.out.printf("-------DANH SÁCH TÀI KHOẢN-------\n");
        System.out.printf("%-12s%-15s%-25s%-15s%-15s%-20s%-15s%-15s\n","Mã TK","Stk","Tên TK","Loại TK","Tên ngân hàng","Ngày PH","Ngày HH","Số dư");
        for(BankAccount b : bam ){
            thongtin(b);
        }
    }
    public static BankAccount timid(ArrayList<BankAccount> nganhang,String id){
        for(BankAccount b: nganhang ){
            String tim = b.getId();
            if(tim.compareToIgnoreCase(id)==0){
                return b;
            }
        }
        return null;
    }
    public static boolean deposit(ArrayList<BankAccount> nganhang,String id,long money){
        BankAccount acc=timid(nganhang,id);
        if (acc!=null){
            return acc.naptien(money);
        }
        return false;
    }
    public static boolean ruttien(ArrayList<BankAccount> nganhang,String id,long money){
        BankAccount tim=timid(nganhang,id);
        if(tim!=null&&tim.getBallance()>money){
            return tim.ruttien(money);
        }
        else {
            return false;
        }
    }
    public static boolean chuyentien(ArrayList<BankAccount> nganhang,String idgui,String idnhan,long money){
        BankAccount gui=timid(nganhang,idgui);
        BankAccount nhan=timid(nganhang,idnhan);
        if(gui!=null&&nhan!=null){
            return gui.chuyenkhoan(money,nhan);
        }
        return false;
    }
    public static String layname(String name){
        int index=name.lastIndexOf(" ");
        return name.substring(index);
    }
    public static ArrayList<BankAccount> Searchname(ArrayList<BankAccount> nganhang,String name){
        ArrayList<BankAccount> res=new ArrayList<>();
        for(BankAccount b:nganhang) {
            String fir=layname(b.getOwner());
            if (fir.compareToIgnoreCase(name)==0)
                res.add(b);
            }
        return res;
    }
}