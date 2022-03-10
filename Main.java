import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
/*******************************************************
 * Main.java
 * @author Joao Filipe Gomes de Almeida Barros
 * @version 19.06.2014
 * 
 * Aventuras Fantasticas
 *******************************************************/
public class Main{
    public static void main() {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem-vindo!");
        System.out.println("A aventura está prestes a começar!!");
        
        Batalha b = new Batalha();
        System.out.println("===============================");
        String nomeJ = "";
        do{
            System.out.println("Qual o seu nome?");
            nomeJ = input.nextLine();
        } while(nomeJ.equals(""));
        Jogador j = new Jogador(nomeJ);
        System.out.println("");
        // Personagem p = (Personagem) j;
        b.adicionar(j);
        b.Infpsf();
        String pocao = "";
        do{
            System.out.println("Qual a poção que pretende escolher? (f-força,p-pericia,s-sorte)");
            pocao = input.nextLine();
        } while(pocao.equals(""));
        //while(!pocao.equals("p")|| !pocao.equals("s") || !pocao.equals("f"));
        j.setPocao(pocao);

        System.out.println("===============================");
        System.out.println(" 1 - Jogador");
        System.out.println(" 2 - Curar (Nao pode ser usado em combate!)");
        System.out.println(" 3 - Lutar");
        System.out.println(" 4 - Acções Especiais (Só usar se o livro indicar,");
        System.out.println("   - por exemplo: perder ouro,perder pericia, ganhar sorte...)");
        System.out.println(" 0 - Sair");
        System.out.println("===============================");

        int n = -1;
        try{
            n=input.nextInt();
        } catch(Exception e){
            System.out.println("ERRO: introduza um número entre 0 e 9");
        } finally{
            System.out.println(input.nextLine());
        }
        while (n != 0) {
            switch(n) {
                case 1:
                System.out.println("==========Jogador==========");
                System.out.println(" 1 - Toda a Informação do Jogador");
                System.out.println(" 2 - Adicionar Joia");
                System.out.println(" 3 - Adicionar Ouro");
                System.out.println(" 4 - Voltar ao menu inicial");
                System.out.println(" 0 - Sair");
                System.out.println("===============================");
                int m = -1;
                try{
                    m=input.nextInt();
                } catch(Exception e){
                    System.out.println("ERRO: introduza um número entre 0 e 4");
                } finally{
                    System.out.println(input.nextLine());
                }
                switch(m) {
                    case 1:
                    System.out.println("=======================");
                    System.out.println("Toda a Informação do Jogador");
                    b.ImprimeInfJogador();
                    break;

                    case 2:
                    System.out.println("=======================");
                    System.out.println("Adicionar Joia");
                    System.out.println("Qual o nome da joia a adicionar?");
                    String nomeJoia = input.nextLine();
                    b.addjoia(nomeJoia);
                    break;

                    case 3:
                    System.out.println("=======================");
                    System.out.println("Adicionar Ouro");
                    System.out.println("Quantia a adicionar?");
                    int addM = input.nextInt();
                    b.SomarOuro(addM);
                    break;

                    case 4:
                    break;

                    case 0:
                    System.out.println("Fim do Jogo!");
                    return;
                }
                break; 

                case 2:
                System.out.println("=====Curar=====");
                System.out.println(" 1 - Usar Poção (Só pode usar uma vez!)");
                System.out.println(" 2 - Usar Provissão");
                System.out.println(" 3 - Voltar ao menu inicial");
                System.out.println(" 0 - Sair");
                int l =  -1;
                try{
                    l=input.nextInt();
                } catch(Exception e){
                    System.out.println("ERRO: introduza um número entre 0 e 3");
                } finally{
                    System.out.println(input.nextLine());
                }
                switch(l) {
                    case 1:
                    System.out.println("=======================");
                    System.out.println("Usar Poção (Só pode usar uma vez!)");
                    b.UsarPocao();
                    break;

                    case 2:
                    System.out.println("=======================");
                    System.out.println("Usar Provissão");
                    b.UsarProvisao();
                    break;

                    case 3:
                    break;

                    case 0:
                    System.out.println("Fim do Jogo!");
                    return;
                }
                break;

                case 3:
                System.out.println("=====Lutar=====");
                System.out.println(" 1 - Acrescentar Adversario");
                System.out.println(" 2 - Lutar");
                System.out.println(" 3 - Fugir da Luta? (Escolher só se o livro o referir!)");
                System.out.println(" 4 - Voltar ao menu inicial");
                System.out.println(" 0 - Sair");
                int p =  -1;
                try{
                    p=input.nextInt();
                } catch(Exception e){
                    System.out.println("ERRO: introduza um número entre 0 e 4");
                } finally{
                    System.out.println(input.nextLine());
                }
                switch(p) {
                    case 1:
                    System.out.println("=======================");
                    System.out.println("Acrescentar Adversario");
                    String nomeA = "";
                    do{
                        System.out.println("Qual o nome do Adversario?");
                        nomeA = input.nextLine();
                    } while(nomeA.equals(""));
                    int forcaA = -1;
                    do{
                        System.out.println("Qual a sua Força?");
                        forcaA = input.nextInt();
                    }  while(forcaA<4 && forcaA>17);

                    int periciaA = -1;
                    do{
                        System.out.println("Qual a sua Pericia?");
                        periciaA = input.nextInt();
                    }  while(periciaA<4 && periciaA>13);
                    Adversario adv= new Adversario(nomeA,forcaA,periciaA);
                    b.adicionar(adv);

                    case 2:
                    System.out.println("=======================");
                    System.out.println("Lutar!");
                    b.VerPericia();
                    System.out.println("Quer usar a sorte nesta ronda?");
                    String Usarsorte = "";
                    do{
                        System.out.println("Sim(s)? Ou Não(n)?");
                        Usarsorte = input.nextLine();
                        if(Usarsorte.equals("n")){
                            b.Luta(false);
                            break;
                        }else if (Usarsorte.equals("s")){
                            b.Luta(true);
                            break;
                        }else {System.out.println("Valor Inválido!!");
                        }
                    }while(!Usarsorte.equals("s") || !Usarsorte.equals("n"));
                    break;

                    case 3:
                    System.out.println("=======================");
                    System.out.println("Fugir da Luta! (Escolher só se o livro o referir");
                    System.out.println("Quer usar a sorte nesta ronda?");
                    String fugir = "";
                    do{
                        System.out.println("Sim(s)? Ou Não(n)?");
                        fugir = input.nextLine();
                        if(fugir.equals("n")){
                            b.PodeFugir(false);
                            break;
                        }else if (fugir.equals("s")){
                            b.PodeFugir(true);
                            break;
                        }else {System.out.println("Valor Inválido!!");
                        }
                    }while(!fugir.equals("s") || !fugir.equals("n"));
                    break;

                    case 4:
                    break;

                    case 0:
                    System.out.println("Fim do Jogo!");
                    return;
                }
                break;

                case 4:
                System.out.println("=====Indicado pelo Livro (Só usar se o livro indicar)=====");
                System.out.println(" 1 - Aumentar a Pericia (Escolher só se o livro o referir!)");
                System.out.println(" 2 - Aumentar a Força (Escolher só se o livro o referir!)");
                System.out.println(" 3 - Aumentar a Sorte (Escolher só se o livro o referir!)");
                System.out.println(" 4 - Diminuir as Provisões (Escolher só se o livro o referir!)");
                System.out.println(" 5 - Diminuir as Jóias (Escolher só se o livro o referir!)");
                System.out.println(" 6 - Diminuir a Pericia (Escolher só se o livro o referir!)");
                System.out.println(" 7 - Diminuir a Força (Escolher só se o livro o referir!)");
                System.out.println(" 8 - Diminuir a Sorte (Escolher só se o livro o referir!)");
                System.out.println(" 9 - Diminuir Ouro (Escolher só se o livro o referir!)");
                System.out.println(" 10 - Voltar ao menu inicial");
                System.out.println(" 0 - Sair");
                int i =  -1;
                try{
                    i=input.nextInt();
                } catch(Exception e){
                    System.out.println("ERRO: introduza um número entre 0 e 10");
                } finally{
                    System.out.println(input.nextLine());
                }
                switch(i) {
                    case 1:
                    System.out.println("=======================");
                    int AumP=-1;
                    do{
                        System.out.println("Aumentar a Pericia (Escolher só se o livro o referir!)");
                        System.out.println("Em quanto quer Aumentar?");
                        AumP = input.nextInt();
                    } while(AumP<=0 && AumP>=7);
                    b.AumenPericia(AumP);
                    break;

                    case 2:
                    System.out.println("=======================");
                    int AumF=-1;
                    do{
                        System.out.println("Aumentar a Força (Escolher só se o livro o referir!)");
                        System.out.println("Em quanto quer aumentar?");
                        AumF = input.nextInt();
                    } while(AumF<=0 && AumF>=7);
                    b.AumenForca(AumF);
                    break;

                    case 3:
                    System.out.println("=======================");
                    int AumS=-1;
                    do{
                        System.out.println("Aumentar a Sorte (Escolher só se o livro o referir!)");
                        System.out.println("Em quanto quer Aumentar?");
                        AumS = input.nextInt();
                    } while(AumS<=0 && AumS>=7);
                    b.AumenSorte(AumS);
                    break;

                    case 4:
                    System.out.println("=======================");
                    int DimPro=-1;
                    do{
                        System.out.println("Diminuir as Provisões (Escolher só se o livro o referir!)");
                        System.out.println("Em quanto quer Diminuir?");
                        DimPro = input.nextInt();
                    } while(DimPro<=0 && DimPro>=7);
                    b.DimiProvisao(DimPro);
                    break;

                    case 5:
                    System.out.println("=======================");
                    String DimJ="";
                    do{
                        System.out.println("Diminuir as Jóias (Escolher só se o livro o referir!)");
                        System.out.println("Qual a joia a retirar(Indicada pelo livro!)");
                        DimJ = input.nextLine();
                    } while(pocao.equals(""));
                    b.RemoverJoia(DimJ);
                    break;

                    case 6:
                    System.out.println("=======================");
                    int DimP=-1;
                    do{
                        System.out.println("Diminuir a Pericia (Escolher só se o livro o referir!)");
                        System.out.println("Em quanto quer Diminuir?");
                        DimP = input.nextInt();
                    } while(DimP<=0 && DimP>=7);
                    b.DimiPericia(DimP);
                    break;

                    case 7:
                    System.out.println("=======================");
                    int DimF=-1;
                    do{
                        System.out.println("Diminuir a Força (Escolher só se o livro o referir!)");
                        System.out.println("Em quanto quer Diminuir?");
                        DimF = input.nextInt();
                    } while(DimF<=0 && DimF>=10);
                    b.DimiForca(DimF);
                    break;

                    case 8:
                    System.out.println("=======================");
                    int DimS=-1;
                    do{
                        System.out.println("Diminuir a Sorte (Escolher só se o livro o referir!)");
                        System.out.println("Em quanto quer Diminuir?");
                        DimS = input.nextInt();
                    } while(DimS<=0 && DimS>=7);
                    b.DimiSorte(DimS);
                    break;

                    case 9:
                    System.out.println("=======================");
                    int DimO=-1;
                    do{
                        System.out.println("Diminuir Ouro (Escolher só se o livro o referir!)");
                        System.out.println("Em quanto quer Diminuir?");
                        DimO = input.nextInt();
                    } while(DimO<=0 && DimO>=7);
                    b.SubtOuro(DimO);
                    break;

                    case 10:
                    break;

                    case 0:
                    System.out.println("Fim do Jogo!");
                    return;
                }

            }
            System.out.println("===============================");
            System.out.println(" 1 - Jogador");
            System.out.println(" 2 - Curar");
            System.out.println(" 3 - Lutar");
            System.out.println(" 4 - Acções Especiais (Só usar se o livro indicar,");
            System.out.println("   - por exemplo: perder dinheiro,perder pericia, ganhar sorte...)");
            System.out.println(" 0 - Sair");
            System.out.println("===============================");

            n = input.nextInt();
            input.nextLine();
        }
        System.out.println("Fim do Jogo!");

    }
}

