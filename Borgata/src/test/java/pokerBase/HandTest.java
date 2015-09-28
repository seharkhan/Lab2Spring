package pokerBase;
//By Sehar Khan, Caroline Ostuni & Kayla McAdoo

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

import pokerBase.Deck;

public class HandTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		d = new Deck();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private static Deck d;
	
	
    //Tests the number of cards in the deck
	@Test
	public void testDeck() {
		int iExpectedSize = 52;
		assertTrue(d.getTotalCards() == iExpectedSize);
		
		int iRemoveCard = 51;
		d.drawFromDeck();
		assertTrue(d.getTotalCards() == iRemoveCard);
		
		
	}
	
	//Tests all the hand evaluations
	
	@Test
	public void TestRoyalFlush() {
		ArrayList <Card> royalFlush = new ArrayList <Card>();
		royalFlush.add(new Card(eSuit.SPADES, eRank.ACE,0));
		royalFlush.add(new Card(eSuit.SPADES, eRank.KING,0));
		royalFlush.add(new Card(eSuit.SPADES, eRank.QUEEN,0));
		royalFlush.add(new Card(eSuit.SPADES, eRank.JACK,0));
		royalFlush.add(new Card(eSuit.SPADES, eRank.TEN,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(royalFlush);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.RoyalFlush.getHandStrength() == myHand.getHandStrength());
		
	}
	
	@Test
	public void TestStraightFlush() {
		ArrayList <Card> straightFlush = new ArrayList <Card>();
		straightFlush.add(new Card(eSuit.SPADES, eRank.FOUR,0));
		straightFlush.add(new Card(eSuit.SPADES, eRank.FIVE,0));
		straightFlush.add(new Card(eSuit.SPADES, eRank.SIX,0));
		straightFlush.add(new Card(eSuit.SPADES, eRank.SEVEN,0));
		straightFlush.add(new Card(eSuit.SPADES, eRank.EIGHT,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(straightFlush);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.StraightFlush.getHandStrength() == myHand.getHandStrength());
		
	}

	
	@Test
	public void TestFourofaKind() {
		ArrayList <Card> fourOfAKind = new ArrayList <Card>();
		fourOfAKind.add(new Card(eSuit.CLUBS, eRank.ACE,0));
		fourOfAKind.add(new Card(eSuit.SPADES, eRank.ACE,0));
		fourOfAKind.add(new Card(eSuit.HEARTS, eRank.ACE,0));
		fourOfAKind.add(new Card(eSuit.DIAMONDS, eRank.ACE,0));
		fourOfAKind.add(new Card(eSuit.CLUBS, eRank.TEN,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(fourOfAKind);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.FourOfAKind.getHandStrength() == myHand.getHandStrength());
		
	}

	
	@Test
	public void TestFullHouse() {
		ArrayList <Card> fullHouse = new ArrayList <Card>();
		fullHouse.add(new Card(eSuit.CLUBS, eRank.ACE,0));
		fullHouse.add(new Card(eSuit.SPADES, eRank.ACE,0));
		fullHouse.add(new Card(eSuit.HEARTS, eRank.EIGHT,0));
		fullHouse.add(new Card(eSuit.DIAMONDS, eRank.EIGHT,0));
		fullHouse.add(new Card(eSuit.CLUBS, eRank.EIGHT,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(fullHouse);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.FullHouse.getHandStrength() == myHand.getHandStrength());
		
	}
	
	@Test
	public void TestFlush() {
		ArrayList <Card> flush = new ArrayList <Card>();
		flush.add(new Card(eSuit.CLUBS, eRank.ACE,0));
		flush.add(new Card(eSuit.CLUBS, eRank.TEN,0));
		flush.add(new Card(eSuit.CLUBS, eRank.EIGHT,0));
		flush.add(new Card(eSuit.CLUBS, eRank.FOUR,0));
		flush.add(new Card(eSuit.CLUBS, eRank.JACK,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(flush);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.Flush.getHandStrength() == myHand.getHandStrength());
		
	}
	
	@Test
	public void TestStraight() {
		ArrayList <Card> straight = new ArrayList <Card>();
		straight.add(new Card(eSuit.CLUBS, eRank.SEVEN,0));
		straight.add(new Card(eSuit.SPADES, eRank.EIGHT,0));
		straight.add(new Card(eSuit.HEARTS, eRank.NINE,0));
		straight.add(new Card(eSuit.DIAMONDS, eRank.TEN,0));
		straight.add(new Card(eSuit.CLUBS, eRank.JACK,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(straight);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.Straight.getHandStrength() == myHand.getHandStrength());
		
	}
	
	@Test
	public void TestThreeOfAKind() {
		ArrayList <Card> threeOfAKind = new ArrayList <Card>();
		threeOfAKind.add(new Card(eSuit.CLUBS, eRank.SEVEN,0));
		threeOfAKind.add(new Card(eSuit.SPADES, eRank.SEVEN,0));
		threeOfAKind.add(new Card(eSuit.HEARTS, eRank.SEVEN,0));
		threeOfAKind.add(new Card(eSuit.DIAMONDS, eRank.TEN,0));
		threeOfAKind.add(new Card(eSuit.CLUBS, eRank.JACK,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(threeOfAKind);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.ThreeOfAKind.getHandStrength() == myHand.getHandStrength());
		
	}
	
	@Test
	public void TestTwoPair() {
		ArrayList <Card> twoPair = new ArrayList <Card>();
		twoPair.add(new Card(eSuit.CLUBS, eRank.SEVEN,0));
		twoPair.add(new Card(eSuit.SPADES, eRank.SEVEN,0));
		twoPair.add(new Card(eSuit.HEARTS, eRank.TWO,0));
		twoPair.add(new Card(eSuit.DIAMONDS, eRank.TWO,0));
		twoPair.add(new Card(eSuit.CLUBS, eRank.FOUR,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(twoPair);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.TwoPair.getHandStrength() == myHand.getHandStrength());
		
	}
	
	@Test
	public void TestPair() {
		ArrayList <Card> Pair = new ArrayList <Card>();
		Pair.add(new Card(eSuit.CLUBS, eRank.SEVEN,0));
		Pair.add(new Card(eSuit.SPADES, eRank.SEVEN,0));
		Pair.add(new Card(eSuit.HEARTS, eRank.TWO,0));
		Pair.add(new Card(eSuit.DIAMONDS, eRank.EIGHT,0));
		Pair.add(new Card(eSuit.CLUBS, eRank.FOUR,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(Pair);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.Pair.getHandStrength() == myHand.getHandStrength());
		
	}
	
	public void TestHighCard() {
		ArrayList <Card> highCard = new ArrayList <Card>();
		highCard.add(new Card(eSuit.CLUBS, eRank.SEVEN,0));
		highCard.add(new Card(eSuit.SPADES, eRank.FOUR,0));
		highCard.add(new Card(eSuit.HEARTS, eRank.TWO,0));
		highCard.add(new Card(eSuit.DIAMONDS, eRank.NINE,0));
		highCard.add(new Card(eSuit.CLUBS, eRank.ACE,0));
		
		
		Hand myHand = new Hand();
		myHand = Hand.EvalHand(highCard);
		myHand.EvalHand();
		
		assertTrue(eHandStrength.HighCard.getHandStrength() == myHand.getHandStrength());
		
	}








}
