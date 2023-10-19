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
                this.quality++;
                if (this.sellIn < 0) {
                    this.quality++;
                }
                this.quality = Math.min(50, this.quality);
                break;
            case "Backstage passes to a TAFKAL80ETC concert" :
                this.quality++;
                if (this.sellIn < 11 ) {
                    this.quality++;
                }
                if (this.sellIn < 6 ) {
                    this.quality++;
                }
                this.sellIn--;
                if (this.sellIn < 0) {
                    this.quality = 0;
                }
                this.quality = Math.min(50, this.quality);
                break;
            case "Conjured Mana Cake" :
                this.quality -= 2;
                if (this.sellIn < 0) {
                    this.quality -= 2;                    
                }
                this.quality = Math.max(0, this.quality);
                this.sellIn--;
                break;
            default :
                this.sellIn--;
                this.quality--;
                if (this.sellIn < 0) {
                    this.quality--;
                }
                this.quality = Math.max(0, this.quality);
            break;
        }
    }
}
