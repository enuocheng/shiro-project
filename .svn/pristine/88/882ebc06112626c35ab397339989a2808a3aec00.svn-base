package cn.mycloudedu.framework.core.utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by qiankun.yin on 2015/7/31.
 */
public class ValidateCodeUtil {
    /**
     * 验证码类型为仅数字 0~9
     */
    public static final int TYPE_NUM_ONLY = 0;
    /**
     * 验证码类型为仅字母，即大写、小写字母混合
     */
    public static final int TYPE_LETTER_ONLY = 1;
    /**
     * 验证码类型为数字、大写字母、小写
     */
    public static final int TYPE_ALL_MIXED = 2;
    /**
     * 验证码类型为数字、大写字母混合
     */
    public static final int TYPE_NUM_UPPER = 3;
    /**
     * 验证码类型为数字、小写字母混合
     */
    public static final int TYPE_NUM_LOWER = 4;
    /**
     * 验证码类型为仅大写字母
     */
    public static final int TYPE_UPPER_ONLY = 5;
    /**
     * 验证码类型为仅小写字母
     */
    public static final int TYPE_LOWER_ONLY = 6;

    private static Random random = new Random();

    private ValidateCodeUtil(){

    }


    /**
     * 生成长度为6的数字验证码字符串
     *
     */
    public static String  generateDefaultCode(){
        return generateTextCode(TYPE_NUM_ONLY,6, null);
    }

    /**
     * 生成验证码字符串
     * @param type
     * 验证码类型，参见本类的静态属性
     * @param length
     * 验证码长度，大于0的整数
     * @param exChars
     * 需排除的特殊字符（仅对数字、字母混合型验证码有效，无需排除则为null）
     * @return
     */
    public static String  generateTextCode(int type,int length,String exChars){
        if (length<=0){
            return "";
        }
        StringBuffer code = new StringBuffer();
        int i =0;
        Random r = new Random();

        switch (type){
            case TYPE_NUM_ONLY:
                while (i<length){
                    int t = r.nextInt(10);
                    if (exChars==null||exChars.indexOf(t+"")<0){//排除特殊字符
                        code.append(t);
                        i++;
                    }
                }
                break;
            case TYPE_LETTER_ONLY:
                while(i<length){
                    int t = r.nextInt(123);
                    if ((t>97||(t>=65&&t<=90))&&(exChars==null||exChars.indexOf((char)t)<0)){
                        code.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_ALL_MIXED:
                while(i<length){
                    int t = r.nextInt(123);
                    if ((t>=97||(t>=65&&t<=90)||(t>=48&&t<= 57))&&(exChars == null||exChars.indexOf((char)t)<0)){
                        code.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_NUM_UPPER:
                while (i<length){
                    int t = r.nextInt(91);
                    if ((t>= 65||(t>=48&&t<=57))&&(exChars == null || exChars.indexOf((char)t)<0)){
                        code.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_NUM_LOWER:
                while(i<length){
                    int t = r.nextInt(123);
                    if ((t>=97||(t>=48&&t<57))&&(exChars == null || exChars.indexOf((char)t)<0)){
                        code.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_UPPER_ONLY:
                while(i<length){
                    int t = r.nextInt(91);
                    if ((t>=65)&&(exChars == null || exChars.indexOf((char)t)<0)){
                        code.append((char)t);
                        i++;
                    }
                }
                break;
            case TYPE_LOWER_ONLY:
                while (i<length){
                    int t = r.nextInt(123);
                    if ((t>97)&&(exChars == null || exChars.indexOf((char)t)<0)){
                        code.append((char)t);
                        i++;
                    }
                }
                break;
        }
        return code.toString();
    }
    public static BufferedImage generateImageCode(String textCode,int width,int height,
                                                  int interLine,boolean randomLocation,
                                                  Color backColor,Color foreColor,Color lineColor){
        BufferedImage bim = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        //设置边框
        g.setColor(Color.GRAY);
        g.fillRect(0,0,width,height);
        //话背景图
        g.setColor(backColor == null?getRandomColor(200,255):backColor);
        g.fillRect(0,2,width,height-4);
        //画干扰线
        Random r = new Random();
        if (interLine>0){
            int x = 0,y = 0,x1 =0,y1 = 0;
            for (int i=0;i<interLine;i++){
                g.setColor(lineColor == null?getRandomColor(160,200):lineColor);
                x = r.nextInt(width/2);
                x1= r.nextInt(width/2)+width/2;
                y = r.nextInt(height);
                y1 = r.nextInt(height);
                g.drawLine(x,y,x1,y1);
            }
        }
        // 添加噪点
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int rgb = getRandomIntColor();
            bim.setRGB(x, y, rgb);
        }

        shear(g,width,height, getRandomColor(200,255));// 使图片扭曲

        //写验证码

        //g.setColor(getRandomColor())
        //g.setColor(isSimpleColor?Color.BLACK:Color.WHITE);

        //字体大小为图片高度的80%
        int fsize = (int)(height*0.8);
        int fx = height - fsize;
        int fy = fsize;

        g.setFont(new Font("Algerian",Font.ITALIC,fsize));
        Random rand = new Random();
        Integer verifySize = textCode.length();
        //写验证码字符
        for(int i = 0;i<verifySize;i++){
            AffineTransform affine = new AffineTransform();
            affine.setToRotation(Math.PI / 4 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1), (width / verifySize) * i + fsize/2, height/2);
            fy = randomLocation?(int)((Math.random()*0.3+0.6)*height):fy;//每个字符高低是否随机
            g.setTransform(affine);
            g.setColor(foreColor == null?getRandomColor(100,160):foreColor);
            g.drawString(textCode.charAt(i)+"",fx,fy);
            fx += fsize*0.9;
        }
        g.dispose();
        return bim;
    }

    private static Color getRandomColor(int fromColor,int toColor) {
        if (fromColor>255){
            fromColor = 255;
        }
        if (toColor>255){
            toColor = 255;
        }
        if(fromColor<0){
            fromColor =0;
        }
        if (toColor<0){
            toColor = 0;
        }
        if (fromColor>toColor){
            return null;
        }
        Random random = new Random();
        int r = fromColor + random.nextInt(toColor - fromColor);
        int g = fromColor + random.nextInt(toColor - fromColor);
        int b = fromColor + random.nextInt(toColor - fromColor);
        Color c = new Color(r,g,b);
        return c;
    }
    private static void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    private static void shearX(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(2);

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }

    }

    private static void shearY(Graphics g, int w1, int h1, Color color) {

        int period = random.nextInt(40) + 10; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }

        }

    }

    private static int getRandomIntColor() {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb) {
            color = color << 8;
            color = color | c;
        }
        return color;
    }
    private static int[] getRandomRgb() {
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }
}
