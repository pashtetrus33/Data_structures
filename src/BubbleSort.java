public class BubbleSort {

    public static void bubbleSort(int[] array){
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length -1; i++){
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i+1] = temp;
                    finish = false;
                }
            }

        } while (!finish);
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,4,5,67,0,4,65};
        printArray(array);
        bubbleSort(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for(int i =0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
