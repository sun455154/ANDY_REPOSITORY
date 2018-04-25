package org.andyjian.util.fileutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class FileUtil.
 */
public class FileUtil {

	/**
	 * Turn csv file to str arr.
	 *
	 * @param csv檔案
	 * @param 分隔符號
	 * @return the list
	 */
	public static List<String[]> turnCsvFileToStrArr(File file, String seperate) {
		List<String[]> resultList = new ArrayList<>();
		if (file.exists()) {
			try(BufferedReader br = new BufferedReader(new FileReader(file));){
				String line = "";
				while ((line = br.readLine()) != null) {
					String[] lineContent = line.split(seperate);
					resultList.add(lineContent);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File is not found!");
		}
		return resultList;
	}
	
	
	/**
	 * 取出根目錄下所有的檔案.
	 *
	 * @param 根目錄
	 * @return 所有檔案
	 */
	public static List<File> recursiveFileToList(File file) {
		List<File> result = new ArrayList<>();
		for (File subFile : file.listFiles()) {
			if (subFile.isDirectory()) {
				result.addAll(recursiveFileToList(subFile));
			} else {
				result.add(subFile);
			}
		}
		return result;
	}
	
}
