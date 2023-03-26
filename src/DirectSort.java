public class DirectSort {
    public static void directSort(int[] array) {
        for(int i =0; i < array.length-1; i++){
            int minPosition = i;
            for(int j = i+1; j < array.length; j++){
                if (array[j] < array[minPosition]) {
                    minPosition =j;
                }
            }
            if (i != minPosition){
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3,4,5,67,0,4,65,5,3,7,8,9,23,2,1};
        printArray(array);
        directSort(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for(int i =0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
