
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class SardinasPatterson {


    public static void StampaArr(String nome, ArrayList<String> s){
        System.out.println("Stampa di "+nome);
        System.out.println("/-----------/");
       
        if(s.isEmpty()){
             System.out.println("/-  Vuoto  -/");
        }else{
            for(String x : s){
                System.out.println(x);
            }
        }

        System.out.println("/-----------/");
    }

    public static void CaricaSi(String nome, ArrayList<String> s0){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci stringhe nella colonna "+nome+" di codice e quando hai terminato premi -");
        String input;
        do{
            input = sc.nextLine();
            if(input.equals("-") == false)
                s0.add(input);
        }while(input.equals("-") == false);
        Collections.sort(s0);  

    }
    public static ArrayList<String> CalcolaSi(int ncreated, ArrayList<String> s0, ArrayList<String> si){
        ArrayList<String> sapp = s0;
        ArrayList snew = new ArrayList();

        if(ncreated == 0){
            //creazione di S1
            for(String x1 : s0){
                for(String x2 : s0){
                    if(x1.startsWith(x2) && x1.equals(x2) == false){

                        //capisco i prefissi di altre parole
                        //System.out.println("x2: "+x2+" è prefisso di x1: "+x1);
                    
                        //elimino i prefissi da altre parole
                        String newS = x1.substring(x2.length());
                        //System.out.println("parola nuova da aggiungere in s1 "+newS);
                        snew.add(newS);
                    }
                }
            }
            
           // StampaArr("S"+ncreated, snew);
            
        }else{
            //creazione di Si più grandi di uno
             for(String x1 : s0){
                for(String x2 : si){
                    if(x1.startsWith(x2) && x1.equals(x2) == false){

                        //capisco i prefissi di altre parole
                        //System.out.println("x2: "+x2+" è prefisso di x1: "+x1);
                    
                        //elimino i prefissi da altre parole
                        String newS = x1.substring(x2.length());
                        //System.out.println("parola nuova da aggiungere in s1 "+newS);
                        if(snew.contains(newS) == false)
                            snew.add(newS);
                    }
                }
             }
             for(String x3 : si){
                for(String x4 : s0){
                    if(x3.startsWith(x4) && x3.equals(x4) == false){

                        //capisco i prefissi di altre parole
                        //System.out.println("x4: "+x4+" è prefisso di x3: "+x3);
                    
                        //elimino i prefissi da altre parole
                        String newS = x3.substring(x4.length());
                        //System.out.println("parola nuova da aggiungere in s1 "+newS);
                        if(snew.contains(newS) == false)
                            snew.add(newS);
                    }
                }
            }
        }

        //StampaArr("S"+ncreated, snew);
        return snew;
        
    }

    public static boolean StopCondizion(ArrayList<String> s0, ArrayList<String> si, ArrayList<ArrayList<String>> story){
        
     
        //1° condizione
        if(si.isEmpty() == true){
            System.out.println("empty Il codice è UD");
            return true;
        }
        else{
            //3° condizione
            //System.out.println("Le liste sono Diverse");
            boolean occ = false;
            for (String elemento : si) {
                if (s0.contains(elemento)) {
                    occ = true;
                    break; // Se abbiamo trovato una corrispondenza, usciamo dal ciclo
                }
            }

            if(occ){
                System.out.println("Il codice non è UD");
                return true;
            }

            //2° condizione
            for(ArrayList<String> s : story){
                if(si.equals(s)){
                    StampaArr("s", s);
                    StampaArr("si", si);
                    System.out.println("uguals Il codice è UD");
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        
                
        System.out.println("..........................................");
        System.out.println("Sardinas-Patterson Algo");
        System.out.println("Determinazione se una codifica è UD");
        System.out.println("..........................................");
        ArrayList<ArrayList<String>> story = new ArrayList();

        int count = 0;
        boolean stop = false;
        ArrayList s0 = new ArrayList();
        ArrayList si = new ArrayList();
        CaricaSi("s0",s0);


        //per testare un caricamento singolo di un nuovo si aventi s0 e si-1
        // CaricaSi("s1",si);
        // StampaArr("s0",s0);

        // si = CalcolaSi(1, s0, si);
        // StampaArr("si finale",si);


        
        while(stop == false){
            si = CalcolaSi(count, s0, si);
           
            StampaArr("S"+(count+1),si);
            count++;  
            stop = StopCondizion(s0,si,story);
            story.add(si);
        }
        System.out.println("..........................................");
        System.out.println("Programma terminato");
        System.out.println("..........................................");
    }
}





