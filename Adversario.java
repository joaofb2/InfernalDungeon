public class Adversario extends Personagem{

    public Adversario(String n,int forca,int pericia)
    {
        super(n);
        if (forca>0){
            setForca(forca);
        }
        if (pericia>0){    
            setPericia(pericia);
        }
        setSorte(0);

    }

    public String toString(){
        return super.toString();
    }
       public void RemoverJoia(String novo){}
    public void addjoia(String novo){}
        public void RemoverEquipamento(String novo){}
            
      public void addEquipamento(String novo){}

    public void Fugir(){}

    public void SomarOuro(int ouroN){}

    public void SubtOuro(int ouroN){}

    public void getInformacoes(){}

    public void UsarProvisao(){}

    public void AtkRecebidoFugir(){}

    public void UsarPocao(){}
    
        public void DimiProvisoes(int provisoesN){ }

}