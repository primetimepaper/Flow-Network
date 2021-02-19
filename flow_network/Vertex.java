package flow_network;

import java.util.Objects;

public class Vertex {

    final String string_id; public int flag;

    public Vertex(String id, int flag1){
        string_id = id;
        flag = flag1;

    }

    public Vertex(String id){
        string_id = id;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Vertex){
            Vertex newvertex = (Vertex)other;
            if(newvertex.string_id == this.string_id){return true;}
            else{return false;}
        }
        else{return false;}
    }

    @Override
    public int hashCode(){
        return Objects.hash(string_id);
    }
    
}
