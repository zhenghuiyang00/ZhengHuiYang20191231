package combwei.zhenghuiyang20191231.base.mvp;

import java.lang.ref.WeakReference;
/*
* @作者:郑惠洋
* @创建日期:2019/12/31 10:06
*/
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    public WeakReference<V>weakReference;

    public BasePresenter(){
    model=initmodel();
    }

    protected abstract M initmodel();

    //绑定
    public void attach(V v){
        weakReference=new WeakReference<>(v);
    }
    //解绑
    public void dettach(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }

    public V getView(){
        return weakReference.get();
    }


}
