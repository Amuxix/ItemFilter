# ItemFilter
This is a program to auto generate itemfilters for the game [Path of Exile](https://www.pathofexile.com).
It relies on prices from [poe.ninja](https://poe.ninja).

## Mode of operation

Right now this generates a 4 filters at a time it requires a threshold in chaos(the ingame currency).
According to a multiplier on the given threshold it assigns rarities to items(unrelated to game rarity) an item fits into a rarity if its value is lesser than the next highest multiplier, the existing rarities are:
* Common(1x)
* Uncommon(2x)
* Rare(5x)
* Epic(20x)
* Mythic(100x)

There is also another rarity for items where the price is not determined, its simply called *Undetermined*

### Item Filters generated

There are 3 main item filters that simply apply a cutoff to the items displayed by their rarity or for items where price is undetermined its hardcoded which items appear.
There is a fourth filter that is an experiment that takes the most restrict filter and hides all items and only shows beams and minimap icons.


## TODO

* Get prices for maps and uniques.
* Refine the block merging process
