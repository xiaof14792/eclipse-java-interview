
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 14792 on 2019/5/4.
 *
 * Java�Զ���ע��
 * @Inheritedע���ʾ��ע����ԴӸ���̳У�Ĭ��Ϊfalse��ֻ��Ӧ������������
 * @Repeatableע�⣬Java 8�����룬��ʾ����ǵ�ע�����Ӧ�ö�Ρ�
 *
 * ���ǿ���ʹ��default�ؼ���ָ��Ĭ��ֵ������������ʹ��ע���ʱ����Բ�ָ������ֵ��
 * �����ʹ��default�ؼ��֣�����Ҫָ������ֵ
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface  MyAnnotation{
    int priority() default 0;
    String value() default "";
}