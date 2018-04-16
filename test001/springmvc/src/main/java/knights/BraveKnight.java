package knights;

public class BraveKnight implements Knight {

	private Quest quest;

	public BraveKnight(Quest quest) {
		this.quest = quest;
	}

	public BraveKnight() {
		// TODO Auto-generated constructor stub
	}

	public void embarkOnQuest() {
		System.out.println("embarkOnQuest");
		System.out.println("embarkOnQuest");
		quest.embark();
		System.out.println("embarkOnQuest");
		System.out.println("embarkOnQuest");
	}

}
