package tools;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

import org.junit.Test;

public class ThumbnailatorTest {
	
	@Test
	public void test(){
		try {
			String file="C:\\Users\\Administrator\\Desktop\\a.jpg";
			String toFile="C:\\Users\\Administrator\\Desktop\\b.jpg";
			Thumbnails.of(new File(file)).size(95, 95).toFile(toFile);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
}
