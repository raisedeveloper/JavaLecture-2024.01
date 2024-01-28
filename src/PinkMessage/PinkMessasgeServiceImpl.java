package PinkMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PinkMessasgeServiceImpl {
	
	private List<PinkMessage> pm = new ArrayList<>();
	private int index = 1001;
	
	public PinkMessasgeServiceImpl() {
		pm.add(new PinkMessage(index++, "나는 자바를 다룰 수 있게 되었다.", LocalDateTime.now()));
		pm.add(new PinkMessage(index++, "나는 스프링부트를 할 수 있게 되었다.", LocalDateTime.now()));
		pm.add(new PinkMessage(index++, "나는 깃허브를 다룰 수 있게 되었다.", LocalDateTime.now()));
		pm.add(new PinkMessage(index++, "나는 3개의 팀 프로젝트를 마쳤다.", LocalDateTime.now()));
	}
	
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
	
	 
	
	
	
	
	MesContent MesTime isDeleted

}
