package factory;

public interface IFactory<T> {
    T create(String[] args);
}
