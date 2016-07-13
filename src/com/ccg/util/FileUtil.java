package com.ccg.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件操作工具类
 * @author		CCG
 * @version		1.0
 * Created		2016年6月27日 上午9:25:13
 */
public class FileUtil {

	/**
	 * 判断文件是否存在
	 * @author CCG 2016年6月27日
	 * @param filePath
	 * @return
	 */
	public static boolean isExist(String filePath){
		File file = null;
		boolean rt = false;
		try{
			file = new File(filePath);
			rt = file.exists();
		}catch(Exception e){
			e.printStackTrace();
			rt = false;
		}
		return rt;
	}
	
	/**
	 * 创建文件夹
	 * @author CCG 2016年6月27日
	 * @return
	 */
	public static File createDir(String dirPath){
		File dirFile = null;
		try{
			dirFile = new File(dirPath);
			//当前文件夹不存在，且是文件夹时创建
			if(!(dirFile.exists())&&!(dirFile.isDirectory())){
				dirFile.mkdirs();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dirFile;
	}
	
	/**
	 * 创建文件
	 * @author CCG 2016年6月28日
	 * @param destFileName 如：d:/ccg.txt
	 * @return
	 */
	public static boolean createFile(String destFileName) {  
        File file = new File(destFileName);  
        if(file.exists()) {  
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");  
            return false;  
        }  
        if (destFileName.endsWith(File.separator)) {  
            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");  
            return false;  
        }  
        //判断目标文件所在的目录是否存在  
        if(!file.getParentFile().exists()) {  
            //如果目标文件所在的目录不存在，则创建父目录  
            System.out.println("目标文件所在目录不存在，准备创建它！");  
            if(!file.getParentFile().mkdirs()) {  
                System.out.println("创建目标文件所在目录失败！");  
                return false;  
            }  
        }  
        //创建目标文件  
        try {  
            if (file.createNewFile()) {  
                System.out.println("创建单个文件" + destFileName + "成功！");  
                return true;  
            } else {  
                System.out.println("创建单个文件" + destFileName + "失败！");  
                return false;  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());  
            return false;  
        }  
    }
	
	/**
	 * 读取文件
	 * @author CCG 2016年6月28日
	 * @param filePath
	 * @param charset
	 */
	 public static String readTxtFile(String filePath,String charset){
		StringBuffer sb = new StringBuffer();
        try {
	        String encoding=charset;
	        String lineTxt = null;
	        File file=new File(filePath);
	        if(file.isFile() && file.exists()){ //判断文件是否存在
	            InputStreamReader read = new InputStreamReader(
	            new FileInputStream(file),encoding);//考虑到编码格式
	            BufferedReader bufferedReader = new BufferedReader(read);
	            while((lineTxt = bufferedReader.readLine()) != null){
	            	sb.append(lineTxt);
	            	sb.append(SeparatorUtils.getLineSeparator());
	            }
	            read.close();
        }else{
            System.out.println("找不到指定的文件");
        	}
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
		return sb.toString();
	 }
	 /**
	  * 追加内容到末尾
	  * @author CCG 2016年6月28日
	  * @param file
	  * @param appendStr
	  *	@throws IOException 
	  */
	 public static void appendTxt(String file,String appendStr) throws IOException{
		FileOutputStream fos = new FileOutputStream(file,true);//true表示在文件末尾追加  
		fos.write(appendStr.getBytes());  
		fos.close();//流要及时关闭
	 }
	 
	 /**
	  * 在指定文件开头插入内容
	  * @author CCG 2016年6月28日
	  * @param file d:/ccg.txt
	  * @param addStr 
	  * @param charset 
	  * @throws IOException
	  */
	 public static void addTxt(String file,String addStr,String charset) throws IOException{
		//先读出旧文件内容
		 String oldStr = FileUtil.readTxtFile(file, charset);
		 addStr = addStr + SeparatorUtils.getLineSeparator()+oldStr;
		 
		 FileOutputStream fos = new FileOutputStream(file,false);//false表示覆盖
		 fos.write(addStr.getBytes());  
		 fos.close();//流要及时关闭 
	 }
	 
	 /**
	  * 替换原来内容
	  * @author CCG 2016年6月30日
	  * @param file
	  * @param replaceStr
	  * @param charset
	  * @throws IOException
	  */
	 public static void replaceTxt(String file,String replaceStr,String charset) throws IOException{
		 FileOutputStream fos = new FileOutputStream(file,false);//false表示覆盖
		 fos.write(replaceStr.getBytes());  
		 fos.close();//流要及时关闭  
	 }
	 
	 /**
	  * 读取指定行数数据
	  * @author CCG 2016年7月13日
	  * @param lineNumber
	  * @param reader
	  * @return
	  * @throws IOException
	  */
	 public static String readXLineText(int lineNumber,BufferedReader reader) throws IOException{
		 String line = "";
		 int i = 0;
		 while(i < lineNumber){
			 line = reader.readLine();
			 i++;
		 }
		 return line;
	 }
}
