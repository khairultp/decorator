package com.khairul.mvp;

public class NoNullFileWriter implements Default{

	private Default defaultFileWriter;
	
	public NoNullFileWriter(Default defaultFileWriter){
		this.defaultFileWriter = defaultFileWriter;
	}
	
	@Override
	public void write(String paths, String contents) throws Exception {
		failIfEmptyContents(contents);
		defaultFileWriter.write(paths, contents);
	}

	private void failIfEmptyContents(String contents) throws Exception {
		if(isEmpty(contents)) throw new Exception("Nothing to write");
	}

	private boolean isEmpty(String contents) {
		return contents == null || contents.trim().length() == 0;
	}

}
