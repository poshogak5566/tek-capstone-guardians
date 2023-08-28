package tek.capstone.guardians.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtility {
	
//this method will return an instance of FileInputStream class	
	public static FileInputStream
	getFileInputStream(String filePath)throws FileNotFoundException{
		return new FileInputStream(new File(filePath));
	}
// fileinputstream class helps to read sequential data from a source

	// file input stream is used to get data from the file
}
