Feature: Player.selectPokemon
  This scenario shows that it is possible to find and select pokemon by name in players list of pokemon.
  Naturally if this pokemon was caught by the player.

  Scenario Outline: Pokemon was catch by player, now player try to select this pokemon.
    Given list of pokemons catch by Player
    When try to select <pokemon_name>
    Then the answer should be: <ans>

    Examples:
      |pokemon_name  |ans         |
      |"Wishiwashi"  |"Wishiwashi"|
      |"Slaking"     |"Slaking"   |



