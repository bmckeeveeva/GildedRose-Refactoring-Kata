package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.gildedrose.TestItem.singletonItem;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GildedRoseTest {
    static final String NORMAL = "Normal";
    static final String AGED_BRIE = "Aged Brie";
    static final String CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    void normal_afterSellByDegradeTwiceAsFast() {
        TestItem[] items = new TestItem[] {
            new TestItem(NORMAL, 1, 4),
            new TestItem(NORMAL, 1, 3)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertArrayEquals(
            new TestItem[] {
                new TestItem(NORMAL, 0, 3),
                new TestItem(NORMAL, 0, 2)
            },
            items
        );

        app.updateQuality();
        assertArrayEquals(
            new TestItem[] {
                new TestItem(NORMAL, -1, 1),
                new TestItem(NORMAL, -1, 0)
            },
            items
        );

        app.updateQuality();
        assertArrayEquals(
            new TestItem[] {
                new TestItem(NORMAL, -2, 0),
                new TestItem(NORMAL, -2, 0)
            },
            items
        );
    }

    @ParameterizedTest
    @ValueSource(strings = { NORMAL, CONCERT })
    void qualityInNeverNegative(String itemName) {
        TestItem[] items = singletonItem(itemName, 0, 0);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertArrayEquals(
            singletonItem(itemName, -1, 0),
            items
        );
    }


    @Test
    void sulfuras_qualityAndSellInNeverChange() {
        TestItem[] items = singletonItem(SULFURAS, 2, 5);
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertArrayEquals(
            singletonItem(SULFURAS, 2, 5),
            items
        );
    }

    @Test
    void sulfuras_negativeSellIn() {
        TestItem[] items = singletonItem(SULFURAS, -1, 5);
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertArrayEquals(
            singletonItem(SULFURAS, -1, 5),
            items
        );
    }

    @Test
    void agedBrie_qualityIncreasesWithAge() {
        TestItem[] items = new TestItem[] {
            new TestItem(AGED_BRIE, 1, 48),
            new TestItem(AGED_BRIE, 1, 49)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertArrayEquals(
            new TestItem[] {
                new TestItem(AGED_BRIE, 0, 49),
                new TestItem(AGED_BRIE, 0, 50)
            },
            items
        );

        app.updateQuality();
        assertArrayEquals(
            new TestItem[] {
                new TestItem(AGED_BRIE, -1, 50),
                new TestItem(AGED_BRIE, -1, 50)
            },
            items
        );
    }

    @Test
    void agedBrie_qualityFunction2() {
        TestItem[] items = singletonItem(AGED_BRIE, -1, 1);
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertArrayEquals(
            singletonItem(AGED_BRIE, -2, 3),
            items
        );
    }

    @Test
    void concert_qualityFunction() {
        TestItem[] items = singletonItem(CONCERT, 11, 1);
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertArrayEquals(
            singletonItem(CONCERT, 10, 2),
            items
        );

        app.updateQuality();
        assertArrayEquals(
            singletonItem(CONCERT, 9, 4),
            items
        );

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertArrayEquals(
            singletonItem(CONCERT, 5, 12),
            items
        );

        app.updateQuality();
        assertArrayEquals(
            singletonItem(CONCERT, 4, 15),
            items
        );

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertArrayEquals(
            singletonItem(CONCERT, 0, 27),
            items
        );

        app.updateQuality();
        assertArrayEquals(
            singletonItem(CONCERT, -1, 0),
            items
        );
    }

    @Test
    void concert_qualityFunction2() {
        TestItem[] items = singletonItem(CONCERT, 10, 49);
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertArrayEquals(
            singletonItem(CONCERT, 9, 50),
            items
        );
    }

    @Test
    void concert_qualityFunction3() {
        TestItem[] items = singletonItem(CONCERT, 5, 49);
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertArrayEquals(
            singletonItem(CONCERT, 4, 50),
            items
        );
    }
}
