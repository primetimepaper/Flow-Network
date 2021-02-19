package flow_network;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlowNetwork {
    final int UNVISITED = 0;
    final int VISITED = 1;
    final int BEING_PROCESSED = 2;

    Map<Vertex, List<Edge>> graph;
    List<Vertex> vertices;

    public FlowNetwork(){;}

    public boolean addVertex(Vertex v){
        if(vertices.contains(v)){return false;}
        else{
            vertices.add(v);
            return true;
        }
    }

    public boolean addEdge(Vertex from, Vertex to, int cap){
        Edge e = new Edge(from, to, cap);
        if(graph.get(from).contains(e)){return false;}
        else{
            List<Edge> x = graph.get(from);
            x.add(e);
            graph.replace(from, x);
            return true;
        }
    }

    public boolean contains(Vertex v){
        if(vertices.contains(v)){return true;}
        else{return false;}
    }

    public boolean contains(Edge e){
        if(graph.get(e.source).contains(e)){return true;}
        else{return false;}
    }

    public boolean contains(Vertex source, Vertex destination){
        List<Edge> x = graph.get(source);
        for(int i = 0; i < x.size(); i++){
            if(x.get(i).destination == destination){return true;}
        }
        return false;
    }

    public Vertex getVertex(String id){
        Set<Vertex> x = graph.keySet();
        Vertex[] y = (Vertex[])x.toArray();
        for(int i = 0; i < Array.getLength(y); i++){
            if(y[i].string_id == id){return y[i];}
        }
        return null;
    }

    //todo public void printBFS(Vertex start)

    //todo public void printDFS(Vertex start)

}