package com.qunar.work.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qunar.work.domain.Characters;

public class GetCharacters {
	
	private String url;
	private int characters;
	private int chinese;
	private int letters;
	private int punctuation;
	private String title;
	private int numbers;

	public GetCharacters(String url) {
		this.url = url;
	}
	
	public Characters getCharacters() {
		try {
			InputStream in = getInputStream(url);
			InputStreamReader inputStreamReader = new InputStreamReader(in,"UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = null;
			//读取prop内容
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				letters += GetCharacters.countLetters(line);
				chinese += GetCharacters.countChinese(line);
				punctuation += GetCharacters.countPunctuation(line);
				numbers += GetCharacters.countNumber(line);
			}
			characters = letters + chinese + punctuation + numbers;
			bufferedReader.close();
			inputStreamReader.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		title = url;
		Characters c = new Characters(characters, chinese, letters, punctuation, title);
		
		return c;
	}
	
	/**
     * 正则表达式判断有多少数字
     * @param str
     * @return
     */
    public static int countNumber(String str){
        int count = 0;
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    };
	
	/**
     * 判断有多少字母
     * @param str
     * @return
     */
    public static int countLetters(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    /**
     * 判断有多少中文
     * @param str
     * @return
     */
    public static int countChinese(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    /**
     * 判断标点
     * @param str
     * @return
     */
    public static int countPunctuation(String str){
        int count = 0;
        Pattern p = Pattern.compile("\\pP");
        Matcher m = p.matcher(str);
        while (m.find()){
            count++;
        }
        return count;
    }

	private InputStream getInputStream(String path) throws IOException {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty(
			"Accept",
			"image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
			+ "application/x-shockwave-flash, application/xaml+xml, "
			+ "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
			+ "application/x-ms-application, application/vnd.ms-excel, "
			+ "application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		
		return conn.getInputStream();
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
