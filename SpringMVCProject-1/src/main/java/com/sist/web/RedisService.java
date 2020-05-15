package com.sist.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

@Service("redisService")
public class RedisService {
	
	@Autowired
	private RedisTemplate<String, String> template;
	
	@Resource(name="redisTemplate")
	private ListOperations<String, String> listOps;
	
	@Resource(name="redisTempalte")
	private HashOperations<String,String,String> hashOps;
	
	
	@Resource(name="redisTemplate")
	private SetOperations<String, String> setOps;
	
/*	public List<Sensor> getSensor() {
		RedisOperations<String, String> redis= listOps.getOperations();
		
		Set<String> keys = redis.keys("sensor*");
		
		Iterator<String> iter=keys.iterator();
		
		List<Sensor> sensorList = new ArrayList<Sensor>();
		
		while(iter.hasNext()){
			String key = iter.next().toString();
			int size = (int)(long)redis.opsForList().size(key);
			for(int i=0;i<size; i++){
				Sensor sensor = new Sensor();
				String[] value=redis.opsForList().leftPop(key).split("_");
				sensor.getDeviceName();
				
			}
		}
		
	}*/
	
}
