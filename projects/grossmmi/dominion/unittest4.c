#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include <iostream>

int main() {
  std::cout << "Unit Test 4: getCost() method" << std::endl;
  int seed = 1000;
  int numPlayer = 2;
  int p = 1
  int k[10] = {adventurer, council_room, feast, gardens, mine
                 , remodel, smithy, village, baron, great_hall};
  struct gameState G, G2;
  int maxHandCount = 5;

  memset(&G, 23, sizeof(struct gameState));   // clear the game state
  r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
  G.handCount[p] = maxHandCount;
  /*
  This should check that the proper values are being returned for the card given
  If it doesn't mathe the value throw an error.
  */


  std::cout << "Unit Test 4 Complete" << std::endl;

  return 0;
}
