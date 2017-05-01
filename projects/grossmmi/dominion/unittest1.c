#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include <iostream>

int main() {
  std::cout << "Unit Test 1: handCard() method" << std::endl;
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
  //set the hand to particular cards in particular order
  //verify that the card the method returns is the one that
  //was placed there at the beginning of the test.


  std::cout << "Unit Test 1 Complete" << std::endl;

  return 0;
}
