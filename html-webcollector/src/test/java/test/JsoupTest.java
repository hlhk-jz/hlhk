package test;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 * select 方 法为选择器
 * select（标签） 标签选择器
 * select（.class） 类选择器
 * select（#id）id选择器
 * select（[属性]）属性选择器
 */
public class JsoupTest {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.88tph.com/topic/2021qiuji/").get();
            //System.out.println(doc.html());

            //属性选择器
            Elements select1 = doc.select("[href]");
            System.out.println(select1.html());

            //标签选择器，选择ul 标签
            Elements ul = doc.select("a");
           // System.out.println(ul.html());

            //类选择器
            Elements select = Jsoup.parse(doc.html()).select(".clearfix");
            //System.out.println(select.html());

           /* Connection.Response imgRes = Jsoup.connect(URLS.get(0)).ignoreContentType(true).execute();
            FileOutputStream out = (new FileOutputStream(new java.io.File("demo.jpg")));*/
            // imgRes.body() 就是图片数据out.write(imgRes.bodyAsBytes());out.close();


            }catch (Exception e){
            e.printStackTrace();
         }
     }
 }
