
package QLHS;
import java.util.*;

public class GiaoVien extends Nguoi {
    private String msgv;
    Scanner sc = new Scanner(System.in);

    public GiaoVien() {
        super();
        msgv = "";
    }
    
    public GiaoVien(String msgv, String hoten, String gioitinh, String diachi, String phone, String email) {
        super(hoten, gioitinh, diachi, phone, email);
        this.msgv = msgv;
    }

    public String getMsgv() {
        return msgv;
    }

    public boolean setMsgv(String msgv) {
        String msgvPattern = "GV\\d{3}";
        if(msgv.matches(msgvPattern))
            this.msgv = msgv;
        else{
            System.err.println("\nKhông hợp lệ! Nhập lại mã số giáo viên (GVxxx)!!!\n");    
            return false;
        }
        return true;
    } 

    @Override 
    public void Nhap() {
        while(true){
            System.out.print("Nhập mã số giáo viên: ");
            if(setMsgv(sc.nextLine()))
                break;
        }
        super.Nhap();
    }
        
    @Override 
    public void Xuat() {
        System.out.printf("       %-10s %-20s %-10s %-20s %-20s %-20s ",msgv,hoten,gioitinh,diachi,phone,email); 
    }
    
    public String toString() {
        return (msgv + ", " + hoten + ", " + gioitinh + ", " + diachi + ", " + phone + ", " + email);
    }
}

