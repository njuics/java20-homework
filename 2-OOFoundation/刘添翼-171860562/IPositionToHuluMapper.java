// position to hulu mapper
public interface IPositionToHuluMapper {
    public abstract void syncChange(HuluWithPosition hulu);
    public abstract HuluWithPosition getHulu(Position position);
}
