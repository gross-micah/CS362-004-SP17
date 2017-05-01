#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include <iostream>

int main() {
  std::cout << "Unit Test 2: supplyCount() method" << std::endl;
  int seed = 1000;
  int numPlayer = 2;
  int p = 1
  int k[10] = {adventurer, council_room, feast, gardens, mine
                 , remodel, smithy, village, baron, great_hall};
  struct gameState G;
  int maxHandCount = 5;

  memset(&G, 23, sizeof(struct gameState));   // clear the game state
  r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
  G.handCount[p] = maxHandCount;
  /*
  supplyCount returns the count of any card given. What needs to be checked
  is that the value returned for each possible card is correct, AND that
  no other changes to the state of the game, points, cards in discard etc
  are made. This should not modify anything. A copy of the game state right before
  running this method should be the exact same as the copy after this method has
  been called.
  */


  std::cout << "Unit Test 2 Complete" << std::endl;

  return 0;
}
