package hafta6;//import java.lang.reflect.Type;
//import java.util.Arrays;

//hafta 6
public class BinaryHeap<T extends Comparable<T>> {

    public T[] dizi; // Yığını tutacak dizi(değiştirmeyin)
    public int es; // Eleman sayısı(değiştirmeyin)

    public BinaryHeap() { dizi = (T[]) new Comparable[100]; } // değiştirmeyin, kullanın

    public BinaryHeap(int boyut) { dizi = (T[]) new Comparable[boyut]; } // değiştirmeyin, kullanın
    public int ebeveyn(int konum) { return konum / 2; } // değiştirmeyin, kullanın
    public int solCocuk(int konum) { return 2 * konum; } // değiştirmeyin, kullanın
    public int sagCocuk(int konum) { return 2 * konum + 1; } // değiştirmeyin, kullanın
    public int elemanSayisi() { return es; } // değiştirmeyin, kullanın

    public void ekle(T eleman) {
        es++;
        dizi[es] = eleman;
        Up();
    }

    public T sil() {
        T del = dizi[1];
        dizi[1] = dizi[es];
        dizi[es--] = null;
        Down();
        return del;
    }
    public void Up() {
        int counter = es;

        while (ebeveyn(counter) > 0 && dizi[counter].compareTo(dizi[ebeveyn(counter)]) <= 0) {
            T temp = dizi[ebeveyn(counter)];
            dizi[ebeveyn(counter)] = dizi[counter];
            dizi[counter] = temp;

            counter = ebeveyn(counter);
        }
    }

    public void Down() {
        int counter = 1;

        while (solCocuk(counter) <= es) {
            int smallest = solCocuk(counter);

            if (sagCocuk(counter) <= es && dizi[sagCocuk(counter)].compareTo(dizi[solCocuk(counter)]) <= 0 ) {
                smallest = sagCocuk(counter);
            }

            if (dizi[counter].compareTo(dizi[smallest]) >= 0) {
                T temp = dizi[smallest];
                dizi[smallest] = dizi[counter];
                dizi[counter] = temp;
            } else {
                break;
            }

            counter = smallest;
        }
    }
    /*private void swap(int child, int parent)
    {
        T t = dizi[child];
        dizi[child] = dizi[parent];
        dizi[parent] = t;
    }*/

}
