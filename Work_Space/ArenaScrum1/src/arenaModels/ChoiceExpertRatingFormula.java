package arenaModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ChoiceExpertRatingFormula {
	 private final SimpleStringProperty ExpertRatingFormulaFormula;
	 
	 public ChoiceExpertRatingFormula (String ExpertRatingFormulaFormula){
		 this.ExpertRatingFormulaFormula= new SimpleStringProperty(ExpertRatingFormulaFormula);
	 }

	 public String getExpertRatingFormulaFormula(){
		 return ExpertRatingFormulaFormula.get();
	 }
	 public void setExpertRatingFormulaFormula(String value){
		 ExpertRatingFormulaFormula.set(value);
	}
	 public StringProperty ExpertRatingFormulaFormula() {
			return ExpertRatingFormulaFormula;
	}
}
