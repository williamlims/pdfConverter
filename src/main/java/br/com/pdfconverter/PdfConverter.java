package br.com.pdfconverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

public class PdfConverter {
    
    final JFileChooser fileup = new JFileChooser();
    File file;
    
    public void uploadFile() throws FileNotFoundException, IOException {       
        int value = fileup.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            file = fileup.getSelectedFile();
        }
    }
}
