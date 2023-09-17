import java.util.Random;

public class Pilha {
    Random rd= new Random();

    private Node topo;

    public Pilha(int tamanho){
        for (int i = 0;i<tamanho;i++){
            this.inserir(rd.nextInt(100)+1);
        }
    }
    public Pilha(){
        this.topo=null;
    }

    public Node getTopo() {
        return topo;
    }

    public void inserir(Integer info){
        Node noAtual = new Node();
        noAtual.setInfo(info);
        if(topo==null){
            topo=noAtual;
        }else{
            noAtual.setProximo(topo);
            topo=noAtual;
        }
    }

    public void pop(){
        if(this.topo==null){
            System.out.println("A pilha está Vazia!!");
        }else{
            topo=topo.getProximo();
        }
    }
    public void push(Pilha destino){
        if(topo==null){
            System.out.println("Pilha Vazia!");
        }else{
            Main.jogadas++;
            destino.inserir(this.topo.getInfo());
            this.pop();
        }
    }

    public void imprimir(){
        Node noAtual = topo;
        if(noAtual==null){
            System.out.print(" - ");
        }else{
            while(noAtual!=null) {
                if (noAtual.getProximo() == null) {
                    System.out.print(noAtual.getInfo());
                } else {
                    System.out.print(noAtual.getInfo() + " -> ");
                }
                noAtual = noAtual.getProximo();
            }
        }
    }

    public boolean verificar(int tamanho,boolean ordem){
        Node noAtual= this.topo;
        int count = 0;
        if(noAtual==null){
            return false;
        }else{
            if(ordem){
                while(noAtual.getProximo()!=null){
                    if(noAtual.getInfo()<=noAtual.getProximo().getInfo()){
                        count++;
                        noAtual=noAtual.getProximo();
                        if(count==(tamanho-1)){
                            return true;
                        }
                    }else{
                        break;
                    }
                }
                return false;
            }else{
                while(noAtual.getProximo()!=null){
                    if(noAtual.getInfo()>=noAtual.getProximo().getInfo()){
                        count++;
                        noAtual=noAtual.getProximo();
                        if(count==(tamanho-1)){
                            return true;
                        }
                    }else{
                        break;
                    }
                }
                return false;
            }
        }
    }



}
