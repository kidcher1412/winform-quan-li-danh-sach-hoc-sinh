
package QLHS;
import java.util.*;

public class MonHoc implements INhapXuat{
    Scanner sc = new Scanner(System.in);
    private String mamh, tenmh;
    private int sotiet;
    
    public MonHoc(){
        mamh = ""; 
        tenmh = ""; 
        sotiet = 0;
    }

    public MonHoc(String mamh, String tenmh, int sotiet){
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.sotiet = sotiet;
    }

    public String getMamh(){
        return mamh;
    }
    
    public boolean setMamh(String mamh){
        String mamhPattern = "MH\\d{2}"; //  MHxx
        if(mamh.matches(mamhPattern))
            this.mamh = mamh;
        else{
            System.err.println("\nKhông hợp lệ! Nhập lại mã số môn học(MHxx)!!!\n");    
            return false;
        }
        return true;
    }
    
    public String getTenmh(){
        return tenmh;
    }
    
    public void setTenmh(String tenmh){
        this.tenmh = tenmh;
    }
    
    public int getSotiet(){
        return sotiet;
    }
    
    public boolean setSotiet(int sotiet){
        if(sotiet >0)
            this.sotiet = sotiet;
        else {
            System.err.println("Không hợp lệ! Nhập lại số tiết!!!\n");
            return false;
        }
        return true;
    }
    
    @Override
    public void Nhap(){
        while(true){    
            System.out.print("\nNhập mã môn học: ");
            if(setMamh(sc.nextLine())) 
                break;
        }

        System.out.print("Nhập tên môn học: ");
        tenmh = sc.nextLine();

        while(true){    
            System.out.print("Nhập số tiết: ");
            if(setSotiet(sc.nextInt()))
                break;
            sc.nextLine(); // ENTER
        }
    }

    @Override
    public void Xuat() {
        System.out.printf("%-20s %-20s %-15d \n",mamh,tenmh,sotiet);
    }

    public String toString(){
        return (mamh + "," + tenmh + "," + sotiet); 
    }
}