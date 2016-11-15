package projetojava;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**Classe principal para execução do programa 
 *@author Bruno Felix 
 *@author João Marcus
 *@author Emerson Lemos
 *@author Rayemilley Martins 
 */
public class Principal {
    
    public static void main(String[] args) throws IOException{

    //INSTÂNCIA PARA CHAMADA DA CLASSE ONDE CONTÉM NOSSO ATRIBUTO ESPECIAL
        TecladoVirtual teclado = new TecladoVirtual();
        
    //CRIAÇÃO DE COMPONENTES UTILIZANDO AS CLASSES SWING E AWT
        ImageIcon icone = new ImageIcon("botões/iconLogo.png");
        JFrame frm1 = new JFrame("FlatEditor");
        frm1.setIconImage(icone.getImage());
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel();
        JPanel panelDown = new JPanel();
        JPanel panelLogo = new JPanel();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuEditar = new JMenu("Editar");
        JMenu menuFerramentas = new JMenu("Ferramentas");
        JMenu menuSobre = new JMenu("Sobre");
        ImageIcon logo = new ImageIcon("botões/bigLogo.png");
        JLabel label = new JLabel(logo);
        JMenuBar menuBar = new JMenuBar();
        JMenuItem itemNovo = new JMenuItem("Novo");
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemSalvarComo = new JMenuItem("Salvar como");
        JMenuItem itemImprimir = new JMenuItem("Imprimir");
        JMenuItem itemConf = new JMenuItem("Configurações");
        JMenuItem itemSair = new JMenuItem("Sair");
        JMenuItem itemRecortar = new JMenuItem("Recortar");
        JMenuItem itemCopiar = new JMenuItem("Copiar");
        JMenuItem itemColar = new JMenuItem("Colar");
        JMenuItem itemNegrito = new JMenuItem("Negrito");
        JMenuItem itemSublinhado = new JMenuItem("Sublinhado");
        JMenuItem itemItalico = new JMenuItem("Itálico");
        JMenuItem itemJavaDoc = new JMenuItem("Java Doc");
        JMenuItem itemAutores = new JMenuItem("Autores");
        
        
    //ADICIONA A BARRA DE MENU
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);
        menuBar.add(menuFerramentas);
        menuBar.add(menuSobre);
        
    //ADICIONA ITENS AOS MENUS
        menuArquivo.add(itemNovo);
        menuArquivo.add(itemAbrir);
        menuArquivo.add(itemSalvar);
        menuArquivo.add(itemSalvarComo);
        menuArquivo.add(itemImprimir);
        menuArquivo.add(itemConf);
        menuArquivo.add(itemSair);
        menuEditar.add(itemRecortar);
        menuEditar.add(itemCopiar);
        menuEditar.add(itemColar);
        menuFerramentas.add(itemSublinhado);
        menuFerramentas.add(itemNegrito);
        menuFerramentas.add(itemItalico);
        menuSobre.add(itemJavaDoc);
        menuSobre.add(itemAutores);
        
    //ALTERA COR DOS MENUS E ITENS
        itemSair.setForeground(Color.decode("#D60101"));
        menuArquivo.setForeground(Color.decode("#0A52BC"));
        menuEditar.setForeground(Color.decode("#0A52BC"));
        menuFerramentas.setForeground(Color.decode("#0A52BC"));
        menuSobre.setForeground(Color.decode("#0A52BC"));
        itemNovo.setForeground(Color.decode("#0A52BC"));
        itemAbrir.setForeground(Color.decode("#0A52BC"));
        itemSalvar.setForeground(Color.decode("#0A52BC"));
        itemImprimir.setForeground(Color.decode("#0A52BC"));
        itemSalvarComo.setForeground(Color.decode("#0A52BC")); 
        itemConf.setForeground(Color.decode("#0A52BC")); 
        itemRecortar.setForeground(Color.decode("#0A52BC")); 
        itemCopiar.setForeground(Color.decode("#0A52BC")); 
        itemColar.setForeground(Color.decode("#0A52BC")); 
        itemSublinhado.setForeground(Color.decode("#0A52BC")); 
        itemNegrito.setForeground(Color.decode("#0A52BC")); 
        itemItalico.setForeground(Color.decode("#0A52BC")); 
        itemJavaDoc.setForeground(Color.decode("#0A52BC")); 
        itemAutores.setForeground(Color.decode("#0A52BC")); 
        
        frm1.add(panelTop, BorderLayout.PAGE_START); //Altera painel do top
        frm1.add(panelBottom, BorderLayout.CENTER); //Altera painel do meio
        frm1.add(panelDown, BorderLayout.PAGE_END); //Altera painel de baixo
        frm1.setJMenuBar(menuBar); //Adiciona a barra de menu no frame
        frm1.setSize(800, 600); //Dimensões do frame H/W

