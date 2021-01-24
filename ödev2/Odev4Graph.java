package ödev2;

import java.util.List;

public class Odev4Graph<T> extends Odev4AbstractGraph<T> {
    /**
     * Mevcut çizgenin komşuluk matrisini hesaplayıp geri döndürür
     *
     * @return Komşuluk matrisi(iki boyutlu tamsayı dizisi)
     */
    @Override
    public int[][] adjacencyMatrix() {
        int[][] mat = new int[this.vertices.size()][this.vertices.size()];
        boolean[][] isSetMatrix = new boolean[this.vertices.size()][this.vertices.size()];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                // We only want to print the values of those positions that have been marked as set
                if (isSetMatrix[i][j])
                    System.out.format("%8s", String.valueOf(mat[i][j]));
                else System.out.format("%8s", "/  ");
            }
            System.out.println();
        }

        return mat;
    }

    /**
     * Mevcut çizgenin parametre olarak gönderilen çizge ile eşit olup
     * olmadığını döndürür. İki çizgenin birbirine eşit olması için düğümlerin
     * (vertex) referansları farklı olsa bile değerlerinin eşit olması ve de
     * tüm kenarların her iki çizgede de aynı düğümler arasında olması gerekir
     *
     * @param g2 Eşitlik kontrolü için gönderilen çizge parametresi
     * @return Eşit için true aksi halde false döner
     */
    @Override
    public boolean equals(Odev4AbstractGraph<T> g2) {
        int row1;
        Vertex<T> col1;
        int row2;
        Vertex<T> col2;
        boolean flag=true;
        boolean deger=true;

        row1 = this.vertices.size();
        col1 = this.verticesMap.get(0);

        row2 = g2.vertices.size();
        col2 = g2.verticesMap.get(0);

        if (row1 != row2 || col1 != col2)
            flag = false;
        else {

            for (Vertex<T> i:this.vertices) {

                List<Edge<T>> j=i.edges;
                List<Edge<T>> k=g2.verticesMap.get(i.value).edges;

                if (j.size()!=k.size()){
                    flag=false;
                }
                else{
                    for (Edge<T> a:j){
                        deger=true;
                        for (Edge<T> l:k){
                                    if (a.to.value==l.to.value){
                                        deger=false;
                                    }
                                        }
                        if(deger==true) {
                            flag=false;
                        }

                    }
                }
            }
        }
        return flag;
    }
}

/*
int[][] mat = new int[this.vertices.size()][this.vertices.size()];
        int c=0;
        for (ödev2.hafta10.Vertex<T> i:this.vertices) {

            List<ödev2.hafta10.Edge<T>> j=i.edges;
                for (ödev2.hafta10.Edge<T> a:j){
                    if(a.to!=null){
                        int index=this.vertices.indexOf(a.to);
                        mat[c][index]=1;
                    }

                }
            c++;
        }
 */

