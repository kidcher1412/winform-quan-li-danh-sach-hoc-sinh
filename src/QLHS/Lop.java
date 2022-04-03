
package QLHS;
import java.util.*;

public class Lop implements INhapXuat{
    Scanner sc = new Scanner(System.in);
    private String malop;
    private int siso;
    private int khoi;

    public Lop(){
        malop = "";
        siso = 0;
    }
    
    public Lop(String malop, int siso,int khoi){
        this.malop = malop;
        this.siso = siso;
        this.khoi= khoi;
    }
    
    public String getMalop(){
        return malop;
    }
    
    public boolean setMalop(String malop){
        String malopPattern = "A\\d{1}";
        if(malop.matches(malopPattern))
            this.malop = khoi+malop;
        else{
            System.err.println("\nKhông hợp lệ! Nhập lại mã số lớp(VD A1)!!!\n");    
            return false;
        }
        return true;
    }   
    
    public int getSiso(){
        return siso;
    }
    
    public boolean setSiso(int siso){
        if(siso >0)
            this.siso = siso;
        else {
            System.err.println("Không hợp lệ! Nhập lại sĩ số!!!\n");
            return false;
        }
        return true;
    }

    public int getKhoi() {
        return khoi;
    }

    public void setKhoi(int khoi) {
        this.khoi = khoi;
    }

    @Override
    public void Nhap(){
        while(true){
            System.out.print("\nNhập mã lớp: ");
            if(setMalop(sc.nextLine()))
                break;
        }
        while(true){
            System.out.print("Nhập sĩ số lớp: ");
            if(setSiso(sc.nextInt()))
                break;
            sc.nextLine(); //ENTER
        }
    }
    
    @Override
    public void Xuat(){
        System.out.printf("         %-20s %-10d %-10d  ",malop,siso,khoi);
    }
    
    public String toString(){
        return (malop + "," + siso + "," + khoi);
    }
}
