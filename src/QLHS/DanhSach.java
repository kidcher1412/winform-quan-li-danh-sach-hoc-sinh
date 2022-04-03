package QLHS;
import java.util.*;

public abstract class DanhSach {
    Scanner sc = new Scanner(System.in);
    static DanhSach dsql;
    
    public static void LoaiDanhSach(){
        Scanner sc = new Scanner(System.in);
        byte number;
        boolean exit = false;
        do {
            System.out.println();
            System.out.println("=============== DANH SÁCH ===============");
            System.out.println("Hãy chọn danh sách bạn muốn thao tác");
            System.out.println("1)......Danh sách các khối lớp");
            System.out.println("2)......Danh sách giáo viên");
            System.out.println("3)......Danh sách học sinh");
            System.out.println("4)......Danh sách môn học");
            System.out.println("5)......Danh sách điểm");
            System.out.println("0)......Thoát chương trình!");
            System.out.println("=========================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            number = sc.nextByte();   
            sc.nextLine();
                                      
            switch(number){
                case 1:
                    dsql = new DSLop(); 
                    dsql.Menu();
                    break;
            
                case 2:
                    dsql = new DSGiaoVien();
                    dsql.Menu();
                    break;
            
                case 3:
                    dsql = new DSHocSinh();
                    dsql.Menu();
                    break;
            
                case 4:
                    dsql = new DSMonHoc();
                    dsql.Menu();
                    break;
            
                case 5:
                    dsql = new DSDiem();
                    dsql.Menu();
                    break;

                case 0:
                    exit = true; 
                    System.out.println("Thoát thành công!");
                    break;
            
                default:
                    System.out.print("\nLựa chọn không hợp lệ! Vui lòng chọn lại...");
                    break;
            }
            if(exit == true)
                break;
        }
        while(true);
    }  

    public void them(){
        System.out.println("\n----- THÊM -----");    
    }
    
    public void sua(){
        System.out.println("\n----- SỬA -----");          
    }
    
    public void xoa(){
        System.out.println("\n----- XÓA -----");        
    }
    
    public void timkiem(){
        System.out.println("\n----- TÌM KIẾM -----");         
    }
    
    public void sapxep(){
        System.out.println("\n----- SẮP XẾP -----");      
    }
    
    
    public void docFile(){
        System.out.println("\n----- ĐỌC DỮ LIỆU FILE -----");
    }

    public void ghiFile(){
        System.out.println("\n----- GHI DỮ LIỆU RA FILE -----");
    }
    
    public abstract void hienthi(); // phương thức trừu tượng
  
    public void Menu(){
        byte select;
        boolean exit = false;
        do{
            System.out.println("\n======= MENU =======");
            System.out.println("1)......Thêm");
            System.out.println("2)......Sửa");
            System.out.println("3)......Xóa");
            System.out.println("4)......Tìm kiếm");
            System.out.println("5)......Sắp xếp");
            System.out.println("6)......Hiển thị");
            System.out.println("7)......Đọc file");
            System.out.println("8)......Ghi file");
            System.out.println("0)......Thoát");
            System.out.println("=====================");    
            System.out.print("Chọn: ");
            select = sc.nextByte();
            sc.nextLine(); //ENTER

            switch(select){
                case 1:
                    them();
                    break;
                
                case 2:
                    sua();
                    break;
                
                case 3:
                    xoa();
                    break;
                
                case 4:
                    timkiem();
                    break;
                
                case 5:
                    sapxep();
                    break;
                
                case 6:
                    hienthi();
                    break;
                
                case 7: 
                    docFile();
                    break;
                
                case 8:
                    ghiFile();
                    break;
                
                case 0:
                    exit = true; 
                    System.out.println("Thoát thành công!");
                    break;
                
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại...");
                    break;
            }
            if(exit == true)
                break;
        }
        while(true);
    }
}    
   