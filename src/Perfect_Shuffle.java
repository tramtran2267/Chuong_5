import java.util.Scanner;

public class Perfect_Shuffle {
    final static int MIN = -100;
    final static int MAX = 100;
    public static void main(String[] args) {

    }

    public static int nhapN(Scanner scan){
        int n;
        do{
            System.out.println("Enter n > 0: ");
            n = Integer.parseInt(scan.nextLine());
        }while (n<1);
        return n;
    }

    public static int[] taoMang(int n){
        int a[] = new int[n];
        for (int i=0; i<n; i++){
            a[i] = MIN + (int)(Math.random() * ((MAX - MIN) + 1));
        }
        return a;
    }

    public static void xuatMang(int a[]) {
        for (int pt: a){
            System.out.print(pt + "\t");
        }
        System.out.println("\n");
    }
}
