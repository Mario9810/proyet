import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrea 
 */
public class Lisp {
private String chain; 

public Lisp(String cadena){
    chain = cadena;
    
}
//metodo que comprueba que el comando cumpla con el tamanio minimo
public boolean isCorrect(String command){
    boolean correct = false;
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" "))); 
    int size = alist.size(); 
    if(size > 3){
        correct = true; 
    }
    
    return correct;
}

/*/
*************************************************************************************************************************
*                                                                                                                       *
*                                         arithmetical operations                                                       *
*                                                                                                                       *
*************************************************************************************************************************
/*/

//method that operates the add
public int suma(String command){
    
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" ")));
    int total = 0;
   
    for (int i = 2 ;i < (alist.size() - 1);i++){
        total = total + Integer.valueOf(alist.get(i)); 
       
        
    }
    return total;
}
// metodo enargado de la resta
public int resta(String command){
    
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" ")));
    int total = Integer.valueOf(alist.get(2));
   
    for (int i = 3;i < (alist.size() - 1);i++){
        total = total - Integer.valueOf(alist.get(i)); 
        
        
    }
    return total;
}


public int mult(String command){
    
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" ")));
    int total = Integer.valueOf(alist.get(2));
   
    for (int i = 3;i < (alist.size() - 1);i++){
        total = total * Integer.valueOf(alist.get(i)); 
        
        
    }
    return total;
}
public boolean canDiv(String command){
    boolean capable = false; 
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" "))); 
    int size = alist.size(); 
    if(size == 5){
        capable = true;
    }
    return capable;
}
public int div(String command){
    
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" ")));
    int total = Integer.valueOf(alist.get(2));
   
    for (int i = 3;i < (alist.size() - 1);i++){
        total = total / Integer.valueOf(alist.get(i)); 
        
        
    }
    return total;
}
/*/
*************************************************************************************************************************
*                                                                                                                       *
*                                         function declaring                                                            *
*                                                                                                                       *
*************************************************************************************************************************
/*/
//situational tools
public String getname(String command){
    List<String> func = new ArrayList<String>(Arrays.asList(command.split(" ")));
    return func.get(2);
}
public String getparam(String command){
    List<String> func = new ArrayList<String>(Arrays.asList(command.split("\\(")));
    return func.get(2);
}
public String getOp(String command){
    List<String> func = new ArrayList<String>(Arrays.asList(command.split("\\(")));
    return func.get(3);
}
public List<Integer> getIndex1 (String command){
     List<String> func = new ArrayList<String>(Arrays.asList(command.split("\\(")));       
    String name = func.get(1);
    name.replaceAll("\\s+", "");
    String parameter = func.get(2);
    parameter.replaceAll("\\s+", "");
    String ops = func.get(3);
    ops.replaceAll("\\s+", "");
    List<String> ppp = new ArrayList<String>(Arrays.asList(ops.split(" ")));
    ppp.remove(0);
    List<String> param = new ArrayList<String>(Arrays.asList(parameter.split(" ")));
    param.remove(0);
    List<Integer> index = new ArrayList<Integer>(1);
    List<Integer> index2 = new ArrayList<Integer>(1);
       for (int i = 0;i < ppp.size(); i++) {
            for (int j = 0;j < param.size() ; j++) {
                if(Objects.equals(ppp.get(i),param.get(j)) && !ppp.get(i).equals(")") ){
                    index.add(i); 
                    index2.add(j);
                }
                
            }
        }   
       return index;
}
//--------------------------------------------------------------------
public List<Integer> getIndex2 (String command){
     List<String> func = new ArrayList<String>(Arrays.asList(command.split("\\(")));       
    String name = func.get(1);
    name.replaceAll("\\s+", "");
    String parameter = func.get(2);
    parameter.replaceAll("\\s+", "");
    String ops = func.get(3);
    ops.replaceAll("\\s+", "");
    List<String> ppp = new ArrayList<String>(Arrays.asList(ops.split(" ")));
    ppp.remove(0);
    List<String> param = new ArrayList<String>(Arrays.asList(parameter.split(" ")));
    param.remove(0);
    List<Integer> index = new ArrayList<Integer>(1);
    List<Integer> index2 = new ArrayList<Integer>(1);
       for (int i = 0;i < ppp.size(); i++) {
            for (int j = 0;j < param.size() ; j++) {
                if(Objects.equals(ppp.get(i),param.get(j)) && !ppp.get(i).equals(")") ){
                    index.add(i); 
                    index2.add(j);
                }
                
            }
        }   
       return index2;
}

