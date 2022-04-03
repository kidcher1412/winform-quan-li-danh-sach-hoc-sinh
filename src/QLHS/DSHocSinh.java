package QLHS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class DSHocSinh extends DanhSach {
    Scanner sc = new Scanner(System.in);
    HocSinh[] dshs;
    int n=0; 
    
    public DSHocSinh(){
        n = 0;
        dshs = new HocSinh[n];
    }

    public DSHocSinh(HocSinh[] dshs, int n) {
        this.dshs = dshs;
        this.n = n;
    }

    @Override
    public void them(){
        super.them();
        int them = 0;
        System.out.print("\nNhập số lượng học sinh cần thêm: ");
        them = sc.nextInt();
        sc.nextLine(); //ENTER
        n += them;
        dshs = Arrays.copyOf(dshs,n);
        for(int i = n - them; i < n; i++){
            dshs[i] = new HocSinh();
            dshs[i].Nhap(); // dshs[0],dshs[1],dshs[2]
                             // 123456,234567,234567
                             
            boolean test = true; // chạy test 
            while(test){
                test = false; // thoát test
                for(int j = 0; j < i; j++){ //test lần 1
                    while(dshs[i].getMshs().equals(dshs[j].getMshs())){
                        System.err.println("Mã số học sinh đã tồn tại!!!\n"); // 123456
                        while(true){
                            System.out.print("\nNhập lại mã số học sinh: ");
                            if(dshs[i].setMshs(sc.nextLine()))
                                break;
                        }
                    }
                }
                for(int j = 0; j < i; j++){ //test lần 2
                    if(dshs[i].getMshs().equals(dshs[j].getMshs())){
                        test=true;
                        break;
                    }
                }
            }    
        }    
        System.out.print("\nThêm thành công!\n");
    }
    
    @Override 
    public void sua(){
        boolean exit = false,fix=false;
        
        int choose;
        super.sua();
        System.out.print("\nNhập mã số học sinh cần sửa: ");
        String mahs = sc.nextLine();

        for(int i = 0; i < n; i++){
            if(dshs[i].getMshs().equals(mahs)){
                fix=true;
                do {
                    System.out.print("\nĐang sửa thông tin học sinh có mã " + mahs + "...\n");
                    System.out.println("\n----- SỬA THÔNG TIN -----"); 
                    System.out.println("1. Mã số học sinh");
                    System.out.println("2. Họ tên học sinh"); 
                    System.out.println("3. Giới tính");
                    System.out.println("4. Địa chỉ");
                    System.out.println("5. Số điện thoại");
                    System.out.println("6. Email");
                    System.out.println("0. Thoát!");                      
                    System.out.println("-------------------------");
                    System.out.print("Mời bạn nhập lựa chọn: ");
                    choose = sc.nextInt();
                    sc.nextLine(); //ENTER

                    switch(choose) { 
                        case 1:
                            while(true){
                                System.out.print("\nNhập lại mã số học sinh: ");
                                if(dshs[i].setMshs(sc.nextLine()))
                                    break;
                            }
                            // kiểm tra trùng
                            boolean test = true; 
                            while(test){
                                test = false; 
                                for(int j = 0; j < i; j++){ 
                                    while(dshs[i].getMshs().equals(dshs[j].getMshs())){
                                        System.err.println("Mã số học sinh đã tồn tại!!!\n");
                                        while(true){
                                            System.out.print("\nNhập lại mã số học sinh: ");
                                            if(dshs[i].setMshs(sc.nextLine()))
                                                break;
                                        }
                                    }
                                }
                                for(int j = 0; j < i; j++){ 
                                    if(dshs[i].getMshs().equals(dshs[j].getMshs())){
                                        test=true;
                                        break;
                                    }
                                }
                            }
                            break;
                            
                        case 2: 
                            System.out.print("\nNhập lại tên học sinh: ");
                            String hoten = sc.nextLine();
                            dshs[i].setHoten(hoten);
                            break;

                        case 3: 
                            while(true){
                                System.out.print("\nNhập lại giới tính: ");
                                if(dshs[i].setGioitinh(sc.nextLine()))
                                    break;
                            }
                            break;

                        case 4: 
                            System.out.print("\nNhập lại địa chỉ: ");
                            String diachi = sc.nextLine();
                            dshs[i].setDiachi(diachi);
                            break;

                        case 5: 
                            while(true){
                                System.out.print("\nNhập lại số điện thoại: ");
                                if(dshs[i].setPhone(sc.nextLine()))
                                    break;
                            }
                            break;    
 
                        case 6: 
                            while(true){
                                System.out.print("\nNhập lại email: ");
                                if(dshs[i].setEmail(sc.nextLine()))
                                    break;
                            }
                            break;

                        case 0: 
                            exit = true;
                            System.out.print("\nThoát thành công!");
                            break;

                        default:
                            System.out.print("\nLựa chọn không hợp lệ! Vui lòng chọn lại...");
                            break;
                    }
                    if(exit == true)
                        break;
                    System.out.print("Đã sửa mã " + mahs + " thành công!\n");                  
                }
                while(true);
            }
        }
        if(fix==false)
            System.out.print("\nKhông tìm thấy thông tin học sinh có mã " + mahs + "!\n");
    }

    @Override 
    public void xoa(){
        boolean delete = false;
        super.xoa();
        System.out.print("\nNhập mã học sinh cần xóa: ");
        String mahs = sc.nextLine();

        for(int i = 0; i < n; i++){
            if(dshs[i].getMshs().equals(mahs)){
                for(int j = i; j < n - 1; j++){
                    dshs[j] = dshs[j + 1];
                }
                dshs = Arrays.copyOf(dshs, n - 1);
                System.out.print("Đã xóa mã " + mahs + " thành công!\n");
                n--;
                delete = true;
                break;
            }
        }
        if(delete == false)
            System.out.print("\nKhông tìm thấy thông tin học sinh có mã " + mahs + "!\n");
    }
      
    @Override
    public void timkiem(){
        boolean find = false;
        super.timkiem();
        System.out.print("\nTìm theo: ");
        System.out.print("\n1.Mã số học sinh");
        System.out.print("\n2.Họ tên học sinh"); 
        System.out.print("\n----------------------");
        System.out.print("\nMời nhập lựa chọn: ");
        int choose = sc.nextInt();
        sc.nextLine();
        
        if(choose == 1){
            System.out.print("\nNhập mã số học sinh cần tìm: ");
            String mahs = sc.nextLine();
            
            for(int i = 0; i < n; i++){
                if(dshs[i].getMshs().equals(mahs)){
                    find = true;
                    System.out.println("\nKết quả tìm thấy: ");
                    System.out.printf("%-8s %-10s %-20s %-10s %-20s %-20s %-20s ","STT","MSHS","Họ Tên","Giới Tính","Địa Chỉ","Số điện thoại","Email");
                    System.out.print("\n "+(i+1));
                    dshs[i].Xuat();
                    break;
                }
            }
            if(find == false)
                System.out.println("\nKhông tìm thấy thông tin học sinh có mã " + mahs + "!");
        }
            
        else if(choose == 2){
            System.out.print("Nhập họ tên học sinh cần tìm: ");
            String tenhs = sc.nextLine();
            
            for(int i = 0; i < n; i++){
                if(dshs[i].getHoten().equalsIgnoreCase(tenhs)){ //không phân biệt chữ hoa, thường
                    find = true;
                    System.out.println("\nKết quả tìm thấy:");  
                    System.out.printf("%-8s %-10s %-20s %-10s %-20s %-20s %-20s ","STT","MSHS","Họ Tên","Giới Tính","Địa Chỉ","Số điện thoại","Email");
                    System.out.print("\n "+(i+1));
                    dshs[i].Xuat();
                }          
            }
            if(find == false)
                System.out.println("\nKhông tìm thấy thông tin học sinh có tên " + tenhs + "!");
        }
        else
            System.out.println("Lựa chọn không hợp lệ!\n");
    }

    @Override
    public void sapxep(){
        super.sapxep();
        boolean exit = false;
        HocSinh temp = dshs[0];
        int choose;
        do {
            System.out.print("\nSắp xếp DSHS theo: ");
            System.out.print("\n1. Mã số học sinh");
            System.out.print("\n2. Họ tên học sinh");
            System.out.print("\n0. Thoát!");
            System.out.print("\n--------------------");
            System.out.print("\nMời nhập lựa chọn: ");
            choose = sc.nextInt();
            sc.nextLine(); //ENTER
            
            switch(choose){
                case 0: 
                    exit = true;
                    System.out.print("\nThoát thành công!");
                    break;

                case 1: 
                    for(int i = 0; i < n - 1; i++)
                        for(int j = i + 1; j < n; j++)
                            if(dshs[i].getMshs().compareTo(dshs[j].getMshs()) > 0){    
                                temp = dshs[i];
                                dshs[i] = dshs[j];
                                dshs[j] = temp;        
                            }
                    System.out.print("\nSắp xếp thành công!\n");
                    hienthi();
                    break;

                case 2:
                    for(int i = 0; i < n - 1; i++)
                        for(int j = i + 1; j < n; j++)
                            if(dshs[i].getHoten().compareTo(dshs[j].getHoten()) > 0){    
                                temp = dshs[i];
                                dshs[i] = dshs[j];
                                dshs[j] = temp;                             
                            }
                    System.out.print("\nSắp xếp thành công!\n");
                    hienthi();
                    break;

                default:
                    System.out.print("\nLựa chọn không hợp lệ! Vui lòng nhập lại...\n");
                    break;
            }
            if(exit == true)
                break;
        }while(true);
    }
    
    @Override
    public void hienthi(){
        System.out.println("\n----- DANH SÁCH HỌC SINH -----\n");
        System.out.printf("%-8s %-10s %-20s %-10s %-20s %-20s %-20s ","STT","MSHS","Họ Tên","Giới Tính","Địa Chỉ","Số điện thoại","Email");
        for(int i = 0; i < n; i++){
            System.out.print("\n "+(i+1));
            dshs[i].Xuat();
        }
    }
    
    @Override
    public void ghiFile(){
        super.ghiFile();
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("xuathocsinh.txt"));
            
            for(int i = 0; i < n; i++){ 
                fw.write(dshs[i].toString()); 
                fw.newLine();
            }
            fw.close();  
        } catch (Exception e) {
        }
        System.out.println("\nXuất file thành công!");
    }
    
    @Override
    public void docFile(){
        super.docFile();
        try {
            BufferedReader fr = new BufferedReader(new FileReader("hocsinh.txt"));
            String line = fr.readLine();
            while(line != null){
                String[] arr = line.split(",");
                dshs = Arrays.copyOf(dshs, ++n); 
                dshs[n-1] = new HocSinh(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]); 
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }
}