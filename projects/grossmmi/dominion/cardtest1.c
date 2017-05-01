#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

int main() {
  std::cout << "Card Test 1: Smithy" << std::endl;
  int seed = 1000;
  int numPlayer = 2;
  int p = 1;
  int k[10] = {adventurer, council_room, feast, gardens, mine
                 , remodel, smithy, village, baron, great_hall};
  struct gameState G;
  int maxHandCount = 5;

  memset(&G, 23, sizeof(struct gameState));   // clear the game state
  r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
  G.handCount[p] = maxHandCount;
  /*
  In order to check Smithy, I need to confirm the following:
  1) 3 cards are added to the hand as expected
  2) Smithy is properly discarded
  3) No other changes to game state or victory points
  */


  std::cout << "Card Test 1 Complete" << std::endl;

  return 0;
}
