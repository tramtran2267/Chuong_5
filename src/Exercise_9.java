import java.util.Scanner;

public class Exercise_9 {
    static int soLuongTo1k, soLuongTo2k, soLuongTo5k;

    public static void main(String[] args) {
        int luongTienCanDoi, demTo1k = 0, demTo2k = 0, demTo5k = 0, soLuongToTien = 0;
        int soLuongKetQuaItNhat = Integer.MAX_VALUE;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Nhập n (nghìn đồng, n>5): ");
            luongTienCanDoi = Integer.parseInt(scan.nextLine());
        } while (!kiemTraNhap(luongTienCanDoi));
        // x = n - (2y + 5z);
        for (int i = luongTienCanDoi / 2; i >= 1; i--) {
            for (int j = 0; j < luongTienCanDoi / 5; j++) {
                demTo2k = i;
                demTo5k = j;
                demTo1k = luongTienCanDoi - i * 2 - j * 5;
                if ((demTo1k + 2 * demTo2k + 5 * demTo5k) == luongTienCanDoi && demTo1k >= 0 && demTo2k > (demTo1k + demTo5k)) {
                    soLuongToTien = demTo1k + demTo2k + demTo5k;
                    if (soLuongToTien < soLuongKetQuaItNhat) {
                        soLuongKetQuaItNhat = soLuongToTien;
                        soLuongTo1k = demTo1k;
                        soLuongTo2k = demTo2k;
                        soLuongTo5k = demTo5k;
                        break;
                    }
                }
            }
        }
        System.out.println("(" + soLuongTo1k + ", " + soLuongTo2k + ", " + soLuongTo5k + "): " + soLuongKetQuaItNhat + " tờ");
    }

    public static boolean kiemTraNhap(int n) {
        return n > 5;
    }
}
