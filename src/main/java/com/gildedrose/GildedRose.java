package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (items[i].name.equals("Aged Brie")) {
                if (items[i].quality < 50) {
                    items[i].quality++;
                }
                items[i].sellIn--;
                if (items[i].sellIn < 0 && items[i].quality < 50) {
                    items[i].quality++;
                }
                continue;
            }

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality < 50) {
                    items[i].quality++;
                    if (items[i].sellIn < 11 && items[i].quality < 50) {
                        items[i].quality++;
                    }
                    if (items[i].sellIn < 6 && items[i].quality < 50) {
                            items[i].quality++;
                    }
                }
                items[i].sellIn--;
                if (items[i].sellIn < 0) {
                    items[i].quality = 0;
                }
                continue;
            }

            if (items[i].quality > 0) {
                items[i].quality--;
            }

            items[i].sellIn--;

            if (items[i].sellIn < 0) {
                if (items[i].quality > 0) {
                    items[i].quality--;
                }

            }
        }
    }
}