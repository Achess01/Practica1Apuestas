/*
 * Welcome
 */
package com.achess.practica1apuestas.file;

import com.achess.practica1apuestas.betsLogic.Bets;
import com.achess.practica1apuestas.betsLogic.linkedList.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author achess
 */
public class FileManagment {
    
    private static String pattern = "\\w+,[1-9]\\d*(,(10|[1-9])){10}";
    
    public static boolean open(){
        boolean withErrors = true;
        JFileChooser upload = new JFileChooser();
        String extensions[] = {"txt", "csv"};
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Apuestas",extensions);
        upload.setFileFilter(filtro);
        upload.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        upload.showOpenDialog(null);        
        FileReader fr = null;
        try{
            File file = upload.getSelectedFile();
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);                            
            String line;
            while((line = br.readLine()) != null){                
                if(line.matches(pattern)) addBet(line);
            }
        }
        catch (Exception ex){
              ex.printStackTrace(System.out);
              withErrors = false;
        }
        finally{
            try{
                if(fr!=null){
                fr.close();
                }
            }catch(Exception ex){
                ex.printStackTrace(System.out);
                withErrors = false;
            }                
        }
        return withErrors;
    }
    
    
    public static boolean selectDirectory(List rejected){                
        JFileChooser save = new JFileChooser();        
        save.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);    
        save.showSaveDialog(null);
        return save(save, rejected);
    }
    
    private static boolean save(JFileChooser save, List rejected){
        boolean saved = false;                                             
        FileWriter fw = null;                    
        try{
            File file = save.getSelectedFile();
            if(!file.exists()){
                String csvFromList = rejected.getCsv();
                PrintWriter pw = new PrintWriter(file.getPath() + ".csv");
                pw.print(csvFromList); 
                pw.close();
                saved = true;
            }
            else{
                //JOptionPane.showConfirmDialog(null, "El archivo ya existe");
                saved = false;
            }
        }catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
            saved = false;
        }
        finally{
            try{
                if(fw!=null){
                fw.close();
                }
            }catch(Exception ex){
                saved = false;
            }                
        }
        return saved;
    }
    
    private static void addBet(String line){
        String values[] = line.split(",");
        int amount = Integer.parseInt(values[1]);
        int c1 = Integer.parseInt(values[2]);
        int c2 = Integer.parseInt(values[3]);
        int c3 = Integer.parseInt(values[4]);
        int c4 = Integer.parseInt(values[5]);
        int c5 = Integer.parseInt(values[6]);
        int c6 = Integer.parseInt(values[7]);
        int c7 = Integer.parseInt(values[8]);
        int c8 = Integer.parseInt(values[9]);
        int c9 = Integer.parseInt(values[10]);
        int c10 = Integer.parseInt(values[11]);
        int positions[] = {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
        Bets.getBets().addNoVerified(values[0], amount, positions);        
    }
}
