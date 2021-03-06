var cardsJSON = require('./cards.json');
var cardid = 0;

for (cardAttrib in cardsJSON) {
	var card = cardsJSON[cardAttrib];
	var name = card.name;
	name = name.replace(/'/g, "\\'");
	name = name.replace(/"/g, '\\"');
	name = '"' + name + '"';
	
	var cost = 'NULL';
	if (card.manaCost) {
		cost = '"' + card.manaCost + '"';
	}
	cmc = card.cmc || 0;
	
	var supertypes = 'NULL';
	if (card.supertypes) {
		supertypes = '"' + card.supertypes.join(",") + '"';
	}
	var types = 'NULL';
	if (card.types) {
		types = '"' + card.types.join(",") + '"';
	}
	var subtypes = 'NULL';
	if (card.subtypes) {
		subtypes = '"' + card.subtypes.join(",") + '"';
	}
	var text = 'NULL';
	if (card.text) {
		text = card.text.replace(/'/g, "\\'");
		text = text.replace(/"/g, '\\"');
		text = text.replace(/\n/g, "\\n");
		text = '"' + text + '"';
	}
	var power = 'NULL';
	if (card.power) {
		power = '"' + card.power + '"';
	}
	var toughness = 'NULL';
	if (card.toughness) {
		toughness = '"' + card.toughness + '"';
	}
	
	var colors = 0;
	if (card.colors) {
		card.colors.forEach(function(color) {
			colors |= 1 << (['White', 'Blue', 'Black', 'Red', 'Green'].indexOf(color));
		});
	}
	
	var loyalty = 'NULL';
	if (card.loyalty) {
		loyalty = card.loyalty;
	}
	
	console.log("INSERT INTO Cards" + 
	"(card_id,card_name,card_colors,card_cost,card_cmc,card_supertypes,card_cardtypes,card_subtypes,card_text,card_power,card_toughness,card_loyalty,card_image_location)" + 
	"VALUES" +
	'(' + cardid + ',' + name + ',' + colors + ',' + cost + ',' + cmc + ',' + supertypes + ',' + types + ',' + subtypes + ',' + text + ',' + power + ',' + toughness + ',' + loyalty + '"/img/' + cardid +'");' 
	);
	cardid++;
}
