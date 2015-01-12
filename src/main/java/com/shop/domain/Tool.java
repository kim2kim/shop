package com.shop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

/**
 * Used to customize the tools on a user's page.
 * 
 * @author khim.ung
 *
 */
@Entity
public class Tool extends DomainObject {

	public enum ToolType {
		BANK, UPLOAD_IMAGE, ADD_FRIEND, PROFILE;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private Photo icon;

	@Column(name="tool_tip")
	private String toolTip;

	/*
	 * The display name for the tool
	 */
	private String name;

	@Enumerated(EnumType.STRING)
	private ToolType type;
	
	/************************************************************/

	public Photo getIcon() {
		return icon;
	}

	public void setIcon(Photo icon) {
		this.icon = icon;
	}

	public String getToolTip() {
		return toolTip;
	}

	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ToolType getType() {
		return type;
	}

	public void setType(ToolType type) {
		this.type = type;
	}

}
