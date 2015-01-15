package com.shop.test.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.Application;
import com.shop.neo4j.graphs.Member;
import com.shop.neo4j.repositories.MemberRepository;


@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class Neo4jRepositoryTest {
	
	@Autowired GraphDatabaseService graphDatabaseService;
	
	@Autowired MemberRepository memberRepository;

	@Autowired Neo4jTemplate template;

	@Test
	@Transactional 
	public void testSave(){
		Member friend = new Member("jau@gmail.com");
		
		Member member = new Member("kim@gmail.com");
		member.addFriend(friend);
	
		friend = template.save(friend);
		member = template.save(member);
		
		Member found =  template.findOne(member.getId(), Member.class);
		Assert.assertNotNull(found);
		Assert.assertEquals(friend.getId(), found.getFriends().iterator().next().getId());
		
	}
	
	@Test
	public void testRepository(){
		Member friend = new Member("jau@gmail.com");
		
		Member member = new Member("kim@gmail.com");
		member.addFriend(friend);
	
		friend = template.save(friend);
		member = template.save(member);
		
		Member found = memberRepository.findByEmail("kim@gmail.com");
		Assert.assertNotNull(found);
		Assert.assertEquals(friend.getId(), found.getFriends().iterator().next().getId());
	}
	
	@Test
	public void testQuery(){
		Member A = new Member("test@gmail.com");
		Member B = new Member("testb@gmail.com");
		
		Member friend = new Member("jau@gmail.com");
		friend.addFriend(A);
		friend.addFriend(B);

		Member returnfriend = template.save(friend);
		
		System.out.println("friend id " + returnfriend.getId());
		
		Assert.assertNotNull(returnfriend.getId());
		Assert.assertEquals(2, returnfriend.getFriends().size());
		
		Member member = new Member("kim@gmail.com");
		member.addFriend(returnfriend);

		member = template.save(member);
		
		//Page<Member> found = memberRepository.findByIdFriendsOfFriend(member.getId(), new PageRequest(0, 2));
		Collection<Member> found = memberRepository.findByIdFriendsOfFriend(member.getId());

		Assert.assertNotNull(found);
		for(Member m : found){
			if(m != null){
				if(m.getEmail()!=null){
				System.out.println(m.getEmail());
				}
				System.out.println(m.getId());
			}else{
				System.out.println("m is null");
			}
		}
		Assert.assertEquals(2, found.size());
		
	}
	
}
