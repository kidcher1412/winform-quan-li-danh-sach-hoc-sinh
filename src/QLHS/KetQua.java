
package QLHS;
import java.util.*;

public class KetQua implements INhapXuat{
    Scanner sc = new Scanner(System.in);
    private String maHS;
    private float Diem15phut;
    private float Diem1tiet;
    private float DiemThi;
    private int HocKy;
    private int HanhKiem;

    public KetQua() {
        maHS = null;
        Diem15phut = 0;
        Diem1tiet = 0;
        DiemThi = 0;
        HanhKiem = 0;
        HocKy = 1;      //vì chỉ có học kỳ 1 và 2
    }

    public KetQua(String maHS, float Diem15phut, float Diem1tiet, float DiemThi, int HanhKiem, int HocKy) {
        this.maHS = maHS;
        this.Diem15phut = Diem15phut;
        this.Diem1tiet = Diem1tiet;
        this.DiemThi = DiemThi;
        this.HanhKiem = HanhKiem;
        this.HocKy = HocKy;
    }

    public String getMaHS() {
        return maHS;
    }

    public boolean setMaHS(String maHS) {
        String maHSPattern = "HS\\d{4}";
        if(maHS.matches(maHSPattern))
            this.maHS = maHS;
        else{
            System.err.println("\nKhông hợp lệ! Nhập lại mã số học sinh (HSxxxx)!!!\n");    
            return false;
        }
        return true;
    }

    public float getDiem15phut() {
        return Diem15phut;
    }

    public boolean setDiem15phut(float Diem15phut) {        
        if(Diem15phut <= 10 && Diem15phut >= 0)
            this.Diem15phut = Diem15phut;
        else {
            System.err.println("Không hợp lệ! Nhập lại điểm 15 phút!!!\n");
            return false;
        }
        return true;
    }

    public float getDiem1tiet() {
        return Diem1tiet;
    }
    
    public boolean setDiem1tiet(float Diem1tiet) {        
        if(Diem1tiet <= 10 && Diem1tiet >= 0)
            this.Diem1tiet = Diem1tiet;
        else {
            System.err.println("Không hợp lệ! Nhập lại điểm 1 tiết!!!\n");
            return false;
        }
        return true;
    }

    public float getDiemThi() {
        return DiemThi;
    }

    public boolean setDiemThi(float DiemThi) {        
        if(DiemThi <= 10 && DiemThi >= 0)
            this.DiemThi = DiemThi;
        else {
            System.err.println("Không hợp lệ! Nhập lại điểm thi!!!\n");
            return false;
        }
        return true;
    }

    public int getHocKy() {
        return HocKy;
    }

    public boolean setHocKy(int HocKy) {        
        if(HocKy == 1 || HocKy == 2)
            this.HocKy = HocKy;
        else {
            System.err.println("Không hợp lệ! Nhập lại học kỳ!!!\n");
            return false;
        }
        return true;
    }       
    
    public int getHanhKiem() {
        return HanhKiem;
    }

    public boolean setHanhKiem(int HanhKiem) {        
        if(HanhKiem <= 100 && HanhKiem >= 0)
            this.HanhKiem = HanhKiem;
        else {
            System.err.println("Không hợp lệ! Nhập lại điểm hạnh kiểm!!!\n");
            return false;
        }
        return true;
    } 
    
    @Override
    public void Nhap(){
        while(true){    
            System.out.print("\nNhập mã số học sinh: ");
            if(setMaHS(sc.nextLine()))
                break;
        }
        
        while(true){    
            System.out.print("Nhập điểm 15 phút: ");
            if(setDiem15phut(sc.nextFloat()))
                break;
            sc.nextLine(); //ENTER
        }

        while(true){    
            System.out.print("Nhập điểm 1 tiết: ");
            if(setDiem1tiet(sc.nextFloat()))
                break;
            sc.nextLine(); //ENTER
        }

        while(true){    
            System.out.print("Nhập điểm thi: ");
            if(setDiemThi(sc.nextFloat()))
                break;
            sc.nextLine(); //ENTER
        }

        while(true){    
            System.out.print("Nhập điểm hạnh kiểm: ");
            if(setHanhKiem(sc.nextInt()))
                break;
            sc.nextLine(); //ENTER
        }

        while(true){    
            System.out.print("Nhập học kỳ: ");
            if(setHocKy(sc.nextInt()))
                break;
            sc.nextLine(); //ENTER
        }
    }
    
    @Override
    public void Xuat(){
        System.out.println("Mã học sinh: " + maHS);
        System.out.println("Điểm 15 phút: " + Diem15phut);
        System.out.println("Điểm 1 tiết: " + Diem1tiet);
        System.out.println("Điểm thi: " + DiemThi);
        System.out.println("Hạnh kiểm: " + HanhKiem);
        System.out.println("Học kỳ: " + HocKy);
        System.out.println("Điểm trung bình: " + DiemTrungBinh());    
        System.out.print("Xếp loại học lực: ");
        LoaiHocLuc();       
        System.out.print("Xếp loại hạnh kiểm: ");
        LoaiHanhKiem();
        System.out.println("");
        //System.out.println("\t" + maHS + "\t" + Diem15phut + "\t\t" + Diem1tiet +  "\t\t" + DiemThi + "\t\t" + DiemTrungBinh() + "\t" + HanhKiem + "\t\t" + HocKy);      
    }
    
    public void LoaiHocLuc(){
        if(DiemTrungBinh()>=8 && Diem15phut>=6.5 && Diem1tiet>=6.5 && DiemThi>=6.5)
            System.out.println("Học Sinh Giỏi");
        else if(DiemTrungBinh()>=6.5 && Diem15phut>=5 && Diem1tiet>=5 && DiemThi>=5)
            System.out.println("Học Sinh Khá");
        else if(DiemTrungBinh()>=5 && Diem15phut>=3.5 && Diem1tiet>=3.5 && DiemThi>=3.5)
            System.out.println("Học Sinh Trung Bình");
        else if(DiemTrungBinh()>=3.5 && Diem15phut>=2 && Diem1tiet>=2 && DiemThi>=2)
            System.out.println("Học Sinh Yếu");           
        else
            System.out.println("Học Sinh Kém");   
    }
    
    public void LoaiHanhKiem(){
        if(HanhKiem >= 95)
            System.out.println("Xuất Sắc");
        else if(HanhKiem >= 80 && HanhKiem <= 94)
            System.out.println("Tốt");
        else if(HanhKiem >= 65 && HanhKiem <= 79)
            System.out.println("Khá");
        else if(HanhKiem >= 50 && HanhKiem <= 64)
            System.out.println("Trung Bình");           
        else
            System.out.println("Yếu"); 
    }
    
    public float DiemTrungBinh(){
        return (Diem15phut*1 + Diem1tiet*2 + DiemThi*3)/6;
    }
    
    public String toString(){
        return (maHS + "," + Diem15phut + "," + Diem1tiet + "," + DiemThi +  "," + HanhKiem + "," + HocKy);
    }
}
