import java.util.Scanner;

class Kategori {
    String nama;
    
    public Kategori(String nama) {
        this.nama = nama;
    }
}

class Buku {
    String judul;
    int tahunTerbit;
    Kategori kategori;
    String penulis;
    String sinopsis;
    
    public Buku(String judul, int tahunTerbit, Kategori kategori, String penulis, String sinopsis) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
        this.penulis = penulis;
        this.sinopsis = sinopsis;
    }
    
    public int hitungJumlahKata() {
        return sinopsis.split("\\s+").length;
    }
    
    public double cekKesamaan(Buku bukuLain) {
        int totalAttribute = 4; // judul, tahunTerbit, kategori, penulis
        int kesamaan = 0;
        
        if (this.judul.equalsIgnoreCase(bukuLain.judul)) kesamaan++;
        if (this.tahunTerbit == bukuLain.tahunTerbit) kesamaan++;
        if (this.kategori.nama.equalsIgnoreCase(bukuLain.kategori.nama)) kesamaan++;
        if (this.penulis.equalsIgnoreCase(bukuLain.penulis)) kesamaan++;
        
        return (kesamaan / (double) totalAttribute) * 100;
    }
    
    public Buku copy() {
        return new Buku(this.judul, this.tahunTerbit, this.kategori, this.penulis, this.sinopsis);
    }
}

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Kategori teknologi = new Kategori("Teknologi");
        Kategori filsafat = new Kategori("Filsafat");
        Kategori sejarah = new Kategori("Sejarah");
        Kategori agama = new Kategori("Agama");
        Kategori psikologi = new Kategori("Psikologi");
        Kategori politik = new Kategori("Politik");
        Kategori fiksi = new Kategori("Fiksi");
        
        Buku[] bukuList = {
            new Buku("Buku Pemrograman 1", 2001, teknologi, "Zulfikar Ramzy", "Buku ini membahas dasar-dasar pemrograman."),
            new Buku("Buku Pemrograman 2", 2002, teknologi, "Zulfikar Ramzy", "Buku ini membahas algoritma tingkat lanjut."),
            new Buku("Buku Filsafat 1", 2006, filsafat, "Zulfikar Ramzy", "Pemikiran filsafat klasik dan modern."),
            new Buku("Buku Sejarah 1", 2011, sejarah, "Zulfikar Ramzy", "Sejarah dunia dari zaman kuno hingga modern."),
            new Buku("Buku Agama 1", 2016, agama, "Zulfikar Ramzy", "Pembahasan mendalam mengenai nilai-nilai agama."),
            new Buku("Buku Psikologi 1", 2021, psikologi, "Zulfikar Ramzy", "Psikologi perkembangan manusia."),
            new Buku("Buku Politik 1", 2026, politik, "Zulfikar Ramzy", "Dinamika politik dalam era digital."),
            new Buku("Buku Fiksi 1", 2031, fiksi, "Zulfikar Ramzy", "Sebuah kisah petualangan penuh makna.")
        };
        
        for (Buku buku : bukuList) {
            System.out.println("Judul: " + buku.judul);
            System.out.println("Tahun: " + buku.tahunTerbit);
            System.out.println("Kategori: " + buku.kategori.nama);
            System.out.println("Penulis: " + buku.penulis);
            System.out.println("Sinopsis: " + buku.sinopsis);
            System.out.println("Jumlah Kata dalam Sinopsis: " + buku.hitungJumlahKata());
            System.out.println("--------------------");
        }
        
        Buku buku1 = bukuList[0];
        Buku buku2 = bukuList[1];
        System.out.println("\nTingkat Kesamaan Buku1 & Buku2: " + buku1.cekKesamaan(buku2) + "%");
        
        Buku bukuCopy = buku1.copy();
        System.out.println("\nSalinan Buku: " + bukuCopy.judul + " - " + bukuCopy.penulis);
    }
}
