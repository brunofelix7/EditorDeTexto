package projetojava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/** Classe do sistema utilizada para carregar o arquivo .txt dentro da JTextPane
 *@author Rayemilly Martins 
 */
public class AbrirArquivo {

    public void abrirTexto(String abrir) throws IOException{

        String local = JOptionPane.showInputDialog(null, "Local: ");
        String arq = JOptionPane.showInputDialog(null, "Nome do arquivo: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(local + File.separator + arq + ".txt"), "ISO-8859-1"));  
        
        try{  
            String str, txt = "";
            while((str = in.readLine()) != null){  
                txt += str + "\n";  
            }  
        }catch(IOException ex){  
            ex.printStackTrace();
        }finally{
            in.close();
        }
        
    }
    
}
