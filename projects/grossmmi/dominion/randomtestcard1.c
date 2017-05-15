#include <assert.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "dominion.h"
#include "dominion_helpers.h"

//implementation for Smithy card from Assignment 2
int main()
{
  srand(time(NULL));

  //card set from testDrawCard.c
  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};

  struct gameState test, control;
  int i, n, r, p, deckCount, discardCount, handCount, playerCount, seed, player;
  //when possible use defined values from dominion.h

  for (i = 0; i < 50000; i++)
  {
    playerCount = rand() % (MAX_PLAYERS - 1) + 2;
    player = rand() % playerCount;
    seed = rand() % 500;
    initializeGame(playerCount, k, seed, &test);

  }

  return 0;
}
