package org.fisher.weixin.menu.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

// 表示自定义菜单
@Entity
@Table(name = "wx_self_menu")
public class SelfMenu {

	@Id
	@Column(length = 36)
	// 使用UUID2算法生成主键的值，分布式系统里面不能使用自增长作为主键值
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	private String id;

	// 这个成员变量，将会在发送给微信公众号的时候，封装成名为button的属性。
	// 这里特地设计成名称不同，这是因为后面有复杂的操作，还是需要手工来转换的！
	@OneToMany(cascade = CascadeType.ALL)
	// 当前类对应的表是主表，@JoinColumn会在子表生成一个名为menu_id的外键列
	@JoinColumn(name = "menu_id")
	private List<MenuButton> subMenus = new LinkedList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<MenuButton> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<MenuButton> subMenus) {
		this.subMenus = subMenus;
	}
}
