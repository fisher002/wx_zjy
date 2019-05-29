package org.fisher.weixin.menu.service;

import org.fisher.weixin.menu.domain.SelfMenu;

public interface SelfMenuService {

	SelfMenu getMenu();

	void save(SelfMenu selfMenu);

}
