import java.util.Scanner;

public class Main {
    static int jogadas =0;
    static Pilha pilhaA;
    static Pilha pilhaB;
    static Pilha pilhaC;

    static Pilha prioridade;

    public static void imprimir(){
        System.out.println();
        pilhaA.imprimir();
        System.out.println(" | PILHA A");
        pilhaB.imprimir();
        System.out.println(" | PILHA B");
        pilhaC.imprimir();
        System.out.println(" | PILHA C");
        System.out.println();
    }

    public static boolean achar(Node a){
        Node noAtual=pilhaA.getTopo();
        while(noAtual!=null){
            if(noAtual.getInfo()==a.getInfo()){
                return true;
            }
            noAtual=noAtual.getProximo();
        }
        return false;
    }

    public static void auto(int tamanho,boolean ordem){
        while(pilhaC.verificar(tamanho,ordem)==false){
            if(achar(prioridade.getTopo())==true){
                while(pilhaA.getTopo()!=null){
                    if(pilhaA.getTopo().getInfo()==prioridade.getTopo().getInfo()){
                        pilhaA.push(pilhaC);
                        prioridade.pop();
                        imprimir();
                        break;
                    }else{
                        pilhaA.push(pilhaB);
                        imprimir();
                    }
                }

            }else{
                while(pilhaB.getTopo()!=null){
                    if(pilhaB.getTopo().getInfo()==prioridade.getTopo().getInfo()){
                        pilhaB.push(pilhaC);
                        prioridade.pop();
                        imprimir();
                        break;
                    }else{
                        pilhaB.push(pilhaA);
                        imprimir();
                    }
                }
            }

        }
    }

    public static void prioridade(boolean ordem){
        prioridade= new Pilha();
        Node noAtual=pilhaA.getTopo();
        while(noAtual!=null){
            Integer info=noAtual.getInfo();
            prioridade.inserir(info);
            noAtual=noAtual.getProximo();
        }
        noAtual=prioridade.getTopo();
        if(ordem==true){
            while(noAtual.getProximo()!=null){
                if(noAtual.getInfo()<=noAtual.getProximo().getInfo()){
                    prioridade.inserir(noAtual.getProximo().getInfo());
                    noAtual.setProximo(noAtual.getProximo().getProximo());
                    noAtual=prioridade.getTopo();
                }else{
                    noAtual=noAtual.getProximo();
                }
            }
        }else{
            while(noAtual.getProximo()!=null){
                if(noAtual.getInfo()>=noAtual.getProximo().getInfo()){
                    prioridade.inserir(noAtual.getProximo().getInfo());
                    noAtual.setProximo(noAtual.getProximo().getProximo());
                    noAtual=prioridade.getTopo();
                }else{
                    noAtual=noAtual.getProximo();
                }
            }
        }
        prioridade.imprimir();
        System.out.println(" | Prioridade");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o tamanho da Pilha: ");
        int tamanho = sc.nextInt();
        System.out.print("Digite C para Crescente ou D para Descrescente: ");
        String tipo = sc.next();
        boolean ordem = tipo.equals("C") ? true : false;
        pilhaA = new Pilha(tamanho);
        pilhaB = new Pilha();
        pilhaC = new Pilha();
        if(pilhaA.verificar(tamanho,ordem)==true){
            imprimir();
            System.out.println("A pilha ja está Ordenada!");
            System.exit(0);
        }else{
            while(true){
                imprimir();
                System.out.println("---MENU---");
                System.out.println("0 - SAIR");
                System.out.println("1 - MOVIMENTAR");
                System.out.println("2 - SOLUÇÃO AUTOMÁTICA");
                System.out.print("DIGITE A OPÇÃO: ");
                int opcao = sc.nextInt();
                switch (opcao) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        System.out.print("Pilha de Origem: ");
                        String origem = sc.next();
                        if (origem.equals("A")) {
                            System.out.print("Pilha de Destino: ");
                            String destino = sc.next();
                            if (destino.equals("B")) {
                                pilhaA.push(pilhaB);
                                if (pilhaB.verificar(tamanho, ordem)) {
                                    imprimir();
                                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                                    return;
                                }
                            } else if (destino.equals("C")) {
                                pilhaA.push(pilhaC);
                                if (pilhaC.verificar(tamanho, ordem)) {
                                    imprimir();
                                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                                    return;
                                }
                            }
                        } else if (origem.equals("B")) {
                            System.out.print("Pilha de Destino: ");
                            String destino = sc.next();
                            if (destino.equals("A")) {
                                pilhaB.push(pilhaA);
                                if (pilhaA.verificar(tamanho, ordem)) {
                                    imprimir();
                                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                                    return;
                                }
                            } else if (destino.equals("C")) {
                                pilhaB.push(pilhaC);
                                if (pilhaC.verificar(tamanho, ordem)) {
                                    imprimir();
                                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                                    return;
                                }
                            }
                        } else if (origem.equals("C")) {
                            System.out.print("Pilha de Destino: ");
                            String destino = sc.next();
                            if (destino.equals("A")) {
                                pilhaC.push(pilhaA);
                                if (pilhaA.verificar(tamanho, ordem)) {
                                    imprimir();
                                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                                    return;
                                }
                            } else if (destino.equals("B")) {
                                pilhaC.push(pilhaB);
                                if (pilhaB.verificar(tamanho, ordem)) {
                                    imprimir();
                                    System.out.println("Ordenação concluída em " + jogadas + " jogadas");
                                    return;
                                }
                            }
                        }
                        break;
                    case 2:
                        prioridade(ordem);
                        auto(tamanho,ordem);
                        System.out.println("Ordenação concluída em " + Main.jogadas + " jogadas");
                        System.exit(0);
                        break;
                }
            }
        }

    }

}
