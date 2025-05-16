package com.gildedrose;

import java.util.Map;

import static com.gildedrose.Handler.CHANGE_NOTHING;
import static com.gildedrose.Handler.DECREMENT_SELL_IN;

class GildedRose {
    private static final Map<String, Handler> HANDLERS = Map.of(
        "Aged Brie",
        new Handler(GildedRose::agedBrie, DECREMENT_SELL_IN),
        "Backstage passes to a TAFKAL80ETC concert",
        new Handler(GildedRose::concert, DECREMENT_SELL_IN),
        "Sulfuras, Hand of Ragnaros",
        new Handler(CHANGE_NOTHING, CHANGE_NOTHING)
    );

    private static final Handler NORMAL_HANDLER = new Handler(GildedRose::normal, DECREMENT_SELL_IN);

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            HANDLERS.getOrDefault(item.name, NORMAL_HANDLER).update(item);

            if (item.quality < 0) {
                item.quality = 0;
            }

            if (item.quality > 50) {
                item.quality = 50;
            }
        }
    }

    static void agedBrie(Item item) {
        item.quality++;

        if (item.sellIn < 0) {
            item.quality++;
        }
    }

    static void concert(Item item) {
        if (item.sellIn < 1) {
            item.quality = 0;
        } else {
            item.quality++;

            if (item.sellIn < 11) {
                item.quality++;
            }

            if (item.sellIn < 6) {
                item.quality++;
            }
        }
    }

    static void normal(Item item) {
        item.quality--;

        if (item.sellIn < 1) {
            item.quality--;
        }
    }
}
