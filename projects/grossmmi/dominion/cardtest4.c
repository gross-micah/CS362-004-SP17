#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

int main() {
  std::cout << "Card Test 4: Great Hall" << std::endl;
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
  For great hall:
  1) Confirm drawn card (only 1) is from the proper pile. If necessary, shuffle
  the discard pile
  2) Confirm that the number of actions (state->numActions) is precisely
  1 more than before the card was used. Check with memcpy
  3) Ensure that great hall card is properly removed

  */


  std::cout << "Card Test 4 Complete" << std::endl;

  return 0;
}
