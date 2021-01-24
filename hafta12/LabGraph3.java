package hafta12;

import hafta10.Edge;
import hafta10.Vertex;

import java.util.*;

public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {

    void DFSUtil(T v, List<T> visited) {

        visited.add(v);
        Vertex<T> i = verticesMap.get(v);
        ArrayList<T> mList = new ArrayList();
        for (Edge<T> ff : i.edges) {
            mList.add(ff.to.value);

        }
        Collections.sort(mList);

        for (T fff : mList) {
            if (!visited.contains(fff)) {
                DFSUtil(fff, visited);
            }
        }


    }

    void BFSUtil(T v, List<T> liste) {

        Vertex<T> i = verticesMap.get(v);
        ArrayList<T> mList = new ArrayList();
        for (Edge<T> ff : i.edges) {
            mList.add(ff.to.value);

        }
        Collections.sort(mList);

        for (T fff : mList) {
            if (!liste.contains(fff)) {
                liste.add(fff);
            }
        }
        for (T fff : mList) {
            if (verticesMap.get(fff).edges.size()>0){
                BFSUtil(fff, liste);
            }

        }


    }

    @Override
    public List<T> dfs(T baslangic) {
        Stack<T> stack = new Stack();
        stack.push(baslangic);
        List<T> a = new ArrayList<>();
        DFSUtil(baslangic, a);

        return a;
    }



    @Override
    public List<T> bfs(T baslangic) {

            List<T> a=new ArrayList<>();
            a.add(baslangic)  ;
        Vertex<T> i = verticesMap.get(baslangic);
        ArrayList<T> mList = new ArrayList();
        for (Edge<T> ff : i.edges) {
            mList.add(ff.to.value);

        }
        Collections.sort(mList);

        for (T fff : mList) {
            if (!a.contains(fff)) {
                a.add(fff);
            }
        }
        return a;
    }
}
