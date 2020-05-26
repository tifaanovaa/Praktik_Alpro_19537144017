import java.util.Scanner;

class Mahasiswa {
    private String nim;
    private String nama;

    public String getNIM() {
        return this.nim;
    }


    public void setData(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public void getData() {
        System.out.println(this.nim+"  "+this.nama);
    }
}
   
 public class Siakad {
    static int indexData = 0;
    static Mahasiswa[] data = new Mahasiswa[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("Menu");
            System.out.println("1. Masukkan data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Cari data");
            System.out.println("4. Edit data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu = ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1: {
                    String pilihan = "y";
                    do {
                        System.out.println("Silahkan masukkan data");
                        System.out.print("Masukkan NIM = ");
                        String nim = scanner.next();
                        System.out.print("Masukkan Nama = ");
                        String nama = scanner.next();
                        data[indexData] = new Mahasiswa();
                        //siakad.createData(NIM, Nama);
                        data[indexData].setData(nim, nama);
                        indexData++;
                        System.out.print("Masukkan data lagi? (y/t) = ");
                        pilihan = scanner.next();
                    } while (pilihan.equals("y"));
                } break;
                case 2: {
                    System.out.println("Berikut adalah daftar anda");
                    //siakad.readData();
                    for(int i=0; i<indexData; i++) {
                        data[i].getData();
                    };
                } break;
                case 3: {
                    System.out.print("Masukkan NIM data yang Anda cari = ");
                    String nim  = scanner.next();
                    int index = cariMahasiswa(nim);
                    if (index==999) {
                        System.out.println("Data yang Anda cari tidak ada");
                    } else {
                        System.out.println("Berikut data yang Anda cari");
                        data[index].getData();
                    }
                } break;
                case 4: {
                    System.out.print("Masukkan NIM data yang Anda ubah = ");
                    String nim = scanner.next();
                    int index = cariMahasiswa(nim);
                    if (index==999) {
                        System.out.println("Data yang Anda ubah tidak ada");
                    } else {
                        System.out.println("Silahkan masukkan data perubahan");
                        System.out.print("Masukkan NIM = ");
                        String nimEdit = scanner.next();
                        System.out.print("Masukkan Nama = ");
                        String namaEdit = scanner.next();
                        data[index].setData(nimEdit, namaEdit);
                    }
                }
            }
        } while (menu!=5);
    }

    
    public static int cariMahasiswa(String nim) {
        for (int i=0; i<indexData; i++) {
            if (nim.equals(data[i].getNIM())) {
                return i;
            }
        }
        return 999;
    }
}
