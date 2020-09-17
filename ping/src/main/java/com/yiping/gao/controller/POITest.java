package com.yiping.gao.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: 高一平
 * @Date: 2020/5/22
 * @Description:
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class POITest {

    @Test
    public void test() throws IOException {
        String data = "{\"code\":\"0\",\"message\":\"获取成功\",\"success\":\"true\",\"data\":[{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"501\",\"iid\":\"3\",\"normName\":\"该事项在综合窗口收件，一个窗口受理，一次就能办成\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"502\",\"iid\":\"4\",\"normName\":\"该事项可以实行容缺受理\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"503\",\"iid\":\"5\",\"normName\":\"办理该事项不需要提交由政府部门出具的各种证明材料\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"504\",\"iid\":\"6\",\"normName\":\"办理该事项不需要提交政府部门出具的各类证照批文\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"505\",\"iid\":\"7\",\"normName\":\"该事项无需到实体大厅办理，可以在线上传全部申报材料，不用到窗口核验\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"506\",\"iid\":\"8\",\"normName\":\"该事项可以使用自助机在任何时候办理\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"507\",\"iid\":\"9\",\"normName\":\"该事项可以在本市范围内就近的实体大厅办理\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"508\",\"iid\":\"10\",\"normName\":\"该事项可以在本省范围内就近的实体大厅办理\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"false\",\"normCode\":\"509\",\"iid\":\"11\",\"normName\":\"该事项可以在全国范围内就近的实体大厅办理\",\"expandNorm\":\"false\"},{\"starLevel\":\"4\",\"usingStatus\":\"false\",\"normCode\":\"401\",\"iid\":\"12\",\"normName\":\"该事项只需要填写一张表单就可以完成申报\",\"expandNorm\":\"false\"},{\"starLevel\":\"4\",\"usingStatus\":\"false\",\"normCode\":\"402\",\"iid\":\"13\",\"normName\":\"该事项可以在线提交全部申报材料，到窗口核验原件，实现最多跑一次窗口\",\"expandNorm\":\"false\"},{\"starLevel\":\"4\",\"usingStatus\":\"false\",\"normCode\":\"404\",\"iid\":\"15\",\"normName\":\"该事项可以通过自助机办理，但只限于工作时间\",\"expandNorm\":\"false\"},{\"starLevel\":\"4\",\"usingStatus\":\"false\",\"normCode\":\"405\",\"iid\":\"16\",\"normName\":\"该事项可以在线预约办理\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"false\",\"normCode\":\"301\",\"iid\":\"17\",\"normName\":\"按照办事指南的指引能够顺利完成申报事项的办理\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"false\",\"normCode\":\"302\",\"iid\":\"18\",\"normName\":\"能够做到一张清单告知所要提交的全部申报材料\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"false\",\"normCode\":\"303\",\"iid\":\"19\",\"normName\":\"该事项只进一个实体大厅就能够办完\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"false\",\"normCode\":\"304\",\"iid\":\"20\",\"normName\":\"该事项在承诺的时间内办完\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"false\",\"normCode\":\"305\",\"iid\":\"21\",\"normName\":\"跑2次窗口即可办完该事项\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"false\",\"normCode\":\"306\",\"iid\":\"22\",\"normName\":\"实体大厅现场实行排队叫号办理\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"false\",\"normCode\":\"201\",\"iid\":\"23\",\"normName\":\"办事指南列出的申报材料没有提供样本\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"false\",\"normCode\":\"202\",\"iid\":\"24\",\"normName\":\"不能够以清单的方式一次性完整告知要提交的申报材料等相关信息\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"false\",\"normCode\":\"203\",\"iid\":\"25\",\"normName\":\"同样内容的证明材料已向该受理部门提交过，却被要求再次提交\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"false\",\"normCode\":\"204\",\"iid\":\"26\",\"normName\":\"办理完该事项需要到窗口2次以上\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"false\",\"normCode\":\"205\",\"iid\":\"27\",\"normName\":\"实体大厅没有配备现场排队叫号系统\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"false\",\"normCode\":\"206\",\"iid\":\"28\",\"normName\":\"在线预约办理后到实体大厅重复取号排队\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"false\",\"normCode\":\"101\",\"iid\":\"29\",\"normName\":\"被要求提交办事指南未列明的申报材料\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"false\",\"normCode\":\"102\",\"iid\":\"30\",\"normName\":\"承诺在线收取申报材料实际无法收取\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"false\",\"normCode\":\"103\",\"iid\":\"31\",\"normName\":\"没有在承诺的时间内办理完该事项\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"false\",\"normCode\":\"104\",\"iid\":\"32\",\"normName\":\"需要到位于实体大厅以外的办公场所提交申报材料\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"false\",\"normCode\":\"105\",\"iid\":\"33\",\"normName\":\"到大厅现场的次数和承诺的不一致\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"false\",\"normCode\":\"106\",\"iid\":\"34\",\"normName\":\"被要求在实体大厅以外的场所先办理，再到窗口重新申报或者线上重复提交\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"false\",\"normCode\":\"107\",\"iid\":\"35\",\"normName\":\"在办事指南列明的审批条件之外附加新的审批条件\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"true\",\"normCode\":\"510\",\"iid\":\"46\",\"normName\":\"一窗受理一次办结\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"true\",\"normCode\":\"511\",\"iid\":\"47\",\"normName\":\"可以先受理后补材料\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"true\",\"normCode\":\"512\",\"iid\":\"48\",\"normName\":\"不用提交证明\",\"expandNorm\":\"false\"},{\"starLevel\":\"4\",\"usingStatus\":\"true\",\"normCode\":\"406\",\"iid\":\"49\",\"normName\":\"填写一张表单就可完成申报\",\"expandNorm\":\"false\"},{\"starLevel\":\"4\",\"usingStatus\":\"true\",\"normCode\":\"407\",\"iid\":\"50\",\"normName\":\"在线提交材料窗口核验\",\"expandNorm\":\"false\"},{\"starLevel\":\"4\",\"usingStatus\":\"true\",\"normCode\":\"408\",\"iid\":\"51\",\"normName\":\"一张清单告知全部申报材料\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"true\",\"normCode\":\"307\",\"iid\":\"52\",\"normName\":\"一次性告知需要补正的材料\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"true\",\"normCode\":\"308\",\"iid\":\"53\",\"normName\":\"提供申报材料样本\",\"expandNorm\":\"false\"},{\"starLevel\":\"3\",\"usingStatus\":\"true\",\"normCode\":\"309\",\"iid\":\"54\",\"normName\":\"在承诺的时间内办结\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"true\",\"normCode\":\"207\",\"iid\":\"55\",\"normName\":\"没有提供材料样本\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"true\",\"normCode\":\"208\",\"iid\":\"56\",\"normName\":\"没有提供材料清单\",\"expandNorm\":\"false\"},{\"starLevel\":\"2\",\"usingStatus\":\"true\",\"normCode\":\"209\",\"iid\":\"57\",\"normName\":\"未在承诺时间内办结\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"true\",\"normCode\":\"108\",\"iid\":\"58\",\"normName\":\"在办事指南之外增加新的审批条件\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"true\",\"normCode\":\"109\",\"iid\":\"59\",\"normName\":\"需提供办事指南之外的申报材料\",\"expandNorm\":\"false\"},{\"starLevel\":\"1\",\"usingStatus\":\"true\",\"normCode\":\"110\",\"iid\":\"60\",\"normName\":\"无理由超过法定办理时间\",\"expandNorm\":\"false\"},{\"starLevel\":\"5\",\"usingStatus\":\"true\",\"normCode\":\"513\",\"iid\":\"61\",\"normName\":\"可以全程网上办理\",\"expandNorm\":\"true\"},{\"starLevel\":\"5\",\"usingStatus\":\"true\",\"normCode\":\"514\",\"iid\":\"62\",\"normName\":\"可以使用手机办理\",\"expandNorm\":\"true\"},{\"starLevel\":\"5\",\"usingStatus\":\"true\",\"normCode\":\"515\",\"iid\":\"63\",\"normName\":\"可以就近办理\",\"expandNorm\":\"true\"},{\"starLevel\":\"5\",\"usingStatus\":\"true\",\"normCode\":\"516\",\"iid\":\"64\",\"normName\":\"无需材料直接办理\",\"expandNorm\":\"true\"},{\"starLevel\":\"5\",\"usingStatus\":\"true\",\"normCode\":\"517\",\"iid\":\"65\",\"normName\":\"服务热情效率高\",\"expandNorm\":\"true\"},{\"starLevel\":\"4\",\"usingStatus\":\"true\",\"normCode\":\"409\",\"iid\":\"66\",\"normName\":\"用告知承诺减免申报材料\",\"expandNorm\":\"true\"},{\"starLevel\":\"4\",\"usingStatus\":\"true\",\"normCode\":\"410\",\"iid\":\"67\",\"normName\":\"可以在线预约办理\",\"expandNorm\":\"true\"},{\"starLevel\":\"4\",\"usingStatus\":\"true\",\"normCode\":\"411\",\"iid\":\"68\",\"normName\":\"跑大厅一次办完\",\"expandNorm\":\"true\"},{\"starLevel\":\"4\",\"usingStatus\":\"true\",\"normCode\":\"412\",\"iid\":\"69\",\"normName\":\"可以使用自助机办理\",\"expandNorm\":\"true\"},{\"starLevel\":\"4\",\"usingStatus\":\"true\",\"normCode\":\"413\",\"iid\":\"70\",\"normName\":\"服务态度较好\",\"expandNorm\":\"true\"},{\"starLevel\":\"3\",\"usingStatus\":\"true\",\"normCode\":\"310\",\"iid\":\"71\",\"normName\":\"办事指南指引准确\",\"expandNorm\":\"true\"},{\"starLevel\":\"3\",\"usingStatus\":\"true\",\"normCode\":\"311\",\"iid\":\"72\",\"normName\":\"按办事指南要求的材料即可办理\",\"expandNorm\":\"true\"},{\"starLevel\":\"3\",\"usingStatus\":\"true\",\"normCode\":\"312\",\"iid\":\"73\",\"normName\":\"可以快递送达\",\"expandNorm\":\"true\"},{\"starLevel\":\"3\",\"usingStatus\":\"true\",\"normCode\":\"313\",\"iid\":\"74\",\"normName\":\"跑动次数与承诺的一致\",\"expandNorm\":\"true\"},{\"starLevel\":\"3\",\"usingStatus\":\"true\",\"normCode\":\"314\",\"iid\":\"75\",\"normName\":\"服务态度一般\",\"expandNorm\":\"true\"},{\"starLevel\":\"2\",\"usingStatus\":\"true\",\"normCode\":\"210\",\"iid\":\"76\",\"normName\":\"同样内容的证明材料被要求多次提交\",\"expandNorm\":\"true\"},{\"starLevel\":\"2\",\"usingStatus\":\"true\",\"normCode\":\"211\",\"iid\":\"77\",\"normName\":\"承诺网办但无法在线办理\",\"expandNorm\":\"true\"},{\"starLevel\":\"2\",\"usingStatus\":\"true\",\"normCode\":\"212\",\"iid\":\"78\",\"normName\":\"在线预约办理后到实体大厅重复取号排队\",\"expandNorm\":\"true\"},{\"starLevel\":\"2\",\"usingStatus\":\"true\",\"normCode\":\"213\",\"iid\":\"79\",\"normName\":\"窗口人员业务不熟练\",\"expandNorm\":\"true\"},{\"starLevel\":\"2\",\"usingStatus\":\"true\",\"normCode\":\"214\",\"iid\":\"80\",\"normName\":\"服务态度生硬\",\"expandNorm\":\"true\"},{\"starLevel\":\"1\",\"usingStatus\":\"true\",\"normCode\":\"111\",\"iid\":\"81\",\"normName\":\"办事指南提供样本有错\",\"expandNorm\":\"true\"},{\"starLevel\":\"1\",\"usingStatus\":\"true\",\"normCode\":\"112\",\"iid\":\"82\",\"normName\":\"承诺在线收取申报材料实际无法收取\",\"expandNorm\":\"true\"},{\"starLevel\":\"1\",\"usingStatus\":\"true\",\"normCode\":\"113\",\"iid\":\"83\",\"normName\":\"多头跑窗口和部门\",\"expandNorm\":\"true\"},{\"starLevel\":\"1\",\"usingStatus\":\"true\",\"normCode\":\"114\",\"iid\":\"84\",\"normName\":\"跑动次数与承诺的不一致\",\"expandNorm\":\"true\"},{\"starLevel\":\"1\",\"usingStatus\":\"true\",\"normCode\":\"115\",\"iid\":\"85\",\"normName\":\"服务态度差效率低\",\"expandNorm\":\"true\"}]}";

        JSONObject json = JSONObject.parseObject(data);
        JSONArray array = json.getJSONArray("data");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        for (int i = 0; i < array.size(); i++) {
            JSONObject object = array.getJSONObject(i);
            XSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(object.getString("normCode"));
            row.createCell(1).setCellValue(object.getString("normName"));
            row.createCell(2).setCellValue(object.getString("starLevel"));
            row.createCell(3).setCellValue("1");
            // 0-未启用 1-已启用
            String usingStatus = object.getString("usingStatus");
            if (usingStatus.equals("true")) {
                String expandNorm = object.getString("expandNorm");
                if (expandNorm.equals("false")) {
                    row.createCell(4).setCellValue("1");
                } else {
                    row.createCell(4).setCellValue("0");
                }
            } else {
                row.createCell(4).setCellValue("0");
            }

            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream("E:\\1.xlsx");
                workbook.write(outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                outputStream.flush();
                outputStream.close();
            }
        }
    }

}
