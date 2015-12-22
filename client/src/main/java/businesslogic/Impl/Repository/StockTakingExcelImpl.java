package businesslogic.Impl.Repository;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import State.OutputState;
import VO.StockTakingVO;
import businesslogic.Service.Repository.StockTakingExcelService;
import businesslogic.SystemLog.SystemLog;

// TODO: Auto-generated Javadoc
/**
 * The Class StockTakingExcelImpl.
 */
public class StockTakingExcelImpl implements StockTakingExcelService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Repository.StockTakingExcelService#stockTakingExcel(java.util.ArrayList)
	 */
	@Override
	public OutputState stockTakingExcel(ArrayList<StockTakingVO> stockTaking) {
		// TODO Auto-generated method stub
		
		if(stockTaking.isEmpty()){
			return OutputState.EMPTYDATAERROR;
		}
		
		HSSFWorkbook wb = new HSSFWorkbook();  
		HSSFSheet sheet = wb.createSheet("StockTakingSheet");  
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = wb.createCellStyle();  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
        //-------------------------------------------------------------------
		HSSFCell cell = row.createCell(0);  
		cell.setCellValue("BarCode");  
		cell.setCellStyle(style);
		
		cell=row.createCell(1);
		cell.setCellValue("StorageDate");
		cell.setCellStyle(style);
		
		cell=row.createCell(2);
		cell.setCellValue("Destination");
		cell.setCellStyle(style);
		
		cell=row.createCell(3);
		cell.setCellValue("AreaCode");
		cell.setCellStyle(style);
		
		cell=row.createCell(4);
		cell.setCellValue("Row");
		cell.setCellStyle(style);
		
		cell=row.createCell(5);
		cell.setCellValue("Shelf");
		cell.setCellStyle(style);
		
		cell=row.createCell(6);
		cell.setCellValue("Postition");
		cell.setCellStyle(style);
		
		//---------------------------------------------------------------------
		
		for(int i=0;i<stockTaking.size();i++){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			row = sheet.createRow(i + 1);
			StockTakingVO stock=stockTaking.get(i);
			row.createCell(0).setCellValue(stock.getBarCode());  
			row.createCell(1).setCellValue(sdf.format(stock.getStorageDate()));
			row.createCell(2).setCellValue(stock.getDestination());
			row.createCell(3).setCellValue(State.StateSwitch.switchToStr(stock.getAreaCode())); 
			row.createCell(4).setCellValue(stock.getRow());
			row.createCell(5).setCellValue(stock.getShelf());
			row.createCell(6).setCellValue(stock.getPosition());  
		}
		
		//-----------------------------------------------------------------------
		
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date=new Date();
			if(new File(".\\StockTakingExcel\\StockExcel"+SystemLog.getInstitutionId()+sdf.format(date)+".xls").exists()){
				return OutputState.OVERWRITEWARNING;
			}
			FileOutputStream fout = new FileOutputStream(".\\StockTakingExcel\\StockExcel"+SystemLog.getInstitutionId()+sdf.format(date)+".xls");  
            wb.write(fout);  
			fout.close(); 
		} catch (Exception ex) {
			ex.printStackTrace();
			return OutputState.FILEEXPORTERROR;
		}

		//------------------------------------------------------------------------
		
		return OutputState.SUCCESS;
	}

}
