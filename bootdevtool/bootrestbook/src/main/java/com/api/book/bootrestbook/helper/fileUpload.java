package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;;

@Component
public class fileUpload {
    public final String ss = new ClassPathResource("static/image").getFile().getAbsolutePath();
    public fileUpload()throws IOException{

    }
    public String createFile(MultipartFile file){

        // File fdest = new File("/Users/mdafr/java/bootdevtool/bootrestbook/src/main/resources/templates/image/photo.png");
            // String ss="/Users/mdafr/java/bootdevtool/bootrestbook/src/main/resources/templates/image/";
        InputStream fis = null;
        FileOutputStream fos = null;

        try{
            // System.out.println("int try...............");
            // fis =  file.getInputStream();
            // byte data[] = new byte[fis.available()];
            // fis.read(data);
            // fos = new FileOutputStream(fdest);
            // fos.write(data);

            Files.copy(file.getInputStream(),Paths.get(ss,file.getOriginalFilename()));
        }
        catch(IOException e){

           System.out.println("error");

        }
        
        return "created file";

    }
}
