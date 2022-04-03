
package QLHS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class DSGiaoVien extends DanhSach {
    int n=0;
    GiaoVien[] dsgv;
    Scanner sc = new Scanner(System.in);

    public DSGiaoVien(){ 
        n = 0;
        dsgv = new GiaoVien[n];
    }

    public DSGiaoVien(int n, GiaoVien[] dsgv){
        this.n = n;
        this.dsgv = dsgv;
    }
    
    @Override
    public void them() {
        super.them();
        System.out.print("\nNhập số lượng giáo viên cần thêm: ");
        int x = sc.nextInt(); 
        sc.nextLine(); //ENTER
        n += x;
        dsgv = Arrays.copyOf(dsgv, n);        
        for(int i = n - x; i < n; i++){
            dsgv[i] = new GiaoVien();
            System.out.println();
            dsgv[i].Nhap();
        
            boolean test=true;
            while(test){
                test = false;
                for(int j = 0; j < i; j++){
                    while(dsgv[i].getMsgv().equals(dsgv[j].getMsgv())){
                        System.err.println("Mã số giáo viên đã tồn tại!!!\n");
                        while(true){
                            System.out.print("\nNhập lại mã số giáo viên: ");
                            if(dsgv[i].setMsgv(sc.nextLine()))
                                break;
                        }
                    }
                }
                for(int j = 0; j < i; j++){
                    if(dsgv[i].getMsgv().equals(dsgv[j].getMsgv())){
                        test=true;
                        break;
                    }
                }
            }
        }
        System.out.print("\nThêm thành công!\n");
    }
    
    @Override 
    public void sua() {
        boolean fix = false;
        boolean exit = false;
        int choose;
        super.sua();
        System.out.print("\nNhập mã giáo viên cần sửa: ");
        String magv =sc.nextLine();

        for(int i = 0; i < n; i++){
            if(dsgv[i].getMsgv().equals(magv)){
                do {
                    fix = true;
                    System.out.print("\nĐang sửa thông tin giáo viên có mã " + magv + "...\n");
                    System.out.print("\n----- SỬA THÔNG TIN -----");   
                    System.out.print("\n1. Mã số giáo viên");               
                    System.out.print("\n2. Họ tên giáo viên");
                    System.out.print("\n3. Giới tính");
                    System.out.print("\n4. Địa chỉ");
                    System.out.print("\n5. Số điện thoại");
                    System.out.print("\n6. Email");
                    System.out.print("\n0. Thoát!");                      
                    System.out.print("\n-------------------------");
                    System.out.print("\nMời bạn nhập lựa chọn: ");
                    choose = sc.nextInt();
                    sc.nextLine(); //ENTER

                    switch(choose) {
                        case 1: 
                            while(true){
                                System.out.print("\nNhập lại mã giáo viên: ");
                                if(dsgv[i].setMsgv(sc.nextLine()))
                                    break;
                            }
                            //kiểm tra trùng
                            boolean test=true;
                            while(test){
                                test = false;
                                for(int j = 0; j < i; j++){
                                    while(dsgv[i].getMsgv().equals(dsgv[j].getMsgv())){
                                        System.err.println("Mã số giáo viên đã tồn tại!!!\n");
                                        while(true){
                                            System.out.print("\nNhập lại mã số giáo viên: ");
                                            if(dsgv[i].setMsgv(sc.nextLine()))
                                                break;
                                        }
                                    }
                                }
                                for(int j = 0; j < i; j++){
                                    if(dsgv[i].getMsgv().equals(dsgv[j].getMsgv())){
                                        test=true;
                                        break;
                                    }
                                }
                            }
                            //kết thúc kiểm tra
                            System.out.print("Đã sửa mã " + magv + " thành công!\n");  
                            break;

                        case 2: 
                            System.out.print("\nNhập lại tên giáo viên: ");
                            String hoten = sc.nextLine();
                            dsgv[i].setHoten(hoten);
                            System.out.print("Đã sửa mã " + magv + " thành công!\n");  
                            break;

                        case 3: 
                            while(true){
                                System.out.print("\nNhập lại giới tính: ");
                                if(dsgv[i].setGioitinh(sc.nextLine()))
                                    break;
                            }
                            System.out.print("Đã sửa mã " + magv + " thành công!\n");  
                            break;

                        case 4: 
                            System.out.print("\nNhập lại địa chỉ nơi sống: ");
                            String diachi = sc.nextLine();
                            dsgv[i].setDiachi(diachi);
                            System.out.print("Đã sửa mã " + magv + " thành công!\n");  
                            break;

                        case 5: 
                            while(true){
                                System.out.print("\nNhập lại số điện thoại: ");
                                if(dsgv[i].setPhone(sc.nextLine()))
                                    break;
                            }
                            System.out.print("Đã sửa mã " + magv + " thành công!\n");  
                            break;  
 
                        case 6: 
                            while(true){
                                System.out.print("\nNhập lại email: ");
                                if(dsgv[i].setEmail(sc.nextLine()))
                                    break;
                            }
                            System.out.print("Đã sửa mã " + magv + " thành công!\n");  
                            break;

                        case 0: 
                            exit = true;
                            System.out.print("\nThoát thành công!");
                            break;

                        default:
                            System.out.print("\nLựa chọn không hợp lệ! Vui lòng nhập lại...\n");
                            break;
                    }
                    if(exit == true)
                        break;                 
                }
                while(true);
            }
        }
        if(fix == false)
            System.out.print("\nKhông tìm thấy thông tin giáo viên có mã " + magv + "!\n");
    }

    @Override
    public void xoa(){
        boolean delete = false;
        super.xoa();
        System.out.print("\nNhập mã số giáo viên cần xóa: ");
        String magv =sc.nextLine();

        for(int i = 0; i < n; i++){
            if(dsgv[i].getMsgv().equals(magv)){
                for(int j = i; j < n - 1; j++){
                    dsgv[j] = dsgv[j + 1];
                }
                dsgv = Arrays.copyOf(dsgv, n - 1);
                System.out.print("Đã xóa mã " + magv + " thành công!\n");
                n--;
                delete = true;
                break;
            }
        }
        if(delete == false)
            System.out.print("\nKhông tìm thấy thông tin giáo viên có mã " + magv + "!\n");
    }

    @Override
    public void timkiem(){
        boolean find = false;
        super.timkiem();
        System.out.print("Tìm theo: ");
        System.out.print("\n1. Mã số giáo viên");
        System.out.print("\n2. Họ tên giáo viên");
        System.out.print("\n----------------------");
        System.out.print("\nMời nhập lựa chọn: ");
        int choose = sc.nextInt();
        sc.nextLine();

        if(choose == 1){
            System.out.print("Nhập mã số giáo viên cần tìm: ");
            String magv = sc.nextLine();
            
            for(int i = 0; i < n; i++){
                if(dsgv[i].getMsgv().equals(magv)){
                    find = true;
                    System.out.println("\nKết quả tìm thấy: ");
                    System.out.printf("%-8s %-10s %-20s %-10s %-20s %-20s %-20s ","STT","MSGV","Họ Tên","Giới Tính","Địa Chỉ","Số điện thoại","Email");
                    System.out.print("\n "+(i+1));
                    dsgv[i].Xuat();
                    break;
                }
            }
            if(find == false)
                System.out.println("\nKhông tìm thấy thông tin giáo viên có mã " + magv + "!");
        }
            
        else if(choose == 2){
            System.out.print("Nhập họ tên giáo viên cần tìm: ");
            String tengv = sc.nextLine();
        
            for(int i = 0; i < n; i++){
                if(dsgv[i].getHoten().equalsIgnoreCase(tengv)){ //không phân biệt chữ hoa, thường
                    find = true;
                    System.out.println("\nKết quả tìm thấy:");  
                    System.out.printf("%-8s %-10s %-20s %-10s %-20s %-20s %-20s ","STT","MSGV","Họ Tên","Giới Tính","Địa Chỉ","Số điện thoại","Email");
                    System.out.print("\n "+(i+1));
                    dsgv[i].Xuat();
                }          
            }
            if(find == false)
                System.out.println("\nKhông tìm thấy thông tin giáo viên có tên " + tengv + "!");
        }
        else
            System.out.println("Lựa chọn không hợp lệ!\n");
    }

    @Override
    public void sapxep(){
        super.sapxep();
        boolean exit = false;
        GiaoVien temp = dsgv[0];
        int choose;
        do {
            System.out.print("\nSắp xếp DSGV theo: ");
            System.out.print("\n1. Mã số giáo viên");
            System.out.print("\n2. Họ tên giáo viên");
            System.out.print("\n0. Thoát!");
            System.out.print("\n--------------------");
            System.out.print("\nMời nhập lựa chọn: ");
            choose = sc.nextInt();
            sc.nextLine(); //ENTER
            
                    switch(choose){
                        case 1: 
                            for(int i = 0; i < n - 1; i++)
                                for(int j = i + 1; j < n; j++)
                                    if(dsgv[i].getMsgv().compareTo(dsgv[j].getMsgv()) > 0){    
                                        temp = dsgv[i];
                                        dsgv[i] = dsgv[j];
                                       dsgv[j] = temp;     
                                    }
                            System.out.print("\nSắp xếp thành công!\n");
                            hienthi();
                            break;

                        case 2: 
                            for(int i = 0; i < n - 1; i++)
                                for(int j = i + 1; j < n; j++)
                                    if(dsgv[i].getHoten().compareTo(dsgv[j].getHoten()) > 0){    
                                        temp = dsgv[i];
                                        dsgv[i] = dsgv[j];
                                        dsgv[j] = temp;                            
                                    }
                            System.out.print("\nSắp xếp thành công!\n");
                            hienthi();
                            break;
                        
                        case 0: 
                            exit = true;
                            System.out.print("\nThoát thành công!\n");
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
    public void hienthi() {
        System.out.println("\n----- DANH SÁCH GIÁO VIÊN -----\n");
        System.out.printf("%-8s %-10s %-20s %-10s %-20s %-20s %-20s ","STT","MSGV","Họ Tên","Giới Tính","Địa Chỉ","Số điện thoại","Email");
        for(int i = 0; i < n; i++){
            System.out.print("\n "+(i+1));
            dsgv[i].Xuat();
        }
    }
    
    @Override
    public void ghiFile(){
        super.ghiFile();
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("xuatgiaovien.txt"));
            
            for(int i = 0; i < n; i++){
                fw.write(dsgv[i].toString());
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
            BufferedReader fr = new BufferedReader(new FileReader("giaovien.txt"));
            String line = fr.readLine();
            while(line != null){
                String[] arr = line.split(",");
                dsgv = Arrays.copyOf(dsgv, ++n);
                dsgv[n-1] = new GiaoVien(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }
}
