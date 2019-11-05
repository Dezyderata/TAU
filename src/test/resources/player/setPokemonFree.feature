Feature: Player.setPokemonFree
  This scenario shows that it is possible to set pokemons free.
  Selection by min and max defence.

  @success
  Scenario Outline: Player select pokemons by their defence.
    Given list of pokemons own by Player
    When select pokemons with defence between <minD> and <maxD>
    Then number of pokemons that were set free should be <number>

    Examples:
      |minD   |maxD     |number|
      |1      |11       |2     |
      |50     |100      |1     |


  @failure
  Scenario Outline: Player set incorrect values of combat power
    Given pokemons own by Player
    When try to select pokemon with wrong defence values: <minD> and <maxD>
    Then the exception should be: IllegalArgumentException

    Examples:
      |minD    |maxD   |
      |20      |10     |
