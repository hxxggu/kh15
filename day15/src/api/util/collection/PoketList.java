package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class PoketList {
	
	private List<Poketmon> poketList;
	
	public PoketList() {
		this.poketList = new ArrayList<>();
	}
	
	public PoketList(List<Poketmon> poketmon) {
		this.poketList = poketmon;
	}
	
	public void add(Poketmon poketmon) {
		this.poketList.add(poketmon);
	}
	
	public void search(String name) {
		for(Poketmon poketmon : this.poketList) {
			if(poketmon.getName().equals(name)) {
				System.out.println(poketmon.toString()); return;
			}
		} System.out.println("몬스터가 존재하지 않습니다");
	}
}
