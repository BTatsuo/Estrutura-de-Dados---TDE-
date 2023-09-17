public class Node {
    private Integer info;
    private Node proximo;

    public Node(){
        this.info=null;
        this.proximo=null;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
