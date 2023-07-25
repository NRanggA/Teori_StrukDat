import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {82, 90, 10, 12, 15, 77, 55, 23};

        heapSort(arr); // Memanggil fungsi heapSort untuk mengurutkan array

        System.out.println("Hasil Final Setelah Diurutkan:");
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Membangun heap maksimum
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Mengurutkan heap
        for (int i = n - 1; i >= 0; i--) {
            // Menukar root dengan elemen terakhir
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Memanggil heapify pada subarray yang tersisa
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Akar sebagai simpul terbesar
        int left = 2 * i + 1; // Anak kiri
        int right = 2 * i + 2; // Anak kanan

        // Mengecek apakah anak kiri lebih besar dari node saat ini
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Mengecek apakah anak kanan lebih besar dari node saat ini
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Jika elemen terbesar bukan node saat ini
        if (largest != i) {
            // Menukar akar dengan simpul terbesar
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Memanggil heapify secara rekursif pada sub-pohon yang terpengaruh
            heapify(arr, n, largest);
        }
    }
}