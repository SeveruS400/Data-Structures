package hafta8;//hafta 8
import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        int loc = hash(deger);

        if (dizi[loc] == null) {
            LinkedList<Integer> toAdd = new LinkedList<>();
            toAdd.add(deger);
            dizi[loc] = toAdd;
        } else {
            dizi[loc].add(deger);
        }
    }
    public boolean sil(int deger){
        int konum = hash(deger);

        if (dizi[konum] == null) {
            return false;
        } else {
            int konumLinkedList = dizi[konum].indexOf(deger);
            dizi[konum].remove(konumLinkedList);
            return true;
        }
    }
    public void yenidenOzetle() {
        SeperatedChainHash a = new SeperatedChainHash(find(dizi.length));

        for (LinkedList<Integer> linkedList : dizi) {
            for (int deger : linkedList) {
                a.ekle(deger);
            }
        }

        dizi = a.dizi;
    }
    public int find(int length) {
        int doublee = length * 2;

        while(true) {
            doublee++;
            boolean flag = true;
            for (int counter = 2; counter < doublee / 2; counter++) {
                if (doublee % counter == 0) {
                    flag = false;
                } else {
                    flag = true;
                }
            }

            if (flag == true)
                return doublee;
        }
    }

}