public int defun(String command, List<Integer> ix2,List<Integer> ix1, String ops, String pram ){
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" ")));
    List<Integer> index1 = ix1; 
    List<Integer> index2 = ix2;
    String op = ops;
    List<String> bops = new ArrayList<String>(Arrays.asList(op.split(" ")));
    String param = pram;
    List<String> para = new ArrayList<String>(Arrays.asList(param.split(" ")));
    List<String> temp = new ArrayList<String>(1);
    temp.add("("); 
    temp.add(bops.get(1));
    String time = "";
    for(int i = 0; i <(index1.size()) ;i++){
        
        time = alist.get(index1.get(i)+2);
        temp.add(time);
    }
    temp.add(")");
    
   
    //now to work on operation 
    StringBuilder sb = new StringBuilder();
    for (String s : temp)
        {
    sb.append(s);
    sb.append("\t");
        }
    String operation = sb.toString();
    int total = 0;  
   System.out.println("esta es la op: "+operation);
   
    if(Objects.equals(temp.get(1),"+" )){
        for (int i = 2 ;i < (temp.size() - 1);i++){
            total = total + Integer.valueOf(temp.get(i)); 


        }
    }
   
    if(Objects.equals(temp.get(1),"-" )){
        total = Integer.valueOf(temp.get(2));
        for (int i = 3;i < (temp.size() - 1);i++){
        total = total - Integer.valueOf(temp.get(i)); 
        
        
        }
    }
    if(Objects.equals(temp.get(1),"*" )){
        total = Integer.valueOf(temp.get(2));
        for (int i = 3;i < (temp.size() - 1);i++){
        total = total * Integer.valueOf(temp.get(i)); 
        
        
    }
    }
    if(Objects.equals(temp.get(1),"/" )){
       total = Integer.valueOf(alist.get(2));
   
    for (int i = 3;i < (alist.size() - 1);i++){
        total = total / Integer.valueOf(alist.get(i)); 
        
        
    }
                 
    }
    
   
return total;
}
/*/
*************************************************************************************************************************
*                                                                                                                       *
*                                           conditional argument                                                        *
*                                                                                                                       *
*************************************************************************************************************************
/*/

public boolean condicional(String command){
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" ")));
    boolean fact = false;
    System.out.println(alist);
    int n1 = Integer.valueOf(alist.get(4));
    int n2 = Integer.valueOf(alist.get(5));
    System.out.println(n1+" "+n2);
    if(Objects.equals(alist.get(3),"<")){
        fact = n1 < n2;
    }
     if(Objects.equals(alist.get(3),">")){
        fact = n1 > n2;
    }
      if(Objects.equals(alist.get(3),"=")){
        fact = n1 == n2;
    }
    if(Objects.equals(alist.get(3),"<>")){
        fact = n1 != n2;
    } 
    if(Objects.equals(alist.get(3),"equals")){
        fact = Objects.equals(n1,n2);
    }
    
    return fact;
}

//method that decides the arimethic op to do
/*/
being: 
1 = +
2 = -
3 = * 
4 = / 
5 = defun
6 = pow
/*/
public int function(String command, boolean cond, String funn){
    int variable = 0;
    List<String> func = new ArrayList<String>(Arrays.asList(command.split("\\(")));      
    List<String> alist = new ArrayList<String>(Arrays.asList(command.split(" ")));
    boolean t;
    t = false;
    if(Objects.equals(alist.get(1),"+" )){
        variable = 1;
        t = true;
    }
    if(Objects.equals(alist.get(1),"-" )){
        variable = 2;
        t = true;
    }
    if(Objects.equals(alist.get(1),"*" )){
        variable = 3;
        t = true;
    }
    if(Objects.equals(alist.get(1),"/" )){
        variable = 4;
        t = true;
    }
    
    if(Objects.equals(funn,alist.get(1))){
       variable = 6;
    }
    if(Objects.equals(alist.get(1),"defun" )){
        variable = 5;
        
    }
   if(Objects.equals(alist.get(1),"cond" )){
        variable = 7;
        t = true;
    }
  
    return variable;
}
}
