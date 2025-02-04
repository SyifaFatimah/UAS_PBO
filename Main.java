import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BarangDAO barangDAO = new BarangDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Aplikasi Inventaris Barang =====");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1/2/3/4/5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    barangDAO.getAllBarang();
                    break;
                case 3:
                    updateBarang();
                    break;
                case 4:
                    hapusBarang();
                    break;
                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    // Fungsi untuk menambah barang
    private static void tambahBarang() {
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();
        System.out.print("Jumlah: ");
        int jumlah = scanner.nextInt();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        barangDAO.addBarang(namaBarang, kategori, jumlah, harga);
    }

    // Fungsi untuk update barang
    private static void updateBarang() {
        System.out.print("Masukkan ID Barang yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Nama Barang Baru: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Kategori Baru: ");
        String kategori = scanner.nextLine();
        System.out.print("Jumlah Baru: ");
        int jumlah = scanner.nextInt();
        System.out.print("Harga Baru: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        barangDAO.updateBarang(id, namaBarang, kategori, jumlah, harga);
    }

    // Fungsi untuk menghapus barang
    private static void hapusBarang() {
        System.out.print("Masukkan ID Barang yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        barangDAO.deleteBarang(id);
    }
}
