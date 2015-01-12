package com.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.shop.core.enums.AddressType;
import com.shop.core.enums.CartStatus;
import com.shop.core.enums.CategoryType;
import com.shop.core.enums.Gender;
import com.shop.core.enums.ItemType;
import com.shop.core.enums.PermissionType;
import com.shop.core.enums.SubscriptionType;
import com.shop.core.enums.UserType;
import com.shop.model.User;
import com.shop.utils.Age;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="person")
public class Person extends DomainObject{
	
	@Enumerated(EnumType.STRING)
	private SubscriptionType subscriptionType;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PageViewed viewed;

	/** **/
	private Integer online;

	private boolean subscribed = false;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Rating rating;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customize customize;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = true)
	private User userAccount;

	@OrderBy("enteredDate DESC")
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Balance> balances = new ArrayList<Balance>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Face> faces = new ArrayList<Face>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemOrderDetail> itemOrderDetails = new ArrayList<ItemOrderDetail>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FavoriteAd> favoriteAds = new ArrayList<FavoriteAd>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Events> events = new ArrayList<Events>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<GuestPerson> guests = new ArrayList<GuestPerson>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AcceptPerson> accepts = new ArrayList<AcceptPerson>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ConsideringPerson> considerings = new ArrayList<ConsideringPerson>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DeclinePerson> declines = new ArrayList<DeclinePerson>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Journal> journals = new ArrayList<Journal>();

	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderDetail> buyOrders = new ArrayList<OrderDetail>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderDetail> sellOrders = new ArrayList<OrderDetail>();

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Date birthday;

	@Enumerated(EnumType.STRING)
	@Column(name="user_type")
	private UserType userType;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private Bank bank;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmailAddress> emails = new ArrayList<EmailAddress>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Phone> phones = new ArrayList<Phone>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Address> addresses = new ArrayList<Address>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Friend> friends = new ArrayList<Friend>();

	@OrderBy("enteredDate DESC")
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Headline> headlines = new ArrayList<Headline>();

	/**
	 * Someone writing to me
	 */
	@OrderBy("enteredDate DESC")
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Scribble> scribbles = new ArrayList<Scribble>();

	/**
	 * People I've scribbled on
	 */
	@OrderBy("enteredDate DESC")
	@OneToMany(mappedBy = "scribbler", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Scribble> scribbledOns = new ArrayList<Scribble>();

	@OrderBy("enteredDate DESC")
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<News> news = new ArrayList<News>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CreditCard> creditCards = new ArrayList<CreditCard>();

	@OrderBy("enteredDate DESC")
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PersonTag> tags = new ArrayList<PersonTag>();

	/**
	 * My permission setting for each type
	 */
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Permission> permissions = new ArrayList<Permission>();

	/*
	 * Group level visibility. Every visibilityDomain you create represents a
	 * group. Must manually add a person to a specific group you create here.
	 * Must manually decide what entities will belong to which of these groups.
	 */
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "visibilitydomain_person", joinColumns =
	// @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name =
	// "visibilitydomain_id"))
	private List<VisibilityDomainPerson> visibilityGroups = new ArrayList<VisibilityDomainPerson>();

	/*
	 * Group level visibility. Every visibilityDomain you create represents a
	 * group. Must manually add a person to a specific group you create here.
	 * Must manually decide what entities will belong to which of these groups.
	 */
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinTable(name = "group_person", joinColumns = @JoinColumn(name =
	// "person_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private List<GroupPerson> userGroups = new ArrayList<GroupPerson>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderDetail> orders = new ArrayList<OrderDetail>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PersonVisibilityDomain> allowedPermissions = new ArrayList<PersonVisibilityDomain>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Item> items = new ArrayList<Item>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItem> cartItems = new ArrayList<CartItem>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RewardCart> rewardItems = new ArrayList<RewardCart>();

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PersonVisibilityDomain> personVisibilities = new ArrayList<PersonVisibilityDomain>();

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private ShoppingCart shoppingCart;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private Profile profile;

	public PageViewed getViewed() {
		return viewed;
	}

	public void setViewed(PageViewed viewed) {
		this.viewed = viewed;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public List<Journal> getJournals() {
		return journals;
	}

	public void setJournals(List<Journal> journals) {
		this.journals = journals;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public List<ItemOrderDetail> getItemOrderDetails() {
		return itemOrderDetails;
	}

	public void setItemOrderDetails(List<ItemOrderDetail> itemOrderDetails) {
		this.itemOrderDetails = itemOrderDetails;
	}

	public List<OrderDetail> getBuyOrders() {
		return buyOrders;
	}

	public void setBuyOrders(List<OrderDetail> buyOrders) {
		this.buyOrders = buyOrders;
	}

	public List<OrderDetail> getSellOrders() {
		return sellOrders;
	}

	public void setSellOrders(List<OrderDetail> sellOrders) {
		this.sellOrders = sellOrders;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<RewardCart> getRewardItems() {
		return rewardItems;
	}

	public void setRewardItems(List<RewardCart> rewardItems) {
		this.rewardItems = rewardItems;
	}

	public boolean isSubscribed() {
		if (this.getUserType() == UserType.SLEEKSWAP) {
			return true;
		}
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public User getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;

	}

	public List<EmailAddress> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailAddress> emails) {
		this.emails = emails;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Transient
	public int getAge() {
		return Age.get(this.birthday);
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	public List<Headline> getHeadlines() {
		return headlines;
	}

	public void setHeadlines(List<Headline> headlines) {
		this.headlines = headlines;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Scribble> getScribbles() {
		return scribbles;
	}

	public void setScribbles(List<Scribble> scribbles) {
		this.scribbles = scribbles;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public List<Face> getFaces() {
		return faces;
	}

	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public List<ItemCategory> getItemCategories() {
		return itemCategories;
	}

	public void setItemCategories(List<ItemCategory> itemCategories) {
		this.itemCategories = itemCategories;
	}

	public List<PersonVisibilityDomain> getPersonVisibilities() {
		return personVisibilities;
	}

	public void setPersonVisibilities(
			List<PersonVisibilityDomain> personVisibilities) {
		this.personVisibilities = personVisibilities;
	}

	@Transient
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public List<PersonTag> getTags() {
		return tags;
	}

	public void setTags(List<PersonTag> tags) {
		this.tags = tags;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<VisibilityDomainPerson> getVisibilityGroups() {
		return visibilityGroups;
	}

	public void setVisibilityGroups(
			List<VisibilityDomainPerson> visibilityGroups) {
		this.visibilityGroups = visibilityGroups;
	}

	public List<FavoriteAd> getFavoriteAds() {
		return favoriteAds;
	}

	public void setFavoriteAds(List<FavoriteAd> favoriteAds) {
		this.favoriteAds = favoriteAds;
	}

	public List<GroupPerson> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<GroupPerson> userGroups) {
		this.userGroups = userGroups;
	}

	@Transient
	public List<Journal> getActiveJournals() {
		List<Journal> l = new ArrayList<Journal>();
		for (Journal e : this.journals) {
			if (e.isActive()) {
				l.add(e);
			}
		}
		return l;
	}

	@Transient
	public List<Scribble> getActiveScribbles() {
		List<Scribble> l = new ArrayList<Scribble>();
		for (Scribble e : this.scribbles) {
			if (e.isActive()) {
				l.add(e);
			}
		}
		return l;
	}

	@Transient
	public List<Scribble> getActiveScribbledOns() {
		List<Scribble> l = new ArrayList<Scribble>();
		for (Scribble e : this.scribbledOns) {
			if (e.isActive()) {
				l.add(e);
			}
		}
		return l;
	}

	@Transient
	public List<EmailAddress> getActiveEmailAddress() {
		List<EmailAddress> l = new ArrayList<EmailAddress>();
		for (EmailAddress e : this.emails) {
			if (e.isActive()) {
				l.add(e);
			}
		}
		return l;
	}

	@Transient
	public List<Address> getActiveAddresses() {
		List<Address> l = new ArrayList<Address>();
		for (Address a : this.addresses) {
			if (a.isActive()) {
				l.add(a);
			}
		}
		return l;
	}

	@Transient
	public List<Phone> getActivePhones() {
		List<Phone> l = new ArrayList<Phone>();
		for (Phone p : this.phones) {
			if (p.isActive()) {
				l.add(p);
			}
		}
		return l;
	}

	@Transient
	public List<Face> getActiveFaces() {
		List<Face> l = new ArrayList<Face>();
		for (Face p : this.faces) {
			if (p.isActive() && !p.getMini().getSystem().equals("Local")) {
				l.add(p);
			}
		}
		return l;
	}

	@Transient
	public Face getDefaultFace() {
		for (Face p : this.faces) {
			if (p.isDefaultFace() && !p.isApplication()) {
				return p;
			}
		}
		return this.getApplicationFace();
	}

	@Transient
	public Face getApplicationFace() {
		for (Face p : this.faces) {
			if (p.isApplication()) {
				return p;
			}
		}
		throw new RuntimeException(
				"There is no application specific profile face.");
	}

	@Transient
	public void clearDefaultFace() {
		for (Face p : this.faces) {
			if (p.isDefaultFace() && !p.isApplication()) {
				p.setDefaultFace(false);
			}
		}
	}

	@Transient
	public List<CreditCard> getActiveCreditCards() {
		List<CreditCard> l = new ArrayList<CreditCard>();
		for (CreditCard c : this.creditCards) {
			if (c.isActive()) {
				l.add(c);
			}
		}
		return l;
	}

	@Transient
	public Address getBusinessAddress() {
		for (Address a : this.addresses) {
			if (a.isActive() && a.getType() == AddressType.BUSINESS) {
				return a;
			}
		}
		return null;
	}

	@Transient
	public List<Item> getActiveItems() {
		List<Item> list = new ArrayList<Item>();
		for (Item a : this.items) {
			if (a.isActive()) {
				list.add(a);
			}
		}
		return list;
	}
	
	@Transient
	public String identifier() {
		return this.getFirstName() + "-" + this.getLastName() + "-"
				+ this.getId();
	}

	@Transient
	public String getCurrentHeadline() {
		if (this.headlines.size() == 0 || this.headlines.get(0) == null) {
			return null;
		}
		return this.headlines.get(0).getHeadline();
	}

	public Customize getCustomize() {
		return customize;
	}

	public void setCustomize(Customize customize) {
		this.customize = customize;
	}

	public List<OrderDetail> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public List<GuestPerson> getGuests() {
		return guests;
	}

	public void setGuests(List<GuestPerson> guests) {
		this.guests = guests;
	}

	public List<AcceptPerson> getAccepts() {
		return accepts;
	}

	public void setAccepts(List<AcceptPerson> accepts) {
		this.accepts = accepts;
	}

	public List<ConsideringPerson> getConsiderings() {
		return considerings;
	}

	public void setConsiderings(List<ConsideringPerson> considerings) {
		this.considerings = considerings;
	}

	public List<DeclinePerson> getDeclines() {
		return declines;
	}

	public void setDeclines(List<DeclinePerson> declines) {
		this.declines = declines;
	}

	public List<PersonVisibilityDomain> getAllowedPermissions() {
		return allowedPermissions;
	}

	public void setAllowedPermissions(
			List<PersonVisibilityDomain> allowedPermissions) {
		this.allowedPermissions = allowedPermissions;
	}

	public List<Scribble> getScribbledOns() {
		return scribbledOns;
	}

	public void setScribbledOns(List<Scribble> scribbledOns) {
		this.scribbledOns = scribbledOns;
	}

	public List<Balance> getBalances() {
		return balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}
	
	public Balance getCurrentBalance(){
		Date today = new Date();
		for(Balance b : balances){
			if(today.after(b.getStartDate()) && today.before(b.getEndDate())){
				return b;
			}
		}

		return new Balance();
	}

	public Double getUnpaidBalance(){
		double total = 0;
		for(Balance b : balances){
			if(b.isPaid()){
				total += b.getTotal();
			}
		}

		return total;
	}
	
	@Transient
	public boolean getIsSleekswap() {
		if (this.getUserType() == UserType.SLEEKSWAP) {
			return true;
		}
		return false;
	}

	@Transient
	public boolean isFriends(String friendId) {
		if (friends == null) {
			return false;
		}
		for (Friend friend : friends) {
			if (friend.getFriend().getId().equals(Long.parseLong(friendId))) {
				return true;
			}
		}
		return false;
	}

	@Transient
	public boolean isFriends(Long friendId) {
		if (friends == null) {
			return false;
		}
		for (Friend friend : friends) {
			if (friend.getFriend().getId().equals(friendId)) {
				return true;
			}
		}
		return false;
	}

	@Transient
	public Friend findFriend(Long friendId) {
		for (Friend friend : friends) {
			if (friend.getFriend().getId().equals(friendId)) {
				return friend;
			}
		}
		return null;
	}

	@Transient
	public GroupPerson findGroup(Long groupId) {
		for (GroupPerson e : this.userGroups) {
			if (e.getId().equals(groupId)) {
				return e;
			}
		}
		return null;
	}

	@Transient
	public GroupPerson findPermissionVisibilityInGroup(
			Long permissionVisibilityId) {
		for (GroupPerson e : this.userGroups) {
			if (e.getPermissionVisibility().getId().equals(
					permissionVisibilityId)) {
				return e;
			}
		}
		return null;
	}

	@Transient
	public Permission findPermission(Long permissionId) {
		for (Permission e : this.permissions) {
			if (e.getId().equals(permissionId)) {
				return e;
			}
		}
		return null;
	}

	@Transient
	public Permission getPermissionForType(PermissionType type) {
		for (Permission p : permissions) {
			if (p.getType() == type) {
				return p;
			}
		}
		// Will never happen. Its a controlled field
		return null;
	}

	@Transient
	public VisibilityDomain getVisibilityForType(PermissionType type) {
		for (VisibilityDomainPerson v : visibilityGroups) {
			if (v.getVisibilityDomain().getActivityType() == type) {
				return v.getVisibilityDomain();
			}
		}
		// Will never happen. Its a controlled field
		return null;
	}

	@Transient
	public void getNewsPermission(News news) {
		news.getNewsVisibility().add(
				new NewsVisibilityDomain(news,
						getVisibilityForType(PermissionType.NEWS)));
		news.getNewsVisibility().add(
				new NewsVisibilityDomain(news, getDefaultVisibility()));
	}

	public void getItemVisibility(Item item, String category) {
		item.getItemVisibilities().add(
				new ItemVisibilityDomain(item, getDefaultVisibility()));
		item.getItemVisibilities()
				.add(
						new ItemVisibilityDomain(item,
								getVisibilityForType(PermissionType
										.valueOf(category))));
		item.getItemVisibilities().add(
				new ItemVisibilityDomain(item,
						getVisibilityForType(PermissionType.ITEMS)));
	}

	public void getScribblePermission(Scribble scribble) {
		scribble.getScribbleVisibilities().add(
				new ScribbleVisibilityDomain(scribble,
						getVisibilityForType(PermissionType.SCRIBBLE)));
		scribble.getScribbleVisibilities().add(
				new ScribbleVisibilityDomain(scribble, getDefaultVisibility()));
	}

	public void getJournalPermission(Journal journal) {
		journal.getJournalVisibilities().add(
				new JournalVisibility(journal,
						getVisibilityForType(PermissionType.JOURNAL)));
		journal.getJournalVisibilities().add(
				new JournalVisibility(journal, getDefaultVisibility()));
	}

	public void getEventPermission(Events event) {
		event.getEventVisibilities().add(
				new EventVisibility(event,
						getVisibilityForType(PermissionType.EVENT)));
		event.getEventVisibilities().add(
				new EventVisibility(event, getDefaultVisibility()));
	}

	public void getFriendPermission(Friend friend) {
		friend.getFriendVisibilities().add(
				new FriendVisibility(friend,
						getVisibilityForType(PermissionType.FRIENDS)));
		friend.getFriendVisibilities().add(
				new FriendVisibility(friend, getDefaultVisibility()));
	}

	public PersonVisibilityDomain findPersonVisibility(VisibilityDomain vd) {
		for (PersonVisibilityDomain pvd : this.personVisibilities) {
			if (pvd.getVisibilityDomain().getId().equals(vd.getId())) {
				return pvd;
			}
		}
		return null;
	}

	public void hasReadAllScribble() {
		for (Scribble scribble : this.scribbles) {
			scribble.setHasRead(true);
		}
	}

	public int getUnreadScribbles() {
		int count = 0;
		for (Scribble scribble : this.scribbles) {
			if (!scribble.isHasRead()) {
				count++;
			}
		}
		return count;
	}

	public VisibilityDomain getDefaultVisibility() {
		for (VisibilityDomainPerson v : this.visibilityGroups) {
			if (v.getVisibilityDomain().isDefaultVisibility()) {
				return v.getVisibilityDomain();
			}
		}
		// Should never happen unless someone accidentally edited the default
		// group
		throw new RuntimeException("There is no default visibility");
	}

	@Transient
	public String getAlias() {
		return this.firstName;
	}

	public boolean isMaxService() {
		if (this.getUserType() == UserType.SLEEKSWAP) {
			return false;
		}
		if (getCategoryCount(CategoryType.SERVICE) < subscriptionType.getMax()) {
			return false;
		}
		return true;
	}

	public boolean isMaxSelling() {
		if (this.getUserType() == UserType.SLEEKSWAP) {
			return false;
		}
		if (getCategoryCount(CategoryType.SELLING) < subscriptionType.getMax()) {
			return false;
		}		
		return true;
	}

	public int getCategoryCount(CategoryType category) {
		int count = 0;
		for (ItemCategory ic : itemCategories) {
			if (ic.getCategory() == category && ic.isActive()) {
				count++;
			}
		}
		return count;
	}

	// product specific logic

	public int getRewardForVendor(Person person) {
		int totalRewardsPoints = 0;
		for (CartItem c : cartItems) {
			if (c.getStatus() == CartStatus.BOUGHT
					&& c.getItem().getPerson().getId().equals(person.getId())) {
				totalRewardsPoints += c.getPriceTotal();
			}
		}
		return totalRewardsPoints;
	}

	@Transient
	public List<String> getRewardsPerVendor() {
		Map<Person, Float> rewards = new HashMap<Person, Float>();
		List<String> forWeb = new ArrayList<String>();
		for (CartItem c : cartItems) {
			Float totalRewardsPoints = rewards.get(c.getItem().getPerson());

			if (totalRewardsPoints == null) {
				totalRewardsPoints = c.getPriceTotal();
			} else {
				totalRewardsPoints += c.getPriceTotal();
			}
			rewards.put(c.getItem().getPerson(), totalRewardsPoints);
		}
		for (Map.Entry<Person, Float> entry : rewards.entrySet()) {
			forWeb.add("<a href='#' onclick='showPoints("
					+ entry.getKey().getId() + ");'>"
					+ entry.getKey().getFullName() + " : $ " + entry.getValue()
					+ "</a>\n");
		}

		return forWeb;
	}

	@Transient
	public List<PointItem> getPointItems() {
		List<PointItem> pointItems = new ArrayList<PointItem>();
		for (Item i : items) {
			if (i.getType() == ItemType.POINT && i.isActive()) {
				pointItems.add((PointItem) i);
			}
		}
		return pointItems;
	}

	@Transient
	public boolean isRewardsAllowed() {
		if (this.subscriptionType == SubscriptionType.PREMIUM) {
			return true;
		}
		return false;
	}

	@Transient
	public boolean isPartners() {
		if (this.subscriptionType == SubscriptionType.PREMIUM) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + (subscribed ? 1231 : 1237);
		result = prime
				* result
				+ ((subscriptionType == null) ? 0 : subscriptionType.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (subscribed != other.subscribed)
			return false;
		if (subscriptionType == null) {
			if (other.subscriptionType != null)
				return false;
		} else if (!subscriptionType.equals(other.subscriptionType))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

}
