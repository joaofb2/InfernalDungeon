import java.util.Random;
public abstract class Personagem
{
    private int pericia,forca,sorte;
    private String nome;
    private boolean tenhoSorte;
    public  Personagem(String nome)
    {
        tenhoSorte=false;
        this.nome=nome;
    }

    public int getRandom(){
        return (int)(1+ Math.random()*6);
    }

    public String getNome() { 
        return nome; 
    }

    public int getForca() { 
        return forca; 
    } 

    public int getPericia() { 
        return pericia; 
    } 

    public int getSorte() { 
        return sorte; 
    }

    public boolean gettenhoSorte() { 
        return tenhoSorte ; 
    }

    public void setForca(int forca) { 
        this.forca=forca; 
    }

    public void setPericia(int pericia ) { 
        this.pericia =pericia ;  
    } 

    public void setSorte(int sorte) { 
        this.sorte =sorte; 
    } 

    public void DimiForca(int forcaN) { 
        forca = forca -forcaN; 
    }

    public void DimiPericia(int periciaN) { 
        pericia =pericia -periciaN ;  
    } 
    
        public void DimiSorte(int sorteN) { 
        sorte =sorte -sorteN ;  
    }

    public void AumenPericia(int periciaN) { 
        pericia =pericia +periciaN ;  
    }
        public void AumenSorte(int sorteN) { 
        sorte =sorte +sorteN ;  
    }
        public void AumenForca(int forcaN) { 
        forca =forca +forcaN ;  
    }

    public void DimiSorteUm() { 
        sorte =sorte - 1; 
    } 

    public boolean Vivo(){
        boolean estado=true;
        if (forca<=0){
            estado = false;
        }
        return estado;
    }

    public String toString(){
        return getNome()+": tem de força: "+getForca() + " tem de pericia: " +getPericia()+ " e de sorte: "+getSorte();
    }

    public void atkRecebido(){
        forca = forca - 2;
    }

    public void DefinirPericia(){
        pericia = pericia + getRandom() + getRandom();
    }

    public boolean DefinirSorte(){
        if (getSorte()  >= (getRandom() + getRandom())){
            tenhoSorte = true;
            System.out.println("Parabéns! Teve Sorte!");
        }else {tenhoSorte= false;
            System.out.println("Que pena teve Azar!");
        }
        
        return tenhoSorte;
    }

    public void UsarSorteCombate(){
        if (gettenhoSorte()== true){
            DimiForca(4);
        }else{
            DimiForca(1);
        }         
    }

    public void ReceberSorteCombate(){
        if (gettenhoSorte()== true){
            DimiForca(1);
        }else{
            DimiForca(3);
        }         
    }

    public abstract void getInformacoes();

    public abstract void UsarProvisao();

    public abstract void UsarPocao();

    public abstract void SomarOuro(int ouroN);

    public abstract void addjoia(String novo);
        
      public abstract void addEquipamento(String novo);

    public abstract void SubtOuro(int ouroN);

    public abstract void RemoverJoia(String novo);
    public abstract void RemoverEquipamento(String novo);
    
        public abstract void DimiProvisoes(int provisoesN);
    // APAGAR//////
    public abstract void Fugir();

    public abstract void AtkRecebidoFugir();
}
