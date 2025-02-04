import java.sql.*;
import java.util.Scanner;

public class BarangDAO {

    // CREATE - Menambah Barang
    public void addBarang(String namaBarang, String kategori, int jumlah, double harga) {
        String query = "INSERT INTO barang (nama_barang, kategori, jumlah, harga) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, namaBarang);
            stmt.setString(2, kategori);
            stmt.setInt(3, jumlah);
            stmt.setDouble(4, harga);

            stmt.executeUpdate();
            System.out.println("Barang berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Menampilkan Data Barang
    public void getAllBarang() {
        String query = "SELECT * FROM barang";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Daftar Barang:");
            System.out.println("ID\tNama Barang\tKategori\tJumlah\tHarga");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("nama_barang") + "\t" +
                        rs.getString("kategori") + "\t" +
                        rs.getInt("jumlah") + "\t" +
                        rs.getDouble("harga"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE - Mengupdate Data Barang
    public void updateBarang(int id, String namaBarang, String kategori, int jumlah, double harga) {
        String query = "UPDATE barang SET nama_barang = ?, kategori = ?, jumlah = ?, harga = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, namaBarang);
            stmt.setString(2, kategori);
            stmt.setInt(3, jumlah);
            stmt.setDouble(4, harga);
            stmt.setInt(5, id);

            stmt.executeUpdate();
            System.out.println("Barang berhasil diupdate!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE - Menghapus Data Barang
    public void deleteBarang(int id) {
        String query = "DELETE FROM barang WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Barang berhasil dihapus!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
