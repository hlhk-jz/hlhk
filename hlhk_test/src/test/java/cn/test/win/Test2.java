package cn.test.win;

import java.awt.*;

//获取鼠标指定位置颜色
public class Test2 {
    public static void main(String[] args)throws Exception{
        Robot robot = new Robot();
        Color pixelColor = robot.getPixelColor(1389, 744);
        GetChineseColorByColor(pixelColor);
    }
    private static void GetChineseColorByColor(Color color) {
        int rgb = color.getRGB();
        float hsb[] = new float[3];
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = (rgb) & 0xFF;
        System.out.print(r + " " + g + " " + b + ":  ");
        Color.RGBtoHSB(r, g, b, hsb);
        if (hsb[1] < 0.1 && hsb[2] > 0.9) {
            System.out.println("white");
        } else if (hsb[2] < 0.1) {
            System.out.println("black");
        } else {
            float deg = hsb[0] * 360;

            if (deg >= 0 && deg < 30) {
                System.out.println("red");
            } else if (deg >= 30 && deg < 90) {
                System.out.println("yellow");
            } else if (deg >= 90 && deg < 150) {
                System.out.println("green");
            } else if (deg >= 150 && deg < 210) {
                System.out.println("cyan");
            } else if (deg >= 210 && deg < 270) {
                System.out.println("blue");
            } else if (deg >= 270 && deg < 330) {
                System.out.println("magenta");
            } else {
                System.out.println("red");
            }
        }
    }
}
