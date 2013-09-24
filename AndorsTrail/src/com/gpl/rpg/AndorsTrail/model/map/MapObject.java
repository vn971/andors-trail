package com.gpl.rpg.AndorsTrail.model.map;

import com.gpl.rpg.AndorsTrail.model.item.DropList;
import com.gpl.rpg.AndorsTrail.model.quest.QuestProgress;
import com.gpl.rpg.AndorsTrail.util.CoordRect;

public final class MapObject {
	public static enum MapObjectType {
		sign
		,newmap
		,rest
		,keyarea
		,container
	}

	public final CoordRect position;
	public final MapObjectType type;
	public final String id; //placeName on this map or phraseID
	public final String map;
	public final String place;
	public final String group;
	public final QuestProgress requireQuestProgress;
	public final DropList dropList;
	public boolean isActive = true;

	private MapObject(
			final CoordRect position
			, final MapObjectType type
			, final String id
			, final String map
			, final String place
			, final String group
			, final QuestProgress requireQuestProgress
			, final DropList dropList) {
		this.position = new CoordRect(position);
		this.type = type;
		this.id = id;
		this.map = map;
		this.place = place;
		this.group = group;
		this.requireQuestProgress = requireQuestProgress;
		this.dropList = dropList;
	}

	public static MapObject createMapSignEvent(final CoordRect position, final String phraseID, final String group) {
		return new MapObject(position, MapObjectType.sign, phraseID, null, null, group, null, null);
	}
	public static MapObject createNewMapEvent(final CoordRect position, final String thisMapTitle, final String destinationMap, final String destinationPlace, final String group) {
		return new MapObject(position, MapObjectType.newmap, thisMapTitle, destinationMap, destinationPlace, group, null, null);
	}
	public static MapObject createNewRest(final CoordRect position, final String placeId, final String group) {
		return new MapObject(position, MapObjectType.rest, placeId, null, null, group, null, null);
	}
	public static MapObject createNewKeyArea(final CoordRect position, final String phraseID, final QuestProgress requireQuestStage, final String group) {
		return new MapObject(position, MapObjectType.keyarea, phraseID, null, null, group, requireQuestStage, null);
	}
	public static MapObject createNewContainerArea(final CoordRect position, final DropList dropList, final String group) {
		return new MapObject(position, MapObjectType.container, null, null, null, group, null, dropList);
	}
}
