import java.util.ArrayList;
import java.util.List;

public class main {


    //        // O(n^2) - квадратичная
//        for (int i = 0; i < n; i++) { // n
//            for (int j = 0; j < n; j++) { // n
//                if (i == j) {
//                    array[i][j] = 1;
//                }
//            }
//        }

    // O(n) - линейная
//        for (int i = 0; i < 100 * n; i++) {
//            array[i][i] = 1;
//        }

    // O(e^n) Экспоненциальная
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
        // O(n^2) - квадратичная сложность
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    array[i][j] = 1;
            }
        }

        // O(n) - линейная сложность
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
    Задание 1
    Необходимо написать алгоритм, считающий сумму всех чисел
    от 1 до N. Согласно свойствам линейной сложности,
    количество итераций цикла будет линейно изменяться
    относительно изменения размера N.
    */
    public static void sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("\nСумма чисел от 1 до " + n + " равна: " + sum);
    }


    /*
Задание 2
Написать алгоритм поиска простых чисел (делятся только на себя и
на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
вложенный for, что явно говорит о квадратичной сложности, на этом
стоит акцентировать внимание
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
        System.out.println("Простые числа от 1 до " + n + ":");
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

        /*
Задание 3
1. Необходимо написать алгоритм поиска всех доступных комбинаций
(посчитать количество) для количества кубиков K с количеством граней N.
2. У вас есть 2 варианта на выбор – количество кубиков может быть строго
ограничено (4 кубика, например), либо их количество будет
динамическим. Выбор за вами.
3. Если вы реализуете простой вариант, обращает внимание, что данное
решение имеет сложность O(n4
), но если количество кубиков сделать
переменной, то она трансформируется в O(nk
), что будет представлять
собой экспоненциальную сложность. Для второго решения очевидно, что
его сложность O(nk) с самого начала.
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
        System.out.println("Число кубиков равно: 4");
        System.out.println("Число граней равно: " + n);
        System.out.println("Число комбинаций равно: " + count);
    }


    public static long cubeCombinationsCount2(int k, int n) {
        if (k == 1) return n;
        long count = 0;
        for (int i = 1; i <= n; i++) {
            count += cubeCombinationsCount2(k - 1, n);
        }
        return count;
    }

    /*Задание 4
1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
2. Считаем, что 1 и 2 значения последовательности равны 1.
3. Искать будем по формуле On=On-1+On-2 что предполагает использовать
рекурсивного алгоритма.
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
    Задание 5
1.Пишем алгоритм поиска нужного числа последовательности Фибоначчи, но в этот
раз откажемся от рекурсии и воспользуемся обычным алгоритмом, что даст нам
линейную сложность, т.к. вычисление каждого из чисел последовательности будет
происходить ровно 1 раз.
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

        System.out.println("Число под номером: " + n + " равно: " + arr[n - 1]);
    }
}






