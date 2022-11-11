package proiectPPOO;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.attribute.FileAttribute;
import java.util.Optional;

public class FileObject extends File implements Serializable {

	public FileObject(String pathname) {
		super(pathname);
	}

	
	public Optional<String> getExtensionByStringHandling() {
	    return Optional.ofNullable(this.getName())
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(this.getName().lastIndexOf(".") + 1));
	}


	@Override
	public boolean createNewFile() throws IOException {
		System.out.println("Creating new file...");
		// TODO Auto-generated method stub
		return super.createNewFile();
	}
	
	

}
