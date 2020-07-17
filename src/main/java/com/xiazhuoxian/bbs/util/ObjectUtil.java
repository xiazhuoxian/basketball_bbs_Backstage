package com.xiazhuoxian.bbs.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ObjectUtil {

    //获取声明字段
    public static Field[] getDeclaredFields(Object object){
        Field[] field = object.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        return field;
    }

    //获取字段属性
    public static String getGenericType(Field field){
        String type = field.getGenericType().toString(); // 获取属性的类型
        return type;
    }

    //获取getter方法
    //调用getter方法
    // String value = (String) m.invoke(object);
    public static Method getMethod(Field field,Object object){
        String name = field.getName(); // 获取属性的名字
        name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
        Method m=null;
        try{
            m = object.getClass().getMethod("get" + name);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        return m;
    }

    //获取setter方法
    //调用setter方法，value2为setter()方法中的参数
    //m.invoke(object, "default");
    public static Method setMethod(Field field,Object object){
        String name = field.getName(); // 获取属性的名字
        name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
        Method m=null;
        try{
            if (field.getGenericType().toString().equals("class java.lang.String")) {
                m = object.getClass().getMethod("set" + name, String.class);
            }
            if (field.getGenericType().toString().equals("class java.lang.Integer")) {
                m = object.getClass().getMethod("set" + name, Integer.class);
            }
            if (field.getGenericType().toString().equals("int")) {
                m = object.getClass().getMethod("set" + name, int.class);
            }
            if (field.getGenericType().toString().equals("class java.lang.Boolean")) {
                m = object.getClass().getMethod("set" + name, Boolean.class);
            }
            if (field.getGenericType().toString().equals("class java.util.Date")) {
                m = object.getClass().getMethod("set" + name, Date.class);
            }
            if (field.getGenericType().toString().equals("class java.util.Float")) {
                m = object.getClass().getMethod("set" + name, Float.class);
            }
            if (field.getGenericType().toString().equals("float")) {
                m = object.getClass().getMethod("set" + name, float.class);
            }
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        return m;
    }

    public static Object dispose(Object object){
        Field[] field = object.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        try {
            for (int j = 0; j < field.length; j++) { // 遍历所有属性
                String name = field[j].getName(); // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                String type = field[j].getGenericType().toString(); // 获取属性的类型
                if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = object.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(object); // 调用getter方法获取属性值
                    //.....处理开始........
                    //执行处理方法
                            //.....处理结束........
                            m = object.getClass().getMethod("set"+name,String.class);
                    m.invoke(object, "default");
                }
                if (type.equals("class java.lang.Integer")) {
                    Method m = object.getClass().getMethod("get" + name);
                    Integer value = (Integer) m.invoke(object);
                    if (value == null) {
                        m = object.getClass().getMethod("set"+name,Integer.class);
                        m.invoke(object, 1);
                    }
                }
                if (type.equals("class java.lang.Boolean")) {
                    Method m = object.getClass().getMethod("get" + name);
                    Boolean value = (Boolean) m.invoke(object);
                    if (value == null) {
                        m = object.getClass().getMethod("set"+name,Boolean.class);
                        m.invoke(object, false);
                    }
                }
                if (type.equals("class java.util.Date")) {
                    Method m = object.getClass().getMethod("get" + name);
                    Date value = (Date) m.invoke(object);
                    if (value == null) {
                        m = object.getClass().getMethod("set"+name,Date.class);
                        m.invoke(object, new Date());
                    }
                }
                // 如果有需要,可以仿照上面继续进行扩充,再增加对其它类型的判断
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return object;
    }



}
