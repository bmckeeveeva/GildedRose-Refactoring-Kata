package com.gildedrose;

class TestItem extends Item {
    TestItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    TestItem withQuality(int quality) {
        return new TestItem(name, sellIn, quality);
    }

    static TestItem[] singletonItem(String name, int sellIn, int quality) {
        return new TestItem[]{ new TestItem(name, sellIn, quality) };
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;
        return sellIn == item.sellIn && quality == item.quality && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + sellIn;
        result = 31 * result + quality;
        return result;
    }
}
