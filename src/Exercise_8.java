import java.util.Objects;
import java.util.Scanner;

public class Exercise_8 {
    static float laiSuat, tienVon;
    static int thoiHan;

    public static void main(String[] args) {
        String nhapLieu;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Nhập lãi suất, tiền vốn, thời hạn (ngăn cách nhau bởi dấu \",\" ): ");
            // 0.027,15000,3
            nhapLieu = scan.nextLine();
            phanTichNhapLieu(nhapLieu);
            inKetQua(thoiHan, laiSuat, tienVon);
        } while (!kiemTraNhapLieu(nhapLieu));

    }

    public static boolean kiemTraNhapLieu(String nhapLieu) {
        if (nhapLieu.contains(",")) {
            String[] phanTach = nhapLieu.split(",");
            if (phanTach.length != 3) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static void phanTichNhapLieu(String nhapLieu) {
        if (nhapLieu.contains(",")) {
            String[] phanTach = nhapLieu.split(",");
            laiSuat = Float.parseFloat(phanTach[0]);
            tienVon = Float.parseFloat(phanTach[1]);
            thoiHan = Integer.parseInt(phanTach[2]);
        }
    }

    public static double tinhVonTheoNam(float laiSuat, float tienVon, int nam) {
        float heSo, soMu;
        double vonHangNam;
        // tienVon * (1 + laiSuat) ^ nam
        heSo = (1 + laiSuat);
        soMu = nam;
        vonHangNam = tienVon * (Math.pow(heSo, soMu));
        vonHangNam = lamTron(vonHangNam);
        return vonHangNam;
    }

    public static double lamTron(double giaTriLamTron) {
        double ketQuaLamTron;
        ketQuaLamTron = (double) Math.round(giaTriLamTron * 10) / 10;
        return ketQuaLamTron;
    }

    public static float tinhVonTheoNam_SaiCongThuc(float laiSuat, float tienVon, int nam) {
        float vonHangNam;
        vonHangNam = tienVon * (1f + laiSuat) * nam * 1f;
        System.out.println("Lai suat: " + laiSuat);
        System.out.println("Tien von: " + tienVon);
        System.out.println("Nam: " + nam);
        System.out.println(1f + laiSuat);
        return vonHangNam;
    }

    public static String xuLyKetQuaSauDauPhay(double giaTriDuaVao) {
        String chuoiSauXuLy;
        chuoiSauXuLy = String.valueOf(giaTriDuaVao);
        String[] phanTach = chuoiSauXuLy.split("\\.");
        if (Objects.equals(phanTach[1], "0")) {
            chuoiSauXuLy = phanTach[0];
        } else {
            chuoiSauXuLy = String.valueOf(giaTriDuaVao);
        }
        return chuoiSauXuLy;
    }

    public static void inKetQua(int nam, float laiSuat, float tienVon) {
        System.out.println("Lãi suất: " + xuLyKetQuaSauDauPhay(lamTron(laiSuat * 100f)) + "%");
        System.out.println("Vốn ban đầu: " + xuLyKetQuaSauDauPhay(lamTron(tienVon)));
        System.out.println("Thời hạn: " + nam + " năm");
        System.out.println("Năm\t\tVốn");
        for (int i = 1; i <= nam; i++) {
            String tempVonHangNam = xuLyKetQuaSauDauPhay(tinhVonTheoNam(laiSuat, tienVon, i));
            System.out.println(i + "\t\t" + tempVonHangNam);
        }
    }

}
