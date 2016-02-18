package com.khairul.mvp;

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class DefaultTest {

	@Test
	public void write_GiveValidPathWithContents_SuccessCreateFileWithContents() {
		
		//Arrange
		String paths = "/Volumes/caddy/workspace/mars/DecoratorPattern/resources/GiveValidPathWithContents.txt";
		String contents = "Insert Data - 1";
		Default fileWriter = new NoOverwriteFileWriter(
								new NoNullFileWriter(
									new DefaultFileWriter()
								)
							);
		boolean isCreated = false;
		
		try {
			//Clean up
			Files.deleteIfExists(Paths.get(paths));
			
			//Act
			fileWriter.write(paths, contents);
			isCreated = Files.exists(Paths.get(paths));
			
		} catch (Exception e) {
			
			fail("Not Expected exception here");
		}
		
		//Assert
		assertTrue(isCreated);

	}
	
	@Test
	public void write_GiveValidPathWithEmptyContents_ThrowException() {
		
		//Arrange
		String paths = "/Volumes/caddy/workspace/mars/DecoratorPattern/resources/GiveValidPathWithEmptyContents.txt";
		String contents = "";
		Default fileWriter = new NoOverwriteFileWriter(
								new NoNullFileWriter(
									new DefaultFileWriter()
								)
							);

		try {
			//Clean up
			Files.deleteIfExists(Paths.get(paths));
			
			//Act
			fileWriter.write(paths, contents);
			
			fail("Expected exception is not occured");
			
		} catch (Exception e) {

			boolean isCreated = Files.exists(Paths.get(paths));
			
			//Assert
			assertFalse(isCreated);
			assertTrue(true);
		}
		
	}
	
	@Test
	public void write_GiveExistingFile_ThrowException() {
		
		//Arrange
		String paths = "/Volumes/caddy/workspace/mars/DecoratorPattern/resources/GiveExistingFile.txt";
		String contents = "";
		Default fileWriter = new NoOverwriteFileWriter(
								new NoNullFileWriter(
									new DefaultFileWriter()
								)
							);

		try {
			//Clean up
			Files.deleteIfExists(Paths.get(paths));
			Files.createFile(Paths.get(paths));
			
			//Act
			fileWriter.write(paths, contents);
			
			//Assert
			fail("Expected exception is not occured");
			
		} catch (Exception e) {

			boolean isCreated = Files.exists(Paths.get(paths));
			
			//Assert
			assertTrue(isCreated);
			assertTrue(true);
		}
		
	}

}
