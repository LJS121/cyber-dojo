package com.mjy.cyber;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.Data;

public class PokerHands {

    public static final String BLACK = "Black";

    public static final String WHITE = "White";

    private static int compare;

    public static String pokerHands(Map<String, String> map) {

        List<Poker> blackPokers = getPokers(map.get(BLACK));
        List<Poker> whitePokers = getPokers(map.get(WHITE));

        return compareTwo(blackPokers, whitePokers);
    }

    private static String compareTwo(List<Poker> blackPokers, List<Poker> whitePokers) {

        String output = checkStraightFlush(blackPokers, whitePokers);
        if (output != null) {
            return output;
        }

        output = checkFourOfkind(blackPokers, whitePokers);
        if (output != null) {
            return output;
        }
        output = checkFullHouse(blackPokers, whitePokers);
        if (output != null) {
            return output;
        }
        output = checkFlush(blackPokers, whitePokers);
        if (output != null) {
            return output;
        }
        output = checkStraight(blackPokers, whitePokers);
        if (output != null) {
            return output;
        }

        output = checkThreeOfkind(blackPokers, whitePokers);
        if (output != null) {
            return output;
        }
        output = checkTwoPairs(blackPokers, whitePokers);
        if (output != null) {
            return output;
        }
        output = checkPair(blackPokers, whitePokers);
        if (output != null) {
            return output;
        }

        return normalPoker(blackPokers, whitePokers);
    }

    private static String checkPair(List<Poker> blackPokers, List<Poker> whitePokers) {

        List<Entry<String, Integer>> blackEntryList = getEntry(totalMap(blackPokers), 2);
        List<Entry<String, Integer>> whiteEntryList = getEntry(totalMap(whitePokers), 2);

        return dealWithPairs(blackPokers, whitePokers, blackEntryList, whiteEntryList, "pair", 1);
    }

    private static String checkTwoPairs(List<Poker> blackPokers, List<Poker> whitePokers) {

        List<Entry<String, Integer>> blackEntryList = getEntry(totalMap(blackPokers), 2);
        List<Entry<String, Integer>> whiteEntryList = getEntry(totalMap(whitePokers), 2);

        return dealWithPairs(blackPokers, whitePokers, blackEntryList, whiteEntryList, "two pairs", 2);
    }

    private static String dealWithPairs(List<Poker> blackPokers, List<Poker> whitePokers, List<Entry<String, Integer>> blackEntryList,
                    List<Entry<String, Integer>> whiteEntryList, String type, int times) {

        compare = 0;
        if (blackEntryList.size() == times && whiteEntryList.size() < times) {
            compare = 1;
        } else if (blackEntryList.size() < times && whiteEntryList.size() == times) {
            compare = -1;
        } else if (blackEntryList.size() == times && whiteEntryList.size() == times) {
            compare = getPairsCompare(blackPokers, whitePokers, blackEntryList, whiteEntryList);
        } else {
            return null;
        }
        return compare == 0 ? "Tie" : String.format("%s wins - %s", getBlackOrWhite(), type);
    }

    private static int getPairsCompare(List<Poker> blackPokers, List<Poker> whitePokers, List<Entry<String, Integer>> blackEntryList,
                    List<Entry<String, Integer>> whiteEntryList) {

        compare = 0;
        for (int i = blackEntryList.size() - 1; i >= 0; i--) {
            compare = Poker.compareTwo(blackEntryList.get(i).getKey(), whiteEntryList.get(i).getKey());
            if (compare != 0) {
                return compare;
            }
        }

        List<Poker> tempBlack = Lists.newArrayList();
        for (int i = 0; i < blackPokers.size(); i++) {
            if (!containsValue(blackEntryList, blackPokers.get(i).getValue())) {
                tempBlack.add(blackPokers.get(i));
            }
        }
        List<Poker> tempWhite = Lists.newArrayList();
        for (int i = 0; i < whitePokers.size(); i++) {
            if (!containsValue(whiteEntryList, whitePokers.get(i).getValue())) {
                tempWhite.add(whitePokers.get(i));
            }
        }

        return Poker.compareTwo(tempBlack, tempWhite);
    }

    private static boolean containsValue(List<Entry<String, Integer>> entryList, String value) {

        for (Entry<String, Integer> entry : entryList) {
            if (entry.getKey().equals(value)) {
                return true;
            }
        }
        return false;
    }

    private static String checkThreeOfkind(List<Poker> blackPokers, List<Poker> whitePokers) {

        List<Entry<String, Integer>> blackEntryList = getEntry(totalMap(blackPokers), 3);
        List<Entry<String, Integer>> whiteEntryList = getEntry(totalMap(whitePokers), 3);

        return dealCompare(blackPokers, whitePokers, blackEntryList.size() > 0, whiteEntryList.size() > 0, "three of a kind");
    }

    private static String checkStraight(List<Poker> blackPokers, List<Poker> whitePokers) {

        boolean blackIfStraight = ifStraight(blackPokers);
        boolean whiteIfStraight = ifStraight(whitePokers);

        return dealCompare(blackPokers, whitePokers, blackIfStraight, whiteIfStraight, "straight");
    }

    private static String checkFlush(List<Poker> blackPokers, List<Poker> whitePokers) {

        boolean blackIfFlush = ifFlush(blackPokers);
        boolean whiteIfFlush = ifFlush(whitePokers);

        return dealCompare(blackPokers, whitePokers, blackIfFlush, whiteIfFlush, "flush");
    }

