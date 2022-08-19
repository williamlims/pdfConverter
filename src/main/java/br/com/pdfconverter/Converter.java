package br.com.pdfconverter;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author TECHSTUDIO
 */
public class Converter extends Thread {
    
    String nome;
    JFileChooser file = new JFileChooser();
    JProgressBar barProgresso;
    
    public Converter(){
        
    }
    
    @Override
    public void run() {
        nome = nome.substring(0, nome.length() - 4);
        
        String word = file.getSelectedFile().getAbsolutePath().replace("/", "\\");
        String username = System.getProperty("user.name");
        ConvertToPDF(word, "C:\\Users\\"+username+"\\Desktop\\"+nome+".pdf");
               
        
    }
    
    public void ConvertToPDF(String docPath, String pdfPath){
        try {
            InputStream doc = new FileInputStream(new File(docPath));
            XWPFDocument document = new XWPFDocument(doc);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(pdfPath));
            PdfConverter.getInstance().convert(document, out, options);
        } catch (IOException ex) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Ouve um erro ao executar a ação: " +ex);
        }
    }
    
    public void OpenFile(JTextField txtNomeArquivo){
        int testVal = file.showOpenDialog(file);
        if(testVal ==  JFileChooser.APPROVE_OPTION){
            txtNomeArquivo.setText(file.getSelectedFile().getAbsolutePath());
            nome = file.getSelectedFile().getName();   
        }
    }
}
