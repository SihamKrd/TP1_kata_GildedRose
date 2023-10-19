package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
    
    public void updateQuality(){
        switch(this.name){
            case "Sulfuras, Hand of Ragnaros" : 
                break;
            case "Aged Brie" :
                this.sellIn--; 
                if (this.quality < 50) {
                    this.quality++;
                }
                if (this.sellIn < 0 && this.quality < 50) {
                    this.quality++;
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert" :
                if (this.quality < 50) {
                this.quality++;
                    if (this.sellIn < 11 && this.quality < 50) {
                        this.quality++;
                    }
                    if (this.sellIn < 6 && this.quality < 50) {
                        this.quality++;
                    }
                }
                this.sellIn--;
                if (this.sellIn < 0) {
                    this.quality = 0;
                }
                break;
            default :
                this.sellIn--;
                if (this.quality > 0) {
                    this.quality--;
                }

                if (this.sellIn < 0) {
                    if (this.quality > 0) {
                        this.quality--;
                    }

                }
                break;
        }
    }
}
