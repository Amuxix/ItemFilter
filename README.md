# ItemFilter
This is a program to auto generate itemfilters for the game [Path of Exile](https://www.pathofexile.com).
It relies on prices from [poe.ninja](https://poe.ninja).

## Mode of operation

Right now this generates a 4 filters at a time it requires a threshold in chaos(the ingame currency).
According to a multiplier on the given threshold it assigns rarities to items(unrelated to game rarity) an item fits into a rarity if its value is lesser than the next highest multiplier, the existing rarities are:
* Common(1x)
* Uncommon(12.5x)
* Rare(25x)
* Epic(200x)
* Mythic(1000x)
* Undetermined, used when price could not be determined
* Always show
* Always hide
* Leveling

### Item Filters generated

There 4 item filters that simply apply a cutoff to the items displayed by their rarity determined by price, usually.

## TODO

* Get prices for uniques, prophecies.
* Filter corrupted items properly, using white socket color and corrupted implicits.
* Get base prices automatically
