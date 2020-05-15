package com.sist.xml;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RSS {
	private Channel channel = new Channel();

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}


	
	
}
