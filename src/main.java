import java.util.ArrayList;
import java.util.List;

public class main {


    //        // O(n^2) - ������������
//        for (int i = 0; i < n; i++) { // n
//            for (int j = 0; j < n; j++) { // n
//                if (i == j) {
//                    array[i][j] = 1;
//                }
//            }
//        }

    // O(n) - ��������
//        for (int i = 0; i < 100 * n; i++) {
//            array[i][i] = 1;
//        }

    // O(e^n) ����������������
    // O(n!)
    // n -> n^{2}{3}{100} -> {2}{6}^n -> n!

    // 2.7^n <-> n^1000000

    static void timerFactorial(long n){
        long s = System.currentTimeMillis();
        System.out.println(factorial(n));
        System.out.println("Time for n = " + n + ": " + (System.currentTimeMillis() - s));
    }

    // n! = 1*2*3*4* n
    public static long factorial(long n){
        if (n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        int n = 8;
        // O(n^2) - ������������ ���������
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    array[i][j] = 1;
            }
        }

        // O(n) - �������� ���������
        for (int i = 0; i < n; i++){
            array[i][i] = 1;
        }


        timerFactorial(6000);



        System.out.println("\n********************************************************************************");
        sum(20);
        System.out.println("\n********************************************************************************");
        simpleDigitSearch(100);
        System.out.println("\n********************************************************************************");
        cubeCombinationsCount(20);
        System.out.println("\n********************************************************************************");
        System.out.println(cubeCombinationsCount2(2, 6));
        System.out.println("\n********************************************************************************");
        System.out.println(getFibonacciValue(3));
        System.out.println("\n********************************************************************************");
        getFibonacciValueWithoutRecursion(3);
        System.out.println("\n********************************************************************************");


    }

    /*
    ������� 1
    ���������� �������� ��������, ��������� ����� ���� �����
    �� 1 �� N. �������� ��������� �������� ���������,
    ���������� �������� ����� ����� ������� ����������
    ������������ ��������� ������� N.
    */
    public static void sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("\n����� ����� �� 1 �� " + n + " �����: " + sum);
    }


    /*
������� 2
�������� �������� ������ ������� ����� (������� ������ �� ���� �
�� 1) � ��������� �� 1 �� N. � ��������� ����� ��������������
��������� for, ��� ���� ������� � ������������ ���������, �� ����
����� ������������� ��������
*/
    public static void simpleDigitSearch(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("������� ����� �� 1 �� " + n + ":");
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

        /*
������� 3
1. ���������� �������� �������� ������ ���� ��������� ����������
(��������� ����������) ��� ���������� ������� K � ����������� ������ N.
2. � ��� ���� 2 �������� �� ����� � ���������� ������� ����� ���� ������
���������� (4 ������, ��������), ���� �� ���������� �����
������������. ����� �� ����.
3. ���� �� ���������� ������� �������, �������� ��������, ��� ������
������� ����� ��������� O(n4
), �� ���� ���������� ������� �������
����������, �� ��� ���������������� � O(nk
), ��� ����� ������������
����� ���������������� ���������. ��� ������� ������� ��������, ���
��� ��������� O(nk) � ������ ������.
*/

    public static void cubeCombinationsCount(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int a = 1; a <= n; a++) {
                    for (int b = 1; b <= n; b++) {
                        count++;
                    }
                }
            }
        }
        System.out.println("����� ������� �����: 4");
        System.out.println("����� ������ �����: " + n);
        System.out.println("����� ���������� �����: " + count);
    }


    public static long cubeCombinationsCount2(int k, int n) {
        if (k == 1) return n;
        long count = 0;
        for (int i = 1; i <= n; i++) {
            count += cubeCombinationsCount2(k - 1, n);
        }
        return count;
    }

    /*������� 4
1. ����� �������� ������ ������� ����� ������������������ ���������.
2. �������, ��� 1 � 2 �������� ������������������ ����� 1.
3. ������ ����� �� ������� On=On-1+On-2 ��� ������������ ������������
������������ ���������.
 */

    public static int getFibonacciValue(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacciValue(n - 1) + getFibonacciValue(n - 2);
        }
    }

    /*
    ������� 5
1.����� �������� ������ ������� ����� ������������������ ���������, �� � ����
��� ��������� �� �������� � ������������� ������� ����������, ��� ���� ���
�������� ���������, �.�. ���������� ������� �� ����� ������������������ �����
����������� ����� 1 ���.
    */

    public static void getFibonacciValueWithoutRecursion(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (Integer i : arr) {
            System.out.print(i + " ");
        }

        System.out.println("����� ��� �������: " + n + " �����: " + arr[n - 1]);
    }
}






