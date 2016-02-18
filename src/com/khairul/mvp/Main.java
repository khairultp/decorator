package com.khairul.mvp;

public class Main {

	public static void main(String[] args) {
		Default fileWriter = new NoOverwriteFileWriter(
								new NoNullFileWriter(
									new DefaultFileWriter()
								)
							);
		
		String paths = "/Volumes/caddy/workspace/mars/DecoratorPattern/resources/";
		String contents = "Insert Data - 1";
		
		try {
			fileWriter.write(paths + "data.txt", contents);
			fileWriter.write(paths, contents);
			fileWriter.write(paths + "data2.txt", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
