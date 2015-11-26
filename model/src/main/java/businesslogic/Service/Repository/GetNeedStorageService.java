package businesslogic.Service.Repository;

import java.util.ArrayList;

import VO.StorageVO;

public interface GetNeedStorageService {
	public ArrayList<StorageVO> getNeedStorage(String destination);
}
