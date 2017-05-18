package edu.galileo.android.facebookrecipies.libs.base;

/**
 * Created by Usuario_Privado on 23/06/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
