package com.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Service
public class FileUploadServiceImp implements FileUploadService {


    //Get Server's real path for file location
    @Override
    public String getServerUploadPath() {
        Path basePath = Paths.get("./").toAbsolutePath().normalize();
        System.out.println("basePath:"+basePath);
        String serverUploadPath  = basePath+"\\src\\main\\resources\\uploadfileBox\\";
        System.out.println("serverUploadPath:"+serverUploadPath);
        return serverUploadPath;
    }

    //Save Files From  Web page to Disk C:/test/
    @Override
    public void saveUploadedFiles(MultipartFile file, HttpServletRequest httpRequest) throws IOException, ServletException {

        InputStream initialStream = file.getInputStream();

        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        //Save in Disk
        File targetFile = new File("C://WebUploadTest//"+file.getOriginalFilename());
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.close();

        //Save in Server
        //Get Real Path First
        Part part = httpRequest.getPart("file");//Form's input name
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        System.out.println("fileName:"+fileName);


        InputStream fileContent = part.getInputStream();

        String serverUploadPath = getServerUploadPath();

        //Save in the real path of the server
        File targetFile2 = new File(serverUploadPath+file.getOriginalFilename());
        OutputStream outStream2 = new FileOutputStream(targetFile2);
        outStream2.write(buffer);
        outStream2.close();


        //Save in DB?  Save as BLOB?
    }

    //Zip one file
    //https://www.baeldung.com/java-compress-and-uncompress
    @Override
    public void zipSingleFile(MultipartFile file, HttpServletRequest httpRequest) throws IOException, ServletException {
        String targetFileName = file.getOriginalFilename()+".zip";

        String serverUploadPath = getServerUploadPath();

        FileOutputStream fos = new FileOutputStream(serverUploadPath+targetFileName);
        ZipOutputStream zos = new ZipOutputStream(fos);

        zos.putNextEntry(new ZipEntry(file.getOriginalFilename()));

        InputStream in = file.getInputStream();
        byte[] bytes = new byte[in.available()];
        in.read(bytes);

        zos.write(bytes,0,bytes.length);
        zos.closeEntry();
        zos.close();
    }

    //Save Files From  Web page to Server /uploadFiles/
    @Override
    public void downloadTextFile(HttpServletResponse response) throws IOException {

        System.out.println("downloadTextFile: Start......");

        //Define file name with date and time
        String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        //define response OutputStream
        //https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Headers/Content-Disposition

//        response.setHeader("Content-Disposition", "attachment; filename=myfile"+timeLog+".txt");//Download file with specific name
//        response.setHeader("Content-Disposition", "inline; filename=myfile"+timeLog+".txt");//open in browser/mouse right save as a file
//        response.setHeader("Content-Disposition", "form-data; filename="+timeLog+".txt");//Download file with specific name
//        response.setHeader("Content-Disposition", "attachment");//Download file with No specific name


        response.setContentType("text/plain");
        OutputStream outStream = response.getOutputStream();

//        byte[] buf = new byte[4096];
        byte[] buf = new byte[1024];//Change buffer to 1024 bytes ( 1 KB)
        int len = -1;

        //Define file content
        String textContent ="This is my test \nWow wow Wow   \nWonderful Life Very Good for your healthy!!!";

        //Convert file content to InputStream
        InputStream inputStream = new ByteArrayInputStream(textContent.getBytes(StandardCharsets.UTF_8));

        //Write the file contents to the servlet response
        //Using a buffer of 4kb (configurable). This can be
        //optimized based on web server and app server
        //properties

        while ((len = inputStream.read(buf)) != -1) {
            outStream.write(buf, 0, len);
        }

        outStream.flush();
        outStream.close();

        System.out.println("downloadTextFile: End......");

    }


    //Make a text file in the project folder if not specify
    @Override
    public void makeTextFile(){
        BufferedWriter writer = null;
        try {
            //create a temporary file
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            File logFile = new File(timeLog+".txt");
            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("Hello world!");

            //Download location example:
            //C:\Users\OOOOOOOOO\IdeaProjects\springboot004\20200706_194433

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //JAVA 7 up to make a text file
        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("the-file-name-java7.txt");
        try{
            Files.write(file, lines, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        //End
    }

    //How To Read a static file on the server
    @Override
    public void readStaticFile() throws IOException {

        // ...../src/main/resources/..
        String filePath = "/uploadfileBox/readme.txt";

        InputStream is = this.getClass().getResourceAsStream(filePath);

        //To get real path
        URL url = getClass().getResource(filePath);

        System.out.println("readFile() Real Path: "+url.getPath());

        BufferedReader bufReader = new BufferedReader(new InputStreamReader(is));

        String strCurrentLine;

        System.out.println("readFile() --------Read file content : Start--------");
        while ((strCurrentLine=bufReader.readLine()) != null) {
            System.out.println(strCurrentLine);
        }
        System.out.println("readFile() --------Read file content : End--------");

    }

    @Override
    public void getFilesList(){
        //Get File list -------- Start
        String fileFolderName = "/uploadfileBox/";
        URL url2 = getClass().getResource(fileFolderName);

        System.out.println("readFile() Real Path2: "+url2.getPath());

        Set<String> setStr = listFilesUsingJavaIO(url2.getPath());
        System.out.println(setStr);

        //Java 8 iterate set object
        setStr.forEach(System.out::println);

        //Get File list -------- End
    }

    public Set<String> listFilesUsingJavaIO(String fileDir) {
        return Stream.of(new File(fileDir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}
