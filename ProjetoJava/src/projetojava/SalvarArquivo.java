package projetojava;

import java.io.*;
import javax.swing.*;

/** Classe do sistema utilizada para carregar o arquivo .txt dentro da JTextPane
 *@author Bruno Felix 
 */
public class SalvarArquivo{
    
    public void salvarTexto(String txt) throws IOException{

        DataHora d = new DataHora();
        String data = d.getDataTime();
        
        String local = JOptionPane.showInputDialog(null, "Local: ");
        String nome = JOptionPane.showInputDialog(null, "Nome do arquivo: ");
        int r = JOptionPane.showConfirmDialog(null,"Salvar neste local?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if(r == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }if(r == JOptionPane.NO_OPTION){
            return;
        }
        
        File arquivo = new File(local + File.separator + nome + ".txt");
        arquivo.createNewFile();
        FileWriter escrever = new FileWriter(arquivo);
        
        try{
            escrever.write(data + "\r\n\r\n" + txt);
        }catch(IOException erro){
            erro.printStackTrace();
        }finally{
            escrever.close();
        }
    }
        

}

// BufferedWriter escrever = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo),"UTF-8"));
