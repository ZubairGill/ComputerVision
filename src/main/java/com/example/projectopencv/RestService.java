package com.example.projectopencv;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/myservice")
@ComponentScan("projectopencv")
@MultipartConfig(fileSizeThreshold = 20971520)
public class RestService {

	
	
	@RequestMapping(value="/service", method=RequestMethod.GET)
	public @ResponseBody ResponceModel jsonDisplay()
	{
		ResponceModel r=new ResponceModel("No Image ","Image Title");
		//r.getPath();
		return r;
	}
	
	
	
	/*@RequestMapping(value="/upload",method=RequestMethod.POST)
	public @ResponseBody String uploadFile(@RequestParam("uploadFile") MultipartFile uploadFileRef)
	{
		
		OpencvLoader.init();
		String imagepath=uploadFileRef.getOriginalFilename();
		String path="D:/"+imagepath;
		byte [] buffer=new byte[1000];
		
		File outputFile=new File(path);
		
		FileInputStream reader=null;
		FileOutputStream writer=null;
		int totalBytes=0;
		try{
			
		outputFile.createNewFile();	
		reader=(FileInputStream)uploadFileRef.getInputStream();
		writer=new FileOutputStream(outputFile);
		
		int bytesRead=0;
		
			while((bytesRead=reader.read(buffer))!=-1)
			{
				writer.write(buffer);
				totalBytes+=bytesRead;
			}
		
		System.out.println(imagepath);
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			reader.close();
			writer.close();
			}catch (Exception e2) {
			e2.printStackTrace();
			}
		}
		
		return "Image is uploaded";	
		
	}*/
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(
    		@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
    
    	OpencvLoader.init();
    	
    	//Mat input=Highgui.imread(file.getOriginalFilename());
  
    	//Imgproc.blur(input, input, new Size(5,5));
  
    	
    
    	
    	if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + file.getOriginalFilename() + "!";
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getOriginalFilename()+ " because the file was empty.";
        }
    }
	
	
	
}
