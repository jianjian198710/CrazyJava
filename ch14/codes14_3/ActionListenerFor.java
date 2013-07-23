package codes14_3;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * listener變量用於指定監聽器的實現類
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor {
	Class<? extends ActionListener> listener();
}
