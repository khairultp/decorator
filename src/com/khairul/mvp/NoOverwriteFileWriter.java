package com.khairul.mvp;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoOverwriteFileWriter implements Default {

	private Default defaultFileWriter;
	
	public NoOverwriteFileWriter(Default defaultFileWriter){
		this.defaultFileWriter = defaultFileWriter;
	}
	
	@Override
	public void write(String paths, String contents) throws Exception {
		failIfFileExist(paths);
		defaultFileWriter.write(paths, contents);
	}

	private void failIfFileExist(String paths) throws Exception {
		if(isExists(paths)) throw new Exception("File already exists");
	}

	private boolean isExists(String paths) {
		return Files.exists(Paths.get(paths));
	}

}
