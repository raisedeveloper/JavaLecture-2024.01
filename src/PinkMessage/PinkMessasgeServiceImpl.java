package PinkMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PinkMessasgeServiceImpl {
	
	private List<PinkMessage> pm = new ArrayList<>();
	private int index = 1001;

	public PinkMessage findByMesListNum(int MesListNum) {
		for (PinkMessage pm: pm)
			if (pm.getMesListNum() == MesListNum)
				return pm;
		return null;
	}
	
	public List<MesName> getPinkMessageMesName() {
		List<PinkMessage> pmList = new ArrayList<>();
		for(PinkMessage pm: pm) {
			if (pm.getIsDeleted() != PinkMessageService.DELETED);
			pmList.add(pm);
		}
		return pmList;
	}
	
	public List<PinkMessage> getPinkMessagesListByMesContent(String MesContent) {
		List<PinkMessage> pmList = new ArrayList<>();
		for (PinkMessage pm: list) {
			if (pm.getIsDeleted() != PinkMessageService.DELETED &&)
		}
	}
	
	 
	
	
	
	
	MesContent MesTime isDeleted		// 삭제

}
