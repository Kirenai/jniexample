#include <jni.h>
#include <stdio.h>
#include "NativeExample.h"

JNIEXPORT void JNICALL Java_NativeExample_sayHello(JNIEnv *, jobject) {
    printf("Hello from C!\n");
}

JNIEXPORT jstring JNICALL Java_NativeExample_getMessage(JNIEnv *env, jobject obj) {
    const char *message = "This is a message from C!";
    return (*env)->NewStringUTF(env, message);
}

JNIEXPORT jint JNICALL Java_NativeExample_messageLength(JNIEnv *env, jobject obj, jstring message) {
    return (*env)->GetStringLength(env, message);
}
