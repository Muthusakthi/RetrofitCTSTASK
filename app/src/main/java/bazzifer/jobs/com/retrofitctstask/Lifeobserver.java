package bazzifer.jobs.com.retrofitctstask;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class Lifeobserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void Oncrea(){
        Log.i("observer","obserCreated");
    }
}
