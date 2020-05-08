package com.sist.data;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

//property 트위터에서 제공하는 인터페이스
public class TwitterListener implements StatusListener {

	@Override
	public void onException(Exception ex) {
		// TODO Auto-generated method stub
		System.out.println(ex.getMessage());
		
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	//검색할떄마다 자동 호출되는 함수
	@Override
	public void onStatus(Status status) {
		// TODO Auto-generated method stub
		System.out.println(status.getUser().getScreenName());
		System.out.println(status.getText());
		System.out.println(status.getCreatedAt());
		System.out.println(status.getFavoriteCount());
		System.out.println(status.getUser().getOriginalProfileImageURL());
		System.out.println("============================================");
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
