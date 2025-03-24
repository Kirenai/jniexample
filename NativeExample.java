public class NativeExample {
    static {
        System.loadLibrary("nativeLib");
    }

    public native void sayHello();

    public static void main(String[] args) {
        new NativeExample().sayHello();
    }
}
