//package com.edu.zhy.api.api.dubborig;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.reflect.FieldUtils;
//import org.springframework.util.ReflectionUtils;
//
//import java.lang.reflect.Field;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class BeanFactoryUtils {
//    private static final String CLASS_PACKAGE_PREFIX = "com.youzan.";
//    private static Set<Class> BASIC_TYPE;
//
//    public BeanFactoryUtils() {
//    }
//
//    public static boolean isBasicType(Field field) {
//        return isBasicType(field.getType());
//    }
//
//    public static boolean isBasicType(Class clazz) {
//        return BASIC_TYPE.contains(clazz);
//    }
//
//    public static boolean isInterface(Class clazz) {
//        return clazz.isInterface() && !clazz.isArray() && !clazz.isAssignableFrom(List.class) && !clazz.isAssignableFrom(Collection.class) && !clazz.isAssignableFrom(Map.class);
//    }
//
//    public static List<Class> getDeclaredClassesRecursive(Class clazz) {
//        return getDeclaredClassesRecursive(Arrays.asList(clazz));
//    }
//
//    public static List<Class> getDeclaredClassesRecursive(List<Class> clazzList) {
//        List<Class> result = new ArrayList();
//        if (CollectionUtils.isNotEmpty(clazzList)) {
//            clazzList.forEach((o) -> {
//                result.addAll(getDeclaredClasses(o));
//            });
//            result.addAll(getDeclaredClassesRecursive((List)result));
//        }
//
//        return result;
//    }
//
//    public static List<Class> getDeclaredClasses(Class clazz) {
//        List<Class> result = new ArrayList();
//        ReflectionUtils.doWithFields(clazz, (field) -> {
//            result.add(field.getType());
//        }, (field) -> {
//            return !isBasicType(field.getType()) && !clazz.isArray() && !clazz.isAssignableFrom(Map.class);
//        });
//        return result;
//    }
//
//    public static List<Field> getDeclaredFields(List<Class> classList) {
//        List<Field> result = new ArrayList();
//        classList.forEach((clazz) -> {
//            ReflectionUtils.doWithFields(clazz, result::add, (field) -> {
//                return !isBasicType(field.getType()) && !clazz.equals(field.getType()) && field.getAnnotations().length > 0;
//            });
//        });
//        return result;
//    }
//
//    public static String prefixPath(Class fieldClass) {
//        String path = fieldClass.getPackage().getName();
//        System.out.println(path);
//        int index = -1;
//
//        for(int i = 0; i < 4; ++i) {
//            index = path.indexOf(".", index + 1);
//        }
//
//        return index == -1 ? path : path.substring(0, index);
//    }
//
//    public static Set<Class> findSubTypes(Class clazz) {
//        Set<Class> result = new HashSet();
//        if (!isInterface(clazz)) {
//            return result;
//        } else {
//            Reflections reflections = new Reflections(prefixPath(clazz), new Scanner[0]);
//            Set<Class> classes = reflections.getSubTypesOf(clazz);
//            if (classes != null) {
//                result.addAll(classes);
//            }
//
//            return result;
//        }
//    }
//
//    public static boolean isNull(Object target, Field field) {
//        try {
//            return FieldUtils.readField(field, target, true) == null;
//        } catch (Exception var3) {
//            var3.printStackTrace();
//            return false;
//        }
//    }
//
//    public static boolean isSameProjectPath(Class thisClass, Class fieldClass) {
//        String path1 = thisClass.getPackage().getName();
//        String path2 = fieldClass.getPackage().getName();
//        if (path1.startsWith("com.youzan.") && path2.startsWith("com.youzan.")) {
//            path1 = StringUtils.removeStart(path1, "com.youzan.");
//            path2 = StringUtils.removeStart(path2, "com.youzan.");
//            int loop = 2;
//            if (path1.startsWith("owl.trade") && path2.startsWith("owl.trade")) {
//                loop = 3;
//            } else if (path1.startsWith("owl.ump") && path2.startsWith("owl.ump")) {
//                loop = 3;
//            } else if (path1.startsWith("owl.clue") && path2.startsWith("owl.clue")) {
//                loop = 3;
//            } else if (path1.startsWith("owl.data") && path2.startsWith("owl.data")) {
//                loop = 3;
//            }
//
//            for(int i = 0; i < loop; ++i) {
//                if (!path1.contains(".") || !path2.contains(".")) {
//                    return false;
//                }
//
//                String cc = StringUtils.substringBefore(path1, ".") + ".";
//                if (!path2.startsWith(cc)) {
//                    return false;
//                }
//
//                path1 = StringUtils.removeStart(path1, cc);
//                path2 = StringUtils.removeStart(path2, cc);
//            }
//
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    static {
//        BASIC_TYPE = (Set) Stream.of(Character.TYPE, Character.class, Boolean.TYPE, Boolean.class, Short.TYPE, Short.class, Integer.TYPE, Integer.class, Float.TYPE, Float.class, Double.TYPE, Double.class, Long.TYPE, Long.class, String.class, Date.class).collect(Collectors.toSet());
//    }
//
//}
