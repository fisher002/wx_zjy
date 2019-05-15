package org.fisher.weixin.processor;

import org.fisher.weixin.inmessage.event.EventInMessage;

public interface EventMessageProcessor {
	void onMessage(EventInMessage msg);
}
