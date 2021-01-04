package control;
public class SkillAction extends Action{
    public SkillAction(long time) {
        super(time);
    }
    @Override
    public String getType() {
        return "SKILL";
    }
}
