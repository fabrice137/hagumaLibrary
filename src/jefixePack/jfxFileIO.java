/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jefixePack;

import fabFileLib.fabIO;
import javafx.stage.FileChooser;


public class jfxFileIO {

    /**
     * @return the System's default directory folder as a string
     */
    public String defaultDirectory(){
        return javax.swing.filechooser.FileSystemView.
                getFileSystemView().getDefaultDirectory().getParent();
    }
    
    /**
     * Pass in a a path and get an array of folders in a directory 
     * @param fullPath
     * @return an array of folders in a directory 
     */
    public java.io.File[] listFolders(String fullPath){
        return new java.io.File(fullPath).listFiles(java.io.File::isDirectory);
    }
    
    /**
     * Pass in a a path and get an array of files in a directory 
     * @param fullPath
     * @return an array of files in a directory 
     */
    public java.io.File[] listFiles(String fullPath){
        return new java.io.File(fullPath).listFiles();
    }
    
    /**
     * To find the default folder in AppData Local folder
     * @return the jeFixe's default directory folder as a string
     */
    public String jefixeDefaultDirectory(){
        String systemDefaultDir = javax.swing.filechooser.FileSystemView.
                getFileSystemView().getDefaultDirectory().getParent();
        return systemDefaultDir.concat("\\AppData\\Local\\JeFixeApps");
    }
    
    /**
     * Pass in a string of a path to create a Directory there
     * @param fullPath
     * @throws java.io.IOException
     */
    public void createDirectory(String fullPath) throws java.io.IOException{
        java.nio.file.Files.createDirectories(java.nio.file.Paths.get(fullPath));
    }
    
}
