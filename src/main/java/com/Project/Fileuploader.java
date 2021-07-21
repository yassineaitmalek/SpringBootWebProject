package com.Project;



import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.websocket.Session;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.commons.io.FilenameUtils;

@Service
public class Fileuploader {
	
	public String uploadfile(MultipartFile file,String folder_path,String file_name) throws IllegalStateException, IOException {

		String ext = getExtention(file.getOriginalFilename());
		
		
		
		if(! (ext.equalsIgnoreCase("pdf") ||  ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg") ) ) {
			return "";
		}
	
		
		else {
			
			file.transferTo(new File(folder_path+file_name+'.'+ext));
			file_name = file_name+'.'+ext;
			
			return file_name.toLowerCase();
		}
		
	}
	
	public boolean createfolder(String folder_path) {
		File d = new File(folder_path);
		boolean dir = d.mkdir();
					
		return dir;
	}
	
	public  boolean deletefolder(String folder_path) {
		File file = new File(folder_path);
	    File[] flist = null;

	    if(file == null){
	        return false;
	    }

	    if (file.isFile()) {
	        return file.delete();
	    }

	    if (!file.isDirectory()) {
	        return false;
	    }

	    flist = file.listFiles();
	    if (flist != null && flist.length > 0) {
	        for (File f : flist) {
	            if (!deletefolder(f.getAbsolutePath())) {
	                return false;
	            }
	        }
	    }

	    return file.delete();
	}
	
	public String getFileNameWithoutExtension(String file_name) {
        String fileName = "";
 
        try {
         
               
                fileName = file_name.replaceFirst("[.][^.]+$", "");
           
        } catch (Exception e) {
            e.printStackTrace();
            fileName = "";
        }
 
        return fileName;
 
    }
	
	public String getExtention(String file_name) {
		
		String ext = Optional.of(file_name)
							.filter(f -> f.contains("."))
							.map(f -> f.substring(file_name.lastIndexOf(".") + 1))
							.orElse("");
		
		return ext.toLowerCase();
	}
	
	public boolean renamefile(String folder_path,String old_filename,String new_filename) {
		File file = new File(folder_path+old_filename);
		File rename = new File(folder_path+new_filename);
		boolean flag = file.renameTo(rename);
		
		return flag;
	}
}
