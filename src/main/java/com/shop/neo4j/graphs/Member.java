package com.shop.neo4j.graphs;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Member {

	@GraphId
	private Long id;

	@Indexed(unique = true)
	private String email;

	@RelatedTo(type = "FRIEND", direction = Direction.BOTH)
	@Fetch
	Set<Member> friends;

	public Member() {
	}
	
	public Member(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Member> getFriends() {
		return friends;
	}

	public void setFriends(Set<Member> friends) {
		this.friends = friends;
	}

	public void addFriend(Member user) {
		if(this.friends == null){
			this.friends = new HashSet<Member>();
		}
		this.friends.add(user);
	}

}
