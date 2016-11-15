package projetojava;

import java.io.*;

/**Chama o teclado virtual do sistema - Atributo especial
*@author Bruno Felix
*@author João Marcus
*@author Emerson Lemos
*@author Rayemilley Martins 
*/
public class TecladoVirtual{
    
    /**Método para abrir o Teclado Virtual através do CMD do sistema*/
    public void getTecladoVirtual(){
        try{
            Runtime.getRuntime().exec("cmd /c C:\\Windows\\System32\\osk.exe");
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    
    
}