/*
System.out.println("===============================");
System.out.println("O que pretende fazer?");
System.out.println("=====Jogador=====");
System.out.println(" 3 - Toda a Informação do Jogador");
System.out.println(" 4 - Adicionar Joia");
System.out.println(" 5 - Adicionar dinheiro");
System.out.println(" 6 - Remover dinheiro");
System.out.println("=====Curar=====");
System.out.println(" 1 - Usar Poção (Só pode usar uma vez)");
System.out.println(" 2 - Usar Provissão");
System.out.println("=====Lutar=====");
System.out.println(" 8 - Lutar");
System.out.println(" 9 - Fugir da Luta? (Escolher só se o livro o referir!)");
System.out.println("=====Indicado pelo Livro=====");
System.out.println("=====Indicado pelo Livro (Só usar se o livro indicar)=====");
System.out.println(" 1 - Aumentar a Pericia (Escolher só se o livro o referir!)");
System.out.println(" 2 - Aumentar a Força (Escolher só se o livro o referir!)");
System.out.println(" 3 - Aumentar a Sorte (Escolher só se o livro o referir!)");
System.out.println(" 4 - Aumentar Ouro (Escolher só se o livro o referir!)");
System.out.println(" 5 - Diminuir as Provisões (Escolher só se o livro o referir!)");
System.out.println(" 6 - Diminuir as Jóias (Escolher só se o livro o referir!)");
System.out.println(" 7 - Diminuir a Pericia (Escolher só se o livro o referir!)");
System.out.println(" 8 - Diminuir a Força (Escolher só se o livro o referir!)");
System.out.println(" 9 - Diminuir a Sorte (Escolher só se o livro o referir!)");
System.out.println(" 10 - Diminuir Ouro (Escolher só se o livro o referir!)");
System.out.println("=====SAIR=====");
System.out.println(" 0 - Sair!");
System.out.println("=========================");
 */
