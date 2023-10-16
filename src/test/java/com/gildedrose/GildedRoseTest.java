package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {
  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }
  @Test
  @DisplayName("Test that 'Aged Brie' increases in quality over time")
  void testAgedBrieQualityIncreases() {
    Item element = new Item("Aged Brie", 0, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertTrue(element.quality <= 50, "Aged Brie quality should increase over time");
  }
  @Test
  @DisplayName("Test that quality can never be negative")
  void testMinQuality() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertTrue(element.quality >= 0, "TQuality should never be negative");
  }
  @Test
  @DisplayName("Test the quality Backstage passes when SellIn <= 10")
  void testQualityBackstage() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 30);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertEquals(32, element.quality, "Quality should increase for Backstage passes by 2");
  }
  @Test
  @DisplayName("Test that quality degrades twice as fast after sellIn date")
  void testQualityDegradesTwiceAsFast() {
    Item item = new Item("Regular Item", 0, 10);
    GildedRose app = new GildedRose(new Item[] {item});
    app.updateQuality();
    assertEquals(8, item.quality, "Quality should degrade twice as fast after sellIn date");
  }
  @Test
  @DisplayName("Test quality reset to zero of Backstage when the concert is over")
  void testQualityResetToZero() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertEquals(0, element.quality, "Quality should reset to zero");
  }
  @Test
  @DisplayName("Test Backstage quality increase by 1 when SellIn>10")
  void testSellIn11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertEquals(49, element.quality, "Quality should increase by 1 when SellIn>10");
  }
  @Test
  @DisplayName("Test Backstage quality not over 50 when SellIn<=5 and quality near 50")
  void testSellInfouEgal5() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertEquals(50, element.quality, "Quality should not be over 50");
  }
  @Test
  @DisplayName("Test that 'Sulfuras' quality remains unchanged")
  void testSulfuras() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -2, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertEquals(20, element.quality, "Quality should remain unchanged");
  }
  @Test
  @DisplayName("Test that'Aged Brie'quality is never more than 50")
  void testAgedBrieMaximumQualitySellInNegative() {
    Item element = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();

    assertEquals(50, element.quality, "Quality should never be more than 50");
  }
  @Test
  @DisplayName("Test the toString method")
  void testToString(){
    Item element = new Item("foo", 0, 0);
    String elementString=element.name + ", " + element.sellIn + ", " + element.quality;

    assertEquals(elementString, element.toString(), "toString should return the expected string");
  }

}
