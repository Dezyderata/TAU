Feature: Player.selectPokemon
    This scenario shows that it is possible to find and select pokemon by name in players list of pokemon.
    Naturally if this pokemon was caught by the player.

  @success
  Scenario Outline: Player try to select pokemon.
    Given list of pokemons catch by Player
    When try to select <pokemon_name>
    Then the answer should be: <ans>
    Examples:
    Examples:
      |pokemon_name  |ans         |
      |"Wishiwashi"  |"Wishiwashi"|
      |"Slaking"     |"Slaking"   |


  @failure
  Scenario Outline: Player has other pokemon, but try to select pokemon which he doesn't have.
    Given list of Players pokemons
    When try to select wrong pokemon <pokemon>
    Then the answer should be: NullPointerException

    Examples:
      |pokemon       |
      |"Psyduck"     |