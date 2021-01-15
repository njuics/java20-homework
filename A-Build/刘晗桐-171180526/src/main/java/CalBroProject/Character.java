package CalBroProject;
import com.google.common.base.Preconditions;
public class Character {
	public String name;
	public String gender;
	
	public void setName(String newName) {
		Preconditions.checkNotNull(newName);
		this.name = newName;
	}
	
	public void setGender(String newGender) {
		Preconditions.checkNotNull(newGender);
		this.gender = newGender;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getGender() {
		return this.gender;
	}
}
