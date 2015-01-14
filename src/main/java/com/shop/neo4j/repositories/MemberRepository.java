package com.shop.neo4j.repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import com.shop.neo4j.graphs.Member;

public interface MemberRepository extends GraphRepository<Member> {
	
	//@Query("start member=node:Member(email={0}) return member")
	//@Query("MATCH (`member`:`Member`) WHERE `member`.`email` = {0} RETURN `member`")
	//public Member findByEmail(@Param("0") String email);
	
	public Member findByEmail(String email);
	
	/*
	 * <- means right has left
	 * -> means left has right
	 * 
	 * MATCH (`member`) WHERE id(`member`) = {0} AND `member`:`Member` RETURN `member`
	 */
	//@Query("MATCH (me)-[FRIEND]->(friend) where id(me) = {id} RETURN friend.friends order by limit {start}, {size}")
	//@Query("MATCH (me:Member)-[f:FRIEND]->(friend:Member)-[ff:FRIEND]->(fof:Member) WHERE id(me) = {id} RETURN collect(fof)")
	//@Query("MATCH (me)-[f:FRIEND]->(friend) WHERE id(me) = {id} RETURN labels(friend) as label") // causes entity is required; it must not be null
	@Query("MATCH path=(me:Member {id: '{id}'})-[f:FRIEND]->(friend:Member) WITH [x in nodes(path) | id(x) AS friends] WHERE id(me) in friends MATCH friends-[ff:FRIEND]->(fof:Member) return fof") // expect Node but was Path
	public Collection<Member> findByIdFriendsOfFriend(@Param("id") Long id);
	
    // returns the node with id equal to idOfMovie parameter  
    //@Query("start n=node({0}) return n")
    
	Member getMemberById(Long id);
    

}