    private static String dealCompare(List<Poker> blackPokers, List<Poker> whitePokers, boolean boo1, boolean boo2, final String type) {

        compare = 0;
        if (boo1 && !boo2) {
            compare = 1;
        } else if (!boo1 && boo2) {
            compare = -1;
        } else if (boo1 && boo2) {
            compare = Poker.compareTwo(blackPokers.get(blackPokers.size() - 1), whitePokers.get(whitePokers.size() - 1));
        } else {
            return null;
        }

        return compare == 0 ? "Tie" : String.format("%s wins - %s", getBlackOrWhite(), type);
    }

    private static String getBlackOrWhite() {

        return compare > 0 ? BLACK : WHITE;
    }

    private static String checkFullHouse(List<Poker> blackPokers, List<Poker> whitePokers) {

        List<Entry<String, Integer>> blackEntryList1 = getEntry(totalMap(blackPokers), 3);
        List<Entry<String, Integer>> blackEntryList2 = getEntry(totalMap(blackPokers), 2);
        List<Entry<String, Integer>> whiteEntryList1 = getEntry(totalMap(whitePokers), 3);
        List<Entry<String, Integer>> whiteEntryList2 = getEntry(totalMap(whitePokers), 2);

        return dealCompare(blackPokers, whitePokers, (blackEntryList1.size() == 1 && blackEntryList2.size() == 1),
            (whiteEntryList1.size() == 1 && whiteEntryList2.size() == 1), "full house");
    }

    private static String checkFourOfkind(List<Poker> blackPokers, List<Poker> whitePokers) {

        List<Entry<String, Integer>> blackEntryList = getEntry(totalMap(blackPokers), 4);
        List<Entry<String, Integer>> whiteEntryList = getEntry(totalMap(whitePokers), 4);

        return dealCompare(blackPokers, whitePokers, blackEntryList.size() > 0, whiteEntryList.size() > 0, "four of a kind");
    }

    private static List<Entry<String, Integer>> getEntry(Map<String, Integer> blackMap, int times) {

        List<Entry<String, Integer>> list = Lists.newArrayList();
        for (Entry<String, Integer> entry : blackMap.entrySet()) {
            if (entry.getValue() == times) {
                list.add(entry);
            }
        }
        Collections.sort(list, (o1, o2) -> Poker.compareTwo(o1.getKey(), o2.getKey()));
        return list;
    }

    private static Map<String, Integer> totalMap(List<Poker> pokers) {

        Map<String, Integer> map = Maps.newHashMap();
        for (Poker poker : pokers) {
            map.put(poker.getValue(), map.get(poker.getValue()) == null ? 1 : map.get(poker.getValue()) + 1);
        }
        return map;
    }

    private static String checkStraightFlush(List<Poker> blackPokers, List<Poker> whitePokers) {

        boolean ifBlackStraightFlush = ifStraightFlush(blackPokers);
        boolean ifWhiteStraightFlush = ifStraightFlush(whitePokers);
        return dealCompare(blackPokers, whitePokers, ifBlackStraightFlush, ifWhiteStraightFlush, "straight flush");
    }

    private static String normalPoker(List<Poker> blackPokers, List<Poker> whitePokers) {

        compare = blackPokers.get(blackPokers.size() - 1).compareTo(whitePokers.get(whitePokers.size() - 1));
        if (compare != 0) {
            return String.format("%s wins - high card: %s", getBlackOrWhite(),
                compare > 0 ? blackPokers.get(blackPokers.size() - 1).getValue() : whitePokers.get(whitePokers.size() - 1).getValue());
        } else {
            return "Tie";
        }

    }

    private static List<Poker> getPokers(String black) {

        List<Poker> pokers = Lists.newArrayList();
        for (String str : black.split(" ")) {
            pokers.add(new Poker(str));
        }
        Collections.sort(pokers);
        return pokers;
    }

    private static boolean ifStraightFlush(List<Poker> pokerList) {

        if (!ifFlush(pokerList)) {
            return false;
        }
        if (!ifStraight(pokerList)) {
            return false;
        }
        return true;
    }

    private static boolean ifStraight(List<Poker> pokerList) {

        if (pokerList.get(0).getIndex() > 8) {
            return false;
        }
        for (int i = 0; i < pokerList.size() - 1; i++) {
            if (pokerList.get(i + 1).getIndex() - pokerList.get(i).getIndex() != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean ifFlush(List<Poker> pokerList) {

        String suit = pokerList.get(0).getSuit();
        for (Poker poker : pokerList) {
            if (!suit.equals(poker.getSuit())) {
                return false;
            }
        }
        return true;
    }

}

@Data
class Poker implements Comparable {

    private String value;

    private String suit;

    private static final String CLUBS = "C";

    private static final String DIAMONDS = "D";

    private static final String HEARTS = "H";

    private static final String SPADES = "S";

    public static final String SORT = "23456789TJQKA";

    public Poker() {

    }

    public Poker(String valueAndSuit) {

        this.value = valueAndSuit.substring(0, 1);
        this.suit = valueAndSuit.substring(1, 2);
    }

    public static int compareTwo(List<Poker> list1, List<Poker> list2) {

        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = list1.size() - 1; i >= 0; i--) {
            if (compareTwo(list1.get(i), list2.get(i)) != 0) {
                return compareTwo(list1.get(i), list2.get(i));
            }
        }
        return 0;
    }

    @Override
    public int compareTo(Object o) {

        return SORT.indexOf(this.value) - SORT.indexOf(((Poker) o).value);
    }

    public int getIndex() {

        return SORT.indexOf(this.value);
    }

    public static int compareTwo(Poker p1, Poker p2) {

        return SORT.indexOf(p1.getValue()) - SORT.indexOf(p2.getValue());
    }

    public static int compareTwo(String v1, String v2) {

        return SORT.indexOf(v1) - SORT.indexOf(v2);
    }

}
