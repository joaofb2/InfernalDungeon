import java.util.ArrayList;
import java.util.Random;
public class Batalha { 
    private  ArrayList<Personagem> lista; 
    Random random = new Random();
    boolean usarSorte;
    Personagem p1,p2;
    int pInicial1,pInicial2;
    public Batalha () {
        lista = new ArrayList<Personagem>(); 
        pInicial1 =0;
        pInicial2=0;
        p1 = null;
        p2 =null;
    } 

    public void adicionar(Personagem novo) { 
        if(lista.size()<2){
            lista.add(novo);
            p1 = lista.get(0);
        }
    } 

    public void ImprimeInfJogador(){
        p1.getInformacoes();
    }

    public void imprimirTudo() {
        for (Personagem cada : lista) { 
            System.out.println(cada); 
        } 
    }

    public void VerPericia(){
        p1 = lista.get(0);
        p2 = lista.get(1);   
        pInicial1 = p1.getPericia();
        pInicial2 = p2.getPericia();
        p1.DefinirPericia();
        p2.DefinirPericia();
        System.out.println("Sua Pericia: "+ p1.getPericia());
        System.out.println("Pericia do adversario: "+ p2.getPericia());
    }

    public void Luta(boolean sorte){
        UsarSorte(sorte);

        if(lista.size()>=0){
            //int pInicial1 = p1.getPericia();
            //int pInicial2 = p2.getPericia();
            //p1.DefinirPericia();
            //p2.DefinirPericia();
            //System.out.println("p1: "+ p1.getPericia());
            //System.out.println("p2: "+ p2.getPericia());
            if(p1.getPericia()>p2.getPericia()){
                // System.out.println("se acertar quer tentar a sorte? 
                //nao perde nada por isso (true) ou (false"))
                if(getUsarSorte() == true){    
                    p1.DimiSorteUm();
                    p1.DefinirSorte();
                    p2.UsarSorteCombate();
                }else{
                    p2.atkRecebido();
                }
            }
            /*else{
            p1.atkRecebido();    
            }*/

            if (p1.getPericia()<p2.getPericia()){
                if(getUsarSorte() == true){    
                    p1.DimiSorteUm();
                    p1.DefinirSorte();
                    p1.ReceberSorteCombate();
                }else{
                    p1.atkRecebido();
                }
            }
            p1.setPericia(pInicial1);
            p2.setPericia(pInicial2);
            if (p1.getPericia()==p2.getPericia()){
                return;
            }

            if (p2.Vivo()== false){
                System.out.println("Ganhou!");
                System.out.println("Pode continuar a aventura!");
                System.out.println("Jogador: "+ p1.toString());
                lista.remove(1);
                return;
            }else if(p1.Vivo()== false){
                System.out.println("Vencedor da Batalha: " + p2.getNome());
                System.out.println( p1.getNome()+ " Perdeu o jogo!");
                return;
            }
            //if (p1.Vivo() == false){
            System.out.println("Jogador: "+ p1.toString());
            System.out.println("adversario: "+ p2.toString());
            return;
        }
    }    

    public void UsarSorte(boolean usarSorte){
        this.usarSorte = usarSorte;
    }

    public boolean getUsarSorte(){
        return usarSorte;
    }

    public void PodeFugir(boolean usarSorte){
        //System.out.println("Quer fugir??"); por no main 
        lista.remove(1);

        //System.out.println("Quer usar a sorte");por no main
        if(usarSorte){
            p1.DimiSorteUm();
            p1.DefinirSorte();
            p1.ReceberSorteCombate();
        }else{
            p1.atkRecebido();
        }
        System.out.println("Fugiu com Sucesso!");
        System.out.println(p1.toString());
    }

    public void UsarProvisao(){
        p1.UsarProvisao();
    }
    
      public void DimiProvisao(int proN){
        p1.DimiProvisoes(proN);
    }

    public void UsarPocao(){
        p1.UsarPocao();
    }

    public  void SomarOuro(int ouroN){
        p1.SomarOuro(ouroN);
    }

    public  void addjoia(String novo){
        p1.addjoia(novo);
    }
        public  void addEquipamento(String novo){
        p1.addEquipamento(novo);
    }

    public  void SubtOuro(int ouroN){
        p1.SubtOuro(ouroN);
    }

    public void RemoverJoia(String novo){        
        p1.RemoverJoia(novo);
    }
    public void RemoverEquipamento(String novo){
        p1.RemoverEquipamento(novo);
    }

    public void AumenPericia(int novo){        
        p1.AumenPericia(novo);
    }
        public void AumenSorte(int sorteN) { 
       p1.AumenSorte(sorteN);
    }
        public void AumenForca(int forcaN) { 
        p1.AumenForca(forcaN); 
    }
    
    public void DimiPericia(int novo){        
        p1.DimiPericia(novo);
    }

    public void DimiForca(int novo){        
        //p1 = lista.get(0);
        p1.DimiForca(novo);
    }

    public void DimiSorte(int novo){        
       // p1 = lista.get(0);
        p1.DimiSorte(novo);
    }

    public void Infpsf(){
        System.out.println(p1.toString());
    }
}

