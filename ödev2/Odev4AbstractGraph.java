package ödev2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Odev4AbstractGraph<T> {
    /**
     * Düğümleri tutan liste
     */
    protected List<Vertex<T>> vertices;
    /**
     * Düğümlere kolay erişmek için kullanılan map <değer, düğüm>
     */
    protected Map<T, Vertex<T>> verticesMap;
    /**
     * Çizge yönlü mü
     */
    boolean directed=true;

    public Odev4AbstractGraph() {
        vertices=new ArrayList<>();
        verticesMap=new HashMap<>();
    }

    public Odev4AbstractGraph(boolean directed) {
        this();
        this.directed=directed;
    }

    /**
     * Çizgeye düğüm ekler
     * @param deger eklenecek düğümün değeri
     */
    public void addVertex(T deger){
        if(!vertices.contains(deger)) {
            Vertex<T> v=new Vertex<>(deger);
            vertices.add(v);
            verticesMap.put(deger, v);
        }
    }

    /**
     * Çizgeye kenar ekler
     * @param from kenarın çıktığı düğüm
     * @param to kenarın girdiği düğüm
     */
    public void addEdge(T from, T to){
        addEdge(from,to,1);
    }

    /**
     * Çizgeye kenar ekler
     * @param from kenarın çıktığı düğüm
     * @param to kenarın girdiği düğüm
     * @param weight kenarın ağırlığı
     */
    public void addEdge(T from, T to, int weight) {
        Vertex<T> f=verticesMap.get(from);
        Vertex<T> t=verticesMap.get(to);
        if (f!=null && t!=null){
            for (Edge<T> e:f.edges)
                if(e.to.value.equals(to))
                    return;
            Edge e1=new Edge(f,t,weight);
            //edges.get(from).add(e1);//alttaki şekilde değişti
            verticesMap.get(from).edges.add(e1);
            if(!directed){
                Edge e2=new Edge(t,f,weight);
                //edges.get(to).add(e2);//alttaki şekilde değişti
                verticesMap.get(to).edges.add(e2);
            }
        }

    }

    /**
     * Çizgenin içeriğini ekrana yazdırır
     */
    public void print() {
        System.out.println(toString());
    }

    /**
     * Düğüm ve kenarları içeren metinsel temsil
     * @return Çizgenin metin temsilini verir
     */
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Vertices:\n");
        for (Vertex<T> vertex:vertices)
            sb.append(vertex.value+"\n");
        sb.append("Edges:\n");
        for (Vertex<T> vertex:vertices)
            for (Edge<T> edge:vertex.edges)
                sb.append(edge.from.value+(edge.weight!=1?" - "+edge.weight:"")+" -> "+edge.to.value+"\n");
        return sb.toString();
    }

    public abstract int[][] adjacencyMatrix();
    public abstract boolean equals(Odev4AbstractGraph<T> g2);
}