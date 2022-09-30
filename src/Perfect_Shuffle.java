import java.util.Scanner;

public class Perfect_Shuffle {
    final static int MIN = -100;
    final static int MAX = 100;
    public static void main(String[] args) {

    }

    public static int nhapN(Scanner scan){
        int n;
        do{
            System.out.println("Enter n > 2 (n mod 2 = 0): ");
            n = Integer.parseInt(scan.nextLine());
        }while (n<2 || n%2 != 0);
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

    public static int[] shuffle(int a[]){
        int temp[] = new int[a.length];
        for (int i=0; i<a.length/2; i++){
            temp[2*i] = a[i];
            temp[2*i + 1] = a[a.length/2 + i];
        }
        a = temp;
        return a;
    }
}
