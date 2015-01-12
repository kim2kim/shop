package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="counter")
public class Counter extends DomainObject {

	private int count;
	private String name;

	@OneToMany(mappedBy = "counter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<IpAddress> hosts = new ArrayList<IpAddress>();

	public Counter(String name){
		this.name = name;
	}
	
	public Counter() {
		count = 0;
	}

	public List<IpAddress> getHosts() {
		return hosts;
	}

	public void setHosts(List<IpAddress> hosts) {
		this.hosts = hosts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void increment() {
		count++;
	}

	@Transient
	public IpAddress findIpAddress(String host) {
		for (IpAddress ipaddress : this.hosts) {
			if (ipaddress.getAddress().equals(host)) {
				return ipaddress;
			}
		}
		return null;
	}

	@Transient
	public boolean hasIpAddress(String host) {
		for (IpAddress ipaddress : this.hosts) {
			if (ipaddress.getAddress().equals(host)) {
				return true;
			}
		}
		return false;
	}
}
