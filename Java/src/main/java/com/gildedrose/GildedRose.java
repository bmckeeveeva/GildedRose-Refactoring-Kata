package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    agedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    concert(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    sulfuras(item);
                    break;
                default:
                    normal(item);
            }

            if (item.quality < 0) {
                item.quality = 0;
            }

            if (item.quality > 50) {
                item.quality = 50;
            }
        }
    }

    void agedBrie(Item item) {
        item.quality++;

        if (item.sellIn < 0) {
            item.quality++;
        }

        item.sellIn--;
    }

    void concert(Item item) {
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

        item.sellIn--;
    }

    void sulfuras(Item item) {

    }

    void normal(Item item) {
        item.quality--;

        if (item.sellIn < 1) {
            item.quality--;
        }

        item.sellIn--;
    }
}
