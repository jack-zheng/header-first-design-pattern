package chapter03.iosamples;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class Test {
	public static void main(String[] args) throws Exception {
		for (byte b : "中文".getBytes()) {
			System.out.print((char)b);
		}

		String filename =  "/data.txt";
		inputStreamPrint(filename);

		inputStreamPrintWithBuffer(filename);

		readerPrint(filename);
	}

	static void inputStreamPrint(String filename) throws Exception {
		FileInputStream fis = new FileInputStream(Test.class.getResource(filename).getFile());
		System.out.println("---- start stream print");
		int content;
		while ((content = fis.read()) != -1) {
			// convert to char and display it
			System.out.print((char) content);
		}

		System.out.println("---- end stream print");
	}

	static void inputStreamPrintWithBuffer(String filename) throws Exception {
		FileInputStream fis = new FileInputStream(Test.class.getResource(filename).getFile());
		System.out.println("---- start stream print with buff");
		byte[] buff = new byte[2];
		int content;
		while ((content = fis.read(buff)) != -1) {
			// convert to char and display it
			System.out.print(new String(buff, 0, content));
		}

		System.out.println("---- end stream print with buff");
	}

	static void readerPrint(String filename) throws Exception {
		System.out.println("---- start reader print");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(Test.class.getResource(filename).getFile()));
		String line;
		while ( (line=bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

		System.out.println("---- end reader print");
	}
}
