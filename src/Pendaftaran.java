import java.util.regex.Pattern;

public class Pendaftaran {

    /**
     * pendaftaran
     * @param email pengguna
     * @return end
     */
    public static boolean validasiEmail(String email) {
        String polaEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        return Pattern.matches(polaEmail, email);
    }

    /**
     * class validasi password
     * @param password password pengguna
     * @return
     */
    public static boolean validasiPassword(String password) {
        return password.length() >= 6;
    }

    /**
     *class pendaftaran
     * @param username input
     * @param password input
     * @param email input
     * @return
     */
    public static String pendaftaran(String username, String password, String email) {
        if (username == null || username.isEmpty()) {
            return "Username tidak boleh kosong";
        }

        if (password == null || password.isEmpty()) {
            return "Password tidak boleh kosong";
        }

        if (email == null || email.isEmpty()) {
            return "Email tidak boleh kosong";
        }

        // Validasi password minimal 6 karakter
        if (!validasiPassword(password)) {
            return "Password minimal 6 karakter";
        }

        // Validasi format email
        if (!validasiEmail(email)) {
            return "Format email tidak valid";
        }

        // Jika semua valid, pendaftaran berhasil
        return "Akun berhasil didaftarkan";
    }

    /**
     * methot main menjalakan program
     * @param args
     */
    public static void main(String[] args) {
            String[][] testCases = {
                    {"user1", "pass123", "user1@example.com"},   // Data valid
                    {"user2", "pass123", "user2example.com"},    // Email tidak valid
                    {"user3", "pass", "user3@example.com"},      // Password kurang dari 6 karakter
                    {"", "pass123", "user4@example.com"},        // Username kosong
                    {"user5", "", "user5@example.com"},          // Password kosong
                    {"user6", "pass123", ""}                     // Email kosong
            };

        for (int i = 0; i < testCases.length; i++) {
            String username = testCases[i][0];
            String password = testCases[i][1];
            String email = testCases[i][2];

            String hasil = pendaftaran(username, password, email);
            System.out.println("Test Case " + (i + 1) + ": " + hasil);
            System.out.println("menyala");
        }
    }
}
