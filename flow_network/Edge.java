package flow_network;

import java.util.Objects;

public class Edge {

    final int capacity; int flow;
    final Vertex source; final Vertex destination;
    Edge reverse; // NEEDS TO BE FINAL

    public Edge(Vertex from, Vertex to, int cap){
        source = from; destination = to;
        capacity = cap;
        flow = 0;
    }

    public Edge(Vertex from, Vertex to, int cap, Edge rev){
        source = from; destination = to;
        capacity = cap;
        flow = 0;
        reverse = rev;
    }

    public int getResidual(){
        return this.capacity - this.flow;
    }

    public boolean addFlow(int newflow){
        int ans = newflow + this.flow;
        if(ans > this.capacity){return false;}
        else{
            this.flow = ans;
            return true;
        }
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Edge){
            Edge newedge = (Edge)other;
            if(this.source.equals(newedge.source) & this.destination.equals(newedge.destination)){return true;}
            else{return false;}
        }
        else{return false;}
    }

    @Override
    public int hashCode(){
        return Objects.hash(source, destination);
    }
}
