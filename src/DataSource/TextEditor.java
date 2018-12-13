package DataSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import Domain.Train;
import Domain.trainPart.*;

public class TextEditor {

	private String filePath = "txt/mySave.txt";
	private File f = new File(filePath);
	private File t = new File("txt/types.txt");

	private PrintWriter writer;
	
	public void delTrain(String code,File file) throws IOException {
		File tempFile = new File("txt/myTempFile.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
				if (items.get(0).trim().equals(code)) {
					continue;
				}
				writer.write(line);
				writer.write("\n");

			}

			br.close();
			writer.close();
			boolean b = file.delete();
			if (tempFile.renameTo(file)) {
			} else {
				System.out.println("faild");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


	public List findTrain(String code) throws FileNotFoundException, IOException {
		List train;

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
				if (items.get(0).trim().equalsIgnoreCase(code)) {
					return items;
				}
				System.out.println(items.get(0));
			}
		}
		System.out.println("not found");
		return null;

	}

	public void write(String yourText,File file) throws FileNotFoundException {
		if (file.exists() && !file.isDirectory()) {
			writer = new PrintWriter(new FileOutputStream(new File(file.getPath()), true));

		} else {
			writer = new PrintWriter(file.getPath());
		}

		writer.append(yourText);
		writer.close();

	}
	


	public String trainTotxt(Train t) {
		String spaceingChar = "\n";
		// test format to save train to.txt
		// the format is trainCode: type-type-type
		// spaceingChar ; is added in the end of the whole train
		String s = "";
		s += t.getCode();
		s += " ,";

		List parts = t.getPartsTypes();
		Iterator i = parts.iterator();
		String type;
		while (i.hasNext()) {
			TrainPart part = (TrainPart) i.next();
			type = part.getType();
			s += type + ",";

		}
		s = s.substring(0, s.length() - 1);
		s += spaceingChar;
		return s;
	}

	public List selectAlltypes() {
		String type;
		String zitPlaats;
		List allTypes = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(t))) {
			String line;
			while ((line = br.readLine()) != null) {
				List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
				type = items.get(0);
				zitPlaats = items.get(1);
				allTypes.add(type);
				allTypes.add(zitPlaats);


			}} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return allTypes;
		}
	
	
	public List selectAllcodes() {
		String trainCode;
		List allCodes = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
				trainCode = items.get(0);
				allCodes.add(trainCode);

			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allCodes;
	}
}
