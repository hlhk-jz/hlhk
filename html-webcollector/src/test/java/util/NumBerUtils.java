package util;

public class NumBerUtils {

    public static void main(String[] args){
        String url = "https://m.yexiashuge.xyz/book/1040698/chapter/501976071.html";
        System.out.println(url.substring(0,url.length()-5));
    }

    /**
     * 通过章节名获取第几章
     * @param title 章节名
     * @return 转换后的int
     */
    public static int getSectionNum(String title){
        try {
            String sectionNumString = title;
            char[] charList = sectionNumString.toCharArray();

            int num = getChinaNum(charList,0,0,0);

            return num;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转换失败2："+title);
        }
        return 0;
    }

    /**
     * 通过递归将中文转int
     * @param chinaList 需要转换的中文数值
     * @param i 处理到的位数
     * @param maxNum 暂存的数字
     * @param nowNum 暂存的数字
     * @return 转换后的int
     */
    public static int getChinaNum(char[] chinaList,int i,int maxNum,int nowNum){
        if(i>=chinaList.length){
            return maxNum;
        }
        int flag = charToInt(chinaList[i]);
        i++;
        if(flag>9){
            // 这里时解决第一位不是数值而是位值得情况
            maxNum = maxNum == 0 ? 1:maxNum;
            if(flag > maxNum){
                // todo 这个if有俩次递归，或许会有更好的处理方式
                if(getChinaNum(chinaList,i,0,0)>(maxNum+nowNum)*flag){
                    return getChinaNum(chinaList,i,(maxNum+nowNum)*flag,0);
                }else{
                    return (maxNum+nowNum)*flag + getChinaNum(chinaList,i,0,0);
                }
            }else{
                return getChinaNum(chinaList,i,maxNum+nowNum*flag,0);
            }
        }else{
            if(maxNum < flag){
                return getChinaNum(chinaList,i,flag,0);
            }else{
                return getChinaNum(chinaList,i,maxNum,flag);
            }
        }
    }

    /**
     * 单个字符转int
     * @param num 需要转换的字符
     * @return 转换后的int
     */
    public static int charToInt(char num){
        switch (num){
            case '十':
                return 10;
            case '百':
                return 100;
            case '千':
                return 1000;
            case '万':
                return 10000;
            case '亿':
                return 100000000;
            case '零':
                return 0;
            case '一':
                return 1;
            case '二':
                return 2;
            case '两':
                return 2;
            case '三':
                return 3;
            case '四':
                return 4;
            case '五':
                return 5;
            case '六':
                return 6;
            case '七':
                return 7;
            case '八':
                return 8;
            case '九':
                return 9;
            default:
                System.out.println(num);
                return 0;
        }
    }

}
