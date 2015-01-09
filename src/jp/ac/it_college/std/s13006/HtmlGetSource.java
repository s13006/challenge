package jp.ac.it_college.std.s13006;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlGetSource {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("URLを入力してください");
            URL url = new URL("http://www.yahoo.co.jp/");
            url = new URL(br.readLine());
            System.out.println(getSourceText(url));

        } catch (IOException e) {
            System.err.println(e);
            System.exit(-1);
        }
    }


    public static String getSourceText(URL url) throws IOException {
        InputStream in = url.openStream();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            String s;
            while ((s=bf.readLine())!=null) {
                sb.append(s);
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }
}
