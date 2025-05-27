package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

@Component
public class PowerLottery implements Lottery{

	@Override
	public List<Integer> createLottery() {
		TreeSet<Integer> lottery = new TreeSet<>();
		while (lottery.size() < 6) {
			lottery.add((int)(Math.random()*38+1));
		}
		
		List<Integer> retList = new ArrayList<>();
		for (Integer i : lottery) {
			retList.add(i);
		}
		
		retList.add((int)(Math.random()*8+1));
		
		return retList;
	}
}
