package Program_Siakad;

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
     static int sizeData = 10;
     static int indexData = 0;
     static Mahasiswa[] data = new Mahasiswa [sizeData];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int menu = 0;
        do {
            System.out.println("Menu");
            System.out.println("1. Masukkan data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Cari data");
            System.out.println("4. Edit data");
            System.out.println("5. Hapus data (Perulangan)");
            System.out.println("6. Hapus data (Rekursi)");
            System.out.println("7. Urutkan data (Exchange Sort)");
            System.out.println("8. Urutkan data (Selection Sort)");
            System.out.println("9. Urutkan data (Bubble Sort)");
            System.out.println("10. Urutkan data (Shell Sort)");
            System.out.println("11. Urutkan data (Quick Sort)");
            System.out.println("12. Cari data (Binary Search)");
            System.out.println("13. Program UAS");
            System.out.println("14. Keluar");
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
                } break;
                case 5: {
                    System.out.print("Masukkan NIM data yang akan dihapus = ");
                    String nim = scanner.next();
                    int index = cariMahasiswa(nim);
                    if (index==999) {
                        System.out.println("Data yang Anda cari tidak ada");
                    } else {
                        hapusPerulangan(index);
                    }
                } break;
                case 6: {
                    System.out.print("Masukkan NIM data yang akan dihapus = ");
                    String nim = scanner.next();
                    int index = cariMahasiswa(nim);
                    if (index==999) {
                        System.out.println("Data yang Anda cari tidak ada");
                    } else {
                        hapusRekursi(index);
                    }
                } break;
                case 7: {
                    exchangeSort();
                    System.out.println("Data telah diurutkan");
                    for(int i=0; i<indexData; i++) {
                        data[i].getData();
                    };
                } break;
                case 8: {
                    selectionSort();
                    System.out.println("Data telah diurutkan");
                    for(int i=0; i<indexData; i++) {
                        data[i].getData();
                    };
                } break;
                case 9: {
                    bubbleSort();
                    System.out.println("Data telah diurutkan");
                    for(int i=0; i<indexData; i++) {
                        data[i].getData();
                    };
                } break;
                case 10: {
                    shellSort();
                    System.out.println("Data telah diurutkan");
                    for(int i=0; i<indexData; i++) {
                        data[i].getData();
                    };
                } break;
                case 11: {
                    quickSort();
                    System.out.println("Data telah diurutkan");
                    for(int i=0; i<indexData; i++) {
                        data[i].getData();
                    }
                } break;
                case 12: {
                    shellSort();
                    System.out.print("Masukkan NIM data yang Anda cari = ");
                    String nim  = scanner.next();
                    binarySearch(nim);
                } break;
                case 13: {
                    UAS();
                    System.out.println("Data telah diurutkan");
                    for(int i=0; i<indexData; i++) {
                        data[i].getData();
                    };
                } break;
            }
        } while (menu!=14);
    }

    public static int cariMahasiswa(String nim) {
        for (int i=0; i<indexData; i++) {
            if (nim.equals(data[i].getNIM())) {
                return i;
            }
        }
        return 999;
    }

    public static void hapusPerulangan(int index) {
        for (int i = index; i<indexData; i++) {
            data[i] = data [i+1];
        }
        indexData--;
        System.out.println("Data berhasil dihapus");
    }

    public static void hapusRekursi(int index) {
        if (index<indexData) {
            data[index] = data[index+1];
            hapusRekursi(index+1);
        } else {
            indexData--;
            System.out.println("Data berhasil dihapus");
        }
    }

    public static void exchangeSort() {
        for (int i = 0; i<indexData-1; i++) {
            for (int j = i+1; j<indexData; j++) {
                if (data[i].getNIM().compareTo(data[j].getNIM())>0) {
                    Mahasiswa temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public static void selectionSort() {
        for (int i = 0; i<indexData-1; i++) {
            int indeks = i;
            for (int j = i+1; j<indexData; j++) {
                if(data[indeks].getNIM().compareTo(data[j].getNIM())>0) {
                    indeks = j;
                }
            }
            if (indeks!=i) {
                Mahasiswa temp = data[i];
                data[i] = data[indeks];
                data[indeks] = temp;
            }
        }
    }

    public static void bubbleSort() {
        for (int i = 0; i<indexData-1; i++) {
            for (int j = 0; j<indexData-1; j++) {
                if (data[j].getNIM().compareTo(data[j+1].getNIM())>0) {
                    Mahasiswa temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public static void shellSort() {
        int lompat = indexData;
        while (lompat > 1) {
            lompat = lompat / 2;
            int i = indexData - lompat;
            boolean tukar = false;
            do {
                tukar = false;
                for (int j = 0; j<i; j++) {
                    if (data[j].getNIM().compareTo(data[j+lompat].getNIM())>0) {
                        Mahasiswa temp = data[j];
                        data[j] = data[j+lompat];
                        data[j+lompat] = temp;
                        tukar = true;
                    }
                }
            } while (tukar!=false);
        }
    }

    public static void quickSort() {
        System.out.println("Berikut data yang Anda cari");
    }


    public static void binarySearch(String nim) {
        int l = 0;
        int r = indexData;
        boolean ketemu = false;
        int m = 0;
        while (l<=r && ketemu==false) {
            m= (l+r)/2;
            if (data[m].getNIM().equals(nim)) {
                ketemu = true;
            } else if (data[m].getNIM().compareTo(nim)<0) {
                r = m - 1;
            } else {
                l= m + 1;
            }
        }
        if (ketemu==false) {
            System.out.println("Data yang Anda cari tidak ada");
        } else {
            System.out.println("Berikut data yang Anda cari");
            data[m].getData();
        }
    }

    public static void UAS() {
        if (indexData == 0) {
            System.out.println("Data tidak ditemukan");
        } else {
            int jarak = indexData;
            int susut = 13;
            int urut = 0;
            while (urut == 0) {
                jarak = (jarak * 10) / susut;
                if (jarak <= 1); {
                    jarak = 1;
                    urut = 1;
                }
                for (int i = 0; i+jarak < indexData; i++) {
                    while (data[i].getNIM().compareTo(data[i+jarak].getNIM())>0) {
                        Mahasiswa temp = data [i];
                        data[i] = data[i+jarak];
                        data[i+jarak] = temp;
                        urut = 0;
                    }
                }
            }
            System.out.println("Data telah dirutkan. Silahkan tampilkan Data");

        }
    }
}