import java.util.ArrayList;
public class Jogador extends Personagem{
    private int ouro,provisoes;
    ArrayList<String> joias,equipamentos;
    private String pocao;
    private boolean fugir;
    private int p,s,f;
    public Jogador(String n)
    {
        // Por a receber String pocao neste metodo 
        super(n);
        // p = pericia, s=sorte,f=forca

        setPericia(6 + getRandom());
        p = getPericia();
        setForca(12 + getRandom() +getRandom());
        f = getForca();
        setSorte(6 + getRandom());
        s = getSorte();
        
        pocao ="";
        fugir = false;
        ouro = 0;
        provisoes=10;
        joias = new ArrayList<String>();
        equipamentos = new ArrayList<String>();
    }

    public void UsarPocao(){
        if (pocao.equals("p")){
            pocao="";
            setPericia(p);
        }else if (pocao.equals("f")){
            pocao="";
            setForca(f);
        }else if(pocao.equals("s")){
            pocao="";
            setSorte(s+1);
        }else{
            System.out.println("Já usou a poção! Nao existem mais poções!");
        }
    }

    public void UsarProvisao(){
        provisoes= provisoes -1;
        setForca(getForca()+4);
        if(getForca()>f){
            setForca(f);
        }
    }

    public ArrayList<String> getJoias() { 
        return joias; 
    }
    
        public ArrayList<String> getEquipamento() { 
        return equipamentos; 
    }

    public boolean getFugir() { 
        return fugir; 
    }

    public String getPocao() { 
        return pocao; 
    } 

    public int getProvisoes() { 
        return provisoes; 
    }

    public int getOuro() { 
        return ouro; 
    } 

    public String toString(){
        return " "+ super.toString();
    }

    public void getInformacoes(){
        String output = super.toString() + "\nProvisoes: " + getProvisoes() + "\nOuro: "+getOuro()+ "\nPocao escolhida: "+getPocao()+ "\nJoias: \n"; 
        for (String cada: joias){
            output= output+ "      "+cada+";\n";
        }
        System.out.println(output);
    }

    public void addjoia(String novo){
        joias.add(novo);
    }
    
     public void RemoverJoia(String novo){
        joias.remove(novo);
    }
    
      public void addEquipamento(String novo){
        equipamentos.add(novo);
    }
    
       public void RemoverEquipamento(String novo){
        equipamentos.remove(novo);
    }
    
    public void Fugir(){
        fugir = true;
    }

    public void SomarOuro(int ouroN){
        ouro=ouro+ouroN;
    }

    public void SubtOuro(int ouroN){
        ouro=ouro-ouroN;
    }

    public void DimiProvisoes(int provisoesN){
        provisoes=provisoes-provisoesN;
    }

    public void AtkRecebidoFugir(){
        if (fugir==true){
            if (gettenhoSorte()== false){
                DimiForca(2);
            }else{
                DimiForca(1);
            } 
        } 
    }

    public void setPocao(String pocao){
        this.pocao = pocao;
    }
}