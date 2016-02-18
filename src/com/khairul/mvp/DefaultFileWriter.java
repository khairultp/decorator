package com.khairul.mvp;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DefaultFileWriter implements Default {

	@Override
	public void write(String paths, String contents) throws Exception {
		Files.write(Paths.get(paths), contents.getBytes(Charset.defaultCharset()));
	}

}