        panelTop.setLayout(new FlowLayout(FlowLayout.LEFT)); //Alinha elementos do interior do panel à esquerda
        panelTop.setBorder(new EmptyBorder(3, 3, 3, 3)); //Borda externa do painel do top
        panelDown.setBorder(new EmptyBorder(2,2,2,2));  //Altera tamanho da borda do painel de baixo
        panelDown.setLayout(new FlowLayout(FlowLayout.LEFT)); //Alinha elementos de baixo do panel à esquerda
        panelBottom.setBorder(new EmptyBorder(0, 60, 0, 60)); //Altera o tamanho painel do centro
        panelTop.setBackground(Color.decode("#D7DADC")); //Alterar cor do painel superior
        panelBottom.setBackground(Color.decode("#D7DADC")); //Alterar cor do painel lateral
        panelDown.setBackground(Color.decode("#D7DADC")); //Atera cor do painel de baixo
        panelDown.add(label); //Adiciona label que contém a imagem da logomarca no painel de baixo
        
        
    //ÁREA DE TEXTO
        JTextPane area = new JTextPane(); 
        area.setMargin(new Insets(25,25,25,25)); 
        area.setFont(new Font(null, 0, 15));
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
    //BOTÃO NOVO
        FButton botao1 = new FButton("botões/normalNovo.png", "botões/hoverNovo.png", "botões/pressNovo.png");
        panelTop.add(botao1);
        botao1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            area.setText("");
        }});
        itemNovo.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            area.setText("");
        }});
        
    //BOTÃO ABRIR
        FButton botao2 = new FButton("botões/normalAbrir.png", "botões/hoverAbrir.png", "botões/pressAbrir.png");
        panelTop.add(botao2);
        botao2.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String local = JOptionPane.showInputDialog(null, "Local: ");
            String arq = JOptionPane.showInputDialog(null, "Nome do arquivo: ");
        try{  
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(local + File.separator + arq + ".txt"), "ISO-8859-1"));  
            String str, txt = "";
            while((str = in.readLine()) != null){  
                txt += str + "\n";  
            }  
            area.setText(txt);  
        }catch(IOException ex){  
            ex.printStackTrace();
        }
        }});
        itemAbrir.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String local = JOptionPane.showInputDialog(null, "Local: ");
            String arq = JOptionPane.showInputDialog(null, "Nome do arquivo: ");
        try{  
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(local + File.separator + arq + ".txt"), "ISO-8859-1"));  
            String str, txt = "";
            while((str = in.readLine()) != null){  
                txt += str + "\n";  
            }  
            area.setText(txt);  
        }catch(IOException ex){  
            ex.printStackTrace();
        }
        }});
        
    //BOTÃO SALVAR                    
        FButton botao3 = new FButton("botões/normalSalvar.png", "botões/hoverSalvar.png", "botões/pressSalvar.png");
        panelTop.add(botao3);
        botao3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                String gravar = area.getText().replaceAll("\n", System.getProperty("line.separator"));
                SalvarArquivo st = new SalvarArquivo();
                st.salvarTexto(gravar);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }});
        itemSalvar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                String gravar = area.getText().replaceAll("\n", System.getProperty("line.separator"));
                SalvarArquivo st = new SalvarArquivo();
                st.salvarTexto(gravar);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }});
                
    //ITEM SALVAR COMO 
        itemSalvarComo.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
        /*
        JFileChooser salvarArquivo = new JFileChooser();
        int returnValue = salvarArquivo.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        */
            SalvarArquivo salvar = new SalvarArquivo();
            try {
                salvar.salvarTexto(area.getText());
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }}});
        
    //ITEM IMPRIMIR      
        itemImprimir.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "Função indisponível no momento", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }});
 
    //ITEM CONFIGURAÇÕES      
        itemConf.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "Função indisponível no momento", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }});
        
    //BOTÃO RECORTAR
        FButton botao6 = new FButton("botões/normalRecortar.png", "botões/hoverRecortar.png", "botões/pressRecortar.png");
        panelTop.add(botao6);
        botao6.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            area.cut();
        }});
        itemRecortar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            area.cut();
        }});
        
    //BOTÃO COPIAR
        FButton botao5 = new FButton("botões/normalCopiar.png", "botões/hoverCopiar.png", "botões/pressCopiar.png");
        panelTop.add(botao5);
        botao5.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            area.copy();
        }});
        itemCopiar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            area.copy();
        }});
        
    //BOTÃO COLAR
        FButton botao7 = new FButton("botões/normalColar.png", "botões/hoverColar.png", "botões/pressColar.png");
        panelTop.add(botao7);
        botao7.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            area.paste();
        }});
        itemColar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            area.paste();
        }});
        
    //BOTÃO NEGRITO
        FButton botao8 = new FButton("botões/normalNegrito.png", "botões/hoverNegrito.png", "botões/pressNegrito.png");
        panelTop.add(botao8);
        botao8.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(area.getSelectedText());

            try{
                StyleContext context = new StyleContext();
                StyledDocument document = new DefaultStyledDocument(context);
                Style style = context.getStyle(StyleContext.DEFAULT_STYLE);

            if(area.getSelectedText() != null){
                String texto = area.getText();
                String textoAntes = texto.substring(0, area.getSelectionStart());
                String textoDepois = texto.substring(area.getSelectionEnd(), texto.length());

                StyleConstants.setBold(style, false);
                document.insertString(document.getLength(), textoAntes, style);

                StyleConstants.setBold(style, true);
                document.insertString(document.getLength(), area.getSelectedText(), style);

                StyleConstants.setBold(style, false);
                document.insertString(document.getLength(), textoDepois, style);

                System.out.println("Texto todo: " + texto);
                System.out.println("Texto antes: " + textoAntes);
                System.out.println("Texto d: " + textoAntes);
                System.out.println("Texto selecionado: " + area.getSelectedText());

                area.setDocument(document);
                }	
                }catch(BadLocationException ex){
                    ex.printStackTrace();
            }
        }});
        itemNegrito.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(area.getSelectedText());

            try{
                StyleContext context = new StyleContext();
                StyledDocument document = new DefaultStyledDocument(context);
                Style style = context.getStyle(StyleContext.DEFAULT_STYLE);

            if(area.getSelectedText() != null){
                String texto = area.getText();
                String textoAntes = texto.substring(0, area.getSelectionStart());
                String textoDepois = texto.substring(area.getSelectionEnd(), texto.length());

                StyleConstants.setBold(style, false);
                document.insertString(document.getLength(), textoAntes, style);

                StyleConstants.setBold(style, true);
                document.insertString(document.getLength(), area.getSelectedText(), style);

                StyleConstants.setBold(style, false);
                document.insertString(document.getLength(), textoDepois, style);

                System.out.println("Texto todo: " + texto);
                System.out.println("Texto antes: " + textoAntes);
                System.out.println("Texto d: " + textoAntes);
                System.out.println("Texto selecionado: " + area.getSelectedText());

                area.setDocument(document);
                }	
                }catch(BadLocationException ex){
                    ex.printStackTrace();
            }
        }});
               
    //BOTÃO ITÁLICO
        FButton botao9 = new FButton("botões/normalItalico.png", "botões/hoverItalico.png", "botões/pressItalico.png");
        panelTop.add(botao9);
        botao9.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(area.getSelectedText());

            try{
                StyleContext context = new StyleContext();
                StyledDocument document = new DefaultStyledDocument(context);
                Style style = context.getStyle(StyleContext.DEFAULT_STYLE);

            if(area.getSelectedText() != null){
                String texto = area.getText();
                String textoAntes = texto.substring(0, area.getSelectionStart());
                String textoDepois = texto.substring(area.getSelectionEnd(), texto.length());

                StyleConstants.setItalic(style, false);
                document.insertString(document.getLength(), textoAntes, style);

                StyleConstants.setItalic(style, true);
                document.insertString(document.getLength(), area.getSelectedText(), style);

                StyleConstants.setItalic(style, false);
                document.insertString(document.getLength(), textoDepois, style);

                System.out.println("Texto todo: " + texto);
                System.out.println("Texto antes: " + textoAntes);
                System.out.println("Texto d: " + textoAntes);
                System.out.println("Texto selecionado: " + area.getSelectedText());

                area.setDocument(document);
                }	
                }catch(BadLocationException ex){
                    ex.printStackTrace();
            }
        }});
        itemItalico.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(area.getSelectedText());

            try{
                StyleContext context = new StyleContext();
                StyledDocument document = new DefaultStyledDocument(context);
                Style style = context.getStyle(StyleContext.DEFAULT_STYLE);

            if(area.getSelectedText() != null){
                String texto = area.getText();
                String textoAntes = texto.substring(0, area.getSelectionStart());
                String textoDepois = texto.substring(area.getSelectionEnd(), texto.length());

                StyleConstants.setItalic(style, false);
                document.insertString(document.getLength(), textoAntes, style);

                StyleConstants.setItalic(style, true);
                document.insertString(document.getLength(), area.getSelectedText(), style);

                StyleConstants.setItalic(style, false);
                document.insertString(document.getLength(), textoDepois, style);

                System.out.println("Texto todo: " + texto);
                System.out.println("Texto antes: " + textoAntes);
                System.out.println("Texto d: " + textoAntes);
                System.out.println("Texto selecionado: " + area.getSelectedText());

                area.setDocument(document);
                }	
                }catch(BadLocationException ex){
                    ex.printStackTrace();
            }
        }});
        
    //BOTÃO SUBLINHADO    
        FButton botao10 = new FButton("botões/normalSublinhado.png", "botões/hoverSublinhado.png", "botões/pressSublinhado.png");
        panelTop.add(botao10);
        botao10.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            /*
            Font font = new Font(null, 0, 15);
            Map attributte = font.getAttributes();
            attributte.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            area.setFont(font.deriveFont(attributte));
            */
            System.out.println(area.getSelectedText());

            try{
                StyleContext context = new StyleContext();
                StyledDocument document = new DefaultStyledDocument(context);
                Style style = context.getStyle(StyleContext.DEFAULT_STYLE);

            if(area.getSelectedText() != null){
                String texto = area.getText();
                String textoAntes = texto.substring(0, area.getSelectionStart());
                String textoDepois = texto.substring(area.getSelectionEnd(), texto.length());

                StyleConstants.setUnderline(style, false);
                document.insertString(document.getLength(), textoAntes, style);

                StyleConstants.setUnderline(style, true);
                document.insertString(document.getLength(), area.getSelectedText(), style);

                StyleConstants.setUnderline(style, false);
                document.insertString(document.getLength(), textoDepois, style);

                System.out.println("Texto todo: " + texto);
                System.out.println("Texto antes: " + textoAntes);
                System.out.println("Texto d: " + textoAntes);
                System.out.println("Texto selecionado: " + area.getSelectedText());

                area.setDocument(document);
                }	
                }catch(BadLocationException ex){
                    ex.printStackTrace();
            }
        }});
        itemSublinhado.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println(area.getSelectedText());

            try{
                StyleContext context = new StyleContext();
                StyledDocument document = new DefaultStyledDocument(context);
                Style style = context.getStyle(StyleContext.DEFAULT_STYLE);

            if(area.getSelectedText() != null){
                String texto = area.getText();
                String textoAntes = texto.substring(0, area.getSelectionStart());
                String textoDepois = texto.substring(area.getSelectionEnd(), texto.length());

                StyleConstants.setUnderline(style, false);
                document.insertString(document.getLength(), textoAntes, style);

                StyleConstants.setUnderline(style, true);
                document.insertString(document.getLength(), area.getSelectedText(), style);

                StyleConstants.setUnderline(style, false);
                document.insertString(document.getLength(), textoDepois, style);

                System.out.println("Texto todo: " + texto);
                System.out.println("Texto antes: " + textoAntes);
                System.out.println("Texto d: " + textoAntes);
                System.out.println("Texto selecionado: " + area.getSelectedText());

                area.setDocument(document);
                }	
                }catch(BadLocationException ex){
                    ex.printStackTrace();
            }
        }});
        
    //ITEM AUTORES    
        itemAutores.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "Bruno Felix\nEmerson Lemos\nJoão Marcus\nRayemille Martins", "Autores", JOptionPane.INFORMATION_MESSAGE);
        }});
        
    //TECLADO VIRTUAL    
        FButton botao11 = new FButton("botões/pressTeclado.png", "botões/hoverTeclado.png", "botões/normalTeclado.png");
        panelTop.add(botao11);
        botao11.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            teclado.getTecladoVirtual();
        }});
        
    //JAVA DOC    
        itemJavaDoc.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JavaDoc javadoc = new JavaDoc();
            javadoc.getJavaDoc();
        }});
               
    //ITEM SAIR      
        itemSair.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int r = JOptionPane.showConfirmDialog(null, "Salvar conteúdo?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION);
            if(r == JOptionPane.YES_OPTION){
                    SalvarArquivo salvar = new SalvarArquivo();
                try {
                    salvar.salvarTexto(area.getText());
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(r == JOptionPane.NO_OPTION){
                System.exit(1);
            }
            if(r == JOptionPane.CANCEL_OPTION){
                return;
            }
            
        }});

        panelBottom.setLayout(new BorderLayout());
        panelBottom.add(scroll, BorderLayout.CENTER);

        frm1.setUndecorated(true);
        frm1.getRootPane().setWindowDecorationStyle(JRootPane.FRAME); //Altera a janela do Windows
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm1.setVisible(true);
        
    }
	
}
