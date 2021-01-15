package environment;

public class EnvComponent {
    static int numEnvComponent = 0;
    int id;
    EnvComponent() {
        id = numEnvComponent++;
    }
}
