package yiping.gao.common.utils.qrCode;

import java.io.File;

/**
 * FileName: QrCodeUtil
 * Author: 高一平
 * Date: 2018/2/5 15:46
 * Description: 二维码生成器
 */

public class QrCodeUtil {

    public void generatingQrCode(String context, String imgPath) {
        TwoDimensionCode handler = new TwoDimensionCode();
        File file = new File(imgPath);
        if (file.exists() == false) {
            handler.encoderQRCode(context, imgPath, "png");
        }
    }

    public String analyticQrcode(String imgPath){
        TwoDimensionCode handler = new TwoDimensionCode();
        String decoderContent = handler.decoderQRCode(imgPath);
        return decoderContent;
    }

    public static void main(String[] args) {
        String imgPath = "D:\\BDIOT_QRCODE.png";
        String context = "这是一个小测试";
        QrCodeUtil qrCodeUtil = new QrCodeUtil();
        qrCodeUtil.generatingQrCode(context, imgPath);
        System.out.println("成功");
        String analyticQrcode = qrCodeUtil.analyticQrcode(imgPath);
        System.out.println("二维码信息为：" + analyticQrcode);
    }

}
