package yiping.gao.common.utils.qrCode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * FileName: TwoDimensionCodeWithLogoUtil
 * Author: 高一平
 * Date: 2018/2/6 11:14
 * Description: 生成/解析带logo的二维码
 */

public class TwoDimensionCodeWithLogoUtil {

    /**
     * 生成二维码(QRCode)图片
     *
     * @param content 二维码图片的内容
     * @param imgPath 生成二维码图片完整的路径
     * @param ccbPath 二维码图片中间的logo路径
     */
    public static int createQRCode(String content, String imgPath, String ccbPath) {
        try {
            Qrcode qrcodeHandler = new Qrcode();
            //设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
            qrcodeHandler.setQrcodeErrorCorrect('M');
            //N代表数字,A代表字符a-Z,B代表其他字符
            qrcodeHandler.setQrcodeEncodeMode('B');
            // 设置设置二维码版本，取值范围1-40，值越大尺寸越大，可存储的信息越大
            qrcodeHandler.setQrcodeVersion(8);
            byte[] contentBytes = content.getBytes("gb2312");
            BufferedImage bufImg = new BufferedImage(149, 149, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = bufImg.createGraphics();
            gs.setBackground(Color.WHITE);
            gs.clearRect(0, 0, 149, 149);
            // 设定图像颜色 > BLACK
            gs.setColor(Color.BLACK);
            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            // 输出内容 > 二维码
            if (contentBytes.length > 0 && contentBytes.length < 150) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                System.err.println("QRCode content bytes length = "
                        + contentBytes.length + " not in [ 0,125]. ");
                return -1;
            }
            Image img = ImageIO.read(new File(ccbPath));//实例化一个Image对象。
            gs.drawImage(img, 50, 50, null);
            gs.dispose();
            bufImg.flush();
            // 生成二维码QRCode图片
            File imgFile = new File(imgPath);
            ImageIO.write(bufImg, "png", imgFile);
        } catch (Exception e) {
            e.printStackTrace();
            return -100;
        }
        return 0;
    }

    public static void main(String[] args) {
        String imgPath = "E:/qrcode.png";
        String imgPath1 = "E:/logo.jpg";
        String encoderContent = "你若不离不弃，我必生死相依。";
        TwoDimensionCodeWithLogoUtil qrcode = new TwoDimensionCodeWithLogoUtil();
        qrcode.createQRCode(encoderContent, imgPath, imgPath1);
    }

}