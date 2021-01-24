package hafta10;

//hafta 10
public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {
        Vertex<T> a=verticesMap.get(deger);
        if(a==null)
            return -1;
        return a.edges.size();
    }

    @Override
    public int inDegree(T deger) {
        Vertex<T> b=verticesMap.get(deger);
        if(b==null)
            return -1;
        int id=0;
        for (Vertex<T> ver:vertices)
            for (Edge<T> edge:ver.edges)
                if(edge.to.value.equals(deger))
                    id++;
        return id;
    }
}
