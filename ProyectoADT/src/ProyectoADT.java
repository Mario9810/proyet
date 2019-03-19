import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Andrea
 */
public class ProyectoADT {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lisp lisp = new Lisp("");
        Scanner keyboard = new Scanner(System.in);
        int condicion = 0;
        List<Integer> index1 = new ArrayList(1);
        List<Integer> index2 = new ArrayList(1);
        String opss = "";
        String param = "";
        String funName = "";
       
         String command = "";
        int fun = 0;
        boolean noerror = false; //variable that prevents function crash
        int myturn = 0;
       while(condicion == 0){
          System.out.println("Ingrese comando a ejectutar en LISP: " +funName); //user is requested to put an operation
          command = keyboard.nextLine();
         fun = lisp.function(command,noerror,funName); //function method its called
         if(lisp.isCorrect(command) == true){
            
            if(fun == 1){
                System.out.println(lisp.suma(command));
                noerror = true;
            }
            if(fun == 2){
                System.out.println(lisp.resta(command));
                noerror = true;
            }
            if(fun == 3){
                System.out.println(lisp.mult(command));
                noerror = true;
            }
            if(fun == 4){
                if(lisp.canDiv(command) == true){
                    System.out.println(lisp.div(command));
                    noerror = true;
                }
                else{
                    System.out.println("Solo se aceptan dos parametros en division");
                }
                
            }
             if(fun == 6 && myturn ==1) { 
                
                System.out.println(lisp.defun(command,index1,index2,opss,param));
            }
            if(fun == 5){
                index1 = lisp.getIndex1(command);
                index2 = lisp.getIndex2(command);
                funName = lisp.getname(command);
                opss = lisp.getOp(command);
                param = lisp.getparam(command);
               myturn = 1;
            }
           
            if(fun == 7){
                System.out.println(lisp.condicional(command));
            }
         }   
            
        else{
            System.out.println("La funcion indicada no es correcta");
        }
         
         
       System.out.println("presione 0 para continuar,pulse 1 para salir...");
       
       condicion = keyboard.nextInt();
       keyboard.nextLine();
      
       
    } 
       
    }
    
}
