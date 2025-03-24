# Ejecutar Código Nativo en Java con JNI

Este repositorio explica cómo ejecutar código nativo en Java usando **JNI (Java Native Interface)** en **Windows** con **JDK 21** y **MinGW**.

---

## 1️⃣ Requisitos
- **JDK 21** (Verifica con `java -version`)
- **MinGW** para compilar código C (`gcc`).

---

## 2️⃣ Archivos creados
### 📁 **Estructura del proyecto**
```
project/
│── NativeExample.java    # Clase Java con método nativo
│── NativeExample.c       # Implementación en C
│── NativeExample.h       # Archivo de encabezado generado por javac
│── nativeLib.dll         # Biblioteca nativa compilada
│── README.md             # Esta guía
```

---

## 3️⃣ Escribir el código Java
📌 **Crea el archivo `NativeExample.java`**
```java
public class NativeExample {
    static {
        System.loadLibrary("nativeLib"); // Cargar la biblioteca nativa
    }
    
    public native void sayHello(); // Método nativo
    
    public static void main(String[] args) {
        new NativeExample().sayHello();
    }
}
```

---

## 4️⃣ Generar el archivo de encabezado JNI
Ejecuta el siguiente comando en **CMD**:
```sh
javac -h . NativeExample.java
```
**Archivos generados:**
- `NativeExample.class` (bytecode compilado)
- `NativeExample.h` (archivo de encabezado JNI)

---

## 5️⃣ Escribir el código nativo en C
📌 **Crea el archivo `NativeExample.c`**
```c
#include <jni.h>
#include <stdio.h>
#include "NativeExample.h"

JNIEXPORT void JNICALL Java_NativeExample_sayHello(JNIEnv *env, jobject obj) {
    printf("Hello from C!\n");
}
```

---

## 6️⃣ Compilar el código C a una biblioteca compartida (`.dll`)
Ejecuta en **CMD**:

El archivo `build.bat` contiene el siguiente comando:
```sh
gcc -shared -o nativeLib.dll -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" NativeExample.c
```
**Archivo generado:** `nativeLib.dll`

---

## 7️⃣ Ejecutar el programa Java con JNI
Ejecuta en **CMD**:

El archivo `exec.bat` contiene el siguiente comando:
```sh
java "-Djava.library.path=." NativeExample
```
### 📌 **Salida esperada:**
```
Hello from C!
```

---

## 🎯 Conclusión
Siguiendo estos pasos, se ejecuta código nativo en **C** desde **Java** usando **JNI**. 🚀
