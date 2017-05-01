#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>


int main() {
  std::cout << "Unit Test 3: whoseTurn() method" << std::endl;
  int seed = 1000;
  int numPlayer = 2;
  int p = 1;
  int k[10] = {adventurer, council_room, feast, gardens, mine
                 , remodel, smithy, village, baron, great_hall};
  struct gameState G, G2;
  int maxHandCount = 5;

  memset(&G, 23, sizeof(struct gameState));   // clear the game state
  r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
  G.handCount[p] = maxHandCount;
  /*
  This should return the value of the current player and make
  no other modifications to the game state.
  */
  memcpy(G2, G, sizeof(int) * struct gameState);
  whoseTurn(G);
  if (G2 === G)
    std::cout << "Test worked!" << std::endl;
  else
    std::cout << "Game state not the same. Error" << std::endl;

  std::cout << "Unit Test 3 Complete" << std::endl;

  return 0;
}
