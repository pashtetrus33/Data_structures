public class InsetSort {

    public static void insertSort(int[] array) {
        for (int i=0; i < array.length -1; i++){
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[] {3,4,5,67,0,4,65,5,3,7,8,9,23,2,1};
        printArray(array);
        insertSort(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for(int i =0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
