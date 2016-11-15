package projetojava;

import java.io.IOException;

/**Busca a data e hora do sistema
 *@author Bruno Felix
 *@author João Marcus 
 */
public class JavaDoc {
    
    /**Método para abrir o JavaDoc através do CMD do sistema
     *@author Bruno Felix
     *@author João Marcus 
     */
    public void getJavaDoc(){
        try{
            Runtime.getRuntime().exec("cmd /c dist\\javadoc\\index.html");
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
