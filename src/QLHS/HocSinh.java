
package QLHS;
import java.util.*;

public class HocSinh extends Nguoi {
    private String mshs;
    Scanner sc = new Scanner(System.in);

    public HocSinh(){
        super();
        mshs = "";
    }
    
    public HocSinh(String mshs, String hoten, String gioitinh, String diachi, String phone, String email) {
        super(hoten, gioitinh, diachi, phone, email);
        this.mshs = mshs;
    }
        
    @Override
    public void Nhap() {
        while(true){
            System.out.print("Nhập mã số học sinh: ");
            if(setMshs(sc.nextLine()))
                break;
        }
        super.Nhap();
    }
    
    @Override
    public void Xuat() {
        System.out.printf("       %-10s %-20s %-10s %-20s %-20s %-20s ",mshs,hoten,gioitinh,diachi,phone,email);    
    }

    public String getMshs() {
        return mshs;
    }

    public boolean setMshs(String mshs) {
        String mshsPattern = "HS\\d{4}";
        if(mshs.matches(mshsPattern))
            this.mshs = mshs;
        else{
            System.err.println("\nKhông hợp lệ! Nhập lại mã số học sinh (HSxxxx)!!!\n");    
            return false;
        }
        return true;
    }

    public String toString() {
        return (mshs + "," + hoten + "," + gioitinh + "," + diachi + "," + phone + "," + email);
    }
}
