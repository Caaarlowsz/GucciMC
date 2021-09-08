package me.Pedro.Ultis;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public final class ReflectionHandler
{
    public static Class<?> getClass(final String name, final ReflectionHandler.PackageType type) throws Exception {
        return Class.forName(type + "." + name);
    }
    
    public static Class<?> getClass(final String name, final ReflectionHandler.SubPackageType type) throws Exception {
        return Class.forName(type + "." + name);
    }
    
    public static Constructor<?> getConstructor(final Class<?> clazz, final Class<?>[] parameterTypes) {
        final Class[] p = ReflectionHandler.DataType.convertToPrimitive((Class[])parameterTypes);
        Constructor<?>[] constructors;
        for (int length = (constructors = clazz.getConstructors()).length, i = 0; i < length; ++i) {
            final Constructor<?> c = constructors[i];
            if (ReflectionHandler.DataType.equalsArray(ReflectionHandler.DataType.convertToPrimitive((Class[])c.getParameterTypes()), p)) {
                return c;
            }
        }
        return null;
    }
    
    public static Constructor<?> getConstructor(final String className, final ReflectionHandler.PackageType type, final Class<?>[] parameterTypes) throws Exception {
        return getConstructor(getClass(className, type), parameterTypes);
    }
    
    public static Constructor<?> getConstructor(final String className, final ReflectionHandler.SubPackageType type, final Class<?>[] parameterTypes) throws Exception {
        return getConstructor(getClass(className, type), parameterTypes);
    }
    
    public static Object newInstance(final Class<?> clazz, final Object[] args) throws Exception {
        return getConstructor(clazz, ReflectionHandler.DataType.convertToPrimitive(args)).newInstance(args);
    }
    
    public static Object newInstance(final String className, final ReflectionHandler.PackageType type, final Object[] args) throws Exception {
        return newInstance(getClass(className, type), args);
    }
    
    public static Object newInstance(final String className, final ReflectionHandler.SubPackageType type, final Object[] args) throws Exception {
        return newInstance(getClass(className, type), args);
    }
    
    public static Method getMethod(final Class<?> clazz, final String name, final Class<?>[] parameterTypes) {
        final Class[] p = ReflectionHandler.DataType.convertToPrimitive((Class[])parameterTypes);
        Method[] methods;
        for (int length = (methods = clazz.getMethods()).length, i = 0; i < length; ++i) {
            final Method m = methods[i];
            if (m.getName().equals(name) && ReflectionHandler.DataType.equalsArray(ReflectionHandler.DataType.convertToPrimitive((Class[])m.getParameterTypes()), p)) {
                return m;
            }
        }
        return null;
    }
    
    public static Method getMethod(final String className, final ReflectionHandler.PackageType type, final String name, final Class<?>[] parameterTypes) throws Exception {
        return getMethod(getClass(className, type), name, parameterTypes);
    }
    
    public static Method getMethod(final String className, final ReflectionHandler.SubPackageType type, final String name, final Class<?>[] parameterTypes) throws Exception {
        return getMethod(getClass(className, type), name, parameterTypes);
    }
    
    public static Object invokeMethod(final String name, final Object instance, final Object[] args) throws Exception {
        return getMethod(instance.getClass(), name, ReflectionHandler.DataType.convertToPrimitive(args)).invoke(instance, args);
    }
    
    public static Object invokeMethod(final Class<?> clazz, final String name, final Object instance, final Object[] args) throws Exception {
        return getMethod(clazz, name, ReflectionHandler.DataType.convertToPrimitive(args)).invoke(instance, args);
    }
    
    public static Object invokeMethod(final String className, final ReflectionHandler.PackageType type, final String name, final Object instance, final Object[] args) throws Exception {
        return invokeMethod(getClass(className, type), name, instance, args);
    }
    
    public static Object invokeMethod(final String className, final ReflectionHandler.SubPackageType type, final String name, final Object instance, final Object[] args) throws Exception {
        return invokeMethod(getClass(className, type), name, instance, args);
    }
    
    public static Field getField(final Class<?> clazz, final String name) throws Exception {
        final Field f = clazz.getField(name);
        f.setAccessible(true);
        return f;
    }
    
    public static Field getField(final String className, final ReflectionHandler.PackageType type, final String name) throws Exception {
        return getField(getClass(className, type), name);
    }
    
    public static Field getField(final String className, final ReflectionHandler.SubPackageType type, final String name) throws Exception {
        return getField(getClass(className, type), name);
    }
    
    public static Field getDeclaredField(final Class<?> clazz, final String name) throws Exception {
        final Field f = clazz.getDeclaredField(name);
        f.setAccessible(true);
        return f;
    }
    
    public static Field getDeclaredField(final String className, final ReflectionHandler.PackageType type, final String name) throws Exception {
        return getDeclaredField(getClass(className, type), name);
    }
    
    public static Field getDeclaredField(final String className, final ReflectionHandler.SubPackageType type, final String name) throws Exception {
        return getDeclaredField(getClass(className, type), name);
    }
    
    public static Object getValue(final Object instance, final String fieldName) throws Exception {
        return getField(instance.getClass(), fieldName).get(instance);
    }
    
    public static Object getValue(final Class<?> clazz, final Object instance, final String fieldName) throws Exception {
        return getField(clazz, fieldName).get(instance);
    }
    
    public static Object getValue(final String className, final ReflectionHandler.PackageType type, final Object instance, final String fieldName) throws Exception {
        return getValue(getClass(className, type), instance, fieldName);
    }
    
    public static Object getValue(final String className, final ReflectionHandler.SubPackageType type, final Object instance, final String fieldName) throws Exception {
        return getValue(getClass(className, type), instance, fieldName);
    }
    
    public static Object getDeclaredValue(final Object instance, final String fieldName) throws Exception {
        return getDeclaredField(instance.getClass(), fieldName).get(instance);
    }
    
    public static Object getDeclaredValue(final Class<?> clazz, final Object instance, final String fieldName) throws Exception {
        return getDeclaredField(clazz, fieldName).get(instance);
    }
    
    public static Object getDeclaredValue(final String className, final ReflectionHandler.PackageType type, final Object instance, final String fieldName) throws Exception {
        return getDeclaredValue(getClass(className, type), instance, fieldName);
    }
    
    public static Object getDeclaredValue(final String className, final ReflectionHandler.SubPackageType type, final Object instance, final String fieldName) throws Exception {
        return getDeclaredValue(getClass(className, type), instance, fieldName);
    }
    
    public static void setValue(final Object instance, final String fieldName, final Object fieldValue) throws Exception {
        final Field f = getField(instance.getClass(), fieldName);
        f.set(instance, fieldValue);
    }
    
    public static void setValue(final Object instance, final ReflectionHandler.FieldPair pair) throws Exception {
        setValue(instance, pair.getName(), pair.getValue());
    }
    
    public static void setValue(final Class<?> clazz, final Object instance, final String fieldName, final Object fieldValue) throws Exception {
        final Field f = getField(clazz, fieldName);
        f.set(instance, fieldValue);
    }
    
    public static void setValue(final Class<?> clazz, final Object instance, final ReflectionHandler.FieldPair pair) throws Exception {
        setValue(clazz, instance, pair.getName(), pair.getValue());
    }
    
    public static void setValue(final String className, final ReflectionHandler.PackageType type, final Object instance, final String fieldName, final Object fieldValue) throws Exception {
        setValue(getClass(className, type), instance, fieldName, fieldValue);
    }
    
    public static void setValue(final String className, final ReflectionHandler.PackageType type, final Object instance, final ReflectionHandler.FieldPair pair) throws Exception {
        setValue(className, type, instance, pair.getName(), pair.getValue());
    }
    
    public static void setValue(final String className, final ReflectionHandler.SubPackageType type, final Object instance, final String fieldName, final Object fieldValue) throws Exception {
        setValue(getClass(className, type), instance, fieldName, fieldValue);
    }
    
    public static void setValue(final String className, final ReflectionHandler.SubPackageType type, final Object instance, final ReflectionHandler.FieldPair pair) throws Exception {
        setValue(className, type, instance, pair.getName(), pair.getValue());
    }
    
    public static void setValues(final Object instance, final ReflectionHandler.FieldPair[] pairs) throws Exception {
        for (final ReflectionHandler.FieldPair pair : pairs) {
            setValue(instance, pair);
        }
    }
    
    public static void setValues(final Class<?> clazz, final Object instance, final ReflectionHandler.FieldPair[] pairs) throws Exception {
        for (final ReflectionHandler.FieldPair pair : pairs) {
            setValue(clazz, instance, pair);
        }
    }
    
    public static void setValues(final String className, final ReflectionHandler.PackageType type, final Object instance, final ReflectionHandler.FieldPair[] pairs) throws Exception {
        setValues(getClass(className, type), instance, pairs);
    }
    
    public static void setValues(final String className, final ReflectionHandler.SubPackageType type, final Object instance, final ReflectionHandler.FieldPair[] pairs) throws Exception {
        setValues(getClass(className, type), instance, pairs);
    }
    
    public static void setDeclaredValue(final Object instance, final String fieldName, final Object fieldValue) throws Exception {
        final Field f = getDeclaredField(instance.getClass(), fieldName);
        f.set(instance, fieldValue);
    }
    
    public static void setDeclaredValue(final Object instance, final ReflectionHandler.FieldPair pair) throws Exception {
        setDeclaredValue(instance, pair.getName(), pair.getValue());
    }
    
    public static void setDeclaredValue(final Class<?> clazz, final Object instance, final String fieldName, final Object fieldValue) throws Exception {
        final Field f = getDeclaredField(clazz, fieldName);
        f.set(instance, fieldValue);
    }
    
    public static void setDeclaredValue(final Class<?> clazz, final Object instance, final ReflectionHandler.FieldPair pair) throws Exception {
        setDeclaredValue(clazz, instance, pair.getName(), pair.getValue());
    }
    
    public static void setDeclaredValue(final String className, final ReflectionHandler.PackageType type, final Object instance, final String fieldName, final Object fieldValue) throws Exception {
        setDeclaredValue(getClass(className, type), instance, fieldName, fieldValue);
    }
    
    public static void setDeclaredValue(final String className, final ReflectionHandler.PackageType type, final Object instance, final ReflectionHandler.FieldPair pair) throws Exception {
        setDeclaredValue(className, type, instance, pair.getName(), pair.getValue());
    }
    
    public static void setDeclaredValue(final String className, final ReflectionHandler.SubPackageType type, final Object instance, final String fieldName, final Object fieldValue) throws Exception {
        setDeclaredValue(getClass(className, type), instance, fieldName, fieldValue);
    }
    
    public static void setDeclaredValue(final String className, final ReflectionHandler.SubPackageType type, final Object instance, final ReflectionHandler.FieldPair pair) throws Exception {
        setDeclaredValue(className, type, instance, pair.getName(), pair.getValue());
    }
    
    public static void setDeclaredValues(final Object instance, final ReflectionHandler.FieldPair[] pairs) throws Exception {
        for (final ReflectionHandler.FieldPair pair : pairs) {
            setDeclaredValue(instance, pair);
        }
    }
    
    public static void setDeclaredValues(final Class<?> clazz, final Object instance, final ReflectionHandler.FieldPair[] pairs) throws Exception {
        for (final ReflectionHandler.FieldPair pair : pairs) {
            setDeclaredValue(clazz, instance, pair);
        }
    }
    
    public static void setDeclaredValues(final String className, final ReflectionHandler.PackageType type, final Object instance, final ReflectionHandler.FieldPair[] pairs) throws Exception {
        setDeclaredValues(getClass(className, type), instance, pairs);
    }
    
    public static void setDeclaredValues(final String className, final ReflectionHandler.SubPackageType type, final Object instance, final ReflectionHandler.FieldPair[] pairs) throws Exception {
        setDeclaredValues(getClass(className, type), instance, pairs);
    }
}
