public class HeapSort {

    public static void main(String args[]) {
        int array[] = {4, 181, 1, 45, 61, 7, 11, 78};

        sort(array);

        System.out.println("Result:");
        printArray(array);
    }

    public static void sort(int array[]) {

        // ���������� ���� (�������������� ������)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        // ���� �� ������ ��������� �������� �� ����   
        for (int i = array.length - 1; i >= 0; i--) {
            // ���������� ������� ������ � �����
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // �������� ��������� heapify �� ����������� ����
            heapify(array, i, 0);
        }
    }

    // ��������� ��� �������������� � �������� ���� ��������� � �������� ����� i, ��� ��������
// �������� � arr[]. n - ������ ����
    public static void heapify(int array[], int heapSize, int rootIndex) {
        int largest = rootIndex; // �������������� ���������� ������� ��� ������
        int leftChild = 2 * rootIndex + 1; // ����� = 2*i + 1
        int rightChild = 2 * rootIndex + 2; // ������ = 2*i + 2

        // ���� ����� �������� ������� ������ �����
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        // ���� ������ �������� ������� ������, ��� ����� ������� ������� �� ������ ������
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        // ���� ����� ������� ������� �� ������
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // ���������� ����������� � �������� ���� ���������� ���������
            heapify(array, heapSize, largest);
        }
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}