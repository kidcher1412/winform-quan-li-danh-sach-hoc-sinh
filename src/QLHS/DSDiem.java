
package QLHS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class DSDiem extends DanhSach{
    Scanner sc = new Scanner(System.in);
    KetQua[] dsd;
    int n=0;

    public DSDiem() {
        n = 0;
        dsd = new KetQua[0];
    }

    public DSDiem(KetQua[] dsd, int n) {
        this.dsd = dsd;
    }

    @Override
    public void them(){
        super.them();
        System.out.print("\nNhập số lượng học sinh cần thêm: ");
        int x = sc.nextInt(); 
        sc.nextLine(); //ENTER
        n += x;
        dsd = Arrays.copyOf(dsd, n);        
        for(int i = n - x; i < n; i++){
            dsd[i] = new KetQua();
            System.out.println();
            dsd[i].Nhap();
            //kiểm tra trùng
            boolean test = true;
            while(test){
                test = false;
                for(int j = 0; j < i; j++){
                    while(dsd[i].getMaHS().equals(dsd[j].getMaHS())){
                        System.err.println("Mã số học sinh đã tồn tại!!!\n");
                        while(true){
                            System.out.print("\nNhập lại mã số môn học: ");
                            if(dsd[i].setMaHS(sc.nextLine()))
                                break;
                        }
                    }
                }
                for(int j = 0; j < i; j++){
                    if(dsd[i].getMaHS().equals(dsd[j].getMaHS())){
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
        System.out.print("\nNhập mã học sinh muốn sửa: ");
        String mahs = sc.nextLine();

        for(int i = 0; i < n; i++){
            if(dsd[i].getMaHS().equals(mahs)){
                fix = true;
                System.out.print("\nĐang sửa thông tin học sinh có mã " + mahs + "...\n");
                int choose;
                do{
                    System.out.print("\n----- SỬA THÔNG TIN -----");
                    System.out.print("\n1. Mã số học sinh");
                    System.out.print("\n2. Điểm 15 phút");
                    System.out.print("\n3. Điểm 1 tiết");
                    System.out.print("\n4. Điểm thi");
                    System.out.print("\n5. Hạnh Kiểm");
                    System.out.print("\n6. Học Kỳ");
                    System.out.print("\n0. Thoát!");
                    System.out.print("\n-------------------------");
                    System.out.print("\nChọn nội dung bạn muốn sửa: ");
                    choose = sc.nextInt();
                    sc.nextLine(); //ENTER
                
                    switch(choose){
                        case 1:
                            while(true){
                                System.out.print("\nNhập lại mã số học sinh: ");
                                if(dsd[i].setMaHS(sc.nextLine()))
                                    break;
                            }
                            // kiểm tra trùng
                            boolean test = true; 
                            while(test){
                                test = false; 
                                for(int j = 0; j < i; j++){ 
                                    while(dsd[i].getMaHS().equals(dsd[j].getMaHS())){
                                        System.err.println("Mã số học sinh đã tồn tại!!!\n");
                                        while(true){
                                            System.out.print("\nNhập lại mã số học sinh: ");
                                            if(dsd[i].setMaHS(sc.nextLine()))
                                                break;
                                        }
                                    }
                                }
                                for(int j = 0; j < i; j++){ 
                                    if(dsd[i].getMaHS().equals(dsd[j].getMaHS())){
                                        test=true;
                                        break;
                                    }
                                }
                            }
                            break;
                            
                        case 2:{
                            while(true){    
                                System.out.print("\nSửa điểm 15 phút thành: ");
                                if(dsd[i].setDiem15phut(sc.nextFloat()))
                                    break;
                                sc.nextLine(); //ENTER
                            }
                            System.out.println("\nĐã sửa kết quả của học sinh có mã " + mahs + " thành công!\n");
                            break;
                        }

                        case 3:{
                            while(true){    
                                System.out.print("\nSửa điểm 1 tiết thành: ");
                                if(dsd[i].setDiem1tiet(sc.nextFloat()))
                                    break;
                                sc.nextLine(); //ENTER
                            }
                            System.out.println("\nĐã sửa kết quả của học sinh có mã " + mahs + " thành công!\n");
                            break;
                        }

                        case 4:{
                            while(true){    
                                System.out.print("\nSửa điểm thi thành: ");
                                if(dsd[i].setDiemThi(sc.nextFloat()))
                                    break;
                                sc.nextLine(); //ENTER
                            }
                            System.out.println("\nĐã sửa kết quả của học sinh có mã " + mahs + " thành công!\n");
                            break;
                        }

                        case 5:{
                            while(true){    
                                System.out.print("\nSửa điểm hạnh kiểm thành: ");
                                if(dsd[i].setHanhKiem(sc.nextInt()))
                                    break;
                                sc.nextLine(); //ENTER
                            }
                            System.out.println("\nĐã sửa kết quả của học sinh có mã " + mahs + " thành công!\n");
                            break;
                        }                   
                        
                        case 6:{
                            while(true){    
                                System.out.print("\nSửa học kỳ thành: ");
                                if(dsd[i].setHocKy(sc.nextInt()))
                                    break;
                                sc.nextLine(); //ENTER
                            }
                            System.out.println("\nĐã sửa kết quả của học sinh có mã " + mahs + " thành công!\n");
                            break;
                        }

                        case 0:{
                            exit = true;
                            System.out.print("\nThoát thành công!");
                            break;
                        }

                        default:{    
                            System.out.print("\nLựa chọn không hợp lệ! Vui lòng nhập lại...\n");
                            break;
                        }
                    }
                    if(exit == true)
                        break;
                } 
                while(true);
            }
        }
        if(fix == false)
            System.out.println("\nKhông tìm thấy thông tin học sinh có mã " + mahs + "!");     
    }
    
    @Override 
    public void xoa(){ 
        boolean delete = false;
        super.xoa();
        System.out.print("\nNhập mã học sinh cần xóa: ");
        String mahs = sc.nextLine();

        for(int i = 0; i < n; i++){
            if(dsd[i].getMaHS().equals(mahs)){
                for(int j = i; j < n-1; j++){
                    dsd[j] = dsd[j+1];
                }
                dsd = Arrays.copyOf(dsd, n-1);
                n--;
                delete = true;
                break;
            }
        }
        if(delete == true)
            System.out.print("\nĐã xóa học sinh có mã " + mahs + " thành công!\n");
        else
            System.out.print("\nKhông tìm thấy thông tin học sinh có mã " + mahs + "!");
    }

    @Override 
    public void timkiem(){  
        boolean find = false;
        super.timkiem();
        System.out.print("\nNhập mã học sinh cần xem kết quả: ");
        String mahs = sc.nextLine();
        
        for(int i = 0; i < n; i++){
            if(dsd[i].getMaHS().equals(mahs)){
                find = true;
                System.out.println("\nKết quả tìm thấy:");
                //System.out.println("STT" + "\tMSHS" + "\tĐiểm 15 phút" + "\tĐiểm 1 tiết" + "\tĐiểm thi" + "\tĐiểm trung bình" + "\tHạnh kiểm" + "\tHọc kỳ");
                System.out.print("STT: " + (i+1) + "\n");
                dsd[i].Xuat();
                break;
            }           
        }
        if(find == false) {   
            System.out.println("\nKhông tìm thấy thông tin học sinh có mã " + mahs + "!");             
        }
    }

    @Override
    public void sapxep(){
        super.sapxep();
        boolean exit = false;
        KetQua temp = dsd[0];
        int choose;
        do {
            System.out.print("Sắp xếp DS điểm theo: ");
            System.out.print("\n1. Mã số học sinh");
            System.out.print("\n2. Điểm trung bình");
            System.out.print("\n0. Thoát!");
            System.out.print("\n--------------------");
            System.out.print("\nMời nhập lựa chọn: ");
            choose = sc.nextInt();
            sc.nextLine(); //ENTER
            
            switch(choose){
                case 1: 
                    for(int i = 0; i < n - 1; i++)
                        for(int j = i + 1; j < n; j++)
                            if(dsd[i].getMaHS().compareTo(dsd[j].getMaHS()) > 0){    
                                temp = dsd[i];
                                dsd[i] = dsd[j];
                                dsd[j] = temp;     
                            }
                    break;

                case 2: 
                    for(int i = 0; i < n - 1; i++)
                        for(int j = i + 1; j < n; j++)
                            if(dsd[i].DiemTrungBinh() > dsd[j].DiemTrungBinh()){
                                temp = dsd[i];
                                dsd[i] = dsd[j];
                                dsd[j] = temp;
                            }  
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
                System.out.println("\nSắp xếp thành công!\n");
        }
        while(true);
    }

    @Override
    public void hienthi(){
        System.out.println("\n----- DANH SÁCH ĐIỂM -----\n");
        //System.out.println("STT" + "\tMSHS" + "\tĐiểm 15 phút" + "\tĐiểm 1 tiết" + "\tĐiểm thi" + "\tĐiểm trung bình" + "\tHạnh kiểm" + "\tHọc kỳ");
        for(int i = 0; i < n; i++){
            System.out.print("STT: " + (i+1) + "\n");
            dsd[i].Xuat();
        }
    }
    
    @Override
    public void ghiFile(){
        super.ghiFile();
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("xuatdiem.txt"));
            
            for(int i = 0; i < n; i++){
                fw.write(dsd[i].toString());
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
            BufferedReader fr = new BufferedReader(new FileReader("diem.txt"));
            String line = fr.readLine();
            while(line != null){
                String[] arr = line.split(",");
                dsd = Arrays.copyOf(dsd, ++n);
                dsd[n-1] = new KetQua(arr[0],Float.parseFloat(arr[1]),Float.parseFloat(arr[2]),Float.parseFloat(arr[3]),Integer.parseInt(arr[4]),Integer.parseInt(arr[5]));
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }    
}
