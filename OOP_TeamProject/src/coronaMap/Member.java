package coronaMap;

import java.io.*;

import java.time.LocalTime;
import java.util.*;
import java.util.Map.Entry;

import manager.*;

public class Member {
	public HashMap<String, String> pathByDate = new HashMap<>();
	public String name;
	
	public Member(String userID) {
		name = userID;
	}

	public void readFile(String fileName) {
		Scanner scanFile = openFile(fileName);
		
		while (scanFile.hasNext()) {
			String tmpDate = null;
			String tmpPath = null;
			
			tmpDate = scanFile.next();
			tmpPath = (scanFile.nextLine()).trim();
			
			pathByDate.put(tmpDate, tmpPath);		
		}
		scanFile.close();
	}
	
	private Scanner openFile(String fileName) {
		Scanner scanFile = null;

		try {
			scanFile = new Scanner(new File(fileName));
		} catch (IOException e) {
			System.out.println("Fail! scanFile " + fileName);
			System.exit(0);
		}
		return scanFile;
	}
	
	public HashMap<String, String> getPathByDate(String key) {
		
		for (Entry<String, String> entry: pathByDate.entrySet()) {
			if (entry.getKey().contentEquals(key)) {
				return pathByDate;
			}
		}
		return null;
	}
}
