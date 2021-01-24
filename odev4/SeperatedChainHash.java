package odev4;

import java.util.ArrayList;
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


    }
    public boolean sil(int deger){
        int hasVal = hash(deger, SeperatedChainHash());  // Calculate hash for index of array
        boolean result = L[hasVal].delete(deger); // delete the record from the table

        // If deletion is successful
        if (result) {

            entries--;  // Decrement number of entries by 1
        }

        return result;
    }
    public void yenidenOzetle() {
        //yenidenOzetle metodunu yazınız
    }
}
