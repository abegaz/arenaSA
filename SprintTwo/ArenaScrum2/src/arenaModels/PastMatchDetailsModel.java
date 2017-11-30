package arenaModels;

import javafx.beans.property.SimpleIntegerProperty;

public class PastMatchDetailsModel {

	private SimpleIntegerProperty Team1_Score;
	private SimpleIntegerProperty Team2_Score;
	
	public PastMatchDetailsModel(Integer Team1_Score,Integer Team2_Score){
		this.Team1_Score = new SimpleIntegerProperty(Team1_Score);
		this.Team2_Score = new SimpleIntegerProperty(Team2_Score);
	}
	public int getTeam1_Score()
	{
		return Team1_Score.get();
	}
	public void setTeam1_Score(int Value)
	{
		Team1_Score.set(Value);
	}
	public SimpleIntegerProperty Team1_ScoreProperty()
	{
		return Team1_Score;
	}

	public int getTeam2_Score()
	{
		return Team2_Score.get();
	}
	public void setTeam2_Score(int Value)
	{
		Team2_Score.set(Value);
	}
	public SimpleIntegerProperty Team2_ScoreProperty()
	{
		return Team2_Score;
	}
}
