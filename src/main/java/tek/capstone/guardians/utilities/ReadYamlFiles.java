package tek.capstone.guardians.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {

	
	private static ReadYamlFiles readYamlFiles;
	private HashMap propertyType;
	
//constructor: we create to load our yml file	
	private ReadYamlFiles(String filepath)throws
	FileNotFoundException{
		FileInputStream fileInputStream =
				FileUtility.getFileInputStream(filepath);
        Yaml yaml = new Yaml();
        propertyType = yaml.load(fileInputStream);
    }
    
//this methos will return an instance of ReadYmlFiles class
    public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
        if ( readYamlFiles == null)
        	return new ReadYamlFiles(filePath);
        return readYamlFiles;
    }
    
    public HashMap getYamlProperty(String key) {
        return (HashMap)propertyType.get(key);
    }			
		
	}

