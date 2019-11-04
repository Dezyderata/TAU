Feature: Player.selectPokemon
  This scenario shows what happen when pokemon we are looking isn't in players list of pokemon.

  Scenario Outline: Player has other pokemon, but try to select pokemon which he doesn't have.
    Given list of Players pokemons
    When try to select wrong pokemon <pokemon_name>
    Then the answer should be: NullPointerException

    Examples:
      |pokemon_name  |
      |"Psyduck"     |
