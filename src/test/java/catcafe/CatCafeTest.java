package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CatCafeTest {

  @Test
  void givenEmptyCafe_whenGettingCatCount_thenReturnZero() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(0, count);
  }

  @Test
  void givenOneCat_whenAddingCat_thenCountIsOne() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    cafe.addCat(new FelineOverLord("Milo", 5));

    // then
    assertEquals(1, cafe.getCatCount());
  }

  @Test
  void givenTwoCats_whenAddingCats_thenCountIsTwo() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    cafe.addCat(new FelineOverLord("Milo", 5));
    cafe.addCat(new FelineOverLord("Luna", 4));

    // then
    assertEquals(2, cafe.getCatCount());
  }

  @Test
  void givenExistingCatName_whenSearchingByName_thenReturnCat() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Milo", 5);
    cafe.addCat(cat);

    // when
    FelineOverLord result = cafe.getCatByName("Milo");

    // then
    assertEquals(cat, result);
  }

  @Test
  void givenUnknownCatName_whenSearchingByName_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord result = cafe.getCatByName("Ghost");

    // then
    assertNull(result);
  }

  @Test
  void givenNullName_whenSearchingByName_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord result = cafe.getCatByName(null);

    // then
    assertNull(result);
  }

  @Test
  void givenCatInWeightRange_whenSearchingByWeight_thenReturnCat() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Tiger", 7);
    cafe.addCat(cat);

    // when
    FelineOverLord result = cafe.getCatByWeight(5, 10);

    // then
    assertEquals(cat, result);
  }

  @Test
  void givenNegativeMinWeight_whenSearchingByWeight_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord result = cafe.getCatByWeight(-1, 10);

    // then
    assertNull(result);
  }

  @Test
  void givenMaxWeightSmallerThanMinWeight_whenSearchingByWeight_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord result = cafe.getCatByWeight(10, 5);

    // then
    assertNull(result);
  }

  @Test
  void givenNoCatInWeightRange_whenSearchingByWeight_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));

    // when
    FelineOverLord result = cafe.getCatByWeight(10, 20);

    // then
    assertNull(result);
  }
}
