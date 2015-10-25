package businesslogic.Service.Manage;

import java.util.ArrayList;

import businesslogic.VO.StaffVO;

public interface SearchStaffService {
	public ArrayList<StaffVO> searchStaff (String id);
}
