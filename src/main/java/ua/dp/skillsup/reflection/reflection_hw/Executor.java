package ua.dp.skillsup.reflection.reflection_hw;


public class Executor {

    @Execute
    public static void execute (@Env("PACKAGE_NAME") String packageName) {
        System.out.println(packageName);
    }

    public static void main(String[] args) {
        Executor.execute("src");
    }
}
