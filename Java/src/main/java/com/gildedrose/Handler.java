package com.gildedrose;

import java.util.function.Consumer;

record Handler(Consumer<Item> qualityFunction, Consumer<Item> sellInFunction) {
    static final Consumer<Item> CHANGE_NOTHING = item ->  {};
    static final Consumer<Item> DECREMENT_SELL_IN = item -> item.sellIn--;

    void update(Item item) {
        qualityFunction.accept(item);
        sellInFunction.accept(item);
    }
}
