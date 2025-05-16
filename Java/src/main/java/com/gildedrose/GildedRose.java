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
                    //old(item);
            }
        }
    }

    /*
    private void old(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }*/

    void agedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }

        if (item.quality < 50 && item.sellIn < 0) {
            item.quality++;
        }

        item.sellIn--;
    }

    void concert(Item item) {
        if (item.sellIn < 1) {
            item.quality = 0;
        } else {
            if (item.quality < 50) {
                item.quality++;
            }

            if (item.quality < 50 && item.sellIn < 11) {
                item.quality++;
            }

            if (item.quality < 50 && item.sellIn < 6) {
                item.quality++;
            }
        }

        item.sellIn--;
    }

    void sulfuras(Item item) {

    }

    void normal(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }

        if (item.quality > 0 && item.sellIn < 1) {
            item.quality--;
        }

        item.sellIn--;
    }
}
