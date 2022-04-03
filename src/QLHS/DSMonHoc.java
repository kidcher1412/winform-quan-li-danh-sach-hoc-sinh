
package QLHS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class DSMonHoc extends DanhSach{
    Scanner sc = new Scanner(System.in);
    int n=0;
    MonHoc[] dsmh;
    
    public DSMonHoc(){
        n = 0;
        dsmh = new MonHoc[0];
    }

    public DSMonHoc(int n, MonHoc[] ds){
        this.n = n;
        this.dsmh = dsmh;
    }
    
    @Override
    public void them(){
        super.them();
        System.out.print("\nNhập số lượng môn học cần thêm: ");
        int x = sc.nextInt();
        sc.nextLine(); //ENTER
        n += x;
        dsmh = Arrays.copyOf(dsmh, n);        
        for(int i = n - x; i < n; i++){
            dsmh[i] = new MonHoc();
            dsmh[i].Nhap();

            boolean test = true;
            while(test){
                test = false;
                for(int j = 0; j < i; j++){
                    while(dsmh[i].getMamh().equals(dsmh[j].getMamh())){
                        System.err.println("Mã số môn học đã tồn tại!!!\n");
                        while(true){
                            System.out.print("\nNhập lại mã số môn học: ");
                            if(dsmh[i].setMamh(sc.nextLine()))
                                break;
                        }
                    }
                }
                for(int j = 0; j < i; j++){
                    if(dsmh[i].getMamh().equals(dsmh[j].getMamh())){
                        test = true; 
                        break;
                    }
                }
            }
        }
        System.out.print("\nThêm thành công!\n");
    }

    @Override
    public void sua(){
        boolean fix = false;  
        boolean exit = false;
        super.sua();
        System.out.print("\nNhập mã môn học muốn sửa: ");
        String mamh = sc.nextLine();
        
        for(int i = 0; i < n; i++){
            if(dsmh[i].getMamh().equals(mamh)){
                fix = true;
                System.out.print("\nĐang sửa thông tin môn học có mã " + mamh + "...\n"); 
                int choose;
                do{
                    System.out.print("\n----- SỬA THÔNG TIN -----");
                    System.out.print("\n1. Mã môn học");
                    System.out.print("\n2. Tên môn học");  
                    System.out.print("\n3. Số tiết");
                    System.out.print("\n0. Thoát!");
                    System.out.print("\n-------------------------");
                    System.out.print("\nChọn nội dung bạn muốn sửa:");
                    choose = sc.nextInt();
                    sc.nextLine(); //ENTER
                
                    switch(choose){
                        case 1:
                            while(true){    
                            System.out.print("\nSửa mã môn học thành: ");
                            if(dsmh[i].setMamh(sc.nextLine()))
                                break;
                            }
                            boolean test = true;
                            while(test){
                                test = false;
                                for(int j = 0; j < i; j++){
                                    while(dsmh[i].getMamh().equals(dsmh[j].getMamh())){
                                        System.err.println("Mã số môn học đã tồn tại!!!\n");
                                        while(true){
                                            System.out.print("\nNhập lại mã số môn học: ");
                                            if(dsmh[i].setMamh(sc.nextLine()))
                                                break;
                                        }
                                    }
                                }
                                for(int j = 0; j < i; j++){
                                    if(dsmh[i].getMamh().equals(dsmh[j].getMamh())){
                                        test = true; 
                                        break;
                                    }
                                }
                            }
                            break;

                        case 2:
                            System.out.print("\nSửa tên môn học thành: ");
                            String tenmh_new = sc.nextLine();
                            dsmh[i].setTenmh(tenmh_new);
                            break;

                        case 3:
                            while(true){    
                                System.out.print("\nSửa số tiết thành: ");
                                if(dsmh[i].setSotiet(sc.nextInt()))
                                    break;
                                sc.nextLine(); // ENTER
                            }
                            break;
                        
                        case 0:
                            exit = true;
                            System.out.print("\nThoát thành công!");
                            break;
                        
                        default:   
                            System.out.println("\nLựa chọn không hợp lệ! Vui lòng nhập lại...");
                            break;
                    }
                    if(exit == true)
                        break;
                }
                while(true);
            }
        }
        if(fix == false) 
            System.out.println("\nKhông tìm thấy mã môn học " + mamh + "!\n");
        
    }

    @Override
    public void xoa(){ 
        boolean delete = false;
        super.xoa();
        System.out.print("\nNhập mã môn học cần xóa: ");
        String mamh = sc.nextLine();

        for(int i = 0; i < n; i++){
            if(dsmh[i].getMamh().equals(mamh)){
                for(int j = i; j < n-1; j++){
                    dsmh[j] = dsmh[j+1];
                }
                dsmh = Arrays.copyOf(dsmh, n-1);
                n--;
                delete = true;
                break;
            }
        }
        if(delete == true)
            System.out.println("\nĐã xóa mã " + mamh + " thành công!\n");
        else
            System.out.println("\nKhông tìm thấy mã môn học " + mamh + "!\n");
    }

    @Override
    public void timkiem(){
        boolean find = false;
        super.timkiem();
        System.out.print("Tìm theo: ");
        System.out.print("\n1. Mã môn học");
        System.out.print("\n2. Tên môn học");
        System.out.print("\n----------------------");
        System.out.print("\nMời nhập lựa chọn: ");
        int choose = sc.nextInt();
        sc.nextLine(); //ENTER

        if(choose == 1){
            System.out.print("Nhập mã môn học cần tìm: ");
            String mamh = sc.nextLine();
            
            for(int i = 0; i < n; i++){
                if(dsmh[i].getMamh().equals(mamh)){
                    find = true;
                    System.out.println("\nKết quả tìm thấy:");
                    System.out.printf("%-20s %-20s %-15s\n","mã môn học","tên môn học","số tiết");
                    dsmh[i].Xuat();
                    break;
                }           
            }
            if(find == false)  
                System.out.println("\nKhông tìm thấy mã môn học " + mamh + "!\n");   
        }
        else if(choose == 2){
            System.out.print("Nhập tên môn học cần tìm: ");
            String tenmh = sc.nextLine();
            
            for(int i = 0; i < n; i++){
                if(dsmh[i].getTenmh().equalsIgnoreCase(tenmh)){ //không phân biệt chữ hoa, thường
                    find = true;
                    System.out.println("\nKết quả tìm thấy:");
                    System.out.printf("%-20s %-20s %-15s\n","mã môn học","tên môn học","số tiết");
                    dsmh[i].Xuat();
                }          
            }
            if(find == false)    
                System.out.println("\nKhông tìm thấy môn " + tenmh + "!");                
        }
        else
            System.out.println("Lựa chọn không hợp lệ!\n");
    }

    @Override
    public void sapxep(){
        super.sapxep();
        boolean exit = false;
        MonHoc temp = dsmh[0];
        int choose;
        do {
            System.out.print("\nSắp xếp DS môn học theo: ");
            System.out.print("\n1. Mã môn học");
            System.out.print("\n2. Tên môn học");
            System.out.print("\n0. Thoát!");
            System.out.print("\n--------------------");
            System.out.print("\nMời nhập lựa chọn: ");
            choose = sc.nextInt();
            sc.nextLine(); //ENTER
            
                    switch(choose){
                        case 1: {
                            for(int i = 0; i < n - 1; i++)
                                for(int j = i + 1; j < n; j++)
                                    if(dsmh[i].getMamh().compareTo(dsmh[j].getMamh()) > 0){    
                                        temp = dsmh[i];
                                        dsmh[i] = dsmh[j];
                                        dsmh[j] = temp;     
                                    }
                            System.out.print("\nSắp xếp thành công!\n");
                            hienthi();
                            break;
                            
                        }

                        case 2: {
                            for(int i = 0; i < n - 1; i++)
                                for(int j = i + 1; j < n; j++)
                                    if(dsmh[i].getTenmh().compareTo(dsmh[j].getTenmh()) > 0){    
                                        temp = dsmh[i];
                                        dsmh[i] = dsmh[j];
                                        dsmh[j] = temp;     
                                    }
                            System.out.print("\nSắp xếp thành công!\n");
                            hienthi();
                            break;
                        }
                        
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

    @Override
    public void hienthi(){
        System.out.println("\n----- DANH SÁCH MÔN HỌC -----\n");
        System.out.printf("%-20s %-20s %-15s\n","mã môn học","tên môn học","số tiết");
        for(int i = 0; i < n; i++){
            dsmh[i].Xuat();
        }
    }
    
    @Override
    public void ghiFile(){
        super.ghiFile();
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("xuatmonhoc.txt"));
            
            for(int i = 0; i < n; i++){
                fw.write(dsmh[i].toString());
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
            BufferedReader fr = new BufferedReader(new FileReader("monhoc.txt"));
            String line = fr.readLine();
            while(line != null){
                String[] arr = line.split(",");
                dsmh = Arrays.copyOf(dsmh, ++n);
                dsmh[n-1] = new MonHoc(arr[0], arr[1], Integer.parseInt(arr[2]));
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }
}