/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabFileLib;

import java.io.IOException;

/**
 *
 * @author fabruz
 */
public class fabIO {
    /**
     *stringArray as the array to write in the folder with the filename NB: don't put extension
     * @param stringArray the array to write as binary data 
     * @param folder to write to
     * @param filename the name of your file in that folder whether new or existing 
     * @throws java.io.FileNotFoundException */
    public void writeArray_toDat(String[] stringArray, String folder, String filename) 
            throws java.io.FileNotFoundException, java.io.IOException{
        
        java.io.FileOutputStream file = new java.io.FileOutputStream(folder + filename + ".dat");
        try (java.io.ObjectOutputStream output = new java.io.ObjectOutputStream(file)) {
                output.writeObject(stringArray); 
        }
    }
    
    /**
     *stringArray as the array to write in the folder with the filename NB: don't put extension
     * @param string the string to write as binary data 
     * @param folder to write to
     * @param filename the name of your file in that folder whether new or existing 
     * @throws java.io.FileNotFoundException */
    public void writeString_toDat(String string, String folder, String filename) 
            throws java.io.FileNotFoundException, java.io.IOException{
        
        java.io.FileOutputStream file = new java.io.FileOutputStream(folder + filename + ".dat");
        try (java.io.ObjectOutputStream output = new java.io.ObjectOutputStream(file)) {
                output.writeUTF(string); 
        }
    }
    
    /**
     *updating a binary containing already an array to write in the folder with the filename NB: don't put extension
     * @param anArray the second array to update in binary data
     * @param folder to write to
     * @param filename the name of your file in that folder whether new or existing 
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException */
    public void updateArray_toDat(String[] anArray, String folder, String filename) 
            throws java.io.FileNotFoundException, java.io.IOException, ClassNotFoundException{
        
        java.io.FileInputStream file0 = new java.io.FileInputStream(folder + filename + ".dat");
        java.io.FileOutputStream file1 = new java.io.FileOutputStream(folder + filename + ".dat");
        
        Object[] firstIn;
        
        try (
                java.io.ObjectInputStream input = new java.io.ObjectInputStream(file0);
                java.io.ObjectOutputStream output = new java.io.ObjectOutputStream(file1)) {
            
            firstIn = (Object[]) input.readObject();
            output.writeObject(add2array(firstIn, anArray)); 
        }
    }
    
    
    /**
     *read an object array from the folder with the filename NB: don't put extension
     * @param folder to write to
     * @param filename the name of your file in that folder whether new or existing 
     * @return Object array
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException */
    public Object[] readDat_asArray(String folder, String filename) 
            throws java.io.FileNotFoundException, java.io.IOException, ClassNotFoundException{
        
        java.io.FileInputStream file = new java.io.FileInputStream(folder + filename + ".dat");
        Object[] list;
        try (java.io.ObjectInputStream input = new java.io.ObjectInputStream(file)) 
        {
            list = (Object[]) input.readObject();
        }
        return list;
    }
    
    /**
     *read an object array from the folder with the filename NB: don't put extension
     * @param folder to write to
     * @param filename the name of your file in that folder whether new or existing 
     * @return String 
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException */
    public String readDat_asString(String folder, String filename) 
            throws java.io.FileNotFoundException, java.io.IOException, ClassNotFoundException{
        
        java.io.FileInputStream file = new java.io.FileInputStream(folder + filename + ".dat");
        String thingObject;
        try (java.io.ObjectInputStream input = new java.io.ObjectInputStream(file)) 
        {
            thingObject = input.readUTF();
        }
        return thingObject;
    }
    
    /**
     *read a string from a text file in a folder with the filename NB: don't put extension
     * @param folder to read from 
     * @param filename the name of your file in that folder 
     * @return  a string representation of the text file content 
     * @throws java.lang.Exception */
    public String readTxt_asString(String folder, String filename) throws Exception{
        java.io.File file2read = new java.io.File(folder + filename + ".txt");
        StringBuilder sbContent = new StringBuilder();
        
        try (java.io.BufferedReader reader = 
                new java.io.BufferedReader(new java.io.FileReader(file2read)); )
        {
            String line = reader.readLine();
            while (line != null) {
                sbContent.append(line).append('|');
                line = reader.readLine() ;
            }
        }
        return stringWithLines(sbContent.toString()); 
    }
    
