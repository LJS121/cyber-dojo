package com.mjy.cyber;

import com.google.common.collect.Lists;

import java.util.List;

public class HarryPotter {

    private final static int price = 8 * 100;

    public static int calculateCost(List<HarryPotterTitle> bookList) {
        if (bookList == null || bookList.size() == 0) {
            return 0;
        } else if (bookList.size() == 1) {
            return price;
        } else {
            List<HarryPotterTitle> bookListWithDiscounts = Lists.newArrayList();
            List<HarryPotterTitle> bookListLeft = Lists.newArrayList();
            groupDiscount(bookList, bookListWithDiscounts, bookListLeft);

            return getFinalCost(bookList, bookListWithDiscounts, bookListLeft, getDiscount(bookListWithDiscounts));
        }
    }

    private static int getFinalCost(List<HarryPotterTitle> bookList, List<HarryPotterTitle> bookListWithDiscounts, List<HarryPotterTitle> bookListLeft, float discount) {
        if (bookListLeft.size() == 0) {
            return Double.valueOf(price * bookList.size() * discount).intValue();
        } else {
            return calculateCost(bookListWithDiscounts) + calculateCost(bookListLeft);
        }
    }

    private static void groupDiscount(List<HarryPotterTitle> bookList, List<HarryPotterTitle> bookListWithDiscounts, List<HarryPotterTitle> bookListLeft) {
        for (HarryPotterTitle title : bookList) {
            if (!bookListWithDiscounts.contains(title)) {
                bookListWithDiscounts.add(title);
            } else {
                bookListLeft.add(title);
            }
        }
    }

    private static float getDiscount(List<HarryPotterTitle> bookListWithDiscounts) {
        float discount;
        switch (bookListWithDiscounts.size()) {
            case 2:
                discount = 0.95F;
                break;
            case 3:
                discount = 0.9F;
                break;
            case 4:
                discount = 0.8F;
                break;
            case 5:
                discount = 0.75F;
                break;
            default:
                discount = 1F;
        }
        return discount;
    }
}

enum HarryPotterTitle {
    HarryPotter1("HarryPotter1"),
    HarryPotter2("HarryPotter2"),
    HarryPotter3("HarryPotter3"),
    HarryPotter4("HarryPotter4"),
    HarryPotter5("HarryPotter5");

    private String title;

    private HarryPotterTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
