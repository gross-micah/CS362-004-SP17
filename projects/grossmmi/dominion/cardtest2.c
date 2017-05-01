#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

int main() {
  std::cout << "Card Test 2: Adventurer" << std::endl;
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
  To confirm adventurer, There are a host of items that need to be checked
  1) If the deck is empty, the discard pile is properly shuffled and added
  2) Check that in the event a copper, silver, or gold is drawn, the count
  drawn treasure is incremented accordingly
  3) Continue drawing and discarding until drawn treasure goes up by 2
  */


  std::cout << "Card Test 2 Complete" << std::endl;

  return 0;
}
