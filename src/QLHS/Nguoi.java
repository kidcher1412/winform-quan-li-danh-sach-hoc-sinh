
package QLHS;
import java.util.*;

public class Nguoi implements INhapXuat {
    protected String hoten;
    protected String gioitinh;
    protected String diachi;
    protected String phone;    
    protected String email;         
    Scanner sc =new Scanner(System.in);

    public Nguoi(){
        hoten = "";
        gioitinh = "";
        diachi = "";
        phone = "";
        email = "";
    }
    
    public Nguoi(String hoten, String gioitinh, String diachi, String phone, String email){
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.phone = phone;
        this.email = email;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public boolean setGioitinh(String gioitinh) {
        if(gioitinh.equalsIgnoreCase("nam") || gioitinh.equalsIgnoreCase("nu")) //không biệt viết hoa hay viết thường 
            this.gioitinh = gioitinh;
        else{
            System.err.println("\nKhông hợp lệ! Nhập lại giới tính (Nam/Nữ)!!!\n");    
            return false;
        }
        return true;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        String phonePattern = "\\d{10}";  // \\d{10}: số điện thoại, \\d là nhập vào số bất kỳ, vd: 084-1234567
        if(phone.matches(phonePattern))
            this.phone = phone;
        else {
            System.err.println("\nKhông hợp lệ! Nhập lại số điện thoại (10 số)!!!\n");
            return false;
        }
        return true;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        String emailPattern = "\\w+@\\w+[.]\\w+";  // \\w: ký tự, vd: vy@gmail.com
        if(email.matches(emailPattern))
            this.email = email;
        else{
            System.err.println("\nKhông hợp lệ! Nhập lại Email!!!\n");    
            return false;
        }
        return true;
    }
    
    @Override
    public void Nhap(){
        System.out.print("Nhập họ tên: ");
        hoten = sc.nextLine();
        
        while(true){
            System.out.print("Nhập giới tính: ");
            if(setGioitinh(sc.nextLine()))
                break;
        }
        
        System.out.print("Nhập địa chỉ: ");
        diachi = sc.nextLine();
        
        while(true){
            System.out.print("Nhập số điện thoại (xxx-xxxx-xxx): ");
            if(setPhone(sc.nextLine()))
                break;
        }
        
        while(true){
            System.out.print("Nhập Email: ");
            if(setEmail(sc.nextLine()))
                break;
        }
    }
    
    @Override
    public void Xuat()
    {
    }
}
