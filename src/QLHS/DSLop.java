
package QLHS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class DSLop extends DanhSach{
    Scanner sc = new Scanner(System.in);
    int n=0;
    Lop[] dsl;
    
    public DSLop(){
        n = 0;
        dsl = new Lop[0];
    }
    
    public DSLop(int n, Lop[] dsl){
        this.n = n;
        this.dsl = dsl;
    }
    
    @Override
    public void them() {
        super.them();
        boolean exit = false;
        int choose;
        do{
            System.out.print("\n------- Thêm Lớp -------");
            System.out.print("\n1. Khối 10");
            System.out.print("\n2. Khối 11"); 
            System.out.print("\n3. Khối 12");
            System.out.print("\n0. Thoát");
            System.out.print("\n------------------------");
            System.out.print("\nMời bạn nhập lựa chọn: ");
            choose = sc.nextInt();
            sc.nextLine(); //ENTER

            switch(choose){
                case 0:
                    exit = true;
                    break;

                case 1:
                    System.out.print("\nNhập số lượng lớp cần thêm: ");
                    int x = sc.nextInt();
                    sc.nextLine(); //ENTER
                    n += x;
                    dsl = Arrays.copyOf(dsl, n);        
                    for(int i = n - x; i < n; i++){
                        dsl[i] = new Lop();
                        dsl[i].setKhoi(10);
                        dsl[i].Nhap();
                        // kiểm tra trùng 
                        boolean test = true;
                        while(test){
                            test = false;
                            for(int j = 0; j < i; j++){
                                while(dsl[i].getMalop().equals(dsl[j].getMalop()) && dsl[j].getKhoi() == 10 ){
                                    System.err.println("Mã số lớp đã tồn tại!!!\n");
                                    while(true){
                                        System.out.print("\nNhập lại mã số lớp: ");
                                        if(dsl[i].setMalop(sc.nextLine()))
                                            break;
                                    }
                                }
                            }
                            for(int j = 0; j < i; j++){
                                if(dsl[i].getMalop().equals(dsl[j].getMalop())){
                                    test = true; 
                                    break;
                                }
                            }
                        }
                    }
                    System.out.print("\nThêm thành công!\n");
                    break;

                case 2:
                    System.out.print("\nNhập số lượng lớp cần thêm: ");
                    int x2 = sc.nextInt();
                    sc.nextLine(); //ENTER
                    n += x2;
                    dsl = Arrays.copyOf(dsl, n);        
                    for(int i = n - x2; i < n; i++){
                        dsl[i] = new Lop();
                        dsl[i].setKhoi(11);
                        dsl[i].Nhap();
                        boolean test = true;
                        while(test){
                            test = false;
                            for(int j = 0; j < i; j++){
                                while(dsl[i].getMalop().equals(dsl[j].getMalop()) && dsl[j].getKhoi() == 11 ){
                                    System.err.println("Mã số lớp đã tồn tại!!!\n");
                                    while(true){
                                        System.out.print("\nNhập lại mã số lớp: ");
                                        if(dsl[i].setMalop(sc.nextLine()))
                                            break;
                                    }
                                }
                            }
                            for(int j = 0; j < i; j++){
                                if(dsl[i].getMalop().equals(dsl[j].getMalop())){
                                    test = true; 
                                    break;
                                }
                            }
                        }
                    }
                    System.out.print("\nThêm thành công!\n");
                    break;

                case 3:
                    System.out.print("\nNhập số lượng lớp cần thêm: ");
                    int x3 = sc.nextInt(); 
                    sc.nextLine(); //ENTER
                    n += x3;
                    dsl = Arrays.copyOf(dsl, n);        
                    for(int i = n - x3; i < n; i++){
                        dsl[i] = new Lop();
                        dsl[i].setKhoi(12);
                        dsl[i].Nhap();
                        boolean test = true;
                        while(test){
                            test = false;
                            for(int j = 0; j < i; j++){
                                while(dsl[i].getMalop().equals(dsl[j].getMalop()) && dsl[j].getKhoi() == 12 ){
                                    System.err.println("Mã số lớp đã tồn tại!!!\n");
                                    while(true){
                                        System.out.print("\nNhập lại mã số lớp: ");
                                        if(dsl[i].setMalop(sc.nextLine()))
                                            break;
                                    }
                                }
                            }
                            for(int j = 0; j < i; j++){
                                if(dsl[i].getMalop().equals(dsl[j].getMalop())){
                                    test = true; 
                                    break;
                                }
                            }
                        }
                    }
                    System.out.print("\nThêm thành công!\n");
                    break; 

                default:
                    System.err.print("\nLựa chọn không hợp lệ! Vui lòng nhập lại...\n");
                    break;
            }
            if(exit)
                break;
        }
        while(true);
    }

    @Override
    public void sua() {
        boolean fix = false;
        boolean exit = false;
        int choose;
        super.sua();
        System.out.print("\nNhập mã lớp cần sửa: ");
        String masolop = sc.nextLine();
        
        for(int i = 0; i < n; i++){
            if(dsl[i].getMalop().equals(masolop)){
                do {
                    fix = true;
                    System.out.print("\nĐang sửa thông tin lớp có mã " + masolop + "...\n");   
                    System.out.print("\n----- SỬA THÔNG TIN -----");
                    System.out.print("\n1. Mã lớp");
                    System.out.print("\n2. Sĩ số lớp");
                    System.out.print("\n0. Thoát!");
                    System.out.print("\n-------------------------");
                    System.out.print("\nMời bạn nhập lựa chọn: ");
                    choose = sc.nextInt();
                    sc.nextLine(); //ENTER

                    switch(choose) {
                        case 1: 
                            while(true){
                                System.out.print("\nNhập lại mã số lớp: ");
                                if(dsl[i].setMalop(sc.nextLine()))
                                    break;
                            }
                            
                            boolean test = true;
                            while(test){
                                test = false;
                                for(int j = 0; j < i; j++){
                                    while(dsl[i].getMalop().equals(dsl[j].getMalop())){
                                        System.err.println("Mã số lớp đã tồn tại!!!\n");
                                        while(true){
                                            System.out.print("\nNhập lại mã số lớp: ");
                                            if(dsl[i].setMalop(sc.nextLine()))
                                                break;
                                        }
                                    }
                                }
                                for(int j = 0; j < i; j++){
                                    if(dsl[i].getMalop().equals(dsl[j].getMalop())){
                                        test = true; 
                                        break;
                                    }
                                }
                            }
                            break;

                        case 2: 
                            while(true){
                                System.out.print("\nNhập lại sĩ số lớp: ");
                                if(dsl[i].setSiso(sc.nextInt()))
                                    break;
                                sc.nextLine(); //ENTER
                            }
                            break;

                        case 0:
                            exit = true;
                            System.out.print("\nThoát thành công!");
                            break;
                        
                        default:
                            System.out.print("\nLựa chọn không hợp lệ! Vui lòng nhập lại!");
                            break;
                    }
                    if(exit == true)
                        break;
                    System.out.print("Đã sửa mã " + masolop + " thành công!\n");                   
                }
                while(true);
            }
        }
        if(fix == false)
            System.out.print("\nKhông tìm thấy thông tin lớp có mã " + masolop + "!\n");
    }
     
    @Override
    public void xoa(){
        boolean delete = false;
        super.xoa();
        System.out.print("\nNhập mã số lớp cần xóa: ");
        String masolop = sc.nextLine();

        for(int i = 0; i < n; i++){
            if(dsl[i].getMalop().equals(masolop)){
                for(int j = i; j < n - 1; j++){
                    dsl[j] = dsl[j + 1];
                }
                dsl = Arrays.copyOf(dsl, n - 1);
                System.out.print("Đã xóa mã " + masolop + " thành công!\n"); 
                n--;
                delete = true;
                break;
            }
        }
        if(delete == false)
            System.out.print("\nKhông tìm thấy thông tin lớp có mã " + masolop + "!\n");
    }
    
    @Override
    public void timkiem(){
        boolean find = false;
        super.timkiem();
        System.out.print("\nNhập mã số lớp cần tìm: ");
        String masolop = sc.nextLine();
        for(int i = 0; i < n; i++){
            if(dsl[i].getMalop().equalsIgnoreCase(masolop)){
                find = true;
                System.out.println("\nKết quả tìm thấy: ");
                System.out.printf("%-10s %-20s %-10s %-10s ","STT","Mã số lớp","Sĩ số","Khối");
                System.out.print("\n "+(i+1));
                dsl[i].Xuat();
            }
        }
        if(find == false)
            System.out.print("\nKhông tìm thấy thông tin lớp có mã " + masolop + "!\n");
    }
    
    @Override
    public void sapxep(){
        super.sapxep();
        Lop temp = dsl[0];
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(dsl[i].getMalop().compareTo(dsl[j].getMalop()) > 0){    
                    temp = dsl[i];
                    dsl[i] = dsl[j];
                    dsl[j] = temp;     
                }
            }
        }
        System.out.print("\nSắp xếp thành công!\n");
    }
    
    @Override
    public void hienthi() {
        System.out.println("\n----- DANH SÁCH LỚP -----");
        System.out.printf("%-10s %-20s %-10s %-10s ","STT","Mã số lớp","Sĩ số","Khối");
        for(int i = 0; i < n; i++){
            System.out.print("\n "+(i+1));
            dsl[i].Xuat();
        }
    }

    @Override
    public void ghiFile(){
        super.ghiFile();
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("xuatlop.txt"));
            
            for(int i = 0; i < n; i++){
                fw.write(dsl[i].toString());
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
            BufferedReader fr = new BufferedReader(new FileReader("lop.txt"));
            String line = fr.readLine();
            while(line != null){
                String[] arr = line.split(",");
                dsl = Arrays.copyOf(dsl, ++n);
                dsl[n-1] = new Lop(arr[0],Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }   
}

