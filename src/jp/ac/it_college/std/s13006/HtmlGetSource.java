package jp.ac.it_college.std.s13006;


import java.io.*;
import java.net.URL;

public class HtmlGetSource {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            //URLを指定し、そのサイトのソースを取得
            System.out.println("URLを入力してください");
            URL url = new URL("http://www.yahoo.co.jp/");
            url = new URL(br.readLine());
            //取得したソースを出力
            String source = getSourceText(url);
            System.out.println(source);

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
            //取得したソースをファイルに保存
            File save = new File("temp.txt");
            FileWriter filewriter = new FileWriter(save);

            while ((s = bf.readLine())!=null) {
                filewriter.write(s + "\n\r");

                //取得した行と次の行をつなげる
                sb.append(s);
            }
            filewriter.close();

        } finally {
            in.close();
        }
        return sb.toString();
    }
}
