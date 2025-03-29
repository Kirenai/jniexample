public class NativeExample {
    static {
        System.loadLibrary("nativeLib");
    }

    public native void sayHello();

    public native String getMessage();

    public native int messageLength(String message);

    public static void main(String[] args) {
        NativeExample nativeExample = new NativeExample();
        nativeExample.sayHello();

        String message = nativeExample.getMessage();
        System.out.println("Print message from native code: " + message);

        int messageLength = nativeExample.messageLength(message);
        System.out.println("Message length from native code: " + messageLength);
    }
}
