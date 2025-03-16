import java.util.Scanner;

class Kategori {
    String nama;
    public Kategori(String nama) {
        this.nama = nama;
    }
}

class Buku {
    String judul, penulis, sinopsis;
    int tahunTerbit;
    Kategori kategori;
    
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
        int kesamaan = 0;
        if (judul.equalsIgnoreCase(bukuLain.judul)) kesamaan++;
        if (tahunTerbit == bukuLain.tahunTerbit) kesamaan++;
        if (kategori.nama.equalsIgnoreCase(bukuLain.kategori.nama)) kesamaan++;
        if (penulis.equalsIgnoreCase(bukuLain.penulis)) kesamaan++;
        if (sinopsis.equalsIgnoreCase(bukuLain.sinopsis)) kesamaan++;
        return (kesamaan / 5.0) * 100;
    }
    
    public Buku copy() {
        return new Buku(judul, tahunTerbit, kategori, penulis, sinopsis);
    }
}

public class Perpustakaan {
    public static void main(String[] args) {
        Kategori teknologi = new Kategori("Teknologi");
        Kategori filsafat = new Kategori("Filsafat");
        Kategori sejarah = new Kategori("Sejarah");
        Kategori psikologi = new Kategori("Psikologi");
        Kategori fiksi = new Kategori("Fiksi");
        
        Buku buku1 = new Buku("Buku Pemrograman", 2022, teknologi, "Zulfikar Ramzy", "Buku ini membahas konsep pemrograman modern dan penerapannya dalam dunia kerja.");
        Buku buku2 = new Buku("Buku Filsafat", 2023, filsafat, "Zulfikar Ramzy", "Buku ini membahas pemikiran filsafat dari berbagai era.");
        Buku buku3 = new Buku("Buku Sejarah", 2024, sejarah, "Zulfikar Ramzy", "Buku ini menjelaskan sejarah peradaban dunia dengan rinci.");
        Buku buku4 = new Buku("Buku Psikologi", 2025, psikologi, "Zulfikar Ramzy", "Buku ini mengupas berbagai teori psikologi dan penerapannya.");
        Buku buku5 = new Buku("Buku Fiksi", 2026, fiksi, "Zulfikar Ramzy", "Buku ini adalah novel fiksi yang penuh dengan petualangan dan misteri.");
        
        Buku[] daftarBuku = {buku1, buku2, buku3, buku4, buku5};
        
        for (Buku buku : daftarBuku) {
            System.out.println("Judul: " + buku.judul);
            System.out.println("Kategori: " + buku.kategori.nama);
            System.out.println("Penulis: " + buku.penulis);
            System.out.println("Sinopsis: " + buku.sinopsis);
            System.out.println("Jumlah Kata dalam Sinopsis: " + buku.hitungJumlahKata());
            System.out.println("--------------------");
        }
    }
}
