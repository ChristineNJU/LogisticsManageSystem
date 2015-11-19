package businesslogic.Service.Manage;

import java.util.ArrayList;

import VO.StaffVO;

public interface GetStaffService {
	public ArrayList<StaffVO> searchStaff (String id);
}
