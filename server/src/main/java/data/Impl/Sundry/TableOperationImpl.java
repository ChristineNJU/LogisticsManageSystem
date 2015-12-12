package data.Impl.Sundry;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import businesslogic.URLHelper.URLHelper;
import State.InstitutionType;
import data.Helper.DBHelper.DBHelper.DBHelper;
import data.Service.Sundry.TableOperationService;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class TableOperationImpl extends UnicastRemoteObject implements TableOperationService {

	public TableOperationImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createInstitutionTable(String institution_id,
			InstitutionType type) throws RemoteException {
		// TODO Auto-generated method stub
		if(institution_id==null||type==null){
			return false;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			String table_name = "";
			if(type==InstitutionType.BusinessLobby){
				table_name = URLHelper.getDriverInfoURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (driver_number varchar(20) PRIMARY key, driver_name varchar(20), driver_birthday varchar(20), "
						+ "driver_id varchar(20), driver_mobilephone varchar(20), driver_sex varchar(10), attend_time int)");
				conn.commit();
				System.out.println("创建营业厅司机信息表");
				
				table_name = URLHelper.getCarInfoURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (car_number varchar(20) PRIMARY key, car_license varchar(20),"
						+ " attend_time int)");
				conn.commit();
				System.out.println("创建营业厅车辆信息表");
				
				table_name = URLHelper.getArrivalURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, arrival_date varchar(20), "
						+ "transfer_number varchar(25), starting varchar(20), state varchar(20), "
						+ "isApproved varchar(10))");
				conn.commit();
				System.out.println("创建营业厅到达单信息表");
				
				table_name = URLHelper.getDeliveryURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (date varchar(25) PRIMARY key, bar_code_list varchar(1000), courier varchar(20), "
						+ "isApproved varchar(10))");
				conn.commit();
				System.out.println("创建营业厅派件单信息表");
				
				table_name = URLHelper.getEntruckingURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (date varchar(25), transfer_number varchar(20) PRIMARY key, destination varchar(20), "
						+ "car_number varchar(20), guard_name varchar(20), supercargo_name varchar(20), "
						+ "bar_code_list varchar(1000), amount double, isApproved varchar(10))");
				conn.commit();
				System.out.println("创建营业厅装车单信息表");
				
				table_name = URLHelper.getGatheringURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (date varchar(20) PRIMARY key, amount double, "
						+ "courier varchar(20), bar_code_list varchar(1000), isApproved varchar(10))");
				conn.commit();
				System.out.println("创建营业厅收款单信息表");
				
				table_name = URLHelper.getInstitutionStorage(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key)");
				conn.commit();
				System.out.println("创建营业厅虚拟存储");
			}else if(type==InstitutionType.MediumCenter){
				table_name = URLHelper.getTransferURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (date varchar(20), transfer_number varchar(20) PRIMARY key, "
						+ "transport_id varchar(50), starting varchar(20), destination varchar(20), "
						+ "container_number varchar(20), guard_name varchar(20), bar_code_list varchar(1000), "
						+ "amount double, isApproved varchar(10))");
				conn.commit();
				System.out.println("创建中转中心中转单信息表");
				
				table_name = URLHelper.getEntruckingURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (date varchar(25), transfer_number varchar(20) PRIMARY key, destination varchar(20), "
						+ "car_number varchar(20), guard_name varchar(20), supercargo_name varchar(20), "
						+ "bar_code_list varchar(1000), amount double, isApproved varchar(10))");
				conn.commit();
				System.out.println("创建中转中心装车单信息表");
				
				table_name = URLHelper.getArrivalURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, arrival_date varchar(20), "
						+ "transfer_number varchar(25), starting varchar(20), state varchar(20), "
						+ "isApproved varchar(10))");
				conn.commit();
				System.out.println("创建中转中心到达单信息表");
				
				table_name = URLHelper.getInstitutionStorage(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key)");
				conn.commit();
				System.out.println("创建中转中心虚拟存储");
			}else if(type==InstitutionType.Repository){
				table_name = URLHelper.getStockTakingURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, storage_date varchar(20), "
						+ "destination varchar(20), area_code varchar(20), row int, shelf int, position int)");
				conn.commit();
				System.out.println("创建仓库库存盘点信息表");
				
				table_name = URLHelper.getStorageURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, storage_date varchar(20), "
						+ "destination varchar(20), area_code varchar(20), row int, shelf int, "
						+ "position int, isApproved varchar(10))");
				conn.commit();
				System.out.println("创建仓库入库单信息表");
				
				table_name = URLHelper.getRemovalURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_cod varchar(20) PRIMARY key, removal_date varchar(20), "
						+ "destination varchar(20), type varchar(15), transfer_number varchar(20), "
						+ "isApproved varchar(10))");
				conn.commit();
				
				table_name = URLHelper.getBalanceURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, storage_date varchar(20), destination varchar(50), "
						+ "old_area varchar(50), old_row int, old_shelf int, old_position int, "
						+ "new_area varchar(50), new_row int, new_shelf int, new_position int, isApproved varchar(10))");
				conn.commit();
				System.out.println("创建仓库库存调整信息表");
				
				table_name = URLHelper.getWareHouseURL(institution_id);
				s.execute("CREATE TABLE "+table_name+" (bar_code varchar(20) PRIMARY key, destination varchar(20), "
						+ "area_code varchar(50), row int, shelf int, position int)");
				conn.commit();
				System.out.println("创建仓库信息表");
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		} 
		return true;
	}

	@Override
	public boolean deleteInstitutionTable(String institution_id,
			InstitutionType type) throws RemoteException {
		// TODO Auto-generated method stub
		if(institution_id==null||type==null){
			return false;
		}
		
		Connection conn = DBHelper.getConnection();
		try {
			Statement s = conn.createStatement();
			String table_name = "";
			if(type==InstitutionType.BusinessLobby){
				table_name = URLHelper.getDriverInfoURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除营业厅司机信息表");
				
				table_name = URLHelper.getCarInfoURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除营业厅车辆信息表");
				
				table_name = URLHelper.getArrivalURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除营业厅到达单信息表");
				
				table_name = URLHelper.getDeliveryURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除营业厅派件单信息表");
				
				table_name = URLHelper.getEntruckingURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除营业厅装车单信息表");
				
				table_name = URLHelper.getGatheringURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除营业厅收款单信息表");
				
				table_name = URLHelper.getInstitutionStorage(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除营业厅虚拟存储");
			}else if(type==InstitutionType.MediumCenter){
				table_name = URLHelper.getTransferURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除中转中心中转单信息表");
				
				table_name = URLHelper.getEntruckingURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除中转中心装车单信息表");
				
				table_name = URLHelper.getArrivalURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除中转中心到达单信息表");
				
				table_name = URLHelper.getInstitutionStorage(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除中转中心虚拟存储");
			}else if(type==InstitutionType.Repository){
				table_name = URLHelper.getStockTakingURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除仓库库存盘点信息表");
				
				table_name = URLHelper.getStorageURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除仓库入库单信息表");
				
				table_name = URLHelper.getRemovalURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除仓库出库单信息表");
				
				table_name = URLHelper.getBalanceURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除仓库库存调整信息表");
				
				table_name = URLHelper.getWareHouseURL(institution_id);
				s.execute("DROP TABLE "+table_name);
				conn.commit();
				System.out.println("删除仓库信息表");
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}

}
