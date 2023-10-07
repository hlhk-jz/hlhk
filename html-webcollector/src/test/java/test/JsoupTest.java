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
 * 模式	比赛	例
 * *	任何元素	*
 * tag	具有给定标记名称的元素	div
 * *|E	任何命名空间（包括非命名空间）中 E 类型的元素	*|name查找和元素<fb:name><name>
 * ns|E	命名空间 ns 中 E 类型的元素	fb|name查找元素<fb:name>
 * #id	属性 ID 为“id”的元素	div#wrap,#logo
 * .class	类名为“类”的元素	div.left,.result
 * [attr]	具有名为“attr”的属性的元素（具有任何值）	a[href],[title]
 * [^attrPrefix]	属性名称以“attrPrefix”开头的元素。用于查找具有 HTML5 数据集的元素	[^data-],div[^data-]
 * [attr=val]	属性名为“attr”且值等于“val”的元素	img[width=500],a[rel=nofollow]
 * [attr="val"]	属性名为“attr”且值等于“val”的元素	span[hello="Cleveland"][goodbye="Columbus"],a[rel="nofollow"]
 * [attr^=valPrefix]	属性名为“attr”且值以“valPrefix”开头的元素	a[href^=http:]
 * [attr$=valSuffix]	属性名为“attr”且值以“valSuffix”结尾的元素	img[src$=.png]
 * [attr*=valContaining]	元素，属性名为“attr”，值包含“valContaining”	a[href*=/search/]
 * [attr~=regex]	元素，其属性名为“attr”，值与正则表达式匹配	img[src~=(?i)\\.(png|jpe?g)]
 * 以上内容可以按任何顺序组合	div.header[title]
 */
public class JsoupTest {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.quanjing.com/").get();
            //System.out.println(doc.html());

            //属性选择器
            Elements select1 = doc.select("[href]");
            //System.out.println(select1.html());

            //标签选择器，选择a 标签
            Elements links = doc.select("a");
           //System.out.println(links.html());

            //CSS查询匹配的元素,查询a标签中href的值
            //Elements links2 = doc.select("a[href]");
            //CSS查询匹配的元素,查找a标签中href的值中包含 tubiao 的值， *= 是模糊查询
            //Elements links2 = doc.select("a[href*=tubiao]");
            /**
             * CSS查询匹配的元素,查找 img中src包含https://webimg.quanjing.com的值
             * Element的元素集合，遍历获取 src 地址，下载
             */
            Elements links2 = doc.select("img[src *= https://webimg.quanjing.com]");
           /* int s = 1;
            for (Element link : links2) {
                s ++;
                String src = link.attr("src");
                Connection.Response imgRes = Jsoup.connect(src).ignoreContentType(true).execute();
                FileOutputStream out = (new FileOutputStream(new java.io.File("D:/images/"+s+".jpg")));
                // imgRes.bodyAsBytes() 以字节数组的形式获取响应的正文。
                out.write(imgRes.bodyAsBytes());
                out.close();
            }*/

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
