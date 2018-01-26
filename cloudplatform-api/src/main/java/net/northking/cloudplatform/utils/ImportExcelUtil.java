package net.northking.cloudplatform.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by laodeng on 2017/11/15.
 * poi导入execl
 */
public  class ImportExcelUtil {

    private static final String execl2003 = ".xls";
    private static final String execl2007 = ".xlsx";

    public static List<List<Object>> importExecl(String filePath) throws IOException {

        List<List<Object>> list = new ArrayList<List<Object>>();

        File file = new File(filePath);

        Workbook wb = null;

        InputStream in = new FileInputStream(filePath);

        //判断后缀名
        String fileType = filePath.substring(filePath.lastIndexOf("."));
        if (execl2003.equals(fileType)) {
            wb = new HSSFWorkbook(in);
        } else if (execl2007.equals(fileType)) {
            wb = new XSSFWorkbook(in);
        }

        //表
        Sheet sheet = null;
        //行
        Row row = null;
        //列
        Cell cell = null;

        //遍历excel中所有的sheet
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            sheet = wb.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            //遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum(); j <=sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                //排除第一行
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                //遍历所有的列
                List<Object> cells = new ArrayList<Object>();
                for (int k = row.getFirstCellNum(); k <= row.getLastCellNum(); k++) {
                    cell = row.getCell(k);
                    //对数据进行格式化
                    cells.add(new ImportExcelUtil().getCellValue(cell));
                }
                    list.add(cells);
            }
        }
          return list;
    }


    /**
     * 对表格中的数据进行格式化
     */
    public Object getCellValue(Cell cell) {

        Object value = "";
        if (null == cell) {
            return value;
        }
        //以下是判断数据的类型
        switch (cell.getCellType()){
            //数值
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                            .getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date =cell.getDateCellValue();
                    value = sdf.format(date);
                } else if (cell.getCellStyle().getDataFormat() == 58) {
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    double cellValue = cell.getNumericCellValue();
                    Date date = DateUtil
                            .getJavaDate(cellValue);
                    value = sdf.format(date);
                } else {
                    //纯数字格式
                    double cellValue = cell.getNumericCellValue();
                    CellStyle style = cell.getCellStyle();
                    DecimalFormat format = new DecimalFormat();
                    String temp = style.getDataFormatString();
                    // 单元格设置成常规
                    if ("General".equals(temp)) {
                        format.applyPattern("#");
                    }
                    value = format.format(cellValue);
                }
                break;
            case HSSFCell.CELL_TYPE_STRING: // 字符串
                value = cell.getStringCellValue();
                break;

            case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                value = cell.getBooleanCellValue() + "";
                break;

            case HSSFCell.CELL_TYPE_FORMULA: // 公式
                value = cell.getCellFormula() + "";
                break;

            case HSSFCell.CELL_TYPE_BLANK: // 空值
                value = "";
                break;

            case HSSFCell.CELL_TYPE_ERROR: // 故障
                value = "非法字符";
                break;
            default:
                value = "未知类型";
                break;
        }
            return value;
    }
}