    /**
     * Read a string from a file
     * @param file to read from 
     * @return  a string representation of the file content 
     * @throws java.lang.Exception */
    public String readFile_asString(java.io.File file) throws Exception{
        StringBuilder sbContent = new StringBuilder();
        
        try (java.io.BufferedReader reader = 
                new java.io.BufferedReader(new java.io.FileReader(file)); )
        {
            String line = reader.readLine();
            while (line != null) {
                sbContent.append(line).append('|');
                line = reader.readLine() ;
            }
        }
        return stringWithLines(sbContent.toString()); 
    }
    
    /**
     *read a text file as string array from a folder with the filename NB: don't put extension
     * @param folder to read from
     * @param filename the name of your file in that folder
     * @return a string array of the text file content each line gets an index 
     * @throws java.lang.Exception */
    public String[] readTxt_asArray(String folder, String filename) throws Exception{
        java.io.File file2read = new java.io.File(folder + filename + ".txt");
        StringBuilder sbContent = new StringBuilder();
        
        try (java.io.BufferedReader reader = 
                new java.io.BufferedReader(new java.io.FileReader(file2read)); )
        {
            String line = reader.readLine();
            while (line != null) {
                sbContent.append(line).append('|');
                line = reader.readLine();
            }
        }
        return sbContent.toString().split("[|]"); 
    }
    
    
    /**
     * Read a text from file as string array 
     * @param file to read from
     * @return a string array of the file content each line gets an index 
     * @throws java.lang.Exception */
    public String[] readFile_asArray(java.io.File file) throws Exception{
        StringBuilder sbContent = new StringBuilder();
        
        try (java.io.BufferedReader reader = 
                new java.io.BufferedReader(new java.io.FileReader(file)); )
        {
            String line = reader.readLine();
            while (line != null) {
                sbContent.append(line).append('|');
                line = reader.readLine();
            }
        }
        return sbContent.toString().split("[|]"); 
    }
    

    /**
     * Writing the content of an array to the text file in the folder 
     * @param anArray
     * @param folder
     * @param filename 
     * @throws java.io.IOException
     */

    public void writeToTxt(String[] anArray, String folder, String filename) throws IOException{
        java.io.File file2write = new java.io.File(folder + filename + ".txt");
        
        try (java.io.BufferedWriter writer = 
                new java.io.BufferedWriter(new java.io.FileWriter(file2write)); )
        {
            writer.write(textListed(anArray)); 
        }
    }
    
    /**
     * Writing the string to the text file in the folder 
     * @param string
     * @param folder
     * @param filename 
     * @throws java.io.IOException
     */
    public void writeToTxt(String string, String folder, String filename) throws IOException{
        java.io.File file2write = new java.io.File(folder + filename + ".txt");
        
        try (java.io.BufferedWriter writer = 
                new java.io.BufferedWriter(new java.io.FileWriter(file2write)); )
        {
            writer.write(string); 
        }
    }
    
    private static String stringWithLines(String string){
        String[] items = string.split("[|]");
        StringBuilder sbOut = new StringBuilder();
        for (String item: items)
            sbOut.append(item).append(System.lineSeparator());
        
        return sbOut.toString();
    }
    
    private static String textListed(String[] strings){
        StringBuilder sbOut = new StringBuilder();
        for (String item: strings)
            sbOut.append(item).append(System.lineSeparator());
        
        return sbOut.toString();
    }
    
    private static Object[] add2array(Object[] x, Object[] y){
        //  Taking-in 2 arrays of strings and returning 1 array.
        //  the array is the addition of the two.
        int a = x.length;  int b = y.length;
        int tot = a + b;
        Object[] total = new Object[tot];
        System.arraycopy(x, 0, total, 0, a);
        System.arraycopy(y, 0, total, a, b);

        return total;
    }
    
    
}
