
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 14792 on 2019/5/4.
 *
 * Java自定义注解
 * @Inherited注解表示该注解可以从父类继承，默认为false。只能应用于类声明。
 * @Repeatable注解，Java 8中引入，表示被标记的注解可以应用多次。
 *
 * 我们可以使用default关键字指定默认值，这样我们在使用注解的时候可以不指定参数值，
 * 如果不使用default关键字，则需要指定参数值
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface  MyAnnotation{
    int priority() default 0;
    String value() default "";
}
